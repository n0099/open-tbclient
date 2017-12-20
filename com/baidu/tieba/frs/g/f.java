package com.baidu.tieba.frs.g;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.SignMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.tbadkCore.q;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private LikeModel bZt;
    com.baidu.tieba.frs.entelechy.b.b cHy;
    private final View.OnClickListener cIJ;
    private com.baidu.tieba.frs.g cOx;
    private BdTypeListView cRQ;
    private com.baidu.tieba.frs.view.c daN;
    private int daO;
    private int daP;
    private String daQ;
    private Runnable daR;
    private int daS;
    private boolean daT;
    private w daU;
    private boolean daV;
    private com.baidu.tieba.frs.entelechy.b.a daW;
    private boolean daX;
    private com.baidu.tieba.e.a daY;
    private AntiHelper.a daZ;
    private CustomMessageListener dba;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(com.baidu.tieba.frs.g gVar, com.baidu.tieba.frs.entelechy.b.a aVar) {
        super(gVar.getPageContext());
        this.cRQ = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.daQ = null;
        this.daT = false;
        this.bZt = null;
        this.daU = null;
        this.daV = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.g.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.ahN));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.ahN));
            }
        };
        this.daZ = new AntiHelper.a() { // from class: com.baidu.tieba.frs.g.f.3
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.ahP));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.ahP));
            }
        };
        this.dba = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.g.f.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SignData signData;
                boolean z;
                int i;
                k alE = f.this.cOx.alE();
                if (alE != null && alE.aRn() != null && alE.aRn().getName() != null && alE.aRn().getName().equals(FrsActivityStatic.forumName)) {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name = alE.aRn().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.uB(signMessage.mSignErrorCode) && signMessage.signData != null) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener) != null) {
                            TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.ahN));
                            return;
                        }
                        return;
                    }
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(alE.aRn().getId())) {
                            f.this.lG(name);
                            alE.d(signData2);
                            signData2.forumId = alE.aRn().getId();
                            signData2.forumName = alE.aRn().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = alE.aRn().getUser_level();
                        if (f.this.aqW()) {
                            i = alE.aRn().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (AntiHelper.uB(signMessage.mSignErrorCode)) {
                            AntiHelper.am(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                            return;
                        } else if (!f.this.aqU()) {
                            f.this.cOx.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                            return;
                        } else {
                            f.this.cOx.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                            return;
                        }
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.lb(1);
                    }
                    f.this.cOx.showToast(signMessage.mSignErrorString);
                }
            }
        };
        this.cIJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k alE = f.this.cOx.alE();
                if (alE != null && alE.aRn() != null && f.this.daN != null && (view == f.this.daN.ari() || view == f.this.daN.arj() || view == f.this.daN.ark())) {
                    if (f.this.cOx != null && alE.aRn() != null) {
                        TiebaStatic.log(new ak("c12046").ac(ImageViewerConfig.FORUM_ID, alE.aRn().getId()).r("obj_locate", f.this.cOx.alG() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), alE.aRn().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == d.g.tv_love) {
                    if (!f.this.cOx.alF() && j.hh()) {
                        if (!ax.aS(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new ak("c10517").r("obj_locate", 1).ac(ImageViewerConfig.FORUM_ID, f.this.cOx.getForumId()));
                        } else {
                            f.this.fD(true);
                        }
                    }
                } else if (id == d.g.tv_sign) {
                    if (!f.this.cOx.alF() && j.hh() && ax.aS(f.this.mContext.getPageActivity())) {
                        if (!f.this.aqV()) {
                            f.this.aqY();
                        } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(f.this.cOx.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.g(f.this.cOx.getForumId(), 0), 24002)));
                        }
                    }
                } else if (id == d.g.frs_header_games) {
                    if (ax.aS(f.this.mContext.getPageActivity()) && alE != null && alE.bve() != null) {
                        String bve = alE.bve();
                        if (m.dD(bve) == 3) {
                            m.a(f.this.cOx.getPageContext(), bve);
                        } else {
                            av.vI().a((TbPageContext) f.this.getPageContext(), new String[]{bve}, true);
                        }
                    }
                } else if (id == d.g.frs_bawu_center) {
                    if (alE != null && alE.getUserData() != null && alE.getUserData().isBawu()) {
                        String bvl = alE.bvl();
                        if (!am.isEmpty(bvl)) {
                            com.baidu.tbadk.browser.a.O(f.this.getPageContext().getPageActivity(), bvl);
                            if (alE.aRn() != null) {
                                TiebaStatic.log(new ak("c10502").ac(ImageViewerConfig.FORUM_ID, alE.aRn().getId()).ac("uid", alE.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == d.g.level_container && !f.this.cOx.alF() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page")) && f.this.daN != null) {
                        f.this.daN.h(view, false);
                    }
                }
            }
        };
        this.cOx = gVar;
        this.daW = aVar;
        if (this.daW != null) {
            this.cHy = this.daW.anh();
        }
        this.daY = new com.baidu.tieba.e.a();
        this.daY.a(new a.InterfaceC0097a() { // from class: com.baidu.tieba.frs.g.f.5
            @Override // com.baidu.tieba.e.a.InterfaceC0097a
            public void ag(int i, int i2) {
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0097a
            public void ah(int i, int i2) {
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0097a
            public void ai(int i, int i2) {
            }
        });
    }

    public void k(Bundle bundle) {
        this.cOx.registerListener(this.dba);
        akn();
        aqZ();
        this.daT = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.daN != null) {
            this.daN.onDestory();
        }
        if (this.bZt != null) {
            this.bZt.bwh();
        }
        if (this.daR != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.daR);
        }
    }

    public void onActivityStop() {
        if (this.daN != null) {
            this.daN.onStop();
        }
    }

    public void fB(boolean z) {
        if (this.daN != null) {
            this.daN.fB(z);
        }
    }

    public boolean kX(int i) {
        this.mSkinType = i;
        if (this.daN != null) {
            this.daN.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void d(BdTypeListView bdTypeListView) {
        this.cRQ = bdTypeListView;
    }

    public void fC(boolean z) {
        if (z) {
            if (this.daN != null) {
                this.cRQ.removeHeaderView(this.daN.arh());
                this.daV = false;
            }
        } else if (this.daN != null && this.daN.arh() != null && !this.daV) {
            this.cRQ.addHeaderView(this.daN.arh(), this.cRQ.getHeaderViewsCount());
            this.daV = true;
        }
    }

    public void a(String str, k kVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) && kVar != null && kVar.getUserData() != null && kVar.aRn() != null) {
            f(str, kVar.getUserData().getIsMem(), kVar.aRn().isLike());
        }
    }

    public void f(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.daQ, str);
        this.daS = i2;
        this.daQ = str;
        aqQ();
        if (this.daN == null || z) {
            this.daN = this.daW.a(str, this.cOx, i);
            this.daN.changeSkinType(this.mSkinType);
            this.daN.setCommonClickListener(this.cIJ);
        }
        this.cRQ.addHeaderView(this.daN.getView());
        if (this.cHy != null) {
            this.cHy.a(this.cRQ, this.daN);
        }
        int f = l.f(TbadkCoreApplication.getInst(), d.e.tbds44);
        this.daN.p(0, f, 0, f);
        aqR();
    }

    public void aqP() {
        if (!this.daV && this.daN != null) {
            this.cRQ.addHeaderView(this.daN.arh());
            this.daV = true;
        }
    }

    private void aqQ() {
        if (("normal_page".equals(this.daQ) || "frs_page".equals(this.daQ) || "book_page".equals(this.daQ)) && this.daN != null) {
            this.cRQ.removeHeaderView(this.daN.getView());
            this.cRQ.removeHeaderView(this.daN.arh());
        }
        this.daV = false;
    }

    private void aqR() {
        if (this.daR == null) {
            this.daR = new Runnable() { // from class: com.baidu.tieba.frs.g.f.6
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0 && f.this.cRQ.isRefreshDone() && f.this.cRQ.isShown() && f.this.cOx.isPrimary() && !f.this.daT && f.this.daS == 1 && f.this.cOx.aln() != null && f.this.cOx.aln().alN() != null && !f.this.cOx.aln().alN().anW()) {
                        if (("frs_page".equals(f.this.daQ) || "normal_page".equals(f.this.daQ) || "book_page".equals(f.this.daQ)) && f.this.daN != null && f.this.daN.arg()) {
                            TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                            f.this.anu();
                            f.this.cOx.cGX = true;
                            f.this.daT = true;
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.fP().postDelayed(this.daR, 4000L);
    }

    public void g(k kVar) {
        if (kVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(kVar.aRn(), kVar);
            }
        }
    }

    public void b(ForumData forumData, k kVar) {
        if (forumData != null && kVar != null) {
            float a = a(forumData);
            if (this.daN != null) {
                this.daN.a(forumData, kVar);
                this.daN.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.daN.lj(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.daN.fF(false);
                        return;
                    }
                    this.daN.fF(true);
                    this.daN.lj(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.daO = forumData.getLevelupScore();
        this.daP = forumData.getCurScore();
        if (this.daO > 0) {
            return this.daP / this.daO;
        }
        return 0.0f;
    }

    public void kY(int i) {
        if (i > 1) {
            if (this.daN != null) {
                this.daN.fG(false);
            }
        } else if (this.daN != null) {
            this.daN.fG(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void f(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            aqS();
        }
    }

    public void setIsMem(int i) {
        if (this.daN != null) {
            this.daN.setMemberType(i);
        }
    }

    public void anu() {
        if (("normal_page".equals(this.daQ) || "frs_page".equals(this.daQ) || "book_page".equals(this.daQ)) && this.daN != null) {
            this.daN.anu();
        }
    }

    public void aqS() {
        if (this.daN != null) {
            this.daN.anw();
        }
    }

    public void a(k kVar, boolean z) {
        if (kVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, kVar.aRn(), kVar, z);
            }
        }
    }

    public void aqT() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            la(0);
        }
    }

    public void kZ(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            la(i);
        }
    }

    public void la(int i) {
        if (this.daN != null) {
            this.daN.li(i);
        }
    }

    public void a(int i, ForumData forumData, k kVar, boolean z) {
        if (this.daN != null) {
            this.daN.a(forumData, kVar);
            if (forumData != null) {
                this.daN.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.daN.fF(false);
                }
            }
        }
    }

    public boolean aqU() {
        if (("normal_page".equals(this.daQ) || "frs_page".equals(this.daQ) || "book_page".equals(this.daQ)) && this.daN != null) {
            return this.daN.arf();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.c cVar, SignData signData) {
        if (cVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.daO - this.daP) {
                z = true;
                this.daO = signData.levelup_score;
            }
            this.daP = i + this.daP;
            if (this.daP > this.daO) {
                this.daP = this.daO;
            }
            if (this.daO != 0) {
                f = this.daP / this.daO;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            cVar.c(z, f);
        }
    }

    public void lb(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.daN != null) {
            this.daN.lj(i);
        }
    }

    public void h(k kVar) {
        SignData signData;
        ForumData aRn;
        if (kVar != null && kVar.aRn() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.daN != null && (signData = kVar.aRn().getSignData()) != null && (aRn = kVar.aRn()) != null) {
                this.daN.a(aRn, kVar);
                this.daN.lj(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.daN.arf()) {
                    a(this.daN, signData);
                    aRn.setCurScore(this.daP);
                    aRn.setLevelupScore(this.daO);
                    this.daN.a(aRn, kVar);
                }
            }
        }
    }

    public boolean aqV() {
        if (("normal_page".equals(this.daQ) || "frs_page".equals(this.daQ) || "book_page".equals(this.daQ)) && this.daN != null) {
            return this.daN.aqV();
        }
        return false;
    }

    public boolean aqW() {
        if (("normal_page".equals(this.daQ) || "frs_page".equals(this.daQ) || "book_page".equals(this.daQ)) && this.daN != null) {
            return this.daN.aqW();
        }
        return false;
    }

    public void fD(boolean z) {
        if (this.cOx != null) {
            k alE = this.cOx.alE();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.cOx.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_INITED)));
            } else if (alE != null && alE.aRn() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.cOx.getFrom())) {
                    TiebaStatic.log(new ak("c10356").ac(ImageViewerConfig.FORUM_ID, alE.aRn().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.cOx.getFrom())) {
                    TiebaStatic.log(new ak("c10590").r("obj_type", 2).ac(ImageViewerConfig.FORUM_ID, alE.aRn().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.cOx.getFrom())) {
                    TiebaStatic.log(new ak("c10587").r("obj_type", 2).ac(ImageViewerConfig.FORUM_ID, alE.aRn().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.cOx.getFrom())) {
                    TiebaStatic.log(new ak("c10578").r("obj_type", 2).ac(ImageViewerConfig.FORUM_ID, alE.aRn().getId()));
                }
                this.bZt.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.cOx.getFrom())) {
                    TiebaStatic.eventStat(this.cOx.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.cOx.getFrom())) {
                    TiebaStatic.log(new ak("c10359").ac(ImageViewerConfig.FORUM_ID, alE.aRn().getId()));
                }
                this.bZt.H(alE.aRn().getName(), alE.aRn().getId(), "FRS");
                this.daX = z;
            }
        }
    }

    public void aqX() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.cOx.alE() != null && this.cOx.alE().aRn() != null && this.cOx.alE().aRn().getName() != null) {
            str = this.cOx.alE().aRn().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cS(String.format(getPageContext().getString(d.j.attention_cancel_dialog_content), str));
        } else {
            aVar.cS(getPageContext().getString(d.j.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(d.j.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.g.f.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                k alE = f.this.cOx.alE();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.cOx.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) f.this.getPageContext().getPageActivity(), f.this.getPageContext().getString(d.j.login_to_use), true, 11036)));
                } else if (alE != null && alE.aRn() != null) {
                    f.this.daU.u(alE.aRn().getName(), com.baidu.adp.lib.g.b.c(alE.aRn().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(d.j.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.g.f.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).th();
    }

    public void aqY() {
        k alE = this.cOx.alE();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.cOx.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, 11014)));
        } else if (alE != null && alE.aRn() != null) {
            FrsActivityStatic.forumName = alE.aRn().getName() == null ? "" : alE.aRn().getName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, alE.aRn()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lG(String str) {
        if (this.cOx.ali() != null && this.cOx.ali().apP() != null) {
            com.baidu.tieba.tbadkCore.c.buJ().Z(com.baidu.tieba.tbadkCore.c.buJ().d(str, this.cOx.ali().apP().Qt(), this.cOx.ali().apP().getIsGood(), this.cOx.ali().apP().getCategoryId()), false);
        }
    }

    private void akn() {
        this.bZt = new LikeModel(this.cOx.getPageContext());
        this.bZt.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.g.f.10
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                q qVar;
                k alE = f.this.cOx.alE();
                if (alE != null && alE.aRn() != null && obj != null) {
                    if (AntiHelper.uB(f.this.bZt.getErrorCode())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.bZt.getBlockPopInfoData(), f.this.daZ) != null) {
                            TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.ahP));
                            return;
                        }
                        return;
                    }
                    String name = alE.aRn().getName();
                    String id = alE.aRn().getId();
                    boolean z = false;
                    if (!(obj instanceof q)) {
                        qVar = null;
                    } else {
                        qVar = (q) obj;
                    }
                    if (qVar != null && f.this.bZt.getErrorCode() == 0) {
                        z = true;
                    }
                    if (qVar == null || !z) {
                        if (f.this.bZt.getErrorCode() == 22) {
                            f.this.cOx.showToast(f.this.getPageContext().getString(d.j.had_liked_forum));
                        } else {
                            f.this.cOx.showToast(f.this.bZt.getErrorString());
                        }
                    } else {
                        f.this.lG(name);
                        qVar.setLike(1);
                        alE.c(qVar);
                        alE.dx(qVar.buM());
                        f.this.a(alE, f.this.daX);
                        f.this.daX = true;
                        f.this.cOx.showToast(f.this.getPageContext().getResources().getString(d.j.attention_success));
                        f.this.f(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, qVar));
                    }
                    f.this.cOx.R(Boolean.valueOf(z));
                }
            }
        });
    }

    private void aqZ() {
        this.daU = new w();
        this.daU.setFrom("from_frs");
        this.daU.a(new w.a() { // from class: com.baidu.tieba.frs.g.f.2
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void n(String str, long j) {
                k alE = f.this.cOx.alE();
                if (alE != null && alE.aRn() != null) {
                    String name = alE.aRn().getName();
                    String id = alE.aRn().getId();
                    if (j == com.baidu.adp.lib.g.b.c(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.lG(str);
                        alE.aRn().setLike(0);
                        f.this.kZ(0);
                        f.this.cOx.Q(true);
                        f.this.f(false, id);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, id));
                        q qVar = new q();
                        qVar.setLike(0);
                        qVar.setFid(id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, qVar));
                    }
                }
            }

            @Override // com.baidu.tieba.tbadkCore.w.a
            public void o(String str, long j) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.aDh().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void C(int i, int i2, int i3) {
        k alE;
        if (i > 0 && i2 > 0 && (alE = this.cOx.alE()) != null && alE.aRn() != null && alE.getSignData() != null) {
            ForumData aRn = alE.aRn();
            SignData signData = alE.getSignData();
            signData.levelup_score = aRn.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            alE.d(signData);
            signData.forumId = aRn.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            int i4 = -1;
            if (aqW()) {
                i4 = aRn.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(aRn.getName(), signData.sign_bonus_point, i4);
        }
    }

    public int ara() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            if (this.daN != null && this.daN.arh() != null && this.daN.arh().getParent() != null) {
                return this.cRQ.getHeaderViewsCount() - 2;
            }
            return this.cRQ.getHeaderViewsCount() - 1;
        }
        return 0;
    }

    public void ang() {
        if (this.daN != null) {
            this.daN.ang();
        }
    }

    public static boolean i(k kVar) {
        if (kVar != null) {
            return (kVar.bvp() == null || StringUtils.isNull(kVar.bvp().pK(), true) || kVar.bvp().pK().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean j(k kVar) {
        if (kVar != null) {
            return ((kVar.buU() == null || kVar.buU().bvF() != 1) && kVar.bvo() == null && (kVar.buV() == null || v.w(kVar.buV().pJ())) && ((kVar.aRn() == null || kVar.aRn().getFrsBannerData() == null || kVar.aRn().getFrsBannerData().getType() != 2) && (kVar.bvq() == null || StringUtils.isNull(kVar.bvq().pR(), true)))) ? false : true;
        }
        return false;
    }

    public void lc(int i) {
        View findViewById;
        if (this.daN != null && this.daN.arh() != null && (findViewById = this.daN.arh().findViewById(d.g.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.daY != null) {
            this.daY.onTouchEvent(motionEvent);
        }
    }
}
