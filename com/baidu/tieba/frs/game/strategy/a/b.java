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
    private String emp;
    private List<e> gAc;
    private com.baidu.tieba.frs.game.strategy.tab.b gzU;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int gAe = 0;
    private int gAf = 0;
    private int gAg = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0505a gAi = new a.InterfaceC0505a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0505a
        public void b(List<e> list, List<m> list2, boolean z) {
            if (b.this.gAc != null && b.this.gzU != null) {
                b.this.gzU.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gAj = new com.baidu.adp.framework.listener.a(1003362, CmdConfigSocket.CMD_FRS_GAME_STRATEGY) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.gzU != null) {
                        b.this.gzU.j(b.this.gAe, b.this.gAf, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.gAc == null) {
                        b.this.gAc = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.gAc == null) {
                        b.this.gAc = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.gAe;
                int i3 = b.this.gAf;
                if (b.this.gAe == 0 && b.this.gAf == 0 && !v.isEmpty(b.this.gAc) && (eVar = (e) b.this.gAc.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String bK = b.this.bK(i2, i3);
                c cVar2 = (c) b.this.gAd.get(bK);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.gAd.put(bK, cVar3);
                    cVar3.key = bK;
                    cVar3.gzY = i2;
                    cVar3.labelId = i3;
                    b.this.gAd.put(bK, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.gAg;
                if (!v.isEmpty(threadList)) {
                    if (b.this.gAg == 0) {
                        if (v.isEmpty(cVar.gzZ)) {
                            cVar.gzZ = threadList;
                        } else {
                            i = cVar.ch(threadList);
                        }
                    } else {
                        cVar.gzZ.addAll(threadList);
                    }
                }
                if (b.this.gzU != null) {
                    b.this.gzU.a(b.this.gAe, b.this.gAf, cVar.gzZ, b.this.gAc, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> gAd = new HashMap<>();
    private a gAh = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.emp = str;
        this.gAh.a(this.gAi);
        registerListeners();
        bce();
    }

    private void registerListeners() {
        this.gAj.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.gAj);
    }

    private static void bce() {
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
    public void bH(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.bH(i, i2);
                }
            }, 1000L);
            return;
        }
        this.gAe = i;
        this.gAf = i2;
        if (i == 0 && i2 == 0) {
            this.gAh.Bo(String.valueOf(this.mFid));
        } else {
            String bK = bK(i, i2);
            c cVar = this.gAd.get(bK);
            if (cVar == null) {
                cVar = new c();
                this.gAd.put(bK, cVar);
            }
            cVar.key = bK;
            cVar.gzY = this.gAe;
            cVar.labelId = this.gAf;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.gAg = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.gAg, this.gAe, this.gAf);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void bI(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.bI(i, i2);
                }
            }, 1000L);
            return;
        }
        this.gAe = i;
        if (i == 0 && i2 == 0) {
            e tr = tr(i);
            if (tr != null && (tr.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) tr.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.gAf = aVar.labelId;
                }
            }
        } else {
            this.gAf = i2;
        }
        String bK = bK(i, i2);
        c cVar = this.gAd.get(bK);
        if (cVar == null) {
            cVar = new c();
            this.gAd.put(bK, cVar);
            cVar.key = bK;
            cVar.gzY = this.gAf;
            cVar.labelId = this.gAe;
            cVar.hasMore = true;
            this.gAd.put(bK, cVar);
        }
        this.gAg = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.gAg, this.gAe, this.gAf);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.gzU = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean bJ(int i, int i2) {
        c bL = bL(i, i2);
        if (bL == null || v.isEmpty(bL.gzZ)) {
            return false;
        }
        if (this.gzU != null) {
            this.gzU.a(i, i2, bL.gzZ, this.gAc, bL.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e tq(int i) {
        if (v.isEmpty(this.gAc)) {
            return null;
        }
        for (e eVar : this.gAc) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e tr(int i) {
        if (v.isEmpty(this.gAc)) {
            return null;
        }
        for (e eVar : this.gAc) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bK(int i, int i2) {
        return i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i2;
    }

    public c bL(int i, int i2) {
        return this.gAd.get(bK(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
