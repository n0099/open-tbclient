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
    private com.baidu.tieba.frs.smartsort.a hTm;
    private boolean hvl;
    private CustomMessageListener hvs;
    private boolean iur;
    private HashMap<Integer, ad> ius;
    private final CustomMessageListener iut;
    private final CustomMessageListener iuu;
    private final CustomMessageListener iuv;
    private final CustomMessageListener iuw;
    private au iux;

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.iur = false;
        this.hvl = false;
        this.hvs = new CustomMessageListener(2921468) { // from class: com.baidu.tieba.frs.vc.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        j.this.hvl = false;
                        return;
                    }
                    j.this.hvl = true;
                    j.this.iom.clQ().ctV();
                }
            }
        };
        this.iut = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.vc.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && j.this.hSP != null) {
                    j.this.hSP.startPullRefresh();
                }
            }
        };
        this.iuu = new CustomMessageListener(2921448) { // from class: com.baidu.tieba.frs.vc.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ad)) {
                    j.this.hSP.bGd();
                    ad adVar = (ad) customResponsedMessage.getData();
                    if (adVar.hXc != null) {
                        j.this.a(adVar.tabId, adVar.hXc);
                    } else if (adVar.tabId == 1) {
                        j.this.a(adVar.tabId, j.this.iux);
                    } else {
                        j.this.a(adVar.tabId, (au) null);
                    }
                    j.this.yQ(adVar.tabId);
                }
            }
        };
        this.iuv = new CustomMessageListener(9205410) { // from class: com.baidu.tieba.frs.vc.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ad)) {
                    ad adVar = (ad) customResponsedMessage.getData();
                    j.this.S(adVar.tabId, adVar.esv);
                }
            }
        };
        this.iuw = new CustomMessageListener(2921449) { // from class: com.baidu.tieba.frs.vc.j.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof v)) {
                    v vVar = (v) customResponsedMessage.getData();
                    j.this.T(vVar.tabId, vVar.fky);
                }
            }
        };
        this.iux = new au() { // from class: com.baidu.tieba.frs.vc.j.6
            @Override // com.baidu.tieba.frs.au
            public void bkD() {
                j.this.iur = true;
                if (j.this.hSP != null && j.this.ipx != null && j.this.hTj != null && j.this.iom != null && j.this.iom.isAdded()) {
                    if (j.this.hSP != null && j.this.hSP.cmV() != null) {
                        j.this.hSP.cmV().cxp();
                    }
                    j.this.iom.og(false);
                    com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.j.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.hSP.cmM() != null && j.this.ipx != null && j.this.hSP.cmM().getVisibility() != 0) {
                                j.this.ipx.bvE();
                            }
                        }
                    }, 110L);
                    j.this.hSP.O(1, true);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        j.this.iom.refresh();
                        j.this.iom.og(true);
                    } else {
                        j.this.iom.clV();
                    }
                    TiebaStatic.log(new aq("c11749").dD("fid", j.this.iom.getFid()).dD("obj_locate", "1"));
                }
            }

            @Override // com.baidu.tieba.frs.au
            public void bkE() {
                if (j.this.iom != null && j.this.iom.isAdded()) {
                    if (j.this.iur && j.this.iom.clQ() != null) {
                        if (!j.this.hvl) {
                            j.this.iom.clQ().ctU();
                        }
                        j.this.iur = false;
                    }
                    if (j.this.hTm != null && j.this.iom.clS() != null && j.this.iom.clS().cmX() != null && !j.this.iom.clS().cmX().cti()) {
                        j.this.hTm.csq();
                    }
                    if (j.this.hSP != null && j.this.ipx != null && j.this.hTj != null && j.this.hTm != null) {
                        j.this.hSP.cmV().a(0, 0, true, true);
                        j.this.iom.cmh();
                        j.this.iom.og(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (j.this.iom.clS() != null) {
                            j.this.iom.clS().O(1, false);
                        }
                        if (!TbadkCoreApplication.isLogin() || j.this.iom.blc().getVisibility() != 0 || y.isEmpty(j.this.iom.cmw().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.hTm = frsFragment.clM();
        this.ius = new HashMap<>();
        this.hSP.xk(1);
        frsFragment.registerListener(this.iut);
        frsFragment.registerListener(this.iuu);
        frsFragment.registerListener(this.iuv);
        frsFragment.registerListener(this.iuw);
        frsFragment.registerListener(this.hvs);
    }

    public void ctF() {
        if (this.hSP != null) {
            if ((this.ipw instanceof FrsTabViewController) && ((FrsTabViewController) this.ipw).ctT() != null && (((FrsTabViewController) this.ipw).ctT().fragment instanceof au)) {
                FrsTabViewController.b ctT = ((FrsTabViewController) this.ipw).ctT();
                a(ctT.tabId, (au) ctT.fragment);
                yQ(ctT.tabId);
                return;
            }
            this.hSP.a(this.iux);
        }
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.hvs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yQ(int i) {
        ad adVar;
        if (this.hSP != null && (adVar = this.ius.get(Integer.valueOf(i))) != null) {
            this.hSP.xk(i);
            this.hSP.a(adVar.hXc);
            this.hSP.op(adVar.esv);
            if (adVar.hXc == null) {
                this.hSP.op(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, au auVar) {
        ad adVar = this.ius.get(Integer.valueOf(i));
        if (adVar == null) {
            ad adVar2 = new ad();
            adVar2.tabId = i;
            adVar2.hXc = auVar;
            this.ius.put(Integer.valueOf(i), adVar2);
        } else {
            adVar.hXc = auVar;
        }
        if (this.hSP != null) {
            this.hSP.a(auVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i, boolean z) {
        ad adVar = this.ius.get(Integer.valueOf(i));
        if (adVar == null) {
            ad adVar2 = new ad();
            adVar2.tabId = i;
            adVar2.esv = z;
            this.ius.put(Integer.valueOf(i), adVar2);
        } else {
            adVar.esv = z;
        }
        if (this.hSP != null) {
            this.hSP.op(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(int i, boolean z) {
        if (this.hSP != null) {
            this.hSP.O(i, z);
        }
    }
}
