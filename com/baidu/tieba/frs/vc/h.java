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
/* loaded from: classes21.dex */
public class h extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Runnable goY;
    private final View.OnClickListener iKO;
    private FrsHeaderViewContainer iLf;
    private FrsFragment jdH;
    private com.baidu.tieba.frs.view.b jjB;
    private com.baidu.tieba.frs.entelechy.b.a jjC;
    private boolean jjD;
    private String jjE;
    private boolean jjF;
    private int jjG;
    private com.baidu.tieba.g.a jjH;
    private FrsTabViewController jjI;
    private g jjJ;
    private f jjK;
    private final Runnable jjL;
    private BdUniqueId jjv;
    private int mScrollState;
    private int mSkinType;

    public h(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.jjD = false;
        this.mSkinType = 0;
        this.jjE = "normal_page";
        this.mScrollState = 0;
        this.jjF = false;
        this.jjL = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.1
            @Override // java.lang.Runnable
            public void run() {
                q cxO;
                if (h.this.jdH != null && h.this.mScrollState == 0 && (cxO = h.this.jdH.cxO()) != null && cxO.cyT() != null && !cxO.cyT().cFk() && !cxO.cyt() && h.this.iLf.isShown() && h.this.jdH.isPrimary() && !h.this.jjF && h.this.jdH.cyA() && h.this.jjG == 1 && h.this.cFA() && h.this.jjB != null && h.this.jjB.cGF()) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                    h.this.cBy();
                    h.this.jdH.iHQ = true;
                    h.this.jjF = true;
                }
            }
        };
        this.goY = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.iLf != null) {
                    int childCount = h.this.iLf.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(h.this.iLf.getChildAt(i));
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
        this.iKO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.jdH != null) {
                    FrsViewData cys = h.this.jdH.cys();
                    if (cys != null && cys.getForum() != null && h.this.jjB != null && (view == h.this.jjB.cGH() || view == h.this.jjB.cGI() || view == h.this.jjB.cGJ())) {
                        if (h.this.jdH != null && cys.getForum() != null) {
                            TiebaStatic.log(new ar("c12046").dR("fid", cys.getForum().getId()).ak("obj_locate", h.this.jdH.cyv() ? 1 : 2));
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        if (cys.getEntelechyTabInfo() != null && cys.getEntelechyTabInfo().tab != null) {
                            for (int i = 0; i < cys.getEntelechyTabInfo().tab.size(); i++) {
                                arrayList.add(cys.getEntelechyTabInfo().tab.get(i).tab_name);
                            }
                        }
                        ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), cys.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                        forumDetailActivityConfig.setForumTabs(arrayList);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumDetailActivityConfig));
                    }
                    int id = view.getId();
                    if (id == R.id.tv_love) {
                        if (!h.this.jdH.cyt()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.jdH.showToast(R.string.neterror);
                            } else if (!bh.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                TiebaStatic.log(new ar("c10517").ak("obj_locate", 1).dR("fid", h.this.jdH.getForumId()));
                            } else {
                                h.this.qv(true);
                                if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    ar arVar = new ar("c10048");
                                    arVar.dR("fid", h.this.jdH.getForumId());
                                    arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(arVar);
                                }
                            }
                        }
                    } else if (id == R.id.tv_sign) {
                        if (!h.this.jdH.cyt()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.jdH.showToast(R.string.neterror);
                            } else if (bh.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                if (!h.this.cFE()) {
                                    h.this.cFt();
                                    ar.Bs("c13560").ak("obj_type", 2).bqy();
                                } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(h.this.jdH.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(h.this.jdH.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                                }
                            }
                        }
                    } else if (id == R.id.frs_header_games) {
                        if (bh.checkUpIsLogin(h.this.mContext.getPageActivity()) && cys != null && cys.getGameUrl() != null) {
                            bf.bqF().a((TbPageContext) h.this.getPageContext(), new String[]{cys.getGameUrl()}, true);
                        }
                    } else if (id == R.id.frs_bawu_center) {
                        if (cys != null && cys.getUserData() != null && cys.getUserData().isBawu()) {
                            String bawuCenterUrl = cys.getBawuCenterUrl();
                            if (!au.isEmpty(bawuCenterUrl)) {
                                com.baidu.tbadk.browser.a.startWebActivity(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (cys.getForum() != null) {
                                    TiebaStatic.log(new ar("c10502").dR("fid", cys.getForum().getId()).dR("uid", cys.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id == R.id.level_container) {
                        if (!h.this.jdH.cyt() && h.this.mScrollState == 0 && h.this.cFA() && h.this.jjB != null) {
                            h.this.jjB.m(view, false);
                        }
                    } else if (id == R.id.frs_hot_rank_entry) {
                        if (cys != null && cys.getForum() != null && !TextUtils.isEmpty(cys.getForum().getId())) {
                            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(h.this.getPageContext().getPageActivity());
                            hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(cys.getForum().getId(), 0L)));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                            ar arVar2 = new ar("c13666");
                            arVar2.dR("fid", cys.getForum().getId());
                            TiebaStatic.log(arVar2);
                        }
                    } else if (id == R.id.frs_manager_info_layout) {
                        if (cys != null && cys.getForum() != null && !TextUtils.isEmpty(cys.getForum().getId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumMemberActivityConfig(h.this.getPageContext().getPageActivity(), String.valueOf(cys.getForum().getId()), cys.getForum().getName())));
                        }
                    } else if (id == R.id.frs_manager_application_layout && bh.checkUpIsLogin(h.this.mContext.getPageActivity()) && cys != null && cys.getForum() != null && !TextUtils.isEmpty(cys.getForum().getId())) {
                        bf.bqF().b(h.this.jdH.getTbPageContext(), new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + cys.getForum().getId()});
                    }
                }
            }
        };
        this.jdH = frsFragment;
        this.jjC = aVar;
        this.iLf = frsHeaderViewContainer;
        this.jjv = BdUniqueId.gen();
        this.jjJ = new g(this.jdH, this.jjv);
        this.jjK = new f(this.jdH);
        this.jjH = new com.baidu.tieba.g.a();
    }

    public void aq(Bundle bundle) {
        if (this.jjJ != null) {
            this.jjJ.registerListener();
        }
        if (this.jjK != null) {
            this.jjK.aLz();
        }
        this.jjF = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void cDp() {
        if (this.jjB != null) {
            this.jjB.onDestory();
        }
        if (this.jjK != null) {
            this.jjK.cDp();
        }
        if (this.jjL != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jjL);
        }
    }

    public void brC() {
        if (this.jjB != null) {
            this.jjB.onStop();
        }
        if (this.iLf != null) {
            this.iLf.removeCallbacks(this.goY);
        }
    }

    public void bS(boolean z) {
        if (this.jjB != null) {
            this.jjB.bS(z);
        }
    }

    public boolean AT(int i) {
        this.mSkinType = i;
        if (this.jjB != null) {
            this.jjB.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void qx(boolean z) {
        if (z) {
            if (this.jjB != null) {
                this.iLf.removeHeaderView(this.jjB.cGG());
                this.jjD = false;
            }
        } else if (this.jjB != null && this.jjB.cGG() != null && !this.jjD) {
            this.iLf.addHeaderView(this.jjB.cGG(), this.iLf.getHeaderViewsCount());
            this.jjD = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            x(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean cFu() {
        return true;
    }

    private void x(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.jjE, str);
        this.jjG = i2;
        this.jjE = str;
        cFx();
        if (this.jjB == null || z) {
            this.jjB = this.jjC.a(str, this.jdH, i);
            this.jjB.changeSkinType(this.mSkinType);
            this.jjB.B(this.iKO);
        }
        if (this.jjJ != null) {
            this.jjB.f(this.jjJ);
        }
        if (this.jjK != null) {
            this.jjB.g(this.jjK);
        }
        this.iLf.addHeaderView(this.jjB.getView());
        KC(str);
        cFv();
    }

    private void cFv() {
        com.baidu.adp.lib.f.e.mY().postDelayed(this.jjL, 4000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBy() {
        if (cFA() && this.jjB != null) {
            this.jjB.cBy();
        }
    }

    public void cFw() {
        if (!this.jjD && this.jjB != null) {
            this.iLf.addHeaderView(this.jjB.cGG());
            this.jjD = true;
        }
    }

    private void cFx() {
        if (this.jjB != null) {
            this.iLf.removeHeaderView(this.jjB.getView());
            this.iLf.removeHeaderView(this.jjB.cGG());
            cFy();
        }
        this.jjD = false;
    }

    private void cFy() {
        if (this.jjI != null && this.jdH != null && this.jdH.bsq() != null) {
            this.jdH.bsq().removeHeaderView(this.jjI.cFP());
        }
    }

    private void KC(String str) {
        RelativeLayout cFP;
        if (this.jjI != null && this.jdH != null && this.jdH.bsq() != null && (cFP = this.jjI.cFP()) != null) {
            if ("brand_page".equals(str)) {
                this.jdH.bsq().removeHeaderView(cFP);
                return;
            }
            this.jdH.bsq().removeHeaderView(cFP);
            this.jdH.bsq().addHeaderView(cFP, 0);
        }
    }

    public void j(FrsViewData frsViewData) {
        if (frsViewData != null && cFA()) {
            b(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.jjE)) {
                this.jjB.cBl();
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float f = f(forumData);
            if (this.jjB != null) {
                this.jjB.a(forumData, frsViewData);
                this.jjB.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), f, false);
                this.jjB.a(forumData.getSignData());
            }
        }
    }

    public void k(FrsViewData frsViewData) {
        if (frsViewData != null && this.jjB != null && cFA()) {
            this.jjB.aG(f(frsViewData.getForum()));
        }
    }

    private float f(ForumData forumData) {
        if (forumData == null || this.jjJ == null) {
            return 0.0f;
        }
        return this.jjJ.f(forumData);
    }

    public void AU(int i) {
        if (i > 1) {
            if (this.jjB != null) {
                this.jjB.qF(false);
            }
        } else if (this.jjB != null) {
            this.jjB.qF(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void cFz() {
        if (this.iLf != null) {
            this.iLf.removeCallbacks(this.goY);
            this.iLf.postDelayed(this.goY, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cFA() {
        return "frs_page".equals(this.jjE) || "normal_page".equals(this.jjE) || "book_page".equals(this.jjE) || "brand_page".equals(this.jjE);
    }

    public void o(Integer num) {
        setIsMem(num.intValue());
        if (cFA()) {
            cFB();
        }
    }

    public void setIsMem(int i) {
        if (this.jjB != null) {
            this.jjB.setMemberType(i);
        }
    }

    public void cFB() {
        if (this.jjB != null) {
            this.jjB.cBA();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && cFA()) {
            a(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void cFC() {
        if (cFA()) {
            AW(0);
        }
    }

    public void AV(int i) {
        if (cFA()) {
            AW(i);
        }
    }

    public void AW(int i) {
        if (this.jjB != null) {
            this.jjB.Bs(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.jjB != null) {
            this.jjB.a(forumData, frsViewData);
            if (forumData != null) {
                this.jjB.a(i, forumData.getLevelName(), forumData.getUser_level(), f(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.jjB.qw(false);
                }
            }
        }
    }

    public boolean cFD() {
        if (!cFA() || this.jjB == null) {
            return false;
        }
        return this.jjB.cGE();
    }

    public void cFt() {
        if (this.jjJ != null) {
            this.jjJ.cFt();
        }
    }

    public void S(int i, int i2, int i3) {
        if (this.jjJ != null) {
            this.jjJ.S(i, i2, i3);
        }
    }

    public void AX(int i) {
        if (cFA() && this.jjB != null) {
            this.jjB.Bt(i);
        }
    }

    public void l(FrsViewData frsViewData) {
        if (cFA() && this.jjJ != null) {
            this.jjJ.a(this.jjB, frsViewData);
        }
    }

    public boolean cFE() {
        if (!cFA() || this.jjB == null) {
            return false;
        }
        return this.jjB.cFE();
    }

    public boolean cFF() {
        if (!cFA() || this.jjB == null) {
            return false;
        }
        return this.jjB.cFF();
    }

    public void qv(boolean z) {
        if (this.jjK != null) {
            this.jjK.qv(z);
        }
    }

    public void cFp() {
        if (this.jjK != null) {
            this.jjK.cFp();
        }
    }

    public void KD(String str) {
        if (this.jdH.cxJ() != null && this.jdH.cxJ().cDL() != null) {
            com.baidu.tieba.tbadkCore.e.dIP().bc(com.baidu.tieba.tbadkCore.e.dIP().f("1~" + str, this.jdH.cxJ().cDL().getSortType(), this.jdH.cxJ().cDL().getIsGood(), this.jdH.cxJ().cDL().getCategoryId()), false);
        }
    }

    public void cBv() {
        if (this.jjB != null) {
            this.jjB.cBv();
        }
    }

    public static boolean m(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().bjI(), true) || frsViewData.getBookInfo().bjI().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean n(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().dJc() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || y.isEmpty(frsViewData.getActivityHeadData().bjG())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().bjy(), true)))) ? false : true;
        }
        return false;
    }

    public void AY(int i) {
        View findViewById;
        if (this.jjB != null && this.jjB.cGG() != null && (findViewById = this.jjB.cGG().findViewById(R.id.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.jjH != null) {
            this.jjH.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.jjI = frsTabViewController;
    }

    public f cFG() {
        return this.jjK;
    }
}
