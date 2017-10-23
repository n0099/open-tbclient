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
    private LikeModel bJy;
    private BdTypeListView cAm;
    private com.baidu.tieba.frs.view.b cHR;
    private int cHS;
    private int cHT;
    private String cHU;
    private Runnable cHV;
    private boolean cHW;
    private u cHX;
    private boolean cHY;
    private com.baidu.tieba.frs.entelechy.b.a cHZ;
    private boolean cIa;
    private com.baidu.tieba.e.a cIb;
    private CustomMessageListener cIc;
    private int ccx;
    com.baidu.tieba.frs.entelechy.b.b cqy;
    private final View.OnClickListener crI;
    private com.baidu.tieba.frs.f cwW;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(com.baidu.tieba.frs.f fVar, com.baidu.tieba.frs.entelechy.b.a aVar) {
        super(fVar.getPageContext());
        this.cAm = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.cHU = null;
        this.cHW = false;
        this.bJy = null;
        this.cHX = null;
        this.cHY = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.h.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.ahb));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.ahb));
            }
        };
        this.cIc = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.h.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SignData signData;
                boolean z;
                int i;
                i ahf = f.this.cwW.ahf();
                if (ahf != null && ahf.aMU() != null && ahf.aMU().getName() != null && ahf.aMU().getName().equals(FrsActivityStatic.forumName)) {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name = ahf.aMU().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.tF(signMessage.mSignErrorCode) && signMessage.signData != null) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener) != null) {
                            TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.ahb));
                            return;
                        }
                        return;
                    }
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(ahf.aMU().getId())) {
                            f.this.kV(name);
                            ahf.d(signData2);
                            signData2.forumId = ahf.aMU().getId();
                            signData2.forumName = ahf.aMU().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = ahf.aMU().getUser_level();
                        if (f.this.alU()) {
                            i = ahf.aMU().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (AntiHelper.tF(signMessage.mSignErrorCode)) {
                            AntiHelper.ao(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                            return;
                        } else if (!f.this.alS()) {
                            f.this.cwW.showToast(f.this.getPageContext().getResources().getString(d.l.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                            return;
                        } else {
                            f.this.cwW.showToast(f.this.getPageContext().getResources().getString(d.l.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                            return;
                        }
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.kf(1);
                    }
                    f.this.cwW.showToast(signMessage.mSignErrorString);
                }
            }
        };
        this.crI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.h.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i ahf = f.this.cwW.ahf();
                if (ahf != null && ahf.aMU() != null && f.this.cHR != null && (view == f.this.cHR.alV() || view == f.this.cHR.amg() || view == f.this.cHR.amh())) {
                    if (f.this.cwW != null && ahf.aMU() != null) {
                        TiebaStatic.log(new ak("c12046").ac("fid", ahf.aMU().getId()).r("obj_locate", f.this.cwW.ahi() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), ahf.aMU().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == d.h.tv_love) {
                    if (!f.this.cwW.ahg() && j.hh()) {
                        if (!ax.aT(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new ak("c10517").r("obj_locate", 1).ac("fid", f.this.cwW.getForumId()));
                        } else {
                            f.this.fg(true);
                        }
                    }
                } else if (id == d.h.tv_sign) {
                    if (!f.this.cwW.ahg() && j.hh() && ax.aT(f.this.mContext.getPageActivity())) {
                        if (!f.this.alT()) {
                            f.this.alX();
                        } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(f.this.cwW.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.g(f.this.cwW.getForumId(), 0), 24002)));
                        }
                    }
                } else if (id == d.h.frs_header_games) {
                    if (ax.aT(f.this.mContext.getPageActivity()) && ahf != null && ahf.bpC() != null) {
                        String bpC = ahf.bpC();
                        if (m.dx(bpC) == 3) {
                            m.a(f.this.cwW.getPageContext(), bpC);
                        } else {
                            av.vA().a((TbPageContext) f.this.getPageContext(), new String[]{bpC}, true);
                        }
                    }
                } else if (id == d.h.frs_bawu_center) {
                    if (ahf != null && ahf.getUserData() != null && ahf.getUserData().isBawu()) {
                        String bpK = ahf.bpK();
                        if (!am.isEmpty(bpK)) {
                            com.baidu.tbadk.browser.a.O(f.this.getPageContext().getPageActivity(), bpK);
                            if (ahf.aMU() != null) {
                                TiebaStatic.log(new ak("c10502").ac("fid", ahf.aMU().getId()).ac(SapiAccountManager.SESSION_UID, ahf.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == d.h.level_container && !f.this.cwW.ahg() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page")) && f.this.cHR != null) {
                        f.this.cHR.g(view, false);
                    }
                }
            }
        };
        this.cwW = fVar;
        this.cHZ = aVar;
        if (this.cHZ != null) {
            this.cqy = this.cHZ.aiD();
        }
        this.cIb = new com.baidu.tieba.e.a();
        this.cIb.a(new a.InterfaceC0081a() { // from class: com.baidu.tieba.frs.h.f.3
            @Override // com.baidu.tieba.e.a.InterfaceC0081a
            public void ao(int i, int i2) {
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0081a
            public void ap(int i, int i2) {
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0081a
            public void aq(int i, int i2) {
            }
        });
    }

    public void l(Bundle bundle) {
        this.cwW.registerListener(this.cIc);
        afQ();
        alY();
        this.cHW = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.cHR != null) {
            this.cHR.onDestory();
        }
        if (this.bJy != null) {
            this.bJy.bqB();
        }
        if (this.cHV != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.cHV);
        }
    }

    public void onActivityStop() {
        if (this.cHR != null) {
            this.cHR.onStop();
        }
    }

    public boolean kb(int i) {
        this.mSkinType = i;
        if (this.cHR != null) {
            this.cHR.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void d(BdTypeListView bdTypeListView) {
        this.cAm = bdTypeListView;
    }

    public void ff(boolean z) {
        if (z) {
            if (this.cHR != null) {
                this.cAm.removeHeaderView(this.cHR.amf());
                this.cHY = false;
            }
        } else if (this.cHR != null && this.cHR.amf() != null && !this.cHY) {
            this.cAm.addHeaderView(this.cHR.amf(), this.cAm.getHeaderViewsCount());
            this.cHY = true;
        }
    }

    public void a(String str, i iVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) && iVar != null && iVar.getUserData() != null && iVar.aMU() != null) {
            f(str, iVar.getUserData().getIsMem(), iVar.aMU().isLike());
        }
    }

    public void f(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.cHU, str);
        this.ccx = i2;
        this.cHU = str;
        alO();
        if (this.cHR == null || z) {
            this.cHR = this.cHZ.a(str, this.cwW, i);
            this.cHR.changeSkinType(this.mSkinType);
            this.cHR.setCommonClickListener(this.crI);
        }
        this.cAm.addHeaderView(this.cHR.getView());
        if (this.cqy != null) {
            this.cqy.a(this.cAm, this.cHR);
        }
        if (this.cwW.ahi()) {
            this.cHR.n(0, l.f(TbadkCoreApplication.getInst(), d.f.ds40), 0, l.f(this.mContext.getPageActivity(), d.f.ds20));
        } else {
            int f = l.f(TbadkCoreApplication.getInst(), d.f.ds34);
            this.cHR.n(0, f, 0, f);
        }
        alP();
    }

    public void alN() {
        if (!this.cHY && this.cHR != null) {
            this.cAm.addHeaderView(this.cHR.amf());
            this.cHY = true;
        }
    }

    private void alO() {
        if (("normal_page".equals(this.cHU) || "frs_page".equals(this.cHU) || "book_page".equals(this.cHU)) && this.cHR != null) {
            this.cAm.removeHeaderView(this.cHR.getView());
            this.cAm.removeHeaderView(this.cHR.amf());
        }
        this.cHY = false;
    }

    private void alP() {
        if (this.cHV == null) {
            this.cHV = new Runnable() { // from class: com.baidu.tieba.frs.h.f.4
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0 && f.this.cAm.isRefreshDone() && !f.this.cHW && f.this.ccx == 1 && f.this.cwW.agP() != null && f.this.cwW.agP().ahp() != null && !f.this.cwW.agP().ahp().ajs()) {
                        if (("frs_page".equals(f.this.cHU) || "normal_page".equals(f.this.cHU) || "book_page".equals(f.this.cHU)) && f.this.cHR != null && f.this.cHR.ame()) {
                            TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                            f.this.aiR();
                            f.this.cwW.cpW = true;
                            f.this.cHW = true;
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.fP().postDelayed(this.cHV, 4000L);
    }

    public void f(i iVar) {
        if (iVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(iVar.aMU(), iVar);
            }
        }
    }

    public void b(ForumData forumData, i iVar) {
        if (forumData != null && iVar != null) {
            float a = a(forumData);
            if (this.cHR != null) {
                this.cHR.a(forumData, iVar);
                this.cHR.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.cHR.ki(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.cHR.fh(false);
                        return;
                    }
                    this.cHR.fh(true);
                    this.cHR.ki(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.cHS = forumData.getLevelupScore();
        this.cHT = forumData.getCurScore();
        if (this.cHS > 0) {
            return this.cHT / this.cHS;
        }
        return 0.0f;
    }

    public void kc(int i) {
        if (i > 1) {
            if (this.cHR != null) {
                this.cHR.fi(false);
            }
        } else if (this.cHR != null) {
            this.cHR.fi(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void f(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            alQ();
        }
    }

    public void setIsMem(int i) {
        if (this.cHR != null) {
            this.cHR.setMemberType(i);
        }
    }

    public void aiR() {
        if (("normal_page".equals(this.cHU) || "frs_page".equals(this.cHU) || "book_page".equals(this.cHU)) && this.cHR != null) {
            this.cHR.aiR();
        }
    }

    public void alQ() {
        if (this.cHR != null) {
            this.cHR.aiT();
        }
    }

    public void a(i iVar, boolean z) {
        if (iVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, iVar.aMU(), iVar, z);
            }
        }
    }

    public void alR() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            ke(0);
        }
    }

    public void kd(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            ke(i);
        }
    }

    public void ke(int i) {
        if (this.cHR != null) {
            this.cHR.kh(i);
        }
    }

    public void a(int i, ForumData forumData, i iVar, boolean z) {
        if (this.cHR != null) {
            this.cHR.a(forumData, iVar);
            if (forumData != null) {
                this.cHR.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.cHR.fh(false);
                }
            }
        }
    }

    public boolean alS() {
        if (("normal_page".equals(this.cHU) || "frs_page".equals(this.cHU) || "book_page".equals(this.cHU)) && this.cHR != null) {
            return this.cHR.amd();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.cHS - this.cHT) {
                z = true;
                this.cHS = signData.levelup_score;
            }
            this.cHT = i + this.cHT;
            if (this.cHT > this.cHS) {
                this.cHT = this.cHS;
            }
            if (this.cHS != 0) {
                f = this.cHT / this.cHS;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.c(z, f);
        }
    }

    public void kf(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cHR != null) {
            this.cHR.ki(i);
        }
    }

    public void g(i iVar) {
        SignData signData;
        ForumData aMU;
        if (iVar != null && iVar.aMU() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cHR != null && (signData = iVar.aMU().getSignData()) != null && (aMU = iVar.aMU()) != null) {
                this.cHR.a(aMU, iVar);
                this.cHR.ki(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.cHR.amd()) {
                    a(this.cHR, signData);
                    aMU.setCurScore(this.cHT);
                    aMU.setLevelupScore(this.cHS);
                    this.cHR.a(aMU, iVar);
                }
            }
        }
    }

    public boolean alT() {
        if (("normal_page".equals(this.cHU) || "frs_page".equals(this.cHU) || "book_page".equals(this.cHU)) && this.cHR != null) {
            return this.cHR.alT();
        }
        return false;
    }

    public boolean alU() {
        if (("normal_page".equals(this.cHU) || "frs_page".equals(this.cHU) || "book_page".equals(this.cHU)) && this.cHR != null) {
            return this.cHR.alU();
        }
        return false;
    }

    public BarImageView alV() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cHR != null) {
            return this.cHR.alV();
        }
        return null;
    }

    public void fg(boolean z) {
        if (this.cwW != null) {
            i ahf = this.cwW.ahf();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.cwW.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.l.login_to_use), true, 11002)));
            } else if (ahf != null && ahf.aMU() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.cwW.getFrom())) {
                    TiebaStatic.log(new ak("c10356").ac("fid", ahf.aMU().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.cwW.getFrom())) {
                    TiebaStatic.log(new ak("c10590").r("obj_type", 2).ac("fid", ahf.aMU().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.cwW.getFrom())) {
                    TiebaStatic.log(new ak("c10587").r("obj_type", 2).ac("fid", ahf.aMU().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.cwW.getFrom())) {
                    TiebaStatic.log(new ak("c10578").r("obj_type", 2).ac("fid", ahf.aMU().getId()));
                }
                this.bJy.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.cwW.getFrom())) {
                    TiebaStatic.eventStat(this.cwW.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.cwW.getFrom())) {
                    TiebaStatic.log(new ak("c10359").ac("fid", ahf.aMU().getId()));
                }
                this.bJy.J(ahf.aMU().getName(), ahf.aMU().getId(), "FRS");
                this.cIa = z;
            }
        }
    }

    public void alW() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.cwW.ahf() != null && this.cwW.ahf().aMU() != null && this.cwW.ahf().aMU().getName() != null) {
            str = this.cwW.ahf().aMU().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cL(String.format(getPageContext().getString(d.l.attention_cancel_dialog_content), str));
        } else {
            aVar.cL(getPageContext().getString(d.l.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(d.l.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.h.f.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                i ahf = f.this.cwW.ahf();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.cwW.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) f.this.getPageContext().getPageActivity(), f.this.getPageContext().getString(d.l.login_to_use), true, 11036)));
                } else if (ahf != null && ahf.aMU() != null) {
                    f.this.cHX.r(ahf.aMU().getName(), com.baidu.adp.lib.g.b.c(ahf.aMU().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(d.l.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.h.f.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).tb();
    }

    public void alX() {
        i ahf = this.cwW.ahf();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.cwW.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.l.login_to_use), true, 11014)));
        } else if (ahf != null && ahf.aMU() != null) {
            FrsActivityStatic.forumName = ahf.aMU().getName() == null ? "" : ahf.aMU().getName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, ahf.aMU()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kV(String str) {
        if (this.cwW.agK() != null && this.cwW.agK().akN() != null) {
            com.baidu.tieba.tbadkCore.c.bpi().Y(com.baidu.tieba.tbadkCore.c.bpi().d(str, this.cwW.agK().akN().OT(), this.cwW.agK().akN().getIsGood(), this.cwW.agK().akN().getCategoryId()), false);
        }
    }

    private void afQ() {
        this.bJy = new LikeModel(this.cwW.getPageContext());
        this.bJy.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.h.f.8
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                o oVar;
                if (AntiHelper.tF(f.this.bJy.getErrorCode())) {
                    AntiHelper.ao(f.this.getPageContext().getPageActivity(), f.this.bJy.getErrorString());
                    return;
                }
                i ahf = f.this.cwW.ahf();
                if (ahf != null && ahf.aMU() != null && obj != null) {
                    String name = ahf.aMU().getName();
                    String id = ahf.aMU().getId();
                    boolean z = false;
                    if (!(obj instanceof o)) {
                        oVar = null;
                    } else {
                        oVar = (o) obj;
                    }
                    if (oVar != null && f.this.bJy.getErrorCode() == 0) {
                        z = true;
                    }
                    if (oVar == null || !z) {
                        if (f.this.bJy.getErrorCode() == 22) {
                            f.this.cwW.showToast(f.this.getPageContext().getString(d.l.had_liked_forum));
                        } else if (AntiHelper.tF(f.this.bJy.getErrorCode())) {
                            AntiHelper.ao(f.this.getPageContext().getPageActivity(), f.this.bJy.getErrorString());
                        } else {
                            f.this.cwW.showToast(f.this.bJy.getErrorString());
                        }
                    } else {
                        f.this.kV(name);
                        oVar.setLike(1);
                        ahf.c(oVar);
                        ahf.dk(oVar.bpl());
                        f.this.a(ahf, f.this.cIa);
                        f.this.cIa = true;
                        f.this.cwW.showToast(f.this.getPageContext().getResources().getString(d.l.attention_success));
                        f.this.e(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, oVar));
                    }
                    f.this.cwW.O(Boolean.valueOf(z));
                }
            }
        });
    }

    private void alY() {
        this.cHX = new u();
        this.cHX.setFrom("from_frs");
        this.cHX.a(new u.a() { // from class: com.baidu.tieba.frs.h.f.9
            @Override // com.baidu.tieba.tbadkCore.u.a
            public void k(String str, long j) {
                i ahf = f.this.cwW.ahf();
                if (ahf != null && ahf.aMU() != null) {
                    String name = ahf.aMU().getName();
                    String id = ahf.aMU().getId();
                    if (j == com.baidu.adp.lib.g.b.c(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.kV(str);
                        ahf.aMU().setLike(0);
                        f.this.kd(0);
                        f.this.cwW.N(true);
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
        com.baidu.tieba.im.settingcache.d.aza().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void y(int i, int i2, int i3) {
        i ahf;
        if (i > 0 && i2 > 0 && (ahf = this.cwW.ahf()) != null && ahf.aMU() != null && ahf.getSignData() != null) {
            ForumData aMU = ahf.aMU();
            SignData signData = ahf.getSignData();
            signData.levelup_score = aMU.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            ahf.d(signData);
            signData.forumId = aMU.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            int i4 = -1;
            if (alU()) {
                i4 = aMU.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(aMU.getName(), signData.sign_bonus_point, i4);
        }
    }

    public int alZ() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            if (this.cHR != null && this.cHR.amf() != null && this.cHR.amf().getParent() != null) {
                return this.cAm.getHeaderViewsCount() - 2;
            }
            return this.cAm.getHeaderViewsCount() - 1;
        }
        return 0;
    }

    public void aiC() {
        if (this.cHR != null) {
            this.cHR.aiC();
        }
    }

    public static boolean h(i iVar) {
        if (iVar != null) {
            return (iVar.bpO() == null || StringUtils.isNull(iVar.bpO().pE(), true) || iVar.bpO().pE().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean i(i iVar) {
        if (iVar != null) {
            return ((iVar.bps() == null || iVar.bps().bqb() != 1) && iVar.bpN() == null && (iVar.bpt() == null || v.u(iVar.bpt().pD())) && ((iVar.aMU() == null || iVar.aMU().getFrsBannerData() == null || iVar.aMU().getFrsBannerData().getType() != 2) && (iVar.bpP() == null || StringUtils.isNull(iVar.bpP().pL(), true)))) ? false : true;
        }
        return false;
    }

    public void kg(int i) {
        View findViewById;
        if (this.cHR != null && this.cHR.amf() != null && (findViewById = this.cHR.amf().findViewById(d.h.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.cIb != null) {
            this.cIb.onTouchEvent(motionEvent);
        }
    }
}
