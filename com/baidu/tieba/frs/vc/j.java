package com.baidu.tieba.frs.vc;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.y;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class j extends com.baidu.tieba.frs.mc.j {
    private boolean hMk;
    private HashMap<Integer, y> hMl;
    private final CustomMessageListener hMm;
    private final CustomMessageListener hMn;
    private final CustomMessageListener hMo;
    private final CustomMessageListener hMp;
    private an hMq;
    private com.baidu.tieba.frs.smartsort.a hnC;

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.hMk = false;
        this.hMm = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.vc.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && j.this.hni != null) {
                    j.this.hni.startPullRefresh();
                }
            }
        };
        this.hMn = new CustomMessageListener(2921448) { // from class: com.baidu.tieba.frs.vc.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof y)) {
                    j.this.hni.bqV();
                    y yVar = (y) customResponsedMessage.getData();
                    if (yVar.hqH != null) {
                        j.this.a(yVar.tabId, yVar.hqH);
                    } else if (yVar.tabId == 1) {
                        j.this.a(yVar.tabId, j.this.hMq);
                    } else {
                        j.this.a(yVar.tabId, (an) null);
                    }
                    j.this.vy(yVar.tabId);
                }
            }
        };
        this.hMo = new CustomMessageListener(9205410) { // from class: com.baidu.tieba.frs.vc.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof y)) {
                    y yVar = (y) customResponsedMessage.getData();
                    j.this.N(yVar.tabId, yVar.dVd);
                }
            }
        };
        this.hMp = new CustomMessageListener(2921449) { // from class: com.baidu.tieba.frs.vc.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof s)) {
                    s sVar = (s) customResponsedMessage.getData();
                    j.this.O(sVar.tabId, sVar.eIo);
                }
            }
        };
        this.hMq = new an() { // from class: com.baidu.tieba.frs.vc.j.5
            @Override // com.baidu.tieba.frs.an
            public void aWo() {
                j.this.hMk = true;
                if (j.this.hni != null && j.this.hHq != null && j.this.hnz != null && j.this.hGd != null && j.this.hGd.isAdded()) {
                    if (j.this.hni != null && j.this.hni.bVQ() != null) {
                        j.this.hni.bVQ().cfz();
                    }
                    j.this.hGd.mM(false);
                    com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.j.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.hni.bVH() != null && j.this.hHq != null && j.this.hni.bVH().getVisibility() != 0) {
                                j.this.hHq.bgJ();
                            }
                        }
                    }, 110L);
                    j.this.hni.K(1, true);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        j.this.hGd.refresh();
                        j.this.hGd.mM(true);
                    } else {
                        j.this.hGd.bUU();
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11749").dh("fid", j.this.hGd.getFid()).dh("obj_locate", "1"));
                }
            }

            @Override // com.baidu.tieba.frs.an
            public void aWp() {
                if (j.this.hGd != null && j.this.hGd.isAdded()) {
                    if (j.this.hMk && j.this.hGd.bUP() != null) {
                        j.this.hGd.bUP().ccp();
                        j.this.hMk = false;
                    }
                    if (j.this.hnC != null && j.this.hGd.bUR() != null && j.this.hGd.bUR().bVS() != null && !j.this.hGd.bUR().bVS().cbE()) {
                        j.this.hnC.caM();
                    }
                    if (j.this.hni != null && j.this.hHq != null && j.this.hnz != null && j.this.hnC != null) {
                        j.this.hni.bVQ().a(0, 0, true, true);
                        j.this.hGd.bVf();
                        j.this.hGd.mM(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (j.this.hGd.bUR() != null) {
                            j.this.hGd.bUR().K(1, false);
                        }
                        if (!TbadkCoreApplication.isLogin() || j.this.hGd.aWN().getVisibility() != 0 || v.isEmpty(j.this.hGd.bVs().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.hnC = frsFragment.bUL();
        this.hMl = new HashMap<>();
        this.hni.tW(1);
        frsFragment.registerListener(this.hMm);
        frsFragment.registerListener(this.hMn);
        frsFragment.registerListener(this.hMo);
        frsFragment.registerListener(this.hMp);
    }

    public void ccb() {
        if (this.hni != null) {
            this.hni.a(this.hMq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vy(int i) {
        y yVar;
        if (this.hni != null && (yVar = this.hMl.get(Integer.valueOf(i))) != null) {
            this.hni.tW(i);
            this.hni.a(yVar.hqH);
            this.hni.mV(yVar.dVd);
            if (yVar.hqH == null) {
                this.hni.mV(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, an anVar) {
        y yVar = this.hMl.get(Integer.valueOf(i));
        if (yVar == null) {
            y yVar2 = new y();
            yVar2.tabId = i;
            yVar2.hqH = anVar;
            this.hMl.put(Integer.valueOf(i), yVar2);
        } else {
            yVar.hqH = anVar;
        }
        if (this.hni != null) {
            this.hni.a(anVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(int i, boolean z) {
        y yVar = this.hMl.get(Integer.valueOf(i));
        if (yVar == null) {
            y yVar2 = new y();
            yVar2.tabId = i;
            yVar2.dVd = z;
            this.hMl.put(Integer.valueOf(i), yVar2);
        } else {
            yVar.dVd = z;
        }
        if (this.hni != null) {
            this.hni.mV(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(int i, boolean z) {
        if (this.hni != null) {
            this.hni.K(i, z);
        }
    }
}
