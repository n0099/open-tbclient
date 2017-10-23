package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.personalize.a.o;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class b {
    private BdUniqueId aPk;
    private final o cYj;
    private List<ThreadInfo> cYl;
    private a cYm;
    private final List<com.baidu.adp.widget.ListView.f> cnl;
    private HashMap<Long, ThreadInfo> cYk = new HashMap<>();
    private CustomMessageListener cYn = new CustomMessageListener(CmdConfigCustom.PERSONALIZED_MAINTAB_ON_RESULT) { // from class: com.baidu.tieba.homepage.personalize.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
                long c = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
                long c2 = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
                if (c != 0 && c2 != 0) {
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(b.this.cYm);
                    b.this.cYm = new a(c2, c);
                    com.baidu.adp.lib.g.e.fP().postDelayed(b.this.cYm, 500L);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a bTF = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.homepage.personalize.b.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                b.this.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                b.this.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    };
    private final CustomMessageListener cFd = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.homepage.personalize.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str) && !v.u(b.this.cnl) && !v.u(b.this.cYl)) {
                    Iterator it = b.this.cnl.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) it.next();
                        if (fVar instanceof com.baidu.tieba.card.data.c) {
                            com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) fVar;
                            if (cVar.Nd() != null && cVar.Nd().getTid() != null && cVar.Nd().getTid().equals(str)) {
                                it.remove();
                                com.baidu.tieba.homepage.personalize.model.b.bw(b.this.cnl);
                                b.this.cYj.br(new ArrayList(b.this.cnl));
                                break;
                            }
                        }
                    }
                    long c = com.baidu.adp.lib.g.b.c(str, 0L);
                    Iterator it2 = b.this.cYl.iterator();
                    while (it2.hasNext()) {
                        ThreadInfo threadInfo = (ThreadInfo) it2.next();
                        if (threadInfo != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                            it2.remove();
                            return;
                        }
                    }
                }
            }
        }
    };

    public b(List<com.baidu.adp.widget.ListView.f> list, o oVar) {
        this.cnl = list;
        this.cYj = oVar;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.aPk = bdUniqueId;
        this.cYn.setTag(bdUniqueId);
        this.cYn.setSelfListener(false);
        this.bTF.setTag(bdUniqueId);
        this.bTF.getHttpMessageListener().setSelfListener(true);
        this.bTF.getSocketMessageListener().setSelfListener(true);
        this.cFd.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cYn);
        MessageManager.getInstance().registerListener(this.bTF);
        MessageManager.getInstance().registerListener(this.cFd);
    }

    public void bs(List<ThreadInfo> list) {
        this.cYl = list;
    }

    public void bt(List<ThreadInfo> list) {
        if (!v.u(list)) {
            Iterator<ThreadInfo> it = list.iterator();
            while (it.hasNext()) {
                ThreadInfo next = it.next();
                if (next != null && this.cYk.get(next.tid) != null) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private long postId;
        private long threadId;

        public a(long j, long j2) {
            this.threadId = j;
            this.postId = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int ad = l.ad(TbadkCoreApplication.getInst());
            int af = l.af(TbadkCoreApplication.getInst());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i = 1;
            if (an.vl().vn()) {
                i = 2;
            }
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(b.this.aPk);
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, ad, af, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i == 0 && !v.u(this.cnl) && !v.u(this.cYl) && this.cYj != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder2.portrait = TbadkCoreApplication.getCurrentPortrait();
            builder.author = builder2.build(true);
            ThreadInfo build = builder.build(true);
            bh bhVar = new bh();
            bhVar.a(build);
            if (com.baidu.tieba.card.data.l.A(bhVar)) {
                this.cnl.add(0, com.baidu.tieba.homepage.personalize.model.d.S(bhVar));
                com.baidu.tieba.homepage.personalize.model.b.bw(this.cnl);
                this.cYj.br(new ArrayList(this.cnl));
                this.cYl.add(0, build);
                this.cYk.put(build.tid, build);
            }
        }
    }

    private void a(User.Builder builder, User_Info user_Info) {
        if (user_Info != null) {
            builder.id = user_Info.id;
            builder.gender = user_Info.gender;
            builder.type = user_Info.type;
            builder.name = user_Info.name;
            builder.name_show = user_Info.name_show;
            builder.portrait = user_Info.portrait;
            builder.god_data = user_Info.god_data;
            builder.fans_num = user_Info.fans_num;
        }
    }

    public void onDestroy() {
        if (this.cYm != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.cYm);
        }
    }
}
