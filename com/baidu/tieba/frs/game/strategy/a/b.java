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
    private String dgn;
    private com.baidu.tieba.frs.game.strategy.tab.b dgq;
    private List<e> dgy;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int bjL = 0;
    private int dgA = 0;
    private int dgB = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0137a dgD = new a.InterfaceC0137a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0137a
        public void e(List<e> list, List<h> list2, boolean z) {
            if (b.this.dgy != null && b.this.dgq != null) {
                b.this.dgq.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a dgE = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.dgq != null) {
                        b.this.dgq.c(b.this.bjL, b.this.dgA, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.dgy == null) {
                        b.this.dgy = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.dgy == null) {
                        b.this.dgy = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.bjL;
                int i3 = b.this.dgA;
                if (b.this.bjL == 0 && b.this.dgA == 0 && !v.w(b.this.dgy) && (eVar = (e) b.this.dgy.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String aE = b.this.aE(i2, i3);
                c cVar2 = (c) b.this.dgz.get(aE);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.dgz.put(aE, cVar3);
                    cVar3.key = aE;
                    cVar3.dgu = i2;
                    cVar3.labelId = i3;
                    b.this.dgz.put(aE, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.dgB;
                if (!v.w(threadList)) {
                    if (b.this.dgB == 0) {
                        if (v.w(cVar.dgv)) {
                            cVar.dgv = threadList;
                        } else {
                            i = cVar.bi(threadList);
                        }
                    } else {
                        cVar.dgv.addAll(threadList);
                    }
                }
                if (b.this.dgq != null) {
                    b.this.dgq.a(b.this.bjL, b.this.dgA, cVar.dgv, b.this.dgy, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> dgz = new HashMap<>();
    private a dgC = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.dgn = str;
        this.dgC.a(this.dgD);
        apX();
        Pm();
    }

    private void apX() {
        this.dgE.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.dgE);
    }

    private static void Pm() {
        com.baidu.tieba.tbadkCore.a.a.a(309478, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, com.baidu.tieba.tbadkCore.a.a.aK("c/f/game/gameForumGuideTab", 309478));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void aB(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aB(i, i2);
                }
            }, 1000L);
            return;
        }
        this.bjL = i;
        this.dgA = i2;
        if (i == 0 && i2 == 0) {
            this.dgC.lV(String.valueOf(this.mFid));
        } else {
            String aE = aE(i, i2);
            c cVar = this.dgz.get(aE);
            if (cVar == null) {
                cVar = new c();
                this.dgz.put(aE, cVar);
            }
            cVar.key = aE;
            cVar.dgu = this.bjL;
            cVar.labelId = this.dgA;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.dgB = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.dgB, this.bjL, this.dgA);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void aC(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aC(i, i2);
                }
            }, 1000L);
            return;
        }
        this.bjL = i;
        if (i == 0 && i2 == 0) {
            e kC = kC(i);
            if (kC != null && (kC.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) kC.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.dgA = aVar.labelId;
                }
            }
        } else {
            this.dgA = i2;
        }
        String aE = aE(i, i2);
        c cVar = this.dgz.get(aE);
        if (cVar == null) {
            cVar = new c();
            this.dgz.put(aE, cVar);
            cVar.key = aE;
            cVar.dgu = this.dgA;
            cVar.labelId = this.bjL;
            cVar.hasMore = true;
            this.dgz.put(aE, cVar);
        }
        this.dgB = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.dgB, this.bjL, this.dgA);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.dgq = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean aD(int i, int i2) {
        c aF = aF(i, i2);
        if (aF == null || v.w(aF.dgv)) {
            return false;
        }
        if (this.dgq != null) {
            this.dgq.a(i, i2, aF.dgv, this.dgy, aF.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e kB(int i) {
        if (v.w(this.dgy)) {
            return null;
        }
        for (e eVar : this.dgy) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e kC(int i) {
        if (v.w(this.dgy)) {
            return null;
        }
        for (e eVar : this.dgy) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aE(int i, int i2) {
        return i + "_" + i2;
    }

    public c aF(int i, int i2) {
        return this.dgz.get(aE(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
