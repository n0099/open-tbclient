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
    private LikeModel bmW;
    private final View.OnClickListener cYQ;
    private FrsHeaderViewContainer cZk;
    private FrsFragment dmW;
    private com.baidu.tieba.frs.view.b dqg;
    private int dqh;
    private int dqi;
    private String dqj;
    private Runnable dqk;
    private int dql;
    private boolean dqm;
    private w dqn;
    private boolean dqo;
    private com.baidu.tieba.frs.entelechy.b.a dqp;
    private boolean dqq;
    private com.baidu.tieba.f.a dqr;
    private boolean dqs;
    private com.baidu.tieba.frs.c.a.a dqt;
    private BdUniqueId dqu;
    private FrsTabViewController dqv;
    private AntiHelper.a dqw;
    private CustomMessageListener dqx;
    private Runnable dqy;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.cZk = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.dqj = null;
        this.dqm = false;
        this.bmW = null;
        this.dqn = null;
        this.dqo = false;
        this.dqs = false;
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
        this.dqw = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.4
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new al("c12536").r("obj_locate", ar.a.ajh));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new al("c12535").r("obj_locate", ar.a.ajh));
            }
        };
        this.dqx = new CustomMessageListener(2001425) { // from class: com.baidu.tieba.frs.vc.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SignData signData;
                boolean z;
                int i;
                l apE = f.this.dmW.apE();
                if (apE != null && apE.aVq() != null && apE.aVq().getName() != null && apE.aVq().getName().equals(FrsActivityStatic.forumName)) {
                    if (customResponsedMessage == null || customResponsedMessage.getOrginalMessage().getTag() == f.this.dqu) {
                        TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_end_time", System.currentTimeMillis() + "");
                        String name = apE.aVq().getName();
                        SignMessage signMessage = (SignMessage) customResponsedMessage;
                        if (AntiHelper.tt(signMessage.mSignErrorCode) && signMessage.signData != null) {
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
                            if (signData2.forumId != null && signData2.forumId.equals(apE.aVq().getId())) {
                                f.this.mu(name);
                                apE.d(signData2);
                                signData2.forumId = apE.aVq().getId();
                                signData2.forumName = apE.aVq().getName();
                                signData = signData2;
                                z = true;
                            } else {
                                return;
                            }
                        }
                        if (z) {
                            int user_level = apE.aVq().getUser_level();
                            if (f.this.avn()) {
                                i = apE.aVq().getUser_level();
                                if (user_level >= i) {
                                    i++;
                                }
                            } else {
                                i = user_level;
                            }
                            TbadkCoreApplication.getInst().addSignedForum(name, signData.sign_bonus_point, i);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                            if (AntiHelper.tt(signMessage.mSignErrorCode)) {
                                AntiHelper.am(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                                return;
                            } else if (signData.mContriInfo != null && signData.mContriInfo.isShowToast()) {
                                f.this.dmW.a(signData.mContriInfo);
                                return;
                            } else if (!f.this.avl()) {
                                f.this.dmW.showToast(f.this.getPageContext().getResources().getString(d.k.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                                return;
                            } else {
                                f.this.dmW.showToast(f.this.getPageContext().getResources().getString(d.k.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                                return;
                            }
                        }
                        if (signMessage.mSignErrorCode == 160002) {
                            f.this.lq(1);
                        }
                        f.this.dmW.showToast(signMessage.mSignErrorString);
                    }
                }
            }
        };
        this.dqy = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.8
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.cZk != null) {
                    int childCount = f.this.cZk.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(f.this.cZk.getChildAt(i));
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
        this.cYQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                l apE = f.this.dmW.apE();
                if (apE != null && apE.aVq() != null && f.this.dqg != null && (view2 == f.this.dqg.avM() || view2 == f.this.dqg.avN() || view2 == f.this.dqg.avO())) {
                    if (f.this.dmW != null && apE.aVq() != null) {
                        TiebaStatic.log(new al("c12046").ac(ImageViewerConfig.FORUM_ID, apE.aVq().getId()).r("obj_locate", f.this.dmW.apG() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), apE.aVq().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view2.getId();
                if (id == d.g.tv_love) {
                    if (!f.this.dmW.apF()) {
                        if (!com.baidu.adp.lib.util.j.gP()) {
                            f.this.dmW.showToast(d.k.neterror);
                        } else if (!az.aK(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new al("c10517").r("obj_locate", 1).ac(ImageViewerConfig.FORUM_ID, f.this.dmW.getForumId()));
                        } else {
                            f.this.fX(true);
                        }
                    }
                } else if (id == d.g.tv_sign) {
                    if (!f.this.dmW.apF()) {
                        if (!com.baidu.adp.lib.util.j.gP()) {
                            f.this.dmW.showToast(d.k.neterror);
                        } else if (az.aK(f.this.mContext.getPageActivity())) {
                            if (!f.this.avm()) {
                                f.this.avp();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(f.this.dmW.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.g(f.this.dmW.getForumId(), 0), 24002)));
                            }
                        }
                    }
                } else if (id == d.g.frs_header_games) {
                    if (az.aK(f.this.mContext.getPageActivity()) && apE != null && apE.bql() != null) {
                        ax.wg().a((TbPageContext) f.this.getPageContext(), new String[]{apE.bql()}, true);
                    }
                } else if (id == d.g.frs_bawu_center) {
                    if (apE != null && apE.getUserData() != null && apE.getUserData().isBawu()) {
                        String bqq = apE.bqq();
                        if (!an.isEmpty(bqq)) {
                            com.baidu.tbadk.browser.a.M(f.this.getPageContext().getPageActivity(), bqq);
                            if (apE.aVq() != null) {
                                TiebaStatic.log(new al("c10502").ac(ImageViewerConfig.FORUM_ID, apE.aVq().getId()).ac("uid", apE.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == d.g.level_container && !f.this.dmW.apF() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page")) && f.this.dqg != null) {
                        f.this.dqg.j(view2, false);
                    }
                }
            }
        };
        this.dmW = frsFragment;
        this.dqp = aVar;
        this.cZk = frsHeaderViewContainer;
        this.dqt = new com.baidu.tieba.frs.c.a(frsFragment.aeY());
        this.dqu = BdUniqueId.gen();
        this.dqr = new com.baidu.tieba.f.a();
        this.dqr.a(new a.InterfaceC0131a() { // from class: com.baidu.tieba.frs.vc.f.6
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
        this.dmW.registerListener(this.dqx);
        PY();
        avq();
        this.dqm = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.dqg != null) {
            this.dqg.onDestory();
        }
        if (this.bmW != null) {
            this.bmW.brp();
        }
        if (this.dqk != null) {
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.dqk);
        }
    }

    public void onActivityStop() {
        if (this.dqg != null) {
            this.dqg.onStop();
        }
        if (this.cZk != null) {
            this.cZk.removeCallbacks(this.dqy);
        }
    }

    public void fV(boolean z) {
        if (this.dqg != null) {
            this.dqg.fV(z);
        }
    }

    public boolean lm(int i) {
        this.mSkinType = i;
        if (this.dqg != null) {
            this.dqg.changeSkinType(i);
        }
        if (this.dqt != null) {
            this.dqt.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    public void fW(boolean z) {
        if (z) {
            if (this.dqg != null) {
                this.cZk.removeHeaderView(this.dqg.avL());
                this.dqo = false;
            }
        } else if (this.dqg != null && this.dqg.avL() != null && !this.dqo) {
            this.cZk.addHeaderView(this.dqg.avL(), this.cZk.getHeaderViewsCount());
            this.dqo = true;
        }
    }

    public void a(String str, l lVar) {
        this.mPageType = str;
        if ("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) {
            if (lVar != null && lVar.bqd() != null && lVar.bqd().qz() != null && lVar.bqd().qz().size() >= 1) {
                a(lVar.bqd().qz().get(0), false);
            } else if (lVar != null && lVar.bqc() != null && !StringUtils.isNull(lVar.bqc().bqQ())) {
                r rVar = new r();
                rVar.setLinkUrl("");
                rVar.setImageUrl(lVar.bqc().bqQ());
                a(rVar, true);
            } else {
                this.dqs = false;
                if (this.cZk != null && this.dqt != null && this.dqt.getHeaderView() != null) {
                    this.cZk.removeHeaderView(this.dqt.getHeaderView());
                }
            }
            if (lVar != null && lVar.getUserData() != null && lVar.aVq() != null) {
                n(str, lVar.getUserData().getIsMem(), lVar.aVq().isLike());
            }
        }
    }

    public boolean ave() {
        return this.dqs;
    }

    private void a(r rVar, boolean z) {
        if (rVar == null) {
            this.dqs = false;
        } else if (this.cZk == null || this.dqt == null || this.dqt.getHeaderView() == null) {
            this.dqs = false;
        } else {
            this.dqs = true;
            this.cZk.removeHeaderView(this.dqt.getHeaderView());
            this.cZk.addHeaderView(this.dqt.getHeaderView());
            this.dqt.hu(rVar.getImageUrl());
            this.dqt.setTitle(rVar.getTitle());
            this.dqt.setSchemaUrl(rVar.getLinkUrl());
            if (z) {
                this.dqt.hideTitle();
            }
        }
    }

    private void n(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.dqj, str);
        this.dql = i2;
        this.dqj = str;
        avg();
        if (this.dqg == null || z) {
            this.dqg = this.dqp.a(str, this.dmW, i);
            this.dqg.changeSkinType(this.mSkinType);
            this.dqg.n(this.cYQ);
        }
        this.cZk.addHeaderView(this.dqg.getView());
        int e = com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst(), d.e.tbds44);
        this.dqg.q(0, e, 0, e);
        avh();
        if (this.dqv != null) {
            this.dqv.ay(this.dqg.art());
        }
    }

    public void avf() {
        if (!this.dqo && this.dqg != null) {
            this.cZk.addHeaderView(this.dqg.avL());
            if (this.dqg.art() != null && this.dmW.xj() != null) {
                this.dmW.xj().addHeaderView(this.dqg.art(), 0);
            }
            this.dqo = true;
        }
    }

    private void avg() {
        if (("normal_page".equals(this.dqj) || "frs_page".equals(this.dqj) || "book_page".equals(this.dqj)) && this.dqg != null) {
            this.cZk.removeHeaderView(this.dqg.getView());
            this.cZk.removeHeaderView(this.dqg.avL());
            if (this.dqg.art() != null && this.dmW.xj() != null) {
                this.dmW.xj().removeHeaderView(this.dqg.art());
            }
        }
        this.dqo = false;
    }

    private void avh() {
        if (this.dqk == null) {
            this.dqk = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.dmW.apn() == null || !f.this.dmW.apn().apF()) && f.this.cZk.isShown() && f.this.dmW.isPrimary() && !f.this.dqm && f.this.dql == 1 && f.this.dmW.apn() != null && f.this.dmW.apn().aqe() != null && !f.this.dmW.apn().aqe().asd() && f.this.dmW.apJ()) {
                            if (("frs_page".equals(f.this.dqj) || "normal_page".equals(f.this.dqj) || "book_page".equals(f.this.dqj)) && f.this.dqg != null && f.this.dqg.avK()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.arE();
                                f.this.dmW.cWV = true;
                                f.this.dqm = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.fw().postDelayed(this.dqk, 4000L);
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
            if (this.dqg != null) {
                this.dqg.a(forumData, lVar);
                this.dqg.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                if (forumData.getSignData() != null) {
                    this.dqg.lE(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.dqg.ge(false);
                        return;
                    }
                    this.dqg.ge(true);
                    this.dqg.lE(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.dqh = forumData.getLevelupScore();
        this.dqi = forumData.getCurScore();
        if (this.dqh > 0) {
            return this.dqi / this.dqh;
        }
        return 0.0f;
    }

    public void ln(int i) {
        if (i > 1) {
            if (this.dqg != null) {
                this.dqg.gf(false);
            }
        } else if (this.dqg != null) {
            this.dqg.gf(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void avi() {
        if (this.cZk != null) {
            this.cZk.removeCallbacks(this.dqy);
            this.cZk.postDelayed(this.dqy, 100L);
        }
    }

    public void g(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            avj();
        }
    }

    public void setIsMem(int i) {
        if (this.dqg != null) {
            this.dqg.setMemberType(i);
        }
    }

    public void arE() {
        if (("normal_page".equals(this.dqj) || "frs_page".equals(this.dqj) || "book_page".equals(this.dqj)) && this.dqg != null) {
            this.dqg.arE();
        }
    }

    public void avj() {
        if (this.dqg != null) {
            this.dqg.arG();
        }
    }

    public void a(l lVar, boolean z) {
        if (lVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, lVar.aVq(), lVar, z);
            }
        }
    }

    public void avk() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            lp(0);
        }
    }

    public void lo(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            lp(i);
        }
    }

    public void lp(int i) {
        if (this.dqg != null) {
            this.dqg.lD(i);
        }
    }

    public void a(int i, ForumData forumData, l lVar, boolean z) {
        if (this.dqg != null) {
            this.dqg.a(forumData, lVar);
            if (forumData != null) {
                this.dqg.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.dqg.ge(false);
                }
            }
        }
    }

    public boolean avl() {
        if (("normal_page".equals(this.dqj) || "frs_page".equals(this.dqj) || "book_page".equals(this.dqj)) && this.dqg != null) {
            return this.dqg.avJ();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.dqh - this.dqi) {
                z = true;
                this.dqh = signData.levelup_score;
            }
            this.dqi = i + this.dqi;
            if (this.dqi > this.dqh) {
                this.dqi = this.dqh;
            }
            if (this.dqh != 0) {
                f = this.dqi / this.dqh;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.c(z, f);
        }
    }

    public void lq(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.dqg != null) {
            this.dqg.lE(i);
        }
    }

    public void g(l lVar) {
        SignData signData;
        ForumData aVq;
        if (lVar != null && lVar.aVq() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.dqg != null && (signData = lVar.aVq().getSignData()) != null && (aVq = lVar.aVq()) != null) {
                this.dqg.a(aVq, lVar);
                this.dqg.lE(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.dqg.avJ()) {
                    a(this.dqg, signData);
                    aVq.setCurScore(this.dqi);
                    aVq.setLevelupScore(this.dqh);
                    this.dqg.a(aVq, lVar);
                }
            }
        }
    }

    public boolean avm() {
        if (("normal_page".equals(this.dqj) || "frs_page".equals(this.dqj) || "book_page".equals(this.dqj)) && this.dqg != null) {
            return this.dqg.avm();
        }
        return false;
    }

    public boolean avn() {
        if (("normal_page".equals(this.dqj) || "frs_page".equals(this.dqj) || "book_page".equals(this.dqj)) && this.dqg != null) {
            return this.dqg.avn();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void fX(boolean z) {
        if (this.dmW != null) {
            l apE = this.dmW.apE();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.dmW.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.k.login_to_use), true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_INITED)));
            } else if (apE != null && apE.aVq() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.dmW.getFrom())) {
                    TiebaStatic.log(new al("c10356").ac(ImageViewerConfig.FORUM_ID, apE.aVq().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.dmW.getFrom())) {
                    TiebaStatic.log(new al("c10590").r("obj_type", 2).ac(ImageViewerConfig.FORUM_ID, apE.aVq().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.dmW.getFrom())) {
                    TiebaStatic.log(new al("c10587").r("obj_type", 2).ac(ImageViewerConfig.FORUM_ID, apE.aVq().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.dmW.getFrom())) {
                    TiebaStatic.log(new al("c10578").r("obj_type", 2).ac(ImageViewerConfig.FORUM_ID, apE.aVq().getId()));
                }
                this.bmW.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.dmW.getFrom())) {
                    TiebaStatic.eventStat(this.dmW.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.dmW.getFrom())) {
                    TiebaStatic.log(new al("c10359").ac(ImageViewerConfig.FORUM_ID, apE.aVq().getId()));
                }
                this.bmW.I(apE.aVq().getName(), apE.aVq().getId(), "FRS");
                this.dqq = z;
            }
        }
    }

    public void avo() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.dmW.apE() != null && this.dmW.apE().aVq() != null && this.dmW.apE().aVq().getName() != null) {
            str = this.dmW.apE().aVq().getName();
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
                l apE = f.this.dmW.apE();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.dmW.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) f.this.getPageContext().getPageActivity(), f.this.getPageContext().getString(d.k.login_to_use), true, 11036)));
                } else if (apE != null && apE.aVq() != null) {
                    f.this.dqn.t(apE.aVq().getName(), com.baidu.adp.lib.g.b.c(apE.aVq().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(d.k.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).tD();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void avp() {
        l apE = this.dmW.apE();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.dmW.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.k.login_to_use), true, 11014)));
        } else if (apE != null && apE.aVq() != null) {
            FrsActivityStatic.forumName = apE.aVq().getName() == null ? "" : apE.aVq().getName();
            CustomMessage customMessage = new CustomMessage(2001425, apE.aVq());
            customMessage.setTag(this.dqu);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mu(String str) {
        if (this.dmW.aph() != null && this.dmW.aph().auc() != null) {
            com.baidu.tieba.tbadkCore.c.bpQ().T(com.baidu.tieba.tbadkCore.c.bpQ().d(str, this.dmW.aph().auc().Rl(), this.dmW.aph().auc().getIsGood(), this.dmW.aph().auc().getCategoryId()), false);
        }
    }

    private void PY() {
        this.bmW = new LikeModel(this.dmW.getPageContext());
        this.bmW.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                com.baidu.tieba.tbadkCore.r rVar;
                l apE = f.this.dmW.apE();
                if (apE != null && apE.aVq() != null && obj != null) {
                    if (AntiHelper.tt(f.this.bmW.getErrorCode())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.bmW.getBlockPopInfoData(), f.this.dqw) != null) {
                            TiebaStatic.log(new al("c12534").r("obj_locate", ar.a.ajh));
                            return;
                        }
                        return;
                    }
                    String name = apE.aVq().getName();
                    String id = apE.aVq().getId();
                    boolean z = false;
                    if (!(obj instanceof com.baidu.tieba.tbadkCore.r)) {
                        rVar = null;
                    } else {
                        rVar = (com.baidu.tieba.tbadkCore.r) obj;
                    }
                    if (rVar != null && f.this.bmW.getErrorCode() == 0) {
                        z = true;
                    }
                    if (rVar == null || !z) {
                        if (f.this.bmW.getErrorCode() == 22) {
                            f.this.dmW.showToast(f.this.getPageContext().getString(d.k.had_liked_forum));
                        } else {
                            f.this.dmW.showToast(f.this.bmW.getErrorString());
                        }
                    } else {
                        f.this.mu(name);
                        rVar.setLike(1);
                        apE.c(rVar);
                        apE.dj(rVar.bpV());
                        f.this.a(apE, f.this.dqq);
                        f.this.dqq = true;
                        f.this.dmW.showToast(f.this.getPageContext().getResources().getString(d.k.attention_success));
                        f.this.h(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                    }
                    f.this.dmW.S(Boolean.valueOf(z));
                }
            }
        });
    }

    private void avq() {
        this.dqn = new w();
        this.dqn.setFrom("from_frs");
        this.dqn.a(new w.a() { // from class: com.baidu.tieba.frs.vc.f.3
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void m(String str, long j) {
                l apE = f.this.dmW.apE();
                if (apE != null && apE.aVq() != null) {
                    String name = apE.aVq().getName();
                    String id = apE.aVq().getId();
                    if (j == com.baidu.adp.lib.g.b.c(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.mu(str);
                        apE.aVq().setLike(0);
                        f.this.lo(0);
                        f.this.dmW.R(true);
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
        com.baidu.tieba.im.settingcache.d.aGW().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void A(int i, int i2, int i3) {
        l apE;
        if (i > 0 && i2 > 0 && (apE = this.dmW.apE()) != null && apE.aVq() != null && apE.getSignData() != null) {
            ForumData aVq = apE.aVq();
            SignData signData = apE.getSignData();
            signData.levelup_score = aVq.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            apE.d(signData);
            signData.forumId = aVq.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
            int i4 = -1;
            if (avn()) {
                i4 = aVq.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(aVq.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void arq() {
        if (this.dqg != null) {
            this.dqg.arq();
        }
    }

    public static boolean h(l lVar) {
        if (lVar != null) {
            return (lVar.bqu() == null || StringUtils.isNull(lVar.bqu().qA(), true) || lVar.bqu().qA().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean i(l lVar) {
        if (lVar != null) {
            return ((lVar.bqc() == null || lVar.bqc().bqM() != 1) && lVar.bqt() == null && (lVar.bqd() == null || v.w(lVar.bqd().qz())) && ((lVar.aVq() == null || lVar.aVq().getFrsBannerData() == null || lVar.aVq().getFrsBannerData().getType() != 2) && (lVar.bqv() == null || StringUtils.isNull(lVar.bqv().qG(), true)))) ? false : true;
        }
        return false;
    }

    public void lr(int i) {
        View findViewById;
        if (this.dqg != null && this.dqg.avL() != null && (findViewById = this.dqg.avL().findViewById(d.g.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.dqr != null) {
            this.dqr.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.dqv = frsTabViewController;
    }
}
