package com.baidu.tieba.frs.game.strategy.a;

import android.content.Context;
import android.os.Handler;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.data.Config;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.util.y;
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
/* loaded from: classes2.dex */
public class b implements com.baidu.tieba.frs.game.strategy.tab.a {
    private String gBf;
    private List<e> jxA;
    private com.baidu.tieba.frs.game.strategy.tab.b jxs;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int jxC = 0;
    private int jxD = 0;
    private int jxE = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0727a jxG = new a.InterfaceC0727a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0727a
        public void d(List<e> list, List<n> list2, boolean z) {
            if (b.this.jxA != null && b.this.jxs != null) {
                b.this.jxs.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a jxH = new com.baidu.adp.framework.listener.a(1003362, CmdConfigSocket.CMD_FRS_GAME_STRATEGY) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<n> threadList;
            boolean hasMore;
            c cVar;
            e eVar;
            com.baidu.tieba.frs.game.strategy.data.a aVar;
            int i = -1;
            if (responsedMessage != null) {
                b.this.mIsLoading = false;
                if (responsedMessage.hasError()) {
                    if (b.this.jxs != null) {
                        b.this.jxs.m(b.this.jxC, b.this.jxD, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.jxA == null) {
                        b.this.jxA = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.jxA == null) {
                        b.this.jxA = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.jxC;
                int i3 = b.this.jxD;
                if (b.this.jxC == 0 && b.this.jxD == 0 && !y.isEmpty(b.this.jxA) && (eVar = (e) b.this.jxA.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String ct = b.this.ct(i2, i3);
                c cVar2 = (c) b.this.jxB.get(ct);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.jxB.put(ct, cVar3);
                    cVar3.key = ct;
                    cVar3.jxw = i2;
                    cVar3.labelId = i3;
                    b.this.jxB.put(ct, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.jxE;
                if (!y.isEmpty(threadList)) {
                    if (b.this.jxE == 0) {
                        if (y.isEmpty(cVar.jxx)) {
                            cVar.jxx = threadList;
                        } else {
                            i = cVar.du(threadList);
                        }
                    } else {
                        cVar.jxx.addAll(threadList);
                    }
                }
                if (b.this.jxs != null) {
                    b.this.jxs.a(b.this.jxC, b.this.jxD, cVar.jxx, b.this.jxA, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> jxB = new HashMap<>();
    private a jxF = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.gBf = str;
        this.jxF.a(this.jxG);
        registerListeners();
        bRa();
    }

    private void registerListeners() {
        this.jxH.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.jxH);
    }

    private static void bRa() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FRS_GAME_STRATEGY, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003362, com.baidu.tieba.tbadkCore.a.a.bV(Config.FRS_GAME_STRATEGY, CmdConfigSocket.CMD_FRS_GAME_STRATEGY));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void cq(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.cq(i, i2);
                }
            }, 1000L);
            return;
        }
        this.jxC = i;
        this.jxD = i2;
        if (i == 0 && i2 == 0) {
            this.jxF.KH(String.valueOf(this.mFid));
        } else {
            String ct = ct(i, i2);
            c cVar = this.jxB.get(ct);
            if (cVar == null) {
                cVar = new c();
                this.jxB.put(ct, cVar);
            }
            cVar.key = ct;
            cVar.jxw = this.jxC;
            cVar.labelId = this.jxD;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.jxE = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.jxE, this.jxC, this.jxD);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void cr(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.cr(i, i2);
                }
            }, 1000L);
            return;
        }
        this.jxC = i;
        if (i == 0 && i2 == 0) {
            e zF = zF(i);
            if (zF != null && (zF.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) zF.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.jxD = aVar.labelId;
                }
            }
        } else {
            this.jxD = i2;
        }
        String ct = ct(i, i2);
        c cVar = this.jxB.get(ct);
        if (cVar == null) {
            cVar = new c();
            this.jxB.put(ct, cVar);
            cVar.key = ct;
            cVar.jxw = this.jxD;
            cVar.labelId = this.jxC;
            cVar.hasMore = true;
            this.jxB.put(ct, cVar);
        }
        this.jxE = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.jxE, this.jxC, this.jxD);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.jxs = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean cs(int i, int i2) {
        c cu = cu(i, i2);
        if (cu == null || y.isEmpty(cu.jxx)) {
            return false;
        }
        if (this.jxs != null) {
            this.jxs.a(i, i2, cu.jxx, this.jxA, cu.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e zE(int i) {
        if (y.isEmpty(this.jxA)) {
            return null;
        }
        for (e eVar : this.jxA) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e zF(int i) {
        if (y.isEmpty(this.jxA)) {
            return null;
        }
        for (e eVar : this.jxA) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ct(int i, int i2) {
        return i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i2;
    }

    public c cu(int i, int i2) {
        return this.jxB.get(ct(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
