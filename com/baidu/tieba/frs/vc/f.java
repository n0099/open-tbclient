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
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
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
    private LikeModel aCp;
    private FrsFragment dKj;
    private com.baidu.tieba.frs.view.b dNB;
    private int dNC;
    private int dND;
    private String dNE;
    private Runnable dNF;
    private int dNG;
    private boolean dNH;
    private w dNI;
    private boolean dNJ;
    private com.baidu.tieba.frs.entelechy.b.a dNK;
    private boolean dNL;
    private com.baidu.tieba.f.a dNM;
    private boolean dNN;
    private com.baidu.tieba.frs.c.a.a dNO;
    private com.baidu.tieba.frs.c.a.a dNP;
    private BdUniqueId dNQ;
    private FrsTabViewController dNR;
    private AntiHelper.a dNS;
    private CustomMessageListener dNT;
    private Runnable dNU;
    private final View.OnClickListener dud;
    private FrsHeaderViewContainer duz;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.duz = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.dNE = null;
        this.dNH = false;
        this.aCp = null;
        this.dNI = null;
        this.dNJ = false;
        this.dNN = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12536").w("obj_locate", as.a.atQ));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12535").w("obj_locate", as.a.atQ));
            }
        };
        this.dNS = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.4
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12536").w("obj_locate", as.a.atS));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12535").w("obj_locate", as.a.atS));
            }
        };
        this.dNT = new CustomMessageListener(2001425) { // from class: com.baidu.tieba.frs.vc.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                l awv;
                String name;
                SignData signData;
                boolean z;
                int i;
                if (f.this.dKj != null && (customResponsedMessage instanceof SignMessage) && (awv = f.this.dKj.awv()) != null && awv.bbH() != null && (name = awv.bbH().getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == f.this.dNQ) {
                    TiebaStatic.eventStat(f.this.dKj.getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name2 = awv.bbH().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.am(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                        if (signMessage.signData != null) {
                            AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener);
                        } else {
                            AntiHelper.aG(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                        }
                        TiebaStatic.log(new am("c12534").w("obj_locate", as.a.atQ));
                        return;
                    }
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(awv.bbH().getId())) {
                            f.this.nK(name2);
                            awv.d(signData2);
                            signData2.forumId = awv.bbH().getId();
                            signData2.forumName = awv.bbH().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = awv.bbH().getUser_level();
                        if (f.this.aCO()) {
                            i = awv.bbH().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                        if (signData.mContriInfo != null && signData.mContriInfo.isShowToast()) {
                            f.this.dKj.a(signData.mContriInfo);
                            return;
                        }
                        if (!f.this.aCM()) {
                            f.this.dKj.showToast(f.this.getPageContext().getResources().getString(e.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                        } else {
                            f.this.dKj.showToast(f.this.getPageContext().getResources().getString(e.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                        }
                        if (f.this.dKj.awe() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.FA().a(f.this.dKj.getTbPageContext(), f.this.dKj.awe().axn());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.mq(1);
                    }
                    f.this.dKj.showToast(signMessage.mSignErrorString);
                }
            }
        };
        this.dNU = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.8
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.duz != null) {
                    int childCount = f.this.duz.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(f.this.duz.getChildAt(i));
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
        this.dud = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l awv = f.this.dKj.awv();
                if (awv != null && awv.bbH() != null && f.this.dNB != null && (view == f.this.dNB.aDs() || view == f.this.dNB.aDt() || view == f.this.dNB.aDu())) {
                    if (f.this.dKj != null && awv.bbH() != null) {
                        TiebaStatic.log(new am("c12046").al(ImageViewerConfig.FORUM_ID, awv.bbH().getId()).w("obj_locate", f.this.dKj.awx() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), awv.bbH().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == e.g.tv_love) {
                    if (!f.this.dKj.aww()) {
                        if (!com.baidu.adp.lib.util.j.kK()) {
                            f.this.dKj.showToast(e.j.neterror);
                        } else if (!ba.bA(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new am("c10517").w("obj_locate", 1).al(ImageViewerConfig.FORUM_ID, f.this.dKj.getForumId()));
                        } else {
                            f.this.gL(true);
                            if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                am amVar = new am("c10048");
                                amVar.al(ImageViewerConfig.FORUM_ID, f.this.dKj.getForumId());
                                amVar.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(amVar);
                            }
                        }
                    }
                } else if (id == e.g.tv_sign) {
                    if (!f.this.dKj.aww()) {
                        if (!com.baidu.adp.lib.util.j.kK()) {
                            f.this.dKj.showToast(e.j.neterror);
                        } else if (ba.bA(f.this.mContext.getPageActivity())) {
                            if (!f.this.aCN()) {
                                f.this.aCQ();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(f.this.dKj.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.l(f.this.dKj.getForumId(), 0), 24002)));
                            }
                        }
                    }
                } else if (id == e.g.frs_header_games) {
                    if (ba.bA(f.this.mContext.getPageActivity()) && awv != null && awv.bwV() != null) {
                        ay.AN().a((TbPageContext) f.this.getPageContext(), new String[]{awv.bwV()}, true);
                    }
                } else if (id == e.g.frs_bawu_center) {
                    if (awv != null && awv.getUserData() != null && awv.getUserData().isBawu()) {
                        String bwZ = awv.bwZ();
                        if (!ao.isEmpty(bwZ)) {
                            com.baidu.tbadk.browser.a.ae(f.this.getPageContext().getPageActivity(), bwZ);
                            if (awv.bbH() != null) {
                                TiebaStatic.log(new am("c10502").al(ImageViewerConfig.FORUM_ID, awv.bbH().getId()).al("uid", awv.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == e.g.level_container && !f.this.dKj.aww() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page") || f.this.mPageType.equals("brand_page")) && f.this.dNB != null) {
                        f.this.dNB.i(view, false);
                    }
                }
            }
        };
        this.dKj = frsFragment;
        this.dNK = aVar;
        this.duz = frsHeaderViewContainer;
        this.dNO = new com.baidu.tieba.frs.c.b(frsFragment.getTbPageContext());
        this.dNP = new com.baidu.tieba.frs.c.a(frsFragment.getTbPageContext());
        this.dNQ = BdUniqueId.gen();
        this.dNM = new com.baidu.tieba.f.a();
        this.dNM.a(new a.InterfaceC0145a() { // from class: com.baidu.tieba.frs.vc.f.6
            @Override // com.baidu.tieba.f.a.InterfaceC0145a
            public void ac(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0145a
            public void ad(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0145a
            public void ae(int i, int i2) {
            }
        });
    }

    public void m(Bundle bundle) {
        this.dKj.registerListener(this.dNT);
        VL();
        aCR();
        this.dNH = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.dNB != null) {
            this.dNB.onDestory();
        }
        if (this.aCp != null) {
            this.aCp.byb();
        }
        if (this.dNF != null) {
            com.baidu.adp.lib.g.e.jt().removeCallbacks(this.dNF);
        }
    }

    public void onActivityStop() {
        if (this.dNB != null) {
            this.dNB.onStop();
        }
        if (this.duz != null) {
            this.duz.removeCallbacks(this.dNU);
        }
    }

    public void fR(boolean z) {
        if (this.dNB != null) {
            this.dNB.fR(z);
        }
    }

    public boolean mm(int i) {
        this.mSkinType = i;
        if (this.dNB != null) {
            this.dNB.changeSkinType(i);
        }
        if (this.dNO != null) {
            this.dNO.onChangeSkinType(i);
        }
        if (this.dNP != null) {
            this.dNP.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    public void gK(boolean z) {
        if (z) {
            if (this.dNB != null) {
                this.duz.removeHeaderView(this.dNB.aDr());
                this.dNJ = false;
            }
        } else if (this.dNB != null && this.dNB.aDr() != null && !this.dNJ) {
            this.duz.addHeaderView(this.dNB.aDr(), this.duz.getHeaderViewsCount());
            this.dNJ = true;
        }
    }

    public void a(String str, l lVar) {
        this.mPageType = str;
        if ("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str) || "brand_page".equals(str)) {
            if (!"brand_page".equals(str) && lVar != null && lVar.bwN() != null && lVar.bwN().uO() != null && lVar.bwN().uO().size() >= 1) {
                a(lVar.bwN().uO().get(0), false);
            } else if (!"brand_page".equals(str) && lVar != null && lVar.bwM() != null && !StringUtils.isNull(lVar.bwM().bxB())) {
                q qVar = new q();
                qVar.setLinkUrl("");
                qVar.setImageUrl(lVar.bwM().bxB());
                a(qVar, true);
            } else if (lVar != null && "brand_page".equals(str) && lVar.bwN() != null && lVar.bwN().uO() != null && lVar.bwN().uO().size() >= 1) {
                t(str, lVar.getUserData().getIsMem(), lVar.bbH().isLike());
                g(lVar);
            } else {
                this.dNN = false;
                if (this.duz != null && this.dNO != null && this.dNO.getHeaderView() != null) {
                    this.duz.removeHeaderView(this.dNO.getHeaderView());
                }
                if (this.duz != null && this.dNP != null && this.dNP.getHeaderView() != null) {
                    this.duz.removeHeaderView(this.dNP.getHeaderView());
                }
            }
            if (lVar != null && lVar.getUserData() != null && lVar.bbH() != null && !"brand_page".equals(str)) {
                s(str, lVar.getUserData().getIsMem(), lVar.bbH().isLike());
            }
        }
    }

    public boolean aCF() {
        return this.dNN;
    }

    private void a(q qVar, boolean z) {
        if (qVar == null) {
            this.dNN = false;
        } else if (this.duz == null || this.dNO == null || this.dNO.getHeaderView() == null) {
            this.dNN = false;
        } else {
            this.dNN = true;
            this.duz.removeHeaderView(this.dNO.getHeaderView());
            this.duz.addHeaderView(this.dNO.getHeaderView());
            this.dNO.it(qVar.getImageUrl());
            this.dNO.setTitle(qVar.getTitle());
            this.dNO.setSchemaUrl(qVar.getLinkUrl());
            if (z) {
                this.dNO.hideTitle();
            }
        }
    }

    private void g(l lVar) {
        if (lVar == null || lVar.bwN() == null || v.z(lVar.bwN().uO()) || this.duz == null || this.dNB == null || this.dNB.getView() == null || this.dNP == null || this.dNP.getHeaderView() == null) {
            this.dNN = false;
            return;
        }
        q qVar = lVar.bwN().uO().get(0);
        if (qVar == null) {
            this.dNN = false;
            return;
        }
        this.dNN = true;
        this.dNB.getView().setBackgroundColor(0);
        this.dNP.aBs().removeView(this.dNB.getView());
        this.dNP.aBs().addView(this.dNB.getView());
        this.duz.removeHeaderView(this.dNP.getHeaderView());
        this.duz.addHeaderView(this.dNP.getHeaderView());
        this.dNP.it(qVar.getImageUrl());
        this.dNP.setSchemaUrl(qVar.getLinkUrl());
        this.dNP.setTitle(qVar.getTitle());
        if (this.dNP instanceof com.baidu.tieba.frs.c.a) {
            ((com.baidu.tieba.frs.c.a) this.dNP).bw(lVar.gTN);
        }
    }

    private void s(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.dNE, str);
        this.dNG = i2;
        this.dNE = str;
        aCH();
        if (this.dNB == null || z) {
            this.dNB = this.dNK.a(str, this.dKj, i);
            this.dNB.changeSkinType(this.mSkinType);
            this.dNB.q(this.dud);
        }
        this.duz.addHeaderView(this.dNB.getView());
        int h = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0141e.tbds44);
        this.dNB.q(0, h, 0, h);
        aCI();
        if (this.dNR != null) {
            this.dNR.aR(this.dNB.ayR());
        }
    }

    private void t(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.dNE, str);
        this.dNG = i2;
        this.dNE = str;
        aCH();
        if (this.dNB == null || z) {
            this.dNB = this.dNK.a(str, this.dKj, i);
            this.dNB.changeSkinType(this.mSkinType);
            this.dNB.q(this.dud);
            this.dNB.ayW();
        }
        this.dNB.q(0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0141e.tbds132), 0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0141e.tbds44));
        aCI();
        if (this.dNR != null) {
            this.dNR.aR(this.dNB.ayR());
        }
    }

    public void aCG() {
        if (!this.dNJ && this.dNB != null) {
            this.duz.addHeaderView(this.dNB.aDr());
            if (this.dNB.ayR() != null && this.dKj.Cb() != null) {
                this.dKj.Cb().addHeaderView(this.dNB.ayR(), 0);
            }
            this.dNJ = true;
        }
    }

    private void aCH() {
        if (("normal_page".equals(this.dNE) || "frs_page".equals(this.dNE) || "book_page".equals(this.dNE) || "brand_page".equals(this.dNE)) && this.dNB != null) {
            this.duz.removeHeaderView(this.dNB.getView());
            this.duz.removeHeaderView(this.dNB.aDr());
            if (this.dNB.ayR() != null && this.dKj.Cb() != null) {
                this.dKj.Cb().removeHeaderView(this.dNB.ayR());
            }
        }
        this.dNJ = false;
    }

    private void aCI() {
        if (this.dNF == null) {
            this.dNF = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.dKj.awe() == null || !f.this.dKj.awe().aww()) && f.this.duz.isShown() && f.this.dKj.isPrimary() && !f.this.dNH && f.this.dNG == 1 && f.this.dKj.awe() != null && f.this.dKj.awe().awW() != null && !f.this.dKj.awe().awW().azC() && f.this.dKj.awA()) {
                            if (("frs_page".equals(f.this.dNE) || "normal_page".equals(f.this.dNE) || "brand_page".equals(f.this.mPageType) || "book_page".equals(f.this.dNE)) && f.this.dNB != null && f.this.dNB.aDq()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.aze();
                                f.this.dKj.drY = true;
                                f.this.dNH = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.jt().postDelayed(this.dNF, 4000L);
    }

    public void h(l lVar) {
        if (lVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                b(lVar.bbH(), lVar);
                if ("brand_page".equals(this.mPageType)) {
                    this.dNB.ayX();
                }
            }
        }
    }

    public void b(ForumData forumData, l lVar) {
        if (forumData != null && lVar != null) {
            float b = b(forumData);
            if (this.dNB != null) {
                this.dNB.a(forumData, lVar);
                this.dNB.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                if (forumData.getSignData() != null) {
                    this.dNB.mH(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.dNB.gU(false);
                        return;
                    }
                    this.dNB.gU(true);
                    this.dNB.mH(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.dNC = forumData.getLevelupScore();
        this.dND = forumData.getCurScore();
        if (this.dNC > 0) {
            return this.dND / this.dNC;
        }
        return 0.0f;
    }

    public void mn(int i) {
        if (i > 1) {
            if (this.dNB != null) {
                this.dNB.gV(false);
            }
        } else if (this.dNB != null) {
            this.dNB.gV(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void aCJ() {
        if (this.duz != null) {
            this.duz.removeCallbacks(this.dNU);
            this.duz.postDelayed(this.dNU, 100L);
        }
    }

    public void g(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            aCK();
        }
    }

    public void setIsMem(int i) {
        if (this.dNB != null) {
            this.dNB.setMemberType(i);
        }
    }

    public void aze() {
        if (("normal_page".equals(this.dNE) || "frs_page".equals(this.dNE) || "book_page".equals(this.dNE) || "brand_page".equals(this.mPageType)) && this.dNB != null) {
            this.dNB.aze();
        }
    }

    public void aCK() {
        if (this.dNB != null) {
            this.dNB.azg();
        }
    }

    public void a(l lVar, boolean z) {
        if (lVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                a(1, lVar.bbH(), lVar, z);
            }
        }
    }

    public void aCL() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            mp(0);
        }
    }

    public void mo(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            mp(i);
        }
    }

    public void mp(int i) {
        if (this.dNB != null) {
            this.dNB.mG(i);
        }
    }

    public void a(int i, ForumData forumData, l lVar, boolean z) {
        if (this.dNB != null) {
            this.dNB.a(forumData, lVar);
            if (forumData != null) {
                this.dNB.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.dNB.gU(false);
                }
            }
        }
    }

    public boolean aCM() {
        if (("normal_page".equals(this.dNE) || "frs_page".equals(this.dNE) || "book_page".equals(this.dNE) || "brand_page".equals(this.mPageType)) && this.dNB != null) {
            return this.dNB.aDp();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.dNC - this.dND) {
                z = true;
                this.dNC = signData.levelup_score;
            }
            this.dND = i + this.dND;
            if (this.dND > this.dNC) {
                this.dND = this.dNC;
            }
            if (this.dNC != 0) {
                f = this.dND / this.dNC;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.d(z, f);
        }
    }

    public void mq(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.dNB != null) {
            this.dNB.mH(i);
        }
    }

    public void i(l lVar) {
        SignData signData;
        ForumData bbH;
        if (lVar != null && lVar.bbH() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.dNB != null && (signData = lVar.bbH().getSignData()) != null && (bbH = lVar.bbH()) != null) {
                this.dNB.a(bbH, lVar);
                this.dNB.mH(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.dNB.aDp()) {
                    a(this.dNB, signData);
                    bbH.setCurScore(this.dND);
                    bbH.setLevelupScore(this.dNC);
                    this.dNB.a(bbH, lVar);
                }
            }
        }
    }

    public boolean aCN() {
        if (("normal_page".equals(this.dNE) || "frs_page".equals(this.dNE) || "book_page".equals(this.dNE) || "brand_page".equals(this.mPageType)) && this.dNB != null) {
            return this.dNB.aCN();
        }
        return false;
    }

    public boolean aCO() {
        if (("normal_page".equals(this.dNE) || "frs_page".equals(this.dNE) || "book_page".equals(this.dNE) || "brand_page".equals(this.mPageType)) && this.dNB != null) {
            return this.dNB.aCO();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void gL(boolean z) {
        if (this.dKj != null) {
            l awv = this.dKj.awv();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.dKj.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11002)));
            } else if (awv != null && awv.bbH() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.dKj.getFrom())) {
                    TiebaStatic.log(new am("c10356").al(ImageViewerConfig.FORUM_ID, awv.bbH().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.dKj.getFrom())) {
                    TiebaStatic.log(new am("c10590").w("obj_type", 2).al(ImageViewerConfig.FORUM_ID, awv.bbH().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.dKj.getFrom())) {
                    TiebaStatic.log(new am("c10587").w("obj_type", 2).al(ImageViewerConfig.FORUM_ID, awv.bbH().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.dKj.getFrom())) {
                    TiebaStatic.log(new am("c10578").w("obj_type", 2).al(ImageViewerConfig.FORUM_ID, awv.bbH().getId()));
                }
                this.aCp.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.dKj.getFrom())) {
                    TiebaStatic.eventStat(this.dKj.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.dKj.getFrom())) {
                    TiebaStatic.log(new am("c10359").al(ImageViewerConfig.FORUM_ID, awv.bbH().getId()));
                }
                this.aCp.I(awv.bbH().getName(), awv.bbH().getId(), "FRS");
                this.dNL = z;
            }
        }
    }

    public void aCP() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.dKj.awv() != null && this.dKj.awv().bbH() != null && this.dKj.awv().bbH().getName() != null) {
            str = this.dKj.awv().bbH().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.dT(String.format(getPageContext().getString(e.j.attention_cancel_dialog_content), str));
        } else {
            aVar.dT(getPageContext().getString(e.j.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(e.j.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.10
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                l awv = f.this.dKj.awv();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.dKj.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(f.this.getPageContext().getPageActivity(), true, 11036)));
                } else if (awv != null && awv.bbH() != null) {
                    f.this.dNI.v(awv.bbH().getName(), com.baidu.adp.lib.g.b.d(awv.bbH().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(e.j.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).yl();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void aCQ() {
        l awv = this.dKj.awv();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.dKj.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11014)));
        } else if (awv != null && awv.bbH() != null) {
            FrsActivityStatic.forumName = awv.bbH().getName() == null ? "" : awv.bbH().getName();
            CustomMessage customMessage = new CustomMessage(2001425, awv.bbH());
            customMessage.setTag(this.dNQ);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nK(String str) {
        if (this.dKj.avZ() != null && this.dKj.avZ().aBH() != null) {
            com.baidu.tieba.tbadkCore.c.bwy().U(com.baidu.tieba.tbadkCore.c.bwy().d(str, this.dKj.avZ().aBH().Xb(), this.dKj.avZ().aBH().getIsGood(), this.dKj.avZ().aBH().getCategoryId()), false);
        }
    }

    private void VL() {
        this.aCp = new LikeModel(this.dKj.getPageContext());
        this.aCp.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
            @Override // com.baidu.adp.base.d
            public void j(Object obj) {
                r rVar;
                boolean z = false;
                l awv = f.this.dKj.awv();
                if (awv != null && awv.bbH() != null && obj != null) {
                    if (AntiHelper.am(f.this.aCp.getErrorCode(), f.this.aCp.getErrorString())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.aCp.getBlockPopInfoData(), f.this.dNS) != null) {
                            TiebaStatic.log(new am("c12534").w("obj_locate", as.a.atS));
                            return;
                        }
                        return;
                    }
                    String name = awv.bbH().getName();
                    String id = awv.bbH().getId();
                    if (!(obj instanceof r)) {
                        rVar = null;
                    } else {
                        rVar = (r) obj;
                    }
                    boolean z2 = rVar != null && f.this.aCp.getErrorCode() == 0;
                    if (rVar.getErrorCode() == 3250013) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), rVar.getErrorMsg(), e.f.icon_toast_game_error, 3000).yt();
                    } else {
                        z = z2;
                    }
                    if (rVar == null || !z) {
                        if (f.this.aCp.getErrorCode() == 22) {
                            f.this.dKj.showToast(f.this.getPageContext().getString(e.j.had_liked_forum));
                        } else {
                            f.this.dKj.showToast(f.this.aCp.getErrorString());
                        }
                    } else {
                        f.this.nK(name);
                        rVar.setLike(1);
                        awv.c(rVar);
                        awv.dr(rVar.bwF());
                        f.this.a(awv, f.this.dNL);
                        f.this.dNL = true;
                        f.this.dKj.showToast(f.this.getPageContext().getResources().getString(e.j.attention_success));
                        f.this.h(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                    }
                    f.this.dKj.aa(Boolean.valueOf(z));
                }
            }
        });
    }

    private void aCR() {
        this.dNI = new w();
        this.dNI.setFrom("from_frs");
        this.dNI.a(new w.a() { // from class: com.baidu.tieba.frs.vc.f.3
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void o(String str, long j) {
                l awv = f.this.dKj.awv();
                if (awv != null && awv.bbH() != null) {
                    String name = awv.bbH().getName();
                    String id = awv.bbH().getId();
                    if (j == com.baidu.adp.lib.g.b.d(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.nK(str);
                        awv.bbH().setLike(0);
                        f.this.mo(0);
                        f.this.dKj.Z(true);
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
            public void p(String str, long j) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.aPH().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void F(int i, int i2, int i3) {
        l awv;
        if (i > 0 && i2 > 0 && (awv = this.dKj.awv()) != null && awv.bbH() != null && awv.getSignData() != null) {
            ForumData bbH = awv.bbH();
            SignData signData = awv.getSignData();
            signData.levelup_score = bbH.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            awv.d(signData);
            signData.forumId = bbH.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
            int i4 = -1;
            if (aCO()) {
                i4 = bbH.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(bbH.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void ayO() {
        if (this.dNB != null) {
            this.dNB.ayO();
        }
    }

    public static boolean j(l lVar) {
        if (lVar != null) {
            return (lVar.bxd() == null || StringUtils.isNull(lVar.bxd().uP(), true) || lVar.bxd().uP().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean k(l lVar) {
        if (lVar != null) {
            return ((lVar.bwM() == null || lVar.bwM().bxx() != 1) && lVar.bxc() == null && (lVar.bwN() == null || v.z(lVar.bwN().uO())) && ((lVar.bbH() == null || lVar.bbH().getFrsBannerData() == null || lVar.bbH().getFrsBannerData().getType() != 2) && (lVar.bxe() == null || StringUtils.isNull(lVar.bxe().uW(), true)))) ? false : true;
        }
        return false;
    }

    public void mr(int i) {
        View findViewById;
        if (this.dNB != null && this.dNB.aDr() != null && (findViewById = this.dNB.aDr().findViewById(e.g.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.dNM != null) {
            this.dNM.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.dNR = frsTabViewController;
    }
}
