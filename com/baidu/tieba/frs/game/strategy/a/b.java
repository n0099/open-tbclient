package com.baidu.tieba.frs.game.strategy.a;

import android.content.Context;
import android.os.Handler;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.o;
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
    private String fde;
    private List<e> hAd;
    private com.baidu.tieba.frs.game.strategy.tab.b hzV;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int hAf = 0;
    private int hAg = 0;
    private int hAh = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0613a hAj = new a.InterfaceC0613a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0613a
        public void b(List<e> list, List<o> list2, boolean z) {
            if (b.this.hAd != null && b.this.hzV != null) {
                b.this.hzV.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a hAk = new com.baidu.adp.framework.listener.a(1003362, CmdConfigSocket.CMD_FRS_GAME_STRATEGY) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<o> threadList;
            boolean hasMore;
            c cVar;
            e eVar;
            com.baidu.tieba.frs.game.strategy.data.a aVar;
            int i = -1;
            if (responsedMessage != null) {
                b.this.mIsLoading = false;
                if (responsedMessage.hasError()) {
                    if (b.this.hzV != null) {
                        b.this.hzV.j(b.this.hAf, b.this.hAg, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.hAd == null) {
                        b.this.hAd = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.hAd == null) {
                        b.this.hAd = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.hAf;
                int i3 = b.this.hAg;
                if (b.this.hAf == 0 && b.this.hAg == 0 && !v.isEmpty(b.this.hAd) && (eVar = (e) b.this.hAd.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String bW = b.this.bW(i2, i3);
                c cVar2 = (c) b.this.hAe.get(bW);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.hAe.put(bW, cVar3);
                    cVar3.key = bW;
                    cVar3.hzZ = i2;
                    cVar3.labelId = i3;
                    b.this.hAe.put(bW, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.hAh;
                if (!v.isEmpty(threadList)) {
                    if (b.this.hAh == 0) {
                        if (v.isEmpty(cVar.hAa)) {
                            cVar.hAa = threadList;
                        } else {
                            i = cVar.cr(threadList);
                        }
                    } else {
                        cVar.hAa.addAll(threadList);
                    }
                }
                if (b.this.hzV != null) {
                    b.this.hzV.a(b.this.hAf, b.this.hAg, cVar.hAa, b.this.hAd, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> hAe = new HashMap<>();
    private a hAi = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.fde = str;
        this.hAi.a(this.hAj);
        registerListeners();
        bqv();
    }

    private void registerListeners() {
        this.hAk.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.hAk);
    }

    private static void bqv() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FRS_GAME_STRATEGY, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003362, com.baidu.tieba.tbadkCore.a.a.bF(Config.FRS_GAME_STRATEGY, CmdConfigSocket.CMD_FRS_GAME_STRATEGY));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void bT(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.bT(i, i2);
                }
            }, 1000L);
            return;
        }
        this.hAf = i;
        this.hAg = i2;
        if (i == 0 && i2 == 0) {
            this.hAi.EK(String.valueOf(this.mFid));
        } else {
            String bW = bW(i, i2);
            c cVar = this.hAe.get(bW);
            if (cVar == null) {
                cVar = new c();
                this.hAe.put(bW, cVar);
            }
            cVar.key = bW;
            cVar.hzZ = this.hAf;
            cVar.labelId = this.hAg;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.hAh = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.hAh, this.hAf, this.hAg);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void bU(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.bU(i, i2);
                }
            }, 1000L);
            return;
        }
        this.hAf = i;
        if (i == 0 && i2 == 0) {
            e uC = uC(i);
            if (uC != null && (uC.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) uC.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.hAg = aVar.labelId;
                }
            }
        } else {
            this.hAg = i2;
        }
        String bW = bW(i, i2);
        c cVar = this.hAe.get(bW);
        if (cVar == null) {
            cVar = new c();
            this.hAe.put(bW, cVar);
            cVar.key = bW;
            cVar.hzZ = this.hAg;
            cVar.labelId = this.hAf;
            cVar.hasMore = true;
            this.hAe.put(bW, cVar);
        }
        this.hAh = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.hAh, this.hAf, this.hAg);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.hzV = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean bV(int i, int i2) {
        c bX = bX(i, i2);
        if (bX == null || v.isEmpty(bX.hAa)) {
            return false;
        }
        if (this.hzV != null) {
            this.hzV.a(i, i2, bX.hAa, this.hAd, bX.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e uB(int i) {
        if (v.isEmpty(this.hAd)) {
            return null;
        }
        for (e eVar : this.hAd) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e uC(int i) {
        if (v.isEmpty(this.hAd)) {
            return null;
        }
        for (e eVar : this.hAd) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bW(int i, int i2) {
        return i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i2;
    }

    public c bX(int i, int i2) {
        return this.hAe.get(bW(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
