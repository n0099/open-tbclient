package com.baidu.tieba.frs.vc;

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
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
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
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
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
/* loaded from: classes6.dex */
public class f extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private LikeModel aLn;
    private final View.OnClickListener dMI;
    private FrsHeaderViewContainer dNd;
    private FrsFragment ecG;
    private com.baidu.tieba.frs.view.b efY;
    private int efZ;
    private int ega;
    private String egb;
    private Runnable egc;
    private int egd;
    private boolean ege;
    private w egf;
    private boolean egg;
    private com.baidu.tieba.frs.entelechy.b.a egh;
    private boolean egi;
    private com.baidu.tieba.f.a egj;
    private boolean egk;
    private com.baidu.tieba.frs.c.a.a egl;
    private com.baidu.tieba.frs.c.a.a egm;
    private BdUniqueId egn;
    private FrsTabViewController ego;
    private AntiHelper.a egp;
    private CustomMessageListener egq;
    private Runnable egr;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.dNd = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.egb = null;
        this.ege = false;
        this.aLn = null;
        this.egf = null;
        this.egg = false;
        this.egk = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12536").x("obj_locate", as.a.aCP));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12535").x("obj_locate", as.a.aCP));
            }
        };
        this.egp = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.4
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12536").x("obj_locate", as.a.aCR));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12535").x("obj_locate", as.a.aCR));
            }
        };
        this.egq = new CustomMessageListener(2001425) { // from class: com.baidu.tieba.frs.vc.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                l aBO;
                String name;
                SignData signData;
                boolean z;
                int i;
                if (f.this.ecG != null && (customResponsedMessage instanceof SignMessage) && (aBO = f.this.ecG.aBO()) != null && aBO.bgT() != null && (name = aBO.bgT().getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == f.this.egn) {
                    TiebaStatic.eventStat(f.this.ecG.getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name2 = aBO.bgT().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.aj(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                        if (signMessage.signData != null) {
                            AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener);
                        } else {
                            AntiHelper.aJ(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                        }
                        TiebaStatic.log(new am("c12534").x("obj_locate", as.a.aCP));
                        return;
                    }
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(aBO.bgT().getId())) {
                            f.this.oR(name2);
                            aBO.d(signData2);
                            signData2.forumId = aBO.bgT().getId();
                            signData2.forumName = aBO.bgT().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = aBO.bgT().getUser_level();
                        if (f.this.aId()) {
                            i = aBO.bgT().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                        if (signData.mContriInfo != null && signData.mContriInfo.isShowToast()) {
                            f.this.ecG.a(signData.mContriInfo);
                            return;
                        }
                        if (!f.this.aIb()) {
                            f.this.ecG.showToast(f.this.getPageContext().getResources().getString(e.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                        } else {
                            f.this.ecG.showToast(f.this.getPageContext().getResources().getString(e.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                        }
                        if (f.this.ecG.aBx() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.IS().a(f.this.ecG.getTbPageContext(), f.this.ecG.aBx().aCF());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.nJ(1);
                    }
                    f.this.ecG.showToast(signMessage.mSignErrorString);
                }
            }
        };
        this.egr = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.8
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.dNd != null) {
                    int childCount = f.this.dNd.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(f.this.dNd.getChildAt(i));
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
        this.dMI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l aBO = f.this.ecG.aBO();
                if (aBO != null && aBO.bgT() != null && f.this.efY != null && (view == f.this.efY.aIJ() || view == f.this.efY.aIK() || view == f.this.efY.aIL())) {
                    if (f.this.ecG != null && aBO.bgT() != null) {
                        TiebaStatic.log(new am("c12046").aA(ImageViewerConfig.FORUM_ID, aBO.bgT().getId()).x("obj_locate", f.this.ecG.aBQ() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), aBO.bgT().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == e.g.tv_love) {
                    if (!f.this.ecG.aBP()) {
                        if (!com.baidu.adp.lib.util.j.kV()) {
                            f.this.ecG.showToast(e.j.neterror);
                        } else if (!ba.bJ(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new am("c10517").x("obj_locate", 1).aA(ImageViewerConfig.FORUM_ID, f.this.ecG.getForumId()));
                        } else {
                            f.this.hs(true);
                            if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                am amVar = new am("c10048");
                                amVar.aA(ImageViewerConfig.FORUM_ID, f.this.ecG.getForumId());
                                amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(amVar);
                            }
                        }
                    }
                } else if (id == e.g.tv_sign) {
                    if (!f.this.ecG.aBP()) {
                        if (!com.baidu.adp.lib.util.j.kV()) {
                            f.this.ecG.showToast(e.j.neterror);
                        } else if (ba.bJ(f.this.mContext.getPageActivity())) {
                            if (!f.this.aIc()) {
                                f.this.aIf();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(f.this.ecG.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.l(f.this.ecG.getForumId(), 0), 24002)));
                            }
                        }
                    }
                } else if (id == e.g.frs_header_games) {
                    if (ba.bJ(f.this.mContext.getPageActivity()) && aBO != null && aBO.bCr() != null) {
                        ay.Ef().a((TbPageContext) f.this.getPageContext(), new String[]{aBO.bCr()}, true);
                    }
                } else if (id == e.g.frs_bawu_center) {
                    if (aBO != null && aBO.getUserData() != null && aBO.getUserData().isBawu()) {
                        String bCv = aBO.bCv();
                        if (!ao.isEmpty(bCv)) {
                            com.baidu.tbadk.browser.a.ad(f.this.getPageContext().getPageActivity(), bCv);
                            if (aBO.bgT() != null) {
                                TiebaStatic.log(new am("c10502").aA(ImageViewerConfig.FORUM_ID, aBO.bgT().getId()).aA("uid", aBO.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == e.g.level_container && !f.this.ecG.aBP() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page") || f.this.mPageType.equals("brand_page")) && f.this.efY != null) {
                        f.this.efY.h(view, false);
                    }
                }
            }
        };
        this.ecG = frsFragment;
        this.egh = aVar;
        this.dNd = frsHeaderViewContainer;
        this.egl = new com.baidu.tieba.frs.c.b(frsFragment.getTbPageContext());
        this.egm = new com.baidu.tieba.frs.c.a(frsFragment.getTbPageContext());
        this.egn = BdUniqueId.gen();
        this.egj = new com.baidu.tieba.f.a();
        this.egj.a(new a.InterfaceC0214a() { // from class: com.baidu.tieba.frs.vc.f.6
            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void ar(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void as(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void at(int i, int i2) {
            }
        });
    }

    public void t(Bundle bundle) {
        this.ecG.registerListener(this.egq);
        aaL();
        aIg();
        this.ege = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.efY != null) {
            this.efY.onDestory();
        }
        if (this.aLn != null) {
            this.aLn.bDy();
        }
        if (this.egc != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.egc);
        }
    }

    public void onActivityStop() {
        if (this.efY != null) {
            this.efY.onStop();
        }
        if (this.dNd != null) {
            this.dNd.removeCallbacks(this.egr);
        }
    }

    public void gx(boolean z) {
        if (this.efY != null) {
            this.efY.gx(z);
        }
    }

    public boolean nF(int i) {
        this.mSkinType = i;
        if (this.efY != null) {
            this.efY.changeSkinType(i);
        }
        if (this.egl != null) {
            this.egl.onChangeSkinType(i);
        }
        if (this.egm != null) {
            this.egm.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    public void hr(boolean z) {
        if (z) {
            if (this.efY != null) {
                this.dNd.removeHeaderView(this.efY.aII());
                this.egg = false;
            }
        } else if (this.efY != null && this.efY.aII() != null && !this.egg) {
            this.dNd.addHeaderView(this.efY.aII(), this.dNd.getHeaderViewsCount());
            this.egg = true;
        }
    }

    public void a(String str, l lVar) {
        this.mPageType = str;
        if ("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str) || "brand_page".equals(str)) {
            if (!"brand_page".equals(str) && lVar != null && lVar.bCj() != null && lVar.bCj().yj() != null && lVar.bCj().yj().size() >= 1) {
                a(lVar.bCj().yj().get(0), false, lVar);
            } else if (!"brand_page".equals(str) && lVar != null && lVar.bCi() != null && !StringUtils.isNull(lVar.bCi().bCX())) {
                q qVar = new q();
                qVar.setLinkUrl("");
                qVar.setImageUrl(lVar.bCi().bCX());
                a(qVar, true, lVar);
            } else if (lVar != null && "brand_page".equals(str) && lVar.bCj() != null && lVar.bCj().yj() != null && lVar.bCj().yj().size() >= 1) {
                v(str, lVar.getUserData().getIsMem(), lVar.bgT().isLike());
                h(lVar);
            } else {
                this.egk = false;
                if (this.dNd != null && this.egl != null && this.egl.getHeaderView() != null) {
                    this.dNd.removeHeaderView(this.egl.getHeaderView());
                }
                if (this.dNd != null && this.egm != null && this.egm.getHeaderView() != null) {
                    this.dNd.removeHeaderView(this.egm.getHeaderView());
                }
            }
            if (lVar != null && lVar.getUserData() != null && lVar.bgT() != null && !"brand_page".equals(str)) {
                u(str, lVar.getUserData().getIsMem(), lVar.bgT().isLike());
            }
        }
    }

    public boolean aHU() {
        return this.egk;
    }

    private void a(q qVar, boolean z, l lVar) {
        if (qVar == null) {
            this.egk = false;
        } else if (this.dNd == null || this.egl == null || this.egl.getHeaderView() == null) {
            this.egk = false;
        } else {
            this.egk = true;
            this.dNd.removeHeaderView(this.egl.getHeaderView());
            this.dNd.addHeaderView(this.egl.getHeaderView());
            this.egl.a(lVar, qVar.getImageUrl());
            this.egl.setTitle(qVar.getTitle());
            this.egl.setSchemaUrl(qVar.getLinkUrl());
            if (z) {
                this.egl.hideTitle();
            }
        }
        if (lVar != null && lVar.bgT() != null && !TextUtils.isEmpty(lVar.bgT().getId()) && lVar.bCj() != null && !TextUtils.isEmpty(lVar.bCj().yk())) {
            am amVar = new am("c13326");
            amVar.aA(ImageViewerConfig.FORUM_ID, lVar.bgT().getId());
            amVar.aA(VideoPlayActivityConfig.OBJ_ID, lVar.bCj().yk());
            TiebaStatic.log(amVar);
        }
    }

    private void h(l lVar) {
        if (lVar == null || lVar.bCj() == null || v.I(lVar.bCj().yj()) || this.dNd == null || this.efY == null || this.efY.getView() == null || this.egm == null || this.egm.getHeaderView() == null) {
            this.egk = false;
            return;
        }
        q qVar = lVar.bCj().yj().get(0);
        if (qVar == null) {
            this.egk = false;
            return;
        }
        this.egk = true;
        this.efY.getView().setBackgroundColor(0);
        this.egm.aGI().removeView(this.efY.getView());
        this.egm.aGI().addView(this.efY.getView());
        this.dNd.removeHeaderView(this.egm.getHeaderView());
        this.dNd.addHeaderView(this.egm.getHeaderView());
        this.egm.a(lVar, qVar.getImageUrl());
        this.egm.setSchemaUrl(qVar.getLinkUrl());
        this.egm.setTitle(qVar.getTitle());
        if (this.egm instanceof com.baidu.tieba.frs.c.a) {
            ((com.baidu.tieba.frs.c.a) this.egm).bN(lVar.hmK);
        }
    }

    private void u(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.egb, str);
        this.egd = i2;
        this.egb = str;
        aHW();
        if (this.efY == null || z) {
            this.efY = this.egh.a(str, this.ecG, i);
            this.efY.changeSkinType(this.mSkinType);
            this.efY.s(this.dMI);
        }
        this.dNd.addHeaderView(this.efY.getView());
        int h = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0210e.tbds44);
        this.efY.q(0, h, 0, h);
        aHX();
        if (this.ego != null) {
            this.ego.aW(this.efY.aEg());
        }
    }

    private void v(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.egb, str);
        this.egd = i2;
        this.egb = str;
        aHW();
        if (this.efY == null || z) {
            this.efY = this.egh.a(str, this.ecG, i);
            this.efY.changeSkinType(this.mSkinType);
            this.efY.s(this.dMI);
            this.efY.aEl();
        }
        this.efY.q(0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0210e.tbds132), 0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0210e.tbds44));
        aHX();
        if (this.ego != null) {
            this.ego.aW(this.efY.aEg());
        }
    }

    public void aHV() {
        if (!this.egg && this.efY != null) {
            this.dNd.addHeaderView(this.efY.aII());
            if (this.efY.aEg() != null && this.ecG.Fv() != null) {
                this.ecG.Fv().addHeaderView(this.efY.aEg(), 0);
            }
            this.egg = true;
        }
    }

    private void aHW() {
        if (("normal_page".equals(this.egb) || "frs_page".equals(this.egb) || "book_page".equals(this.egb) || "brand_page".equals(this.egb)) && this.efY != null) {
            this.dNd.removeHeaderView(this.efY.getView());
            this.dNd.removeHeaderView(this.efY.aII());
            if (this.efY.aEg() != null && this.ecG.Fv() != null) {
                this.ecG.Fv().removeHeaderView(this.efY.aEg());
            }
        }
        this.egg = false;
    }

    private void aHX() {
        if (this.egc == null) {
            this.egc = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.ecG.aBx() == null || !f.this.ecG.aBx().aBP()) && f.this.dNd.isShown() && f.this.ecG.isPrimary() && !f.this.ege && f.this.egd == 1 && f.this.ecG.aBx() != null && f.this.ecG.aBx().aCo() != null && !f.this.ecG.aBx().aCo().aER() && f.this.ecG.aBT()) {
                            if (("frs_page".equals(f.this.egb) || "normal_page".equals(f.this.egb) || "brand_page".equals(f.this.mPageType) || "book_page".equals(f.this.egb)) && f.this.efY != null && f.this.efY.aIH()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.aEt();
                                f.this.ecG.dKE = true;
                                f.this.ege = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.jG().postDelayed(this.egc, 4000L);
    }

    public void i(l lVar) {
        if (lVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                b(lVar.bgT(), lVar);
                if ("brand_page".equals(this.mPageType)) {
                    this.efY.aEm();
                }
            }
        }
    }

    public void b(ForumData forumData, l lVar) {
        if (forumData != null && lVar != null) {
            float b = b(forumData);
            if (this.efY != null) {
                this.efY.a(forumData, lVar);
                this.efY.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                if (forumData.getSignData() != null) {
                    this.efY.oa(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.efY.hB(false);
                        return;
                    }
                    this.efY.hB(true);
                    this.efY.oa(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.efZ = forumData.getLevelupScore();
        this.ega = forumData.getCurScore();
        if (this.efZ > 0) {
            return this.ega / this.efZ;
        }
        return 0.0f;
    }

    public void nG(int i) {
        if (i > 1) {
            if (this.efY != null) {
                this.efY.hC(false);
            }
        } else if (this.efY != null) {
            this.efY.hC(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void aHY() {
        if (this.dNd != null) {
            this.dNd.removeCallbacks(this.egr);
            this.dNd.postDelayed(this.egr, 100L);
        }
    }

    public void g(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            aHZ();
        }
    }

    public void setIsMem(int i) {
        if (this.efY != null) {
            this.efY.setMemberType(i);
        }
    }

    public void aEt() {
        if (("normal_page".equals(this.egb) || "frs_page".equals(this.egb) || "book_page".equals(this.egb) || "brand_page".equals(this.mPageType)) && this.efY != null) {
            this.efY.aEt();
        }
    }

    public void aHZ() {
        if (this.efY != null) {
            this.efY.aEv();
        }
    }

    public void a(l lVar, boolean z) {
        if (lVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                a(1, lVar.bgT(), lVar, z);
            }
        }
    }

    public void aIa() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            nI(0);
        }
    }

    public void nH(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            nI(i);
        }
    }

    public void nI(int i) {
        if (this.efY != null) {
            this.efY.nZ(i);
        }
    }

    public void a(int i, ForumData forumData, l lVar, boolean z) {
        if (this.efY != null) {
            this.efY.a(forumData, lVar);
            if (forumData != null) {
                this.efY.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.efY.hB(false);
                }
            }
        }
    }

    public boolean aIb() {
        if (("normal_page".equals(this.egb) || "frs_page".equals(this.egb) || "book_page".equals(this.egb) || "brand_page".equals(this.mPageType)) && this.efY != null) {
            return this.efY.aIG();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.efZ - this.ega) {
                z = true;
                this.efZ = signData.levelup_score;
            }
            this.ega = i + this.ega;
            if (this.ega > this.efZ) {
                this.ega = this.efZ;
            }
            if (this.efZ != 0) {
                f = this.ega / this.efZ;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.d(z, f);
        }
    }

    public void nJ(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.efY != null) {
            this.efY.oa(i);
        }
    }

    public void j(l lVar) {
        SignData signData;
        ForumData bgT;
        if (lVar != null && lVar.bgT() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.efY != null && (signData = lVar.bgT().getSignData()) != null && (bgT = lVar.bgT()) != null) {
                this.efY.a(bgT, lVar);
                this.efY.oa(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.efY.aIG()) {
                    a(this.efY, signData);
                    bgT.setCurScore(this.ega);
                    bgT.setLevelupScore(this.efZ);
                    this.efY.a(bgT, lVar);
                }
            }
        }
    }

    public boolean aIc() {
        if (("normal_page".equals(this.egb) || "frs_page".equals(this.egb) || "book_page".equals(this.egb) || "brand_page".equals(this.mPageType)) && this.efY != null) {
            return this.efY.aIc();
        }
        return false;
    }

    public boolean aId() {
        if (("normal_page".equals(this.egb) || "frs_page".equals(this.egb) || "book_page".equals(this.egb) || "brand_page".equals(this.mPageType)) && this.efY != null) {
            return this.efY.aId();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void hs(boolean z) {
        if (this.ecG != null) {
            l aBO = this.ecG.aBO();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.ecG.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), true, 11002)));
            } else if (aBO != null && aBO.bgT() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.ecG.getFrom())) {
                    TiebaStatic.log(new am("c10356").aA(ImageViewerConfig.FORUM_ID, aBO.bgT().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.ecG.getFrom())) {
                    TiebaStatic.log(new am("c10590").x("obj_type", 2).aA(ImageViewerConfig.FORUM_ID, aBO.bgT().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.ecG.getFrom())) {
                    TiebaStatic.log(new am("c10587").x("obj_type", 2).aA(ImageViewerConfig.FORUM_ID, aBO.bgT().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.ecG.getFrom())) {
                    TiebaStatic.log(new am("c10578").x("obj_type", 2).aA(ImageViewerConfig.FORUM_ID, aBO.bgT().getId()));
                }
                this.aLn.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.ecG.getFrom())) {
                    TiebaStatic.eventStat(this.ecG.getPageContext().getPageActivity(), "square_frs_focus", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.ecG.getFrom())) {
                    TiebaStatic.log(new am("c10359").aA(ImageViewerConfig.FORUM_ID, aBO.bgT().getId()));
                }
                this.aLn.Q(aBO.bgT().getName(), aBO.bgT().getId(), "FRS");
                this.egi = z;
            }
        }
    }

    public void aIe() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.ecG.aBO() != null && this.ecG.aBO().bgT() != null && this.ecG.aBO().bgT().getName() != null) {
            str = this.ecG.aBO().bgT().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.eB(String.format(getPageContext().getString(e.j.attention_cancel_dialog_content), str));
        } else {
            aVar.eB(getPageContext().getString(e.j.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(e.j.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.10
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                l aBO = f.this.ecG.aBO();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.ecG.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) f.this.getPageContext().getPageActivity(), true, 11036)));
                } else if (aBO != null && aBO.bgT() != null) {
                    f.this.egf.w(aBO.bgT().getName(), com.baidu.adp.lib.g.b.d(aBO.bgT().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(e.j.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).BF();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void aIf() {
        l aBO = this.ecG.aBO();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.ecG.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), true, 11014)));
        } else if (aBO != null && aBO.bgT() != null) {
            FrsActivityStatic.forumName = aBO.bgT().getName() == null ? "" : aBO.bgT().getName();
            CustomMessage customMessage = new CustomMessage(2001425, aBO.bgT());
            customMessage.setTag(this.egn);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oR(String str) {
        if (this.ecG.aBs() != null && this.ecG.aBs().aGX() != null) {
            com.baidu.tieba.tbadkCore.c.bBU().ad(com.baidu.tieba.tbadkCore.c.bBU().d(str, this.ecG.aBs().aGX().acb(), this.ecG.aBs().aGX().getIsGood(), this.ecG.aBs().aGX().getCategoryId()), false);
        }
    }

    private void aaL() {
        this.aLn = new LikeModel(this.ecG.getPageContext());
        this.aLn.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                r rVar;
                boolean z = false;
                l aBO = f.this.ecG.aBO();
                if (aBO != null && aBO.bgT() != null && obj != null) {
                    if (AntiHelper.aj(f.this.aLn.getErrorCode(), f.this.aLn.getErrorString())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.aLn.getBlockPopInfoData(), f.this.egp) != null) {
                            TiebaStatic.log(new am("c12534").x("obj_locate", as.a.aCR));
                            return;
                        }
                        return;
                    }
                    String name = aBO.bgT().getName();
                    String id = aBO.bgT().getId();
                    if (!(obj instanceof r)) {
                        rVar = null;
                    } else {
                        rVar = (r) obj;
                    }
                    boolean z2 = rVar != null && f.this.aLn.getErrorCode() == 0;
                    if (rVar.getErrorCode() == 3250013) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), rVar.getErrorMsg(), e.f.icon_toast_game_error, 3000).BN();
                    } else {
                        z = z2;
                    }
                    if (rVar == null || !z) {
                        if (f.this.aLn.getErrorCode() == 22) {
                            f.this.ecG.showToast(f.this.getPageContext().getString(e.j.had_liked_forum));
                        } else {
                            f.this.ecG.showToast(f.this.aLn.getErrorString());
                        }
                    } else {
                        f.this.oR(name);
                        rVar.setLike(1);
                        aBO.c(rVar);
                        aBO.dI(rVar.bCb());
                        f.this.a(aBO, f.this.egi);
                        f.this.egi = true;
                        f.this.ecG.showToast(f.this.getPageContext().getResources().getString(e.j.attention_success));
                        f.this.h(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                    }
                    f.this.ecG.ad(Boolean.valueOf(z));
                }
            }
        });
    }

    private void aIg() {
        this.egf = new w();
        this.egf.setFrom("from_frs");
        this.egf.a(new w.a() { // from class: com.baidu.tieba.frs.vc.f.3
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void p(String str, long j) {
                l aBO = f.this.ecG.aBO();
                if (aBO != null && aBO.bgT() != null) {
                    String name = aBO.bgT().getName();
                    String id = aBO.bgT().getId();
                    if (j == com.baidu.adp.lib.g.b.d(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.oR(str);
                        aBO.bgT().setLike(0);
                        f.this.nH(0);
                        f.this.ecG.ac(true);
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
            public void q(String str, long j) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.aUX().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void F(int i, int i2, int i3) {
        l aBO;
        if (i > 0 && i2 > 0 && (aBO = this.ecG.aBO()) != null && aBO.bgT() != null && aBO.getSignData() != null) {
            ForumData bgT = aBO.bgT();
            SignData signData = aBO.getSignData();
            signData.levelup_score = bgT.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            aBO.d(signData);
            signData.forumId = bgT.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
            int i4 = -1;
            if (aId()) {
                i4 = bgT.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(bgT.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void aEb() {
        if (this.efY != null) {
            this.efY.aEb();
        }
    }

    public static boolean k(l lVar) {
        if (lVar != null) {
            return (lVar.bCz() == null || StringUtils.isNull(lVar.bCz().yl(), true) || lVar.bCz().yl().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean l(l lVar) {
        if (lVar != null) {
            return ((lVar.bCi() == null || lVar.bCi().bCT() != 1) && lVar.bCy() == null && (lVar.bCj() == null || v.I(lVar.bCj().yj())) && ((lVar.bgT() == null || lVar.bgT().getFrsBannerData() == null || lVar.bgT().getFrsBannerData().getType() != 2) && (lVar.bCA() == null || StringUtils.isNull(lVar.bCA().ys(), true)))) ? false : true;
        }
        return false;
    }

    public void nK(int i) {
        View findViewById;
        if (this.efY != null && this.efY.aII() != null && (findViewById = this.efY.aII().findViewById(e.g.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.egj != null) {
            this.egj.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.ego = frsTabViewController;
    }
}
