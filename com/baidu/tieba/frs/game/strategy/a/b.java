package com.baidu.tieba.frs.game.strategy.a;

import android.content.Context;
import android.os.Handler;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.data.Config;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
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
/* loaded from: classes9.dex */
public class b implements com.baidu.tieba.frs.game.strategy.tab.a {
    private String eQg;
    private com.baidu.tieba.frs.game.strategy.tab.b hko;
    private List<e> hkw;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int hky = 0;
    private int hkz = 0;
    private int hkA = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0542a hkC = new a.InterfaceC0542a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0542a
        public void b(List<e> list, List<m> list2, boolean z) {
            if (b.this.hkw != null && b.this.hko != null) {
                b.this.hko.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a hkD = new com.baidu.adp.framework.listener.a(1003362, CmdConfigSocket.CMD_FRS_GAME_STRATEGY) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.hko != null) {
                        b.this.hko.j(b.this.hky, b.this.hkz, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.hkw == null) {
                        b.this.hkw = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.hkw == null) {
                        b.this.hkw = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.hky;
                int i3 = b.this.hkz;
                if (b.this.hky == 0 && b.this.hkz == 0 && !v.isEmpty(b.this.hkw) && (eVar = (e) b.this.hkw.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String bR = b.this.bR(i2, i3);
                c cVar2 = (c) b.this.hkx.get(bR);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.hkx.put(bR, cVar3);
                    cVar3.key = bR;
                    cVar3.hks = i2;
                    cVar3.labelId = i3;
                    b.this.hkx.put(bR, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.hkA;
                if (!v.isEmpty(threadList)) {
                    if (b.this.hkA == 0) {
                        if (v.isEmpty(cVar.hkt)) {
                            cVar.hkt = threadList;
                        } else {
                            i = cVar.ct(threadList);
                        }
                    } else {
                        cVar.hkt.addAll(threadList);
                    }
                }
                if (b.this.hko != null) {
                    b.this.hko.a(b.this.hky, b.this.hkz, cVar.hkt, b.this.hkw, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> hkx = new HashMap<>();
    private a hkB = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.eQg = str;
        this.hkB.a(this.hkC);
        registerListeners();
        bkZ();
    }

    private void registerListeners() {
        this.hkD.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.hkD);
    }

    private static void bkZ() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FRS_GAME_STRATEGY, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003362, com.baidu.tieba.tbadkCore.a.a.bE(Config.FRS_GAME_STRATEGY, CmdConfigSocket.CMD_FRS_GAME_STRATEGY));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void bO(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.bO(i, i2);
                }
            }, 1000L);
            return;
        }
        this.hky = i;
        this.hkz = i2;
        if (i == 0 && i2 == 0) {
            this.hkB.CY(String.valueOf(this.mFid));
        } else {
            String bR = bR(i, i2);
            c cVar = this.hkx.get(bR);
            if (cVar == null) {
                cVar = new c();
                this.hkx.put(bR, cVar);
            }
            cVar.key = bR;
            cVar.hks = this.hky;
            cVar.labelId = this.hkz;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.hkA = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.hkA, this.hky, this.hkz);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void bP(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.bP(i, i2);
                }
            }, 1000L);
            return;
        }
        this.hky = i;
        if (i == 0 && i2 == 0) {
            e tV = tV(i);
            if (tV != null && (tV.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) tV.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.hkz = aVar.labelId;
                }
            }
        } else {
            this.hkz = i2;
        }
        String bR = bR(i, i2);
        c cVar = this.hkx.get(bR);
        if (cVar == null) {
            cVar = new c();
            this.hkx.put(bR, cVar);
            cVar.key = bR;
            cVar.hks = this.hkz;
            cVar.labelId = this.hky;
            cVar.hasMore = true;
            this.hkx.put(bR, cVar);
        }
        this.hkA = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.hkA, this.hky, this.hkz);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.hko = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean bQ(int i, int i2) {
        c bS = bS(i, i2);
        if (bS == null || v.isEmpty(bS.hkt)) {
            return false;
        }
        if (this.hko != null) {
            this.hko.a(i, i2, bS.hkt, this.hkw, bS.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e tU(int i) {
        if (v.isEmpty(this.hkw)) {
            return null;
        }
        for (e eVar : this.hkw) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e tV(int i) {
        if (v.isEmpty(this.hkw)) {
            return null;
        }
        for (e eVar : this.hkw) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bR(int i, int i2) {
        return i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i2;
    }

    public c bS(int i, int i2) {
        return this.hkx.get(bR(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
