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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.f;
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
    private LikeModel azn;
    private FrsFragment dDt;
    private boolean dGA;
    private w dGB;
    private boolean dGC;
    private com.baidu.tieba.frs.entelechy.b.a dGD;
    private boolean dGE;
    private com.baidu.tieba.f.a dGF;
    private boolean dGG;
    private com.baidu.tieba.frs.c.a.a dGH;
    private com.baidu.tieba.frs.c.a.a dGI;
    private BdUniqueId dGJ;
    private FrsTabViewController dGK;
    private AntiHelper.a dGL;
    private CustomMessageListener dGM;
    private Runnable dGN;
    private com.baidu.tieba.frs.view.b dGu;
    private int dGv;
    private int dGw;
    private String dGx;
    private Runnable dGy;
    private int dGz;
    private FrsHeaderViewContainer doC;
    private final View.OnClickListener dog;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.doC = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.dGx = null;
        this.dGA = false;
        this.azn = null;
        this.dGB = null;
        this.dGC = false;
        this.dGG = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an("c12536").r("obj_locate", at.a.ars));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an("c12535").r("obj_locate", at.a.ars));
            }
        };
        this.dGL = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.4
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an("c12536").r("obj_locate", at.a.aru));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an("c12535").r("obj_locate", at.a.aru));
            }
        };
        this.dGM = new CustomMessageListener(2001425) { // from class: com.baidu.tieba.frs.vc.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SignData signData;
                boolean z;
                int i;
                l auC = f.this.dDt.auC();
                if (auC != null && auC.aZg() != null && auC.aZg().getName() != null && auC.aZg().getName().equals(FrsActivityStatic.forumName)) {
                    if (customResponsedMessage == null || customResponsedMessage.getOrginalMessage().getTag() == f.this.dGJ) {
                        TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_end_time", System.currentTimeMillis() + "");
                        String name = auC.aZg().getName();
                        SignMessage signMessage = (SignMessage) customResponsedMessage;
                        if (AntiHelper.al(signMessage.mSignErrorCode, signMessage.mSignErrorString) && signMessage.signData != null) {
                            if (AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener) != null) {
                                TiebaStatic.log(new an("c12534").r("obj_locate", at.a.ars));
                                return;
                            }
                            return;
                        }
                        if (signMessage == null || signMessage.signData == null) {
                            signData = null;
                            z = false;
                        } else {
                            SignData signData2 = signMessage.signData;
                            if (signData2.forumId != null && signData2.forumId.equals(auC.aZg().getId())) {
                                f.this.nf(name);
                                auC.d(signData2);
                                signData2.forumId = auC.aZg().getId();
                                signData2.forumName = auC.aZg().getName();
                                signData = signData2;
                                z = true;
                            } else {
                                return;
                            }
                        }
                        if (z) {
                            int user_level = auC.aZg().getUser_level();
                            if (f.this.aAF()) {
                                i = auC.aZg().getUser_level();
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
                                f.this.dDt.a(signData.mContriInfo);
                                return;
                            } else if (!f.this.aAD()) {
                                f.this.dDt.showToast(f.this.getPageContext().getResources().getString(f.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                                return;
                            } else {
                                f.this.dDt.showToast(f.this.getPageContext().getResources().getString(f.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                                return;
                            }
                        }
                        if (signMessage.mSignErrorCode == 160002) {
                            f.this.lO(1);
                        }
                        f.this.dDt.showToast(signMessage.mSignErrorString);
                    }
                }
            }
        };
        this.dGN = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.8
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.doC != null) {
                    int childCount = f.this.doC.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(f.this.doC.getChildAt(i));
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
        this.dog = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l auC = f.this.dDt.auC();
                if (auC != null && auC.aZg() != null && f.this.dGu != null && (view == f.this.dGu.aBh() || view == f.this.dGu.aBi() || view == f.this.dGu.aBj())) {
                    if (f.this.dDt != null && auC.aZg() != null) {
                        TiebaStatic.log(new an("c12046").ae(ImageViewerConfig.FORUM_ID, auC.aZg().getId()).r("obj_locate", f.this.dDt.auE() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), auC.aZg().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == f.g.tv_love) {
                    if (!f.this.dDt.auD()) {
                        if (!com.baidu.adp.lib.util.j.jE()) {
                            f.this.dDt.showToast(f.j.neterror);
                        } else if (!bb.aU(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new an("c10517").r("obj_locate", 1).ae(ImageViewerConfig.FORUM_ID, f.this.dDt.getForumId()));
                        } else {
                            f.this.gp(true);
                        }
                    }
                } else if (id == f.g.tv_sign) {
                    if (!f.this.dDt.auD()) {
                        if (!com.baidu.adp.lib.util.j.jE()) {
                            f.this.dDt.showToast(f.j.neterror);
                        } else if (bb.aU(f.this.mContext.getPageActivity())) {
                            if (!f.this.aAE()) {
                                f.this.aAH();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(f.this.dDt.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.g(f.this.dDt.getForumId(), 0), 24002)));
                            }
                        }
                    }
                } else if (id == f.g.frs_header_games) {
                    if (bb.aU(f.this.mContext.getPageActivity()) && auC != null && auC.bup() != null) {
                        az.zI().a((TbPageContext) f.this.getPageContext(), new String[]{auC.bup()}, true);
                    }
                } else if (id == f.g.frs_bawu_center) {
                    if (auC != null && auC.getUserData() != null && auC.getUserData().isBawu()) {
                        String but = auC.but();
                        if (!ap.isEmpty(but)) {
                            com.baidu.tbadk.browser.a.Q(f.this.getPageContext().getPageActivity(), but);
                            if (auC.aZg() != null) {
                                TiebaStatic.log(new an("c10502").ae(ImageViewerConfig.FORUM_ID, auC.aZg().getId()).ae("uid", auC.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == f.g.level_container && !f.this.dDt.auD() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page") || f.this.mPageType.equals("brand_page")) && f.this.dGu != null) {
                        f.this.dGu.i(view, false);
                    }
                }
            }
        };
        this.dDt = frsFragment;
        this.dGD = aVar;
        this.doC = frsHeaderViewContainer;
        this.dGH = new com.baidu.tieba.frs.c.b(frsFragment.aiB());
        this.dGI = new com.baidu.tieba.frs.c.a(frsFragment.aiB());
        this.dGJ = BdUniqueId.gen();
        this.dGF = new com.baidu.tieba.f.a();
        this.dGF.a(new a.InterfaceC0144a() { // from class: com.baidu.tieba.frs.vc.f.6
            @Override // com.baidu.tieba.f.a.InterfaceC0144a
            public void Y(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0144a
            public void Z(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0144a
            public void aa(int i, int i2) {
            }
        });
    }

    public void m(Bundle bundle) {
        this.dDt.registerListener(this.dGM);
        TY();
        aAI();
        this.dGA = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.dGu != null) {
            this.dGu.onDestory();
        }
        if (this.azn != null) {
            this.azn.bvv();
        }
        if (this.dGy != null) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.dGy);
        }
    }

    public void onActivityStop() {
        if (this.dGu != null) {
            this.dGu.onStop();
        }
        if (this.doC != null) {
            this.doC.removeCallbacks(this.dGN);
        }
    }

    public void fA(boolean z) {
        if (this.dGu != null) {
            this.dGu.fA(z);
        }
    }

    public boolean lK(int i) {
        this.mSkinType = i;
        if (this.dGu != null) {
            this.dGu.changeSkinType(i);
        }
        if (this.dGH != null) {
            this.dGH.onChangeSkinType(i);
        }
        if (this.dGI != null) {
            this.dGI.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    public void go(boolean z) {
        if (z) {
            if (this.dGu != null) {
                this.doC.removeHeaderView(this.dGu.aBg());
                this.dGC = false;
            }
        } else if (this.dGu != null && this.dGu.aBg() != null && !this.dGC) {
            this.doC.addHeaderView(this.dGu.aBg(), this.doC.getHeaderViewsCount());
            this.dGC = true;
        }
    }

    public void a(String str, l lVar) {
        this.mPageType = str;
        if ("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str) || "brand_page".equals(str)) {
            if (!"brand_page".equals(str) && lVar != null && lVar.buh() != null && lVar.buh().tL() != null && lVar.buh().tL().size() >= 1) {
                a(lVar.buh().tL().get(0), false);
            } else if (!"brand_page".equals(str) && lVar != null && lVar.bug() != null && !StringUtils.isNull(lVar.bug().buV())) {
                q qVar = new q();
                qVar.setLinkUrl("");
                qVar.setImageUrl(lVar.bug().buV());
                a(qVar, true);
            } else if (lVar != null && "brand_page".equals(str) && lVar.buh() != null && lVar.buh().tL() != null && lVar.buh().tL().size() >= 1) {
                n(str, lVar.getUserData().getIsMem(), lVar.aZg().isLike());
                g(lVar);
            } else {
                this.dGG = false;
                if (this.doC != null && this.dGH != null && this.dGH.getHeaderView() != null) {
                    this.doC.removeHeaderView(this.dGH.getHeaderView());
                }
                if (this.doC != null && this.dGI != null && this.dGI.getHeaderView() != null) {
                    this.doC.removeHeaderView(this.dGI.getHeaderView());
                }
            }
            if (lVar != null && lVar.getUserData() != null && lVar.aZg() != null && !"brand_page".equals(str)) {
                m(str, lVar.getUserData().getIsMem(), lVar.aZg().isLike());
            }
        }
    }

    public boolean aAw() {
        return this.dGG;
    }

    private void a(q qVar, boolean z) {
        if (qVar == null) {
            this.dGG = false;
        } else if (this.doC == null || this.dGH == null || this.dGH.getHeaderView() == null) {
            this.dGG = false;
        } else {
            this.dGG = true;
            this.doC.removeHeaderView(this.dGH.getHeaderView());
            this.doC.addHeaderView(this.dGH.getHeaderView());
            this.dGH.hV(qVar.getImageUrl());
            this.dGH.setTitle(qVar.getTitle());
            this.dGH.setSchemaUrl(qVar.getLinkUrl());
            if (z) {
                this.dGH.hideTitle();
            }
        }
    }

    private void g(l lVar) {
        if (lVar == null || lVar.buh() == null || com.baidu.tbadk.core.util.w.z(lVar.buh().tL()) || this.doC == null || this.dGu == null || this.dGu.getView() == null || this.dGI == null || this.dGI.getHeaderView() == null) {
            this.dGG = false;
            return;
        }
        q qVar = lVar.buh().tL().get(0);
        if (qVar == null) {
            this.dGG = false;
            return;
        }
        this.dGG = true;
        this.dGu.getView().setBackgroundColor(0);
        this.dGI.azk().removeView(this.dGu.getView());
        this.dGI.azk().addView(this.dGu.getView());
        this.doC.removeHeaderView(this.dGI.getHeaderView());
        this.doC.addHeaderView(this.dGI.getHeaderView());
        this.dGI.hV(qVar.getImageUrl());
        this.dGI.setSchemaUrl(qVar.getLinkUrl());
        this.dGI.setTitle(qVar.getTitle());
        if (this.dGI instanceof com.baidu.tieba.frs.c.a) {
            ((com.baidu.tieba.frs.c.a) this.dGI).bv(lVar.gMl);
        }
    }

    private void m(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.dGx, str);
        this.dGz = i2;
        this.dGx = str;
        aAy();
        if (this.dGu == null || z) {
            this.dGu = this.dGD.a(str, this.dDt, i);
            this.dGu.changeSkinType(this.mSkinType);
            this.dGu.q(this.dog);
        }
        this.doC.addHeaderView(this.dGu.getView());
        int f = com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), f.e.tbds44);
        this.dGu.p(0, f, 0, f);
        aAz();
        if (this.dGK != null) {
            this.dGK.aD(this.dGu.awD());
        }
    }

    private void n(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.dGx, str);
        this.dGz = i2;
        this.dGx = str;
        aAy();
        if (this.dGu == null || z) {
            this.dGu = this.dGD.a(str, this.dDt, i);
            this.dGu.changeSkinType(this.mSkinType);
            this.dGu.q(this.dog);
            this.dGu.awI();
        }
        this.dGu.p(0, com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), f.e.tbds132), 0, com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), f.e.tbds44));
        aAz();
        if (this.dGK != null) {
            this.dGK.aD(this.dGu.awD());
        }
    }

    public void aAx() {
        if (!this.dGC && this.dGu != null) {
            this.doC.addHeaderView(this.dGu.aBg());
            if (this.dGu.awD() != null && this.dDt.AP() != null) {
                this.dDt.AP().addHeaderView(this.dGu.awD(), 0);
            }
            this.dGC = true;
        }
    }

    private void aAy() {
        if (("normal_page".equals(this.dGx) || "frs_page".equals(this.dGx) || "book_page".equals(this.dGx) || "brand_page".equals(this.dGx)) && this.dGu != null) {
            this.doC.removeHeaderView(this.dGu.getView());
            this.doC.removeHeaderView(this.dGu.aBg());
            if (this.dGu.awD() != null && this.dDt.AP() != null) {
                this.dDt.AP().removeHeaderView(this.dGu.awD());
            }
        }
        this.dGC = false;
    }

    private void aAz() {
        if (this.dGy == null) {
            this.dGy = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.dDt.aul() == null || !f.this.dDt.aul().auD()) && f.this.doC.isShown() && f.this.dDt.isPrimary() && !f.this.dGA && f.this.dGz == 1 && f.this.dDt.aul() != null && f.this.dDt.aul().avd() != null && !f.this.dDt.aul().avd().axp() && f.this.dDt.auH()) {
                            if (("frs_page".equals(f.this.dGx) || "normal_page".equals(f.this.dGx) || "brand_page".equals(f.this.mPageType) || "book_page".equals(f.this.dGx)) && f.this.dGu != null && f.this.dGu.aBf()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.awQ();
                                f.this.dDt.dmb = true;
                                f.this.dGA = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.in().postDelayed(this.dGy, 4000L);
    }

    public void h(l lVar) {
        if (lVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                b(lVar.aZg(), lVar);
                if ("brand_page".equals(this.mPageType)) {
                    this.dGu.awJ();
                }
            }
        }
    }

    public void b(ForumData forumData, l lVar) {
        if (forumData != null && lVar != null) {
            float b = b(forumData);
            if (this.dGu != null) {
                this.dGu.a(forumData, lVar);
                this.dGu.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                if (forumData.getSignData() != null) {
                    this.dGu.md(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.dGu.gw(false);
                        return;
                    }
                    this.dGu.gw(true);
                    this.dGu.md(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.dGv = forumData.getLevelupScore();
        this.dGw = forumData.getCurScore();
        if (this.dGv > 0) {
            return this.dGw / this.dGv;
        }
        return 0.0f;
    }

    public void lL(int i) {
        if (i > 1) {
            if (this.dGu != null) {
                this.dGu.gx(false);
            }
        } else if (this.dGu != null) {
            this.dGu.gx(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void aAA() {
        if (this.doC != null) {
            this.doC.removeCallbacks(this.dGN);
            this.doC.postDelayed(this.dGN, 100L);
        }
    }

    public void g(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            aAB();
        }
    }

    public void setIsMem(int i) {
        if (this.dGu != null) {
            this.dGu.setMemberType(i);
        }
    }

    public void awQ() {
        if (("normal_page".equals(this.dGx) || "frs_page".equals(this.dGx) || "book_page".equals(this.dGx) || "brand_page".equals(this.mPageType)) && this.dGu != null) {
            this.dGu.awQ();
        }
    }

    public void aAB() {
        if (this.dGu != null) {
            this.dGu.awS();
        }
    }

    public void a(l lVar, boolean z) {
        if (lVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                a(1, lVar.aZg(), lVar, z);
            }
        }
    }

    public void aAC() {
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
        if (this.dGu != null) {
            this.dGu.mc(i);
        }
    }

    public void a(int i, ForumData forumData, l lVar, boolean z) {
        if (this.dGu != null) {
            this.dGu.a(forumData, lVar);
            if (forumData != null) {
                this.dGu.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.dGu.gw(false);
                }
            }
        }
    }

    public boolean aAD() {
        if (("normal_page".equals(this.dGx) || "frs_page".equals(this.dGx) || "book_page".equals(this.dGx) || "brand_page".equals(this.mPageType)) && this.dGu != null) {
            return this.dGu.aBe();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.dGv - this.dGw) {
                z = true;
                this.dGv = signData.levelup_score;
            }
            this.dGw = i + this.dGw;
            if (this.dGw > this.dGv) {
                this.dGw = this.dGv;
            }
            if (this.dGv != 0) {
                f = this.dGw / this.dGv;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.d(z, f);
        }
    }

    public void lO(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.dGu != null) {
            this.dGu.md(i);
        }
    }

    public void i(l lVar) {
        SignData signData;
        ForumData aZg;
        if (lVar != null && lVar.aZg() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.dGu != null && (signData = lVar.aZg().getSignData()) != null && (aZg = lVar.aZg()) != null) {
                this.dGu.a(aZg, lVar);
                this.dGu.md(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.dGu.aBe()) {
                    a(this.dGu, signData);
                    aZg.setCurScore(this.dGw);
                    aZg.setLevelupScore(this.dGv);
                    this.dGu.a(aZg, lVar);
                }
            }
        }
    }

    public boolean aAE() {
        if (("normal_page".equals(this.dGx) || "frs_page".equals(this.dGx) || "book_page".equals(this.dGx) || "brand_page".equals(this.mPageType)) && this.dGu != null) {
            return this.dGu.aAE();
        }
        return false;
    }

    public boolean aAF() {
        if (("normal_page".equals(this.dGx) || "frs_page".equals(this.dGx) || "book_page".equals(this.dGx) || "brand_page".equals(this.mPageType)) && this.dGu != null) {
            return this.dGu.aAF();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void gp(boolean z) {
        if (this.dDt != null) {
            l auC = this.dDt.auC();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.dDt.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11002)));
            } else if (auC != null && auC.aZg() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.dDt.getFrom())) {
                    TiebaStatic.log(new an("c10356").ae(ImageViewerConfig.FORUM_ID, auC.aZg().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.dDt.getFrom())) {
                    TiebaStatic.log(new an("c10590").r("obj_type", 2).ae(ImageViewerConfig.FORUM_ID, auC.aZg().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.dDt.getFrom())) {
                    TiebaStatic.log(new an("c10587").r("obj_type", 2).ae(ImageViewerConfig.FORUM_ID, auC.aZg().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.dDt.getFrom())) {
                    TiebaStatic.log(new an("c10578").r("obj_type", 2).ae(ImageViewerConfig.FORUM_ID, auC.aZg().getId()));
                }
                this.azn.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.dDt.getFrom())) {
                    TiebaStatic.eventStat(this.dDt.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.dDt.getFrom())) {
                    TiebaStatic.log(new an("c10359").ae(ImageViewerConfig.FORUM_ID, auC.aZg().getId()));
                }
                this.azn.I(auC.aZg().getName(), auC.aZg().getId(), "FRS");
                this.dGE = z;
            }
        }
    }

    public void aAG() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.dDt.auC() != null && this.dDt.auC().aZg() != null && this.dDt.auC().aZg().getName() != null) {
            str = this.dDt.auC().aZg().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.dB(String.format(getPageContext().getString(f.j.attention_cancel_dialog_content), str));
        } else {
            aVar.dB(getPageContext().getString(f.j.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(f.j.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.10
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                l auC = f.this.dDt.auC();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.dDt.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(f.this.getPageContext().getPageActivity(), true, 11036)));
                } else if (auC != null && auC.aZg() != null) {
                    f.this.dGB.t(auC.aZg().getName(), com.baidu.adp.lib.g.b.c(auC.aZg().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(f.j.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).xe();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void aAH() {
        l auC = this.dDt.auC();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.dDt.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11014)));
        } else if (auC != null && auC.aZg() != null) {
            FrsActivityStatic.forumName = auC.aZg().getName() == null ? "" : auC.aZg().getName();
            CustomMessage customMessage = new CustomMessage(2001425, auC.aZg());
            customMessage.setTag(this.dGJ);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nf(String str) {
        if (this.dDt.aug() != null && this.dDt.aug().azy() != null) {
            com.baidu.tieba.tbadkCore.c.btS().T(com.baidu.tieba.tbadkCore.c.btS().c(str, this.dDt.aug().azy().Vo(), this.dDt.aug().azy().getIsGood(), this.dDt.aug().azy().getCategoryId()), false);
        }
    }

    private void TY() {
        this.azn = new LikeModel(this.dDt.getPageContext());
        this.azn.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                r rVar;
                boolean z = false;
                l auC = f.this.dDt.auC();
                if (auC != null && auC.aZg() != null && obj != null) {
                    if (AntiHelper.al(f.this.azn.getErrorCode(), f.this.azn.getErrorString())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.azn.getBlockPopInfoData(), f.this.dGL) != null) {
                            TiebaStatic.log(new an("c12534").r("obj_locate", at.a.aru));
                            return;
                        }
                        return;
                    }
                    String name = auC.aZg().getName();
                    String id = auC.aZg().getId();
                    if (!(obj instanceof r)) {
                        rVar = null;
                    } else {
                        rVar = (r) obj;
                    }
                    boolean z2 = rVar != null && f.this.azn.getErrorCode() == 0;
                    if (rVar.getErrorCode() == 3250013) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), rVar.getErrorMsg(), f.C0146f.icon_toast_game_error, 3000).xm();
                    } else {
                        z = z2;
                    }
                    if (rVar == null || !z) {
                        if (f.this.azn.getErrorCode() == 22) {
                            f.this.dDt.showToast(f.this.getPageContext().getString(f.j.had_liked_forum));
                        } else {
                            f.this.dDt.showToast(f.this.azn.getErrorString());
                        }
                    } else {
                        f.this.nf(name);
                        rVar.setLike(1);
                        auC.c(rVar);
                        auC.dq(rVar.btZ());
                        f.this.a(auC, f.this.dGE);
                        f.this.dGE = true;
                        f.this.dDt.showToast(f.this.getPageContext().getResources().getString(f.j.attention_success));
                        f.this.h(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                    }
                    f.this.dDt.X(Boolean.valueOf(z));
                }
            }
        });
    }

    private void aAI() {
        this.dGB = new w();
        this.dGB.setFrom("from_frs");
        this.dGB.a(new w.a() { // from class: com.baidu.tieba.frs.vc.f.3
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void m(String str, long j) {
                l auC = f.this.dDt.auC();
                if (auC != null && auC.aZg() != null) {
                    String name = auC.aZg().getName();
                    String id = auC.aZg().getId();
                    if (j == com.baidu.adp.lib.g.b.c(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.nf(str);
                        auC.aZg().setLike(0);
                        f.this.lM(0);
                        f.this.dDt.W(true);
                        f.this.h(false, id);
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
    public void h(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.aNs().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void A(int i, int i2, int i3) {
        l auC;
        if (i > 0 && i2 > 0 && (auC = this.dDt.auC()) != null && auC.aZg() != null && auC.getSignData() != null) {
            ForumData aZg = auC.aZg();
            SignData signData = auC.getSignData();
            signData.levelup_score = aZg.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            auC.d(signData);
            signData.forumId = aZg.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
            int i4 = -1;
            if (aAF()) {
                i4 = aZg.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(aZg.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void awA() {
        if (this.dGu != null) {
            this.dGu.awA();
        }
    }

    public static boolean j(l lVar) {
        if (lVar != null) {
            return (lVar.bux() == null || StringUtils.isNull(lVar.bux().tM(), true) || lVar.bux().tM().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean k(l lVar) {
        if (lVar != null) {
            return ((lVar.bug() == null || lVar.bug().buR() != 1) && lVar.buw() == null && (lVar.buh() == null || com.baidu.tbadk.core.util.w.z(lVar.buh().tL())) && ((lVar.aZg() == null || lVar.aZg().getFrsBannerData() == null || lVar.aZg().getFrsBannerData().getType() != 2) && (lVar.buy() == null || StringUtils.isNull(lVar.buy().tT(), true)))) ? false : true;
        }
        return false;
    }

    public void lP(int i) {
        View findViewById;
        if (this.dGu != null && this.dGu.aBg() != null && (findViewById = this.dGu.aBg().findViewById(f.g.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.dGF != null) {
            this.dGF.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.dGK = frsTabViewController;
    }
}
