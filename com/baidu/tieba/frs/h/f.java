package com.baidu.tieba.frs.h;

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
    private LikeModel bES;
    private int bXb;
    com.baidu.tieba.frs.entelechy.b.b cij;
    private final View.OnClickListener cjs;
    private com.baidu.tieba.frs.f cna;
    private BdTypeListView cqr;
    private com.baidu.tieba.frs.view.b cwI;
    private int cwJ;
    private int cwK;
    private String cwL;
    private Runnable cwM;
    private boolean cwN;
    private u cwO;
    private boolean cwP;
    private com.baidu.tieba.frs.entelechy.b.a cwQ;
    private boolean cwR;
    private com.baidu.tieba.e.a cwS;
    private int cwT;
    private CustomMessageListener cwU;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(com.baidu.tieba.frs.f fVar, com.baidu.tieba.frs.entelechy.b.a aVar) {
        super(fVar.getPageContext());
        this.cqr = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.cwL = null;
        this.cwN = false;
        this.bES = null;
        this.cwO = null;
        this.cwP = false;
        this.cwT = 0;
        this.cwU = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.h.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SignData signData;
                boolean z;
                int i;
                i afm = f.this.cna.afm();
                if (afm != null && afm.aOW() != null && afm.aOW().getName() != null && afm.aOW().getName().equals(FrsActivityStatic.forumName)) {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name = afm.aOW().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(afm.aOW().getId())) {
                            com.baidu.tieba.tbadkCore.c.bqn().aa(name, false);
                            afm.d(signData2);
                            signData2.forumId = afm.aOW().getId();
                            signData2.forumName = afm.aOW().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = afm.aOW().getUser_level();
                        if (f.this.ajp()) {
                            i = afm.aOW().getUser_level();
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
                        } else if (!f.this.ajn()) {
                            f.this.cna.showToast(f.this.getPageContext().getResources().getString(d.l.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                        } else {
                            f.this.cna.showToast(f.this.getPageContext().getResources().getString(d.l.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                        }
                    } else if (AntiHelper.tn(signMessage.mSignErrorCode)) {
                        AntiHelper.ar(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                    } else {
                        if (signMessage.mSignErrorCode == 160002) {
                            f.this.jy(1);
                        }
                        f.this.cna.showToast(signMessage.mSignErrorString);
                    }
                }
            }
        };
        this.cjs = new View.OnClickListener() { // from class: com.baidu.tieba.frs.h.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i afm = f.this.cna.afm();
                if (afm != null && afm.aOW() != null && f.this.cwI != null && (view == f.this.cwI.ajq() || view == f.this.cwI.ajB() || view == f.this.cwI.ajC())) {
                    if (f.this.cna != null && afm.aOW() != null) {
                        TiebaStatic.log(new aj("c12046").aa("fid", afm.aOW().getId()).r("obj_locate", f.this.cna.afo() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), afm.aOW().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == d.h.tv_love) {
                    if (!f.this.cna.afn() && com.baidu.adp.lib.util.i.hh()) {
                        if (!aw.aN(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new aj("c10517").r("obj_locate", 1).aa("fid", f.this.cna.getForumId()));
                        } else {
                            f.this.fb(true);
                        }
                    }
                } else if (id == d.h.tv_sign) {
                    if (!f.this.cna.afn() && com.baidu.adp.lib.util.i.hh() && aw.aN(f.this.mContext.getPageActivity())) {
                        if (!f.this.ajo()) {
                            f.this.ajs();
                        } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(f.this.cna.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.g(f.this.cna.getForumId(), 0), 24002)));
                        }
                    }
                } else if (id == d.h.frs_header_games) {
                    if (aw.aN(f.this.mContext.getPageActivity()) && afm != null && afm.bqF() != null) {
                        String bqF = afm.bqF();
                        if (l.dE(bqF) == 3) {
                            l.a(f.this.cna.getPageContext(), bqF);
                        } else {
                            at.vV().a((TbPageContext) f.this.getPageContext(), new String[]{bqF}, true);
                        }
                    }
                } else if (id == d.h.frs_bawu_center) {
                    if (afm != null && afm.getUserData() != null && afm.getUserData().isBawu()) {
                        String bqN = afm.bqN();
                        if (!al.isEmpty(bqN)) {
                            com.baidu.tbadk.browser.a.T(f.this.getPageContext().getPageActivity(), bqN);
                            if (afm.aOW() != null) {
                                TiebaStatic.log(new aj("c10502").aa("fid", afm.aOW().getId()).aa(SapiAccountManager.SESSION_UID, afm.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == d.h.level_container && !f.this.cna.afn() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page")) && f.this.cwI != null) {
                        f.this.cwI.f(view, false);
                    }
                }
            }
        };
        this.cna = fVar;
        this.cwQ = aVar;
        if (this.cwQ != null) {
            this.cij = this.cwQ.agl();
        }
        this.cwS = new com.baidu.tieba.e.a();
        this.cwS.a(new a.InterfaceC0080a() { // from class: com.baidu.tieba.frs.h.f.2
            @Override // com.baidu.tieba.e.a.InterfaceC0080a
            public void ag(int i, int i2) {
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0080a
            public void ah(int i, int i2) {
            }
        });
    }

    public void j(Bundle bundle) {
        this.cna.registerListener(this.cwU);
        adT();
        ajt();
        this.cwN = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.cwI != null) {
            this.cwI.onDestory();
        }
        if (this.bES != null) {
            this.bES.brD();
        }
        if (this.cwM != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.cwM);
        }
    }

    public void onActivityStop() {
        if (this.cwI != null) {
            this.cwI.onStop();
        }
    }

    public boolean ju(int i) {
        this.mSkinType = i;
        if (this.cwI != null) {
            this.cwI.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void d(BdTypeListView bdTypeListView) {
        this.cqr = bdTypeListView;
    }

    public void fa(boolean z) {
        if (z) {
            if (this.cwI != null) {
                this.cqr.removeHeaderView(this.cwI.ajA());
                this.cwP = false;
            }
        } else if (this.cwI != null && this.cwI.ajA() != null && !this.cwP) {
            this.cqr.addHeaderView(this.cwI.ajA(), this.cqr.getHeaderViewsCount());
            this.cwP = true;
        }
    }

    public void a(String str, i iVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) && iVar != null && iVar.getUserData() != null && iVar.aOW() != null) {
            e(str, iVar.getUserData().getIsMem(), iVar.aOW().isLike());
        }
    }

    public void e(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.cwL, str);
        this.bXb = i2;
        this.cwL = str;
        ajj();
        if (this.cwI == null || z) {
            this.cwI = this.cwQ.a(str, this.cna, i);
            this.cwI.changeSkinType(this.mSkinType);
            this.cwI.setCommonClickListener(this.cjs);
        }
        this.cqr.addHeaderView(this.cwI.getView());
        if (this.cij != null) {
            this.cij.a(this.cqr, this.cwI);
        }
        if (this.cna.afo()) {
            this.cwI.m(0, k.g(TbadkCoreApplication.getInst(), d.f.ds40), 0, k.g(this.mContext.getPageActivity(), d.f.ds20));
        } else {
            int g = k.g(TbadkCoreApplication.getInst(), d.f.ds34);
            this.cwI.m(0, g, 0, g);
        }
        ajk();
    }

    public void aji() {
        if (!this.cwP && this.cwI != null) {
            this.cqr.addHeaderView(this.cwI.ajA());
            this.cwP = true;
        }
    }

    private void ajj() {
        if (("normal_page".equals(this.cwL) || "frs_page".equals(this.cwL) || "book_page".equals(this.cwL)) && this.cwI != null) {
            this.cqr.removeHeaderView(this.cwI.getView());
            this.cqr.removeHeaderView(this.cwI.ajA());
        }
        this.cwP = false;
    }

    private void ajk() {
        if (this.cwM == null) {
            this.cwM = new Runnable() { // from class: com.baidu.tieba.frs.h.f.3
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0 && f.this.cqr.isRefreshDone() && !f.this.cwN && f.this.bXb == 1 && f.this.cna.aeU() != null && f.this.cna.aeU().afw() != null && !f.this.cna.aeU().afw().agY()) {
                        if (("frs_page".equals(f.this.cwL) || "normal_page".equals(f.this.cwL) || "book_page".equals(f.this.cwL)) && f.this.cwI != null && f.this.cwI.ajz()) {
                            TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                            f.this.agz();
                            f.this.cna.chD = true;
                            f.this.cwN = true;
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.fP().postDelayed(this.cwM, 4000L);
    }

    public void f(i iVar) {
        if (iVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(iVar.aOW(), iVar);
            }
        }
    }

    public void b(ForumData forumData, i iVar) {
        if (forumData != null && iVar != null) {
            float a = a(forumData);
            if (this.cwI != null) {
                this.cwI.a(forumData, iVar);
                this.cwI.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.cwI.jB(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.cwI.fc(false);
                    } else {
                        this.cwI.fc(true);
                        this.cwI.jB(forumData.getSignData().is_signed);
                    }
                }
                if (forumData.getUser_level() > this.cwT) {
                    be beVar = new be();
                    beVar.setForumName(forumData.getName());
                    beVar.setForumLevel(forumData.getUser_level());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_UPDATE_USER_LEVEL, beVar));
                    this.cwT = forumData.getUser_level();
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.cwJ = forumData.getLevelupScore();
        this.cwK = forumData.getCurScore();
        if (this.cwJ > 0) {
            return this.cwK / this.cwJ;
        }
        return 0.0f;
    }

    public void jv(int i) {
        if (i > 1) {
            if (this.cwI != null) {
                this.cwI.fd(false);
            }
        } else if (this.cwI != null) {
            this.cwI.fd(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void e(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            ajl();
        }
    }

    public void setIsMem(int i) {
        if (this.cwI != null) {
            this.cwI.setMemberType(i);
        }
    }

    public void agz() {
        if (("normal_page".equals(this.cwL) || "frs_page".equals(this.cwL) || "book_page".equals(this.cwL)) && this.cwI != null) {
            this.cwI.agz();
        }
    }

    public void ajl() {
        if (this.cwI != null) {
            this.cwI.agB();
        }
    }

    public void a(i iVar, boolean z) {
        if (iVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, iVar.aOW(), iVar, z);
            }
        }
    }

    public void ajm() {
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
        if (this.cwI != null) {
            this.cwI.jA(i);
        }
    }

    public void a(int i, ForumData forumData, i iVar, boolean z) {
        if (this.cwI != null) {
            this.cwI.a(forumData, iVar);
            if (forumData != null) {
                this.cwI.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.cwI.fc(false);
                }
            }
        }
    }

    public boolean ajn() {
        if (("normal_page".equals(this.cwL) || "frs_page".equals(this.cwL) || "book_page".equals(this.cwL)) && this.cwI != null) {
            return this.cwI.ajy();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.cwJ - this.cwK) {
                z = true;
                this.cwJ = signData.levelup_score;
            }
            this.cwK = i + this.cwK;
            if (this.cwK > this.cwJ) {
                this.cwK = this.cwJ;
            }
            if (this.cwJ != 0) {
                f = this.cwK / this.cwJ;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.c(z, f);
        }
    }

    public void jy(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cwI != null) {
            this.cwI.jB(i);
        }
    }

    public void g(i iVar) {
        SignData signData;
        ForumData aOW;
        if (iVar != null && iVar.aOW() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cwI != null && (signData = iVar.aOW().getSignData()) != null && (aOW = iVar.aOW()) != null) {
                this.cwI.a(aOW, iVar);
                this.cwI.jB(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.cwI.ajy()) {
                    a(this.cwI, signData);
                    aOW.setCurScore(this.cwK);
                    aOW.setLevelupScore(this.cwJ);
                    this.cwI.a(aOW, iVar);
                }
            }
        }
    }

    public boolean ajo() {
        if (("normal_page".equals(this.cwL) || "frs_page".equals(this.cwL) || "book_page".equals(this.cwL)) && this.cwI != null) {
            return this.cwI.ajo();
        }
        return false;
    }

    public boolean ajp() {
        if (("normal_page".equals(this.cwL) || "frs_page".equals(this.cwL) || "book_page".equals(this.cwL)) && this.cwI != null) {
            return this.cwI.ajp();
        }
        return false;
    }

    public BarImageView ajq() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cwI != null) {
            return this.cwI.ajq();
        }
        return null;
    }

    public void fb(boolean z) {
        if (this.cna != null) {
            i afm = this.cna.afm();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.cna.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.l.login_to_use), true, 11002)));
            } else if (afm != null && afm.aOW() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.cna.getFrom())) {
                    TiebaStatic.log(new aj("c10356").aa("fid", afm.aOW().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.cna.getFrom())) {
                    TiebaStatic.log(new aj("c10590").r("obj_type", 2).aa("fid", afm.aOW().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.cna.getFrom())) {
                    TiebaStatic.log(new aj("c10587").r("obj_type", 2).aa("fid", afm.aOW().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.cna.getFrom())) {
                    TiebaStatic.log(new aj("c10578").r("obj_type", 2).aa("fid", afm.aOW().getId()));
                }
                this.bES.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.cna.getFrom())) {
                    TiebaStatic.eventStat(this.cna.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.cna.getFrom())) {
                    TiebaStatic.log(new aj("c10359").aa("fid", afm.aOW().getId()));
                }
                this.bES.J(afm.aOW().getName(), afm.aOW().getId(), "FRS");
                this.cwR = z;
            }
        }
    }

    public void ajr() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.cna.afm() != null && this.cna.afm().aOW() != null && this.cna.afm().aOW().getName() != null) {
            str = this.cna.afm().aOW().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cN(String.format(getPageContext().getString(d.l.attention_cancel_dialog_content), str));
        } else {
            aVar.cN(getPageContext().getString(d.l.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(d.l.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.h.f.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                i afm = f.this.cna.afm();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.cna.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) f.this.getPageContext().getPageActivity(), f.this.getPageContext().getString(d.l.login_to_use), true, 11036)));
                } else if (afm != null && afm.aOW() != null) {
                    f.this.cwO.r(afm.aOW().getName(), com.baidu.adp.lib.g.b.c(afm.aOW().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(d.l.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.h.f.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).th();
    }

    public void ajs() {
        i afm = this.cna.afm();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.cna.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.l.login_to_use), true, 11014)));
        } else if (afm != null && afm.aOW() != null) {
            FrsActivityStatic.forumName = afm.aOW().getName() == null ? "" : afm.aOW().getName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, afm.aOW()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kv(String str) {
        if (this.cna.aeP() != null && this.cna.aeP().aih() != null) {
            com.baidu.tieba.tbadkCore.c.bqn().aa(com.baidu.tieba.tbadkCore.c.bqn().g(str, this.cna.aeP().aih().Oh(), this.cna.aeP().aih().getIsGood(), this.cna.aeP().aih().getCategoryId()), false);
        }
    }

    private void adT() {
        this.bES = new LikeModel(this.cna.getPageContext());
        this.bES.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.h.f.7
            @Override // com.baidu.adp.base.d
            public void g(Object obj) {
                o oVar;
                if (AntiHelper.tn(f.this.bES.getErrorCode())) {
                    AntiHelper.ar(f.this.getPageContext().getPageActivity(), f.this.bES.getErrorString());
                    return;
                }
                i afm = f.this.cna.afm();
                if (afm != null && afm.aOW() != null && obj != null) {
                    String name = afm.aOW().getName();
                    String id = afm.aOW().getId();
                    boolean z = false;
                    if (!(obj instanceof o)) {
                        oVar = null;
                    } else {
                        oVar = (o) obj;
                    }
                    if (oVar != null && f.this.bES.getErrorCode() == 0) {
                        z = true;
                    }
                    if (oVar == null || !z) {
                        if (f.this.bES.getErrorCode() == 22) {
                            f.this.cna.showToast(f.this.getPageContext().getString(d.l.had_liked_forum));
                        } else if (AntiHelper.tn(f.this.bES.getErrorCode())) {
                            AntiHelper.ar(f.this.getPageContext().getPageActivity(), f.this.bES.getErrorString());
                        } else {
                            f.this.cna.showToast(f.this.bES.getErrorString());
                        }
                    } else {
                        f.this.kv(name);
                        oVar.setLike(1);
                        afm.c(oVar);
                        afm.dm(oVar.bqp());
                        f.this.a(afm, f.this.cwR);
                        f.this.cwR = true;
                        f.this.cna.showToast(f.this.getPageContext().getResources().getString(d.l.attention_success));
                        f.this.d(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, oVar));
                    }
                    f.this.cna.Q(Boolean.valueOf(z));
                }
            }
        });
    }

    private void ajt() {
        this.cwO = new u();
        this.cwO.setFrom("from_frs");
        this.cwO.a(new u.a() { // from class: com.baidu.tieba.frs.h.f.8
            @Override // com.baidu.tieba.tbadkCore.u.a
            public void i(String str, long j) {
                i afm = f.this.cna.afm();
                if (afm != null && afm.aOW() != null) {
                    String name = afm.aOW().getName();
                    String id = afm.aOW().getId();
                    if (j == com.baidu.adp.lib.g.b.c(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.kv(str);
                        afm.aOW().setLike(0);
                        f.this.jw(0);
                        f.this.cna.P(true);
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
            public void j(String str, long j) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.axF().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void t(int i, int i2, int i3) {
        i afm;
        if (i > 0 && i2 > 0 && (afm = this.cna.afm()) != null && afm.aOW() != null && afm.getSignData() != null) {
            ForumData aOW = afm.aOW();
            SignData signData = afm.getSignData();
            signData.levelup_score = aOW.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            afm.d(signData);
            signData.forumId = aOW.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            int i4 = -1;
            if (ajp()) {
                i4 = aOW.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(aOW.getName(), signData.sign_bonus_point, i4);
        }
    }

    public int aju() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            if (this.cwI != null && this.cwI.ajA() != null && this.cwI.ajA().getParent() != null) {
                return this.cqr.getHeaderViewsCount() - 2;
            }
            return this.cqr.getHeaderViewsCount() - 1;
        }
        return 0;
    }

    public void agk() {
        if (this.cwI != null) {
            this.cwI.agk();
        }
    }

    public static boolean h(i iVar) {
        if (iVar != null) {
            return (iVar.bqR() == null || StringUtils.isNull(iVar.bqR().getBookId(), true) || iVar.bqR().getBookId().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean i(i iVar) {
        if (iVar != null) {
            return ((iVar.bqv() == null || iVar.bqv().bre() != 1) && iVar.bqQ() == null && (iVar.bqw() == null || com.baidu.tbadk.core.util.u.v(iVar.bqw().pE())) && ((iVar.aOW() == null || iVar.aOW().getFrsBannerData() == null || iVar.aOW().getFrsBannerData().getType() != 2) && (iVar.bqS() == null || StringUtils.isNull(iVar.bqS().pL(), true)))) ? false : true;
        }
        return false;
    }

    public void jz(int i) {
        View findViewById;
        if (this.cwI != null && this.cwI.ajA() != null && (findViewById = this.cwI.ajA().findViewById(d.h.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.cwS != null) {
            this.cwS.onTouchEvent(motionEvent);
        }
    }
}
