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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.v;
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
    private LikeModel bnl;
    private final View.OnClickListener cZX;
    private FrsHeaderViewContainer dar;
    private FrsFragment dof;
    private boolean drA;
    private com.baidu.tieba.frs.c.a.a drB;
    private BdUniqueId drC;
    private FrsTabViewController drD;
    private AntiHelper.a drE;
    private CustomMessageListener drF;
    private Runnable drG;
    private com.baidu.tieba.frs.view.b dro;
    private int drp;
    private int drq;
    private String drr;
    private Runnable drs;
    private int drt;
    private boolean dru;
    private w drv;
    private boolean drw;
    private com.baidu.tieba.frs.entelechy.b.a drx;
    private boolean dry;
    private com.baidu.tieba.f.a drz;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.dar = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.drr = null;
        this.dru = false;
        this.bnl = null;
        this.drv = null;
        this.drw = false;
        this.drA = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new al("c12536").r("obj_locate", ar.a.ajf));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new al("c12535").r("obj_locate", ar.a.ajf));
            }
        };
        this.drE = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.4
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new al("c12536").r("obj_locate", ar.a.ajh));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new al("c12535").r("obj_locate", ar.a.ajh));
            }
        };
        this.drF = new CustomMessageListener(2001425) { // from class: com.baidu.tieba.frs.vc.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SignData signData;
                boolean z;
                int i;
                l apD = f.this.dof.apD();
                if (apD != null && apD.aVq() != null && apD.aVq().getName() != null && apD.aVq().getName().equals(FrsActivityStatic.forumName)) {
                    if (customResponsedMessage == null || customResponsedMessage.getOrginalMessage().getTag() == f.this.drC) {
                        TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_end_time", System.currentTimeMillis() + "");
                        String name = apD.aVq().getName();
                        SignMessage signMessage = (SignMessage) customResponsedMessage;
                        if (AntiHelper.ts(signMessage.mSignErrorCode) && signMessage.signData != null) {
                            if (AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener) != null) {
                                TiebaStatic.log(new al("c12534").r("obj_locate", ar.a.ajf));
                                return;
                            }
                            return;
                        }
                        if (signMessage == null || signMessage.signData == null) {
                            signData = null;
                            z = false;
                        } else {
                            SignData signData2 = signMessage.signData;
                            if (signData2.forumId != null && signData2.forumId.equals(apD.aVq().getId())) {
                                f.this.mx(name);
                                apD.d(signData2);
                                signData2.forumId = apD.aVq().getId();
                                signData2.forumName = apD.aVq().getName();
                                signData = signData2;
                                z = true;
                            } else {
                                return;
                            }
                        }
                        if (z) {
                            int user_level = apD.aVq().getUser_level();
                            if (f.this.avm()) {
                                i = apD.aVq().getUser_level();
                                if (user_level >= i) {
                                    i++;
                                }
                            } else {
                                i = user_level;
                            }
                            TbadkCoreApplication.getInst().addSignedForum(name, signData.sign_bonus_point, i);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                            if (AntiHelper.ts(signMessage.mSignErrorCode)) {
                                AntiHelper.am(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                                return;
                            } else if (signData.mContriInfo != null && signData.mContriInfo.isShowToast()) {
                                f.this.dof.a(signData.mContriInfo);
                                return;
                            } else if (!f.this.avk()) {
                                f.this.dof.showToast(f.this.getPageContext().getResources().getString(d.k.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                                return;
                            } else {
                                f.this.dof.showToast(f.this.getPageContext().getResources().getString(d.k.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                                return;
                            }
                        }
                        if (signMessage.mSignErrorCode == 160002) {
                            f.this.lp(1);
                        }
                        f.this.dof.showToast(signMessage.mSignErrorString);
                    }
                }
            }
        };
        this.drG = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.8
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.dar != null) {
                    int childCount = f.this.dar.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(f.this.dar.getChildAt(i));
                    }
                }
            }

            private void refreshImage(View view2) {
                if (view2 != null) {
                    if (view2 instanceof com.baidu.adp.newwidget.ImageView.h) {
                        ((com.baidu.adp.newwidget.ImageView.h) view2).refresh();
                    }
                    if (view2 instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view2;
                        int childCount = viewGroup.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            refreshImage(viewGroup.getChildAt(i));
                        }
                    }
                }
            }
        };
        this.cZX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                l apD = f.this.dof.apD();
                if (apD != null && apD.aVq() != null && f.this.dro != null && (view2 == f.this.dro.avL() || view2 == f.this.dro.avM() || view2 == f.this.dro.avN())) {
                    if (f.this.dof != null && apD.aVq() != null) {
                        TiebaStatic.log(new al("c12046").ac(ImageViewerConfig.FORUM_ID, apD.aVq().getId()).r("obj_locate", f.this.dof.apF() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), apD.aVq().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view2.getId();
                if (id == d.g.tv_love) {
                    if (!f.this.dof.apE()) {
                        if (!com.baidu.adp.lib.util.j.gP()) {
                            f.this.dof.showToast(d.k.neterror);
                        } else if (!az.aK(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new al("c10517").r("obj_locate", 1).ac(ImageViewerConfig.FORUM_ID, f.this.dof.getForumId()));
                        } else {
                            f.this.fY(true);
                        }
                    }
                } else if (id == d.g.tv_sign) {
                    if (!f.this.dof.apE()) {
                        if (!com.baidu.adp.lib.util.j.gP()) {
                            f.this.dof.showToast(d.k.neterror);
                        } else if (az.aK(f.this.mContext.getPageActivity())) {
                            if (!f.this.avl()) {
                                f.this.avo();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(f.this.dof.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.g(f.this.dof.getForumId(), 0), 24002)));
                            }
                        }
                    }
                } else if (id == d.g.frs_header_games) {
                    if (az.aK(f.this.mContext.getPageActivity()) && apD != null && apD.bqj() != null) {
                        ax.wf().a((TbPageContext) f.this.getPageContext(), new String[]{apD.bqj()}, true);
                    }
                } else if (id == d.g.frs_bawu_center) {
                    if (apD != null && apD.getUserData() != null && apD.getUserData().isBawu()) {
                        String bqo = apD.bqo();
                        if (!an.isEmpty(bqo)) {
                            com.baidu.tbadk.browser.a.M(f.this.getPageContext().getPageActivity(), bqo);
                            if (apD.aVq() != null) {
                                TiebaStatic.log(new al("c10502").ac(ImageViewerConfig.FORUM_ID, apD.aVq().getId()).ac("uid", apD.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == d.g.level_container && !f.this.dof.apE() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page")) && f.this.dro != null) {
                        f.this.dro.j(view2, false);
                    }
                }
            }
        };
        this.dof = frsFragment;
        this.drx = aVar;
        this.dar = frsHeaderViewContainer;
        this.drB = new com.baidu.tieba.frs.c.a(frsFragment.aeY());
        this.drC = BdUniqueId.gen();
        this.drz = new com.baidu.tieba.f.a();
        this.drz.a(new a.InterfaceC0131a() { // from class: com.baidu.tieba.frs.vc.f.6
            @Override // com.baidu.tieba.f.a.InterfaceC0131a
            public void W(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0131a
            public void X(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0131a
            public void Y(int i, int i2) {
            }
        });
    }

    public void l(Bundle bundle) {
        this.dof.registerListener(this.drF);
        PV();
        avp();
        this.dru = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.dro != null) {
            this.dro.onDestory();
        }
        if (this.bnl != null) {
            this.bnl.brn();
        }
        if (this.drs != null) {
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.drs);
        }
    }

    public void onActivityStop() {
        if (this.dro != null) {
            this.dro.onStop();
        }
        if (this.dar != null) {
            this.dar.removeCallbacks(this.drG);
        }
    }

    public void fW(boolean z) {
        if (this.dro != null) {
            this.dro.fW(z);
        }
    }

    public boolean ll(int i) {
        this.mSkinType = i;
        if (this.dro != null) {
            this.dro.changeSkinType(i);
        }
        if (this.drB != null) {
            this.drB.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    public void fX(boolean z) {
        if (z) {
            if (this.dro != null) {
                this.dar.removeHeaderView(this.dro.avK());
                this.drw = false;
            }
        } else if (this.dro != null && this.dro.avK() != null && !this.drw) {
            this.dar.addHeaderView(this.dro.avK(), this.dar.getHeaderViewsCount());
            this.drw = true;
        }
    }

    public void a(String str, l lVar) {
        this.mPageType = str;
        if ("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) {
            if (lVar != null && lVar.bqb() != null && lVar.bqb().qy() != null && lVar.bqb().qy().size() >= 1) {
                a(lVar.bqb().qy().get(0), false);
            } else if (lVar != null && lVar.bqa() != null && !StringUtils.isNull(lVar.bqa().bqO())) {
                r rVar = new r();
                rVar.setLinkUrl("");
                rVar.setImageUrl(lVar.bqa().bqO());
                a(rVar, true);
            } else {
                this.drA = false;
                if (this.dar != null && this.drB != null && this.drB.getHeaderView() != null) {
                    this.dar.removeHeaderView(this.drB.getHeaderView());
                }
            }
            if (lVar != null && lVar.getUserData() != null && lVar.aVq() != null) {
                n(str, lVar.getUserData().getIsMem(), lVar.aVq().isLike());
            }
        }
    }

    public boolean avd() {
        return this.drA;
    }

    private void a(r rVar, boolean z) {
        if (rVar == null) {
            this.drA = false;
        } else if (this.dar == null || this.drB == null || this.drB.getHeaderView() == null) {
            this.drA = false;
        } else {
            this.drA = true;
            this.dar.removeHeaderView(this.drB.getHeaderView());
            this.dar.addHeaderView(this.drB.getHeaderView());
            this.drB.hv(rVar.getImageUrl());
            this.drB.setTitle(rVar.getTitle());
            this.drB.setSchemaUrl(rVar.getLinkUrl());
            if (z) {
                this.drB.hideTitle();
            }
        }
    }

    private void n(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.drr, str);
        this.drt = i2;
        this.drr = str;
        avf();
        if (this.dro == null || z) {
            this.dro = this.drx.a(str, this.dof, i);
            this.dro.changeSkinType(this.mSkinType);
            this.dro.n(this.cZX);
        }
        this.dar.addHeaderView(this.dro.getView());
        int e = com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst(), d.e.tbds44);
        this.dro.q(0, e, 0, e);
        avg();
        if (this.drD != null) {
            this.drD.ay(this.dro.ars());
        }
    }

    public void ave() {
        if (!this.drw && this.dro != null) {
            this.dar.addHeaderView(this.dro.avK());
            if (this.dro.ars() != null && this.dof.xi() != null) {
                this.dof.xi().addHeaderView(this.dro.ars(), 0);
            }
            this.drw = true;
        }
    }

    private void avf() {
        if (("normal_page".equals(this.drr) || "frs_page".equals(this.drr) || "book_page".equals(this.drr)) && this.dro != null) {
            this.dar.removeHeaderView(this.dro.getView());
            this.dar.removeHeaderView(this.dro.avK());
            if (this.dro.ars() != null && this.dof.xi() != null) {
                this.dof.xi().removeHeaderView(this.dro.ars());
            }
        }
        this.drw = false;
    }

    private void avg() {
        if (this.drs == null) {
            this.drs = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.dof.apm() == null || !f.this.dof.apm().apE()) && f.this.dar.isShown() && f.this.dof.isPrimary() && !f.this.dru && f.this.drt == 1 && f.this.dof.apm() != null && f.this.dof.apm().aqd() != null && !f.this.dof.apm().aqd().asc() && f.this.dof.apI()) {
                            if (("frs_page".equals(f.this.drr) || "normal_page".equals(f.this.drr) || "book_page".equals(f.this.drr)) && f.this.dro != null && f.this.dro.avJ()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.arD();
                                f.this.dof.cYc = true;
                                f.this.dru = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.fw().postDelayed(this.drs, 4000L);
    }

    public void f(l lVar) {
        if (lVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(lVar.aVq(), lVar);
            }
        }
    }

    public void b(ForumData forumData, l lVar) {
        if (forumData != null && lVar != null) {
            float b = b(forumData);
            if (this.dro != null) {
                this.dro.a(forumData, lVar);
                this.dro.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                if (forumData.getSignData() != null) {
                    this.dro.lD(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.dro.gf(false);
                        return;
                    }
                    this.dro.gf(true);
                    this.dro.lD(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.drp = forumData.getLevelupScore();
        this.drq = forumData.getCurScore();
        if (this.drp > 0) {
            return this.drq / this.drp;
        }
        return 0.0f;
    }

    public void lm(int i) {
        if (i > 1) {
            if (this.dro != null) {
                this.dro.gg(false);
            }
        } else if (this.dro != null) {
            this.dro.gg(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void avh() {
        if (this.dar != null) {
            this.dar.removeCallbacks(this.drG);
            this.dar.postDelayed(this.drG, 100L);
        }
    }

    public void g(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            avi();
        }
    }

    public void setIsMem(int i) {
        if (this.dro != null) {
            this.dro.setMemberType(i);
        }
    }

    public void arD() {
        if (("normal_page".equals(this.drr) || "frs_page".equals(this.drr) || "book_page".equals(this.drr)) && this.dro != null) {
            this.dro.arD();
        }
    }

    public void avi() {
        if (this.dro != null) {
            this.dro.arF();
        }
    }

    public void a(l lVar, boolean z) {
        if (lVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, lVar.aVq(), lVar, z);
            }
        }
    }

    public void avj() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            lo(0);
        }
    }

    public void ln(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            lo(i);
        }
    }

    public void lo(int i) {
        if (this.dro != null) {
            this.dro.lC(i);
        }
    }

    public void a(int i, ForumData forumData, l lVar, boolean z) {
        if (this.dro != null) {
            this.dro.a(forumData, lVar);
            if (forumData != null) {
                this.dro.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.dro.gf(false);
                }
            }
        }
    }

    public boolean avk() {
        if (("normal_page".equals(this.drr) || "frs_page".equals(this.drr) || "book_page".equals(this.drr)) && this.dro != null) {
            return this.dro.avI();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.drp - this.drq) {
                z = true;
                this.drp = signData.levelup_score;
            }
            this.drq = i + this.drq;
            if (this.drq > this.drp) {
                this.drq = this.drp;
            }
            if (this.drp != 0) {
                f = this.drq / this.drp;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.c(z, f);
        }
    }

    public void lp(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.dro != null) {
            this.dro.lD(i);
        }
    }

    public void g(l lVar) {
        SignData signData;
        ForumData aVq;
        if (lVar != null && lVar.aVq() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.dro != null && (signData = lVar.aVq().getSignData()) != null && (aVq = lVar.aVq()) != null) {
                this.dro.a(aVq, lVar);
                this.dro.lD(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.dro.avI()) {
                    a(this.dro, signData);
                    aVq.setCurScore(this.drq);
                    aVq.setLevelupScore(this.drp);
                    this.dro.a(aVq, lVar);
                }
            }
        }
    }

    public boolean avl() {
        if (("normal_page".equals(this.drr) || "frs_page".equals(this.drr) || "book_page".equals(this.drr)) && this.dro != null) {
            return this.dro.avl();
        }
        return false;
    }

    public boolean avm() {
        if (("normal_page".equals(this.drr) || "frs_page".equals(this.drr) || "book_page".equals(this.drr)) && this.dro != null) {
            return this.dro.avm();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void fY(boolean z) {
        if (this.dof != null) {
            l apD = this.dof.apD();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.dof.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.k.login_to_use), true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_INITED)));
            } else if (apD != null && apD.aVq() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.dof.getFrom())) {
                    TiebaStatic.log(new al("c10356").ac(ImageViewerConfig.FORUM_ID, apD.aVq().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.dof.getFrom())) {
                    TiebaStatic.log(new al("c10590").r("obj_type", 2).ac(ImageViewerConfig.FORUM_ID, apD.aVq().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.dof.getFrom())) {
                    TiebaStatic.log(new al("c10587").r("obj_type", 2).ac(ImageViewerConfig.FORUM_ID, apD.aVq().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.dof.getFrom())) {
                    TiebaStatic.log(new al("c10578").r("obj_type", 2).ac(ImageViewerConfig.FORUM_ID, apD.aVq().getId()));
                }
                this.bnl.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.dof.getFrom())) {
                    TiebaStatic.eventStat(this.dof.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.dof.getFrom())) {
                    TiebaStatic.log(new al("c10359").ac(ImageViewerConfig.FORUM_ID, apD.aVq().getId()));
                }
                this.bnl.I(apD.aVq().getName(), apD.aVq().getId(), "FRS");
                this.dry = z;
            }
        }
    }

    public void avn() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.dof.apD() != null && this.dof.apD().aVq() != null && this.dof.apD().aVq().getName() != null) {
            str = this.dof.apD().aVq().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.dc(String.format(getPageContext().getString(d.k.attention_cancel_dialog_content), str));
        } else {
            aVar.dc(getPageContext().getString(d.k.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(d.k.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.10
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                l apD = f.this.dof.apD();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.dof.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) f.this.getPageContext().getPageActivity(), f.this.getPageContext().getString(d.k.login_to_use), true, 11036)));
                } else if (apD != null && apD.aVq() != null) {
                    f.this.drv.t(apD.aVq().getName(), com.baidu.adp.lib.g.b.c(apD.aVq().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(d.k.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).tC();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void avo() {
        l apD = this.dof.apD();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.dof.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.k.login_to_use), true, 11014)));
        } else if (apD != null && apD.aVq() != null) {
            FrsActivityStatic.forumName = apD.aVq().getName() == null ? "" : apD.aVq().getName();
            CustomMessage customMessage = new CustomMessage(2001425, apD.aVq());
            customMessage.setTag(this.drC);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mx(String str) {
        if (this.dof.apg() != null && this.dof.apg().aub() != null) {
            com.baidu.tieba.tbadkCore.c.bpO().T(com.baidu.tieba.tbadkCore.c.bpO().d(str, this.dof.apg().aub().Ri(), this.dof.apg().aub().getIsGood(), this.dof.apg().aub().getCategoryId()), false);
        }
    }

    private void PV() {
        this.bnl = new LikeModel(this.dof.getPageContext());
        this.bnl.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                com.baidu.tieba.tbadkCore.r rVar;
                l apD = f.this.dof.apD();
                if (apD != null && apD.aVq() != null && obj != null) {
                    if (AntiHelper.ts(f.this.bnl.getErrorCode())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.bnl.getBlockPopInfoData(), f.this.drE) != null) {
                            TiebaStatic.log(new al("c12534").r("obj_locate", ar.a.ajh));
                            return;
                        }
                        return;
                    }
                    String name = apD.aVq().getName();
                    String id = apD.aVq().getId();
                    boolean z = false;
                    if (!(obj instanceof com.baidu.tieba.tbadkCore.r)) {
                        rVar = null;
                    } else {
                        rVar = (com.baidu.tieba.tbadkCore.r) obj;
                    }
                    if (rVar != null && f.this.bnl.getErrorCode() == 0) {
                        z = true;
                    }
                    if (rVar == null || !z) {
                        if (f.this.bnl.getErrorCode() == 22) {
                            f.this.dof.showToast(f.this.getPageContext().getString(d.k.had_liked_forum));
                        } else {
                            f.this.dof.showToast(f.this.bnl.getErrorString());
                        }
                    } else {
                        f.this.mx(name);
                        rVar.setLike(1);
                        apD.c(rVar);
                        apD.dm(rVar.bpT());
                        f.this.a(apD, f.this.dry);
                        f.this.dry = true;
                        f.this.dof.showToast(f.this.getPageContext().getResources().getString(d.k.attention_success));
                        f.this.h(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                    }
                    f.this.dof.S(Boolean.valueOf(z));
                }
            }
        });
    }

    private void avp() {
        this.drv = new w();
        this.drv.setFrom("from_frs");
        this.drv.a(new w.a() { // from class: com.baidu.tieba.frs.vc.f.3
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void m(String str, long j) {
                l apD = f.this.dof.apD();
                if (apD != null && apD.aVq() != null) {
                    String name = apD.aVq().getName();
                    String id = apD.aVq().getId();
                    if (j == com.baidu.adp.lib.g.b.c(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.mx(str);
                        apD.aVq().setLike(0);
                        f.this.ln(0);
                        f.this.dof.R(true);
                        f.this.h(false, id);
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
    public void h(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.aGU().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void A(int i, int i2, int i3) {
        l apD;
        if (i > 0 && i2 > 0 && (apD = this.dof.apD()) != null && apD.aVq() != null && apD.getSignData() != null) {
            ForumData aVq = apD.aVq();
            SignData signData = apD.getSignData();
            signData.levelup_score = aVq.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            apD.d(signData);
            signData.forumId = aVq.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
            int i4 = -1;
            if (avm()) {
                i4 = aVq.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(aVq.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void arp() {
        if (this.dro != null) {
            this.dro.arp();
        }
    }

    public static boolean h(l lVar) {
        if (lVar != null) {
            return (lVar.bqs() == null || StringUtils.isNull(lVar.bqs().qz(), true) || lVar.bqs().qz().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean i(l lVar) {
        if (lVar != null) {
            return ((lVar.bqa() == null || lVar.bqa().bqK() != 1) && lVar.bqr() == null && (lVar.bqb() == null || v.w(lVar.bqb().qy())) && ((lVar.aVq() == null || lVar.aVq().getFrsBannerData() == null || lVar.aVq().getFrsBannerData().getType() != 2) && (lVar.bqt() == null || StringUtils.isNull(lVar.bqt().qF(), true)))) ? false : true;
        }
        return false;
    }

    public void lq(int i) {
        View findViewById;
        if (this.dro != null && this.dro.avK() != null && (findViewById = this.dro.avK().findViewById(d.g.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.drz != null) {
            this.drz.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.drD = frsTabViewController;
    }
}
