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
import com.baidu.tbadk.core.data.r;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.message.SignMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.d;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private LikeModel bwM;
    private FrsFragment dAK;
    private com.baidu.tieba.frs.view.b dDM;
    private int dDN;
    private int dDO;
    private String dDP;
    private Runnable dDQ;
    private int dDR;
    private boolean dDS;
    private w dDT;
    private boolean dDU;
    private com.baidu.tieba.frs.entelechy.b.a dDV;
    private boolean dDW;
    private com.baidu.tieba.f.a dDX;
    private boolean dDY;
    private com.baidu.tieba.frs.c.a.a dDZ;
    private com.baidu.tieba.frs.c.a.a dEa;
    private BdUniqueId dEb;
    private FrsTabViewController dEc;
    private AntiHelper.a dEd;
    private CustomMessageListener dEe;
    private Runnable dEf;
    private FrsHeaderViewContainer dlM;
    private final View.OnClickListener dlq;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.dlM = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.dDP = null;
        this.dDS = false;
        this.bwM = null;
        this.dDT = null;
        this.dDU = false;
        this.dDY = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an("c12536").r("obj_locate", at.a.arQ));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an("c12535").r("obj_locate", at.a.arQ));
            }
        };
        this.dEd = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.4
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an("c12536").r("obj_locate", at.a.arS));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an("c12535").r("obj_locate", at.a.arS));
            }
        };
        this.dEe = new CustomMessageListener(2001425) { // from class: com.baidu.tieba.frs.vc.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SignData signData;
                boolean z;
                int i;
                l atZ = f.this.dAK.atZ();
                if (atZ != null && atZ.baT() != null && atZ.baT().getName() != null && atZ.baT().getName().equals(FrsActivityStatic.forumName)) {
                    if (customResponsedMessage == null || customResponsedMessage.getOrginalMessage().getTag() == f.this.dEb) {
                        TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_end_time", System.currentTimeMillis() + "");
                        String name = atZ.baT().getName();
                        SignMessage signMessage = (SignMessage) customResponsedMessage;
                        if (AntiHelper.tQ(signMessage.mSignErrorCode) && signMessage.signData != null) {
                            if (AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener) != null) {
                                TiebaStatic.log(new an("c12534").r("obj_locate", at.a.arQ));
                                return;
                            }
                            return;
                        }
                        if (signMessage == null || signMessage.signData == null) {
                            signData = null;
                            z = false;
                        } else {
                            SignData signData2 = signMessage.signData;
                            if (signData2.forumId != null && signData2.forumId.equals(atZ.baT().getId())) {
                                f.this.ne(name);
                                atZ.d(signData2);
                                signData2.forumId = atZ.baT().getId();
                                signData2.forumName = atZ.baT().getName();
                                signData = signData2;
                                z = true;
                            } else {
                                return;
                            }
                        }
                        if (z) {
                            int user_level = atZ.baT().getUser_level();
                            if (f.this.aAb()) {
                                i = atZ.baT().getUser_level();
                                if (user_level >= i) {
                                    i++;
                                }
                            } else {
                                i = user_level;
                            }
                            TbadkCoreApplication.getInst().addSignedForum(name, signData.sign_bonus_point, i);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                            if (AntiHelper.tQ(signMessage.mSignErrorCode)) {
                                AntiHelper.ao(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                                return;
                            } else if (signData.mContriInfo != null && signData.mContriInfo.isShowToast()) {
                                f.this.dAK.a(signData.mContriInfo);
                                return;
                            } else if (!f.this.azZ()) {
                                f.this.dAK.showToast(f.this.getPageContext().getResources().getString(d.k.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                                return;
                            } else {
                                f.this.dAK.showToast(f.this.getPageContext().getResources().getString(d.k.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                                return;
                            }
                        }
                        if (signMessage.mSignErrorCode == 160002) {
                            f.this.lD(1);
                        }
                        f.this.dAK.showToast(signMessage.mSignErrorString);
                    }
                }
            }
        };
        this.dEf = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.8
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.dlM != null) {
                    int childCount = f.this.dlM.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(f.this.dlM.getChildAt(i));
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
        this.dlq = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l atZ = f.this.dAK.atZ();
                if (atZ != null && atZ.baT() != null && f.this.dDM != null && (view == f.this.dDM.aAB() || view == f.this.dDM.aAC() || view == f.this.dDM.aAD())) {
                    if (f.this.dAK != null && atZ.baT() != null) {
                        TiebaStatic.log(new an("c12046").ah(ImageViewerConfig.FORUM_ID, atZ.baT().getId()).r("obj_locate", f.this.dAK.aub() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), atZ.baT().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == d.g.tv_love) {
                    if (!f.this.dAK.aua()) {
                        if (!com.baidu.adp.lib.util.j.jD()) {
                            f.this.dAK.showToast(d.k.neterror);
                        } else if (!bb.aU(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new an("c10517").r("obj_locate", 1).ah(ImageViewerConfig.FORUM_ID, f.this.dAK.getForumId()));
                        } else {
                            f.this.gn(true);
                        }
                    }
                } else if (id == d.g.tv_sign) {
                    if (!f.this.dAK.aua()) {
                        if (!com.baidu.adp.lib.util.j.jD()) {
                            f.this.dAK.showToast(d.k.neterror);
                        } else if (bb.aU(f.this.mContext.getPageActivity())) {
                            if (!f.this.aAa()) {
                                f.this.aAd();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(f.this.dAK.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.g(f.this.dAK.getForumId(), 0), 24002)));
                            }
                        }
                    }
                } else if (id == d.g.frs_header_games) {
                    if (bb.aU(f.this.mContext.getPageActivity()) && atZ != null && atZ.bvK() != null) {
                        az.zV().a((TbPageContext) f.this.getPageContext(), new String[]{atZ.bvK()}, true);
                    }
                } else if (id == d.g.frs_bawu_center) {
                    if (atZ != null && atZ.getUserData() != null && atZ.getUserData().isBawu()) {
                        String bvO = atZ.bvO();
                        if (!ap.isEmpty(bvO)) {
                            com.baidu.tbadk.browser.a.O(f.this.getPageContext().getPageActivity(), bvO);
                            if (atZ.baT() != null) {
                                TiebaStatic.log(new an("c10502").ah(ImageViewerConfig.FORUM_ID, atZ.baT().getId()).ah("uid", atZ.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == d.g.level_container && !f.this.dAK.aua() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page") || f.this.mPageType.equals("brand_page")) && f.this.dDM != null) {
                        f.this.dDM.j(view, false);
                    }
                }
            }
        };
        this.dAK = frsFragment;
        this.dDV = aVar;
        this.dlM = frsHeaderViewContainer;
        this.dDZ = new com.baidu.tieba.frs.c.b(frsFragment.ahZ());
        this.dEa = new com.baidu.tieba.frs.c.a(frsFragment.ahZ());
        this.dEb = BdUniqueId.gen();
        this.dDX = new com.baidu.tieba.f.a();
        this.dDX.a(new a.InterfaceC0147a() { // from class: com.baidu.tieba.frs.vc.f.6
            @Override // com.baidu.tieba.f.a.InterfaceC0147a
            public void W(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0147a
            public void X(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0147a
            public void Y(int i, int i2) {
            }
        });
    }

    public void m(Bundle bundle) {
        this.dAK.registerListener(this.dEe);
        TN();
        aAe();
        this.dDS = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.dDM != null) {
            this.dDM.onDestory();
        }
        if (this.bwM != null) {
            this.bwM.bwQ();
        }
        if (this.dDQ != null) {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.dDQ);
        }
    }

    public void onActivityStop() {
        if (this.dDM != null) {
            this.dDM.onStop();
        }
        if (this.dlM != null) {
            this.dlM.removeCallbacks(this.dEf);
        }
    }

    public void fy(boolean z) {
        if (this.dDM != null) {
            this.dDM.fy(z);
        }
    }

    public boolean lz(int i) {
        this.mSkinType = i;
        if (this.dDM != null) {
            this.dDM.changeSkinType(i);
        }
        if (this.dDZ != null) {
            this.dDZ.onChangeSkinType(i);
        }
        if (this.dEa != null) {
            this.dEa.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    public void gm(boolean z) {
        if (z) {
            if (this.dDM != null) {
                this.dlM.removeHeaderView(this.dDM.aAA());
                this.dDU = false;
            }
        } else if (this.dDM != null && this.dDM.aAA() != null && !this.dDU) {
            this.dlM.addHeaderView(this.dDM.aAA(), this.dlM.getHeaderViewsCount());
            this.dDU = true;
        }
    }

    public void a(String str, l lVar) {
        this.mPageType = str;
        if ("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str) || "brand_page".equals(str)) {
            if (!"brand_page".equals(str) && lVar != null && lVar.bvC() != null && lVar.bvC().ua() != null && lVar.bvC().ua().size() >= 1) {
                a(lVar.bvC().ua().get(0), false);
            } else if (!"brand_page".equals(str) && lVar != null && lVar.bvB() != null && !StringUtils.isNull(lVar.bvB().bwq())) {
                r rVar = new r();
                rVar.setLinkUrl("");
                rVar.setImageUrl(lVar.bvB().bwq());
                a(rVar, true);
            } else if (lVar != null && "brand_page".equals(str) && lVar.bvC() != null && lVar.bvC().ua() != null && lVar.bvC().ua().size() >= 1) {
                p(str, lVar.getUserData().getIsMem(), lVar.baT().isLike());
                g(lVar);
            } else {
                this.dDY = false;
                if (this.dlM != null && this.dDZ != null && this.dDZ.getHeaderView() != null) {
                    this.dlM.removeHeaderView(this.dDZ.getHeaderView());
                }
                if (this.dlM != null && this.dEa != null && this.dEa.getHeaderView() != null) {
                    this.dlM.removeHeaderView(this.dEa.getHeaderView());
                }
            }
            if (lVar != null && lVar.getUserData() != null && lVar.baT() != null && !"brand_page".equals(str)) {
                o(str, lVar.getUserData().getIsMem(), lVar.baT().isLike());
            }
        }
    }

    public boolean azS() {
        return this.dDY;
    }

    private void a(r rVar, boolean z) {
        if (rVar == null) {
            this.dDY = false;
        } else if (this.dlM == null || this.dDZ == null || this.dDZ.getHeaderView() == null) {
            this.dDY = false;
        } else {
            this.dDY = true;
            this.dlM.removeHeaderView(this.dDZ.getHeaderView());
            this.dlM.addHeaderView(this.dDZ.getHeaderView());
            this.dDZ.hX(rVar.getImageUrl());
            this.dDZ.setTitle(rVar.getTitle());
            this.dDZ.setSchemaUrl(rVar.getLinkUrl());
            if (z) {
                this.dDZ.hideTitle();
            }
        }
    }

    private void g(l lVar) {
        if (lVar == null || lVar.bvC() == null || com.baidu.tbadk.core.util.w.A(lVar.bvC().ua()) || this.dlM == null || this.dDM == null || this.dDM.getView() == null || this.dEa == null || this.dEa.getHeaderView() == null) {
            this.dDY = false;
            return;
        }
        r rVar = lVar.bvC().ua().get(0);
        if (rVar == null) {
            this.dDY = false;
            return;
        }
        this.dDY = true;
        this.dDM.getView().setBackgroundColor(0);
        this.dEa.ayH().removeView(this.dDM.getView());
        this.dEa.ayH().addView(this.dDM.getView());
        this.dlM.removeHeaderView(this.dEa.getHeaderView());
        this.dlM.addHeaderView(this.dEa.getHeaderView());
        this.dEa.hX(rVar.getImageUrl());
        this.dEa.setSchemaUrl(rVar.getLinkUrl());
        this.dEa.setTitle(rVar.getTitle());
        if (this.dEa instanceof com.baidu.tieba.frs.c.a) {
            ((com.baidu.tieba.frs.c.a) this.dEa).bw(lVar.gLm);
        }
    }

    private void o(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.dDP, str);
        this.dDR = i2;
        this.dDP = str;
        azU();
        if (this.dDM == null || z) {
            this.dDM = this.dDV.a(str, this.dAK, i);
            this.dDM.changeSkinType(this.mSkinType);
            this.dDM.q(this.dlq);
        }
        this.dlM.addHeaderView(this.dDM.getView());
        int e = com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst(), d.e.tbds44);
        this.dDM.q(0, e, 0, e);
        azV();
        if (this.dEc != null) {
            this.dEc.aA(this.dDM.avZ());
        }
    }

    private void p(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.dDP, str);
        this.dDR = i2;
        this.dDP = str;
        azU();
        if (this.dDM == null || z) {
            this.dDM = this.dDV.a(str, this.dAK, i);
            this.dDM.changeSkinType(this.mSkinType);
            this.dDM.q(this.dlq);
            this.dDM.awe();
        }
        this.dDM.q(0, com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst(), d.e.tbds132), 0, com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst(), d.e.tbds44));
        azV();
        if (this.dEc != null) {
            this.dEc.aA(this.dDM.avZ());
        }
    }

    public void azT() {
        if (!this.dDU && this.dDM != null) {
            this.dlM.addHeaderView(this.dDM.aAA());
            if (this.dDM.avZ() != null && this.dAK.Bb() != null) {
                this.dAK.Bb().addHeaderView(this.dDM.avZ(), 0);
            }
            this.dDU = true;
        }
    }

    private void azU() {
        if (("normal_page".equals(this.dDP) || "frs_page".equals(this.dDP) || "book_page".equals(this.dDP) || "brand_page".equals(this.dDP)) && this.dDM != null) {
            this.dlM.removeHeaderView(this.dDM.getView());
            this.dlM.removeHeaderView(this.dDM.aAA());
            if (this.dDM.avZ() != null && this.dAK.Bb() != null) {
                this.dAK.Bb().removeHeaderView(this.dDM.avZ());
            }
        }
        this.dDU = false;
    }

    private void azV() {
        if (this.dDQ == null) {
            this.dDQ = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.dAK.atI() == null || !f.this.dAK.atI().aua()) && f.this.dlM.isShown() && f.this.dAK.isPrimary() && !f.this.dDS && f.this.dDR == 1 && f.this.dAK.atI() != null && f.this.dAK.atI().auA() != null && !f.this.dAK.atI().auA().awL() && f.this.dAK.aue()) {
                            if (("frs_page".equals(f.this.dDP) || "normal_page".equals(f.this.dDP) || "brand_page".equals(f.this.mPageType) || "book_page".equals(f.this.dDP)) && f.this.dDM != null && f.this.dDM.aAz()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.awm();
                                f.this.dAK.djn = true;
                                f.this.dDS = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.im().postDelayed(this.dDQ, 4000L);
    }

    public void h(l lVar) {
        if (lVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                b(lVar.baT(), lVar);
                if ("brand_page".equals(this.mPageType)) {
                    this.dDM.awf();
                }
            }
        }
    }

    public void b(ForumData forumData, l lVar) {
        if (forumData != null && lVar != null) {
            float b = b(forumData);
            if (this.dDM != null) {
                this.dDM.a(forumData, lVar);
                this.dDM.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                if (forumData.getSignData() != null) {
                    this.dDM.lR(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.dDM.gu(false);
                        return;
                    }
                    this.dDM.gu(true);
                    this.dDM.lR(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.dDN = forumData.getLevelupScore();
        this.dDO = forumData.getCurScore();
        if (this.dDN > 0) {
            return this.dDO / this.dDN;
        }
        return 0.0f;
    }

    public void lA(int i) {
        if (i > 1) {
            if (this.dDM != null) {
                this.dDM.gv(false);
            }
        } else if (this.dDM != null) {
            this.dDM.gv(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void azW() {
        if (this.dlM != null) {
            this.dlM.removeCallbacks(this.dEf);
            this.dlM.postDelayed(this.dEf, 100L);
        }
    }

    public void g(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            azX();
        }
    }

    public void setIsMem(int i) {
        if (this.dDM != null) {
            this.dDM.setMemberType(i);
        }
    }

    public void awm() {
        if (("normal_page".equals(this.dDP) || "frs_page".equals(this.dDP) || "book_page".equals(this.dDP) || "brand_page".equals(this.mPageType)) && this.dDM != null) {
            this.dDM.awm();
        }
    }

    public void azX() {
        if (this.dDM != null) {
            this.dDM.awo();
        }
    }

    public void a(l lVar, boolean z) {
        if (lVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                a(1, lVar.baT(), lVar, z);
            }
        }
    }

    public void azY() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            lC(0);
        }
    }

    public void lB(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            lC(i);
        }
    }

    public void lC(int i) {
        if (this.dDM != null) {
            this.dDM.lQ(i);
        }
    }

    public void a(int i, ForumData forumData, l lVar, boolean z) {
        if (this.dDM != null) {
            this.dDM.a(forumData, lVar);
            if (forumData != null) {
                this.dDM.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.dDM.gu(false);
                }
            }
        }
    }

    public boolean azZ() {
        if (("normal_page".equals(this.dDP) || "frs_page".equals(this.dDP) || "book_page".equals(this.dDP) || "brand_page".equals(this.mPageType)) && this.dDM != null) {
            return this.dDM.aAy();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.dDN - this.dDO) {
                z = true;
                this.dDN = signData.levelup_score;
            }
            this.dDO = i + this.dDO;
            if (this.dDO > this.dDN) {
                this.dDO = this.dDN;
            }
            if (this.dDN != 0) {
                f = this.dDO / this.dDN;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.d(z, f);
        }
    }

    public void lD(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.dDM != null) {
            this.dDM.lR(i);
        }
    }

    public void i(l lVar) {
        SignData signData;
        ForumData baT;
        if (lVar != null && lVar.baT() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.dDM != null && (signData = lVar.baT().getSignData()) != null && (baT = lVar.baT()) != null) {
                this.dDM.a(baT, lVar);
                this.dDM.lR(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.dDM.aAy()) {
                    a(this.dDM, signData);
                    baT.setCurScore(this.dDO);
                    baT.setLevelupScore(this.dDN);
                    this.dDM.a(baT, lVar);
                }
            }
        }
    }

    public boolean aAa() {
        if (("normal_page".equals(this.dDP) || "frs_page".equals(this.dDP) || "book_page".equals(this.dDP) || "brand_page".equals(this.mPageType)) && this.dDM != null) {
            return this.dDM.aAa();
        }
        return false;
    }

    public boolean aAb() {
        if (("normal_page".equals(this.dDP) || "frs_page".equals(this.dDP) || "book_page".equals(this.dDP) || "brand_page".equals(this.mPageType)) && this.dDM != null) {
            return this.dDM.aAb();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void gn(boolean z) {
        if (this.dAK != null) {
            l atZ = this.dAK.atZ();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.dAK.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11002)));
            } else if (atZ != null && atZ.baT() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.dAK.getFrom())) {
                    TiebaStatic.log(new an("c10356").ah(ImageViewerConfig.FORUM_ID, atZ.baT().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.dAK.getFrom())) {
                    TiebaStatic.log(new an("c10590").r("obj_type", 2).ah(ImageViewerConfig.FORUM_ID, atZ.baT().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.dAK.getFrom())) {
                    TiebaStatic.log(new an("c10587").r("obj_type", 2).ah(ImageViewerConfig.FORUM_ID, atZ.baT().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.dAK.getFrom())) {
                    TiebaStatic.log(new an("c10578").r("obj_type", 2).ah(ImageViewerConfig.FORUM_ID, atZ.baT().getId()));
                }
                this.bwM.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.dAK.getFrom())) {
                    TiebaStatic.eventStat(this.dAK.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.dAK.getFrom())) {
                    TiebaStatic.log(new an("c10359").ah(ImageViewerConfig.FORUM_ID, atZ.baT().getId()));
                }
                this.bwM.H(atZ.baT().getName(), atZ.baT().getId(), "FRS");
                this.dDW = z;
            }
        }
    }

    public void aAc() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.dAK.atZ() != null && this.dAK.atZ().baT() != null && this.dAK.atZ().baT().getName() != null) {
            str = this.dAK.atZ().baT().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.dE(String.format(getPageContext().getString(d.k.attention_cancel_dialog_content), str));
        } else {
            aVar.dE(getPageContext().getString(d.k.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(d.k.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.10
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                l atZ = f.this.dAK.atZ();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.dAK.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(f.this.getPageContext().getPageActivity(), true, 11036)));
                } else if (atZ != null && atZ.baT() != null) {
                    f.this.dDT.t(atZ.baT().getName(), com.baidu.adp.lib.g.b.c(atZ.baT().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(d.k.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).xn();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void aAd() {
        l atZ = this.dAK.atZ();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.dAK.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11014)));
        } else if (atZ != null && atZ.baT() != null) {
            FrsActivityStatic.forumName = atZ.baT().getName() == null ? "" : atZ.baT().getName();
            CustomMessage customMessage = new CustomMessage(2001425, atZ.baT());
            customMessage.setTag(this.dEb);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ne(String str) {
        if (this.dAK.atD() != null && this.dAK.atD().ayU() != null) {
            com.baidu.tieba.tbadkCore.c.bvo().U(com.baidu.tieba.tbadkCore.c.bvo().d(str, this.dAK.atD().ayU().Vb(), this.dAK.atD().ayU().getIsGood(), this.dAK.atD().ayU().getCategoryId()), false);
        }
    }

    private void TN() {
        this.bwM = new LikeModel(this.dAK.getPageContext());
        this.bwM.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                com.baidu.tieba.tbadkCore.r rVar;
                l atZ = f.this.dAK.atZ();
                if (atZ != null && atZ.baT() != null && obj != null) {
                    if (AntiHelper.tQ(f.this.bwM.getErrorCode())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.bwM.getBlockPopInfoData(), f.this.dEd) != null) {
                            TiebaStatic.log(new an("c12534").r("obj_locate", at.a.arS));
                            return;
                        }
                        return;
                    }
                    String name = atZ.baT().getName();
                    String id = atZ.baT().getId();
                    boolean z = false;
                    if (!(obj instanceof com.baidu.tieba.tbadkCore.r)) {
                        rVar = null;
                    } else {
                        rVar = (com.baidu.tieba.tbadkCore.r) obj;
                    }
                    if (rVar != null && f.this.bwM.getErrorCode() == 0) {
                        z = true;
                    }
                    if (rVar == null || !z) {
                        if (f.this.bwM.getErrorCode() == 22) {
                            f.this.dAK.showToast(f.this.getPageContext().getString(d.k.had_liked_forum));
                        } else {
                            f.this.dAK.showToast(f.this.bwM.getErrorString());
                        }
                    } else {
                        f.this.ne(name);
                        rVar.setLike(1);
                        atZ.c(rVar);
                        atZ.du(rVar.bvu());
                        f.this.a(atZ, f.this.dDW);
                        f.this.dDW = true;
                        f.this.dAK.showToast(f.this.getPageContext().getResources().getString(d.k.attention_success));
                        f.this.i(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                    }
                    f.this.dAK.X(Boolean.valueOf(z));
                }
            }
        });
    }

    private void aAe() {
        this.dDT = new w();
        this.dDT.setFrom("from_frs");
        this.dDT.a(new w.a() { // from class: com.baidu.tieba.frs.vc.f.3
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void m(String str, long j) {
                l atZ = f.this.dAK.atZ();
                if (atZ != null && atZ.baT() != null) {
                    String name = atZ.baT().getName();
                    String id = atZ.baT().getId();
                    if (j == com.baidu.adp.lib.g.b.c(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.ne(str);
                        atZ.baT().setLike(0);
                        f.this.lB(0);
                        f.this.dAK.W(true);
                        f.this.i(false, id);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003004, id));
                        com.baidu.tieba.tbadkCore.r rVar = new com.baidu.tieba.tbadkCore.r();
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
        com.baidu.tieba.im.settingcache.d.aMv().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void A(int i, int i2, int i3) {
        l atZ;
        if (i > 0 && i2 > 0 && (atZ = this.dAK.atZ()) != null && atZ.baT() != null && atZ.getSignData() != null) {
            ForumData baT = atZ.baT();
            SignData signData = atZ.getSignData();
            signData.levelup_score = baT.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            atZ.d(signData);
            signData.forumId = baT.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
            int i4 = -1;
            if (aAb()) {
                i4 = baT.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(baT.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void avW() {
        if (this.dDM != null) {
            this.dDM.avW();
        }
    }

    public static boolean j(l lVar) {
        if (lVar != null) {
            return (lVar.bvS() == null || StringUtils.isNull(lVar.bvS().ub(), true) || lVar.bvS().ub().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean k(l lVar) {
        if (lVar != null) {
            return ((lVar.bvB() == null || lVar.bvB().bwm() != 1) && lVar.bvR() == null && (lVar.bvC() == null || com.baidu.tbadk.core.util.w.A(lVar.bvC().ua())) && ((lVar.baT() == null || lVar.baT().getFrsBannerData() == null || lVar.baT().getFrsBannerData().getType() != 2) && (lVar.bvT() == null || StringUtils.isNull(lVar.bvT().uh(), true)))) ? false : true;
        }
        return false;
    }

    public void lE(int i) {
        View findViewById;
        if (this.dDM != null && this.dDM.aAA() != null && (findViewById = this.dDM.aAA().findViewById(d.g.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.dDX != null) {
            this.dDX.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.dEc = frsTabViewController;
    }
}
