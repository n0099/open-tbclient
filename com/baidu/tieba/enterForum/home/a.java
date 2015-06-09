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
    private String aEP;
    private boolean aES;
    private long aET;
    private ViewEventCenter aEU;
    private boolean aEV;
    private com.baidu.tbadk.core.view.b aEW;
    private boolean aEZ;
    private com.baidu.tbadk.core.dialog.a aFb;
    private BaseFragmentActivity azl;
    private com.baidu.tieba.enterForum.d.e aEM = null;
    private com.baidu.tieba.enterForum.c.c aEN = null;
    private boolean isFirst = true;
    private boolean aEO = false;
    private long aEQ = -1;
    private boolean aER = false;
    private boolean aEX = true;
    private com.baidu.adp.framework.listener.a aEY = new b(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private CustomMessageListener aFa = new j(this, 2007008);
    private com.baidu.adp.base.i aFc = new k(this);
    private final com.baidu.tieba.enterForum.c.h aFd = new l(this);
    private aj aaa = new m(this);

    static {
        HM();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.aEX = bundle.getBoolean("key_first_start_maintab", true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBoolean("key_first_start_maintab", this.aEX);
        super.onSaveInstanceState(bundle);
    }

    private static void HM() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean HN() {
        return (this.aEN.b(this.aEM.Iz(), this.aEM.IA()) && (this.aEM.Im() == this.aEM.Iq())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HO() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, false));
        this.aEM.Ix();
    }

    private void HP() {
        registerListener(new n(this, 2007010));
        registerListener(new o(this, 2007011));
    }

    private void HQ() {
        registerListener(new p(this, 2007012));
    }

    public void HR() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getFragmentActivity());
        aVar.bu(t.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.m411getInst().getString(t.enter_forum_cancel_change), new q(this));
        aVar.b(TbadkCoreApplication.m411getInst().getString(t.cancel), new c(this));
        aVar.b(this.azl.getPageContext());
        aVar.rL();
    }

    private void HS() {
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
            aVar.cn(String.format(this.azl.getPageContext().getString(t.attention_cancel_dialog_content), aeVar.getName()));
            aVar.a(TbadkCoreApplication.m411getInst().getString(t.confirm), new f(this, aeVar));
            aVar.b(TbadkCoreApplication.m411getInst().getString(t.cancel), new g(this));
            aVar.b(getPageContext());
            aVar.rL();
        }
    }

    public void bH(boolean z) {
        if (this.aEW == null) {
            HT();
        }
        this.aEW.ar(z);
    }

    private void HT() {
        this.aEW = new com.baidu.tbadk.core.view.b(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.azl = getBaseFragmentActivity();
        this.aEU = new ViewEventCenter();
        this.aEU.addEventDelegate(this);
        registerListener(this.aFa);
        HP();
        HQ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return c(layoutInflater);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.aEY);
        this.aEQ = System.currentTimeMillis();
        initData(getArguments());
        initUI();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.aEV = this.aEN.hasShowForumEditGuide();
        com.baidu.tieba.enterForum.c.a.HU().i(getFragmentActivity(), com.baidu.adp.lib.util.n.l(getFragmentActivity()));
    }

    private View c(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(com.baidu.tieba.r.enter_forum_view, (ViewGroup) null);
    }

    private void initUI() {
        this.aEM = new com.baidu.tieba.enterForum.d.e(this, this.aEU);
        this.aEM.a(this.aaa);
        this.aEM.c(new h(this));
    }

    private void initData(Bundle bundle) {
        this.isFirst = true;
        this.aEO = false;
        this.aEP = "";
        this.aEN = new com.baidu.tieba.enterForum.c.c(this.azl.getPageContext());
        this.aEN.a(this.aFd);
        this.aET = this.aEN.Ij();
        this.LI = new af(this.azl.getPageContext());
        this.LI.setLoadDataCallBack(this.aFc);
        this.aEN.a(this.aFd);
    }

    public void e(boolean z, String str) {
        if (!z && str != null) {
            showToast(str);
        }
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null) {
            if (bVar.HD() != null && bVar.HD().rh() != null && !bVar.HD().rh().isEmpty()) {
                this.aEM.a(getPageContext(), bVar.HD().rh().get(0));
            }
            com.baidu.tieba.enterForum.b.c HE = bVar.HE();
            if (HE != null && HE.HH() != null) {
                int size = HE.HH().size();
                if (size < 5 && this.aEX && TbadkCoreApplication.isLogin()) {
                    sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getActivity()).createNormalCfg(2)));
                }
                this.aEX = false;
                if (size <= 10) {
                    if (size <= 0) {
                        if (this.mIsLogin) {
                            this.aEM.bL(true);
                        } else {
                            this.aEM.bL(false);
                        }
                    } else {
                        this.aEM.bL(false);
                    }
                    boolean P = this.aEN.P(this.aET);
                    List<com.baidu.tieba.enterForum.b.e> HL = bVar.HC() != null ? bVar.HC().HL() : null;
                    if (!P || HL == null || HL.isEmpty()) {
                        this.aEM.IC();
                    } else {
                        this.aEM.O(HL);
                    }
                    if (!this.mIsLogin && HL != null && !HL.isEmpty()) {
                        this.aEM.O(HL);
                    }
                } else {
                    this.aEM.IC();
                    this.aEM.bL(false);
                }
            }
            J(HE == null ? null : HE.HH());
        }
    }

    private void J(List<ae> list) {
        if (list != null) {
            int eH = this.aEN.eH(0);
            if (eH == 0) {
                if (list.size() > 8) {
                    eH = 2;
                } else {
                    eH = 1;
                }
            }
            this.aEM.eK(eH);
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.aEM.R(this.aEN.a(list, this.aEN.Ii()));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.aEM.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.aER = false;
        if (!isShow()) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        this.aEM.onResume();
        bI(false);
        if (this.aEM.Iv()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Boolean.valueOf(isPrimary())));
        }
        if (!isPrimary() && this.aFb != null) {
            this.aFb.dismiss();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        At();
        com.baidu.tieba.enterForum.c.a.HU().destroy();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aEM.onChangeSkinType(i);
    }

    public void At() {
        this.aEN.cancelLoadData();
    }

    public void bI(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.aEZ && this.aEN != null) {
            String str = this.aEP;
            this.aEP = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.aEP == null || this.aEP.equals(str)) {
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
                if (this.aEN != null && this.aEN.Ie() != null && this.aEN.Ie().HE() != null) {
                    Iterator<ae> it = this.aEN.Ie().HE().HH().iterator();
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
                this.aEM.notifyDataSetChanged();
            }
            if (z2 || z4) {
                At();
                if (z4) {
                    this.aEM.no();
                } else if (z2) {
                    this.aEN.bK(StringUtils.isNull(this.aEP) ? false : true);
                    this.aEM.no();
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
        int Bs = bVar.Bs();
        com.baidu.tbadk.mvc.b.a Bt = bVar.Bt();
        switch (Bs) {
            case 1:
                if (Bt instanceof ae) {
                    String name = ((ae) Bt).getName();
                    if (bb.aT(name)) {
                        TiebaStatic.eventStat(this.azl.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aER = true;
                        sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.azl.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE)));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, true));
                this.aEM.eI(Bt instanceof com.baidu.tieba.enterForum.b.d ? ((com.baidu.tieba.enterForum.b.d) Bt).getPosition() : 0);
                this.aES = false;
                if (getView() != null && getView().getParent() != null) {
                    getView().getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 3:
                return true;
            case 4:
                if (Bt instanceof ae) {
                    a((ae) Bt);
                    return true;
                }
                return false;
            case 5:
            case 12:
            default:
                return false;
            case 6:
                ArrayList arrayList = new ArrayList();
                if (this.aEM.Is() != null) {
                    arrayList.addAll(this.aEM.Is());
                }
                List<ae> L = this.aEN.L(this.aEM.Is());
                if (!arrayList.isEmpty() && this.aEN.b(arrayList, L)) {
                    showToast(t.enter_forum_sort_already);
                } else {
                    this.aEM.N(L);
                }
                return true;
            case 7:
                this.aEM.Iu();
                return true;
            case 8:
                HS();
                return true;
            case 9:
                this.aEM.IB();
                if (!this.mIsLogin) {
                    TiebaStatic.eventStat(this.azl.getPageContext().getPageActivity(), "notlogin_7", "click", 1, new Object[0]);
                }
                return true;
            case 10:
                if (Bt instanceof com.baidu.tieba.enterForum.b.e) {
                    com.baidu.tieba.enterForum.b.e eVar = (com.baidu.tieba.enterForum.b.e) Bt;
                    String forumName = eVar.getForumName();
                    String valueOf = String.valueOf(eVar.getForumId());
                    if (bb.aT(forumName)) {
                        TiebaStatic.eventStat(this.azl.getPageContext().getPageActivity(), "recom_flist_like", "click", 1, "dev_id", valueOf);
                        this.LI.ba(forumName, valueOf);
                        return true;
                    }
                    return false;
                }
                return false;
            case 11:
                if (Bt instanceof com.baidu.tieba.enterForum.b.e) {
                    com.baidu.tieba.enterForum.b.e eVar2 = (com.baidu.tieba.enterForum.b.e) Bt;
                    String forumName2 = eVar2.getForumName();
                    String valueOf2 = String.valueOf(eVar2.getForumId());
                    if (bb.aT(forumName2)) {
                        TiebaStatic.eventStat(this.azl.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aER = true;
                        sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.azl.getPageContext().getPageActivity()).createNormalCfg(forumName2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.eventStat(this.azl.getPageContext().getPageActivity(), "recom_flist_pic", "click", 1, "dev_id", valueOf2);
                        if (!this.mIsLogin) {
                            TiebaStatic.eventStat(this.azl.getPageContext().getPageActivity(), "notlogin_5", "click", 1, new Object[0]);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage(2902023, new SingleSquareActivityConfig(this.azl.getPageContext().getPageActivity())));
                if (!this.mIsLogin) {
                    TiebaStatic.eventStat(this.azl.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                return true;
            case 14:
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new com.baidu.tbadk.core.frameworkData.c(this.azl.getPageContext().getPageActivity())));
                if (!this.mIsLogin) {
                    TiebaStatic.eventStat(this.azl.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                return true;
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean AN() {
        return false;
    }
}
