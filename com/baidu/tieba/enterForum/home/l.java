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
    private BaseFragmentActivity aXw;
    private f bGR;
    private EnterForumModel bGT;
    private boolean bGU;
    private String bGV;
    private long bGX;
    private boolean bGY;
    private long bGZ;
    private com.baidu.tbadk.core.view.a bHb;
    private boolean bHc;
    private com.baidu.tbadk.core.dialog.a bHd;
    private LikeModel bui;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tieba.enterForum.c.e bGS = null;
    private boolean bGW = false;
    private final CustomMessageListener aXx = new m(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private CustomMessageListener bHe = new w(this, CmdConfigCustom.CMD_ADVERT_SDK_BANNER_CLICK);
    private CustomMessageListener bHf = new x(this, CmdConfigCustom.CMD_AD_BANNER_NO_AD);
    private com.baidu.adp.framework.listener.a bHg = new aa(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private CustomMessageListener bHh = new ab(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private com.baidu.adp.base.f bHi = new ac(this);
    private final EnterForumModel.b bHj = new ad(this);
    private final CustomMessageListener bHk = new ae(this, CmdConfigCustom.CMD_FRS_SET_COMMON_ACCESS_FORUM);
    private ab.b alq = new af(this);
    private ViewEventCenter bHa = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        Kj();
    }

    public void hw(int i) {
        if (this.bGS != null && this.bGS.XD() != null && this.bGS.XD().getLayoutParams() != null) {
            this.bGS.XD().getLayoutParams().height = i;
            this.bGS.XD().setLayoutParams(this.bGS.XD().getLayoutParams());
        }
    }

    public l(f fVar) {
        this.bGT = null;
        this.isFirst = true;
        this.bGU = false;
        this.bGX = -1L;
        this.bGR = fVar;
        this.aXw = fVar.getBaseFragmentActivity();
        this.bHa.addEventDelegate(this);
        this.bGX = System.currentTimeMillis();
        this.isFirst = true;
        this.bGU = false;
        this.bGV = "";
        this.bGT = new EnterForumModel(this.aXw.getPageContext());
        this.bGZ = this.bGT.Xp();
        this.bui = new LikeModel(this.aXw.getPageContext());
        this.bui.setLoadDataCallBack(this.bHi);
        this.bGT.a(this.bHj);
        com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.model.a.Xc().m(this.bGR.getFragmentActivity(), com.baidu.adp.lib.util.k.m(this.bGR.getFragmentActivity()));
        initUI();
        initListener();
    }

    private void initListener() {
        WW();
        this.bGR.registerListener(this.bHh);
        this.bGR.registerListener(this.bHg);
        this.bGR.registerListener(this.aXx);
        this.bGR.registerListener(this.bHe);
        this.bGR.registerListener(this.bHf);
        this.bGR.registerListener(this.bHk);
    }

    private static void Kj() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean WU() {
        return (this.bGT.e(this.bGS.XJ(), this.bGS.XK()) && (this.bGS.Xs() == this.bGS.Xy())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WV() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.bGS.XF();
    }

    private void WW() {
        this.bGR.registerListener(new n(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
        this.bGR.registerListener(new o(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
    }

    public void WX() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aXw.getPageContext().getPageActivity());
        aVar.bZ(w.l.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.m9getInst().getString(w.l.enter_forum_cancel_change), new p(this));
        aVar.b(TbadkCoreApplication.m9getInst().getString(w.l.cancel), new q(this));
        aVar.b(this.aXw.getPageContext());
        aVar.tQ();
    }

    private void WY() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aXw.getPageContext().getPageActivity());
        aVar.bZ(w.l.recommend_dismis_affirm);
        aVar.a(TbadkCoreApplication.m9getInst().getString(w.l.hide), new r(this));
        aVar.b(TbadkCoreApplication.m9getInst().getString(w.l.cancel), new s(this));
        aVar.b(this.aXw.getPageContext());
        aVar.tQ();
    }

    public void a(com.baidu.tieba.tbadkCore.u uVar) {
        if (uVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aXw.getPageContext().getPageActivity());
            aVar.cE(String.format(this.aXw.getPageContext().getString(w.l.attention_cancel_dialog_content), uVar.getName()));
            aVar.a(TbadkCoreApplication.m9getInst().getString(w.l.confirm), new t(this, uVar));
            aVar.b(TbadkCoreApplication.m9getInst().getString(w.l.cancel), new u(this));
            aVar.b(this.aXw.getPageContext());
            aVar.tQ();
        }
    }

    public void dp(boolean z) {
        if (this.bHb == null) {
            WZ();
        }
        this.bHb.aK(z);
    }

    private void WZ() {
        this.bHb = new com.baidu.tbadk.core.view.a(this.aXw.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.aXw.getActivity()).inflate(w.j.enter_forum_view, (ViewGroup) null);
        this.bGS = new com.baidu.tieba.enterForum.c.e(this.bGR, this.mRootView, this.bHa);
        this.bGS.a(this.alq);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void dq(boolean z) {
        if (this.bGS != null && this.bGR != null) {
            if (z) {
                if (this.bGR.isPrimary() && this.bGR.isResumed()) {
                    this.bGS.startPullRefresh();
                    return;
                } else {
                    this.bGS.XH();
                    return;
                }
            }
            this.bGS.XH();
        }
    }

    public void d(boolean z, String str) {
        if (!z && str != null) {
            this.aXw.showToast(str);
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_BANNER_NO_AD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.bGR.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null && this.bGS != null) {
            c(bVar);
            b(bVar);
            com.baidu.tieba.enterForum.b.e WC = bVar.WC();
            if (WC != null && WC.WH() != null) {
                int size = WC.WH().size();
                if (size <= 10) {
                    if (size <= 0) {
                        if (TbadkCoreApplication.isLogin()) {
                            this.bGS.dv(true);
                        } else {
                            this.bGS.dv(false);
                        }
                    } else {
                        this.bGS.dv(false);
                    }
                    boolean aM = this.bGT.aM(this.bGZ);
                    List<com.baidu.tieba.enterForum.b.g> WL = bVar.Wy() != null ? bVar.Wy().WL() : null;
                    boolean z = aM && !com.baidu.tbadk.core.util.x.q(WL);
                    if (z) {
                        this.bGS.ai(WL);
                    } else {
                        this.bGS.XM();
                    }
                    if (!z && !TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.x.q(WL)) {
                        this.bGS.ai(WL);
                    }
                } else {
                    this.bGS.XM();
                    this.bGS.dv(false);
                }
            }
            ad(WC != null ? WC.WH() : null);
            if (TbadkCoreApplication.isLogin() && WC != null && WC.WH() != null && WC.WH().size() > 0) {
                this.bGS.setAttentionTitleVisibililty(true);
            } else {
                this.bGS.setAttentionTitleVisibililty(false);
            }
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.uL().getString("hot_search_title", ""));
            this.bGS.XN();
        }
    }

    private void b(com.baidu.tieba.enterForum.b.b bVar) {
        if (this.bGS != null) {
            this.bGS.f(bVar);
        }
    }

    private void c(com.baidu.tieba.enterForum.b.b bVar) {
        if (com.baidu.adp.lib.b.e.eZ().Y("ad_baichuan_open") != 0 && this.bGS != null) {
            View bannerView = this.bGS.getBannerView();
            if (bannerView == null) {
                View bannerView2 = getBannerView();
                if (bannerView2 != null) {
                    this.bGS.ae(bannerView2);
                    this.bGW = false;
                }
            } else if (this.bGW) {
                View bannerView3 = getBannerView();
                if (bannerView3 != null) {
                    this.bGS.ae(bannerView3);
                    TiebaStatic.log(new as("c10807"));
                    this.bGW = false;
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
        int af = com.baidu.adp.lib.util.k.af(this.aXw.getActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_BANNER, View.class, new com.baidu.tbadk.coreExtra.data.e(this.aXw.getPageContext(), (int) ((0.16875f * af) + 0.5d), af, true));
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof View)) {
            return null;
        }
        return (View) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.bGS.setSearchHint(str.trim());
        } else {
            this.bGS.setSearchHint(this.aXw.getActivity().getString(w.l.enter_forum_search_tip));
        }
    }

    private void ad(List<com.baidu.tieba.tbadkCore.u> list) {
        if (list != null) {
            int hy = this.bGT.hy(0);
            if (hy == 0) {
                if (list.size() > 8) {
                    hy = 2;
                } else {
                    hy = 1;
                }
            }
            this.bGS.hB(hy);
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.bGS.al(this.bGT.a(list, this.bGT.Xo()));
        }
    }

    public void Ol() {
        if (this.bGS != null) {
            dr(false);
            if (!this.bGR.isPrimary() && this.bHd != null) {
                this.bHd.dismiss();
            }
        }
    }

    public void onDestroy() {
        EP();
        com.baidu.tieba.enterForum.model.a.Xc().destroy();
        if (this.bGS != null && this.bGS.getBannerView() != null) {
            MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BC_BANNER_STOP_LOAD, this.bGS.getBannerView()), (Class) null);
        }
        if (this.bGS != null) {
            this.bGS.onDestory();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bGS != null) {
            this.bGS.onChangeSkinType(i);
        }
    }

    public void EP() {
        if (this.bGT != null) {
            this.bGT.cancelLoadData();
        }
    }

    public void dr(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.bHc && this.bGT != null && this.bGS != null) {
            String str = this.bGV;
            this.bGV = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.bGV == null || this.bGV.equals(str)) {
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
                if (this.bGT != null && this.bGT.Xl() != null && this.bGT.Xl().WC() != null) {
                    Iterator<com.baidu.tieba.tbadkCore.u> it = this.bGT.Xl().WC().WH().iterator();
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
                    com.baidu.tieba.tbadkCore.util.l.qh(currentAccount);
                }
                this.bGS.notifyDataSetChanged();
            }
            if (z2 || z4) {
                EP();
                if (z4) {
                    this.bGS.startPullRefresh();
                } else if (z2) {
                    this.bGT.du(StringUtils.isNull(this.bGV) ? false : true);
                    this.bGS.startPullRefresh();
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
        if (this.bGS != null && this.bGS.XC() != null) {
            this.bGS.XC().completePullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<com.baidu.tieba.tbadkCore.u, Integer, String> {
        private com.baidu.tieba.tbadkCore.u bHs;
        private com.baidu.tbadk.core.util.z mNetwork = null;

        public a(com.baidu.tieba.tbadkCore.u uVar) {
            this.bHs = null;
            this.bHs = uVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.tbadkCore.u... uVarArr) {
            com.baidu.tieba.tbadkCore.u uVar = this.bHs;
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
            l.this.dp(false);
            if (this.mNetwork != null) {
                if (!this.mNetwork.vw().wq().isRequestSuccess()) {
                    if (l.this.aXw != null) {
                        if (StringUtils.isNull(this.mNetwork.getErrorString())) {
                            if (l.this.bGR.isAdded()) {
                                l.this.aXw.showToast(l.this.aXw.getActivity().getString(w.l.delete_like_fail));
                                return;
                            }
                            return;
                        }
                        l.this.aXw.showToast(this.mNetwork.getErrorString());
                        return;
                    }
                    return;
                }
                l.this.bGY = true;
                if (l.this.bGR.isAdded() && l.this.aXw != null) {
                    l.this.aXw.showToast(l.this.aXw.getActivity().getString(w.l.unlike_success));
                }
                TbadkCoreApplication.m9getInst().setLikeBarChanged(true);
                l.this.e(false, this.bHs.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.bHs.getId()));
                long c = com.baidu.adp.lib.g.b.c(this.bHs.getId(), 0L);
                if (c > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                }
                l.this.bGS.b(this.bHs);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            l.this.dp(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fs();
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
                        TiebaStatic.eventStat(this.aXw.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aXw.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aXw.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE, im(name))));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("enter_forum_edit_mode", true);
                this.bGS.hz(Fm instanceof com.baidu.tieba.enterForum.b.f ? ((com.baidu.tieba.enterForum.b.f) Fm).getPosition() : 0);
                this.bGY = false;
                if (this.bGR.getView() != null && this.bGR.getView().getParent() != null) {
                    this.bGR.getView().getParent().requestDisallowInterceptTouchEvent(true);
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
                if (this.bGS.XA() != null) {
                    arrayList.addAll(this.bGS.XA());
                }
                List<com.baidu.tieba.tbadkCore.u> af = this.bGT.af(this.bGS.XA());
                if (!arrayList.isEmpty() && this.bGT.e(arrayList, af)) {
                    this.aXw.showToast(w.l.enter_forum_sort_already);
                } else {
                    this.bGS.ah(af);
                }
                return true;
            case 7:
                this.bGS.XB();
                return true;
            case 8:
                WY();
                return true;
            case 9:
                this.bGS.XL();
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aXw.getPageContext().getPageActivity(), "notlogin_7", "click", 1, new Object[0]);
                }
                return true;
            case 10:
                if (Fm instanceof com.baidu.tieba.enterForum.b.g) {
                    com.baidu.tieba.enterForum.b.g gVar = (com.baidu.tieba.enterForum.b.g) Fm;
                    String forumName = gVar.getForumName();
                    String valueOf = String.valueOf(gVar.getForumId());
                    if (au.aB(forumName)) {
                        TiebaStatic.log(new as("c10358").aa("fid", valueOf));
                        TiebaStatic.eventStat(this.aXw.getPageContext().getPageActivity(), "recom_flist_like", "click", 1, "dev_id", valueOf);
                        this.bui.bY(forumName, valueOf);
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
                        TiebaStatic.eventStat(this.aXw.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aXw.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aXw.getPageContext().getPageActivity()).createNormalCfg(forumName2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.eventStat(this.aXw.getPageContext().getPageActivity(), "recom_flist_pic", "click", 1, "dev_id", valueOf2);
                        if (!TbadkCoreApplication.isLogin()) {
                            TiebaStatic.eventStat(this.aXw.getPageContext().getPageActivity(), "notlogin_5", "click", 1, new Object[0]);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aXw.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aXw.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                return true;
            case 14:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aXw.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aXw.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log("c10362");
                return true;
        }
    }

    private boolean im(String str) {
        if (this.bGT == null || this.bGT.Xl() == null || this.bGT.Xl().Wz() == null) {
            return false;
        }
        List<com.baidu.tbadk.data.e> WE = this.bGT.Xl().Wz().WE();
        if (com.baidu.tbadk.core.util.x.q(WE)) {
            return false;
        }
        for (com.baidu.tbadk.data.e eVar : WE) {
            if (eVar != null && eVar.getForumName() != null && eVar.getForumName().equals(str)) {
                return !com.baidu.tbadk.core.util.x.q(eVar.CE());
            }
        }
        return false;
    }

    public void Xa() {
        if (this.bGS != null) {
            this.bGS.XG();
        }
    }

    public boolean Xb() {
        if (this.bGS != null) {
            return this.bGS.Xb();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Fk() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.aXw.getUniqueId();
    }

    public void ds(boolean z) {
        int i = 1;
        if (this.bGS != null && this.bGR != null) {
            boolean z2 = this.bGS.Xb() && this.bGR.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
