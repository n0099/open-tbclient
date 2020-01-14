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
/* loaded from: classes7.dex */
public class h extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Runnable emJ;
    private FrsFragment gEE;
    private BdUniqueId gKd;
    private com.baidu.tieba.frs.view.b gKj;
    private com.baidu.tieba.frs.entelechy.b.a gKk;
    private boolean gKl;
    private String gKm;
    private boolean gKn;
    private int gKo;
    private com.baidu.tieba.f.a gKp;
    private FrsTabViewController gKq;
    private g gKr;
    private f gKs;
    private final Runnable gKt;
    private FrsHeaderViewContainer goF;
    private final View.OnClickListener gon;
    private int mScrollState;
    private int mSkinType;

    public h(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.gKl = false;
        this.mSkinType = 0;
        this.gKm = "normal_page";
        this.mScrollState = 0;
        this.gKn = false;
        this.gKt = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tieba.frs.l bCk;
                if (h.this.gEE != null && h.this.mScrollState == 0 && (bCk = h.this.gEE.bCk()) != null && bCk.bDh() != null && !bCk.bDh().bIQ() && !bCk.bCL() && h.this.goF.isShown() && h.this.gEE.isPrimary() && !h.this.gKn && h.this.gEE.bCR() && h.this.gKo == 1 && h.this.bJg() && h.this.gKj != null && h.this.gKj.bKa()) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                    h.this.bFq();
                    h.this.gEE.glW = true;
                    h.this.gKn = true;
                }
            }
        };
        this.emJ = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.goF != null) {
                    int childCount = h.this.goF.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(h.this.goF.getChildAt(i));
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
        this.gon = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.gEE != null) {
                    FrsViewData bCK = h.this.gEE.bCK();
                    if (bCK != null && bCK.getForum() != null && h.this.gKj != null && (view == h.this.gKj.bKc() || view == h.this.gKj.bKd() || view == h.this.gKj.bKe())) {
                        if (h.this.gEE != null && bCK.getForum() != null) {
                            TiebaStatic.log(new an("c12046").cp("fid", bCK.getForum().getId()).Z("obj_locate", h.this.gEE.bCN() ? 1 : 2));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), bCK.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    }
                    int id = view.getId();
                    if (id == R.id.tv_love) {
                        if (!h.this.gEE.bCL()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.gEE.showToast(R.string.neterror);
                            } else if (!bc.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                TiebaStatic.log(new an("c10517").Z("obj_locate", 1).cp("fid", h.this.gEE.getForumId()));
                            } else {
                                h.this.mc(true);
                                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    an anVar = new an("c10048");
                                    anVar.cp("fid", h.this.gEE.getForumId());
                                    anVar.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(anVar);
                                }
                            }
                        }
                    } else if (id == R.id.tv_sign) {
                        if (!h.this.gEE.bCL()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.gEE.showToast(R.string.neterror);
                            } else if (bc.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                if (!h.this.bJk()) {
                                    h.this.bIZ();
                                    an.tf("c13560").Z("obj_type", 2).aEm();
                                } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(h.this.gEE.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(h.this.gEE.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                                }
                            }
                        }
                    } else if (id == R.id.frs_header_games) {
                        if (bc.checkUpIsLogin(h.this.mContext.getPageActivity()) && bCK != null && bCK.getGameUrl() != null) {
                            ba.aEt().a((TbPageContext) h.this.getPageContext(), new String[]{bCK.getGameUrl()}, true);
                        }
                    } else if (id == R.id.frs_bawu_center) {
                        if (bCK != null && bCK.getUserData() != null && bCK.getUserData().isBawu()) {
                            String bawuCenterUrl = bCK.getBawuCenterUrl();
                            if (!aq.isEmpty(bawuCenterUrl)) {
                                com.baidu.tbadk.browser.a.startWebActivity(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (bCK.getForum() != null) {
                                    TiebaStatic.log(new an("c10502").cp("fid", bCK.getForum().getId()).cp("uid", bCK.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id == R.id.level_container && !h.this.gEE.bCL() && h.this.mScrollState == 0 && h.this.bJg() && h.this.gKj != null) {
                        h.this.gKj.i(view, false);
                    }
                }
            }
        };
        this.gEE = frsFragment;
        this.gKk = aVar;
        this.goF = frsHeaderViewContainer;
        this.gKd = BdUniqueId.gen();
        this.gKr = new g(this.gEE, this.gKd);
        this.gKs = new f(this.gEE);
        this.gKp = new com.baidu.tieba.f.a();
    }

    public void aj(Bundle bundle) {
        if (this.gKr != null) {
            this.gKr.registerListener();
        }
        if (this.gKs != null) {
            this.gKs.aef();
        }
        this.gKn = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void ags() {
        if (this.gKj != null) {
            this.gKj.onDestory();
        }
        if (this.gKs != null) {
            this.gKs.ags();
        }
        if (this.gKt != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gKt);
        }
    }

    public void aFn() {
        if (this.gKj != null) {
            this.gKj.onStop();
        }
        if (this.goF != null) {
            this.goF.removeCallbacks(this.emJ);
        }
    }

    public void lg(boolean z) {
        if (this.gKj != null) {
            this.gKj.lg(z);
        }
    }

    public boolean ud(int i) {
        this.mSkinType = i;
        if (this.gKj != null) {
            this.gKj.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void me(boolean z) {
        if (z) {
            if (this.gKj != null) {
                this.goF.removeHeaderView(this.gKj.bKb());
                this.gKl = false;
            }
        } else if (this.gKj != null && this.gKj.bKb() != null && !this.gKl) {
            this.goF.addHeaderView(this.gKj.bKb(), this.goF.getHeaderViewsCount());
            this.gKl = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            v(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean bJa() {
        return true;
    }

    private void v(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.gKm, str);
        this.gKo = i2;
        this.gKm = str;
        bJd();
        if (this.gKj == null || z) {
            this.gKj = this.gKk.a(str, this.gEE, i);
            this.gKj.changeSkinType(this.mSkinType);
            this.gKj.x(this.gon);
        }
        if (this.gKr != null) {
            this.gKj.f(this.gKr);
        }
        if (this.gKs != null) {
            this.gKj.g(this.gKs);
        }
        this.goF.addHeaderView(this.gKj.getView());
        Bz(str);
        bJb();
    }

    private void bJb() {
        com.baidu.adp.lib.f.e.gx().postDelayed(this.gKt, 4000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFq() {
        if (bJg() && this.gKj != null) {
            this.gKj.bFq();
        }
    }

    public void bJc() {
        if (!this.gKl && this.gKj != null) {
            this.goF.addHeaderView(this.gKj.bKb());
            this.gKl = true;
        }
    }

    private void bJd() {
        if (this.gKj != null) {
            this.goF.removeHeaderView(this.gKj.getView());
            this.goF.removeHeaderView(this.gKj.bKb());
            bJe();
        }
        this.gKl = false;
    }

    private void bJe() {
        if (this.gKq != null && this.gEE != null && this.gEE.aFQ() != null) {
            this.gEE.aFQ().removeHeaderView(this.gKq.bJp());
        }
    }

    private void Bz(String str) {
        RelativeLayout bJp;
        if (this.gKq != null && this.gEE != null && this.gEE.aFQ() != null && (bJp = this.gKq.bJp()) != null) {
            if ("brand_page".equals(str)) {
                this.gEE.aFQ().removeHeaderView(bJp);
                return;
            }
            this.gEE.aFQ().removeHeaderView(bJp);
            this.gEE.aFQ().addHeaderView(bJp, 0);
        }
    }

    public void i(FrsViewData frsViewData) {
        if (frsViewData != null && bJg()) {
            b(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.gKm)) {
                this.gKj.bFf();
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float b = b(forumData);
            if (this.gKj != null) {
                this.gKj.a(forumData, frsViewData);
                this.gKj.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                this.gKj.a(forumData.getSignData());
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null || this.gKr == null) {
            return 0.0f;
        }
        return this.gKr.b(forumData);
    }

    public void ue(int i) {
        if (i > 1) {
            if (this.gKj != null) {
                this.gKj.mm(false);
            }
        } else if (this.gKj != null) {
            this.gKj.mm(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void bJf() {
        if (this.goF != null) {
            this.goF.removeCallbacks(this.emJ);
            this.goF.postDelayed(this.emJ, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bJg() {
        return "frs_page".equals(this.gKm) || "normal_page".equals(this.gKm) || "book_page".equals(this.gKm) || "brand_page".equals(this.gKm);
    }

    public void k(Integer num) {
        setIsMem(num.intValue());
        if (bJg()) {
            bJh();
        }
    }

    public void setIsMem(int i) {
        if (this.gKj != null) {
            this.gKj.setMemberType(i);
        }
    }

    public void bJh() {
        if (this.gKj != null) {
            this.gKj.bFs();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && bJg()) {
            a(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void bJi() {
        if (bJg()) {
            ug(0);
        }
    }

    public void uf(int i) {
        if (bJg()) {
            ug(i);
        }
    }

    public void ug(int i) {
        if (this.gKj != null) {
            this.gKj.uz(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.gKj != null) {
            this.gKj.a(forumData, frsViewData);
            if (forumData != null) {
                this.gKj.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.gKj.md(false);
                }
            }
        }
    }

    public boolean bJj() {
        if (!bJg() || this.gKj == null) {
            return false;
        }
        return this.gKj.bJZ();
    }

    public void bIZ() {
        if (this.gKr != null) {
            this.gKr.bIZ();
        }
    }

    public void K(int i, int i2, int i3) {
        if (this.gKr != null) {
            this.gKr.K(i, i2, i3);
        }
    }

    public void uh(int i) {
        if (bJg() && this.gKj != null) {
            this.gKj.uA(i);
        }
    }

    public void j(FrsViewData frsViewData) {
        if (bJg() && this.gKr != null) {
            this.gKr.a(this.gKj, frsViewData);
        }
    }

    public boolean bJk() {
        if (!bJg() || this.gKj == null) {
            return false;
        }
        return this.gKj.bJk();
    }

    public boolean bJl() {
        if (!bJg() || this.gKj == null) {
            return false;
        }
        return this.gKj.bJl();
    }

    public void mc(boolean z) {
        if (this.gKs != null) {
            this.gKs.mc(z);
        }
    }

    public void bIV() {
        if (this.gKs != null) {
            this.gKs.bIV();
        }
    }

    public void BA(String str) {
        if (this.gEE.bCf() != null && this.gEE.bCf().bHC() != null) {
            com.baidu.tieba.tbadkCore.d.cIv().aA(com.baidu.tieba.tbadkCore.d.cIv().e("1~" + str, this.gEE.bCf().bHC().getSortType(), this.gEE.bCf().bHC().getIsGood(), this.gEE.bCf().bHC().getCategoryId()), false);
        }
    }

    public void bFn() {
        if (this.gKj != null) {
            this.gKj.bFn();
        }
    }

    public static boolean k(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().ayj(), true) || frsViewData.getBookInfo().ayj().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean l(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().cII() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || v.isEmpty(frsViewData.getActivityHeadData().ayh())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().ayq(), true)))) ? false : true;
        }
        return false;
    }

    public void ui(int i) {
        View findViewById;
        if (this.gKj != null && this.gKj.bKb() != null && (findViewById = this.gKj.bKb().findViewById(R.id.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.gKp != null) {
            this.gKp.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.gKq = frsTabViewController;
    }
}
