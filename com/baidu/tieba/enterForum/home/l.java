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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.t;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.c.c;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private com.baidu.tieba.tbadkCore.x Ge;
    private BaseFragmentActivity aTi;
    private e bGI;
    private com.baidu.tieba.enterForum.c.c bGK;
    private boolean bGL;
    private String bGM;
    private long bGO;
    private boolean bGP;
    private long bGQ;
    private com.baidu.tbadk.core.view.a bGR;
    private boolean bGS;
    private com.baidu.tbadk.core.dialog.a bGT;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tieba.enterForum.e.e bGJ = null;
    private boolean bGN = false;
    private final CustomMessageListener aTj = new m(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final CustomMessageListener bGU = new w(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private CustomMessageListener bGV = new y(this, CmdConfigCustom.CMD_ADVERT_SDK_BANNER_CLICK);
    private CustomMessageListener bGW = new z(this, CmdConfigCustom.CMD_AD_BANNER_NO_AD);
    private com.baidu.adp.framework.listener.a bGX = new ac(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private CustomMessageListener bGY = new ad(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private com.baidu.adp.base.g bGZ = new ae(this);
    private final c.b bHa = new af(this);
    private final CustomMessageListener bHb = new ag(this, CmdConfigCustom.CMD_FRS_SET_COMMON_ACCESS_FORUM);
    private t.b agd = new n(this);
    private ViewEventCenter aOw = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        Kt();
    }

    public void hq(int i) {
        if (this.bGJ != null && this.bGJ.Ye() != null && this.bGJ.Ye().getLayoutParams() != null) {
            this.bGJ.Ye().getLayoutParams().height = i;
            this.bGJ.Ye().setLayoutParams(this.bGJ.Ye().getLayoutParams());
        }
    }

    public l(e eVar) {
        this.bGK = null;
        this.isFirst = true;
        this.bGL = false;
        this.bGO = -1L;
        this.bGI = eVar;
        this.aTi = eVar.getBaseFragmentActivity();
        this.aOw.addEventDelegate(this);
        this.bGO = System.currentTimeMillis();
        this.isFirst = true;
        this.bGL = false;
        this.bGM = "";
        this.bGK = new com.baidu.tieba.enterForum.c.c(this.aTi.getPageContext());
        this.bGQ = this.bGK.XR();
        this.Ge = new com.baidu.tieba.tbadkCore.x(this.aTi.getPageContext());
        this.Ge.setLoadDataCallBack(this.bGZ);
        this.bGK.a(this.bHa);
        com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.c.a.XD().k(this.bGI.getFragmentActivity(), com.baidu.adp.lib.util.k.m(this.bGI.getFragmentActivity()));
        initUI();
        UA();
    }

    private void UA() {
        Xx();
        this.bGI.registerListener(this.bGY);
        this.bGI.registerListener(this.bGX);
        this.bGI.registerListener(this.aTj);
        this.bGI.registerListener(this.bGU);
        this.bGI.registerListener(this.bGV);
        this.bGI.registerListener(this.bGW);
        this.bGI.registerListener(this.bHb);
    }

    private static void Kt() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Xv() {
        return (this.bGK.e(this.bGJ.Yk(), this.bGJ.Yl()) && (this.bGJ.XU() == this.bGJ.XZ())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xw() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.bGJ.Yg();
    }

    private void Xx() {
        this.bGI.registerListener(new o(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
        this.bGI.registerListener(new p(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
    }

    public void Xy() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aTi.getPageContext().getPageActivity());
        aVar.bZ(t.j.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.m9getInst().getString(t.j.enter_forum_cancel_change), new q(this));
        aVar.b(TbadkCoreApplication.m9getInst().getString(t.j.cancel), new r(this));
        aVar.b(this.aTi.getPageContext());
        aVar.sX();
    }

    private void Xz() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aTi.getPageContext().getPageActivity());
        aVar.bZ(t.j.recommend_dismis_affirm);
        aVar.a(TbadkCoreApplication.m9getInst().getString(t.j.hide), new s(this));
        aVar.b(TbadkCoreApplication.m9getInst().getString(t.j.cancel), new t(this));
        aVar.b(this.aTi.getPageContext());
        aVar.sX();
    }

    public void a(com.baidu.tieba.tbadkCore.w wVar) {
        if (wVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aTi.getPageContext().getPageActivity());
            aVar.cB(String.format(this.aTi.getPageContext().getString(t.j.attention_cancel_dialog_content), wVar.getName()));
            aVar.a(TbadkCoreApplication.m9getInst().getString(t.j.confirm), new u(this, wVar));
            aVar.b(TbadkCoreApplication.m9getInst().getString(t.j.cancel), new v(this));
            aVar.b(this.aTi.getPageContext());
            aVar.sX();
        }
    }

    public void di(boolean z) {
        if (this.bGR == null) {
            XA();
        }
        this.bGR.aF(z);
    }

    private void XA() {
        this.bGR = new com.baidu.tbadk.core.view.a(this.aTi.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.aTi.getActivity()).inflate(t.h.enter_forum_view, (ViewGroup) null);
        this.bGJ = new com.baidu.tieba.enterForum.e.e(this.bGI, this.mRootView, this.aOw);
        this.bGJ.a(this.agd);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void dj(boolean z) {
        if (this.bGJ != null && this.bGI != null) {
            if (z) {
                if (this.bGI.isPrimary() && this.bGI.isResumed()) {
                    this.bGJ.kv();
                    return;
                } else {
                    this.bGJ.Yi();
                    return;
                }
            }
            this.bGJ.Yi();
        }
    }

    public void e(boolean z, String str) {
        if (!z && str != null) {
            this.aTi.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.bGI.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null && this.bGJ != null) {
            c(bVar);
            d(bVar);
            b(bVar);
            com.baidu.tieba.enterForum.b.e Xe = bVar.Xe();
            if (Xe != null && Xe.Xj() != null) {
                int size = Xe.Xj().size();
                if (size <= 10) {
                    if (size <= 0) {
                        if (TbadkCoreApplication.isLogin()) {
                            this.bGJ.m13do(true);
                        } else {
                            this.bGJ.m13do(false);
                        }
                    } else {
                        this.bGJ.m13do(false);
                    }
                    boolean bf = this.bGK.bf(this.bGQ);
                    List<com.baidu.tieba.enterForum.b.g> Xn = bVar.Xa() != null ? bVar.Xa().Xn() : null;
                    boolean z = bf && !com.baidu.tbadk.core.util.y.t(Xn);
                    if (z) {
                        this.bGJ.an(Xn);
                    } else {
                        this.bGJ.Yn();
                    }
                    if (!z && !TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.y.t(Xn)) {
                        this.bGJ.an(Xn);
                    }
                } else {
                    this.bGJ.Yn();
                    this.bGJ.m13do(false);
                }
            }
            ai(Xe != null ? Xe.Xj() : null);
            if (TbadkCoreApplication.isLogin() && Xe != null && Xe.Xj() != null && Xe.Xj().size() > 0) {
                this.bGJ.setAttentionTitleVisibililty(true);
            } else {
                this.bGJ.setAttentionTitleVisibililty(false);
            }
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.tS().getString("hot_search_title", ""));
            this.bGJ.Yp();
        }
    }

    private void b(com.baidu.tieba.enterForum.b.b bVar) {
        if (this.bGJ != null) {
            this.bGJ.g(bVar);
        }
    }

    private void c(com.baidu.tieba.enterForum.b.b bVar) {
        if (com.baidu.adp.lib.c.e.dN().ac("ad_baichuan_open") != 0 && this.bGJ != null) {
            View bannerView = this.bGJ.getBannerView();
            if (bannerView == null) {
                View bannerView2 = getBannerView();
                if (bannerView2 != null) {
                    this.bGJ.aa(bannerView2);
                    this.bGN = false;
                }
            } else if (this.bGN) {
                View bannerView3 = getBannerView();
                if (bannerView3 != null) {
                    this.bGJ.aa(bannerView3);
                    TiebaStatic.log(new ay("c10807"));
                    this.bGN = false;
                }
            } else {
                Y(bannerView);
            }
        }
    }

    private void d(com.baidu.tieba.enterForum.b.b bVar) {
        View togetherHiBannerView;
        if (com.baidu.tbadk.plugins.g.GF() && this.bGJ != null && this.bGJ.getTogetherHiBannerView() == null && (togetherHiBannerView = getTogetherHiBannerView()) != null) {
            this.bGJ.ab(togetherHiBannerView);
        }
    }

    private void Y(View view) {
        if (view != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_RELOAD_BANNER, view));
        }
    }

    private View getBannerView() {
        int K = com.baidu.adp.lib.util.k.K(this.aTi.getActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_BANNER, View.class, new com.baidu.tbadk.coreExtra.data.e(this.aTi.getActivity(), (int) ((0.16875f * K) + 0.5d), K, true));
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof View)) {
            return null;
        }
        return (View) runTask.getData();
    }

    private View getTogetherHiBannerView() {
        int K = com.baidu.adp.lib.util.k.K(this.aTi.getActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_HI_GETENTERBANNER, View.class, new com.baidu.tbadk.coreExtra.data.q(this.aTi.getActivity(), this.aTi.getResources().getDimensionPixelSize(t.e.ds100), K, true));
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof View)) {
            return null;
        }
        return (View) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.bGJ.setSearchHint(str.trim());
        } else {
            this.bGJ.setSearchHint(this.aTi.getActivity().getString(t.j.enter_forum_search_tip));
        }
    }

    private void ai(List<com.baidu.tieba.tbadkCore.w> list) {
        if (list != null) {
            int hs = this.bGK.hs(0);
            if (hs == 0) {
                if (list.size() > 8) {
                    hs = 2;
                } else {
                    hs = 1;
                }
            }
            this.bGJ.hv(hs);
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.bGJ.aq(this.bGK.a(list, this.bGK.XQ()));
        }
    }

    public void Rt() {
        if (this.bGJ != null) {
            dk(false);
            if (!this.bGI.isPrimary() && this.bGT != null) {
                this.bGT.dismiss();
            }
        }
    }

    public void onDestroy() {
        Eq();
        com.baidu.tieba.enterForum.c.a.XD().destroy();
        if (this.bGJ != null && this.bGJ.getBannerView() != null) {
            MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BC_BANNER_STOP_LOAD, this.bGJ.getBannerView()), (Class) null);
        }
        if (this.bGJ != null) {
            this.bGJ.onDestory();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bGJ != null) {
            this.bGJ.onChangeSkinType(i);
        }
    }

    public void Eq() {
        if (this.bGK != null) {
            this.bGK.cancelLoadData();
        }
    }

    public void dk(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.bGS && this.bGK != null && this.bGJ != null) {
            String str = this.bGM;
            this.bGM = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.bGM == null || this.bGM.equals(str)) {
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
                if (this.bGK != null && this.bGK.XN() != null && this.bGK.XN().Xe() != null) {
                    Iterator<com.baidu.tieba.tbadkCore.w> it = this.bGK.XN().Xe().Xj().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.w next = it.next();
                        if (TbadkCoreApplication.m9getInst().hasSignedForum(next.getName())) {
                            next.eo(1);
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
                    com.baidu.tieba.tbadkCore.util.m.qY(currentAccount);
                }
                this.bGJ.notifyDataSetChanged();
            }
            if (z2 || z4) {
                Eq();
                if (z4) {
                    this.bGJ.kv();
                } else if (z2) {
                    this.bGK.dn(StringUtils.isNull(this.bGM) ? false : true);
                    this.bGJ.kv();
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
        if (this.bGJ != null && this.bGJ.Yd() != null) {
            this.bGJ.Yd().ku();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<com.baidu.tieba.tbadkCore.w, Integer, String> {
        private com.baidu.tbadk.core.util.ab aiS = null;
        private com.baidu.tieba.tbadkCore.w bHj;

        public a(com.baidu.tieba.tbadkCore.w wVar) {
            this.bHj = null;
            this.bHj = wVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.tbadkCore.w... wVarArr) {
            com.baidu.tieba.tbadkCore.w wVar = this.bHj;
            if (wVar != null) {
                try {
                    if (wVar.getId() != null && wVar.getName() != null) {
                        this.aiS = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                        this.aiS.n("fid", wVar.getId());
                        this.aiS.n("kw", wVar.getName());
                        this.aiS.uD().vz().mIsNeedTbs = true;
                        this.aiS.ue();
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
        /* renamed from: eu */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            l.this.di(false);
            if (this.aiS != null) {
                if (!this.aiS.uD().vA().oE()) {
                    if (l.this.aTi != null) {
                        if (StringUtils.isNull(this.aiS.getErrorString())) {
                            if (l.this.bGI.isAdded()) {
                                l.this.aTi.showToast(l.this.aTi.getActivity().getString(t.j.delete_like_fail));
                                return;
                            }
                            return;
                        }
                        l.this.aTi.showToast(this.aiS.getErrorString());
                        return;
                    }
                    return;
                }
                l.this.bGP = true;
                if (l.this.bGI.isAdded() && l.this.aTi != null) {
                    l.this.aTi.showToast(l.this.aTi.getActivity().getString(t.j.delete_like_success));
                }
                TbadkCoreApplication.m9getInst().setLikeBarChanged(true);
                l.this.f(false, this.bHj.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.bHj.getId()));
                long c = com.baidu.adp.lib.h.b.c(this.bHj.getId(), 0L);
                if (c > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                }
                l.this.bGJ.b(this.bHj);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            l.this.di(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiS != null) {
                this.aiS.eg();
                this.aiS = null;
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        new x(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int EL = bVar.EL();
        com.baidu.tbadk.mvc.b.a EM = bVar.EM();
        switch (EL) {
            case 1:
                if (EM instanceof com.baidu.tieba.tbadkCore.w) {
                    String name = ((com.baidu.tieba.tbadkCore.w) EM).getName();
                    if (ba.aN(name)) {
                        TiebaStatic.eventStat(this.aTi.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aTi.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aTi.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE, jl(name))));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("enter_forum_edit_mode", true);
                this.bGJ.ht(EM instanceof com.baidu.tieba.enterForum.b.f ? ((com.baidu.tieba.enterForum.b.f) EM).getPosition() : 0);
                this.bGP = false;
                if (this.bGI.getView() != null && this.bGI.getView().getParent() != null) {
                    this.bGI.getView().getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 3:
                return true;
            case 4:
                if (EM instanceof com.baidu.tieba.tbadkCore.w) {
                    a((com.baidu.tieba.tbadkCore.w) EM);
                    return true;
                }
                return false;
            case 5:
            case 12:
            default:
                return false;
            case 6:
                ArrayList arrayList = new ArrayList();
                if (this.bGJ.Yb() != null) {
                    arrayList.addAll(this.bGJ.Yb());
                }
                List<com.baidu.tieba.tbadkCore.w> ak = this.bGK.ak(this.bGJ.Yb());
                if (!arrayList.isEmpty() && this.bGK.e(arrayList, ak)) {
                    this.aTi.showToast(t.j.enter_forum_sort_already);
                } else {
                    this.bGJ.am(ak);
                }
                return true;
            case 7:
                this.bGJ.Yc();
                return true;
            case 8:
                Xz();
                return true;
            case 9:
                this.bGJ.Ym();
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aTi.getPageContext().getPageActivity(), "notlogin_7", "click", 1, new Object[0]);
                }
                return true;
            case 10:
                if (EM instanceof com.baidu.tieba.enterForum.b.g) {
                    com.baidu.tieba.enterForum.b.g gVar = (com.baidu.tieba.enterForum.b.g) EM;
                    String forumName = gVar.getForumName();
                    String valueOf = String.valueOf(gVar.getForumId());
                    if (ba.aN(forumName)) {
                        TiebaStatic.log(new ay("c10358").ab("fid", valueOf));
                        TiebaStatic.eventStat(this.aTi.getPageContext().getPageActivity(), "recom_flist_like", "click", 1, "dev_id", valueOf);
                        this.Ge.bP(forumName, valueOf);
                        return true;
                    }
                    return false;
                }
                return false;
            case 11:
                if (EM instanceof com.baidu.tieba.enterForum.b.g) {
                    com.baidu.tieba.enterForum.b.g gVar2 = (com.baidu.tieba.enterForum.b.g) EM;
                    String forumName2 = gVar2.getForumName();
                    String valueOf2 = String.valueOf(gVar2.getForumId());
                    if (ba.aN(forumName2)) {
                        TiebaStatic.log(new ay("c10357").ab("fid", valueOf2));
                        TiebaStatic.eventStat(this.aTi.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aTi.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aTi.getPageContext().getPageActivity()).createNormalCfg(forumName2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.eventStat(this.aTi.getPageContext().getPageActivity(), "recom_flist_pic", "click", 1, "dev_id", valueOf2);
                        if (!TbadkCoreApplication.isLogin()) {
                            TiebaStatic.eventStat(this.aTi.getPageContext().getPageActivity(), "notlogin_5", "click", 1, new Object[0]);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aTi.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aTi.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                return true;
            case 14:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aTi.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aTi.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log("c10362");
                return true;
        }
    }

    private boolean jl(String str) {
        if (this.bGK == null || this.bGK.XN() == null || this.bGK.XN().Xb() == null) {
            return false;
        }
        List<com.baidu.tbadk.data.e> Xg = this.bGK.XN().Xb().Xg();
        if (com.baidu.tbadk.core.util.y.t(Xg)) {
            return false;
        }
        for (com.baidu.tbadk.data.e eVar : Xg) {
            if (eVar != null && eVar.getForumName() != null && eVar.getForumName().equals(str)) {
                return !com.baidu.tbadk.core.util.y.t(eVar.BW());
            }
        }
        return false;
    }

    public void XB() {
        if (this.bGJ != null) {
            this.bGJ.Yh();
        }
    }

    public boolean XC() {
        if (this.bGJ != null) {
            return this.bGJ.XC();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean lI() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.aTi.getUniqueId();
    }

    public void dl(boolean z) {
        int i = 1;
        if (this.bGJ != null && this.bGI != null) {
            boolean z2 = this.bGJ.XC() && this.bGI.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
