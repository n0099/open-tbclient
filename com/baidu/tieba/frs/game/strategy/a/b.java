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
    private String gsb;
    private com.baidu.tieba.frs.game.strategy.tab.b jjR;
    private List<e> jjZ;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int jkb = 0;
    private int jkc = 0;
    private int jkd = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0744a jkf = new a.InterfaceC0744a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0744a
        public void c(List<e> list, List<q> list2, boolean z) {
            if (b.this.jjZ != null && b.this.jjR != null) {
                b.this.jjR.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a jkg = new com.baidu.adp.framework.listener.a(1003362, CmdConfigSocket.CMD_FRS_GAME_STRATEGY) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.jjR != null) {
                        b.this.jjR.m(b.this.jkb, b.this.jkc, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.jjZ == null) {
                        b.this.jjZ = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.jjZ == null) {
                        b.this.jjZ = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.jkb;
                int i3 = b.this.jkc;
                if (b.this.jkb == 0 && b.this.jkc == 0 && !y.isEmpty(b.this.jjZ) && (eVar = (e) b.this.jjZ.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String cz = b.this.cz(i2, i3);
                c cVar2 = (c) b.this.jka.get(cz);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.jka.put(cz, cVar3);
                    cVar3.key = cz;
                    cVar3.jjV = i2;
                    cVar3.labelId = i3;
                    b.this.jka.put(cz, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.jkd;
                if (!y.isEmpty(threadList)) {
                    if (b.this.jkd == 0) {
                        if (y.isEmpty(cVar.jjW)) {
                            cVar.jjW = threadList;
                        } else {
                            i = cVar.dr(threadList);
                        }
                    } else {
                        cVar.jjW.addAll(threadList);
                    }
                }
                if (b.this.jjR != null) {
                    b.this.jjR.a(b.this.jkb, b.this.jkc, cVar.jjW, b.this.jjZ, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> jka = new HashMap<>();
    private a jke = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.gsb = str;
        this.jke.a(this.jkf);
        registerListeners();
        bRK();
    }

    private void registerListeners() {
        this.jkg.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.jkg);
    }

    private static void bRK() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FRS_GAME_STRATEGY, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003362, com.baidu.tieba.tbadkCore.a.a.bN(Config.FRS_GAME_STRATEGY, CmdConfigSocket.CMD_FRS_GAME_STRATEGY));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void cw(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.cw(i, i2);
                }
            }, 1000L);
            return;
        }
        this.jkb = i;
        this.jkc = i2;
        if (i == 0 && i2 == 0) {
            this.jke.Lh(String.valueOf(this.mFid));
        } else {
            String cz = cz(i, i2);
            c cVar = this.jka.get(cz);
            if (cVar == null) {
                cVar = new c();
                this.jka.put(cz, cVar);
            }
            cVar.key = cz;
            cVar.jjV = this.jkb;
            cVar.labelId = this.jkc;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.jkd = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.jkd, this.jkb, this.jkc);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void cx(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.cx(i, i2);
                }
            }, 1000L);
            return;
        }
        this.jkb = i;
        if (i == 0 && i2 == 0) {
            e AP = AP(i);
            if (AP != null && (AP.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) AP.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.jkc = aVar.labelId;
                }
            }
        } else {
            this.jkc = i2;
        }
        String cz = cz(i, i2);
        c cVar = this.jka.get(cz);
        if (cVar == null) {
            cVar = new c();
            this.jka.put(cz, cVar);
            cVar.key = cz;
            cVar.jjV = this.jkc;
            cVar.labelId = this.jkb;
            cVar.hasMore = true;
            this.jka.put(cz, cVar);
        }
        this.jkd = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.jkd, this.jkb, this.jkc);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.jjR = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean cy(int i, int i2) {
        c cA = cA(i, i2);
        if (cA == null || y.isEmpty(cA.jjW)) {
            return false;
        }
        if (this.jjR != null) {
            this.jjR.a(i, i2, cA.jjW, this.jjZ, cA.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e AO(int i) {
        if (y.isEmpty(this.jjZ)) {
            return null;
        }
        for (e eVar : this.jjZ) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e AP(int i) {
        if (y.isEmpty(this.jjZ)) {
            return null;
        }
        for (e eVar : this.jjZ) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cz(int i, int i2) {
        return i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i2;
    }

    public c cA(int i, int i2) {
        return this.jka.get(cz(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
