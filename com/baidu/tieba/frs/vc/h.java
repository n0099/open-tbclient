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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class h extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Runnable ftq;
    private FrsHeaderViewContainer hCE;
    private final View.OnClickListener hCn;
    private FrsFragment hUd;
    private BdUniqueId hZQ;
    private com.baidu.tieba.frs.view.b hZW;
    private com.baidu.tieba.frs.entelechy.b.a hZX;
    private boolean hZY;
    private String hZZ;
    private boolean iaa;
    private int iab;
    private com.baidu.tieba.f.a iac;
    private FrsTabViewController iad;
    private g iae;
    private f iaf;
    private final Runnable iag;
    private int mScrollState;
    private int mSkinType;

    public h(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.hZY = false;
        this.mSkinType = 0;
        this.hZZ = "normal_page";
        this.mScrollState = 0;
        this.iaa = false;
        this.iag = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.1
            @Override // java.lang.Runnable
            public void run() {
                p bXZ;
                if (h.this.hUd != null && h.this.mScrollState == 0 && (bXZ = h.this.hUd.bXZ()) != null && bXZ.bZc() != null && !bXZ.bZc().cfe() && !bXZ.bYC() && h.this.hCE.isShown() && h.this.hUd.isPrimary() && !h.this.iaa && h.this.hUd.bYJ() && h.this.iab == 1 && h.this.cfu() && h.this.hZW != null && h.this.hZW.cgx()) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                    h.this.cbz();
                    h.this.hUd.hzx = true;
                    h.this.iaa = true;
                }
            }
        };
        this.ftq = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.hCE != null) {
                    int childCount = h.this.hCE.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(h.this.hCE.getChildAt(i));
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
        this.hCn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.hUd != null) {
                    FrsViewData bYB = h.this.hUd.bYB();
                    if (bYB != null && bYB.getForum() != null && h.this.hZW != null && (view == h.this.hZW.cgz() || view == h.this.hZW.cgA() || view == h.this.hZW.cgB())) {
                        if (h.this.hUd != null && bYB.getForum() != null) {
                            TiebaStatic.log(new ao("c12046").dk("fid", bYB.getForum().getId()).ag("obj_locate", h.this.hUd.bYE() ? 1 : 2));
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        if (bYB.getEntelechyTabInfo() != null && bYB.getEntelechyTabInfo().tab != null) {
                            for (int i = 0; i < bYB.getEntelechyTabInfo().tab.size(); i++) {
                                arrayList.add(bYB.getEntelechyTabInfo().tab.get(i).tab_name);
                            }
                        }
                        ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), bYB.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                        forumDetailActivityConfig.setForumTabs(arrayList);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumDetailActivityConfig));
                    }
                    int id = view.getId();
                    if (id == R.id.tv_love) {
                        if (!h.this.hUd.bYC()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.hUd.showToast(R.string.neterror);
                            } else if (!be.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                TiebaStatic.log(new ao("c10517").ag("obj_locate", 1).dk("fid", h.this.hUd.getForumId()));
                            } else {
                                h.this.nV(true);
                                if (!ar.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    ao aoVar = new ao("c10048");
                                    aoVar.dk("fid", h.this.hUd.getForumId());
                                    aoVar.dk("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(aoVar);
                                }
                            }
                        }
                    } else if (id == R.id.tv_sign) {
                        if (!h.this.hUd.bYC()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.hUd.showToast(R.string.neterror);
                            } else if (be.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                if (!h.this.cfy()) {
                                    h.this.cfn();
                                    ao.wH("c13560").ag("obj_type", 2).aWN();
                                } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(h.this.hUd.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(h.this.hUd.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                                }
                            }
                        }
                    } else if (id == R.id.frs_header_games) {
                        if (be.checkUpIsLogin(h.this.mContext.getPageActivity()) && bYB != null && bYB.getGameUrl() != null) {
                            bc.aWU().a((TbPageContext) h.this.getPageContext(), new String[]{bYB.getGameUrl()}, true);
                        }
                    } else if (id == R.id.frs_bawu_center) {
                        if (bYB != null && bYB.getUserData() != null && bYB.getUserData().isBawu()) {
                            String bawuCenterUrl = bYB.getBawuCenterUrl();
                            if (!ar.isEmpty(bawuCenterUrl)) {
                                com.baidu.tbadk.browser.a.startWebActivity(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (bYB.getForum() != null) {
                                    TiebaStatic.log(new ao("c10502").dk("fid", bYB.getForum().getId()).dk("uid", bYB.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id == R.id.level_container) {
                        if (!h.this.hUd.bYC() && h.this.mScrollState == 0 && h.this.cfu() && h.this.hZW != null) {
                            h.this.hZW.l(view, false);
                        }
                    } else if (id == R.id.frs_hot_rank_entry) {
                        if (bYB != null && bYB.getForum() != null && !TextUtils.isEmpty(bYB.getForum().getId())) {
                            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(h.this.getPageContext().getPageActivity());
                            hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(bYB.getForum().getId(), 0L)));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                            ao aoVar2 = new ao("c13666");
                            aoVar2.dk("fid", bYB.getForum().getId());
                            TiebaStatic.log(aoVar2);
                        }
                    } else if (id == R.id.frs_manager_info_layout) {
                        if (bYB != null && bYB.getForum() != null && !TextUtils.isEmpty(bYB.getForum().getId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumMemberActivityConfig(h.this.getPageContext().getPageActivity(), String.valueOf(bYB.getForum().getId()), bYB.getForum().getName())));
                        }
                    } else if (id == R.id.frs_manager_application_layout && be.checkUpIsLogin(h.this.mContext.getPageActivity()) && bYB != null && bYB.getForum() != null && !TextUtils.isEmpty(bYB.getForum().getId())) {
                        bc.aWU().b(h.this.hUd.getTbPageContext(), new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + bYB.getForum().getId()});
                    }
                }
            }
        };
        this.hUd = frsFragment;
        this.hZX = aVar;
        this.hCE = frsHeaderViewContainer;
        this.hZQ = BdUniqueId.gen();
        this.iae = new g(this.hUd, this.hZQ);
        this.iaf = new f(this.hUd);
        this.iac = new com.baidu.tieba.f.a();
    }

    public void aq(Bundle bundle) {
        if (this.iae != null) {
            this.iae.registerListener();
        }
        if (this.iaf != null) {
            this.iaf.aui();
        }
        this.iaa = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void cdl() {
        if (this.hZW != null) {
            this.hZW.onDestory();
        }
        if (this.iaf != null) {
            this.iaf.cdl();
        }
        if (this.iag != null) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.iag);
        }
    }

    public void aXU() {
        if (this.hZW != null) {
            this.hZW.onStop();
        }
        if (this.hCE != null) {
            this.hCE.removeCallbacks(this.ftq);
        }
    }

    public void bB(boolean z) {
        if (this.hZW != null) {
            this.hZW.bB(z);
        }
    }

    public boolean vZ(int i) {
        this.mSkinType = i;
        if (this.hZW != null) {
            this.hZW.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void nX(boolean z) {
        if (z) {
            if (this.hZW != null) {
                this.hCE.removeHeaderView(this.hZW.cgy());
                this.hZY = false;
            }
        } else if (this.hZW != null && this.hZW.cgy() != null && !this.hZY) {
            this.hCE.addHeaderView(this.hZW.cgy(), this.hCE.getHeaderViewsCount());
            this.hZY = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            w(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean cfo() {
        return true;
    }

    private void w(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.hZZ, str);
        this.iab = i2;
        this.hZZ = str;
        cfr();
        if (this.hZW == null || z) {
            this.hZW = this.hZX.a(str, this.hUd, i);
            this.hZW.changeSkinType(this.mSkinType);
            this.hZW.z(this.hCn);
        }
        if (this.iae != null) {
            this.hZW.f(this.iae);
        }
        if (this.iaf != null) {
            this.hZW.g(this.iaf);
        }
        this.hCE.addHeaderView(this.hZW.getView());
        FL(str);
        cfp();
    }

    private void cfp() {
        com.baidu.adp.lib.f.e.lt().postDelayed(this.iag, 4000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbz() {
        if (cfu() && this.hZW != null) {
            this.hZW.cbz();
        }
    }

    public void cfq() {
        if (!this.hZY && this.hZW != null) {
            this.hCE.addHeaderView(this.hZW.cgy());
            this.hZY = true;
        }
    }

    private void cfr() {
        if (this.hZW != null) {
            this.hCE.removeHeaderView(this.hZW.getView());
            this.hCE.removeHeaderView(this.hZW.cgy());
            cfs();
        }
        this.hZY = false;
    }

    private void cfs() {
        if (this.iad != null && this.hUd != null && this.hUd.aYH() != null) {
            this.hUd.aYH().removeHeaderView(this.iad.cfH());
        }
    }

    private void FL(String str) {
        RelativeLayout cfH;
        if (this.iad != null && this.hUd != null && this.hUd.aYH() != null && (cfH = this.iad.cfH()) != null) {
            if ("brand_page".equals(str)) {
                this.hUd.aYH().removeHeaderView(cfH);
                return;
            }
            this.hUd.aYH().removeHeaderView(cfH);
            this.hUd.aYH().addHeaderView(cfH, 0);
        }
    }

    public void i(FrsViewData frsViewData) {
        if (frsViewData != null && cfu()) {
            b(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.hZZ)) {
                this.hZW.cbm();
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float c = c(forumData);
            if (this.hZW != null) {
                this.hZW.a(forumData, frsViewData);
                this.hZW.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), c, false);
                this.hZW.a(forumData.getSignData());
            }
        }
    }

    public void j(FrsViewData frsViewData) {
        if (frsViewData != null && this.hZW != null && cfu()) {
            this.hZW.aj(c(frsViewData.getForum()));
        }
    }

    private float c(ForumData forumData) {
        if (forumData == null || this.iae == null) {
            return 0.0f;
        }
        return this.iae.c(forumData);
    }

    public void wa(int i) {
        if (i > 1) {
            if (this.hZW != null) {
                this.hZW.of(false);
            }
        } else if (this.hZW != null) {
            this.hZW.of(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void cft() {
        if (this.hCE != null) {
            this.hCE.removeCallbacks(this.ftq);
            this.hCE.postDelayed(this.ftq, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cfu() {
        return "frs_page".equals(this.hZZ) || "normal_page".equals(this.hZZ) || "book_page".equals(this.hZZ) || "brand_page".equals(this.hZZ);
    }

    public void l(Integer num) {
        setIsMem(num.intValue());
        if (cfu()) {
            cfv();
        }
    }

    public void setIsMem(int i) {
        if (this.hZW != null) {
            this.hZW.setMemberType(i);
        }
    }

    public void cfv() {
        if (this.hZW != null) {
            this.hZW.cbB();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && cfu()) {
            a(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void cfw() {
        if (cfu()) {
            wc(0);
        }
    }

    public void wb(int i) {
        if (cfu()) {
            wc(i);
        }
    }

    public void wc(int i) {
        if (this.hZW != null) {
            this.hZW.wy(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.hZW != null) {
            this.hZW.a(forumData, frsViewData);
            if (forumData != null) {
                this.hZW.a(i, forumData.getLevelName(), forumData.getUser_level(), c(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.hZW.nW(false);
                }
            }
        }
    }

    public boolean cfx() {
        if (!cfu() || this.hZW == null) {
            return false;
        }
        return this.hZW.cgw();
    }

    public void cfn() {
        if (this.iae != null) {
            this.iae.cfn();
        }
    }

    public void O(int i, int i2, int i3) {
        if (this.iae != null) {
            this.iae.O(i, i2, i3);
        }
    }

    public void wd(int i) {
        if (cfu() && this.hZW != null) {
            this.hZW.wz(i);
        }
    }

    public void k(FrsViewData frsViewData) {
        if (cfu() && this.iae != null) {
            this.iae.a(this.hZW, frsViewData);
        }
    }

    public boolean cfy() {
        if (!cfu() || this.hZW == null) {
            return false;
        }
        return this.hZW.cfy();
    }

    public boolean cfz() {
        if (!cfu() || this.hZW == null) {
            return false;
        }
        return this.hZW.cfz();
    }

    public void nV(boolean z) {
        if (this.iaf != null) {
            this.iaf.nV(z);
        }
    }

    public void cfj() {
        if (this.iaf != null) {
            this.iaf.cfj();
        }
    }

    public void FM(String str) {
        if (this.hUd.bXU() != null && this.hUd.bXU().cdH() != null) {
            com.baidu.tieba.tbadkCore.e.dgY().aV(com.baidu.tieba.tbadkCore.e.dgY().e("1~" + str, this.hUd.bXU().cdH().getSortType(), this.hUd.bXU().cdH().getIsGood(), this.hUd.bXU().cdH().getCategoryId()), false);
        }
    }

    public void cbw() {
        if (this.hZW != null) {
            this.hZW.cbw();
        }
    }

    public static boolean l(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().aQv(), true) || frsViewData.getBookInfo().aQv().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean m(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().dhl() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || w.isEmpty(frsViewData.getActivityHeadData().aQt())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().aQl(), true)))) ? false : true;
        }
        return false;
    }

    public void we(int i) {
        View findViewById;
        if (this.hZW != null && this.hZW.cgy() != null && (findViewById = this.hZW.cgy().findViewById(R.id.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.iac != null) {
            this.iac.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.iad = frsTabViewController;
    }
}
