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
    private List<e> dMB;
    private String dMq;
    private com.baidu.tieba.frs.game.strategy.tab.b dMt;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int bJx = 0;
    private int dMD = 0;
    private int dME = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0211a dMG = new a.InterfaceC0211a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0211a
        public void e(List<e> list, List<h> list2, boolean z) {
            if (b.this.dMB != null && b.this.dMt != null) {
                b.this.dMt.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a dMH = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.dMt != null) {
                        b.this.dMt.c(b.this.bJx, b.this.dMD, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.dMB == null) {
                        b.this.dMB = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.dMB == null) {
                        b.this.dMB = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.bJx;
                int i3 = b.this.dMD;
                if (b.this.bJx == 0 && b.this.dMD == 0 && !v.I(b.this.dMB) && (eVar = (e) b.this.dMB.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String aQ = b.this.aQ(i2, i3);
                c cVar2 = (c) b.this.dMC.get(aQ);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.dMC.put(aQ, cVar3);
                    cVar3.key = aQ;
                    cVar3.dMx = i2;
                    cVar3.labelId = i3;
                    b.this.dMC.put(aQ, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.dME;
                if (!v.I(threadList)) {
                    if (b.this.dME == 0) {
                        if (v.I(cVar.dMy)) {
                            cVar.dMy = threadList;
                        } else {
                            i = cVar.bF(threadList);
                        }
                    } else {
                        cVar.dMy.addAll(threadList);
                    }
                }
                if (b.this.dMt != null) {
                    b.this.dMt.a(b.this.bJx, b.this.dMD, cVar.dMy, b.this.dMB, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> dMC = new HashMap<>();
    private a dMF = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.dMq = str;
        this.dMF.a(this.dMG);
        azI();
        YT();
    }

    private void azI() {
        this.dMH.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.dMH);
    }

    private static void YT() {
        com.baidu.tieba.tbadkCore.a.a.a(309478, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, com.baidu.tieba.tbadkCore.a.a.aT("c/f/game/gameForumGuideTab", 309478));
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
        this.bJx = i;
        this.dMD = i2;
        if (i == 0 && i2 == 0) {
            this.dMF.nM(String.valueOf(this.mFid));
        } else {
            String aQ = aQ(i, i2);
            c cVar = this.dMC.get(aQ);
            if (cVar == null) {
                cVar = new c();
                this.dMC.put(aQ, cVar);
            }
            cVar.key = aQ;
            cVar.dMx = this.bJx;
            cVar.labelId = this.dMD;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.dME = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.dME, this.bJx, this.dMD);
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
        this.bJx = i;
        if (i == 0 && i2 == 0) {
            e mp = mp(i);
            if (mp != null && (mp.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) mp.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.dMD = aVar.labelId;
                }
            }
        } else {
            this.dMD = i2;
        }
        String aQ = aQ(i, i2);
        c cVar = this.dMC.get(aQ);
        if (cVar == null) {
            cVar = new c();
            this.dMC.put(aQ, cVar);
            cVar.key = aQ;
            cVar.dMx = this.dMD;
            cVar.labelId = this.bJx;
            cVar.hasMore = true;
            this.dMC.put(aQ, cVar);
        }
        this.dME = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.dME, this.bJx, this.dMD);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.dMt = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean aP(int i, int i2) {
        c aR = aR(i, i2);
        if (aR == null || v.I(aR.dMy)) {
            return false;
        }
        if (this.dMt != null) {
            this.dMt.a(i, i2, aR.dMy, this.dMB, aR.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e mo(int i) {
        if (v.I(this.dMB)) {
            return null;
        }
        for (e eVar : this.dMB) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e mp(int i) {
        if (v.I(this.dMB)) {
            return null;
        }
        for (e eVar : this.dMB) {
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
        return this.dMC.get(aQ(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
