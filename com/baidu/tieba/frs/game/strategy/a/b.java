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
    private String emG;
    private com.baidu.tieba.frs.game.strategy.tab.b gAS;
    private List<e> gBa;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int gBc = 0;
    private int gBd = 0;
    private int gBe = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0505a gBg = new a.InterfaceC0505a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0505a
        public void b(List<e> list, List<m> list2, boolean z) {
            if (b.this.gBa != null && b.this.gAS != null) {
                b.this.gAS.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gBh = new com.baidu.adp.framework.listener.a(1003362, CmdConfigSocket.CMD_FRS_GAME_STRATEGY) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.gAS != null) {
                        b.this.gAS.j(b.this.gBc, b.this.gBd, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.gBa == null) {
                        b.this.gBa = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.gBa == null) {
                        b.this.gBa = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.gBc;
                int i3 = b.this.gBd;
                if (b.this.gBc == 0 && b.this.gBd == 0 && !v.isEmpty(b.this.gBa) && (eVar = (e) b.this.gBa.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String bL = b.this.bL(i2, i3);
                c cVar2 = (c) b.this.gBb.get(bL);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.gBb.put(bL, cVar3);
                    cVar3.key = bL;
                    cVar3.gAW = i2;
                    cVar3.labelId = i3;
                    b.this.gBb.put(bL, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.gBe;
                if (!v.isEmpty(threadList)) {
                    if (b.this.gBe == 0) {
                        if (v.isEmpty(cVar.gAX)) {
                            cVar.gAX = threadList;
                        } else {
                            i = cVar.ch(threadList);
                        }
                    } else {
                        cVar.gAX.addAll(threadList);
                    }
                }
                if (b.this.gAS != null) {
                    b.this.gAS.a(b.this.gBc, b.this.gBd, cVar.gAX, b.this.gBa, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> gBb = new HashMap<>();
    private a gBf = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.emG = str;
        this.gBf.a(this.gBg);
        registerListeners();
        bci();
    }

    private void registerListeners() {
        this.gBh.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.gBh);
    }

    private static void bci() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FRS_GAME_STRATEGY, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003362, com.baidu.tieba.tbadkCore.a.a.bu(Config.FRS_GAME_STRATEGY, CmdConfigSocket.CMD_FRS_GAME_STRATEGY));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void bI(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.bI(i, i2);
                }
            }, 1000L);
            return;
        }
        this.gBc = i;
        this.gBd = i2;
        if (i == 0 && i2 == 0) {
            this.gBf.Bo(String.valueOf(this.mFid));
        } else {
            String bL = bL(i, i2);
            c cVar = this.gBb.get(bL);
            if (cVar == null) {
                cVar = new c();
                this.gBb.put(bL, cVar);
            }
            cVar.key = bL;
            cVar.gAW = this.gBc;
            cVar.labelId = this.gBd;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.gBe = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.gBe, this.gBc, this.gBd);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void bJ(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.bJ(i, i2);
                }
            }, 1000L);
            return;
        }
        this.gBc = i;
        if (i == 0 && i2 == 0) {
            e tx = tx(i);
            if (tx != null && (tx.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) tx.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.gBd = aVar.labelId;
                }
            }
        } else {
            this.gBd = i2;
        }
        String bL = bL(i, i2);
        c cVar = this.gBb.get(bL);
        if (cVar == null) {
            cVar = new c();
            this.gBb.put(bL, cVar);
            cVar.key = bL;
            cVar.gAW = this.gBd;
            cVar.labelId = this.gBc;
            cVar.hasMore = true;
            this.gBb.put(bL, cVar);
        }
        this.gBe = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.gBe, this.gBc, this.gBd);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.gAS = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean bK(int i, int i2) {
        c bM = bM(i, i2);
        if (bM == null || v.isEmpty(bM.gAX)) {
            return false;
        }
        if (this.gAS != null) {
            this.gAS.a(i, i2, bM.gAX, this.gBa, bM.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e tw(int i) {
        if (v.isEmpty(this.gBa)) {
            return null;
        }
        for (e eVar : this.gBa) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e tx(int i) {
        if (v.isEmpty(this.gBa)) {
            return null;
        }
        for (e eVar : this.gBa) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bL(int i, int i2) {
        return i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i2;
    }

    public c bM(int i, int i2) {
        return this.gBb.get(bL(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
