package com.baidu.tieba.frs.game.strategy.a;

import android.content.Context;
import android.os.Handler;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes3.dex */
public class b implements com.baidu.tieba.frs.game.strategy.tab.a {
    private String dtS;
    private com.baidu.tieba.frs.game.strategy.tab.b dtV;
    private List<e> dud;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int btG = 0;
    private int duf = 0;
    private int dug = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0154a dui = new a.InterfaceC0154a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0154a
        public void e(List<e> list, List<h> list2, boolean z) {
            if (b.this.dud != null && b.this.dtV != null) {
                b.this.dtV.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a duj = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<h> threadList;
            boolean hasMore;
            c cVar;
            e eVar;
            com.baidu.tieba.frs.game.strategy.data.a aVar;
            int i = -1;
            if (responsedMessage != null) {
                b.this.mIsLoading = false;
                if (responsedMessage.hasError()) {
                    if (b.this.dtV != null) {
                        b.this.dtV.c(b.this.btG, b.this.duf, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.dud == null) {
                        b.this.dud = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.dud == null) {
                        b.this.dud = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.btG;
                int i3 = b.this.duf;
                if (b.this.btG == 0 && b.this.duf == 0 && !w.A(b.this.dud) && (eVar = (e) b.this.dud.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String aF = b.this.aF(i2, i3);
                c cVar2 = (c) b.this.due.get(aF);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.due.put(aF, cVar3);
                    cVar3.key = aF;
                    cVar3.dtZ = i2;
                    cVar3.labelId = i3;
                    b.this.due.put(aF, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.dug;
                if (!w.A(threadList)) {
                    if (b.this.dug == 0) {
                        if (w.A(cVar.dua)) {
                            cVar.dua = threadList;
                        } else {
                            i = cVar.br(threadList);
                        }
                    } else {
                        cVar.dua.addAll(threadList);
                    }
                }
                if (b.this.dtV != null) {
                    b.this.dtV.a(b.this.btG, b.this.duf, cVar.dua, b.this.dud, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> due = new HashMap<>();
    private a duh = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.dtS = str;
        this.duh.a(this.dui);
        aut();
        Td();
    }

    private void aut() {
        this.duj.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.duj);
    }

    private static void Td() {
        com.baidu.tieba.tbadkCore.a.a.a(309478, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, com.baidu.tieba.tbadkCore.a.a.aO("c/f/game/gameForumGuideTab", 309478));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void aC(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aC(i, i2);
                }
            }, 1000L);
            return;
        }
        this.btG = i;
        this.duf = i2;
        if (i == 0 && i2 == 0) {
            this.duh.mF(String.valueOf(this.mFid));
        } else {
            String aF = aF(i, i2);
            c cVar = this.due.get(aF);
            if (cVar == null) {
                cVar = new c();
                this.due.put(aF, cVar);
            }
            cVar.key = aF;
            cVar.dtZ = this.btG;
            cVar.labelId = this.duf;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.dug = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.dug, this.btG, this.duf);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void aD(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aD(i, i2);
                }
            }, 1000L);
            return;
        }
        this.btG = i;
        if (i == 0 && i2 == 0) {
            e kN = kN(i);
            if (kN != null && (kN.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) kN.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.duf = aVar.labelId;
                }
            }
        } else {
            this.duf = i2;
        }
        String aF = aF(i, i2);
        c cVar = this.due.get(aF);
        if (cVar == null) {
            cVar = new c();
            this.due.put(aF, cVar);
            cVar.key = aF;
            cVar.dtZ = this.duf;
            cVar.labelId = this.btG;
            cVar.hasMore = true;
            this.due.put(aF, cVar);
        }
        this.dug = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.dug, this.btG, this.duf);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.dtV = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean aE(int i, int i2) {
        c aG = aG(i, i2);
        if (aG == null || w.A(aG.dua)) {
            return false;
        }
        if (this.dtV != null) {
            this.dtV.a(i, i2, aG.dua, this.dud, aG.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e kM(int i) {
        if (w.A(this.dud)) {
            return null;
        }
        for (e eVar : this.dud) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e kN(int i) {
        if (w.A(this.dud)) {
            return null;
        }
        for (e eVar : this.dud) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aF(int i, int i2) {
        return i + "_" + i2;
    }

    public c aG(int i, int i2) {
        return this.due.get(aF(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
