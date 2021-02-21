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
/* loaded from: classes2.dex */
public class b implements com.baidu.tieba.frs.game.strategy.tab.a {
    private String gBt;
    private com.baidu.tieba.frs.game.strategy.tab.b jxG;
    private List<e> jxO;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int jxQ = 0;
    private int jxR = 0;
    private int jxS = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0728a jxU = new a.InterfaceC0728a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0728a
        public void d(List<e> list, List<n> list2, boolean z) {
            if (b.this.jxO != null && b.this.jxG != null) {
                b.this.jxG.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a jxV = new com.baidu.adp.framework.listener.a(1003362, CmdConfigSocket.CMD_FRS_GAME_STRATEGY) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.jxG != null) {
                        b.this.jxG.m(b.this.jxQ, b.this.jxR, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.jxO == null) {
                        b.this.jxO = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.jxO == null) {
                        b.this.jxO = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.jxQ;
                int i3 = b.this.jxR;
                if (b.this.jxQ == 0 && b.this.jxR == 0 && !y.isEmpty(b.this.jxO) && (eVar = (e) b.this.jxO.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String cu = b.this.cu(i2, i3);
                c cVar2 = (c) b.this.jxP.get(cu);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.jxP.put(cu, cVar3);
                    cVar3.key = cu;
                    cVar3.jxK = i2;
                    cVar3.labelId = i3;
                    b.this.jxP.put(cu, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.jxS;
                if (!y.isEmpty(threadList)) {
                    if (b.this.jxS == 0) {
                        if (y.isEmpty(cVar.jxL)) {
                            cVar.jxL = threadList;
                        } else {
                            i = cVar.du(threadList);
                        }
                    } else {
                        cVar.jxL.addAll(threadList);
                    }
                }
                if (b.this.jxG != null) {
                    b.this.jxG.a(b.this.jxQ, b.this.jxR, cVar.jxL, b.this.jxO, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> jxP = new HashMap<>();
    private a jxT = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.gBt = str;
        this.jxT.a(this.jxU);
        registerListeners();
        bRh();
    }

    private void registerListeners() {
        this.jxV.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.jxV);
    }

    private static void bRh() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FRS_GAME_STRATEGY, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003362, com.baidu.tieba.tbadkCore.a.a.bV(Config.FRS_GAME_STRATEGY, CmdConfigSocket.CMD_FRS_GAME_STRATEGY));
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
        this.jxQ = i;
        this.jxR = i2;
        if (i == 0 && i2 == 0) {
            this.jxT.KI(String.valueOf(this.mFid));
        } else {
            String cu = cu(i, i2);
            c cVar = this.jxP.get(cu);
            if (cVar == null) {
                cVar = new c();
                this.jxP.put(cu, cVar);
            }
            cVar.key = cu;
            cVar.jxK = this.jxQ;
            cVar.labelId = this.jxR;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.jxS = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.jxS, this.jxQ, this.jxR);
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
        this.jxQ = i;
        if (i == 0 && i2 == 0) {
            e zF = zF(i);
            if (zF != null && (zF.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) zF.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.jxR = aVar.labelId;
                }
            }
        } else {
            this.jxR = i2;
        }
        String cu = cu(i, i2);
        c cVar = this.jxP.get(cu);
        if (cVar == null) {
            cVar = new c();
            this.jxP.put(cu, cVar);
            cVar.key = cu;
            cVar.jxK = this.jxR;
            cVar.labelId = this.jxQ;
            cVar.hasMore = true;
            this.jxP.put(cu, cVar);
        }
        this.jxS = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.jxS, this.jxQ, this.jxR);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.jxG = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean ct(int i, int i2) {
        c cv = cv(i, i2);
        if (cv == null || y.isEmpty(cv.jxL)) {
            return false;
        }
        if (this.jxG != null) {
            this.jxG.a(i, i2, cv.jxL, this.jxO, cv.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e zE(int i) {
        if (y.isEmpty(this.jxO)) {
            return null;
        }
        for (e eVar : this.jxO) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e zF(int i) {
        if (y.isEmpty(this.jxO)) {
            return null;
        }
        for (e eVar : this.jxO) {
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
        return this.jxP.get(cu(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
