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
/* loaded from: classes4.dex */
public class b implements com.baidu.tieba.frs.game.strategy.tab.a {
    private String fGR;
    private com.baidu.tieba.frs.game.strategy.tab.b fGU;
    private List<e> fHc;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int fHe = 0;
    private int fHf = 0;
    private int fHg = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0411a fHi = new a.InterfaceC0411a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0411a
        public void b(List<e> list, List<m> list2, boolean z) {
            if (b.this.fHc != null && b.this.fGU != null) {
                b.this.fGU.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fHj = new com.baidu.adp.framework.listener.a(1003362, CmdConfigSocket.CMD_FRS_GAME_STRATEGY) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.fGU != null) {
                        b.this.fGU.f(b.this.fHe, b.this.fHf, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.fHc == null) {
                        b.this.fHc = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.fHc == null) {
                        b.this.fHc = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.fHe;
                int i3 = b.this.fHf;
                if (b.this.fHe == 0 && b.this.fHf == 0 && !v.isEmpty(b.this.fHc) && (eVar = (e) b.this.fHc.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String bu = b.this.bu(i2, i3);
                c cVar2 = (c) b.this.fHd.get(bu);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.fHd.put(bu, cVar3);
                    cVar3.key = bu;
                    cVar3.fGY = i2;
                    cVar3.labelId = i3;
                    b.this.fHd.put(bu, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.fHg;
                if (!v.isEmpty(threadList)) {
                    if (b.this.fHg == 0) {
                        if (v.isEmpty(cVar.fGZ)) {
                            cVar.fGZ = threadList;
                        } else {
                            i = cVar.cp(threadList);
                        }
                    } else {
                        cVar.fGZ.addAll(threadList);
                    }
                }
                if (b.this.fGU != null) {
                    b.this.fGU.a(b.this.fHe, b.this.fHf, cVar.fGZ, b.this.fHc, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> fHd = new HashMap<>();
    private a fHh = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.fGR = str;
        this.fHh.a(this.fHi);
        registerListeners();
        aIU();
    }

    private void registerListeners() {
        this.fHj.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.fHj);
    }

    private static void aIU() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FRS_GAME_STRATEGY, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003362, com.baidu.tieba.tbadkCore.a.a.bl(Config.FRS_GAME_STRATEGY, CmdConfigSocket.CMD_FRS_GAME_STRATEGY));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void br(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.br(i, i2);
                }
            }, 1000L);
            return;
        }
        this.fHe = i;
        this.fHf = i2;
        if (i == 0 && i2 == 0) {
            this.fHh.vY(String.valueOf(this.mFid));
        } else {
            String bu = bu(i, i2);
            c cVar = this.fHd.get(bu);
            if (cVar == null) {
                cVar = new c();
                this.fHd.put(bu, cVar);
            }
            cVar.key = bu;
            cVar.fGY = this.fHe;
            cVar.labelId = this.fHf;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.fHg = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.fHg, this.fHe, this.fHf);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void bs(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.bs(i, i2);
                }
            }, 1000L);
            return;
        }
        this.fHe = i;
        if (i == 0 && i2 == 0) {
            e rb = rb(i);
            if (rb != null && (rb.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) rb.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.fHf = aVar.labelId;
                }
            }
        } else {
            this.fHf = i2;
        }
        String bu = bu(i, i2);
        c cVar = this.fHd.get(bu);
        if (cVar == null) {
            cVar = new c();
            this.fHd.put(bu, cVar);
            cVar.key = bu;
            cVar.fGY = this.fHf;
            cVar.labelId = this.fHe;
            cVar.hasMore = true;
            this.fHd.put(bu, cVar);
        }
        this.fHg = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.fHg, this.fHe, this.fHf);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.fGU = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean bt(int i, int i2) {
        c bv = bv(i, i2);
        if (bv == null || v.isEmpty(bv.fGZ)) {
            return false;
        }
        if (this.fGU != null) {
            this.fGU.a(i, i2, bv.fGZ, this.fHc, bv.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e ra(int i) {
        if (v.isEmpty(this.fHc)) {
            return null;
        }
        for (e eVar : this.fHc) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e rb(int i) {
        if (v.isEmpty(this.fHc)) {
            return null;
        }
        for (e eVar : this.fHc) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bu(int i, int i2) {
        return i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i2;
    }

    public c bv(int i, int i2) {
        return this.fHd.get(bu(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
