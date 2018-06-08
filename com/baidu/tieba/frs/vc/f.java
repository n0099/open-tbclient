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
import com.baidu.tbadk.core.data.r;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.message.SignMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
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
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private LikeModel bvr;
    private com.baidu.tieba.frs.view.b dAB;
    private int dAC;
    private int dAD;
    private String dAE;
    private Runnable dAF;
    private int dAG;
    private boolean dAH;
    private w dAI;
    private boolean dAJ;
    private com.baidu.tieba.frs.entelechy.b.a dAK;
    private boolean dAL;
    private com.baidu.tieba.f.a dAM;
    private boolean dAN;
    private com.baidu.tieba.frs.c.a.a dAO;
    private BdUniqueId dAP;
    private FrsTabViewController dAQ;
    private AntiHelper.a dAR;
    private CustomMessageListener dAS;
    private Runnable dAT;
    private FrsHeaderViewContainer djJ;
    private final View.OnClickListener djp;
    private FrsFragment dxw;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.djJ = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.dAE = null;
        this.dAH = false;
        this.bvr = null;
        this.dAI = null;
        this.dAJ = false;
        this.dAN = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12536").r("obj_locate", as.a.arn));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12535").r("obj_locate", as.a.arn));
            }
        };
        this.dAR = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.4
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12536").r("obj_locate", as.a.arp));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12535").r("obj_locate", as.a.arp));
            }
        };
        this.dAS = new CustomMessageListener(2001425) { // from class: com.baidu.tieba.frs.vc.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SignData signData;
                boolean z;
                int i;
                l atI = f.this.dxw.atI();
                if (atI != null && atI.bam() != null && atI.bam().getName() != null && atI.bam().getName().equals(FrsActivityStatic.forumName)) {
                    if (customResponsedMessage == null || customResponsedMessage.getOrginalMessage().getTag() == f.this.dAP) {
                        TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_end_time", System.currentTimeMillis() + "");
                        String name = atI.bam().getName();
                        SignMessage signMessage = (SignMessage) customResponsedMessage;
                        if (AntiHelper.tE(signMessage.mSignErrorCode) && signMessage.signData != null) {
                            if (AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener) != null) {
                                TiebaStatic.log(new am("c12534").r("obj_locate", as.a.arn));
                                return;
                            }
                            return;
                        }
                        if (signMessage == null || signMessage.signData == null) {
                            signData = null;
                            z = false;
                        } else {
                            SignData signData2 = signMessage.signData;
                            if (signData2.forumId != null && signData2.forumId.equals(atI.bam().getId())) {
                                f.this.ne(name);
                                atI.d(signData2);
                                signData2.forumId = atI.bam().getId();
                                signData2.forumName = atI.bam().getName();
                                signData = signData2;
                                z = true;
                            } else {
                                return;
                            }
                        }
                        if (z) {
                            int user_level = atI.bam().getUser_level();
                            if (f.this.azv()) {
                                i = atI.bam().getUser_level();
                                if (user_level >= i) {
                                    i++;
                                }
                            } else {
                                i = user_level;
                            }
                            TbadkCoreApplication.getInst().addSignedForum(name, signData.sign_bonus_point, i);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                            if (AntiHelper.tE(signMessage.mSignErrorCode)) {
                                AntiHelper.ao(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                                return;
                            } else if (signData.mContriInfo != null && signData.mContriInfo.isShowToast()) {
                                f.this.dxw.a(signData.mContriInfo);
                                return;
                            } else if (!f.this.azt()) {
                                f.this.dxw.showToast(f.this.getPageContext().getResources().getString(d.k.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                                return;
                            } else {
                                f.this.dxw.showToast(f.this.getPageContext().getResources().getString(d.k.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                                return;
                            }
                        }
                        if (signMessage.mSignErrorCode == 160002) {
                            f.this.lw(1);
                        }
                        f.this.dxw.showToast(signMessage.mSignErrorString);
                    }
                }
            }
        };
        this.dAT = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.8
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.djJ != null) {
                    int childCount = f.this.djJ.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(f.this.djJ.getChildAt(i));
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
        this.djp = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l atI = f.this.dxw.atI();
                if (atI != null && atI.bam() != null && f.this.dAB != null && (view == f.this.dAB.azU() || view == f.this.dAB.azV() || view == f.this.dAB.azW())) {
                    if (f.this.dxw != null && atI.bam() != null) {
                        TiebaStatic.log(new am("c12046").ah(ImageViewerConfig.FORUM_ID, atI.bam().getId()).r("obj_locate", f.this.dxw.atK() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), atI.bam().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == d.g.tv_love) {
                    if (!f.this.dxw.atJ()) {
                        if (!com.baidu.adp.lib.util.j.jD()) {
                            f.this.dxw.showToast(d.k.neterror);
                        } else if (!ba.aU(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new am("c10517").r("obj_locate", 1).ah(ImageViewerConfig.FORUM_ID, f.this.dxw.getForumId()));
                        } else {
                            f.this.gd(true);
                        }
                    }
                } else if (id == d.g.tv_sign) {
                    if (!f.this.dxw.atJ()) {
                        if (!com.baidu.adp.lib.util.j.jD()) {
                            f.this.dxw.showToast(d.k.neterror);
                        } else if (ba.aU(f.this.mContext.getPageActivity())) {
                            if (!f.this.azu()) {
                                f.this.azx();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(f.this.dxw.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.g(f.this.dxw.getForumId(), 0), 24002)));
                            }
                        }
                    }
                } else if (id == d.g.frs_header_games) {
                    if (ba.aU(f.this.mContext.getPageActivity()) && atI != null && atI.bvk() != null) {
                        ay.zG().a((TbPageContext) f.this.getPageContext(), new String[]{atI.bvk()}, true);
                    }
                } else if (id == d.g.frs_bawu_center) {
                    if (atI != null && atI.getUserData() != null && atI.getUserData().isBawu()) {
                        String bvo = atI.bvo();
                        if (!ao.isEmpty(bvo)) {
                            com.baidu.tbadk.browser.a.O(f.this.getPageContext().getPageActivity(), bvo);
                            if (atI.bam() != null) {
                                TiebaStatic.log(new am("c10502").ah(ImageViewerConfig.FORUM_ID, atI.bam().getId()).ah("uid", atI.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == d.g.level_container && !f.this.dxw.atJ() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page")) && f.this.dAB != null) {
                        f.this.dAB.j(view, false);
                    }
                }
            }
        };
        this.dxw = frsFragment;
        this.dAK = aVar;
        this.djJ = frsHeaderViewContainer;
        this.dAO = new com.baidu.tieba.frs.c.a(frsFragment.aiH());
        this.dAP = BdUniqueId.gen();
        this.dAM = new com.baidu.tieba.f.a();
        this.dAM.a(new a.InterfaceC0146a() { // from class: com.baidu.tieba.frs.vc.f.6
            @Override // com.baidu.tieba.f.a.InterfaceC0146a
            public void X(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0146a
            public void Y(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0146a
            public void Z(int i, int i2) {
            }
        });
    }

    public void m(Bundle bundle) {
        this.dxw.registerListener(this.dAS);
        Tt();
        azy();
        this.dAH = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.dAB != null) {
            this.dAB.onDestory();
        }
        if (this.bvr != null) {
            this.bvr.bwp();
        }
        if (this.dAF != null) {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.dAF);
        }
    }

    public void onActivityStop() {
        if (this.dAB != null) {
            this.dAB.onStop();
        }
        if (this.djJ != null) {
            this.djJ.removeCallbacks(this.dAT);
        }
    }

    public void fw(boolean z) {
        if (this.dAB != null) {
            this.dAB.fw(z);
        }
    }

    public boolean ls(int i) {
        this.mSkinType = i;
        if (this.dAB != null) {
            this.dAB.changeSkinType(i);
        }
        if (this.dAO != null) {
            this.dAO.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    public void gc(boolean z) {
        if (z) {
            if (this.dAB != null) {
                this.djJ.removeHeaderView(this.dAB.azT());
                this.dAJ = false;
            }
        } else if (this.dAB != null && this.dAB.azT() != null && !this.dAJ) {
            this.djJ.addHeaderView(this.dAB.azT(), this.djJ.getHeaderViewsCount());
            this.dAJ = true;
        }
    }

    public void a(String str, l lVar) {
        this.mPageType = str;
        if ("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) {
            if (lVar != null && lVar.bvc() != null && lVar.bvc().tU() != null && lVar.bvc().tU().size() >= 1) {
                a(lVar.bvc().tU().get(0), false);
            } else if (lVar != null && lVar.bvb() != null && !StringUtils.isNull(lVar.bvb().bvQ())) {
                r rVar = new r();
                rVar.setLinkUrl("");
                rVar.setImageUrl(lVar.bvb().bvQ());
                a(rVar, true);
            } else {
                this.dAN = false;
                if (this.djJ != null && this.dAO != null && this.dAO.getHeaderView() != null) {
                    this.djJ.removeHeaderView(this.dAO.getHeaderView());
                }
            }
            if (lVar != null && lVar.getUserData() != null && lVar.bam() != null) {
                n(str, lVar.getUserData().getIsMem(), lVar.bam().isLike());
            }
        }
    }

    public boolean azm() {
        return this.dAN;
    }

    private void a(r rVar, boolean z) {
        if (rVar == null) {
            this.dAN = false;
        } else if (this.djJ == null || this.dAO == null || this.dAO.getHeaderView() == null) {
            this.dAN = false;
        } else {
            this.dAN = true;
            this.djJ.removeHeaderView(this.dAO.getHeaderView());
            this.djJ.addHeaderView(this.dAO.getHeaderView());
            this.dAO.hT(rVar.getImageUrl());
            this.dAO.setTitle(rVar.getTitle());
            this.dAO.setSchemaUrl(rVar.getLinkUrl());
            if (z) {
                this.dAO.hideTitle();
            }
        }
    }

    private void n(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.dAE, str);
        this.dAG = i2;
        this.dAE = str;
        azo();
        if (this.dAB == null || z) {
            this.dAB = this.dAK.a(str, this.dxw, i);
            this.dAB.changeSkinType(this.mSkinType);
            this.dAB.n(this.djp);
        }
        this.djJ.addHeaderView(this.dAB.getView());
        int e = com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst(), d.e.tbds44);
        this.dAB.q(0, e, 0, e);
        azp();
        if (this.dAQ != null) {
            this.dAQ.ay(this.dAB.avx());
        }
    }

    public void azn() {
        if (!this.dAJ && this.dAB != null) {
            this.djJ.addHeaderView(this.dAB.azT());
            if (this.dAB.avx() != null && this.dxw.AJ() != null) {
                this.dxw.AJ().addHeaderView(this.dAB.avx(), 0);
            }
            this.dAJ = true;
        }
    }

    private void azo() {
        if (("normal_page".equals(this.dAE) || "frs_page".equals(this.dAE) || "book_page".equals(this.dAE)) && this.dAB != null) {
            this.djJ.removeHeaderView(this.dAB.getView());
            this.djJ.removeHeaderView(this.dAB.azT());
            if (this.dAB.avx() != null && this.dxw.AJ() != null) {
                this.dxw.AJ().removeHeaderView(this.dAB.avx());
            }
        }
        this.dAJ = false;
    }

    private void azp() {
        if (this.dAF == null) {
            this.dAF = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.dxw.atr() == null || !f.this.dxw.atr().atJ()) && f.this.djJ.isShown() && f.this.dxw.isPrimary() && !f.this.dAH && f.this.dAG == 1 && f.this.dxw.atr() != null && f.this.dxw.atr().aui() != null && !f.this.dxw.atr().aui().awh() && f.this.dxw.atN()) {
                            if (("frs_page".equals(f.this.dAE) || "normal_page".equals(f.this.dAE) || "book_page".equals(f.this.dAE)) && f.this.dAB != null && f.this.dAB.azS()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.avI();
                                f.this.dxw.dhq = true;
                                f.this.dAH = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.im().postDelayed(this.dAF, 4000L);
    }

    public void g(l lVar) {
        if (lVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(lVar.bam(), lVar);
            }
        }
    }

    public void b(ForumData forumData, l lVar) {
        if (forumData != null && lVar != null) {
            float b = b(forumData);
            if (this.dAB != null) {
                this.dAB.a(forumData, lVar);
                this.dAB.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                if (forumData.getSignData() != null) {
                    this.dAB.lK(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.dAB.gk(false);
                        return;
                    }
                    this.dAB.gk(true);
                    this.dAB.lK(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.dAC = forumData.getLevelupScore();
        this.dAD = forumData.getCurScore();
        if (this.dAC > 0) {
            return this.dAD / this.dAC;
        }
        return 0.0f;
    }

    public void lt(int i) {
        if (i > 1) {
            if (this.dAB != null) {
                this.dAB.gl(false);
            }
        } else if (this.dAB != null) {
            this.dAB.gl(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void azq() {
        if (this.djJ != null) {
            this.djJ.removeCallbacks(this.dAT);
            this.djJ.postDelayed(this.dAT, 100L);
        }
    }

    public void g(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            azr();
        }
    }

    public void setIsMem(int i) {
        if (this.dAB != null) {
            this.dAB.setMemberType(i);
        }
    }

    public void avI() {
        if (("normal_page".equals(this.dAE) || "frs_page".equals(this.dAE) || "book_page".equals(this.dAE)) && this.dAB != null) {
            this.dAB.avI();
        }
    }

    public void azr() {
        if (this.dAB != null) {
            this.dAB.avK();
        }
    }

    public void a(l lVar, boolean z) {
        if (lVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, lVar.bam(), lVar, z);
            }
        }
    }

    public void azs() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            lv(0);
        }
    }

    public void lu(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            lv(i);
        }
    }

    public void lv(int i) {
        if (this.dAB != null) {
            this.dAB.lJ(i);
        }
    }

    public void a(int i, ForumData forumData, l lVar, boolean z) {
        if (this.dAB != null) {
            this.dAB.a(forumData, lVar);
            if (forumData != null) {
                this.dAB.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.dAB.gk(false);
                }
            }
        }
    }

    public boolean azt() {
        if (("normal_page".equals(this.dAE) || "frs_page".equals(this.dAE) || "book_page".equals(this.dAE)) && this.dAB != null) {
            return this.dAB.azR();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.dAC - this.dAD) {
                z = true;
                this.dAC = signData.levelup_score;
            }
            this.dAD = i + this.dAD;
            if (this.dAD > this.dAC) {
                this.dAD = this.dAC;
            }
            if (this.dAC != 0) {
                f = this.dAD / this.dAC;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.d(z, f);
        }
    }

    public void lw(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.dAB != null) {
            this.dAB.lK(i);
        }
    }

    public void h(l lVar) {
        SignData signData;
        ForumData bam;
        if (lVar != null && lVar.bam() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.dAB != null && (signData = lVar.bam().getSignData()) != null && (bam = lVar.bam()) != null) {
                this.dAB.a(bam, lVar);
                this.dAB.lK(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.dAB.azR()) {
                    a(this.dAB, signData);
                    bam.setCurScore(this.dAD);
                    bam.setLevelupScore(this.dAC);
                    this.dAB.a(bam, lVar);
                }
            }
        }
    }

    public boolean azu() {
        if (("normal_page".equals(this.dAE) || "frs_page".equals(this.dAE) || "book_page".equals(this.dAE)) && this.dAB != null) {
            return this.dAB.azu();
        }
        return false;
    }

    public boolean azv() {
        if (("normal_page".equals(this.dAE) || "frs_page".equals(this.dAE) || "book_page".equals(this.dAE)) && this.dAB != null) {
            return this.dAB.azv();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void gd(boolean z) {
        if (this.dxw != null) {
            l atI = this.dxw.atI();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.dxw.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.k.login_to_use), true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_INITED)));
            } else if (atI != null && atI.bam() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.dxw.getFrom())) {
                    TiebaStatic.log(new am("c10356").ah(ImageViewerConfig.FORUM_ID, atI.bam().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.dxw.getFrom())) {
                    TiebaStatic.log(new am("c10590").r("obj_type", 2).ah(ImageViewerConfig.FORUM_ID, atI.bam().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.dxw.getFrom())) {
                    TiebaStatic.log(new am("c10587").r("obj_type", 2).ah(ImageViewerConfig.FORUM_ID, atI.bam().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.dxw.getFrom())) {
                    TiebaStatic.log(new am("c10578").r("obj_type", 2).ah(ImageViewerConfig.FORUM_ID, atI.bam().getId()));
                }
                this.bvr.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.dxw.getFrom())) {
                    TiebaStatic.eventStat(this.dxw.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.dxw.getFrom())) {
                    TiebaStatic.log(new am("c10359").ah(ImageViewerConfig.FORUM_ID, atI.bam().getId()));
                }
                this.bvr.J(atI.bam().getName(), atI.bam().getId(), "FRS");
                this.dAL = z;
            }
        }
    }

    public void azw() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.dxw.atI() != null && this.dxw.atI().bam() != null && this.dxw.atI().bam().getName() != null) {
            str = this.dxw.atI().bam().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.dB(String.format(getPageContext().getString(d.k.attention_cancel_dialog_content), str));
        } else {
            aVar.dB(getPageContext().getString(d.k.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(d.k.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.10
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                l atI = f.this.dxw.atI();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.dxw.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) f.this.getPageContext().getPageActivity(), f.this.getPageContext().getString(d.k.login_to_use), true, 11036)));
                } else if (atI != null && atI.bam() != null) {
                    f.this.dAI.t(atI.bam().getName(), com.baidu.adp.lib.g.b.c(atI.bam().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(d.k.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).xa();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void azx() {
        l atI = this.dxw.atI();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.dxw.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.k.login_to_use), true, 11014)));
        } else if (atI != null && atI.bam() != null) {
            FrsActivityStatic.forumName = atI.bam().getName() == null ? "" : atI.bam().getName();
            CustomMessage customMessage = new CustomMessage(2001425, atI.bam());
            customMessage.setTag(this.dAP);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ne(String str) {
        if (this.dxw.atm() != null && this.dxw.atm().ayo() != null) {
            com.baidu.tieba.tbadkCore.c.buO().T(com.baidu.tieba.tbadkCore.c.buO().d(str, this.dxw.atm().ayo().UG(), this.dxw.atm().ayo().getIsGood(), this.dxw.atm().ayo().getCategoryId()), false);
        }
    }

    private void Tt() {
        this.bvr = new LikeModel(this.dxw.getPageContext());
        this.bvr.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                com.baidu.tieba.tbadkCore.r rVar;
                l atI = f.this.dxw.atI();
                if (atI != null && atI.bam() != null && obj != null) {
                    if (AntiHelper.tE(f.this.bvr.getErrorCode())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.bvr.getBlockPopInfoData(), f.this.dAR) != null) {
                            TiebaStatic.log(new am("c12534").r("obj_locate", as.a.arp));
                            return;
                        }
                        return;
                    }
                    String name = atI.bam().getName();
                    String id = atI.bam().getId();
                    boolean z = false;
                    if (!(obj instanceof com.baidu.tieba.tbadkCore.r)) {
                        rVar = null;
                    } else {
                        rVar = (com.baidu.tieba.tbadkCore.r) obj;
                    }
                    if (rVar != null && f.this.bvr.getErrorCode() == 0) {
                        z = true;
                    }
                    if (rVar == null || !z) {
                        if (f.this.bvr.getErrorCode() == 22) {
                            f.this.dxw.showToast(f.this.getPageContext().getString(d.k.had_liked_forum));
                        } else {
                            f.this.dxw.showToast(f.this.bvr.getErrorString());
                        }
                    } else {
                        f.this.ne(name);
                        rVar.setLike(1);
                        atI.c(rVar);
                        atI.dq(rVar.buU());
                        f.this.a(atI, f.this.dAL);
                        f.this.dAL = true;
                        f.this.dxw.showToast(f.this.getPageContext().getResources().getString(d.k.attention_success));
                        f.this.i(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                    }
                    f.this.dxw.V(Boolean.valueOf(z));
                }
            }
        });
    }

    private void azy() {
        this.dAI = new w();
        this.dAI.setFrom("from_frs");
        this.dAI.a(new w.a() { // from class: com.baidu.tieba.frs.vc.f.3
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void m(String str, long j) {
                l atI = f.this.dxw.atI();
                if (atI != null && atI.bam() != null) {
                    String name = atI.bam().getName();
                    String id = atI.bam().getId();
                    if (j == com.baidu.adp.lib.g.b.c(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.ne(str);
                        atI.bam().setLike(0);
                        f.this.lu(0);
                        f.this.dxw.U(true);
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
        com.baidu.tieba.im.settingcache.d.aLP().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void A(int i, int i2, int i3) {
        l atI;
        if (i > 0 && i2 > 0 && (atI = this.dxw.atI()) != null && atI.bam() != null && atI.getSignData() != null) {
            ForumData bam = atI.bam();
            SignData signData = atI.getSignData();
            signData.levelup_score = bam.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            atI.d(signData);
            signData.forumId = bam.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
            int i4 = -1;
            if (azv()) {
                i4 = bam.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(bam.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void avu() {
        if (this.dAB != null) {
            this.dAB.avu();
        }
    }

    public static boolean i(l lVar) {
        if (lVar != null) {
            return (lVar.bvs() == null || StringUtils.isNull(lVar.bvs().tV(), true) || lVar.bvs().tV().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean j(l lVar) {
        if (lVar != null) {
            return ((lVar.bvb() == null || lVar.bvb().bvM() != 1) && lVar.bvr() == null && (lVar.bvc() == null || com.baidu.tbadk.core.util.w.z(lVar.bvc().tU())) && ((lVar.bam() == null || lVar.bam().getFrsBannerData() == null || lVar.bam().getFrsBannerData().getType() != 2) && (lVar.bvt() == null || StringUtils.isNull(lVar.bvt().ub(), true)))) ? false : true;
        }
        return false;
    }

    public void lx(int i) {
        View findViewById;
        if (this.dAB != null && this.dAB.azT() != null && (findViewById = this.dAB.azT().findViewById(d.g.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.dAM != null) {
            this.dAM.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.dAQ = frsTabViewController;
    }
}
