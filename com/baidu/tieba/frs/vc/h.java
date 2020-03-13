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
    private Runnable erl;
    private FrsFragment gGR;
    private boolean gMA;
    private int gMB;
    private com.baidu.tieba.f.a gMC;
    private FrsTabViewController gMD;
    private g gME;
    private f gMF;
    private final Runnable gMG;
    private BdUniqueId gMq;
    private com.baidu.tieba.frs.view.b gMw;
    private com.baidu.tieba.frs.entelechy.b.a gMx;
    private boolean gMy;
    private String gMz;
    private final View.OnClickListener gqD;
    private FrsHeaderViewContainer gqV;
    private int mScrollState;
    private int mSkinType;

    public h(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.gMy = false;
        this.mSkinType = 0;
        this.gMz = "normal_page";
        this.mScrollState = 0;
        this.gMA = false;
        this.gMG = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tieba.frs.l bDQ;
                if (h.this.gGR != null && h.this.mScrollState == 0 && (bDQ = h.this.gGR.bDQ()) != null && bDQ.bEN() != null && !bDQ.bEN().bKv() && !bDQ.bEr() && h.this.gqV.isShown() && h.this.gGR.isPrimary() && !h.this.gMA && h.this.gGR.bEx() && h.this.gMB == 1 && h.this.bKK() && h.this.gMw != null && h.this.gMw.bLF()) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                    h.this.bGV();
                    h.this.gGR.gom = true;
                    h.this.gMA = true;
                }
            }
        };
        this.erl = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.gqV != null) {
                    int childCount = h.this.gqV.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(h.this.gqV.getChildAt(i));
                    }
                }
            }

            private void refreshImage(View view) {
                if (view != null) {
                    if (view instanceof com.baidu.adp.newwidget.ImageView.h) {
                        ((com.baidu.adp.newwidget.ImageView.h) view).refresh();
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
        this.gqD = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.gGR != null) {
                    FrsViewData bEq = h.this.gGR.bEq();
                    if (bEq != null && bEq.getForum() != null && h.this.gMw != null && (view == h.this.gMw.bLH() || view == h.this.gMw.bLI() || view == h.this.gMw.bLJ())) {
                        if (h.this.gGR != null && bEq.getForum() != null) {
                            TiebaStatic.log(new an("c12046").cy("fid", bEq.getForum().getId()).X("obj_locate", h.this.gGR.bEt() ? 1 : 2));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), bEq.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    }
                    int id = view.getId();
                    if (id == R.id.tv_love) {
                        if (!h.this.gGR.bEr()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.gGR.showToast(R.string.neterror);
                            } else if (!bc.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                TiebaStatic.log(new an("c10517").X("obj_locate", 1).cy("fid", h.this.gGR.getForumId()));
                            } else {
                                h.this.me(true);
                                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    an anVar = new an("c10048");
                                    anVar.cy("fid", h.this.gGR.getForumId());
                                    anVar.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(anVar);
                                }
                            }
                        }
                    } else if (id == R.id.tv_sign) {
                        if (!h.this.gGR.bEr()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.gGR.showToast(R.string.neterror);
                            } else if (bc.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                if (!h.this.bKO()) {
                                    h.this.bKE();
                                    an.tv("c13560").X("obj_type", 2).aGz();
                                } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(h.this.gGR.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(h.this.gGR.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                                }
                            }
                        }
                    } else if (id == R.id.frs_header_games) {
                        if (bc.checkUpIsLogin(h.this.mContext.getPageActivity()) && bEq != null && bEq.getGameUrl() != null) {
                            ba.aGG().a((TbPageContext) h.this.getPageContext(), new String[]{bEq.getGameUrl()}, true);
                        }
                    } else if (id == R.id.frs_bawu_center) {
                        if (bEq != null && bEq.getUserData() != null && bEq.getUserData().isBawu()) {
                            String bawuCenterUrl = bEq.getBawuCenterUrl();
                            if (!aq.isEmpty(bawuCenterUrl)) {
                                com.baidu.tbadk.browser.a.startWebActivity(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (bEq.getForum() != null) {
                                    TiebaStatic.log(new an("c10502").cy("fid", bEq.getForum().getId()).cy("uid", bEq.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id == R.id.level_container && !h.this.gGR.bEr() && h.this.mScrollState == 0 && h.this.bKK() && h.this.gMw != null) {
                        h.this.gMw.i(view, false);
                    }
                }
            }
        };
        this.gGR = frsFragment;
        this.gMx = aVar;
        this.gqV = frsHeaderViewContainer;
        this.gMq = BdUniqueId.gen();
        this.gME = new g(this.gGR, this.gMq);
        this.gMF = new f(this.gGR);
        this.gMC = new com.baidu.tieba.f.a();
    }

    public void aj(Bundle bundle) {
        if (this.gME != null) {
            this.gME.registerListener();
        }
        if (this.gMF != null) {
            this.gMF.agv();
        }
        this.gMA = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void aiI() {
        if (this.gMw != null) {
            this.gMw.onDestory();
        }
        if (this.gMF != null) {
            this.gMF.aiI();
        }
        if (this.gMG != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gMG);
        }
    }

    public void aHC() {
        if (this.gMw != null) {
            this.gMw.onStop();
        }
        if (this.gqV != null) {
            this.gqV.removeCallbacks(this.erl);
        }
    }

    public void onPrimary(boolean z) {
        if (this.gMw != null) {
            this.gMw.onPrimary(z);
        }
    }

    public boolean uj(int i) {
        this.mSkinType = i;
        if (this.gMw != null) {
            this.gMw.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void mg(boolean z) {
        if (z) {
            if (this.gMw != null) {
                this.gqV.removeHeaderView(this.gMw.bLG());
                this.gMy = false;
            }
        } else if (this.gMw != null && this.gMw.bLG() != null && !this.gMy) {
            this.gqV.addHeaderView(this.gMw.bLG(), this.gqV.getHeaderViewsCount());
            this.gMy = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            v(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean bKF() {
        return true;
    }

    private void v(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.gMz, str);
        this.gMB = i2;
        this.gMz = str;
        bKH();
        if (this.gMw == null || z) {
            this.gMw = this.gMx.a(str, this.gGR, i);
            this.gMw.changeSkinType(this.mSkinType);
            this.gMw.y(this.gqD);
        }
        if (this.gME != null) {
            this.gMw.f(this.gME);
        }
        if (this.gMF != null) {
            this.gMw.g(this.gMF);
        }
        this.gqV.addHeaderView(this.gMw.getView());
        BQ(str);
        bKG();
    }

    private void bKG() {
        com.baidu.adp.lib.f.e.gx().postDelayed(this.gMG, 4000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGV() {
        if (bKK() && this.gMw != null) {
            this.gMw.bGV();
        }
    }

    public void uj() {
        if (!this.gMy && this.gMw != null) {
            this.gqV.addHeaderView(this.gMw.bLG());
            this.gMy = true;
        }
    }

    private void bKH() {
        if (this.gMw != null) {
            this.gqV.removeHeaderView(this.gMw.getView());
            this.gqV.removeHeaderView(this.gMw.bLG());
            bKI();
        }
        this.gMy = false;
    }

    private void bKI() {
        if (this.gMD != null && this.gGR != null && this.gGR.aIi() != null) {
            this.gGR.aIi().removeHeaderView(this.gMD.bKT());
        }
    }

    private void BQ(String str) {
        RelativeLayout bKT;
        if (this.gMD != null && this.gGR != null && this.gGR.aIi() != null && (bKT = this.gMD.bKT()) != null) {
            if ("brand_page".equals(str)) {
                this.gGR.aIi().removeHeaderView(bKT);
                return;
            }
            this.gGR.aIi().removeHeaderView(bKT);
            this.gGR.aIi().addHeaderView(bKT, 0);
        }
    }

    public void i(FrsViewData frsViewData) {
        if (frsViewData != null && bKK()) {
            b(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.gMz)) {
                this.gMw.bGK();
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float b = b(forumData);
            if (this.gMw != null) {
                this.gMw.a(forumData, frsViewData);
                this.gMw.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                this.gMw.a(forumData.getSignData());
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null || this.gME == null) {
            return 0.0f;
        }
        return this.gME.b(forumData);
    }

    public void uk(int i) {
        if (i > 1) {
            if (this.gMw != null) {
                this.gMw.mo(false);
            }
        } else if (this.gMw != null) {
            this.gMw.mo(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void bKJ() {
        if (this.gqV != null) {
            this.gqV.removeCallbacks(this.erl);
            this.gqV.postDelayed(this.erl, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bKK() {
        return "frs_page".equals(this.gMz) || "normal_page".equals(this.gMz) || "book_page".equals(this.gMz) || "brand_page".equals(this.gMz);
    }

    public void k(Integer num) {
        setIsMem(num.intValue());
        if (bKK()) {
            bKL();
        }
    }

    public void setIsMem(int i) {
        if (this.gMw != null) {
            this.gMw.setMemberType(i);
        }
    }

    public void bKL() {
        if (this.gMw != null) {
            this.gMw.bGX();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && bKK()) {
            a(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void bKM() {
        if (bKK()) {
            um(0);
        }
    }

    public void ul(int i) {
        if (bKK()) {
            um(i);
        }
    }

    public void um(int i) {
        if (this.gMw != null) {
            this.gMw.uF(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.gMw != null) {
            this.gMw.a(forumData, frsViewData);
            if (forumData != null) {
                this.gMw.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.gMw.mf(false);
                }
            }
        }
    }

    public boolean bKN() {
        if (!bKK() || this.gMw == null) {
            return false;
        }
        return this.gMw.bLE();
    }

    public void bKE() {
        if (this.gME != null) {
            this.gME.bKE();
        }
    }

    public void L(int i, int i2, int i3) {
        if (this.gME != null) {
            this.gME.L(i, i2, i3);
        }
    }

    public void un(int i) {
        if (bKK() && this.gMw != null) {
            this.gMw.uG(i);
        }
    }

    public void j(FrsViewData frsViewData) {
        if (bKK() && this.gME != null) {
            this.gME.a(this.gMw, frsViewData);
        }
    }

    public boolean bKO() {
        if (!bKK() || this.gMw == null) {
            return false;
        }
        return this.gMw.bKO();
    }

    public boolean bKP() {
        if (!bKK() || this.gMw == null) {
            return false;
        }
        return this.gMw.bKP();
    }

    public void me(boolean z) {
        if (this.gMF != null) {
            this.gMF.me(z);
        }
    }

    public void bKA() {
        if (this.gMF != null) {
            this.gMF.bKA();
        }
    }

    public void BR(String str) {
        if (this.gGR.bDL() != null && this.gGR.bDL().bJh() != null) {
            com.baidu.tieba.tbadkCore.d.cKc().aA(com.baidu.tieba.tbadkCore.d.cKc().e("1~" + str, this.gGR.bDL().bJh().getSortType(), this.gGR.bDL().bJh().getIsGood(), this.gGR.bDL().bJh().getCategoryId()), false);
        }
    }

    public void bGS() {
        if (this.gMw != null) {
            this.gMw.bGS();
        }
    }

    public static boolean k(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().aAz(), true) || frsViewData.getBookInfo().aAz().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean l(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().cKp() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || v.isEmpty(frsViewData.getActivityHeadData().aAx())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().aAG(), true)))) ? false : true;
        }
        return false;
    }

    public void uo(int i) {
        View findViewById;
        if (this.gMw != null && this.gMw.bLG() != null && (findViewById = this.gMw.bLG().findViewById(R.id.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.gMC != null) {
            this.gMC.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.gMD = frsTabViewController;
    }
}
