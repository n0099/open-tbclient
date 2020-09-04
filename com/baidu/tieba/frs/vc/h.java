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
    private Runnable fJU;
    private final View.OnClickListener hVH;
    private FrsHeaderViewContainer hVY;
    private FrsFragment ios;
    private BdUniqueId iue;
    private com.baidu.tieba.frs.view.b iuk;
    private com.baidu.tieba.frs.entelechy.b.a iul;
    private boolean ium;
    private String iun;
    private boolean iuo;
    private int iup;
    private com.baidu.tieba.f.a iuq;
    private FrsTabViewController iur;
    private g ius;
    private f iut;
    private final Runnable iuu;
    private int mScrollState;
    private int mSkinType;

    public h(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.ium = false;
        this.mSkinType = 0;
        this.iun = "normal_page";
        this.mScrollState = 0;
        this.iuo = false;
        this.iuu = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.1
            @Override // java.lang.Runnable
            public void run() {
                q clT;
                if (h.this.ios != null && h.this.mScrollState == 0 && (clT = h.this.ios.clT()) != null && clT.cmY() != null && !clT.cmY().ctj() && !clT.cmy() && h.this.hVY.isShown() && h.this.ios.isPrimary() && !h.this.iuo && h.this.ios.cmF() && h.this.iup == 1 && h.this.ctz() && h.this.iuk != null && h.this.iuk.cuC()) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                    h.this.cpD();
                    h.this.ios.hSI = true;
                    h.this.iuo = true;
                }
            }
        };
        this.fJU = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.hVY != null) {
                    int childCount = h.this.hVY.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(h.this.hVY.getChildAt(i));
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
        this.hVH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.ios != null) {
                    FrsViewData cmx = h.this.ios.cmx();
                    if (cmx != null && cmx.getForum() != null && h.this.iuk != null && (view == h.this.iuk.cuE() || view == h.this.iuk.cuF() || view == h.this.iuk.cuG())) {
                        if (h.this.ios != null && cmx.getForum() != null) {
                            TiebaStatic.log(new aq("c12046").dD("fid", cmx.getForum().getId()).ai("obj_locate", h.this.ios.cmA() ? 1 : 2));
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        if (cmx.getEntelechyTabInfo() != null && cmx.getEntelechyTabInfo().tab != null) {
                            for (int i = 0; i < cmx.getEntelechyTabInfo().tab.size(); i++) {
                                arrayList.add(cmx.getEntelechyTabInfo().tab.get(i).tab_name);
                            }
                        }
                        ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), cmx.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                        forumDetailActivityConfig.setForumTabs(arrayList);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumDetailActivityConfig));
                    }
                    int id = view.getId();
                    if (id == R.id.tv_love) {
                        if (!h.this.ios.cmy()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.ios.showToast(R.string.neterror);
                            } else if (!bg.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                TiebaStatic.log(new aq("c10517").ai("obj_locate", 1).dD("fid", h.this.ios.getForumId()));
                            } else {
                                h.this.pg(true);
                                if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    aq aqVar = new aq("c10048");
                                    aqVar.dD("fid", h.this.ios.getForumId());
                                    aqVar.dD("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(aqVar);
                                }
                            }
                        }
                    } else if (id == R.id.tv_sign) {
                        if (!h.this.ios.cmy()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.ios.showToast(R.string.neterror);
                            } else if (bg.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                if (!h.this.ctD()) {
                                    h.this.cts();
                                    aq.Ae("c13560").ai("obj_type", 2).bjn();
                                } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(h.this.ios.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(h.this.ios.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                                }
                            }
                        }
                    } else if (id == R.id.frs_header_games) {
                        if (bg.checkUpIsLogin(h.this.mContext.getPageActivity()) && cmx != null && cmx.getGameUrl() != null) {
                            be.bju().a((TbPageContext) h.this.getPageContext(), new String[]{cmx.getGameUrl()}, true);
                        }
                    } else if (id == R.id.frs_bawu_center) {
                        if (cmx != null && cmx.getUserData() != null && cmx.getUserData().isBawu()) {
                            String bawuCenterUrl = cmx.getBawuCenterUrl();
                            if (!at.isEmpty(bawuCenterUrl)) {
                                com.baidu.tbadk.browser.a.startWebActivity(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (cmx.getForum() != null) {
                                    TiebaStatic.log(new aq("c10502").dD("fid", cmx.getForum().getId()).dD("uid", cmx.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id == R.id.level_container) {
                        if (!h.this.ios.cmy() && h.this.mScrollState == 0 && h.this.ctz() && h.this.iuk != null) {
                            h.this.iuk.k(view, false);
                        }
                    } else if (id == R.id.frs_hot_rank_entry) {
                        if (cmx != null && cmx.getForum() != null && !TextUtils.isEmpty(cmx.getForum().getId())) {
                            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(h.this.getPageContext().getPageActivity());
                            hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(cmx.getForum().getId(), 0L)));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                            aq aqVar2 = new aq("c13666");
                            aqVar2.dD("fid", cmx.getForum().getId());
                            TiebaStatic.log(aqVar2);
                        }
                    } else if (id == R.id.frs_manager_info_layout) {
                        if (cmx != null && cmx.getForum() != null && !TextUtils.isEmpty(cmx.getForum().getId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumMemberActivityConfig(h.this.getPageContext().getPageActivity(), String.valueOf(cmx.getForum().getId()), cmx.getForum().getName())));
                        }
                    } else if (id == R.id.frs_manager_application_layout && bg.checkUpIsLogin(h.this.mContext.getPageActivity()) && cmx != null && cmx.getForum() != null && !TextUtils.isEmpty(cmx.getForum().getId())) {
                        be.bju().b(h.this.ios.getTbPageContext(), new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + cmx.getForum().getId()});
                    }
                }
            }
        };
        this.ios = frsFragment;
        this.iul = aVar;
        this.hVY = frsHeaderViewContainer;
        this.iue = BdUniqueId.gen();
        this.ius = new g(this.ios, this.iue);
        this.iut = new f(this.ios);
        this.iuq = new com.baidu.tieba.f.a();
    }

    public void aq(Bundle bundle) {
        if (this.ius != null) {
            this.ius.registerListener();
        }
        if (this.iut != null) {
            this.iut.aEu();
        }
        this.iuo = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void crr() {
        if (this.iuk != null) {
            this.iuk.onDestory();
        }
        if (this.iut != null) {
            this.iut.crr();
        }
        if (this.iuu != null) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.iuu);
        }
    }

    public void bkq() {
        if (this.iuk != null) {
            this.iuk.onStop();
        }
        if (this.hVY != null) {
            this.hVY.removeCallbacks(this.fJU);
        }
    }

    public void bJ(boolean z) {
        if (this.iuk != null) {
            this.iuk.bJ(z);
        }
    }

    public boolean yK(int i) {
        this.mSkinType = i;
        if (this.iuk != null) {
            this.iuk.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void pi(boolean z) {
        if (z) {
            if (this.iuk != null) {
                this.hVY.removeHeaderView(this.iuk.cuD());
                this.ium = false;
            }
        } else if (this.iuk != null && this.iuk.cuD() != null && !this.ium) {
            this.hVY.addHeaderView(this.iuk.cuD(), this.hVY.getHeaderViewsCount());
            this.ium = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            v(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean ctt() {
        return true;
    }

    private void v(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.iun, str);
        this.iup = i2;
        this.iun = str;
        ctw();
        if (this.iuk == null || z) {
            this.iuk = this.iul.a(str, this.ios, i);
            this.iuk.changeSkinType(this.mSkinType);
            this.iuk.A(this.hVH);
        }
        if (this.ius != null) {
            this.iuk.f(this.ius);
        }
        if (this.iut != null) {
            this.iuk.g(this.iut);
        }
        this.hVY.addHeaderView(this.iuk.getView());
        Ja(str);
        ctu();
    }

    private void ctu() {
        com.baidu.adp.lib.f.e.mS().postDelayed(this.iuu, 4000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpD() {
        if (ctz() && this.iuk != null) {
            this.iuk.cpD();
        }
    }

    public void ctv() {
        if (!this.ium && this.iuk != null) {
            this.hVY.addHeaderView(this.iuk.cuD());
            this.ium = true;
        }
    }

    private void ctw() {
        if (this.iuk != null) {
            this.hVY.removeHeaderView(this.iuk.getView());
            this.hVY.removeHeaderView(this.iuk.cuD());
            ctx();
        }
        this.ium = false;
    }

    private void ctx() {
        if (this.iur != null && this.ios != null && this.ios.blc() != null) {
            this.ios.blc().removeHeaderView(this.iur.ctM());
        }
    }

    private void Ja(String str) {
        RelativeLayout ctM;
        if (this.iur != null && this.ios != null && this.ios.blc() != null && (ctM = this.iur.ctM()) != null) {
            if ("brand_page".equals(str)) {
                this.ios.blc().removeHeaderView(ctM);
                return;
            }
            this.ios.blc().removeHeaderView(ctM);
            this.ios.blc().addHeaderView(ctM, 0);
        }
    }

    public void i(FrsViewData frsViewData) {
        if (frsViewData != null && ctz()) {
            b(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.iun)) {
                this.iuk.cpq();
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float d = d(forumData);
            if (this.iuk != null) {
                this.iuk.a(forumData, frsViewData);
                this.iuk.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), d, false);
                this.iuk.a(forumData.getSignData());
            }
        }
    }

    public void j(FrsViewData frsViewData) {
        if (frsViewData != null && this.iuk != null && ctz()) {
            this.iuk.ap(d(frsViewData.getForum()));
        }
    }

    private float d(ForumData forumData) {
        if (forumData == null || this.ius == null) {
            return 0.0f;
        }
        return this.ius.d(forumData);
    }

    public void yL(int i) {
        if (i > 1) {
            if (this.iuk != null) {
                this.iuk.pq(false);
            }
        } else if (this.iuk != null) {
            this.iuk.pq(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void cty() {
        if (this.hVY != null) {
            this.hVY.removeCallbacks(this.fJU);
            this.hVY.postDelayed(this.fJU, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ctz() {
        return "frs_page".equals(this.iun) || "normal_page".equals(this.iun) || "book_page".equals(this.iun) || "brand_page".equals(this.iun);
    }

    public void m(Integer num) {
        setIsMem(num.intValue());
        if (ctz()) {
            ctA();
        }
    }

    public void setIsMem(int i) {
        if (this.iuk != null) {
            this.iuk.setMemberType(i);
        }
    }

    public void ctA() {
        if (this.iuk != null) {
            this.iuk.cpF();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && ctz()) {
            a(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void ctB() {
        if (ctz()) {
            yN(0);
        }
    }

    public void yM(int i) {
        if (ctz()) {
            yN(i);
        }
    }

    public void yN(int i) {
        if (this.iuk != null) {
            this.iuk.zk(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.iuk != null) {
            this.iuk.a(forumData, frsViewData);
            if (forumData != null) {
                this.iuk.a(i, forumData.getLevelName(), forumData.getUser_level(), d(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.iuk.ph(false);
                }
            }
        }
    }

    public boolean ctC() {
        if (!ctz() || this.iuk == null) {
            return false;
        }
        return this.iuk.cuB();
    }

    public void cts() {
        if (this.ius != null) {
            this.ius.cts();
        }
    }

    public void M(int i, int i2, int i3) {
        if (this.ius != null) {
            this.ius.M(i, i2, i3);
        }
    }

    public void yO(int i) {
        if (ctz() && this.iuk != null) {
            this.iuk.zl(i);
        }
    }

    public void k(FrsViewData frsViewData) {
        if (ctz() && this.ius != null) {
            this.ius.a(this.iuk, frsViewData);
        }
    }

    public boolean ctD() {
        if (!ctz() || this.iuk == null) {
            return false;
        }
        return this.iuk.ctD();
    }

    public boolean ctE() {
        if (!ctz() || this.iuk == null) {
            return false;
        }
        return this.iuk.ctE();
    }

    public void pg(boolean z) {
        if (this.iut != null) {
            this.iut.pg(z);
        }
    }

    public void cto() {
        if (this.iut != null) {
            this.iut.cto();
        }
    }

    public void Jb(String str) {
        if (this.ios.clO() != null && this.ios.clO().crN() != null) {
            com.baidu.tieba.tbadkCore.e.dvK().aW(com.baidu.tieba.tbadkCore.e.dvK().f("1~" + str, this.ios.clO().crN().getSortType(), this.ios.clO().crN().getIsGood(), this.ios.clO().crN().getCategoryId()), false);
        }
    }

    public void cpA() {
        if (this.iuk != null) {
            this.iuk.cpA();
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
            return ((frsViewData.getStar() == null || frsViewData.getStar().dvX() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || y.isEmpty(frsViewData.getActivityHeadData().bcI())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().bcA(), true)))) ? false : true;
        }
        return false;
    }

    public void yP(int i) {
        View findViewById;
        if (this.iuk != null && this.iuk.cuD() != null && (findViewById = this.iuk.cuD().findViewById(R.id.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.iuq != null) {
            this.iuq.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.iur = frsTabViewController;
    }
}
