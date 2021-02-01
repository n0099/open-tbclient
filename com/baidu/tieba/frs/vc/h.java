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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.q;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class h extends com.baidu.adp.base.d<BaseFragmentActivity> {
    private FrsFragment jEH;
    private com.baidu.tieba.frs.view.b jKA;
    private com.baidu.tieba.frs.entelechy.a.a jKB;
    private boolean jKC;
    private String jKD;
    private boolean jKE;
    private int jKF;
    private com.baidu.tieba.f.a jKG;
    private FrsTabViewController jKH;
    private g jKI;
    private f jKJ;
    private final Runnable jKK;
    private final Runnable jKL;
    private BdUniqueId jKs;
    private final View.OnClickListener jiV;
    private FrsHeaderViewContainer jjm;
    private Runnable mRefreshRunnable;
    private int mScrollState;
    private int mSkinType;

    public h(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.a.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.jKC = false;
        this.mSkinType = 0;
        this.jKD = "normal_page";
        this.mScrollState = 0;
        this.jKE = false;
        this.jKK = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.1
            @Override // java.lang.Runnable
            public void run() {
                q cCu;
                if (h.this.jEH != null && h.this.mScrollState == 0 && (cCu = h.this.jEH.cCu()) != null && cCu.cDA() != null && !cCu.cDA().cKW() && !cCu.cDa() && h.this.jjm.isShown() && h.this.jEH.isPrimary() && !h.this.jKE && h.this.jEH.cDh() && h.this.jKF == 1 && h.this.cLn() && h.this.jKA != null && h.this.jKA.cMW()) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                    h.this.cGj();
                    h.this.jEH.jfU = true;
                    h.this.jKE = true;
                }
            }
        };
        this.jKL = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.jEH != null && h.this.mScrollState == 0 && !h.this.jEH.cCu().cDa() && h.this.jjm.isShown() && h.this.jEH.isPrimary()) {
                    h.this.cGk();
                }
            }
        };
        this.mRefreshRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.jjm != null) {
                    int childCount = h.this.jjm.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(h.this.jjm.getChildAt(i));
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
        this.jiV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.jEH != null) {
                    FrsViewData cCZ = h.this.jEH.cCZ();
                    if (cCZ != null && cCZ.getForum() != null && h.this.jKA != null && (view == h.this.jKA.cMY() || view == h.this.jKA.cMZ() || view == h.this.jKA.cNa())) {
                        if (h.this.jEH != null && cCZ.getForum() != null) {
                            TiebaStatic.log(new ar("c12046").dR("fid", cCZ.getForum().getId()).ap("obj_locate", h.this.jEH.cDc() ? 1 : 2));
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        if (cCZ.getEntelechyTabInfo() != null && cCZ.getEntelechyTabInfo().tab != null) {
                            for (int i = 0; i < cCZ.getEntelechyTabInfo().tab.size(); i++) {
                                arrayList.add(cCZ.getEntelechyTabInfo().tab.get(i).tab_name);
                            }
                        }
                        ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), cCZ.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                        forumDetailActivityConfig.setForumTabs(arrayList);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumDetailActivityConfig));
                    }
                    int id = view.getId();
                    if (id == R.id.tv_love) {
                        if (!h.this.jEH.cDa()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.jEH.showToast(R.string.neterror);
                            } else if (!bh.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                TiebaStatic.log(new ar("c10517").ap("obj_locate", 1).dR("fid", h.this.jEH.getForumId()));
                            } else {
                                h.this.rA(true);
                                if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    ar arVar = new ar("c10048");
                                    arVar.dR("fid", h.this.jEH.getForumId());
                                    arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(arVar);
                                }
                            }
                        }
                    } else if (id == R.id.tv_sign) {
                        if (!h.this.jEH.cDa()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.jEH.showToast(R.string.neterror);
                            } else if (bh.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                if (!h.this.cLs()) {
                                    h.this.cLr();
                                    ar.Bd("c13560").ap("obj_type", 2).bsO();
                                } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(h.this.jEH.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(h.this.jEH.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                                }
                            }
                        }
                    } else if (id == R.id.frs_header_games) {
                        if (bh.checkUpIsLogin(h.this.mContext.getPageActivity()) && cCZ != null && cCZ.getGameUrl() != null) {
                            bf.bsV().a((TbPageContext) h.this.getPageContext(), new String[]{cCZ.getGameUrl()}, true);
                        }
                    } else if (id == R.id.frs_bawu_center) {
                        if (cCZ != null && cCZ.getUserData() != null && cCZ.getUserData().isBawu()) {
                            String bawuCenterUrl = cCZ.getBawuCenterUrl();
                            if (!au.isEmpty(bawuCenterUrl)) {
                                com.baidu.tbadk.browser.a.startWebActivity(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (cCZ.getForum() != null) {
                                    TiebaStatic.log(new ar("c10502").dR("fid", cCZ.getForum().getId()).dR("uid", cCZ.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id == R.id.level_container) {
                        if (!h.this.jEH.cDa() && h.this.mScrollState == 0 && h.this.cLn() && h.this.jKA != null) {
                            h.this.jKA.l(view, false);
                        }
                    } else if (id == R.id.frs_hot_rank_entry) {
                        if (cCZ != null && cCZ.getForum() != null && !TextUtils.isEmpty(cCZ.getForum().getId())) {
                            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(h.this.getPageContext().getPageActivity());
                            hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(cCZ.getForum().getId(), 0L)));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                            ar arVar2 = new ar("c13666");
                            arVar2.dR("fid", cCZ.getForum().getId());
                            TiebaStatic.log(arVar2);
                        }
                    } else if (id == R.id.frs_manager_info_layout) {
                        if (cCZ != null && cCZ.getForum() != null && !TextUtils.isEmpty(cCZ.getForum().getId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumMemberActivityConfig(h.this.getPageContext().getPageActivity(), String.valueOf(cCZ.getForum().getId()), cCZ.getForum().getName())));
                        }
                    } else if (id == R.id.frs_manager_application_layout && bh.checkUpIsLogin(h.this.mContext.getPageActivity()) && cCZ != null && cCZ.getForum() != null && !TextUtils.isEmpty(cCZ.getForum().getId())) {
                        bf.bsV().b(h.this.jEH.getTbPageContext(), new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + cCZ.getForum().getId()});
                    }
                }
            }
        };
        this.jEH = frsFragment;
        this.jKB = aVar;
        this.jjm = frsHeaderViewContainer;
        this.jKs = BdUniqueId.gen();
        this.jKI = new g(this.jEH, this.jKs);
        this.jKJ = new f(this.jEH);
        this.jKG = new com.baidu.tieba.f.a();
    }

    public void as(Bundle bundle) {
        if (this.jKI != null) {
            this.jKI.registerListener();
        }
        if (this.jKJ != null) {
            this.jKJ.aNx();
        }
        this.jKE = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void cIZ() {
        if (this.jKA != null) {
            this.jKA.onDestory();
        }
        if (this.jKJ != null) {
            this.jKJ.cIZ();
        }
        if (this.jKK != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jKK);
        }
        if (this.jKL != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jKL);
        }
    }

    public void btX() {
        if (this.jKA != null) {
            this.jKA.onStop();
        }
        if (this.jjm != null) {
            this.jjm.removeCallbacks(this.mRefreshRunnable);
        }
    }

    public void cb(boolean z) {
        if (this.jKA != null) {
            this.jKA.cb(z);
        }
    }

    public boolean Ax(int i) {
        this.mSkinType = i;
        if (this.jKA != null) {
            this.jKA.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void rD(boolean z) {
        if (z) {
            if (this.jKA != null) {
                this.jjm.removeHeaderView(this.jKA.cMX());
                this.jKC = false;
            }
        } else if (this.jKA != null && this.jKA.cMX() != null && !this.jKC) {
            this.jjm.addHeaderView(this.jKA.cMX(), this.jjm.getHeaderViewsCount());
            this.jKC = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            y(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean cLf() {
        return true;
    }

    private void y(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.jKD, str);
        this.jKF = i2;
        this.jKD = str;
        cLk();
        if (this.jKA == null || z) {
            this.jKA = this.jKB.a(str, this.jEH, i);
            this.jKA.changeSkinType(this.mSkinType);
            this.jKA.C(this.jiV);
        }
        if (this.jKI != null) {
            this.jKA.i(this.jKI);
        }
        if (this.jKJ != null) {
            this.jKA.g(this.jKJ);
        }
        this.jjm.addHeaderView(this.jKA.getView());
        Lj(str);
        cLg();
        cLh();
    }

    private void cLg() {
        com.baidu.adp.lib.f.e.mA().postDelayed(this.jKK, 4000L);
    }

    public void cLh() {
        com.baidu.adp.lib.f.e.mA().postDelayed(this.jKL, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGj() {
        if (cLn() && this.jKA != null) {
            this.jKA.cGj();
        }
    }

    public void cGk() {
        if (this.jKA != null) {
            this.jKA.cGk();
        }
    }

    public void cLi() {
        if (this.jKA != null) {
            this.jKA.cGl();
        }
    }

    public void cLj() {
        if (!this.jKC && this.jKA != null) {
            this.jjm.addHeaderView(this.jKA.cMX());
            this.jKC = true;
        }
    }

    private void cLk() {
        if (this.jKA != null) {
            this.jjm.removeHeaderView(this.jKA.getView());
            this.jjm.removeHeaderView(this.jKA.cMX());
            cLl();
        }
        this.jKC = false;
    }

    private void cLl() {
        if (this.jKH != null && this.jEH != null && this.jEH.getListView() != null) {
            this.jEH.getListView().removeHeaderView(this.jKH.cLF());
        }
    }

    private void Lj(String str) {
        RelativeLayout cLF;
        if (this.jKH != null && this.jEH != null && this.jEH.getListView() != null && (cLF = this.jKH.cLF()) != null) {
            if ("brand_page".equals(str)) {
                this.jEH.getListView().removeHeaderView(cLF);
                return;
            }
            this.jEH.getListView().removeHeaderView(cLF);
            this.jEH.getListView().addHeaderView(cLF, 0);
        }
    }

    public void j(FrsViewData frsViewData) {
        if (frsViewData != null && cLn()) {
            b(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.jKD)) {
                this.jKA.cFU();
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float f = f(forumData);
            if (this.jKA != null) {
                this.jKA.a(forumData, frsViewData);
                this.jKA.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), f, false);
                this.jKA.a(forumData.getSignData());
            }
        }
    }

    public void k(FrsViewData frsViewData) {
        if (frsViewData != null && this.jKA != null && cLn()) {
            this.jKA.aM(f(frsViewData.getForum()));
        }
    }

    private float f(ForumData forumData) {
        if (forumData == null || this.jKI == null) {
            return 0.0f;
        }
        return this.jKI.f(forumData);
    }

    public void Ay(int i) {
        if (i > 1) {
            if (this.jKA != null) {
                this.jKA.rL(false);
            }
        } else if (this.jKA != null) {
            this.jKA.rL(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void cLm() {
        if (this.jjm != null) {
            this.jjm.removeCallbacks(this.mRefreshRunnable);
            this.jjm.postDelayed(this.mRefreshRunnable, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cLn() {
        return "frs_page".equals(this.jKD) || "normal_page".equals(this.jKD) || "book_page".equals(this.jKD) || "brand_page".equals(this.jKD);
    }

    public void q(Integer num) {
        setIsMem(num.intValue());
        if (cLn()) {
            cLo();
        }
    }

    public void setIsMem(int i) {
        if (this.jKA != null) {
            this.jKA.setMemberType(i);
        }
    }

    public void cLo() {
        if (this.jKA != null) {
            this.jKA.cGo();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && cLn()) {
            a(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void cLp() {
        if (cLn()) {
            AA(0);
        }
    }

    public void Az(int i) {
        if (cLn()) {
            AA(i);
        }
    }

    public void AA(int i) {
        if (this.jKA != null) {
            this.jKA.Bc(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.jKA != null) {
            this.jKA.a(forumData, frsViewData);
            if (forumData != null) {
                this.jKA.a(i, forumData.getLevelName(), forumData.getUser_level(), f(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.jKA.rC(false);
                }
            }
        }
    }

    public boolean cLq() {
        if (!cLn() || this.jKA == null) {
            return false;
        }
        return this.jKA.cMV();
    }

    public void cLr() {
        if (this.jKI != null) {
            if (this.jKA != null) {
                this.jKI.B(this.jKA.cGf(), this.jKA.getActivityId());
            } else {
                this.jKI.B(false, "");
            }
            if (this.jKA != null) {
                this.jKI.a(this.jKA.cGg());
            }
        }
    }

    public void T(int i, int i2, int i3) {
        if (this.jKI != null) {
            this.jKI.T(i, i2, i3);
        }
    }

    public void AB(int i) {
        if (cLn() && this.jKA != null) {
            this.jKA.Bd(i);
        }
    }

    public void l(FrsViewData frsViewData) {
        if (cLn() && this.jKI != null) {
            this.jKI.a(this.jKA, frsViewData);
        }
    }

    public boolean cLs() {
        if (!cLn() || this.jKA == null) {
            return false;
        }
        return this.jKA.cLs();
    }

    public boolean cLt() {
        if (!cLn() || this.jKA == null) {
            return false;
        }
        return this.jKA.cLt();
    }

    public void rA(boolean z) {
        if (this.jKJ != null) {
            this.jKJ.rA(z);
        }
    }

    public void cLa() {
        if (this.jKJ != null) {
            this.jKJ.cLa();
        }
    }

    public void Lk(String str) {
        if (this.jEH.cCp() != null && this.jEH.cCp().cJv() != null) {
            com.baidu.tieba.tbadkCore.e.dMs().bd(com.baidu.tieba.tbadkCore.e.dMs().f("1~" + str, this.jEH.cCp().cJv().getSortType(), this.jEH.cCp().cJv().getIsGood(), this.jEH.cCp().cJv().getCategoryId()), false);
        }
    }

    public void cGe() {
        if (this.jKA != null) {
            this.jKA.cGe();
        }
    }

    public static boolean m(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().blT(), true) || frsViewData.getBookInfo().blT().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean n(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().dMF() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || y.isEmpty(frsViewData.getActivityHeadData().blR())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().getImgUrl(), true)))) ? false : true;
        }
        return false;
    }

    public void AC(int i) {
        if (this.jKA != null && this.jKA.cMX() != null) {
            View findViewById = this.jKA.cMX().findViewById(R.id.divider_bottom);
            if (findViewById != null) {
                findViewById.setVisibility(i);
            }
            this.jKA.cGl();
        }
    }

    public void cGm() {
        this.jKA.cGm();
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.jKG != null) {
            this.jKG.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.jKH = frsTabViewController;
    }

    public f cLu() {
        return this.jKJ;
    }
}
