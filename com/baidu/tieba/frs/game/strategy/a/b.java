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
import com.baidu.tbadk.core.util.x;
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
    private String ftz;
    private com.baidu.tieba.frs.game.strategy.tab.b hTe;
    private List<e> hTm;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int hTo = 0;
    private int hTp = 0;
    private int hTq = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0631a hTs = new a.InterfaceC0631a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0631a
        public void b(List<e> list, List<q> list2, boolean z) {
            if (b.this.hTm != null && b.this.hTe != null) {
                b.this.hTe.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a hTt = new com.baidu.adp.framework.listener.a(1003362, CmdConfigSocket.CMD_FRS_GAME_STRATEGY) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.hTe != null) {
                        b.this.hTe.k(b.this.hTo, b.this.hTp, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.hTm == null) {
                        b.this.hTm = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.hTm == null) {
                        b.this.hTm = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.hTo;
                int i3 = b.this.hTp;
                if (b.this.hTo == 0 && b.this.hTp == 0 && !x.isEmpty(b.this.hTm) && (eVar = (e) b.this.hTm.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String cf = b.this.cf(i2, i3);
                c cVar2 = (c) b.this.hTn.get(cf);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.hTn.put(cf, cVar3);
                    cVar3.key = cf;
                    cVar3.hTi = i2;
                    cVar3.labelId = i3;
                    b.this.hTn.put(cf, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.hTq;
                if (!x.isEmpty(threadList)) {
                    if (b.this.hTq == 0) {
                        if (x.isEmpty(cVar.hTj)) {
                            cVar.hTj = threadList;
                        } else {
                            i = cVar.cG(threadList);
                        }
                    } else {
                        cVar.hTj.addAll(threadList);
                    }
                }
                if (b.this.hTe != null) {
                    b.this.hTe.a(b.this.hTo, b.this.hTp, cVar.hTj, b.this.hTm, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> hTn = new HashMap<>();
    private a hTr = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.ftz = str;
        this.hTr.a(this.hTs);
        registerListeners();
        bwC();
    }

    private void registerListeners() {
        this.hTt.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.hTt);
    }

    private static void bwC() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FRS_GAME_STRATEGY, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003362, com.baidu.tieba.tbadkCore.a.a.bC(Config.FRS_GAME_STRATEGY, CmdConfigSocket.CMD_FRS_GAME_STRATEGY));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void cc(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.cc(i, i2);
                }
            }, 1000L);
            return;
        }
        this.hTo = i;
        this.hTp = i2;
        if (i == 0 && i2 == 0) {
            this.hTr.FX(String.valueOf(this.mFid));
        } else {
            String cf = cf(i, i2);
            c cVar = this.hTn.get(cf);
            if (cVar == null) {
                cVar = new c();
                this.hTn.put(cf, cVar);
            }
            cVar.key = cf;
            cVar.hTi = this.hTo;
            cVar.labelId = this.hTp;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.hTq = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.hTq, this.hTo, this.hTp);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void cd(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.cd(i, i2);
                }
            }, 1000L);
            return;
        }
        this.hTo = i;
        if (i == 0 && i2 == 0) {
            e vz = vz(i);
            if (vz != null && (vz.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) vz.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.hTp = aVar.labelId;
                }
            }
        } else {
            this.hTp = i2;
        }
        String cf = cf(i, i2);
        c cVar = this.hTn.get(cf);
        if (cVar == null) {
            cVar = new c();
            this.hTn.put(cf, cVar);
            cVar.key = cf;
            cVar.hTi = this.hTp;
            cVar.labelId = this.hTo;
            cVar.hasMore = true;
            this.hTn.put(cf, cVar);
        }
        this.hTq = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.hTq, this.hTo, this.hTp);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.hTe = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean ce(int i, int i2) {
        c cg = cg(i, i2);
        if (cg == null || x.isEmpty(cg.hTj)) {
            return false;
        }
        if (this.hTe != null) {
            this.hTe.a(i, i2, cg.hTj, this.hTm, cg.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e vy(int i) {
        if (x.isEmpty(this.hTm)) {
            return null;
        }
        for (e eVar : this.hTm) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e vz(int i) {
        if (x.isEmpty(this.hTm)) {
            return null;
        }
        for (e eVar : this.hTm) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cf(int i, int i2) {
        return i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i2;
    }

    public c cg(int i, int i2) {
        return this.hTn.get(cf(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
