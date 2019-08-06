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
    private String fFN;
    private com.baidu.tieba.frs.game.strategy.tab.b fFQ;
    private List<e> fFY;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int dmE = 0;
    private int fGa = 0;
    private int fGb = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0311a fGd = new a.InterfaceC0311a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0311a
        public void e(List<e> list, List<m> list2, boolean z) {
            if (b.this.fFY != null && b.this.fFQ != null) {
                b.this.fFQ.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fGe = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.fFQ != null) {
                        b.this.fFQ.f(b.this.dmE, b.this.fGa, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.fFY == null) {
                        b.this.fFY = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.fFY == null) {
                        b.this.fFY = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.dmE;
                int i3 = b.this.fGa;
                if (b.this.dmE == 0 && b.this.fGa == 0 && !v.aa(b.this.fFY) && (eVar = (e) b.this.fFY.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.bFM;
                        }
                    }
                }
                String by = b.this.by(i2, i3);
                c cVar2 = (c) b.this.fFZ.get(by);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.fFZ.put(by, cVar3);
                    cVar3.key = by;
                    cVar3.fFU = i2;
                    cVar3.bFM = i3;
                    b.this.fFZ.put(by, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.fGb;
                if (!v.aa(threadList)) {
                    if (b.this.fGb == 0) {
                        if (v.aa(cVar.fFV)) {
                            cVar.fFV = threadList;
                        } else {
                            i = cVar.cc(threadList);
                        }
                    } else {
                        cVar.fFV.addAll(threadList);
                    }
                }
                if (b.this.fFQ != null) {
                    b.this.fFQ.a(b.this.dmE, b.this.fGa, cVar.fFV, b.this.fFY, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> fFZ = new HashMap<>();
    private a fGc = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.fFN = str;
        this.fGc.a(this.fGd);
        aac();
        aIQ();
    }

    private void aac() {
        this.fGe.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.fGe);
    }

    private static void aIQ() {
        com.baidu.tieba.tbadkCore.a.a.a(309478, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, com.baidu.tieba.tbadkCore.a.a.bo("c/f/game/gameForumGuideTab", 309478));
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
        this.dmE = i;
        this.fGa = i2;
        if (i == 0 && i2 == 0) {
            this.fGc.xh(String.valueOf(this.mFid));
        } else {
            String by = by(i, i2);
            c cVar = this.fFZ.get(by);
            if (cVar == null) {
                cVar = new c();
                this.fFZ.put(by, cVar);
            }
            cVar.key = by;
            cVar.fFU = this.dmE;
            cVar.bFM = this.fGa;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.fGb = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.fGb, this.dmE, this.fGa);
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
        this.dmE = i;
        if (i == 0 && i2 == 0) {
            e se = se(i);
            if (se != null && (se.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) se.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.fGa = aVar.bFM;
                }
            }
        } else {
            this.fGa = i2;
        }
        String by = by(i, i2);
        c cVar = this.fFZ.get(by);
        if (cVar == null) {
            cVar = new c();
            this.fFZ.put(by, cVar);
            cVar.key = by;
            cVar.fFU = this.fGa;
            cVar.bFM = this.dmE;
            cVar.hasMore = true;
            this.fFZ.put(by, cVar);
        }
        this.fGb = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.fGb, this.dmE, this.fGa);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.fFQ = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean bx(int i, int i2) {
        c bz = bz(i, i2);
        if (bz == null || v.aa(bz.fFV)) {
            return false;
        }
        if (this.fFQ != null) {
            this.fFQ.a(i, i2, bz.fFV, this.fFY, bz.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e sd(int i) {
        if (v.aa(this.fFY)) {
            return null;
        }
        for (e eVar : this.fFY) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e se(int i) {
        if (v.aa(this.fFY)) {
            return null;
        }
        for (e eVar : this.fFY) {
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
        return this.fFZ.get(by(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
