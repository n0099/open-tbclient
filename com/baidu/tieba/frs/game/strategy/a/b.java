package com.baidu.tieba.frs.game.strategy.a;

import android.content.Context;
import android.os.Handler;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.h;
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
    private String dDm;
    private com.baidu.tieba.frs.game.strategy.tab.b dDp;
    private List<e> dDx;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int bAe = 0;
    private int dDz = 0;
    private int dDA = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0152a dDC = new a.InterfaceC0152a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0152a
        public void e(List<e> list, List<h> list2, boolean z) {
            if (b.this.dDx != null && b.this.dDp != null) {
                b.this.dDp.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a dDD = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.dDp != null) {
                        b.this.dDp.c(b.this.bAe, b.this.dDz, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.dDx == null) {
                        b.this.dDx = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.dDx == null) {
                        b.this.dDx = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.bAe;
                int i3 = b.this.dDz;
                if (b.this.bAe == 0 && b.this.dDz == 0 && !v.z(b.this.dDx) && (eVar = (e) b.this.dDx.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String aM = b.this.aM(i2, i3);
                c cVar2 = (c) b.this.dDy.get(aM);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.dDy.put(aM, cVar3);
                    cVar3.key = aM;
                    cVar3.dDt = i2;
                    cVar3.labelId = i3;
                    b.this.dDy.put(aM, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.dDA;
                if (!v.z(threadList)) {
                    if (b.this.dDA == 0) {
                        if (v.z(cVar.dDu)) {
                            cVar.dDu = threadList;
                        } else {
                            i = cVar.br(threadList);
                        }
                    } else {
                        cVar.dDu.addAll(threadList);
                    }
                }
                if (b.this.dDp != null) {
                    b.this.dDp.a(b.this.bAe, b.this.dDz, cVar.dDu, b.this.dDx, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> dDy = new HashMap<>();
    private a dDB = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.dDm = str;
        this.dDB.a(this.dDC);
        awP();
        Vb();
    }

    private void awP() {
        this.dDD.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.dDD);
    }

    private static void Vb() {
        com.baidu.tieba.tbadkCore.a.a.a(309478, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, com.baidu.tieba.tbadkCore.a.a.aP("c/f/game/gameForumGuideTab", 309478));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void aJ(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aJ(i, i2);
                }
            }, 1000L);
            return;
        }
        this.bAe = i;
        this.dDz = i2;
        if (i == 0 && i2 == 0) {
            this.dDB.nj(String.valueOf(this.mFid));
        } else {
            String aM = aM(i, i2);
            c cVar = this.dDy.get(aM);
            if (cVar == null) {
                cVar = new c();
                this.dDy.put(aM, cVar);
            }
            cVar.key = aM;
            cVar.dDt = this.bAe;
            cVar.labelId = this.dDz;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.dDA = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.dDA, this.bAe, this.dDz);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void aK(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aK(i, i2);
                }
            }, 1000L);
            return;
        }
        this.bAe = i;
        if (i == 0 && i2 == 0) {
            e lA = lA(i);
            if (lA != null && (lA.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) lA.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.dDz = aVar.labelId;
                }
            }
        } else {
            this.dDz = i2;
        }
        String aM = aM(i, i2);
        c cVar = this.dDy.get(aM);
        if (cVar == null) {
            cVar = new c();
            this.dDy.put(aM, cVar);
            cVar.key = aM;
            cVar.dDt = this.dDz;
            cVar.labelId = this.bAe;
            cVar.hasMore = true;
            this.dDy.put(aM, cVar);
        }
        this.dDA = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.dDA, this.bAe, this.dDz);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.dDp = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean aL(int i, int i2) {
        c aN = aN(i, i2);
        if (aN == null || v.z(aN.dDu)) {
            return false;
        }
        if (this.dDp != null) {
            this.dDp.a(i, i2, aN.dDu, this.dDx, aN.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e lz(int i) {
        if (v.z(this.dDx)) {
            return null;
        }
        for (e eVar : this.dDx) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e lA(int i) {
        if (v.z(this.dDx)) {
            return null;
        }
        for (e eVar : this.dDx) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aM(int i, int i2) {
        return i + "_" + i2;
    }

    public c aN(int i, int i2) {
        return this.dDy.get(aM(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
