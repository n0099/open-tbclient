package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.personalize.a.k;
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
public class c {
    private BdUniqueId aSv;
    private final List<com.baidu.adp.widget.ListView.f> cEe;
    private final k dpJ;
    private List<ThreadInfo> dpL;
    private a dpM;
    private HashMap<Long, ThreadInfo> dpK = new HashMap<>();
    private CustomMessageListener dpN = new CustomMessageListener(CmdConfigCustom.PERSONALIZED_MAINTAB_ON_RESULT) { // from class: com.baidu.tieba.homepage.personalize.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
                long c = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
                long c2 = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
                if (c != 0 && c2 != 0) {
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.dpM);
                    c.this.dpM = new a(c2, c);
                    com.baidu.adp.lib.g.e.fP().postDelayed(c.this.dpM, 500L);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a ckd = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.homepage.personalize.c.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                c.this.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                c.this.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    };
    private final CustomMessageListener cXZ = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.homepage.personalize.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str) && !v.w(c.this.cEe) && !v.w(c.this.dpL)) {
                    Iterator it = c.this.cEe.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) it.next();
                        if (fVar instanceof com.baidu.tieba.card.data.c) {
                            com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) fVar;
                            if (cVar.Ox() != null && cVar.Ox().getTid() != null && cVar.Ox().getTid().equals(str)) {
                                it.remove();
                                com.baidu.tieba.homepage.personalize.model.b.bH(c.this.cEe);
                                c.this.dpJ.ae(new ArrayList(c.this.cEe));
                                break;
                            }
                        }
                    }
                    long c = com.baidu.adp.lib.g.b.c(str, 0L);
                    Iterator it2 = c.this.dpL.iterator();
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

    public c(List<com.baidu.adp.widget.ListView.f> list, k kVar) {
        this.cEe = list;
        this.dpJ = kVar;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.aSv = bdUniqueId;
        this.dpN.setTag(bdUniqueId);
        this.dpN.setSelfListener(false);
        this.ckd.setTag(bdUniqueId);
        this.ckd.getHttpMessageListener().setSelfListener(true);
        this.ckd.getSocketMessageListener().setSelfListener(true);
        this.cXZ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dpN);
        MessageManager.getInstance().registerListener(this.ckd);
        MessageManager.getInstance().registerListener(this.cXZ);
    }

    public void bD(List<ThreadInfo> list) {
        this.dpL = list;
    }

    public void bE(List<ThreadInfo> list) {
        if (!v.w(list)) {
            Iterator<ThreadInfo> it = list.iterator();
            while (it.hasNext()) {
                ThreadInfo next = it.next();
                if (next != null && this.dpK.get(next.tid) != null) {
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
            int ac = l.ac(TbadkCoreApplication.getInst());
            int ae = l.ae(TbadkCoreApplication.getInst());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i = 1;
            if (an.vv().vx()) {
                i = 2;
            }
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(c.this.aSv);
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, ac, ae, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i == 0 && !v.w(this.cEe) && !v.w(this.dpL) && this.dpJ != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder2.portrait = TbadkCoreApplication.getCurrentPortrait();
            builder.author = builder2.build(true);
            ThreadInfo build = builder.build(true);
            bd bdVar = new bd();
            bdVar.a(build);
            if (com.baidu.tieba.card.data.l.D(bdVar)) {
                this.cEe.add(0, com.baidu.tieba.homepage.personalize.model.d.V(bdVar));
                com.baidu.tieba.homepage.personalize.model.b.bH(this.cEe);
                this.dpJ.ae(new ArrayList(this.cEe));
                this.dpL.add(0, build);
                this.dpK.put(build.tid, build);
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
        if (this.dpM != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dpM);
        }
    }
}
