package com.baidu.tieba.homepage.personalize;

import android.support.v4.util.LongSparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.personalize.a.ab;
import com.baidu.tieba.homepage.personalize.data.g;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes9.dex */
public class b {
    private BdUniqueId epM;
    private final List<o> hjG;
    private final ab icv;
    private List<ThreadInfo> icx;
    private a icy;
    private LongSparseArray<ThreadInfo> icw = new LongSparseArray<>();
    private CustomMessageListener icz = new CustomMessageListener(CmdConfigCustom.PERSONALIZED_MAINTAB_ON_RESULT) { // from class: com.baidu.tieba.homepage.personalize.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
                long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                if (j != 0 && j2 != 0) {
                    com.baidu.adp.lib.f.e.ld().removeCallbacks(b.this.icy);
                    b.this.icy = new a(j2, j);
                    com.baidu.adp.lib.f.e.ld().postDelayed(b.this.icy, 500L);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a gKD = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.homepage.personalize.b.2
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
    private final CustomMessageListener huS = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.homepage.personalize.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str) && !v.isEmpty(b.this.hjG) && !v.isEmpty(b.this.icx)) {
                    Iterator it = b.this.hjG.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        o oVar = (o) it.next();
                        if (oVar instanceof com.baidu.tieba.card.data.c) {
                            com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) oVar;
                            if (cVar.aOi() != null && cVar.aOi().getTid() != null && cVar.aOi().getTid().equals(str)) {
                                it.remove();
                                com.baidu.tieba.homepage.personalize.model.b.cO(b.this.hjG);
                                b.this.icv.bE(new ArrayList(b.this.hjG));
                                break;
                            }
                        }
                    }
                    long j = com.baidu.adp.lib.f.b.toLong(str, 0L);
                    Iterator it2 = b.this.icx.iterator();
                    while (it2.hasNext()) {
                        ThreadInfo threadInfo = (ThreadInfo) it2.next();
                        if (threadInfo != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                            it2.remove();
                            return;
                        }
                    }
                }
            }
        }
    };

    public b(List<o> list, ab abVar) {
        this.hjG = list;
        this.icv = abVar;
    }

    public void l(BdUniqueId bdUniqueId) {
        this.epM = bdUniqueId;
        this.icz.setTag(bdUniqueId);
        this.icz.setSelfListener(false);
        this.gKD.setTag(bdUniqueId);
        this.gKD.getHttpMessageListener().setSelfListener(true);
        this.gKD.getSocketMessageListener().setSelfListener(true);
        this.huS.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.icz);
        MessageManager.getInstance().registerListener(this.gKD);
        MessageManager.getInstance().registerListener(this.huS);
    }

    public void cL(List<ThreadInfo> list) {
        this.icx = list;
    }

    public void cM(List<ThreadInfo> list) {
        if (!v.isEmpty(list)) {
            Iterator<ThreadInfo> it = list.iterator();
            while (it.hasNext()) {
                ThreadInfo next = it.next();
                if (next != null && this.icw.get(next.tid.longValue()) != null) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        private long postId;
        private long threadId;

        public a(long j, long j2) {
            this.threadId = j;
            this.postId = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i = 1;
            if (ar.aUX().aUY()) {
                i = 2;
            }
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(b.this.epM);
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, equipmentWidth, equipmentHeight, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i == 0 && !v.isEmpty(this.hjG) && !v.isEmpty(this.icx) && this.icv != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder2.portrait = TbadkCoreApplication.getCurrentPortrait();
            builder.author = builder2.build(true);
            ThreadInfo build = builder.build(true);
            bk bkVar = new bk();
            bkVar.a(build);
            if (k.ac(bkVar)) {
                this.hjG.add(this.hjG.get(0) instanceof g ? 1 : 0, com.baidu.tieba.homepage.personalize.model.d.aB(bkVar));
                com.baidu.tieba.homepage.personalize.model.b.cO(this.hjG);
                this.icv.bE(new ArrayList(this.hjG));
                this.icx.add(0, build);
                this.icw.put(build.tid.longValue(), build);
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
        if (this.icy != null) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.icy);
        }
    }
}
