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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes6.dex */
public class h extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Runnable elO;
    private FrsFragment gBu;
    private BdUniqueId gGO;
    private com.baidu.tieba.frs.view.b gGU;
    private com.baidu.tieba.frs.entelechy.b.a gGV;
    private boolean gGW;
    private String gGX;
    private boolean gGY;
    private int gGZ;
    private com.baidu.tieba.f.a gHa;
    private FrsTabViewController gHb;
    private g gHc;
    private f gHd;
    private final Runnable gHe;
    private final View.OnClickListener gle;
    private FrsHeaderViewContainer glw;
    private int mScrollState;
    private int mSkinType;

    public h(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.gGW = false;
        this.mSkinType = 0;
        this.gGX = "normal_page";
        this.mScrollState = 0;
        this.gGY = false;
        this.gHe = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tieba.frs.l bBi;
                if (h.this.gBu != null && h.this.mScrollState == 0 && (bBi = h.this.gBu.bBi()) != null && bBi.bCf() != null && !bBi.bCf().bHO() && !bBi.bBJ() && h.this.glw.isShown() && h.this.gBu.isPrimary() && !h.this.gGY && h.this.gBu.bBP() && h.this.gGZ == 1 && h.this.bIe() && h.this.gGU != null && h.this.gGU.bIY()) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                    h.this.bEo();
                    h.this.gBu.giN = true;
                    h.this.gGY = true;
                }
            }
        };
        this.elO = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.glw != null) {
                    int childCount = h.this.glw.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(h.this.glw.getChildAt(i));
                    }
                }
            }

            private void refreshImage(View view) {
                if (view != null) {
                    if (view instanceof com.baidu.adp.newwidget.ImageView.h) {
                        ((com.baidu.adp.newwidget.ImageView.h) view).refresh();
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
        this.gle = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.gBu != null) {
                    FrsViewData bBI = h.this.gBu.bBI();
                    if (bBI != null && bBI.getForum() != null && h.this.gGU != null && (view == h.this.gGU.bJa() || view == h.this.gGU.bJb() || view == h.this.gGU.bJc())) {
                        if (h.this.gBu != null && bBI.getForum() != null) {
                            TiebaStatic.log(new an("c12046").cp("fid", bBI.getForum().getId()).Z("obj_locate", h.this.gBu.bBL() ? 1 : 2));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), bBI.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    }
                    int id = view.getId();
                    if (id == R.id.tv_love) {
                        if (!h.this.gBu.bBJ()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.gBu.showToast(R.string.neterror);
                            } else if (!bc.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                TiebaStatic.log(new an("c10517").Z("obj_locate", 1).cp("fid", h.this.gBu.getForumId()));
                            } else {
                                h.this.lR(true);
                                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    an anVar = new an("c10048");
                                    anVar.cp("fid", h.this.gBu.getForumId());
                                    anVar.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(anVar);
                                }
                            }
                        }
                    } else if (id == R.id.tv_sign) {
                        if (!h.this.gBu.bBJ()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.gBu.showToast(R.string.neterror);
                            } else if (bc.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                if (!h.this.bIi()) {
                                    h.this.bHX();
                                    an.tb("c13560").Z("obj_type", 2).aDT();
                                } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(h.this.gBu.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(h.this.gBu.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                                }
                            }
                        }
                    } else if (id == R.id.frs_header_games) {
                        if (bc.checkUpIsLogin(h.this.mContext.getPageActivity()) && bBI != null && bBI.getGameUrl() != null) {
                            ba.aEa().a((TbPageContext) h.this.getPageContext(), new String[]{bBI.getGameUrl()}, true);
                        }
                    } else if (id == R.id.frs_bawu_center) {
                        if (bBI != null && bBI.getUserData() != null && bBI.getUserData().isBawu()) {
                            String bawuCenterUrl = bBI.getBawuCenterUrl();
                            if (!aq.isEmpty(bawuCenterUrl)) {
                                com.baidu.tbadk.browser.a.startWebActivity(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (bBI.getForum() != null) {
                                    TiebaStatic.log(new an("c10502").cp("fid", bBI.getForum().getId()).cp("uid", bBI.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id == R.id.level_container && !h.this.gBu.bBJ() && h.this.mScrollState == 0 && h.this.bIe() && h.this.gGU != null) {
                        h.this.gGU.i(view, false);
                    }
                }
            }
        };
        this.gBu = frsFragment;
        this.gGV = aVar;
        this.glw = frsHeaderViewContainer;
        this.gGO = BdUniqueId.gen();
        this.gHc = new g(this.gBu, this.gGO);
        this.gHd = new f(this.gBu);
        this.gHa = new com.baidu.tieba.f.a();
    }

    public void aj(Bundle bundle) {
        if (this.gHc != null) {
            this.gHc.registerListener();
        }
        if (this.gHd != null) {
            this.gHd.adM();
        }
        this.gGY = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void afZ() {
        if (this.gGU != null) {
            this.gGU.onDestory();
        }
        if (this.gHd != null) {
            this.gHd.afZ();
        }
        if (this.gHe != null) {
            com.baidu.adp.lib.f.e.gy().removeCallbacks(this.gHe);
        }
    }

    public void aEU() {
        if (this.gGU != null) {
            this.gGU.onStop();
        }
        if (this.glw != null) {
            this.glw.removeCallbacks(this.elO);
        }
    }

    public void kV(boolean z) {
        if (this.gGU != null) {
            this.gGU.kV(z);
        }
    }

    public boolean tY(int i) {
        this.mSkinType = i;
        if (this.gGU != null) {
            this.gGU.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void lT(boolean z) {
        if (z) {
            if (this.gGU != null) {
                this.glw.removeHeaderView(this.gGU.bIZ());
                this.gGW = false;
            }
        } else if (this.gGU != null && this.gGU.bIZ() != null && !this.gGW) {
            this.glw.addHeaderView(this.gGU.bIZ(), this.glw.getHeaderViewsCount());
            this.gGW = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            v(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean bHY() {
        return true;
    }

    private void v(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.gGX, str);
        this.gGZ = i2;
        this.gGX = str;
        bIb();
        if (this.gGU == null || z) {
            this.gGU = this.gGV.a(str, this.gBu, i);
            this.gGU.changeSkinType(this.mSkinType);
            this.gGU.y(this.gle);
        }
        if (this.gHc != null) {
            this.gGU.f(this.gHc);
        }
        if (this.gHd != null) {
            this.gGU.g(this.gHd);
        }
        this.glw.addHeaderView(this.gGU.getView());
        Bp(str);
        bHZ();
    }

    private void bHZ() {
        com.baidu.adp.lib.f.e.gy().postDelayed(this.gHe, 4000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEo() {
        if (bIe() && this.gGU != null) {
            this.gGU.bEo();
        }
    }

    public void bIa() {
        if (!this.gGW && this.gGU != null) {
            this.glw.addHeaderView(this.gGU.bIZ());
            this.gGW = true;
        }
    }

    private void bIb() {
        if (this.gGU != null) {
            this.glw.removeHeaderView(this.gGU.getView());
            this.glw.removeHeaderView(this.gGU.bIZ());
            bIc();
        }
        this.gGW = false;
    }

    private void bIc() {
        if (this.gHb != null && this.gBu != null && this.gBu.aFx() != null) {
            this.gBu.aFx().removeHeaderView(this.gHb.bIn());
        }
    }

    private void Bp(String str) {
        RelativeLayout bIn;
        if (this.gHb != null && this.gBu != null && this.gBu.aFx() != null && (bIn = this.gHb.bIn()) != null) {
            if ("brand_page".equals(str)) {
                this.gBu.aFx().removeHeaderView(bIn);
                return;
            }
            this.gBu.aFx().removeHeaderView(bIn);
            this.gBu.aFx().addHeaderView(bIn, 0);
        }
    }

    public void i(FrsViewData frsViewData) {
        if (frsViewData != null && bIe()) {
            b(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.gGX)) {
                this.gGU.bEd();
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float b = b(forumData);
            if (this.gGU != null) {
                this.gGU.a(forumData, frsViewData);
                this.gGU.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                this.gGU.a(forumData.getSignData());
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null || this.gHc == null) {
            return 0.0f;
        }
        return this.gHc.b(forumData);
    }

    public void tZ(int i) {
        if (i > 1) {
            if (this.gGU != null) {
                this.gGU.mb(false);
            }
        } else if (this.gGU != null) {
            this.gGU.mb(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void bId() {
        if (this.glw != null) {
            this.glw.removeCallbacks(this.elO);
            this.glw.postDelayed(this.elO, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bIe() {
        return "frs_page".equals(this.gGX) || "normal_page".equals(this.gGX) || "book_page".equals(this.gGX) || "brand_page".equals(this.gGX);
    }

    public void k(Integer num) {
        setIsMem(num.intValue());
        if (bIe()) {
            bIf();
        }
    }

    public void setIsMem(int i) {
        if (this.gGU != null) {
            this.gGU.setMemberType(i);
        }
    }

    public void bIf() {
        if (this.gGU != null) {
            this.gGU.bEq();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && bIe()) {
            a(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void bIg() {
        if (bIe()) {
            ub(0);
        }
    }

    public void ua(int i) {
        if (bIe()) {
            ub(i);
        }
    }

    public void ub(int i) {
        if (this.gGU != null) {
            this.gGU.uu(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.gGU != null) {
            this.gGU.a(forumData, frsViewData);
            if (forumData != null) {
                this.gGU.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.gGU.lS(false);
                }
            }
        }
    }

    public boolean bIh() {
        if (!bIe() || this.gGU == null) {
            return false;
        }
        return this.gGU.bIX();
    }

    public void bHX() {
        if (this.gHc != null) {
            this.gHc.bHX();
        }
    }

    public void K(int i, int i2, int i3) {
        if (this.gHc != null) {
            this.gHc.K(i, i2, i3);
        }
    }

    public void uc(int i) {
        if (bIe() && this.gGU != null) {
            this.gGU.uv(i);
        }
    }

    public void j(FrsViewData frsViewData) {
        if (bIe() && this.gHc != null) {
            this.gHc.a(this.gGU, frsViewData);
        }
    }

    public boolean bIi() {
        if (!bIe() || this.gGU == null) {
            return false;
        }
        return this.gGU.bIi();
    }

    public boolean bIj() {
        if (!bIe() || this.gGU == null) {
            return false;
        }
        return this.gGU.bIj();
    }

    public void lR(boolean z) {
        if (this.gHd != null) {
            this.gHd.lR(z);
        }
    }

    public void bHT() {
        if (this.gHd != null) {
            this.gHd.bHT();
        }
    }

    public void Bq(String str) {
        if (this.gBu.bBd() != null && this.gBu.bBd().bGA() != null) {
            com.baidu.tieba.tbadkCore.d.cHp().aA(com.baidu.tieba.tbadkCore.d.cHp().e("1~" + str, this.gBu.bBd().bGA().getSortType(), this.gBu.bBd().bGA().getIsGood(), this.gBu.bBd().bGA().getCategoryId()), false);
        }
    }

    public void bEl() {
        if (this.gGU != null) {
            this.gGU.bEl();
        }
    }

    public static boolean k(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().axQ(), true) || frsViewData.getBookInfo().axQ().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean l(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().cHC() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || v.isEmpty(frsViewData.getActivityHeadData().axO())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().axX(), true)))) ? false : true;
        }
        return false;
    }

    public void ud(int i) {
        View findViewById;
        if (this.gGU != null && this.gGU.bIZ() != null && (findViewById = this.gGU.bIZ().findViewById(R.id.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.gHa != null) {
            this.gHa.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.gHb = frsTabViewController;
    }
}
