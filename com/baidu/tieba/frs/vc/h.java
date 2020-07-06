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
                p bYa;
                if (h.this.hUd != null && h.this.mScrollState == 0 && (bYa = h.this.hUd.bYa()) != null && bYa.bZd() != null && !bYa.bZd().cff() && !bYa.bYD() && h.this.hCE.isShown() && h.this.hUd.isPrimary() && !h.this.iaa && h.this.hUd.bYK() && h.this.iab == 1 && h.this.cfv() && h.this.hZW != null && h.this.hZW.cgy()) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                    h.this.cbA();
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
                    FrsViewData bYC = h.this.hUd.bYC();
                    if (bYC != null && bYC.getForum() != null && h.this.hZW != null && (view == h.this.hZW.cgA() || view == h.this.hZW.cgB() || view == h.this.hZW.cgC())) {
                        if (h.this.hUd != null && bYC.getForum() != null) {
                            TiebaStatic.log(new ao("c12046").dk("fid", bYC.getForum().getId()).ag("obj_locate", h.this.hUd.bYF() ? 1 : 2));
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        if (bYC.getEntelechyTabInfo() != null && bYC.getEntelechyTabInfo().tab != null) {
                            for (int i = 0; i < bYC.getEntelechyTabInfo().tab.size(); i++) {
                                arrayList.add(bYC.getEntelechyTabInfo().tab.get(i).tab_name);
                            }
                        }
                        ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), bYC.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                        forumDetailActivityConfig.setForumTabs(arrayList);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumDetailActivityConfig));
                    }
                    int id = view.getId();
                    if (id == R.id.tv_love) {
                        if (!h.this.hUd.bYD()) {
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
                        if (!h.this.hUd.bYD()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.hUd.showToast(R.string.neterror);
                            } else if (be.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                if (!h.this.cfz()) {
                                    h.this.cfo();
                                    ao.wH("c13560").ag("obj_type", 2).aWN();
                                } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(h.this.hUd.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(h.this.hUd.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                                }
                            }
                        }
                    } else if (id == R.id.frs_header_games) {
                        if (be.checkUpIsLogin(h.this.mContext.getPageActivity()) && bYC != null && bYC.getGameUrl() != null) {
                            bc.aWU().a((TbPageContext) h.this.getPageContext(), new String[]{bYC.getGameUrl()}, true);
                        }
                    } else if (id == R.id.frs_bawu_center) {
                        if (bYC != null && bYC.getUserData() != null && bYC.getUserData().isBawu()) {
                            String bawuCenterUrl = bYC.getBawuCenterUrl();
                            if (!ar.isEmpty(bawuCenterUrl)) {
                                com.baidu.tbadk.browser.a.startWebActivity(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (bYC.getForum() != null) {
                                    TiebaStatic.log(new ao("c10502").dk("fid", bYC.getForum().getId()).dk("uid", bYC.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id == R.id.level_container) {
                        if (!h.this.hUd.bYD() && h.this.mScrollState == 0 && h.this.cfv() && h.this.hZW != null) {
                            h.this.hZW.l(view, false);
                        }
                    } else if (id == R.id.frs_hot_rank_entry) {
                        if (bYC != null && bYC.getForum() != null && !TextUtils.isEmpty(bYC.getForum().getId())) {
                            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(h.this.getPageContext().getPageActivity());
                            hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(bYC.getForum().getId(), 0L)));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                            ao aoVar2 = new ao("c13666");
                            aoVar2.dk("fid", bYC.getForum().getId());
                            TiebaStatic.log(aoVar2);
                        }
                    } else if (id == R.id.frs_manager_info_layout) {
                        if (bYC != null && bYC.getForum() != null && !TextUtils.isEmpty(bYC.getForum().getId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumMemberActivityConfig(h.this.getPageContext().getPageActivity(), String.valueOf(bYC.getForum().getId()), bYC.getForum().getName())));
                        }
                    } else if (id == R.id.frs_manager_application_layout && be.checkUpIsLogin(h.this.mContext.getPageActivity()) && bYC != null && bYC.getForum() != null && !TextUtils.isEmpty(bYC.getForum().getId())) {
                        bc.aWU().b(h.this.hUd.getTbPageContext(), new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + bYC.getForum().getId()});
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

    public void cdm() {
        if (this.hZW != null) {
            this.hZW.onDestory();
        }
        if (this.iaf != null) {
            this.iaf.cdm();
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
                this.hCE.removeHeaderView(this.hZW.cgz());
                this.hZY = false;
            }
        } else if (this.hZW != null && this.hZW.cgz() != null && !this.hZY) {
            this.hCE.addHeaderView(this.hZW.cgz(), this.hCE.getHeaderViewsCount());
            this.hZY = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            w(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean cfp() {
        return true;
    }

    private void w(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.hZZ, str);
        this.iab = i2;
        this.hZZ = str;
        cfs();
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
        cfq();
    }

    private void cfq() {
        com.baidu.adp.lib.f.e.lt().postDelayed(this.iag, 4000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbA() {
        if (cfv() && this.hZW != null) {
            this.hZW.cbA();
        }
    }

    public void cfr() {
        if (!this.hZY && this.hZW != null) {
            this.hCE.addHeaderView(this.hZW.cgz());
            this.hZY = true;
        }
    }

    private void cfs() {
        if (this.hZW != null) {
            this.hCE.removeHeaderView(this.hZW.getView());
            this.hCE.removeHeaderView(this.hZW.cgz());
            cft();
        }
        this.hZY = false;
    }

    private void cft() {
        if (this.iad != null && this.hUd != null && this.hUd.aYH() != null) {
            this.hUd.aYH().removeHeaderView(this.iad.cfI());
        }
    }

    private void FL(String str) {
        RelativeLayout cfI;
        if (this.iad != null && this.hUd != null && this.hUd.aYH() != null && (cfI = this.iad.cfI()) != null) {
            if ("brand_page".equals(str)) {
                this.hUd.aYH().removeHeaderView(cfI);
                return;
            }
            this.hUd.aYH().removeHeaderView(cfI);
            this.hUd.aYH().addHeaderView(cfI, 0);
        }
    }

    public void i(FrsViewData frsViewData) {
        if (frsViewData != null && cfv()) {
            b(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.hZZ)) {
                this.hZW.cbn();
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
        if (frsViewData != null && this.hZW != null && cfv()) {
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

    public void cfu() {
        if (this.hCE != null) {
            this.hCE.removeCallbacks(this.ftq);
            this.hCE.postDelayed(this.ftq, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cfv() {
        return "frs_page".equals(this.hZZ) || "normal_page".equals(this.hZZ) || "book_page".equals(this.hZZ) || "brand_page".equals(this.hZZ);
    }

    public void l(Integer num) {
        setIsMem(num.intValue());
        if (cfv()) {
            cfw();
        }
    }

    public void setIsMem(int i) {
        if (this.hZW != null) {
            this.hZW.setMemberType(i);
        }
    }

    public void cfw() {
        if (this.hZW != null) {
            this.hZW.cbC();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && cfv()) {
            a(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void cfx() {
        if (cfv()) {
            wc(0);
        }
    }

    public void wb(int i) {
        if (cfv()) {
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

    public boolean cfy() {
        if (!cfv() || this.hZW == null) {
            return false;
        }
        return this.hZW.cgx();
    }

    public void cfo() {
        if (this.iae != null) {
            this.iae.cfo();
        }
    }

    public void O(int i, int i2, int i3) {
        if (this.iae != null) {
            this.iae.O(i, i2, i3);
        }
    }

    public void wd(int i) {
        if (cfv() && this.hZW != null) {
            this.hZW.wz(i);
        }
    }

    public void k(FrsViewData frsViewData) {
        if (cfv() && this.iae != null) {
            this.iae.a(this.hZW, frsViewData);
        }
    }

    public boolean cfz() {
        if (!cfv() || this.hZW == null) {
            return false;
        }
        return this.hZW.cfz();
    }

    public boolean cfA() {
        if (!cfv() || this.hZW == null) {
            return false;
        }
        return this.hZW.cfA();
    }

    public void nV(boolean z) {
        if (this.iaf != null) {
            this.iaf.nV(z);
        }
    }

    public void cfk() {
        if (this.iaf != null) {
            this.iaf.cfk();
        }
    }

    public void FM(String str) {
        if (this.hUd.bXV() != null && this.hUd.bXV().cdI() != null) {
            com.baidu.tieba.tbadkCore.e.dgZ().aV(com.baidu.tieba.tbadkCore.e.dgZ().e("1~" + str, this.hUd.bXV().cdI().getSortType(), this.hUd.bXV().cdI().getIsGood(), this.hUd.bXV().cdI().getCategoryId()), false);
        }
    }

    public void cbx() {
        if (this.hZW != null) {
            this.hZW.cbx();
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
            return ((frsViewData.getStar() == null || frsViewData.getStar().dhm() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || w.isEmpty(frsViewData.getActivityHeadData().aQt())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().aQl(), true)))) ? false : true;
        }
        return false;
    }

    public void we(int i) {
        View findViewById;
        if (this.hZW != null && this.hZW.cgz() != null && (findViewById = this.hZW.cgz().findViewById(R.id.divider_bottom)) != null) {
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
