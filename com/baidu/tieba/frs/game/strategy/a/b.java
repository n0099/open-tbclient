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
    private String fGa;
    private com.baidu.tieba.frs.game.strategy.tab.b fGd;
    private List<e> fGl;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int fGn = 0;
    private int fGo = 0;
    private int fGp = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0411a fGr = new a.InterfaceC0411a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0411a
        public void b(List<e> list, List<m> list2, boolean z) {
            if (b.this.fGl != null && b.this.fGd != null) {
                b.this.fGd.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fGs = new com.baidu.adp.framework.listener.a(1003362, CmdConfigSocket.CMD_FRS_GAME_STRATEGY) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.fGd != null) {
                        b.this.fGd.f(b.this.fGn, b.this.fGo, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.fGl == null) {
                        b.this.fGl = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.fGl == null) {
                        b.this.fGl = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.fGn;
                int i3 = b.this.fGo;
                if (b.this.fGn == 0 && b.this.fGo == 0 && !v.isEmpty(b.this.fGl) && (eVar = (e) b.this.fGl.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String bs = b.this.bs(i2, i3);
                c cVar2 = (c) b.this.fGm.get(bs);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.fGm.put(bs, cVar3);
                    cVar3.key = bs;
                    cVar3.fGh = i2;
                    cVar3.labelId = i3;
                    b.this.fGm.put(bs, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.fGp;
                if (!v.isEmpty(threadList)) {
                    if (b.this.fGp == 0) {
                        if (v.isEmpty(cVar.fGi)) {
                            cVar.fGi = threadList;
                        } else {
                            i = cVar.cp(threadList);
                        }
                    } else {
                        cVar.fGi.addAll(threadList);
                    }
                }
                if (b.this.fGd != null) {
                    b.this.fGd.a(b.this.fGn, b.this.fGo, cVar.fGi, b.this.fGl, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> fGm = new HashMap<>();
    private a fGq = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.fGa = str;
        this.fGq.a(this.fGr);
        registerListeners();
        aIS();
    }

    private void registerListeners() {
        this.fGs.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.fGs);
    }

    private static void aIS() {
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
    public void bp(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.bp(i, i2);
                }
            }, 1000L);
            return;
        }
        this.fGn = i;
        this.fGo = i2;
        if (i == 0 && i2 == 0) {
            this.fGq.vY(String.valueOf(this.mFid));
        } else {
            String bs = bs(i, i2);
            c cVar = this.fGm.get(bs);
            if (cVar == null) {
                cVar = new c();
                this.fGm.put(bs, cVar);
            }
            cVar.key = bs;
            cVar.fGh = this.fGn;
            cVar.labelId = this.fGo;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.fGp = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.fGp, this.fGn, this.fGo);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void bq(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.bq(i, i2);
                }
            }, 1000L);
            return;
        }
        this.fGn = i;
        if (i == 0 && i2 == 0) {
            e ra = ra(i);
            if (ra != null && (ra.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) ra.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.fGo = aVar.labelId;
                }
            }
        } else {
            this.fGo = i2;
        }
        String bs = bs(i, i2);
        c cVar = this.fGm.get(bs);
        if (cVar == null) {
            cVar = new c();
            this.fGm.put(bs, cVar);
            cVar.key = bs;
            cVar.fGh = this.fGo;
            cVar.labelId = this.fGn;
            cVar.hasMore = true;
            this.fGm.put(bs, cVar);
        }
        this.fGp = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.fGp, this.fGn, this.fGo);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.fGd = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean br(int i, int i2) {
        c bt = bt(i, i2);
        if (bt == null || v.isEmpty(bt.fGi)) {
            return false;
        }
        if (this.fGd != null) {
            this.fGd.a(i, i2, bt.fGi, this.fGl, bt.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e qZ(int i) {
        if (v.isEmpty(this.fGl)) {
            return null;
        }
        for (e eVar : this.fGl) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e ra(int i) {
        if (v.isEmpty(this.fGl)) {
            return null;
        }
        for (e eVar : this.fGl) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bs(int i, int i2) {
        return i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i2;
    }

    public c bt(int i, int i2) {
        return this.fGm.get(bs(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
