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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.y;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.c.c;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.imageManager.b, com.baidu.tbadk.mvc.c.a {
    private com.baidu.tieba.tbadkCore.x Ge;
    private BaseFragmentActivity aTS;
    private f bGR;
    private com.baidu.tieba.enterForum.c.c bGT;
    private boolean bGU;
    private String bGV;
    private long bGX;
    private boolean bGY;
    private long bGZ;
    private com.baidu.tbadk.core.view.a bHa;
    private boolean bHb;
    private com.baidu.tbadk.core.dialog.a bHc;
    private boolean isFirst;
    private View mRootView;
    private com.baidu.tieba.enterForum.d.e bGS = null;
    private boolean bGW = false;
    private final CustomMessageListener aTT = new m(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private CustomMessageListener bHd = new w(this, CmdConfigCustom.CMD_ADVERT_SDK_BANNER_CLICK);
    private CustomMessageListener bHe = new x(this, CmdConfigCustom.CMD_AD_BANNER_NO_AD);
    private com.baidu.adp.framework.listener.a bHf = new aa(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
    private CustomMessageListener bHg = new ab(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private com.baidu.adp.base.g bHh = new ac(this);
    private final c.b bHi = new ad(this);
    private final CustomMessageListener bHj = new ae(this, CmdConfigCustom.CMD_FRS_SET_COMMON_ACCESS_FORUM);
    private y.b agD = new af(this);
    private ViewEventCenter aPL = new ViewEventCenter();

    public View getView() {
        return this.mRootView;
    }

    static {
        Jo();
    }

    public void hu(int i) {
        if (this.bGS != null && this.bGS.Yw() != null && this.bGS.Yw().getLayoutParams() != null) {
            this.bGS.Yw().getLayoutParams().height = i;
            this.bGS.Yw().setLayoutParams(this.bGS.Yw().getLayoutParams());
        }
    }

    public l(f fVar) {
        this.bGT = null;
        this.isFirst = true;
        this.bGU = false;
        this.bGX = -1L;
        this.bGR = fVar;
        this.aTS = fVar.getBaseFragmentActivity();
        this.aPL.addEventDelegate(this);
        this.bGX = System.currentTimeMillis();
        this.isFirst = true;
        this.bGU = false;
        this.bGV = "";
        this.bGT = new com.baidu.tieba.enterForum.c.c(this.aTS.getPageContext());
        this.bGZ = this.bGT.Yk();
        this.Ge = new com.baidu.tieba.tbadkCore.x(this.aTS.getPageContext());
        this.Ge.setLoadDataCallBack(this.bHh);
        this.bGT.a(this.bHi);
        com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("enter_forum_edit_mode", false);
        com.baidu.tieba.enterForum.c.a.XX().j(this.bGR.getFragmentActivity(), com.baidu.adp.lib.util.k.m(this.bGR.getFragmentActivity()));
        initUI();
        UT();
    }

    private void UT() {
        XR();
        this.bGR.registerListener(this.bHg);
        this.bGR.registerListener(this.bHf);
        this.bGR.registerListener(this.aTT);
        this.bGR.registerListener(this.bHd);
        this.bGR.registerListener(this.bHe);
        this.bGR.registerListener(this.bHj);
    }

    private static void Jo() {
        com.baidu.tieba.tbadkCore.a.a.a(303011, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean XP() {
        return (this.bGT.g(this.bGS.YC(), this.bGS.YD()) && (this.bGS.Yn() == this.bGS.Yr())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XQ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 1));
        this.bGS.Yy();
    }

    private void XR() {
        this.bGR.registerListener(new n(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
        this.bGR.registerListener(new o(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
    }

    public void XS() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aTS.getPageContext().getPageActivity());
        aVar.bZ(r.j.enter_forum_cancel_change_tip);
        aVar.a(TbadkCoreApplication.m9getInst().getString(r.j.enter_forum_cancel_change), new p(this));
        aVar.b(TbadkCoreApplication.m9getInst().getString(r.j.cancel), new q(this));
        aVar.b(this.aTS.getPageContext());
        aVar.tm();
    }

    private void XT() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aTS.getPageContext().getPageActivity());
        aVar.bZ(r.j.recommend_dismis_affirm);
        aVar.a(TbadkCoreApplication.m9getInst().getString(r.j.hide), new r(this));
        aVar.b(TbadkCoreApplication.m9getInst().getString(r.j.cancel), new s(this));
        aVar.b(this.aTS.getPageContext());
        aVar.tm();
    }

    public void a(com.baidu.tieba.tbadkCore.w wVar) {
        if (wVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aTS.getPageContext().getPageActivity());
            aVar.cD(String.format(this.aTS.getPageContext().getString(r.j.attention_cancel_dialog_content), wVar.getName()));
            aVar.a(TbadkCoreApplication.m9getInst().getString(r.j.confirm), new t(this, wVar));
            aVar.b(TbadkCoreApplication.m9getInst().getString(r.j.cancel), new u(this));
            aVar.b(this.aTS.getPageContext());
            aVar.tm();
        }
    }

    public void dj(boolean z) {
        if (this.bHa == null) {
            XU();
        }
        this.bHa.aF(z);
    }

    private void XU() {
        this.bHa = new com.baidu.tbadk.core.view.a(this.aTS.getPageContext());
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.aTS.getActivity()).inflate(r.h.enter_forum_view, (ViewGroup) null);
        this.bGS = new com.baidu.tieba.enterForum.d.e(this.bGR, this.mRootView, this.aPL);
        this.bGS.a(this.agD);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void dk(boolean z) {
        if (this.bGS != null && this.bGR != null) {
            if (z) {
                if (this.bGR.isPrimary() && this.bGR.isResumed()) {
                    this.bGS.kv();
                    return;
                } else {
                    this.bGS.YA();
                    return;
                }
            }
            this.bGS.YA();
        }
    }

    public void e(boolean z, String str) {
        if (!z && str != null) {
            this.aTS.showToast(str);
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
            com.baidu.tieba.enterForum.b.e Xx = bVar.Xx();
            if (Xx != null && Xx.XC() != null) {
                int size = Xx.XC().size();
                if (size <= 10) {
                    if (size <= 0) {
                        if (TbadkCoreApplication.isLogin()) {
                            this.bGS.dp(true);
                        } else {
                            this.bGS.dp(false);
                        }
                    } else {
                        this.bGS.dp(false);
                    }
                    boolean bf = this.bGT.bf(this.bGZ);
                    List<com.baidu.tieba.enterForum.b.g> XG = bVar.Xt() != null ? bVar.Xt().XG() : null;
                    boolean z = bf && !com.baidu.tbadk.core.util.y.t(XG);
                    if (z) {
                        this.bGS.an(XG);
                    } else {
                        this.bGS.YF();
                    }
                    if (!z && !TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.y.t(XG)) {
                        this.bGS.an(XG);
                    }
                } else {
                    this.bGS.YF();
                    this.bGS.dp(false);
                }
            }
            ai(Xx != null ? Xx.XC() : null);
            if (TbadkCoreApplication.isLogin() && Xx != null && Xx.XC() != null && Xx.XC().size() > 0) {
                this.bGS.setAttentionTitleVisibililty(true);
            } else {
                this.bGS.setAttentionTitleVisibililty(false);
            }
            setSearchHint(com.baidu.tbadk.core.sharedPref.b.uh().getString("hot_search_title", ""));
            this.bGS.YG();
        }
    }

    private void b(com.baidu.tieba.enterForum.b.b bVar) {
        if (this.bGS != null) {
            this.bGS.f(bVar);
        }
    }

    private void c(com.baidu.tieba.enterForum.b.b bVar) {
        if (com.baidu.adp.lib.c.e.dN().ac("ad_baichuan_open") != 0 && this.bGS != null) {
            View bannerView = this.bGS.getBannerView();
            if (bannerView == null) {
                View bannerView2 = getBannerView();
                if (bannerView2 != null) {
                    this.bGS.aa(bannerView2);
                    this.bGW = false;
                }
            } else if (this.bGW) {
                View bannerView3 = getBannerView();
                if (bannerView3 != null) {
                    this.bGS.aa(bannerView3);
                    TiebaStatic.log(new ax("c10807"));
                    this.bGW = false;
                }
            } else {
                Y(bannerView);
            }
        }
    }

    private void Y(View view) {
        if (view != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_RELOAD_BANNER, view));
        }
    }

    private View getBannerView() {
        int K = com.baidu.adp.lib.util.k.K(this.aTS.getActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_BANNER, View.class, new com.baidu.tbadk.coreExtra.data.e(this.aTS.getActivity(), (int) ((0.16875f * K) + 0.5d), K, true));
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
            this.bGS.setSearchHint(this.aTS.getActivity().getString(r.j.enter_forum_search_tip));
        }
    }

    private void ai(List<com.baidu.tieba.tbadkCore.w> list) {
        if (list != null) {
            int hw = this.bGT.hw(0);
            if (hw == 0) {
                if (list.size() > 8) {
                    hw = 2;
                } else {
                    hw = 1;
                }
            }
            this.bGS.hz(hw);
            if (list.size() > 500) {
                list = list.subList(0, 500);
            }
            this.bGS.aq(this.bGT.a(list, this.bGT.Yj()));
        }
    }

    public void RL() {
        if (this.bGS != null) {
            dl(false);
            if (!this.bGR.isPrimary() && this.bHc != null) {
                this.bHc.dismiss();
            }
        }
    }

    public void onDestroy() {
        Eq();
        com.baidu.tieba.enterForum.c.a.XX().destroy();
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

    public void Eq() {
        if (this.bGT != null) {
            this.bGT.cancelLoadData();
        }
    }

    public void dl(boolean z) {
        boolean z2;
        boolean z3;
        if (!this.bHb && this.bGT != null && this.bGS != null) {
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
                if (this.bGT != null && this.bGT.Yg() != null && this.bGT.Yg().Xx() != null) {
                    Iterator<com.baidu.tieba.tbadkCore.w> it = this.bGT.Yg().Xx().XC().iterator();
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
                    com.baidu.tieba.tbadkCore.util.m.rn(currentAccount);
                }
                this.bGS.notifyDataSetChanged();
            }
            if (z2 || z4) {
                Eq();
                if (z4) {
                    this.bGS.kv();
                } else if (z2) {
                    this.bGT.m13do(StringUtils.isNull(this.bGV) ? false : true);
                    this.bGS.kv();
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
        if (this.bGS != null && this.bGS.Yv() != null) {
            this.bGS.Yv().ku();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<com.baidu.tieba.tbadkCore.w, Integer, String> {
        private com.baidu.tbadk.core.util.ab aiu = null;
        private com.baidu.tieba.tbadkCore.w bHr;

        public a(com.baidu.tieba.tbadkCore.w wVar) {
            this.bHr = null;
            this.bHr = wVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(com.baidu.tieba.tbadkCore.w... wVarArr) {
            com.baidu.tieba.tbadkCore.w wVar = this.bHr;
            if (wVar != null) {
                try {
                    if (wVar.getId() != null && wVar.getName() != null) {
                        this.aiu = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                        this.aiu.n("fid", wVar.getId());
                        this.aiu.n("kw", wVar.getName());
                        this.aiu.uS().vN().mIsNeedTbs = true;
                        this.aiu.uu();
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
        /* renamed from: ex */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            l.this.dj(false);
            if (this.aiu != null) {
                if (!this.aiu.uS().vO().oF()) {
                    if (l.this.aTS != null) {
                        if (StringUtils.isNull(this.aiu.getErrorString())) {
                            if (l.this.bGR.isAdded()) {
                                l.this.aTS.showToast(l.this.aTS.getActivity().getString(r.j.delete_like_fail));
                                return;
                            }
                            return;
                        }
                        l.this.aTS.showToast(this.aiu.getErrorString());
                        return;
                    }
                    return;
                }
                l.this.bGY = true;
                if (l.this.bGR.isAdded() && l.this.aTS != null) {
                    l.this.aTS.showToast(l.this.aTS.getActivity().getString(r.j.delete_like_success));
                }
                TbadkCoreApplication.m9getInst().setLikeBarChanged(true);
                l.this.f(false, this.bHr.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, this.bHr.getId()));
                long c = com.baidu.adp.lib.h.b.c(this.bHr.getId(), 0L);
                if (c > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(c)));
                }
                l.this.bGS.b(this.bHr);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            l.this.dj(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiu != null) {
                this.aiu.eg();
                this.aiu = null;
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
        int EL = bVar.EL();
        com.baidu.tbadk.mvc.b.a EM = bVar.EM();
        switch (EL) {
            case 1:
                if (EM instanceof com.baidu.tieba.tbadkCore.w) {
                    String name = ((com.baidu.tieba.tbadkCore.w) EM).getName();
                    if (az.aN(name)) {
                        TiebaStatic.eventStat(this.aTS.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aTS.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aTS.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_LIKE, js(name))));
                        return true;
                    }
                    return false;
                }
                return false;
            case 2:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
                com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("enter_forum_edit_mode", true);
                this.bGS.hx(EM instanceof com.baidu.tieba.enterForum.b.f ? ((com.baidu.tieba.enterForum.b.f) EM).getPosition() : 0);
                this.bGY = false;
                if (this.bGR.getView() != null && this.bGR.getView().getParent() != null) {
                    this.bGR.getView().getParent().requestDisallowInterceptTouchEvent(true);
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
                if (this.bGS.Yt() != null) {
                    arrayList.addAll(this.bGS.Yt());
                }
                List<com.baidu.tieba.tbadkCore.w> ak = this.bGT.ak(this.bGS.Yt());
                if (!arrayList.isEmpty() && this.bGT.g(arrayList, ak)) {
                    this.aTS.showToast(r.j.enter_forum_sort_already);
                } else {
                    this.bGS.am(ak);
                }
                return true;
            case 7:
                this.bGS.Yu();
                return true;
            case 8:
                XT();
                return true;
            case 9:
                this.bGS.YE();
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aTS.getPageContext().getPageActivity(), "notlogin_7", "click", 1, new Object[0]);
                }
                return true;
            case 10:
                if (EM instanceof com.baidu.tieba.enterForum.b.g) {
                    com.baidu.tieba.enterForum.b.g gVar = (com.baidu.tieba.enterForum.b.g) EM;
                    String forumName = gVar.getForumName();
                    String valueOf = String.valueOf(gVar.getForumId());
                    if (az.aN(forumName)) {
                        TiebaStatic.log(new ax("c10358").ab("fid", valueOf));
                        TiebaStatic.eventStat(this.aTS.getPageContext().getPageActivity(), "recom_flist_like", "click", 1, "dev_id", valueOf);
                        this.Ge.bQ(forumName, valueOf);
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
                    if (az.aN(forumName2)) {
                        TiebaStatic.log(new ax("c10357").ab("fid", valueOf2));
                        TiebaStatic.eventStat(this.aTS.getPageContext().getPageActivity(), "ef_recent", "click", 1, new Object[0]);
                        this.aTS.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aTS.getPageContext().getPageActivity()).createNormalCfg(forumName2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                        TiebaStatic.eventStat(this.aTS.getPageContext().getPageActivity(), "recom_flist_pic", "click", 1, "dev_id", valueOf2);
                        if (!TbadkCoreApplication.isLogin()) {
                            TiebaStatic.eventStat(this.aTS.getPageContext().getPageActivity(), "notlogin_5", "click", 1, new Object[0]);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(this.aTS.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aTS.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                }
                return true;
            case 14:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(this.aTS.getPageContext().getPageActivity())));
                if (!TbadkCoreApplication.isLogin()) {
                    TiebaStatic.eventStat(this.aTS.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                }
                TiebaStatic.log("c10362");
                return true;
        }
    }

    private boolean js(String str) {
        if (this.bGT == null || this.bGT.Yg() == null || this.bGT.Yg().Xu() == null) {
            return false;
        }
        List<com.baidu.tbadk.data.e> Xz = this.bGT.Yg().Xu().Xz();
        if (com.baidu.tbadk.core.util.y.t(Xz)) {
            return false;
        }
        for (com.baidu.tbadk.data.e eVar : Xz) {
            if (eVar != null && eVar.getForumName() != null && eVar.getForumName().equals(str)) {
                return !com.baidu.tbadk.core.util.y.t(eVar.BZ());
            }
        }
        return false;
    }

    public void XV() {
        if (this.bGS != null) {
            this.bGS.Yz();
        }
    }

    public boolean XW() {
        if (this.bGS != null) {
            return this.bGS.XW();
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean lI() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.aTS.getUniqueId();
    }

    public void dm(boolean z) {
        int i = 1;
        if (this.bGS != null && this.bGR != null) {
            boolean z2 = this.bGS.XW() && this.bGR.isPrimary();
            if (z2 && z) {
                i = 2;
            } else if (z2 || !z) {
                i = 0;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, Integer.valueOf(i)));
        }
    }
}
