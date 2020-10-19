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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.q;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class h extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Runnable fZz;
    private FrsFragment iKB;
    private boolean iQA;
    private int iQB;
    private com.baidu.tieba.f.a iQC;
    private FrsTabViewController iQD;
    private g iQE;
    private f iQF;
    private final Runnable iQG;
    private BdUniqueId iQq;
    private com.baidu.tieba.frs.view.b iQw;
    private com.baidu.tieba.frs.entelechy.b.a iQx;
    private boolean iQy;
    private String iQz;
    private final View.OnClickListener irI;
    private FrsHeaderViewContainer irZ;
    private int mScrollState;
    private int mSkinType;

    public h(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.iQy = false;
        this.mSkinType = 0;
        this.iQz = "normal_page";
        this.mScrollState = 0;
        this.iQA = false;
        this.iQG = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.1
            @Override // java.lang.Runnable
            public void run() {
                q csD;
                if (h.this.iKB != null && h.this.mScrollState == 0 && (csD = h.this.iKB.csD()) != null && csD.ctI() != null && !csD.ctI().czX() && !csD.cti() && h.this.irZ.isShown() && h.this.iKB.isPrimary() && !h.this.iQA && h.this.iKB.ctp() && h.this.iQB == 1 && h.this.cAn() && h.this.iQw != null && h.this.iQw.cBs()) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                    h.this.cwn();
                    h.this.iKB.ioJ = true;
                    h.this.iQA = true;
                }
            }
        };
        this.fZz = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.irZ != null) {
                    int childCount = h.this.irZ.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(h.this.irZ.getChildAt(i));
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
        this.irI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.iKB != null) {
                    FrsViewData cth = h.this.iKB.cth();
                    if (cth != null && cth.getForum() != null && h.this.iQw != null && (view == h.this.iQw.cBu() || view == h.this.iQw.cBv() || view == h.this.iQw.cBw())) {
                        if (h.this.iKB != null && cth.getForum() != null) {
                            TiebaStatic.log(new aq("c12046").dK("fid", cth.getForum().getId()).aj("obj_locate", h.this.iKB.ctk() ? 1 : 2));
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        if (cth.getEntelechyTabInfo() != null && cth.getEntelechyTabInfo().tab != null) {
                            for (int i = 0; i < cth.getEntelechyTabInfo().tab.size(); i++) {
                                arrayList.add(cth.getEntelechyTabInfo().tab.get(i).tab_name);
                            }
                        }
                        ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), cth.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                        forumDetailActivityConfig.setForumTabs(arrayList);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumDetailActivityConfig));
                    }
                    int id = view.getId();
                    if (id == R.id.tv_love) {
                        if (!h.this.iKB.cti()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.iKB.showToast(R.string.neterror);
                            } else if (!bg.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                TiebaStatic.log(new aq("c10517").aj("obj_locate", 1).dK("fid", h.this.iKB.getForumId()));
                            } else {
                                h.this.pR(true);
                                if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    aq aqVar = new aq("c10048");
                                    aqVar.dK("fid", h.this.iKB.getForumId());
                                    aqVar.dK("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(aqVar);
                                }
                            }
                        }
                    } else if (id == R.id.tv_sign) {
                        if (!h.this.iKB.cti()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.iKB.showToast(R.string.neterror);
                            } else if (bg.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                if (!h.this.cAr()) {
                                    h.this.cAg();
                                    aq.Bm("c13560").aj("obj_type", 2).bmR();
                                } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(h.this.iKB.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(h.this.iKB.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                                }
                            }
                        }
                    } else if (id == R.id.frs_header_games) {
                        if (bg.checkUpIsLogin(h.this.mContext.getPageActivity()) && cth != null && cth.getGameUrl() != null) {
                            be.bmY().a((TbPageContext) h.this.getPageContext(), new String[]{cth.getGameUrl()}, true);
                        }
                    } else if (id == R.id.frs_bawu_center) {
                        if (cth != null && cth.getUserData() != null && cth.getUserData().isBawu()) {
                            String bawuCenterUrl = cth.getBawuCenterUrl();
                            if (!at.isEmpty(bawuCenterUrl)) {
                                com.baidu.tbadk.browser.a.startWebActivity(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (cth.getForum() != null) {
                                    TiebaStatic.log(new aq("c10502").dK("fid", cth.getForum().getId()).dK("uid", cth.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id == R.id.level_container) {
                        if (!h.this.iKB.cti() && h.this.mScrollState == 0 && h.this.cAn() && h.this.iQw != null) {
                            h.this.iQw.k(view, false);
                        }
                    } else if (id == R.id.frs_hot_rank_entry) {
                        if (cth != null && cth.getForum() != null && !TextUtils.isEmpty(cth.getForum().getId())) {
                            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(h.this.getPageContext().getPageActivity());
                            hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(cth.getForum().getId(), 0L)));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                            aq aqVar2 = new aq("c13666");
                            aqVar2.dK("fid", cth.getForum().getId());
                            TiebaStatic.log(aqVar2);
                        }
                    } else if (id == R.id.frs_manager_info_layout) {
                        if (cth != null && cth.getForum() != null && !TextUtils.isEmpty(cth.getForum().getId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumMemberActivityConfig(h.this.getPageContext().getPageActivity(), String.valueOf(cth.getForum().getId()), cth.getForum().getName())));
                        }
                    } else if (id == R.id.frs_manager_application_layout && bg.checkUpIsLogin(h.this.mContext.getPageActivity()) && cth != null && cth.getForum() != null && !TextUtils.isEmpty(cth.getForum().getId())) {
                        be.bmY().b(h.this.iKB.getTbPageContext(), new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + cth.getForum().getId()});
                    }
                }
            }
        };
        this.iKB = frsFragment;
        this.iQx = aVar;
        this.irZ = frsHeaderViewContainer;
        this.iQq = BdUniqueId.gen();
        this.iQE = new g(this.iKB, this.iQq);
        this.iQF = new f(this.iKB);
        this.iQC = new com.baidu.tieba.f.a();
    }

    public void aq(Bundle bundle) {
        if (this.iQE != null) {
            this.iQE.registerListener();
        }
        if (this.iQF != null) {
            this.iQF.aHN();
        }
        this.iQA = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void cyd() {
        if (this.iQw != null) {
            this.iQw.onDestory();
        }
        if (this.iQF != null) {
            this.iQF.cyd();
        }
        if (this.iQG != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iQG);
        }
    }

    public void bnV() {
        if (this.iQw != null) {
            this.iQw.onStop();
        }
        if (this.irZ != null) {
            this.irZ.removeCallbacks(this.fZz);
        }
    }

    public void bO(boolean z) {
        if (this.iQw != null) {
            this.iQw.bO(z);
        }
    }

    public boolean zP(int i) {
        this.mSkinType = i;
        if (this.iQw != null) {
            this.iQw.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void pT(boolean z) {
        if (z) {
            if (this.iQw != null) {
                this.irZ.removeHeaderView(this.iQw.cBt());
                this.iQy = false;
            }
        } else if (this.iQw != null && this.iQw.cBt() != null && !this.iQy) {
            this.irZ.addHeaderView(this.iQw.cBt(), this.irZ.getHeaderViewsCount());
            this.iQy = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            w(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean cAh() {
        return true;
    }

    private void w(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.iQz, str);
        this.iQB = i2;
        this.iQz = str;
        cAk();
        if (this.iQw == null || z) {
            this.iQw = this.iQx.a(str, this.iKB, i);
            this.iQw.changeSkinType(this.mSkinType);
            this.iQw.A(this.irI);
        }
        if (this.iQE != null) {
            this.iQw.f(this.iQE);
        }
        if (this.iQF != null) {
            this.iQw.g(this.iQF);
        }
        this.irZ.addHeaderView(this.iQw.getView());
        Kl(str);
        cAi();
    }

    private void cAi() {
        com.baidu.adp.lib.f.e.mY().postDelayed(this.iQG, 4000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwn() {
        if (cAn() && this.iQw != null) {
            this.iQw.cwn();
        }
    }

    public void cAj() {
        if (!this.iQy && this.iQw != null) {
            this.irZ.addHeaderView(this.iQw.cBt());
            this.iQy = true;
        }
    }

    private void cAk() {
        if (this.iQw != null) {
            this.irZ.removeHeaderView(this.iQw.getView());
            this.irZ.removeHeaderView(this.iQw.cBt());
            cAl();
        }
        this.iQy = false;
    }

    private void cAl() {
        if (this.iQD != null && this.iKB != null && this.iKB.boH() != null) {
            this.iKB.boH().removeHeaderView(this.iQD.cAC());
        }
    }

    private void Kl(String str) {
        RelativeLayout cAC;
        if (this.iQD != null && this.iKB != null && this.iKB.boH() != null && (cAC = this.iQD.cAC()) != null) {
            if ("brand_page".equals(str)) {
                this.iKB.boH().removeHeaderView(cAC);
                return;
            }
            this.iKB.boH().removeHeaderView(cAC);
            this.iKB.boH().addHeaderView(cAC, 0);
        }
    }

    public void i(FrsViewData frsViewData) {
        if (frsViewData != null && cAn()) {
            b(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.iQz)) {
                this.iQw.cwa();
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float f = f(forumData);
            if (this.iQw != null) {
                this.iQw.a(forumData, frsViewData);
                this.iQw.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), f, false);
                this.iQw.a(forumData.getSignData());
            }
        }
    }

    public void j(FrsViewData frsViewData) {
        if (frsViewData != null && this.iQw != null && cAn()) {
            this.iQw.av(f(frsViewData.getForum()));
        }
    }

    private float f(ForumData forumData) {
        if (forumData == null || this.iQE == null) {
            return 0.0f;
        }
        return this.iQE.f(forumData);
    }

    public void zQ(int i) {
        if (i > 1) {
            if (this.iQw != null) {
                this.iQw.qb(false);
            }
        } else if (this.iQw != null) {
            this.iQw.qb(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void cAm() {
        if (this.irZ != null) {
            this.irZ.removeCallbacks(this.fZz);
            this.irZ.postDelayed(this.fZz, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cAn() {
        return "frs_page".equals(this.iQz) || "normal_page".equals(this.iQz) || "book_page".equals(this.iQz) || "brand_page".equals(this.iQz);
    }

    public void o(Integer num) {
        setIsMem(num.intValue());
        if (cAn()) {
            cAo();
        }
    }

    public void setIsMem(int i) {
        if (this.iQw != null) {
            this.iQw.setMemberType(i);
        }
    }

    public void cAo() {
        if (this.iQw != null) {
            this.iQw.cwp();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && cAn()) {
            a(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void cAp() {
        if (cAn()) {
            zS(0);
        }
    }

    public void zR(int i) {
        if (cAn()) {
            zS(i);
        }
    }

    public void zS(int i) {
        if (this.iQw != null) {
            this.iQw.Ao(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.iQw != null) {
            this.iQw.a(forumData, frsViewData);
            if (forumData != null) {
                this.iQw.a(i, forumData.getLevelName(), forumData.getUser_level(), f(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.iQw.pS(false);
                }
            }
        }
    }

    public boolean cAq() {
        if (!cAn() || this.iQw == null) {
            return false;
        }
        return this.iQw.cBr();
    }

    public void cAg() {
        if (this.iQE != null) {
            this.iQE.cAg();
        }
    }

    public void O(int i, int i2, int i3) {
        if (this.iQE != null) {
            this.iQE.O(i, i2, i3);
        }
    }

    public void zT(int i) {
        if (cAn() && this.iQw != null) {
            this.iQw.Ap(i);
        }
    }

    public void k(FrsViewData frsViewData) {
        if (cAn() && this.iQE != null) {
            this.iQE.a(this.iQw, frsViewData);
        }
    }

    public boolean cAr() {
        if (!cAn() || this.iQw == null) {
            return false;
        }
        return this.iQw.cAr();
    }

    public boolean cAs() {
        if (!cAn() || this.iQw == null) {
            return false;
        }
        return this.iQw.cAs();
    }

    public void pR(boolean z) {
        if (this.iQF != null) {
            this.iQF.pR(z);
        }
    }

    public void cAc() {
        if (this.iQF != null) {
            this.iQF.cAc();
        }
    }

    public void Km(String str) {
        if (this.iKB.csy() != null && this.iKB.csy().cyz() != null) {
            com.baidu.tieba.tbadkCore.e.dDo().ba(com.baidu.tieba.tbadkCore.e.dDo().f("1~" + str, this.iKB.csy().cyz().getSortType(), this.iKB.csy().cyz().getIsGood(), this.iKB.csy().cyz().getCategoryId()), false);
        }
    }

    public void cwk() {
        if (this.iQw != null) {
            this.iQw.cwk();
        }
    }

    public static boolean l(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().bgn(), true) || frsViewData.getBookInfo().bgn().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean m(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().dDB() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || y.isEmpty(frsViewData.getActivityHeadData().bgl())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().bgd(), true)))) ? false : true;
        }
        return false;
    }

    public void zU(int i) {
        View findViewById;
        if (this.iQw != null && this.iQw.cBt() != null && (findViewById = this.iQw.cBt().findViewById(R.id.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.iQC != null) {
            this.iQC.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.iQD = frsTabViewController;
    }

    public f cAt() {
        return this.iQF;
    }
}
