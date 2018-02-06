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
    private LikeModel cdg;
    private final View.OnClickListener dGd;
    private FrsHeaderViewContainer dGx;
    private com.baidu.tieba.frs.i dSV;
    private boolean dVA;
    private com.baidu.tieba.e.a dVB;
    private boolean dVC;
    private com.baidu.tieba.frs.c.a.a dVD;
    private BdUniqueId dVE;
    private AntiHelper.a dVF;
    private CustomMessageListener dVG;
    private Runnable dVH;
    private com.baidu.tieba.frs.view.c dVq;
    private int dVr;
    private int dVs;
    private String dVt;
    private Runnable dVu;
    private int dVv;
    private boolean dVw;
    private w dVx;
    private boolean dVy;
    private com.baidu.tieba.frs.entelechy.b.a dVz;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(com.baidu.tieba.frs.i iVar, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(iVar.getPageContext());
        this.dGx = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.dVt = null;
        this.dVw = false;
        this.cdg = null;
        this.dVx = null;
        this.dVy = false;
        this.dVC = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.g.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12536").s("obj_locate", aq.a.aXL));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12535").s("obj_locate", aq.a.aXL));
            }
        };
        this.dVF = new AntiHelper.a() { // from class: com.baidu.tieba.frs.g.f.4
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12536").s("obj_locate", aq.a.aXN));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12535").s("obj_locate", aq.a.aXN));
            }
        };
        this.dVG = new CustomMessageListener(2001425) { // from class: com.baidu.tieba.frs.g.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SignData signData;
                boolean z;
                int i;
                l avl = f.this.dSV.avl();
                if (avl != null && avl.bas() != null && avl.bas().getName() != null && avl.bas().getName().equals(FrsActivityStatic.forumName)) {
                    if (customResponsedMessage == null || customResponsedMessage.getOrginalMessage().getTag() == f.this.dVE) {
                        TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_end_time", System.currentTimeMillis() + "");
                        String name = avl.bas().getName();
                        SignMessage signMessage = (SignMessage) customResponsedMessage;
                        if (AntiHelper.vQ(signMessage.mSignErrorCode) && signMessage.signData != null) {
                            if (AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener) != null) {
                                TiebaStatic.log(new ak("c12534").s("obj_locate", aq.a.aXL));
                                return;
                            }
                            return;
                        }
                        if (signMessage == null || signMessage.signData == null) {
                            signData = null;
                            z = false;
                        } else {
                            SignData signData2 = signMessage.signData;
                            if (signData2.forumId != null && signData2.forumId.equals(avl.bas().getId())) {
                                f.this.mr(name);
                                avl.d(signData2);
                                signData2.forumId = avl.bas().getId();
                                signData2.forumName = avl.bas().getName();
                                signData = signData2;
                                z = true;
                            } else {
                                return;
                            }
                        }
                        if (z) {
                            int user_level = avl.bas().getUser_level();
                            if (f.this.aAq()) {
                                i = avl.bas().getUser_level();
                                if (user_level >= i) {
                                    i++;
                                }
                            } else {
                                i = user_level;
                            }
                            TbadkCoreApplication.getInst().addSignedForum(name, signData.sign_bonus_point, i);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                            if (AntiHelper.vQ(signMessage.mSignErrorCode)) {
                                AntiHelper.ar(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                                return;
                            } else if (signData.mContriInfo != null && signData.mContriInfo.isShowToast()) {
                                f.this.dSV.a(signData.mContriInfo);
                                return;
                            } else if (!f.this.aAo()) {
                                f.this.dSV.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                                return;
                            } else {
                                f.this.dSV.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                                return;
                            }
                        }
                        if (signMessage.mSignErrorCode == 160002) {
                            f.this.nR(1);
                        }
                        f.this.dSV.showToast(signMessage.mSignErrorString);
                    }
                }
            }
        };
        this.dVH = new Runnable() { // from class: com.baidu.tieba.frs.g.f.8
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.dGx != null) {
                    int childCount = f.this.dGx.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(f.this.dGx.getChildAt(i));
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
        this.dGd = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l avl = f.this.dSV.avl();
                if (avl != null && avl.bas() != null && f.this.dVq != null && (view == f.this.dVq.aAQ() || view == f.this.dVq.aAR() || view == f.this.dVq.aAS())) {
                    if (f.this.dSV != null && avl.bas() != null) {
                        TiebaStatic.log(new ak("c12046").ab(ImageViewerConfig.FORUM_ID, avl.bas().getId()).s("obj_locate", f.this.dSV.avn() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), avl.bas().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == d.g.tv_love) {
                    if (!f.this.dSV.avm()) {
                        if (!com.baidu.adp.lib.util.j.oJ()) {
                            f.this.dSV.showToast(d.j.neterror);
                        } else if (!ay.ba(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new ak("c10517").s("obj_locate", 1).ab(ImageViewerConfig.FORUM_ID, f.this.dSV.getForumId()));
                        } else {
                            f.this.gt(true);
                        }
                    }
                } else if (id == d.g.tv_sign) {
                    if (!f.this.dSV.avm()) {
                        if (!com.baidu.adp.lib.util.j.oJ()) {
                            f.this.dSV.showToast(d.j.neterror);
                        } else if (ay.ba(f.this.mContext.getPageActivity())) {
                            if (!f.this.aAp()) {
                                f.this.aAs();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(f.this.dSV.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.h(f.this.dSV.getForumId(), 0), 24002)));
                            }
                        }
                    }
                } else if (id == d.g.frs_header_games) {
                    if (ay.ba(f.this.mContext.getPageActivity()) && avl != null && avl.bve() != null) {
                        aw.Du().a((TbPageContext) f.this.getPageContext(), new String[]{avl.bve()}, true);
                    }
                } else if (id == d.g.frs_bawu_center) {
                    if (avl != null && avl.getUserData() != null && avl.getUserData().isBawu()) {
                        String bvl = avl.bvl();
                        if (!am.isEmpty(bvl)) {
                            com.baidu.tbadk.browser.b.R(f.this.getPageContext().getPageActivity(), bvl);
                            if (avl.bas() != null) {
                                TiebaStatic.log(new ak("c10502").ab(ImageViewerConfig.FORUM_ID, avl.bas().getId()).ab("uid", avl.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == d.g.level_container && !f.this.dSV.avm() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page")) && f.this.dVq != null) {
                        f.this.dVq.p(view, false);
                    }
                }
            }
        };
        this.dSV = iVar;
        this.dVz = aVar;
        this.dGx = frsHeaderViewContainer;
        this.dVD = new com.baidu.tieba.frs.c.a(iVar.akO());
        this.dVE = BdUniqueId.gen();
        this.dVB = new com.baidu.tieba.e.a();
        this.dVB.a(new a.InterfaceC0142a() { // from class: com.baidu.tieba.frs.g.f.6
            @Override // com.baidu.tieba.e.a.InterfaceC0142a
            public void aY(int i, int i2) {
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0142a
            public void aZ(int i, int i2) {
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0142a
            public void ba(int i, int i2) {
            }
        });
    }

    public void o(Bundle bundle) {
        this.dSV.registerListener(this.dVG);
        Xy();
        aAt();
        this.dVw = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.dVq != null) {
            this.dVq.onDestory();
        }
        if (this.cdg != null) {
            this.cdg.bwl();
        }
        if (this.dVu != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.dVu);
        }
    }

    public void onActivityStop() {
        if (this.dVq != null) {
            this.dVq.onStop();
        }
        if (this.dGx != null) {
            this.dGx.removeCallbacks(this.dVH);
        }
    }

    public void gr(boolean z) {
        if (this.dVq != null) {
            this.dVq.gr(z);
        }
    }

    public boolean nN(int i) {
        this.mSkinType = i;
        if (this.dVq != null) {
            this.dVq.changeSkinType(i);
        }
        if (this.dVD != null) {
            this.dVD.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    public void gs(boolean z) {
        if (z) {
            if (this.dVq != null) {
                this.dGx.removeHeaderView(this.dVq.aAO());
                this.dVy = false;
            }
        } else if (this.dVq != null && this.dVq.aAO() != null && !this.dVy) {
            this.dGx.addHeaderView(this.dVq.aAO(), this.dGx.getHeaderViewsCount());
            this.dVy = true;
        }
    }

    public void a(String str, l lVar) {
        this.mPageType = str;
        if ("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) {
            if (lVar != null && lVar.buV() != null && lVar.buV().xS() != null && lVar.buV().xS().size() >= 1) {
                a(lVar.buV().xS().get(0));
            } else {
                this.dVC = false;
                if (this.dGx != null && this.dVD != null && this.dVD.getHeaderView() != null) {
                    this.dGx.removeHeaderView(this.dVD.getHeaderView());
                }
            }
            if (lVar != null && lVar.getUserData() != null && lVar.bas() != null) {
                m(str, lVar.getUserData().getIsMem(), lVar.bas().isLike());
            }
        }
    }

    public boolean aAh() {
        return this.dVC;
    }

    private void a(q qVar) {
        if (qVar == null) {
            this.dVC = false;
        } else if (this.dGx == null || this.dVD == null || this.dVD.getHeaderView() == null) {
            this.dVC = false;
        } else {
            this.dVC = true;
            this.dGx.removeHeaderView(this.dVD.getHeaderView());
            this.dGx.addHeaderView(this.dVD.getHeaderView());
            this.dVD.hB(qVar.getImageUrl());
            this.dVD.setTitle(qVar.getTitle());
            this.dVD.setSchemaUrl(qVar.getLinkUrl());
        }
    }

    public void m(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.dVt, str);
        this.dVv = i2;
        this.dVt = str;
        aAj();
        if (this.dVq == null || z) {
            this.dVq = this.dVz.a(str, this.dSV, i);
            this.dVq.changeSkinType(this.mSkinType);
            this.dVq.l(this.dGd);
        }
        this.dGx.addHeaderView(this.dVq.getView());
        int t = com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst(), d.e.tbds44);
        this.dVq.x(0, t, 0, t);
        aAk();
    }

    public void aAi() {
        if (!this.dVy && this.dVq != null) {
            this.dGx.addHeaderView(this.dVq.aAO());
            if (this.dVq.aAP() != null && this.dSV.Ez() != null) {
                this.dSV.Ez().addHeaderView(this.dVq.aAP(), 0);
            }
            this.dVy = true;
        }
    }

    private void aAj() {
        if (("normal_page".equals(this.dVt) || "frs_page".equals(this.dVt) || "book_page".equals(this.dVt)) && this.dVq != null) {
            this.dGx.removeHeaderView(this.dVq.getView());
            this.dGx.removeHeaderView(this.dVq.aAO());
            if (this.dVq.aAP() != null && this.dSV.Ez() != null) {
                this.dSV.Ez().removeHeaderView(this.dVq.aAP());
            }
        }
        this.dVy = false;
    }

    private void aAk() {
        if (this.dVu == null) {
            this.dVu = new Runnable() { // from class: com.baidu.tieba.frs.g.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.dSV.auT() == null || !f.this.dSV.auT().avm()) && f.this.dGx.isShown() && f.this.dSV.isPrimary() && !f.this.dVw && f.this.dVv == 1 && f.this.dSV.auT() != null && f.this.dSV.auT().avG() != null && !f.this.dSV.auT().avG().axE() && !f.this.dSV.avq()) {
                            if (("frs_page".equals(f.this.dVt) || "normal_page".equals(f.this.dVt) || "book_page".equals(f.this.dVt)) && f.this.dVq != null && f.this.dVq.aAN()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.axg();
                                f.this.dSV.dEl = true;
                                f.this.dVw = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.ns().postDelayed(this.dVu, 4000L);
    }

    public void f(l lVar) {
        if (lVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(lVar.bas(), lVar);
            }
        }
    }

    public void b(ForumData forumData, l lVar) {
        if (forumData != null && lVar != null) {
            float a = a(forumData);
            if (this.dVq != null) {
                this.dVq.a(forumData, lVar);
                this.dVq.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.dVq.oe(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.dVq.gz(false);
                        return;
                    }
                    this.dVq.gz(true);
                    this.dVq.oe(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.dVr = forumData.getLevelupScore();
        this.dVs = forumData.getCurScore();
        if (this.dVr > 0) {
            return this.dVs / this.dVr;
        }
        return 0.0f;
    }

    public void nO(int i) {
        if (i > 1) {
            if (this.dVq != null) {
                this.dVq.gA(false);
            }
        } else if (this.dVq != null) {
            this.dVq.gA(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void aAl() {
        if (this.dGx != null) {
            this.dGx.removeCallbacks(this.dVH);
            this.dGx.postDelayed(this.dVH, 100L);
        }
    }

    public void f(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            aAm();
        }
    }

    public void setIsMem(int i) {
        if (this.dVq != null) {
            this.dVq.setMemberType(i);
        }
    }

    public void axg() {
        if (("normal_page".equals(this.dVt) || "frs_page".equals(this.dVt) || "book_page".equals(this.dVt)) && this.dVq != null) {
            this.dVq.axg();
        }
    }

    public void aAm() {
        if (this.dVq != null) {
            this.dVq.axi();
        }
    }

    public void a(l lVar, boolean z) {
        if (lVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, lVar.bas(), lVar, z);
            }
        }
    }

    public void aAn() {
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
        if (this.dVq != null) {
            this.dVq.od(i);
        }
    }

    public void a(int i, ForumData forumData, l lVar, boolean z) {
        if (this.dVq != null) {
            this.dVq.a(forumData, lVar);
            if (forumData != null) {
                this.dVq.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.dVq.gz(false);
                }
            }
        }
    }

    public boolean aAo() {
        if (("normal_page".equals(this.dVt) || "frs_page".equals(this.dVt) || "book_page".equals(this.dVt)) && this.dVq != null) {
            return this.dVq.aAM();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.c cVar, SignData signData) {
        if (cVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.dVr - this.dVs) {
                z = true;
                this.dVr = signData.levelup_score;
            }
            this.dVs = i + this.dVs;
            if (this.dVs > this.dVr) {
                this.dVs = this.dVr;
            }
            if (this.dVr != 0) {
                f = this.dVs / this.dVr;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            cVar.c(z, f);
        }
    }

    public void nR(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.dVq != null) {
            this.dVq.oe(i);
        }
    }

    public void g(l lVar) {
        SignData signData;
        ForumData bas;
        if (lVar != null && lVar.bas() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.dVq != null && (signData = lVar.bas().getSignData()) != null && (bas = lVar.bas()) != null) {
                this.dVq.a(bas, lVar);
                this.dVq.oe(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.dVq.aAM()) {
                    a(this.dVq, signData);
                    bas.setCurScore(this.dVs);
                    bas.setLevelupScore(this.dVr);
                    this.dVq.a(bas, lVar);
                }
            }
        }
    }

    public boolean aAp() {
        if (("normal_page".equals(this.dVt) || "frs_page".equals(this.dVt) || "book_page".equals(this.dVt)) && this.dVq != null) {
            return this.dVq.aAp();
        }
        return false;
    }

    public boolean aAq() {
        if (("normal_page".equals(this.dVt) || "frs_page".equals(this.dVt) || "book_page".equals(this.dVt)) && this.dVq != null) {
            return this.dVq.aAq();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.i */
    /* JADX WARN: Multi-variable type inference failed */
    public void gt(boolean z) {
        if (this.dSV != null) {
            l avl = this.dSV.avl();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.dSV.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_INITED)));
            } else if (avl != null && avl.bas() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.dSV.getFrom())) {
                    TiebaStatic.log(new ak("c10356").ab(ImageViewerConfig.FORUM_ID, avl.bas().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.dSV.getFrom())) {
                    TiebaStatic.log(new ak("c10590").s("obj_type", 2).ab(ImageViewerConfig.FORUM_ID, avl.bas().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.dSV.getFrom())) {
                    TiebaStatic.log(new ak("c10587").s("obj_type", 2).ab(ImageViewerConfig.FORUM_ID, avl.bas().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.dSV.getFrom())) {
                    TiebaStatic.log(new ak("c10578").s("obj_type", 2).ab(ImageViewerConfig.FORUM_ID, avl.bas().getId()));
                }
                this.cdg.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.dSV.getFrom())) {
                    TiebaStatic.eventStat(this.dSV.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.dSV.getFrom())) {
                    TiebaStatic.log(new ak("c10359").ab(ImageViewerConfig.FORUM_ID, avl.bas().getId()));
                }
                this.cdg.L(avl.bas().getName(), avl.bas().getId(), "FRS");
                this.dVA = z;
            }
        }
    }

    public void aAr() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.dSV.avl() != null && this.dSV.avl().bas() != null && this.dSV.avl().bas().getName() != null) {
            str = this.dSV.avl().bas().getName();
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
                l avl = f.this.dSV.avl();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.dSV.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) f.this.getPageContext().getPageActivity(), f.this.getPageContext().getString(d.j.login_to_use), true, 11036)));
                } else if (avl != null && avl.bas() != null) {
                    f.this.dVx.t(avl.bas().getName(), com.baidu.adp.lib.g.b.c(avl.bas().getId(), 0L));
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
    public void aAs() {
        l avl = this.dSV.avl();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.dSV.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, 11014)));
        } else if (avl != null && avl.bas() != null) {
            FrsActivityStatic.forumName = avl.bas().getName() == null ? "" : avl.bas().getName();
            CustomMessage customMessage = new CustomMessage(2001425, avl.bas());
            customMessage.setTag(this.dVE);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mr(String str) {
        if (this.dSV.auO() != null && this.dSV.auO().azm() != null) {
            com.baidu.tieba.tbadkCore.c.buI().Z(com.baidu.tieba.tbadkCore.c.buI().d(str, this.dSV.auO().azm().YM(), this.dSV.auO().azm().getIsGood(), this.dSV.auO().azm().getCategoryId()), false);
        }
    }

    private void Xy() {
        this.cdg = new LikeModel(this.dSV.getPageContext());
        this.cdg.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.g.f.2
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                r rVar;
                l avl = f.this.dSV.avl();
                if (avl != null && avl.bas() != null && obj != null) {
                    if (AntiHelper.vQ(f.this.cdg.getErrorCode())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.cdg.getBlockPopInfoData(), f.this.dVF) != null) {
                            TiebaStatic.log(new ak("c12534").s("obj_locate", aq.a.aXN));
                            return;
                        }
                        return;
                    }
                    String name = avl.bas().getName();
                    String id = avl.bas().getId();
                    boolean z = false;
                    if (!(obj instanceof r)) {
                        rVar = null;
                    } else {
                        rVar = (r) obj;
                    }
                    if (rVar != null && f.this.cdg.getErrorCode() == 0) {
                        z = true;
                    }
                    if (rVar == null || !z) {
                        if (f.this.cdg.getErrorCode() == 22) {
                            f.this.dSV.showToast(f.this.getPageContext().getString(d.j.had_liked_forum));
                        } else {
                            f.this.dSV.showToast(f.this.cdg.getErrorString());
                        }
                    } else {
                        f.this.mr(name);
                        rVar.setLike(1);
                        avl.c(rVar);
                        avl.ds(rVar.buN());
                        f.this.a(avl, f.this.dVA);
                        f.this.dVA = true;
                        f.this.dSV.showToast(f.this.getPageContext().getResources().getString(d.j.attention_success));
                        f.this.f(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                    }
                    f.this.dSV.aX(Boolean.valueOf(z));
                }
            }
        });
    }

    private void aAt() {
        this.dVx = new w();
        this.dVx.setFrom("from_frs");
        this.dVx.a(new w.a() { // from class: com.baidu.tieba.frs.g.f.3
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void m(String str, long j) {
                l avl = f.this.dSV.avl();
                if (avl != null && avl.bas() != null) {
                    String name = avl.bas().getName();
                    String id = avl.bas().getId();
                    if (j == com.baidu.adp.lib.g.b.c(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.mr(str);
                        avl.bas().setLike(0);
                        f.this.nP(0);
                        f.this.dSV.aW(true);
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
        com.baidu.tieba.im.settingcache.d.aLW().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void M(int i, int i2, int i3) {
        l avl;
        if (i > 0 && i2 > 0 && (avl = this.dSV.avl()) != null && avl.bas() != null && avl.getSignData() != null) {
            ForumData bas = avl.bas();
            SignData signData = avl.getSignData();
            signData.levelup_score = bas.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            avl.d(signData);
            signData.forumId = bas.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
            int i4 = -1;
            if (aAq()) {
                i4 = bas.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(bas.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void awU() {
        if (this.dVq != null) {
            this.dVq.awU();
        }
    }

    public static boolean h(l lVar) {
        if (lVar != null) {
            return (lVar.bvp() == null || StringUtils.isNull(lVar.bvp().xT(), true) || lVar.bvp().xT().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean i(l lVar) {
        if (lVar != null) {
            return ((lVar.buU() == null || lVar.buU().bvG() != 1) && lVar.bvo() == null && (lVar.buV() == null || v.E(lVar.buV().xS())) && ((lVar.bas() == null || lVar.bas().getFrsBannerData() == null || lVar.bas().getFrsBannerData().getType() != 2) && (lVar.bvq() == null || StringUtils.isNull(lVar.bvq().ya(), true)))) ? false : true;
        }
        return false;
    }

    public void nS(int i) {
        View findViewById;
        if (this.dVq != null && this.dVq.aAO() != null && (findViewById = this.dVq.aAO().findViewById(d.g.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.dVB != null) {
            this.dVB.onTouchEvent(motionEvent);
        }
    }
}
