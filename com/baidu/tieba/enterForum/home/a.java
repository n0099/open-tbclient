package com.baidu.tieba.enterForum.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.aj;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.tbadkCore.af;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseFragment implements com.baidu.tbadk.imageManager.d, com.baidu.tbadk.mvc.c.a {
    private af LI;
    private String aEO;
    private boolean aER;
    private long aES;
    private ViewEventCenter aET;
    private boolean aEU;
    private com.baidu.tbadk.core.view.b aEV;
    private boolean aEY;
    private com.baidu.tbadk.core.dialog.a aFa;
    private BaseFragmentActivity azk;
    private com.baidu.tieba.enterForum.d.e aEL = null;
    private com.baidu.tieba.enterForum.c.c aEM = null;
    private boolean isFirst = true;
    private boolean aEN = false;
    private long aEP = -1;
    private boolean aEQ = false;
    private boolean aEW = true;
    private com.baidu.adp.framework.listener.a aEX = new b(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private CustomMessageListener aEZ = new j(this, 2007008);
    private com.baidu.adp.base.i aFb = new k(this);
    private final com.baidu.tieba.enterForum.c.h aFc = new l(this);
    private aj aaa = new m(this);

    static {
        HL();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.aEW = bundle.getBoolean("key_first_start_maintab", true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBoolean("key_first_start_maintab", this.aEW);
        super.onSaveInstanceState(bundle);
    }

    private static void HL() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean HM() {
        return (this.aEM.b(this.aEL.Iy(), this.aEL.Iz()) && (this.aEL.Il() == this.aEL.Ip())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HN() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, false));
        this.aEL.Iw();
    }

    private void HO() {
        registerListener(new n(this, 2007010));
        registerListener(new o(this, 2007011));
    }

    private void HP() {
        registerListener(new p(this, 2007012));
    }

    public void HQ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getFragmentActivity());
        aVar.bu(t.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.m411getInst().getString(t.enter_forum_cancel_change), new q(this));
        aVar.b(TbadkCoreApplication.m411getInst().getString(t.cancel), new c(this));
        aVar.b(this.azk.getPageContext());
        aVar.rL();
    }

    private void HR() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getFragmentActivity());
        aVar.bu(t.recommend_dismis_affirm);
        aVar.a(TbadkCoreApplication.m411getInst().getString(t.hide), new d(this));
        aVar.b(TbadkCoreApplication.m411getInst().getString(t.cancel), new e(this));
        aVar.b(getPageContext());
        aVar.rL();
    }

    public void a(ae aeVar) {
        if (aeVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getFragmentActivity());
            aVar.cn(String.format(this.azk.getPageContext().getString(t.attention_cancel_dialog_content), aeVar.getName()));
            aVar.a(TbadkCoreApplication.m411getInst().getString(t.confirm), new f(this, aeVar));
            aVar.b(TbadkCoreApplication.m411getInst().getString(t.cancel), new g(this));
            aVar.b(getPageContext());
            aVar.rL();
        }
    }

    public void bH(boolean z) {
        if (this.aEV == null) {
            HS();
        }
        this.aEV.ar(z);
    }

    private void HS() {
        this.aEV = new com.baidu.tbadk.core.view.b(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.azk = getBaseFragmentActivity();
        this.aET = new ViewEventCenter();
        this.aET.addEventDelegate(this);
        registerListener(this.aEZ);
        HO();
        HP();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return c(layoutInflater);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.aEX);
        this.aEP = System.currentTimeMillis();
        initData(getArguments());
        initUI();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.aEU = this.aEM.hasShowForumEditGuide();
        com.baidu.tieba.enterForum.c.a.HT().i(getFragmentActivity(), com.baidu.adp.lib.util.n.l(getFragmentActivity()));
    }

    private View c(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(com.baidu.tieba.r.enter_forum_view, (ViewGroup) null);
    }

    private void initUI() {
        this.aEL = new com.baidu.tieba.enterForum.d.e(this, this.aET);
        this.aEL.a(this.aaa);
        this.aEL.c(new h(this));
    }

    private void initData(Bundle bundle) {
        this.isFirst = true;
        this.aEN = false;
        this.aEO = "";
        this.aEM = new com.baidu.tieba.enterForum.c.c(this.azk.getPageContext());
        this.aEM.a(this.aFc);
        this.aES = this.aEM.Ii();
        this.LI = new af(this.azk.getPageContext());
        this.LI.setLoadDataCallBack(this.aFb);
        this.aEM.a(this.aFc);
    }

    public void e(boolean z, String str) {
        if (!z && str != null) {
            showToast(str);
        }
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null) {
            if (bVar.HC() != null && bVar.HC().rh() != null && !bVar.HC().rh().isEmpty()) {
                this.aEL.a(getPageContext(), bVar.HC().rh().get(0));
            }
            com.baidu.tieba.enterForum.b.c HD = bVar.HD();
            if (HD != null && HD.HG() != null) {
                int size = HD.HG().size();
                if (size < 5 && this.aEW && TbadkCoreApplication.isLogin()) {
                    sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getActivity()).createNormalCfg(2)));
                }
                this.aEW = false;
                if (size <= 10) {
                    if (size <= 0) {
                        if (this.mIsLogin) {
                            this.aEL.bL(true);
                        } else {
                            this.aEL.bL(false);
                        }
                    } else {
                        this.aEL.bL(false);
                    }
                    boolean P = this.aEM.P(this.aES);
                    List<com.baidu.tieba.enterForum.b.e> HK = bVar.HB() != null ? bVar.HB().HK() : null;
                    if (!P || HK == null || HK.isEmpty()) {
                        this.aEL.IB();
                    } else {
                        this.aEL.O(HK);
                    }
                    if (!this.mIsLogin && HK != null && !HK.isEmpty()) {
                        this.aEL.O(HK);
                    }
                } else {
                    this.aEL.IB();
                    this.aEL.bL(false);
                }
            }
            J(HD == null ? null : HD.HG());
        }
    }

    private void J(List<ae> list) {
        if (list != null) {
            int eH = this.aEM.eH(0);
            if (eH == 0) {
                if (list.size() > 8) {
                    eH = 2;
                } else {
                    eH = 1;
                }
            }
            this.aEL.eK(eH);
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.aEL.R(this.aEM.a(list, this.aEM.Ih()));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.aEL.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.aEQ = false;
        if (!isShow()) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        this.aEL.onResume();
        bI(false);
        if (this.aEL.Iu()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Boolean.valueOf(isPrimary())));
        }
        if (!isPrimary() && this.aFa != null) {
            this.aFa.dismiss();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        As();
        com.baidu.tieba.enterForum.c.a.HT().destroy();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aEL.onChangeSkinType(i);
    }

    public void As() {
        this.aEM.cancelLoadData();
    }

    public void bI(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.aEY && this.aEM != null) {
            String str = this.aEO;
            this.aEO = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.aEO == null || this.aEO.equals(str)) {
                z2 = false;
                z3 = false;
            } else {
                z2 = false;
                z3 = true;
            }
            if (TbadkCoreApplication.m411getInst().getLikeBarChanged()) {
                TbadkCoreApplication.m411getInst().setLikeBarChanged(false);
                z3 = true;
            }
            boolean z4 = z ? true : z3;
            if (TbadkCoreApplication.m411getInst().signedForumCount() > 0) {
                if (this.aEM != null && this.aEM.Id() != null && this.aEM.Id().HD() != null) {
                    Iterator<ae> it = this.aEM.Id().HD().HG().iterator();
                    while (it.hasNext()) {
                        ae next = it.next();
                        if (TbadkCoreApplication.m411getInst().hasSignedForum(next.getName())) {
                            next.iK(1);
                            int signLevelUpValue = TbadkCoreApplication.m411getInst().getSignLevelUpValue(next.getName());
                            if (signLevelUpValue > 0) {
                                next.setLevel(signLevelUpValue);
                            }
                        }
                    }
                }
                TbadkCoreApplication.m411getInst().clearSignedForum();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    com.baidu.tieba.tbadkCore.util.j.jG(currentAccount);
                }
                this.aEL.notifyDataSetChanged();
            }
            if (z2 || z4) {
                As();
                if (z4) {
                    this.aEL.no();
                } else if (z2) {
                    this.aEM.bK(StringUtils.isNull(this.aEO) ? false : true);
                    this.aEL.no();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        new i(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int Br = bVar.Br();
        com.baidu.tbadk.mvc.b.a Bs = bVar.Bs();
        switch (Br) {
            case 1:
                if (Bs instanceof ae) {
                    String name = ((ae) Bs).getName();
                    if (bb.aT(name)) {
                        TiebaStatic.eventStat(this.azk.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aEQ = true;
                        sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.azk.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE)));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, true));
                this.aEL.eI(Bs instanceof com.baidu.tieba.enterForum.b.d ? ((com.baidu.tieba.enterForum.b.d) Bs).getPosition() : 0);
                this.aER = false;
                if (getView() != null && getView().getParent() != null) {
                    getView().getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 3:
                return true;
            case 4:
                if (Bs instanceof ae) {
                    a((ae) Bs);
                    return true;
                }
                return false;
            case 5:
            case 12:
            default:
                return false;
            case 6:
                ArrayList arrayList = new ArrayList();
                if (this.aEL.Ir() != null) {
                    arrayList.addAll(this.aEL.Ir());
                }
                List<ae> L = this.aEM.L(this.aEL.Ir());
                if (!arrayList.isEmpty() && this.aEM.b(arrayList, L)) {
                    showToast(t.enter_forum_sort_already);
                } else {
                    this.aEL.N(L);
                }
                return true;
            case 7:
                this.aEL.It();
                return true;
            case 8:
                HR();
                return true;
            case 9:
                this.aEL.IA();
                if (!this.mIsLogin) {
                    TiebaStatic.eventStat(this.azk.getPageContext().getPageActivity(), "notlogin_7", "click", 1, new Object[0]);
                }
                return true;
            case 10:
                if (Bs instanceof com.baidu.tieba.enterForum.b.e) {
                    com.baidu.tieba.enterForum.b.e eVar = (com.baidu.tieba.enterForum.b.e) Bs;
                    String forumName = eVar.getForumName();
                    String valueOf = String.valueOf(eVar.getForumId());
                    if (bb.aT(forumName)) {
                        TiebaStatic.eventStat(this.azk.getPageContext().getPageActivity(), "recom_flist_like", "click", 1, "dev_id", valueOf);
                        this.LI.ba(forumName, valueOf);
                        return true;
                    }
                    return false;
                }
                return false;
            case 11:
                if (Bs instanceof com.baidu.tieba.enterForum.b.e) {
                    com.baidu.tieba.enterForum.b.e eVar2 = (com.baidu.tieba.enterForum.b.e) Bs;
                    String forumName2 = eVar2.getForumName();
                    String valueOf2 = String.valueOf(eVar2.getForumId());
                    if (bb.aT(forumName2)) {
                        TiebaStatic.eventStat(this.azk.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aEQ = true;
                        sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.azk.getPageContext().getPageActivity()).createNormalCfg(forumName2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.eventStat(this.azk.getPageContext().getPageActivity(), "recom_flist_pic", "click", 1, "dev_id", valueOf2);
                        if (!this.mIsLogin) {
                            TiebaStatic.eventStat(this.azk.getPageContext().getPageActivity(), "notlogin_5", "click", 1, new Object[0]);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage(2902023, new SingleSquareActivityConfig(this.azk.getPageContext().getPageActivity())));
                if (!this.mIsLogin) {
                    TiebaStatic.eventStat(this.azk.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                return true;
            case 14:
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new com.baidu.tbadk.core.frameworkData.c(this.azk.getPageContext().getPageActivity())));
                if (!this.mIsLogin) {
                    TiebaStatic.eventStat(this.azk.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                return true;
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean AM() {
        return false;
    }
}
