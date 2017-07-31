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
    private LikeModel bGc;
    private int bYh;
    com.baidu.tieba.frs.entelechy.b.b cjp;
    private final View.OnClickListener ckz;

    /* renamed from: com  reason: collision with root package name */
    private com.baidu.tieba.frs.f f2com;
    private BdTypeListView crD;
    private com.baidu.tieba.frs.view.b cyc;
    private int cyd;
    private int cye;
    private String cyf;
    private Runnable cyg;
    private boolean cyh;
    private u cyi;
    private boolean cyj;
    private com.baidu.tieba.frs.entelechy.b.a cyk;
    private boolean cyl;
    private com.baidu.tieba.e.a cym;
    private int cyn;
    private CustomMessageListener cyo;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(com.baidu.tieba.frs.f fVar, com.baidu.tieba.frs.entelechy.b.a aVar) {
        super(fVar.getPageContext());
        this.crD = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.cyf = null;
        this.cyh = false;
        this.bGc = null;
        this.cyi = null;
        this.cyj = false;
        this.cyn = 0;
        this.cyo = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.g.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SignData signData;
                boolean z;
                int i;
                i afr = f.this.f2com.afr();
                if (afr != null && afr.aPh() != null && afr.aPh().getName() != null && afr.aPh().getName().equals(FrsActivityStatic.forumName)) {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name = afr.aPh().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(afr.aPh().getId())) {
                            com.baidu.tieba.tbadkCore.c.bqu().Z(name, false);
                            afr.d(signData2);
                            signData2.forumId = afr.aPh().getId();
                            signData2.forumName = afr.aPh().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = afr.aPh().getUser_level();
                        if (f.this.ajC()) {
                            i = afr.aPh().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (AntiHelper.tn(signMessage.mSignErrorCode)) {
                            AntiHelper.ar(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                        } else if (!f.this.ajA()) {
                            f.this.f2com.showToast(f.this.getPageContext().getResources().getString(d.l.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                        } else {
                            f.this.f2com.showToast(f.this.getPageContext().getResources().getString(d.l.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                        }
                    } else if (AntiHelper.tn(signMessage.mSignErrorCode)) {
                        AntiHelper.ar(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                    } else {
                        if (signMessage.mSignErrorCode == 160002) {
                            f.this.jy(1);
                        }
                        f.this.f2com.showToast(signMessage.mSignErrorString);
                    }
                }
            }
        };
        this.ckz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i afr = f.this.f2com.afr();
                if (afr != null && afr.aPh() != null && f.this.cyc != null && (view == f.this.cyc.ajD() || view == f.this.cyc.ajP())) {
                    if (f.this.f2com != null && afr.aPh() != null) {
                        TiebaStatic.log(new aj("c12046").aa("fid", afr.aPh().getId()).r("obj_locate", f.this.f2com.aft() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), afr.aPh().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == d.h.btn_love || id == d.h.love) {
                    if (!f.this.f2com.afs() && com.baidu.adp.lib.util.i.hr()) {
                        if (!aw.aO(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new aj("c10517").r("obj_locate", 1).aa("fid", f.this.f2com.getForumId()));
                        } else {
                            f.this.fb(true);
                        }
                    }
                } else if (id == d.h.btn_sign || id == d.h.sign_done || id == d.h.sign) {
                    if (!f.this.f2com.afs() && com.baidu.adp.lib.util.i.hr() && aw.aO(f.this.mContext.getPageActivity())) {
                        if (!f.this.ajB()) {
                            f.this.ajF();
                        } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(f.this.f2com.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.g(f.this.f2com.getForumId(), 0), 24002)));
                        }
                    }
                } else if (id == d.h.frs_header_games) {
                    if (aw.aO(f.this.mContext.getPageActivity()) && afr != null && afr.bqM() != null) {
                        String bqM = afr.bqM();
                        if (l.dK(bqM) == 3) {
                            l.a(f.this.f2com.getPageContext(), bqM);
                        } else {
                            at.wf().a((TbPageContext) f.this.getPageContext(), new String[]{bqM}, true);
                        }
                    }
                } else if (id == d.h.frs_bawu_center) {
                    if (afr != null && afr.getUserData() != null && afr.getUserData().isBawu()) {
                        String bqU = afr.bqU();
                        if (!al.isEmpty(bqU)) {
                            com.baidu.tbadk.browser.a.T(f.this.getPageContext().getPageActivity(), bqU);
                            if (afr.aPh() != null) {
                                TiebaStatic.log(new aj("c10502").aa("fid", afr.aPh().getId()).aa(SapiAccountManager.SESSION_UID, afr.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == d.h.btn_love_content && !f.this.f2com.afs() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page")) && f.this.cyc != null) {
                        f.this.cyc.f(view, false);
                    }
                }
            }
        };
        this.f2com = fVar;
        this.cyk = aVar;
        if (this.cyk != null) {
            this.cjp = this.cyk.ags();
        }
        this.cym = new com.baidu.tieba.e.a();
        this.cym.a(new a.InterfaceC0079a() { // from class: com.baidu.tieba.frs.g.f.2
            @Override // com.baidu.tieba.e.a.InterfaceC0079a
            public void ah(int i, int i2) {
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0079a
            public void ai(int i, int i2) {
            }
        });
    }

    public void j(Bundle bundle) {
        this.f2com.registerListener(this.cyo);
        adY();
        ajG();
        this.cyh = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.cyc != null) {
            this.cyc.onDestory();
        }
        if (this.bGc != null) {
            this.bGc.brK();
        }
        if (this.cyg != null) {
            com.baidu.adp.lib.g.e.ga().removeCallbacks(this.cyg);
        }
    }

    public void onActivityStop() {
        if (this.cyc != null) {
            this.cyc.onStop();
        }
    }

    public boolean ju(int i) {
        this.mSkinType = i;
        if (this.cyc != null) {
            this.cyc.changeSkinType(i);
            return true;
        }
        return true;
    }

    public com.baidu.tieba.frs.view.b aju() {
        return this.cyc;
    }

    public void d(BdTypeListView bdTypeListView) {
        this.crD = bdTypeListView;
    }

    public void fa(boolean z) {
        if (z) {
            if (this.cyc != null) {
                this.crD.removeHeaderView(this.cyc.ajO());
                this.cyj = false;
            }
        } else if (this.cyc != null && this.cyc.ajO() != null && !this.cyj) {
            this.crD.addHeaderView(this.cyc.ajO(), this.crD.getHeaderViewsCount());
            this.cyj = true;
        }
    }

    public void a(String str, i iVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) && iVar != null && iVar.getUserData() != null && iVar.aPh() != null) {
            e(str, iVar.getUserData().getIsMem(), iVar.aPh().isLike());
        }
    }

    public void e(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.cyf, str);
        this.bYh = i2;
        this.cyf = str;
        ajw();
        if (this.cyc == null || z) {
            this.cyc = this.cyk.a(str, this.f2com, i);
            this.cyc.changeSkinType(this.mSkinType);
            this.cyc.setCommonClickListener(this.ckz);
        }
        this.crD.addHeaderView(this.cyc.getView());
        if (this.cjp != null) {
            this.cjp.a(this.crD, this.cyc);
        }
        if (this.f2com.aft()) {
            this.cyc.getView().setPadding(0, k.g(this.f2com.getActivity(), d.f.ds40), 0, 0);
        } else {
            this.cyc.getView().setPadding(0, k.g(this.f2com.getActivity(), d.f.ds20), 0, 0);
        }
        ajx();
    }

    public void ajv() {
        if (!this.cyj && this.cyc != null) {
            this.crD.addHeaderView(this.cyc.ajO());
            this.cyj = true;
        }
    }

    private void ajw() {
        if (("normal_page".equals(this.cyf) || "frs_page".equals(this.cyf) || "book_page".equals(this.cyf)) && this.cyc != null) {
            this.crD.removeHeaderView(this.cyc.getView());
            this.crD.removeHeaderView(this.cyc.ajO());
        }
        this.cyj = false;
    }

    private void ajx() {
        if (this.cyg == null) {
            this.cyg = new Runnable() { // from class: com.baidu.tieba.frs.g.f.3
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0 && f.this.crD.isRefreshDone() && !f.this.cyh && f.this.bYh == 1 && f.this.f2com.aeZ() != null && f.this.f2com.aeZ().afB() != null && !f.this.f2com.aeZ().afB().ahf()) {
                        if (("frs_page".equals(f.this.cyf) || "normal_page".equals(f.this.cyf) || "book_page".equals(f.this.cyf)) && f.this.cyc != null && f.this.cyc.ajN()) {
                            TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                            f.this.agG();
                            f.this.f2com.ciK = true;
                            f.this.cyh = true;
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.ga().postDelayed(this.cyg, 4000L);
    }

    public void f(i iVar) {
        if (iVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(iVar.aPh(), iVar);
            }
        }
    }

    public void b(ForumData forumData, i iVar) {
        if (forumData != null && iVar != null) {
            float a = a(forumData);
            if (this.cyc != null) {
                this.cyc.a(forumData, iVar);
                this.cyc.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.cyc.jB(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.cyc.fc(false);
                    } else {
                        this.cyc.fc(true);
                        this.cyc.jB(forumData.getSignData().is_signed);
                    }
                }
                if (forumData.getUser_level() > this.cyn) {
                    be beVar = new be();
                    beVar.setForumName(forumData.getName());
                    beVar.setForumLevel(forumData.getUser_level());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_UPDATE_USER_LEVEL, beVar));
                    this.cyn = forumData.getUser_level();
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.cyd = forumData.getLevelupScore();
        this.cye = forumData.getCurScore();
        if (this.cyd > 0) {
            return this.cye / this.cyd;
        }
        return 0.0f;
    }

    public void jv(int i) {
        if (i > 1) {
            if (this.cyc != null) {
                this.cyc.fd(false);
            }
        } else if (this.cyc != null) {
            this.cyc.fd(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void e(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            ajy();
        }
    }

    public void setIsMem(int i) {
        if (this.cyc != null) {
            this.cyc.setMemberType(i);
        }
    }

    public void agG() {
        if (("normal_page".equals(this.cyf) || "frs_page".equals(this.cyf) || "book_page".equals(this.cyf)) && this.cyc != null) {
            this.cyc.agG();
        }
    }

    public void ajy() {
        if (this.cyc != null) {
            this.cyc.agI();
        }
    }

    public void a(i iVar, boolean z) {
        if (iVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, iVar.aPh(), iVar, z);
            }
        }
    }

    public void ajz() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            jx(0);
        }
    }

    public void jw(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            jx(i);
        }
    }

    public void jx(int i) {
        if (this.cyc != null) {
            this.cyc.jA(i);
        }
    }

    public void a(int i, ForumData forumData, i iVar, boolean z) {
        if (this.cyc != null) {
            this.cyc.a(forumData, iVar);
            if (forumData != null) {
                this.cyc.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.cyc.fc(false);
                }
            }
        }
    }

    public boolean ajA() {
        if (("normal_page".equals(this.cyf) || "frs_page".equals(this.cyf) || "book_page".equals(this.cyf)) && this.cyc != null) {
            return this.cyc.ajM();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.cyd - this.cye) {
                z = true;
                this.cyd = signData.levelup_score;
            }
            this.cye = i + this.cye;
            if (this.cye > this.cyd) {
                this.cye = this.cyd;
            }
            if (this.cyd != 0) {
                f = this.cye / this.cyd;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.c(z, f);
        }
    }

    public void jy(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cyc != null) {
            this.cyc.jB(i);
        }
    }

    public void g(i iVar) {
        SignData signData;
        ForumData aPh;
        if (iVar != null && iVar.aPh() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cyc != null && (signData = iVar.aPh().getSignData()) != null && (aPh = iVar.aPh()) != null) {
                this.cyc.a(aPh, iVar);
                this.cyc.jB(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.cyc.ajM()) {
                    a(this.cyc, signData);
                    aPh.setCurScore(this.cye);
                    aPh.setLevelupScore(this.cyd);
                    this.cyc.a(aPh, iVar);
                }
            }
        }
    }

    public boolean ajB() {
        if (("normal_page".equals(this.cyf) || "frs_page".equals(this.cyf) || "book_page".equals(this.cyf)) && this.cyc != null) {
            return this.cyc.ajB();
        }
        return false;
    }

    public boolean ajC() {
        if (("normal_page".equals(this.cyf) || "frs_page".equals(this.cyf) || "book_page".equals(this.cyf)) && this.cyc != null) {
            return this.cyc.ajC();
        }
        return false;
    }

    public BarImageView ajD() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cyc != null) {
            return this.cyc.ajD();
        }
        return null;
    }

    public void fb(boolean z) {
        if (this.f2com != null) {
            i afr = this.f2com.afr();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.f2com.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.l.login_to_use), true, 11002)));
            } else if (afr != null && afr.aPh() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.f2com.getFrom())) {
                    TiebaStatic.log(new aj("c10356").aa("fid", afr.aPh().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.f2com.getFrom())) {
                    TiebaStatic.log(new aj("c10590").r("obj_type", 2).aa("fid", afr.aPh().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.f2com.getFrom())) {
                    TiebaStatic.log(new aj("c10587").r("obj_type", 2).aa("fid", afr.aPh().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.f2com.getFrom())) {
                    TiebaStatic.log(new aj("c10578").r("obj_type", 2).aa("fid", afr.aPh().getId()));
                }
                this.bGc.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.f2com.getFrom())) {
                    TiebaStatic.eventStat(this.f2com.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.f2com.getFrom())) {
                    TiebaStatic.log(new aj("c10359").aa("fid", afr.aPh().getId()));
                }
                this.bGc.J(afr.aPh().getName(), afr.aPh().getId(), "FRS");
                this.cyl = z;
            }
        }
    }

    public void ajE() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.f2com.afr() != null && this.f2com.afr().aPh() != null && this.f2com.afr().aPh().getName() != null) {
            str = this.f2com.afr().aPh().getName();
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
                i afr = f.this.f2com.afr();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.f2com.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) f.this.getPageContext().getPageActivity(), f.this.getPageContext().getString(d.l.login_to_use), true, 11036)));
                } else if (afr != null && afr.aPh() != null) {
                    f.this.cyi.s(afr.aPh().getName(), com.baidu.adp.lib.g.b.d(afr.aPh().getId(), 0L));
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

    public void ajF() {
        i afr = this.f2com.afr();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.f2com.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.l.login_to_use), true, 11014)));
        } else if (afr != null && afr.aPh() != null) {
            FrsActivityStatic.forumName = afr.aPh().getName() == null ? "" : afr.aPh().getName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, afr.aPh()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kz(String str) {
        if (this.f2com.aeU() != null && this.f2com.aeU().ait() != null) {
            com.baidu.tieba.tbadkCore.c.bqu().Z(com.baidu.tieba.tbadkCore.c.bqu().g(str, this.f2com.aeU().ait().Om(), this.f2com.aeU().ait().getIsGood(), this.f2com.aeU().ait().getCategoryId()), false);
        }
    }

    private void adY() {
        this.bGc = new LikeModel(this.f2com.getPageContext());
        this.bGc.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.g.f.7
            @Override // com.baidu.adp.base.d
            public void g(Object obj) {
                o oVar;
                if (AntiHelper.tn(f.this.bGc.getErrorCode())) {
                    AntiHelper.ar(f.this.getPageContext().getPageActivity(), f.this.bGc.getErrorString());
                    return;
                }
                i afr = f.this.f2com.afr();
                if (afr != null && afr.aPh() != null && obj != null) {
                    String name = afr.aPh().getName();
                    String id = afr.aPh().getId();
                    boolean z = false;
                    if (!(obj instanceof o)) {
                        oVar = null;
                    } else {
                        oVar = (o) obj;
                    }
                    if (oVar != null && f.this.bGc.getErrorCode() == 0) {
                        z = true;
                    }
                    if (oVar == null || !z) {
                        if (f.this.bGc.getErrorCode() == 22) {
                            f.this.f2com.showToast(f.this.getPageContext().getString(d.l.had_liked_forum));
                        } else if (AntiHelper.tn(f.this.bGc.getErrorCode())) {
                            AntiHelper.ar(f.this.getPageContext().getPageActivity(), f.this.bGc.getErrorString());
                        } else {
                            f.this.f2com.showToast(f.this.bGc.getErrorString());
                        }
                    } else {
                        f.this.kz(name);
                        oVar.setLike(1);
                        afr.c(oVar);
                        afr.dm(oVar.bqw());
                        f.this.a(afr, f.this.cyl);
                        f.this.cyl = true;
                        f.this.f2com.showToast(f.this.getPageContext().getResources().getString(d.l.attention_success));
                        f.this.d(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, oVar));
                    }
                    f.this.f2com.Q(Boolean.valueOf(z));
                }
            }
        });
    }

    private void ajG() {
        this.cyi = new u();
        this.cyi.setFrom("from_frs");
        this.cyi.a(new u.a() { // from class: com.baidu.tieba.frs.g.f.8
            @Override // com.baidu.tieba.tbadkCore.u.a
            public void j(String str, long j) {
                i afr = f.this.f2com.afr();
                if (afr != null && afr.aPh() != null) {
                    String name = afr.aPh().getName();
                    String id = afr.aPh().getId();
                    if (j == com.baidu.adp.lib.g.b.d(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.kz(str);
                        afr.aPh().setLike(0);
                        f.this.jw(0);
                        f.this.f2com.P(true);
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
        com.baidu.tieba.im.settingcache.d.axQ().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void t(int i, int i2, int i3) {
        i afr;
        if (i > 0 && i2 > 0 && (afr = this.f2com.afr()) != null && afr.aPh() != null && afr.getSignData() != null) {
            ForumData aPh = afr.aPh();
            SignData signData = afr.getSignData();
            signData.levelup_score = aPh.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            afr.d(signData);
            signData.forumId = aPh.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            int i4 = -1;
            if (ajC()) {
                i4 = aPh.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(aPh.getName(), signData.sign_bonus_point, i4);
        }
    }

    public int ajH() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            if (this.cyc != null && this.cyc.ajO() != null && this.cyc.ajO().getParent() != null) {
                return this.crD.getHeaderViewsCount() - 2;
            }
            return this.crD.getHeaderViewsCount() - 1;
        }
        return 0;
    }

    public void agr() {
        if (this.cyc != null) {
            this.cyc.agr();
        }
    }

    public static boolean h(i iVar) {
        if (iVar != null) {
            return (iVar.bqY() == null || StringUtils.isNull(iVar.bqY().getBookId(), true) || iVar.bqY().getBookId().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean i(i iVar) {
        if (iVar != null) {
            return ((iVar.bqC() == null || iVar.bqC().brl() != 1) && iVar.bqX() == null && (iVar.bqD() == null || com.baidu.tbadk.core.util.u.v(iVar.bqD().pO())) && ((iVar.aPh() == null || iVar.aPh().getFrsBannerData() == null || iVar.aPh().getFrsBannerData().getType() != 2) && (iVar.bqZ() == null || StringUtils.isNull(iVar.bqZ().pV(), true)))) ? false : true;
        }
        return false;
    }

    public void jz(int i) {
        View findViewById;
        if (this.cyc != null && this.cyc.ajO() != null && (findViewById = this.cyc.ajO().findViewById(d.h.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.cym != null) {
            this.cym.onTouchEvent(motionEvent);
        }
    }
}
