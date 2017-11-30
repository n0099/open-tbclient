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
    private LikeModel bZp;
    com.baidu.tieba.frs.entelechy.b.b cHq;
    private final View.OnClickListener cIA;
    private com.baidu.tieba.frs.f cOm;
    private BdTypeListView cRF;
    private int daA;
    private int daB;
    private String daC;
    private Runnable daD;
    private int daE;
    private boolean daF;
    private w daG;
    private boolean daH;
    private com.baidu.tieba.frs.entelechy.b.a daI;
    private boolean daJ;
    private com.baidu.tieba.e.a daK;
    private AntiHelper.a daL;
    private CustomMessageListener daM;
    private com.baidu.tieba.frs.view.b daz;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(com.baidu.tieba.frs.f fVar, com.baidu.tieba.frs.entelechy.b.a aVar) {
        super(fVar.getPageContext());
        this.cRF = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.daC = null;
        this.daF = false;
        this.bZp = null;
        this.daG = null;
        this.daH = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.g.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.ahT));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.ahT));
            }
        };
        this.daL = new AntiHelper.a() { // from class: com.baidu.tieba.frs.g.f.3
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.ahV));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.ahV));
            }
        };
        this.daM = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.g.f.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SignData signData;
                boolean z;
                int i;
                k alv = f.this.cOm.alv();
                if (alv != null && alv.aRf() != null && alv.aRf().getName() != null && alv.aRf().getName().equals(FrsActivityStatic.forumName)) {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name = alv.aRf().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.uq(signMessage.mSignErrorCode) && signMessage.signData != null) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener) != null) {
                            TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.ahT));
                            return;
                        }
                        return;
                    }
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(alv.aRf().getId())) {
                            f.this.lH(name);
                            alv.d(signData2);
                            signData2.forumId = alv.aRf().getId();
                            signData2.forumName = alv.aRf().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = alv.aRf().getUser_level();
                        if (f.this.aqO()) {
                            i = alv.aRf().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (AntiHelper.uq(signMessage.mSignErrorCode)) {
                            AntiHelper.an(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                            return;
                        } else if (!f.this.aqM()) {
                            f.this.cOm.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                            return;
                        } else {
                            f.this.cOm.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                            return;
                        }
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.kZ(1);
                    }
                    f.this.cOm.showToast(signMessage.mSignErrorString);
                }
            }
        };
        this.cIA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k alv = f.this.cOm.alv();
                if (alv != null && alv.aRf() != null && f.this.daz != null && (view == f.this.daz.aqZ() || view == f.this.daz.ara() || view == f.this.daz.arb())) {
                    if (f.this.cOm != null && alv.aRf() != null) {
                        TiebaStatic.log(new ak("c12046").ac(ImageViewerConfig.FORUM_ID, alv.aRf().getId()).r("obj_locate", f.this.cOm.aly() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), alv.aRf().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == d.g.tv_love) {
                    if (!f.this.cOm.alw() && j.hh()) {
                        if (!ax.aV(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new ak("c10517").r("obj_locate", 1).ac(ImageViewerConfig.FORUM_ID, f.this.cOm.getForumId()));
                        } else {
                            f.this.fC(true);
                        }
                    }
                } else if (id == d.g.tv_sign) {
                    if (!f.this.cOm.alw() && j.hh() && ax.aV(f.this.mContext.getPageActivity())) {
                        if (!f.this.aqN()) {
                            f.this.aqQ();
                        } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(f.this.cOm.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.g(f.this.cOm.getForumId(), 0), 24002)));
                        }
                    }
                } else if (id == d.g.frs_header_games) {
                    if (ax.aV(f.this.mContext.getPageActivity()) && alv != null && alv.buy() != null) {
                        String buy = alv.buy();
                        if (m.dD(buy) == 3) {
                            m.a(f.this.cOm.getPageContext(), buy);
                        } else {
                            av.vL().a((TbPageContext) f.this.getPageContext(), new String[]{buy}, true);
                        }
                    }
                } else if (id == d.g.frs_bawu_center) {
                    if (alv != null && alv.getUserData() != null && alv.getUserData().isBawu()) {
                        String buF = alv.buF();
                        if (!am.isEmpty(buF)) {
                            com.baidu.tbadk.browser.a.P(f.this.getPageContext().getPageActivity(), buF);
                            if (alv.aRf() != null) {
                                TiebaStatic.log(new ak("c10502").ac(ImageViewerConfig.FORUM_ID, alv.aRf().getId()).ac(SapiAccountManager.SESSION_UID, alv.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == d.g.level_container && !f.this.cOm.alw() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page")) && f.this.daz != null) {
                        f.this.daz.h(view, false);
                    }
                }
            }
        };
        this.cOm = fVar;
        this.daI = aVar;
        if (this.daI != null) {
            this.cHq = this.daI.amZ();
        }
        this.daK = new com.baidu.tieba.e.a();
        this.daK.a(new a.InterfaceC0083a() { // from class: com.baidu.tieba.frs.g.f.5
            @Override // com.baidu.tieba.e.a.InterfaceC0083a
            public void af(int i, int i2) {
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0083a
            public void ag(int i, int i2) {
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0083a
            public void ah(int i, int i2) {
            }
        });
    }

    public void k(Bundle bundle) {
        this.cOm.registerListener(this.daM);
        akg();
        aqR();
        this.daF = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.daz != null) {
            this.daz.onDestory();
        }
        if (this.bZp != null) {
            this.bZp.bvB();
        }
        if (this.daD != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.daD);
        }
    }

    public void onActivityStop() {
        if (this.daz != null) {
            this.daz.onStop();
        }
    }

    public void fA(boolean z) {
        if (this.daz != null) {
            this.daz.fA(z);
        }
    }

    public boolean kV(int i) {
        this.mSkinType = i;
        if (this.daz != null) {
            this.daz.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void d(BdTypeListView bdTypeListView) {
        this.cRF = bdTypeListView;
    }

    public void fB(boolean z) {
        if (z) {
            if (this.daz != null) {
                this.cRF.removeHeaderView(this.daz.aqY());
                this.daH = false;
            }
        } else if (this.daz != null && this.daz.aqY() != null && !this.daH) {
            this.cRF.addHeaderView(this.daz.aqY(), this.cRF.getHeaderViewsCount());
            this.daH = true;
        }
    }

    public void a(String str, k kVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) && kVar != null && kVar.getUserData() != null && kVar.aRf() != null) {
            f(str, kVar.getUserData().getIsMem(), kVar.aRf().isLike());
        }
    }

    public void f(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.daC, str);
        this.daE = i2;
        this.daC = str;
        aqI();
        if (this.daz == null || z) {
            this.daz = this.daI.a(str, this.cOm, i);
            this.daz.changeSkinType(this.mSkinType);
            this.daz.setCommonClickListener(this.cIA);
        }
        this.cRF.addHeaderView(this.daz.getView());
        if (this.cHq != null) {
            this.cHq.a(this.cRF, this.daz);
        }
        int f = l.f(TbadkCoreApplication.getInst(), d.e.tbds44);
        this.daz.p(0, f, 0, f);
        aqJ();
    }

    public void aqH() {
        if (!this.daH && this.daz != null) {
            this.cRF.addHeaderView(this.daz.aqY());
            this.daH = true;
        }
    }

    private void aqI() {
        if (("normal_page".equals(this.daC) || "frs_page".equals(this.daC) || "book_page".equals(this.daC)) && this.daz != null) {
            this.cRF.removeHeaderView(this.daz.getView());
            this.cRF.removeHeaderView(this.daz.aqY());
        }
        this.daH = false;
    }

    private void aqJ() {
        if (this.daD == null) {
            this.daD = new Runnable() { // from class: com.baidu.tieba.frs.g.f.6
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0 && f.this.cRF.isRefreshDone() && f.this.cRF.isShown() && f.this.cOm.isPrimary() && !f.this.daF && f.this.daE == 1 && f.this.cOm.ale() != null && f.this.cOm.ale().alF() != null && !f.this.cOm.ale().alF().anO()) {
                        if (("frs_page".equals(f.this.daC) || "normal_page".equals(f.this.daC) || "book_page".equals(f.this.daC)) && f.this.daz != null && f.this.daz.aqX()) {
                            TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                            f.this.anm();
                            f.this.cOm.cGP = true;
                            f.this.daF = true;
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.fP().postDelayed(this.daD, 4000L);
    }

    public void f(k kVar) {
        if (kVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(kVar.aRf(), kVar);
            }
        }
    }

    public void b(ForumData forumData, k kVar) {
        if (forumData != null && kVar != null) {
            float a = a(forumData);
            if (this.daz != null) {
                this.daz.a(forumData, kVar);
                this.daz.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.daz.lc(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.daz.fE(false);
                        return;
                    }
                    this.daz.fE(true);
                    this.daz.lc(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.daA = forumData.getLevelupScore();
        this.daB = forumData.getCurScore();
        if (this.daA > 0) {
            return this.daB / this.daA;
        }
        return 0.0f;
    }

    public void kW(int i) {
        if (i > 1) {
            if (this.daz != null) {
                this.daz.fF(false);
            }
        } else if (this.daz != null) {
            this.daz.fF(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void f(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            aqK();
        }
    }

    public void setIsMem(int i) {
        if (this.daz != null) {
            this.daz.setMemberType(i);
        }
    }

    public void anm() {
        if (("normal_page".equals(this.daC) || "frs_page".equals(this.daC) || "book_page".equals(this.daC)) && this.daz != null) {
            this.daz.anm();
        }
    }

    public void aqK() {
        if (this.daz != null) {
            this.daz.ano();
        }
    }

    public void a(k kVar, boolean z) {
        if (kVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, kVar.aRf(), kVar, z);
            }
        }
    }

    public void aqL() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            kY(0);
        }
    }

    public void kX(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            kY(i);
        }
    }

    public void kY(int i) {
        if (this.daz != null) {
            this.daz.lb(i);
        }
    }

    public void a(int i, ForumData forumData, k kVar, boolean z) {
        if (this.daz != null) {
            this.daz.a(forumData, kVar);
            if (forumData != null) {
                this.daz.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.daz.fE(false);
                }
            }
        }
    }

    public boolean aqM() {
        if (("normal_page".equals(this.daC) || "frs_page".equals(this.daC) || "book_page".equals(this.daC)) && this.daz != null) {
            return this.daz.aqW();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.daA - this.daB) {
                z = true;
                this.daA = signData.levelup_score;
            }
            this.daB = i + this.daB;
            if (this.daB > this.daA) {
                this.daB = this.daA;
            }
            if (this.daA != 0) {
                f = this.daB / this.daA;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.c(z, f);
        }
    }

    public void kZ(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.daz != null) {
            this.daz.lc(i);
        }
    }

    public void g(k kVar) {
        SignData signData;
        ForumData aRf;
        if (kVar != null && kVar.aRf() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.daz != null && (signData = kVar.aRf().getSignData()) != null && (aRf = kVar.aRf()) != null) {
                this.daz.a(aRf, kVar);
                this.daz.lc(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.daz.aqW()) {
                    a(this.daz, signData);
                    aRf.setCurScore(this.daB);
                    aRf.setLevelupScore(this.daA);
                    this.daz.a(aRf, kVar);
                }
            }
        }
    }

    public boolean aqN() {
        if (("normal_page".equals(this.daC) || "frs_page".equals(this.daC) || "book_page".equals(this.daC)) && this.daz != null) {
            return this.daz.aqN();
        }
        return false;
    }

    public boolean aqO() {
        if (("normal_page".equals(this.daC) || "frs_page".equals(this.daC) || "book_page".equals(this.daC)) && this.daz != null) {
            return this.daz.aqO();
        }
        return false;
    }

    public void fC(boolean z) {
        if (this.cOm != null) {
            k alv = this.cOm.alv();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.cOm.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, 11002)));
            } else if (alv != null && alv.aRf() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.cOm.getFrom())) {
                    TiebaStatic.log(new ak("c10356").ac(ImageViewerConfig.FORUM_ID, alv.aRf().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.cOm.getFrom())) {
                    TiebaStatic.log(new ak("c10590").r("obj_type", 2).ac(ImageViewerConfig.FORUM_ID, alv.aRf().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.cOm.getFrom())) {
                    TiebaStatic.log(new ak("c10587").r("obj_type", 2).ac(ImageViewerConfig.FORUM_ID, alv.aRf().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.cOm.getFrom())) {
                    TiebaStatic.log(new ak("c10578").r("obj_type", 2).ac(ImageViewerConfig.FORUM_ID, alv.aRf().getId()));
                }
                this.bZp.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.cOm.getFrom())) {
                    TiebaStatic.eventStat(this.cOm.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.cOm.getFrom())) {
                    TiebaStatic.log(new ak("c10359").ac(ImageViewerConfig.FORUM_ID, alv.aRf().getId()));
                }
                this.bZp.H(alv.aRf().getName(), alv.aRf().getId(), "FRS");
                this.daJ = z;
            }
        }
    }

    public void aqP() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.cOm.alv() != null && this.cOm.alv().aRf() != null && this.cOm.alv().aRf().getName() != null) {
            str = this.cOm.alv().aRf().getName();
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
                k alv = f.this.cOm.alv();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.cOm.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) f.this.getPageContext().getPageActivity(), f.this.getPageContext().getString(d.j.login_to_use), true, 11036)));
                } else if (alv != null && alv.aRf() != null) {
                    f.this.daG.u(alv.aRf().getName(), com.baidu.adp.lib.g.b.c(alv.aRf().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(d.j.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.g.f.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).tk();
    }

    public void aqQ() {
        k alv = this.cOm.alv();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.cOm.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, 11014)));
        } else if (alv != null && alv.aRf() != null) {
            FrsActivityStatic.forumName = alv.aRf().getName() == null ? "" : alv.aRf().getName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, alv.aRf()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lH(String str) {
        if (this.cOm.akZ() != null && this.cOm.akZ().apH() != null) {
            com.baidu.tieba.tbadkCore.c.bue().Y(com.baidu.tieba.tbadkCore.c.bue().d(str, this.cOm.akZ().apH().Qt(), this.cOm.akZ().apH().getIsGood(), this.cOm.akZ().apH().getCategoryId()), false);
        }
    }

    private void akg() {
        this.bZp = new LikeModel(this.cOm.getPageContext());
        this.bZp.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.g.f.10
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                q qVar;
                k alv = f.this.cOm.alv();
                if (alv != null && alv.aRf() != null && obj != null) {
                    if (AntiHelper.uq(f.this.bZp.getErrorCode())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.bZp.getBlockPopInfoData(), f.this.daL) != null) {
                            TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.ahV));
                            return;
                        }
                        return;
                    }
                    String name = alv.aRf().getName();
                    String id = alv.aRf().getId();
                    boolean z = false;
                    if (!(obj instanceof q)) {
                        qVar = null;
                    } else {
                        qVar = (q) obj;
                    }
                    if (qVar != null && f.this.bZp.getErrorCode() == 0) {
                        z = true;
                    }
                    if (qVar == null || !z) {
                        if (f.this.bZp.getErrorCode() == 22) {
                            f.this.cOm.showToast(f.this.getPageContext().getString(d.j.had_liked_forum));
                        } else {
                            f.this.cOm.showToast(f.this.bZp.getErrorString());
                        }
                    } else {
                        f.this.lH(name);
                        qVar.setLike(1);
                        alv.c(qVar);
                        alv.dy(qVar.buh());
                        f.this.a(alv, f.this.daJ);
                        f.this.daJ = true;
                        f.this.cOm.showToast(f.this.getPageContext().getResources().getString(d.j.attention_success));
                        f.this.f(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, qVar));
                    }
                    f.this.cOm.R(Boolean.valueOf(z));
                }
            }
        });
    }

    private void aqR() {
        this.daG = new w();
        this.daG.setFrom("from_frs");
        this.daG.a(new w.a() { // from class: com.baidu.tieba.frs.g.f.2
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void n(String str, long j) {
                k alv = f.this.cOm.alv();
                if (alv != null && alv.aRf() != null) {
                    String name = alv.aRf().getName();
                    String id = alv.aRf().getId();
                    if (j == com.baidu.adp.lib.g.b.c(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.lH(str);
                        alv.aRf().setLike(0);
                        f.this.kX(0);
                        f.this.cOm.Q(true);
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
        com.baidu.tieba.im.settingcache.d.aCZ().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void C(int i, int i2, int i3) {
        k alv;
        if (i > 0 && i2 > 0 && (alv = this.cOm.alv()) != null && alv.aRf() != null && alv.getSignData() != null) {
            ForumData aRf = alv.aRf();
            SignData signData = alv.getSignData();
            signData.levelup_score = aRf.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            alv.d(signData);
            signData.forumId = aRf.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            int i4 = -1;
            if (aqO()) {
                i4 = aRf.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(aRf.getName(), signData.sign_bonus_point, i4);
        }
    }

    public int aqS() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            if (this.daz != null && this.daz.aqY() != null && this.daz.aqY().getParent() != null) {
                return this.cRF.getHeaderViewsCount() - 2;
            }
            return this.cRF.getHeaderViewsCount() - 1;
        }
        return 0;
    }

    public void amY() {
        if (this.daz != null) {
            this.daz.amY();
        }
    }

    public static boolean h(k kVar) {
        if (kVar != null) {
            return (kVar.buJ() == null || StringUtils.isNull(kVar.buJ().pM(), true) || kVar.buJ().pM().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean i(k kVar) {
        if (kVar != null) {
            return ((kVar.buo() == null || kVar.buo().buZ() != 1) && kVar.buI() == null && (kVar.bup() == null || v.w(kVar.bup().pL())) && ((kVar.aRf() == null || kVar.aRf().getFrsBannerData() == null || kVar.aRf().getFrsBannerData().getType() != 2) && (kVar.buK() == null || StringUtils.isNull(kVar.buK().pT(), true)))) ? false : true;
        }
        return false;
    }

    public void la(int i) {
        View findViewById;
        if (this.daz != null && this.daz.aqY() != null && (findViewById = this.daz.aqY().findViewById(d.g.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.daK != null) {
            this.daK.onTouchEvent(motionEvent);
        }
    }
}
