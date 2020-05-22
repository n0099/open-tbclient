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
    private Runnable fhR;
    private FrsFragment hGd;
    private BdUniqueId hLR;
    private com.baidu.tieba.frs.view.b hLX;
    private com.baidu.tieba.frs.entelechy.b.a hLY;
    private boolean hLZ;
    private String hMa;
    private boolean hMb;
    private int hMc;
    private com.baidu.tieba.f.a hMd;
    private FrsTabViewController hMe;
    private g hMf;
    private f hMg;
    private final Runnable hMh;
    private FrsHeaderViewContainer hpL;
    private final View.OnClickListener hpu;
    private int mScrollState;
    private int mSkinType;

    public h(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.hLZ = false;
        this.mSkinType = 0;
        this.hMa = "normal_page";
        this.mScrollState = 0;
        this.hMb = false;
        this.hMh = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tieba.frs.n bUR;
                if (h.this.hGd != null && h.this.mScrollState == 0 && (bUR = h.this.hGd.bUR()) != null && bUR.bVS() != null && !bUR.bVS().cbE() && !bUR.bVt() && h.this.hpL.isShown() && h.this.hGd.isPrimary() && !h.this.hMb && h.this.hGd.bVA() && h.this.hMc == 1 && h.this.cbU() && h.this.hLX != null && h.this.hLX.ccW()) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                    h.this.bYi();
                    h.this.hGd.hmV = true;
                    h.this.hMb = true;
                }
            }
        };
        this.fhR = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.hpL != null) {
                    int childCount = h.this.hpL.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(h.this.hpL.getChildAt(i));
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
        this.hpu = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.hGd != null) {
                    FrsViewData bVs = h.this.hGd.bVs();
                    if (bVs != null && bVs.getForum() != null && h.this.hLX != null && (view == h.this.hLX.ccY() || view == h.this.hLX.ccZ() || view == h.this.hLX.cda())) {
                        if (h.this.hGd != null && bVs.getForum() != null) {
                            TiebaStatic.log(new an("c12046").dh("fid", bVs.getForum().getId()).ag("obj_locate", h.this.hGd.bVv() ? 1 : 2));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), bVs.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    }
                    int id = view.getId();
                    if (id == R.id.tv_love) {
                        if (!h.this.hGd.bVt()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.hGd.showToast(R.string.neterror);
                            } else if (!bc.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                TiebaStatic.log(new an("c10517").ag("obj_locate", 1).dh("fid", h.this.hGd.getForumId()));
                            } else {
                                h.this.nJ(true);
                                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    an anVar = new an("c10048");
                                    anVar.dh("fid", h.this.hGd.getForumId());
                                    anVar.dh("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(anVar);
                                }
                            }
                        }
                    } else if (id == R.id.tv_sign) {
                        if (!h.this.hGd.bVt()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.hGd.showToast(R.string.neterror);
                            } else if (bc.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                if (!h.this.cbY()) {
                                    h.this.cbN();
                                    an.wr("c13560").ag("obj_type", 2).aUS();
                                } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(h.this.hGd.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(h.this.hGd.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                                }
                            }
                        }
                    } else if (id == R.id.frs_header_games) {
                        if (bc.checkUpIsLogin(h.this.mContext.getPageActivity()) && bVs != null && bVs.getGameUrl() != null) {
                            ba.aUZ().a((TbPageContext) h.this.getPageContext(), new String[]{bVs.getGameUrl()}, true);
                        }
                    } else if (id == R.id.frs_bawu_center) {
                        if (bVs != null && bVs.getUserData() != null && bVs.getUserData().isBawu()) {
                            String bawuCenterUrl = bVs.getBawuCenterUrl();
                            if (!aq.isEmpty(bawuCenterUrl)) {
                                com.baidu.tbadk.browser.a.startWebActivity(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (bVs.getForum() != null) {
                                    TiebaStatic.log(new an("c10502").dh("fid", bVs.getForum().getId()).dh("uid", bVs.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id == R.id.level_container) {
                        if (!h.this.hGd.bVt() && h.this.mScrollState == 0 && h.this.cbU() && h.this.hLX != null) {
                            h.this.hLX.l(view, false);
                        }
                    } else if (id == R.id.frs_hot_rank_entry) {
                        if (bVs != null && bVs.getForum() != null && !TextUtils.isEmpty(bVs.getForum().getId())) {
                            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(h.this.getPageContext().getPageActivity());
                            hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(bVs.getForum().getId(), 0L)));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                            an anVar2 = new an("c13666");
                            anVar2.dh("fid", bVs.getForum().getId());
                            TiebaStatic.log(anVar2);
                        }
                    } else if (id == R.id.frs_manager_info_layout) {
                        if (bVs != null && bVs.getForum() != null && !TextUtils.isEmpty(bVs.getForum().getId())) {
                            if (bVs.getForum().isLike() == 0) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), bVs.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumMemberActivityConfig(h.this.getPageContext().getPageActivity(), String.valueOf(bVs.getForum().getId()), bVs.getForum().getName())));
                            }
                        }
                    } else if (id == R.id.frs_manager_application_layout && bVs != null && bVs.getForum() != null && !TextUtils.isEmpty(bVs.getForum().getId())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), bVs.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    }
                }
            }
        };
        this.hGd = frsFragment;
        this.hLY = aVar;
        this.hpL = frsHeaderViewContainer;
        this.hLR = BdUniqueId.gen();
        this.hMf = new g(this.hGd, this.hLR);
        this.hMg = new f(this.hGd);
        this.hMd = new com.baidu.tieba.f.a();
    }

    public void ap(Bundle bundle) {
        if (this.hMf != null) {
            this.hMf.registerListener();
        }
        if (this.hMg != null) {
            this.hMg.atc();
        }
        this.hMb = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void bZP() {
        if (this.hLX != null) {
            this.hLX.onDestory();
        }
        if (this.hMg != null) {
            this.hMg.bZP();
        }
        if (this.hMh != null) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.hMh);
        }
    }

    public void aVZ() {
        if (this.hLX != null) {
            this.hLX.onStop();
        }
        if (this.hpL != null) {
            this.hpL.removeCallbacks(this.fhR);
        }
    }

    public void bB(boolean z) {
        if (this.hLX != null) {
            this.hLX.bB(z);
        }
    }

    public boolean vs(int i) {
        this.mSkinType = i;
        if (this.hLX != null) {
            this.hLX.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void nL(boolean z) {
        if (z) {
            if (this.hLX != null) {
                this.hpL.removeHeaderView(this.hLX.ccX());
                this.hLZ = false;
            }
        } else if (this.hLX != null && this.hLX.ccX() != null && !this.hLZ) {
            this.hpL.addHeaderView(this.hLX.ccX(), this.hpL.getHeaderViewsCount());
            this.hLZ = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            w(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean cbO() {
        return true;
    }

    private void w(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.hMa, str);
        this.hMc = i2;
        this.hMa = str;
        cbR();
        if (this.hLX == null || z) {
            this.hLX = this.hLY.a(str, this.hGd, i);
            this.hLX.changeSkinType(this.mSkinType);
            this.hLX.y(this.hpu);
        }
        if (this.hMf != null) {
            this.hLX.f(this.hMf);
        }
        if (this.hMg != null) {
            this.hLX.g(this.hMg);
        }
        this.hpL.addHeaderView(this.hLX.getView());
        Fk(str);
        cbP();
    }

    private void cbP() {
        com.baidu.adp.lib.f.e.ld().postDelayed(this.hMh, 4000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYi() {
        if (cbU() && this.hLX != null) {
            this.hLX.bYi();
        }
    }

    public void cbQ() {
        if (!this.hLZ && this.hLX != null) {
            this.hpL.addHeaderView(this.hLX.ccX());
            this.hLZ = true;
        }
    }

    private void cbR() {
        if (this.hLX != null) {
            this.hpL.removeHeaderView(this.hLX.getView());
            this.hpL.removeHeaderView(this.hLX.ccX());
            cbS();
        }
        this.hLZ = false;
    }

    private void cbS() {
        if (this.hMe != null && this.hGd != null && this.hGd.aWN() != null) {
            this.hGd.aWN().removeHeaderView(this.hMe.cch());
        }
    }

    private void Fk(String str) {
        RelativeLayout cch;
        if (this.hMe != null && this.hGd != null && this.hGd.aWN() != null && (cch = this.hMe.cch()) != null) {
            if ("brand_page".equals(str)) {
                this.hGd.aWN().removeHeaderView(cch);
                return;
            }
            this.hGd.aWN().removeHeaderView(cch);
            this.hGd.aWN().addHeaderView(cch, 0);
        }
    }

    public void i(FrsViewData frsViewData) {
        if (frsViewData != null && cbU()) {
            b(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.hMa)) {
                this.hLX.bXV();
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float c = c(forumData);
            if (this.hLX != null) {
                this.hLX.a(forumData, frsViewData);
                this.hLX.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), c, false);
                this.hLX.a(forumData.getSignData());
            }
        }
    }

    private float c(ForumData forumData) {
        if (forumData == null || this.hMf == null) {
            return 0.0f;
        }
        return this.hMf.c(forumData);
    }

    public void vt(int i) {
        if (i > 1) {
            if (this.hLX != null) {
                this.hLX.nT(false);
            }
        } else if (this.hLX != null) {
            this.hLX.nT(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void cbT() {
        if (this.hpL != null) {
            this.hpL.removeCallbacks(this.fhR);
            this.hpL.postDelayed(this.fhR, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cbU() {
        return "frs_page".equals(this.hMa) || "normal_page".equals(this.hMa) || "book_page".equals(this.hMa) || "brand_page".equals(this.hMa);
    }

    public void l(Integer num) {
        setIsMem(num.intValue());
        if (cbU()) {
            cbV();
        }
    }

    public void setIsMem(int i) {
        if (this.hLX != null) {
            this.hLX.setMemberType(i);
        }
    }

    public void cbV() {
        if (this.hLX != null) {
            this.hLX.bYk();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && cbU()) {
            a(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void cbW() {
        if (cbU()) {
            vv(0);
        }
    }

    public void vu(int i) {
        if (cbU()) {
            vv(i);
        }
    }

    public void vv(int i) {
        if (this.hLX != null) {
            this.hLX.vQ(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.hLX != null) {
            this.hLX.a(forumData, frsViewData);
            if (forumData != null) {
                this.hLX.a(i, forumData.getLevelName(), forumData.getUser_level(), c(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.hLX.nK(false);
                }
            }
        }
    }

    public boolean cbX() {
        if (!cbU() || this.hLX == null) {
            return false;
        }
        return this.hLX.ccV();
    }

    public void cbN() {
        if (this.hMf != null) {
            this.hMf.cbN();
        }
    }

    public void O(int i, int i2, int i3) {
        if (this.hMf != null) {
            this.hMf.O(i, i2, i3);
        }
    }

    public void vw(int i) {
        if (cbU() && this.hLX != null) {
            this.hLX.vR(i);
        }
    }

    public void j(FrsViewData frsViewData) {
        if (cbU() && this.hMf != null) {
            this.hMf.a(this.hLX, frsViewData);
        }
    }

    public boolean cbY() {
        if (!cbU() || this.hLX == null) {
            return false;
        }
        return this.hLX.cbY();
    }

    public boolean cbZ() {
        if (!cbU() || this.hLX == null) {
            return false;
        }
        return this.hLX.cbZ();
    }

    public void nJ(boolean z) {
        if (this.hMg != null) {
            this.hMg.nJ(z);
        }
    }

    public void cbJ() {
        if (this.hMg != null) {
            this.hMg.cbJ();
        }
    }

    public void Fl(String str) {
        if (this.hGd.bUM() != null && this.hGd.bUM().cal() != null) {
            com.baidu.tieba.tbadkCore.e.dcu().aT(com.baidu.tieba.tbadkCore.e.dcu().e("1~" + str, this.hGd.bUM().cal().getSortType(), this.hGd.bUM().cal().getIsGood(), this.hGd.bUM().cal().getCategoryId()), false);
        }
    }

    public void bYf() {
        if (this.hLX != null) {
            this.hLX.bYf();
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
            return ((frsViewData.getStar() == null || frsViewData.getStar().dcH() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || v.isEmpty(frsViewData.getActivityHeadData().aOG())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().aOP(), true)))) ? false : true;
        }
        return false;
    }

    public void vx(int i) {
        View findViewById;
        if (this.hLX != null && this.hLX.ccX() != null && (findViewById = this.hLX.ccX().findViewById(R.id.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.hMd != null) {
            this.hMd.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.hMe = frsTabViewController;
    }
}
