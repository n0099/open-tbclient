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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.z;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.c.c;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private com.baidu.tieba.tbadkCore.x Gg;
    private BaseFragmentActivity aWd;
    private f bJL;
    private com.baidu.tieba.enterForum.c.c bJN;
    private boolean bJO;
    private String bJP;
    private long bJR;
    private boolean bJS;
    private long bJT;
    private com.baidu.tbadk.core.view.a bJU;
    private boolean bJV;
    private com.baidu.tbadk.core.dialog.a bJW;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tieba.enterForum.d.e bJM = null;
    private boolean bJQ = false;
    private final CustomMessageListener aWe = new m(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private CustomMessageListener bJX = new w(this, CmdConfigCustom.CMD_ADVERT_SDK_BANNER_CLICK);
    private CustomMessageListener bJY = new x(this, CmdConfigCustom.CMD_AD_BANNER_NO_AD);
    private com.baidu.adp.framework.listener.a bJZ = new aa(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private CustomMessageListener bKa = new ab(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private com.baidu.adp.base.g bKb = new ac(this);
    private final c.b bKc = new ad(this);
    private final CustomMessageListener bKd = new ae(this, CmdConfigCustom.CMD_FRS_SET_COMMON_ACCESS_FORUM);
    private z.b ahd = new af(this);
    private ViewEventCenter aRS = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        Jv();
    }

    public void hv(int i) {
        if (this.bJM != null && this.bJM.Zy() != null && this.bJM.Zy().getLayoutParams() != null) {
            this.bJM.Zy().getLayoutParams().height = i;
            this.bJM.Zy().setLayoutParams(this.bJM.Zy().getLayoutParams());
        }
    }

    public l(f fVar) {
        this.bJN = null;
        this.isFirst = true;
        this.bJO = false;
        this.bJR = -1L;
        this.bJL = fVar;
        this.aWd = fVar.getBaseFragmentActivity();
        this.aRS.addEventDelegate(this);
        this.bJR = System.currentTimeMillis();
        this.isFirst = true;
        this.bJO = false;
        this.bJP = "";
        this.bJN = new com.baidu.tieba.enterForum.c.c(this.aWd.getPageContext());
        this.bJT = this.bJN.Zm();
        this.Gg = new com.baidu.tieba.tbadkCore.x(this.aWd.getPageContext());
        this.Gg.setLoadDataCallBack(this.bKb);
        this.bJN.a(this.bKc);
        com.baidu.tbadk.core.sharedPref.b.um().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.c.a.YZ().j(this.bJL.getFragmentActivity(), com.baidu.adp.lib.util.k.m(this.bJL.getFragmentActivity()));
        initUI();
        VV();
    }

    private void VV() {
        YT();
        this.bJL.registerListener(this.bKa);
        this.bJL.registerListener(this.bJZ);
        this.bJL.registerListener(this.aWe);
        this.bJL.registerListener(this.bJX);
        this.bJL.registerListener(this.bJY);
        this.bJL.registerListener(this.bKd);
    }

    private static void Jv() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean YR() {
        return (this.bJN.g(this.bJM.ZE(), this.bJM.ZF()) && (this.bJM.Zp() == this.bJM.Zt())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YS() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.bJM.ZA();
    }

    private void YT() {
        this.bJL.registerListener(new n(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
        this.bJL.registerListener(new o(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
    }

    public void YU() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aWd.getPageContext().getPageActivity());
        aVar.ca(r.j.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.m9getInst().getString(r.j.enter_forum_cancel_change), new p(this));
        aVar.b(TbadkCoreApplication.m9getInst().getString(r.j.cancel), new q(this));
        aVar.b(this.aWd.getPageContext());
        aVar.tq();
    }

    private void YV() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aWd.getPageContext().getPageActivity());
        aVar.ca(r.j.recommend_dismis_affirm);
        aVar.a(TbadkCoreApplication.m9getInst().getString(r.j.hide), new r(this));
        aVar.b(TbadkCoreApplication.m9getInst().getString(r.j.cancel), new s(this));
        aVar.b(this.aWd.getPageContext());
        aVar.tq();
    }

    public void a(com.baidu.tieba.tbadkCore.w wVar) {
        if (wVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aWd.getPageContext().getPageActivity());
            aVar.cF(String.format(this.aWd.getPageContext().getString(r.j.attention_cancel_dialog_content), wVar.getName()));
            aVar.a(TbadkCoreApplication.m9getInst().getString(r.j.confirm), new t(this, wVar));
            aVar.b(TbadkCoreApplication.m9getInst().getString(r.j.cancel), new u(this));
            aVar.b(this.aWd.getPageContext());
            aVar.tq();
        }
    }

    /* renamed from: do  reason: not valid java name */
    public void m13do(boolean z) {
        if (this.bJU == null) {
            YW();
        }
        this.bJU.aI(z);
    }

    private void YW() {
        this.bJU = new com.baidu.tbadk.core.view.a(this.aWd.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.aWd.getActivity()).inflate(r.h.enter_forum_view, (ViewGroup) null);
        this.bJM = new com.baidu.tieba.enterForum.d.e(this.bJL, this.mRootView, this.aRS);
        this.bJM.a(this.ahd);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void dp(boolean z) {
        if (this.bJM != null && this.bJL != null) {
            if (z) {
                if (this.bJL.isPrimary() && this.bJL.isResumed()) {
                    this.bJM.kv();
                    return;
                } else {
                    this.bJM.ZC();
                    return;
                }
            }
            this.bJM.ZC();
        }
    }

    public void e(boolean z, String str) {
        if (!z && str != null) {
            this.aWd.showToast(str);
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_BANNER_NO_AD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShow() {
        return !this.bJL.isHidden();
    }

    public void a(com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null && this.bJM != null) {
            c(bVar);
            b(bVar);
            com.baidu.tieba.enterForum.b.e Yz = bVar.Yz();
            if (Yz != null && Yz.YE() != null) {
                int size = Yz.YE().size();
                if (size <= 10) {
                    if (size <= 0) {
                        if (TbadkCoreApplication.isLogin()) {
                            this.bJM.du(true);
                        } else {
                            this.bJM.du(false);
                        }
                    } else {
                        this.bJM.du(false);
                    }
                    boolean bd = this.bJN.bd(this.bJT);
                    List<com.baidu.tieba.enterForum.b.g> YI = bVar.Yv() != null ? bVar.Yv().YI() : null;
                    boolean z = bd && !com.baidu.tbadk.core.util.x.t(YI);
                    if (z) {
                        this.bJM.ao(YI);
                    } else {
                        this.bJM.ZH();
                    }
                    if (!z && !TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.x.t(YI)) {
                        this.bJM.ao(YI);
                    }
                } else {
                    this.bJM.ZH();
                    this.bJM.du(false);
                }
            }
            aj(Yz != null ? Yz.YE() : null);
            if (TbadkCoreApplication.isLogin() && Yz != null && Yz.YE() != null && Yz.YE().size() > 0) {
                this.bJM.setAttentionTitleVisibililty(true);
            } else {
                this.bJM.setAttentionTitleVisibililty(false);
            }
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.um().getString("hot_search_title", ""));
            this.bJM.ZI();
        }
    }

    private void b(com.baidu.tieba.enterForum.b.b bVar) {
        if (this.bJM != null) {
            this.bJM.f(bVar);
        }
    }

    private void c(com.baidu.tieba.enterForum.b.b bVar) {
        if (com.baidu.adp.lib.c.e.dN().ac("ad_baichuan_open") != 0 && this.bJM != null) {
            View bannerView = this.bJM.getBannerView();
            if (bannerView == null) {
                View bannerView2 = getBannerView();
                if (bannerView2 != null) {
                    this.bJM.ab(bannerView2);
                    this.bJQ = false;
                }
            } else if (this.bJQ) {
                View bannerView3 = getBannerView();
                if (bannerView3 != null) {
                    this.bJM.ab(bannerView3);
                    TiebaStatic.log(new av("c10807"));
                    this.bJQ = false;
                }
            } else {
                Z(bannerView);
            }
        }
    }

    private void Z(View view) {
        if (view != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_RELOAD_BANNER, view));
        }
    }

    private View getBannerView() {
        int K = com.baidu.adp.lib.util.k.K(this.aWd.getActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_BANNER, View.class, new com.baidu.tbadk.coreExtra.data.e(this.aWd.getPageContext(), (int) ((0.16875f * K) + 0.5d), K, true));
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof View)) {
            return null;
        }
        return (View) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHint(String str) {
        if (!StringUtils.isNull(str)) {
            this.bJM.setSearchHint(str.trim());
        } else {
            this.bJM.setSearchHint(this.aWd.getActivity().getString(r.j.enter_forum_search_tip));
        }
    }

    private void aj(List<com.baidu.tieba.tbadkCore.w> list) {
        if (list != null) {
            int hx = this.bJN.hx(0);
            if (hx == 0) {
                if (list.size() > 8) {
                    hx = 2;
                } else {
                    hx = 1;
                }
            }
            this.bJM.hA(hx);
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.bJM.ar(this.bJN.a(list, this.bJN.Zl()));
        }
    }

    public void SN() {
        if (this.bJM != null) {
            dq(false);
            if (!this.bJL.isPrimary() && this.bJW != null) {
                this.bJW.dismiss();
            }
        }
    }

    public void onDestroy() {
        Ev();
        com.baidu.tieba.enterForum.c.a.YZ().destroy();
        if (this.bJM != null && this.bJM.getBannerView() != null) {
            MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BC_BANNER_STOP_LOAD, this.bJM.getBannerView()), (Class) null);
        }
        if (this.bJM != null) {
            this.bJM.onDestory();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bJM != null) {
            this.bJM.onChangeSkinType(i);
        }
    }

    public void Ev() {
        if (this.bJN != null) {
            this.bJN.cancelLoadData();
        }
    }

    public void dq(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.bJV && this.bJN != null && this.bJM != null) {
            String str = this.bJP;
            this.bJP = TbadkCoreApplication.getCurrentAccount();
            if (this.isFirst) {
                this.isFirst = false;
                z2 = true;
                z3 = false;
            } else if (this.bJP == null || this.bJP.equals(str)) {
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
                if (this.bJN != null && this.bJN.Zi() != null && this.bJN.Zi().Yz() != null) {
                    Iterator<com.baidu.tieba.tbadkCore.w> it = this.bJN.Zi().Yz().YE().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.w next = it.next();
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
                    com.baidu.tieba.tbadkCore.util.l.rI(currentAccount);
                }
                this.bJM.notifyDataSetChanged();
            }
            if (z2 || z4) {
                Ev();
                if (z4) {
                    this.bJM.kv();
                } else if (z2) {
                    this.bJN.dt(StringUtils.isNull(this.bJP) ? false : true);
                    this.bJM.kv();
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
        if (this.bJM != null && this.bJM.Zx() != null) {
            this.bJM.Zx().ku();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<com.baidu.tieba.tbadkCore.w, Integer, String> {
        private com.baidu.tbadk.core.util.z ajm = null;
        private com.baidu.tieba.tbadkCore.w bKl;

        public a(com.baidu.tieba.tbadkCore.w wVar) {
            this.bKl = null;
            this.bKl = wVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.tbadkCore.w... wVarArr) {
            com.baidu.tieba.tbadkCore.w wVar = this.bKl;
            if (wVar != null) {
                try {
                    if (wVar.getId() != null && wVar.getName() != null) {
                        this.ajm = new com.baidu.tbadk.core.util.z(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                        this.ajm.n("fid", wVar.getId());
                        this.ajm.n("kw", wVar.getName());
                        this.ajm.uW().vR().mIsNeedTbs = true;
                        this.ajm.uy();
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
        /* renamed from: ez */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            l.this.m13do(false);
            if (this.ajm != null) {
                if (!this.ajm.uW().vS().oH()) {
                    if (l.this.aWd != null) {
                        if (StringUtils.isNull(this.ajm.getErrorString())) {
                            if (l.this.bJL.isAdded()) {
                                l.this.aWd.showToast(l.this.aWd.getActivity().getString(r.j.delete_like_fail));
                                return;
                            }
                            return;
                        }
                        l.this.aWd.showToast(this.ajm.getErrorString());
                        return;
                    }
                    return;
                }
                l.this.bJS = true;
                if (l.this.bJL.isAdded() && l.this.aWd != null) {
                    l.this.aWd.showToast(l.this.aWd.getActivity().getString(r.j.delete_like_success));
                }
                TbadkCoreApplication.m9getInst().setLikeBarChanged(true);
                l.this.f(false, this.bKl.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.bKl.getId()));
                long c = com.baidu.adp.lib.h.b.c(this.bKl.getId(), 0L);
                if (c > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                }
                l.this.bJM.b(this.bKl);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            l.this.m13do(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.ajm != null) {
                this.ajm.eg();
                this.ajm = null;
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        new v(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int EQ = bVar.EQ();
        com.baidu.tbadk.mvc.b.a ER = bVar.ER();
        switch (EQ) {
            case 1:
                if (ER instanceof com.baidu.tieba.tbadkCore.w) {
                    String name = ((com.baidu.tieba.tbadkCore.w) ER).getName();
                    if (ax.aN(name)) {
                        TiebaStatic.eventStat(this.aWd.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aWd.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aWd.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE, jw(name))));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.um().putBoolean("enter_forum_edit_mode", true);
                this.bJM.hy(ER instanceof com.baidu.tieba.enterForum.b.f ? ((com.baidu.tieba.enterForum.b.f) ER).getPosition() : 0);
                this.bJS = false;
                if (this.bJL.getView() != null && this.bJL.getView().getParent() != null) {
                    this.bJL.getView().getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 3:
                return true;
            case 4:
                if (ER instanceof com.baidu.tieba.tbadkCore.w) {
                    a((com.baidu.tieba.tbadkCore.w) ER);
                    return true;
                }
                return false;
            case 5:
            case 12:
            default:
                return false;
            case 6:
                ArrayList arrayList = new ArrayList();
                if (this.bJM.Zv() != null) {
                    arrayList.addAll(this.bJM.Zv());
                }
                List<com.baidu.tieba.tbadkCore.w> al = this.bJN.al(this.bJM.Zv());
                if (!arrayList.isEmpty() && this.bJN.g(arrayList, al)) {
                    this.aWd.showToast(r.j.enter_forum_sort_already);
                } else {
                    this.bJM.an(al);
                }
                return true;
            case 7:
                this.bJM.Zw();
                return true;
            case 8:
                YV();
                return true;
            case 9:
                this.bJM.ZG();
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aWd.getPageContext().getPageActivity(), "notlogin_7", "click", 1, new Object[0]);
                }
                return true;
            case 10:
                if (ER instanceof com.baidu.tieba.enterForum.b.g) {
                    com.baidu.tieba.enterForum.b.g gVar = (com.baidu.tieba.enterForum.b.g) ER;
                    String forumName = gVar.getForumName();
                    String valueOf = String.valueOf(gVar.getForumId());
                    if (ax.aN(forumName)) {
                        TiebaStatic.log(new av("c10358").ab("fid", valueOf));
                        TiebaStatic.eventStat(this.aWd.getPageContext().getPageActivity(), "recom_flist_like", "click", 1, "dev_id", valueOf);
                        this.Gg.bS(forumName, valueOf);
                        return true;
                    }
                    return false;
                }
                return false;
            case 11:
                if (ER instanceof com.baidu.tieba.enterForum.b.g) {
                    com.baidu.tieba.enterForum.b.g gVar2 = (com.baidu.tieba.enterForum.b.g) ER;
                    String forumName2 = gVar2.getForumName();
                    String valueOf2 = String.valueOf(gVar2.getForumId());
                    if (ax.aN(forumName2)) {
                        TiebaStatic.log(new av("c10357").ab("fid", valueOf2));
                        TiebaStatic.eventStat(this.aWd.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aWd.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aWd.getPageContext().getPageActivity()).createNormalCfg(forumName2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.eventStat(this.aWd.getPageContext().getPageActivity(), "recom_flist_pic", "click", 1, "dev_id", valueOf2);
                        if (!TbadkCoreApplication.isLogin()) {
                            TiebaStatic.eventStat(this.aWd.getPageContext().getPageActivity(), "notlogin_5", "click", 1, new Object[0]);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aWd.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aWd.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                return true;
            case 14:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aWd.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aWd.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log("c10362");
                return true;
        }
    }

    private boolean jw(String str) {
        if (this.bJN == null || this.bJN.Zi() == null || this.bJN.Zi().Yw() == null) {
            return false;
        }
        List<com.baidu.tbadk.data.e> YB = this.bJN.Zi().Yw().YB();
        if (com.baidu.tbadk.core.util.x.t(YB)) {
            return false;
        }
        for (com.baidu.tbadk.data.e eVar : YB) {
            if (eVar != null && eVar.getForumName() != null && eVar.getForumName().equals(str)) {
                return !com.baidu.tbadk.core.util.x.t(eVar.Cf());
            }
        }
        return false;
    }

    public void YX() {
        if (this.bJM != null) {
            this.bJM.ZB();
        }
    }

    public boolean YY() {
        if (this.bJM != null) {
            return this.bJM.YY();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean lL() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.aWd.getUniqueId();
    }

    public void dr(boolean z) {
        int i = 1;
        if (this.bJM != null && this.bJL != null) {
            boolean z2 = this.bJM.YY() && this.bJL.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
