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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class h extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Runnable fyy;
    private FrsHeaderViewContainer hIC;
    private final View.OnClickListener hIl;
    private FrsFragment iac;
    private BdUniqueId ifS;
    private com.baidu.tieba.frs.view.b ifY;
    private com.baidu.tieba.frs.entelechy.b.a ifZ;
    private boolean iga;
    private String igb;
    private boolean igc;
    private int igd;
    private com.baidu.tieba.f.a ige;
    private FrsTabViewController igf;
    private g igg;
    private f igh;
    private final Runnable igi;
    private int mScrollState;
    private int mSkinType;

    public h(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.iga = false;
        this.mSkinType = 0;
        this.igb = "normal_page";
        this.mScrollState = 0;
        this.igc = false;
        this.igi = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.1
            @Override // java.lang.Runnable
            public void run() {
                p cbw;
                if (h.this.iac != null && h.this.mScrollState == 0 && (cbw = h.this.iac.cbw()) != null && cbw.ccA() != null && !cbw.ccA().ciE() && !cbw.cca() && h.this.hIC.isShown() && h.this.iac.isPrimary() && !h.this.igc && h.this.iac.cch() && h.this.igd == 1 && h.this.ciU() && h.this.ifY != null && h.this.ifY.cjX()) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                    h.this.ceY();
                    h.this.iac.hFm = true;
                    h.this.igc = true;
                }
            }
        };
        this.fyy = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.hIC != null) {
                    int childCount = h.this.hIC.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(h.this.hIC.getChildAt(i));
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
        this.hIl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.iac != null) {
                    FrsViewData cbZ = h.this.iac.cbZ();
                    if (cbZ != null && cbZ.getForum() != null && h.this.ifY != null && (view == h.this.ifY.cjZ() || view == h.this.ifY.cka() || view == h.this.ifY.ckb())) {
                        if (h.this.iac != null && cbZ.getForum() != null) {
                            TiebaStatic.log(new ap("c12046").dn("fid", cbZ.getForum().getId()).ah("obj_locate", h.this.iac.ccc() ? 1 : 2));
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        if (cbZ.getEntelechyTabInfo() != null && cbZ.getEntelechyTabInfo().tab != null) {
                            for (int i = 0; i < cbZ.getEntelechyTabInfo().tab.size(); i++) {
                                arrayList.add(cbZ.getEntelechyTabInfo().tab.get(i).tab_name);
                            }
                        }
                        ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), cbZ.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                        forumDetailActivityConfig.setForumTabs(arrayList);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumDetailActivityConfig));
                    }
                    int id = view.getId();
                    if (id == R.id.tv_love) {
                        if (!h.this.iac.cca()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.iac.showToast(R.string.neterror);
                            } else if (!bf.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                TiebaStatic.log(new ap("c10517").ah("obj_locate", 1).dn("fid", h.this.iac.getForumId()));
                            } else {
                                h.this.oA(true);
                                if (!as.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    ap apVar = new ap("c10048");
                                    apVar.dn("fid", h.this.iac.getForumId());
                                    apVar.dn("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(apVar);
                                }
                            }
                        }
                    } else if (id == R.id.tv_sign) {
                        if (!h.this.iac.cca()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.iac.showToast(R.string.neterror);
                            } else if (bf.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                if (!h.this.ciY()) {
                                    h.this.ciN();
                                    ap.xP("c13560").ah("obj_type", 2).baO();
                                } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(h.this.iac.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(h.this.iac.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                                }
                            }
                        }
                    } else if (id == R.id.frs_header_games) {
                        if (bf.checkUpIsLogin(h.this.mContext.getPageActivity()) && cbZ != null && cbZ.getGameUrl() != null) {
                            bd.baV().a((TbPageContext) h.this.getPageContext(), new String[]{cbZ.getGameUrl()}, true);
                        }
                    } else if (id == R.id.frs_bawu_center) {
                        if (cbZ != null && cbZ.getUserData() != null && cbZ.getUserData().isBawu()) {
                            String bawuCenterUrl = cbZ.getBawuCenterUrl();
                            if (!as.isEmpty(bawuCenterUrl)) {
                                com.baidu.tbadk.browser.a.startWebActivity(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (cbZ.getForum() != null) {
                                    TiebaStatic.log(new ap("c10502").dn("fid", cbZ.getForum().getId()).dn("uid", cbZ.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id == R.id.level_container) {
                        if (!h.this.iac.cca() && h.this.mScrollState == 0 && h.this.ciU() && h.this.ifY != null) {
                            h.this.ifY.l(view, false);
                        }
                    } else if (id == R.id.frs_hot_rank_entry) {
                        if (cbZ != null && cbZ.getForum() != null && !TextUtils.isEmpty(cbZ.getForum().getId())) {
                            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(h.this.getPageContext().getPageActivity());
                            hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(cbZ.getForum().getId(), 0L)));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                            ap apVar2 = new ap("c13666");
                            apVar2.dn("fid", cbZ.getForum().getId());
                            TiebaStatic.log(apVar2);
                        }
                    } else if (id == R.id.frs_manager_info_layout) {
                        if (cbZ != null && cbZ.getForum() != null && !TextUtils.isEmpty(cbZ.getForum().getId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumMemberActivityConfig(h.this.getPageContext().getPageActivity(), String.valueOf(cbZ.getForum().getId()), cbZ.getForum().getName())));
                        }
                    } else if (id == R.id.frs_manager_application_layout && bf.checkUpIsLogin(h.this.mContext.getPageActivity()) && cbZ != null && cbZ.getForum() != null && !TextUtils.isEmpty(cbZ.getForum().getId())) {
                        bd.baV().b(h.this.iac.getTbPageContext(), new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + cbZ.getForum().getId()});
                    }
                }
            }
        };
        this.iac = frsFragment;
        this.ifZ = aVar;
        this.hIC = frsHeaderViewContainer;
        this.ifS = BdUniqueId.gen();
        this.igg = new g(this.iac, this.ifS);
        this.igh = new f(this.iac);
        this.ige = new com.baidu.tieba.f.a();
    }

    public void ar(Bundle bundle) {
        if (this.igg != null) {
            this.igg.registerListener();
        }
        if (this.igh != null) {
            this.igh.awk();
        }
        this.igc = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void cgL() {
        if (this.ifY != null) {
            this.ifY.onDestory();
        }
        if (this.igh != null) {
            this.igh.cgL();
        }
        if (this.igi != null) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.igi);
        }
    }

    public void bbU() {
        if (this.ifY != null) {
            this.ifY.onStop();
        }
        if (this.hIC != null) {
            this.hIC.removeCallbacks(this.fyy);
        }
    }

    public void bE(boolean z) {
        if (this.ifY != null) {
            this.ifY.bE(z);
        }
    }

    public boolean wr(int i) {
        this.mSkinType = i;
        if (this.ifY != null) {
            this.ifY.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void oC(boolean z) {
        if (z) {
            if (this.ifY != null) {
                this.hIC.removeHeaderView(this.ifY.cjY());
                this.iga = false;
            }
        } else if (this.ifY != null && this.ifY.cjY() != null && !this.iga) {
            this.hIC.addHeaderView(this.ifY.cjY(), this.hIC.getHeaderViewsCount());
            this.iga = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            w(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean ciO() {
        return true;
    }

    private void w(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.igb, str);
        this.igd = i2;
        this.igb = str;
        ciR();
        if (this.ifY == null || z) {
            this.ifY = this.ifZ.a(str, this.iac, i);
            this.ifY.changeSkinType(this.mSkinType);
            this.ifY.z(this.hIl);
        }
        if (this.igg != null) {
            this.ifY.f(this.igg);
        }
        if (this.igh != null) {
            this.ifY.g(this.igh);
        }
        this.hIC.addHeaderView(this.ifY.getView());
        Gx(str);
        ciP();
    }

    private void ciP() {
        com.baidu.adp.lib.f.e.lt().postDelayed(this.igi, 4000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceY() {
        if (ciU() && this.ifY != null) {
            this.ifY.ceY();
        }
    }

    public void ciQ() {
        if (!this.iga && this.ifY != null) {
            this.hIC.addHeaderView(this.ifY.cjY());
            this.iga = true;
        }
    }

    private void ciR() {
        if (this.ifY != null) {
            this.hIC.removeHeaderView(this.ifY.getView());
            this.hIC.removeHeaderView(this.ifY.cjY());
            ciS();
        }
        this.iga = false;
    }

    private void ciS() {
        if (this.igf != null && this.iac != null && this.iac.bcE() != null) {
            this.iac.bcE().removeHeaderView(this.igf.cjh());
        }
    }

    private void Gx(String str) {
        RelativeLayout cjh;
        if (this.igf != null && this.iac != null && this.iac.bcE() != null && (cjh = this.igf.cjh()) != null) {
            if ("brand_page".equals(str)) {
                this.iac.bcE().removeHeaderView(cjh);
                return;
            }
            this.iac.bcE().removeHeaderView(cjh);
            this.iac.bcE().addHeaderView(cjh, 0);
        }
    }

    public void i(FrsViewData frsViewData) {
        if (frsViewData != null && ciU()) {
            b(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.igb)) {
                this.ifY.ceL();
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float c = c(forumData);
            if (this.ifY != null) {
                this.ifY.a(forumData, frsViewData);
                this.ifY.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), c, false);
                this.ifY.a(forumData.getSignData());
            }
        }
    }

    public void j(FrsViewData frsViewData) {
        if (frsViewData != null && this.ifY != null && ciU()) {
            this.ifY.aj(c(frsViewData.getForum()));
        }
    }

    private float c(ForumData forumData) {
        if (forumData == null || this.igg == null) {
            return 0.0f;
        }
        return this.igg.c(forumData);
    }

    public void ws(int i) {
        if (i > 1) {
            if (this.ifY != null) {
                this.ifY.oK(false);
            }
        } else if (this.ifY != null) {
            this.ifY.oK(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void ciT() {
        if (this.hIC != null) {
            this.hIC.removeCallbacks(this.fyy);
            this.hIC.postDelayed(this.fyy, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ciU() {
        return "frs_page".equals(this.igb) || "normal_page".equals(this.igb) || "book_page".equals(this.igb) || "brand_page".equals(this.igb);
    }

    public void l(Integer num) {
        setIsMem(num.intValue());
        if (ciU()) {
            ciV();
        }
    }

    public void setIsMem(int i) {
        if (this.ifY != null) {
            this.ifY.setMemberType(i);
        }
    }

    public void ciV() {
        if (this.ifY != null) {
            this.ifY.cfa();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && ciU()) {
            a(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void ciW() {
        if (ciU()) {
            wu(0);
        }
    }

    public void wt(int i) {
        if (ciU()) {
            wu(i);
        }
    }

    public void wu(int i) {
        if (this.ifY != null) {
            this.ifY.wQ(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.ifY != null) {
            this.ifY.a(forumData, frsViewData);
            if (forumData != null) {
                this.ifY.a(i, forumData.getLevelName(), forumData.getUser_level(), c(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.ifY.oB(false);
                }
            }
        }
    }

    public boolean ciX() {
        if (!ciU() || this.ifY == null) {
            return false;
        }
        return this.ifY.cjW();
    }

    public void ciN() {
        if (this.igg != null) {
            this.igg.ciN();
        }
    }

    public void N(int i, int i2, int i3) {
        if (this.igg != null) {
            this.igg.N(i, i2, i3);
        }
    }

    public void wv(int i) {
        if (ciU() && this.ifY != null) {
            this.ifY.wR(i);
        }
    }

    public void k(FrsViewData frsViewData) {
        if (ciU() && this.igg != null) {
            this.igg.a(this.ifY, frsViewData);
        }
    }

    public boolean ciY() {
        if (!ciU() || this.ifY == null) {
            return false;
        }
        return this.ifY.ciY();
    }

    public boolean ciZ() {
        if (!ciU() || this.ifY == null) {
            return false;
        }
        return this.ifY.ciZ();
    }

    public void oA(boolean z) {
        if (this.igh != null) {
            this.igh.oA(z);
        }
    }

    public void ciJ() {
        if (this.igh != null) {
            this.igh.ciJ();
        }
    }

    public void Gy(String str) {
        if (this.iac.cbr() != null && this.iac.cbr().chh() != null) {
            com.baidu.tieba.tbadkCore.e.dki().aS(com.baidu.tieba.tbadkCore.e.dki().e("1~" + str, this.iac.cbr().chh().getSortType(), this.iac.cbr().chh().getIsGood(), this.iac.cbr().chh().getCategoryId()), false);
        }
    }

    public void ceV() {
        if (this.ifY != null) {
            this.ifY.ceV();
        }
    }

    public static boolean l(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().aUr(), true) || frsViewData.getBookInfo().aUr().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean m(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().dku() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || x.isEmpty(frsViewData.getActivityHeadData().aUp())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().aUh(), true)))) ? false : true;
        }
        return false;
    }

    public void ww(int i) {
        View findViewById;
        if (this.ifY != null && this.ifY.cjY() != null && (findViewById = this.ifY.cjY().findViewById(R.id.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.ige != null) {
            this.ige.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.igf = frsTabViewController;
    }
}
