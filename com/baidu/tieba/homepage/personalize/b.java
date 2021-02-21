package com.baidu.tieba.homepage.personalize;

import androidx.collection.LongSparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.personalize.adapter.ab;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes2.dex */
public class b {
    private BdUniqueId fGZ;
    private final List<n> jcx;
    private final ab kic;
    private List<ThreadInfo> kif;
    private a kig;
    private LongSparseArray<ThreadInfo> kie = new LongSparseArray<>();
    private CustomMessageListener kih = new CustomMessageListener(CmdConfigCustom.PERSONALIZED_MAINTAB_ON_RESULT) { // from class: com.baidu.tieba.homepage.personalize.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
                long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                if (j != 0 && j2 != 0) {
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(b.this.kig);
                    b.this.kig = new a(j2, j);
                    com.baidu.adp.lib.f.e.mA().postDelayed(b.this.kig, 500L);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a iDX = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.homepage.personalize.b.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
            }
        }
    };
    private final CustomMessageListener jpz = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.homepage.personalize.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str) && !y.isEmpty(b.this.jcx) && !y.isEmpty(b.this.kif)) {
                    Iterator it = b.this.jcx.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        n nVar = (n) it.next();
                        if (nVar instanceof com.baidu.tieba.card.data.b) {
                            com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) nVar;
                            if (bVar.bln() != null && bVar.bln().getTid() != null && bVar.bln().getTid().equals(str)) {
                                it.remove();
                                com.baidu.tieba.homepage.personalize.model.b.ee(b.this.jcx);
                                b.this.kic.cx(new ArrayList(b.this.jcx));
                                break;
                            }
                        }
                    }
                    long j = com.baidu.adp.lib.f.b.toLong(str, 0L);
                    Iterator it2 = b.this.kif.iterator();
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

    public b(List<n> list, ab abVar) {
        this.jcx = list;
        this.kic = abVar;
    }

    public void l(BdUniqueId bdUniqueId) {
        this.fGZ = bdUniqueId;
        this.kih.setTag(bdUniqueId);
        this.kih.setSelfListener(false);
        this.iDX.setTag(bdUniqueId);
        this.iDX.getHttpMessageListener().setSelfListener(true);
        this.iDX.getSocketMessageListener().setSelfListener(true);
        this.jpz.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kih);
        MessageManager.getInstance().registerListener(this.iDX);
        MessageManager.getInstance().registerListener(this.jpz);
    }

    public void eb(List<ThreadInfo> list) {
        this.kif = list;
    }

    public void ec(List<ThreadInfo> list) {
        if (!y.isEmpty(list)) {
            Iterator<ThreadInfo> it = list.iterator();
            while (it.hasNext()) {
                ThreadInfo next = it.next();
                if (next != null && this.kie.get(next.tid.longValue()) != null) {
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
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i = 1;
            if (av.bsS().bsT()) {
                i = 2;
            }
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(b.this.fGZ);
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, equipmentWidth, equipmentHeight, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    public void onDestroy() {
        if (this.kig != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.kig);
        }
    }
}
