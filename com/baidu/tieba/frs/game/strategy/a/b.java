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
    private List<e> dgB;
    private String dgq;
    private com.baidu.tieba.frs.game.strategy.tab.b dgt;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int bjL = 0;
    private int dgD = 0;
    private int dgE = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0137a dgG = new a.InterfaceC0137a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0137a
        public void e(List<e> list, List<h> list2, boolean z) {
            if (b.this.dgB != null && b.this.dgt != null) {
                b.this.dgt.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a dgH = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.dgt != null) {
                        b.this.dgt.c(b.this.bjL, b.this.dgD, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.dgB == null) {
                        b.this.dgB = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.dgB == null) {
                        b.this.dgB = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.bjL;
                int i3 = b.this.dgD;
                if (b.this.bjL == 0 && b.this.dgD == 0 && !v.w(b.this.dgB) && (eVar = (e) b.this.dgB.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String aF = b.this.aF(i2, i3);
                c cVar2 = (c) b.this.dgC.get(aF);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.dgC.put(aF, cVar3);
                    cVar3.key = aF;
                    cVar3.dgx = i2;
                    cVar3.labelId = i3;
                    b.this.dgC.put(aF, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.dgE;
                if (!v.w(threadList)) {
                    if (b.this.dgE == 0) {
                        if (v.w(cVar.dgy)) {
                            cVar.dgy = threadList;
                        } else {
                            i = cVar.bi(threadList);
                        }
                    } else {
                        cVar.dgy.addAll(threadList);
                    }
                }
                if (b.this.dgt != null) {
                    b.this.dgt.a(b.this.bjL, b.this.dgD, cVar.dgy, b.this.dgB, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> dgC = new HashMap<>();
    private a dgF = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.dgq = str;
        this.dgF.a(this.dgG);
        apX();
        Pm();
    }

    private void apX() {
        this.dgH.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.dgH);
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
    public void aC(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aC(i, i2);
                }
            }, 1000L);
            return;
        }
        this.bjL = i;
        this.dgD = i2;
        if (i == 0 && i2 == 0) {
            this.dgF.lV(String.valueOf(this.mFid));
        } else {
            String aF = aF(i, i2);
            c cVar = this.dgC.get(aF);
            if (cVar == null) {
                cVar = new c();
                this.dgC.put(aF, cVar);
            }
            cVar.key = aF;
            cVar.dgx = this.bjL;
            cVar.labelId = this.dgD;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.dgE = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.dgE, this.bjL, this.dgD);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void aD(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aD(i, i2);
                }
            }, 1000L);
            return;
        }
        this.bjL = i;
        if (i == 0 && i2 == 0) {
            e kD = kD(i);
            if (kD != null && (kD.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) kD.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.dgD = aVar.labelId;
                }
            }
        } else {
            this.dgD = i2;
        }
        String aF = aF(i, i2);
        c cVar = this.dgC.get(aF);
        if (cVar == null) {
            cVar = new c();
            this.dgC.put(aF, cVar);
            cVar.key = aF;
            cVar.dgx = this.dgD;
            cVar.labelId = this.bjL;
            cVar.hasMore = true;
            this.dgC.put(aF, cVar);
        }
        this.dgE = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.dgE, this.bjL, this.dgD);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.dgt = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean aE(int i, int i2) {
        c aG = aG(i, i2);
        if (aG == null || v.w(aG.dgy)) {
            return false;
        }
        if (this.dgt != null) {
            this.dgt.a(i, i2, aG.dgy, this.dgB, aG.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e kC(int i) {
        if (v.w(this.dgB)) {
            return null;
        }
        for (e eVar : this.dgB) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e kD(int i) {
        if (v.w(this.dgB)) {
            return null;
        }
        for (e eVar : this.dgB) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aF(int i, int i2) {
        return i + "_" + i2;
    }

    public c aG(int i, int i2) {
        return this.dgC.get(aF(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
