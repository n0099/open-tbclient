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
/* loaded from: classes2.dex */
public class b implements com.baidu.tieba.frs.game.strategy.tab.a {
    private String gyv;
    private com.baidu.tieba.frs.game.strategy.tab.b jrM;
    private List<e> jrU;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int jrW = 0;
    private int jrX = 0;
    private int jrY = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0727a jsa = new a.InterfaceC0727a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0727a
        public void c(List<e> list, List<n> list2, boolean z) {
            if (b.this.jrU != null && b.this.jrM != null) {
                b.this.jrM.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a jsb = new com.baidu.adp.framework.listener.a(1003362, CmdConfigSocket.CMD_FRS_GAME_STRATEGY) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.jrM != null) {
                        b.this.jrM.n(b.this.jrW, b.this.jrX, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.jrU == null) {
                        b.this.jrU = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.jrU == null) {
                        b.this.jrU = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.jrW;
                int i3 = b.this.jrX;
                if (b.this.jrW == 0 && b.this.jrX == 0 && !x.isEmpty(b.this.jrU) && (eVar = (e) b.this.jrU.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String cw = b.this.cw(i2, i3);
                c cVar2 = (c) b.this.jrV.get(cw);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.jrV.put(cw, cVar3);
                    cVar3.key = cw;
                    cVar3.jrQ = i2;
                    cVar3.labelId = i3;
                    b.this.jrV.put(cw, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.jrY;
                if (!x.isEmpty(threadList)) {
                    if (b.this.jrY == 0) {
                        if (x.isEmpty(cVar.jrR)) {
                            cVar.jrR = threadList;
                        } else {
                            i = cVar.dz(threadList);
                        }
                    } else {
                        cVar.jrR.addAll(threadList);
                    }
                }
                if (b.this.jrM != null) {
                    b.this.jrM.a(b.this.jrW, b.this.jrX, cVar.jrR, b.this.jrU, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> jrV = new HashMap<>();
    private a jrZ = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.gyv = str;
        this.jrZ.a(this.jsa);
        registerListeners();
        bQw();
    }

    private void registerListeners() {
        this.jsb.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.jsb);
    }

    private static void bQw() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FRS_GAME_STRATEGY, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003362, com.baidu.tieba.tbadkCore.a.a.bU(Config.FRS_GAME_STRATEGY, CmdConfigSocket.CMD_FRS_GAME_STRATEGY));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void ct(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.ct(i, i2);
                }
            }, 1000L);
            return;
        }
        this.jrW = i;
        this.jrX = i2;
        if (i == 0 && i2 == 0) {
            this.jrZ.JW(String.valueOf(this.mFid));
        } else {
            String cw = cw(i, i2);
            c cVar = this.jrV.get(cw);
            if (cVar == null) {
                cVar = new c();
                this.jrV.put(cw, cVar);
            }
            cVar.key = cw;
            cVar.jrQ = this.jrW;
            cVar.labelId = this.jrX;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.jrY = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.jrY, this.jrW, this.jrX);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void cu(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.cu(i, i2);
                }
            }, 1000L);
            return;
        }
        this.jrW = i;
        if (i == 0 && i2 == 0) {
            e zv = zv(i);
            if (zv != null && (zv.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) zv.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.jrX = aVar.labelId;
                }
            }
        } else {
            this.jrX = i2;
        }
        String cw = cw(i, i2);
        c cVar = this.jrV.get(cw);
        if (cVar == null) {
            cVar = new c();
            this.jrV.put(cw, cVar);
            cVar.key = cw;
            cVar.jrQ = this.jrX;
            cVar.labelId = this.jrW;
            cVar.hasMore = true;
            this.jrV.put(cw, cVar);
        }
        this.jrY = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.jrY, this.jrW, this.jrX);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.jrM = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean cv(int i, int i2) {
        c cx = cx(i, i2);
        if (cx == null || x.isEmpty(cx.jrR)) {
            return false;
        }
        if (this.jrM != null) {
            this.jrM.a(i, i2, cx.jrR, this.jrU, cx.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e zu(int i) {
        if (x.isEmpty(this.jrU)) {
            return null;
        }
        for (e eVar : this.jrU) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e zv(int i) {
        if (x.isEmpty(this.jrU)) {
            return null;
        }
        for (e eVar : this.jrU) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cw(int i, int i2) {
        return i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i2;
    }

    public c cx(int i, int i2) {
        return this.jrV.get(cw(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
