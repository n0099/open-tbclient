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
/* loaded from: classes16.dex */
public class h extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Runnable fJQ;
    private final View.OnClickListener hVB;
    private FrsHeaderViewContainer hVS;
    private FrsFragment iom;
    private BdUniqueId itY;
    private com.baidu.tieba.frs.view.b iue;
    private com.baidu.tieba.frs.entelechy.b.a iuf;
    private boolean iug;
    private String iuh;
    private boolean iui;
    private int iuj;
    private com.baidu.tieba.f.a iuk;
    private FrsTabViewController iul;
    private g ium;
    private f iun;
    private final Runnable iuo;
    private int mScrollState;
    private int mSkinType;

    public h(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.iug = false;
        this.mSkinType = 0;
        this.iuh = "normal_page";
        this.mScrollState = 0;
        this.iui = false;
        this.iuo = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.1
            @Override // java.lang.Runnable
            public void run() {
                q clS;
                if (h.this.iom != null && h.this.mScrollState == 0 && (clS = h.this.iom.clS()) != null && clS.cmX() != null && !clS.cmX().cti() && !clS.cmx() && h.this.hVS.isShown() && h.this.iom.isPrimary() && !h.this.iui && h.this.iom.cmE() && h.this.iuj == 1 && h.this.cty() && h.this.iue != null && h.this.iue.cuB()) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                    h.this.cpC();
                    h.this.iom.hSC = true;
                    h.this.iui = true;
                }
            }
        };
        this.fJQ = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.hVS != null) {
                    int childCount = h.this.hVS.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(h.this.hVS.getChildAt(i));
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
        this.hVB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.iom != null) {
                    FrsViewData cmw = h.this.iom.cmw();
                    if (cmw != null && cmw.getForum() != null && h.this.iue != null && (view == h.this.iue.cuD() || view == h.this.iue.cuE() || view == h.this.iue.cuF())) {
                        if (h.this.iom != null && cmw.getForum() != null) {
                            TiebaStatic.log(new aq("c12046").dD("fid", cmw.getForum().getId()).ai("obj_locate", h.this.iom.cmz() ? 1 : 2));
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        if (cmw.getEntelechyTabInfo() != null && cmw.getEntelechyTabInfo().tab != null) {
                            for (int i = 0; i < cmw.getEntelechyTabInfo().tab.size(); i++) {
                                arrayList.add(cmw.getEntelechyTabInfo().tab.get(i).tab_name);
                            }
                        }
                        ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), cmw.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                        forumDetailActivityConfig.setForumTabs(arrayList);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumDetailActivityConfig));
                    }
                    int id = view.getId();
                    if (id == R.id.tv_love) {
                        if (!h.this.iom.cmx()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.iom.showToast(R.string.neterror);
                            } else if (!bg.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                TiebaStatic.log(new aq("c10517").ai("obj_locate", 1).dD("fid", h.this.iom.getForumId()));
                            } else {
                                h.this.pe(true);
                                if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    aq aqVar = new aq("c10048");
                                    aqVar.dD("fid", h.this.iom.getForumId());
                                    aqVar.dD("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(aqVar);
                                }
                            }
                        }
                    } else if (id == R.id.tv_sign) {
                        if (!h.this.iom.cmx()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.iom.showToast(R.string.neterror);
                            } else if (bg.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                if (!h.this.ctC()) {
                                    h.this.ctr();
                                    aq.Ad("c13560").ai("obj_type", 2).bjn();
                                } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(h.this.iom.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(h.this.iom.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                                }
                            }
                        }
                    } else if (id == R.id.frs_header_games) {
                        if (bg.checkUpIsLogin(h.this.mContext.getPageActivity()) && cmw != null && cmw.getGameUrl() != null) {
                            be.bju().a((TbPageContext) h.this.getPageContext(), new String[]{cmw.getGameUrl()}, true);
                        }
                    } else if (id == R.id.frs_bawu_center) {
                        if (cmw != null && cmw.getUserData() != null && cmw.getUserData().isBawu()) {
                            String bawuCenterUrl = cmw.getBawuCenterUrl();
                            if (!at.isEmpty(bawuCenterUrl)) {
                                com.baidu.tbadk.browser.a.startWebActivity(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (cmw.getForum() != null) {
                                    TiebaStatic.log(new aq("c10502").dD("fid", cmw.getForum().getId()).dD("uid", cmw.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id == R.id.level_container) {
                        if (!h.this.iom.cmx() && h.this.mScrollState == 0 && h.this.cty() && h.this.iue != null) {
                            h.this.iue.k(view, false);
                        }
                    } else if (id == R.id.frs_hot_rank_entry) {
                        if (cmw != null && cmw.getForum() != null && !TextUtils.isEmpty(cmw.getForum().getId())) {
                            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(h.this.getPageContext().getPageActivity());
                            hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(cmw.getForum().getId(), 0L)));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                            aq aqVar2 = new aq("c13666");
                            aqVar2.dD("fid", cmw.getForum().getId());
                            TiebaStatic.log(aqVar2);
                        }
                    } else if (id == R.id.frs_manager_info_layout) {
                        if (cmw != null && cmw.getForum() != null && !TextUtils.isEmpty(cmw.getForum().getId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumMemberActivityConfig(h.this.getPageContext().getPageActivity(), String.valueOf(cmw.getForum().getId()), cmw.getForum().getName())));
                        }
                    } else if (id == R.id.frs_manager_application_layout && bg.checkUpIsLogin(h.this.mContext.getPageActivity()) && cmw != null && cmw.getForum() != null && !TextUtils.isEmpty(cmw.getForum().getId())) {
                        be.bju().b(h.this.iom.getTbPageContext(), new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + cmw.getForum().getId()});
                    }
                }
            }
        };
        this.iom = frsFragment;
        this.iuf = aVar;
        this.hVS = frsHeaderViewContainer;
        this.itY = BdUniqueId.gen();
        this.ium = new g(this.iom, this.itY);
        this.iun = new f(this.iom);
        this.iuk = new com.baidu.tieba.f.a();
    }

    public void aq(Bundle bundle) {
        if (this.ium != null) {
            this.ium.registerListener();
        }
        if (this.iun != null) {
            this.iun.aEu();
        }
        this.iui = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void crq() {
        if (this.iue != null) {
            this.iue.onDestory();
        }
        if (this.iun != null) {
            this.iun.crq();
        }
        if (this.iuo != null) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.iuo);
        }
    }

    public void bkq() {
        if (this.iue != null) {
            this.iue.onStop();
        }
        if (this.hVS != null) {
            this.hVS.removeCallbacks(this.fJQ);
        }
    }

    public void bJ(boolean z) {
        if (this.iue != null) {
            this.iue.bJ(z);
        }
    }

    public boolean yK(int i) {
        this.mSkinType = i;
        if (this.iue != null) {
            this.iue.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void pg(boolean z) {
        if (z) {
            if (this.iue != null) {
                this.hVS.removeHeaderView(this.iue.cuC());
                this.iug = false;
            }
        } else if (this.iue != null && this.iue.cuC() != null && !this.iug) {
            this.hVS.addHeaderView(this.iue.cuC(), this.hVS.getHeaderViewsCount());
            this.iug = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            v(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean cts() {
        return true;
    }

    private void v(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.iuh, str);
        this.iuj = i2;
        this.iuh = str;
        ctv();
        if (this.iue == null || z) {
            this.iue = this.iuf.a(str, this.iom, i);
            this.iue.changeSkinType(this.mSkinType);
            this.iue.A(this.hVB);
        }
        if (this.ium != null) {
            this.iue.f(this.ium);
        }
        if (this.iun != null) {
            this.iue.g(this.iun);
        }
        this.hVS.addHeaderView(this.iue.getView());
        IZ(str);
        ctt();
    }

    private void ctt() {
        com.baidu.adp.lib.f.e.mS().postDelayed(this.iuo, 4000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpC() {
        if (cty() && this.iue != null) {
            this.iue.cpC();
        }
    }

    public void ctu() {
        if (!this.iug && this.iue != null) {
            this.hVS.addHeaderView(this.iue.cuC());
            this.iug = true;
        }
    }

    private void ctv() {
        if (this.iue != null) {
            this.hVS.removeHeaderView(this.iue.getView());
            this.hVS.removeHeaderView(this.iue.cuC());
            ctw();
        }
        this.iug = false;
    }

    private void ctw() {
        if (this.iul != null && this.iom != null && this.iom.blc() != null) {
            this.iom.blc().removeHeaderView(this.iul.ctL());
        }
    }

    private void IZ(String str) {
        RelativeLayout ctL;
        if (this.iul != null && this.iom != null && this.iom.blc() != null && (ctL = this.iul.ctL()) != null) {
            if ("brand_page".equals(str)) {
                this.iom.blc().removeHeaderView(ctL);
                return;
            }
            this.iom.blc().removeHeaderView(ctL);
            this.iom.blc().addHeaderView(ctL, 0);
        }
    }

    public void i(FrsViewData frsViewData) {
        if (frsViewData != null && cty()) {
            b(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.iuh)) {
                this.iue.cpp();
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float d = d(forumData);
            if (this.iue != null) {
                this.iue.a(forumData, frsViewData);
                this.iue.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), d, false);
                this.iue.a(forumData.getSignData());
            }
        }
    }

    public void j(FrsViewData frsViewData) {
        if (frsViewData != null && this.iue != null && cty()) {
            this.iue.ap(d(frsViewData.getForum()));
        }
    }

    private float d(ForumData forumData) {
        if (forumData == null || this.ium == null) {
            return 0.0f;
        }
        return this.ium.d(forumData);
    }

    public void yL(int i) {
        if (i > 1) {
            if (this.iue != null) {
                this.iue.po(false);
            }
        } else if (this.iue != null) {
            this.iue.po(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void ctx() {
        if (this.hVS != null) {
            this.hVS.removeCallbacks(this.fJQ);
            this.hVS.postDelayed(this.fJQ, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cty() {
        return "frs_page".equals(this.iuh) || "normal_page".equals(this.iuh) || "book_page".equals(this.iuh) || "brand_page".equals(this.iuh);
    }

    public void m(Integer num) {
        setIsMem(num.intValue());
        if (cty()) {
            ctz();
        }
    }

    public void setIsMem(int i) {
        if (this.iue != null) {
            this.iue.setMemberType(i);
        }
    }

    public void ctz() {
        if (this.iue != null) {
            this.iue.cpE();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && cty()) {
            a(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void ctA() {
        if (cty()) {
            yN(0);
        }
    }

    public void yM(int i) {
        if (cty()) {
            yN(i);
        }
    }

    public void yN(int i) {
        if (this.iue != null) {
            this.iue.zk(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.iue != null) {
            this.iue.a(forumData, frsViewData);
            if (forumData != null) {
                this.iue.a(i, forumData.getLevelName(), forumData.getUser_level(), d(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.iue.pf(false);
                }
            }
        }
    }

    public boolean ctB() {
        if (!cty() || this.iue == null) {
            return false;
        }
        return this.iue.cuA();
    }

    public void ctr() {
        if (this.ium != null) {
            this.ium.ctr();
        }
    }

    public void M(int i, int i2, int i3) {
        if (this.ium != null) {
            this.ium.M(i, i2, i3);
        }
    }

    public void yO(int i) {
        if (cty() && this.iue != null) {
            this.iue.zl(i);
        }
    }

    public void k(FrsViewData frsViewData) {
        if (cty() && this.ium != null) {
            this.ium.a(this.iue, frsViewData);
        }
    }

    public boolean ctC() {
        if (!cty() || this.iue == null) {
            return false;
        }
        return this.iue.ctC();
    }

    public boolean ctD() {
        if (!cty() || this.iue == null) {
            return false;
        }
        return this.iue.ctD();
    }

    public void pe(boolean z) {
        if (this.iun != null) {
            this.iun.pe(z);
        }
    }

    public void ctn() {
        if (this.iun != null) {
            this.iun.ctn();
        }
    }

    public void Ja(String str) {
        if (this.iom.clN() != null && this.iom.clN().crM() != null) {
            com.baidu.tieba.tbadkCore.e.dvF().aW(com.baidu.tieba.tbadkCore.e.dvF().f("1~" + str, this.iom.clN().crM().getSortType(), this.iom.clN().crM().getIsGood(), this.iom.clN().crM().getCategoryId()), false);
        }
    }

    public void cpz() {
        if (this.iue != null) {
            this.iue.cpz();
        }
    }

    public static boolean l(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().bcK(), true) || frsViewData.getBookInfo().bcK().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean m(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().dvS() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || y.isEmpty(frsViewData.getActivityHeadData().bcI())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().bcA(), true)))) ? false : true;
        }
        return false;
    }

    public void yP(int i) {
        View findViewById;
        if (this.iue != null && this.iue.cuC() != null && (findViewById = this.iue.cuC().findViewById(R.id.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.iuk != null) {
            this.iuk.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.iul = frsTabViewController;
    }
}
