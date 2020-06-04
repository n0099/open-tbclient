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
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.y;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class j extends com.baidu.tieba.frs.mc.j {
    private boolean hMX;
    private HashMap<Integer, y> hMY;
    private final CustomMessageListener hMZ;
    private final CustomMessageListener hNa;
    private final CustomMessageListener hNb;
    private final CustomMessageListener hNc;
    private an hNd;
    private com.baidu.tieba.frs.smartsort.a hnN;

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.hMX = false;
        this.hMZ = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.vc.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && j.this.hnt != null) {
                    j.this.hnt.startPullRefresh();
                }
            }
        };
        this.hNa = new CustomMessageListener(2921448) { // from class: com.baidu.tieba.frs.vc.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof y)) {
                    j.this.hnt.bqX();
                    y yVar = (y) customResponsedMessage.getData();
                    if (yVar.hqS != null) {
                        j.this.a(yVar.tabId, yVar.hqS);
                    } else if (yVar.tabId == 1) {
                        j.this.a(yVar.tabId, j.this.hNd);
                    } else {
                        j.this.a(yVar.tabId, (an) null);
                    }
                    j.this.vA(yVar.tabId);
                }
            }
        };
        this.hNb = new CustomMessageListener(9205410) { // from class: com.baidu.tieba.frs.vc.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof y)) {
                    y yVar = (y) customResponsedMessage.getData();
                    j.this.N(yVar.tabId, yVar.dVd);
                }
            }
        };
        this.hNc = new CustomMessageListener(2921449) { // from class: com.baidu.tieba.frs.vc.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof s)) {
                    s sVar = (s) customResponsedMessage.getData();
                    j.this.O(sVar.tabId, sVar.eIz);
                }
            }
        };
        this.hNd = new an() { // from class: com.baidu.tieba.frs.vc.j.5
            @Override // com.baidu.tieba.frs.an
            public void aWp() {
                j.this.hMX = true;
                if (j.this.hnt != null && j.this.hId != null && j.this.hnK != null && j.this.hGQ != null && j.this.hGQ.isAdded()) {
                    if (j.this.hnt != null && j.this.hnt.bVS() != null) {
                        j.this.hnt.bVS().cfI();
                    }
                    j.this.hGQ.mM(false);
                    com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.j.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.hnt.bVJ() != null && j.this.hId != null && j.this.hnt.bVJ().getVisibility() != 0) {
                                j.this.hId.bgK();
                            }
                        }
                    }, 110L);
                    j.this.hnt.K(1, true);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        j.this.hGQ.refresh();
                        j.this.hGQ.mM(true);
                    } else {
                        j.this.hGQ.bUW();
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11749").dh("fid", j.this.hGQ.getFid()).dh("obj_locate", "1"));
                }
            }

            @Override // com.baidu.tieba.frs.an
            public void aWq() {
                if (j.this.hGQ != null && j.this.hGQ.isAdded()) {
                    if (j.this.hMX && j.this.hGQ.bUR() != null) {
                        j.this.hGQ.bUR().ccx();
                        j.this.hMX = false;
                    }
                    if (j.this.hnN != null && j.this.hGQ.bUT() != null && j.this.hGQ.bUT().bVU() != null && !j.this.hGQ.bUT().bVU().cbM()) {
                        j.this.hnN.caU();
                    }
                    if (j.this.hnt != null && j.this.hId != null && j.this.hnK != null && j.this.hnN != null) {
                        j.this.hnt.bVS().a(0, 0, true, true);
                        j.this.hGQ.bVh();
                        j.this.hGQ.mM(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (j.this.hGQ.bUT() != null) {
                            j.this.hGQ.bUT().K(1, false);
                        }
                        if (!TbadkCoreApplication.isLogin() || j.this.hGQ.aWO().getVisibility() != 0 || v.isEmpty(j.this.hGQ.bVu().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.hnN = frsFragment.bUN();
        this.hMY = new HashMap<>();
        this.hnt.tY(1);
        frsFragment.registerListener(this.hMZ);
        frsFragment.registerListener(this.hNa);
        frsFragment.registerListener(this.hNb);
        frsFragment.registerListener(this.hNc);
    }

    public void ccj() {
        if (this.hnt != null) {
            if ((this.hIc instanceof FrsTabViewController) && ((FrsTabViewController) this.hIc).ccw() != null && (((FrsTabViewController) this.hIc).ccw().fragment instanceof an)) {
                FrsTabViewController.b ccw = ((FrsTabViewController) this.hIc).ccw();
                a(ccw.tabId, (an) ccw.fragment);
                vA(ccw.tabId);
                return;
            }
            this.hnt.a(this.hNd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vA(int i) {
        y yVar;
        if (this.hnt != null && (yVar = this.hMY.get(Integer.valueOf(i))) != null) {
            this.hnt.tY(i);
            this.hnt.a(yVar.hqS);
            this.hnt.mV(yVar.dVd);
            if (yVar.hqS == null) {
                this.hnt.mV(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, an anVar) {
        y yVar = this.hMY.get(Integer.valueOf(i));
        if (yVar == null) {
            y yVar2 = new y();
            yVar2.tabId = i;
            yVar2.hqS = anVar;
            this.hMY.put(Integer.valueOf(i), yVar2);
        } else {
            yVar.hqS = anVar;
        }
        if (this.hnt != null) {
            this.hnt.a(anVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(int i, boolean z) {
        y yVar = this.hMY.get(Integer.valueOf(i));
        if (yVar == null) {
            y yVar2 = new y();
            yVar2.tabId = i;
            yVar2.dVd = z;
            this.hMY.put(Integer.valueOf(i), yVar2);
        } else {
            yVar.dVd = z;
        }
        if (this.hnt != null) {
            this.hnt.mV(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(int i, boolean z) {
        if (this.hnt != null) {
            this.hnt.K(i, z);
        }
    }
}
