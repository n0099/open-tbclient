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
    private Runnable gjE;
    private final View.OnClickListener iEe;
    private FrsHeaderViewContainer iEv;
    private FrsFragment iWX;
    private BdUniqueId jcM;
    private com.baidu.tieba.frs.view.b jcS;
    private com.baidu.tieba.frs.entelechy.b.a jcT;
    private boolean jcU;
    private String jcV;
    private boolean jcW;
    private int jcX;
    private com.baidu.tieba.f.a jcY;
    private FrsTabViewController jcZ;
    private g jda;
    private f jdb;
    private final Runnable jdc;
    private int mScrollState;
    private int mSkinType;

    public h(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.jcU = false;
        this.mSkinType = 0;
        this.jcV = "normal_page";
        this.mScrollState = 0;
        this.jcW = false;
        this.jdc = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.1
            @Override // java.lang.Runnable
            public void run() {
                q cvK;
                if (h.this.iWX != null && h.this.mScrollState == 0 && (cvK = h.this.iWX.cvK()) != null && cvK.cwP() != null && !cvK.cwP().cDe() && !cvK.cwp() && h.this.iEv.isShown() && h.this.iWX.isPrimary() && !h.this.jcW && h.this.iWX.cww() && h.this.jcX == 1 && h.this.cDu() && h.this.jcS != null && h.this.jcS.cEz()) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                    h.this.czu();
                    h.this.iWX.iBf = true;
                    h.this.jcW = true;
                }
            }
        };
        this.gjE = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.iEv != null) {
                    int childCount = h.this.iEv.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(h.this.iEv.getChildAt(i));
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
        this.iEe = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.iWX != null) {
                    FrsViewData cwo = h.this.iWX.cwo();
                    if (cwo != null && cwo.getForum() != null && h.this.jcS != null && (view == h.this.jcS.cEB() || view == h.this.jcS.cEC() || view == h.this.jcS.cED())) {
                        if (h.this.iWX != null && cwo.getForum() != null) {
                            TiebaStatic.log(new aq("c12046").dR("fid", cwo.getForum().getId()).aj("obj_locate", h.this.iWX.cwr() ? 1 : 2));
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        if (cwo.getEntelechyTabInfo() != null && cwo.getEntelechyTabInfo().tab != null) {
                            for (int i = 0; i < cwo.getEntelechyTabInfo().tab.size(); i++) {
                                arrayList.add(cwo.getEntelechyTabInfo().tab.get(i).tab_name);
                            }
                        }
                        ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), cwo.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                        forumDetailActivityConfig.setForumTabs(arrayList);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumDetailActivityConfig));
                    }
                    int id = view.getId();
                    if (id == R.id.tv_love) {
                        if (!h.this.iWX.cwp()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.iWX.showToast(R.string.neterror);
                            } else if (!bg.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                TiebaStatic.log(new aq("c10517").aj("obj_locate", 1).dR("fid", h.this.iWX.getForumId()));
                            } else {
                                h.this.qj(true);
                                if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    aq aqVar = new aq("c10048");
                                    aqVar.dR("fid", h.this.iWX.getForumId());
                                    aqVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(aqVar);
                                }
                            }
                        }
                    } else if (id == R.id.tv_sign) {
                        if (!h.this.iWX.cwp()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.iWX.showToast(R.string.neterror);
                            } else if (bg.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                if (!h.this.cDy()) {
                                    h.this.cDn();
                                    aq.BF("c13560").aj("obj_type", 2).boK();
                                } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(h.this.iWX.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(h.this.iWX.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                                }
                            }
                        }
                    } else if (id == R.id.frs_header_games) {
                        if (bg.checkUpIsLogin(h.this.mContext.getPageActivity()) && cwo != null && cwo.getGameUrl() != null) {
                            be.boR().a((TbPageContext) h.this.getPageContext(), new String[]{cwo.getGameUrl()}, true);
                        }
                    } else if (id == R.id.frs_bawu_center) {
                        if (cwo != null && cwo.getUserData() != null && cwo.getUserData().isBawu()) {
                            String bawuCenterUrl = cwo.getBawuCenterUrl();
                            if (!at.isEmpty(bawuCenterUrl)) {
                                com.baidu.tbadk.browser.a.startWebActivity(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (cwo.getForum() != null) {
                                    TiebaStatic.log(new aq("c10502").dR("fid", cwo.getForum().getId()).dR("uid", cwo.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id == R.id.level_container) {
                        if (!h.this.iWX.cwp() && h.this.mScrollState == 0 && h.this.cDu() && h.this.jcS != null) {
                            h.this.jcS.k(view, false);
                        }
                    } else if (id == R.id.frs_hot_rank_entry) {
                        if (cwo != null && cwo.getForum() != null && !TextUtils.isEmpty(cwo.getForum().getId())) {
                            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(h.this.getPageContext().getPageActivity());
                            hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(cwo.getForum().getId(), 0L)));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                            aq aqVar2 = new aq("c13666");
                            aqVar2.dR("fid", cwo.getForum().getId());
                            TiebaStatic.log(aqVar2);
                        }
                    } else if (id == R.id.frs_manager_info_layout) {
                        if (cwo != null && cwo.getForum() != null && !TextUtils.isEmpty(cwo.getForum().getId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumMemberActivityConfig(h.this.getPageContext().getPageActivity(), String.valueOf(cwo.getForum().getId()), cwo.getForum().getName())));
                        }
                    } else if (id == R.id.frs_manager_application_layout && bg.checkUpIsLogin(h.this.mContext.getPageActivity()) && cwo != null && cwo.getForum() != null && !TextUtils.isEmpty(cwo.getForum().getId())) {
                        be.boR().b(h.this.iWX.getTbPageContext(), new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + cwo.getForum().getId()});
                    }
                }
            }
        };
        this.iWX = frsFragment;
        this.jcT = aVar;
        this.iEv = frsHeaderViewContainer;
        this.jcM = BdUniqueId.gen();
        this.jda = new g(this.iWX, this.jcM);
        this.jdb = new f(this.iWX);
        this.jcY = new com.baidu.tieba.f.a();
    }

    public void aq(Bundle bundle) {
        if (this.jda != null) {
            this.jda.registerListener();
        }
        if (this.jdb != null) {
            this.jdb.aJH();
        }
        this.jcW = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void cBk() {
        if (this.jcS != null) {
            this.jcS.onDestory();
        }
        if (this.jdb != null) {
            this.jdb.cBk();
        }
        if (this.jdc != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jdc);
        }
    }

    public void bpO() {
        if (this.jcS != null) {
            this.jcS.onStop();
        }
        if (this.iEv != null) {
            this.iEv.removeCallbacks(this.gjE);
        }
    }

    public void bP(boolean z) {
        if (this.jcS != null) {
            this.jcS.bP(z);
        }
    }

    public boolean Ai(int i) {
        this.mSkinType = i;
        if (this.jcS != null) {
            this.jcS.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void ql(boolean z) {
        if (z) {
            if (this.jcS != null) {
                this.iEv.removeHeaderView(this.jcS.cEA());
                this.jcU = false;
            }
        } else if (this.jcS != null && this.jcS.cEA() != null && !this.jcU) {
            this.iEv.addHeaderView(this.jcS.cEA(), this.iEv.getHeaderViewsCount());
            this.jcU = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            x(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean cDo() {
        return true;
    }

    private void x(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.jcV, str);
        this.jcX = i2;
        this.jcV = str;
        cDr();
        if (this.jcS == null || z) {
            this.jcS = this.jcT.a(str, this.iWX, i);
            this.jcS.changeSkinType(this.mSkinType);
            this.jcS.A(this.iEe);
        }
        if (this.jda != null) {
            this.jcS.f(this.jda);
        }
        if (this.jdb != null) {
            this.jcS.g(this.jdb);
        }
        this.iEv.addHeaderView(this.jcS.getView());
        KK(str);
        cDp();
    }

    private void cDp() {
        com.baidu.adp.lib.f.e.mY().postDelayed(this.jdc, 4000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czu() {
        if (cDu() && this.jcS != null) {
            this.jcS.czu();
        }
    }

    public void cDq() {
        if (!this.jcU && this.jcS != null) {
            this.iEv.addHeaderView(this.jcS.cEA());
            this.jcU = true;
        }
    }

    private void cDr() {
        if (this.jcS != null) {
            this.iEv.removeHeaderView(this.jcS.getView());
            this.iEv.removeHeaderView(this.jcS.cEA());
            cDs();
        }
        this.jcU = false;
    }

    private void cDs() {
        if (this.jcZ != null && this.iWX != null && this.iWX.bqA() != null) {
            this.iWX.bqA().removeHeaderView(this.jcZ.cDJ());
        }
    }

    private void KK(String str) {
        RelativeLayout cDJ;
        if (this.jcZ != null && this.iWX != null && this.iWX.bqA() != null && (cDJ = this.jcZ.cDJ()) != null) {
            if ("brand_page".equals(str)) {
                this.iWX.bqA().removeHeaderView(cDJ);
                return;
            }
            this.iWX.bqA().removeHeaderView(cDJ);
            this.iWX.bqA().addHeaderView(cDJ, 0);
        }
    }

    public void i(FrsViewData frsViewData) {
        if (frsViewData != null && cDu()) {
            b(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.jcV)) {
                this.jcS.czh();
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float f = f(forumData);
            if (this.jcS != null) {
                this.jcS.a(forumData, frsViewData);
                this.jcS.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), f, false);
                this.jcS.a(forumData.getSignData());
            }
        }
    }

    public void j(FrsViewData frsViewData) {
        if (frsViewData != null && this.jcS != null && cDu()) {
            this.jcS.ax(f(frsViewData.getForum()));
        }
    }

    private float f(ForumData forumData) {
        if (forumData == null || this.jda == null) {
            return 0.0f;
        }
        return this.jda.f(forumData);
    }

    public void Aj(int i) {
        if (i > 1) {
            if (this.jcS != null) {
                this.jcS.qt(false);
            }
        } else if (this.jcS != null) {
            this.jcS.qt(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void cDt() {
        if (this.iEv != null) {
            this.iEv.removeCallbacks(this.gjE);
            this.iEv.postDelayed(this.gjE, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cDu() {
        return "frs_page".equals(this.jcV) || "normal_page".equals(this.jcV) || "book_page".equals(this.jcV) || "brand_page".equals(this.jcV);
    }

    public void o(Integer num) {
        setIsMem(num.intValue());
        if (cDu()) {
            cDv();
        }
    }

    public void setIsMem(int i) {
        if (this.jcS != null) {
            this.jcS.setMemberType(i);
        }
    }

    public void cDv() {
        if (this.jcS != null) {
            this.jcS.czw();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && cDu()) {
            a(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void cDw() {
        if (cDu()) {
            Al(0);
        }
    }

    public void Ak(int i) {
        if (cDu()) {
            Al(i);
        }
    }

    public void Al(int i) {
        if (this.jcS != null) {
            this.jcS.AH(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.jcS != null) {
            this.jcS.a(forumData, frsViewData);
            if (forumData != null) {
                this.jcS.a(i, forumData.getLevelName(), forumData.getUser_level(), f(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.jcS.qk(false);
                }
            }
        }
    }

    public boolean cDx() {
        if (!cDu() || this.jcS == null) {
            return false;
        }
        return this.jcS.cEy();
    }

    public void cDn() {
        if (this.jda != null) {
            this.jda.cDn();
        }
    }

    public void Q(int i, int i2, int i3) {
        if (this.jda != null) {
            this.jda.Q(i, i2, i3);
        }
    }

    public void Am(int i) {
        if (cDu() && this.jcS != null) {
            this.jcS.AI(i);
        }
    }

    public void k(FrsViewData frsViewData) {
        if (cDu() && this.jda != null) {
            this.jda.a(this.jcS, frsViewData);
        }
    }

    public boolean cDy() {
        if (!cDu() || this.jcS == null) {
            return false;
        }
        return this.jcS.cDy();
    }

    public boolean cDz() {
        if (!cDu() || this.jcS == null) {
            return false;
        }
        return this.jcS.cDz();
    }

    public void qj(boolean z) {
        if (this.jdb != null) {
            this.jdb.qj(z);
        }
    }

    public void cDj() {
        if (this.jdb != null) {
            this.jdb.cDj();
        }
    }

    public void KL(String str) {
        if (this.iWX.cvF() != null && this.iWX.cvF().cBG() != null) {
            com.baidu.tieba.tbadkCore.e.dGw().bc(com.baidu.tieba.tbadkCore.e.dGw().f("1~" + str, this.iWX.cvF().cBG().getSortType(), this.iWX.cvF().cBG().getIsGood(), this.iWX.cvF().cBG().getCategoryId()), false);
        }
    }

    public void czr() {
        if (this.jcS != null) {
            this.jcS.czr();
        }
    }

    public static boolean l(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().big(), true) || frsViewData.getBookInfo().big().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean m(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().dGJ() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || y.isEmpty(frsViewData.getActivityHeadData().bie())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().bhW(), true)))) ? false : true;
        }
        return false;
    }

    public void An(int i) {
        View findViewById;
        if (this.jcS != null && this.jcS.cEA() != null && (findViewById = this.jcS.cEA().findViewById(R.id.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.jcY != null) {
            this.jcY.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.jcZ = frsTabViewController;
    }

    public f cDA() {
        return this.jdb;
    }
}
