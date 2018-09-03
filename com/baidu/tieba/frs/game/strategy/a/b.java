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
    private String dwC;
    private com.baidu.tieba.frs.game.strategy.tab.b dwF;
    private List<e> dwN;
    private Context mContext;
    private long mFid;
    private BdUniqueId mPageId;
    private int bup = 0;
    private int dwP = 0;
    private int dwQ = 0;
    private boolean mIsLoading = false;
    private Handler mHandler = new Handler();
    private a.InterfaceC0152a dwS = new a.InterfaceC0152a() { // from class: com.baidu.tieba.frs.game.strategy.a.b.1
        @Override // com.baidu.tieba.frs.game.strategy.a.a.InterfaceC0152a
        public void e(List<e> list, List<h> list2, boolean z) {
            if (b.this.dwN != null && b.this.dwF != null) {
                b.this.dwF.a(0, 0, list2, list, z, true, -1);
            }
        }
    };
    private com.baidu.adp.framework.listener.a dwT = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478) { // from class: com.baidu.tieba.frs.game.strategy.a.b.2
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
                    if (b.this.dwF != null) {
                        b.this.dwF.c(b.this.bup, b.this.dwP, responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                    FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                    if (b.this.dwN == null) {
                        b.this.dwN = frsGameStrategySocketResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategySocketResponseMessage.getThreadList();
                    hasMore = frsGameStrategySocketResponseMessage.hasMore();
                } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                    FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                    if (b.this.dwN == null) {
                        b.this.dwN = frsGameStrategyHttpResponseMessage.getTabList();
                    }
                    threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                    hasMore = frsGameStrategyHttpResponseMessage.hasMore();
                } else {
                    return;
                }
                int i2 = b.this.bup;
                int i3 = b.this.dwP;
                if (b.this.bup == 0 && b.this.dwP == 0 && !w.z(b.this.dwN) && (eVar = (e) b.this.dwN.get(0)) != null) {
                    i2 = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            i3 = aVar.labelId;
                        }
                    }
                }
                String aI = b.this.aI(i2, i3);
                c cVar2 = (c) b.this.dwO.get(aI);
                if (cVar2 == null) {
                    c cVar3 = new c();
                    b.this.dwO.put(aI, cVar3);
                    cVar3.key = aI;
                    cVar3.dwJ = i2;
                    cVar3.labelId = i3;
                    b.this.dwO.put(aI, cVar3);
                    cVar = cVar3;
                } else {
                    cVar = cVar2;
                }
                cVar.hasMore = hasMore;
                cVar.pn = b.this.dwQ;
                if (!w.z(threadList)) {
                    if (b.this.dwQ == 0) {
                        if (w.z(cVar.dwK)) {
                            cVar.dwK = threadList;
                        } else {
                            i = cVar.bq(threadList);
                        }
                    } else {
                        cVar.dwK.addAll(threadList);
                    }
                }
                if (b.this.dwF != null) {
                    b.this.dwF.a(b.this.bup, b.this.dwP, cVar.dwK, b.this.dwN, cVar.hasMore, false, i);
                }
            }
        }
    };
    private final HashMap<String, c> dwO = new HashMap<>();
    private a dwR = new a();

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        this.mFid = 0L;
        this.mContext = context;
        this.mPageId = bdUniqueId;
        this.mFid = j;
        this.dwC = str;
        this.dwR.a(this.dwS);
        auW();
        To();
    }

    private void auW() {
        this.dwT.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.dwT);
    }

    private static void To() {
        com.baidu.tieba.tbadkCore.a.a.a(309478, FrsGameStrategySocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, com.baidu.tieba.tbadkCore.a.a.aK("c/f/game/gameForumGuideTab", 309478));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void aF(final int i, final int i2) {
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aF(i, i2);
                }
            }, 1000L);
            return;
        }
        this.bup = i;
        this.dwP = i2;
        if (i == 0 && i2 == 0) {
            this.dwR.mG(String.valueOf(this.mFid));
        } else {
            String aI = aI(i, i2);
            c cVar = this.dwO.get(aI);
            if (cVar == null) {
                cVar = new c();
                this.dwO.put(aI, cVar);
            }
            cVar.key = aI;
            cVar.dwJ = this.bup;
            cVar.labelId = this.dwP;
            cVar.pn = 0;
            cVar.hasMore = true;
        }
        this.dwQ = 0;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.dwQ, this.bup, this.dwP);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public void aG(final int i, final int i2) {
        com.baidu.tieba.frs.game.strategy.data.a aVar;
        if (this.mIsLoading) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.a.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aG(i, i2);
                }
            }, 1000L);
            return;
        }
        this.bup = i;
        if (i == 0 && i2 == 0) {
            e kX = kX(i);
            if (kX != null && (kX.extra instanceof LabelDataList)) {
                LabelDataList labelDataList = (LabelDataList) kX.extra;
                if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                    this.dwP = aVar.labelId;
                }
            }
        } else {
            this.dwP = i2;
        }
        String aI = aI(i, i2);
        c cVar = this.dwO.get(aI);
        if (cVar == null) {
            cVar = new c();
            this.dwO.put(aI, cVar);
            cVar.key = aI;
            cVar.dwJ = this.dwP;
            cVar.labelId = this.bup;
            cVar.hasMore = true;
            this.dwO.put(aI, cVar);
        }
        this.dwQ = cVar.pn + 1;
        FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.mFid, this.dwQ, this.bup, this.dwP);
        frsGameStrategyRequestMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
        this.mIsLoading = true;
    }

    public void a(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.dwF = bVar;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public boolean aH(int i, int i2) {
        c aJ = aJ(i, i2);
        if (aJ == null || w.z(aJ.dwK)) {
            return false;
        }
        if (this.dwF != null) {
            this.dwF.a(i, i2, aJ.dwK, this.dwN, aJ.hasMore, false, -1);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public String getForumId() {
        return String.valueOf(this.mFid);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.a
    public e kW(int i) {
        if (w.z(this.dwN)) {
            return null;
        }
        for (e eVar : this.dwN) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    private e kX(int i) {
        if (w.z(this.dwN)) {
            return null;
        }
        for (e eVar : this.dwN) {
            if (eVar != null && eVar.tabId == i) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aI(int i, int i2) {
        return i + "_" + i2;
    }

    public c aJ(int i, int i2) {
        return this.dwO.get(aI(i, i2));
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
