package com.baidu.tieba.frs.game.strategy.a;

import android.content.Context;
import android.os.Handler;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
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
/* loaded from: classes4.dex */
public class b implements com.baidu.tieba.frs.game.strategy.tab.a {
    private String fAa;
    private com.baidu.tieba.frs.game.strategy.tab.b fAd;
    private List<e> fAl;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int dkO = 0;
    private int fAn = 0;
    private int fAo = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0308a fAq = new a.InterfaceC0308a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0308a
        public void e(List<e> list, List<m> list2, boolean z) {
            if (b.this.fAl != null && b.this.fAd != null) {
                b.this.fAd.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fAr = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.fAd != null) {
                        b.this.fAd.f(b.this.dkO, b.this.fAn, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.fAl == null) {
                        b.this.fAl = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.fAl == null) {
                        b.this.fAl = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.dkO;
                int i3 = b.this.fAn;
                if (b.this.dkO == 0 && b.this.fAn == 0 && !v.aa(b.this.fAl) && (eVar = (e) b.this.fAl.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String bt = b.this.bt(i2, i3);
                c cVar2 = (c) b.this.fAm.get(bt);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.fAm.put(bt, cVar3);
                    cVar3.key = bt;
                    cVar3.fAh = i2;
                    cVar3.labelId = i3;
                    b.this.fAm.put(bt, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.fAo;
                if (!v.aa(threadList)) {
                    if (b.this.fAo == 0) {
                        if (v.aa(cVar.fAi)) {
                            cVar.fAi = threadList;
                        } else {
                            i = cVar.cc(threadList);
                        }
                    } else {
                        cVar.fAi.addAll(threadList);
                    }
                }
                if (b.this.fAd != null) {
                    b.this.fAd.a(b.this.dkO, b.this.fAn, cVar.fAi, b.this.fAl, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> fAm = new HashMap<>();
    private a fAp = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.fAa = str;
        this.fAp.a(this.fAq);
        Zd();
        aHo();
    }

    private void Zd() {
        this.fAr.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.fAr);
    }

    private static void aHo() {
        com.baidu.tieba.tbadkCore.a.a.a(309478, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, com.baidu.tieba.tbadkCore.a.a.bn("c/f/game/gameForumGuideTab", 309478));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void bq(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.bq(i, i2);
                }
            }, 1000L);
            return;
        }
        this.dkO = i;
        this.fAn = i2;
        if (i == 0 && i2 == 0) {
            this.fAp.wC(String.valueOf(this.mFid));
        } else {
            String bt = bt(i, i2);
            c cVar = this.fAm.get(bt);
            if (cVar == null) {
                cVar = new c();
                this.fAm.put(bt, cVar);
            }
            cVar.key = bt;
            cVar.fAh = this.dkO;
            cVar.labelId = this.fAn;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.fAo = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.fAo, this.dkO, this.fAn);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void br(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.br(i, i2);
                }
            }, 1000L);
            return;
        }
        this.dkO = i;
        if (i == 0 && i2 == 0) {
            e rK = rK(i);
            if (rK != null && (rK.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) rK.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.fAn = aVar.labelId;
                }
            }
        } else {
            this.fAn = i2;
        }
        String bt = bt(i, i2);
        c cVar = this.fAm.get(bt);
        if (cVar == null) {
            cVar = new c();
            this.fAm.put(bt, cVar);
            cVar.key = bt;
            cVar.fAh = this.fAn;
            cVar.labelId = this.dkO;
            cVar.hasMore = true;
            this.fAm.put(bt, cVar);
        }
        this.fAo = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.fAo, this.dkO, this.fAn);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.fAd = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean bs(int i, int i2) {
        c bu = bu(i, i2);
        if (bu == null || v.aa(bu.fAi)) {
            return false;
        }
        if (this.fAd != null) {
            this.fAd.a(i, i2, bu.fAi, this.fAl, bu.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e rJ(int i) {
        if (v.aa(this.fAl)) {
            return null;
        }
        for (e eVar : this.fAl) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e rK(int i) {
        if (v.aa(this.fAl)) {
            return null;
        }
        for (e eVar : this.fAl) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bt(int i, int i2) {
        return i + "_" + i2;
    }

    public c bu(int i, int i2) {
        return this.fAm.get(bt(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
