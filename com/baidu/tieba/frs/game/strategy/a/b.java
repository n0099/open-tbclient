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
    private String fEZ;
    private com.baidu.tieba.frs.game.strategy.tab.b fFc;
    private List<e> fFk;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int dmx = 0;
    private int fFm = 0;
    private int fFn = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0305a fFp = new a.InterfaceC0305a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0305a
        public void e(List<e> list, List<m> list2, boolean z) {
            if (b.this.fFk != null && b.this.fFc != null) {
                b.this.fFc.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fFq = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.fFc != null) {
                        b.this.fFc.f(b.this.dmx, b.this.fFm, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.fFk == null) {
                        b.this.fFk = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.fFk == null) {
                        b.this.fFk = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.dmx;
                int i3 = b.this.fFm;
                if (b.this.dmx == 0 && b.this.fFm == 0 && !v.aa(b.this.fFk) && (eVar = (e) b.this.fFk.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.bFL;
                        }
                    }
                }
                String by = b.this.by(i2, i3);
                c cVar2 = (c) b.this.fFl.get(by);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.fFl.put(by, cVar3);
                    cVar3.key = by;
                    cVar3.fFg = i2;
                    cVar3.bFL = i3;
                    b.this.fFl.put(by, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.fFn;
                if (!v.aa(threadList)) {
                    if (b.this.fFn == 0) {
                        if (v.aa(cVar.fFh)) {
                            cVar.fFh = threadList;
                        } else {
                            i = cVar.cd(threadList);
                        }
                    } else {
                        cVar.fFh.addAll(threadList);
                    }
                }
                if (b.this.fFc != null) {
                    b.this.fFc.a(b.this.dmx, b.this.fFm, cVar.fFh, b.this.fFk, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> fFl = new HashMap<>();
    private a fFo = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.fEZ = str;
        this.fFo.a(this.fFp);
        aac();
        aIO();
    }

    private void aac() {
        this.fFq.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.fFq);
    }

    private static void aIO() {
        com.baidu.tieba.tbadkCore.a.a.a(309478, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, com.baidu.tieba.tbadkCore.a.a.bo("c/f/game/gameForumGuideTab", 309478));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void bv(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.bv(i, i2);
                }
            }, 1000L);
            return;
        }
        this.dmx = i;
        this.fFm = i2;
        if (i == 0 && i2 == 0) {
            this.fFo.xg(String.valueOf(this.mFid));
        } else {
            String by = by(i, i2);
            c cVar = this.fFl.get(by);
            if (cVar == null) {
                cVar = new c();
                this.fFl.put(by, cVar);
            }
            cVar.key = by;
            cVar.fFg = this.dmx;
            cVar.bFL = this.fFm;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.fFn = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.fFn, this.dmx, this.fFm);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void bw(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.bw(i, i2);
                }
            }, 1000L);
            return;
        }
        this.dmx = i;
        if (i == 0 && i2 == 0) {
            e sc = sc(i);
            if (sc != null && (sc.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) sc.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.fFm = aVar.bFL;
                }
            }
        } else {
            this.fFm = i2;
        }
        String by = by(i, i2);
        c cVar = this.fFl.get(by);
        if (cVar == null) {
            cVar = new c();
            this.fFl.put(by, cVar);
            cVar.key = by;
            cVar.fFg = this.fFm;
            cVar.bFL = this.dmx;
            cVar.hasMore = true;
            this.fFl.put(by, cVar);
        }
        this.fFn = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.fFn, this.dmx, this.fFm);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.fFc = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean bx(int i, int i2) {
        c bz = bz(i, i2);
        if (bz == null || v.aa(bz.fFh)) {
            return false;
        }
        if (this.fFc != null) {
            this.fFc.a(i, i2, bz.fFh, this.fFk, bz.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e sb(int i) {
        if (v.aa(this.fFk)) {
            return null;
        }
        for (e eVar : this.fFk) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e sc(int i) {
        if (v.aa(this.fFk)) {
            return null;
        }
        for (e eVar : this.fFk) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String by(int i, int i2) {
        return i + "_" + i2;
    }

    public c bz(int i, int i2) {
        return this.fFl.get(by(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
