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
    private LikeModel bUt;
    private int eVl;
    private final View.OnClickListener faL;
    private FrsHeaderViewContainer fbe;
    private FrsFragment fqE;
    private com.baidu.tieba.frs.entelechy.b.a fvA;
    private boolean fvB;
    private com.baidu.tieba.f.a fvC;
    private BdUniqueId fvD;
    private FrsTabViewController fvE;
    private AntiHelper.a fvF;
    private CustomMessageListener fvG;
    private Runnable fvH;
    private com.baidu.tieba.frs.view.b fvs;
    private int fvt;
    private String fvu;
    private Runnable fvv;
    private int fvw;
    private boolean fvx;
    private w fvy;
    private boolean fvz;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.fbe = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.fvu = null;
        this.fvx = false;
        this.bUt = null;
        this.fvy = null;
        this.fvz = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12536").T("obj_locate", at.a.bLr));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12535").T("obj_locate", at.a.bLr));
            }
        };
        this.fvF = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.4
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12536").T("obj_locate", at.a.bLt));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12535").T("obj_locate", at.a.bLt));
            }
        };
        this.fvG = new CustomMessageListener(2001425) { // from class: com.baidu.tieba.frs.vc.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                FrsViewData bcP;
                String name;
                SignData signData;
                boolean z;
                int i;
                if (f.this.fqE != null && (customResponsedMessage instanceof SignMessage) && (bcP = f.this.fqE.bcP()) != null && bcP.getForum() != null && (name = bcP.getForum().getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == f.this.fvD) {
                    TiebaStatic.eventStat(f.this.fqE.getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name2 = bcP.getForum().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.aD(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                        if (signMessage.signData != null) {
                            AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener);
                        } else {
                            AntiHelper.aU(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                        }
                        TiebaStatic.log(new am("c12534").T("obj_locate", at.a.bLr));
                        return;
                    }
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(bcP.getForum().getId())) {
                            f.this.vN(name2);
                            bcP.updateSignData(signData2);
                            signData2.forumId = bcP.getForum().getId();
                            signData2.forumName = bcP.getForum().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = bcP.getForum().getUser_level();
                        if (f.this.bjg()) {
                            i = bcP.getForum().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                        if (!f.this.bje()) {
                            f.this.fqE.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                        } else {
                            f.this.fqE.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                        }
                        if (f.this.fqE.bcs() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.aiz().a(f.this.fqE.getTbPageContext(), f.this.fqE.bcs().bdJ());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.rv(1);
                    }
                    f.this.fqE.showToast(signMessage.mSignErrorString);
                }
            }
        };
        this.fvH = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.8
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.fbe != null) {
                    int childCount = f.this.fbe.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(f.this.fbe.getChildAt(i));
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
        this.faL = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsViewData bcP = f.this.fqE.bcP();
                if (bcP != null && bcP.getForum() != null && f.this.fvs != null && (view == f.this.fvs.bjZ() || view == f.this.fvs.bka() || view == f.this.fvs.bkb())) {
                    if (f.this.fqE != null && bcP.getForum() != null) {
                        TiebaStatic.log(new am("c12046").bJ(ImageViewerConfig.FORUM_ID, bcP.getForum().getId()).T("obj_locate", f.this.fqE.bcR() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), bcP.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                }
                int id = view.getId();
                if (id == d.g.tv_love) {
                    if (!f.this.fqE.bcQ()) {
                        if (!com.baidu.adp.lib.util.j.kY()) {
                            f.this.fqE.showToast(d.j.neterror);
                        } else if (!bc.cZ(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new am("c10517").T("obj_locate", 1).bJ(ImageViewerConfig.FORUM_ID, f.this.fqE.getForumId()));
                        } else {
                            f.this.jQ(true);
                            if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                am amVar = new am("c10048");
                                amVar.bJ(ImageViewerConfig.FORUM_ID, f.this.fqE.getForumId());
                                amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(amVar);
                            }
                        }
                    }
                } else if (id == d.g.tv_sign) {
                    if (!f.this.fqE.bcQ()) {
                        if (!com.baidu.adp.lib.util.j.kY()) {
                            f.this.fqE.showToast(d.j.neterror);
                        } else if (bc.cZ(f.this.mContext.getPageActivity())) {
                            if (!f.this.bjf()) {
                                f.this.bji();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(f.this.fqE.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.l(f.this.fqE.getForumId(), 0), 24002)));
                            }
                        }
                    }
                } else if (id == d.g.frs_header_games) {
                    if (bc.cZ(f.this.mContext.getPageActivity()) && bcP != null && bcP.getGameUrl() != null) {
                        ba.adA().a((TbPageContext) f.this.getPageContext(), new String[]{bcP.getGameUrl()}, true);
                    }
                } else if (id == d.g.frs_bawu_center) {
                    if (bcP != null && bcP.getUserData() != null && bcP.getUserData().isBawu()) {
                        String bawuCenterUrl = bcP.getBawuCenterUrl();
                        if (!ap.isEmpty(bawuCenterUrl)) {
                            com.baidu.tbadk.browser.a.ar(f.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            if (bcP.getForum() != null) {
                                TiebaStatic.log(new am("c10502").bJ(ImageViewerConfig.FORUM_ID, bcP.getForum().getId()).bJ("uid", bcP.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == d.g.level_container && !f.this.fqE.bcQ() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page") || f.this.mPageType.equals("brand_page")) && f.this.fvs != null) {
                        f.this.fvs.k(view, false);
                    }
                }
            }
        };
        this.fqE = frsFragment;
        this.fvA = aVar;
        this.fbe = frsHeaderViewContainer;
        this.fvD = BdUniqueId.gen();
        this.fvC = new com.baidu.tieba.f.a();
        this.fvC.a(new a.InterfaceC0284a() { // from class: com.baidu.tieba.frs.vc.f.6
            @Override // com.baidu.tieba.f.a.InterfaceC0284a
            public void aR(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0284a
            public void aS(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0284a
            public void aT(int i, int i2) {
            }
        });
    }

    public void Q(Bundle bundle) {
        this.fqE.registerListener(this.fvG);
        aCe();
        bjj();
        this.fvx = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.fvs != null) {
            this.fvs.onDestory();
        }
        if (this.bUt != null) {
            this.bUt.cdE();
        }
        if (this.fvv != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fvv);
        }
    }

    public void onActivityStop() {
        if (this.fvs != null) {
            this.fvs.onStop();
        }
        if (this.fbe != null) {
            this.fbe.removeCallbacks(this.fvH);
        }
    }

    public void iY(boolean z) {
        if (this.fvs != null) {
            this.fvs.iY(z);
        }
    }

    public boolean rr(int i) {
        this.mSkinType = i;
        if (this.fvs != null) {
            this.fvs.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void jP(boolean z) {
        if (z) {
            if (this.fvs != null) {
                this.fbe.removeHeaderView(this.fvs.bjY());
                this.fvz = false;
            }
        } else if (this.fvs != null && this.fvs.bjY() != null && !this.fvz) {
            this.fbe.addHeaderView(this.fvs.bjY(), this.fbe.getHeaderViewsCount());
            this.fvz = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        this.mPageType = str;
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            u(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean biW() {
        return true;
    }

    private void u(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.fvu, str);
        this.fvw = i2;
        this.fvu = str;
        biY();
        if (this.fvs == null || z) {
            this.fvs = this.fvA.a(str, this.fqE, i);
            this.fvs.changeSkinType(this.mSkinType);
            this.fvs.t(this.faL);
        }
        this.fbe.addHeaderView(this.fvs.getView());
        vM(this.mPageType);
        bja();
    }

    public void biX() {
        if (!this.fvz && this.fvs != null) {
            this.fbe.addHeaderView(this.fvs.bjY());
            this.fvz = true;
        }
    }

    private void biY() {
        if (this.fvs != null) {
            this.fbe.removeHeaderView(this.fvs.getView());
            this.fbe.removeHeaderView(this.fvs.bjY());
            biZ();
        }
        this.fvz = false;
    }

    private void biZ() {
        if (this.fvE != null && this.fqE != null && this.fqE.aeZ() != null) {
            this.fqE.aeZ().removeHeaderView(this.fvE.bjn());
        }
    }

    private void vM(String str) {
        RelativeLayout bjn;
        if (this.fvE != null && this.fqE != null && this.fqE.aeZ() != null && (bjn = this.fvE.bjn()) != null) {
            if ("brand_page".equals(str)) {
                this.fqE.aeZ().removeHeaderView(bjn);
                return;
            }
            this.fqE.aeZ().removeHeaderView(bjn);
            this.fqE.aeZ().addHeaderView(bjn, 0);
        }
    }

    private void bja() {
        if (this.fvv == null) {
            this.fvv = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.fqE.bcs() == null || !f.this.fqE.bcs().bcQ()) && f.this.fbe.isShown() && f.this.fqE.isPrimary() && !f.this.fvx && f.this.fvw == 1 && f.this.fqE.bcs() != null && f.this.fqE.bcs().bdo() != null && !f.this.fqE.bcs().bdo().biT() && f.this.fqE.bcV()) {
                            if (("frs_page".equals(f.this.fvu) || "normal_page".equals(f.this.fvu) || "brand_page".equals(f.this.mPageType) || "book_page".equals(f.this.fvu)) && f.this.fvs != null && f.this.fvs.bjX()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.bft();
                                f.this.fqE.eYs = true;
                                f.this.fvx = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.jH().postDelayed(this.fvv, 4000L);
    }

    public void h(FrsViewData frsViewData) {
        if (frsViewData != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                b(frsViewData.getForum(), frsViewData);
                if ("brand_page".equals(this.mPageType)) {
                    this.fvs.bfi();
                }
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float b = b(forumData);
            if (this.fvs != null) {
                this.fvs.a(forumData, frsViewData);
                this.fvs.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                if (forumData.getSignData() != null) {
                    this.fvs.rO(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.fvs.jX(false);
                        return;
                    }
                    this.fvs.jX(true);
                    this.fvs.rO(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.fvt = forumData.getLevelupScore();
        this.eVl = forumData.getCurScore();
        if (this.fvt > 0) {
            return this.eVl / this.fvt;
        }
        return 0.0f;
    }

    public void rs(int i) {
        if (i > 1) {
            if (this.fvs != null) {
                this.fvs.jY(false);
            }
        } else if (this.fvs != null) {
            this.fvs.jY(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void bjb() {
        if (this.fbe != null) {
            this.fbe.removeCallbacks(this.fvH);
            this.fbe.postDelayed(this.fvH, 100L);
        }
    }

    public void h(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            bjc();
        }
    }

    public void setIsMem(int i) {
        if (this.fvs != null) {
            this.fvs.setMemberType(i);
        }
    }

    public void bft() {
        if (("normal_page".equals(this.fvu) || "frs_page".equals(this.fvu) || "book_page".equals(this.fvu) || "brand_page".equals(this.mPageType)) && this.fvs != null) {
            this.fvs.bft();
        }
    }

    public void bjc() {
        if (this.fvs != null) {
            this.fvs.bfv();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                a(1, frsViewData.getForum(), frsViewData, z);
            }
        }
    }

    public void bjd() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            ru(0);
        }
    }

    public void rt(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            ru(i);
        }
    }

    public void ru(int i) {
        if (this.fvs != null) {
            this.fvs.rN(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.fvs != null) {
            this.fvs.a(forumData, frsViewData);
            if (forumData != null) {
                this.fvs.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.fvs.jX(false);
                }
            }
        }
    }

    public boolean bje() {
        if (("normal_page".equals(this.fvu) || "frs_page".equals(this.fvu) || "book_page".equals(this.fvu) || "brand_page".equals(this.mPageType)) && this.fvs != null) {
            return this.fvs.bjW();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.fvt - this.eVl) {
                z = true;
                this.fvt = signData.levelup_score;
            }
            this.eVl = i + this.eVl;
            if (this.eVl > this.fvt) {
                this.eVl = this.fvt;
            }
            if (this.fvt != 0) {
                f = this.eVl / this.fvt;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.d(z, f);
        }
    }

    public void rv(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.fvs != null) {
            this.fvs.rO(i);
        }
    }

    public void i(FrsViewData frsViewData) {
        SignData signData;
        ForumData forum;
        if (frsViewData != null && frsViewData.getForum() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.fvs != null && (signData = frsViewData.getForum().getSignData()) != null && (forum = frsViewData.getForum()) != null) {
                this.fvs.a(forum, frsViewData);
                this.fvs.rO(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.fvs.bjW()) {
                    a(this.fvs, signData);
                    forum.setCurScore(this.eVl);
                    forum.setLevelupScore(this.fvt);
                    this.fvs.a(forum, frsViewData);
                }
            }
        }
    }

    public boolean bjf() {
        if (("normal_page".equals(this.fvu) || "frs_page".equals(this.fvu) || "book_page".equals(this.fvu) || "brand_page".equals(this.mPageType)) && this.fvs != null) {
            return this.fvs.bjf();
        }
        return false;
    }

    public boolean bjg() {
        if (("normal_page".equals(this.fvu) || "frs_page".equals(this.fvu) || "book_page".equals(this.fvu) || "brand_page".equals(this.mPageType)) && this.fvs != null) {
            return this.fvs.bjg();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void jQ(boolean z) {
        if (this.fqE != null) {
            FrsViewData bcP = this.fqE.bcP();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.fqE.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11002)));
            } else if (bcP != null && bcP.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.fqE.getFrom())) {
                    TiebaStatic.log(new am("c10356").bJ(ImageViewerConfig.FORUM_ID, bcP.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.fqE.getFrom())) {
                    TiebaStatic.log(new am("c10590").T("obj_type", 2).bJ(ImageViewerConfig.FORUM_ID, bcP.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.fqE.getFrom())) {
                    TiebaStatic.log(new am("c10587").T("obj_type", 2).bJ(ImageViewerConfig.FORUM_ID, bcP.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.fqE.getFrom())) {
                    TiebaStatic.log(new am("c10578").T("obj_type", 2).bJ(ImageViewerConfig.FORUM_ID, bcP.getForum().getId()));
                }
                this.bUt.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.fqE.getFrom())) {
                    TiebaStatic.eventStat(this.fqE.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.fqE.getFrom())) {
                    TiebaStatic.log(new am("c10359").bJ(ImageViewerConfig.FORUM_ID, bcP.getForum().getId()));
                }
                this.bUt.ac(bcP.getForum().getName(), bcP.getForum().getId(), "FRS");
                this.fvB = z;
            }
        }
    }

    public void bjh() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.fqE.bcP() != null && this.fqE.bcP().getForum() != null && this.fqE.bcP().getForum().getName() != null) {
            str = this.fqE.bcP().getForum().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.lz(String.format(getPageContext().getString(d.j.attention_cancel_dialog_content), str));
        } else {
            aVar.lz(getPageContext().getString(d.j.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(d.j.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.10
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                FrsViewData bcP = f.this.fqE.bcP();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.fqE.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(f.this.getPageContext().getPageActivity(), true, 11036)));
                } else if (bcP != null && bcP.getForum() != null) {
                    f.this.fvy.A(bcP.getForum().getName(), com.baidu.adp.lib.g.b.d(bcP.getForum().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(d.j.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).aaW();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void bji() {
        FrsViewData bcP = this.fqE.bcP();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.fqE.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11014)));
        } else if (bcP != null && bcP.getForum() != null) {
            FrsActivityStatic.forumName = bcP.getForum().getName() == null ? "" : bcP.getForum().getName();
            CustomMessage customMessage = new CustomMessage(2001425, bcP.getForum());
            customMessage.setTag(this.fvD);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vN(String str) {
        if (this.fqE.bcn() != null && this.fqE.bcn().bhE() != null) {
            com.baidu.tieba.tbadkCore.d.cdq().au(com.baidu.tieba.tbadkCore.d.cdq().d("1~" + str, this.fqE.bcn().bhE().getSortType(), this.fqE.bcn().bhE().getIsGood(), this.fqE.bcn().bhE().getCategoryId()), false);
        }
    }

    private void aCe() {
        this.bUt = new LikeModel(this.fqE.getPageContext());
        this.bUt.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                r rVar;
                boolean z = false;
                FrsViewData bcP = f.this.fqE.bcP();
                if (bcP != null && bcP.getForum() != null && obj != null) {
                    if (AntiHelper.aD(f.this.bUt.getErrorCode(), f.this.bUt.getErrorString())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.bUt.getBlockPopInfoData(), f.this.fvF) != null) {
                            TiebaStatic.log(new am("c12534").T("obj_locate", at.a.bLt));
                            return;
                        }
                        return;
                    }
                    String name = bcP.getForum().getName();
                    String id = bcP.getForum().getId();
                    if (!(obj instanceof r)) {
                        rVar = null;
                    } else {
                        rVar = (r) obj;
                    }
                    boolean z2 = rVar != null && f.this.bUt.getErrorCode() == 0;
                    if (rVar.getErrorCode() == 3250013) {
                        BdToast.b(TbadkCoreApplication.getInst().getContext(), rVar.getErrorMsg(), d.f.icon_toast_game_error, 3000).abe();
                    } else {
                        z = z2;
                    }
                    if (rVar == null || !z) {
                        if (f.this.bUt.getErrorCode() == 22) {
                            f.this.fqE.showToast(f.this.getPageContext().getString(d.j.had_liked_forum));
                        } else {
                            f.this.fqE.showToast(f.this.bUt.getErrorString());
                        }
                    } else {
                        f.this.vN(name);
                        rVar.setLike(1);
                        bcP.updateLikeData(rVar);
                        bcP.setLikeFeedForumDataList(rVar.cdx());
                        f.this.a(bcP, f.this.fvB);
                        f.this.fvB = true;
                        f.this.fqE.showToast(f.this.getPageContext().getResources().getString(d.j.attention_success));
                        f.this.l(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                    }
                    f.this.fqE.aq(Boolean.valueOf(z));
                }
            }
        });
    }

    private void bjj() {
        this.fvy = new w();
        this.fvy.setFrom("from_frs");
        this.fvy.a(new w.a() { // from class: com.baidu.tieba.frs.vc.f.3
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void s(String str, long j) {
                FrsViewData bcP = f.this.fqE.bcP();
                if (bcP != null && bcP.getForum() != null) {
                    String name = bcP.getForum().getName();
                    String id = bcP.getForum().getId();
                    if (j == com.baidu.adp.lib.g.b.d(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.vN(str);
                        bcP.getForum().setLike(0);
                        f.this.rt(0);
                        f.this.fqE.ap(true);
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
        com.baidu.tieba.im.settingcache.d.bvZ().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void I(int i, int i2, int i3) {
        FrsViewData bcP;
        if (i > 0 && i2 > 0 && (bcP = this.fqE.bcP()) != null && bcP.getForum() != null && bcP.getSignData() != null) {
            ForumData forum = bcP.getForum();
            SignData signData = bcP.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            bcP.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
            int i4 = -1;
            if (bjg()) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void bfq() {
        if (this.fvs != null) {
            this.fvs.bfq();
        }
    }

    public static boolean j(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().Xd(), true) || frsViewData.getBookInfo().Xd().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean k(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().cdy() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || v.T(frsViewData.getActivityHeadData().Xc())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().Xk(), true)))) ? false : true;
        }
        return false;
    }

    public void rw(int i) {
        View findViewById;
        if (this.fvs != null && this.fvs.bjY() != null && (findViewById = this.fvs.bjY().findViewById(d.g.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.fvC != null) {
            this.fvC.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.fvE = frsTabViewController;
    }
}
