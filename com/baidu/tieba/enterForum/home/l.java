package com.baidu.tieba.enterForum.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private BaseFragmentActivity aXt;
    private f bEA;
    private EnterForumModel bEC;
    private boolean bED;
    private String bEE;
    private long bEG;
    private boolean bEH;
    private long bEI;
    private com.baidu.tbadk.core.view.a bEK;
    private boolean bEL;
    private com.baidu.tbadk.core.dialog.a bEM;
    private LikeModel brQ;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tieba.enterForum.c.e bEB = null;
    private boolean bEF = false;
    private final CustomMessageListener aXu = new m(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private CustomMessageListener bEN = new w(this, CmdConfigCustom.CMD_ADVERT_SDK_BANNER_CLICK);
    private CustomMessageListener bEO = new x(this, CmdConfigCustom.CMD_AD_BANNER_NO_AD);
    private com.baidu.adp.framework.listener.a bEP = new aa(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private CustomMessageListener bEQ = new ab(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private com.baidu.adp.base.f bER = new ac(this);
    private final EnterForumModel.b bES = new ad(this);
    private final CustomMessageListener bET = new ae(this, CmdConfigCustom.CMD_FRS_SET_COMMON_ACCESS_FORUM);
    private ab.b alp = new af(this);
    private ViewEventCenter bEJ = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        Kj();
    }

    public void hq(int i) {
        if (this.bEB != null && this.bEB.WC() != null && this.bEB.WC().getLayoutParams() != null) {
            this.bEB.WC().getLayoutParams().height = i;
            this.bEB.WC().setLayoutParams(this.bEB.WC().getLayoutParams());
        }
    }

    public l(f fVar) {
        this.bEC = null;
        this.isFirst = true;
        this.bED = false;
        this.bEG = -1L;
        this.bEA = fVar;
        this.aXt = fVar.getBaseFragmentActivity();
        this.bEJ.addEventDelegate(this);
        this.bEG = System.currentTimeMillis();
        this.isFirst = true;
        this.bED = false;
        this.bEE = "";
        this.bEC = new EnterForumModel(this.aXt.getPageContext());
        this.bEI = this.bEC.Wo();
        this.brQ = new LikeModel(this.aXt.getPageContext());
        this.brQ.setLoadDataCallBack(this.bER);
        this.bEC.a(this.bES);
        com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.Wb().m(this.bEA.getFragmentActivity(), com.baidu.adp.lib.util.k.m(this.bEA.getFragmentActivity()));
        initUI();
        initListener();
    }

    private void initListener() {
        VV();
        this.bEA.registerListener(this.bEQ);
        this.bEA.registerListener(this.bEP);
        this.bEA.registerListener(this.aXu);
        this.bEA.registerListener(this.bEN);
        this.bEA.registerListener(this.bEO);
        this.bEA.registerListener(this.bET);
    }

    private static void Kj() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean VT() {
        return (this.bEC.e(this.bEB.WI(), this.bEB.WJ()) && (this.bEB.Wr() == this.bEB.Wx())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VU() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.bEB.WE();
    }

    private void VV() {
        this.bEA.registerListener(new n(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
        this.bEA.registerListener(new o(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
    }

    public void VW() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aXt.getPageContext().getPageActivity());
        aVar.bZ(w.l.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.m9getInst().getString(w.l.enter_forum_cancel_change), new p(this));
        aVar.b(TbadkCoreApplication.m9getInst().getString(w.l.cancel), new q(this));
        aVar.b(this.aXt.getPageContext());
        aVar.tQ();
    }

    private void VX() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aXt.getPageContext().getPageActivity());
        aVar.bZ(w.l.recommend_dismis_affirm);
        aVar.a(TbadkCoreApplication.m9getInst().getString(w.l.hide), new r(this));
        aVar.b(TbadkCoreApplication.m9getInst().getString(w.l.cancel), new s(this));
        aVar.b(this.aXt.getPageContext());
        aVar.tQ();
    }

    public void a(com.baidu.tieba.tbadkCore.u uVar) {
        if (uVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aXt.getPageContext().getPageActivity());
            aVar.cE(String.format(this.aXt.getPageContext().getString(w.l.attention_cancel_dialog_content), uVar.getName()));
            aVar.a(TbadkCoreApplication.m9getInst().getString(w.l.confirm), new t(this, uVar));
            aVar.b(TbadkCoreApplication.m9getInst().getString(w.l.cancel), new u(this));
            aVar.b(this.aXt.getPageContext());
            aVar.tQ();
        }
    }

    public void df(boolean z) {
        if (this.bEK == null) {
            VY();
        }
        this.bEK.aK(z);
    }

    private void VY() {
        this.bEK = new com.baidu.tbadk.core.view.a(this.aXt.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.aXt.getActivity()).inflate(w.j.enter_forum_view, (ViewGroup) null);
        this.bEB = new com.baidu.tieba.enterForum.c.e(this.bEA, this.mRootView, this.bEJ);
        this.bEB.a(this.alp);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void dg(boolean z) {
        if (this.bEB != null && this.bEA != null) {
            if (z) {
                if (this.bEA.isPrimary() && this.bEA.isResumed()) {
                    this.bEB.startPullRefresh();
                    return;
                } else {
                    this.bEB.WG();
                    return;
                }
            }
            this.bEB.WG();
        }
    }

    public void d(boolean z, String str) {
        if (!z && str != null) {
            this.aXt.showToast(str);
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_BANNER_NO_AD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.bEA.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null && this.bEB != null) {
            c(bVar);
            b(bVar);
            com.baidu.tieba.enterForum.b.e VB = bVar.VB();
            if (VB != null && VB.VG() != null) {
                int size = VB.VG().size();
                if (size <= 10) {
                    if (size <= 0) {
                        if (TbadkCoreApplication.isLogin()) {
                            this.bEB.dl(true);
                        } else {
                            this.bEB.dl(false);
                        }
                    } else {
                        this.bEB.dl(false);
                    }
                    boolean aM = this.bEC.aM(this.bEI);
                    List<com.baidu.tieba.enterForum.b.g> VK = bVar.Vx() != null ? bVar.Vx().VK() : null;
                    boolean z = aM && !com.baidu.tbadk.core.util.x.q(VK);
                    if (z) {
                        this.bEB.ah(VK);
                    } else {
                        this.bEB.WL();
                    }
                    if (!z && !TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.x.q(VK)) {
                        this.bEB.ah(VK);
                    }
                } else {
                    this.bEB.WL();
                    this.bEB.dl(false);
                }
            }
            ac(VB != null ? VB.VG() : null);
            if (TbadkCoreApplication.isLogin() && VB != null && VB.VG() != null && VB.VG().size() > 0) {
                this.bEB.setAttentionTitleVisibililty(true);
            } else {
                this.bEB.setAttentionTitleVisibililty(false);
            }
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.uL().getString("hot_search_title", ""));
            this.bEB.WM();
        }
    }

    private void b(com.baidu.tieba.enterForum.b.b bVar) {
        if (this.bEB != null) {
            this.bEB.f(bVar);
        }
    }

    private void c(com.baidu.tieba.enterForum.b.b bVar) {
        if (com.baidu.adp.lib.b.e.eY().Y("ad_baichuan_open") != 0 && this.bEB != null) {
            View bannerView = this.bEB.getBannerView();
            if (bannerView == null) {
                View bannerView2 = getBannerView();
                if (bannerView2 != null) {
                    this.bEB.ae(bannerView2);
                    this.bEF = false;
                }
            } else if (this.bEF) {
                View bannerView3 = getBannerView();
                if (bannerView3 != null) {
                    this.bEB.ae(bannerView3);
                    TiebaStatic.log(new as("c10807"));
                    this.bEF = false;
                }
            } else {
                ac(bannerView);
            }
        }
    }

    private void ac(View view) {
        if (view != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_RELOAD_BANNER, view));
        }
    }

    private View getBannerView() {
        int af = com.baidu.adp.lib.util.k.af(this.aXt.getActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_BANNER, View.class, new com.baidu.tbadk.coreExtra.data.e(this.aXt.getPageContext(), (int) ((0.16875f * af) + 0.5d), af, true));
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof View)) {
            return null;
        }
        return (View) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.bEB.setSearchHint(str.trim());
        } else {
            this.bEB.setSearchHint(this.aXt.getActivity().getString(w.l.enter_forum_search_tip));
        }
    }

    private void ac(List<com.baidu.tieba.tbadkCore.u> list) {
        if (list != null) {
            int hs = this.bEC.hs(0);
            if (hs == 0) {
                if (list.size() > 8) {
                    hs = 2;
                } else {
                    hs = 1;
                }
            }
            this.bEB.hv(hs);
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.bEB.ak(this.bEC.a(list, this.bEC.Wn()));
        }
    }

    public void Oc() {
        if (this.bEB != null) {
            dh(false);
            if (!this.bEA.isPrimary() && this.bEM != null) {
                this.bEM.dismiss();
            }
        }
    }

    public void onDestroy() {
        EP();
        com.baidu.tieba.enterForum.model.a.Wb().destroy();
        if (this.bEB != null && this.bEB.getBannerView() != null) {
            MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BC_BANNER_STOP_LOAD, this.bEB.getBannerView()), (Class) null);
        }
        if (this.bEB != null) {
            this.bEB.onDestory();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bEB != null) {
            this.bEB.onChangeSkinType(i);
        }
    }

    public void EP() {
        if (this.bEC != null) {
            this.bEC.cancelLoadData();
        }
    }

    public void dh(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.bEL && this.bEC != null && this.bEB != null) {
            String str = this.bEE;
            this.bEE = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.bEE == null || this.bEE.equals(str)) {
                z2 = false;
                z3 = false;
            } else {
                z2 = false;
                z3 = true;
            }
            if (TbadkCoreApplication.m9getInst().getLikeBarChanged()) {
                TbadkCoreApplication.m9getInst().setLikeBarChanged(false);
                z3 = true;
            }
            boolean z4 = z ? true : z3;
            if (TbadkCoreApplication.m9getInst().signedForumCount() > 0) {
                if (this.bEC != null && this.bEC.Wk() != null && this.bEC.Wk().VB() != null) {
                    Iterator<com.baidu.tieba.tbadkCore.u> it = this.bEC.Wk().VB().VG().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.u next = it.next();
                        if (TbadkCoreApplication.m9getInst().hasSignedForum(next.getName())) {
                            next.eq(1);
                            int signLevelUpValue = TbadkCoreApplication.m9getInst().getSignLevelUpValue(next.getName());
                            if (signLevelUpValue > 0) {
                                next.setLevel(signLevelUpValue);
                            }
                        }
                    }
                }
                TbadkCoreApplication.m9getInst().clearSignedForum();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    com.baidu.tieba.tbadkCore.util.l.qg(currentAccount);
                }
                this.bEB.notifyDataSetChanged();
            }
            if (z2 || z4) {
                EP();
                if (z4) {
                    this.bEB.startPullRefresh();
                } else if (z2) {
                    this.bEC.dk(StringUtils.isNull(this.bEE) ? false : true);
                    this.bEB.startPullRefresh();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar == null) {
        }
    }

    public void onPause() {
        if (this.bEB != null && this.bEB.WB() != null) {
            this.bEB.WB().completePullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<com.baidu.tieba.tbadkCore.u, Integer, String> {
        private com.baidu.tieba.tbadkCore.u bFb;
        private com.baidu.tbadk.core.util.z mNetwork = null;

        public a(com.baidu.tieba.tbadkCore.u uVar) {
            this.bFb = null;
            this.bFb = uVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.tbadkCore.u... uVarArr) {
            com.baidu.tieba.tbadkCore.u uVar = this.bFb;
            if (uVar != null) {
                try {
                    if (uVar.getId() != null && uVar.getName() != null) {
                        this.mNetwork = new com.baidu.tbadk.core.util.z(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                        this.mNetwork.n("fid", uVar.getId());
                        this.mNetwork.n("kw", uVar.getName());
                        this.mNetwork.vw().wp().mIsNeedTbs = true;
                        this.mNetwork.uY();
                        return null;
                    }
                    return null;
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    return null;
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            l.this.df(false);
            if (this.mNetwork != null) {
                if (!this.mNetwork.vw().wq().isRequestSuccess()) {
                    if (l.this.aXt != null) {
                        if (StringUtils.isNull(this.mNetwork.getErrorString())) {
                            if (l.this.bEA.isAdded()) {
                                l.this.aXt.showToast(l.this.aXt.getActivity().getString(w.l.delete_like_fail));
                                return;
                            }
                            return;
                        }
                        l.this.aXt.showToast(this.mNetwork.getErrorString());
                        return;
                    }
                    return;
                }
                l.this.bEH = true;
                if (l.this.bEA.isAdded() && l.this.aXt != null) {
                    l.this.aXt.showToast(l.this.aXt.getActivity().getString(w.l.unlike_success));
                }
                TbadkCoreApplication.m9getInst().setLikeBarChanged(true);
                l.this.e(false, this.bFb.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.bFb.getId()));
                long c = com.baidu.adp.lib.g.b.c(this.bFb.getId(), 0L);
                if (c > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                }
                l.this.bEB.b(this.bFb);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            l.this.df(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fr();
                this.mNetwork = null;
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, String str) {
        new v(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int Fl = bVar.Fl();
        com.baidu.tbadk.mvc.b.a Fm = bVar.Fm();
        switch (Fl) {
            case 1:
                if (Fm instanceof com.baidu.tieba.tbadkCore.u) {
                    String name = ((com.baidu.tieba.tbadkCore.u) Fm).getName();
                    if (au.aB(name)) {
                        TiebaStatic.eventStat(this.aXt.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aXt.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aXt.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE, il(name))));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("enter_forum_edit_mode", true);
                this.bEB.ht(Fm instanceof com.baidu.tieba.enterForum.b.f ? ((com.baidu.tieba.enterForum.b.f) Fm).getPosition() : 0);
                this.bEH = false;
                if (this.bEA.getView() != null && this.bEA.getView().getParent() != null) {
                    this.bEA.getView().getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 3:
                return true;
            case 4:
                if (Fm instanceof com.baidu.tieba.tbadkCore.u) {
                    a((com.baidu.tieba.tbadkCore.u) Fm);
                    return true;
                }
                return false;
            case 5:
            case 12:
            default:
                return false;
            case 6:
                ArrayList arrayList = new ArrayList();
                if (this.bEB.Wz() != null) {
                    arrayList.addAll(this.bEB.Wz());
                }
                List<com.baidu.tieba.tbadkCore.u> ae = this.bEC.ae(this.bEB.Wz());
                if (!arrayList.isEmpty() && this.bEC.e(arrayList, ae)) {
                    this.aXt.showToast(w.l.enter_forum_sort_already);
                } else {
                    this.bEB.ag(ae);
                }
                return true;
            case 7:
                this.bEB.WA();
                return true;
            case 8:
                VX();
                return true;
            case 9:
                this.bEB.WK();
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aXt.getPageContext().getPageActivity(), "notlogin_7", "click", 1, new Object[0]);
                }
                return true;
            case 10:
                if (Fm instanceof com.baidu.tieba.enterForum.b.g) {
                    com.baidu.tieba.enterForum.b.g gVar = (com.baidu.tieba.enterForum.b.g) Fm;
                    String forumName = gVar.getForumName();
                    String valueOf = String.valueOf(gVar.getForumId());
                    if (au.aB(forumName)) {
                        TiebaStatic.log(new as("c10358").aa("fid", valueOf));
                        TiebaStatic.eventStat(this.aXt.getPageContext().getPageActivity(), "recom_flist_like", "click", 1, "dev_id", valueOf);
                        this.brQ.bZ(forumName, valueOf);
                        return true;
                    }
                    return false;
                }
                return false;
            case 11:
                if (Fm instanceof com.baidu.tieba.enterForum.b.g) {
                    com.baidu.tieba.enterForum.b.g gVar2 = (com.baidu.tieba.enterForum.b.g) Fm;
                    String forumName2 = gVar2.getForumName();
                    String valueOf2 = String.valueOf(gVar2.getForumId());
                    if (au.aB(forumName2)) {
                        TiebaStatic.log(new as("c10357").aa("fid", valueOf2));
                        TiebaStatic.eventStat(this.aXt.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aXt.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aXt.getPageContext().getPageActivity()).createNormalCfg(forumName2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.eventStat(this.aXt.getPageContext().getPageActivity(), "recom_flist_pic", "click", 1, "dev_id", valueOf2);
                        if (!TbadkCoreApplication.isLogin()) {
                            TiebaStatic.eventStat(this.aXt.getPageContext().getPageActivity(), "notlogin_5", "click", 1, new Object[0]);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aXt.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aXt.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                return true;
            case 14:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aXt.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aXt.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log("c10362");
                return true;
        }
    }

    private boolean il(String str) {
        if (this.bEC == null || this.bEC.Wk() == null || this.bEC.Wk().Vy() == null) {
            return false;
        }
        List<com.baidu.tbadk.data.e> VD = this.bEC.Wk().Vy().VD();
        if (com.baidu.tbadk.core.util.x.q(VD)) {
            return false;
        }
        for (com.baidu.tbadk.data.e eVar : VD) {
            if (eVar != null && eVar.getForumName() != null && eVar.getForumName().equals(str)) {
                return !com.baidu.tbadk.core.util.x.q(eVar.CE());
            }
        }
        return false;
    }

    public void VZ() {
        if (this.bEB != null) {
            this.bEB.WF();
        }
    }

    public boolean Wa() {
        if (this.bEB != null) {
            return this.bEB.Wa();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Fk() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.aXt.getUniqueId();
    }

    public void di(boolean z) {
        int i = 1;
        if (this.bEB != null && this.bEA != null) {
            boolean z2 = this.bEB.Wa() && this.bEA.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
