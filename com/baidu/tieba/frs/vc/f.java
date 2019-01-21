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
    private LikeModel aLQ;
    private FrsHeaderViewContainer dNN;
    private final View.OnClickListener dNs;
    private FrsFragment edn;
    private com.baidu.tieba.frs.view.b egF;
    private int egG;
    private int egH;
    private String egI;
    private Runnable egJ;
    private int egK;
    private boolean egL;
    private w egM;
    private boolean egN;
    private com.baidu.tieba.frs.entelechy.b.a egO;
    private boolean egP;
    private com.baidu.tieba.f.a egQ;
    private boolean egR;
    private com.baidu.tieba.frs.c.a.a egS;
    private com.baidu.tieba.frs.c.a.a egT;
    private BdUniqueId egU;
    private FrsTabViewController egV;
    private AntiHelper.a egW;
    private CustomMessageListener egX;
    private Runnable egY;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.dNN = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.egI = null;
        this.egL = false;
        this.aLQ = null;
        this.egM = null;
        this.egN = false;
        this.egR = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12536").y("obj_locate", as.a.aDs));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12535").y("obj_locate", as.a.aDs));
            }
        };
        this.egW = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.4
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12536").y("obj_locate", as.a.aDu));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12535").y("obj_locate", as.a.aDu));
            }
        };
        this.egX = new CustomMessageListener(2001425) { // from class: com.baidu.tieba.frs.vc.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                l aCl;
                String name;
                SignData signData;
                boolean z;
                int i;
                if (f.this.edn != null && (customResponsedMessage instanceof SignMessage) && (aCl = f.this.edn.aCl()) != null && aCl.bhx() != null && (name = aCl.bhx().getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == f.this.egU) {
                    TiebaStatic.eventStat(f.this.edn.getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name2 = aCl.bhx().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.al(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                        if (signMessage.signData != null) {
                            AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener);
                        } else {
                            AntiHelper.aH(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                        }
                        TiebaStatic.log(new am("c12534").y("obj_locate", as.a.aDs));
                        return;
                    }
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(aCl.bhx().getId())) {
                            f.this.ph(name2);
                            aCl.d(signData2);
                            signData2.forumId = aCl.bhx().getId();
                            signData2.forumName = aCl.bhx().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = aCl.bhx().getUser_level();
                        if (f.this.aIA()) {
                            i = aCl.bhx().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                        if (signData.mContriInfo != null && signData.mContriInfo.isShowToast()) {
                            f.this.edn.a(signData.mContriInfo);
                            return;
                        }
                        if (!f.this.aIy()) {
                            f.this.edn.showToast(f.this.getPageContext().getResources().getString(e.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                        } else {
                            f.this.edn.showToast(f.this.getPageContext().getResources().getString(e.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                        }
                        if (f.this.edn.aBU() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.Jh().a(f.this.edn.getTbPageContext(), f.this.edn.aBU().aDc());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.nK(1);
                    }
                    f.this.edn.showToast(signMessage.mSignErrorString);
                }
            }
        };
        this.egY = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.8
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.dNN != null) {
                    int childCount = f.this.dNN.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(f.this.dNN.getChildAt(i));
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
        this.dNs = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l aCl = f.this.edn.aCl();
                if (aCl != null && aCl.bhx() != null && f.this.egF != null && (view == f.this.egF.aJh() || view == f.this.egF.aJi() || view == f.this.egF.aJj())) {
                    if (f.this.edn != null && aCl.bhx() != null) {
                        TiebaStatic.log(new am("c12046").aB(ImageViewerConfig.FORUM_ID, aCl.bhx().getId()).y("obj_locate", f.this.edn.aCn() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), aCl.bhx().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == e.g.tv_love) {
                    if (!f.this.edn.aCm()) {
                        if (!com.baidu.adp.lib.util.j.kV()) {
                            f.this.edn.showToast(e.j.neterror);
                        } else if (!ba.bJ(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new am("c10517").y("obj_locate", 1).aB(ImageViewerConfig.FORUM_ID, f.this.edn.getForumId()));
                        } else {
                            f.this.hv(true);
                            if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                am amVar = new am("c10048");
                                amVar.aB(ImageViewerConfig.FORUM_ID, f.this.edn.getForumId());
                                amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(amVar);
                            }
                        }
                    }
                } else if (id == e.g.tv_sign) {
                    if (!f.this.edn.aCm()) {
                        if (!com.baidu.adp.lib.util.j.kV()) {
                            f.this.edn.showToast(e.j.neterror);
                        } else if (ba.bJ(f.this.mContext.getPageActivity())) {
                            if (!f.this.aIz()) {
                                f.this.aIC();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(f.this.edn.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.l(f.this.edn.getForumId(), 0), 24002)));
                            }
                        }
                    }
                } else if (id == e.g.frs_header_games) {
                    if (ba.bJ(f.this.mContext.getPageActivity()) && aCl != null && aCl.bDa() != null) {
                        ay.Es().a((TbPageContext) f.this.getPageContext(), new String[]{aCl.bDa()}, true);
                    }
                } else if (id == e.g.frs_bawu_center) {
                    if (aCl != null && aCl.getUserData() != null && aCl.getUserData().isBawu()) {
                        String bDe = aCl.bDe();
                        if (!ao.isEmpty(bDe)) {
                            com.baidu.tbadk.browser.a.ad(f.this.getPageContext().getPageActivity(), bDe);
                            if (aCl.bhx() != null) {
                                TiebaStatic.log(new am("c10502").aB(ImageViewerConfig.FORUM_ID, aCl.bhx().getId()).aB("uid", aCl.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == e.g.level_container && !f.this.edn.aCm() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page") || f.this.mPageType.equals("brand_page")) && f.this.egF != null) {
                        f.this.egF.h(view, false);
                    }
                }
            }
        };
        this.edn = frsFragment;
        this.egO = aVar;
        this.dNN = frsHeaderViewContainer;
        this.egS = new com.baidu.tieba.frs.c.b(frsFragment.getTbPageContext());
        this.egT = new com.baidu.tieba.frs.c.a(frsFragment.getTbPageContext());
        this.egU = BdUniqueId.gen();
        this.egQ = new com.baidu.tieba.f.a();
        this.egQ.a(new a.InterfaceC0214a() { // from class: com.baidu.tieba.frs.vc.f.6
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
        this.edn.registerListener(this.egX);
        abi();
        aID();
        this.egL = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.egF != null) {
            this.egF.onDestory();
        }
        if (this.aLQ != null) {
            this.aLQ.bEh();
        }
        if (this.egJ != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.egJ);
        }
    }

    public void onActivityStop() {
        if (this.egF != null) {
            this.egF.onStop();
        }
        if (this.dNN != null) {
            this.dNN.removeCallbacks(this.egY);
        }
    }

    public void gA(boolean z) {
        if (this.egF != null) {
            this.egF.gA(z);
        }
    }

    public boolean nG(int i) {
        this.mSkinType = i;
        if (this.egF != null) {
            this.egF.changeSkinType(i);
        }
        if (this.egS != null) {
            this.egS.onChangeSkinType(i);
        }
        if (this.egT != null) {
            this.egT.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    public void hu(boolean z) {
        if (z) {
            if (this.egF != null) {
                this.dNN.removeHeaderView(this.egF.aJg());
                this.egN = false;
            }
        } else if (this.egF != null && this.egF.aJg() != null && !this.egN) {
            this.dNN.addHeaderView(this.egF.aJg(), this.dNN.getHeaderViewsCount());
            this.egN = true;
        }
    }

    public void a(String str, l lVar) {
        this.mPageType = str;
        if ("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str) || "brand_page".equals(str)) {
            if (!"brand_page".equals(str) && lVar != null && lVar.bCS() != null && lVar.bCS().yw() != null && lVar.bCS().yw().size() >= 1) {
                a(lVar.bCS().yw().get(0), false, lVar);
            } else if (!"brand_page".equals(str) && lVar != null && lVar.bCR() != null && !StringUtils.isNull(lVar.bCR().bDG())) {
                q qVar = new q();
                qVar.setLinkUrl("");
                qVar.setImageUrl(lVar.bCR().bDG());
                a(qVar, true, lVar);
            } else if (lVar != null && "brand_page".equals(str) && lVar.bCS() != null && lVar.bCS().yw() != null && lVar.bCS().yw().size() >= 1) {
                v(str, lVar.getUserData().getIsMem(), lVar.bhx().isLike());
                h(lVar);
            } else {
                this.egR = false;
                if (this.dNN != null && this.egS != null && this.egS.getHeaderView() != null) {
                    this.dNN.removeHeaderView(this.egS.getHeaderView());
                }
                if (this.dNN != null && this.egT != null && this.egT.getHeaderView() != null) {
                    this.dNN.removeHeaderView(this.egT.getHeaderView());
                }
            }
            if (lVar != null && lVar.getUserData() != null && lVar.bhx() != null && !"brand_page".equals(str)) {
                u(str, lVar.getUserData().getIsMem(), lVar.bhx().isLike());
            }
        }
    }

    public boolean aIr() {
        return this.egR;
    }

    private void a(q qVar, boolean z, l lVar) {
        if (qVar == null) {
            this.egR = false;
        } else if (this.dNN == null || this.egS == null || this.egS.getHeaderView() == null) {
            this.egR = false;
        } else {
            this.egR = true;
            this.dNN.removeHeaderView(this.egS.getHeaderView());
            this.dNN.addHeaderView(this.egS.getHeaderView());
            this.egS.a(lVar, qVar.getImageUrl());
            this.egS.setTitle(qVar.getTitle());
            this.egS.setSchemaUrl(qVar.getLinkUrl());
            if (z) {
                this.egS.hideTitle();
            }
        }
        if (lVar != null && lVar.bhx() != null && !TextUtils.isEmpty(lVar.bhx().getId()) && lVar.bCS() != null && !TextUtils.isEmpty(lVar.bCS().yx())) {
            am amVar = new am("c13326");
            amVar.aB(ImageViewerConfig.FORUM_ID, lVar.bhx().getId());
            amVar.aB(VideoPlayActivityConfig.OBJ_ID, lVar.bCS().yx());
            TiebaStatic.log(amVar);
        }
    }

    private void h(l lVar) {
        if (lVar == null || lVar.bCS() == null || v.I(lVar.bCS().yw()) || this.dNN == null || this.egF == null || this.egF.getView() == null || this.egT == null || this.egT.getHeaderView() == null) {
            this.egR = false;
            return;
        }
        q qVar = lVar.bCS().yw().get(0);
        if (qVar == null) {
            this.egR = false;
            return;
        }
        this.egR = true;
        this.egF.getView().setBackgroundColor(0);
        this.egT.aHf().removeView(this.egF.getView());
        this.egT.aHf().addView(this.egF.getView());
        this.dNN.removeHeaderView(this.egT.getHeaderView());
        this.dNN.addHeaderView(this.egT.getHeaderView());
        this.egT.a(lVar, qVar.getImageUrl());
        this.egT.setSchemaUrl(qVar.getLinkUrl());
        this.egT.setTitle(qVar.getTitle());
        if (this.egT instanceof com.baidu.tieba.frs.c.a) {
            ((com.baidu.tieba.frs.c.a) this.egT).bO(lVar.hnQ);
        }
    }

    private void u(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.egI, str);
        this.egK = i2;
        this.egI = str;
        aIt();
        if (this.egF == null || z) {
            this.egF = this.egO.a(str, this.edn, i);
            this.egF.changeSkinType(this.mSkinType);
            this.egF.s(this.dNs);
        }
        this.dNN.addHeaderView(this.egF.getView());
        int h = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0210e.tbds44);
        this.egF.q(0, h, 0, h);
        aIu();
        if (this.egV != null) {
            this.egV.aW(this.egF.aED());
        }
    }

    private void v(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.egI, str);
        this.egK = i2;
        this.egI = str;
        aIt();
        if (this.egF == null || z) {
            this.egF = this.egO.a(str, this.edn, i);
            this.egF.changeSkinType(this.mSkinType);
            this.egF.s(this.dNs);
            this.egF.aEI();
        }
        this.egF.q(0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0210e.tbds132), 0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0210e.tbds44));
        aIu();
        if (this.egV != null) {
            this.egV.aW(this.egF.aED());
        }
    }

    public void aIs() {
        if (!this.egN && this.egF != null) {
            this.dNN.addHeaderView(this.egF.aJg());
            if (this.egF.aED() != null && this.edn.FI() != null) {
                this.edn.FI().addHeaderView(this.egF.aED(), 0);
            }
            this.egN = true;
        }
    }

    private void aIt() {
        if (("normal_page".equals(this.egI) || "frs_page".equals(this.egI) || "book_page".equals(this.egI) || "brand_page".equals(this.egI)) && this.egF != null) {
            this.dNN.removeHeaderView(this.egF.getView());
            this.dNN.removeHeaderView(this.egF.aJg());
            if (this.egF.aED() != null && this.edn.FI() != null) {
                this.edn.FI().removeHeaderView(this.egF.aED());
            }
        }
        this.egN = false;
    }

    private void aIu() {
        if (this.egJ == null) {
            this.egJ = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.edn.aBU() == null || !f.this.edn.aBU().aCm()) && f.this.dNN.isShown() && f.this.edn.isPrimary() && !f.this.egL && f.this.egK == 1 && f.this.edn.aBU() != null && f.this.edn.aBU().aCL() != null && !f.this.edn.aBU().aCL().aFo() && f.this.edn.aCq()) {
                            if (("frs_page".equals(f.this.egI) || "normal_page".equals(f.this.egI) || "brand_page".equals(f.this.mPageType) || "book_page".equals(f.this.egI)) && f.this.egF != null && f.this.egF.aJf()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.aEQ();
                                f.this.edn.dLo = true;
                                f.this.egL = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.jG().postDelayed(this.egJ, 4000L);
    }

    public void i(l lVar) {
        if (lVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                b(lVar.bhx(), lVar);
                if ("brand_page".equals(this.mPageType)) {
                    this.egF.aEJ();
                }
            }
        }
    }

    public void b(ForumData forumData, l lVar) {
        if (forumData != null && lVar != null) {
            float b = b(forumData);
            if (this.egF != null) {
                this.egF.a(forumData, lVar);
                this.egF.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                if (forumData.getSignData() != null) {
                    this.egF.ob(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.egF.hB(false);
                        return;
                    }
                    this.egF.hB(true);
                    this.egF.ob(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.egG = forumData.getLevelupScore();
        this.egH = forumData.getCurScore();
        if (this.egG > 0) {
            return this.egH / this.egG;
        }
        return 0.0f;
    }

    public void nH(int i) {
        if (i > 1) {
            if (this.egF != null) {
                this.egF.hC(false);
            }
        } else if (this.egF != null) {
            this.egF.hC(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void aIv() {
        if (this.dNN != null) {
            this.dNN.removeCallbacks(this.egY);
            this.dNN.postDelayed(this.egY, 100L);
        }
    }

    public void g(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            aIw();
        }
    }

    public void setIsMem(int i) {
        if (this.egF != null) {
            this.egF.setMemberType(i);
        }
    }

    public void aEQ() {
        if (("normal_page".equals(this.egI) || "frs_page".equals(this.egI) || "book_page".equals(this.egI) || "brand_page".equals(this.mPageType)) && this.egF != null) {
            this.egF.aEQ();
        }
    }

    public void aIw() {
        if (this.egF != null) {
            this.egF.aES();
        }
    }

    public void a(l lVar, boolean z) {
        if (lVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                a(1, lVar.bhx(), lVar, z);
            }
        }
    }

    public void aIx() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            nJ(0);
        }
    }

    public void nI(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            nJ(i);
        }
    }

    public void nJ(int i) {
        if (this.egF != null) {
            this.egF.oa(i);
        }
    }

    public void a(int i, ForumData forumData, l lVar, boolean z) {
        if (this.egF != null) {
            this.egF.a(forumData, lVar);
            if (forumData != null) {
                this.egF.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.egF.hB(false);
                }
            }
        }
    }

    public boolean aIy() {
        if (("normal_page".equals(this.egI) || "frs_page".equals(this.egI) || "book_page".equals(this.egI) || "brand_page".equals(this.mPageType)) && this.egF != null) {
            return this.egF.aJe();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.egG - this.egH) {
                z = true;
                this.egG = signData.levelup_score;
            }
            this.egH = i + this.egH;
            if (this.egH > this.egG) {
                this.egH = this.egG;
            }
            if (this.egG != 0) {
                f = this.egH / this.egG;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.d(z, f);
        }
    }

    public void nK(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.egF != null) {
            this.egF.ob(i);
        }
    }

    public void j(l lVar) {
        SignData signData;
        ForumData bhx;
        if (lVar != null && lVar.bhx() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.egF != null && (signData = lVar.bhx().getSignData()) != null && (bhx = lVar.bhx()) != null) {
                this.egF.a(bhx, lVar);
                this.egF.ob(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.egF.aJe()) {
                    a(this.egF, signData);
                    bhx.setCurScore(this.egH);
                    bhx.setLevelupScore(this.egG);
                    this.egF.a(bhx, lVar);
                }
            }
        }
    }

    public boolean aIz() {
        if (("normal_page".equals(this.egI) || "frs_page".equals(this.egI) || "book_page".equals(this.egI) || "brand_page".equals(this.mPageType)) && this.egF != null) {
            return this.egF.aIz();
        }
        return false;
    }

    public boolean aIA() {
        if (("normal_page".equals(this.egI) || "frs_page".equals(this.egI) || "book_page".equals(this.egI) || "brand_page".equals(this.mPageType)) && this.egF != null) {
            return this.egF.aIA();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void hv(boolean z) {
        if (this.edn != null) {
            l aCl = this.edn.aCl();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.edn.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11002)));
            } else if (aCl != null && aCl.bhx() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.edn.getFrom())) {
                    TiebaStatic.log(new am("c10356").aB(ImageViewerConfig.FORUM_ID, aCl.bhx().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.edn.getFrom())) {
                    TiebaStatic.log(new am("c10590").y("obj_type", 2).aB(ImageViewerConfig.FORUM_ID, aCl.bhx().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.edn.getFrom())) {
                    TiebaStatic.log(new am("c10587").y("obj_type", 2).aB(ImageViewerConfig.FORUM_ID, aCl.bhx().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.edn.getFrom())) {
                    TiebaStatic.log(new am("c10578").y("obj_type", 2).aB(ImageViewerConfig.FORUM_ID, aCl.bhx().getId()));
                }
                this.aLQ.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.edn.getFrom())) {
                    TiebaStatic.eventStat(this.edn.getPageContext().getPageActivity(), "square_frs_focus", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.edn.getFrom())) {
                    TiebaStatic.log(new am("c10359").aB(ImageViewerConfig.FORUM_ID, aCl.bhx().getId()));
                }
                this.aLQ.Q(aCl.bhx().getName(), aCl.bhx().getId(), "FRS");
                this.egP = z;
            }
        }
    }

    public void aIB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.edn.aCl() != null && this.edn.aCl().bhx() != null && this.edn.aCl().bhx().getName() != null) {
            str = this.edn.aCl().bhx().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.eK(String.format(getPageContext().getString(e.j.attention_cancel_dialog_content), str));
        } else {
            aVar.eK(getPageContext().getString(e.j.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(e.j.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.10
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                l aCl = f.this.edn.aCl();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.edn.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(f.this.getPageContext().getPageActivity(), true, 11036)));
                } else if (aCl != null && aCl.bhx() != null) {
                    f.this.egM.w(aCl.bhx().getName(), com.baidu.adp.lib.g.b.d(aCl.bhx().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(e.j.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).BS();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void aIC() {
        l aCl = this.edn.aCl();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.edn.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11014)));
        } else if (aCl != null && aCl.bhx() != null) {
            FrsActivityStatic.forumName = aCl.bhx().getName() == null ? "" : aCl.bhx().getName();
            CustomMessage customMessage = new CustomMessage(2001425, aCl.bhx());
            customMessage.setTag(this.egU);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ph(String str) {
        if (this.edn.aBP() != null && this.edn.aBP().aHu() != null) {
            com.baidu.tieba.tbadkCore.c.bCD().ac(com.baidu.tieba.tbadkCore.c.bCD().d(str, this.edn.aBP().aHu().acy(), this.edn.aBP().aHu().getIsGood(), this.edn.aBP().aHu().getCategoryId()), false);
        }
    }

    private void abi() {
        this.aLQ = new LikeModel(this.edn.getPageContext());
        this.aLQ.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                r rVar;
                boolean z = false;
                l aCl = f.this.edn.aCl();
                if (aCl != null && aCl.bhx() != null && obj != null) {
                    if (AntiHelper.al(f.this.aLQ.getErrorCode(), f.this.aLQ.getErrorString())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.aLQ.getBlockPopInfoData(), f.this.egW) != null) {
                            TiebaStatic.log(new am("c12534").y("obj_locate", as.a.aDu));
                            return;
                        }
                        return;
                    }
                    String name = aCl.bhx().getName();
                    String id = aCl.bhx().getId();
                    if (!(obj instanceof r)) {
                        rVar = null;
                    } else {
                        rVar = (r) obj;
                    }
                    boolean z2 = rVar != null && f.this.aLQ.getErrorCode() == 0;
                    if (rVar.getErrorCode() == 3250013) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), rVar.getErrorMsg(), e.f.icon_toast_game_error, 3000).Ca();
                    } else {
                        z = z2;
                    }
                    if (rVar == null || !z) {
                        if (f.this.aLQ.getErrorCode() == 22) {
                            f.this.edn.showToast(f.this.getPageContext().getString(e.j.had_liked_forum));
                        } else {
                            f.this.edn.showToast(f.this.aLQ.getErrorString());
                        }
                    } else {
                        f.this.ph(name);
                        rVar.setLike(1);
                        aCl.c(rVar);
                        aCl.dJ(rVar.bCK());
                        f.this.a(aCl, f.this.egP);
                        f.this.egP = true;
                        f.this.edn.showToast(f.this.getPageContext().getResources().getString(e.j.attention_success));
                        f.this.g(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                    }
                    f.this.edn.ad(Boolean.valueOf(z));
                }
            }
        });
    }

    private void aID() {
        this.egM = new w();
        this.egM.setFrom("from_frs");
        this.egM.a(new w.a() { // from class: com.baidu.tieba.frs.vc.f.3
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void p(String str, long j) {
                l aCl = f.this.edn.aCl();
                if (aCl != null && aCl.bhx() != null) {
                    String name = aCl.bhx().getName();
                    String id = aCl.bhx().getId();
                    if (j == com.baidu.adp.lib.g.b.d(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.ph(str);
                        aCl.bhx().setLike(0);
                        f.this.nI(0);
                        f.this.edn.ac(true);
                        f.this.g(false, id);
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
    public void g(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.aVx().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void F(int i, int i2, int i3) {
        l aCl;
        if (i > 0 && i2 > 0 && (aCl = this.edn.aCl()) != null && aCl.bhx() != null && aCl.getSignData() != null) {
            ForumData bhx = aCl.bhx();
            SignData signData = aCl.getSignData();
            signData.levelup_score = bhx.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            aCl.d(signData);
            signData.forumId = bhx.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
            int i4 = -1;
            if (aIA()) {
                i4 = bhx.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(bhx.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void aEy() {
        if (this.egF != null) {
            this.egF.aEy();
        }
    }

    public static boolean k(l lVar) {
        if (lVar != null) {
            return (lVar.bDi() == null || StringUtils.isNull(lVar.bDi().yy(), true) || lVar.bDi().yy().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean l(l lVar) {
        if (lVar != null) {
            return ((lVar.bCR() == null || lVar.bCR().bDC() != 1) && lVar.bDh() == null && (lVar.bCS() == null || v.I(lVar.bCS().yw())) && ((lVar.bhx() == null || lVar.bhx().getFrsBannerData() == null || lVar.bhx().getFrsBannerData().getType() != 2) && (lVar.bDj() == null || StringUtils.isNull(lVar.bDj().yF(), true)))) ? false : true;
        }
        return false;
    }

    public void nL(int i) {
        View findViewById;
        if (this.egF != null && this.egF.aJg() != null && (findViewById = this.egF.aJg().findViewById(e.g.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.egQ != null) {
            this.egQ.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.egV = frsTabViewController;
    }
}
