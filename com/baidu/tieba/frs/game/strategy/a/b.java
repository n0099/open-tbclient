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
    private List<e> dhF;
    private String dhu;
    private com.baidu.tieba.frs.game.strategy.tab.b dhx;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int bkb = 0;
    private int dhH = 0;
    private int dhI = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0137a dhK = new a.InterfaceC0137a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0137a
        public void e(List<e> list, List<h> list2, boolean z) {
            if (b.this.dhF != null && b.this.dhx != null) {
                b.this.dhx.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a dhL = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.dhx != null) {
                        b.this.dhx.c(b.this.bkb, b.this.dhH, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.dhF == null) {
                        b.this.dhF = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.dhF == null) {
                        b.this.dhF = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.bkb;
                int i3 = b.this.dhH;
                if (b.this.bkb == 0 && b.this.dhH == 0 && !v.w(b.this.dhF) && (eVar = (e) b.this.dhF.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String aE = b.this.aE(i2, i3);
                c cVar2 = (c) b.this.dhG.get(aE);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.dhG.put(aE, cVar3);
                    cVar3.key = aE;
                    cVar3.dhB = i2;
                    cVar3.labelId = i3;
                    b.this.dhG.put(aE, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.dhI;
                if (!v.w(threadList)) {
                    if (b.this.dhI == 0) {
                        if (v.w(cVar.dhC)) {
                            cVar.dhC = threadList;
                        } else {
                            i = cVar.bl(threadList);
                        }
                    } else {
                        cVar.dhC.addAll(threadList);
                    }
                }
                if (b.this.dhx != null) {
                    b.this.dhx.a(b.this.bkb, b.this.dhH, cVar.dhC, b.this.dhF, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> dhG = new HashMap<>();
    private a dhJ = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.dhu = str;
        this.dhJ.a(this.dhK);
        apW();
        Pj();
    }

    private void apW() {
        this.dhL.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.dhL);
    }

    private static void Pj() {
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
        this.bkb = i;
        this.dhH = i2;
        if (i == 0 && i2 == 0) {
            this.dhJ.lY(String.valueOf(this.mFid));
        } else {
            String aE = aE(i, i2);
            c cVar = this.dhG.get(aE);
            if (cVar == null) {
                cVar = new c();
                this.dhG.put(aE, cVar);
            }
            cVar.key = aE;
            cVar.dhB = this.bkb;
            cVar.labelId = this.dhH;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.dhI = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.dhI, this.bkb, this.dhH);
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
        this.bkb = i;
        if (i == 0 && i2 == 0) {
            e kB = kB(i);
            if (kB != null && (kB.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) kB.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.dhH = aVar.labelId;
                }
            }
        } else {
            this.dhH = i2;
        }
        String aE = aE(i, i2);
        c cVar = this.dhG.get(aE);
        if (cVar == null) {
            cVar = new c();
            this.dhG.put(aE, cVar);
            cVar.key = aE;
            cVar.dhB = this.dhH;
            cVar.labelId = this.bkb;
            cVar.hasMore = true;
            this.dhG.put(aE, cVar);
        }
        this.dhI = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.dhI, this.bkb, this.dhH);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.dhx = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean aD(int i, int i2) {
        c aF = aF(i, i2);
        if (aF == null || v.w(aF.dhC)) {
            return false;
        }
        if (this.dhx != null) {
            this.dhx.a(i, i2, aF.dhC, this.dhF, aF.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e kA(int i) {
        if (v.w(this.dhF)) {
            return null;
        }
        for (e eVar : this.dhF) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e kB(int i) {
        if (v.w(this.dhF)) {
            return null;
        }
        for (e eVar : this.dhF) {
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
        return this.dhG.get(aE(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
