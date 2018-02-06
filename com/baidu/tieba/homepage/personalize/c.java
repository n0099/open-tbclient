package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.personalize.a.l;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes2.dex */
public class c {
    private BdUniqueId bII;
    private final List<i> dBt;
    private final l eiQ;
    private List<ThreadInfo> eiS;
    private a eiT;
    private HashMap<Long, ThreadInfo> eiR = new HashMap<>();
    private CustomMessageListener eiU = new CustomMessageListener(2921030) { // from class: com.baidu.tieba.homepage.personalize.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
                long c = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
                long c2 = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
                if (c != 0 && c2 != 0) {
                    com.baidu.adp.lib.g.e.ns().removeCallbacks(c.this.eiT);
                    c.this.eiT = new a(c2, c);
                    com.baidu.adp.lib.g.e.ns().postDelayed(c.this.eiT, 500L);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a dgN = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.homepage.personalize.c.2
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
    private final CustomMessageListener dTy = new CustomMessageListener(2921031) { // from class: com.baidu.tieba.homepage.personalize.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str) && !v.E(c.this.dBt) && !v.E(c.this.eiS)) {
                    Iterator it = c.this.dBt.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        i iVar = (i) it.next();
                        if (iVar instanceof com.baidu.tieba.card.data.c) {
                            com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) iVar;
                            if (cVar.WE() != null && cVar.WE().getTid() != null && cVar.WE().getTid().equals(str)) {
                                it.remove();
                                com.baidu.tieba.homepage.personalize.model.b.bO(c.this.dBt);
                                c.this.eiQ.ao(new ArrayList(c.this.dBt));
                                break;
                            }
                        }
                    }
                    long c = com.baidu.adp.lib.g.b.c(str, 0L);
                    Iterator it2 = c.this.eiS.iterator();
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

    public c(List<i> list, l lVar) {
        this.dBt = list;
        this.eiQ = lVar;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.bII = bdUniqueId;
        this.eiU.setTag(bdUniqueId);
        this.eiU.setSelfListener(false);
        this.dgN.setTag(bdUniqueId);
        this.dgN.getHttpMessageListener().setSelfListener(true);
        this.dgN.getSocketMessageListener().setSelfListener(true);
        this.dTy.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eiU);
        MessageManager.getInstance().registerListener(this.dgN);
        MessageManager.getInstance().registerListener(this.dTy);
    }

    public void bK(List<ThreadInfo> list) {
        this.eiS = list;
    }

    public void bL(List<ThreadInfo> list) {
        if (!v.E(list)) {
            Iterator<ThreadInfo> it = list.iterator();
            while (it.hasNext()) {
                ThreadInfo next = it.next();
                if (next != null && this.eiR.get(next.tid) != null) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private long postId;
        private long threadId;

        public a(long j, long j2) {
            this.threadId = j;
            this.postId = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int ao = com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst());
            int aq = com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i = 1;
            if (ao.De().Dg()) {
                i = 2;
            }
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(c.this.bII);
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, ao, aq, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i == 0 && !v.E(this.dBt) && !v.E(this.eiS) && this.eiQ != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder2.portrait = TbadkCoreApplication.getCurrentPortrait();
            builder.author = builder2.build(true);
            ThreadInfo build = builder.build(true);
            bd bdVar = new bd();
            bdVar.a(build);
            if (k.M(bdVar)) {
                this.dBt.add(0, com.baidu.tieba.homepage.personalize.model.d.Y(bdVar));
                com.baidu.tieba.homepage.personalize.model.b.bO(this.dBt);
                this.eiQ.ao(new ArrayList(this.dBt));
                this.eiS.add(0, build);
                this.eiR.put(build.tid, build);
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
        if (this.eiT != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.eiT);
        }
    }
}
