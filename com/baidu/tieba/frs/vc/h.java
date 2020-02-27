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
    private Runnable eqX;
    private FrsFragment gGD;
    private BdUniqueId gMc;
    private com.baidu.tieba.frs.view.b gMi;
    private com.baidu.tieba.frs.entelechy.b.a gMj;
    private boolean gMk;
    private String gMl;
    private boolean gMm;
    private int gMn;
    private com.baidu.tieba.f.a gMo;
    private FrsTabViewController gMp;
    private g gMq;
    private f gMr;
    private final Runnable gMs;
    private FrsHeaderViewContainer gqG;
    private final View.OnClickListener gqo;
    private int mScrollState;
    private int mSkinType;

    public h(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.gMk = false;
        this.mSkinType = 0;
        this.gMl = "normal_page";
        this.mScrollState = 0;
        this.gMm = false;
        this.gMs = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tieba.frs.l bDN;
                if (h.this.gGD != null && h.this.mScrollState == 0 && (bDN = h.this.gGD.bDN()) != null && bDN.bEK() != null && !bDN.bEK().bKs() && !bDN.bEo() && h.this.gqG.isShown() && h.this.gGD.isPrimary() && !h.this.gMm && h.this.gGD.bEu() && h.this.gMn == 1 && h.this.bKH() && h.this.gMi != null && h.this.gMi.bLC()) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                    h.this.bGS();
                    h.this.gGD.gnX = true;
                    h.this.gMm = true;
                }
            }
        };
        this.eqX = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.gqG != null) {
                    int childCount = h.this.gqG.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(h.this.gqG.getChildAt(i));
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
        this.gqo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.gGD != null) {
                    FrsViewData bEn = h.this.gGD.bEn();
                    if (bEn != null && bEn.getForum() != null && h.this.gMi != null && (view == h.this.gMi.bLE() || view == h.this.gMi.bLF() || view == h.this.gMi.bLG())) {
                        if (h.this.gGD != null && bEn.getForum() != null) {
                            TiebaStatic.log(new an("c12046").cy("fid", bEn.getForum().getId()).X("obj_locate", h.this.gGD.bEq() ? 1 : 2));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), bEn.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    }
                    int id = view.getId();
                    if (id == R.id.tv_love) {
                        if (!h.this.gGD.bEo()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.gGD.showToast(R.string.neterror);
                            } else if (!bc.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                TiebaStatic.log(new an("c10517").X("obj_locate", 1).cy("fid", h.this.gGD.getForumId()));
                            } else {
                                h.this.me(true);
                                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    an anVar = new an("c10048");
                                    anVar.cy("fid", h.this.gGD.getForumId());
                                    anVar.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(anVar);
                                }
                            }
                        }
                    } else if (id == R.id.tv_sign) {
                        if (!h.this.gGD.bEo()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.gGD.showToast(R.string.neterror);
                            } else if (bc.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                if (!h.this.bKL()) {
                                    h.this.bKB();
                                    an.tv("c13560").X("obj_type", 2).aGx();
                                } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(h.this.gGD.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(h.this.gGD.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                                }
                            }
                        }
                    } else if (id == R.id.frs_header_games) {
                        if (bc.checkUpIsLogin(h.this.mContext.getPageActivity()) && bEn != null && bEn.getGameUrl() != null) {
                            ba.aGE().a((TbPageContext) h.this.getPageContext(), new String[]{bEn.getGameUrl()}, true);
                        }
                    } else if (id == R.id.frs_bawu_center) {
                        if (bEn != null && bEn.getUserData() != null && bEn.getUserData().isBawu()) {
                            String bawuCenterUrl = bEn.getBawuCenterUrl();
                            if (!aq.isEmpty(bawuCenterUrl)) {
                                com.baidu.tbadk.browser.a.startWebActivity(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (bEn.getForum() != null) {
                                    TiebaStatic.log(new an("c10502").cy("fid", bEn.getForum().getId()).cy("uid", bEn.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id == R.id.level_container && !h.this.gGD.bEo() && h.this.mScrollState == 0 && h.this.bKH() && h.this.gMi != null) {
                        h.this.gMi.i(view, false);
                    }
                }
            }
        };
        this.gGD = frsFragment;
        this.gMj = aVar;
        this.gqG = frsHeaderViewContainer;
        this.gMc = BdUniqueId.gen();
        this.gMq = new g(this.gGD, this.gMc);
        this.gMr = new f(this.gGD);
        this.gMo = new com.baidu.tieba.f.a();
    }

    public void aj(Bundle bundle) {
        if (this.gMq != null) {
            this.gMq.registerListener();
        }
        if (this.gMr != null) {
            this.gMr.agt();
        }
        this.gMm = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void aiG() {
        if (this.gMi != null) {
            this.gMi.onDestory();
        }
        if (this.gMr != null) {
            this.gMr.aiG();
        }
        if (this.gMs != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gMs);
        }
    }

    public void aHz() {
        if (this.gMi != null) {
            this.gMi.onStop();
        }
        if (this.gqG != null) {
            this.gqG.removeCallbacks(this.eqX);
        }
    }

    public void onPrimary(boolean z) {
        if (this.gMi != null) {
            this.gMi.onPrimary(z);
        }
    }

    public boolean uj(int i) {
        this.mSkinType = i;
        if (this.gMi != null) {
            this.gMi.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void mg(boolean z) {
        if (z) {
            if (this.gMi != null) {
                this.gqG.removeHeaderView(this.gMi.bLD());
                this.gMk = false;
            }
        } else if (this.gMi != null && this.gMi.bLD() != null && !this.gMk) {
            this.gqG.addHeaderView(this.gMi.bLD(), this.gqG.getHeaderViewsCount());
            this.gMk = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            v(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean bKC() {
        return true;
    }

    private void v(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.gMl, str);
        this.gMn = i2;
        this.gMl = str;
        bKE();
        if (this.gMi == null || z) {
            this.gMi = this.gMj.a(str, this.gGD, i);
            this.gMi.changeSkinType(this.mSkinType);
            this.gMi.y(this.gqo);
        }
        if (this.gMq != null) {
            this.gMi.f(this.gMq);
        }
        if (this.gMr != null) {
            this.gMi.g(this.gMr);
        }
        this.gqG.addHeaderView(this.gMi.getView());
        BP(str);
        bKD();
    }

    private void bKD() {
        com.baidu.adp.lib.f.e.gx().postDelayed(this.gMs, 4000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGS() {
        if (bKH() && this.gMi != null) {
            this.gMi.bGS();
        }
    }

    public void uj() {
        if (!this.gMk && this.gMi != null) {
            this.gqG.addHeaderView(this.gMi.bLD());
            this.gMk = true;
        }
    }

    private void bKE() {
        if (this.gMi != null) {
            this.gqG.removeHeaderView(this.gMi.getView());
            this.gqG.removeHeaderView(this.gMi.bLD());
            bKF();
        }
        this.gMk = false;
    }

    private void bKF() {
        if (this.gMp != null && this.gGD != null && this.gGD.aIf() != null) {
            this.gGD.aIf().removeHeaderView(this.gMp.bKQ());
        }
    }

    private void BP(String str) {
        RelativeLayout bKQ;
        if (this.gMp != null && this.gGD != null && this.gGD.aIf() != null && (bKQ = this.gMp.bKQ()) != null) {
            if ("brand_page".equals(str)) {
                this.gGD.aIf().removeHeaderView(bKQ);
                return;
            }
            this.gGD.aIf().removeHeaderView(bKQ);
            this.gGD.aIf().addHeaderView(bKQ, 0);
        }
    }

    public void i(FrsViewData frsViewData) {
        if (frsViewData != null && bKH()) {
            b(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.gMl)) {
                this.gMi.bGH();
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float b = b(forumData);
            if (this.gMi != null) {
                this.gMi.a(forumData, frsViewData);
                this.gMi.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                this.gMi.a(forumData.getSignData());
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null || this.gMq == null) {
            return 0.0f;
        }
        return this.gMq.b(forumData);
    }

    public void uk(int i) {
        if (i > 1) {
            if (this.gMi != null) {
                this.gMi.mo(false);
            }
        } else if (this.gMi != null) {
            this.gMi.mo(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void bKG() {
        if (this.gqG != null) {
            this.gqG.removeCallbacks(this.eqX);
            this.gqG.postDelayed(this.eqX, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bKH() {
        return "frs_page".equals(this.gMl) || "normal_page".equals(this.gMl) || "book_page".equals(this.gMl) || "brand_page".equals(this.gMl);
    }

    public void k(Integer num) {
        setIsMem(num.intValue());
        if (bKH()) {
            bKI();
        }
    }

    public void setIsMem(int i) {
        if (this.gMi != null) {
            this.gMi.setMemberType(i);
        }
    }

    public void bKI() {
        if (this.gMi != null) {
            this.gMi.bGU();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && bKH()) {
            a(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void bKJ() {
        if (bKH()) {
            um(0);
        }
    }

    public void ul(int i) {
        if (bKH()) {
            um(i);
        }
    }

    public void um(int i) {
        if (this.gMi != null) {
            this.gMi.uF(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.gMi != null) {
            this.gMi.a(forumData, frsViewData);
            if (forumData != null) {
                this.gMi.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.gMi.mf(false);
                }
            }
        }
    }

    public boolean bKK() {
        if (!bKH() || this.gMi == null) {
            return false;
        }
        return this.gMi.bLB();
    }

    public void bKB() {
        if (this.gMq != null) {
            this.gMq.bKB();
        }
    }

    public void L(int i, int i2, int i3) {
        if (this.gMq != null) {
            this.gMq.L(i, i2, i3);
        }
    }

    public void un(int i) {
        if (bKH() && this.gMi != null) {
            this.gMi.uG(i);
        }
    }

    public void j(FrsViewData frsViewData) {
        if (bKH() && this.gMq != null) {
            this.gMq.a(this.gMi, frsViewData);
        }
    }

    public boolean bKL() {
        if (!bKH() || this.gMi == null) {
            return false;
        }
        return this.gMi.bKL();
    }

    public boolean bKM() {
        if (!bKH() || this.gMi == null) {
            return false;
        }
        return this.gMi.bKM();
    }

    public void me(boolean z) {
        if (this.gMr != null) {
            this.gMr.me(z);
        }
    }

    public void bKx() {
        if (this.gMr != null) {
            this.gMr.bKx();
        }
    }

    public void BQ(String str) {
        if (this.gGD.bDI() != null && this.gGD.bDI().bJe() != null) {
            com.baidu.tieba.tbadkCore.d.cJZ().aA(com.baidu.tieba.tbadkCore.d.cJZ().e("1~" + str, this.gGD.bDI().bJe().getSortType(), this.gGD.bDI().bJe().getIsGood(), this.gGD.bDI().bJe().getCategoryId()), false);
        }
    }

    public void bGP() {
        if (this.gMi != null) {
            this.gMi.bGP();
        }
    }

    public static boolean k(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().aAx(), true) || frsViewData.getBookInfo().aAx().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean l(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().cKm() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || v.isEmpty(frsViewData.getActivityHeadData().aAv())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().aAE(), true)))) ? false : true;
        }
        return false;
    }

    public void uo(int i) {
        View findViewById;
        if (this.gMi != null && this.gMi.bLD() != null && (findViewById = this.gMi.bLD().findViewById(R.id.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.gMo != null) {
            this.gMo.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.gMp = frsTabViewController;
    }
}
