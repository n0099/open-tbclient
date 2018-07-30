package com.baidu.tieba.frs.vc;

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
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.message.SignMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.d;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private LikeModel azq;
    private FrsFragment dDw;
    private int dGA;
    private String dGB;
    private Runnable dGC;
    private int dGD;
    private boolean dGE;
    private w dGF;
    private boolean dGG;
    private com.baidu.tieba.frs.entelechy.b.a dGH;
    private boolean dGI;
    private com.baidu.tieba.f.a dGJ;
    private boolean dGK;
    private com.baidu.tieba.frs.c.a.a dGL;
    private com.baidu.tieba.frs.c.a.a dGM;
    private BdUniqueId dGN;
    private FrsTabViewController dGO;
    private AntiHelper.a dGP;
    private CustomMessageListener dGQ;
    private Runnable dGR;
    private com.baidu.tieba.frs.view.b dGy;
    private int dGz;
    private FrsHeaderViewContainer doE;
    private final View.OnClickListener doi;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.doE = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.dGB = null;
        this.dGE = false;
        this.azq = null;
        this.dGF = null;
        this.dGG = false;
        this.dGK = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an("c12536").r("obj_locate", at.a.arr));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an("c12535").r("obj_locate", at.a.arr));
            }
        };
        this.dGP = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.4
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an("c12536").r("obj_locate", at.a.art));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an("c12535").r("obj_locate", at.a.art));
            }
        };
        this.dGQ = new CustomMessageListener(2001425) { // from class: com.baidu.tieba.frs.vc.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SignData signData;
                boolean z;
                int i;
                l auD = f.this.dDw.auD();
                if (auD != null && auD.aZl() != null && auD.aZl().getName() != null && auD.aZl().getName().equals(FrsActivityStatic.forumName)) {
                    if (customResponsedMessage == null || customResponsedMessage.getOrginalMessage().getTag() == f.this.dGN) {
                        TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_end_time", System.currentTimeMillis() + "");
                        String name = auD.aZl().getName();
                        SignMessage signMessage = (SignMessage) customResponsedMessage;
                        if (AntiHelper.al(signMessage.mSignErrorCode, signMessage.mSignErrorString) && signMessage.signData != null) {
                            if (AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener) != null) {
                                TiebaStatic.log(new an("c12534").r("obj_locate", at.a.arr));
                                return;
                            }
                            return;
                        }
                        if (signMessage == null || signMessage.signData == null) {
                            signData = null;
                            z = false;
                        } else {
                            SignData signData2 = signMessage.signData;
                            if (signData2.forumId != null && signData2.forumId.equals(auD.aZl().getId())) {
                                f.this.nd(name);
                                auD.d(signData2);
                                signData2.forumId = auD.aZl().getId();
                                signData2.forumName = auD.aZl().getName();
                                signData = signData2;
                                z = true;
                            } else {
                                return;
                            }
                        }
                        if (z) {
                            int user_level = auD.aZl().getUser_level();
                            if (f.this.aAI()) {
                                i = auD.aZl().getUser_level();
                                if (user_level >= i) {
                                    i++;
                                }
                            } else {
                                i = user_level;
                            }
                            TbadkCoreApplication.getInst().addSignedForum(name, signData.sign_bonus_point, i);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                            if (AntiHelper.al(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                                AntiHelper.aq(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                                return;
                            } else if (signData.mContriInfo != null && signData.mContriInfo.isShowToast()) {
                                f.this.dDw.a(signData.mContriInfo);
                                return;
                            } else if (!f.this.aAG()) {
                                f.this.dDw.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                                return;
                            } else {
                                f.this.dDw.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                                return;
                            }
                        }
                        if (signMessage.mSignErrorCode == 160002) {
                            f.this.lO(1);
                        }
                        f.this.dDw.showToast(signMessage.mSignErrorString);
                    }
                }
            }
        };
        this.dGR = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.8
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.doE != null) {
                    int childCount = f.this.doE.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(f.this.doE.getChildAt(i));
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
        this.doi = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l auD = f.this.dDw.auD();
                if (auD != null && auD.aZl() != null && f.this.dGy != null && (view == f.this.dGy.aBk() || view == f.this.dGy.aBl() || view == f.this.dGy.aBm())) {
                    if (f.this.dDw != null && auD.aZl() != null) {
                        TiebaStatic.log(new an("c12046").af(ImageViewerConfig.FORUM_ID, auD.aZl().getId()).r("obj_locate", f.this.dDw.auF() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), auD.aZl().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == d.g.tv_love) {
                    if (!f.this.dDw.auE()) {
                        if (!com.baidu.adp.lib.util.j.jE()) {
                            f.this.dDw.showToast(d.j.neterror);
                        } else if (!ba.aV(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new an("c10517").r("obj_locate", 1).af(ImageViewerConfig.FORUM_ID, f.this.dDw.getForumId()));
                        } else {
                            f.this.gp(true);
                        }
                    }
                } else if (id == d.g.tv_sign) {
                    if (!f.this.dDw.auE()) {
                        if (!com.baidu.adp.lib.util.j.jE()) {
                            f.this.dDw.showToast(d.j.neterror);
                        } else if (ba.aV(f.this.mContext.getPageActivity())) {
                            if (!f.this.aAH()) {
                                f.this.aAK();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(f.this.dDw.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.g(f.this.dDw.getForumId(), 0), 24002)));
                            }
                        }
                    }
                } else if (id == d.g.frs_header_games) {
                    if (ba.aV(f.this.mContext.getPageActivity()) && auD != null && auD.buo() != null) {
                        ay.zK().a((TbPageContext) f.this.getPageContext(), new String[]{auD.buo()}, true);
                    }
                } else if (id == d.g.frs_bawu_center) {
                    if (auD != null && auD.getUserData() != null && auD.getUserData().isBawu()) {
                        String bus = auD.bus();
                        if (!ap.isEmpty(bus)) {
                            com.baidu.tbadk.browser.a.Q(f.this.getPageContext().getPageActivity(), bus);
                            if (auD.aZl() != null) {
                                TiebaStatic.log(new an("c10502").af(ImageViewerConfig.FORUM_ID, auD.aZl().getId()).af("uid", auD.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == d.g.level_container && !f.this.dDw.auE() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page") || f.this.mPageType.equals("brand_page")) && f.this.dGy != null) {
                        f.this.dGy.i(view, false);
                    }
                }
            }
        };
        this.dDw = frsFragment;
        this.dGH = aVar;
        this.doE = frsHeaderViewContainer;
        this.dGL = new com.baidu.tieba.frs.c.b(frsFragment.aiy());
        this.dGM = new com.baidu.tieba.frs.c.a(frsFragment.aiy());
        this.dGN = BdUniqueId.gen();
        this.dGJ = new com.baidu.tieba.f.a();
        this.dGJ.a(new a.InterfaceC0145a() { // from class: com.baidu.tieba.frs.vc.f.6
            @Override // com.baidu.tieba.f.a.InterfaceC0145a
            public void Y(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0145a
            public void Z(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0145a
            public void aa(int i, int i2) {
            }
        });
    }

    public void m(Bundle bundle) {
        this.dDw.registerListener(this.dGQ);
        TV();
        aAL();
        this.dGE = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.dGy != null) {
            this.dGy.onDestory();
        }
        if (this.azq != null) {
            this.azq.bvu();
        }
        if (this.dGC != null) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.dGC);
        }
    }

    public void onActivityStop() {
        if (this.dGy != null) {
            this.dGy.onStop();
        }
        if (this.doE != null) {
            this.doE.removeCallbacks(this.dGR);
        }
    }

    public void fA(boolean z) {
        if (this.dGy != null) {
            this.dGy.fA(z);
        }
    }

    public boolean lK(int i) {
        this.mSkinType = i;
        if (this.dGy != null) {
            this.dGy.changeSkinType(i);
        }
        if (this.dGL != null) {
            this.dGL.onChangeSkinType(i);
        }
        if (this.dGM != null) {
            this.dGM.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    public void go(boolean z) {
        if (z) {
            if (this.dGy != null) {
                this.doE.removeHeaderView(this.dGy.aBj());
                this.dGG = false;
            }
        } else if (this.dGy != null && this.dGy.aBj() != null && !this.dGG) {
            this.doE.addHeaderView(this.dGy.aBj(), this.doE.getHeaderViewsCount());
            this.dGG = true;
        }
    }

    public void a(String str, l lVar) {
        this.mPageType = str;
        if ("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str) || "brand_page".equals(str)) {
            if (!"brand_page".equals(str) && lVar != null && lVar.bug() != null && lVar.bug().tM() != null && lVar.bug().tM().size() >= 1) {
                a(lVar.bug().tM().get(0), false);
            } else if (!"brand_page".equals(str) && lVar != null && lVar.buf() != null && !StringUtils.isNull(lVar.buf().buU())) {
                q qVar = new q();
                qVar.setLinkUrl("");
                qVar.setImageUrl(lVar.buf().buU());
                a(qVar, true);
            } else if (lVar != null && "brand_page".equals(str) && lVar.bug() != null && lVar.bug().tM() != null && lVar.bug().tM().size() >= 1) {
                n(str, lVar.getUserData().getIsMem(), lVar.aZl().isLike());
                g(lVar);
            } else {
                this.dGK = false;
                if (this.doE != null && this.dGL != null && this.dGL.getHeaderView() != null) {
                    this.doE.removeHeaderView(this.dGL.getHeaderView());
                }
                if (this.doE != null && this.dGM != null && this.dGM.getHeaderView() != null) {
                    this.doE.removeHeaderView(this.dGM.getHeaderView());
                }
            }
            if (lVar != null && lVar.getUserData() != null && lVar.aZl() != null && !"brand_page".equals(str)) {
                m(str, lVar.getUserData().getIsMem(), lVar.aZl().isLike());
            }
        }
    }

    public boolean aAz() {
        return this.dGK;
    }

    private void a(q qVar, boolean z) {
        if (qVar == null) {
            this.dGK = false;
        } else if (this.doE == null || this.dGL == null || this.dGL.getHeaderView() == null) {
            this.dGK = false;
        } else {
            this.dGK = true;
            this.doE.removeHeaderView(this.dGL.getHeaderView());
            this.doE.addHeaderView(this.dGL.getHeaderView());
            this.dGL.hU(qVar.getImageUrl());
            this.dGL.setTitle(qVar.getTitle());
            this.dGL.setSchemaUrl(qVar.getLinkUrl());
            if (z) {
                this.dGL.hideTitle();
            }
        }
    }

    private void g(l lVar) {
        if (lVar == null || lVar.bug() == null || com.baidu.tbadk.core.util.w.z(lVar.bug().tM()) || this.doE == null || this.dGy == null || this.dGy.getView() == null || this.dGM == null || this.dGM.getHeaderView() == null) {
            this.dGK = false;
            return;
        }
        q qVar = lVar.bug().tM().get(0);
        if (qVar == null) {
            this.dGK = false;
            return;
        }
        this.dGK = true;
        this.dGy.getView().setBackgroundColor(0);
        this.dGM.azm().removeView(this.dGy.getView());
        this.dGM.azm().addView(this.dGy.getView());
        this.doE.removeHeaderView(this.dGM.getHeaderView());
        this.doE.addHeaderView(this.dGM.getHeaderView());
        this.dGM.hU(qVar.getImageUrl());
        this.dGM.setSchemaUrl(qVar.getLinkUrl());
        this.dGM.setTitle(qVar.getTitle());
        if (this.dGM instanceof com.baidu.tieba.frs.c.a) {
            ((com.baidu.tieba.frs.c.a) this.dGM).bv(lVar.gMj);
        }
    }

    private void m(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.dGB, str);
        this.dGD = i2;
        this.dGB = str;
        aAB();
        if (this.dGy == null || z) {
            this.dGy = this.dGH.a(str, this.dDw, i);
            this.dGy.changeSkinType(this.mSkinType);
            this.dGy.q(this.doi);
        }
        this.doE.addHeaderView(this.dGy.getView());
        int f = com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.tbds44);
        this.dGy.p(0, f, 0, f);
        aAC();
        if (this.dGO != null) {
            this.dGO.aD(this.dGy.awE());
        }
    }

    private void n(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.dGB, str);
        this.dGD = i2;
        this.dGB = str;
        aAB();
        if (this.dGy == null || z) {
            this.dGy = this.dGH.a(str, this.dDw, i);
            this.dGy.changeSkinType(this.mSkinType);
            this.dGy.q(this.doi);
            this.dGy.awJ();
        }
        this.dGy.p(0, com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.tbds132), 0, com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.tbds44));
        aAC();
        if (this.dGO != null) {
            this.dGO.aD(this.dGy.awE());
        }
    }

    public void aAA() {
        if (!this.dGG && this.dGy != null) {
            this.doE.addHeaderView(this.dGy.aBj());
            if (this.dGy.awE() != null && this.dDw.AS() != null) {
                this.dDw.AS().addHeaderView(this.dGy.awE(), 0);
            }
            this.dGG = true;
        }
    }

    private void aAB() {
        if (("normal_page".equals(this.dGB) || "frs_page".equals(this.dGB) || "book_page".equals(this.dGB) || "brand_page".equals(this.dGB)) && this.dGy != null) {
            this.doE.removeHeaderView(this.dGy.getView());
            this.doE.removeHeaderView(this.dGy.aBj());
            if (this.dGy.awE() != null && this.dDw.AS() != null) {
                this.dDw.AS().removeHeaderView(this.dGy.awE());
            }
        }
        this.dGG = false;
    }

    private void aAC() {
        if (this.dGC == null) {
            this.dGC = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.dDw.aum() == null || !f.this.dDw.aum().auE()) && f.this.doE.isShown() && f.this.dDw.isPrimary() && !f.this.dGE && f.this.dGD == 1 && f.this.dDw.aum() != null && f.this.dDw.aum().ave() != null && !f.this.dDw.aum().ave().axq() && f.this.dDw.auI()) {
                            if (("frs_page".equals(f.this.dGB) || "normal_page".equals(f.this.dGB) || "brand_page".equals(f.this.mPageType) || "book_page".equals(f.this.dGB)) && f.this.dGy != null && f.this.dGy.aBi()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.awR();
                                f.this.dDw.dmd = true;
                                f.this.dGE = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.in().postDelayed(this.dGC, 4000L);
    }

    public void h(l lVar) {
        if (lVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                b(lVar.aZl(), lVar);
                if ("brand_page".equals(this.mPageType)) {
                    this.dGy.awK();
                }
            }
        }
    }

    public void b(ForumData forumData, l lVar) {
        if (forumData != null && lVar != null) {
            float b = b(forumData);
            if (this.dGy != null) {
                this.dGy.a(forumData, lVar);
                this.dGy.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                if (forumData.getSignData() != null) {
                    this.dGy.md(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.dGy.gw(false);
                        return;
                    }
                    this.dGy.gw(true);
                    this.dGy.md(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.dGz = forumData.getLevelupScore();
        this.dGA = forumData.getCurScore();
        if (this.dGz > 0) {
            return this.dGA / this.dGz;
        }
        return 0.0f;
    }

    public void lL(int i) {
        if (i > 1) {
            if (this.dGy != null) {
                this.dGy.gx(false);
            }
        } else if (this.dGy != null) {
            this.dGy.gx(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void aAD() {
        if (this.doE != null) {
            this.doE.removeCallbacks(this.dGR);
            this.doE.postDelayed(this.dGR, 100L);
        }
    }

    public void g(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            aAE();
        }
    }

    public void setIsMem(int i) {
        if (this.dGy != null) {
            this.dGy.setMemberType(i);
        }
    }

    public void awR() {
        if (("normal_page".equals(this.dGB) || "frs_page".equals(this.dGB) || "book_page".equals(this.dGB) || "brand_page".equals(this.mPageType)) && this.dGy != null) {
            this.dGy.awR();
        }
    }

    public void aAE() {
        if (this.dGy != null) {
            this.dGy.awT();
        }
    }

    public void a(l lVar, boolean z) {
        if (lVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                a(1, lVar.aZl(), lVar, z);
            }
        }
    }

    public void aAF() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            lN(0);
        }
    }

    public void lM(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            lN(i);
        }
    }

    public void lN(int i) {
        if (this.dGy != null) {
            this.dGy.mc(i);
        }
    }

    public void a(int i, ForumData forumData, l lVar, boolean z) {
        if (this.dGy != null) {
            this.dGy.a(forumData, lVar);
            if (forumData != null) {
                this.dGy.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.dGy.gw(false);
                }
            }
        }
    }

    public boolean aAG() {
        if (("normal_page".equals(this.dGB) || "frs_page".equals(this.dGB) || "book_page".equals(this.dGB) || "brand_page".equals(this.mPageType)) && this.dGy != null) {
            return this.dGy.aBh();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.dGz - this.dGA) {
                z = true;
                this.dGz = signData.levelup_score;
            }
            this.dGA = i + this.dGA;
            if (this.dGA > this.dGz) {
                this.dGA = this.dGz;
            }
            if (this.dGz != 0) {
                f = this.dGA / this.dGz;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.d(z, f);
        }
    }

    public void lO(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.dGy != null) {
            this.dGy.md(i);
        }
    }

    public void i(l lVar) {
        SignData signData;
        ForumData aZl;
        if (lVar != null && lVar.aZl() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.dGy != null && (signData = lVar.aZl().getSignData()) != null && (aZl = lVar.aZl()) != null) {
                this.dGy.a(aZl, lVar);
                this.dGy.md(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.dGy.aBh()) {
                    a(this.dGy, signData);
                    aZl.setCurScore(this.dGA);
                    aZl.setLevelupScore(this.dGz);
                    this.dGy.a(aZl, lVar);
                }
            }
        }
    }

    public boolean aAH() {
        if (("normal_page".equals(this.dGB) || "frs_page".equals(this.dGB) || "book_page".equals(this.dGB) || "brand_page".equals(this.mPageType)) && this.dGy != null) {
            return this.dGy.aAH();
        }
        return false;
    }

    public boolean aAI() {
        if (("normal_page".equals(this.dGB) || "frs_page".equals(this.dGB) || "book_page".equals(this.dGB) || "brand_page".equals(this.mPageType)) && this.dGy != null) {
            return this.dGy.aAI();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void gp(boolean z) {
        if (this.dDw != null) {
            l auD = this.dDw.auD();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.dDw.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11002)));
            } else if (auD != null && auD.aZl() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.dDw.getFrom())) {
                    TiebaStatic.log(new an("c10356").af(ImageViewerConfig.FORUM_ID, auD.aZl().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.dDw.getFrom())) {
                    TiebaStatic.log(new an("c10590").r("obj_type", 2).af(ImageViewerConfig.FORUM_ID, auD.aZl().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.dDw.getFrom())) {
                    TiebaStatic.log(new an("c10587").r("obj_type", 2).af(ImageViewerConfig.FORUM_ID, auD.aZl().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.dDw.getFrom())) {
                    TiebaStatic.log(new an("c10578").r("obj_type", 2).af(ImageViewerConfig.FORUM_ID, auD.aZl().getId()));
                }
                this.azq.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.dDw.getFrom())) {
                    TiebaStatic.eventStat(this.dDw.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.dDw.getFrom())) {
                    TiebaStatic.log(new an("c10359").af(ImageViewerConfig.FORUM_ID, auD.aZl().getId()));
                }
                this.azq.I(auD.aZl().getName(), auD.aZl().getId(), "FRS");
                this.dGI = z;
            }
        }
    }

    public void aAJ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.dDw.auD() != null && this.dDw.auD().aZl() != null && this.dDw.auD().aZl().getName() != null) {
            str = this.dDw.auD().aZl().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.dB(String.format(getPageContext().getString(d.j.attention_cancel_dialog_content), str));
        } else {
            aVar.dB(getPageContext().getString(d.j.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(d.j.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.10
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                l auD = f.this.dDw.auD();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.dDw.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(f.this.getPageContext().getPageActivity(), true, 11036)));
                } else if (auD != null && auD.aZl() != null) {
                    f.this.dGF.t(auD.aZl().getName(), com.baidu.adp.lib.g.b.c(auD.aZl().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(d.j.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).xf();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void aAK() {
        l auD = this.dDw.auD();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.dDw.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11014)));
        } else if (auD != null && auD.aZl() != null) {
            FrsActivityStatic.forumName = auD.aZl().getName() == null ? "" : auD.aZl().getName();
            CustomMessage customMessage = new CustomMessage(2001425, auD.aZl());
            customMessage.setTag(this.dGN);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nd(String str) {
        if (this.dDw.auh() != null && this.dDw.auh().azA() != null) {
            com.baidu.tieba.tbadkCore.c.btR().T(com.baidu.tieba.tbadkCore.c.btR().c(str, this.dDw.auh().azA().Vk(), this.dDw.auh().azA().getIsGood(), this.dDw.auh().azA().getCategoryId()), false);
        }
    }

    private void TV() {
        this.azq = new LikeModel(this.dDw.getPageContext());
        this.azq.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                r rVar;
                boolean z = false;
                l auD = f.this.dDw.auD();
                if (auD != null && auD.aZl() != null && obj != null) {
                    if (AntiHelper.al(f.this.azq.getErrorCode(), f.this.azq.getErrorString())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.azq.getBlockPopInfoData(), f.this.dGP) != null) {
                            TiebaStatic.log(new an("c12534").r("obj_locate", at.a.art));
                            return;
                        }
                        return;
                    }
                    String name = auD.aZl().getName();
                    String id = auD.aZl().getId();
                    if (!(obj instanceof r)) {
                        rVar = null;
                    } else {
                        rVar = (r) obj;
                    }
                    boolean z2 = rVar != null && f.this.azq.getErrorCode() == 0;
                    if (rVar.getErrorCode() == 3250013) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), rVar.getErrorMsg(), d.f.icon_toast_game_error, 3000).xn();
                    } else {
                        z = z2;
                    }
                    if (rVar == null || !z) {
                        if (f.this.azq.getErrorCode() == 22) {
                            f.this.dDw.showToast(f.this.getPageContext().getString(d.j.had_liked_forum));
                        } else {
                            f.this.dDw.showToast(f.this.azq.getErrorString());
                        }
                    } else {
                        f.this.nd(name);
                        rVar.setLike(1);
                        auD.c(rVar);
                        auD.dq(rVar.btY());
                        f.this.a(auD, f.this.dGI);
                        f.this.dGI = true;
                        f.this.dDw.showToast(f.this.getPageContext().getResources().getString(d.j.attention_success));
                        f.this.i(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                    }
                    f.this.dDw.X(Boolean.valueOf(z));
                }
            }
        });
    }

    private void aAL() {
        this.dGF = new w();
        this.dGF.setFrom("from_frs");
        this.dGF.a(new w.a() { // from class: com.baidu.tieba.frs.vc.f.3
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void m(String str, long j) {
                l auD = f.this.dDw.auD();
                if (auD != null && auD.aZl() != null) {
                    String name = auD.aZl().getName();
                    String id = auD.aZl().getId();
                    if (j == com.baidu.adp.lib.g.b.c(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.nd(str);
                        auD.aZl().setLike(0);
                        f.this.lM(0);
                        f.this.dDw.W(true);
                        f.this.i(false, id);
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
    public void i(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.aNv().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void A(int i, int i2, int i3) {
        l auD;
        if (i > 0 && i2 > 0 && (auD = this.dDw.auD()) != null && auD.aZl() != null && auD.getSignData() != null) {
            ForumData aZl = auD.aZl();
            SignData signData = auD.getSignData();
            signData.levelup_score = aZl.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            auD.d(signData);
            signData.forumId = aZl.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
            int i4 = -1;
            if (aAI()) {
                i4 = aZl.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(aZl.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void awB() {
        if (this.dGy != null) {
            this.dGy.awB();
        }
    }

    public static boolean j(l lVar) {
        if (lVar != null) {
            return (lVar.buw() == null || StringUtils.isNull(lVar.buw().tN(), true) || lVar.buw().tN().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean k(l lVar) {
        if (lVar != null) {
            return ((lVar.buf() == null || lVar.buf().buQ() != 1) && lVar.buv() == null && (lVar.bug() == null || com.baidu.tbadk.core.util.w.z(lVar.bug().tM())) && ((lVar.aZl() == null || lVar.aZl().getFrsBannerData() == null || lVar.aZl().getFrsBannerData().getType() != 2) && (lVar.bux() == null || StringUtils.isNull(lVar.bux().tU(), true)))) ? false : true;
        }
        return false;
    }

    public void lP(int i) {
        View findViewById;
        if (this.dGy != null && this.dGy.aBj() != null && (findViewById = this.dGy.aBj().findViewById(d.g.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.dGJ != null) {
            this.dGJ.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.dGO = frsTabViewController;
    }
}
