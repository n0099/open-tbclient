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
    private Runnable erI;
    private FrsFragment gHP;
    private com.baidu.tieba.frs.view.b gNB;
    private com.baidu.tieba.frs.entelechy.b.a gNC;
    private boolean gND;
    private String gNE;
    private boolean gNF;
    private int gNG;
    private com.baidu.tieba.f.a gNH;
    private FrsTabViewController gNI;
    private g gNJ;
    private f gNK;
    private final Runnable gNL;
    private BdUniqueId gNv;
    private FrsHeaderViewContainer grF;
    private final View.OnClickListener grn;
    private int mScrollState;
    private int mSkinType;

    public h(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.gND = false;
        this.mSkinType = 0;
        this.gNE = "normal_page";
        this.mScrollState = 0;
        this.gNF = false;
        this.gNL = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tieba.frs.m bDY;
                if (h.this.gHP != null && h.this.mScrollState == 0 && (bDY = h.this.gHP.bDY()) != null && bDY.bEX() != null && !bDY.bEX().bKI() && !bDY.bEA() && h.this.grF.isShown() && h.this.gHP.isPrimary() && !h.this.gNF && h.this.gHP.bEH() && h.this.gNG == 1 && h.this.bKX() && h.this.gNB != null && h.this.gNB.bLT()) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                    h.this.bHk();
                    h.this.gHP.goW = true;
                    h.this.gNF = true;
                }
            }
        };
        this.erI = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.grF != null) {
                    int childCount = h.this.grF.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(h.this.grF.getChildAt(i));
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
        this.grn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.gHP != null) {
                    FrsViewData bEz = h.this.gHP.bEz();
                    if (bEz != null && bEz.getForum() != null && h.this.gNB != null && (view == h.this.gNB.bLV() || view == h.this.gNB.bLW() || view == h.this.gNB.bLX())) {
                        if (h.this.gHP != null && bEz.getForum() != null) {
                            TiebaStatic.log(new an("c12046").cx("fid", bEz.getForum().getId()).X("obj_locate", h.this.gHP.bEC() ? 1 : 2));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), bEz.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    }
                    int id = view.getId();
                    if (id == R.id.tv_love) {
                        if (!h.this.gHP.bEA()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.gHP.showToast(R.string.neterror);
                            } else if (!bc.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                TiebaStatic.log(new an("c10517").X("obj_locate", 1).cx("fid", h.this.gHP.getForumId()));
                            } else {
                                h.this.mk(true);
                                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    an anVar = new an("c10048");
                                    anVar.cx("fid", h.this.gHP.getForumId());
                                    anVar.cx("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(anVar);
                                }
                            }
                        }
                    } else if (id == R.id.tv_sign) {
                        if (!h.this.gHP.bEA()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.gHP.showToast(R.string.neterror);
                            } else if (bc.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                if (!h.this.bLb()) {
                                    h.this.bKR();
                                    an.tv("c13560").X("obj_type", 2).aGD();
                                } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(h.this.gHP.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(h.this.gHP.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                                }
                            }
                        }
                    } else if (id == R.id.frs_header_games) {
                        if (bc.checkUpIsLogin(h.this.mContext.getPageActivity()) && bEz != null && bEz.getGameUrl() != null) {
                            ba.aGK().a((TbPageContext) h.this.getPageContext(), new String[]{bEz.getGameUrl()}, true);
                        }
                    } else if (id == R.id.frs_bawu_center) {
                        if (bEz != null && bEz.getUserData() != null && bEz.getUserData().isBawu()) {
                            String bawuCenterUrl = bEz.getBawuCenterUrl();
                            if (!aq.isEmpty(bawuCenterUrl)) {
                                com.baidu.tbadk.browser.a.startWebActivity(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (bEz.getForum() != null) {
                                    TiebaStatic.log(new an("c10502").cx("fid", bEz.getForum().getId()).cx("uid", bEz.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id == R.id.level_container && !h.this.gHP.bEA() && h.this.mScrollState == 0 && h.this.bKX() && h.this.gNB != null) {
                        h.this.gNB.i(view, false);
                    }
                }
            }
        };
        this.gHP = frsFragment;
        this.gNC = aVar;
        this.grF = frsHeaderViewContainer;
        this.gNv = BdUniqueId.gen();
        this.gNJ = new g(this.gHP, this.gNv);
        this.gNK = new f(this.gHP);
        this.gNH = new com.baidu.tieba.f.a();
    }

    public void aj(Bundle bundle) {
        if (this.gNJ != null) {
            this.gNJ.registerListener();
        }
        if (this.gNK != null) {
            this.gNK.agy();
        }
        this.gNF = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void aiL() {
        if (this.gNB != null) {
            this.gNB.onDestory();
        }
        if (this.gNK != null) {
            this.gNK.aiL();
        }
        if (this.gNL != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gNL);
        }
    }

    public void aHG() {
        if (this.gNB != null) {
            this.gNB.onStop();
        }
        if (this.grF != null) {
            this.grF.removeCallbacks(this.erI);
        }
    }

    public void onPrimary(boolean z) {
        if (this.gNB != null) {
            this.gNB.onPrimary(z);
        }
    }

    public boolean up(int i) {
        this.mSkinType = i;
        if (this.gNB != null) {
            this.gNB.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void mm(boolean z) {
        if (z) {
            if (this.gNB != null) {
                this.grF.removeHeaderView(this.gNB.bLU());
                this.gND = false;
            }
        } else if (this.gNB != null && this.gNB.bLU() != null && !this.gND) {
            this.grF.addHeaderView(this.gNB.bLU(), this.grF.getHeaderViewsCount());
            this.gND = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            v(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean bKS() {
        return true;
    }

    private void v(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.gNE, str);
        this.gNG = i2;
        this.gNE = str;
        bKU();
        if (this.gNB == null || z) {
            this.gNB = this.gNC.a(str, this.gHP, i);
            this.gNB.changeSkinType(this.mSkinType);
            this.gNB.y(this.grn);
        }
        if (this.gNJ != null) {
            this.gNB.f(this.gNJ);
        }
        if (this.gNK != null) {
            this.gNB.g(this.gNK);
        }
        this.grF.addHeaderView(this.gNB.getView());
        BQ(str);
        bKT();
    }

    private void bKT() {
        com.baidu.adp.lib.f.e.gx().postDelayed(this.gNL, 4000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHk() {
        if (bKX() && this.gNB != null) {
            this.gNB.bHk();
        }
    }

    public void uo() {
        if (!this.gND && this.gNB != null) {
            this.grF.addHeaderView(this.gNB.bLU());
            this.gND = true;
        }
    }

    private void bKU() {
        if (this.gNB != null) {
            this.grF.removeHeaderView(this.gNB.getView());
            this.grF.removeHeaderView(this.gNB.bLU());
            bKV();
        }
        this.gND = false;
    }

    private void bKV() {
        if (this.gNI != null && this.gHP != null && this.gHP.aIm() != null) {
            this.gHP.aIm().removeHeaderView(this.gNI.bLg());
        }
    }

    private void BQ(String str) {
        RelativeLayout bLg;
        if (this.gNI != null && this.gHP != null && this.gHP.aIm() != null && (bLg = this.gNI.bLg()) != null) {
            if ("brand_page".equals(str)) {
                this.gHP.aIm().removeHeaderView(bLg);
                return;
            }
            this.gHP.aIm().removeHeaderView(bLg);
            this.gHP.aIm().addHeaderView(bLg, 0);
        }
    }

    public void i(FrsViewData frsViewData) {
        if (frsViewData != null && bKX()) {
            b(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.gNE)) {
                this.gNB.bGZ();
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float b = b(forumData);
            if (this.gNB != null) {
                this.gNB.a(forumData, frsViewData);
                this.gNB.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                this.gNB.a(forumData.getSignData());
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null || this.gNJ == null) {
            return 0.0f;
        }
        return this.gNJ.b(forumData);
    }

    public void uq(int i) {
        if (i > 1) {
            if (this.gNB != null) {
                this.gNB.mu(false);
            }
        } else if (this.gNB != null) {
            this.gNB.mu(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void bKW() {
        if (this.grF != null) {
            this.grF.removeCallbacks(this.erI);
            this.grF.postDelayed(this.erI, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bKX() {
        return "frs_page".equals(this.gNE) || "normal_page".equals(this.gNE) || "book_page".equals(this.gNE) || "brand_page".equals(this.gNE);
    }

    public void k(Integer num) {
        setIsMem(num.intValue());
        if (bKX()) {
            bKY();
        }
    }

    public void setIsMem(int i) {
        if (this.gNB != null) {
            this.gNB.setMemberType(i);
        }
    }

    public void bKY() {
        if (this.gNB != null) {
            this.gNB.bHm();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && bKX()) {
            a(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void bKZ() {
        if (bKX()) {
            us(0);
        }
    }

    public void ur(int i) {
        if (bKX()) {
            us(i);
        }
    }

    public void us(int i) {
        if (this.gNB != null) {
            this.gNB.uM(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.gNB != null) {
            this.gNB.a(forumData, frsViewData);
            if (forumData != null) {
                this.gNB.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.gNB.ml(false);
                }
            }
        }
    }

    public boolean bLa() {
        if (!bKX() || this.gNB == null) {
            return false;
        }
        return this.gNB.bLS();
    }

    public void bKR() {
        if (this.gNJ != null) {
            this.gNJ.bKR();
        }
    }

    public void L(int i, int i2, int i3) {
        if (this.gNJ != null) {
            this.gNJ.L(i, i2, i3);
        }
    }

    public void ut(int i) {
        if (bKX() && this.gNB != null) {
            this.gNB.uN(i);
        }
    }

    public void j(FrsViewData frsViewData) {
        if (bKX() && this.gNJ != null) {
            this.gNJ.a(this.gNB, frsViewData);
        }
    }

    public boolean bLb() {
        if (!bKX() || this.gNB == null) {
            return false;
        }
        return this.gNB.bLb();
    }

    public boolean bLc() {
        if (!bKX() || this.gNB == null) {
            return false;
        }
        return this.gNB.bLc();
    }

    public void mk(boolean z) {
        if (this.gNK != null) {
            this.gNK.mk(z);
        }
    }

    public void bKN() {
        if (this.gNK != null) {
            this.gNK.bKN();
        }
    }

    public void BR(String str) {
        if (this.gHP.bDT() != null && this.gHP.bDT().bJt() != null) {
            com.baidu.tieba.tbadkCore.e.cKw().aA(com.baidu.tieba.tbadkCore.e.cKw().e("1~" + str, this.gHP.bDT().bJt().getSortType(), this.gHP.bDT().bJt().getIsGood(), this.gHP.bDT().bJt().getCategoryId()), false);
        }
    }

    public void bHh() {
        if (this.gNB != null) {
            this.gNB.bHh();
        }
    }

    public static boolean k(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().aAC(), true) || frsViewData.getBookInfo().aAC().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean l(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().cKJ() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || v.isEmpty(frsViewData.getActivityHeadData().aAA())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().aAJ(), true)))) ? false : true;
        }
        return false;
    }

    public void uu(int i) {
        View findViewById;
        if (this.gNB != null && this.gNB.bLU() != null && (findViewById = this.gNB.bLU().findViewById(R.id.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.gNH != null) {
            this.gNH.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.gNI = frsTabViewController;
    }
}
