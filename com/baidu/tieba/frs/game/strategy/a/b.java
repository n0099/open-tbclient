package com.baidu.tieba.frs.game.strategy.a;

import android.content.Context;
import android.os.Handler;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.q;
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
/* loaded from: classes16.dex */
public class b implements com.baidu.tieba.frs.game.strategy.tab.a {
    private String fEW;
    private List<e> ihA;
    private com.baidu.tieba.frs.game.strategy.tab.b ihs;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int ihC = 0;
    private int ihD = 0;
    private int ihE = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0682a ihG = new a.InterfaceC0682a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0682a
        public void b(List<e> list, List<q> list2, boolean z) {
            if (b.this.ihA != null && b.this.ihs != null) {
                b.this.ihs.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a ihH = new com.baidu.adp.framework.listener.a(1003362, CmdConfigSocket.CMD_FRS_GAME_STRATEGY) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<q> threadList;
            boolean hasMore;
            c cVar;
            e eVar;
            com.baidu.tieba.frs.game.strategy.data.a aVar;
            int i = -1;
            if (responsedMessage != null) {
                b.this.mIsLoading = false;
                if (responsedMessage.hasError()) {
                    if (b.this.ihs != null) {
                        b.this.ihs.j(b.this.ihC, b.this.ihD, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.ihA == null) {
                        b.this.ihA = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.ihA == null) {
                        b.this.ihA = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.ihC;
                int i3 = b.this.ihD;
                if (b.this.ihC == 0 && b.this.ihD == 0 && !y.isEmpty(b.this.ihA) && (eVar = (e) b.this.ihA.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String cn2 = b.this.cn(i2, i3);
                c cVar2 = (c) b.this.ihB.get(cn2);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.ihB.put(cn2, cVar3);
                    cVar3.key = cn2;
                    cVar3.ihw = i2;
                    cVar3.labelId = i3;
                    b.this.ihB.put(cn2, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.ihE;
                if (!y.isEmpty(threadList)) {
                    if (b.this.ihE == 0) {
                        if (y.isEmpty(cVar.ihx)) {
                            cVar.ihx = threadList;
                        } else {
                            i = cVar.cI(threadList);
                        }
                    } else {
                        cVar.ihx.addAll(threadList);
                    }
                }
                if (b.this.ihs != null) {
                    b.this.ihs.a(b.this.ihC, b.this.ihD, cVar.ihx, b.this.ihA, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> ihB = new HashMap<>();
    private a ihF = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.fEW = str;
        this.ihF.a(this.ihG);
        registerListeners();
        bFC();
    }

    private void registerListeners() {
        this.ihH.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.ihH);
    }

    private static void bFC() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FRS_GAME_STRATEGY, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003362, com.baidu.tieba.tbadkCore.a.a.bH(Config.FRS_GAME_STRATEGY, CmdConfigSocket.CMD_FRS_GAME_STRATEGY));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void ck(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.ck(i, i2);
                }
            }, 1000L);
            return;
        }
        this.ihC = i;
        this.ihD = i2;
        if (i == 0 && i2 == 0) {
            this.ihF.IA(String.valueOf(this.mFid));
        } else {
            String cn2 = cn(i, i2);
            c cVar = this.ihB.get(cn2);
            if (cVar == null) {
                cVar = new c();
                this.ihB.put(cn2, cVar);
            }
            cVar.key = cn2;
            cVar.ihw = this.ihC;
            cVar.labelId = this.ihD;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.ihE = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.ihE, this.ihC, this.ihD);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void cl(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.cl(i, i2);
                }
            }, 1000L);
            return;
        }
        this.ihC = i;
        if (i == 0 && i2 == 0) {
            e xS = xS(i);
            if (xS != null && (xS.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) xS.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.ihD = aVar.labelId;
                }
            }
        } else {
            this.ihD = i2;
        }
        String cn2 = cn(i, i2);
        c cVar = this.ihB.get(cn2);
        if (cVar == null) {
            cVar = new c();
            this.ihB.put(cn2, cVar);
            cVar.key = cn2;
            cVar.ihw = this.ihD;
            cVar.labelId = this.ihC;
            cVar.hasMore = true;
            this.ihB.put(cn2, cVar);
        }
        this.ihE = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.ihE, this.ihC, this.ihD);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.ihs = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean cm(int i, int i2) {
        c co = co(i, i2);
        if (co == null || y.isEmpty(co.ihx)) {
            return false;
        }
        if (this.ihs != null) {
            this.ihs.a(i, i2, co.ihx, this.ihA, co.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e xR(int i) {
        if (y.isEmpty(this.ihA)) {
            return null;
        }
        for (e eVar : this.ihA) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e xS(int i) {
        if (y.isEmpty(this.ihA)) {
            return null;
        }
        for (e eVar : this.ihA) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cn(int i, int i2) {
        return i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i2;
    }

    public c co(int i, int i2) {
        return this.ihB.get(cn(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
