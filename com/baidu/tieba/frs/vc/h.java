package com.baidu.tieba.frs.vc;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.q;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class h extends com.baidu.adp.base.d<BaseFragmentActivity> {
    private BdUniqueId jEO;
    private com.baidu.tieba.frs.view.b jEW;
    private com.baidu.tieba.frs.entelechy.a.a jEX;
    private boolean jEY;
    private String jEZ;
    private boolean jFa;
    private int jFb;
    private com.baidu.tieba.f.a jFc;
    private FrsTabViewController jFd;
    private g jFe;
    private f jFf;
    private final Runnable jFg;
    private final Runnable jFh;
    private FrsHeaderViewContainer jdF;
    private final View.OnClickListener jdo;
    private FrsFragment jzc;
    private Runnable mRefreshRunnable;
    private int mScrollState;
    private int mSkinType;

    public h(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.a.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.jEY = false;
        this.mSkinType = 0;
        this.jEZ = "normal_page";
        this.mScrollState = 0;
        this.jFa = false;
        this.jFg = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.1
            @Override // java.lang.Runnable
            public void run() {
                q cBi;
                if (h.this.jzc != null && h.this.mScrollState == 0 && (cBi = h.this.jzc.cBi()) != null && cBi.cCo() != null && !cBi.cCo().cJJ() && !cBi.cBO() && h.this.jdF.isShown() && h.this.jzc.isPrimary() && !h.this.jFa && h.this.jzc.cBV() && h.this.jFb == 1 && h.this.cJZ() && h.this.jEW != null && h.this.jEW.cLh()) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                    h.this.cEW();
                    h.this.jzc.jao = true;
                    h.this.jFa = true;
                }
            }
        };
        this.jFh = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.jzc != null && h.this.mScrollState == 0 && !h.this.jzc.cBi().cBO() && h.this.jdF.isShown() && h.this.jzc.isPrimary()) {
                    h.this.cEX();
                }
            }
        };
        this.mRefreshRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.jdF != null) {
                    int childCount = h.this.jdF.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(h.this.jdF.getChildAt(i));
                    }
                }
            }

            private void refreshImage(View view) {
                if (view != null) {
                    if (view instanceof com.baidu.adp.newwidget.ImageView.i) {
                        ((com.baidu.adp.newwidget.ImageView.i) view).refresh();
                    }
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view;
                        int childCount = viewGroup.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            refreshImage(viewGroup.getChildAt(i));
                        }
                    }
                }
            }
        };
        this.jdo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.jzc != null) {
                    FrsViewData cBN = h.this.jzc.cBN();
                    if (cBN != null && cBN.getForum() != null && h.this.jEW != null && (view == h.this.jEW.cLj() || view == h.this.jEW.cLk() || view == h.this.jEW.cLl())) {
                        if (h.this.jzc != null && cBN.getForum() != null) {
                            TiebaStatic.log(new aq("c12046").dW("fid", cBN.getForum().getId()).an("obj_locate", h.this.jzc.cBQ() ? 1 : 2));
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        if (cBN.getEntelechyTabInfo() != null && cBN.getEntelechyTabInfo().tab != null) {
                            for (int i = 0; i < cBN.getEntelechyTabInfo().tab.size(); i++) {
                                arrayList.add(cBN.getEntelechyTabInfo().tab.get(i).tab_name);
                            }
                        }
                        ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), cBN.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                        forumDetailActivityConfig.setForumTabs(arrayList);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumDetailActivityConfig));
                    }
                    int id = view.getId();
                    if (id == R.id.tv_love) {
                        if (!h.this.jzc.cBO()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.jzc.showToast(R.string.neterror);
                            } else if (!bg.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                TiebaStatic.log(new aq("c10517").an("obj_locate", 1).dW("fid", h.this.jzc.getForumId()));
                            } else {
                                h.this.rq(true);
                                if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    aq aqVar = new aq("c10048");
                                    aqVar.dW("fid", h.this.jzc.getForumId());
                                    aqVar.dW("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(aqVar);
                                }
                            }
                        }
                    } else if (id == R.id.tv_sign) {
                        if (!h.this.jzc.cBO()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.jzc.showToast(R.string.neterror);
                            } else if (bg.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                if (!h.this.cKe()) {
                                    h.this.cKd();
                                    aq.AM("c13560").an("obj_type", 2).bsu();
                                } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(h.this.jzc.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(h.this.jzc.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                                }
                            }
                        }
                    } else if (id == R.id.frs_header_games) {
                        if (bg.checkUpIsLogin(h.this.mContext.getPageActivity()) && cBN != null && cBN.getGameUrl() != null) {
                            be.bsB().a((TbPageContext) h.this.getPageContext(), new String[]{cBN.getGameUrl()}, true);
                        }
                    } else if (id == R.id.frs_bawu_center) {
                        if (cBN != null && cBN.getUserData() != null && cBN.getUserData().isBawu()) {
                            String bawuCenterUrl = cBN.getBawuCenterUrl();
                            if (!at.isEmpty(bawuCenterUrl)) {
                                com.baidu.tbadk.browser.a.startWebActivity(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (cBN.getForum() != null) {
                                    TiebaStatic.log(new aq("c10502").dW("fid", cBN.getForum().getId()).dW("uid", cBN.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id == R.id.level_container) {
                        if (!h.this.jzc.cBO() && h.this.mScrollState == 0 && h.this.cJZ() && h.this.jEW != null) {
                            h.this.jEW.l(view, false);
                        }
                    } else if (id == R.id.frs_hot_rank_entry) {
                        if (cBN != null && cBN.getForum() != null && !TextUtils.isEmpty(cBN.getForum().getId())) {
                            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(h.this.getPageContext().getPageActivity());
                            hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(cBN.getForum().getId(), 0L)));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                            aq aqVar2 = new aq("c13666");
                            aqVar2.dW("fid", cBN.getForum().getId());
                            TiebaStatic.log(aqVar2);
                        }
                    } else if (id == R.id.frs_manager_info_layout) {
                        if (cBN != null && cBN.getForum() != null && !TextUtils.isEmpty(cBN.getForum().getId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumMemberActivityConfig(h.this.getPageContext().getPageActivity(), String.valueOf(cBN.getForum().getId()), cBN.getForum().getName())));
                        }
                    } else if (id == R.id.frs_manager_application_layout && bg.checkUpIsLogin(h.this.mContext.getPageActivity()) && cBN != null && cBN.getForum() != null && !TextUtils.isEmpty(cBN.getForum().getId())) {
                        be.bsB().b(h.this.jzc.getTbPageContext(), new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + cBN.getForum().getId()});
                    }
                }
            }
        };
        this.jzc = frsFragment;
        this.jEX = aVar;
        this.jdF = frsHeaderViewContainer;
        this.jEO = BdUniqueId.gen();
        this.jFe = new g(this.jzc, this.jEO);
        this.jFf = new f(this.jzc);
        this.jFc = new com.baidu.tieba.f.a();
    }

    public void as(Bundle bundle) {
        if (this.jFe != null) {
            this.jFe.registerListener();
        }
        if (this.jFf != null) {
            this.jFf.aNe();
        }
        this.jFa = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void cHM() {
        if (this.jEW != null) {
            this.jEW.onDestory();
        }
        if (this.jFf != null) {
            this.jFf.cHM();
        }
        if (this.jFg != null) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jFg);
        }
        if (this.jFh != null) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jFh);
        }
    }

    public void btD() {
        if (this.jEW != null) {
            this.jEW.onStop();
        }
        if (this.jdF != null) {
            this.jdF.removeCallbacks(this.mRefreshRunnable);
        }
    }

    public void bW(boolean z) {
        if (this.jEW != null) {
            this.jEW.bW(z);
        }
    }

    public boolean An(int i) {
        this.mSkinType = i;
        if (this.jEW != null) {
            this.jEW.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void rt(boolean z) {
        if (z) {
            if (this.jEW != null) {
                this.jdF.removeHeaderView(this.jEW.cLi());
                this.jEY = false;
            }
        } else if (this.jEW != null && this.jEW.cLi() != null && !this.jEY) {
            this.jdF.addHeaderView(this.jEW.cLi(), this.jdF.getHeaderViewsCount());
            this.jEY = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            y(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean cJR() {
        return true;
    }

    private void y(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.jEZ, str);
        this.jFb = i2;
        this.jEZ = str;
        cJW();
        if (this.jEW == null || z) {
            this.jEW = this.jEX.a(str, this.jzc, i);
            this.jEW.changeSkinType(this.mSkinType);
            this.jEW.C(this.jdo);
        }
        if (this.jFe != null) {
            this.jEW.i(this.jFe);
        }
        if (this.jFf != null) {
            this.jEW.g(this.jFf);
        }
        this.jdF.addHeaderView(this.jEW.getView());
        Ky(str);
        cJS();
        cJT();
    }

    private void cJS() {
        com.baidu.adp.lib.f.e.mB().postDelayed(this.jFg, 4000L);
    }

    public void cJT() {
        com.baidu.adp.lib.f.e.mB().postDelayed(this.jFh, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEW() {
        if (cJZ() && this.jEW != null) {
            this.jEW.cEW();
        }
    }

    public void cEX() {
        if (this.jEW != null) {
            this.jEW.cEX();
        }
    }

    public void cJU() {
        if (this.jEW != null) {
            this.jEW.cEY();
        }
    }

    public void cJV() {
        if (!this.jEY && this.jEW != null) {
            this.jdF.addHeaderView(this.jEW.cLi());
            this.jEY = true;
        }
    }

    private void cJW() {
        if (this.jEW != null) {
            this.jdF.removeHeaderView(this.jEW.getView());
            this.jdF.removeHeaderView(this.jEW.cLi());
            cJX();
        }
        this.jEY = false;
    }

    private void cJX() {
        if (this.jFd != null && this.jzc != null && this.jzc.getListView() != null) {
            this.jzc.getListView().removeHeaderView(this.jFd.cKr());
        }
    }

    private void Ky(String str) {
        RelativeLayout cKr;
        if (this.jFd != null && this.jzc != null && this.jzc.getListView() != null && (cKr = this.jFd.cKr()) != null) {
            if ("brand_page".equals(str)) {
                this.jzc.getListView().removeHeaderView(cKr);
                return;
            }
            this.jzc.getListView().removeHeaderView(cKr);
            this.jzc.getListView().addHeaderView(cKr, 0);
        }
    }

    public void j(FrsViewData frsViewData) {
        if (frsViewData != null && cJZ()) {
            b(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.jEZ)) {
                this.jEW.cEH();
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float f = f(forumData);
            if (this.jEW != null) {
                this.jEW.a(forumData, frsViewData);
                this.jEW.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), f, false);
                this.jEW.a(forumData.getSignData());
            }
        }
    }

    public void k(FrsViewData frsViewData) {
        if (frsViewData != null && this.jEW != null && cJZ()) {
            this.jEW.aJ(f(frsViewData.getForum()));
        }
    }

    private float f(ForumData forumData) {
        if (forumData == null || this.jFe == null) {
            return 0.0f;
        }
        return this.jFe.f(forumData);
    }

    public void Ao(int i) {
        if (i > 1) {
            if (this.jEW != null) {
                this.jEW.rB(false);
            }
        } else if (this.jEW != null) {
            this.jEW.rB(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void cJY() {
        if (this.jdF != null) {
            this.jdF.removeCallbacks(this.mRefreshRunnable);
            this.jdF.postDelayed(this.mRefreshRunnable, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cJZ() {
        return "frs_page".equals(this.jEZ) || "normal_page".equals(this.jEZ) || "book_page".equals(this.jEZ) || "brand_page".equals(this.jEZ);
    }

    public void q(Integer num) {
        setIsMem(num.intValue());
        if (cJZ()) {
            cKa();
        }
    }

    public void setIsMem(int i) {
        if (this.jEW != null) {
            this.jEW.setMemberType(i);
        }
    }

    public void cKa() {
        if (this.jEW != null) {
            this.jEW.cFb();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && cJZ()) {
            a(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void cKb() {
        if (cJZ()) {
            Aq(0);
        }
    }

    public void Ap(int i) {
        if (cJZ()) {
            Aq(i);
        }
    }

    public void Aq(int i) {
        if (this.jEW != null) {
            this.jEW.AN(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.jEW != null) {
            this.jEW.a(forumData, frsViewData);
            if (forumData != null) {
                this.jEW.a(i, forumData.getLevelName(), forumData.getUser_level(), f(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.jEW.rs(false);
                }
            }
        }
    }

    public boolean cKc() {
        if (!cJZ() || this.jEW == null) {
            return false;
        }
        return this.jEW.cLg();
    }

    public void cKd() {
        if (this.jFe != null) {
            if (this.jEW != null) {
                this.jFe.u(this.jEW.cES(), this.jEW.getActivityId());
            } else {
                this.jFe.u(false, "");
            }
            if (this.jEW != null) {
                this.jFe.a(this.jEW.cET());
            }
        }
    }

    public void T(int i, int i2, int i3) {
        if (this.jFe != null) {
            this.jFe.T(i, i2, i3);
        }
    }

    public void Ar(int i) {
        if (cJZ() && this.jEW != null) {
            this.jEW.AO(i);
        }
    }

    public void l(FrsViewData frsViewData) {
        if (cJZ() && this.jFe != null) {
            this.jFe.a(this.jEW, frsViewData);
        }
    }

    public boolean cKe() {
        if (!cJZ() || this.jEW == null) {
            return false;
        }
        return this.jEW.cKe();
    }

    public boolean cKf() {
        if (!cJZ() || this.jEW == null) {
            return false;
        }
        return this.jEW.cKf();
    }

    public void rq(boolean z) {
        if (this.jFf != null) {
            this.jFf.rq(z);
        }
    }

    public void cJM() {
        if (this.jFf != null) {
            this.jFf.cJM();
        }
    }

    public void Kz(String str) {
        if (this.jzc.cBd() != null && this.jzc.cBd().cIi() != null) {
            com.baidu.tieba.tbadkCore.e.dKh().bd(com.baidu.tieba.tbadkCore.e.dKh().f("1~" + str, this.jzc.cBd().cIi().getSortType(), this.jzc.cBd().cIi().getIsGood(), this.jzc.cBd().cIi().getCategoryId()), false);
        }
    }

    public void cER() {
        if (this.jEW != null) {
            this.jEW.cER();
        }
    }

    public static boolean m(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().blB(), true) || frsViewData.getBookInfo().blB().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean n(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().dKu() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || x.isEmpty(frsViewData.getActivityHeadData().blz())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().getImgUrl(), true)))) ? false : true;
        }
        return false;
    }

    public void As(int i) {
        if (this.jEW != null && this.jEW.cLi() != null) {
            View findViewById = this.jEW.cLi().findViewById(R.id.divider_bottom);
            if (findViewById != null) {
                findViewById.setVisibility(i);
            }
            this.jEW.cEY();
        }
    }

    public void cEZ() {
        this.jEW.cEZ();
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.jFc != null) {
            this.jFc.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.jFd = frsTabViewController;
    }

    public f cKg() {
        return this.jFf;
    }
}
