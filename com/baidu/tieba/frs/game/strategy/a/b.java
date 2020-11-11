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
    private String gkl;
    private com.baidu.tieba.frs.game.strategy.tab.b iVG;
    private List<e> iVO;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int iVQ = 0;
    private int iVR = 0;
    private int iVS = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0727a iVU = new a.InterfaceC0727a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0727a
        public void b(List<e> list, List<q> list2, boolean z) {
            if (b.this.iVO != null && b.this.iVG != null) {
                b.this.iVG.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a iVV = new com.baidu.adp.framework.listener.a(1003362, CmdConfigSocket.CMD_FRS_GAME_STRATEGY) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.iVG != null) {
                        b.this.iVG.m(b.this.iVQ, b.this.iVR, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.iVO == null) {
                        b.this.iVO = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.iVO == null) {
                        b.this.iVO = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.iVQ;
                int i3 = b.this.iVR;
                if (b.this.iVQ == 0 && b.this.iVR == 0 && !y.isEmpty(b.this.iVO) && (eVar = (e) b.this.iVO.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String cu = b.this.cu(i2, i3);
                c cVar2 = (c) b.this.iVP.get(cu);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.iVP.put(cu, cVar3);
                    cVar3.key = cu;
                    cVar3.iVK = i2;
                    cVar3.labelId = i3;
                    b.this.iVP.put(cu, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.iVS;
                if (!y.isEmpty(threadList)) {
                    if (b.this.iVS == 0) {
                        if (y.isEmpty(cVar.iVL)) {
                            cVar.iVL = threadList;
                        } else {
                            i = cVar.di(threadList);
                        }
                    } else {
                        cVar.iVL.addAll(threadList);
                    }
                }
                if (b.this.iVG != null) {
                    b.this.iVG.a(b.this.iVQ, b.this.iVR, cVar.iVL, b.this.iVO, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> iVP = new HashMap<>();
    private a iVT = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.gkl = str;
        this.iVT.a(this.iVU);
        registerListeners();
        bOG();
    }

    private void registerListeners() {
        this.iVV.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.iVV);
    }

    private static void bOG() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FRS_GAME_STRATEGY, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003362, com.baidu.tieba.tbadkCore.a.a.bL(Config.FRS_GAME_STRATEGY, CmdConfigSocket.CMD_FRS_GAME_STRATEGY));
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
        this.iVQ = i;
        this.iVR = i2;
        if (i == 0 && i2 == 0) {
            this.iVT.KA(String.valueOf(this.mFid));
        } else {
            String cu = cu(i, i2);
            c cVar = this.iVP.get(cu);
            if (cVar == null) {
                cVar = new c();
                this.iVP.put(cu, cVar);
            }
            cVar.key = cu;
            cVar.iVK = this.iVQ;
            cVar.labelId = this.iVR;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.iVS = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.iVS, this.iVQ, this.iVR);
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
        this.iVQ = i;
        if (i == 0 && i2 == 0) {
            e zD = zD(i);
            if (zD != null && (zD.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) zD.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.iVR = aVar.labelId;
                }
            }
        } else {
            this.iVR = i2;
        }
        String cu = cu(i, i2);
        c cVar = this.iVP.get(cu);
        if (cVar == null) {
            cVar = new c();
            this.iVP.put(cu, cVar);
            cVar.key = cu;
            cVar.iVK = this.iVR;
            cVar.labelId = this.iVQ;
            cVar.hasMore = true;
            this.iVP.put(cu, cVar);
        }
        this.iVS = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.iVS, this.iVQ, this.iVR);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.iVG = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean ct(int i, int i2) {
        c cv = cv(i, i2);
        if (cv == null || y.isEmpty(cv.iVL)) {
            return false;
        }
        if (this.iVG != null) {
            this.iVG.a(i, i2, cv.iVL, this.iVO, cv.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e zC(int i) {
        if (y.isEmpty(this.iVO)) {
            return null;
        }
        for (e eVar : this.iVO) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e zD(int i) {
        if (y.isEmpty(this.iVO)) {
            return null;
        }
        for (e eVar : this.iVO) {
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
        return this.iVP.get(cu(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
