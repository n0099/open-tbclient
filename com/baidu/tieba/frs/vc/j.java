package com.baidu.tieba.frs.vc;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.u;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class j extends com.baidu.tieba.frs.mc.j {
    private com.baidu.tieba.frs.smartsort.a hAg;
    private boolean iaj;
    private HashMap<Integer, ab> iak;
    private final CustomMessageListener ial;
    private final CustomMessageListener iam;
    private final CustomMessageListener ian;
    private final CustomMessageListener iao;
    private as iap;

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.iaj = false;
        this.ial = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.vc.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && j.this.hzK != null) {
                    j.this.hzK.startPullRefresh();
                }
            }
        };
        this.iam = new CustomMessageListener(2921448) { // from class: com.baidu.tieba.frs.vc.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ab)) {
                    j.this.hzK.btV();
                    ab abVar = (ab) customResponsedMessage.getData();
                    if (abVar.hDF != null) {
                        j.this.a(abVar.tabId, abVar.hDF);
                    } else if (abVar.tabId == 1) {
                        j.this.a(abVar.tabId, j.this.iap);
                    } else {
                        j.this.a(abVar.tabId, (as) null);
                    }
                    j.this.wf(abVar.tabId);
                }
            }
        };
        this.ian = new CustomMessageListener(9205410) { // from class: com.baidu.tieba.frs.vc.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ab)) {
                    ab abVar = (ab) customResponsedMessage.getData();
                    j.this.Q(abVar.tabId, abVar.ecu);
                }
            }
        };
        this.iao = new CustomMessageListener(2921449) { // from class: com.baidu.tieba.frs.vc.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof u)) {
                    u uVar = (u) customResponsedMessage.getData();
                    j.this.R(uVar.tabId, uVar.eSL);
                }
            }
        };
        this.iap = new as() { // from class: com.baidu.tieba.frs.vc.j.5
            @Override // com.baidu.tieba.frs.as
            public void aYg() {
                j.this.iaj = true;
                if (j.this.hzK != null && j.this.hVp != null && j.this.hAd != null && j.this.hUd != null && j.this.hUd.isAdded()) {
                    if (j.this.hzK != null && j.this.hzK.bZb() != null) {
                        j.this.hzK.bZb().cjf();
                    }
                    j.this.hUd.mX(false);
                    com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.j.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.hzK.bYS() != null && j.this.hVp != null && j.this.hzK.bYS().getVisibility() != 0) {
                                j.this.hVp.biY();
                            }
                        }
                    }, 110L);
                    j.this.hzK.M(1, true);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        j.this.hUd.refresh();
                        j.this.hUd.mX(true);
                    } else {
                        j.this.hUd.bYd();
                    }
                    TiebaStatic.log(new ao("c11749").dk("fid", j.this.hUd.getFid()).dk("obj_locate", "1"));
                }
            }

            @Override // com.baidu.tieba.frs.as
            public void aYh() {
                if (j.this.hUd != null && j.this.hUd.isAdded()) {
                    if (j.this.iaj && j.this.hUd.bXY() != null) {
                        j.this.hUd.bXY().cfR();
                        j.this.iaj = false;
                    }
                    if (j.this.hAg != null && j.this.hUd.bYa() != null && j.this.hUd.bYa().bZd() != null && !j.this.hUd.bYa().bZd().cff()) {
                        j.this.hAg.cen();
                    }
                    if (j.this.hzK != null && j.this.hVp != null && j.this.hAd != null && j.this.hAg != null) {
                        j.this.hzK.bZb().a(0, 0, true, true);
                        j.this.hUd.bYp();
                        j.this.hUd.mX(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (j.this.hUd.bYa() != null) {
                            j.this.hUd.bYa().M(1, false);
                        }
                        if (!TbadkCoreApplication.isLogin() || j.this.hUd.aYH().getVisibility() != 0 || w.isEmpty(j.this.hUd.bYC().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.hAg = frsFragment.bXU();
        this.iak = new HashMap<>();
        this.hzK.uD(1);
        frsFragment.registerListener(this.ial);
        frsFragment.registerListener(this.iam);
        frsFragment.registerListener(this.ian);
        frsFragment.registerListener(this.iao);
    }

    public void cfC() {
        if (this.hzK != null) {
            if ((this.hVo instanceof FrsTabViewController) && ((FrsTabViewController) this.hVo).cfQ() != null && (((FrsTabViewController) this.hVo).cfQ().fragment instanceof as)) {
                FrsTabViewController.b cfQ = ((FrsTabViewController) this.hVo).cfQ();
                a(cfQ.tabId, (as) cfQ.fragment);
                wf(cfQ.tabId);
                return;
            }
            this.hzK.a(this.iap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wf(int i) {
        ab abVar;
        if (this.hzK != null && (abVar = this.iak.get(Integer.valueOf(i))) != null) {
            this.hzK.uD(i);
            this.hzK.a(abVar.hDF);
            this.hzK.ng(abVar.ecu);
            if (abVar.hDF == null) {
                this.hzK.ng(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, as asVar) {
        ab abVar = this.iak.get(Integer.valueOf(i));
        if (abVar == null) {
            ab abVar2 = new ab();
            abVar2.tabId = i;
            abVar2.hDF = asVar;
            this.iak.put(Integer.valueOf(i), abVar2);
        } else {
            abVar.hDF = asVar;
        }
        if (this.hzK != null) {
            this.hzK.a(asVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(int i, boolean z) {
        ab abVar = this.iak.get(Integer.valueOf(i));
        if (abVar == null) {
            ab abVar2 = new ab();
            abVar2.tabId = i;
            abVar2.ecu = z;
            this.iak.put(Integer.valueOf(i), abVar2);
        } else {
            abVar.ecu = z;
        }
        if (this.hzK != null) {
            this.hzK.ng(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i, boolean z) {
        if (this.hzK != null) {
            this.hzK.M(i, z);
        }
    }
}
