package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
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
    private BdUniqueId aOx;
    private final List<com.baidu.adp.widget.ListView.f> cmi;
    private final o dbj;
    private List<ThreadInfo> dbl;
    private a dbm;
    private HashMap<Long, ThreadInfo> dbk = new HashMap<>();
    private CustomMessageListener dbn = new CustomMessageListener(CmdConfigCustom.PERSONALIZED_MAINTAB_ON_RESULT) { // from class: com.baidu.tieba.homepage.personalize.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
                long c = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
                long c2 = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
                if (c != 0 && c2 != 0) {
                    com.baidu.adp.lib.g.e.fQ().removeCallbacks(b.this.dbm);
                    b.this.dbm = new a(c2, c);
                    com.baidu.adp.lib.g.e.fQ().postDelayed(b.this.dbm, 500L);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a cDF = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.homepage.personalize.b.2
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
    private final CustomMessageListener cDE = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.homepage.personalize.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str) && !v.v(b.this.cmi) && !v.v(b.this.dbl)) {
                    Iterator it = b.this.cmi.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) it.next();
                        if (fVar instanceof com.baidu.tieba.card.data.c) {
                            com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) fVar;
                            if (cVar.MR() != null && cVar.MR().getTid() != null && cVar.MR().getTid().equals(str)) {
                                it.remove();
                                com.baidu.tieba.homepage.personalize.model.b.bE(b.this.cmi);
                                b.this.dbj.bv(new ArrayList(b.this.cmi));
                                break;
                            }
                        }
                    }
                    long c = com.baidu.adp.lib.g.b.c(str, 0L);
                    Iterator it2 = b.this.dbl.iterator();
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
        this.cmi = list;
        this.dbj = oVar;
    }

    public void i(BdUniqueId bdUniqueId) {
        this.aOx = bdUniqueId;
        this.dbn.setTag(bdUniqueId);
        this.dbn.setSelfListener(false);
        this.cDF.setTag(bdUniqueId);
        this.cDF.getHttpMessageListener().setSelfListener(true);
        this.cDF.getSocketMessageListener().setSelfListener(true);
        this.cDE.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dbn);
        MessageManager.getInstance().registerListener(this.cDF);
        MessageManager.getInstance().registerListener(this.cDE);
    }

    public void bA(List<ThreadInfo> list) {
        this.dbl = list;
    }

    public void bB(List<ThreadInfo> list) {
        if (!v.v(list)) {
            Iterator<ThreadInfo> it = list.iterator();
            while (it.hasNext()) {
                ThreadInfo next = it.next();
                if (next != null && this.dbk.get(next.tid) != null) {
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
            int ad = k.ad(TbadkCoreApplication.getInst());
            int ae = k.ae(TbadkCoreApplication.getInst());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i = 1;
            if (an.vO().vQ()) {
                i = 2;
            }
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(b.this.aOx);
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, ad, ae, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i == 0 && !v.v(this.cmi) && !v.v(this.dbl) && this.dbj != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder2.portrait = TbadkCoreApplication.getCurrentPortrait();
            builder.author = builder2.build(true);
            ThreadInfo build = builder.build(true);
            bj bjVar = new bj();
            bjVar.a(build);
            if (l.F(bjVar)) {
                this.cmi.add(0, com.baidu.tieba.homepage.personalize.model.d.X(bjVar));
                com.baidu.tieba.homepage.personalize.model.b.bE(this.cmi);
                this.dbj.bv(new ArrayList(this.cmi));
                this.dbl.add(0, build);
                this.dbk.put(build.tid, build);
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
        if (this.dbm != null) {
            com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.dbm);
        }
    }
}
