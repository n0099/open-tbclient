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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.personalize.a.af;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes22.dex */
public class b {
    private BdUniqueId fzO;
    private final List<q> iOX;
    private final af jRc;
    private List<ThreadInfo> jRe;
    private a jRf;
    private LongSparseArray<ThreadInfo> jRd = new LongSparseArray<>();
    private CustomMessageListener jRg = new CustomMessageListener(CmdConfigCustom.PERSONALIZED_MAINTAB_ON_RESULT) { // from class: com.baidu.tieba.homepage.personalize.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
                long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                if (j != 0 && j2 != 0) {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(b.this.jRf);
                    b.this.jRf = new a(j2, j);
                    com.baidu.adp.lib.f.e.mY().postDelayed(b.this.jRf, 500L);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a iqm = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.homepage.personalize.b.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
            }
        }
    };
    private final CustomMessageListener jbV = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.homepage.personalize.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str) && !y.isEmpty(b.this.iOX) && !y.isEmpty(b.this.jRe)) {
                    Iterator it = b.this.iOX.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        q qVar = (q) it.next();
                        if (qVar instanceof com.baidu.tieba.card.data.b) {
                            com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) qVar;
                            if (bVar.bmn() != null && bVar.bmn().getTid() != null && bVar.bmn().getTid().equals(str)) {
                                it.remove();
                                com.baidu.tieba.homepage.personalize.model.b.dZ(b.this.iOX);
                                b.this.jRc.cv(new ArrayList(b.this.iOX));
                                break;
                            }
                        }
                    }
                    long j = com.baidu.adp.lib.f.b.toLong(str, 0L);
                    Iterator it2 = b.this.jRe.iterator();
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
        this.iOX = list;
        this.jRc = afVar;
    }

    public void l(BdUniqueId bdUniqueId) {
        this.fzO = bdUniqueId;
        this.jRg.setTag(bdUniqueId);
        this.jRg.setSelfListener(false);
        this.iqm.setTag(bdUniqueId);
        this.iqm.getHttpMessageListener().setSelfListener(true);
        this.iqm.getSocketMessageListener().setSelfListener(true);
        this.jbV.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jRg);
        MessageManager.getInstance().registerListener(this.iqm);
        MessageManager.getInstance().registerListener(this.jbV);
    }

    public void dW(List<ThreadInfo> list) {
        this.jRe = list;
    }

    public void dX(List<ThreadInfo> list) {
        if (!y.isEmpty(list)) {
            Iterator<ThreadInfo> it = list.iterator();
            while (it.hasNext()) {
                ThreadInfo next = it.next();
                if (next != null && this.jRd.get(next.tid.longValue()) != null) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
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
            if (av.btX().btY()) {
                i = 2;
            }
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(b.this.fzO);
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, equipmentWidth, equipmentHeight, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    public void onDestroy() {
        if (this.jRf != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jRf);
        }
    }
}
