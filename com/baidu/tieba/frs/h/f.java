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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.v;
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
    private LikeModel bJG;
    private com.baidu.tieba.frs.entelechy.b.a cGA;
    private boolean cGB;
    private com.baidu.tieba.e.a cGC;
    private int cGD;
    private CustomMessageListener cGE;
    private com.baidu.tieba.frs.view.b cGs;
    private int cGt;
    private int cGu;
    private String cGv;
    private Runnable cGw;
    private boolean cGx;
    private u cGy;
    private boolean cGz;
    private int cbR;
    com.baidu.tieba.frs.entelechy.b.b cpw;
    private final View.OnClickListener cqF;
    private com.baidu.tieba.frs.f cvA;
    private BdTypeListView cyN;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(com.baidu.tieba.frs.f fVar, com.baidu.tieba.frs.entelechy.b.a aVar) {
        super(fVar.getPageContext());
        this.cyN = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.cGv = null;
        this.cGx = false;
        this.bJG = null;
        this.cGy = null;
        this.cGz = false;
        this.cGD = 0;
        this.cGE = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.h.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SignData signData;
                boolean z;
                int i;
                i ahf = f.this.cvA.ahf();
                if (ahf != null && ahf.aOV() != null && ahf.aOV().getName() != null && ahf.aOV().getName().equals(FrsActivityStatic.forumName)) {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name = ahf.aOV().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(ahf.aOV().getId())) {
                            f.this.kX(name);
                            ahf.d(signData2);
                            signData2.forumId = ahf.aOV().getId();
                            signData2.forumName = ahf.aOV().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = ahf.aOV().getUser_level();
                        if (f.this.alK()) {
                            i = ahf.aOV().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (AntiHelper.tz(signMessage.mSignErrorCode)) {
                            AntiHelper.ar(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                        } else if (!f.this.alI()) {
                            f.this.cvA.showToast(f.this.getPageContext().getResources().getString(d.l.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                        } else {
                            f.this.cvA.showToast(f.this.getPageContext().getResources().getString(d.l.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                        }
                    } else if (AntiHelper.tz(signMessage.mSignErrorCode)) {
                        AntiHelper.ar(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                    } else {
                        if (signMessage.mSignErrorCode == 160002) {
                            f.this.jW(1);
                        }
                        f.this.cvA.showToast(signMessage.mSignErrorString);
                    }
                }
            }
        };
        this.cqF = new View.OnClickListener() { // from class: com.baidu.tieba.frs.h.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i ahf = f.this.cvA.ahf();
                if (ahf != null && ahf.aOV() != null && f.this.cGs != null && (view == f.this.cGs.alL() || view == f.this.cGs.alW() || view == f.this.cGs.alX())) {
                    if (f.this.cvA != null && ahf.aOV() != null) {
                        TiebaStatic.log(new ak("c12046").ad("fid", ahf.aOV().getId()).r("obj_locate", f.this.cvA.ahi() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), ahf.aOV().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == d.h.tv_love) {
                    if (!f.this.cvA.ahg() && com.baidu.adp.lib.util.i.hi()) {
                        if (!ax.aT(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new ak("c10517").r("obj_locate", 1).ad("fid", f.this.cvA.getForumId()));
                        } else {
                            f.this.fm(true);
                        }
                    }
                } else if (id == d.h.tv_sign) {
                    if (!f.this.cvA.ahg() && com.baidu.adp.lib.util.i.hi() && ax.aT(f.this.mContext.getPageActivity())) {
                        if (!f.this.alJ()) {
                            f.this.alN();
                        } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(f.this.cvA.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.g(f.this.cvA.getForumId(), 0), 24002)));
                        }
                    }
                } else if (id == d.h.frs_header_games) {
                    if (ax.aT(f.this.mContext.getPageActivity()) && ahf != null && ahf.bqC() != null) {
                        String bqC = ahf.bqC();
                        if (m.dF(bqC) == 3) {
                            m.a(f.this.cvA.getPageContext(), bqC);
                        } else {
                            au.wd().a((TbPageContext) f.this.getPageContext(), new String[]{bqC}, true);
                        }
                    }
                } else if (id == d.h.frs_bawu_center) {
                    if (ahf != null && ahf.getUserData() != null && ahf.getUserData().isBawu()) {
                        String bqK = ahf.bqK();
                        if (!am.isEmpty(bqK)) {
                            com.baidu.tbadk.browser.a.T(f.this.getPageContext().getPageActivity(), bqK);
                            if (ahf.aOV() != null) {
                                TiebaStatic.log(new ak("c10502").ad("fid", ahf.aOV().getId()).ad(SapiAccountManager.SESSION_UID, ahf.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == d.h.level_container && !f.this.cvA.ahg() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page")) && f.this.cGs != null) {
                        f.this.cGs.f(view, false);
                    }
                }
            }
        };
        this.cvA = fVar;
        this.cGA = aVar;
        if (this.cGA != null) {
            this.cpw = this.cGA.ait();
        }
        this.cGC = new com.baidu.tieba.e.a();
        this.cGC.a(new a.InterfaceC0082a() { // from class: com.baidu.tieba.frs.h.f.2
            @Override // com.baidu.tieba.e.a.InterfaceC0082a
            public void ag(int i, int i2) {
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0082a
            public void ah(int i, int i2) {
            }
        });
    }

    public void l(Bundle bundle) {
        this.cvA.registerListener(this.cGE);
        afN();
        alO();
        this.cGx = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.cGs != null) {
            this.cGs.onDestory();
        }
        if (this.bJG != null) {
            this.bJG.brA();
        }
        if (this.cGw != null) {
            com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.cGw);
        }
    }

    public void onActivityStop() {
        if (this.cGs != null) {
            this.cGs.onStop();
        }
    }

    public boolean jS(int i) {
        this.mSkinType = i;
        if (this.cGs != null) {
            this.cGs.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void d(BdTypeListView bdTypeListView) {
        this.cyN = bdTypeListView;
    }

    public void fl(boolean z) {
        if (z) {
            if (this.cGs != null) {
                this.cyN.removeHeaderView(this.cGs.alV());
                this.cGz = false;
            }
        } else if (this.cGs != null && this.cGs.alV() != null && !this.cGz) {
            this.cyN.addHeaderView(this.cGs.alV(), this.cyN.getHeaderViewsCount());
            this.cGz = true;
        }
    }

    public void a(String str, i iVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) && iVar != null && iVar.getUserData() != null && iVar.aOV() != null) {
            f(str, iVar.getUserData().getIsMem(), iVar.aOV().isLike());
        }
    }

    public void f(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.cGv, str);
        this.cbR = i2;
        this.cGv = str;
        alE();
        if (this.cGs == null || z) {
            this.cGs = this.cGA.a(str, this.cvA, i);
            this.cGs.changeSkinType(this.mSkinType);
            this.cGs.setCommonClickListener(this.cqF);
        }
        this.cyN.addHeaderView(this.cGs.getView());
        if (this.cpw != null) {
            this.cpw.a(this.cyN, this.cGs);
        }
        if (this.cvA.ahi()) {
            this.cGs.l(0, k.g(TbadkCoreApplication.getInst(), d.f.ds40), 0, k.g(this.mContext.getPageActivity(), d.f.ds20));
        } else {
            int g = k.g(TbadkCoreApplication.getInst(), d.f.ds34);
            this.cGs.l(0, g, 0, g);
        }
        alF();
    }

    public void alD() {
        if (!this.cGz && this.cGs != null) {
            this.cyN.addHeaderView(this.cGs.alV());
            this.cGz = true;
        }
    }

    private void alE() {
        if (("normal_page".equals(this.cGv) || "frs_page".equals(this.cGv) || "book_page".equals(this.cGv)) && this.cGs != null) {
            this.cyN.removeHeaderView(this.cGs.getView());
            this.cyN.removeHeaderView(this.cGs.alV());
        }
        this.cGz = false;
    }

    private void alF() {
        if (this.cGw == null) {
            this.cGw = new Runnable() { // from class: com.baidu.tieba.frs.h.f.3
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0 && f.this.cyN.isRefreshDone() && !f.this.cGx && f.this.cbR == 1 && f.this.cvA.agN() != null && f.this.cvA.agN().ahq() != null && !f.this.cvA.agN().ahq().ajh()) {
                        if (("frs_page".equals(f.this.cGv) || "normal_page".equals(f.this.cGv) || "book_page".equals(f.this.cGv)) && f.this.cGs != null && f.this.cGs.alU()) {
                            TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                            f.this.aiH();
                            f.this.cvA.coR = true;
                            f.this.cGx = true;
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.fQ().postDelayed(this.cGw, 4000L);
    }

    public void f(i iVar) {
        if (iVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(iVar.aOV(), iVar);
            }
        }
    }

    public void b(ForumData forumData, i iVar) {
        if (forumData != null && iVar != null) {
            float a = a(forumData);
            if (this.cGs != null) {
                this.cGs.a(forumData, iVar);
                this.cGs.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.cGs.jZ(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.cGs.fn(false);
                    } else {
                        this.cGs.fn(true);
                        this.cGs.jZ(forumData.getSignData().is_signed);
                    }
                }
                if (forumData.getUser_level() > this.cGD) {
                    be beVar = new be();
                    beVar.setForumName(forumData.getName());
                    beVar.setForumLevel(forumData.getUser_level());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_UPDATE_USER_LEVEL, beVar));
                    this.cGD = forumData.getUser_level();
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.cGt = forumData.getLevelupScore();
        this.cGu = forumData.getCurScore();
        if (this.cGt > 0) {
            return this.cGu / this.cGt;
        }
        return 0.0f;
    }

    public void jT(int i) {
        if (i > 1) {
            if (this.cGs != null) {
                this.cGs.fo(false);
            }
        } else if (this.cGs != null) {
            this.cGs.fo(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void f(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            alG();
        }
    }

    public void setIsMem(int i) {
        if (this.cGs != null) {
            this.cGs.setMemberType(i);
        }
    }

    public void aiH() {
        if (("normal_page".equals(this.cGv) || "frs_page".equals(this.cGv) || "book_page".equals(this.cGv)) && this.cGs != null) {
            this.cGs.aiH();
        }
    }

    public void alG() {
        if (this.cGs != null) {
            this.cGs.aiJ();
        }
    }

    public void a(i iVar, boolean z) {
        if (iVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, iVar.aOV(), iVar, z);
            }
        }
    }

    public void alH() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            jV(0);
        }
    }

    public void jU(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            jV(i);
        }
    }

    public void jV(int i) {
        if (this.cGs != null) {
            this.cGs.jY(i);
        }
    }

    public void a(int i, ForumData forumData, i iVar, boolean z) {
        if (this.cGs != null) {
            this.cGs.a(forumData, iVar);
            if (forumData != null) {
                this.cGs.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.cGs.fn(false);
                }
            }
        }
    }

    public boolean alI() {
        if (("normal_page".equals(this.cGv) || "frs_page".equals(this.cGv) || "book_page".equals(this.cGv)) && this.cGs != null) {
            return this.cGs.alT();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.cGt - this.cGu) {
                z = true;
                this.cGt = signData.levelup_score;
            }
            this.cGu = i + this.cGu;
            if (this.cGu > this.cGt) {
                this.cGu = this.cGt;
            }
            if (this.cGt != 0) {
                f = this.cGu / this.cGt;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.c(z, f);
        }
    }

    public void jW(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cGs != null) {
            this.cGs.jZ(i);
        }
    }

    public void g(i iVar) {
        SignData signData;
        ForumData aOV;
        if (iVar != null && iVar.aOV() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cGs != null && (signData = iVar.aOV().getSignData()) != null && (aOV = iVar.aOV()) != null) {
                this.cGs.a(aOV, iVar);
                this.cGs.jZ(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.cGs.alT()) {
                    a(this.cGs, signData);
                    aOV.setCurScore(this.cGu);
                    aOV.setLevelupScore(this.cGt);
                    this.cGs.a(aOV, iVar);
                }
            }
        }
    }

    public boolean alJ() {
        if (("normal_page".equals(this.cGv) || "frs_page".equals(this.cGv) || "book_page".equals(this.cGv)) && this.cGs != null) {
            return this.cGs.alJ();
        }
        return false;
    }

    public boolean alK() {
        if (("normal_page".equals(this.cGv) || "frs_page".equals(this.cGv) || "book_page".equals(this.cGv)) && this.cGs != null) {
            return this.cGs.alK();
        }
        return false;
    }

    public BarImageView alL() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cGs != null) {
            return this.cGs.alL();
        }
        return null;
    }

    public void fm(boolean z) {
        if (this.cvA != null) {
            i ahf = this.cvA.ahf();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.cvA.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.l.login_to_use), true, 11002)));
            } else if (ahf != null && ahf.aOV() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.cvA.getFrom())) {
                    TiebaStatic.log(new ak("c10356").ad("fid", ahf.aOV().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.cvA.getFrom())) {
                    TiebaStatic.log(new ak("c10590").r("obj_type", 2).ad("fid", ahf.aOV().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.cvA.getFrom())) {
                    TiebaStatic.log(new ak("c10587").r("obj_type", 2).ad("fid", ahf.aOV().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.cvA.getFrom())) {
                    TiebaStatic.log(new ak("c10578").r("obj_type", 2).ad("fid", ahf.aOV().getId()));
                }
                this.bJG.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.cvA.getFrom())) {
                    TiebaStatic.eventStat(this.cvA.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.cvA.getFrom())) {
                    TiebaStatic.log(new ak("c10359").ad("fid", ahf.aOV().getId()));
                }
                this.bJG.I(ahf.aOV().getName(), ahf.aOV().getId(), "FRS");
                this.cGB = z;
            }
        }
    }

    public void alM() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.cvA.ahf() != null && this.cvA.ahf().aOV() != null && this.cvA.ahf().aOV().getName() != null) {
            str = this.cvA.ahf().aOV().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cM(String.format(getPageContext().getString(d.l.attention_cancel_dialog_content), str));
        } else {
            aVar.cM(getPageContext().getString(d.l.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(d.l.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.h.f.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                i ahf = f.this.cvA.ahf();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.cvA.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) f.this.getPageContext().getPageActivity(), f.this.getPageContext().getString(d.l.login_to_use), true, 11036)));
                } else if (ahf != null && ahf.aOV() != null) {
                    f.this.cGy.r(ahf.aOV().getName(), com.baidu.adp.lib.g.b.c(ahf.aOV().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(d.l.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.h.f.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).to();
    }

    public void alN() {
        i ahf = this.cvA.ahf();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.cvA.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.l.login_to_use), true, 11014)));
        } else if (ahf != null && ahf.aOV() != null) {
            FrsActivityStatic.forumName = ahf.aOV().getName() == null ? "" : ahf.aOV().getName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, ahf.aOV()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kX(String str) {
        if (this.cvA.agI() != null && this.cvA.agI().akD() != null) {
            com.baidu.tieba.tbadkCore.c.bqk().ab(com.baidu.tieba.tbadkCore.c.bqk().d(str, this.cvA.agI().akD().OC(), this.cvA.agI().akD().getIsGood(), this.cvA.agI().akD().getCategoryId()), false);
        }
    }

    private void afN() {
        this.bJG = new LikeModel(this.cvA.getPageContext());
        this.bJG.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.h.f.7
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                o oVar;
                if (AntiHelper.tz(f.this.bJG.getErrorCode())) {
                    AntiHelper.ar(f.this.getPageContext().getPageActivity(), f.this.bJG.getErrorString());
                    return;
                }
                i ahf = f.this.cvA.ahf();
                if (ahf != null && ahf.aOV() != null && obj != null) {
                    String name = ahf.aOV().getName();
                    String id = ahf.aOV().getId();
                    boolean z = false;
                    if (!(obj instanceof o)) {
                        oVar = null;
                    } else {
                        oVar = (o) obj;
                    }
                    if (oVar != null && f.this.bJG.getErrorCode() == 0) {
                        z = true;
                    }
                    if (oVar == null || !z) {
                        if (f.this.bJG.getErrorCode() == 22) {
                            f.this.cvA.showToast(f.this.getPageContext().getString(d.l.had_liked_forum));
                        } else if (AntiHelper.tz(f.this.bJG.getErrorCode())) {
                            AntiHelper.ar(f.this.getPageContext().getPageActivity(), f.this.bJG.getErrorString());
                        } else {
                            f.this.cvA.showToast(f.this.bJG.getErrorString());
                        }
                    } else {
                        f.this.kX(name);
                        oVar.setLike(1);
                        ahf.c(oVar);
                        ahf.dm(oVar.bqm());
                        f.this.a(ahf, f.this.cGB);
                        f.this.cGB = true;
                        f.this.cvA.showToast(f.this.getPageContext().getResources().getString(d.l.attention_success));
                        f.this.e(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, oVar));
                    }
                    f.this.cvA.P(Boolean.valueOf(z));
                }
            }
        });
    }

    private void alO() {
        this.cGy = new u();
        this.cGy.setFrom("from_frs");
        this.cGy.a(new u.a() { // from class: com.baidu.tieba.frs.h.f.8
            @Override // com.baidu.tieba.tbadkCore.u.a
            public void k(String str, long j) {
                i ahf = f.this.cvA.ahf();
                if (ahf != null && ahf.aOV() != null) {
                    String name = ahf.aOV().getName();
                    String id = ahf.aOV().getId();
                    if (j == com.baidu.adp.lib.g.b.c(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.kX(str);
                        ahf.aOV().setLike(0);
                        f.this.jU(0);
                        f.this.cvA.O(true);
                        f.this.e(false, id);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, id));
                        o oVar = new o();
                        oVar.setLike(0);
                        oVar.setFid(id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, oVar));
                    }
                }
            }

            @Override // com.baidu.tieba.tbadkCore.u.a
            public void l(String str, long j) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.aAh().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void t(int i, int i2, int i3) {
        i ahf;
        if (i > 0 && i2 > 0 && (ahf = this.cvA.ahf()) != null && ahf.aOV() != null && ahf.getSignData() != null) {
            ForumData aOV = ahf.aOV();
            SignData signData = ahf.getSignData();
            signData.levelup_score = aOV.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            ahf.d(signData);
            signData.forumId = aOV.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            int i4 = -1;
            if (alK()) {
                i4 = aOV.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(aOV.getName(), signData.sign_bonus_point, i4);
        }
    }

    public int alP() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            if (this.cGs != null && this.cGs.alV() != null && this.cGs.alV().getParent() != null) {
                return this.cyN.getHeaderViewsCount() - 2;
            }
            return this.cyN.getHeaderViewsCount() - 1;
        }
        return 0;
    }

    public void ais() {
        if (this.cGs != null) {
            this.cGs.ais();
        }
    }

    public static boolean h(i iVar) {
        if (iVar != null) {
            return (iVar.bqO() == null || StringUtils.isNull(iVar.bqO().pK(), true) || iVar.bqO().pK().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean i(i iVar) {
        if (iVar != null) {
            return ((iVar.bqs() == null || iVar.bqs().brb() != 1) && iVar.bqN() == null && (iVar.bqt() == null || v.v(iVar.bqt().pJ())) && ((iVar.aOV() == null || iVar.aOV().getFrsBannerData() == null || iVar.aOV().getFrsBannerData().getType() != 2) && (iVar.bqP() == null || StringUtils.isNull(iVar.bqP().pR(), true)))) ? false : true;
        }
        return false;
    }

    public void jX(int i) {
        View findViewById;
        if (this.cGs != null && this.cGs.alV() != null && (findViewById = this.cGs.alV().findViewById(d.h.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.cGC != null) {
            this.cGC.onTouchEvent(motionEvent);
        }
    }
}
