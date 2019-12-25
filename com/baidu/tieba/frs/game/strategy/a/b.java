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
/* loaded from: classes6.dex */
public class b implements com.baidu.tieba.frs.game.strategy.tab.a {
    private List<e> guE;
    private String gut;
    private com.baidu.tieba.frs.game.strategy.tab.b guw;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int guG = 0;
    private int guH = 0;
    private int guI = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0494a guK = new a.InterfaceC0494a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0494a
        public void b(List<e> list, List<m> list2, boolean z) {
            if (b.this.guE != null && b.this.guw != null) {
                b.this.guw.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a guL = new com.baidu.adp.framework.listener.a(1003362, CmdConfigSocket.CMD_FRS_GAME_STRATEGY) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.guw != null) {
                        b.this.guw.h(b.this.guG, b.this.guH, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.guE == null) {
                        b.this.guE = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.guE == null) {
                        b.this.guE = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.guG;
                int i3 = b.this.guH;
                if (b.this.guG == 0 && b.this.guH == 0 && !v.isEmpty(b.this.guE) && (eVar = (e) b.this.guE.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String bK = b.this.bK(i2, i3);
                c cVar2 = (c) b.this.guF.get(bK);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.guF.put(bK, cVar3);
                    cVar3.key = bK;
                    cVar3.guA = i2;
                    cVar3.labelId = i3;
                    b.this.guF.put(bK, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.guI;
                if (!v.isEmpty(threadList)) {
                    if (b.this.guI == 0) {
                        if (v.isEmpty(cVar.guB)) {
                            cVar.guB = threadList;
                        } else {
                            i = cVar.cl(threadList);
                        }
                    } else {
                        cVar.guB.addAll(threadList);
                    }
                }
                if (b.this.guw != null) {
                    b.this.guw.a(b.this.guG, b.this.guH, cVar.guB, b.this.guE, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> guF = new HashMap<>();
    private a guJ = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.gut = str;
        this.guJ.a(this.guK);
        registerListeners();
        aZq();
    }

    private void registerListeners() {
        this.guL.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.guL);
    }

    private static void aZq() {
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
        this.guG = i;
        this.guH = i2;
        if (i == 0 && i2 == 0) {
            this.guJ.AN(String.valueOf(this.mFid));
        } else {
            String bK = bK(i, i2);
            c cVar = this.guF.get(bK);
            if (cVar == null) {
                cVar = new c();
                this.guF.put(bK, cVar);
            }
            cVar.key = bK;
            cVar.guA = this.guG;
            cVar.labelId = this.guH;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.guI = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.guI, this.guG, this.guH);
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
        this.guG = i;
        if (i == 0 && i2 == 0) {
            e tg = tg(i);
            if (tg != null && (tg.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) tg.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.guH = aVar.labelId;
                }
            }
        } else {
            this.guH = i2;
        }
        String bK = bK(i, i2);
        c cVar = this.guF.get(bK);
        if (cVar == null) {
            cVar = new c();
            this.guF.put(bK, cVar);
            cVar.key = bK;
            cVar.guA = this.guH;
            cVar.labelId = this.guG;
            cVar.hasMore = true;
            this.guF.put(bK, cVar);
        }
        this.guI = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.guI, this.guG, this.guH);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.guw = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean bJ(int i, int i2) {
        c bL = bL(i, i2);
        if (bL == null || v.isEmpty(bL.guB)) {
            return false;
        }
        if (this.guw != null) {
            this.guw.a(i, i2, bL.guB, this.guE, bL.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e tf(int i) {
        if (v.isEmpty(this.guE)) {
            return null;
        }
        for (e eVar : this.guE) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e tg(int i) {
        if (v.isEmpty(this.guE)) {
            return null;
        }
        for (e eVar : this.guE) {
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
        return this.guF.get(bK(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
