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
    private String gDc;
    private List<e> jwA;
    private com.baidu.tieba.frs.game.strategy.tab.b jws;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int jwC = 0;
    private int jwD = 0;
    private int jwE = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0737a jwG = new a.InterfaceC0737a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0737a
        public void c(List<e> list, List<n> list2, boolean z) {
            if (b.this.jwA != null && b.this.jws != null) {
                b.this.jws.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a jwH = new com.baidu.adp.framework.listener.a(1003362, CmdConfigSocket.CMD_FRS_GAME_STRATEGY) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.jws != null) {
                        b.this.jws.n(b.this.jwC, b.this.jwD, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.jwA == null) {
                        b.this.jwA = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.jwA == null) {
                        b.this.jwA = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.jwC;
                int i3 = b.this.jwD;
                if (b.this.jwC == 0 && b.this.jwD == 0 && !x.isEmpty(b.this.jwA) && (eVar = (e) b.this.jwA.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String cw = b.this.cw(i2, i3);
                c cVar2 = (c) b.this.jwB.get(cw);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.jwB.put(cw, cVar3);
                    cVar3.key = cw;
                    cVar3.jww = i2;
                    cVar3.labelId = i3;
                    b.this.jwB.put(cw, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.jwE;
                if (!x.isEmpty(threadList)) {
                    if (b.this.jwE == 0) {
                        if (x.isEmpty(cVar.jwx)) {
                            cVar.jwx = threadList;
                        } else {
                            i = cVar.dz(threadList);
                        }
                    } else {
                        cVar.jwx.addAll(threadList);
                    }
                }
                if (b.this.jws != null) {
                    b.this.jws.a(b.this.jwC, b.this.jwD, cVar.jwx, b.this.jwA, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> jwB = new HashMap<>();
    private a jwF = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.gDc = str;
        this.jwF.a(this.jwG);
        registerListeners();
        bUn();
    }

    private void registerListeners() {
        this.jwH.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.jwH);
    }

    private static void bUn() {
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
        this.jwC = i;
        this.jwD = i2;
        if (i == 0 && i2 == 0) {
            this.jwF.Lh(String.valueOf(this.mFid));
        } else {
            String cw = cw(i, i2);
            c cVar = this.jwB.get(cw);
            if (cVar == null) {
                cVar = new c();
                this.jwB.put(cw, cVar);
            }
            cVar.key = cw;
            cVar.jww = this.jwC;
            cVar.labelId = this.jwD;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.jwE = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.jwE, this.jwC, this.jwD);
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
        this.jwC = i;
        if (i == 0 && i2 == 0) {
            e Bb = Bb(i);
            if (Bb != null && (Bb.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) Bb.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.jwD = aVar.labelId;
                }
            }
        } else {
            this.jwD = i2;
        }
        String cw = cw(i, i2);
        c cVar = this.jwB.get(cw);
        if (cVar == null) {
            cVar = new c();
            this.jwB.put(cw, cVar);
            cVar.key = cw;
            cVar.jww = this.jwD;
            cVar.labelId = this.jwC;
            cVar.hasMore = true;
            this.jwB.put(cw, cVar);
        }
        this.jwE = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.jwE, this.jwC, this.jwD);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.jws = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean cv(int i, int i2) {
        c cx = cx(i, i2);
        if (cx == null || x.isEmpty(cx.jwx)) {
            return false;
        }
        if (this.jws != null) {
            this.jws.a(i, i2, cx.jwx, this.jwA, cx.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e Ba(int i) {
        if (x.isEmpty(this.jwA)) {
            return null;
        }
        for (e eVar : this.jwA) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e Bb(int i) {
        if (x.isEmpty(this.jwA)) {
            return null;
        }
        for (e eVar : this.jwA) {
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
        return this.jwB.get(cw(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
