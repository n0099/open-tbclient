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
    private Runnable eqY;
    private FrsFragment gGF;
    private BdUniqueId gMe;
    private com.baidu.tieba.frs.view.b gMk;
    private com.baidu.tieba.frs.entelechy.b.a gMl;
    private boolean gMm;
    private String gMn;
    private boolean gMo;
    private int gMp;
    private com.baidu.tieba.f.a gMq;
    private FrsTabViewController gMr;
    private g gMs;
    private f gMt;
    private final Runnable gMu;
    private FrsHeaderViewContainer gqI;
    private final View.OnClickListener gqq;
    private int mScrollState;
    private int mSkinType;

    public h(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.gMm = false;
        this.mSkinType = 0;
        this.gMn = "normal_page";
        this.mScrollState = 0;
        this.gMo = false;
        this.gMu = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tieba.frs.l bDP;
                if (h.this.gGF != null && h.this.mScrollState == 0 && (bDP = h.this.gGF.bDP()) != null && bDP.bEM() != null && !bDP.bEM().bKu() && !bDP.bEq() && h.this.gqI.isShown() && h.this.gGF.isPrimary() && !h.this.gMo && h.this.gGF.bEw() && h.this.gMp == 1 && h.this.bKJ() && h.this.gMk != null && h.this.gMk.bLE()) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                    h.this.bGU();
                    h.this.gGF.gnZ = true;
                    h.this.gMo = true;
                }
            }
        };
        this.eqY = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.gqI != null) {
                    int childCount = h.this.gqI.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(h.this.gqI.getChildAt(i));
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
        this.gqq = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.gGF != null) {
                    FrsViewData bEp = h.this.gGF.bEp();
                    if (bEp != null && bEp.getForum() != null && h.this.gMk != null && (view == h.this.gMk.bLG() || view == h.this.gMk.bLH() || view == h.this.gMk.bLI())) {
                        if (h.this.gGF != null && bEp.getForum() != null) {
                            TiebaStatic.log(new an("c12046").cy("fid", bEp.getForum().getId()).X("obj_locate", h.this.gGF.bEs() ? 1 : 2));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), bEp.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    }
                    int id = view.getId();
                    if (id == R.id.tv_love) {
                        if (!h.this.gGF.bEq()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.gGF.showToast(R.string.neterror);
                            } else if (!bc.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                TiebaStatic.log(new an("c10517").X("obj_locate", 1).cy("fid", h.this.gGF.getForumId()));
                            } else {
                                h.this.me(true);
                                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    an anVar = new an("c10048");
                                    anVar.cy("fid", h.this.gGF.getForumId());
                                    anVar.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(anVar);
                                }
                            }
                        }
                    } else if (id == R.id.tv_sign) {
                        if (!h.this.gGF.bEq()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.gGF.showToast(R.string.neterror);
                            } else if (bc.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                if (!h.this.bKN()) {
                                    h.this.bKD();
                                    an.tv("c13560").X("obj_type", 2).aGz();
                                } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(h.this.gGF.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(h.this.gGF.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                                }
                            }
                        }
                    } else if (id == R.id.frs_header_games) {
                        if (bc.checkUpIsLogin(h.this.mContext.getPageActivity()) && bEp != null && bEp.getGameUrl() != null) {
                            ba.aGG().a((TbPageContext) h.this.getPageContext(), new String[]{bEp.getGameUrl()}, true);
                        }
                    } else if (id == R.id.frs_bawu_center) {
                        if (bEp != null && bEp.getUserData() != null && bEp.getUserData().isBawu()) {
                            String bawuCenterUrl = bEp.getBawuCenterUrl();
                            if (!aq.isEmpty(bawuCenterUrl)) {
                                com.baidu.tbadk.browser.a.startWebActivity(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (bEp.getForum() != null) {
                                    TiebaStatic.log(new an("c10502").cy("fid", bEp.getForum().getId()).cy("uid", bEp.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id == R.id.level_container && !h.this.gGF.bEq() && h.this.mScrollState == 0 && h.this.bKJ() && h.this.gMk != null) {
                        h.this.gMk.i(view, false);
                    }
                }
            }
        };
        this.gGF = frsFragment;
        this.gMl = aVar;
        this.gqI = frsHeaderViewContainer;
        this.gMe = BdUniqueId.gen();
        this.gMs = new g(this.gGF, this.gMe);
        this.gMt = new f(this.gGF);
        this.gMq = new com.baidu.tieba.f.a();
    }

    public void aj(Bundle bundle) {
        if (this.gMs != null) {
            this.gMs.registerListener();
        }
        if (this.gMt != null) {
            this.gMt.agv();
        }
        this.gMo = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void aiI() {
        if (this.gMk != null) {
            this.gMk.onDestory();
        }
        if (this.gMt != null) {
            this.gMt.aiI();
        }
        if (this.gMu != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gMu);
        }
    }

    public void aHB() {
        if (this.gMk != null) {
            this.gMk.onStop();
        }
        if (this.gqI != null) {
            this.gqI.removeCallbacks(this.eqY);
        }
    }

    public void onPrimary(boolean z) {
        if (this.gMk != null) {
            this.gMk.onPrimary(z);
        }
    }

    public boolean uj(int i) {
        this.mSkinType = i;
        if (this.gMk != null) {
            this.gMk.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void mg(boolean z) {
        if (z) {
            if (this.gMk != null) {
                this.gqI.removeHeaderView(this.gMk.bLF());
                this.gMm = false;
            }
        } else if (this.gMk != null && this.gMk.bLF() != null && !this.gMm) {
            this.gqI.addHeaderView(this.gMk.bLF(), this.gqI.getHeaderViewsCount());
            this.gMm = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            v(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean bKE() {
        return true;
    }

    private void v(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.gMn, str);
        this.gMp = i2;
        this.gMn = str;
        bKG();
        if (this.gMk == null || z) {
            this.gMk = this.gMl.a(str, this.gGF, i);
            this.gMk.changeSkinType(this.mSkinType);
            this.gMk.y(this.gqq);
        }
        if (this.gMs != null) {
            this.gMk.f(this.gMs);
        }
        if (this.gMt != null) {
            this.gMk.g(this.gMt);
        }
        this.gqI.addHeaderView(this.gMk.getView());
        BP(str);
        bKF();
    }

    private void bKF() {
        com.baidu.adp.lib.f.e.gx().postDelayed(this.gMu, 4000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGU() {
        if (bKJ() && this.gMk != null) {
            this.gMk.bGU();
        }
    }

    public void uj() {
        if (!this.gMm && this.gMk != null) {
            this.gqI.addHeaderView(this.gMk.bLF());
            this.gMm = true;
        }
    }

    private void bKG() {
        if (this.gMk != null) {
            this.gqI.removeHeaderView(this.gMk.getView());
            this.gqI.removeHeaderView(this.gMk.bLF());
            bKH();
        }
        this.gMm = false;
    }

    private void bKH() {
        if (this.gMr != null && this.gGF != null && this.gGF.aIh() != null) {
            this.gGF.aIh().removeHeaderView(this.gMr.bKS());
        }
    }

    private void BP(String str) {
        RelativeLayout bKS;
        if (this.gMr != null && this.gGF != null && this.gGF.aIh() != null && (bKS = this.gMr.bKS()) != null) {
            if ("brand_page".equals(str)) {
                this.gGF.aIh().removeHeaderView(bKS);
                return;
            }
            this.gGF.aIh().removeHeaderView(bKS);
            this.gGF.aIh().addHeaderView(bKS, 0);
        }
    }

    public void i(FrsViewData frsViewData) {
        if (frsViewData != null && bKJ()) {
            b(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.gMn)) {
                this.gMk.bGJ();
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float b = b(forumData);
            if (this.gMk != null) {
                this.gMk.a(forumData, frsViewData);
                this.gMk.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                this.gMk.a(forumData.getSignData());
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null || this.gMs == null) {
            return 0.0f;
        }
        return this.gMs.b(forumData);
    }

    public void uk(int i) {
        if (i > 1) {
            if (this.gMk != null) {
                this.gMk.mo(false);
            }
        } else if (this.gMk != null) {
            this.gMk.mo(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void bKI() {
        if (this.gqI != null) {
            this.gqI.removeCallbacks(this.eqY);
            this.gqI.postDelayed(this.eqY, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bKJ() {
        return "frs_page".equals(this.gMn) || "normal_page".equals(this.gMn) || "book_page".equals(this.gMn) || "brand_page".equals(this.gMn);
    }

    public void k(Integer num) {
        setIsMem(num.intValue());
        if (bKJ()) {
            bKK();
        }
    }

    public void setIsMem(int i) {
        if (this.gMk != null) {
            this.gMk.setMemberType(i);
        }
    }

    public void bKK() {
        if (this.gMk != null) {
            this.gMk.bGW();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && bKJ()) {
            a(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void bKL() {
        if (bKJ()) {
            um(0);
        }
    }

    public void ul(int i) {
        if (bKJ()) {
            um(i);
        }
    }

    public void um(int i) {
        if (this.gMk != null) {
            this.gMk.uF(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.gMk != null) {
            this.gMk.a(forumData, frsViewData);
            if (forumData != null) {
                this.gMk.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.gMk.mf(false);
                }
            }
        }
    }

    public boolean bKM() {
        if (!bKJ() || this.gMk == null) {
            return false;
        }
        return this.gMk.bLD();
    }

    public void bKD() {
        if (this.gMs != null) {
            this.gMs.bKD();
        }
    }

    public void L(int i, int i2, int i3) {
        if (this.gMs != null) {
            this.gMs.L(i, i2, i3);
        }
    }

    public void un(int i) {
        if (bKJ() && this.gMk != null) {
            this.gMk.uG(i);
        }
    }

    public void j(FrsViewData frsViewData) {
        if (bKJ() && this.gMs != null) {
            this.gMs.a(this.gMk, frsViewData);
        }
    }

    public boolean bKN() {
        if (!bKJ() || this.gMk == null) {
            return false;
        }
        return this.gMk.bKN();
    }

    public boolean bKO() {
        if (!bKJ() || this.gMk == null) {
            return false;
        }
        return this.gMk.bKO();
    }

    public void me(boolean z) {
        if (this.gMt != null) {
            this.gMt.me(z);
        }
    }

    public void bKz() {
        if (this.gMt != null) {
            this.gMt.bKz();
        }
    }

    public void BQ(String str) {
        if (this.gGF.bDK() != null && this.gGF.bDK().bJg() != null) {
            com.baidu.tieba.tbadkCore.d.cKb().aA(com.baidu.tieba.tbadkCore.d.cKb().e("1~" + str, this.gGF.bDK().bJg().getSortType(), this.gGF.bDK().bJg().getIsGood(), this.gGF.bDK().bJg().getCategoryId()), false);
        }
    }

    public void bGR() {
        if (this.gMk != null) {
            this.gMk.bGR();
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
            return ((frsViewData.getStar() == null || frsViewData.getStar().cKo() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || v.isEmpty(frsViewData.getActivityHeadData().aAx())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().aAG(), true)))) ? false : true;
        }
        return false;
    }

    public void uo(int i) {
        View findViewById;
        if (this.gMk != null && this.gMk.bLF() != null && (findViewById = this.gMk.bLF().findViewById(R.id.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.gMq != null) {
            this.gMq.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.gMr = frsTabViewController;
    }
}
