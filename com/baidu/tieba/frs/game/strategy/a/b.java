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
/* loaded from: classes7.dex */
public class b implements com.baidu.tieba.frs.game.strategy.tab.a {
    private String gxD;
    private com.baidu.tieba.frs.game.strategy.tab.b gxG;
    private List<e> gxO;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int gxQ = 0;
    private int gxR = 0;
    private int gxS = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0498a gxU = new a.InterfaceC0498a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0498a
        public void b(List<e> list, List<m> list2, boolean z) {
            if (b.this.gxO != null && b.this.gxG != null) {
                b.this.gxG.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gxV = new com.baidu.adp.framework.listener.a(1003362, CmdConfigSocket.CMD_FRS_GAME_STRATEGY) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.gxG != null) {
                        b.this.gxG.j(b.this.gxQ, b.this.gxR, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.gxO == null) {
                        b.this.gxO = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.gxO == null) {
                        b.this.gxO = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.gxQ;
                int i3 = b.this.gxR;
                if (b.this.gxQ == 0 && b.this.gxR == 0 && !v.isEmpty(b.this.gxO) && (eVar = (e) b.this.gxO.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String bJ = b.this.bJ(i2, i3);
                c cVar2 = (c) b.this.gxP.get(bJ);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.gxP.put(bJ, cVar3);
                    cVar3.key = bJ;
                    cVar3.gxK = i2;
                    cVar3.labelId = i3;
                    b.this.gxP.put(bJ, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.gxS;
                if (!v.isEmpty(threadList)) {
                    if (b.this.gxS == 0) {
                        if (v.isEmpty(cVar.gxL)) {
                            cVar.gxL = threadList;
                        } else {
                            i = cVar.cl(threadList);
                        }
                    } else {
                        cVar.gxL.addAll(threadList);
                    }
                }
                if (b.this.gxG != null) {
                    b.this.gxG.a(b.this.gxQ, b.this.gxR, cVar.gxL, b.this.gxO, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> gxP = new HashMap<>();
    private a gxT = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.gxD = str;
        this.gxT.a(this.gxU);
        registerListeners();
        aZL();
    }

    private void registerListeners() {
        this.gxV.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.gxV);
    }

    private static void aZL() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FRS_GAME_STRATEGY, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003362, com.baidu.tieba.tbadkCore.a.a.bv(Config.FRS_GAME_STRATEGY, CmdConfigSocket.CMD_FRS_GAME_STRATEGY));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void bG(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.bG(i, i2);
                }
            }, 1000L);
            return;
        }
        this.gxQ = i;
        this.gxR = i2;
        if (i == 0 && i2 == 0) {
            this.gxT.AX(String.valueOf(this.mFid));
        } else {
            String bJ = bJ(i, i2);
            c cVar = this.gxP.get(bJ);
            if (cVar == null) {
                cVar = new c();
                this.gxP.put(bJ, cVar);
            }
            cVar.key = bJ;
            cVar.gxK = this.gxQ;
            cVar.labelId = this.gxR;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.gxS = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.gxS, this.gxQ, this.gxR);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void bH(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.bH(i, i2);
                }
            }, 1000L);
            return;
        }
        this.gxQ = i;
        if (i == 0 && i2 == 0) {
            e tl = tl(i);
            if (tl != null && (tl.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) tl.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.gxR = aVar.labelId;
                }
            }
        } else {
            this.gxR = i2;
        }
        String bJ = bJ(i, i2);
        c cVar = this.gxP.get(bJ);
        if (cVar == null) {
            cVar = new c();
            this.gxP.put(bJ, cVar);
            cVar.key = bJ;
            cVar.gxK = this.gxR;
            cVar.labelId = this.gxQ;
            cVar.hasMore = true;
            this.gxP.put(bJ, cVar);
        }
        this.gxS = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.gxS, this.gxQ, this.gxR);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.gxG = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean bI(int i, int i2) {
        c bK = bK(i, i2);
        if (bK == null || v.isEmpty(bK.gxL)) {
            return false;
        }
        if (this.gxG != null) {
            this.gxG.a(i, i2, bK.gxL, this.gxO, bK.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e tk(int i) {
        if (v.isEmpty(this.gxO)) {
            return null;
        }
        for (e eVar : this.gxO) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e tl(int i) {
        if (v.isEmpty(this.gxO)) {
            return null;
        }
        for (e eVar : this.gxO) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bJ(int i, int i2) {
        return i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i2;
    }

    public c bK(int i, int i2) {
        return this.gxP.get(bJ(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
