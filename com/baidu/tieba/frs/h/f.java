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
    private LikeModel bJK;
    private BdTypeListView cAy;
    private com.baidu.tieba.frs.view.b cId;
    private int cIe;
    private int cIf;
    private String cIg;
    private Runnable cIh;
    private boolean cIi;
    private u cIj;
    private boolean cIk;
    private com.baidu.tieba.frs.entelechy.b.a cIl;
    private boolean cIm;
    private com.baidu.tieba.e.a cIn;
    private CustomMessageListener cIo;
    private int ccJ;
    com.baidu.tieba.frs.entelechy.b.b cqK;
    private final View.OnClickListener crU;
    private com.baidu.tieba.frs.f cxi;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(com.baidu.tieba.frs.f fVar, com.baidu.tieba.frs.entelechy.b.a aVar) {
        super(fVar.getPageContext());
        this.cAy = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.cIg = null;
        this.cIi = false;
        this.bJK = null;
        this.cIj = null;
        this.cIk = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.h.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.ahn));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.ahn));
            }
        };
        this.cIo = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.h.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SignData signData;
                boolean z;
                int i;
                i ahk = f.this.cxi.ahk();
                if (ahk != null && ahk.aMZ() != null && ahk.aMZ().getName() != null && ahk.aMZ().getName().equals(FrsActivityStatic.forumName)) {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name = ahk.aMZ().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.tG(signMessage.mSignErrorCode) && signMessage.signData != null) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener) != null) {
                            TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.ahn));
                            return;
                        }
                        return;
                    }
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(ahk.aMZ().getId())) {
                            f.this.kW(name);
                            ahk.d(signData2);
                            signData2.forumId = ahk.aMZ().getId();
                            signData2.forumName = ahk.aMZ().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = ahk.aMZ().getUser_level();
                        if (f.this.alZ()) {
                            i = ahk.aMZ().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (AntiHelper.tG(signMessage.mSignErrorCode)) {
                            AntiHelper.at(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                            return;
                        } else if (!f.this.alX()) {
                            f.this.cxi.showToast(f.this.getPageContext().getResources().getString(d.l.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                            return;
                        } else {
                            f.this.cxi.showToast(f.this.getPageContext().getResources().getString(d.l.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                            return;
                        }
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.kg(1);
                    }
                    f.this.cxi.showToast(signMessage.mSignErrorString);
                }
            }
        };
        this.crU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.h.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i ahk = f.this.cxi.ahk();
                if (ahk != null && ahk.aMZ() != null && f.this.cId != null && (view == f.this.cId.ama() || view == f.this.cId.aml() || view == f.this.cId.amm())) {
                    if (f.this.cxi != null && ahk.aMZ() != null) {
                        TiebaStatic.log(new ak("c12046").ad("fid", ahk.aMZ().getId()).r("obj_locate", f.this.cxi.ahn() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), ahk.aMZ().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == d.h.tv_love) {
                    if (!f.this.cxi.ahl() && j.hh()) {
                        if (!ax.aU(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new ak("c10517").r("obj_locate", 1).ad("fid", f.this.cxi.getForumId()));
                        } else {
                            f.this.fh(true);
                        }
                    }
                } else if (id == d.h.tv_sign) {
                    if (!f.this.cxi.ahl() && j.hh() && ax.aU(f.this.mContext.getPageActivity())) {
                        if (!f.this.alY()) {
                            f.this.amc();
                        } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(f.this.cxi.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.g(f.this.cxi.getForumId(), 0), 24002)));
                        }
                    }
                } else if (id == d.h.frs_header_games) {
                    if (ax.aU(f.this.mContext.getPageActivity()) && ahk != null && ahk.bpK() != null) {
                        String bpK = ahk.bpK();
                        if (m.dy(bpK) == 3) {
                            m.a(f.this.cxi.getPageContext(), bpK);
                        } else {
                            av.vH().a((TbPageContext) f.this.getPageContext(), new String[]{bpK}, true);
                        }
                    }
                } else if (id == d.h.frs_bawu_center) {
                    if (ahk != null && ahk.getUserData() != null && ahk.getUserData().isBawu()) {
                        String bpS = ahk.bpS();
                        if (!am.isEmpty(bpS)) {
                            com.baidu.tbadk.browser.a.T(f.this.getPageContext().getPageActivity(), bpS);
                            if (ahk.aMZ() != null) {
                                TiebaStatic.log(new ak("c10502").ad("fid", ahk.aMZ().getId()).ad(SapiAccountManager.SESSION_UID, ahk.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == d.h.level_container && !f.this.cxi.ahl() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page")) && f.this.cId != null) {
                        f.this.cId.g(view, false);
                    }
                }
            }
        };
        this.cxi = fVar;
        this.cIl = aVar;
        if (this.cIl != null) {
            this.cqK = this.cIl.aiI();
        }
        this.cIn = new com.baidu.tieba.e.a();
        this.cIn.a(new a.InterfaceC0081a() { // from class: com.baidu.tieba.frs.h.f.3
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
        this.cxi.registerListener(this.cIo);
        afV();
        amd();
        this.cIi = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.cId != null) {
            this.cId.onDestory();
        }
        if (this.bJK != null) {
            this.bJK.bqJ();
        }
        if (this.cIh != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.cIh);
        }
    }

    public void onActivityStop() {
        if (this.cId != null) {
            this.cId.onStop();
        }
    }

    public boolean kc(int i) {
        this.mSkinType = i;
        if (this.cId != null) {
            this.cId.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void d(BdTypeListView bdTypeListView) {
        this.cAy = bdTypeListView;
    }

    public void fg(boolean z) {
        if (z) {
            if (this.cId != null) {
                this.cAy.removeHeaderView(this.cId.amk());
                this.cIk = false;
            }
        } else if (this.cId != null && this.cId.amk() != null && !this.cIk) {
            this.cAy.addHeaderView(this.cId.amk(), this.cAy.getHeaderViewsCount());
            this.cIk = true;
        }
    }

    public void a(String str, i iVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) && iVar != null && iVar.getUserData() != null && iVar.aMZ() != null) {
            f(str, iVar.getUserData().getIsMem(), iVar.aMZ().isLike());
        }
    }

    public void f(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.cIg, str);
        this.ccJ = i2;
        this.cIg = str;
        alT();
        if (this.cId == null || z) {
            this.cId = this.cIl.a(str, this.cxi, i);
            this.cId.changeSkinType(this.mSkinType);
            this.cId.setCommonClickListener(this.crU);
        }
        this.cAy.addHeaderView(this.cId.getView());
        if (this.cqK != null) {
            this.cqK.a(this.cAy, this.cId);
        }
        if (this.cxi.ahn()) {
            this.cId.n(0, l.f(TbadkCoreApplication.getInst(), d.f.ds40), 0, l.f(this.mContext.getPageActivity(), d.f.ds20));
        } else {
            int f = l.f(TbadkCoreApplication.getInst(), d.f.ds34);
            this.cId.n(0, f, 0, f);
        }
        alU();
    }

    public void alS() {
        if (!this.cIk && this.cId != null) {
            this.cAy.addHeaderView(this.cId.amk());
            this.cIk = true;
        }
    }

    private void alT() {
        if (("normal_page".equals(this.cIg) || "frs_page".equals(this.cIg) || "book_page".equals(this.cIg)) && this.cId != null) {
            this.cAy.removeHeaderView(this.cId.getView());
            this.cAy.removeHeaderView(this.cId.amk());
        }
        this.cIk = false;
    }

    private void alU() {
        if (this.cIh == null) {
            this.cIh = new Runnable() { // from class: com.baidu.tieba.frs.h.f.4
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0 && f.this.cAy.isRefreshDone() && !f.this.cIi && f.this.ccJ == 1 && f.this.cxi.agU() != null && f.this.cxi.agU().ahu() != null && !f.this.cxi.agU().ahu().ajx()) {
                        if (("frs_page".equals(f.this.cIg) || "normal_page".equals(f.this.cIg) || "book_page".equals(f.this.cIg)) && f.this.cId != null && f.this.cId.amj()) {
                            TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                            f.this.aiW();
                            f.this.cxi.cqi = true;
                            f.this.cIi = true;
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.fP().postDelayed(this.cIh, 4000L);
    }

    public void f(i iVar) {
        if (iVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(iVar.aMZ(), iVar);
            }
        }
    }

    public void b(ForumData forumData, i iVar) {
        if (forumData != null && iVar != null) {
            float a = a(forumData);
            if (this.cId != null) {
                this.cId.a(forumData, iVar);
                this.cId.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.cId.kj(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.cId.fi(false);
                        return;
                    }
                    this.cId.fi(true);
                    this.cId.kj(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.cIe = forumData.getLevelupScore();
        this.cIf = forumData.getCurScore();
        if (this.cIe > 0) {
            return this.cIf / this.cIe;
        }
        return 0.0f;
    }

    public void kd(int i) {
        if (i > 1) {
            if (this.cId != null) {
                this.cId.fj(false);
            }
        } else if (this.cId != null) {
            this.cId.fj(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void f(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            alV();
        }
    }

    public void setIsMem(int i) {
        if (this.cId != null) {
            this.cId.setMemberType(i);
        }
    }

    public void aiW() {
        if (("normal_page".equals(this.cIg) || "frs_page".equals(this.cIg) || "book_page".equals(this.cIg)) && this.cId != null) {
            this.cId.aiW();
        }
    }

    public void alV() {
        if (this.cId != null) {
            this.cId.aiY();
        }
    }

    public void a(i iVar, boolean z) {
        if (iVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, iVar.aMZ(), iVar, z);
            }
        }
    }

    public void alW() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            kf(0);
        }
    }

    public void ke(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            kf(i);
        }
    }

    public void kf(int i) {
        if (this.cId != null) {
            this.cId.ki(i);
        }
    }

    public void a(int i, ForumData forumData, i iVar, boolean z) {
        if (this.cId != null) {
            this.cId.a(forumData, iVar);
            if (forumData != null) {
                this.cId.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.cId.fi(false);
                }
            }
        }
    }

    public boolean alX() {
        if (("normal_page".equals(this.cIg) || "frs_page".equals(this.cIg) || "book_page".equals(this.cIg)) && this.cId != null) {
            return this.cId.ami();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.cIe - this.cIf) {
                z = true;
                this.cIe = signData.levelup_score;
            }
            this.cIf = i + this.cIf;
            if (this.cIf > this.cIe) {
                this.cIf = this.cIe;
            }
            if (this.cIe != 0) {
                f = this.cIf / this.cIe;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.c(z, f);
        }
    }

    public void kg(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cId != null) {
            this.cId.kj(i);
        }
    }

    public void g(i iVar) {
        SignData signData;
        ForumData aMZ;
        if (iVar != null && iVar.aMZ() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cId != null && (signData = iVar.aMZ().getSignData()) != null && (aMZ = iVar.aMZ()) != null) {
                this.cId.a(aMZ, iVar);
                this.cId.kj(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.cId.ami()) {
                    a(this.cId, signData);
                    aMZ.setCurScore(this.cIf);
                    aMZ.setLevelupScore(this.cIe);
                    this.cId.a(aMZ, iVar);
                }
            }
        }
    }

    public boolean alY() {
        if (("normal_page".equals(this.cIg) || "frs_page".equals(this.cIg) || "book_page".equals(this.cIg)) && this.cId != null) {
            return this.cId.alY();
        }
        return false;
    }

    public boolean alZ() {
        if (("normal_page".equals(this.cIg) || "frs_page".equals(this.cIg) || "book_page".equals(this.cIg)) && this.cId != null) {
            return this.cId.alZ();
        }
        return false;
    }

    public BarImageView ama() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cId != null) {
            return this.cId.ama();
        }
        return null;
    }

    public void fh(boolean z) {
        if (this.cxi != null) {
            i ahk = this.cxi.ahk();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.cxi.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.l.login_to_use), true, 11002)));
            } else if (ahk != null && ahk.aMZ() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.cxi.getFrom())) {
                    TiebaStatic.log(new ak("c10356").ad("fid", ahk.aMZ().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.cxi.getFrom())) {
                    TiebaStatic.log(new ak("c10590").r("obj_type", 2).ad("fid", ahk.aMZ().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.cxi.getFrom())) {
                    TiebaStatic.log(new ak("c10587").r("obj_type", 2).ad("fid", ahk.aMZ().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.cxi.getFrom())) {
                    TiebaStatic.log(new ak("c10578").r("obj_type", 2).ad("fid", ahk.aMZ().getId()));
                }
                this.bJK.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.cxi.getFrom())) {
                    TiebaStatic.eventStat(this.cxi.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.cxi.getFrom())) {
                    TiebaStatic.log(new ak("c10359").ad("fid", ahk.aMZ().getId()));
                }
                this.bJK.J(ahk.aMZ().getName(), ahk.aMZ().getId(), "FRS");
                this.cIm = z;
            }
        }
    }

    public void amb() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.cxi.ahk() != null && this.cxi.ahk().aMZ() != null && this.cxi.ahk().aMZ().getName() != null) {
            str = this.cxi.ahk().aMZ().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cM(String.format(getPageContext().getString(d.l.attention_cancel_dialog_content), str));
        } else {
            aVar.cM(getPageContext().getString(d.l.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(d.l.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.h.f.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                i ahk = f.this.cxi.ahk();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.cxi.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) f.this.getPageContext().getPageActivity(), f.this.getPageContext().getString(d.l.login_to_use), true, 11036)));
                } else if (ahk != null && ahk.aMZ() != null) {
                    f.this.cIj.r(ahk.aMZ().getName(), com.baidu.adp.lib.g.b.c(ahk.aMZ().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(d.l.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.h.f.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).ti();
    }

    public void amc() {
        i ahk = this.cxi.ahk();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.cxi.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.l.login_to_use), true, 11014)));
        } else if (ahk != null && ahk.aMZ() != null) {
            FrsActivityStatic.forumName = ahk.aMZ().getName() == null ? "" : ahk.aMZ().getName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, ahk.aMZ()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kW(String str) {
        if (this.cxi.agP() != null && this.cxi.agP().akS() != null) {
            com.baidu.tieba.tbadkCore.c.bpq().Y(com.baidu.tieba.tbadkCore.c.bpq().d(str, this.cxi.agP().akS().OZ(), this.cxi.agP().akS().getIsGood(), this.cxi.agP().akS().getCategoryId()), false);
        }
    }

    private void afV() {
        this.bJK = new LikeModel(this.cxi.getPageContext());
        this.bJK.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.h.f.8
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                o oVar;
                if (AntiHelper.tG(f.this.bJK.getErrorCode())) {
                    AntiHelper.at(f.this.getPageContext().getPageActivity(), f.this.bJK.getErrorString());
                    return;
                }
                i ahk = f.this.cxi.ahk();
                if (ahk != null && ahk.aMZ() != null && obj != null) {
                    String name = ahk.aMZ().getName();
                    String id = ahk.aMZ().getId();
                    boolean z = false;
                    if (!(obj instanceof o)) {
                        oVar = null;
                    } else {
                        oVar = (o) obj;
                    }
                    if (oVar != null && f.this.bJK.getErrorCode() == 0) {
                        z = true;
                    }
                    if (oVar == null || !z) {
                        if (f.this.bJK.getErrorCode() == 22) {
                            f.this.cxi.showToast(f.this.getPageContext().getString(d.l.had_liked_forum));
                        } else if (AntiHelper.tG(f.this.bJK.getErrorCode())) {
                            AntiHelper.at(f.this.getPageContext().getPageActivity(), f.this.bJK.getErrorString());
                        } else {
                            f.this.cxi.showToast(f.this.bJK.getErrorString());
                        }
                    } else {
                        f.this.kW(name);
                        oVar.setLike(1);
                        ahk.c(oVar);
                        ahk.dk(oVar.bpt());
                        f.this.a(ahk, f.this.cIm);
                        f.this.cIm = true;
                        f.this.cxi.showToast(f.this.getPageContext().getResources().getString(d.l.attention_success));
                        f.this.e(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, oVar));
                    }
                    f.this.cxi.O(Boolean.valueOf(z));
                }
            }
        });
    }

    private void amd() {
        this.cIj = new u();
        this.cIj.setFrom("from_frs");
        this.cIj.a(new u.a() { // from class: com.baidu.tieba.frs.h.f.9
            @Override // com.baidu.tieba.tbadkCore.u.a
            public void k(String str, long j) {
                i ahk = f.this.cxi.ahk();
                if (ahk != null && ahk.aMZ() != null) {
                    String name = ahk.aMZ().getName();
                    String id = ahk.aMZ().getId();
                    if (j == com.baidu.adp.lib.g.b.c(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.kW(str);
                        ahk.aMZ().setLike(0);
                        f.this.ke(0);
                        f.this.cxi.N(true);
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
        com.baidu.tieba.im.settingcache.d.azf().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void y(int i, int i2, int i3) {
        i ahk;
        if (i > 0 && i2 > 0 && (ahk = this.cxi.ahk()) != null && ahk.aMZ() != null && ahk.getSignData() != null) {
            ForumData aMZ = ahk.aMZ();
            SignData signData = ahk.getSignData();
            signData.levelup_score = aMZ.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            ahk.d(signData);
            signData.forumId = aMZ.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            int i4 = -1;
            if (alZ()) {
                i4 = aMZ.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(aMZ.getName(), signData.sign_bonus_point, i4);
        }
    }

    public int ame() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            if (this.cId != null && this.cId.amk() != null && this.cId.amk().getParent() != null) {
                return this.cAy.getHeaderViewsCount() - 2;
            }
            return this.cAy.getHeaderViewsCount() - 1;
        }
        return 0;
    }

    public void aiH() {
        if (this.cId != null) {
            this.cId.aiH();
        }
    }

    public static boolean h(i iVar) {
        if (iVar != null) {
            return (iVar.bpW() == null || StringUtils.isNull(iVar.bpW().pL(), true) || iVar.bpW().pL().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean i(i iVar) {
        if (iVar != null) {
            return ((iVar.bpA() == null || iVar.bpA().bqj() != 1) && iVar.bpV() == null && (iVar.bpB() == null || v.u(iVar.bpB().pK())) && ((iVar.aMZ() == null || iVar.aMZ().getFrsBannerData() == null || iVar.aMZ().getFrsBannerData().getType() != 2) && (iVar.bpX() == null || StringUtils.isNull(iVar.bpX().pS(), true)))) ? false : true;
        }
        return false;
    }

    public void kh(int i) {
        View findViewById;
        if (this.cId != null && this.cId.amk() != null && (findViewById = this.cId.amk().findViewById(d.h.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.cIn != null) {
            this.cIn.onTouchEvent(motionEvent);
        }
    }
}
