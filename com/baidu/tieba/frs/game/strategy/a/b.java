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
/* loaded from: classes22.dex */
public class b implements com.baidu.tieba.frs.game.strategy.tab.a {
    private String fUs;
    private com.baidu.tieba.frs.game.strategy.tab.b iDn;
    private List<e> iDv;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int iDx = 0;
    private int iDy = 0;
    private int iDz = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0697a iDB = new a.InterfaceC0697a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0697a
        public void b(List<e> list, List<q> list2, boolean z) {
            if (b.this.iDv != null && b.this.iDn != null) {
                b.this.iDn.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a iDC = new com.baidu.adp.framework.listener.a(1003362, CmdConfigSocket.CMD_FRS_GAME_STRATEGY) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.iDn != null) {
                        b.this.iDn.l(b.this.iDx, b.this.iDy, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.iDv == null) {
                        b.this.iDv = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.iDv == null) {
                        b.this.iDv = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.iDx;
                int i3 = b.this.iDy;
                if (b.this.iDx == 0 && b.this.iDy == 0 && !y.isEmpty(b.this.iDv) && (eVar = (e) b.this.iDv.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String cq = b.this.cq(i2, i3);
                c cVar2 = (c) b.this.iDw.get(cq);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.iDw.put(cq, cVar3);
                    cVar3.key = cq;
                    cVar3.iDr = i2;
                    cVar3.labelId = i3;
                    b.this.iDw.put(cq, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.iDz;
                if (!y.isEmpty(threadList)) {
                    if (b.this.iDz == 0) {
                        if (y.isEmpty(cVar.iDs)) {
                            cVar.iDs = threadList;
                        } else {
                            i = cVar.cR(threadList);
                        }
                    } else {
                        cVar.iDs.addAll(threadList);
                    }
                }
                if (b.this.iDn != null) {
                    b.this.iDn.a(b.this.iDx, b.this.iDy, cVar.iDs, b.this.iDv, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> iDw = new HashMap<>();
    private a iDA = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.fUs = str;
        this.iDA.a(this.iDB);
        registerListeners();
        bJE();
    }

    private void registerListeners() {
        this.iDC.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.iDC);
    }

    private static void bJE() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FRS_GAME_STRATEGY, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003362, com.baidu.tieba.tbadkCore.a.a.bI(Config.FRS_GAME_STRATEGY, CmdConfigSocket.CMD_FRS_GAME_STRATEGY));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void cn(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.cn(i, i2);
                }
            }, 1000L);
            return;
        }
        this.iDx = i;
        this.iDy = i2;
        if (i == 0 && i2 == 0) {
            this.iDA.JK(String.valueOf(this.mFid));
        } else {
            String cq = cq(i, i2);
            c cVar = this.iDw.get(cq);
            if (cVar == null) {
                cVar = new c();
                this.iDw.put(cq, cVar);
            }
            cVar.key = cq;
            cVar.iDr = this.iDx;
            cVar.labelId = this.iDy;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.iDz = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.iDz, this.iDx, this.iDy);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void co(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.co(i, i2);
                }
            }, 1000L);
            return;
        }
        this.iDx = i;
        if (i == 0 && i2 == 0) {
            e yX = yX(i);
            if (yX != null && (yX.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) yX.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.iDy = aVar.labelId;
                }
            }
        } else {
            this.iDy = i2;
        }
        String cq = cq(i, i2);
        c cVar = this.iDw.get(cq);
        if (cVar == null) {
            cVar = new c();
            this.iDw.put(cq, cVar);
            cVar.key = cq;
            cVar.iDr = this.iDy;
            cVar.labelId = this.iDx;
            cVar.hasMore = true;
            this.iDw.put(cq, cVar);
        }
        this.iDz = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.iDz, this.iDx, this.iDy);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.iDn = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean cp(int i, int i2) {
        c cr = cr(i, i2);
        if (cr == null || y.isEmpty(cr.iDs)) {
            return false;
        }
        if (this.iDn != null) {
            this.iDn.a(i, i2, cr.iDs, this.iDv, cr.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e yW(int i) {
        if (y.isEmpty(this.iDv)) {
            return null;
        }
        for (e eVar : this.iDv) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e yX(int i) {
        if (y.isEmpty(this.iDv)) {
            return null;
        }
        for (e eVar : this.iDv) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cq(int i, int i2) {
        return i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i2;
    }

    public c cr(int i, int i2) {
        return this.iDw.get(cq(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
