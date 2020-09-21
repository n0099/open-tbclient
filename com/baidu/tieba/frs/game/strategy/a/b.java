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
    private String fIi;
    private List<e> ioC;
    private com.baidu.tieba.frs.game.strategy.tab.b iou;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int ioE = 0;
    private int ioF = 0;
    private int ioG = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0679a ioI = new a.InterfaceC0679a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0679a
        public void b(List<e> list, List<q> list2, boolean z) {
            if (b.this.ioC != null && b.this.iou != null) {
                b.this.iou.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a ioJ = new com.baidu.adp.framework.listener.a(1003362, CmdConfigSocket.CMD_FRS_GAME_STRATEGY) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.iou != null) {
                        b.this.iou.k(b.this.ioE, b.this.ioF, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.ioC == null) {
                        b.this.ioC = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.ioC == null) {
                        b.this.ioC = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.ioE;
                int i3 = b.this.ioF;
                if (b.this.ioE == 0 && b.this.ioF == 0 && !y.isEmpty(b.this.ioC) && (eVar = (e) b.this.ioC.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String cq = b.this.cq(i2, i3);
                c cVar2 = (c) b.this.ioD.get(cq);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.ioD.put(cq, cVar3);
                    cVar3.key = cq;
                    cVar3.ioy = i2;
                    cVar3.labelId = i3;
                    b.this.ioD.put(cq, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.ioG;
                if (!y.isEmpty(threadList)) {
                    if (b.this.ioG == 0) {
                        if (y.isEmpty(cVar.ioz)) {
                            cVar.ioz = threadList;
                        } else {
                            i = cVar.cO(threadList);
                        }
                    } else {
                        cVar.ioz.addAll(threadList);
                    }
                }
                if (b.this.iou != null) {
                    b.this.iou.a(b.this.ioE, b.this.ioF, cVar.ioz, b.this.ioC, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> ioD = new HashMap<>();
    private a ioH = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.fIi = str;
        this.ioH.a(this.ioI);
        registerListeners();
        bGS();
    }

    private void registerListeners() {
        this.ioJ.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.ioJ);
    }

    private static void bGS() {
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
        this.ioE = i;
        this.ioF = i2;
        if (i == 0 && i2 == 0) {
            this.ioH.IX(String.valueOf(this.mFid));
        } else {
            String cq = cq(i, i2);
            c cVar = this.ioD.get(cq);
            if (cVar == null) {
                cVar = new c();
                this.ioD.put(cq, cVar);
            }
            cVar.key = cq;
            cVar.ioy = this.ioE;
            cVar.labelId = this.ioF;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.ioG = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.ioG, this.ioE, this.ioF);
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
        this.ioE = i;
        if (i == 0 && i2 == 0) {
            e yr = yr(i);
            if (yr != null && (yr.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) yr.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.ioF = aVar.labelId;
                }
            }
        } else {
            this.ioF = i2;
        }
        String cq = cq(i, i2);
        c cVar = this.ioD.get(cq);
        if (cVar == null) {
            cVar = new c();
            this.ioD.put(cq, cVar);
            cVar.key = cq;
            cVar.ioy = this.ioF;
            cVar.labelId = this.ioE;
            cVar.hasMore = true;
            this.ioD.put(cq, cVar);
        }
        this.ioG = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.ioG, this.ioE, this.ioF);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.iou = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean cp(int i, int i2) {
        c cr = cr(i, i2);
        if (cr == null || y.isEmpty(cr.ioz)) {
            return false;
        }
        if (this.iou != null) {
            this.iou.a(i, i2, cr.ioz, this.ioC, cr.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e yq(int i) {
        if (y.isEmpty(this.ioC)) {
            return null;
        }
        for (e eVar : this.ioC) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e yr(int i) {
        if (y.isEmpty(this.ioC)) {
            return null;
        }
        for (e eVar : this.ioC) {
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
        return this.ioD.get(cq(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
