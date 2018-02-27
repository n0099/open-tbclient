package com.baidu.tieba.frs.g;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.q;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.message.SignMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private LikeModel ccU;
    private final View.OnClickListener dFR;
    private FrsHeaderViewContainer dGl;
    private com.baidu.tieba.frs.i dSJ;
    private com.baidu.tieba.frs.view.c dVe;
    private int dVf;
    private int dVg;
    private String dVh;
    private Runnable dVi;
    private int dVj;
    private boolean dVk;
    private w dVl;
    private boolean dVm;
    private com.baidu.tieba.frs.entelechy.b.a dVn;
    private boolean dVo;
    private com.baidu.tieba.e.a dVp;
    private boolean dVq;
    private com.baidu.tieba.frs.c.a.a dVr;
    private BdUniqueId dVs;
    private AntiHelper.a dVt;
    private CustomMessageListener dVu;
    private Runnable dVv;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(com.baidu.tieba.frs.i iVar, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(iVar.getPageContext());
        this.dGl = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.dVh = null;
        this.dVk = false;
        this.ccU = null;
        this.dVl = null;
        this.dVm = false;
        this.dVq = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.g.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12536").s("obj_locate", aq.a.aXz));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12535").s("obj_locate", aq.a.aXz));
            }
        };
        this.dVt = new AntiHelper.a() { // from class: com.baidu.tieba.frs.g.f.4
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12536").s("obj_locate", aq.a.aXB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12535").s("obj_locate", aq.a.aXB));
            }
        };
        this.dVu = new CustomMessageListener(2001425) { // from class: com.baidu.tieba.frs.g.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SignData signData;
                boolean z;
                int i;
                l avk = f.this.dSJ.avk();
                if (avk != null && avk.bar() != null && avk.bar().getName() != null && avk.bar().getName().equals(FrsActivityStatic.forumName)) {
                    if (customResponsedMessage == null || customResponsedMessage.getOrginalMessage().getTag() == f.this.dVs) {
                        TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_end_time", System.currentTimeMillis() + "");
                        String name = avk.bar().getName();
                        SignMessage signMessage = (SignMessage) customResponsedMessage;
                        if (AntiHelper.vR(signMessage.mSignErrorCode) && signMessage.signData != null) {
                            if (AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener) != null) {
                                TiebaStatic.log(new ak("c12534").s("obj_locate", aq.a.aXz));
                                return;
                            }
                            return;
                        }
                        if (signMessage == null || signMessage.signData == null) {
                            signData = null;
                            z = false;
                        } else {
                            SignData signData2 = signMessage.signData;
                            if (signData2.forumId != null && signData2.forumId.equals(avk.bar().getId())) {
                                f.this.mr(name);
                                avk.d(signData2);
                                signData2.forumId = avk.bar().getId();
                                signData2.forumName = avk.bar().getName();
                                signData = signData2;
                                z = true;
                            } else {
                                return;
                            }
                        }
                        if (z) {
                            int user_level = avk.bar().getUser_level();
                            if (f.this.aAp()) {
                                i = avk.bar().getUser_level();
                                if (user_level >= i) {
                                    i++;
                                }
                            } else {
                                i = user_level;
                            }
                            TbadkCoreApplication.getInst().addSignedForum(name, signData.sign_bonus_point, i);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                            if (AntiHelper.vR(signMessage.mSignErrorCode)) {
                                AntiHelper.ar(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                                return;
                            } else if (signData.mContriInfo != null && signData.mContriInfo.isShowToast()) {
                                f.this.dSJ.a(signData.mContriInfo);
                                return;
                            } else if (!f.this.aAn()) {
                                f.this.dSJ.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                                return;
                            } else {
                                f.this.dSJ.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                                return;
                            }
                        }
                        if (signMessage.mSignErrorCode == 160002) {
                            f.this.nR(1);
                        }
                        f.this.dSJ.showToast(signMessage.mSignErrorString);
                    }
                }
            }
        };
        this.dVv = new Runnable() { // from class: com.baidu.tieba.frs.g.f.8
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.dGl != null) {
                    int childCount = f.this.dGl.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(f.this.dGl.getChildAt(i));
                    }
                }
            }

            private void refreshImage(View view) {
                if (view != null) {
                    if (view instanceof com.baidu.adp.b.a.i) {
                        ((com.baidu.adp.b.a.i) view).refresh();
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
        this.dFR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l avk = f.this.dSJ.avk();
                if (avk != null && avk.bar() != null && f.this.dVe != null && (view == f.this.dVe.aAP() || view == f.this.dVe.aAQ() || view == f.this.dVe.aAR())) {
                    if (f.this.dSJ != null && avk.bar() != null) {
                        TiebaStatic.log(new ak("c12046").ab(ImageViewerConfig.FORUM_ID, avk.bar().getId()).s("obj_locate", f.this.dSJ.avm() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), avk.bar().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == d.g.tv_love) {
                    if (!f.this.dSJ.avl()) {
                        if (!com.baidu.adp.lib.util.j.oJ()) {
                            f.this.dSJ.showToast(d.j.neterror);
                        } else if (!ay.ba(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new ak("c10517").s("obj_locate", 1).ab(ImageViewerConfig.FORUM_ID, f.this.dSJ.getForumId()));
                        } else {
                            f.this.gt(true);
                        }
                    }
                } else if (id == d.g.tv_sign) {
                    if (!f.this.dSJ.avl()) {
                        if (!com.baidu.adp.lib.util.j.oJ()) {
                            f.this.dSJ.showToast(d.j.neterror);
                        } else if (ay.ba(f.this.mContext.getPageActivity())) {
                            if (!f.this.aAo()) {
                                f.this.aAr();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(f.this.dSJ.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.h(f.this.dSJ.getForumId(), 0), 24002)));
                            }
                        }
                    }
                } else if (id == d.g.frs_header_games) {
                    if (ay.ba(f.this.mContext.getPageActivity()) && avk != null && avk.bvd() != null) {
                        aw.Dt().a((TbPageContext) f.this.getPageContext(), new String[]{avk.bvd()}, true);
                    }
                } else if (id == d.g.frs_bawu_center) {
                    if (avk != null && avk.getUserData() != null && avk.getUserData().isBawu()) {
                        String bvk = avk.bvk();
                        if (!am.isEmpty(bvk)) {
                            com.baidu.tbadk.browser.b.R(f.this.getPageContext().getPageActivity(), bvk);
                            if (avk.bar() != null) {
                                TiebaStatic.log(new ak("c10502").ab(ImageViewerConfig.FORUM_ID, avk.bar().getId()).ab("uid", avk.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == d.g.level_container && !f.this.dSJ.avl() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page")) && f.this.dVe != null) {
                        f.this.dVe.p(view, false);
                    }
                }
            }
        };
        this.dSJ = iVar;
        this.dVn = aVar;
        this.dGl = frsHeaderViewContainer;
        this.dVr = new com.baidu.tieba.frs.c.a(iVar.akN());
        this.dVs = BdUniqueId.gen();
        this.dVp = new com.baidu.tieba.e.a();
        this.dVp.a(new a.InterfaceC0143a() { // from class: com.baidu.tieba.frs.g.f.6
            @Override // com.baidu.tieba.e.a.InterfaceC0143a
            public void aY(int i, int i2) {
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0143a
            public void aZ(int i, int i2) {
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0143a
            public void ba(int i, int i2) {
            }
        });
    }

    public void o(Bundle bundle) {
        this.dSJ.registerListener(this.dVu);
        Xx();
        aAs();
        this.dVk = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.dVe != null) {
            this.dVe.onDestory();
        }
        if (this.ccU != null) {
            this.ccU.bwk();
        }
        if (this.dVi != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.dVi);
        }
    }

    public void onActivityStop() {
        if (this.dVe != null) {
            this.dVe.onStop();
        }
        if (this.dGl != null) {
            this.dGl.removeCallbacks(this.dVv);
        }
    }

    public void gr(boolean z) {
        if (this.dVe != null) {
            this.dVe.gr(z);
        }
    }

    public boolean nN(int i) {
        this.mSkinType = i;
        if (this.dVe != null) {
            this.dVe.changeSkinType(i);
        }
        if (this.dVr != null) {
            this.dVr.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    public void gs(boolean z) {
        if (z) {
            if (this.dVe != null) {
                this.dGl.removeHeaderView(this.dVe.aAN());
                this.dVm = false;
            }
        } else if (this.dVe != null && this.dVe.aAN() != null && !this.dVm) {
            this.dGl.addHeaderView(this.dVe.aAN(), this.dGl.getHeaderViewsCount());
            this.dVm = true;
        }
    }

    public void a(String str, l lVar) {
        this.mPageType = str;
        if ("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) {
            if (lVar != null && lVar.buU() != null && lVar.buU().xS() != null && lVar.buU().xS().size() >= 1) {
                a(lVar.buU().xS().get(0));
            } else {
                this.dVq = false;
                if (this.dGl != null && this.dVr != null && this.dVr.getHeaderView() != null) {
                    this.dGl.removeHeaderView(this.dVr.getHeaderView());
                }
            }
            if (lVar != null && lVar.getUserData() != null && lVar.bar() != null) {
                m(str, lVar.getUserData().getIsMem(), lVar.bar().isLike());
            }
        }
    }

    public boolean aAg() {
        return this.dVq;
    }

    private void a(q qVar) {
        if (qVar == null) {
            this.dVq = false;
        } else if (this.dGl == null || this.dVr == null || this.dVr.getHeaderView() == null) {
            this.dVq = false;
        } else {
            this.dVq = true;
            this.dGl.removeHeaderView(this.dVr.getHeaderView());
            this.dGl.addHeaderView(this.dVr.getHeaderView());
            this.dVr.hB(qVar.getImageUrl());
            this.dVr.setTitle(qVar.getTitle());
            this.dVr.setSchemaUrl(qVar.getLinkUrl());
        }
    }

    public void m(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.dVh, str);
        this.dVj = i2;
        this.dVh = str;
        aAi();
        if (this.dVe == null || z) {
            this.dVe = this.dVn.a(str, this.dSJ, i);
            this.dVe.changeSkinType(this.mSkinType);
            this.dVe.l(this.dFR);
        }
        this.dGl.addHeaderView(this.dVe.getView());
        int t = com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst(), d.e.tbds44);
        this.dVe.x(0, t, 0, t);
        aAj();
    }

    public void aAh() {
        if (!this.dVm && this.dVe != null) {
            this.dGl.addHeaderView(this.dVe.aAN());
            if (this.dVe.aAO() != null && this.dSJ.Ey() != null) {
                this.dSJ.Ey().addHeaderView(this.dVe.aAO(), 0);
            }
            this.dVm = true;
        }
    }

    private void aAi() {
        if (("normal_page".equals(this.dVh) || "frs_page".equals(this.dVh) || "book_page".equals(this.dVh)) && this.dVe != null) {
            this.dGl.removeHeaderView(this.dVe.getView());
            this.dGl.removeHeaderView(this.dVe.aAN());
            if (this.dVe.aAO() != null && this.dSJ.Ey() != null) {
                this.dSJ.Ey().removeHeaderView(this.dVe.aAO());
            }
        }
        this.dVm = false;
    }

    private void aAj() {
        if (this.dVi == null) {
            this.dVi = new Runnable() { // from class: com.baidu.tieba.frs.g.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.dSJ.auS() == null || !f.this.dSJ.auS().avl()) && f.this.dGl.isShown() && f.this.dSJ.isPrimary() && !f.this.dVk && f.this.dVj == 1 && f.this.dSJ.auS() != null && f.this.dSJ.auS().avF() != null && !f.this.dSJ.auS().avF().axD() && !f.this.dSJ.avp()) {
                            if (("frs_page".equals(f.this.dVh) || "normal_page".equals(f.this.dVh) || "book_page".equals(f.this.dVh)) && f.this.dVe != null && f.this.dVe.aAM()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.axf();
                                f.this.dSJ.dDZ = true;
                                f.this.dVk = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.ns().postDelayed(this.dVi, 4000L);
    }

    public void f(l lVar) {
        if (lVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(lVar.bar(), lVar);
            }
        }
    }

    public void b(ForumData forumData, l lVar) {
        if (forumData != null && lVar != null) {
            float a = a(forumData);
            if (this.dVe != null) {
                this.dVe.a(forumData, lVar);
                this.dVe.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.dVe.oe(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.dVe.gz(false);
                        return;
                    }
                    this.dVe.gz(true);
                    this.dVe.oe(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.dVf = forumData.getLevelupScore();
        this.dVg = forumData.getCurScore();
        if (this.dVf > 0) {
            return this.dVg / this.dVf;
        }
        return 0.0f;
    }

    public void nO(int i) {
        if (i > 1) {
            if (this.dVe != null) {
                this.dVe.gA(false);
            }
        } else if (this.dVe != null) {
            this.dVe.gA(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void aAk() {
        if (this.dGl != null) {
            this.dGl.removeCallbacks(this.dVv);
            this.dGl.postDelayed(this.dVv, 100L);
        }
    }

    public void f(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            aAl();
        }
    }

    public void setIsMem(int i) {
        if (this.dVe != null) {
            this.dVe.setMemberType(i);
        }
    }

    public void axf() {
        if (("normal_page".equals(this.dVh) || "frs_page".equals(this.dVh) || "book_page".equals(this.dVh)) && this.dVe != null) {
            this.dVe.axf();
        }
    }

    public void aAl() {
        if (this.dVe != null) {
            this.dVe.axh();
        }
    }

    public void a(l lVar, boolean z) {
        if (lVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, lVar.bar(), lVar, z);
            }
        }
    }

    public void aAm() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            nQ(0);
        }
    }

    public void nP(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            nQ(i);
        }
    }

    public void nQ(int i) {
        if (this.dVe != null) {
            this.dVe.od(i);
        }
    }

    public void a(int i, ForumData forumData, l lVar, boolean z) {
        if (this.dVe != null) {
            this.dVe.a(forumData, lVar);
            if (forumData != null) {
                this.dVe.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.dVe.gz(false);
                }
            }
        }
    }

    public boolean aAn() {
        if (("normal_page".equals(this.dVh) || "frs_page".equals(this.dVh) || "book_page".equals(this.dVh)) && this.dVe != null) {
            return this.dVe.aAL();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.c cVar, SignData signData) {
        if (cVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.dVf - this.dVg) {
                z = true;
                this.dVf = signData.levelup_score;
            }
            this.dVg = i + this.dVg;
            if (this.dVg > this.dVf) {
                this.dVg = this.dVf;
            }
            if (this.dVf != 0) {
                f = this.dVg / this.dVf;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            cVar.c(z, f);
        }
    }

    public void nR(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.dVe != null) {
            this.dVe.oe(i);
        }
    }

    public void g(l lVar) {
        SignData signData;
        ForumData bar;
        if (lVar != null && lVar.bar() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.dVe != null && (signData = lVar.bar().getSignData()) != null && (bar = lVar.bar()) != null) {
                this.dVe.a(bar, lVar);
                this.dVe.oe(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.dVe.aAL()) {
                    a(this.dVe, signData);
                    bar.setCurScore(this.dVg);
                    bar.setLevelupScore(this.dVf);
                    this.dVe.a(bar, lVar);
                }
            }
        }
    }

    public boolean aAo() {
        if (("normal_page".equals(this.dVh) || "frs_page".equals(this.dVh) || "book_page".equals(this.dVh)) && this.dVe != null) {
            return this.dVe.aAo();
        }
        return false;
    }

    public boolean aAp() {
        if (("normal_page".equals(this.dVh) || "frs_page".equals(this.dVh) || "book_page".equals(this.dVh)) && this.dVe != null) {
            return this.dVe.aAp();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.i */
    /* JADX WARN: Multi-variable type inference failed */
    public void gt(boolean z) {
        if (this.dSJ != null) {
            l avk = this.dSJ.avk();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.dSJ.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_INITED)));
            } else if (avk != null && avk.bar() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.dSJ.getFrom())) {
                    TiebaStatic.log(new ak("c10356").ab(ImageViewerConfig.FORUM_ID, avk.bar().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.dSJ.getFrom())) {
                    TiebaStatic.log(new ak("c10590").s("obj_type", 2).ab(ImageViewerConfig.FORUM_ID, avk.bar().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.dSJ.getFrom())) {
                    TiebaStatic.log(new ak("c10587").s("obj_type", 2).ab(ImageViewerConfig.FORUM_ID, avk.bar().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.dSJ.getFrom())) {
                    TiebaStatic.log(new ak("c10578").s("obj_type", 2).ab(ImageViewerConfig.FORUM_ID, avk.bar().getId()));
                }
                this.ccU.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.dSJ.getFrom())) {
                    TiebaStatic.eventStat(this.dSJ.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.dSJ.getFrom())) {
                    TiebaStatic.log(new ak("c10359").ab(ImageViewerConfig.FORUM_ID, avk.bar().getId()));
                }
                this.ccU.L(avk.bar().getName(), avk.bar().getId(), "FRS");
                this.dVo = z;
            }
        }
    }

    public void aAq() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.dSJ.avk() != null && this.dSJ.avk().bar() != null && this.dSJ.avk().bar().getName() != null) {
            str = this.dSJ.avk().bar().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.dk(String.format(getPageContext().getString(d.j.attention_cancel_dialog_content), str));
        } else {
            aVar.dk(getPageContext().getString(d.j.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(d.j.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.g.f.10
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.i */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                l avk = f.this.dSJ.avk();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.dSJ.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) f.this.getPageContext().getPageActivity(), f.this.getPageContext().getString(d.j.login_to_use), true, 11036)));
                } else if (avk != null && avk.bar() != null) {
                    f.this.dVl.t(avk.bar().getName(), com.baidu.adp.lib.g.b.c(avk.bar().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(d.j.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.g.f.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).AU();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.i */
    /* JADX WARN: Multi-variable type inference failed */
    public void aAr() {
        l avk = this.dSJ.avk();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.dSJ.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, 11014)));
        } else if (avk != null && avk.bar() != null) {
            FrsActivityStatic.forumName = avk.bar().getName() == null ? "" : avk.bar().getName();
            CustomMessage customMessage = new CustomMessage(2001425, avk.bar());
            customMessage.setTag(this.dVs);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mr(String str) {
        if (this.dSJ.auN() != null && this.dSJ.auN().azl() != null) {
            com.baidu.tieba.tbadkCore.c.buH().Y(com.baidu.tieba.tbadkCore.c.buH().d(str, this.dSJ.auN().azl().YL(), this.dSJ.auN().azl().getIsGood(), this.dSJ.auN().azl().getCategoryId()), false);
        }
    }

    private void Xx() {
        this.ccU = new LikeModel(this.dSJ.getPageContext());
        this.ccU.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.g.f.2
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                r rVar;
                l avk = f.this.dSJ.avk();
                if (avk != null && avk.bar() != null && obj != null) {
                    if (AntiHelper.vR(f.this.ccU.getErrorCode())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.ccU.getBlockPopInfoData(), f.this.dVt) != null) {
                            TiebaStatic.log(new ak("c12534").s("obj_locate", aq.a.aXB));
                            return;
                        }
                        return;
                    }
                    String name = avk.bar().getName();
                    String id = avk.bar().getId();
                    boolean z = false;
                    if (!(obj instanceof r)) {
                        rVar = null;
                    } else {
                        rVar = (r) obj;
                    }
                    if (rVar != null && f.this.ccU.getErrorCode() == 0) {
                        z = true;
                    }
                    if (rVar == null || !z) {
                        if (f.this.ccU.getErrorCode() == 22) {
                            f.this.dSJ.showToast(f.this.getPageContext().getString(d.j.had_liked_forum));
                        } else {
                            f.this.dSJ.showToast(f.this.ccU.getErrorString());
                        }
                    } else {
                        f.this.mr(name);
                        rVar.setLike(1);
                        avk.c(rVar);
                        avk.ds(rVar.buM());
                        f.this.a(avk, f.this.dVo);
                        f.this.dVo = true;
                        f.this.dSJ.showToast(f.this.getPageContext().getResources().getString(d.j.attention_success));
                        f.this.f(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                    }
                    f.this.dSJ.aX(Boolean.valueOf(z));
                }
            }
        });
    }

    private void aAs() {
        this.dVl = new w();
        this.dVl.setFrom("from_frs");
        this.dVl.a(new w.a() { // from class: com.baidu.tieba.frs.g.f.3
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void m(String str, long j) {
                l avk = f.this.dSJ.avk();
                if (avk != null && avk.bar() != null) {
                    String name = avk.bar().getName();
                    String id = avk.bar().getId();
                    if (j == com.baidu.adp.lib.g.b.c(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.mr(str);
                        avk.bar().setLike(0);
                        f.this.nP(0);
                        f.this.dSJ.aW(true);
                        f.this.f(false, id);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003004, id));
                        r rVar = new r();
                        rVar.setLike(0);
                        rVar.setFid(id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                    }
                }
            }

            @Override // com.baidu.tieba.tbadkCore.w.a
            public void n(String str, long j) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.aLV().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void M(int i, int i2, int i3) {
        l avk;
        if (i > 0 && i2 > 0 && (avk = this.dSJ.avk()) != null && avk.bar() != null && avk.getSignData() != null) {
            ForumData bar = avk.bar();
            SignData signData = avk.getSignData();
            signData.levelup_score = bar.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            avk.d(signData);
            signData.forumId = bar.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
            int i4 = -1;
            if (aAp()) {
                i4 = bar.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(bar.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void awT() {
        if (this.dVe != null) {
            this.dVe.awT();
        }
    }

    public static boolean h(l lVar) {
        if (lVar != null) {
            return (lVar.bvo() == null || StringUtils.isNull(lVar.bvo().xT(), true) || lVar.bvo().xT().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean i(l lVar) {
        if (lVar != null) {
            return ((lVar.buT() == null || lVar.buT().bvF() != 1) && lVar.bvn() == null && (lVar.buU() == null || v.E(lVar.buU().xS())) && ((lVar.bar() == null || lVar.bar().getFrsBannerData() == null || lVar.bar().getFrsBannerData().getType() != 2) && (lVar.bvp() == null || StringUtils.isNull(lVar.bvp().ya(), true)))) ? false : true;
        }
        return false;
    }

    public void nS(int i) {
        View findViewById;
        if (this.dVe != null && this.dVe.aAN() != null && (findViewById = this.dVe.aAN().findViewById(d.g.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.dVp != null) {
            this.dVp.onTouchEvent(motionEvent);
        }
    }
}
