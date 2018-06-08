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
    private String dqJ;
    private com.baidu.tieba.frs.game.strategy.tab.b dqM;
    private List<e> dqU;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int bsf = 0;
    private int dqW = 0;
    private int dqX = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0152a dqZ = new a.InterfaceC0152a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0152a
        public void e(List<e> list, List<h> list2, boolean z) {
            if (b.this.dqU != null && b.this.dqM != null) {
                b.this.dqM.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a dra = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.dqM != null) {
                        b.this.dqM.c(b.this.bsf, b.this.dqW, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.dqU == null) {
                        b.this.dqU = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.dqU == null) {
                        b.this.dqU = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.bsf;
                int i3 = b.this.dqW;
                if (b.this.bsf == 0 && b.this.dqW == 0 && !w.z(b.this.dqU) && (eVar = (e) b.this.dqU.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String aG = b.this.aG(i2, i3);
                c cVar2 = (c) b.this.dqV.get(aG);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.dqV.put(aG, cVar3);
                    cVar3.key = aG;
                    cVar3.dqQ = i2;
                    cVar3.labelId = i3;
                    b.this.dqV.put(aG, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.dqX;
                if (!w.z(threadList)) {
                    if (b.this.dqX == 0) {
                        if (w.z(cVar.dqR)) {
                            cVar.dqR = threadList;
                        } else {
                            i = cVar.bo(threadList);
                        }
                    } else {
                        cVar.dqR.addAll(threadList);
                    }
                }
                if (b.this.dqM != null) {
                    b.this.dqM.a(b.this.bsf, b.this.dqW, cVar.dqR, b.this.dqU, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> dqV = new HashMap<>();
    private a dqY = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.dqJ = str;
        this.dqY.a(this.dqZ);
        aub();
        SH();
    }

    private void aub() {
        this.dra.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.dra);
    }

    private static void SH() {
        com.baidu.tieba.tbadkCore.a.a.a(309478, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, com.baidu.tieba.tbadkCore.a.a.aN("c/f/game/gameForumGuideTab", 309478));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void aD(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aD(i, i2);
                }
            }, 1000L);
            return;
        }
        this.bsf = i;
        this.dqW = i2;
        if (i == 0 && i2 == 0) {
            this.dqY.mF(String.valueOf(this.mFid));
        } else {
            String aG = aG(i, i2);
            c cVar = this.dqV.get(aG);
            if (cVar == null) {
                cVar = new c();
                this.dqV.put(aG, cVar);
            }
            cVar.key = aG;
            cVar.dqQ = this.bsf;
            cVar.labelId = this.dqW;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.dqX = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.dqX, this.bsf, this.dqW);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void aE(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aE(i, i2);
                }
            }, 1000L);
            return;
        }
        this.bsf = i;
        if (i == 0 && i2 == 0) {
            e kG = kG(i);
            if (kG != null && (kG.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) kG.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.dqW = aVar.labelId;
                }
            }
        } else {
            this.dqW = i2;
        }
        String aG = aG(i, i2);
        c cVar = this.dqV.get(aG);
        if (cVar == null) {
            cVar = new c();
            this.dqV.put(aG, cVar);
            cVar.key = aG;
            cVar.dqQ = this.dqW;
            cVar.labelId = this.bsf;
            cVar.hasMore = true;
            this.dqV.put(aG, cVar);
        }
        this.dqX = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.dqX, this.bsf, this.dqW);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.dqM = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean aF(int i, int i2) {
        c aH = aH(i, i2);
        if (aH == null || w.z(aH.dqR)) {
            return false;
        }
        if (this.dqM != null) {
            this.dqM.a(i, i2, aH.dqR, this.dqU, aH.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e kF(int i) {
        if (w.z(this.dqU)) {
            return null;
        }
        for (e eVar : this.dqU) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e kG(int i) {
        if (w.z(this.dqU)) {
            return null;
        }
        for (e eVar : this.dqU) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aG(int i, int i2) {
        return i + "_" + i2;
    }

    public c aH(int i, int i2) {
        return this.dqV.get(aG(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
