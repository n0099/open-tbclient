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
/* loaded from: classes21.dex */
public class b implements com.baidu.tieba.frs.game.strategy.tab.a {
    private String gjS;
    private List<e> iWA;
    private com.baidu.tieba.frs.game.strategy.tab.b iWs;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int iWC = 0;
    private int iWD = 0;
    private int iWE = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0728a iWG = new a.InterfaceC0728a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0728a
        public void b(List<e> list, List<q> list2, boolean z) {
            if (b.this.iWA != null && b.this.iWs != null) {
                b.this.iWs.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a iWH = new com.baidu.adp.framework.listener.a(1003362, CmdConfigSocket.CMD_FRS_GAME_STRATEGY) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.iWs != null) {
                        b.this.iWs.l(b.this.iWC, b.this.iWD, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.iWA == null) {
                        b.this.iWA = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.iWA == null) {
                        b.this.iWA = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.iWC;
                int i3 = b.this.iWD;
                if (b.this.iWC == 0 && b.this.iWD == 0 && !y.isEmpty(b.this.iWA) && (eVar = (e) b.this.iWA.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String cu = b.this.cu(i2, i3);
                c cVar2 = (c) b.this.iWB.get(cu);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.iWB.put(cu, cVar3);
                    cVar3.key = cu;
                    cVar3.iWw = i2;
                    cVar3.labelId = i3;
                    b.this.iWB.put(cu, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.iWE;
                if (!y.isEmpty(threadList)) {
                    if (b.this.iWE == 0) {
                        if (y.isEmpty(cVar.iWx)) {
                            cVar.iWx = threadList;
                        } else {
                            i = cVar.di(threadList);
                        }
                    } else {
                        cVar.iWx.addAll(threadList);
                    }
                }
                if (b.this.iWs != null) {
                    b.this.iWs.a(b.this.iWC, b.this.iWD, cVar.iWx, b.this.iWA, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> iWB = new HashMap<>();
    private a iWF = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.gjS = str;
        this.iWF.a(this.iWG);
        registerListeners();
        bNZ();
    }

    private void registerListeners() {
        this.iWH.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.iWH);
    }

    private static void bNZ() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FRS_GAME_STRATEGY, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003362, com.baidu.tieba.tbadkCore.a.a.bK(Config.FRS_GAME_STRATEGY, CmdConfigSocket.CMD_FRS_GAME_STRATEGY));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void cr(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.cr(i, i2);
                }
            }, 1000L);
            return;
        }
        this.iWC = i;
        this.iWD = i2;
        if (i == 0 && i2 == 0) {
            this.iWF.Kb(String.valueOf(this.mFid));
        } else {
            String cu = cu(i, i2);
            c cVar = this.iWB.get(cu);
            if (cVar == null) {
                cVar = new c();
                this.iWB.put(cu, cVar);
            }
            cVar.key = cu;
            cVar.iWw = this.iWC;
            cVar.labelId = this.iWD;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.iWE = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.iWE, this.iWC, this.iWD);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void cs(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.cs(i, i2);
                }
            }, 1000L);
            return;
        }
        this.iWC = i;
        if (i == 0 && i2 == 0) {
            e Ab = Ab(i);
            if (Ab != null && (Ab.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) Ab.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.iWD = aVar.labelId;
                }
            }
        } else {
            this.iWD = i2;
        }
        String cu = cu(i, i2);
        c cVar = this.iWB.get(cu);
        if (cVar == null) {
            cVar = new c();
            this.iWB.put(cu, cVar);
            cVar.key = cu;
            cVar.iWw = this.iWD;
            cVar.labelId = this.iWC;
            cVar.hasMore = true;
            this.iWB.put(cu, cVar);
        }
        this.iWE = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.iWE, this.iWC, this.iWD);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.iWs = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean ct(int i, int i2) {
        c cv = cv(i, i2);
        if (cv == null || y.isEmpty(cv.iWx)) {
            return false;
        }
        if (this.iWs != null) {
            this.iWs.a(i, i2, cv.iWx, this.iWA, cv.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e Aa(int i) {
        if (y.isEmpty(this.iWA)) {
            return null;
        }
        for (e eVar : this.iWA) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e Ab(int i) {
        if (y.isEmpty(this.iWA)) {
            return null;
        }
        for (e eVar : this.iWA) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cu(int i, int i2) {
        return i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i2;
    }

    public c cv(int i, int i2) {
        return this.iWB.get(cu(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
