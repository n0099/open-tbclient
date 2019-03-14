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
    private LikeModel bUq;
    private int eVy;
    private final View.OnClickListener faY;
    private FrsHeaderViewContainer fbr;
    private FrsFragment fqS;
    private com.baidu.tieba.frs.view.b fvG;
    private int fvH;
    private String fvI;
    private Runnable fvJ;
    private int fvK;
    private boolean fvL;
    private w fvM;
    private boolean fvN;
    private com.baidu.tieba.frs.entelechy.b.a fvO;
    private boolean fvP;
    private com.baidu.tieba.f.a fvQ;
    private BdUniqueId fvR;
    private FrsTabViewController fvS;
    private AntiHelper.a fvT;
    private CustomMessageListener fvU;
    private Runnable fvV;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.fbr = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.fvI = null;
        this.fvL = false;
        this.bUq = null;
        this.fvM = null;
        this.fvN = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12536").T("obj_locate", at.a.bLo));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12535").T("obj_locate", at.a.bLo));
            }
        };
        this.fvT = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.4
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12536").T("obj_locate", at.a.bLq));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12535").T("obj_locate", at.a.bLq));
            }
        };
        this.fvU = new CustomMessageListener(2001425) { // from class: com.baidu.tieba.frs.vc.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                FrsViewData bcR;
                String name;
                SignData signData;
                boolean z;
                int i;
                if (f.this.fqS != null && (customResponsedMessage instanceof SignMessage) && (bcR = f.this.fqS.bcR()) != null && bcR.getForum() != null && (name = bcR.getForum().getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == f.this.fvR) {
                    TiebaStatic.eventStat(f.this.fqS.getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name2 = bcR.getForum().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.aB(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                        if (signMessage.signData != null) {
                            AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener);
                        } else {
                            AntiHelper.aU(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                        }
                        TiebaStatic.log(new am("c12534").T("obj_locate", at.a.bLo));
                        return;
                    }
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(bcR.getForum().getId())) {
                            f.this.vO(name2);
                            bcR.updateSignData(signData2);
                            signData2.forumId = bcR.getForum().getId();
                            signData2.forumName = bcR.getForum().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = bcR.getForum().getUser_level();
                        if (f.this.bji()) {
                            i = bcR.getForum().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                        if (!f.this.bjg()) {
                            f.this.fqS.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                        } else {
                            f.this.fqS.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                        }
                        if (f.this.fqS.bcu() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.aiC().a(f.this.fqS.getTbPageContext(), f.this.fqS.bcu().bdL());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.rz(1);
                    }
                    f.this.fqS.showToast(signMessage.mSignErrorString);
                }
            }
        };
        this.fvV = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.8
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.fbr != null) {
                    int childCount = f.this.fbr.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(f.this.fbr.getChildAt(i));
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
        this.faY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsViewData bcR = f.this.fqS.bcR();
                if (bcR != null && bcR.getForum() != null && f.this.fvG != null && (view == f.this.fvG.bkb() || view == f.this.fvG.bkc() || view == f.this.fvG.bkd())) {
                    if (f.this.fqS != null && bcR.getForum() != null) {
                        TiebaStatic.log(new am("c12046").bJ(ImageViewerConfig.FORUM_ID, bcR.getForum().getId()).T("obj_locate", f.this.fqS.bcT() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), bcR.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                }
                int id = view.getId();
                if (id == d.g.tv_love) {
                    if (!f.this.fqS.bcS()) {
                        if (!com.baidu.adp.lib.util.j.kY()) {
                            f.this.fqS.showToast(d.j.neterror);
                        } else if (!bc.cZ(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new am("c10517").T("obj_locate", 1).bJ(ImageViewerConfig.FORUM_ID, f.this.fqS.getForumId()));
                        } else {
                            f.this.jQ(true);
                            if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                am amVar = new am("c10048");
                                amVar.bJ(ImageViewerConfig.FORUM_ID, f.this.fqS.getForumId());
                                amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(amVar);
                            }
                        }
                    }
                } else if (id == d.g.tv_sign) {
                    if (!f.this.fqS.bcS()) {
                        if (!com.baidu.adp.lib.util.j.kY()) {
                            f.this.fqS.showToast(d.j.neterror);
                        } else if (bc.cZ(f.this.mContext.getPageActivity())) {
                            if (!f.this.bjh()) {
                                f.this.bjk();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(f.this.fqS.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.l(f.this.fqS.getForumId(), 0), 24002)));
                            }
                        }
                    }
                } else if (id == d.g.frs_header_games) {
                    if (bc.cZ(f.this.mContext.getPageActivity()) && bcR != null && bcR.getGameUrl() != null) {
                        ba.adD().a((TbPageContext) f.this.getPageContext(), new String[]{bcR.getGameUrl()}, true);
                    }
                } else if (id == d.g.frs_bawu_center) {
                    if (bcR != null && bcR.getUserData() != null && bcR.getUserData().isBawu()) {
                        String bawuCenterUrl = bcR.getBawuCenterUrl();
                        if (!ap.isEmpty(bawuCenterUrl)) {
                            com.baidu.tbadk.browser.a.ar(f.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            if (bcR.getForum() != null) {
                                TiebaStatic.log(new am("c10502").bJ(ImageViewerConfig.FORUM_ID, bcR.getForum().getId()).bJ("uid", bcR.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == d.g.level_container && !f.this.fqS.bcS() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page") || f.this.mPageType.equals("brand_page")) && f.this.fvG != null) {
                        f.this.fvG.k(view, false);
                    }
                }
            }
        };
        this.fqS = frsFragment;
        this.fvO = aVar;
        this.fbr = frsHeaderViewContainer;
        this.fvR = BdUniqueId.gen();
        this.fvQ = new com.baidu.tieba.f.a();
        this.fvQ.a(new a.InterfaceC0284a() { // from class: com.baidu.tieba.frs.vc.f.6
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
        this.fqS.registerListener(this.fvU);
        aCh();
        bjl();
        this.fvL = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.fvG != null) {
            this.fvG.onDestory();
        }
        if (this.bUq != null) {
            this.bUq.cdI();
        }
        if (this.fvJ != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fvJ);
        }
    }

    public void onActivityStop() {
        if (this.fvG != null) {
            this.fvG.onStop();
        }
        if (this.fbr != null) {
            this.fbr.removeCallbacks(this.fvV);
        }
    }

    public void iY(boolean z) {
        if (this.fvG != null) {
            this.fvG.iY(z);
        }
    }

    public boolean rv(int i) {
        this.mSkinType = i;
        if (this.fvG != null) {
            this.fvG.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void jP(boolean z) {
        if (z) {
            if (this.fvG != null) {
                this.fbr.removeHeaderView(this.fvG.bka());
                this.fvN = false;
            }
        } else if (this.fvG != null && this.fvG.bka() != null && !this.fvN) {
            this.fbr.addHeaderView(this.fvG.bka(), this.fbr.getHeaderViewsCount());
            this.fvN = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        this.mPageType = str;
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            u(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean biY() {
        return true;
    }

    private void u(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.fvI, str);
        this.fvK = i2;
        this.fvI = str;
        bja();
        if (this.fvG == null || z) {
            this.fvG = this.fvO.a(str, this.fqS, i);
            this.fvG.changeSkinType(this.mSkinType);
            this.fvG.t(this.faY);
        }
        this.fbr.addHeaderView(this.fvG.getView());
        vN(this.mPageType);
        bjc();
    }

    public void biZ() {
        if (!this.fvN && this.fvG != null) {
            this.fbr.addHeaderView(this.fvG.bka());
            this.fvN = true;
        }
    }

    private void bja() {
        if (this.fvG != null) {
            this.fbr.removeHeaderView(this.fvG.getView());
            this.fbr.removeHeaderView(this.fvG.bka());
            bjb();
        }
        this.fvN = false;
    }

    private void bjb() {
        if (this.fvS != null && this.fqS != null && this.fqS.afc() != null) {
            this.fqS.afc().removeHeaderView(this.fvS.bjp());
        }
    }

    private void vN(String str) {
        RelativeLayout bjp;
        if (this.fvS != null && this.fqS != null && this.fqS.afc() != null && (bjp = this.fvS.bjp()) != null) {
            if ("brand_page".equals(str)) {
                this.fqS.afc().removeHeaderView(bjp);
                return;
            }
            this.fqS.afc().removeHeaderView(bjp);
            this.fqS.afc().addHeaderView(bjp, 0);
        }
    }

    private void bjc() {
        if (this.fvJ == null) {
            this.fvJ = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.fqS.bcu() == null || !f.this.fqS.bcu().bcS()) && f.this.fbr.isShown() && f.this.fqS.isPrimary() && !f.this.fvL && f.this.fvK == 1 && f.this.fqS.bcu() != null && f.this.fqS.bcu().bdq() != null && !f.this.fqS.bcu().bdq().biV() && f.this.fqS.bcX()) {
                            if (("frs_page".equals(f.this.fvI) || "normal_page".equals(f.this.fvI) || "brand_page".equals(f.this.mPageType) || "book_page".equals(f.this.fvI)) && f.this.fvG != null && f.this.fvG.bjZ()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.bfv();
                                f.this.fqS.eYF = true;
                                f.this.fvL = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.jH().postDelayed(this.fvJ, 4000L);
    }

    public void h(FrsViewData frsViewData) {
        if (frsViewData != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                b(frsViewData.getForum(), frsViewData);
                if ("brand_page".equals(this.mPageType)) {
                    this.fvG.bfk();
                }
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float b = b(forumData);
            if (this.fvG != null) {
                this.fvG.a(forumData, frsViewData);
                this.fvG.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                if (forumData.getSignData() != null) {
                    this.fvG.rS(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.fvG.jX(false);
                        return;
                    }
                    this.fvG.jX(true);
                    this.fvG.rS(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.fvH = forumData.getLevelupScore();
        this.eVy = forumData.getCurScore();
        if (this.fvH > 0) {
            return this.eVy / this.fvH;
        }
        return 0.0f;
    }

    public void rw(int i) {
        if (i > 1) {
            if (this.fvG != null) {
                this.fvG.jY(false);
            }
        } else if (this.fvG != null) {
            this.fvG.jY(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void bjd() {
        if (this.fbr != null) {
            this.fbr.removeCallbacks(this.fvV);
            this.fbr.postDelayed(this.fvV, 100L);
        }
    }

    public void h(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            bje();
        }
    }

    public void setIsMem(int i) {
        if (this.fvG != null) {
            this.fvG.setMemberType(i);
        }
    }

    public void bfv() {
        if (("normal_page".equals(this.fvI) || "frs_page".equals(this.fvI) || "book_page".equals(this.fvI) || "brand_page".equals(this.mPageType)) && this.fvG != null) {
            this.fvG.bfv();
        }
    }

    public void bje() {
        if (this.fvG != null) {
            this.fvG.bfx();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                a(1, frsViewData.getForum(), frsViewData, z);
            }
        }
    }

    public void bjf() {
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
        if (this.fvG != null) {
            this.fvG.rR(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.fvG != null) {
            this.fvG.a(forumData, frsViewData);
            if (forumData != null) {
                this.fvG.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.fvG.jX(false);
                }
            }
        }
    }

    public boolean bjg() {
        if (("normal_page".equals(this.fvI) || "frs_page".equals(this.fvI) || "book_page".equals(this.fvI) || "brand_page".equals(this.mPageType)) && this.fvG != null) {
            return this.fvG.bjY();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.fvH - this.eVy) {
                z = true;
                this.fvH = signData.levelup_score;
            }
            this.eVy = i + this.eVy;
            if (this.eVy > this.fvH) {
                this.eVy = this.fvH;
            }
            if (this.fvH != 0) {
                f = this.eVy / this.fvH;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.d(z, f);
        }
    }

    public void rz(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.fvG != null) {
            this.fvG.rS(i);
        }
    }

    public void i(FrsViewData frsViewData) {
        SignData signData;
        ForumData forum;
        if (frsViewData != null && frsViewData.getForum() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.fvG != null && (signData = frsViewData.getForum().getSignData()) != null && (forum = frsViewData.getForum()) != null) {
                this.fvG.a(forum, frsViewData);
                this.fvG.rS(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.fvG.bjY()) {
                    a(this.fvG, signData);
                    forum.setCurScore(this.eVy);
                    forum.setLevelupScore(this.fvH);
                    this.fvG.a(forum, frsViewData);
                }
            }
        }
    }

    public boolean bjh() {
        if (("normal_page".equals(this.fvI) || "frs_page".equals(this.fvI) || "book_page".equals(this.fvI) || "brand_page".equals(this.mPageType)) && this.fvG != null) {
            return this.fvG.bjh();
        }
        return false;
    }

    public boolean bji() {
        if (("normal_page".equals(this.fvI) || "frs_page".equals(this.fvI) || "book_page".equals(this.fvI) || "brand_page".equals(this.mPageType)) && this.fvG != null) {
            return this.fvG.bji();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void jQ(boolean z) {
        if (this.fqS != null) {
            FrsViewData bcR = this.fqS.bcR();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.fqS.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11002)));
            } else if (bcR != null && bcR.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.fqS.getFrom())) {
                    TiebaStatic.log(new am("c10356").bJ(ImageViewerConfig.FORUM_ID, bcR.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.fqS.getFrom())) {
                    TiebaStatic.log(new am("c10590").T("obj_type", 2).bJ(ImageViewerConfig.FORUM_ID, bcR.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.fqS.getFrom())) {
                    TiebaStatic.log(new am("c10587").T("obj_type", 2).bJ(ImageViewerConfig.FORUM_ID, bcR.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.fqS.getFrom())) {
                    TiebaStatic.log(new am("c10578").T("obj_type", 2).bJ(ImageViewerConfig.FORUM_ID, bcR.getForum().getId()));
                }
                this.bUq.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.fqS.getFrom())) {
                    TiebaStatic.eventStat(this.fqS.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.fqS.getFrom())) {
                    TiebaStatic.log(new am("c10359").bJ(ImageViewerConfig.FORUM_ID, bcR.getForum().getId()));
                }
                this.bUq.ac(bcR.getForum().getName(), bcR.getForum().getId(), "FRS");
                this.fvP = z;
            }
        }
    }

    public void bjj() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.fqS.bcR() != null && this.fqS.bcR().getForum() != null && this.fqS.bcR().getForum().getName() != null) {
            str = this.fqS.bcR().getForum().getName();
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
                FrsViewData bcR = f.this.fqS.bcR();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.fqS.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(f.this.getPageContext().getPageActivity(), true, 11036)));
                } else if (bcR != null && bcR.getForum() != null) {
                    f.this.fvM.A(bcR.getForum().getName(), com.baidu.adp.lib.g.b.d(bcR.getForum().getId(), 0L));
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
    public void bjk() {
        FrsViewData bcR = this.fqS.bcR();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.fqS.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11014)));
        } else if (bcR != null && bcR.getForum() != null) {
            FrsActivityStatic.forumName = bcR.getForum().getName() == null ? "" : bcR.getForum().getName();
            CustomMessage customMessage = new CustomMessage(2001425, bcR.getForum());
            customMessage.setTag(this.fvR);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vO(String str) {
        if (this.fqS.bcp() != null && this.fqS.bcp().bhG() != null) {
            com.baidu.tieba.tbadkCore.d.cdu().au(com.baidu.tieba.tbadkCore.d.cdu().d("1~" + str, this.fqS.bcp().bhG().getSortType(), this.fqS.bcp().bhG().getIsGood(), this.fqS.bcp().bhG().getCategoryId()), false);
        }
    }

    private void aCh() {
        this.bUq = new LikeModel(this.fqS.getPageContext());
        this.bUq.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                r rVar;
                boolean z = false;
                FrsViewData bcR = f.this.fqS.bcR();
                if (bcR != null && bcR.getForum() != null && obj != null) {
                    if (AntiHelper.aB(f.this.bUq.getErrorCode(), f.this.bUq.getErrorString())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.bUq.getBlockPopInfoData(), f.this.fvT) != null) {
                            TiebaStatic.log(new am("c12534").T("obj_locate", at.a.bLq));
                            return;
                        }
                        return;
                    }
                    String name = bcR.getForum().getName();
                    String id = bcR.getForum().getId();
                    if (!(obj instanceof r)) {
                        rVar = null;
                    } else {
                        rVar = (r) obj;
                    }
                    boolean z2 = rVar != null && f.this.bUq.getErrorCode() == 0;
                    if (rVar.getErrorCode() == 3250013) {
                        BdToast.b(TbadkCoreApplication.getInst().getContext(), rVar.getErrorMsg(), d.f.icon_toast_game_error, 3000).abh();
                    } else {
                        z = z2;
                    }
                    if (rVar == null || !z) {
                        if (f.this.bUq.getErrorCode() == 22) {
                            f.this.fqS.showToast(f.this.getPageContext().getString(d.j.had_liked_forum));
                        } else {
                            f.this.fqS.showToast(f.this.bUq.getErrorString());
                        }
                    } else {
                        f.this.vO(name);
                        rVar.setLike(1);
                        bcR.updateLikeData(rVar);
                        bcR.setLikeFeedForumDataList(rVar.cdB());
                        f.this.a(bcR, f.this.fvP);
                        f.this.fvP = true;
                        f.this.fqS.showToast(f.this.getPageContext().getResources().getString(d.j.attention_success));
                        f.this.l(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                    }
                    f.this.fqS.au(Boolean.valueOf(z));
                }
            }
        });
    }

    private void bjl() {
        this.fvM = new w();
        this.fvM.setFrom("from_frs");
        this.fvM.a(new w.a() { // from class: com.baidu.tieba.frs.vc.f.3
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void s(String str, long j) {
                FrsViewData bcR = f.this.fqS.bcR();
                if (bcR != null && bcR.getForum() != null) {
                    String name = bcR.getForum().getName();
                    String id = bcR.getForum().getId();
                    if (j == com.baidu.adp.lib.g.b.d(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.vO(str);
                        bcR.getForum().setLike(0);
                        f.this.rx(0);
                        f.this.fqS.at(true);
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
        com.baidu.tieba.im.settingcache.d.bwc().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void I(int i, int i2, int i3) {
        FrsViewData bcR;
        if (i > 0 && i2 > 0 && (bcR = this.fqS.bcR()) != null && bcR.getForum() != null && bcR.getSignData() != null) {
            ForumData forum = bcR.getForum();
            SignData signData = bcR.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            bcR.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
            int i4 = -1;
            if (bji()) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void bfs() {
        if (this.fvG != null) {
            this.fvG.bfs();
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
            return ((frsViewData.getStar() == null || frsViewData.getStar().cdC() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || v.T(frsViewData.getActivityHeadData().Xf())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().Xn(), true)))) ? false : true;
        }
        return false;
    }

    public void rA(int i) {
        View findViewById;
        if (this.fvG != null && this.fvG.bka() != null && (findViewById = this.fvG.bka().findViewById(d.g.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.fvQ != null) {
            this.fvQ.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.fvS = frsTabViewController;
    }
}
