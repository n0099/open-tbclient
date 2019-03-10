package com.baidu.tieba.frs.vc;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.message.SignMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes4.dex */
public class f extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private LikeModel bUp;
    private int eVC;
    private final View.OnClickListener faZ;
    private FrsHeaderViewContainer fbs;
    private FrsFragment fqT;
    private com.baidu.tieba.frs.view.b fvH;
    private int fvI;
    private String fvJ;
    private Runnable fvK;
    private int fvL;
    private boolean fvM;
    private w fvN;
    private boolean fvO;
    private com.baidu.tieba.frs.entelechy.b.a fvP;
    private boolean fvQ;
    private com.baidu.tieba.f.a fvR;
    private BdUniqueId fvS;
    private FrsTabViewController fvT;
    private AntiHelper.a fvU;
    private CustomMessageListener fvV;
    private Runnable fvW;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.fbs = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.fvJ = null;
        this.fvM = false;
        this.bUp = null;
        this.fvN = null;
        this.fvO = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12536").T("obj_locate", at.a.bLn));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12535").T("obj_locate", at.a.bLn));
            }
        };
        this.fvU = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.4
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12536").T("obj_locate", at.a.bLp));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12535").T("obj_locate", at.a.bLp));
            }
        };
        this.fvV = new CustomMessageListener(2001425) { // from class: com.baidu.tieba.frs.vc.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                FrsViewData bcS;
                String name;
                SignData signData;
                boolean z;
                int i;
                if (f.this.fqT != null && (customResponsedMessage instanceof SignMessage) && (bcS = f.this.fqT.bcS()) != null && bcS.getForum() != null && (name = bcS.getForum().getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == f.this.fvS) {
                    TiebaStatic.eventStat(f.this.fqT.getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name2 = bcS.getForum().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.aB(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                        if (signMessage.signData != null) {
                            AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener);
                        } else {
                            AntiHelper.aV(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                        }
                        TiebaStatic.log(new am("c12534").T("obj_locate", at.a.bLn));
                        return;
                    }
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(bcS.getForum().getId())) {
                            f.this.vQ(name2);
                            bcS.updateSignData(signData2);
                            signData2.forumId = bcS.getForum().getId();
                            signData2.forumName = bcS.getForum().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = bcS.getForum().getUser_level();
                        if (f.this.bjj()) {
                            i = bcS.getForum().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                        if (!f.this.bjh()) {
                            f.this.fqT.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                        } else {
                            f.this.fqT.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                        }
                        if (f.this.fqT.bcv() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.aiC().a(f.this.fqT.getTbPageContext(), f.this.fqT.bcv().bdM());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.rz(1);
                    }
                    f.this.fqT.showToast(signMessage.mSignErrorString);
                }
            }
        };
        this.fvW = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.8
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.fbs != null) {
                    int childCount = f.this.fbs.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(f.this.fbs.getChildAt(i));
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
        this.faZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsViewData bcS = f.this.fqT.bcS();
                if (bcS != null && bcS.getForum() != null && f.this.fvH != null && (view == f.this.fvH.bkc() || view == f.this.fvH.bkd() || view == f.this.fvH.bke())) {
                    if (f.this.fqT != null && bcS.getForum() != null) {
                        TiebaStatic.log(new am("c12046").bJ(ImageViewerConfig.FORUM_ID, bcS.getForum().getId()).T("obj_locate", f.this.fqT.bcU() ? 1 : 2));
                    }
                    if (com.baidu.tbadk.plugins.c.ay(f.this.mContext.getPageActivity(), "com.baidu.tieba.pluginCore")) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), bcS.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                        return;
                    }
                    return;
                }
                int id = view.getId();
                if (id == d.g.tv_love) {
                    if (!f.this.fqT.bcT()) {
                        if (!com.baidu.adp.lib.util.j.kY()) {
                            f.this.fqT.showToast(d.j.neterror);
                        } else if (!bc.cZ(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new am("c10517").T("obj_locate", 1).bJ(ImageViewerConfig.FORUM_ID, f.this.fqT.getForumId()));
                        } else {
                            f.this.jQ(true);
                            if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                am amVar = new am("c10048");
                                amVar.bJ(ImageViewerConfig.FORUM_ID, f.this.fqT.getForumId());
                                amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(amVar);
                            }
                        }
                    }
                } else if (id == d.g.tv_sign) {
                    if (!f.this.fqT.bcT()) {
                        if (!com.baidu.adp.lib.util.j.kY()) {
                            f.this.fqT.showToast(d.j.neterror);
                        } else if (bc.cZ(f.this.mContext.getPageActivity())) {
                            if (!f.this.bji()) {
                                f.this.bjl();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(f.this.fqT.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.l(f.this.fqT.getForumId(), 0), 24002)));
                            }
                        }
                    }
                } else if (id == d.g.frs_header_games) {
                    if (bc.cZ(f.this.mContext.getPageActivity()) && bcS != null && bcS.getGameUrl() != null) {
                        ba.adD().a((TbPageContext) f.this.getPageContext(), new String[]{bcS.getGameUrl()}, true);
                    }
                } else if (id == d.g.frs_bawu_center) {
                    if (bcS != null && bcS.getUserData() != null && bcS.getUserData().isBawu()) {
                        String bawuCenterUrl = bcS.getBawuCenterUrl();
                        if (!ap.isEmpty(bawuCenterUrl)) {
                            com.baidu.tbadk.browser.a.ar(f.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            if (bcS.getForum() != null) {
                                TiebaStatic.log(new am("c10502").bJ(ImageViewerConfig.FORUM_ID, bcS.getForum().getId()).bJ("uid", bcS.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == d.g.level_container && !f.this.fqT.bcT() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page") || f.this.mPageType.equals("brand_page")) && f.this.fvH != null) {
                        f.this.fvH.k(view, false);
                    }
                }
            }
        };
        this.fqT = frsFragment;
        this.fvP = aVar;
        this.fbs = frsHeaderViewContainer;
        this.fvS = BdUniqueId.gen();
        this.fvR = new com.baidu.tieba.f.a();
        this.fvR.a(new a.InterfaceC0243a() { // from class: com.baidu.tieba.frs.vc.f.6
            @Override // com.baidu.tieba.f.a.InterfaceC0243a
            public void aR(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0243a
            public void aS(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0243a
            public void aT(int i, int i2) {
            }
        });
    }

    public void Q(Bundle bundle) {
        this.fqT.registerListener(this.fvV);
        aCi();
        bjm();
        this.fvM = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.fvH != null) {
            this.fvH.onDestory();
        }
        if (this.bUp != null) {
            this.bUp.cdG();
        }
        if (this.fvK != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fvK);
        }
    }

    public void onActivityStop() {
        if (this.fvH != null) {
            this.fvH.onStop();
        }
        if (this.fbs != null) {
            this.fbs.removeCallbacks(this.fvW);
        }
    }

    public void iY(boolean z) {
        if (this.fvH != null) {
            this.fvH.iY(z);
        }
    }

    public boolean rv(int i) {
        this.mSkinType = i;
        if (this.fvH != null) {
            this.fvH.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void jP(boolean z) {
        if (z) {
            if (this.fvH != null) {
                this.fbs.removeHeaderView(this.fvH.bkb());
                this.fvO = false;
            }
        } else if (this.fvH != null && this.fvH.bkb() != null && !this.fvO) {
            this.fbs.addHeaderView(this.fvH.bkb(), this.fbs.getHeaderViewsCount());
            this.fvO = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        this.mPageType = str;
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            u(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean biZ() {
        return true;
    }

    private void u(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.fvJ, str);
        this.fvL = i2;
        this.fvJ = str;
        bjb();
        if (this.fvH == null || z) {
            this.fvH = this.fvP.a(str, this.fqT, i);
            this.fvH.changeSkinType(this.mSkinType);
            this.fvH.t(this.faZ);
        }
        this.fbs.addHeaderView(this.fvH.getView());
        vP(this.mPageType);
        bjd();
    }

    public void bja() {
        if (!this.fvO && this.fvH != null) {
            this.fbs.addHeaderView(this.fvH.bkb());
            this.fvO = true;
        }
    }

    private void bjb() {
        if (this.fvH != null) {
            this.fbs.removeHeaderView(this.fvH.getView());
            this.fbs.removeHeaderView(this.fvH.bkb());
            bjc();
        }
        this.fvO = false;
    }

    private void bjc() {
        if (this.fvT != null && this.fqT != null && this.fqT.afc() != null) {
            this.fqT.afc().removeHeaderView(this.fvT.bjq());
        }
    }

    private void vP(String str) {
        RelativeLayout bjq;
        if (this.fvT != null && this.fqT != null && this.fqT.afc() != null && (bjq = this.fvT.bjq()) != null) {
            if ("brand_page".equals(str)) {
                this.fqT.afc().removeHeaderView(bjq);
                return;
            }
            this.fqT.afc().removeHeaderView(bjq);
            this.fqT.afc().addHeaderView(bjq, 0);
        }
    }

    private void bjd() {
        if (this.fvK == null) {
            this.fvK = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.fqT.bcv() == null || !f.this.fqT.bcv().bcT()) && f.this.fbs.isShown() && f.this.fqT.isPrimary() && !f.this.fvM && f.this.fvL == 1 && f.this.fqT.bcv() != null && f.this.fqT.bcv().bdr() != null && !f.this.fqT.bcv().bdr().biW() && f.this.fqT.bcY()) {
                            if (("frs_page".equals(f.this.fvJ) || "normal_page".equals(f.this.fvJ) || "brand_page".equals(f.this.mPageType) || "book_page".equals(f.this.fvJ)) && f.this.fvH != null && f.this.fvH.bka()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.bfw();
                                f.this.fqT.eYG = true;
                                f.this.fvM = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.jH().postDelayed(this.fvK, 4000L);
    }

    public void h(FrsViewData frsViewData) {
        if (frsViewData != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                b(frsViewData.getForum(), frsViewData);
                if ("brand_page".equals(this.mPageType)) {
                    this.fvH.bfl();
                }
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float b = b(forumData);
            if (this.fvH != null) {
                this.fvH.a(forumData, frsViewData);
                this.fvH.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                if (forumData.getSignData() != null) {
                    this.fvH.rS(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.fvH.jX(false);
                        return;
                    }
                    this.fvH.jX(true);
                    this.fvH.rS(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.fvI = forumData.getLevelupScore();
        this.eVC = forumData.getCurScore();
        if (this.fvI > 0) {
            return this.eVC / this.fvI;
        }
        return 0.0f;
    }

    public void rw(int i) {
        if (i > 1) {
            if (this.fvH != null) {
                this.fvH.jY(false);
            }
        } else if (this.fvH != null) {
            this.fvH.jY(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void bje() {
        if (this.fbs != null) {
            this.fbs.removeCallbacks(this.fvW);
            this.fbs.postDelayed(this.fvW, 100L);
        }
    }

    public void h(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            bjf();
        }
    }

    public void setIsMem(int i) {
        if (this.fvH != null) {
            this.fvH.setMemberType(i);
        }
    }

    public void bfw() {
        if (("normal_page".equals(this.fvJ) || "frs_page".equals(this.fvJ) || "book_page".equals(this.fvJ) || "brand_page".equals(this.mPageType)) && this.fvH != null) {
            this.fvH.bfw();
        }
    }

    public void bjf() {
        if (this.fvH != null) {
            this.fvH.bfy();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                a(1, frsViewData.getForum(), frsViewData, z);
            }
        }
    }

    public void bjg() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            ry(0);
        }
    }

    public void rx(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            ry(i);
        }
    }

    public void ry(int i) {
        if (this.fvH != null) {
            this.fvH.rR(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.fvH != null) {
            this.fvH.a(forumData, frsViewData);
            if (forumData != null) {
                this.fvH.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.fvH.jX(false);
                }
            }
        }
    }

    public boolean bjh() {
        if (("normal_page".equals(this.fvJ) || "frs_page".equals(this.fvJ) || "book_page".equals(this.fvJ) || "brand_page".equals(this.mPageType)) && this.fvH != null) {
            return this.fvH.bjZ();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.fvI - this.eVC) {
                z = true;
                this.fvI = signData.levelup_score;
            }
            this.eVC = i + this.eVC;
            if (this.eVC > this.fvI) {
                this.eVC = this.fvI;
            }
            if (this.fvI != 0) {
                f = this.eVC / this.fvI;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.d(z, f);
        }
    }

    public void rz(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.fvH != null) {
            this.fvH.rS(i);
        }
    }

    public void i(FrsViewData frsViewData) {
        SignData signData;
        ForumData forum;
        if (frsViewData != null && frsViewData.getForum() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.fvH != null && (signData = frsViewData.getForum().getSignData()) != null && (forum = frsViewData.getForum()) != null) {
                this.fvH.a(forum, frsViewData);
                this.fvH.rS(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.fvH.bjZ()) {
                    a(this.fvH, signData);
                    forum.setCurScore(this.eVC);
                    forum.setLevelupScore(this.fvI);
                    this.fvH.a(forum, frsViewData);
                }
            }
        }
    }

    public boolean bji() {
        if (("normal_page".equals(this.fvJ) || "frs_page".equals(this.fvJ) || "book_page".equals(this.fvJ) || "brand_page".equals(this.mPageType)) && this.fvH != null) {
            return this.fvH.bji();
        }
        return false;
    }

    public boolean bjj() {
        if (("normal_page".equals(this.fvJ) || "frs_page".equals(this.fvJ) || "book_page".equals(this.fvJ) || "brand_page".equals(this.mPageType)) && this.fvH != null) {
            return this.fvH.bjj();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void jQ(boolean z) {
        if (this.fqT != null) {
            FrsViewData bcS = this.fqT.bcS();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.fqT.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11002)));
            } else if (bcS != null && bcS.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.fqT.getFrom())) {
                    TiebaStatic.log(new am("c10356").bJ(ImageViewerConfig.FORUM_ID, bcS.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.fqT.getFrom())) {
                    TiebaStatic.log(new am("c10590").T("obj_type", 2).bJ(ImageViewerConfig.FORUM_ID, bcS.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.fqT.getFrom())) {
                    TiebaStatic.log(new am("c10587").T("obj_type", 2).bJ(ImageViewerConfig.FORUM_ID, bcS.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.fqT.getFrom())) {
                    TiebaStatic.log(new am("c10578").T("obj_type", 2).bJ(ImageViewerConfig.FORUM_ID, bcS.getForum().getId()));
                }
                this.bUp.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.fqT.getFrom())) {
                    TiebaStatic.eventStat(this.fqT.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.fqT.getFrom())) {
                    TiebaStatic.log(new am("c10359").bJ(ImageViewerConfig.FORUM_ID, bcS.getForum().getId()));
                }
                this.bUp.ac(bcS.getForum().getName(), bcS.getForum().getId(), "FRS");
                this.fvQ = z;
            }
        }
    }

    public void bjk() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.fqT.bcS() != null && this.fqT.bcS().getForum() != null && this.fqT.bcS().getForum().getName() != null) {
            str = this.fqT.bcS().getForum().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.ly(String.format(getPageContext().getString(d.j.attention_cancel_dialog_content), str));
        } else {
            aVar.ly(getPageContext().getString(d.j.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(d.j.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.10
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                FrsViewData bcS = f.this.fqT.bcS();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.fqT.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(f.this.getPageContext().getPageActivity(), true, 11036)));
                } else if (bcS != null && bcS.getForum() != null) {
                    f.this.fvN.A(bcS.getForum().getName(), com.baidu.adp.lib.g.b.d(bcS.getForum().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(d.j.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).aaZ();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void bjl() {
        FrsViewData bcS = this.fqT.bcS();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.fqT.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11014)));
        } else if (bcS != null && bcS.getForum() != null && com.baidu.tbadk.plugins.c.ay(this.mContext.getPageActivity(), "com.baidu.tieba.pluginCore")) {
            FrsActivityStatic.forumName = bcS.getForum().getName() == null ? "" : bcS.getForum().getName();
            CustomMessage customMessage = new CustomMessage(2001425, bcS.getForum());
            customMessage.setTag(this.fvS);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vQ(String str) {
        if (this.fqT.bcq() != null && this.fqT.bcq().bhH() != null) {
            com.baidu.tieba.tbadkCore.d.cds().au(com.baidu.tieba.tbadkCore.d.cds().d("1~" + str, this.fqT.bcq().bhH().getSortType(), this.fqT.bcq().bhH().getIsGood(), this.fqT.bcq().bhH().getCategoryId()), false);
        }
    }

    private void aCi() {
        this.bUp = new LikeModel(this.fqT.getPageContext());
        this.bUp.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                r rVar;
                boolean z = false;
                FrsViewData bcS = f.this.fqT.bcS();
                if (bcS != null && bcS.getForum() != null && obj != null) {
                    if (AntiHelper.aB(f.this.bUp.getErrorCode(), f.this.bUp.getErrorString())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.bUp.getBlockPopInfoData(), f.this.fvU) != null) {
                            TiebaStatic.log(new am("c12534").T("obj_locate", at.a.bLp));
                            return;
                        }
                        return;
                    }
                    String name = bcS.getForum().getName();
                    String id = bcS.getForum().getId();
                    if (!(obj instanceof r)) {
                        rVar = null;
                    } else {
                        rVar = (r) obj;
                    }
                    boolean z2 = rVar != null && f.this.bUp.getErrorCode() == 0;
                    if (rVar.getErrorCode() == 3250013) {
                        BdToast.b(TbadkCoreApplication.getInst().getContext(), rVar.getErrorMsg(), d.f.icon_toast_game_error, 3000).abh();
                    } else {
                        z = z2;
                    }
                    if (rVar == null || !z) {
                        if (f.this.bUp.getErrorCode() == 22) {
                            f.this.fqT.showToast(f.this.getPageContext().getString(d.j.had_liked_forum));
                        } else {
                            f.this.fqT.showToast(f.this.bUp.getErrorString());
                        }
                    } else {
                        f.this.vQ(name);
                        rVar.setLike(1);
                        bcS.updateLikeData(rVar);
                        bcS.setLikeFeedForumDataList(rVar.cdz());
                        f.this.a(bcS, f.this.fvQ);
                        f.this.fvQ = true;
                        f.this.fqT.showToast(f.this.getPageContext().getResources().getString(d.j.attention_success));
                        f.this.l(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                    }
                    f.this.fqT.au(Boolean.valueOf(z));
                }
            }
        });
    }

    private void bjm() {
        this.fvN = new w();
        this.fvN.setFrom("from_frs");
        this.fvN.a(new w.a() { // from class: com.baidu.tieba.frs.vc.f.3
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void s(String str, long j) {
                FrsViewData bcS = f.this.fqT.bcS();
                if (bcS != null && bcS.getForum() != null) {
                    String name = bcS.getForum().getName();
                    String id = bcS.getForum().getId();
                    if (j == com.baidu.adp.lib.g.b.d(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.vQ(str);
                        bcS.getForum().setLike(0);
                        f.this.rx(0);
                        f.this.fqT.at(true);
                        f.this.l(false, id);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003004, id));
                        r rVar = new r();
                        rVar.setLike(0);
                        rVar.setFid(id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                    }
                }
            }

            @Override // com.baidu.tieba.tbadkCore.w.a
            public void t(String str, long j) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.bwd().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void I(int i, int i2, int i3) {
        FrsViewData bcS;
        if (i > 0 && i2 > 0 && (bcS = this.fqT.bcS()) != null && bcS.getForum() != null && bcS.getSignData() != null) {
            ForumData forum = bcS.getForum();
            SignData signData = bcS.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            bcS.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
            int i4 = -1;
            if (bjj()) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void bft() {
        if (this.fvH != null) {
            this.fvH.bft();
        }
    }

    public static boolean j(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().Xg(), true) || frsViewData.getBookInfo().Xg().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean k(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().cdA() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || v.T(frsViewData.getActivityHeadData().Xf())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().Xn(), true)))) ? false : true;
        }
        return false;
    }

    public void rA(int i) {
        View findViewById;
        if (this.fvH != null && this.fvH.bkb() != null && (findViewById = this.fvH.bkb().findViewById(d.g.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.fvR != null) {
            this.fvR.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.fvT = frsTabViewController;
    }
}
