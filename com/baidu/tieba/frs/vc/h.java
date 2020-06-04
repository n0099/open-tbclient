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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes9.dex */
public class h extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Runnable fic;
    private FrsFragment hGQ;
    private BdUniqueId hME;
    private com.baidu.tieba.frs.view.b hMK;
    private com.baidu.tieba.frs.entelechy.b.a hML;
    private boolean hMM;
    private String hMN;
    private boolean hMO;
    private int hMP;
    private com.baidu.tieba.f.a hMQ;
    private FrsTabViewController hMR;
    private g hMS;
    private f hMT;
    private final Runnable hMU;
    private final View.OnClickListener hpF;
    private FrsHeaderViewContainer hpW;
    private int mScrollState;
    private int mSkinType;

    public h(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.hMM = false;
        this.mSkinType = 0;
        this.hMN = "normal_page";
        this.mScrollState = 0;
        this.hMO = false;
        this.hMU = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tieba.frs.n bUT;
                if (h.this.hGQ != null && h.this.mScrollState == 0 && (bUT = h.this.hGQ.bUT()) != null && bUT.bVU() != null && !bUT.bVU().cbM() && !bUT.bVv() && h.this.hpW.isShown() && h.this.hGQ.isPrimary() && !h.this.hMO && h.this.hGQ.bVC() && h.this.hMP == 1 && h.this.ccc() && h.this.hMK != null && h.this.hMK.cde()) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                    h.this.bYl();
                    h.this.hGQ.hng = true;
                    h.this.hMO = true;
                }
            }
        };
        this.fic = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.hpW != null) {
                    int childCount = h.this.hpW.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(h.this.hpW.getChildAt(i));
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
        this.hpF = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.hGQ != null) {
                    FrsViewData bVu = h.this.hGQ.bVu();
                    if (bVu != null && bVu.getForum() != null && h.this.hMK != null && (view == h.this.hMK.cdg() || view == h.this.hMK.cdh() || view == h.this.hMK.cdi())) {
                        if (h.this.hGQ != null && bVu.getForum() != null) {
                            TiebaStatic.log(new an("c12046").dh("fid", bVu.getForum().getId()).ag("obj_locate", h.this.hGQ.bVx() ? 1 : 2));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), bVu.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    }
                    int id = view.getId();
                    if (id == R.id.tv_love) {
                        if (!h.this.hGQ.bVv()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.hGQ.showToast(R.string.neterror);
                            } else if (!bc.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                TiebaStatic.log(new an("c10517").ag("obj_locate", 1).dh("fid", h.this.hGQ.getForumId()));
                            } else {
                                h.this.nJ(true);
                                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    an anVar = new an("c10048");
                                    anVar.dh("fid", h.this.hGQ.getForumId());
                                    anVar.dh("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(anVar);
                                }
                            }
                        }
                    } else if (id == R.id.tv_sign) {
                        if (!h.this.hGQ.bVv()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.hGQ.showToast(R.string.neterror);
                            } else if (bc.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                if (!h.this.ccg()) {
                                    h.this.cbV();
                                    an.wr("c13560").ag("obj_type", 2).aUT();
                                } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(h.this.hGQ.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(h.this.hGQ.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                                }
                            }
                        }
                    } else if (id == R.id.frs_header_games) {
                        if (bc.checkUpIsLogin(h.this.mContext.getPageActivity()) && bVu != null && bVu.getGameUrl() != null) {
                            ba.aVa().a((TbPageContext) h.this.getPageContext(), new String[]{bVu.getGameUrl()}, true);
                        }
                    } else if (id == R.id.frs_bawu_center) {
                        if (bVu != null && bVu.getUserData() != null && bVu.getUserData().isBawu()) {
                            String bawuCenterUrl = bVu.getBawuCenterUrl();
                            if (!aq.isEmpty(bawuCenterUrl)) {
                                com.baidu.tbadk.browser.a.startWebActivity(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (bVu.getForum() != null) {
                                    TiebaStatic.log(new an("c10502").dh("fid", bVu.getForum().getId()).dh("uid", bVu.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id == R.id.level_container) {
                        if (!h.this.hGQ.bVv() && h.this.mScrollState == 0 && h.this.ccc() && h.this.hMK != null) {
                            h.this.hMK.l(view, false);
                        }
                    } else if (id == R.id.frs_hot_rank_entry) {
                        if (bVu != null && bVu.getForum() != null && !TextUtils.isEmpty(bVu.getForum().getId())) {
                            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(h.this.getPageContext().getPageActivity());
                            hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(bVu.getForum().getId(), 0L)));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                            an anVar2 = new an("c13666");
                            anVar2.dh("fid", bVu.getForum().getId());
                            TiebaStatic.log(anVar2);
                        }
                    } else if (id == R.id.frs_manager_info_layout) {
                        if (bVu != null && bVu.getForum() != null && !TextUtils.isEmpty(bVu.getForum().getId())) {
                            if (bVu.getForum().isLike() == 0) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), bVu.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumMemberActivityConfig(h.this.getPageContext().getPageActivity(), String.valueOf(bVu.getForum().getId()), bVu.getForum().getName())));
                            }
                        }
                    } else if (id == R.id.frs_manager_application_layout && bVu != null && bVu.getForum() != null && !TextUtils.isEmpty(bVu.getForum().getId())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), bVu.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    }
                }
            }
        };
        this.hGQ = frsFragment;
        this.hML = aVar;
        this.hpW = frsHeaderViewContainer;
        this.hME = BdUniqueId.gen();
        this.hMS = new g(this.hGQ, this.hME);
        this.hMT = new f(this.hGQ);
        this.hMQ = new com.baidu.tieba.f.a();
    }

    public void ap(Bundle bundle) {
        if (this.hMS != null) {
            this.hMS.registerListener();
        }
        if (this.hMT != null) {
            this.hMT.atc();
        }
        this.hMO = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void bZX() {
        if (this.hMK != null) {
            this.hMK.onDestory();
        }
        if (this.hMT != null) {
            this.hMT.bZX();
        }
        if (this.hMU != null) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.hMU);
        }
    }

    public void aWa() {
        if (this.hMK != null) {
            this.hMK.onStop();
        }
        if (this.hpW != null) {
            this.hpW.removeCallbacks(this.fic);
        }
    }

    public void bB(boolean z) {
        if (this.hMK != null) {
            this.hMK.bB(z);
        }
    }

    public boolean vu(int i) {
        this.mSkinType = i;
        if (this.hMK != null) {
            this.hMK.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void nL(boolean z) {
        if (z) {
            if (this.hMK != null) {
                this.hpW.removeHeaderView(this.hMK.cdf());
                this.hMM = false;
            }
        } else if (this.hMK != null && this.hMK.cdf() != null && !this.hMM) {
            this.hpW.addHeaderView(this.hMK.cdf(), this.hpW.getHeaderViewsCount());
            this.hMM = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            w(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean cbW() {
        return true;
    }

    private void w(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.hMN, str);
        this.hMP = i2;
        this.hMN = str;
        cbZ();
        if (this.hMK == null || z) {
            this.hMK = this.hML.a(str, this.hGQ, i);
            this.hMK.changeSkinType(this.mSkinType);
            this.hMK.y(this.hpF);
        }
        if (this.hMS != null) {
            this.hMK.f(this.hMS);
        }
        if (this.hMT != null) {
            this.hMK.g(this.hMT);
        }
        this.hpW.addHeaderView(this.hMK.getView());
        Fk(str);
        cbX();
    }

    private void cbX() {
        com.baidu.adp.lib.f.e.ld().postDelayed(this.hMU, 4000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYl() {
        if (ccc() && this.hMK != null) {
            this.hMK.bYl();
        }
    }

    public void cbY() {
        if (!this.hMM && this.hMK != null) {
            this.hpW.addHeaderView(this.hMK.cdf());
            this.hMM = true;
        }
    }

    private void cbZ() {
        if (this.hMK != null) {
            this.hpW.removeHeaderView(this.hMK.getView());
            this.hpW.removeHeaderView(this.hMK.cdf());
            cca();
        }
        this.hMM = false;
    }

    private void cca() {
        if (this.hMR != null && this.hGQ != null && this.hGQ.aWO() != null) {
            this.hGQ.aWO().removeHeaderView(this.hMR.ccp());
        }
    }

    private void Fk(String str) {
        RelativeLayout ccp;
        if (this.hMR != null && this.hGQ != null && this.hGQ.aWO() != null && (ccp = this.hMR.ccp()) != null) {
            if ("brand_page".equals(str)) {
                this.hGQ.aWO().removeHeaderView(ccp);
                return;
            }
            this.hGQ.aWO().removeHeaderView(ccp);
            this.hGQ.aWO().addHeaderView(ccp, 0);
        }
    }

    public void i(FrsViewData frsViewData) {
        if (frsViewData != null && ccc()) {
            b(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.hMN)) {
                this.hMK.bXY();
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float c = c(forumData);
            if (this.hMK != null) {
                this.hMK.a(forumData, frsViewData);
                this.hMK.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), c, false);
                this.hMK.a(forumData.getSignData());
            }
        }
    }

    private float c(ForumData forumData) {
        if (forumData == null || this.hMS == null) {
            return 0.0f;
        }
        return this.hMS.c(forumData);
    }

    public void vv(int i) {
        if (i > 1) {
            if (this.hMK != null) {
                this.hMK.nT(false);
            }
        } else if (this.hMK != null) {
            this.hMK.nT(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void ccb() {
        if (this.hpW != null) {
            this.hpW.removeCallbacks(this.fic);
            this.hpW.postDelayed(this.fic, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ccc() {
        return "frs_page".equals(this.hMN) || "normal_page".equals(this.hMN) || "book_page".equals(this.hMN) || "brand_page".equals(this.hMN);
    }

    public void l(Integer num) {
        setIsMem(num.intValue());
        if (ccc()) {
            ccd();
        }
    }

    public void setIsMem(int i) {
        if (this.hMK != null) {
            this.hMK.setMemberType(i);
        }
    }

    public void ccd() {
        if (this.hMK != null) {
            this.hMK.bYn();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && ccc()) {
            a(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void cce() {
        if (ccc()) {
            vx(0);
        }
    }

    public void vw(int i) {
        if (ccc()) {
            vx(i);
        }
    }

    public void vx(int i) {
        if (this.hMK != null) {
            this.hMK.vS(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.hMK != null) {
            this.hMK.a(forumData, frsViewData);
            if (forumData != null) {
                this.hMK.a(i, forumData.getLevelName(), forumData.getUser_level(), c(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.hMK.nK(false);
                }
            }
        }
    }

    public boolean ccf() {
        if (!ccc() || this.hMK == null) {
            return false;
        }
        return this.hMK.cdd();
    }

    public void cbV() {
        if (this.hMS != null) {
            this.hMS.cbV();
        }
    }

    public void O(int i, int i2, int i3) {
        if (this.hMS != null) {
            this.hMS.O(i, i2, i3);
        }
    }

    public void vy(int i) {
        if (ccc() && this.hMK != null) {
            this.hMK.vT(i);
        }
    }

    public void j(FrsViewData frsViewData) {
        if (ccc() && this.hMS != null) {
            this.hMS.a(this.hMK, frsViewData);
        }
    }

    public boolean ccg() {
        if (!ccc() || this.hMK == null) {
            return false;
        }
        return this.hMK.ccg();
    }

    public boolean cch() {
        if (!ccc() || this.hMK == null) {
            return false;
        }
        return this.hMK.cch();
    }

    public void nJ(boolean z) {
        if (this.hMT != null) {
            this.hMT.nJ(z);
        }
    }

    public void cbR() {
        if (this.hMT != null) {
            this.hMT.cbR();
        }
    }

    public void Fl(String str) {
        if (this.hGQ.bUO() != null && this.hGQ.bUO().cat() != null) {
            com.baidu.tieba.tbadkCore.e.dcJ().aT(com.baidu.tieba.tbadkCore.e.dcJ().e("1~" + str, this.hGQ.bUO().cat().getSortType(), this.hGQ.bUO().cat().getIsGood(), this.hGQ.bUO().cat().getCategoryId()), false);
        }
    }

    public void bYi() {
        if (this.hMK != null) {
            this.hMK.bYi();
        }
    }

    public static boolean k(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().aOI(), true) || frsViewData.getBookInfo().aOI().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean l(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().dcW() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || v.isEmpty(frsViewData.getActivityHeadData().aOG())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().aOP(), true)))) ? false : true;
        }
        return false;
    }

    public void vz(int i) {
        View findViewById;
        if (this.hMK != null && this.hMK.cdf() != null && (findViewById = this.hMK.cdf().findViewById(R.id.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.hMQ != null) {
            this.hMQ.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.hMR = frsTabViewController;
    }
}
