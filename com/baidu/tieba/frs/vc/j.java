package com.baidu.tieba.frs.vc;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.t;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.z;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class j extends com.baidu.tieba.frs.mc.j {
    private boolean iDe;
    private CustomMessageListener iDl;
    private boolean jFk;
    private HashMap<Integer, z> jFl;
    private final CustomMessageListener jFm;
    private final CustomMessageListener jFn;
    private final CustomMessageListener jFo;
    private final CustomMessageListener jFp;
    private aq jFq;
    private com.baidu.tieba.frs.smartsort.a jaX;

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.jFk = false;
        this.iDe = false;
        this.iDl = new CustomMessageListener(2921468) { // from class: com.baidu.tieba.frs.vc.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        j.this.iDe = false;
                        return;
                    }
                    j.this.iDe = true;
                    j.this.jzc.cBg().cKB();
                }
            }
        };
        this.jFm = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.vc.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && j.this.jaB != null) {
                    j.this.jaB.startPullRefresh();
                }
            }
        };
        this.jFn = new CustomMessageListener(2921448) { // from class: com.baidu.tieba.frs.vc.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof z)) {
                    j.this.jaB.bQX();
                    z zVar = (z) customResponsedMessage.getData();
                    if (zVar.jeN != null) {
                        j.this.a(zVar.tabId, zVar.jeN);
                    } else if (zVar.tabId == 1) {
                        j.this.a(zVar.tabId, j.this.jFq);
                    } else {
                        j.this.a(zVar.tabId, (aq) null);
                    }
                    j.this.At(zVar.tabId);
                }
            }
        };
        this.jFo = new CustomMessageListener(9205410) { // from class: com.baidu.tieba.frs.vc.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof z)) {
                    z zVar = (z) customResponsedMessage.getData();
                    j.this.U(zVar.tabId, zVar.fgC);
                }
            }
        };
        this.jFp = new CustomMessageListener(2921449) { // from class: com.baidu.tieba.frs.vc.j.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof t)) {
                    t tVar = (t) customResponsedMessage.getData();
                    j.this.V(tVar.tabId, tVar.gae);
                }
            }
        };
        this.jFq = new aq() { // from class: com.baidu.tieba.frs.vc.j.6
            @Override // com.baidu.tieba.frs.aq
            public void btS() {
                j.this.jFk = true;
                if (j.this.jaB != null && j.this.jAm != null && j.this.jaU != null && j.this.jzc != null && j.this.jzc.isAdded()) {
                    if (j.this.jaB != null && j.this.jaB.cCm() != null) {
                        j.this.jaB.cCm().cOx();
                    }
                    j.this.jzc.qn(false);
                    com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.j.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.jaB.cCd() != null && j.this.jAm != null && j.this.jaB.cCd().getVisibility() != 0) {
                                j.this.jAm.bFk();
                            }
                        }
                    }, 110L);
                    j.this.jaB.Q(1, true);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        j.this.jzc.refresh();
                        j.this.jzc.qn(true);
                    } else {
                        j.this.jzc.cBl();
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11749").dW("fid", j.this.jzc.getFid()).dW("obj_locate", "1"));
                }
            }

            @Override // com.baidu.tieba.frs.aq
            public void btT() {
                if (j.this.jzc != null && j.this.jzc.isAdded()) {
                    if (j.this.jFk && j.this.jzc.cBg() != null) {
                        if (!j.this.iDe && !j.this.cKj()) {
                            j.this.jzc.cBg().cKA();
                        }
                        j.this.jFk = false;
                    }
                    if (j.this.jaX != null && j.this.jzc.cBi() != null && j.this.jzc.cBi().cCo() != null && !j.this.jzc.cBi().cCo().cJJ() && j.this.jzc.cBg() != null && !j.this.jzc.cBg().cKt()) {
                        j.this.jaX.cIN();
                    }
                    if (j.this.jaB != null && j.this.jAm != null && j.this.jaU != null && j.this.jaX != null) {
                        j.this.jaB.cCm().b(0, 0, true, true);
                        j.this.jzc.cBx();
                        j.this.jzc.qn(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (j.this.jzc.cBi() != null) {
                            j.this.jzc.cBi().Q(1, false);
                        }
                        j.this.jaU.cJT();
                        if (!TbadkCoreApplication.isLogin() || j.this.jzc.getListView().getVisibility() != 0 || x.isEmpty(j.this.jzc.cBN().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.jaX = frsFragment.cBc();
        this.jFl = new HashMap<>();
        this.jaB.yE(1);
        frsFragment.registerListener(this.jFm);
        frsFragment.registerListener(this.jFn);
        frsFragment.registerListener(this.jFo);
        frsFragment.registerListener(this.jFp);
        frsFragment.registerListener(this.iDl);
    }

    public void cKi() {
        if (this.jaB != null) {
            if ((this.jAl instanceof FrsTabViewController) && ((FrsTabViewController) this.jAl).cKz() != null && (((FrsTabViewController) this.jAl).cKz().fragment instanceof aq)) {
                FrsTabViewController.b cKz = ((FrsTabViewController) this.jAl).cKz();
                a(cKz.tabId, (aq) cKz.fragment);
                At(cKz.tabId);
                return;
            }
            this.jaB.a(this.jFq);
        }
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.iDl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cKj() {
        if (this.jzc.cBN() == null || this.jzc.cBN().getUserData() == null || this.jzc.cBN().forumRule == null || this.jzc.cBN().getForum() == null || !this.jzc.cBN().getForum().getIsShowRule()) {
            return false;
        }
        return this.jzc.cBN().getUserData().getIs_manager() == 1 ? this.jzc.cBN().forumRule.has_forum_rule.intValue() != 1 && this.jzc.cBN().forumRule.audit_status.intValue() == 0 && com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_forum_rule_first_show_frs_manager", 0) <= 0 : this.jzc.cBN().forumRule.has_forum_rule.intValue() == 1 && com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_forum_rule_first_show_frs", 0) <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void At(int i) {
        z zVar;
        if (this.jaB != null && (zVar = this.jFl.get(Integer.valueOf(i))) != null) {
            this.jaB.yE(i);
            this.jaB.a(zVar.jeN);
            this.jaB.qx(zVar.fgC);
            if (zVar.jeN == null) {
                this.jaB.qx(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, aq aqVar) {
        z zVar = this.jFl.get(Integer.valueOf(i));
        if (zVar == null) {
            z zVar2 = new z();
            zVar2.tabId = i;
            zVar2.jeN = aqVar;
            this.jFl.put(Integer.valueOf(i), zVar2);
        } else {
            zVar.jeN = aqVar;
        }
        if (this.jaB != null) {
            this.jaB.a(aqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i, boolean z) {
        z zVar = this.jFl.get(Integer.valueOf(i));
        if (zVar == null) {
            z zVar2 = new z();
            zVar2.tabId = i;
            zVar2.fgC = z;
            this.jFl.put(Integer.valueOf(i), zVar2);
        } else {
            zVar.fgC = z;
        }
        if (this.jaB != null) {
            this.jaB.qx(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i, boolean z) {
        if (this.jaB != null) {
            this.jaB.Q(i, z);
        }
    }
}
