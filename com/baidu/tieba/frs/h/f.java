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
    private LikeModel bKx;
    private com.baidu.tieba.frs.view.b cHm;
    private int cHn;
    private int cHo;
    private String cHp;
    private Runnable cHq;
    private boolean cHr;
    private u cHs;
    private boolean cHt;
    private com.baidu.tieba.frs.entelechy.b.a cHu;
    private boolean cHv;
    private com.baidu.tieba.e.a cHw;
    private int cHx;
    private CustomMessageListener cHy;
    private int ccJ;
    com.baidu.tieba.frs.entelechy.b.b cqo;
    private final View.OnClickListener cry;
    private com.baidu.tieba.frs.f cws;
    private BdTypeListView czF;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(com.baidu.tieba.frs.f fVar, com.baidu.tieba.frs.entelechy.b.a aVar) {
        super(fVar.getPageContext());
        this.czF = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.cHp = null;
        this.cHr = false;
        this.bKx = null;
        this.cHs = null;
        this.cHt = false;
        this.cHx = 0;
        this.cHy = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.h.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SignData signData;
                boolean z;
                int i;
                i ahq = f.this.cws.ahq();
                if (ahq != null && ahq.aPg() != null && ahq.aPg().getName() != null && ahq.aPg().getName().equals(FrsActivityStatic.forumName)) {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name = ahq.aPg().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(ahq.aPg().getId())) {
                            f.this.kZ(name);
                            ahq.d(signData2);
                            signData2.forumId = ahq.aPg().getId();
                            signData2.forumName = ahq.aPg().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = ahq.aPg().getUser_level();
                        if (f.this.alV()) {
                            i = ahq.aPg().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (AntiHelper.tB(signMessage.mSignErrorCode)) {
                            AntiHelper.ar(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                        } else if (!f.this.alT()) {
                            f.this.cws.showToast(f.this.getPageContext().getResources().getString(d.l.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                        } else {
                            f.this.cws.showToast(f.this.getPageContext().getResources().getString(d.l.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                        }
                    } else if (AntiHelper.tB(signMessage.mSignErrorCode)) {
                        AntiHelper.ar(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                    } else {
                        if (signMessage.mSignErrorCode == 160002) {
                            f.this.jY(1);
                        }
                        f.this.cws.showToast(signMessage.mSignErrorString);
                    }
                }
            }
        };
        this.cry = new View.OnClickListener() { // from class: com.baidu.tieba.frs.h.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i ahq = f.this.cws.ahq();
                if (ahq != null && ahq.aPg() != null && f.this.cHm != null && (view == f.this.cHm.alW() || view == f.this.cHm.amh() || view == f.this.cHm.ami())) {
                    if (f.this.cws != null && ahq.aPg() != null) {
                        TiebaStatic.log(new ak("c12046").ad("fid", ahq.aPg().getId()).r("obj_locate", f.this.cws.aht() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), ahq.aPg().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == d.h.tv_love) {
                    if (!f.this.cws.ahr() && com.baidu.adp.lib.util.i.hi()) {
                        if (!ax.aU(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new ak("c10517").r("obj_locate", 1).ad("fid", f.this.cws.getForumId()));
                        } else {
                            f.this.fn(true);
                        }
                    }
                } else if (id == d.h.tv_sign) {
                    if (!f.this.cws.ahr() && com.baidu.adp.lib.util.i.hi() && ax.aU(f.this.mContext.getPageActivity())) {
                        if (!f.this.alU()) {
                            f.this.alY();
                        } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(f.this.cws.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.g(f.this.cws.getForumId(), 0), 24002)));
                        }
                    }
                } else if (id == d.h.frs_header_games) {
                    if (ax.aU(f.this.mContext.getPageActivity()) && ahq != null && ahq.bqN() != null) {
                        String bqN = ahq.bqN();
                        if (m.dF(bqN) == 3) {
                            m.a(f.this.cws.getPageContext(), bqN);
                        } else {
                            au.wd().a((TbPageContext) f.this.getPageContext(), new String[]{bqN}, true);
                        }
                    }
                } else if (id == d.h.frs_bawu_center) {
                    if (ahq != null && ahq.getUserData() != null && ahq.getUserData().isBawu()) {
                        String bqV = ahq.bqV();
                        if (!am.isEmpty(bqV)) {
                            com.baidu.tbadk.browser.a.T(f.this.getPageContext().getPageActivity(), bqV);
                            if (ahq.aPg() != null) {
                                TiebaStatic.log(new ak("c10502").ad("fid", ahq.aPg().getId()).ad(SapiAccountManager.SESSION_UID, ahq.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == d.h.level_container && !f.this.cws.ahr() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page")) && f.this.cHm != null) {
                        f.this.cHm.g(view, false);
                    }
                }
            }
        };
        this.cws = fVar;
        this.cHu = aVar;
        if (this.cHu != null) {
            this.cqo = this.cHu.aiE();
        }
        this.cHw = new com.baidu.tieba.e.a();
        this.cHw.a(new a.InterfaceC0081a() { // from class: com.baidu.tieba.frs.h.f.2
            @Override // com.baidu.tieba.e.a.InterfaceC0081a
            public void ak(int i, int i2) {
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0081a
            public void al(int i, int i2) {
            }
        });
    }

    public void l(Bundle bundle) {
        this.cws.registerListener(this.cHy);
        afY();
        alZ();
        this.cHr = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.cHm != null) {
            this.cHm.onDestory();
        }
        if (this.bKx != null) {
            this.bKx.brL();
        }
        if (this.cHq != null) {
            com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.cHq);
        }
    }

    public void onActivityStop() {
        if (this.cHm != null) {
            this.cHm.onStop();
        }
    }

    public boolean jU(int i) {
        this.mSkinType = i;
        if (this.cHm != null) {
            this.cHm.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void d(BdTypeListView bdTypeListView) {
        this.czF = bdTypeListView;
    }

    public void fm(boolean z) {
        if (z) {
            if (this.cHm != null) {
                this.czF.removeHeaderView(this.cHm.amg());
                this.cHt = false;
            }
        } else if (this.cHm != null && this.cHm.amg() != null && !this.cHt) {
            this.czF.addHeaderView(this.cHm.amg(), this.czF.getHeaderViewsCount());
            this.cHt = true;
        }
    }

    public void a(String str, i iVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) && iVar != null && iVar.getUserData() != null && iVar.aPg() != null) {
            f(str, iVar.getUserData().getIsMem(), iVar.aPg().isLike());
        }
    }

    public void f(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.cHp, str);
        this.ccJ = i2;
        this.cHp = str;
        alP();
        if (this.cHm == null || z) {
            this.cHm = this.cHu.a(str, this.cws, i);
            this.cHm.changeSkinType(this.mSkinType);
            this.cHm.setCommonClickListener(this.cry);
        }
        this.czF.addHeaderView(this.cHm.getView());
        if (this.cqo != null) {
            this.cqo.a(this.czF, this.cHm);
        }
        if (this.cws.aht()) {
            this.cHm.l(0, k.f(TbadkCoreApplication.getInst(), d.f.ds40), 0, k.f(this.mContext.getPageActivity(), d.f.ds20));
        } else {
            int f = k.f(TbadkCoreApplication.getInst(), d.f.ds34);
            this.cHm.l(0, f, 0, f);
        }
        alQ();
    }

    public void alO() {
        if (!this.cHt && this.cHm != null) {
            this.czF.addHeaderView(this.cHm.amg());
            this.cHt = true;
        }
    }

    private void alP() {
        if (("normal_page".equals(this.cHp) || "frs_page".equals(this.cHp) || "book_page".equals(this.cHp)) && this.cHm != null) {
            this.czF.removeHeaderView(this.cHm.getView());
            this.czF.removeHeaderView(this.cHm.amg());
        }
        this.cHt = false;
    }

    private void alQ() {
        if (this.cHq == null) {
            this.cHq = new Runnable() { // from class: com.baidu.tieba.frs.h.f.3
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0 && f.this.czF.isRefreshDone() && !f.this.cHr && f.this.ccJ == 1 && f.this.cws.agY() != null && f.this.cws.agY().ahB() != null && !f.this.cws.agY().ahB().ajs()) {
                        if (("frs_page".equals(f.this.cHp) || "normal_page".equals(f.this.cHp) || "book_page".equals(f.this.cHp)) && f.this.cHm != null && f.this.cHm.amf()) {
                            TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                            f.this.aiS();
                            f.this.cws.cpJ = true;
                            f.this.cHr = true;
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.fQ().postDelayed(this.cHq, 4000L);
    }

    public void f(i iVar) {
        if (iVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(iVar.aPg(), iVar);
            }
        }
    }

    public void b(ForumData forumData, i iVar) {
        if (forumData != null && iVar != null) {
            float a = a(forumData);
            if (this.cHm != null) {
                this.cHm.a(forumData, iVar);
                this.cHm.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.cHm.kb(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.cHm.fo(false);
                    } else {
                        this.cHm.fo(true);
                        this.cHm.kb(forumData.getSignData().is_signed);
                    }
                }
                if (forumData.getUser_level() > this.cHx) {
                    be beVar = new be();
                    beVar.setForumName(forumData.getName());
                    beVar.setForumLevel(forumData.getUser_level());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_UPDATE_USER_LEVEL, beVar));
                    this.cHx = forumData.getUser_level();
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.cHn = forumData.getLevelupScore();
        this.cHo = forumData.getCurScore();
        if (this.cHn > 0) {
            return this.cHo / this.cHn;
        }
        return 0.0f;
    }

    public void jV(int i) {
        if (i > 1) {
            if (this.cHm != null) {
                this.cHm.fp(false);
            }
        } else if (this.cHm != null) {
            this.cHm.fp(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void f(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            alR();
        }
    }

    public void setIsMem(int i) {
        if (this.cHm != null) {
            this.cHm.setMemberType(i);
        }
    }

    public void aiS() {
        if (("normal_page".equals(this.cHp) || "frs_page".equals(this.cHp) || "book_page".equals(this.cHp)) && this.cHm != null) {
            this.cHm.aiS();
        }
    }

    public void alR() {
        if (this.cHm != null) {
            this.cHm.aiU();
        }
    }

    public void a(i iVar, boolean z) {
        if (iVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, iVar.aPg(), iVar, z);
            }
        }
    }

    public void alS() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            jX(0);
        }
    }

    public void jW(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            jX(i);
        }
    }

    public void jX(int i) {
        if (this.cHm != null) {
            this.cHm.ka(i);
        }
    }

    public void a(int i, ForumData forumData, i iVar, boolean z) {
        if (this.cHm != null) {
            this.cHm.a(forumData, iVar);
            if (forumData != null) {
                this.cHm.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.cHm.fo(false);
                }
            }
        }
    }

    public boolean alT() {
        if (("normal_page".equals(this.cHp) || "frs_page".equals(this.cHp) || "book_page".equals(this.cHp)) && this.cHm != null) {
            return this.cHm.ame();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.cHn - this.cHo) {
                z = true;
                this.cHn = signData.levelup_score;
            }
            this.cHo = i + this.cHo;
            if (this.cHo > this.cHn) {
                this.cHo = this.cHn;
            }
            if (this.cHn != 0) {
                f = this.cHo / this.cHn;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.c(z, f);
        }
    }

    public void jY(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cHm != null) {
            this.cHm.kb(i);
        }
    }

    public void g(i iVar) {
        SignData signData;
        ForumData aPg;
        if (iVar != null && iVar.aPg() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cHm != null && (signData = iVar.aPg().getSignData()) != null && (aPg = iVar.aPg()) != null) {
                this.cHm.a(aPg, iVar);
                this.cHm.kb(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.cHm.ame()) {
                    a(this.cHm, signData);
                    aPg.setCurScore(this.cHo);
                    aPg.setLevelupScore(this.cHn);
                    this.cHm.a(aPg, iVar);
                }
            }
        }
    }

    public boolean alU() {
        if (("normal_page".equals(this.cHp) || "frs_page".equals(this.cHp) || "book_page".equals(this.cHp)) && this.cHm != null) {
            return this.cHm.alU();
        }
        return false;
    }

    public boolean alV() {
        if (("normal_page".equals(this.cHp) || "frs_page".equals(this.cHp) || "book_page".equals(this.cHp)) && this.cHm != null) {
            return this.cHm.alV();
        }
        return false;
    }

    public BarImageView alW() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cHm != null) {
            return this.cHm.alW();
        }
        return null;
    }

    public void fn(boolean z) {
        if (this.cws != null) {
            i ahq = this.cws.ahq();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.cws.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.l.login_to_use), true, 11002)));
            } else if (ahq != null && ahq.aPg() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.cws.getFrom())) {
                    TiebaStatic.log(new ak("c10356").ad("fid", ahq.aPg().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.cws.getFrom())) {
                    TiebaStatic.log(new ak("c10590").r("obj_type", 2).ad("fid", ahq.aPg().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.cws.getFrom())) {
                    TiebaStatic.log(new ak("c10587").r("obj_type", 2).ad("fid", ahq.aPg().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.cws.getFrom())) {
                    TiebaStatic.log(new ak("c10578").r("obj_type", 2).ad("fid", ahq.aPg().getId()));
                }
                this.bKx.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.cws.getFrom())) {
                    TiebaStatic.eventStat(this.cws.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.cws.getFrom())) {
                    TiebaStatic.log(new ak("c10359").ad("fid", ahq.aPg().getId()));
                }
                this.bKx.I(ahq.aPg().getName(), ahq.aPg().getId(), "FRS");
                this.cHv = z;
            }
        }
    }

    public void alX() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.cws.ahq() != null && this.cws.ahq().aPg() != null && this.cws.ahq().aPg().getName() != null) {
            str = this.cws.ahq().aPg().getName();
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
                i ahq = f.this.cws.ahq();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.cws.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) f.this.getPageContext().getPageActivity(), f.this.getPageContext().getString(d.l.login_to_use), true, 11036)));
                } else if (ahq != null && ahq.aPg() != null) {
                    f.this.cHs.r(ahq.aPg().getName(), com.baidu.adp.lib.g.b.c(ahq.aPg().getId(), 0L));
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

    public void alY() {
        i ahq = this.cws.ahq();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.cws.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.l.login_to_use), true, 11014)));
        } else if (ahq != null && ahq.aPg() != null) {
            FrsActivityStatic.forumName = ahq.aPg().getName() == null ? "" : ahq.aPg().getName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, ahq.aPg()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kZ(String str) {
        if (this.cws.agT() != null && this.cws.agT().akO() != null) {
            com.baidu.tieba.tbadkCore.c.bqv().ab(com.baidu.tieba.tbadkCore.c.bqv().d(str, this.cws.agT().akO().OE(), this.cws.agT().akO().getIsGood(), this.cws.agT().akO().getCategoryId()), false);
        }
    }

    private void afY() {
        this.bKx = new LikeModel(this.cws.getPageContext());
        this.bKx.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.h.f.7
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                o oVar;
                if (AntiHelper.tB(f.this.bKx.getErrorCode())) {
                    AntiHelper.ar(f.this.getPageContext().getPageActivity(), f.this.bKx.getErrorString());
                    return;
                }
                i ahq = f.this.cws.ahq();
                if (ahq != null && ahq.aPg() != null && obj != null) {
                    String name = ahq.aPg().getName();
                    String id = ahq.aPg().getId();
                    boolean z = false;
                    if (!(obj instanceof o)) {
                        oVar = null;
                    } else {
                        oVar = (o) obj;
                    }
                    if (oVar != null && f.this.bKx.getErrorCode() == 0) {
                        z = true;
                    }
                    if (oVar == null || !z) {
                        if (f.this.bKx.getErrorCode() == 22) {
                            f.this.cws.showToast(f.this.getPageContext().getString(d.l.had_liked_forum));
                        } else if (AntiHelper.tB(f.this.bKx.getErrorCode())) {
                            AntiHelper.ar(f.this.getPageContext().getPageActivity(), f.this.bKx.getErrorString());
                        } else {
                            f.this.cws.showToast(f.this.bKx.getErrorString());
                        }
                    } else {
                        f.this.kZ(name);
                        oVar.setLike(1);
                        ahq.c(oVar);
                        ahq.dn(oVar.bqx());
                        f.this.a(ahq, f.this.cHv);
                        f.this.cHv = true;
                        f.this.cws.showToast(f.this.getPageContext().getResources().getString(d.l.attention_success));
                        f.this.e(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, oVar));
                    }
                    f.this.cws.P(Boolean.valueOf(z));
                }
            }
        });
    }

    private void alZ() {
        this.cHs = new u();
        this.cHs.setFrom("from_frs");
        this.cHs.a(new u.a() { // from class: com.baidu.tieba.frs.h.f.8
            @Override // com.baidu.tieba.tbadkCore.u.a
            public void k(String str, long j) {
                i ahq = f.this.cws.ahq();
                if (ahq != null && ahq.aPg() != null) {
                    String name = ahq.aPg().getName();
                    String id = ahq.aPg().getId();
                    if (j == com.baidu.adp.lib.g.b.c(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.kZ(str);
                        ahq.aPg().setLike(0);
                        f.this.jW(0);
                        f.this.cws.O(true);
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
        com.baidu.tieba.im.settingcache.d.aAs().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void t(int i, int i2, int i3) {
        i ahq;
        if (i > 0 && i2 > 0 && (ahq = this.cws.ahq()) != null && ahq.aPg() != null && ahq.getSignData() != null) {
            ForumData aPg = ahq.aPg();
            SignData signData = ahq.getSignData();
            signData.levelup_score = aPg.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            ahq.d(signData);
            signData.forumId = aPg.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            int i4 = -1;
            if (alV()) {
                i4 = aPg.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(aPg.getName(), signData.sign_bonus_point, i4);
        }
    }

    public int ama() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            if (this.cHm != null && this.cHm.amg() != null && this.cHm.amg().getParent() != null) {
                return this.czF.getHeaderViewsCount() - 2;
            }
            return this.czF.getHeaderViewsCount() - 1;
        }
        return 0;
    }

    public void aiD() {
        if (this.cHm != null) {
            this.cHm.aiD();
        }
    }

    public static boolean h(i iVar) {
        if (iVar != null) {
            return (iVar.bqZ() == null || StringUtils.isNull(iVar.bqZ().pK(), true) || iVar.bqZ().pK().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean i(i iVar) {
        if (iVar != null) {
            return ((iVar.bqD() == null || iVar.bqD().brm() != 1) && iVar.bqY() == null && (iVar.bqE() == null || v.v(iVar.bqE().pJ())) && ((iVar.aPg() == null || iVar.aPg().getFrsBannerData() == null || iVar.aPg().getFrsBannerData().getType() != 2) && (iVar.bra() == null || StringUtils.isNull(iVar.bra().pR(), true)))) ? false : true;
        }
        return false;
    }

    public void jZ(int i) {
        View findViewById;
        if (this.cHm != null && this.cHm.amg() != null && (findViewById = this.cHm.amg().findViewById(d.h.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.cHw != null) {
            this.cHw.onTouchEvent(motionEvent);
        }
    }
}
