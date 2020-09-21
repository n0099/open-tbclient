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
/* loaded from: classes21.dex */
public class h extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Runnable fNi;
    private BdUniqueId iBA;
    private com.baidu.tieba.frs.view.b iBG;
    private com.baidu.tieba.frs.entelechy.b.a iBH;
    private boolean iBI;
    private String iBJ;
    private boolean iBK;
    private int iBL;
    private com.baidu.tieba.f.a iBM;
    private FrsTabViewController iBN;
    private g iBO;
    private f iBP;
    private final Runnable iBQ;
    private final View.OnClickListener icH;
    private FrsHeaderViewContainer icY;
    private FrsFragment ivI;
    private int mScrollState;
    private int mSkinType;

    public h(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.iBI = false;
        this.mSkinType = 0;
        this.iBJ = "normal_page";
        this.mScrollState = 0;
        this.iBK = false;
        this.iBQ = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.1
            @Override // java.lang.Runnable
            public void run() {
                q cpf;
                if (h.this.ivI != null && h.this.mScrollState == 0 && (cpf = h.this.ivI.cpf()) != null && cpf.cqk() != null && !cpf.cqk().cwA() && !cpf.cpK() && h.this.icY.isShown() && h.this.ivI.isPrimary() && !h.this.iBK && h.this.ivI.cpR() && h.this.iBL == 1 && h.this.cwQ() && h.this.iBG != null && h.this.iBG.cxV()) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                    h.this.csQ();
                    h.this.ivI.hZI = true;
                    h.this.iBK = true;
                }
            }
        };
        this.fNi = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.icY != null) {
                    int childCount = h.this.icY.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(h.this.icY.getChildAt(i));
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
        this.icH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.ivI != null) {
                    FrsViewData cpJ = h.this.ivI.cpJ();
                    if (cpJ != null && cpJ.getForum() != null && h.this.iBG != null && (view == h.this.iBG.cxX() || view == h.this.iBG.cxY() || view == h.this.iBG.cxZ())) {
                        if (h.this.ivI != null && cpJ.getForum() != null) {
                            TiebaStatic.log(new aq("c12046").dF("fid", cpJ.getForum().getId()).ai("obj_locate", h.this.ivI.cpM() ? 1 : 2));
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        if (cpJ.getEntelechyTabInfo() != null && cpJ.getEntelechyTabInfo().tab != null) {
                            for (int i = 0; i < cpJ.getEntelechyTabInfo().tab.size(); i++) {
                                arrayList.add(cpJ.getEntelechyTabInfo().tab.get(i).tab_name);
                            }
                        }
                        ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), cpJ.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                        forumDetailActivityConfig.setForumTabs(arrayList);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumDetailActivityConfig));
                    }
                    int id = view.getId();
                    if (id == R.id.tv_love) {
                        if (!h.this.ivI.cpK()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.ivI.showToast(R.string.neterror);
                            } else if (!bg.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                TiebaStatic.log(new aq("c10517").ai("obj_locate", 1).dF("fid", h.this.ivI.getForumId()));
                            } else {
                                h.this.pm(true);
                                if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    aq aqVar = new aq("c10048");
                                    aqVar.dF("fid", h.this.ivI.getForumId());
                                    aqVar.dF("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(aqVar);
                                }
                            }
                        }
                    } else if (id == R.id.tv_sign) {
                        if (!h.this.ivI.cpK()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.ivI.showToast(R.string.neterror);
                            } else if (bg.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                if (!h.this.cwU()) {
                                    h.this.cwJ();
                                    aq.AA("c13560").ai("obj_type", 2).bki();
                                } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(h.this.ivI.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(h.this.ivI.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                                }
                            }
                        }
                    } else if (id == R.id.frs_header_games) {
                        if (bg.checkUpIsLogin(h.this.mContext.getPageActivity()) && cpJ != null && cpJ.getGameUrl() != null) {
                            be.bkp().a((TbPageContext) h.this.getPageContext(), new String[]{cpJ.getGameUrl()}, true);
                        }
                    } else if (id == R.id.frs_bawu_center) {
                        if (cpJ != null && cpJ.getUserData() != null && cpJ.getUserData().isBawu()) {
                            String bawuCenterUrl = cpJ.getBawuCenterUrl();
                            if (!at.isEmpty(bawuCenterUrl)) {
                                com.baidu.tbadk.browser.a.startWebActivity(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (cpJ.getForum() != null) {
                                    TiebaStatic.log(new aq("c10502").dF("fid", cpJ.getForum().getId()).dF("uid", cpJ.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id == R.id.level_container) {
                        if (!h.this.ivI.cpK() && h.this.mScrollState == 0 && h.this.cwQ() && h.this.iBG != null) {
                            h.this.iBG.k(view, false);
                        }
                    } else if (id == R.id.frs_hot_rank_entry) {
                        if (cpJ != null && cpJ.getForum() != null && !TextUtils.isEmpty(cpJ.getForum().getId())) {
                            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(h.this.getPageContext().getPageActivity());
                            hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(cpJ.getForum().getId(), 0L)));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                            aq aqVar2 = new aq("c13666");
                            aqVar2.dF("fid", cpJ.getForum().getId());
                            TiebaStatic.log(aqVar2);
                        }
                    } else if (id == R.id.frs_manager_info_layout) {
                        if (cpJ != null && cpJ.getForum() != null && !TextUtils.isEmpty(cpJ.getForum().getId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumMemberActivityConfig(h.this.getPageContext().getPageActivity(), String.valueOf(cpJ.getForum().getId()), cpJ.getForum().getName())));
                        }
                    } else if (id == R.id.frs_manager_application_layout && bg.checkUpIsLogin(h.this.mContext.getPageActivity()) && cpJ != null && cpJ.getForum() != null && !TextUtils.isEmpty(cpJ.getForum().getId())) {
                        be.bkp().b(h.this.ivI.getTbPageContext(), new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + cpJ.getForum().getId()});
                    }
                }
            }
        };
        this.ivI = frsFragment;
        this.iBH = aVar;
        this.icY = frsHeaderViewContainer;
        this.iBA = BdUniqueId.gen();
        this.iBO = new g(this.ivI, this.iBA);
        this.iBP = new f(this.ivI);
        this.iBM = new com.baidu.tieba.f.a();
    }

    public void aq(Bundle bundle) {
        if (this.iBO != null) {
            this.iBO.registerListener();
        }
        if (this.iBP != null) {
            this.iBP.aFe();
        }
        this.iBK = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void cuG() {
        if (this.iBG != null) {
            this.iBG.onDestory();
        }
        if (this.iBP != null) {
            this.iBP.cuG();
        }
        if (this.iBQ != null) {
            com.baidu.adp.lib.f.e.mX().removeCallbacks(this.iBQ);
        }
    }

    public void bll() {
        if (this.iBG != null) {
            this.iBG.onStop();
        }
        if (this.icY != null) {
            this.icY.removeCallbacks(this.fNi);
        }
    }

    public void bL(boolean z) {
        if (this.iBG != null) {
            this.iBG.bL(z);
        }
    }

    public boolean zj(int i) {
        this.mSkinType = i;
        if (this.iBG != null) {
            this.iBG.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void po(boolean z) {
        if (z) {
            if (this.iBG != null) {
                this.icY.removeHeaderView(this.iBG.cxW());
                this.iBI = false;
            }
        } else if (this.iBG != null && this.iBG.cxW() != null && !this.iBI) {
            this.icY.addHeaderView(this.iBG.cxW(), this.icY.getHeaderViewsCount());
            this.iBI = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            v(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean cwK() {
        return true;
    }

    private void v(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.iBJ, str);
        this.iBL = i2;
        this.iBJ = str;
        cwN();
        if (this.iBG == null || z) {
            this.iBG = this.iBH.a(str, this.ivI, i);
            this.iBG.changeSkinType(this.mSkinType);
            this.iBG.A(this.icH);
        }
        if (this.iBO != null) {
            this.iBG.f(this.iBO);
        }
        if (this.iBP != null) {
            this.iBG.g(this.iBP);
        }
        this.icY.addHeaderView(this.iBG.getView());
        Jy(str);
        cwL();
    }

    private void cwL() {
        com.baidu.adp.lib.f.e.mX().postDelayed(this.iBQ, 4000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csQ() {
        if (cwQ() && this.iBG != null) {
            this.iBG.csQ();
        }
    }

    public void cwM() {
        if (!this.iBI && this.iBG != null) {
            this.icY.addHeaderView(this.iBG.cxW());
            this.iBI = true;
        }
    }

    private void cwN() {
        if (this.iBG != null) {
            this.icY.removeHeaderView(this.iBG.getView());
            this.icY.removeHeaderView(this.iBG.cxW());
            cwO();
        }
        this.iBI = false;
    }

    private void cwO() {
        if (this.iBN != null && this.ivI != null && this.ivI.blX() != null) {
            this.ivI.blX().removeHeaderView(this.iBN.cxf());
        }
    }

    private void Jy(String str) {
        RelativeLayout cxf;
        if (this.iBN != null && this.ivI != null && this.ivI.blX() != null && (cxf = this.iBN.cxf()) != null) {
            if ("brand_page".equals(str)) {
                this.ivI.blX().removeHeaderView(cxf);
                return;
            }
            this.ivI.blX().removeHeaderView(cxf);
            this.ivI.blX().addHeaderView(cxf, 0);
        }
    }

    public void i(FrsViewData frsViewData) {
        if (frsViewData != null && cwQ()) {
            b(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.iBJ)) {
                this.iBG.csD();
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float f = f(forumData);
            if (this.iBG != null) {
                this.iBG.a(forumData, frsViewData);
                this.iBG.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), f, false);
                this.iBG.a(forumData.getSignData());
            }
        }
    }

    public void j(FrsViewData frsViewData) {
        if (frsViewData != null && this.iBG != null && cwQ()) {
            this.iBG.ap(f(frsViewData.getForum()));
        }
    }

    private float f(ForumData forumData) {
        if (forumData == null || this.iBO == null) {
            return 0.0f;
        }
        return this.iBO.f(forumData);
    }

    public void zk(int i) {
        if (i > 1) {
            if (this.iBG != null) {
                this.iBG.pw(false);
            }
        } else if (this.iBG != null) {
            this.iBG.pw(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void cwP() {
        if (this.icY != null) {
            this.icY.removeCallbacks(this.fNi);
            this.icY.postDelayed(this.fNi, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cwQ() {
        return "frs_page".equals(this.iBJ) || "normal_page".equals(this.iBJ) || "book_page".equals(this.iBJ) || "brand_page".equals(this.iBJ);
    }

    public void m(Integer num) {
        setIsMem(num.intValue());
        if (cwQ()) {
            cwR();
        }
    }

    public void setIsMem(int i) {
        if (this.iBG != null) {
            this.iBG.setMemberType(i);
        }
    }

    public void cwR() {
        if (this.iBG != null) {
            this.iBG.csS();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && cwQ()) {
            a(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void cwS() {
        if (cwQ()) {
            zm(0);
        }
    }

    public void zl(int i) {
        if (cwQ()) {
            zm(i);
        }
    }

    public void zm(int i) {
        if (this.iBG != null) {
            this.iBG.zI(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.iBG != null) {
            this.iBG.a(forumData, frsViewData);
            if (forumData != null) {
                this.iBG.a(i, forumData.getLevelName(), forumData.getUser_level(), f(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.iBG.pn(false);
                }
            }
        }
    }

    public boolean cwT() {
        if (!cwQ() || this.iBG == null) {
            return false;
        }
        return this.iBG.cxU();
    }

    public void cwJ() {
        if (this.iBO != null) {
            this.iBO.cwJ();
        }
    }

    public void O(int i, int i2, int i3) {
        if (this.iBO != null) {
            this.iBO.O(i, i2, i3);
        }
    }

    public void zn(int i) {
        if (cwQ() && this.iBG != null) {
            this.iBG.zJ(i);
        }
    }

    public void k(FrsViewData frsViewData) {
        if (cwQ() && this.iBO != null) {
            this.iBO.a(this.iBG, frsViewData);
        }
    }

    public boolean cwU() {
        if (!cwQ() || this.iBG == null) {
            return false;
        }
        return this.iBG.cwU();
    }

    public boolean cwV() {
        if (!cwQ() || this.iBG == null) {
            return false;
        }
        return this.iBG.cwV();
    }

    public void pm(boolean z) {
        if (this.iBP != null) {
            this.iBP.pm(z);
        }
    }

    public void cwF() {
        if (this.iBP != null) {
            this.iBP.cwF();
        }
    }

    public void Jz(String str) {
        if (this.ivI.cpa() != null && this.ivI.cpa().cvc() != null) {
            com.baidu.tieba.tbadkCore.e.dzD().aW(com.baidu.tieba.tbadkCore.e.dzD().f("1~" + str, this.ivI.cpa().cvc().getSortType(), this.ivI.cpa().cvc().getIsGood(), this.ivI.cpa().cvc().getCategoryId()), false);
        }
    }

    public void csN() {
        if (this.iBG != null) {
            this.iBG.csN();
        }
    }

    public static boolean l(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().bdE(), true) || frsViewData.getBookInfo().bdE().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean m(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().dzQ() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || y.isEmpty(frsViewData.getActivityHeadData().bdC())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().bdu(), true)))) ? false : true;
        }
        return false;
    }

    public void zo(int i) {
        View findViewById;
        if (this.iBG != null && this.iBG.cxW() != null && (findViewById = this.iBG.cxW().findViewById(R.id.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.iBM != null) {
            this.iBM.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.iBN = frsTabViewController;
    }

    public f cwW() {
        return this.iBP;
    }
}
