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
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.sapi2.SapiAccountManager;
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
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.j;
import com.baidu.tieba.tbadkCore.p;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private LikeModel bRe;
    private com.baidu.tieba.frs.f cEN;
    private BdTypeListView cIb;
    private com.baidu.tieba.frs.view.b cRb;
    private int cRc;
    private int cRd;
    private String cRe;
    private Runnable cRf;
    private int cRg;
    private boolean cRh;
    private v cRi;
    private boolean cRj;
    private com.baidu.tieba.frs.entelechy.b.a cRk;
    private boolean cRl;
    private com.baidu.tieba.e.a cRm;
    private AntiHelper.a cRn;
    private CustomMessageListener cRo;
    com.baidu.tieba.frs.entelechy.b.b cxS;
    private final View.OnClickListener czc;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(com.baidu.tieba.frs.f fVar, com.baidu.tieba.frs.entelechy.b.a aVar) {
        super(fVar.getPageContext());
        this.cIb = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.cRe = null;
        this.cRh = false;
        this.bRe = null;
        this.cRi = null;
        this.cRj = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.g.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.ahw));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.ahw));
            }
        };
        this.cRn = new AntiHelper.a() { // from class: com.baidu.tieba.frs.g.f.3
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.ahy));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.ahy));
            }
        };
        this.cRo = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.g.f.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SignData signData;
                boolean z;
                int i;
                j ajn = f.this.cEN.ajn();
                if (ajn != null && ajn.aPM() != null && ajn.aPM().getName() != null && ajn.aPM().getName().equals(FrsActivityStatic.forumName)) {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name = ajn.aPM().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.tW(signMessage.mSignErrorCode) && signMessage.signData != null) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener) != null) {
                            TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.ahw));
                            return;
                        }
                        return;
                    }
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(ajn.aPM().getId())) {
                            f.this.lw(name);
                            ajn.d(signData2);
                            signData2.forumId = ajn.aPM().getId();
                            signData2.forumName = ajn.aPM().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = ajn.aPM().getUser_level();
                        if (f.this.aoF()) {
                            i = ajn.aPM().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (AntiHelper.tW(signMessage.mSignErrorCode)) {
                            AntiHelper.ao(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                            return;
                        } else if (!f.this.aoD()) {
                            f.this.cEN.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                            return;
                        } else {
                            f.this.cEN.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                            return;
                        }
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.kB(1);
                    }
                    f.this.cEN.showToast(signMessage.mSignErrorString);
                }
            }
        };
        this.czc = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j ajn = f.this.cEN.ajn();
                if (ajn != null && ajn.aPM() != null && f.this.cRb != null && (view == f.this.cRb.aoG() || view == f.this.cRb.aoR() || view == f.this.cRb.aoS())) {
                    if (f.this.cEN != null && ajn.aPM() != null) {
                        TiebaStatic.log(new ak("c12046").ac(ImageViewerConfig.FORUM_ID, ajn.aPM().getId()).r("obj_locate", f.this.cEN.ajq() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), ajn.aPM().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == d.g.tv_love) {
                    if (!f.this.cEN.ajo() && com.baidu.adp.lib.util.j.hh()) {
                        if (!ax.aT(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new ak("c10517").r("obj_locate", 1).ac(ImageViewerConfig.FORUM_ID, f.this.cEN.getForumId()));
                        } else {
                            f.this.ff(true);
                        }
                    }
                } else if (id == d.g.tv_sign) {
                    if (!f.this.cEN.ajo() && com.baidu.adp.lib.util.j.hh() && ax.aT(f.this.mContext.getPageActivity())) {
                        if (!f.this.aoE()) {
                            f.this.aoI();
                        } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(f.this.cEN.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.g(f.this.cEN.getForumId(), 0), 24002)));
                        }
                    }
                } else if (id == d.g.frs_header_games) {
                    if (ax.aT(f.this.mContext.getPageActivity()) && ajn != null && ajn.bsG() != null) {
                        String bsG = ajn.bsG();
                        if (m.dD(bsG) == 3) {
                            m.a(f.this.cEN.getPageContext(), bsG);
                        } else {
                            av.vI().a((TbPageContext) f.this.getPageContext(), new String[]{bsG}, true);
                        }
                    }
                } else if (id == d.g.frs_bawu_center) {
                    if (ajn != null && ajn.getUserData() != null && ajn.getUserData().isBawu()) {
                        String bsO = ajn.bsO();
                        if (!am.isEmpty(bsO)) {
                            com.baidu.tbadk.browser.a.O(f.this.getPageContext().getPageActivity(), bsO);
                            if (ajn.aPM() != null) {
                                TiebaStatic.log(new ak("c10502").ac(ImageViewerConfig.FORUM_ID, ajn.aPM().getId()).ac(SapiAccountManager.SESSION_UID, ajn.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == d.g.level_container && !f.this.cEN.ajo() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page")) && f.this.cRb != null) {
                        f.this.cRb.h(view, false);
                    }
                }
            }
        };
        this.cEN = fVar;
        this.cRk = aVar;
        if (this.cRk != null) {
            this.cxS = this.cRk.akP();
        }
        this.cRm = new com.baidu.tieba.e.a();
        this.cRm.a(new a.InterfaceC0081a() { // from class: com.baidu.tieba.frs.g.f.5
            @Override // com.baidu.tieba.e.a.InterfaceC0081a
            public void ag(int i, int i2) {
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0081a
            public void ah(int i, int i2) {
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0081a
            public void ai(int i, int i2) {
            }
        });
    }

    public void k(Bundle bundle) {
        this.cEN.registerListener(this.cRo);
        ahX();
        aoJ();
        this.cRh = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.cRb != null) {
            this.cRb.onDestory();
        }
        if (this.bRe != null) {
            this.bRe.btH();
        }
        if (this.cRf != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.cRf);
        }
    }

    public void onActivityStop() {
        if (this.cRb != null) {
            this.cRb.onStop();
        }
    }

    public boolean kx(int i) {
        this.mSkinType = i;
        if (this.cRb != null) {
            this.cRb.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void d(BdTypeListView bdTypeListView) {
        this.cIb = bdTypeListView;
    }

    public void fe(boolean z) {
        if (z) {
            if (this.cRb != null) {
                this.cIb.removeHeaderView(this.cRb.aoQ());
                this.cRj = false;
            }
        } else if (this.cRb != null && this.cRb.aoQ() != null && !this.cRj) {
            this.cIb.addHeaderView(this.cRb.aoQ(), this.cIb.getHeaderViewsCount());
            this.cRj = true;
        }
    }

    public void a(String str, j jVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) && jVar != null && jVar.getUserData() != null && jVar.aPM() != null) {
            f(str, jVar.getUserData().getIsMem(), jVar.aPM().isLike());
        }
    }

    public void f(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.cRe, str);
        this.cRg = i2;
        this.cRe = str;
        aoz();
        if (this.cRb == null || z) {
            this.cRb = this.cRk.a(str, this.cEN, i);
            this.cRb.changeSkinType(this.mSkinType);
            this.cRb.setCommonClickListener(this.czc);
        }
        this.cIb.addHeaderView(this.cRb.getView());
        if (this.cxS != null) {
            this.cxS.a(this.cIb, this.cRb);
        }
        if (this.cEN.ajq()) {
            this.cRb.p(0, l.f(TbadkCoreApplication.getInst(), d.e.ds40), 0, l.f(this.mContext.getPageActivity(), d.e.ds20));
        } else {
            int f = l.f(TbadkCoreApplication.getInst(), d.e.ds34);
            this.cRb.p(0, f, 0, f);
        }
        aoA();
    }

    public void aoy() {
        if (!this.cRj && this.cRb != null) {
            this.cIb.addHeaderView(this.cRb.aoQ());
            this.cRj = true;
        }
    }

    private void aoz() {
        if (("normal_page".equals(this.cRe) || "frs_page".equals(this.cRe) || "book_page".equals(this.cRe)) && this.cRb != null) {
            this.cIb.removeHeaderView(this.cRb.getView());
            this.cIb.removeHeaderView(this.cRb.aoQ());
        }
        this.cRj = false;
    }

    private void aoA() {
        if (this.cRf == null) {
            this.cRf = new Runnable() { // from class: com.baidu.tieba.frs.g.f.6
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0 && f.this.cIb.isRefreshDone() && !f.this.cRh && f.this.cRg == 1 && f.this.cEN.aiW() != null && f.this.cEN.aiW().ajx() != null && !f.this.cEN.aiW().ajx().alF()) {
                        if (("frs_page".equals(f.this.cRe) || "normal_page".equals(f.this.cRe) || "book_page".equals(f.this.cRe)) && f.this.cRb != null && f.this.cRb.aoP()) {
                            TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                            f.this.ald();
                            f.this.cEN.cxq = true;
                            f.this.cRh = true;
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.fP().postDelayed(this.cRf, 4000L);
    }

    public void f(j jVar) {
        if (jVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(jVar.aPM(), jVar);
            }
        }
    }

    public void b(ForumData forumData, j jVar) {
        if (forumData != null && jVar != null) {
            float a = a(forumData);
            if (this.cRb != null) {
                this.cRb.a(forumData, jVar);
                this.cRb.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.cRb.kE(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.cRb.fg(false);
                        return;
                    }
                    this.cRb.fg(true);
                    this.cRb.kE(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.cRc = forumData.getLevelupScore();
        this.cRd = forumData.getCurScore();
        if (this.cRc > 0) {
            return this.cRd / this.cRc;
        }
        return 0.0f;
    }

    public void ky(int i) {
        if (i > 1) {
            if (this.cRb != null) {
                this.cRb.fh(false);
            }
        } else if (this.cRb != null) {
            this.cRb.fh(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void f(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            aoB();
        }
    }

    public void setIsMem(int i) {
        if (this.cRb != null) {
            this.cRb.setMemberType(i);
        }
    }

    public void ald() {
        if (("normal_page".equals(this.cRe) || "frs_page".equals(this.cRe) || "book_page".equals(this.cRe)) && this.cRb != null) {
            this.cRb.ald();
        }
    }

    public void aoB() {
        if (this.cRb != null) {
            this.cRb.alf();
        }
    }

    public void a(j jVar, boolean z) {
        if (jVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, jVar.aPM(), jVar, z);
            }
        }
    }

    public void aoC() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            kA(0);
        }
    }

    public void kz(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            kA(i);
        }
    }

    public void kA(int i) {
        if (this.cRb != null) {
            this.cRb.kD(i);
        }
    }

    public void a(int i, ForumData forumData, j jVar, boolean z) {
        if (this.cRb != null) {
            this.cRb.a(forumData, jVar);
            if (forumData != null) {
                this.cRb.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.cRb.fg(false);
                }
            }
        }
    }

    public boolean aoD() {
        if (("normal_page".equals(this.cRe) || "frs_page".equals(this.cRe) || "book_page".equals(this.cRe)) && this.cRb != null) {
            return this.cRb.aoO();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.cRc - this.cRd) {
                z = true;
                this.cRc = signData.levelup_score;
            }
            this.cRd = i + this.cRd;
            if (this.cRd > this.cRc) {
                this.cRd = this.cRc;
            }
            if (this.cRc != 0) {
                f = this.cRd / this.cRc;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.c(z, f);
        }
    }

    public void kB(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cRb != null) {
            this.cRb.kE(i);
        }
    }

    public void g(j jVar) {
        SignData signData;
        ForumData aPM;
        if (jVar != null && jVar.aPM() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cRb != null && (signData = jVar.aPM().getSignData()) != null && (aPM = jVar.aPM()) != null) {
                this.cRb.a(aPM, jVar);
                this.cRb.kE(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.cRb.aoO()) {
                    a(this.cRb, signData);
                    aPM.setCurScore(this.cRd);
                    aPM.setLevelupScore(this.cRc);
                    this.cRb.a(aPM, jVar);
                }
            }
        }
    }

    public boolean aoE() {
        if (("normal_page".equals(this.cRe) || "frs_page".equals(this.cRe) || "book_page".equals(this.cRe)) && this.cRb != null) {
            return this.cRb.aoE();
        }
        return false;
    }

    public boolean aoF() {
        if (("normal_page".equals(this.cRe) || "frs_page".equals(this.cRe) || "book_page".equals(this.cRe)) && this.cRb != null) {
            return this.cRb.aoF();
        }
        return false;
    }

    public BarImageView aoG() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cRb != null) {
            return this.cRb.aoG();
        }
        return null;
    }

    public void ff(boolean z) {
        if (this.cEN != null) {
            j ajn = this.cEN.ajn();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.cEN.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, 11002)));
            } else if (ajn != null && ajn.aPM() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.cEN.getFrom())) {
                    TiebaStatic.log(new ak("c10356").ac(ImageViewerConfig.FORUM_ID, ajn.aPM().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.cEN.getFrom())) {
                    TiebaStatic.log(new ak("c10590").r("obj_type", 2).ac(ImageViewerConfig.FORUM_ID, ajn.aPM().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.cEN.getFrom())) {
                    TiebaStatic.log(new ak("c10587").r("obj_type", 2).ac(ImageViewerConfig.FORUM_ID, ajn.aPM().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.cEN.getFrom())) {
                    TiebaStatic.log(new ak("c10578").r("obj_type", 2).ac(ImageViewerConfig.FORUM_ID, ajn.aPM().getId()));
                }
                this.bRe.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.cEN.getFrom())) {
                    TiebaStatic.eventStat(this.cEN.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.cEN.getFrom())) {
                    TiebaStatic.log(new ak("c10359").ac(ImageViewerConfig.FORUM_ID, ajn.aPM().getId()));
                }
                this.bRe.H(ajn.aPM().getName(), ajn.aPM().getId(), "FRS");
                this.cRl = z;
            }
        }
    }

    public void aoH() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.cEN.ajn() != null && this.cEN.ajn().aPM() != null && this.cEN.ajn().aPM().getName() != null) {
            str = this.cEN.ajn().aPM().getName();
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
                j ajn = f.this.cEN.ajn();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.cEN.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) f.this.getPageContext().getPageActivity(), f.this.getPageContext().getString(d.j.login_to_use), true, 11036)));
                } else if (ajn != null && ajn.aPM() != null) {
                    f.this.cRi.s(ajn.aPM().getName(), com.baidu.adp.lib.g.b.c(ajn.aPM().getId(), 0L));
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

    public void aoI() {
        j ajn = this.cEN.ajn();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.cEN.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, 11014)));
        } else if (ajn != null && ajn.aPM() != null) {
            FrsActivityStatic.forumName = ajn.aPM().getName() == null ? "" : ajn.aPM().getName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, ajn.aPM()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lw(String str) {
        if (this.cEN.aiR() != null && this.cEN.aiR().any() != null) {
            com.baidu.tieba.tbadkCore.c.bsm().W(com.baidu.tieba.tbadkCore.c.bsm().d(str, this.cEN.aiR().any().OY(), this.cEN.aiR().any().getIsGood(), this.cEN.aiR().any().getCategoryId()), false);
        }
    }

    private void ahX() {
        this.bRe = new LikeModel(this.cEN.getPageContext());
        this.bRe.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.g.f.10
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                p pVar;
                j ajn = f.this.cEN.ajn();
                if (ajn != null && ajn.aPM() != null && obj != null) {
                    if (AntiHelper.tW(f.this.bRe.getErrorCode())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.bRe.getBlockPopInfoData(), f.this.cRn) != null) {
                            TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.ahy));
                            return;
                        }
                        return;
                    }
                    String name = ajn.aPM().getName();
                    String id = ajn.aPM().getId();
                    boolean z = false;
                    if (!(obj instanceof p)) {
                        pVar = null;
                    } else {
                        pVar = (p) obj;
                    }
                    if (pVar != null && f.this.bRe.getErrorCode() == 0) {
                        z = true;
                    }
                    if (pVar == null || !z) {
                        if (f.this.bRe.getErrorCode() == 22) {
                            f.this.cEN.showToast(f.this.getPageContext().getString(d.j.had_liked_forum));
                        } else {
                            f.this.cEN.showToast(f.this.bRe.getErrorString());
                        }
                    } else {
                        f.this.lw(name);
                        pVar.setLike(1);
                        ajn.c(pVar);
                        ajn.dm(pVar.bsp());
                        f.this.a(ajn, f.this.cRl);
                        f.this.cRl = true;
                        f.this.cEN.showToast(f.this.getPageContext().getResources().getString(d.j.attention_success));
                        f.this.e(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, pVar));
                    }
                    f.this.cEN.R(Boolean.valueOf(z));
                }
            }
        });
    }

    private void aoJ() {
        this.cRi = new v();
        this.cRi.setFrom("from_frs");
        this.cRi.a(new v.a() { // from class: com.baidu.tieba.frs.g.f.2
            @Override // com.baidu.tieba.tbadkCore.v.a
            public void l(String str, long j) {
                j ajn = f.this.cEN.ajn();
                if (ajn != null && ajn.aPM() != null) {
                    String name = ajn.aPM().getName();
                    String id = ajn.aPM().getId();
                    if (j == com.baidu.adp.lib.g.b.c(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.lw(str);
                        ajn.aPM().setLike(0);
                        f.this.kz(0);
                        f.this.cEN.Q(true);
                        f.this.e(false, id);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, id));
                        p pVar = new p();
                        pVar.setLike(0);
                        pVar.setFid(id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, pVar));
                    }
                }
            }

            @Override // com.baidu.tieba.tbadkCore.v.a
            public void m(String str, long j) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.aBv().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void B(int i, int i2, int i3) {
        j ajn;
        if (i > 0 && i2 > 0 && (ajn = this.cEN.ajn()) != null && ajn.aPM() != null && ajn.getSignData() != null) {
            ForumData aPM = ajn.aPM();
            SignData signData = ajn.getSignData();
            signData.levelup_score = aPM.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            ajn.d(signData);
            signData.forumId = aPM.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            int i4 = -1;
            if (aoF()) {
                i4 = aPM.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(aPM.getName(), signData.sign_bonus_point, i4);
        }
    }

    public int aoK() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            if (this.cRb != null && this.cRb.aoQ() != null && this.cRb.aoQ().getParent() != null) {
                return this.cIb.getHeaderViewsCount() - 2;
            }
            return this.cIb.getHeaderViewsCount() - 1;
        }
        return 0;
    }

    public void akO() {
        if (this.cRb != null) {
            this.cRb.akO();
        }
    }

    public static boolean h(j jVar) {
        if (jVar != null) {
            return (jVar.bsS() == null || StringUtils.isNull(jVar.bsS().pJ(), true) || jVar.bsS().pJ().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean i(j jVar) {
        if (jVar != null) {
            return ((jVar.bsw() == null || jVar.bsw().btg() != 1) && jVar.bsR() == null && (jVar.bsx() == null || com.baidu.tbadk.core.util.v.v(jVar.bsx().pI())) && ((jVar.aPM() == null || jVar.aPM().getFrsBannerData() == null || jVar.aPM().getFrsBannerData().getType() != 2) && (jVar.bsT() == null || StringUtils.isNull(jVar.bsT().pQ(), true)))) ? false : true;
        }
        return false;
    }

    public void kC(int i) {
        View findViewById;
        if (this.cRb != null && this.cRb.aoQ() != null && (findViewById = this.cRb.aoQ().findViewById(d.g.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.cRm != null) {
            this.cRm.onTouchEvent(motionEvent);
        }
    }
}
