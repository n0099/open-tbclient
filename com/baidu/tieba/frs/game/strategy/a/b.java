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
    private List<e> dWB;
    private String dWq;
    private com.baidu.tieba.frs.game.strategy.tab.b dWt;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int bOb = 0;
    private int dWD = 0;
    private int dWE = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0222a dWG = new a.InterfaceC0222a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0222a
        public void e(List<e> list, List<h> list2, boolean z) {
            if (b.this.dWB != null && b.this.dWt != null) {
                b.this.dWt.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a dWH = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.dWt != null) {
                        b.this.dWt.c(b.this.bOb, b.this.dWD, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.dWB == null) {
                        b.this.dWB = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.dWB == null) {
                        b.this.dWB = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.bOb;
                int i3 = b.this.dWD;
                if (b.this.bOb == 0 && b.this.dWD == 0 && !v.I(b.this.dWB) && (eVar = (e) b.this.dWB.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String aR = b.this.aR(i2, i3);
                c cVar2 = (c) b.this.dWC.get(aR);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.dWC.put(aR, cVar3);
                    cVar3.key = aR;
                    cVar3.dWx = i2;
                    cVar3.labelId = i3;
                    b.this.dWC.put(aR, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.dWE;
                if (!v.I(threadList)) {
                    if (b.this.dWE == 0) {
                        if (v.I(cVar.dWy)) {
                            cVar.dWy = threadList;
                        } else {
                            i = cVar.bJ(threadList);
                        }
                    } else {
                        cVar.dWy.addAll(threadList);
                    }
                }
                if (b.this.dWt != null) {
                    b.this.dWt.a(b.this.bOb, b.this.dWD, cVar.dWy, b.this.dWB, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> dWC = new HashMap<>();
    private a dWF = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.dWq = str;
        this.dWF.a(this.dWG);
        vB();
        aay();
    }

    private void vB() {
        this.dWH.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.dWH);
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
        this.bOb = i;
        this.dWD = i2;
        if (i == 0 && i2 == 0) {
            this.dWF.oG(String.valueOf(this.mFid));
        } else {
            String aR = aR(i, i2);
            c cVar = this.dWC.get(aR);
            if (cVar == null) {
                cVar = new c();
                this.dWC.put(aR, cVar);
            }
            cVar.key = aR;
            cVar.dWx = this.bOb;
            cVar.labelId = this.dWD;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.dWE = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.dWE, this.bOb, this.dWD);
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
        this.bOb = i;
        if (i == 0 && i2 == 0) {
            e mT = mT(i);
            if (mT != null && (mT.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) mT.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.dWD = aVar.labelId;
                }
            }
        } else {
            this.dWD = i2;
        }
        String aR = aR(i, i2);
        c cVar = this.dWC.get(aR);
        if (cVar == null) {
            cVar = new c();
            this.dWC.put(aR, cVar);
            cVar.key = aR;
            cVar.dWx = this.dWD;
            cVar.labelId = this.bOb;
            cVar.hasMore = true;
            this.dWC.put(aR, cVar);
        }
        this.dWE = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.dWE, this.bOb, this.dWD);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.dWt = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean aQ(int i, int i2) {
        c aS = aS(i, i2);
        if (aS == null || v.I(aS.dWy)) {
            return false;
        }
        if (this.dWt != null) {
            this.dWt.a(i, i2, aS.dWy, this.dWB, aS.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e mS(int i) {
        if (v.I(this.dWB)) {
            return null;
        }
        for (e eVar : this.dWB) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e mT(int i) {
        if (v.I(this.dWB)) {
            return null;
        }
        for (e eVar : this.dWB) {
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
        return this.dWC.get(aR(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
