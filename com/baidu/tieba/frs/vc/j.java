package com.baidu.tieba.frs.vc;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import java.util.HashMap;
/* loaded from: classes21.dex */
public class j extends com.baidu.tieba.frs.mc.j {
    private CustomMessageListener hCD;
    private boolean hCw;
    private boolean iBT;
    private HashMap<Integer, ad> iBU;
    private final CustomMessageListener iBV;
    private final CustomMessageListener iBW;
    private final CustomMessageListener iBX;
    private final CustomMessageListener iBY;
    private au iBZ;
    private com.baidu.tieba.frs.smartsort.a ias;

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.iBT = false;
        this.hCw = false;
        this.hCD = new CustomMessageListener(2921468) { // from class: com.baidu.tieba.frs.vc.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        j.this.hCw = false;
                        return;
                    }
                    j.this.hCw = true;
                    j.this.ivI.cpd().cxp();
                }
            }
        };
        this.iBV = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.vc.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && j.this.hZV != null) {
                    j.this.hZV.startPullRefresh();
                }
            }
        };
        this.iBW = new CustomMessageListener(2921448) { // from class: com.baidu.tieba.frs.vc.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ad)) {
                    j.this.hZV.bHu();
                    ad adVar = (ad) customResponsedMessage.getData();
                    if (adVar.iem != null) {
                        j.this.a(adVar.tabId, adVar.iem);
                    } else if (adVar.tabId == 1) {
                        j.this.a(adVar.tabId, j.this.iBZ);
                    } else {
                        j.this.a(adVar.tabId, (au) null);
                    }
                    j.this.zp(adVar.tabId);
                }
            }
        };
        this.iBX = new CustomMessageListener(9205410) { // from class: com.baidu.tieba.frs.vc.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ad)) {
                    ad adVar = (ad) customResponsedMessage.getData();
                    j.this.S(adVar.tabId, adVar.euE);
                }
            }
        };
        this.iBY = new CustomMessageListener(2921449) { // from class: com.baidu.tieba.frs.vc.j.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof v)) {
                    v vVar = (v) customResponsedMessage.getData();
                    j.this.T(vVar.tabId, vVar.fnv);
                }
            }
        };
        this.iBZ = new au() { // from class: com.baidu.tieba.frs.vc.j.6
            @Override // com.baidu.tieba.frs.au
            public void bly() {
                j.this.iBT = true;
                if (j.this.hZV != null && j.this.iwT != null && j.this.iap != null && j.this.ivI != null && j.this.ivI.isAdded()) {
                    if (j.this.hZV != null && j.this.hZV.cqi() != null) {
                        j.this.hZV.cqi().cAY();
                    }
                    j.this.ivI.oo(false);
                    com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.j.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.hZV.cpZ() != null && j.this.iwT != null && j.this.hZV.cpZ().getVisibility() != 0) {
                                j.this.iwT.bwO();
                            }
                        }
                    }, 110L);
                    j.this.hZV.O(1, true);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        j.this.ivI.refresh();
                        j.this.ivI.oo(true);
                    } else {
                        j.this.ivI.cpi();
                    }
                    TiebaStatic.log(new aq("c11749").dF("fid", j.this.ivI.getFid()).dF("obj_locate", "1"));
                }
            }

            @Override // com.baidu.tieba.frs.au
            public void blz() {
                if (j.this.ivI != null && j.this.ivI.isAdded()) {
                    if (j.this.iBT && j.this.ivI.cpd() != null) {
                        if (!j.this.hCw) {
                            j.this.ivI.cpd().cxo();
                        }
                        j.this.iBT = false;
                    }
                    if (j.this.ias != null && j.this.ivI.cpf() != null && j.this.ivI.cpf().cqk() != null && !j.this.ivI.cpf().cqk().cwA()) {
                        j.this.ias.cvG();
                    }
                    if (j.this.hZV != null && j.this.iwT != null && j.this.iap != null && j.this.ias != null) {
                        j.this.hZV.cqi().a(0, 0, true, true);
                        j.this.ivI.cpu();
                        j.this.ivI.oo(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (j.this.ivI.cpf() != null) {
                            j.this.ivI.cpf().O(1, false);
                        }
                        if (!TbadkCoreApplication.isLogin() || j.this.ivI.blX().getVisibility() != 0 || y.isEmpty(j.this.ivI.cpJ().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.ias = frsFragment.coZ();
        this.iBU = new HashMap<>();
        this.hZV.xJ(1);
        frsFragment.registerListener(this.iBV);
        frsFragment.registerListener(this.iBW);
        frsFragment.registerListener(this.iBX);
        frsFragment.registerListener(this.iBY);
        frsFragment.registerListener(this.hCD);
    }

    public void cwY() {
        if (this.hZV != null) {
            if ((this.iwS instanceof FrsTabViewController) && ((FrsTabViewController) this.iwS).cxn() != null && (((FrsTabViewController) this.iwS).cxn().fragment instanceof au)) {
                FrsTabViewController.b cxn = ((FrsTabViewController) this.iwS).cxn();
                a(cxn.tabId, (au) cxn.fragment);
                zp(cxn.tabId);
                return;
            }
            this.hZV.a(this.iBZ);
        }
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.hCD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zp(int i) {
        ad adVar;
        if (this.hZV != null && (adVar = this.iBU.get(Integer.valueOf(i))) != null) {
            this.hZV.xJ(i);
            this.hZV.a(adVar.iem);
            this.hZV.ox(adVar.euE);
            if (adVar.iem == null) {
                this.hZV.ox(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, au auVar) {
        ad adVar = this.iBU.get(Integer.valueOf(i));
        if (adVar == null) {
            ad adVar2 = new ad();
            adVar2.tabId = i;
            adVar2.iem = auVar;
            this.iBU.put(Integer.valueOf(i), adVar2);
        } else {
            adVar.iem = auVar;
        }
        if (this.hZV != null) {
            this.hZV.a(auVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i, boolean z) {
        ad adVar = this.iBU.get(Integer.valueOf(i));
        if (adVar == null) {
            ad adVar2 = new ad();
            adVar2.tabId = i;
            adVar2.euE = z;
            this.iBU.put(Integer.valueOf(i), adVar2);
        } else {
            adVar.euE = z;
        }
        if (this.hZV != null) {
            this.hZV.ox(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(int i, boolean z) {
        if (this.hZV != null) {
            this.hZV.O(i, z);
        }
    }
}
