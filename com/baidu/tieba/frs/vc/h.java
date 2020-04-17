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
    private Runnable eVe;
    private final View.OnClickListener haA;
    private FrsHeaderViewContainer haR;
    private FrsFragment hri;
    private BdUniqueId hwY;
    private com.baidu.tieba.frs.view.b hxe;
    private com.baidu.tieba.frs.entelechy.b.a hxf;
    private boolean hxg;
    private String hxh;
    private boolean hxi;
    private int hxj;
    private com.baidu.tieba.f.a hxk;
    private FrsTabViewController hxl;
    private g hxm;
    private f hxn;
    private final Runnable hxo;
    private int mScrollState;
    private int mSkinType;

    public h(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.hxg = false;
        this.mSkinType = 0;
        this.hxh = "normal_page";
        this.mScrollState = 0;
        this.hxi = false;
        this.hxo = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tieba.frs.n bOx;
                if (h.this.hri != null && h.this.mScrollState == 0 && (bOx = h.this.hri.bOx()) != null && bOx.bPx() != null && !bOx.bPx().bVi() && !bOx.bOZ() && h.this.haR.isShown() && h.this.hri.isPrimary() && !h.this.hxi && h.this.hri.bPg() && h.this.hxj == 1 && h.this.bVx() && h.this.hxe != null && h.this.hxe.bWz()) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                    h.this.bRN();
                    h.this.hri.gYd = true;
                    h.this.hxi = true;
                }
            }
        };
        this.eVe = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.haR != null) {
                    int childCount = h.this.haR.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(h.this.haR.getChildAt(i));
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
        this.haA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.hri != null) {
                    FrsViewData bOY = h.this.hri.bOY();
                    if (bOY != null && bOY.getForum() != null && h.this.hxe != null && (view == h.this.hxe.bWB() || view == h.this.hxe.bWC() || view == h.this.hxe.bWD())) {
                        if (h.this.hri != null && bOY.getForum() != null) {
                            TiebaStatic.log(new an("c12046").cI("fid", bOY.getForum().getId()).af("obj_locate", h.this.hri.bPb() ? 1 : 2));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), bOY.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    }
                    int id = view.getId();
                    if (id == R.id.tv_love) {
                        if (!h.this.hri.bOZ()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.hri.showToast(R.string.neterror);
                            } else if (!bc.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                TiebaStatic.log(new an("c10517").af("obj_locate", 1).cI("fid", h.this.hri.getForumId()));
                            } else {
                                h.this.no(true);
                                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    an anVar = new an("c10048");
                                    anVar.cI("fid", h.this.hri.getForumId());
                                    anVar.cI("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(anVar);
                                }
                            }
                        }
                    } else if (id == R.id.tv_sign) {
                        if (!h.this.hri.bOZ()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.hri.showToast(R.string.neterror);
                            } else if (bc.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                if (!h.this.bVB()) {
                                    h.this.bVr();
                                    an.uI("c13560").af("obj_type", 2).aOR();
                                } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(h.this.hri.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(h.this.hri.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                                }
                            }
                        }
                    } else if (id == R.id.frs_header_games) {
                        if (bc.checkUpIsLogin(h.this.mContext.getPageActivity()) && bOY != null && bOY.getGameUrl() != null) {
                            ba.aOY().a((TbPageContext) h.this.getPageContext(), new String[]{bOY.getGameUrl()}, true);
                        }
                    } else if (id == R.id.frs_bawu_center) {
                        if (bOY != null && bOY.getUserData() != null && bOY.getUserData().isBawu()) {
                            String bawuCenterUrl = bOY.getBawuCenterUrl();
                            if (!aq.isEmpty(bawuCenterUrl)) {
                                com.baidu.tbadk.browser.a.startWebActivity(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (bOY.getForum() != null) {
                                    TiebaStatic.log(new an("c10502").cI("fid", bOY.getForum().getId()).cI("uid", bOY.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id == R.id.level_container) {
                        if (!h.this.hri.bOZ() && h.this.mScrollState == 0 && h.this.bVx() && h.this.hxe != null) {
                            h.this.hxe.i(view, false);
                        }
                    } else if (id == R.id.frs_hot_rank_entry) {
                        if (bOY != null && bOY.getForum() != null && !TextUtils.isEmpty(bOY.getForum().getId())) {
                            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(h.this.getPageContext().getPageActivity());
                            hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(bOY.getForum().getId(), 0L)));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                            an anVar2 = new an("c13666");
                            anVar2.cI("fid", bOY.getForum().getId());
                            TiebaStatic.log(anVar2);
                        }
                    } else if (id == R.id.frs_manager_info_layout) {
                        if (bOY != null && bOY.getForum() != null && !TextUtils.isEmpty(bOY.getForum().getId())) {
                            if (bOY.getForum().isLike() == 0) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), bOY.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumMemberActivityConfig(h.this.getPageContext().getPageActivity(), String.valueOf(bOY.getForum().getId()), bOY.getForum().getName())));
                            }
                        }
                    } else if (id == R.id.frs_manager_application_layout && bOY != null && bOY.getForum() != null && !TextUtils.isEmpty(bOY.getForum().getId())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), bOY.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    }
                }
            }
        };
        this.hri = frsFragment;
        this.hxf = aVar;
        this.haR = frsHeaderViewContainer;
        this.hwY = BdUniqueId.gen();
        this.hxm = new g(this.hri, this.hwY);
        this.hxn = new f(this.hri);
        this.hxk = new com.baidu.tieba.f.a();
    }

    public void aj(Bundle bundle) {
        if (this.hxm != null) {
            this.hxm.registerListener();
        }
        if (this.hxn != null) {
            this.hxn.aoD();
        }
        this.hxi = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void aqT() {
        if (this.hxe != null) {
            this.hxe.onDestory();
        }
        if (this.hxn != null) {
            this.hxn.aqT();
        }
        if (this.hxo != null) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hxo);
        }
    }

    public void aPY() {
        if (this.hxe != null) {
            this.hxe.onStop();
        }
        if (this.haR != null) {
            this.haR.removeCallbacks(this.eVe);
        }
    }

    public void jb(boolean z) {
        if (this.hxe != null) {
            this.hxe.jb(z);
        }
    }

    public boolean uM(int i) {
        this.mSkinType = i;
        if (this.hxe != null) {
            this.hxe.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void nq(boolean z) {
        if (z) {
            if (this.hxe != null) {
                this.haR.removeHeaderView(this.hxe.bWA());
                this.hxg = false;
            }
        } else if (this.hxe != null && this.hxe.bWA() != null && !this.hxg) {
            this.haR.addHeaderView(this.hxe.bWA(), this.haR.getHeaderViewsCount());
            this.hxg = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            u(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean bVs() {
        return true;
    }

    private void u(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.hxh, str);
        this.hxj = i2;
        this.hxh = str;
        bVu();
        if (this.hxe == null || z) {
            this.hxe = this.hxf.a(str, this.hri, i);
            this.hxe.changeSkinType(this.mSkinType);
            this.hxe.z(this.haA);
        }
        if (this.hxm != null) {
            this.hxe.f(this.hxm);
        }
        if (this.hxn != null) {
            this.hxe.g(this.hxn);
        }
        this.haR.addHeaderView(this.hxe.getView());
        Dy(str);
        bVt();
    }

    private void bVt() {
        com.baidu.adp.lib.f.e.lb().postDelayed(this.hxo, 4000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRN() {
        if (bVx() && this.hxe != null) {
            this.hxe.bRN();
        }
    }

    public void yI() {
        if (!this.hxg && this.hxe != null) {
            this.haR.addHeaderView(this.hxe.bWA());
            this.hxg = true;
        }
    }

    private void bVu() {
        if (this.hxe != null) {
            this.haR.removeHeaderView(this.hxe.getView());
            this.haR.removeHeaderView(this.hxe.bWA());
            bVv();
        }
        this.hxg = false;
    }

    private void bVv() {
        if (this.hxl != null && this.hri != null && this.hri.aQI() != null) {
            this.hri.aQI().removeHeaderView(this.hxl.bVK());
        }
    }

    private void Dy(String str) {
        RelativeLayout bVK;
        if (this.hxl != null && this.hri != null && this.hri.aQI() != null && (bVK = this.hxl.bVK()) != null) {
            if ("brand_page".equals(str)) {
                this.hri.aQI().removeHeaderView(bVK);
                return;
            }
            this.hri.aQI().removeHeaderView(bVK);
            this.hri.aQI().addHeaderView(bVK, 0);
        }
    }

    public void i(FrsViewData frsViewData) {
        if (frsViewData != null && bVx()) {
            b(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.hxh)) {
                this.hxe.bRA();
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float c = c(forumData);
            if (this.hxe != null) {
                this.hxe.a(forumData, frsViewData);
                this.hxe.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), c, false);
                this.hxe.a(forumData.getSignData());
            }
        }
    }

    private float c(ForumData forumData) {
        if (forumData == null || this.hxm == null) {
            return 0.0f;
        }
        return this.hxm.c(forumData);
    }

    public void uN(int i) {
        if (i > 1) {
            if (this.hxe != null) {
                this.hxe.ny(false);
            }
        } else if (this.hxe != null) {
            this.hxe.ny(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void bVw() {
        if (this.haR != null) {
            this.haR.removeCallbacks(this.eVe);
            this.haR.postDelayed(this.eVe, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bVx() {
        return "frs_page".equals(this.hxh) || "normal_page".equals(this.hxh) || "book_page".equals(this.hxh) || "brand_page".equals(this.hxh);
    }

    public void k(Integer num) {
        setIsMem(num.intValue());
        if (bVx()) {
            bVy();
        }
    }

    public void setIsMem(int i) {
        if (this.hxe != null) {
            this.hxe.setMemberType(i);
        }
    }

    public void bVy() {
        if (this.hxe != null) {
            this.hxe.bRP();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && bVx()) {
            a(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void bVz() {
        if (bVx()) {
            uP(0);
        }
    }

    public void uO(int i) {
        if (bVx()) {
            uP(i);
        }
    }

    public void uP(int i) {
        if (this.hxe != null) {
            this.hxe.vk(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.hxe != null) {
            this.hxe.a(forumData, frsViewData);
            if (forumData != null) {
                this.hxe.a(i, forumData.getLevelName(), forumData.getUser_level(), c(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.hxe.np(false);
                }
            }
        }
    }

    public boolean bVA() {
        if (!bVx() || this.hxe == null) {
            return false;
        }
        return this.hxe.bWy();
    }

    public void bVr() {
        if (this.hxm != null) {
            this.hxm.bVr();
        }
    }

    public void O(int i, int i2, int i3) {
        if (this.hxm != null) {
            this.hxm.O(i, i2, i3);
        }
    }

    public void uQ(int i) {
        if (bVx() && this.hxe != null) {
            this.hxe.vl(i);
        }
    }

    public void j(FrsViewData frsViewData) {
        if (bVx() && this.hxm != null) {
            this.hxm.a(this.hxe, frsViewData);
        }
    }

    public boolean bVB() {
        if (!bVx() || this.hxe == null) {
            return false;
        }
        return this.hxe.bVB();
    }

    public boolean bVC() {
        if (!bVx() || this.hxe == null) {
            return false;
        }
        return this.hxe.bVC();
    }

    public void no(boolean z) {
        if (this.hxn != null) {
            this.hxn.no(z);
        }
    }

    public void bVn() {
        if (this.hxn != null) {
            this.hxn.bVn();
        }
    }

    public void Dz(String str) {
        if (this.hri.bOs() != null && this.hri.bOs().bTQ() != null) {
            com.baidu.tieba.tbadkCore.e.cVs().aG(com.baidu.tieba.tbadkCore.e.cVs().e("1~" + str, this.hri.bOs().bTQ().getSortType(), this.hri.bOs().bTQ().getIsGood(), this.hri.bOs().bTQ().getCategoryId()), false);
        }
    }

    public void bRK() {
        if (this.hxe != null) {
            this.hxe.bRK();
        }
    }

    public static boolean k(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().aIP(), true) || frsViewData.getBookInfo().aIP().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean l(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().cVF() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || v.isEmpty(frsViewData.getActivityHeadData().aIN())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().aIW(), true)))) ? false : true;
        }
        return false;
    }

    public void uR(int i) {
        View findViewById;
        if (this.hxe != null && this.hxe.bWA() != null && (findViewById = this.hxe.bWA().findViewById(R.id.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.hxk != null) {
            this.hxk.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.hxl = frsTabViewController;
    }
}
