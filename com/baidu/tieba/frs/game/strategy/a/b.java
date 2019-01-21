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
    private List<e> dWC;
    private String dWr;
    private com.baidu.tieba.frs.game.strategy.tab.b dWu;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int bOc = 0;
    private int dWE = 0;
    private int dWF = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0222a dWH = new a.InterfaceC0222a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0222a
        public void e(List<e> list, List<h> list2, boolean z) {
            if (b.this.dWC != null && b.this.dWu != null) {
                b.this.dWu.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a dWI = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.dWu != null) {
                        b.this.dWu.c(b.this.bOc, b.this.dWE, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.dWC == null) {
                        b.this.dWC = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.dWC == null) {
                        b.this.dWC = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.bOc;
                int i3 = b.this.dWE;
                if (b.this.bOc == 0 && b.this.dWE == 0 && !v.I(b.this.dWC) && (eVar = (e) b.this.dWC.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String aR = b.this.aR(i2, i3);
                c cVar2 = (c) b.this.dWD.get(aR);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.dWD.put(aR, cVar3);
                    cVar3.key = aR;
                    cVar3.dWy = i2;
                    cVar3.labelId = i3;
                    b.this.dWD.put(aR, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.dWF;
                if (!v.I(threadList)) {
                    if (b.this.dWF == 0) {
                        if (v.I(cVar.dWz)) {
                            cVar.dWz = threadList;
                        } else {
                            i = cVar.bJ(threadList);
                        }
                    } else {
                        cVar.dWz.addAll(threadList);
                    }
                }
                if (b.this.dWu != null) {
                    b.this.dWu.a(b.this.bOc, b.this.dWE, cVar.dWz, b.this.dWC, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> dWD = new HashMap<>();
    private a dWG = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.dWr = str;
        this.dWG.a(this.dWH);
        vB();
        aay();
    }

    private void vB() {
        this.dWI.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.dWI);
    }

    private static void aay() {
        com.baidu.tieba.tbadkCore.a.a.a(309478, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, com.baidu.tieba.tbadkCore.a.a.aV("c/f/game/gameForumGuideTab", 309478));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void aO(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aO(i, i2);
                }
            }, 1000L);
            return;
        }
        this.bOc = i;
        this.dWE = i2;
        if (i == 0 && i2 == 0) {
            this.dWG.oG(String.valueOf(this.mFid));
        } else {
            String aR = aR(i, i2);
            c cVar = this.dWD.get(aR);
            if (cVar == null) {
                cVar = new c();
                this.dWD.put(aR, cVar);
            }
            cVar.key = aR;
            cVar.dWy = this.bOc;
            cVar.labelId = this.dWE;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.dWF = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.dWF, this.bOc, this.dWE);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void aP(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aP(i, i2);
                }
            }, 1000L);
            return;
        }
        this.bOc = i;
        if (i == 0 && i2 == 0) {
            e mT = mT(i);
            if (mT != null && (mT.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) mT.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.dWE = aVar.labelId;
                }
            }
        } else {
            this.dWE = i2;
        }
        String aR = aR(i, i2);
        c cVar = this.dWD.get(aR);
        if (cVar == null) {
            cVar = new c();
            this.dWD.put(aR, cVar);
            cVar.key = aR;
            cVar.dWy = this.dWE;
            cVar.labelId = this.bOc;
            cVar.hasMore = true;
            this.dWD.put(aR, cVar);
        }
        this.dWF = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.dWF, this.bOc, this.dWE);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.dWu = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean aQ(int i, int i2) {
        c aS = aS(i, i2);
        if (aS == null || v.I(aS.dWz)) {
            return false;
        }
        if (this.dWu != null) {
            this.dWu.a(i, i2, aS.dWz, this.dWC, aS.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e mS(int i) {
        if (v.I(this.dWC)) {
            return null;
        }
        for (e eVar : this.dWC) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e mT(int i) {
        if (v.I(this.dWC)) {
            return null;
        }
        for (e eVar : this.dWC) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aR(int i, int i2) {
        return i + BaseRequestAction.SPLITE + i2;
    }

    public c aS(int i, int i2) {
        return this.dWD.get(aR(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
