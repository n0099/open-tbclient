package com.baidu.tieba.frs.game.strategy.a;

import android.content.Context;
import android.os.Handler;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.h;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.game.strategy.a.a;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.data.c;
import com.baidu.tieba.frs.game.strategy.message.FrsGameStrategyHttpResponseMessage;
import com.baidu.tieba.frs.game.strategy.message.FrsGameStrategyRequestMessage;
import com.baidu.tieba.frs.game.strategy.message.FrsGameStrategySocketResponseMessage;
import com.baidu.tieba.frs.game.strategy.tab.e;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements com.baidu.tieba.frs.game.strategy.tab.a {
    private String dST;
    private com.baidu.tieba.frs.game.strategy.tab.b dSW;
    private List<e> dTe;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int bNm = 0;
    private int dTg = 0;
    private int dTh = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0222a dTj = new a.InterfaceC0222a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0222a
        public void e(List<e> list, List<h> list2, boolean z) {
            if (b.this.dTe != null && b.this.dSW != null) {
                b.this.dSW.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a dTk = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<h> threadList;
            boolean hasMore;
            c cVar;
            e eVar;
            com.baidu.tieba.frs.game.strategy.data.a aVar;
            int i = -1;
            if (responsedMessage != null) {
                b.this.mIsLoading = false;
                if (responsedMessage.hasError()) {
                    if (b.this.dSW != null) {
                        b.this.dSW.c(b.this.bNm, b.this.dTg, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.dTe == null) {
                        b.this.dTe = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.dTe == null) {
                        b.this.dTe = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.bNm;
                int i3 = b.this.dTg;
                if (b.this.bNm == 0 && b.this.dTg == 0 && !v.I(b.this.dTe) && (eVar = (e) b.this.dTe.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String aQ = b.this.aQ(i2, i3);
                c cVar2 = (c) b.this.dTf.get(aQ);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.dTf.put(aQ, cVar3);
                    cVar3.key = aQ;
                    cVar3.dTa = i2;
                    cVar3.labelId = i3;
                    b.this.dTf.put(aQ, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.dTh;
                if (!v.I(threadList)) {
                    if (b.this.dTh == 0) {
                        if (v.I(cVar.dTb)) {
                            cVar.dTb = threadList;
                        } else {
                            i = cVar.bH(threadList);
                        }
                    } else {
                        cVar.dTb.addAll(threadList);
                    }
                }
                if (b.this.dSW != null) {
                    b.this.dSW.a(b.this.bNm, b.this.dTg, cVar.dTb, b.this.dTe, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> dTf = new HashMap<>();
    private a dTi = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.dST = str;
        this.dTi.a(this.dTj);
        vx();
        ZZ();
    }

    private void vx() {
        this.dTk.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.dTk);
    }

    private static void ZZ() {
        com.baidu.tieba.tbadkCore.a.a.a(309478, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, com.baidu.tieba.tbadkCore.a.a.aU("c/f/game/gameForumGuideTab", 309478));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void aN(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aN(i, i2);
                }
            }, 1000L);
            return;
        }
        this.bNm = i;
        this.dTg = i2;
        if (i == 0 && i2 == 0) {
            this.dTi.om(String.valueOf(this.mFid));
        } else {
            String aQ = aQ(i, i2);
            c cVar = this.dTf.get(aQ);
            if (cVar == null) {
                cVar = new c();
                this.dTf.put(aQ, cVar);
            }
            cVar.key = aQ;
            cVar.dTa = this.bNm;
            cVar.labelId = this.dTg;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.dTh = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.dTh, this.bNm, this.dTg);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void aO(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aO(i, i2);
                }
            }, 1000L);
            return;
        }
        this.bNm = i;
        if (i == 0 && i2 == 0) {
            e mF = mF(i);
            if (mF != null && (mF.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) mF.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.dTg = aVar.labelId;
                }
            }
        } else {
            this.dTg = i2;
        }
        String aQ = aQ(i, i2);
        c cVar = this.dTf.get(aQ);
        if (cVar == null) {
            cVar = new c();
            this.dTf.put(aQ, cVar);
            cVar.key = aQ;
            cVar.dTa = this.dTg;
            cVar.labelId = this.bNm;
            cVar.hasMore = true;
            this.dTf.put(aQ, cVar);
        }
        this.dTh = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.dTh, this.bNm, this.dTg);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.dSW = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean aP(int i, int i2) {
        c aR = aR(i, i2);
        if (aR == null || v.I(aR.dTb)) {
            return false;
        }
        if (this.dSW != null) {
            this.dSW.a(i, i2, aR.dTb, this.dTe, aR.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e mE(int i) {
        if (v.I(this.dTe)) {
            return null;
        }
        for (e eVar : this.dTe) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e mF(int i) {
        if (v.I(this.dTe)) {
            return null;
        }
        for (e eVar : this.dTe) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aQ(int i, int i2) {
        return i + BaseRequestAction.SPLITE + i2;
    }

    public c aR(int i, int i2) {
        return this.dTf.get(aQ(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
