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
    private String fjF;
    private com.baidu.tieba.frs.game.strategy.tab.b fjI;
    private List<e> fjQ;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int dag = 0;
    private int fjS = 0;
    private int fjT = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0290a fjV = new a.InterfaceC0290a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0290a
        public void e(List<e> list, List<m> list2, boolean z) {
            if (b.this.fjQ != null && b.this.fjI != null) {
                b.this.fjI.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fjW = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.fjI != null) {
                        b.this.fjI.e(b.this.dag, b.this.fjS, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.fjQ == null) {
                        b.this.fjQ = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.fjQ == null) {
                        b.this.fjQ = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.dag;
                int i3 = b.this.fjS;
                if (b.this.dag == 0 && b.this.fjS == 0 && !v.T(b.this.fjQ) && (eVar = (e) b.this.fjQ.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String bm = b.this.bm(i2, i3);
                c cVar2 = (c) b.this.fjR.get(bm);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.fjR.put(bm, cVar3);
                    cVar3.key = bm;
                    cVar3.fjM = i2;
                    cVar3.labelId = i3;
                    b.this.fjR.put(bm, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.fjT;
                if (!v.T(threadList)) {
                    if (b.this.fjT == 0) {
                        if (v.T(cVar.fjN)) {
                            cVar.fjN = threadList;
                        } else {
                            i = cVar.bU(threadList);
                        }
                    } else {
                        cVar.fjN.addAll(threadList);
                    }
                }
                if (b.this.fjI != null) {
                    b.this.fjI.a(b.this.dag, b.this.fjS, cVar.fjN, b.this.fjQ, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> fjR = new HashMap<>();
    private a fjU = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.fjF = str;
        this.fjU.a(this.fjV);
        Ua();
        aAX();
    }

    private void Ua() {
        this.fjW.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.fjW);
    }

    private static void aAX() {
        com.baidu.tieba.tbadkCore.a.a.a(309478, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, com.baidu.tieba.tbadkCore.a.a.br("c/f/game/gameForumGuideTab", 309478));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void bj(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.bj(i, i2);
                }
            }, 1000L);
            return;
        }
        this.dag = i;
        this.fjS = i2;
        if (i == 0 && i2 == 0) {
            this.fjU.vi(String.valueOf(this.mFid));
        } else {
            String bm = bm(i, i2);
            c cVar = this.fjR.get(bm);
            if (cVar == null) {
                cVar = new c();
                this.fjR.put(bm, cVar);
            }
            cVar.key = bm;
            cVar.fjM = this.dag;
            cVar.labelId = this.fjS;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.fjT = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.fjT, this.dag, this.fjS);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void bk(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.bk(i, i2);
                }
            }, 1000L);
            return;
        }
        this.dag = i;
        if (i == 0 && i2 == 0) {
            e qC = qC(i);
            if (qC != null && (qC.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) qC.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.fjS = aVar.labelId;
                }
            }
        } else {
            this.fjS = i2;
        }
        String bm = bm(i, i2);
        c cVar = this.fjR.get(bm);
        if (cVar == null) {
            cVar = new c();
            this.fjR.put(bm, cVar);
            cVar.key = bm;
            cVar.fjM = this.fjS;
            cVar.labelId = this.dag;
            cVar.hasMore = true;
            this.fjR.put(bm, cVar);
        }
        this.fjT = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.fjT, this.dag, this.fjS);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.fjI = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean bl(int i, int i2) {
        c bn = bn(i, i2);
        if (bn == null || v.T(bn.fjN)) {
            return false;
        }
        if (this.fjI != null) {
            this.fjI.a(i, i2, bn.fjN, this.fjQ, bn.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e qB(int i) {
        if (v.T(this.fjQ)) {
            return null;
        }
        for (e eVar : this.fjQ) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e qC(int i) {
        if (v.T(this.fjQ)) {
            return null;
        }
        for (e eVar : this.fjQ) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bm(int i, int i2) {
        return i + "_" + i2;
    }

    public c bn(int i, int i2) {
        return this.fjR.get(bm(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
