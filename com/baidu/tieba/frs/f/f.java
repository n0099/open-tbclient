package com.baidu.tieba.frs.f;

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
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.x;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private LikeModel cOc;
    private com.baidu.tieba.frs.i dKN;
    private com.baidu.tieba.frs.view.c dNh;
    private int dNi;
    private int dNj;
    private String dNk;
    private Runnable dNl;
    private int dNm;
    private boolean dNn;
    private x dNo;
    private boolean dNp;
    private com.baidu.tieba.frs.entelechy.b.a dNq;
    private boolean dNr;
    private com.baidu.tieba.e.a dNs;
    private AntiHelper.a dNt;
    private CustomMessageListener dNu;
    private FrsHeaderViewContainer dyD;
    private final View.OnClickListener dyk;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(com.baidu.tieba.frs.i iVar, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(iVar.getPageContext());
        this.dyD = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.dNk = null;
        this.dNn = false;
        this.cOc = null;
        this.dNo = null;
        this.dNp = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.f.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12536").s("obj_locate", ap.a.aWa));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12535").s("obj_locate", ap.a.aWa));
            }
        };
        this.dNt = new AntiHelper.a() { // from class: com.baidu.tieba.frs.f.f.3
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12536").s("obj_locate", ap.a.aWc));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12535").s("obj_locate", ap.a.aWc));
            }
        };
        this.dNu = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.f.f.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SignData signData;
                boolean z;
                int i;
                l atn = f.this.dKN.atn();
                if (atn != null && atn.aYy() != null && atn.aYy().getName() != null && atn.aYy().getName().equals(FrsActivityStatic.forumName)) {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name = atn.aYy().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.xo(signMessage.mSignErrorCode) && signMessage.signData != null) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener) != null) {
                            TiebaStatic.log(new ak("c12534").s("obj_locate", ap.a.aWa));
                            return;
                        }
                        return;
                    }
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(atn.aYy().getId())) {
                            f.this.lQ(name);
                            atn.d(signData2);
                            signData2.forumId = atn.aYy().getId();
                            signData2.forumName = atn.aYy().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = atn.aYy().getUser_level();
                        if (f.this.aye()) {
                            i = atn.aYy().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (AntiHelper.xo(signMessage.mSignErrorCode)) {
                            AntiHelper.ap(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                            return;
                        } else if (!f.this.ayc()) {
                            f.this.dKN.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                            return;
                        } else {
                            f.this.dKN.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                            return;
                        }
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.nO(1);
                    }
                    f.this.dKN.showToast(signMessage.mSignErrorString);
                }
            }
        };
        this.dyk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l atn = f.this.dKN.atn();
                if (atn != null && atn.aYy() != null && f.this.dNh != null && (view == f.this.dNh.ayp() || view == f.this.dNh.ayq() || view == f.this.dNh.ayr())) {
                    if (f.this.dKN != null && atn.aYy() != null) {
                        TiebaStatic.log(new ak("c12046").ab(ImageViewerConfig.FORUM_ID, atn.aYy().getId()).s("obj_locate", f.this.dKN.atq() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), atn.aYy().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == d.g.tv_love) {
                    if (!f.this.dKN.ato()) {
                        if (!com.baidu.adp.lib.util.j.oI()) {
                            f.this.dKN.showToast(d.j.neterror);
                        } else if (!ax.be(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new ak("c10517").s("obj_locate", 1).ab(ImageViewerConfig.FORUM_ID, f.this.dKN.getForumId()));
                        } else {
                            f.this.gd(true);
                        }
                    }
                } else if (id == d.g.tv_sign) {
                    if (!f.this.dKN.ato()) {
                        if (!com.baidu.adp.lib.util.j.oI()) {
                            f.this.dKN.showToast(d.j.neterror);
                        } else if (ax.be(f.this.mContext.getPageActivity())) {
                            if (!f.this.ayd()) {
                                f.this.ayg();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(f.this.dKN.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.h(f.this.dKN.getForumId(), 0), 24002)));
                            }
                        }
                    }
                } else if (id == d.g.frs_header_games) {
                    if (ax.be(f.this.mContext.getPageActivity()) && atn != null && atn.bAr() != null) {
                        String bAr = atn.bAr();
                        if (m.dK(bAr) == 3) {
                            m.a(f.this.dKN.getPageContext(), bAr);
                        } else {
                            av.Di().a((TbPageContext) f.this.getPageContext(), new String[]{bAr}, true);
                        }
                    }
                } else if (id == d.g.frs_bawu_center) {
                    if (atn != null && atn.getUserData() != null && atn.getUserData().isBawu()) {
                        String bAy = atn.bAy();
                        if (!am.isEmpty(bAy)) {
                            com.baidu.tbadk.browser.a.R(f.this.getPageContext().getPageActivity(), bAy);
                            if (atn.aYy() != null) {
                                TiebaStatic.log(new ak("c10502").ab(ImageViewerConfig.FORUM_ID, atn.aYy().getId()).ab("uid", atn.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == d.g.level_container && !f.this.dKN.ato() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page")) && f.this.dNh != null) {
                        f.this.dNh.p(view, false);
                    }
                }
            }
        };
        this.dKN = iVar;
        this.dNq = aVar;
        this.dyD = frsHeaderViewContainer;
        this.dNs = new com.baidu.tieba.e.a();
        this.dNs.a(new a.InterfaceC0109a() { // from class: com.baidu.tieba.frs.f.f.5
            @Override // com.baidu.tieba.e.a.InterfaceC0109a
            public void aY(int i, int i2) {
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0109a
            public void aZ(int i, int i2) {
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0109a
            public void ba(int i, int i2) {
            }
        });
    }

    public void n(Bundle bundle) {
        this.dKN.registerListener(this.dNu);
        arW();
        ayh();
        this.dNn = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.dNh != null) {
            this.dNh.onDestory();
        }
        if (this.cOc != null) {
            this.cOc.bBx();
        }
        if (this.dNl != null) {
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.dNl);
        }
    }

    public void onActivityStop() {
        if (this.dNh != null) {
            this.dNh.onStop();
        }
    }

    public void gb(boolean z) {
        if (this.dNh != null) {
            this.dNh.gb(z);
        }
    }

    public boolean nK(int i) {
        this.mSkinType = i;
        if (this.dNh != null) {
            this.dNh.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void gc(boolean z) {
        if (z) {
            if (this.dNh != null) {
                this.dyD.removeHeaderView(this.dNh.ayn());
                this.dNp = false;
            }
        } else if (this.dNh != null && this.dNh.ayn() != null && !this.dNp) {
            this.dyD.addHeaderView(this.dNh.ayn(), this.dyD.getHeaderViewsCount());
            this.dNp = true;
        }
    }

    public void a(String str, l lVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) && lVar != null && lVar.getUserData() != null && lVar.aYy() != null) {
            k(str, lVar.getUserData().getIsMem(), lVar.aYy().isLike());
        }
    }

    public void k(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.dNk, str);
        this.dNm = i2;
        this.dNk = str;
        axY();
        if (this.dNh == null || z) {
            this.dNh = this.dNq.a(str, this.dKN, i);
            this.dNh.changeSkinType(this.mSkinType);
            this.dNh.setCommonClickListener(this.dyk);
        }
        this.dyD.addHeaderView(this.dNh.getView());
        int s = com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst(), d.e.tbds44);
        this.dNh.x(0, s, 0, s);
        axZ();
    }

    public void axX() {
        if (!this.dNp && this.dNh != null) {
            this.dyD.addHeaderView(this.dNh.ayn());
            if (this.dNh.ayo() != null && this.dKN.El() != null) {
                this.dKN.El().addHeaderView(this.dNh.ayo(), 0);
            }
            this.dNp = true;
        }
    }

    private void axY() {
        if (("normal_page".equals(this.dNk) || "frs_page".equals(this.dNk) || "book_page".equals(this.dNk)) && this.dNh != null) {
            this.dyD.removeHeaderView(this.dNh.getView());
            this.dyD.removeHeaderView(this.dNh.ayn());
            if (this.dNh.ayo() != null && this.dKN.El() != null) {
                this.dKN.El().removeHeaderView(this.dNh.ayo());
            }
        }
        this.dNp = false;
    }

    private void axZ() {
        if (this.dNl == null) {
            this.dNl = new Runnable() { // from class: com.baidu.tieba.frs.f.f.6
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.dKN.asV() == null || !f.this.dKN.asV().ato()) && f.this.dyD.isShown() && f.this.dKN.isPrimary() && !f.this.dNn && f.this.dNm == 1 && f.this.dKN.asV() != null && f.this.dKN.asV().aty() != null && !f.this.dKN.asV().aty().avx()) {
                            if (("frs_page".equals(f.this.dNk) || "normal_page".equals(f.this.dNk) || "book_page".equals(f.this.dNk)) && f.this.dNh != null && f.this.dNh.aym()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.auZ();
                                f.this.dKN.dww = true;
                                f.this.dNn = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.nr().postDelayed(this.dNl, 4000L);
    }

    public void f(l lVar) {
        if (lVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(lVar.aYy(), lVar);
            }
        }
    }

    public void b(ForumData forumData, l lVar) {
        if (forumData != null && lVar != null) {
            float a = a(forumData);
            if (this.dNh != null) {
                this.dNh.a(forumData, lVar);
                this.dNh.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.dNh.ob(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.dNh.ge(false);
                        return;
                    }
                    this.dNh.ge(true);
                    this.dNh.ob(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.dNi = forumData.getLevelupScore();
        this.dNj = forumData.getCurScore();
        if (this.dNi > 0) {
            return this.dNj / this.dNi;
        }
        return 0.0f;
    }

    public void nL(int i) {
        if (i > 1) {
            if (this.dNh != null) {
                this.dNh.gf(false);
            }
        } else if (this.dNh != null) {
            this.dNh.gf(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void f(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            aya();
        }
    }

    public void setIsMem(int i) {
        if (this.dNh != null) {
            this.dNh.setMemberType(i);
        }
    }

    public void auZ() {
        if (("normal_page".equals(this.dNk) || "frs_page".equals(this.dNk) || "book_page".equals(this.dNk)) && this.dNh != null) {
            this.dNh.auZ();
        }
    }

    public void aya() {
        if (this.dNh != null) {
            this.dNh.avb();
        }
    }

    public void a(l lVar, boolean z) {
        if (lVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, lVar.aYy(), lVar, z);
            }
        }
    }

    public void ayb() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            nN(0);
        }
    }

    public void nM(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            nN(i);
        }
    }

    public void nN(int i) {
        if (this.dNh != null) {
            this.dNh.oa(i);
        }
    }

    public void a(int i, ForumData forumData, l lVar, boolean z) {
        if (this.dNh != null) {
            this.dNh.a(forumData, lVar);
            if (forumData != null) {
                this.dNh.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.dNh.ge(false);
                }
            }
        }
    }

    public boolean ayc() {
        if (("normal_page".equals(this.dNk) || "frs_page".equals(this.dNk) || "book_page".equals(this.dNk)) && this.dNh != null) {
            return this.dNh.ayl();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.c cVar, SignData signData) {
        if (cVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.dNi - this.dNj) {
                z = true;
                this.dNi = signData.levelup_score;
            }
            this.dNj = i + this.dNj;
            if (this.dNj > this.dNi) {
                this.dNj = this.dNi;
            }
            if (this.dNi != 0) {
                f = this.dNj / this.dNi;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            cVar.c(z, f);
        }
    }

    public void nO(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.dNh != null) {
            this.dNh.ob(i);
        }
    }

    public void g(l lVar) {
        SignData signData;
        ForumData aYy;
        if (lVar != null && lVar.aYy() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.dNh != null && (signData = lVar.aYy().getSignData()) != null && (aYy = lVar.aYy()) != null) {
                this.dNh.a(aYy, lVar);
                this.dNh.ob(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.dNh.ayl()) {
                    a(this.dNh, signData);
                    aYy.setCurScore(this.dNj);
                    aYy.setLevelupScore(this.dNi);
                    this.dNh.a(aYy, lVar);
                }
            }
        }
    }

    public boolean ayd() {
        if (("normal_page".equals(this.dNk) || "frs_page".equals(this.dNk) || "book_page".equals(this.dNk)) && this.dNh != null) {
            return this.dNh.ayd();
        }
        return false;
    }

    public boolean aye() {
        if (("normal_page".equals(this.dNk) || "frs_page".equals(this.dNk) || "book_page".equals(this.dNk)) && this.dNh != null) {
            return this.dNh.aye();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.i */
    /* JADX WARN: Multi-variable type inference failed */
    public void gd(boolean z) {
        if (this.dKN != null) {
            l atn = this.dKN.atn();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.dKN.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_INITED)));
            } else if (atn != null && atn.aYy() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.dKN.getFrom())) {
                    TiebaStatic.log(new ak("c10356").ab(ImageViewerConfig.FORUM_ID, atn.aYy().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.dKN.getFrom())) {
                    TiebaStatic.log(new ak("c10590").s("obj_type", 2).ab(ImageViewerConfig.FORUM_ID, atn.aYy().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.dKN.getFrom())) {
                    TiebaStatic.log(new ak("c10587").s("obj_type", 2).ab(ImageViewerConfig.FORUM_ID, atn.aYy().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.dKN.getFrom())) {
                    TiebaStatic.log(new ak("c10578").s("obj_type", 2).ab(ImageViewerConfig.FORUM_ID, atn.aYy().getId()));
                }
                this.cOc.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.dKN.getFrom())) {
                    TiebaStatic.eventStat(this.dKN.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.dKN.getFrom())) {
                    TiebaStatic.log(new ak("c10359").ab(ImageViewerConfig.FORUM_ID, atn.aYy().getId()));
                }
                this.cOc.K(atn.aYy().getName(), atn.aYy().getId(), "FRS");
                this.dNr = z;
            }
        }
    }

    public void ayf() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.dKN.atn() != null && this.dKN.atn().aYy() != null && this.dKN.atn().aYy().getName() != null) {
            str = this.dKN.atn().aYy().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cZ(String.format(getPageContext().getString(d.j.attention_cancel_dialog_content), str));
        } else {
            aVar.cZ(getPageContext().getString(d.j.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(d.j.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.f.f.8
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.i */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                l atn = f.this.dKN.atn();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.dKN.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) f.this.getPageContext().getPageActivity(), f.this.getPageContext().getString(d.j.login_to_use), true, 11036)));
                } else if (atn != null && atn.aYy() != null) {
                    f.this.dNo.u(atn.aYy().getName(), com.baidu.adp.lib.g.b.c(atn.aYy().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(d.j.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.f.f.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).AI();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.i */
    /* JADX WARN: Multi-variable type inference failed */
    public void ayg() {
        l atn = this.dKN.atn();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.dKN.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, 11014)));
        } else if (atn != null && atn.aYy() != null) {
            FrsActivityStatic.forumName = atn.aYy().getName() == null ? "" : atn.aYy().getName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, atn.aYy()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lQ(String str) {
        if (this.dKN.asQ() != null && this.dKN.asQ().axc() != null) {
            com.baidu.tieba.tbadkCore.c.bzX().aa(com.baidu.tieba.tbadkCore.c.bzX().d(str, this.dKN.asQ().axc().XR(), this.dKN.asQ().axc().getIsGood(), this.dKN.asQ().axc().getCategoryId()), false);
        }
    }

    private void arW() {
        this.cOc = new LikeModel(this.dKN.getPageContext());
        this.cOc.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.f.f.10
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                r rVar;
                l atn = f.this.dKN.atn();
                if (atn != null && atn.aYy() != null && obj != null) {
                    if (AntiHelper.xo(f.this.cOc.getErrorCode())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.cOc.getBlockPopInfoData(), f.this.dNt) != null) {
                            TiebaStatic.log(new ak("c12534").s("obj_locate", ap.a.aWc));
                            return;
                        }
                        return;
                    }
                    String name = atn.aYy().getName();
                    String id = atn.aYy().getId();
                    boolean z = false;
                    if (!(obj instanceof r)) {
                        rVar = null;
                    } else {
                        rVar = (r) obj;
                    }
                    if (rVar != null && f.this.cOc.getErrorCode() == 0) {
                        z = true;
                    }
                    if (rVar == null || !z) {
                        if (f.this.cOc.getErrorCode() == 22) {
                            f.this.dKN.showToast(f.this.getPageContext().getString(d.j.had_liked_forum));
                        } else {
                            f.this.dKN.showToast(f.this.cOc.getErrorString());
                        }
                    } else {
                        f.this.lQ(name);
                        rVar.setLike(1);
                        atn.c(rVar);
                        atn.dD(rVar.bAa());
                        f.this.a(atn, f.this.dNr);
                        f.this.dNr = true;
                        f.this.dKN.showToast(f.this.getPageContext().getResources().getString(d.j.attention_success));
                        f.this.f(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, rVar));
                    }
                    f.this.dKN.aV(Boolean.valueOf(z));
                }
            }
        });
    }

    private void ayh() {
        this.dNo = new x();
        this.dNo.setFrom("from_frs");
        this.dNo.a(new x.a() { // from class: com.baidu.tieba.frs.f.f.2
            @Override // com.baidu.tieba.tbadkCore.x.a
            public void n(String str, long j) {
                l atn = f.this.dKN.atn();
                if (atn != null && atn.aYy() != null) {
                    String name = atn.aYy().getName();
                    String id = atn.aYy().getId();
                    if (j == com.baidu.adp.lib.g.b.c(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.lQ(str);
                        atn.aYy().setLike(0);
                        f.this.nM(0);
                        f.this.dKN.aU(true);
                        f.this.f(false, id);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, id));
                        r rVar = new r();
                        rVar.setLike(0);
                        rVar.setFid(id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, rVar));
                    }
                }
            }

            @Override // com.baidu.tieba.tbadkCore.x.a
            public void o(String str, long j) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.aKk().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void L(int i, int i2, int i3) {
        l atn;
        if (i > 0 && i2 > 0 && (atn = this.dKN.atn()) != null && atn.aYy() != null && atn.getSignData() != null) {
            ForumData aYy = atn.aYy();
            SignData signData = atn.getSignData();
            signData.levelup_score = aYy.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            atn.d(signData);
            signData.forumId = aYy.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            int i4 = -1;
            if (aye()) {
                i4 = aYy.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(aYy.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void auN() {
        if (this.dNh != null) {
            this.dNh.auN();
        }
    }

    public static boolean h(l lVar) {
        if (lVar != null) {
            return (lVar.bAC() == null || StringUtils.isNull(lVar.bAC().xn(), true) || lVar.bAC().xn().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean i(l lVar) {
        if (lVar != null) {
            return ((lVar.bAh() == null || lVar.bAh().bAT() != 1) && lVar.bAB() == null && (lVar.bAi() == null || v.G(lVar.bAi().xm())) && ((lVar.aYy() == null || lVar.aYy().getFrsBannerData() == null || lVar.aYy().getFrsBannerData().getType() != 2) && (lVar.bAD() == null || StringUtils.isNull(lVar.bAD().xu(), true)))) ? false : true;
        }
        return false;
    }

    public void nP(int i) {
        View findViewById;
        if (this.dNh != null && this.dNh.ayn() != null && (findViewById = this.dNh.ayn().findViewById(d.g.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.dNs != null) {
            this.dNs.onTouchEvent(motionEvent);
        }
    }
}
