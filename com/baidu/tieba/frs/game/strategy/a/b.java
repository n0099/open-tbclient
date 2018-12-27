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
    private String dVK;
    private com.baidu.tieba.frs.game.strategy.tab.b dVN;
    private List<e> dVV;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int bNp = 0;
    private int dVX = 0;
    private int dVY = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0222a dWa = new a.InterfaceC0222a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0222a
        public void e(List<e> list, List<h> list2, boolean z) {
            if (b.this.dVV != null && b.this.dVN != null) {
                b.this.dVN.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a dWb = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.dVN != null) {
                        b.this.dVN.c(b.this.bNp, b.this.dVX, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.dVV == null) {
                        b.this.dVV = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.dVV == null) {
                        b.this.dVV = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.bNp;
                int i3 = b.this.dVX;
                if (b.this.bNp == 0 && b.this.dVX == 0 && !v.I(b.this.dVV) && (eVar = (e) b.this.dVV.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String aR = b.this.aR(i2, i3);
                c cVar2 = (c) b.this.dVW.get(aR);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.dVW.put(aR, cVar3);
                    cVar3.key = aR;
                    cVar3.dVR = i2;
                    cVar3.labelId = i3;
                    b.this.dVW.put(aR, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.dVY;
                if (!v.I(threadList)) {
                    if (b.this.dVY == 0) {
                        if (v.I(cVar.dVS)) {
                            cVar.dVS = threadList;
                        } else {
                            i = cVar.bI(threadList);
                        }
                    } else {
                        cVar.dVS.addAll(threadList);
                    }
                }
                if (b.this.dVN != null) {
                    b.this.dVN.a(b.this.bNp, b.this.dVX, cVar.dVS, b.this.dVV, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> dVW = new HashMap<>();
    private a dVZ = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.dVK = str;
        this.dVZ.a(this.dWa);
        vx();
        aab();
    }

    private void vx() {
        this.dWb.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.dWb);
    }

    private static void aab() {
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
        this.bNp = i;
        this.dVX = i2;
        if (i == 0 && i2 == 0) {
            this.dVZ.oq(String.valueOf(this.mFid));
        } else {
            String aR = aR(i, i2);
            c cVar = this.dVW.get(aR);
            if (cVar == null) {
                cVar = new c();
                this.dVW.put(aR, cVar);
            }
            cVar.key = aR;
            cVar.dVR = this.bNp;
            cVar.labelId = this.dVX;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.dVY = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.dVY, this.bNp, this.dVX);
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
        this.bNp = i;
        if (i == 0 && i2 == 0) {
            e mS = mS(i);
            if (mS != null && (mS.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) mS.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.dVX = aVar.labelId;
                }
            }
        } else {
            this.dVX = i2;
        }
        String aR = aR(i, i2);
        c cVar = this.dVW.get(aR);
        if (cVar == null) {
            cVar = new c();
            this.dVW.put(aR, cVar);
            cVar.key = aR;
            cVar.dVR = this.dVX;
            cVar.labelId = this.bNp;
            cVar.hasMore = true;
            this.dVW.put(aR, cVar);
        }
        this.dVY = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.dVY, this.bNp, this.dVX);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.dVN = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean aQ(int i, int i2) {
        c aS = aS(i, i2);
        if (aS == null || v.I(aS.dVS)) {
            return false;
        }
        if (this.dVN != null) {
            this.dVN.a(i, i2, aS.dVS, this.dVV, aS.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e mR(int i) {
        if (v.I(this.dVV)) {
            return null;
        }
        for (e eVar : this.dVV) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e mS(int i) {
        if (v.I(this.dVV)) {
            return null;
        }
        for (e eVar : this.dVV) {
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
        return this.dVW.get(aR(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
