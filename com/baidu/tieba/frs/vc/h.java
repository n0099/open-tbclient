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
    private Runnable eVj;
    private final View.OnClickListener haG;
    private FrsHeaderViewContainer haX;
    private FrsFragment hro;
    private BdUniqueId hxe;
    private com.baidu.tieba.frs.view.b hxk;
    private com.baidu.tieba.frs.entelechy.b.a hxl;
    private boolean hxm;
    private String hxn;
    private boolean hxo;
    private int hxp;
    private com.baidu.tieba.f.a hxq;
    private FrsTabViewController hxr;
    private g hxs;
    private f hxt;
    private final Runnable hxu;
    private int mScrollState;
    private int mSkinType;

    public h(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.hxm = false;
        this.mSkinType = 0;
        this.hxn = "normal_page";
        this.mScrollState = 0;
        this.hxo = false;
        this.hxu = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tieba.frs.n bOw;
                if (h.this.hro != null && h.this.mScrollState == 0 && (bOw = h.this.hro.bOw()) != null && bOw.bPw() != null && !bOw.bPw().bVh() && !bOw.bOY() && h.this.haX.isShown() && h.this.hro.isPrimary() && !h.this.hxo && h.this.hro.bPf() && h.this.hxp == 1 && h.this.bVw() && h.this.hxk != null && h.this.hxk.bWy()) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                    h.this.bRM();
                    h.this.hro.gYj = true;
                    h.this.hxo = true;
                }
            }
        };
        this.eVj = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.haX != null) {
                    int childCount = h.this.haX.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(h.this.haX.getChildAt(i));
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
        this.haG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.hro != null) {
                    FrsViewData bOX = h.this.hro.bOX();
                    if (bOX != null && bOX.getForum() != null && h.this.hxk != null && (view == h.this.hxk.bWA() || view == h.this.hxk.bWB() || view == h.this.hxk.bWC())) {
                        if (h.this.hro != null && bOX.getForum() != null) {
                            TiebaStatic.log(new an("c12046").cI("fid", bOX.getForum().getId()).af("obj_locate", h.this.hro.bPa() ? 1 : 2));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), bOX.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    }
                    int id = view.getId();
                    if (id == R.id.tv_love) {
                        if (!h.this.hro.bOY()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.hro.showToast(R.string.neterror);
                            } else if (!bc.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                TiebaStatic.log(new an("c10517").af("obj_locate", 1).cI("fid", h.this.hro.getForumId()));
                            } else {
                                h.this.no(true);
                                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    an anVar = new an("c10048");
                                    anVar.cI("fid", h.this.hro.getForumId());
                                    anVar.cI("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(anVar);
                                }
                            }
                        }
                    } else if (id == R.id.tv_sign) {
                        if (!h.this.hro.bOY()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.hro.showToast(R.string.neterror);
                            } else if (bc.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                if (!h.this.bVA()) {
                                    h.this.bVq();
                                    an.uL("c13560").af("obj_type", 2).aOO();
                                } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(h.this.hro.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(h.this.hro.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                                }
                            }
                        }
                    } else if (id == R.id.frs_header_games) {
                        if (bc.checkUpIsLogin(h.this.mContext.getPageActivity()) && bOX != null && bOX.getGameUrl() != null) {
                            ba.aOV().a((TbPageContext) h.this.getPageContext(), new String[]{bOX.getGameUrl()}, true);
                        }
                    } else if (id == R.id.frs_bawu_center) {
                        if (bOX != null && bOX.getUserData() != null && bOX.getUserData().isBawu()) {
                            String bawuCenterUrl = bOX.getBawuCenterUrl();
                            if (!aq.isEmpty(bawuCenterUrl)) {
                                com.baidu.tbadk.browser.a.startWebActivity(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (bOX.getForum() != null) {
                                    TiebaStatic.log(new an("c10502").cI("fid", bOX.getForum().getId()).cI("uid", bOX.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id == R.id.level_container) {
                        if (!h.this.hro.bOY() && h.this.mScrollState == 0 && h.this.bVw() && h.this.hxk != null) {
                            h.this.hxk.i(view, false);
                        }
                    } else if (id == R.id.frs_hot_rank_entry) {
                        if (bOX != null && bOX.getForum() != null && !TextUtils.isEmpty(bOX.getForum().getId())) {
                            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(h.this.getPageContext().getPageActivity());
                            hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(bOX.getForum().getId(), 0L)));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                            an anVar2 = new an("c13666");
                            anVar2.cI("fid", bOX.getForum().getId());
                            TiebaStatic.log(anVar2);
                        }
                    } else if (id == R.id.frs_manager_info_layout) {
                        if (bOX != null && bOX.getForum() != null && !TextUtils.isEmpty(bOX.getForum().getId())) {
                            if (bOX.getForum().isLike() == 0) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), bOX.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumMemberActivityConfig(h.this.getPageContext().getPageActivity(), String.valueOf(bOX.getForum().getId()), bOX.getForum().getName())));
                            }
                        }
                    } else if (id == R.id.frs_manager_application_layout && bOX != null && bOX.getForum() != null && !TextUtils.isEmpty(bOX.getForum().getId())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), bOX.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    }
                }
            }
        };
        this.hro = frsFragment;
        this.hxl = aVar;
        this.haX = frsHeaderViewContainer;
        this.hxe = BdUniqueId.gen();
        this.hxs = new g(this.hro, this.hxe);
        this.hxt = new f(this.hro);
        this.hxq = new com.baidu.tieba.f.a();
    }

    public void aj(Bundle bundle) {
        if (this.hxs != null) {
            this.hxs.registerListener();
        }
        if (this.hxt != null) {
            this.hxt.aoC();
        }
        this.hxo = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void aqS() {
        if (this.hxk != null) {
            this.hxk.onDestory();
        }
        if (this.hxt != null) {
            this.hxt.aqS();
        }
        if (this.hxu != null) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hxu);
        }
    }

    public void aPV() {
        if (this.hxk != null) {
            this.hxk.onStop();
        }
        if (this.haX != null) {
            this.haX.removeCallbacks(this.eVj);
        }
    }

    public void jb(boolean z) {
        if (this.hxk != null) {
            this.hxk.jb(z);
        }
    }

    public boolean uM(int i) {
        this.mSkinType = i;
        if (this.hxk != null) {
            this.hxk.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void nq(boolean z) {
        if (z) {
            if (this.hxk != null) {
                this.haX.removeHeaderView(this.hxk.bWz());
                this.hxm = false;
            }
        } else if (this.hxk != null && this.hxk.bWz() != null && !this.hxm) {
            this.haX.addHeaderView(this.hxk.bWz(), this.haX.getHeaderViewsCount());
            this.hxm = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            u(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean bVr() {
        return true;
    }

    private void u(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.hxn, str);
        this.hxp = i2;
        this.hxn = str;
        bVt();
        if (this.hxk == null || z) {
            this.hxk = this.hxl.a(str, this.hro, i);
            this.hxk.changeSkinType(this.mSkinType);
            this.hxk.z(this.haG);
        }
        if (this.hxs != null) {
            this.hxk.f(this.hxs);
        }
        if (this.hxt != null) {
            this.hxk.g(this.hxt);
        }
        this.haX.addHeaderView(this.hxk.getView());
        DB(str);
        bVs();
    }

    private void bVs() {
        com.baidu.adp.lib.f.e.lb().postDelayed(this.hxu, 4000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRM() {
        if (bVw() && this.hxk != null) {
            this.hxk.bRM();
        }
    }

    public void yH() {
        if (!this.hxm && this.hxk != null) {
            this.haX.addHeaderView(this.hxk.bWz());
            this.hxm = true;
        }
    }

    private void bVt() {
        if (this.hxk != null) {
            this.haX.removeHeaderView(this.hxk.getView());
            this.haX.removeHeaderView(this.hxk.bWz());
            bVu();
        }
        this.hxm = false;
    }

    private void bVu() {
        if (this.hxr != null && this.hro != null && this.hro.aQF() != null) {
            this.hro.aQF().removeHeaderView(this.hxr.bVJ());
        }
    }

    private void DB(String str) {
        RelativeLayout bVJ;
        if (this.hxr != null && this.hro != null && this.hro.aQF() != null && (bVJ = this.hxr.bVJ()) != null) {
            if ("brand_page".equals(str)) {
                this.hro.aQF().removeHeaderView(bVJ);
                return;
            }
            this.hro.aQF().removeHeaderView(bVJ);
            this.hro.aQF().addHeaderView(bVJ, 0);
        }
    }

    public void i(FrsViewData frsViewData) {
        if (frsViewData != null && bVw()) {
            b(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.hxn)) {
                this.hxk.bRz();
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float c = c(forumData);
            if (this.hxk != null) {
                this.hxk.a(forumData, frsViewData);
                this.hxk.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), c, false);
                this.hxk.a(forumData.getSignData());
            }
        }
    }

    private float c(ForumData forumData) {
        if (forumData == null || this.hxs == null) {
            return 0.0f;
        }
        return this.hxs.c(forumData);
    }

    public void uN(int i) {
        if (i > 1) {
            if (this.hxk != null) {
                this.hxk.ny(false);
            }
        } else if (this.hxk != null) {
            this.hxk.ny(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void bVv() {
        if (this.haX != null) {
            this.haX.removeCallbacks(this.eVj);
            this.haX.postDelayed(this.eVj, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bVw() {
        return "frs_page".equals(this.hxn) || "normal_page".equals(this.hxn) || "book_page".equals(this.hxn) || "brand_page".equals(this.hxn);
    }

    public void k(Integer num) {
        setIsMem(num.intValue());
        if (bVw()) {
            bVx();
        }
    }

    public void setIsMem(int i) {
        if (this.hxk != null) {
            this.hxk.setMemberType(i);
        }
    }

    public void bVx() {
        if (this.hxk != null) {
            this.hxk.bRO();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && bVw()) {
            a(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void bVy() {
        if (bVw()) {
            uP(0);
        }
    }

    public void uO(int i) {
        if (bVw()) {
            uP(i);
        }
    }

    public void uP(int i) {
        if (this.hxk != null) {
            this.hxk.vk(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.hxk != null) {
            this.hxk.a(forumData, frsViewData);
            if (forumData != null) {
                this.hxk.a(i, forumData.getLevelName(), forumData.getUser_level(), c(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.hxk.np(false);
                }
            }
        }
    }

    public boolean bVz() {
        if (!bVw() || this.hxk == null) {
            return false;
        }
        return this.hxk.bWx();
    }

    public void bVq() {
        if (this.hxs != null) {
            this.hxs.bVq();
        }
    }

    public void O(int i, int i2, int i3) {
        if (this.hxs != null) {
            this.hxs.O(i, i2, i3);
        }
    }

    public void uQ(int i) {
        if (bVw() && this.hxk != null) {
            this.hxk.vl(i);
        }
    }

    public void j(FrsViewData frsViewData) {
        if (bVw() && this.hxs != null) {
            this.hxs.a(this.hxk, frsViewData);
        }
    }

    public boolean bVA() {
        if (!bVw() || this.hxk == null) {
            return false;
        }
        return this.hxk.bVA();
    }

    public boolean bVB() {
        if (!bVw() || this.hxk == null) {
            return false;
        }
        return this.hxk.bVB();
    }

    public void no(boolean z) {
        if (this.hxt != null) {
            this.hxt.no(z);
        }
    }

    public void bVm() {
        if (this.hxt != null) {
            this.hxt.bVm();
        }
    }

    public void DC(String str) {
        if (this.hro.bOr() != null && this.hro.bOr().bTP() != null) {
            com.baidu.tieba.tbadkCore.e.cVq().aG(com.baidu.tieba.tbadkCore.e.cVq().e("1~" + str, this.hro.bOr().bTP().getSortType(), this.hro.bOr().bTP().getIsGood(), this.hro.bOr().bTP().getCategoryId()), false);
        }
    }

    public void bRJ() {
        if (this.hxk != null) {
            this.hxk.bRJ();
        }
    }

    public static boolean k(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().aIN(), true) || frsViewData.getBookInfo().aIN().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean l(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().cVD() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || v.isEmpty(frsViewData.getActivityHeadData().aIL())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().aIU(), true)))) ? false : true;
        }
        return false;
    }

    public void uR(int i) {
        View findViewById;
        if (this.hxk != null && this.hxk.bWz() != null && (findViewById = this.hxk.bWz().findViewById(R.id.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.hxq != null) {
            this.hxq.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.hxr = frsTabViewController;
    }
}
