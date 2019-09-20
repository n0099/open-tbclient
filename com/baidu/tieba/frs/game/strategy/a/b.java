package com.baidu.tieba.frs.game.strategy.a;

import android.content.Context;
import android.os.Handler;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.m;
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
/* loaded from: classes4.dex */
public class b implements com.baidu.tieba.frs.game.strategy.tab.a {
    private String fHC;
    private com.baidu.tieba.frs.game.strategy.tab.b fHF;
    private List<e> fHN;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int dor = 0;
    private int fHP = 0;
    private int fHQ = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0322a fHS = new a.InterfaceC0322a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0322a
        public void e(List<e> list, List<m> list2, boolean z) {
            if (b.this.fHN != null && b.this.fHF != null) {
                b.this.fHF.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fHT = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<m> threadList;
            boolean hasMore;
            c cVar;
            e eVar;
            com.baidu.tieba.frs.game.strategy.data.a aVar;
            int i = -1;
            if (responsedMessage != null) {
                b.this.mIsLoading = false;
                if (responsedMessage.hasError()) {
                    if (b.this.fHF != null) {
                        b.this.fHF.f(b.this.dor, b.this.fHP, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.fHN == null) {
                        b.this.fHN = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.fHN == null) {
                        b.this.fHN = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.dor;
                int i3 = b.this.fHP;
                if (b.this.dor == 0 && b.this.fHP == 0 && !v.aa(b.this.fHN) && (eVar = (e) b.this.fHN.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.bGk;
                        }
                    }
                }
                String by = b.this.by(i2, i3);
                c cVar2 = (c) b.this.fHO.get(by);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.fHO.put(by, cVar3);
                    cVar3.key = by;
                    cVar3.fHJ = i2;
                    cVar3.bGk = i3;
                    b.this.fHO.put(by, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.fHQ;
                if (!v.aa(threadList)) {
                    if (b.this.fHQ == 0) {
                        if (v.aa(cVar.fHK)) {
                            cVar.fHK = threadList;
                        } else {
                            i = cVar.cc(threadList);
                        }
                    } else {
                        cVar.fHK.addAll(threadList);
                    }
                }
                if (b.this.fHF != null) {
                    b.this.fHF.a(b.this.dor, b.this.fHP, cVar.fHK, b.this.fHN, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> fHO = new HashMap<>();
    private a fHR = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.fHC = str;
        this.fHR.a(this.fHS);
        aag();
        aJu();
    }

    private void aag() {
        this.fHT.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.fHT);
    }

    private static void aJu() {
        com.baidu.tieba.tbadkCore.a.a.a(309478, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, com.baidu.tieba.tbadkCore.a.a.bq("c/f/game/gameForumGuideTab", 309478));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void bv(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.bv(i, i2);
                }
            }, 1000L);
            return;
        }
        this.dor = i;
        this.fHP = i2;
        if (i == 0 && i2 == 0) {
            this.fHR.xG(String.valueOf(this.mFid));
        } else {
            String by = by(i, i2);
            c cVar = this.fHO.get(by);
            if (cVar == null) {
                cVar = new c();
                this.fHO.put(by, cVar);
            }
            cVar.key = by;
            cVar.fHJ = this.dor;
            cVar.bGk = this.fHP;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.fHQ = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.fHQ, this.dor, this.fHP);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void bw(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.bw(i, i2);
                }
            }, 1000L);
            return;
        }
        this.dor = i;
        if (i == 0 && i2 == 0) {
            e si = si(i);
            if (si != null && (si.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) si.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.fHP = aVar.bGk;
                }
            }
        } else {
            this.fHP = i2;
        }
        String by = by(i, i2);
        c cVar = this.fHO.get(by);
        if (cVar == null) {
            cVar = new c();
            this.fHO.put(by, cVar);
            cVar.key = by;
            cVar.fHJ = this.fHP;
            cVar.bGk = this.dor;
            cVar.hasMore = true;
            this.fHO.put(by, cVar);
        }
        this.fHQ = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.fHQ, this.dor, this.fHP);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.fHF = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean bx(int i, int i2) {
        c bz = bz(i, i2);
        if (bz == null || v.aa(bz.fHK)) {
            return false;
        }
        if (this.fHF != null) {
            this.fHF.a(i, i2, bz.fHK, this.fHN, bz.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e sh(int i) {
        if (v.aa(this.fHN)) {
            return null;
        }
        for (e eVar : this.fHN) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e si(int i) {
        if (v.aa(this.fHN)) {
            return null;
        }
        for (e eVar : this.fHN) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String by(int i, int i2) {
        return i + "_" + i2;
    }

    public c bz(int i, int i2) {
        return this.fHO.get(by(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
