package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.personalize.b.o;
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
    private BdUniqueId aON;
    private final o cUG;
    private List<ThreadInfo> cUI;
    private a cUJ;
    private final List<com.baidu.adp.widget.ListView.f> cgM;
    private HashMap<Long, ThreadInfo> cUH = new HashMap<>();
    private CustomMessageListener cUK = new CustomMessageListener(CmdConfigCustom.PERSONALIZED_MAINTAB_ON_RESULT) { // from class: com.baidu.tieba.homepage.personalize.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
                long d = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getPostId(), 0L);
                long d2 = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getThreadId(), 0L);
                if (d != 0 && d2 != 0) {
                    com.baidu.adp.lib.g.e.ga().removeCallbacks(b.this.cUJ);
                    b.this.cUJ = new a(d2, d);
                    com.baidu.adp.lib.g.e.ga().postDelayed(b.this.cUJ, 500L);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a cxe = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.homepage.personalize.b.2
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
    private final CustomMessageListener cxd = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.homepage.personalize.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str) && !u.v(b.this.cgM) && !u.v(b.this.cUI)) {
                    Iterator it = b.this.cgM.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) it.next();
                        if (fVar instanceof com.baidu.tieba.card.data.c) {
                            com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) fVar;
                            if (cVar.MF() != null && cVar.MF().getTid() != null && cVar.MF().getTid().equals(str)) {
                                it.remove();
                                com.baidu.tieba.homepage.personalize.model.b.bA(b.this.cgM);
                                b.this.cUG.br(new ArrayList(b.this.cgM));
                                break;
                            }
                        }
                    }
                    long d = com.baidu.adp.lib.g.b.d(str, 0L);
                    Iterator it2 = b.this.cUI.iterator();
                    while (it2.hasNext()) {
                        ThreadInfo threadInfo = (ThreadInfo) it2.next();
                        if (threadInfo != null && threadInfo.tid != null && threadInfo.tid.longValue() == d) {
                            it2.remove();
                            return;
                        }
                    }
                }
            }
        }
    };

    public b(List<com.baidu.adp.widget.ListView.f> list, o oVar) {
        this.cgM = list;
        this.cUG = oVar;
    }

    public void i(BdUniqueId bdUniqueId) {
        this.aON = bdUniqueId;
        this.cUK.setTag(bdUniqueId);
        this.cUK.setSelfListener(false);
        this.cxe.setTag(bdUniqueId);
        this.cxe.getHttpMessageListener().setSelfListener(true);
        this.cxe.getSocketMessageListener().setSelfListener(true);
        this.cxd.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cUK);
        MessageManager.getInstance().registerListener(this.cxe);
        MessageManager.getInstance().registerListener(this.cxd);
    }

    public void bw(List<ThreadInfo> list) {
        this.cUI = list;
    }

    public void bx(List<ThreadInfo> list) {
        if (!u.v(list)) {
            Iterator<ThreadInfo> it = list.iterator();
            while (it.hasNext()) {
                ThreadInfo next = it.next();
                if (next != null && this.cUH.get(next.tid) != null) {
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
            int ag = k.ag(TbadkCoreApplication.getInst());
            int ah = k.ah(TbadkCoreApplication.getInst());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i = 1;
            if (am.vQ().vS()) {
                i = 2;
            }
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(b.this.aON);
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, ag, ah, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i == 0 && !u.v(this.cgM) && !u.v(this.cUI) && this.cUG != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder2.portrait = TbadkCoreApplication.getCurrentPortrait();
            builder.author = builder2.build(true);
            ThreadInfo build = builder.build(true);
            bl blVar = new bl();
            blVar.a(build);
            if (l.B(blVar)) {
                this.cgM.add(0, com.baidu.tieba.homepage.personalize.model.d.S(blVar));
                com.baidu.tieba.homepage.personalize.model.b.bA(this.cgM);
                this.cUG.br(new ArrayList(this.cgM));
                this.cUI.add(0, build);
                this.cUH.put(build.tid, build);
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
        if (this.cUJ != null) {
            com.baidu.adp.lib.g.e.ga().removeCallbacks(this.cUJ);
        }
    }
}
