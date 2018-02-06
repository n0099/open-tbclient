package com.baidu.tieba.frs.game.strategy.a;

import android.content.Context;
import android.os.Handler;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.game.strategy.a.a;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.message.FrsGameStrategyHttpResponseMessage;
import com.baidu.tieba.frs.game.strategy.message.FrsGameStrategyRequestMessage;
import com.baidu.tieba.frs.game.strategy.message.FrsGameStrategySocketResponseMessage;
import com.baidu.tieba.frs.game.strategy.tab.c;
import com.baidu.tieba.frs.game.strategy.tab.f;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements com.baidu.tieba.frs.game.strategy.tab.b {
    private String dNQ;
    private c dNT;
    private List<f> dOc;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int bZU = 0;
    private int dOe = 0;
    private int dOf = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0153a dOh = new a.InterfaceC0153a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0153a
        public void e(List<f> list, List<i> list2, boolean z) {
            if (b.this.dOc != null && b.this.dNT != null) {
                b.this.dNT.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a dOi = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<i> threadList;
            boolean hasMore;
            com.baidu.tieba.frs.game.strategy.data.c cVar;
            f fVar;
            com.baidu.tieba.frs.game.strategy.data.a aVar;
            int i = -1;
            if (responsedMessage != null) {
                b.this.mIsLoading = false;
                if (responsedMessage.hasError()) {
                    if (b.this.dNT != null) {
                        b.this.dNT.e(b.this.bZU, b.this.dOe, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.dOc == null) {
                        b.this.dOc = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.dOc == null) {
                        b.this.dOc = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.bZU;
                int i3 = b.this.dOe;
                if (b.this.bZU == 0 && b.this.dOe == 0 && !v.E(b.this.dOc) && (fVar = (f) b.this.dOc.get(0)) != null) {
                    i2 = fVar.tabId;
                    if (fVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) fVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String bA = b.this.bA(i2, i3);
                com.baidu.tieba.frs.game.strategy.data.c cVar2 = (com.baidu.tieba.frs.game.strategy.data.c) b.this.dOd.get(bA);
                if (cVar2 == null) {
                    com.baidu.tieba.frs.game.strategy.data.c cVar3 = new com.baidu.tieba.frs.game.strategy.data.c();
                    b.this.dOd.put(bA, cVar3);
                    cVar3.key = bA;
                    cVar3.dNY = i2;
                    cVar3.labelId = i3;
                    b.this.dOd.put(bA, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.dOf;
                if (!v.E(threadList)) {
                    if (b.this.dOf == 0) {
                        if (v.E(cVar.dNZ)) {
                            cVar.dNZ = threadList;
                        } else {
                            i = cVar.bo(threadList);
                        }
                    } else {
                        cVar.dNZ.addAll(threadList);
                    }
                }
                if (b.this.dNT != null) {
                    b.this.dNT.a(b.this.bZU, b.this.dOe, cVar.dNZ, b.this.dOc, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, com.baidu.tieba.frs.game.strategy.data.c> dOd = new HashMap<>();
    private a dOg = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.dNQ = str;
        this.dOg.a(this.dOh);
        avz();
        WM();
    }

    private void avz() {
        this.dOi.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.dOi);
    }

    private static void WM() {
        com.baidu.tieba.tbadkCore.a.a.a(309478, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, com.baidu.tieba.tbadkCore.a.a.aJ("c/f/game/gameForumGuideTab", 309478));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void bx(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.bx(i, i2);
                }
            }, 1000L);
            return;
        }
        this.bZU = i;
        this.dOe = i2;
        if (i == 0 && i2 == 0) {
            this.dOg.lR(String.valueOf(this.mFid));
        } else {
            String bA = bA(i, i2);
            com.baidu.tieba.frs.game.strategy.data.c cVar = this.dOd.get(bA);
            if (cVar == null) {
                cVar = new com.baidu.tieba.frs.game.strategy.data.c();
                this.dOd.put(bA, cVar);
            }
            cVar.key = bA;
            cVar.dNY = this.bZU;
            cVar.labelId = this.dOe;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.dOf = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.dOf, this.bZU, this.dOe);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void by(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.by(i, i2);
                }
            }, 1000L);
            return;
        }
        this.bZU = i;
        if (i == 0 && i2 == 0) {
            f np = np(i);
            if (np != null && (np.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) np.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.dOe = aVar.labelId;
                }
            }
        } else {
            this.dOe = i2;
        }
        String bA = bA(i, i2);
        com.baidu.tieba.frs.game.strategy.data.c cVar = this.dOd.get(bA);
        if (cVar == null) {
            cVar = new com.baidu.tieba.frs.game.strategy.data.c();
            this.dOd.put(bA, cVar);
            cVar.key = bA;
            cVar.dNY = this.dOe;
            cVar.labelId = this.bZU;
            cVar.hasMore = true;
            this.dOd.put(bA, cVar);
        }
        this.dOf = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.dOf, this.bZU, this.dOe);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(c cVar) {
        this.dNT = cVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public boolean bz(int i, int i2) {
        com.baidu.tieba.frs.game.strategy.data.c bB = bB(i, i2);
        if (bB == null || v.E(bB.dNZ)) {
            return false;
        }
        if (this.dNT != null) {
            this.dNT.a(i, i2, bB.dNZ, this.dOc, bB.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public f no(int i) {
        if (v.E(this.dOc)) {
            return null;
        }
        for (f fVar : this.dOc) {
            if (fVar != null && fVar.tabId == i) {
                return fVar;
            }
        }
        return null;
    }

    private f np(int i) {
        if (v.E(this.dOc)) {
            return null;
        }
        for (f fVar : this.dOc) {
            if (fVar != null && fVar.tabId == i) {
                return fVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bA(int i, int i2) {
        return i + "_" + i2;
    }

    public com.baidu.tieba.frs.game.strategy.data.c bB(int i, int i2) {
        return this.dOd.get(bA(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
