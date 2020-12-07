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
/* loaded from: classes22.dex */
public class h extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Runnable gxh;
    private final View.OnClickListener iVH;
    private FrsHeaderViewContainer iVY;
    private FrsFragment jrk;
    private BdUniqueId jwX;
    private com.baidu.tieba.frs.view.b jxd;
    private com.baidu.tieba.frs.entelechy.b.a jxe;
    private boolean jxf;
    private String jxg;
    private boolean jxh;
    private int jxi;
    private com.baidu.tieba.g.a jxj;
    private FrsTabViewController jxk;
    private g jxl;
    private f jxm;
    private final Runnable jxn;
    private final Runnable jxo;
    private int mScrollState;
    private int mSkinType;

    public h(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.jxf = false;
        this.mSkinType = 0;
        this.jxg = "normal_page";
        this.mScrollState = 0;
        this.jxh = false;
        this.jxn = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.1
            @Override // java.lang.Runnable
            public void run() {
                q cCe;
                if (h.this.jrk != null && h.this.mScrollState == 0 && (cCe = h.this.jrk.cCe()) != null && cCe.cDk() != null && !cCe.cDk().cKz() && !cCe.cCK() && h.this.iVY.isShown() && h.this.jrk.isPrimary() && !h.this.jxh && h.this.jrk.cCR() && h.this.jxi == 1 && h.this.cKP() && h.this.jxd != null && h.this.jxd.cLU()) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                    h.this.cFO();
                    h.this.jrk.iSI = true;
                    h.this.jxh = true;
                }
            }
        };
        this.jxo = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.jrk != null && h.this.mScrollState == 0 && !h.this.jrk.cCe().cCK() && h.this.iVY.isShown() && h.this.jrk.isPrimary()) {
                    h.this.cFP();
                }
            }
        };
        this.gxh = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.iVY != null) {
                    int childCount = h.this.iVY.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(h.this.iVY.getChildAt(i));
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
        this.iVH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.jrk != null) {
                    FrsViewData cCJ = h.this.jrk.cCJ();
                    if (cCJ != null && cCJ.getForum() != null && h.this.jxd != null && (view == h.this.jxd.cLW() || view == h.this.jxd.cLX() || view == h.this.jxd.cLY())) {
                        if (h.this.jrk != null && cCJ.getForum() != null) {
                            TiebaStatic.log(new ar("c12046").dY("fid", cCJ.getForum().getId()).al("obj_locate", h.this.jrk.cCM() ? 1 : 2));
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        if (cCJ.getEntelechyTabInfo() != null && cCJ.getEntelechyTabInfo().tab != null) {
                            for (int i = 0; i < cCJ.getEntelechyTabInfo().tab.size(); i++) {
                                arrayList.add(cCJ.getEntelechyTabInfo().tab.get(i).tab_name);
                            }
                        }
                        ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), cCJ.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                        forumDetailActivityConfig.setForumTabs(arrayList);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumDetailActivityConfig));
                    }
                    int id = view.getId();
                    if (id == R.id.tv_love) {
                        if (!h.this.jrk.cCK()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.jrk.showToast(R.string.neterror);
                            } else if (!bh.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                TiebaStatic.log(new ar("c10517").al("obj_locate", 1).dY("fid", h.this.jrk.getForumId()));
                            } else {
                                h.this.qW(true);
                                if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    ar arVar = new ar("c10048");
                                    arVar.dY("fid", h.this.jrk.getForumId());
                                    arVar.dY("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(arVar);
                                }
                            }
                        }
                    } else if (id == R.id.tv_sign) {
                        if (!h.this.jrk.cCK()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.jrk.showToast(R.string.neterror);
                            } else if (bh.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                if (!h.this.cKT()) {
                                    h.this.cKG();
                                    ar.BZ("c13560").al("obj_type", 2).btT();
                                } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(h.this.jrk.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(h.this.jrk.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                                }
                            }
                        }
                    } else if (id == R.id.frs_header_games) {
                        if (bh.checkUpIsLogin(h.this.mContext.getPageActivity()) && cCJ != null && cCJ.getGameUrl() != null) {
                            bf.bua().a((TbPageContext) h.this.getPageContext(), new String[]{cCJ.getGameUrl()}, true);
                        }
                    } else if (id == R.id.frs_bawu_center) {
                        if (cCJ != null && cCJ.getUserData() != null && cCJ.getUserData().isBawu()) {
                            String bawuCenterUrl = cCJ.getBawuCenterUrl();
                            if (!au.isEmpty(bawuCenterUrl)) {
                                com.baidu.tbadk.browser.a.startWebActivity(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (cCJ.getForum() != null) {
                                    TiebaStatic.log(new ar("c10502").dY("fid", cCJ.getForum().getId()).dY("uid", cCJ.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id == R.id.level_container) {
                        if (!h.this.jrk.cCK() && h.this.mScrollState == 0 && h.this.cKP() && h.this.jxd != null) {
                            h.this.jxd.m(view, false);
                        }
                    } else if (id == R.id.frs_hot_rank_entry) {
                        if (cCJ != null && cCJ.getForum() != null && !TextUtils.isEmpty(cCJ.getForum().getId())) {
                            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(h.this.getPageContext().getPageActivity());
                            hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(cCJ.getForum().getId(), 0L)));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                            ar arVar2 = new ar("c13666");
                            arVar2.dY("fid", cCJ.getForum().getId());
                            TiebaStatic.log(arVar2);
                        }
                    } else if (id == R.id.frs_manager_info_layout) {
                        if (cCJ != null && cCJ.getForum() != null && !TextUtils.isEmpty(cCJ.getForum().getId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumMemberActivityConfig(h.this.getPageContext().getPageActivity(), String.valueOf(cCJ.getForum().getId()), cCJ.getForum().getName())));
                        }
                    } else if (id == R.id.frs_manager_application_layout && bh.checkUpIsLogin(h.this.mContext.getPageActivity()) && cCJ != null && cCJ.getForum() != null && !TextUtils.isEmpty(cCJ.getForum().getId())) {
                        bf.bua().b(h.this.jrk.getTbPageContext(), new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + cCJ.getForum().getId()});
                    }
                }
            }
        };
        this.jrk = frsFragment;
        this.jxe = aVar;
        this.iVY = frsHeaderViewContainer;
        this.jwX = BdUniqueId.gen();
        this.jxl = new g(this.jrk, this.jwX);
        this.jxm = new f(this.jrk);
        this.jxj = new com.baidu.tieba.g.a();
    }

    public void as(Bundle bundle) {
        if (this.jxl != null) {
            this.jxl.registerListener();
        }
        if (this.jxm != null) {
            this.jxm.aOG();
        }
        this.jxh = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void cIC() {
        if (this.jxd != null) {
            this.jxd.onDestory();
        }
        if (this.jxm != null) {
            this.jxm.cIC();
        }
        if (this.jxn != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jxn);
        }
        if (this.jxo != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jxo);
        }
    }

    public void bvb() {
        if (this.jxd != null) {
            this.jxd.onStop();
        }
        if (this.iVY != null) {
            this.iVY.removeCallbacks(this.gxh);
        }
    }

    public void cb(boolean z) {
        if (this.jxd != null) {
            this.jxd.cb(z);
        }
    }

    public boolean BH(int i) {
        this.mSkinType = i;
        if (this.jxd != null) {
            this.jxd.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void qY(boolean z) {
        if (z) {
            if (this.jxd != null) {
                this.iVY.removeHeaderView(this.jxd.cLV());
                this.jxf = false;
            }
        } else if (this.jxd != null && this.jxd.cLV() != null && !this.jxf) {
            this.iVY.addHeaderView(this.jxd.cLV(), this.iVY.getHeaderViewsCount());
            this.jxf = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            y(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean cKH() {
        return true;
    }

    private void y(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.jxg, str);
        this.jxi = i2;
        this.jxg = str;
        cKM();
        if (this.jxd == null || z) {
            this.jxd = this.jxe.a(str, this.jrk, i);
            this.jxd.changeSkinType(this.mSkinType);
            this.jxd.B(this.iVH);
        }
        if (this.jxl != null) {
            this.jxd.f(this.jxl);
        }
        if (this.jxm != null) {
            this.jxd.g(this.jxm);
        }
        this.iVY.addHeaderView(this.jxd.getView());
        LJ(str);
        cKI();
        cKJ();
    }

    private void cKI() {
        com.baidu.adp.lib.f.e.mY().postDelayed(this.jxn, 4000L);
    }

    public void cKJ() {
        com.baidu.adp.lib.f.e.mY().postDelayed(this.jxo, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFO() {
        if (cKP() && this.jxd != null) {
            this.jxd.cFO();
        }
    }

    public void cFP() {
        if (this.jxd != null) {
            this.jxd.cFP();
        }
    }

    public void cKK() {
        if (this.jxd != null) {
            this.jxd.cFQ();
        }
    }

    public void cKL() {
        if (!this.jxf && this.jxd != null) {
            this.iVY.addHeaderView(this.jxd.cLV());
            this.jxf = true;
        }
    }

    private void cKM() {
        if (this.jxd != null) {
            this.iVY.removeHeaderView(this.jxd.getView());
            this.iVY.removeHeaderView(this.jxd.cLV());
            cKN();
        }
        this.jxf = false;
    }

    private void cKN() {
        if (this.jxk != null && this.jrk != null && this.jrk.bvQ() != null) {
            this.jrk.bvQ().removeHeaderView(this.jxk.cLf());
        }
    }

    private void LJ(String str) {
        RelativeLayout cLf;
        if (this.jxk != null && this.jrk != null && this.jrk.bvQ() != null && (cLf = this.jxk.cLf()) != null) {
            if ("brand_page".equals(str)) {
                this.jrk.bvQ().removeHeaderView(cLf);
                return;
            }
            this.jrk.bvQ().removeHeaderView(cLf);
            this.jrk.bvQ().addHeaderView(cLf, 0);
        }
    }

    public void j(FrsViewData frsViewData) {
        if (frsViewData != null && cKP()) {
            b(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.jxg)) {
                this.jxd.cFB();
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float f = f(forumData);
            if (this.jxd != null) {
                this.jxd.a(forumData, frsViewData);
                this.jxd.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), f, false);
                this.jxd.a(forumData.getSignData());
            }
        }
    }

    public void k(FrsViewData frsViewData) {
        if (frsViewData != null && this.jxd != null && cKP()) {
            this.jxd.aH(f(frsViewData.getForum()));
        }
    }

    private float f(ForumData forumData) {
        if (forumData == null || this.jxl == null) {
            return 0.0f;
        }
        return this.jxl.f(forumData);
    }

    public void BI(int i) {
        if (i > 1) {
            if (this.jxd != null) {
                this.jxd.rg(false);
            }
        } else if (this.jxd != null) {
            this.jxd.rg(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void cKO() {
        if (this.iVY != null) {
            this.iVY.removeCallbacks(this.gxh);
            this.iVY.postDelayed(this.gxh, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cKP() {
        return "frs_page".equals(this.jxg) || "normal_page".equals(this.jxg) || "book_page".equals(this.jxg) || "brand_page".equals(this.jxg);
    }

    public void o(Integer num) {
        setIsMem(num.intValue());
        if (cKP()) {
            cKQ();
        }
    }

    public void setIsMem(int i) {
        if (this.jxd != null) {
            this.jxd.setMemberType(i);
        }
    }

    public void cKQ() {
        if (this.jxd != null) {
            this.jxd.cFT();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && cKP()) {
            a(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void cKR() {
        if (cKP()) {
            BK(0);
        }
    }

    public void BJ(int i) {
        if (cKP()) {
            BK(i);
        }
    }

    public void BK(int i) {
        if (this.jxd != null) {
            this.jxd.Ch(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.jxd != null) {
            this.jxd.a(forumData, frsViewData);
            if (forumData != null) {
                this.jxd.a(i, forumData.getLevelName(), forumData.getUser_level(), f(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.jxd.qX(false);
                }
            }
        }
    }

    public boolean cKS() {
        if (!cKP() || this.jxd == null) {
            return false;
        }
        return this.jxd.cLT();
    }

    public void cKG() {
        if (this.jxl != null) {
            this.jxl.cKG();
        }
    }

    public void R(int i, int i2, int i3) {
        if (this.jxl != null) {
            this.jxl.R(i, i2, i3);
        }
    }

    public void BL(int i) {
        if (cKP() && this.jxd != null) {
            this.jxd.Ci(i);
        }
    }

    public void l(FrsViewData frsViewData) {
        if (cKP() && this.jxl != null) {
            this.jxl.a(this.jxd, frsViewData);
        }
    }

    public boolean cKT() {
        if (!cKP() || this.jxd == null) {
            return false;
        }
        return this.jxd.cKT();
    }

    public boolean cKU() {
        if (!cKP() || this.jxd == null) {
            return false;
        }
        return this.jxd.cKU();
    }

    public void qW(boolean z) {
        if (this.jxm != null) {
            this.jxm.qW(z);
        }
    }

    public void cKC() {
        if (this.jxm != null) {
            this.jxm.cKC();
        }
    }

    public void LK(String str) {
        if (this.jrk.cBZ() != null && this.jrk.cBZ().cIY() != null) {
            com.baidu.tieba.tbadkCore.e.dOf().bd(com.baidu.tieba.tbadkCore.e.dOf().f("1~" + str, this.jrk.cBZ().cIY().getSortType(), this.jrk.cBZ().cIY().getIsGood(), this.jrk.cBZ().cIY().getCategoryId()), false);
        }
    }

    public void cFL() {
        if (this.jxd != null) {
            this.jxd.cFL();
        }
    }

    public static boolean m(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().bmV(), true) || frsViewData.getBookInfo().bmV().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean n(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().dOs() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || y.isEmpty(frsViewData.getActivityHeadData().bmT())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().bmL(), true)))) ? false : true;
        }
        return false;
    }

    public void BM(int i) {
        if (this.jxd != null && this.jxd.cLV() != null) {
            View findViewById = this.jxd.cLV().findViewById(R.id.divider_bottom);
            if (findViewById != null) {
                findViewById.setVisibility(i);
            }
            this.jxd.cFQ();
        }
    }

    public void cFR() {
        this.jxd.cFR();
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.jxj != null) {
            this.jxj.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.jxk = frsTabViewController;
    }

    public f cKV() {
        return this.jxm;
    }
}
