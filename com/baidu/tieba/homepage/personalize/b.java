package com.baidu.tieba.homepage.personalize;

import android.support.v4.util.LongSparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.personalize.a.af;
import com.baidu.tieba.homepage.personalize.data.h;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes16.dex */
public class b {
    private BdUniqueId eEU;
    private final List<q> hBA;
    private final af ixG;
    private List<ThreadInfo> ixI;
    private a ixJ;
    private LongSparseArray<ThreadInfo> ixH = new LongSparseArray<>();
    private CustomMessageListener ixK = new CustomMessageListener(CmdConfigCustom.PERSONALIZED_MAINTAB_ON_RESULT) { // from class: com.baidu.tieba.homepage.personalize.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
                long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                if (j != 0 && j2 != 0) {
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(b.this.ixJ);
                    b.this.ixJ = new a(j2, j);
                    com.baidu.adp.lib.f.e.lt().postDelayed(b.this.ixJ, 500L);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a hdf = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.homepage.personalize.b.2
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
    private final CustomMessageListener hNH = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.homepage.personalize.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str) && !x.isEmpty(b.this.hBA) && !x.isEmpty(b.this.ixI)) {
                    Iterator it = b.this.hBA.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        q qVar = (q) it.next();
                        if (qVar instanceof com.baidu.tieba.card.data.c) {
                            com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) qVar;
                            if (cVar.aTN() != null && cVar.aTN().getTid() != null && cVar.aTN().getTid().equals(str)) {
                                it.remove();
                                com.baidu.tieba.homepage.personalize.model.b.df(b.this.hBA);
                                b.this.ixG.bR(new ArrayList(b.this.hBA));
                                break;
                            }
                        }
                    }
                    long j = com.baidu.adp.lib.f.b.toLong(str, 0L);
                    Iterator it2 = b.this.ixI.iterator();
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

    public b(List<q> list, af afVar) {
        this.hBA = list;
        this.ixG = afVar;
    }

    public void m(BdUniqueId bdUniqueId) {
        this.eEU = bdUniqueId;
        this.ixK.setTag(bdUniqueId);
        this.ixK.setSelfListener(false);
        this.hdf.setTag(bdUniqueId);
        this.hdf.getHttpMessageListener().setSelfListener(true);
        this.hdf.getSocketMessageListener().setSelfListener(true);
        this.hNH.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ixK);
        MessageManager.getInstance().registerListener(this.hdf);
        MessageManager.getInstance().registerListener(this.hNH);
    }

    public void dc(List<ThreadInfo> list) {
        this.ixI = list;
    }

    public void dd(List<ThreadInfo> list) {
        if (!x.isEmpty(list)) {
            Iterator<ThreadInfo> it = list.iterator();
            while (it.hasNext()) {
                ThreadInfo next = it.next();
                if (next != null && this.ixH.get(next.tid.longValue()) != null) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
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
            if (at.baS().baT()) {
                i = 2;
            }
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(b.this.eEU);
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, equipmentWidth, equipmentHeight, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i == 0 && !x.isEmpty(this.hBA) && !x.isEmpty(this.ixI) && this.ixG != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder2.portrait = TbadkCoreApplication.getCurrentPortrait();
            builder.author = builder2.build(true);
            ThreadInfo build = builder.build(true);
            bv bvVar = new bv();
            bvVar.a(build);
            if (k.aa(bvVar)) {
                this.hBA.add(this.hBA.get(0) instanceof h ? 1 : 0, com.baidu.tieba.homepage.personalize.model.d.ay(bvVar));
                com.baidu.tieba.homepage.personalize.model.b.df(this.hBA);
                this.ixG.bR(new ArrayList(this.hBA));
                this.ixI.add(0, build);
                this.ixH.put(build.tid.longValue(), build);
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
        if (this.ixJ != null) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ixJ);
        }
    }
}
