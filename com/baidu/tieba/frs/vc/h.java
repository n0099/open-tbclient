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
    private Runnable gxj;
    private final View.OnClickListener iVJ;
    private FrsHeaderViewContainer iWa;
    private FrsFragment jrm;
    private BdUniqueId jwZ;
    private com.baidu.tieba.frs.view.b jxf;
    private com.baidu.tieba.frs.entelechy.b.a jxg;
    private boolean jxh;
    private String jxi;
    private boolean jxj;
    private int jxk;
    private com.baidu.tieba.g.a jxl;
    private FrsTabViewController jxm;
    private g jxn;
    private f jxo;
    private final Runnable jxp;
    private final Runnable jxq;
    private int mScrollState;
    private int mSkinType;

    public h(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.jxh = false;
        this.mSkinType = 0;
        this.jxi = "normal_page";
        this.mScrollState = 0;
        this.jxj = false;
        this.jxp = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.1
            @Override // java.lang.Runnable
            public void run() {
                q cCf;
                if (h.this.jrm != null && h.this.mScrollState == 0 && (cCf = h.this.jrm.cCf()) != null && cCf.cDl() != null && !cCf.cDl().cKA() && !cCf.cCL() && h.this.iWa.isShown() && h.this.jrm.isPrimary() && !h.this.jxj && h.this.jrm.cCS() && h.this.jxk == 1 && h.this.cKQ() && h.this.jxf != null && h.this.jxf.cLV()) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                    h.this.cFP();
                    h.this.jrm.iSK = true;
                    h.this.jxj = true;
                }
            }
        };
        this.jxq = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.jrm != null && h.this.mScrollState == 0 && !h.this.jrm.cCf().cCL() && h.this.iWa.isShown() && h.this.jrm.isPrimary()) {
                    h.this.cFQ();
                }
            }
        };
        this.gxj = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.iWa != null) {
                    int childCount = h.this.iWa.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(h.this.iWa.getChildAt(i));
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
        this.iVJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.jrm != null) {
                    FrsViewData cCK = h.this.jrm.cCK();
                    if (cCK != null && cCK.getForum() != null && h.this.jxf != null && (view == h.this.jxf.cLX() || view == h.this.jxf.cLY() || view == h.this.jxf.cLZ())) {
                        if (h.this.jrm != null && cCK.getForum() != null) {
                            TiebaStatic.log(new ar("c12046").dY("fid", cCK.getForum().getId()).al("obj_locate", h.this.jrm.cCN() ? 1 : 2));
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        if (cCK.getEntelechyTabInfo() != null && cCK.getEntelechyTabInfo().tab != null) {
                            for (int i = 0; i < cCK.getEntelechyTabInfo().tab.size(); i++) {
                                arrayList.add(cCK.getEntelechyTabInfo().tab.get(i).tab_name);
                            }
                        }
                        ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), cCK.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                        forumDetailActivityConfig.setForumTabs(arrayList);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumDetailActivityConfig));
                    }
                    int id = view.getId();
                    if (id == R.id.tv_love) {
                        if (!h.this.jrm.cCL()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.jrm.showToast(R.string.neterror);
                            } else if (!bh.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                TiebaStatic.log(new ar("c10517").al("obj_locate", 1).dY("fid", h.this.jrm.getForumId()));
                            } else {
                                h.this.qW(true);
                                if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    ar arVar = new ar("c10048");
                                    arVar.dY("fid", h.this.jrm.getForumId());
                                    arVar.dY("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(arVar);
                                }
                            }
                        }
                    } else if (id == R.id.tv_sign) {
                        if (!h.this.jrm.cCL()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.jrm.showToast(R.string.neterror);
                            } else if (bh.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                if (!h.this.cKU()) {
                                    h.this.cKH();
                                    ar.BZ("c13560").al("obj_type", 2).btT();
                                } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(h.this.jrm.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(h.this.jrm.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                                }
                            }
                        }
                    } else if (id == R.id.frs_header_games) {
                        if (bh.checkUpIsLogin(h.this.mContext.getPageActivity()) && cCK != null && cCK.getGameUrl() != null) {
                            bf.bua().a((TbPageContext) h.this.getPageContext(), new String[]{cCK.getGameUrl()}, true);
                        }
                    } else if (id == R.id.frs_bawu_center) {
                        if (cCK != null && cCK.getUserData() != null && cCK.getUserData().isBawu()) {
                            String bawuCenterUrl = cCK.getBawuCenterUrl();
                            if (!au.isEmpty(bawuCenterUrl)) {
                                com.baidu.tbadk.browser.a.startWebActivity(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (cCK.getForum() != null) {
                                    TiebaStatic.log(new ar("c10502").dY("fid", cCK.getForum().getId()).dY("uid", cCK.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id == R.id.level_container) {
                        if (!h.this.jrm.cCL() && h.this.mScrollState == 0 && h.this.cKQ() && h.this.jxf != null) {
                            h.this.jxf.m(view, false);
                        }
                    } else if (id == R.id.frs_hot_rank_entry) {
                        if (cCK != null && cCK.getForum() != null && !TextUtils.isEmpty(cCK.getForum().getId())) {
                            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(h.this.getPageContext().getPageActivity());
                            hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(cCK.getForum().getId(), 0L)));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                            ar arVar2 = new ar("c13666");
                            arVar2.dY("fid", cCK.getForum().getId());
                            TiebaStatic.log(arVar2);
                        }
                    } else if (id == R.id.frs_manager_info_layout) {
                        if (cCK != null && cCK.getForum() != null && !TextUtils.isEmpty(cCK.getForum().getId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumMemberActivityConfig(h.this.getPageContext().getPageActivity(), String.valueOf(cCK.getForum().getId()), cCK.getForum().getName())));
                        }
                    } else if (id == R.id.frs_manager_application_layout && bh.checkUpIsLogin(h.this.mContext.getPageActivity()) && cCK != null && cCK.getForum() != null && !TextUtils.isEmpty(cCK.getForum().getId())) {
                        bf.bua().b(h.this.jrm.getTbPageContext(), new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + cCK.getForum().getId()});
                    }
                }
            }
        };
        this.jrm = frsFragment;
        this.jxg = aVar;
        this.iWa = frsHeaderViewContainer;
        this.jwZ = BdUniqueId.gen();
        this.jxn = new g(this.jrm, this.jwZ);
        this.jxo = new f(this.jrm);
        this.jxl = new com.baidu.tieba.g.a();
    }

    public void as(Bundle bundle) {
        if (this.jxn != null) {
            this.jxn.registerListener();
        }
        if (this.jxo != null) {
            this.jxo.aOG();
        }
        this.jxj = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void cID() {
        if (this.jxf != null) {
            this.jxf.onDestory();
        }
        if (this.jxo != null) {
            this.jxo.cID();
        }
        if (this.jxp != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jxp);
        }
        if (this.jxq != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jxq);
        }
    }

    public void bvb() {
        if (this.jxf != null) {
            this.jxf.onStop();
        }
        if (this.iWa != null) {
            this.iWa.removeCallbacks(this.gxj);
        }
    }

    public void cb(boolean z) {
        if (this.jxf != null) {
            this.jxf.cb(z);
        }
    }

    public boolean BH(int i) {
        this.mSkinType = i;
        if (this.jxf != null) {
            this.jxf.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void qY(boolean z) {
        if (z) {
            if (this.jxf != null) {
                this.iWa.removeHeaderView(this.jxf.cLW());
                this.jxh = false;
            }
        } else if (this.jxf != null && this.jxf.cLW() != null && !this.jxh) {
            this.iWa.addHeaderView(this.jxf.cLW(), this.iWa.getHeaderViewsCount());
            this.jxh = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            y(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean cKI() {
        return true;
    }

    private void y(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.jxi, str);
        this.jxk = i2;
        this.jxi = str;
        cKN();
        if (this.jxf == null || z) {
            this.jxf = this.jxg.a(str, this.jrm, i);
            this.jxf.changeSkinType(this.mSkinType);
            this.jxf.B(this.iVJ);
        }
        if (this.jxn != null) {
            this.jxf.f(this.jxn);
        }
        if (this.jxo != null) {
            this.jxf.g(this.jxo);
        }
        this.iWa.addHeaderView(this.jxf.getView());
        LJ(str);
        cKJ();
        cKK();
    }

    private void cKJ() {
        com.baidu.adp.lib.f.e.mY().postDelayed(this.jxp, 4000L);
    }

    public void cKK() {
        com.baidu.adp.lib.f.e.mY().postDelayed(this.jxq, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFP() {
        if (cKQ() && this.jxf != null) {
            this.jxf.cFP();
        }
    }

    public void cFQ() {
        if (this.jxf != null) {
            this.jxf.cFQ();
        }
    }

    public void cKL() {
        if (this.jxf != null) {
            this.jxf.cFR();
        }
    }

    public void cKM() {
        if (!this.jxh && this.jxf != null) {
            this.iWa.addHeaderView(this.jxf.cLW());
            this.jxh = true;
        }
    }

    private void cKN() {
        if (this.jxf != null) {
            this.iWa.removeHeaderView(this.jxf.getView());
            this.iWa.removeHeaderView(this.jxf.cLW());
            cKO();
        }
        this.jxh = false;
    }

    private void cKO() {
        if (this.jxm != null && this.jrm != null && this.jrm.bvQ() != null) {
            this.jrm.bvQ().removeHeaderView(this.jxm.cLg());
        }
    }

    private void LJ(String str) {
        RelativeLayout cLg;
        if (this.jxm != null && this.jrm != null && this.jrm.bvQ() != null && (cLg = this.jxm.cLg()) != null) {
            if ("brand_page".equals(str)) {
                this.jrm.bvQ().removeHeaderView(cLg);
                return;
            }
            this.jrm.bvQ().removeHeaderView(cLg);
            this.jrm.bvQ().addHeaderView(cLg, 0);
        }
    }

    public void j(FrsViewData frsViewData) {
        if (frsViewData != null && cKQ()) {
            b(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.jxi)) {
                this.jxf.cFC();
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float f = f(forumData);
            if (this.jxf != null) {
                this.jxf.a(forumData, frsViewData);
                this.jxf.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), f, false);
                this.jxf.a(forumData.getSignData());
            }
        }
    }

    public void k(FrsViewData frsViewData) {
        if (frsViewData != null && this.jxf != null && cKQ()) {
            this.jxf.aH(f(frsViewData.getForum()));
        }
    }

    private float f(ForumData forumData) {
        if (forumData == null || this.jxn == null) {
            return 0.0f;
        }
        return this.jxn.f(forumData);
    }

    public void BI(int i) {
        if (i > 1) {
            if (this.jxf != null) {
                this.jxf.rg(false);
            }
        } else if (this.jxf != null) {
            this.jxf.rg(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void cKP() {
        if (this.iWa != null) {
            this.iWa.removeCallbacks(this.gxj);
            this.iWa.postDelayed(this.gxj, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cKQ() {
        return "frs_page".equals(this.jxi) || "normal_page".equals(this.jxi) || "book_page".equals(this.jxi) || "brand_page".equals(this.jxi);
    }

    public void o(Integer num) {
        setIsMem(num.intValue());
        if (cKQ()) {
            cKR();
        }
    }

    public void setIsMem(int i) {
        if (this.jxf != null) {
            this.jxf.setMemberType(i);
        }
    }

    public void cKR() {
        if (this.jxf != null) {
            this.jxf.cFU();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && cKQ()) {
            a(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void cKS() {
        if (cKQ()) {
            BK(0);
        }
    }

    public void BJ(int i) {
        if (cKQ()) {
            BK(i);
        }
    }

    public void BK(int i) {
        if (this.jxf != null) {
            this.jxf.Ch(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.jxf != null) {
            this.jxf.a(forumData, frsViewData);
            if (forumData != null) {
                this.jxf.a(i, forumData.getLevelName(), forumData.getUser_level(), f(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.jxf.qX(false);
                }
            }
        }
    }

    public boolean cKT() {
        if (!cKQ() || this.jxf == null) {
            return false;
        }
        return this.jxf.cLU();
    }

    public void cKH() {
        if (this.jxn != null) {
            this.jxn.cKH();
        }
    }

    public void R(int i, int i2, int i3) {
        if (this.jxn != null) {
            this.jxn.R(i, i2, i3);
        }
    }

    public void BL(int i) {
        if (cKQ() && this.jxf != null) {
            this.jxf.Ci(i);
        }
    }

    public void l(FrsViewData frsViewData) {
        if (cKQ() && this.jxn != null) {
            this.jxn.a(this.jxf, frsViewData);
        }
    }

    public boolean cKU() {
        if (!cKQ() || this.jxf == null) {
            return false;
        }
        return this.jxf.cKU();
    }

    public boolean cKV() {
        if (!cKQ() || this.jxf == null) {
            return false;
        }
        return this.jxf.cKV();
    }

    public void qW(boolean z) {
        if (this.jxo != null) {
            this.jxo.qW(z);
        }
    }

    public void cKD() {
        if (this.jxo != null) {
            this.jxo.cKD();
        }
    }

    public void LK(String str) {
        if (this.jrm.cCa() != null && this.jrm.cCa().cIZ() != null) {
            com.baidu.tieba.tbadkCore.e.dOg().bd(com.baidu.tieba.tbadkCore.e.dOg().f("1~" + str, this.jrm.cCa().cIZ().getSortType(), this.jrm.cCa().cIZ().getIsGood(), this.jrm.cCa().cIZ().getCategoryId()), false);
        }
    }

    public void cFM() {
        if (this.jxf != null) {
            this.jxf.cFM();
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
            return ((frsViewData.getStar() == null || frsViewData.getStar().dOt() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || y.isEmpty(frsViewData.getActivityHeadData().bmT())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().bmL(), true)))) ? false : true;
        }
        return false;
    }

    public void BM(int i) {
        if (this.jxf != null && this.jxf.cLW() != null) {
            View findViewById = this.jxf.cLW().findViewById(R.id.divider_bottom);
            if (findViewById != null) {
                findViewById.setVisibility(i);
            }
            this.jxf.cFR();
        }
    }

    public void cFS() {
        this.jxf.cFS();
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.jxl != null) {
            this.jxl.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.jxm = frsTabViewController;
    }

    public f cKW() {
        return this.jxo;
    }
}
