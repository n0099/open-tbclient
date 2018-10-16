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
    private String dLm;
    private com.baidu.tieba.frs.game.strategy.tab.b dLp;
    private List<e> dLx;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int bIM = 0;
    private int dLz = 0;
    private int dLA = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0186a dLC = new a.InterfaceC0186a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0186a
        public void e(List<e> list, List<h> list2, boolean z) {
            if (b.this.dLx != null && b.this.dLp != null) {
                b.this.dLp.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a dLD = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.dLp != null) {
                        b.this.dLp.c(b.this.bIM, b.this.dLz, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.dLx == null) {
                        b.this.dLx = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.dLx == null) {
                        b.this.dLx = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.bIM;
                int i3 = b.this.dLz;
                if (b.this.bIM == 0 && b.this.dLz == 0 && !v.J(b.this.dLx) && (eVar = (e) b.this.dLx.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String aP = b.this.aP(i2, i3);
                c cVar2 = (c) b.this.dLy.get(aP);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.dLy.put(aP, cVar3);
                    cVar3.key = aP;
                    cVar3.dLt = i2;
                    cVar3.labelId = i3;
                    b.this.dLy.put(aP, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.dLA;
                if (!v.J(threadList)) {
                    if (b.this.dLA == 0) {
                        if (v.J(cVar.dLu)) {
                            cVar.dLu = threadList;
                        } else {
                            i = cVar.bH(threadList);
                        }
                    } else {
                        cVar.dLu.addAll(threadList);
                    }
                }
                if (b.this.dLp != null) {
                    b.this.dLp.a(b.this.bIM, b.this.dLz, cVar.dLu, b.this.dLx, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> dLy = new HashMap<>();
    private a dLB = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.dLm = str;
        this.dLB.a(this.dLC);
        aAk();
        YI();
    }

    private void aAk() {
        this.dLD.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.dLD);
    }

    private static void YI() {
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
    public void aM(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aM(i, i2);
                }
            }, 1000L);
            return;
        }
        this.bIM = i;
        this.dLz = i2;
        if (i == 0 && i2 == 0) {
            this.dLB.nL(String.valueOf(this.mFid));
        } else {
            String aP = aP(i, i2);
            c cVar = this.dLy.get(aP);
            if (cVar == null) {
                cVar = new c();
                this.dLy.put(aP, cVar);
            }
            cVar.key = aP;
            cVar.dLt = this.bIM;
            cVar.labelId = this.dLz;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.dLA = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.dLA, this.bIM, this.dLz);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void aN(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aN(i, i2);
                }
            }, 1000L);
            return;
        }
        this.bIM = i;
        if (i == 0 && i2 == 0) {
            e lY = lY(i);
            if (lY != null && (lY.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) lY.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.dLz = aVar.labelId;
                }
            }
        } else {
            this.dLz = i2;
        }
        String aP = aP(i, i2);
        c cVar = this.dLy.get(aP);
        if (cVar == null) {
            cVar = new c();
            this.dLy.put(aP, cVar);
            cVar.key = aP;
            cVar.dLt = this.dLz;
            cVar.labelId = this.bIM;
            cVar.hasMore = true;
            this.dLy.put(aP, cVar);
        }
        this.dLA = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.dLA, this.bIM, this.dLz);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.dLp = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean aO(int i, int i2) {
        c aQ = aQ(i, i2);
        if (aQ == null || v.J(aQ.dLu)) {
            return false;
        }
        if (this.dLp != null) {
            this.dLp.a(i, i2, aQ.dLu, this.dLx, aQ.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e lX(int i) {
        if (v.J(this.dLx)) {
            return null;
        }
        for (e eVar : this.dLx) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e lY(int i) {
        if (v.J(this.dLx)) {
            return null;
        }
        for (e eVar : this.dLx) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aP(int i, int i2) {
        return i + BaseRequestAction.SPLITE + i2;
    }

    public c aQ(int i, int i2) {
        return this.dLy.get(aP(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
