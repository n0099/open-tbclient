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
    private Runnable gpr;
    private final View.OnClickListener iKb;
    private FrsHeaderViewContainer iKs;
    private FrsFragment jcU;
    private BdUniqueId jiK;
    private com.baidu.tieba.frs.view.b jiQ;
    private com.baidu.tieba.frs.entelechy.b.a jiR;
    private boolean jiS;
    private String jiT;
    private boolean jiU;
    private int jiV;
    private com.baidu.tieba.f.a jiW;
    private FrsTabViewController jiX;
    private g jiY;
    private f jiZ;
    private final Runnable jja;
    private int mScrollState;
    private int mSkinType;

    public h(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.jiS = false;
        this.mSkinType = 0;
        this.jiT = "normal_page";
        this.mScrollState = 0;
        this.jiU = false;
        this.jja = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.1
            @Override // java.lang.Runnable
            public void run() {
                q cyl;
                if (h.this.jcU != null && h.this.mScrollState == 0 && (cyl = h.this.jcU.cyl()) != null && cyl.czq() != null && !cyl.czq().cFF() && !cyl.cyQ() && h.this.iKs.isShown() && h.this.jcU.isPrimary() && !h.this.jiU && h.this.jcU.cyX() && h.this.jiV == 1 && h.this.cFV() && h.this.jiQ != null && h.this.jiQ.cHa()) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                    h.this.cBV();
                    h.this.jcU.iHc = true;
                    h.this.jiU = true;
                }
            }
        };
        this.gpr = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.iKs != null) {
                    int childCount = h.this.iKs.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(h.this.iKs.getChildAt(i));
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
        this.iKb = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.jcU != null) {
                    FrsViewData cyP = h.this.jcU.cyP();
                    if (cyP != null && cyP.getForum() != null && h.this.jiQ != null && (view == h.this.jiQ.cHc() || view == h.this.jiQ.cHd() || view == h.this.jiQ.cHe())) {
                        if (h.this.jcU != null && cyP.getForum() != null) {
                            TiebaStatic.log(new aq("c12046").dR("fid", cyP.getForum().getId()).al("obj_locate", h.this.jcU.cyS() ? 1 : 2));
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        if (cyP.getEntelechyTabInfo() != null && cyP.getEntelechyTabInfo().tab != null) {
                            for (int i = 0; i < cyP.getEntelechyTabInfo().tab.size(); i++) {
                                arrayList.add(cyP.getEntelechyTabInfo().tab.get(i).tab_name);
                            }
                        }
                        ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), cyP.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                        forumDetailActivityConfig.setForumTabs(arrayList);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumDetailActivityConfig));
                    }
                    int id = view.getId();
                    if (id == R.id.tv_love) {
                        if (!h.this.jcU.cyQ()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.jcU.showToast(R.string.neterror);
                            } else if (!bg.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                TiebaStatic.log(new aq("c10517").al("obj_locate", 1).dR("fid", h.this.jcU.getForumId()));
                            } else {
                                h.this.qs(true);
                                if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    aq aqVar = new aq("c10048");
                                    aqVar.dR("fid", h.this.jcU.getForumId());
                                    aqVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(aqVar);
                                }
                            }
                        }
                    } else if (id == R.id.tv_sign) {
                        if (!h.this.jcU.cyQ()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.jcU.showToast(R.string.neterror);
                            } else if (bg.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                if (!h.this.cFZ()) {
                                    h.this.cFO();
                                    aq.BT("c13560").al("obj_type", 2).brk();
                                } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(h.this.jcU.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(h.this.jcU.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                                }
                            }
                        }
                    } else if (id == R.id.frs_header_games) {
                        if (bg.checkUpIsLogin(h.this.mContext.getPageActivity()) && cyP != null && cyP.getGameUrl() != null) {
                            be.brr().a((TbPageContext) h.this.getPageContext(), new String[]{cyP.getGameUrl()}, true);
                        }
                    } else if (id == R.id.frs_bawu_center) {
                        if (cyP != null && cyP.getUserData() != null && cyP.getUserData().isBawu()) {
                            String bawuCenterUrl = cyP.getBawuCenterUrl();
                            if (!at.isEmpty(bawuCenterUrl)) {
                                com.baidu.tbadk.browser.a.startWebActivity(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (cyP.getForum() != null) {
                                    TiebaStatic.log(new aq("c10502").dR("fid", cyP.getForum().getId()).dR("uid", cyP.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id == R.id.level_container) {
                        if (!h.this.jcU.cyQ() && h.this.mScrollState == 0 && h.this.cFV() && h.this.jiQ != null) {
                            h.this.jiQ.l(view, false);
                        }
                    } else if (id == R.id.frs_hot_rank_entry) {
                        if (cyP != null && cyP.getForum() != null && !TextUtils.isEmpty(cyP.getForum().getId())) {
                            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(h.this.getPageContext().getPageActivity());
                            hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(cyP.getForum().getId(), 0L)));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                            aq aqVar2 = new aq("c13666");
                            aqVar2.dR("fid", cyP.getForum().getId());
                            TiebaStatic.log(aqVar2);
                        }
                    } else if (id == R.id.frs_manager_info_layout) {
                        if (cyP != null && cyP.getForum() != null && !TextUtils.isEmpty(cyP.getForum().getId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumMemberActivityConfig(h.this.getPageContext().getPageActivity(), String.valueOf(cyP.getForum().getId()), cyP.getForum().getName())));
                        }
                    } else if (id == R.id.frs_manager_application_layout && bg.checkUpIsLogin(h.this.mContext.getPageActivity()) && cyP != null && cyP.getForum() != null && !TextUtils.isEmpty(cyP.getForum().getId())) {
                        be.brr().b(h.this.jcU.getTbPageContext(), new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + cyP.getForum().getId()});
                    }
                }
            }
        };
        this.jcU = frsFragment;
        this.jiR = aVar;
        this.iKs = frsHeaderViewContainer;
        this.jiK = BdUniqueId.gen();
        this.jiY = new g(this.jcU, this.jiK);
        this.jiZ = new f(this.jcU);
        this.jiW = new com.baidu.tieba.f.a();
    }

    public void aq(Bundle bundle) {
        if (this.jiY != null) {
            this.jiY.registerListener();
        }
        if (this.jiZ != null) {
            this.jiZ.aMh();
        }
        this.jiU = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void cDL() {
        if (this.jiQ != null) {
            this.jiQ.onDestory();
        }
        if (this.jiZ != null) {
            this.jiZ.cDL();
        }
        if (this.jja != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jja);
        }
    }

    public void bso() {
        if (this.jiQ != null) {
            this.jiQ.onStop();
        }
        if (this.iKs != null) {
            this.iKs.removeCallbacks(this.gpr);
        }
    }

    public void bQ(boolean z) {
        if (this.jiQ != null) {
            this.jiQ.bQ(z);
        }
    }

    public boolean Av(int i) {
        this.mSkinType = i;
        if (this.jiQ != null) {
            this.jiQ.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void qu(boolean z) {
        if (z) {
            if (this.jiQ != null) {
                this.iKs.removeHeaderView(this.jiQ.cHb());
                this.jiS = false;
            }
        } else if (this.jiQ != null && this.jiQ.cHb() != null && !this.jiS) {
            this.iKs.addHeaderView(this.jiQ.cHb(), this.iKs.getHeaderViewsCount());
            this.jiS = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            x(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean cFP() {
        return true;
    }

    private void x(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.jiT, str);
        this.jiV = i2;
        this.jiT = str;
        cFS();
        if (this.jiQ == null || z) {
            this.jiQ = this.jiR.a(str, this.jcU, i);
            this.jiQ.changeSkinType(this.mSkinType);
            this.jiQ.B(this.iKb);
        }
        if (this.jiY != null) {
            this.jiQ.f(this.jiY);
        }
        if (this.jiZ != null) {
            this.jiQ.g(this.jiZ);
        }
        this.iKs.addHeaderView(this.jiQ.getView());
        Lb(str);
        cFQ();
    }

    private void cFQ() {
        com.baidu.adp.lib.f.e.mY().postDelayed(this.jja, 4000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBV() {
        if (cFV() && this.jiQ != null) {
            this.jiQ.cBV();
        }
    }

    public void cFR() {
        if (!this.jiS && this.jiQ != null) {
            this.iKs.addHeaderView(this.jiQ.cHb());
            this.jiS = true;
        }
    }

    private void cFS() {
        if (this.jiQ != null) {
            this.iKs.removeHeaderView(this.jiQ.getView());
            this.iKs.removeHeaderView(this.jiQ.cHb());
            cFT();
        }
        this.jiS = false;
    }

    private void cFT() {
        if (this.jiX != null && this.jcU != null && this.jcU.bta() != null) {
            this.jcU.bta().removeHeaderView(this.jiX.cGk());
        }
    }

    private void Lb(String str) {
        RelativeLayout cGk;
        if (this.jiX != null && this.jcU != null && this.jcU.bta() != null && (cGk = this.jiX.cGk()) != null) {
            if ("brand_page".equals(str)) {
                this.jcU.bta().removeHeaderView(cGk);
                return;
            }
            this.jcU.bta().removeHeaderView(cGk);
            this.jcU.bta().addHeaderView(cGk, 0);
        }
    }

    public void i(FrsViewData frsViewData) {
        if (frsViewData != null && cFV()) {
            b(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.jiT)) {
                this.jiQ.cBI();
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float f = f(forumData);
            if (this.jiQ != null) {
                this.jiQ.a(forumData, frsViewData);
                this.jiQ.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), f, false);
                this.jiQ.a(forumData.getSignData());
            }
        }
    }

    public void j(FrsViewData frsViewData) {
        if (frsViewData != null && this.jiQ != null && cFV()) {
            this.jiQ.az(f(frsViewData.getForum()));
        }
    }

    private float f(ForumData forumData) {
        if (forumData == null || this.jiY == null) {
            return 0.0f;
        }
        return this.jiY.f(forumData);
    }

    public void Aw(int i) {
        if (i > 1) {
            if (this.jiQ != null) {
                this.jiQ.qC(false);
            }
        } else if (this.jiQ != null) {
            this.jiQ.qC(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void cFU() {
        if (this.iKs != null) {
            this.iKs.removeCallbacks(this.gpr);
            this.iKs.postDelayed(this.gpr, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cFV() {
        return "frs_page".equals(this.jiT) || "normal_page".equals(this.jiT) || "book_page".equals(this.jiT) || "brand_page".equals(this.jiT);
    }

    public void o(Integer num) {
        setIsMem(num.intValue());
        if (cFV()) {
            cFW();
        }
    }

    public void setIsMem(int i) {
        if (this.jiQ != null) {
            this.jiQ.setMemberType(i);
        }
    }

    public void cFW() {
        if (this.jiQ != null) {
            this.jiQ.cBX();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && cFV()) {
            a(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void cFX() {
        if (cFV()) {
            Ay(0);
        }
    }

    public void Ax(int i) {
        if (cFV()) {
            Ay(i);
        }
    }

    public void Ay(int i) {
        if (this.jiQ != null) {
            this.jiQ.AU(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.jiQ != null) {
            this.jiQ.a(forumData, frsViewData);
            if (forumData != null) {
                this.jiQ.a(i, forumData.getLevelName(), forumData.getUser_level(), f(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.jiQ.qt(false);
                }
            }
        }
    }

    public boolean cFY() {
        if (!cFV() || this.jiQ == null) {
            return false;
        }
        return this.jiQ.cGZ();
    }

    public void cFO() {
        if (this.jiY != null) {
            this.jiY.cFO();
        }
    }

    public void Q(int i, int i2, int i3) {
        if (this.jiY != null) {
            this.jiY.Q(i, i2, i3);
        }
    }

    public void Az(int i) {
        if (cFV() && this.jiQ != null) {
            this.jiQ.AV(i);
        }
    }

    public void k(FrsViewData frsViewData) {
        if (cFV() && this.jiY != null) {
            this.jiY.a(this.jiQ, frsViewData);
        }
    }

    public boolean cFZ() {
        if (!cFV() || this.jiQ == null) {
            return false;
        }
        return this.jiQ.cFZ();
    }

    public boolean cGa() {
        if (!cFV() || this.jiQ == null) {
            return false;
        }
        return this.jiQ.cGa();
    }

    public void qs(boolean z) {
        if (this.jiZ != null) {
            this.jiZ.qs(z);
        }
    }

    public void cFK() {
        if (this.jiZ != null) {
            this.jiZ.cFK();
        }
    }

    public void Lc(String str) {
        if (this.jcU.cyg() != null && this.jcU.cyg().cEh() != null) {
            com.baidu.tieba.tbadkCore.e.dIY().bc(com.baidu.tieba.tbadkCore.e.dIY().f("1~" + str, this.jcU.cyg().cEh().getSortType(), this.jcU.cyg().cEh().getIsGood(), this.jcU.cyg().cEh().getCategoryId()), false);
        }
    }

    public void cBS() {
        if (this.jiQ != null) {
            this.jiQ.cBS();
        }
    }

    public static boolean l(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().bkG(), true) || frsViewData.getBookInfo().bkG().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean m(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().dJl() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || y.isEmpty(frsViewData.getActivityHeadData().bkE())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().bkw(), true)))) ? false : true;
        }
        return false;
    }

    public void AA(int i) {
        View findViewById;
        if (this.jiQ != null && this.jiQ.cHb() != null && (findViewById = this.jiQ.cHb().findViewById(R.id.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.jiW != null) {
            this.jiW.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.jiX = frsTabViewController;
    }

    public f cGb() {
        return this.jiZ;
    }
}
