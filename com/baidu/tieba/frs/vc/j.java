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
    private boolean iHL;
    private CustomMessageListener iHS;
    private boolean jJQ;
    private HashMap<Integer, z> jJR;
    private final CustomMessageListener jJS;
    private final CustomMessageListener jJT;
    private final CustomMessageListener jJU;
    private final CustomMessageListener jJV;
    private aq jJW;
    private com.baidu.tieba.frs.smartsort.a jfE;

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.jJQ = false;
        this.iHL = false;
        this.iHS = new CustomMessageListener(2921468) { // from class: com.baidu.tieba.frs.vc.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        j.this.iHL = false;
                        return;
                    }
                    j.this.iHL = true;
                    j.this.jDI.cEX().cOs();
                }
            }
        };
        this.jJS = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.vc.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && j.this.jfi != null) {
                    j.this.jfi.startPullRefresh();
                }
            }
        };
        this.jJT = new CustomMessageListener(2921448) { // from class: com.baidu.tieba.frs.vc.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof z)) {
                    j.this.jfi.bUO();
                    z zVar = (z) customResponsedMessage.getData();
                    if (zVar.jjv != null) {
                        j.this.a(zVar.tabId, zVar.jjv);
                    } else if (zVar.tabId == 1) {
                        j.this.a(zVar.tabId, j.this.jJW);
                    } else {
                        j.this.a(zVar.tabId, (aq) null);
                    }
                    j.this.BZ(zVar.tabId);
                }
            }
        };
        this.jJU = new CustomMessageListener(9205410) { // from class: com.baidu.tieba.frs.vc.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof z)) {
                    z zVar = (z) customResponsedMessage.getData();
                    j.this.U(zVar.tabId, zVar.fln);
                }
            }
        };
        this.jJV = new CustomMessageListener(2921449) { // from class: com.baidu.tieba.frs.vc.j.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof t)) {
                    t tVar = (t) customResponsedMessage.getData();
                    j.this.V(tVar.tabId, tVar.geO);
                }
            }
        };
        this.jJW = new aq() { // from class: com.baidu.tieba.frs.vc.j.6
            @Override // com.baidu.tieba.frs.aq
            public void bxL() {
                j.this.jJQ = true;
                if (j.this.jfi != null && j.this.jES != null && j.this.jfB != null && j.this.jDI != null && j.this.jDI.isAdded()) {
                    if (j.this.jfi != null && j.this.jfi.cGd() != null) {
                        j.this.jfi.cGd().cSo();
                    }
                    j.this.jDI.qr(false);
                    com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.j.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.jfi.cFU() != null && j.this.jES != null && j.this.jfi.cFU().getVisibility() != 0) {
                                j.this.jES.bJb();
                            }
                        }
                    }, 110L);
                    j.this.jfi.Q(1, true);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        j.this.jDI.refresh();
                        j.this.jDI.qr(true);
                    } else {
                        j.this.jDI.cFc();
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11749").dX("fid", j.this.jDI.getFid()).dX("obj_locate", "1"));
                }
            }

            @Override // com.baidu.tieba.frs.aq
            public void bxM() {
                if (j.this.jDI != null && j.this.jDI.isAdded()) {
                    if (j.this.jJQ && j.this.jDI.cEX() != null) {
                        if (!j.this.iHL && !j.this.cOa()) {
                            j.this.jDI.cEX().cOr();
                        }
                        j.this.jJQ = false;
                    }
                    if (j.this.jfE != null && j.this.jDI.cEZ() != null && j.this.jDI.cEZ().cGf() != null && !j.this.jDI.cEZ().cGf().cNA() && j.this.jDI.cEX() != null && !j.this.jDI.cEX().cOk()) {
                        j.this.jfE.cME();
                    }
                    if (j.this.jfi != null && j.this.jES != null && j.this.jfB != null && j.this.jfE != null) {
                        j.this.jfi.cGd().b(0, 0, true, true);
                        j.this.jDI.cFo();
                        j.this.jDI.qr(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (j.this.jDI.cEZ() != null) {
                            j.this.jDI.cEZ().Q(1, false);
                        }
                        j.this.jfB.cNK();
                        if (!TbadkCoreApplication.isLogin() || j.this.jDI.getListView().getVisibility() != 0 || x.isEmpty(j.this.jDI.cFE().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.jfE = frsFragment.cET();
        this.jJR = new HashMap<>();
        this.jfi.Ak(1);
        frsFragment.registerListener(this.jJS);
        frsFragment.registerListener(this.jJT);
        frsFragment.registerListener(this.jJU);
        frsFragment.registerListener(this.jJV);
        frsFragment.registerListener(this.iHS);
    }

    public void cNZ() {
        if (this.jfi != null) {
            if ((this.jER instanceof FrsTabViewController) && ((FrsTabViewController) this.jER).cOq() != null && (((FrsTabViewController) this.jER).cOq().fragment instanceof aq)) {
                FrsTabViewController.b cOq = ((FrsTabViewController) this.jER).cOq();
                a(cOq.tabId, (aq) cOq.fragment);
                BZ(cOq.tabId);
                return;
            }
            this.jfi.a(this.jJW);
        }
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.iHS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cOa() {
        if (this.jDI.cFE() == null || this.jDI.cFE().getUserData() == null || this.jDI.cFE().forumRule == null || this.jDI.cFE().getForum() == null || !this.jDI.cFE().getForum().getIsShowRule()) {
            return false;
        }
        return this.jDI.cFE().getUserData().getIs_manager() == 1 ? this.jDI.cFE().forumRule.has_forum_rule.intValue() != 1 && this.jDI.cFE().forumRule.audit_status.intValue() == 0 && com.baidu.tbadk.core.sharedPref.b.bvq().getInt("key_forum_rule_first_show_frs_manager", 0) <= 0 : this.jDI.cFE().forumRule.has_forum_rule.intValue() == 1 && com.baidu.tbadk.core.sharedPref.b.bvq().getInt("key_forum_rule_first_show_frs", 0) <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BZ(int i) {
        z zVar;
        if (this.jfi != null && (zVar = this.jJR.get(Integer.valueOf(i))) != null) {
            this.jfi.Ak(i);
            this.jfi.a(zVar.jjv);
            this.jfi.qB(zVar.fln);
            if (zVar.jjv == null) {
                this.jfi.qB(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, aq aqVar) {
        z zVar = this.jJR.get(Integer.valueOf(i));
        if (zVar == null) {
            z zVar2 = new z();
            zVar2.tabId = i;
            zVar2.jjv = aqVar;
            this.jJR.put(Integer.valueOf(i), zVar2);
        } else {
            zVar.jjv = aqVar;
        }
        if (this.jfi != null) {
            this.jfi.a(aqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i, boolean z) {
        z zVar = this.jJR.get(Integer.valueOf(i));
        if (zVar == null) {
            z zVar2 = new z();
            zVar2.tabId = i;
            zVar2.fln = z;
            this.jJR.put(Integer.valueOf(i), zVar2);
        } else {
            zVar.fln = z;
        }
        if (this.jfi != null) {
            this.jfi.qB(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i, boolean z) {
        if (this.jfi != null) {
            this.jfi.Q(i, z);
        }
    }
}
