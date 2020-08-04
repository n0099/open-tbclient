package com.baidu.tieba.frs.vc;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.u;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import java.util.HashMap;
/* loaded from: classes16.dex */
public class j extends com.baidu.tieba.frs.mc.j {
    private com.baidu.tieba.frs.smartsort.a hFW;
    private boolean him;
    private CustomMessageListener hit;
    private boolean ign;
    private HashMap<Integer, ab> igo;
    private final CustomMessageListener igp;
    private final CustomMessageListener igq;
    private final CustomMessageListener igr;
    private final CustomMessageListener igs;
    private as igt;

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.ign = false;
        this.him = false;
        this.hit = new CustomMessageListener(2921468) { // from class: com.baidu.tieba.frs.vc.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        j.this.him = false;
                        return;
                    }
                    j.this.him = true;
                    j.this.iae.cbu().cjr();
                }
            }
        };
        this.igp = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.vc.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && j.this.hFz != null) {
                    j.this.hFz.startPullRefresh();
                }
            }
        };
        this.igq = new CustomMessageListener(2921448) { // from class: com.baidu.tieba.frs.vc.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ab)) {
                    j.this.hFz.bxe();
                    ab abVar = (ab) customResponsedMessage.getData();
                    if (abVar.hJD != null) {
                        j.this.a(abVar.tabId, abVar.hJD);
                    } else if (abVar.tabId == 1) {
                        j.this.a(abVar.tabId, j.this.igt);
                    } else {
                        j.this.a(abVar.tabId, (as) null);
                    }
                    j.this.wx(abVar.tabId);
                }
            }
        };
        this.igr = new CustomMessageListener(9205410) { // from class: com.baidu.tieba.frs.vc.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ab)) {
                    ab abVar = (ab) customResponsedMessage.getData();
                    j.this.Q(abVar.tabId, abVar.eiE);
                }
            }
        };
        this.igs = new CustomMessageListener(2921449) { // from class: com.baidu.tieba.frs.vc.j.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof u)) {
                    u uVar = (u) customResponsedMessage.getData();
                    j.this.R(uVar.tabId, uVar.eZg);
                }
            }
        };
        this.igt = new as() { // from class: com.baidu.tieba.frs.vc.j.6
            @Override // com.baidu.tieba.frs.as
            public void bcg() {
                j.this.ign = true;
                if (j.this.hFz != null && j.this.ibq != null && j.this.hFT != null && j.this.iae != null && j.this.iae.isAdded()) {
                    if (j.this.hFz != null && j.this.hFz.ccy() != null) {
                        j.this.hFz.ccy().cmG();
                    }
                    j.this.iae.nC(false);
                    com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.j.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.hFz.ccp() != null && j.this.ibq != null && j.this.hFz.ccp().getVisibility() != 0) {
                                j.this.ibq.bmR();
                            }
                        }
                    }, 110L);
                    j.this.hFz.M(1, true);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        j.this.iae.refresh();
                        j.this.iae.nC(true);
                    } else {
                        j.this.iae.cbz();
                    }
                    TiebaStatic.log(new ap("c11749").dn("fid", j.this.iae.getFid()).dn("obj_locate", "1"));
                }
            }

            @Override // com.baidu.tieba.frs.as
            public void bch() {
                if (j.this.iae != null && j.this.iae.isAdded()) {
                    if (j.this.ign && j.this.iae.cbu() != null) {
                        if (!j.this.him) {
                            j.this.iae.cbu().cjq();
                        }
                        j.this.ign = false;
                    }
                    if (j.this.hFW != null && j.this.iae.cbw() != null && j.this.iae.cbw().ccA() != null && !j.this.iae.cbw().ccA().ciE()) {
                        j.this.hFW.chM();
                    }
                    if (j.this.hFz != null && j.this.ibq != null && j.this.hFT != null && j.this.hFW != null) {
                        j.this.hFz.ccy().a(0, 0, true, true);
                        j.this.iae.cbK();
                        j.this.iae.nC(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (j.this.iae.cbw() != null) {
                            j.this.iae.cbw().M(1, false);
                        }
                        if (!TbadkCoreApplication.isLogin() || j.this.iae.bcE().getVisibility() != 0 || x.isEmpty(j.this.iae.cbZ().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.hFW = frsFragment.cbq();
        this.igo = new HashMap<>();
        this.hFz.uV(1);
        frsFragment.registerListener(this.igp);
        frsFragment.registerListener(this.igq);
        frsFragment.registerListener(this.igr);
        frsFragment.registerListener(this.igs);
        frsFragment.registerListener(this.hit);
    }

    public void cjb() {
        if (this.hFz != null) {
            if ((this.ibp instanceof FrsTabViewController) && ((FrsTabViewController) this.ibp).cjp() != null && (((FrsTabViewController) this.ibp).cjp().fragment instanceof as)) {
                FrsTabViewController.b cjp = ((FrsTabViewController) this.ibp).cjp();
                a(cjp.tabId, (as) cjp.fragment);
                wx(cjp.tabId);
                return;
            }
            this.hFz.a(this.igt);
        }
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.hit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wx(int i) {
        ab abVar;
        if (this.hFz != null && (abVar = this.igo.get(Integer.valueOf(i))) != null) {
            this.hFz.uV(i);
            this.hFz.a(abVar.hJD);
            this.hFz.nL(abVar.eiE);
            if (abVar.hJD == null) {
                this.hFz.nL(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, as asVar) {
        ab abVar = this.igo.get(Integer.valueOf(i));
        if (abVar == null) {
            ab abVar2 = new ab();
            abVar2.tabId = i;
            abVar2.hJD = asVar;
            this.igo.put(Integer.valueOf(i), abVar2);
        } else {
            abVar.hJD = asVar;
        }
        if (this.hFz != null) {
            this.hFz.a(asVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(int i, boolean z) {
        ab abVar = this.igo.get(Integer.valueOf(i));
        if (abVar == null) {
            ab abVar2 = new ab();
            abVar2.tabId = i;
            abVar2.eiE = z;
            this.igo.put(Integer.valueOf(i), abVar2);
        } else {
            abVar.eiE = z;
        }
        if (this.hFz != null) {
            this.hFz.nL(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i, boolean z) {
        if (this.hFz != null) {
            this.hFz.M(i, z);
        }
    }
}
