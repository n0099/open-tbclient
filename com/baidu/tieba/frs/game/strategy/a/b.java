package com.baidu.tieba.frs.game.strategy.a;

import android.content.Context;
import android.os.Handler;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.n;
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
/* loaded from: classes2.dex */
public class b implements com.baidu.tieba.frs.game.strategy.tab.a {
    private String gDc;
    private com.baidu.tieba.frs.game.strategy.tab.b jzp;
    private List<e> jzx;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int jzz = 0;
    private int jzA = 0;
    private int jzB = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0734a jzD = new a.InterfaceC0734a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0734a
        public void d(List<e> list, List<n> list2, boolean z) {
            if (b.this.jzx != null && b.this.jzp != null) {
                b.this.jzp.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a jzE = new com.baidu.adp.framework.listener.a(1003362, CmdConfigSocket.CMD_FRS_GAME_STRATEGY) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<n> threadList;
            boolean hasMore;
            c cVar;
            e eVar;
            com.baidu.tieba.frs.game.strategy.data.a aVar;
            int i = -1;
            if (responsedMessage != null) {
                b.this.mIsLoading = false;
                if (responsedMessage.hasError()) {
                    if (b.this.jzp != null) {
                        b.this.jzp.m(b.this.jzz, b.this.jzA, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.jzx == null) {
                        b.this.jzx = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.jzx == null) {
                        b.this.jzx = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.jzz;
                int i3 = b.this.jzA;
                if (b.this.jzz == 0 && b.this.jzA == 0 && !y.isEmpty(b.this.jzx) && (eVar = (e) b.this.jzx.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String cu = b.this.cu(i2, i3);
                c cVar2 = (c) b.this.jzy.get(cu);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.jzy.put(cu, cVar3);
                    cVar3.key = cu;
                    cVar3.jzt = i2;
                    cVar3.labelId = i3;
                    b.this.jzy.put(cu, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.jzB;
                if (!y.isEmpty(threadList)) {
                    if (b.this.jzB == 0) {
                        if (y.isEmpty(cVar.jzu)) {
                            cVar.jzu = threadList;
                        } else {
                            i = cVar.du(threadList);
                        }
                    } else {
                        cVar.jzu.addAll(threadList);
                    }
                }
                if (b.this.jzp != null) {
                    b.this.jzp.a(b.this.jzz, b.this.jzA, cVar.jzu, b.this.jzx, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> jzy = new HashMap<>();
    private a jzC = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.gDc = str;
        this.jzC.a(this.jzD);
        registerListeners();
        bRn();
    }

    private void registerListeners() {
        this.jzE.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.jzE);
    }

    private static void bRn() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FRS_GAME_STRATEGY, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003362, com.baidu.tieba.tbadkCore.a.a.bV(Config.FRS_GAME_STRATEGY, CmdConfigSocket.CMD_FRS_GAME_STRATEGY));
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
        this.jzz = i;
        this.jzA = i2;
        if (i == 0 && i2 == 0) {
            this.jzC.KR(String.valueOf(this.mFid));
        } else {
            String cu = cu(i, i2);
            c cVar = this.jzy.get(cu);
            if (cVar == null) {
                cVar = new c();
                this.jzy.put(cu, cVar);
            }
            cVar.key = cu;
            cVar.jzt = this.jzz;
            cVar.labelId = this.jzA;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.jzB = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.jzB, this.jzz, this.jzA);
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
        this.jzz = i;
        if (i == 0 && i2 == 0) {
            e zG = zG(i);
            if (zG != null && (zG.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) zG.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.jzA = aVar.labelId;
                }
            }
        } else {
            this.jzA = i2;
        }
        String cu = cu(i, i2);
        c cVar = this.jzy.get(cu);
        if (cVar == null) {
            cVar = new c();
            this.jzy.put(cu, cVar);
            cVar.key = cu;
            cVar.jzt = this.jzA;
            cVar.labelId = this.jzz;
            cVar.hasMore = true;
            this.jzy.put(cu, cVar);
        }
        this.jzB = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.jzB, this.jzz, this.jzA);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.jzp = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean ct(int i, int i2) {
        c cv = cv(i, i2);
        if (cv == null || y.isEmpty(cv.jzu)) {
            return false;
        }
        if (this.jzp != null) {
            this.jzp.a(i, i2, cv.jzu, this.jzx, cv.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e zF(int i) {
        if (y.isEmpty(this.jzx)) {
            return null;
        }
        for (e eVar : this.jzx) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e zG(int i) {
        if (y.isEmpty(this.jzx)) {
            return null;
        }
        for (e eVar : this.jzx) {
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
        return this.jzy.get(cu(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
