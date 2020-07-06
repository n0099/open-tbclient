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
/* loaded from: classes9.dex */
public class b implements com.baidu.tieba.frs.game.strategy.tab.a {
    private String foo;
    private com.baidu.tieba.frs.game.strategy.tab.b hNd;
    private List<e> hNl;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int hNn = 0;
    private int hNo = 0;
    private int hNp = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0621a hNr = new a.InterfaceC0621a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0621a
        public void b(List<e> list, List<q> list2, boolean z) {
            if (b.this.hNl != null && b.this.hNd != null) {
                b.this.hNd.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a hNs = new com.baidu.adp.framework.listener.a(1003362, CmdConfigSocket.CMD_FRS_GAME_STRATEGY) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.hNd != null) {
                        b.this.hNd.j(b.this.hNn, b.this.hNo, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.hNl == null) {
                        b.this.hNl = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.hNl == null) {
                        b.this.hNl = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.hNn;
                int i3 = b.this.hNo;
                if (b.this.hNn == 0 && b.this.hNo == 0 && !w.isEmpty(b.this.hNl) && (eVar = (e) b.this.hNl.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String cc = b.this.cc(i2, i3);
                c cVar2 = (c) b.this.hNm.get(cc);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.hNm.put(cc, cVar3);
                    cVar3.key = cc;
                    cVar3.hNh = i2;
                    cVar3.labelId = i3;
                    b.this.hNm.put(cc, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.hNp;
                if (!w.isEmpty(threadList)) {
                    if (b.this.hNp == 0) {
                        if (w.isEmpty(cVar.hNi)) {
                            cVar.hNi = threadList;
                        } else {
                            i = cVar.cB(threadList);
                        }
                    } else {
                        cVar.hNi.addAll(threadList);
                    }
                }
                if (b.this.hNd != null) {
                    b.this.hNd.a(b.this.hNn, b.this.hNo, cVar.hNi, b.this.hNl, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> hNm = new HashMap<>();
    private a hNq = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.foo = str;
        this.hNq.a(this.hNr);
        registerListeners();
        btt();
    }

    private void registerListeners() {
        this.hNs.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.hNs);
    }

    private static void btt() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FRS_GAME_STRATEGY, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003362, com.baidu.tieba.tbadkCore.a.a.bE(Config.FRS_GAME_STRATEGY, CmdConfigSocket.CMD_FRS_GAME_STRATEGY));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void bZ(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.bZ(i, i2);
                }
            }, 1000L);
            return;
        }
        this.hNn = i;
        this.hNo = i2;
        if (i == 0 && i2 == 0) {
            this.hNq.Fl(String.valueOf(this.mFid));
        } else {
            String cc = cc(i, i2);
            c cVar = this.hNm.get(cc);
            if (cVar == null) {
                cVar = new c();
                this.hNm.put(cc, cVar);
            }
            cVar.key = cc;
            cVar.hNh = this.hNn;
            cVar.labelId = this.hNo;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.hNp = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.hNp, this.hNn, this.hNo);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void ca(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.ca(i, i2);
                }
            }, 1000L);
            return;
        }
        this.hNn = i;
        if (i == 0 && i2 == 0) {
            e vh = vh(i);
            if (vh != null && (vh.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) vh.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.hNo = aVar.labelId;
                }
            }
        } else {
            this.hNo = i2;
        }
        String cc = cc(i, i2);
        c cVar = this.hNm.get(cc);
        if (cVar == null) {
            cVar = new c();
            this.hNm.put(cc, cVar);
            cVar.key = cc;
            cVar.hNh = this.hNo;
            cVar.labelId = this.hNn;
            cVar.hasMore = true;
            this.hNm.put(cc, cVar);
        }
        this.hNp = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.hNp, this.hNn, this.hNo);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.hNd = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean cb(int i, int i2) {
        c cd = cd(i, i2);
        if (cd == null || w.isEmpty(cd.hNi)) {
            return false;
        }
        if (this.hNd != null) {
            this.hNd.a(i, i2, cd.hNi, this.hNl, cd.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e vg(int i) {
        if (w.isEmpty(this.hNl)) {
            return null;
        }
        for (e eVar : this.hNl) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e vh(int i) {
        if (w.isEmpty(this.hNl)) {
            return null;
        }
        for (e eVar : this.hNl) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cc(int i, int i2) {
        return i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i2;
    }

    public c cd(int i, int i2) {
        return this.hNm.get(cc(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
