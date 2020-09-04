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
/* loaded from: classes16.dex */
public class j extends com.baidu.tieba.frs.mc.j {
    private com.baidu.tieba.frs.smartsort.a hTs;
    private boolean hvr;
    private CustomMessageListener hvy;
    private final CustomMessageListener iuA;
    private final CustomMessageListener iuB;
    private final CustomMessageListener iuC;
    private au iuD;
    private boolean iux;
    private HashMap<Integer, ad> iuy;
    private final CustomMessageListener iuz;

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.iux = false;
        this.hvr = false;
        this.hvy = new CustomMessageListener(2921468) { // from class: com.baidu.tieba.frs.vc.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        j.this.hvr = false;
                        return;
                    }
                    j.this.hvr = true;
                    j.this.ios.clR().ctW();
                }
            }
        };
        this.iuz = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.vc.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && j.this.hSV != null) {
                    j.this.hSV.startPullRefresh();
                }
            }
        };
        this.iuA = new CustomMessageListener(2921448) { // from class: com.baidu.tieba.frs.vc.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ad)) {
                    j.this.hSV.bGe();
                    ad adVar = (ad) customResponsedMessage.getData();
                    if (adVar.hXi != null) {
                        j.this.a(adVar.tabId, adVar.hXi);
                    } else if (adVar.tabId == 1) {
                        j.this.a(adVar.tabId, j.this.iuD);
                    } else {
                        j.this.a(adVar.tabId, (au) null);
                    }
                    j.this.yQ(adVar.tabId);
                }
            }
        };
        this.iuB = new CustomMessageListener(9205410) { // from class: com.baidu.tieba.frs.vc.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ad)) {
                    ad adVar = (ad) customResponsedMessage.getData();
                    j.this.S(adVar.tabId, adVar.esz);
                }
            }
        };
        this.iuC = new CustomMessageListener(2921449) { // from class: com.baidu.tieba.frs.vc.j.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof v)) {
                    v vVar = (v) customResponsedMessage.getData();
                    j.this.T(vVar.tabId, vVar.fkC);
                }
            }
        };
        this.iuD = new au() { // from class: com.baidu.tieba.frs.vc.j.6
            @Override // com.baidu.tieba.frs.au
            public void bkD() {
                j.this.iux = true;
                if (j.this.hSV != null && j.this.ipD != null && j.this.hTp != null && j.this.ios != null && j.this.ios.isAdded()) {
                    if (j.this.hSV != null && j.this.hSV.cmW() != null) {
                        j.this.hSV.cmW().cxq();
                    }
                    j.this.ios.oi(false);
                    com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.j.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.hSV.cmN() != null && j.this.ipD != null && j.this.hSV.cmN().getVisibility() != 0) {
                                j.this.ipD.bvF();
                            }
                        }
                    }, 110L);
                    j.this.hSV.O(1, true);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        j.this.ios.refresh();
                        j.this.ios.oi(true);
                    } else {
                        j.this.ios.clW();
                    }
                    TiebaStatic.log(new aq("c11749").dD("fid", j.this.ios.getFid()).dD("obj_locate", "1"));
                }
            }

            @Override // com.baidu.tieba.frs.au
            public void bkE() {
                if (j.this.ios != null && j.this.ios.isAdded()) {
                    if (j.this.iux && j.this.ios.clR() != null) {
                        if (!j.this.hvr) {
                            j.this.ios.clR().ctV();
                        }
                        j.this.iux = false;
                    }
                    if (j.this.hTs != null && j.this.ios.clT() != null && j.this.ios.clT().cmY() != null && !j.this.ios.clT().cmY().ctj()) {
                        j.this.hTs.csr();
                    }
                    if (j.this.hSV != null && j.this.ipD != null && j.this.hTp != null && j.this.hTs != null) {
                        j.this.hSV.cmW().a(0, 0, true, true);
                        j.this.ios.cmi();
                        j.this.ios.oi(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (j.this.ios.clT() != null) {
                            j.this.ios.clT().O(1, false);
                        }
                        if (!TbadkCoreApplication.isLogin() || j.this.ios.blc().getVisibility() != 0 || y.isEmpty(j.this.ios.cmx().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.hTs = frsFragment.clN();
        this.iuy = new HashMap<>();
        this.hSV.xk(1);
        frsFragment.registerListener(this.iuz);
        frsFragment.registerListener(this.iuA);
        frsFragment.registerListener(this.iuB);
        frsFragment.registerListener(this.iuC);
        frsFragment.registerListener(this.hvy);
    }

    public void ctG() {
        if (this.hSV != null) {
            if ((this.ipC instanceof FrsTabViewController) && ((FrsTabViewController) this.ipC).ctU() != null && (((FrsTabViewController) this.ipC).ctU().fragment instanceof au)) {
                FrsTabViewController.b ctU = ((FrsTabViewController) this.ipC).ctU();
                a(ctU.tabId, (au) ctU.fragment);
                yQ(ctU.tabId);
                return;
            }
            this.hSV.a(this.iuD);
        }
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.hvy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yQ(int i) {
        ad adVar;
        if (this.hSV != null && (adVar = this.iuy.get(Integer.valueOf(i))) != null) {
            this.hSV.xk(i);
            this.hSV.a(adVar.hXi);
            this.hSV.or(adVar.esz);
            if (adVar.hXi == null) {
                this.hSV.or(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, au auVar) {
        ad adVar = this.iuy.get(Integer.valueOf(i));
        if (adVar == null) {
            ad adVar2 = new ad();
            adVar2.tabId = i;
            adVar2.hXi = auVar;
            this.iuy.put(Integer.valueOf(i), adVar2);
        } else {
            adVar.hXi = auVar;
        }
        if (this.hSV != null) {
            this.hSV.a(auVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i, boolean z) {
        ad adVar = this.iuy.get(Integer.valueOf(i));
        if (adVar == null) {
            ad adVar2 = new ad();
            adVar2.tabId = i;
            adVar2.esz = z;
            this.iuy.put(Integer.valueOf(i), adVar2);
        } else {
            adVar.esz = z;
        }
        if (this.hSV != null) {
            this.hSV.or(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(int i, boolean z) {
        if (this.hSV != null) {
            this.hSV.O(i, z);
        }
    }
}
