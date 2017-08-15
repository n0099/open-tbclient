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
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.SignMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.i;
import com.baidu.tieba.tbadkCore.o;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private LikeModel bGL;
    private int bYT;
    private com.baidu.tieba.frs.view.b cAa;
    private int cAb;
    private int cAc;
    private String cAd;
    private Runnable cAe;
    private boolean cAf;
    private u cAg;
    private boolean cAh;
    private com.baidu.tieba.frs.entelechy.b.a cAi;
    private boolean cAj;
    private com.baidu.tieba.e.a cAk;
    private int cAl;
    private CustomMessageListener cAm;
    com.baidu.tieba.frs.entelechy.b.b ckc;
    private final View.OnClickListener cll;
    private com.baidu.tieba.frs.f coU;
    private BdTypeListView csk;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(com.baidu.tieba.frs.f fVar, com.baidu.tieba.frs.entelechy.b.a aVar) {
        super(fVar.getPageContext());
        this.csk = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.cAd = null;
        this.cAf = false;
        this.bGL = null;
        this.cAg = null;
        this.cAh = false;
        this.cAl = 0;
        this.cAm = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.g.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SignData signData;
                boolean z;
                int i;
                i afN = f.this.coU.afN();
                if (afN != null && afN.aPO() != null && afN.aPO().getName() != null && afN.aPO().getName().equals(FrsActivityStatic.forumName)) {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name = afN.aPO().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(afN.aPO().getId())) {
                            com.baidu.tieba.tbadkCore.c.brc().aa(name, false);
                            afN.d(signData2);
                            signData2.forumId = afN.aPO().getId();
                            signData2.forumName = afN.aPO().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = afN.aPO().getUser_level();
                        if (f.this.aki()) {
                            i = afN.aPO().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (AntiHelper.tx(signMessage.mSignErrorCode)) {
                            AntiHelper.ar(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                        } else if (!f.this.akg()) {
                            f.this.coU.showToast(f.this.getPageContext().getResources().getString(d.l.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                        } else {
                            f.this.coU.showToast(f.this.getPageContext().getResources().getString(d.l.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                        }
                    } else if (AntiHelper.tx(signMessage.mSignErrorCode)) {
                        AntiHelper.ar(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                    } else {
                        if (signMessage.mSignErrorCode == 160002) {
                            f.this.jI(1);
                        }
                        f.this.coU.showToast(signMessage.mSignErrorString);
                    }
                }
            }
        };
        this.cll = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i afN = f.this.coU.afN();
                if (afN != null && afN.aPO() != null && f.this.cAa != null && (view == f.this.cAa.akj() || view == f.this.cAa.aku() || view == f.this.cAa.akv())) {
                    if (f.this.coU != null && afN.aPO() != null) {
                        TiebaStatic.log(new aj("c12046").aa("fid", afN.aPO().getId()).r("obj_locate", f.this.coU.afQ() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), afN.aPO().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == d.h.tv_love) {
                    if (!f.this.coU.afO() && com.baidu.adp.lib.util.i.hr()) {
                        if (!aw.aO(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new aj("c10517").r("obj_locate", 1).aa("fid", f.this.coU.getForumId()));
                        } else {
                            f.this.fe(true);
                        }
                    }
                } else if (id == d.h.tv_sign) {
                    if (!f.this.coU.afO() && com.baidu.adp.lib.util.i.hr() && aw.aO(f.this.mContext.getPageActivity())) {
                        if (!f.this.akh()) {
                            f.this.akl();
                        } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(f.this.coU.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.g(f.this.coU.getForumId(), 0), 24002)));
                        }
                    }
                } else if (id == d.h.frs_header_games) {
                    if (aw.aO(f.this.mContext.getPageActivity()) && afN != null && afN.bru() != null) {
                        String bru = afN.bru();
                        if (l.dK(bru) == 3) {
                            l.a(f.this.coU.getPageContext(), bru);
                        } else {
                            at.wf().a((TbPageContext) f.this.getPageContext(), new String[]{bru}, true);
                        }
                    }
                } else if (id == d.h.frs_bawu_center) {
                    if (afN != null && afN.getUserData() != null && afN.getUserData().isBawu()) {
                        String brC = afN.brC();
                        if (!al.isEmpty(brC)) {
                            com.baidu.tbadk.browser.a.T(f.this.getPageContext().getPageActivity(), brC);
                            if (afN.aPO() != null) {
                                TiebaStatic.log(new aj("c10502").aa("fid", afN.aPO().getId()).aa(SapiAccountManager.SESSION_UID, afN.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == d.h.level_container && !f.this.coU.afO() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page")) && f.this.cAa != null) {
                        f.this.cAa.f(view, false);
                    }
                }
            }
        };
        this.coU = fVar;
        this.cAi = aVar;
        if (this.cAi != null) {
            this.ckc = this.cAi.agN();
        }
        this.cAk = new com.baidu.tieba.e.a();
        this.cAk.a(new a.InterfaceC0080a() { // from class: com.baidu.tieba.frs.g.f.2
            @Override // com.baidu.tieba.e.a.InterfaceC0080a
            public void ah(int i, int i2) {
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0080a
            public void ai(int i, int i2) {
            }
        });
    }

    public void j(Bundle bundle) {
        this.coU.registerListener(this.cAm);
        aet();
        akm();
        this.cAf = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.cAa != null) {
            this.cAa.onDestory();
        }
        if (this.bGL != null) {
            this.bGL.bss();
        }
        if (this.cAe != null) {
            com.baidu.adp.lib.g.e.ga().removeCallbacks(this.cAe);
        }
    }

    public void onActivityStop() {
        if (this.cAa != null) {
            this.cAa.onStop();
        }
    }

    public boolean jE(int i) {
        this.mSkinType = i;
        if (this.cAa != null) {
            this.cAa.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void d(BdTypeListView bdTypeListView) {
        this.csk = bdTypeListView;
    }

    public void fd(boolean z) {
        if (z) {
            if (this.cAa != null) {
                this.csk.removeHeaderView(this.cAa.akt());
                this.cAh = false;
            }
        } else if (this.cAa != null && this.cAa.akt() != null && !this.cAh) {
            this.csk.addHeaderView(this.cAa.akt(), this.csk.getHeaderViewsCount());
            this.cAh = true;
        }
    }

    public void a(String str, i iVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) && iVar != null && iVar.getUserData() != null && iVar.aPO() != null) {
            e(str, iVar.getUserData().getIsMem(), iVar.aPO().isLike());
        }
    }

    public void e(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.cAd, str);
        this.bYT = i2;
        this.cAd = str;
        akc();
        if (this.cAa == null || z) {
            this.cAa = this.cAi.a(str, this.coU, i);
            this.cAa.changeSkinType(this.mSkinType);
            this.cAa.setCommonClickListener(this.cll);
        }
        this.csk.addHeaderView(this.cAa.getView());
        if (this.ckc != null) {
            this.ckc.a(this.csk, this.cAa);
        }
        if (this.coU.afQ()) {
            this.cAa.n(0, k.g(TbadkCoreApplication.getInst(), d.f.ds40), 0, k.g(this.mContext.getPageActivity(), d.f.ds20));
        } else {
            int g = k.g(TbadkCoreApplication.getInst(), d.f.ds34);
            this.cAa.n(0, g, 0, g);
        }
        akd();
    }

    public void akb() {
        if (!this.cAh && this.cAa != null) {
            this.csk.addHeaderView(this.cAa.akt());
            this.cAh = true;
        }
    }

    private void akc() {
        if (("normal_page".equals(this.cAd) || "frs_page".equals(this.cAd) || "book_page".equals(this.cAd)) && this.cAa != null) {
            this.csk.removeHeaderView(this.cAa.getView());
            this.csk.removeHeaderView(this.cAa.akt());
        }
        this.cAh = false;
    }

    private void akd() {
        if (this.cAe == null) {
            this.cAe = new Runnable() { // from class: com.baidu.tieba.frs.g.f.3
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0 && f.this.csk.isRefreshDone() && !f.this.cAf && f.this.bYT == 1 && f.this.coU.afv() != null && f.this.coU.afv().afY() != null && !f.this.coU.afv().afY().ahA()) {
                        if (("frs_page".equals(f.this.cAd) || "normal_page".equals(f.this.cAd) || "book_page".equals(f.this.cAd)) && f.this.cAa != null && f.this.cAa.aks()) {
                            TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                            f.this.ahb();
                            f.this.coU.cjx = true;
                            f.this.cAf = true;
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.ga().postDelayed(this.cAe, 4000L);
    }

    public void f(i iVar) {
        if (iVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(iVar.aPO(), iVar);
            }
        }
    }

    public void b(ForumData forumData, i iVar) {
        if (forumData != null && iVar != null) {
            float a = a(forumData);
            if (this.cAa != null) {
                this.cAa.a(forumData, iVar);
                this.cAa.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.cAa.jL(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.cAa.ff(false);
                    } else {
                        this.cAa.ff(true);
                        this.cAa.jL(forumData.getSignData().is_signed);
                    }
                }
                if (forumData.getUser_level() > this.cAl) {
                    be beVar = new be();
                    beVar.setForumName(forumData.getName());
                    beVar.setForumLevel(forumData.getUser_level());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_UPDATE_USER_LEVEL, beVar));
                    this.cAl = forumData.getUser_level();
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.cAb = forumData.getLevelupScore();
        this.cAc = forumData.getCurScore();
        if (this.cAb > 0) {
            return this.cAc / this.cAb;
        }
        return 0.0f;
    }

    public void jF(int i) {
        if (i > 1) {
            if (this.cAa != null) {
                this.cAa.fg(false);
            }
        } else if (this.cAa != null) {
            this.cAa.fg(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void e(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            ake();
        }
    }

    public void setIsMem(int i) {
        if (this.cAa != null) {
            this.cAa.setMemberType(i);
        }
    }

    public void ahb() {
        if (("normal_page".equals(this.cAd) || "frs_page".equals(this.cAd) || "book_page".equals(this.cAd)) && this.cAa != null) {
            this.cAa.ahb();
        }
    }

    public void ake() {
        if (this.cAa != null) {
            this.cAa.ahd();
        }
    }

    public void a(i iVar, boolean z) {
        if (iVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, iVar.aPO(), iVar, z);
            }
        }
    }

    public void akf() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            jH(0);
        }
    }

    public void jG(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            jH(i);
        }
    }

    public void jH(int i) {
        if (this.cAa != null) {
            this.cAa.jK(i);
        }
    }

    public void a(int i, ForumData forumData, i iVar, boolean z) {
        if (this.cAa != null) {
            this.cAa.a(forumData, iVar);
            if (forumData != null) {
                this.cAa.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.cAa.ff(false);
                }
            }
        }
    }

    public boolean akg() {
        if (("normal_page".equals(this.cAd) || "frs_page".equals(this.cAd) || "book_page".equals(this.cAd)) && this.cAa != null) {
            return this.cAa.akr();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.cAb - this.cAc) {
                z = true;
                this.cAb = signData.levelup_score;
            }
            this.cAc = i + this.cAc;
            if (this.cAc > this.cAb) {
                this.cAc = this.cAb;
            }
            if (this.cAb != 0) {
                f = this.cAc / this.cAb;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.c(z, f);
        }
    }

    public void jI(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cAa != null) {
            this.cAa.jL(i);
        }
    }

    public void g(i iVar) {
        SignData signData;
        ForumData aPO;
        if (iVar != null && iVar.aPO() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cAa != null && (signData = iVar.aPO().getSignData()) != null && (aPO = iVar.aPO()) != null) {
                this.cAa.a(aPO, iVar);
                this.cAa.jL(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.cAa.akr()) {
                    a(this.cAa, signData);
                    aPO.setCurScore(this.cAc);
                    aPO.setLevelupScore(this.cAb);
                    this.cAa.a(aPO, iVar);
                }
            }
        }
    }

    public boolean akh() {
        if (("normal_page".equals(this.cAd) || "frs_page".equals(this.cAd) || "book_page".equals(this.cAd)) && this.cAa != null) {
            return this.cAa.akh();
        }
        return false;
    }

    public boolean aki() {
        if (("normal_page".equals(this.cAd) || "frs_page".equals(this.cAd) || "book_page".equals(this.cAd)) && this.cAa != null) {
            return this.cAa.aki();
        }
        return false;
    }

    public BarImageView akj() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cAa != null) {
            return this.cAa.akj();
        }
        return null;
    }

    public void fe(boolean z) {
        if (this.coU != null) {
            i afN = this.coU.afN();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.coU.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.l.login_to_use), true, 11002)));
            } else if (afN != null && afN.aPO() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.coU.getFrom())) {
                    TiebaStatic.log(new aj("c10356").aa("fid", afN.aPO().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.coU.getFrom())) {
                    TiebaStatic.log(new aj("c10590").r("obj_type", 2).aa("fid", afN.aPO().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.coU.getFrom())) {
                    TiebaStatic.log(new aj("c10587").r("obj_type", 2).aa("fid", afN.aPO().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.coU.getFrom())) {
                    TiebaStatic.log(new aj("c10578").r("obj_type", 2).aa("fid", afN.aPO().getId()));
                }
                this.bGL.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.coU.getFrom())) {
                    TiebaStatic.eventStat(this.coU.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.coU.getFrom())) {
                    TiebaStatic.log(new aj("c10359").aa("fid", afN.aPO().getId()));
                }
                this.bGL.J(afN.aPO().getName(), afN.aPO().getId(), "FRS");
                this.cAj = z;
            }
        }
    }

    public void akk() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.coU.afN() != null && this.coU.afN().aPO() != null && this.coU.afN().aPO().getName() != null) {
            str = this.coU.afN().aPO().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cT(String.format(getPageContext().getString(d.l.attention_cancel_dialog_content), str));
        } else {
            aVar.cT(getPageContext().getString(d.l.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(d.l.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.g.f.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                i afN = f.this.coU.afN();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.coU.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) f.this.getPageContext().getPageActivity(), f.this.getPageContext().getString(d.l.login_to_use), true, 11036)));
                } else if (afN != null && afN.aPO() != null) {
                    f.this.cAg.s(afN.aPO().getName(), com.baidu.adp.lib.g.b.d(afN.aPO().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(d.l.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.g.f.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).tr();
    }

    public void akl() {
        i afN = this.coU.afN();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.coU.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.l.login_to_use), true, 11014)));
        } else if (afN != null && afN.aPO() != null) {
            FrsActivityStatic.forumName = afN.aPO().getName() == null ? "" : afN.aPO().getName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, afN.aPO()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kD(String str) {
        if (this.coU.afq() != null && this.coU.afq().aja() != null) {
            com.baidu.tieba.tbadkCore.c.brc().aa(com.baidu.tieba.tbadkCore.c.brc().g(str, this.coU.afq().aja().Om(), this.coU.afq().aja().getIsGood(), this.coU.afq().aja().getCategoryId()), false);
        }
    }

    private void aet() {
        this.bGL = new LikeModel(this.coU.getPageContext());
        this.bGL.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.g.f.7
            @Override // com.baidu.adp.base.d
            public void g(Object obj) {
                o oVar;
                if (AntiHelper.tx(f.this.bGL.getErrorCode())) {
                    AntiHelper.ar(f.this.getPageContext().getPageActivity(), f.this.bGL.getErrorString());
                    return;
                }
                i afN = f.this.coU.afN();
                if (afN != null && afN.aPO() != null && obj != null) {
                    String name = afN.aPO().getName();
                    String id = afN.aPO().getId();
                    boolean z = false;
                    if (!(obj instanceof o)) {
                        oVar = null;
                    } else {
                        oVar = (o) obj;
                    }
                    if (oVar != null && f.this.bGL.getErrorCode() == 0) {
                        z = true;
                    }
                    if (oVar == null || !z) {
                        if (f.this.bGL.getErrorCode() == 22) {
                            f.this.coU.showToast(f.this.getPageContext().getString(d.l.had_liked_forum));
                        } else if (AntiHelper.tx(f.this.bGL.getErrorCode())) {
                            AntiHelper.ar(f.this.getPageContext().getPageActivity(), f.this.bGL.getErrorString());
                        } else {
                            f.this.coU.showToast(f.this.bGL.getErrorString());
                        }
                    } else {
                        f.this.kD(name);
                        oVar.setLike(1);
                        afN.c(oVar);
                        afN.dp(oVar.bre());
                        f.this.a(afN, f.this.cAj);
                        f.this.cAj = true;
                        f.this.coU.showToast(f.this.getPageContext().getResources().getString(d.l.attention_success));
                        f.this.d(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, oVar));
                    }
                    f.this.coU.Q(Boolean.valueOf(z));
                }
            }
        });
    }

    private void akm() {
        this.cAg = new u();
        this.cAg.setFrom("from_frs");
        this.cAg.a(new u.a() { // from class: com.baidu.tieba.frs.g.f.8
            @Override // com.baidu.tieba.tbadkCore.u.a
            public void j(String str, long j) {
                i afN = f.this.coU.afN();
                if (afN != null && afN.aPO() != null) {
                    String name = afN.aPO().getName();
                    String id = afN.aPO().getId();
                    if (j == com.baidu.adp.lib.g.b.d(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.kD(str);
                        afN.aPO().setLike(0);
                        f.this.jG(0);
                        f.this.coU.P(true);
                        f.this.d(false, id);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, id));
                        o oVar = new o();
                        oVar.setLike(0);
                        oVar.setFid(id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, oVar));
                    }
                }
            }

            @Override // com.baidu.tieba.tbadkCore.u.a
            public void k(String str, long j) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.ayx().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void t(int i, int i2, int i3) {
        i afN;
        if (i > 0 && i2 > 0 && (afN = this.coU.afN()) != null && afN.aPO() != null && afN.getSignData() != null) {
            ForumData aPO = afN.aPO();
            SignData signData = afN.getSignData();
            signData.levelup_score = aPO.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            afN.d(signData);
            signData.forumId = aPO.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            int i4 = -1;
            if (aki()) {
                i4 = aPO.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(aPO.getName(), signData.sign_bonus_point, i4);
        }
    }

    public int akn() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            if (this.cAa != null && this.cAa.akt() != null && this.cAa.akt().getParent() != null) {
                return this.csk.getHeaderViewsCount() - 2;
            }
            return this.csk.getHeaderViewsCount() - 1;
        }
        return 0;
    }

    public void agM() {
        if (this.cAa != null) {
            this.cAa.agM();
        }
    }

    public static boolean h(i iVar) {
        if (iVar != null) {
            return (iVar.brG() == null || StringUtils.isNull(iVar.brG().getBookId(), true) || iVar.brG().getBookId().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean i(i iVar) {
        if (iVar != null) {
            return ((iVar.brk() == null || iVar.brk().brT() != 1) && iVar.brF() == null && (iVar.brl() == null || com.baidu.tbadk.core.util.u.v(iVar.brl().pO())) && ((iVar.aPO() == null || iVar.aPO().getFrsBannerData() == null || iVar.aPO().getFrsBannerData().getType() != 2) && (iVar.brH() == null || StringUtils.isNull(iVar.brH().pV(), true)))) ? false : true;
        }
        return false;
    }

    public void jJ(int i) {
        View findViewById;
        if (this.cAa != null && this.cAa.akt() != null && (findViewById = this.cAa.akt().findViewById(d.h.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.cAk != null) {
            this.cAk.onTouchEvent(motionEvent);
        }
    }
}
