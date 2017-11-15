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
    private LikeModel bRr;
    private com.baidu.tieba.frs.f cFg;
    private BdTypeListView cIu;
    private int cRA;
    private boolean cRB;
    private v cRC;
    private boolean cRD;
    private com.baidu.tieba.frs.entelechy.b.a cRE;
    private boolean cRF;
    private com.baidu.tieba.e.a cRG;
    private AntiHelper.a cRH;
    private CustomMessageListener cRI;
    private com.baidu.tieba.frs.view.b cRv;
    private int cRw;
    private int cRx;
    private String cRy;
    private Runnable cRz;
    com.baidu.tieba.frs.entelechy.b.b cyl;
    private final View.OnClickListener czv;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(com.baidu.tieba.frs.f fVar, com.baidu.tieba.frs.entelechy.b.a aVar) {
        super(fVar.getPageContext());
        this.cIu = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.cRy = null;
        this.cRB = false;
        this.bRr = null;
        this.cRC = null;
        this.cRD = false;
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
        this.cRH = new AntiHelper.a() { // from class: com.baidu.tieba.frs.g.f.3
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.ahy));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.ahy));
            }
        };
        this.cRI = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.g.f.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SignData signData;
                boolean z;
                int i;
                j ajB = f.this.cFg.ajB();
                if (ajB != null && ajB.aPU() != null && ajB.aPU().getName() != null && ajB.aPU().getName().equals(FrsActivityStatic.forumName)) {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name = ajB.aPU().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.ua(signMessage.mSignErrorCode) && signMessage.signData != null) {
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
                        if (signData2.forumId != null && signData2.forumId.equals(ajB.aPU().getId())) {
                            f.this.ly(name);
                            ajB.d(signData2);
                            signData2.forumId = ajB.aPU().getId();
                            signData2.forumName = ajB.aPU().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = ajB.aPU().getUser_level();
                        if (f.this.aoU()) {
                            i = ajB.aPU().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (AntiHelper.ua(signMessage.mSignErrorCode)) {
                            AntiHelper.ao(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                            return;
                        } else if (!f.this.aoS()) {
                            f.this.cFg.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                            return;
                        } else {
                            f.this.cFg.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                            return;
                        }
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.kB(1);
                    }
                    f.this.cFg.showToast(signMessage.mSignErrorString);
                }
            }
        };
        this.czv = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j ajB = f.this.cFg.ajB();
                if (ajB != null && ajB.aPU() != null && f.this.cRv != null && (view == f.this.cRv.aoV() || view == f.this.cRv.apg() || view == f.this.cRv.aph())) {
                    if (f.this.cFg != null && ajB.aPU() != null) {
                        TiebaStatic.log(new ak("c12046").ac(ImageViewerConfig.FORUM_ID, ajB.aPU().getId()).r("obj_locate", f.this.cFg.ajE() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), ajB.aPU().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == d.g.tv_love) {
                    if (!f.this.cFg.ajC() && com.baidu.adp.lib.util.j.hh()) {
                        if (!ax.aT(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new ak("c10517").r("obj_locate", 1).ac(ImageViewerConfig.FORUM_ID, f.this.cFg.getForumId()));
                        } else {
                            f.this.fl(true);
                        }
                    }
                } else if (id == d.g.tv_sign) {
                    if (!f.this.cFg.ajC() && com.baidu.adp.lib.util.j.hh() && ax.aT(f.this.mContext.getPageActivity())) {
                        if (!f.this.aoT()) {
                            f.this.aoX();
                        } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(f.this.cFg.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.g(f.this.cFg.getForumId(), 0), 24002)));
                        }
                    }
                } else if (id == d.g.frs_header_games) {
                    if (ax.aT(f.this.mContext.getPageActivity()) && ajB != null && ajB.bsR() != null) {
                        String bsR = ajB.bsR();
                        if (m.dD(bsR) == 3) {
                            m.a(f.this.cFg.getPageContext(), bsR);
                        } else {
                            av.vI().a((TbPageContext) f.this.getPageContext(), new String[]{bsR}, true);
                        }
                    }
                } else if (id == d.g.frs_bawu_center) {
                    if (ajB != null && ajB.getUserData() != null && ajB.getUserData().isBawu()) {
                        String bsZ = ajB.bsZ();
                        if (!am.isEmpty(bsZ)) {
                            com.baidu.tbadk.browser.a.O(f.this.getPageContext().getPageActivity(), bsZ);
                            if (ajB.aPU() != null) {
                                TiebaStatic.log(new ak("c10502").ac(ImageViewerConfig.FORUM_ID, ajB.aPU().getId()).ac(SapiAccountManager.SESSION_UID, ajB.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == d.g.level_container && !f.this.cFg.ajC() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page")) && f.this.cRv != null) {
                        f.this.cRv.h(view, false);
                    }
                }
            }
        };
        this.cFg = fVar;
        this.cRE = aVar;
        if (this.cRE != null) {
            this.cyl = this.cRE.ald();
        }
        this.cRG = new com.baidu.tieba.e.a();
        this.cRG.a(new a.InterfaceC0081a() { // from class: com.baidu.tieba.frs.g.f.5
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
        this.cFg.registerListener(this.cRI);
        ail();
        aoY();
        this.cRB = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.cRv != null) {
            this.cRv.onDestory();
        }
        if (this.bRr != null) {
            this.bRr.btT();
        }
        if (this.cRz != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.cRz);
        }
    }

    public void onActivityStop() {
        if (this.cRv != null) {
            this.cRv.onStop();
        }
    }

    public void fj(boolean z) {
        if (this.cRv != null) {
            this.cRv.fj(z);
        }
    }

    public boolean kx(int i) {
        this.mSkinType = i;
        if (this.cRv != null) {
            this.cRv.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void d(BdTypeListView bdTypeListView) {
        this.cIu = bdTypeListView;
    }

    public void fk(boolean z) {
        if (z) {
            if (this.cRv != null) {
                this.cIu.removeHeaderView(this.cRv.apf());
                this.cRD = false;
            }
        } else if (this.cRv != null && this.cRv.apf() != null && !this.cRD) {
            this.cIu.addHeaderView(this.cRv.apf(), this.cIu.getHeaderViewsCount());
            this.cRD = true;
        }
    }

    public void a(String str, j jVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) && jVar != null && jVar.getUserData() != null && jVar.aPU() != null) {
            f(str, jVar.getUserData().getIsMem(), jVar.aPU().isLike());
        }
    }

    public void f(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.cRy, str);
        this.cRA = i2;
        this.cRy = str;
        aoO();
        if (this.cRv == null || z) {
            this.cRv = this.cRE.a(str, this.cFg, i);
            this.cRv.changeSkinType(this.mSkinType);
            this.cRv.setCommonClickListener(this.czv);
        }
        this.cIu.addHeaderView(this.cRv.getView());
        if (this.cyl != null) {
            this.cyl.a(this.cIu, this.cRv);
        }
        if (this.cFg.ajE()) {
            this.cRv.p(0, l.f(TbadkCoreApplication.getInst(), d.e.ds40), 0, l.f(this.mContext.getPageActivity(), d.e.ds20));
        } else {
            int f = l.f(TbadkCoreApplication.getInst(), d.e.ds34);
            this.cRv.p(0, f, 0, f);
        }
        aoP();
    }

    public void aoN() {
        if (!this.cRD && this.cRv != null) {
            this.cIu.addHeaderView(this.cRv.apf());
            this.cRD = true;
        }
    }

    private void aoO() {
        if (("normal_page".equals(this.cRy) || "frs_page".equals(this.cRy) || "book_page".equals(this.cRy)) && this.cRv != null) {
            this.cIu.removeHeaderView(this.cRv.getView());
            this.cIu.removeHeaderView(this.cRv.apf());
        }
        this.cRD = false;
    }

    private void aoP() {
        if (this.cRz == null) {
            this.cRz = new Runnable() { // from class: com.baidu.tieba.frs.g.f.6
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0 && f.this.cIu.isRefreshDone() && f.this.cIu.isShown() && f.this.cFg.isPrimary() && !f.this.cRB && f.this.cRA == 1 && f.this.cFg.ajk() != null && f.this.cFg.ajk().ajL() != null && !f.this.cFg.ajk().ajL().alT()) {
                        if (("frs_page".equals(f.this.cRy) || "normal_page".equals(f.this.cRy) || "book_page".equals(f.this.cRy)) && f.this.cRv != null && f.this.cRv.ape()) {
                            TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                            f.this.alr();
                            f.this.cFg.cxJ = true;
                            f.this.cRB = true;
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.fP().postDelayed(this.cRz, 4000L);
    }

    public void f(j jVar) {
        if (jVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(jVar.aPU(), jVar);
            }
        }
    }

    public void b(ForumData forumData, j jVar) {
        if (forumData != null && jVar != null) {
            float a = a(forumData);
            if (this.cRv != null) {
                this.cRv.a(forumData, jVar);
                this.cRv.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.cRv.kE(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.cRv.fm(false);
                        return;
                    }
                    this.cRv.fm(true);
                    this.cRv.kE(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.cRw = forumData.getLevelupScore();
        this.cRx = forumData.getCurScore();
        if (this.cRw > 0) {
            return this.cRx / this.cRw;
        }
        return 0.0f;
    }

    public void ky(int i) {
        if (i > 1) {
            if (this.cRv != null) {
                this.cRv.fn(false);
            }
        } else if (this.cRv != null) {
            this.cRv.fn(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void f(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            aoQ();
        }
    }

    public void setIsMem(int i) {
        if (this.cRv != null) {
            this.cRv.setMemberType(i);
        }
    }

    public void alr() {
        if (("normal_page".equals(this.cRy) || "frs_page".equals(this.cRy) || "book_page".equals(this.cRy)) && this.cRv != null) {
            this.cRv.alr();
        }
    }

    public void aoQ() {
        if (this.cRv != null) {
            this.cRv.alt();
        }
    }

    public void a(j jVar, boolean z) {
        if (jVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, jVar.aPU(), jVar, z);
            }
        }
    }

    public void aoR() {
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
        if (this.cRv != null) {
            this.cRv.kD(i);
        }
    }

    public void a(int i, ForumData forumData, j jVar, boolean z) {
        if (this.cRv != null) {
            this.cRv.a(forumData, jVar);
            if (forumData != null) {
                this.cRv.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.cRv.fm(false);
                }
            }
        }
    }

    public boolean aoS() {
        if (("normal_page".equals(this.cRy) || "frs_page".equals(this.cRy) || "book_page".equals(this.cRy)) && this.cRv != null) {
            return this.cRv.apd();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.cRw - this.cRx) {
                z = true;
                this.cRw = signData.levelup_score;
            }
            this.cRx = i + this.cRx;
            if (this.cRx > this.cRw) {
                this.cRx = this.cRw;
            }
            if (this.cRw != 0) {
                f = this.cRx / this.cRw;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.c(z, f);
        }
    }

    public void kB(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cRv != null) {
            this.cRv.kE(i);
        }
    }

    public void g(j jVar) {
        SignData signData;
        ForumData aPU;
        if (jVar != null && jVar.aPU() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cRv != null && (signData = jVar.aPU().getSignData()) != null && (aPU = jVar.aPU()) != null) {
                this.cRv.a(aPU, jVar);
                this.cRv.kE(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.cRv.apd()) {
                    a(this.cRv, signData);
                    aPU.setCurScore(this.cRx);
                    aPU.setLevelupScore(this.cRw);
                    this.cRv.a(aPU, jVar);
                }
            }
        }
    }

    public boolean aoT() {
        if (("normal_page".equals(this.cRy) || "frs_page".equals(this.cRy) || "book_page".equals(this.cRy)) && this.cRv != null) {
            return this.cRv.aoT();
        }
        return false;
    }

    public boolean aoU() {
        if (("normal_page".equals(this.cRy) || "frs_page".equals(this.cRy) || "book_page".equals(this.cRy)) && this.cRv != null) {
            return this.cRv.aoU();
        }
        return false;
    }

    public BarImageView aoV() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cRv != null) {
            return this.cRv.aoV();
        }
        return null;
    }

    public void fl(boolean z) {
        if (this.cFg != null) {
            j ajB = this.cFg.ajB();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.cFg.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, 11002)));
            } else if (ajB != null && ajB.aPU() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.cFg.getFrom())) {
                    TiebaStatic.log(new ak("c10356").ac(ImageViewerConfig.FORUM_ID, ajB.aPU().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.cFg.getFrom())) {
                    TiebaStatic.log(new ak("c10590").r("obj_type", 2).ac(ImageViewerConfig.FORUM_ID, ajB.aPU().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.cFg.getFrom())) {
                    TiebaStatic.log(new ak("c10587").r("obj_type", 2).ac(ImageViewerConfig.FORUM_ID, ajB.aPU().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.cFg.getFrom())) {
                    TiebaStatic.log(new ak("c10578").r("obj_type", 2).ac(ImageViewerConfig.FORUM_ID, ajB.aPU().getId()));
                }
                this.bRr.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.cFg.getFrom())) {
                    TiebaStatic.eventStat(this.cFg.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.cFg.getFrom())) {
                    TiebaStatic.log(new ak("c10359").ac(ImageViewerConfig.FORUM_ID, ajB.aPU().getId()));
                }
                this.bRr.H(ajB.aPU().getName(), ajB.aPU().getId(), "FRS");
                this.cRF = z;
            }
        }
    }

    public void aoW() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.cFg.ajB() != null && this.cFg.ajB().aPU() != null && this.cFg.ajB().aPU().getName() != null) {
            str = this.cFg.ajB().aPU().getName();
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
                j ajB = f.this.cFg.ajB();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.cFg.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) f.this.getPageContext().getPageActivity(), f.this.getPageContext().getString(d.j.login_to_use), true, 11036)));
                } else if (ajB != null && ajB.aPU() != null) {
                    f.this.cRC.s(ajB.aPU().getName(), com.baidu.adp.lib.g.b.c(ajB.aPU().getId(), 0L));
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

    public void aoX() {
        j ajB = this.cFg.ajB();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.cFg.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, 11014)));
        } else if (ajB != null && ajB.aPU() != null) {
            FrsActivityStatic.forumName = ajB.aPU().getName() == null ? "" : ajB.aPU().getName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, ajB.aPU()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ly(String str) {
        if (this.cFg.ajf() != null && this.cFg.ajf().anN() != null) {
            com.baidu.tieba.tbadkCore.c.bsx().W(com.baidu.tieba.tbadkCore.c.bsx().d(str, this.cFg.ajf().anN().Pj(), this.cFg.ajf().anN().getIsGood(), this.cFg.ajf().anN().getCategoryId()), false);
        }
    }

    private void ail() {
        this.bRr = new LikeModel(this.cFg.getPageContext());
        this.bRr.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.g.f.10
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                p pVar;
                j ajB = f.this.cFg.ajB();
                if (ajB != null && ajB.aPU() != null && obj != null) {
                    if (AntiHelper.ua(f.this.bRr.getErrorCode())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.bRr.getBlockPopInfoData(), f.this.cRH) != null) {
                            TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.ahy));
                            return;
                        }
                        return;
                    }
                    String name = ajB.aPU().getName();
                    String id = ajB.aPU().getId();
                    boolean z = false;
                    if (!(obj instanceof p)) {
                        pVar = null;
                    } else {
                        pVar = (p) obj;
                    }
                    if (pVar != null && f.this.bRr.getErrorCode() == 0) {
                        z = true;
                    }
                    if (pVar == null || !z) {
                        if (f.this.bRr.getErrorCode() == 22) {
                            f.this.cFg.showToast(f.this.getPageContext().getString(d.j.had_liked_forum));
                        } else {
                            f.this.cFg.showToast(f.this.bRr.getErrorString());
                        }
                    } else {
                        f.this.ly(name);
                        pVar.setLike(1);
                        ajB.c(pVar);
                        ajB.dn(pVar.bsA());
                        f.this.a(ajB, f.this.cRF);
                        f.this.cRF = true;
                        f.this.cFg.showToast(f.this.getPageContext().getResources().getString(d.j.attention_success));
                        f.this.f(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, pVar));
                    }
                    f.this.cFg.R(Boolean.valueOf(z));
                }
            }
        });
    }

    private void aoY() {
        this.cRC = new v();
        this.cRC.setFrom("from_frs");
        this.cRC.a(new v.a() { // from class: com.baidu.tieba.frs.g.f.2
            @Override // com.baidu.tieba.tbadkCore.v.a
            public void l(String str, long j) {
                j ajB = f.this.cFg.ajB();
                if (ajB != null && ajB.aPU() != null) {
                    String name = ajB.aPU().getName();
                    String id = ajB.aPU().getId();
                    if (j == com.baidu.adp.lib.g.b.c(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.ly(str);
                        ajB.aPU().setLike(0);
                        f.this.kz(0);
                        f.this.cFg.Q(true);
                        f.this.f(false, id);
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
    public void f(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.aBz().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void B(int i, int i2, int i3) {
        j ajB;
        if (i > 0 && i2 > 0 && (ajB = this.cFg.ajB()) != null && ajB.aPU() != null && ajB.getSignData() != null) {
            ForumData aPU = ajB.aPU();
            SignData signData = ajB.getSignData();
            signData.levelup_score = aPU.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            ajB.d(signData);
            signData.forumId = aPU.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            int i4 = -1;
            if (aoU()) {
                i4 = aPU.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(aPU.getName(), signData.sign_bonus_point, i4);
        }
    }

    public int aoZ() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            if (this.cRv != null && this.cRv.apf() != null && this.cRv.apf().getParent() != null) {
                return this.cIu.getHeaderViewsCount() - 2;
            }
            return this.cIu.getHeaderViewsCount() - 1;
        }
        return 0;
    }

    public void alc() {
        if (this.cRv != null) {
            this.cRv.alc();
        }
    }

    public static boolean h(j jVar) {
        if (jVar != null) {
            return (jVar.btd() == null || StringUtils.isNull(jVar.btd().pJ(), true) || jVar.btd().pJ().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean i(j jVar) {
        if (jVar != null) {
            return ((jVar.bsH() == null || jVar.bsH().bts() != 1) && jVar.btc() == null && (jVar.bsI() == null || com.baidu.tbadk.core.util.v.v(jVar.bsI().pI())) && ((jVar.aPU() == null || jVar.aPU().getFrsBannerData() == null || jVar.aPU().getFrsBannerData().getType() != 2) && (jVar.bte() == null || StringUtils.isNull(jVar.bte().pQ(), true)))) ? false : true;
        }
        return false;
    }

    public void kC(int i) {
        View findViewById;
        if (this.cRv != null && this.cRv.apf() != null && (findViewById = this.cRv.apf().findViewById(d.g.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.cRG != null) {
            this.cRG.onTouchEvent(motionEvent);
        }
    }
}
