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
import com.baidu.adp.lib.util.l;
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
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.tbadkCore.s;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.x;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private LikeModel ccX;
    private final View.OnClickListener dFV;
    private FrsHeaderViewContainer dGq;
    private com.baidu.tieba.frs.i dSO;
    private CustomMessageListener dVA;
    private Runnable dVB;
    private com.baidu.tieba.frs.view.c dVk;
    private int dVl;
    private int dVm;
    private String dVn;
    private Runnable dVo;
    private int dVp;
    private boolean dVq;
    private x dVr;
    private boolean dVs;
    private com.baidu.tieba.frs.entelechy.b.a dVt;
    private boolean dVu;
    private com.baidu.tieba.e.a dVv;
    private boolean dVw;
    private com.baidu.tieba.frs.c.a.a dVx;
    private BdUniqueId dVy;
    private AntiHelper.a dVz;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(com.baidu.tieba.frs.i iVar, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(iVar.getPageContext());
        this.dGq = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.dVn = null;
        this.dVq = false;
        this.ccX = null;
        this.dVr = null;
        this.dVs = false;
        this.dVw = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.g.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12536").s("obj_locate", aq.a.aXB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12535").s("obj_locate", aq.a.aXB));
            }
        };
        this.dVz = new AntiHelper.a() { // from class: com.baidu.tieba.frs.g.f.4
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12536").s("obj_locate", aq.a.aXD));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12535").s("obj_locate", aq.a.aXD));
            }
        };
        this.dVA = new CustomMessageListener(2001425) { // from class: com.baidu.tieba.frs.g.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SignData signData;
                boolean z;
                int i;
                m avl = f.this.dSO.avl();
                if (avl != null && avl.bas() != null && avl.bas().getName() != null && avl.bas().getName().equals(FrsActivityStatic.forumName)) {
                    if (customResponsedMessage == null || customResponsedMessage.getOrginalMessage().getTag() == f.this.dVy) {
                        TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_end_time", System.currentTimeMillis() + "");
                        String name = avl.bas().getName();
                        SignMessage signMessage = (SignMessage) customResponsedMessage;
                        if (AntiHelper.vR(signMessage.mSignErrorCode) && signMessage.signData != null) {
                            if (AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener) != null) {
                                TiebaStatic.log(new ak("c12534").s("obj_locate", aq.a.aXB));
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
                            if (f.this.aAr()) {
                                i = avl.bas().getUser_level();
                                if (user_level >= i) {
                                    i++;
                                }
                            } else {
                                i = user_level;
                            }
                            TbadkCoreApplication.getInst().addSignedForum(name, signData.sign_bonus_point, i);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                            if (AntiHelper.vR(signMessage.mSignErrorCode)) {
                                AntiHelper.ar(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                                return;
                            } else if (signData.mContriInfo != null && signData.mContriInfo.isShowToast()) {
                                f.this.dSO.a(signData.mContriInfo);
                                return;
                            } else if (!f.this.aAp()) {
                                f.this.dSO.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                                return;
                            } else {
                                f.this.dSO.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                                return;
                            }
                        }
                        if (signMessage.mSignErrorCode == 160002) {
                            f.this.nR(1);
                        }
                        f.this.dSO.showToast(signMessage.mSignErrorString);
                    }
                }
            }
        };
        this.dVB = new Runnable() { // from class: com.baidu.tieba.frs.g.f.8
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.dGq != null) {
                    int childCount = f.this.dGq.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(f.this.dGq.getChildAt(i));
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
        this.dFV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m avl = f.this.dSO.avl();
                if (avl != null && avl.bas() != null && f.this.dVk != null && (view == f.this.dVk.aAR() || view == f.this.dVk.aAS() || view == f.this.dVk.aAT())) {
                    if (f.this.dSO != null && avl.bas() != null) {
                        TiebaStatic.log(new ak("c12046").ab(ImageViewerConfig.FORUM_ID, avl.bas().getId()).s("obj_locate", f.this.dSO.avn() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), avl.bas().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == d.g.tv_love) {
                    if (!f.this.dSO.avm()) {
                        if (!com.baidu.adp.lib.util.j.oJ()) {
                            f.this.dSO.showToast(d.j.neterror);
                        } else if (!ay.ba(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new ak("c10517").s("obj_locate", 1).ab(ImageViewerConfig.FORUM_ID, f.this.dSO.getForumId()));
                        } else {
                            f.this.gv(true);
                        }
                    }
                } else if (id == d.g.tv_sign) {
                    if (!f.this.dSO.avm()) {
                        if (!com.baidu.adp.lib.util.j.oJ()) {
                            f.this.dSO.showToast(d.j.neterror);
                        } else if (ay.ba(f.this.mContext.getPageActivity())) {
                            if (!f.this.aAq()) {
                                f.this.aAt();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(f.this.dSO.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.h(f.this.dSO.getForumId(), 0), 24002)));
                            }
                        }
                    }
                } else if (id == d.g.frs_header_games) {
                    if (ay.ba(f.this.mContext.getPageActivity()) && avl != null && avl.bvg() != null) {
                        aw.Du().a((TbPageContext) f.this.getPageContext(), new String[]{avl.bvg()}, true);
                    }
                } else if (id == d.g.frs_bawu_center) {
                    if (avl != null && avl.getUserData() != null && avl.getUserData().isBawu()) {
                        String bvn = avl.bvn();
                        if (!am.isEmpty(bvn)) {
                            com.baidu.tbadk.browser.b.R(f.this.getPageContext().getPageActivity(), bvn);
                            if (avl.bas() != null) {
                                TiebaStatic.log(new ak("c10502").ab(ImageViewerConfig.FORUM_ID, avl.bas().getId()).ab("uid", avl.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == d.g.level_container && !f.this.dSO.avm() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page")) && f.this.dVk != null) {
                        f.this.dVk.p(view, false);
                    }
                }
            }
        };
        this.dSO = iVar;
        this.dVt = aVar;
        this.dGq = frsHeaderViewContainer;
        this.dVx = new com.baidu.tieba.frs.c.a(iVar.akO());
        this.dVy = BdUniqueId.gen();
        this.dVv = new com.baidu.tieba.e.a();
        this.dVv.a(new a.InterfaceC0143a() { // from class: com.baidu.tieba.frs.g.f.6
            @Override // com.baidu.tieba.e.a.InterfaceC0143a
            public void aY(int i, int i2) {
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0143a
            public void aZ(int i, int i2) {
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0143a
            public void ba(int i, int i2) {
            }
        });
    }

    public void o(Bundle bundle) {
        this.dSO.registerListener(this.dVA);
        Xy();
        aAu();
        this.dVq = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.dVk != null) {
            this.dVk.onDestory();
        }
        if (this.ccX != null) {
            this.ccX.bwp();
        }
        if (this.dVo != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.dVo);
        }
    }

    public void onActivityStop() {
        if (this.dVk != null) {
            this.dVk.onStop();
        }
        if (this.dGq != null) {
            this.dGq.removeCallbacks(this.dVB);
        }
    }

    public void gt(boolean z) {
        if (this.dVk != null) {
            this.dVk.gt(z);
        }
    }

    public boolean nN(int i) {
        this.mSkinType = i;
        if (this.dVk != null) {
            this.dVk.changeSkinType(i);
        }
        if (this.dVx != null) {
            this.dVx.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    public void gu(boolean z) {
        if (z) {
            if (this.dVk != null) {
                this.dGq.removeHeaderView(this.dVk.aAP());
                this.dVs = false;
            }
        } else if (this.dVk != null && this.dVk.aAP() != null && !this.dVs) {
            this.dGq.addHeaderView(this.dVk.aAP(), this.dGq.getHeaderViewsCount());
            this.dVs = true;
        }
    }

    public void a(String str, m mVar) {
        this.mPageType = str;
        if ("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) {
            if (mVar != null && mVar.buX() != null && mVar.buX().xS() != null && mVar.buX().xS().size() >= 1) {
                a(mVar.buX().xS().get(0), false, false);
            } else if (mVar != null && mVar.buV() != null && !StringUtils.isNull(mVar.buV().bvN())) {
                q qVar = new q();
                qVar.setLinkUrl("");
                qVar.setImageUrl(mVar.buV().bvN());
                a(qVar, true, mVar.bvI() != null && mVar.bvI().getType() == 1);
            } else {
                this.dVw = false;
                if (this.dGq != null && this.dVx != null && this.dVx.getHeaderView() != null) {
                    this.dGq.removeHeaderView(this.dVx.getHeaderView());
                }
            }
            if (mVar != null && mVar.getUserData() != null && mVar.bas() != null) {
                m(str, mVar.getUserData().getIsMem(), mVar.bas().isLike());
            }
        }
    }

    public boolean aAi() {
        return this.dVw;
    }

    private void a(q qVar, boolean z, boolean z2) {
        if (qVar == null) {
            this.dVw = false;
        } else if (this.dGq == null || this.dVx == null || this.dVx.getHeaderView() == null) {
            this.dVw = false;
        } else {
            this.dVw = true;
            this.dGq.removeHeaderView(this.dVx.getHeaderView());
            this.dGq.addHeaderView(this.dVx.getHeaderView());
            this.dVx.hB(qVar.getImageUrl());
            this.dVx.setTitle(qVar.getTitle());
            this.dVx.setSchemaUrl(qVar.getLinkUrl());
            this.dVx.gp(z2);
            if (z) {
                this.dVx.hideTitle();
            }
        }
    }

    public void m(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.dVn, str);
        this.dVp = i2;
        this.dVn = str;
        aAk();
        if (this.dVk == null || z) {
            this.dVk = this.dVt.a(str, this.dSO, i);
            this.dVk.changeSkinType(this.mSkinType);
            this.dVk.l(this.dFV);
        }
        this.dGq.addHeaderView(this.dVk.getView());
        int t = l.t(TbadkCoreApplication.getInst(), d.e.tbds44);
        this.dVk.x(0, t, 0, t);
        aAl();
    }

    public void aAj() {
        if (!this.dVs && this.dVk != null) {
            this.dGq.addHeaderView(this.dVk.aAP());
            if (this.dVk.aAQ() != null && this.dSO.Ez() != null) {
                this.dSO.Ez().addHeaderView(this.dVk.aAQ(), 0);
            }
            this.dVs = true;
        }
    }

    private void aAk() {
        if (("normal_page".equals(this.dVn) || "frs_page".equals(this.dVn) || "book_page".equals(this.dVn)) && this.dVk != null) {
            this.dGq.removeHeaderView(this.dVk.getView());
            this.dGq.removeHeaderView(this.dVk.aAP());
            if (this.dVk.aAQ() != null && this.dSO.Ez() != null) {
                this.dSO.Ez().removeHeaderView(this.dVk.aAQ());
            }
        }
        this.dVs = false;
    }

    private void aAl() {
        if (this.dVo == null) {
            this.dVo = new Runnable() { // from class: com.baidu.tieba.frs.g.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.dSO.auT() == null || !f.this.dSO.auT().avm()) && f.this.dGq.isShown() && f.this.dSO.isPrimary() && !f.this.dVq && f.this.dVp == 1 && f.this.dSO.auT() != null && f.this.dSO.auT().avH() != null && !f.this.dSO.auT().avH().axF() && !f.this.dSO.avq()) {
                            if (("frs_page".equals(f.this.dVn) || "normal_page".equals(f.this.dVn) || "book_page".equals(f.this.dVn)) && f.this.dVk != null && f.this.dVk.aAO()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.axh();
                                f.this.dSO.dEc = true;
                                f.this.dVq = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.ns().postDelayed(this.dVo, 4000L);
    }

    public void f(m mVar) {
        if (mVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(mVar.bas(), mVar);
            }
        }
    }

    public void b(ForumData forumData, m mVar) {
        if (forumData != null && mVar != null) {
            float a = a(forumData);
            if (this.dVk != null) {
                this.dVk.a(forumData, mVar);
                this.dVk.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.dVk.oe(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.dVk.gB(false);
                        return;
                    }
                    this.dVk.gB(true);
                    this.dVk.oe(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.dVl = forumData.getLevelupScore();
        this.dVm = forumData.getCurScore();
        if (this.dVl > 0) {
            return this.dVm / this.dVl;
        }
        return 0.0f;
    }

    public void nO(int i) {
        if (i > 1) {
            if (this.dVk != null) {
                this.dVk.gC(false);
            }
        } else if (this.dVk != null) {
            this.dVk.gC(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void aAm() {
        if (this.dGq != null) {
            this.dGq.removeCallbacks(this.dVB);
            this.dGq.postDelayed(this.dVB, 100L);
        }
    }

    public void f(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            aAn();
        }
    }

    public void setIsMem(int i) {
        if (this.dVk != null) {
            this.dVk.setMemberType(i);
        }
    }

    public void axh() {
        if (("normal_page".equals(this.dVn) || "frs_page".equals(this.dVn) || "book_page".equals(this.dVn)) && this.dVk != null) {
            this.dVk.axh();
        }
    }

    public void aAn() {
        if (this.dVk != null) {
            this.dVk.axj();
        }
    }

    public void a(m mVar, boolean z) {
        if (mVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, mVar.bas(), mVar, z);
            }
        }
    }

    public void aAo() {
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
        if (this.dVk != null) {
            this.dVk.od(i);
        }
    }

    public void a(int i, ForumData forumData, m mVar, boolean z) {
        if (this.dVk != null) {
            this.dVk.a(forumData, mVar);
            if (forumData != null) {
                this.dVk.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.dVk.gB(false);
                }
            }
        }
    }

    public boolean aAp() {
        if (("normal_page".equals(this.dVn) || "frs_page".equals(this.dVn) || "book_page".equals(this.dVn)) && this.dVk != null) {
            return this.dVk.aAN();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.c cVar, SignData signData) {
        if (cVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.dVl - this.dVm) {
                z = true;
                this.dVl = signData.levelup_score;
            }
            this.dVm = i + this.dVm;
            if (this.dVm > this.dVl) {
                this.dVm = this.dVl;
            }
            if (this.dVl != 0) {
                f = this.dVm / this.dVl;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            cVar.c(z, f);
        }
    }

    public void nR(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.dVk != null) {
            this.dVk.oe(i);
        }
    }

    public void g(m mVar) {
        SignData signData;
        ForumData bas;
        if (mVar != null && mVar.bas() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.dVk != null && (signData = mVar.bas().getSignData()) != null && (bas = mVar.bas()) != null) {
                this.dVk.a(bas, mVar);
                this.dVk.oe(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.dVk.aAN()) {
                    a(this.dVk, signData);
                    bas.setCurScore(this.dVm);
                    bas.setLevelupScore(this.dVl);
                    this.dVk.a(bas, mVar);
                }
            }
        }
    }

    public boolean aAq() {
        if (("normal_page".equals(this.dVn) || "frs_page".equals(this.dVn) || "book_page".equals(this.dVn)) && this.dVk != null) {
            return this.dVk.aAq();
        }
        return false;
    }

    public boolean aAr() {
        if (("normal_page".equals(this.dVn) || "frs_page".equals(this.dVn) || "book_page".equals(this.dVn)) && this.dVk != null) {
            return this.dVk.aAr();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.i */
    /* JADX WARN: Multi-variable type inference failed */
    public void gv(boolean z) {
        if (this.dSO != null) {
            m avl = this.dSO.avl();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.dSO.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_INITED)));
            } else if (avl != null && avl.bas() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.dSO.getFrom())) {
                    TiebaStatic.log(new ak("c10356").ab(ImageViewerConfig.FORUM_ID, avl.bas().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.dSO.getFrom())) {
                    TiebaStatic.log(new ak("c10590").s("obj_type", 2).ab(ImageViewerConfig.FORUM_ID, avl.bas().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.dSO.getFrom())) {
                    TiebaStatic.log(new ak("c10587").s("obj_type", 2).ab(ImageViewerConfig.FORUM_ID, avl.bas().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.dSO.getFrom())) {
                    TiebaStatic.log(new ak("c10578").s("obj_type", 2).ab(ImageViewerConfig.FORUM_ID, avl.bas().getId()));
                }
                this.ccX.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.dSO.getFrom())) {
                    TiebaStatic.eventStat(this.dSO.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.dSO.getFrom())) {
                    TiebaStatic.log(new ak("c10359").ab(ImageViewerConfig.FORUM_ID, avl.bas().getId()));
                }
                this.ccX.L(avl.bas().getName(), avl.bas().getId(), "FRS");
                this.dVu = z;
            }
        }
    }

    public void aAs() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.dSO.avl() != null && this.dSO.avl().bas() != null && this.dSO.avl().bas().getName() != null) {
            str = this.dSO.avl().bas().getName();
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
                m avl = f.this.dSO.avl();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.dSO.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) f.this.getPageContext().getPageActivity(), f.this.getPageContext().getString(d.j.login_to_use), true, 11036)));
                } else if (avl != null && avl.bas() != null) {
                    f.this.dVr.t(avl.bas().getName(), com.baidu.adp.lib.g.b.c(avl.bas().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(d.j.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.g.f.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).AV();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.i */
    /* JADX WARN: Multi-variable type inference failed */
    public void aAt() {
        m avl = this.dSO.avl();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.dSO.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, 11014)));
        } else if (avl != null && avl.bas() != null) {
            FrsActivityStatic.forumName = avl.bas().getName() == null ? "" : avl.bas().getName();
            CustomMessage customMessage = new CustomMessage(2001425, avl.bas());
            customMessage.setTag(this.dVy);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mr(String str) {
        if (this.dSO.auO() != null && this.dSO.auO().azn() != null) {
            com.baidu.tieba.tbadkCore.c.buI().Y(com.baidu.tieba.tbadkCore.c.buI().d(str, this.dSO.auO().azn().YM(), this.dSO.auO().azn().getIsGood(), this.dSO.auO().azn().getCategoryId()), false);
        }
    }

    private void Xy() {
        this.ccX = new LikeModel(this.dSO.getPageContext());
        this.ccX.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.g.f.2
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                s sVar;
                m avl = f.this.dSO.avl();
                if (avl != null && avl.bas() != null && obj != null) {
                    if (AntiHelper.vR(f.this.ccX.getErrorCode())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.ccX.getBlockPopInfoData(), f.this.dVz) != null) {
                            TiebaStatic.log(new ak("c12534").s("obj_locate", aq.a.aXD));
                            return;
                        }
                        return;
                    }
                    String name = avl.bas().getName();
                    String id = avl.bas().getId();
                    boolean z = false;
                    if (!(obj instanceof s)) {
                        sVar = null;
                    } else {
                        sVar = (s) obj;
                    }
                    if (sVar != null && f.this.ccX.getErrorCode() == 0) {
                        z = true;
                    }
                    if (sVar == null || !z) {
                        if (f.this.ccX.getErrorCode() == 22) {
                            f.this.dSO.showToast(f.this.getPageContext().getString(d.j.had_liked_forum));
                        } else {
                            f.this.dSO.showToast(f.this.ccX.getErrorString());
                        }
                    } else {
                        f.this.mr(name);
                        sVar.setLike(1);
                        avl.c(sVar);
                        avl.ds(sVar.buO());
                        f.this.a(avl, f.this.dVu);
                        f.this.dVu = true;
                        f.this.dSO.showToast(f.this.getPageContext().getResources().getString(d.j.attention_success));
                        f.this.f(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, sVar));
                    }
                    f.this.dSO.aX(Boolean.valueOf(z));
                }
            }
        });
    }

    private void aAu() {
        this.dVr = new x();
        this.dVr.setFrom("from_frs");
        this.dVr.a(new x.a() { // from class: com.baidu.tieba.frs.g.f.3
            @Override // com.baidu.tieba.tbadkCore.x.a
            public void m(String str, long j) {
                m avl = f.this.dSO.avl();
                if (avl != null && avl.bas() != null) {
                    String name = avl.bas().getName();
                    String id = avl.bas().getId();
                    if (j == com.baidu.adp.lib.g.b.c(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.mr(str);
                        avl.bas().setLike(0);
                        f.this.nP(0);
                        f.this.dSO.aW(true);
                        f.this.f(false, id);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003004, id));
                        s sVar = new s();
                        sVar.setLike(0);
                        sVar.setFid(id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, sVar));
                    }
                }
            }

            @Override // com.baidu.tieba.tbadkCore.x.a
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
        m avl;
        if (i > 0 && i2 > 0 && (avl = this.dSO.avl()) != null && avl.bas() != null && avl.getSignData() != null) {
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
            if (aAr()) {
                i4 = bas.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(bas.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void awV() {
        if (this.dVk != null) {
            this.dVk.awV();
        }
    }

    public static boolean h(m mVar) {
        if (mVar != null) {
            return (mVar.bvr() == null || StringUtils.isNull(mVar.bvr().xT(), true) || mVar.bvr().xT().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean i(m mVar) {
        if (mVar != null) {
            return ((mVar.buV() == null || mVar.buV().bvJ() != 1) && mVar.bvq() == null && (mVar.buX() == null || v.E(mVar.buX().xS())) && ((mVar.bas() == null || mVar.bas().getFrsBannerData() == null || mVar.bas().getFrsBannerData().getType() != 2) && (mVar.bvs() == null || StringUtils.isNull(mVar.bvs().ya(), true)))) ? false : true;
        }
        return false;
    }

    public void nS(int i) {
        View findViewById;
        if (this.dVk != null && this.dVk.aAP() != null && (findViewById = this.dVk.aAP().findViewById(d.g.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.dVv != null) {
            this.dVv.onTouchEvent(motionEvent);
        }
    }
}
