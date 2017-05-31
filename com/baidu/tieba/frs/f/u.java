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
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.base.e<BaseFragmentActivity> {
    private int bMm;
    private com.baidu.tieba.frs.r bTw;
    com.baidu.tieba.frs.entelechy.b.b bUt;
    private final View.OnClickListener bVy;
    private LikeModel bzS;
    private BdTypeListView ccf;
    private com.baidu.tieba.frs.view.b chL;
    private int chM;
    private int chN;
    private String chO;
    private Runnable chP;
    private boolean chQ;
    private com.baidu.tieba.tbadkCore.ae chR;
    private boolean chS;
    private com.baidu.tieba.frs.entelechy.b.a chT;
    private boolean chU;
    private com.baidu.tieba.e.a chV;
    private int chW;
    private CustomMessageListener chX;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public u(com.baidu.tieba.frs.r rVar, com.baidu.tieba.frs.entelechy.b.a aVar) {
        super(rVar.getPageContext());
        this.ccf = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.chO = null;
        this.chQ = false;
        this.bzS = null;
        this.chR = null;
        this.chS = false;
        this.chW = 0;
        this.chX = new v(this, CmdConfigCustom.CMD_SIGN_MODEL_TASK);
        this.bVy = new w(this);
        this.bTw = rVar;
        this.chT = aVar;
        if (this.chT != null) {
            this.bUt = this.chT.abn();
        }
        rVar.registerListener(this.chX);
        this.chV = new com.baidu.tieba.e.a();
        this.chV.a(new x(this));
    }

    public void h(Bundle bundle) {
        Zt();
        aeg();
        this.chQ = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.chL != null) {
            this.chL.onDestory();
        }
        if (this.bzS != null) {
            this.bzS.bhs();
        }
        if (this.chP != null) {
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.chP);
        }
    }

    public void onActivityStop() {
        if (this.chL != null) {
            this.chL.onStop();
        }
    }

    public boolean ja(int i) {
        this.mSkinType = i;
        if (this.chL != null) {
            this.chL.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void d(BdTypeListView bdTypeListView) {
        this.ccf = bdTypeListView;
    }

    public void ey(boolean z) {
        if (z) {
            if (this.chL != null) {
                this.ccf.removeHeaderView(this.chL.aek());
                this.chS = false;
            }
        } else if (this.chL != null && this.chL.aek() != null && !this.chS) {
            this.ccf.addHeaderView(this.chL.aek(), this.ccf.getHeaderViewsCount());
            this.chS = true;
        }
    }

    public void a(String str, com.baidu.tieba.tbadkCore.n nVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) && nVar != null && nVar.getUserData() != null && nVar.aIz() != null) {
            e(str, nVar.getUserData().getIsMem(), nVar.aIz().isLike());
        }
    }

    public void e(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.chO, str);
        this.bMm = i2;
        this.chO = str;
        adW();
        if (this.chL == null || z) {
            this.chL = this.chT.a(str, this.bTw, i);
            this.chL.changeSkinType(this.mSkinType);
            this.chL.setCommonClickListener(this.bVy);
        }
        this.ccf.addHeaderView(this.chL.getView());
        if (this.bUt != null) {
            this.bUt.a(this.ccf, this.chL);
        }
        if (this.bTw.aaw()) {
            this.chL.ji(com.baidu.adp.lib.util.k.g(this.bTw.getActivity(), w.f.ds40));
        } else {
            this.chL.ji(com.baidu.adp.lib.util.k.g(this.bTw.getActivity(), w.f.ds20));
        }
        adX();
    }

    public void adV() {
        if (!this.chS && this.chL != null) {
            this.ccf.addHeaderView(this.chL.aek());
            this.chS = true;
        }
    }

    private void adW() {
        if (("normal_page".equals(this.chO) || "frs_page".equals(this.chO) || "book_page".equals(this.chO)) && this.chL != null) {
            this.ccf.removeHeaderView(this.chL.getView());
            this.ccf.removeHeaderView(this.chL.aek());
        }
        this.chS = false;
    }

    private void adX() {
        if (this.chP == null) {
            this.chP = new y(this);
        }
        com.baidu.adp.lib.g.h.fS().postDelayed(this.chP, 4000L);
    }

    public void f(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(nVar.aIz(), nVar);
            }
        }
    }

    public void b(ForumData forumData, com.baidu.tieba.tbadkCore.n nVar) {
        if (forumData != null && nVar != null) {
            float a = a(forumData);
            if (this.chL != null) {
                this.chL.a(forumData, nVar);
                this.chL.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.chL.jh(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.chL.eA(false);
                    } else {
                        this.chL.eA(true);
                        this.chL.jh(forumData.getSignData().is_signed);
                    }
                }
                if (forumData.getUser_level() > this.chW) {
                    be beVar = new be();
                    beVar.setForumName(forumData.getName());
                    beVar.setForumLevel(forumData.getUser_level());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_UPDATE_USER_LEVEL, beVar));
                    this.chW = forumData.getUser_level();
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.chM = forumData.getLevelupScore();
        this.chN = forumData.getCurScore();
        if (this.chM > 0) {
            return this.chN / this.chM;
        }
        return 0.0f;
    }

    public void jb(int i) {
        if (i > 1) {
            if (this.chL != null) {
                this.chL.eB(false);
            }
        } else if (this.chL != null) {
            this.chL.eB(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void a(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            adY();
        }
    }

    public void setIsMem(int i) {
        if (this.chL != null) {
            this.chL.setMemberType(i);
        }
    }

    public void abz() {
        if (("normal_page".equals(this.chO) || "frs_page".equals(this.chO) || "book_page".equals(this.chO)) && this.chL != null) {
            this.chL.abz();
        }
    }

    public void adY() {
        if (this.chL != null) {
            this.chL.abB();
        }
    }

    public void a(com.baidu.tieba.tbadkCore.n nVar, boolean z) {
        if (nVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, nVar.aIz(), nVar, z);
            }
        }
    }

    public void adZ() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            jd(0);
        }
    }

    public void jc(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            jd(i);
        }
    }

    public void jd(int i) {
        if (this.chL != null) {
            this.chL.jg(i);
        }
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.tbadkCore.n nVar, boolean z) {
        if (this.chL != null) {
            this.chL.a(forumData, nVar);
            if (forumData != null) {
                this.chL.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.chL.eA(false);
                }
            }
        }
    }

    public boolean aea() {
        if (("normal_page".equals(this.chO) || "frs_page".equals(this.chO) || "book_page".equals(this.chO)) && this.chL != null) {
            return this.chL.aei();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.chM - this.chN) {
                z = true;
                this.chM = signData.levelup_score;
            }
            this.chN = i + this.chN;
            if (this.chN > this.chM) {
                this.chN = this.chM;
            }
            if (this.chM != 0) {
                f = this.chN / this.chM;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.c(z, f);
        }
    }

    public void je(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.chL != null) {
            this.chL.jh(i);
        }
    }

    public void g(com.baidu.tieba.tbadkCore.n nVar) {
        SignData signData;
        ForumData aIz;
        if (nVar != null && nVar.aIz() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.chL != null && (signData = nVar.aIz().getSignData()) != null && (aIz = nVar.aIz()) != null) {
                this.chL.a(aIz, nVar);
                this.chL.jh(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.chL.aei()) {
                    a(this.chL, signData);
                    aIz.setCurScore(this.chN);
                    aIz.setLevelupScore(this.chM);
                    this.chL.a(aIz, nVar);
                }
            }
        }
    }

    public boolean aeb() {
        if (("normal_page".equals(this.chO) || "frs_page".equals(this.chO) || "book_page".equals(this.chO)) && this.chL != null) {
            return this.chL.aeb();
        }
        return false;
    }

    public boolean aec() {
        if (("normal_page".equals(this.chO) || "frs_page".equals(this.chO) || "book_page".equals(this.chO)) && this.chL != null) {
            return this.chL.aec();
        }
        return false;
    }

    public BarImageView aed() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.chL != null) {
            return this.chL.aed();
        }
        return null;
    }

    public void ez(boolean z) {
        if (this.bTw != null) {
            com.baidu.tieba.tbadkCore.n aau = this.bTw.aau();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.m9getInst().login(this.bTw.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(w.l.login_to_use), true, 11002)));
            } else if (aau != null && aau.aIz() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.bTw.getFrom())) {
                    TiebaStatic.log(new as("c10356").Z("fid", aau.aIz().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.bTw.getFrom())) {
                    TiebaStatic.log(new as("c10590").r("obj_type", 2).Z("fid", aau.aIz().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.bTw.getFrom())) {
                    TiebaStatic.log(new as("c10587").r("obj_type", 2).Z("fid", aau.aIz().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.bTw.getFrom())) {
                    TiebaStatic.log(new as("c10578").r("obj_type", 2).Z("fid", aau.aIz().getId()));
                }
                this.bzS.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.bTw.getFrom())) {
                    TiebaStatic.eventStat(this.bTw.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.bTw.getFrom())) {
                    TiebaStatic.log(new as("c10359").Z("fid", aau.aIz().getId()));
                }
                this.bzS.E(aau.aIz().getName(), aau.aIz().getId(), "FRS");
                this.chU = z;
            }
        }
    }

    public void aee() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.bTw.aau() != null && this.bTw.aau().aIz() != null && this.bTw.aau().aIz().getName() != null) {
            str = this.bTw.aau().aIz().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cB(String.format(getPageContext().getString(w.l.attention_cancel_dialog_content), str));
        } else {
            aVar.cB(getPageContext().getString(w.l.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(w.l.editor_dialog_yes), new z(this));
        aVar.b(getPageContext().getString(w.l.editor_dialog_no), new aa(this));
        aVar.b(getPageContext()).tc();
    }

    public void aef() {
        com.baidu.tieba.tbadkCore.n aau = this.bTw.aau();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(this.bTw.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(w.l.login_to_use), true, 11014)));
        } else if (aau != null && aau.aIz() != null) {
            FrsActivityStatic.forumName = aau.aIz().getName() == null ? "" : aau.aIz().getName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, aau.aIz()));
        }
    }

    private void Zt() {
        this.bzS = new LikeModel(this.bTw.getPageContext());
        this.bzS.setLoadDataCallBack(new ab(this));
    }

    private void aeg() {
        this.chR = new com.baidu.tieba.tbadkCore.ae();
        this.chR.setFrom("from_frs");
        this.chR.a(new ac(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z, String str) {
        new ad(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void t(int i, int i2, int i3) {
        com.baidu.tieba.tbadkCore.n aau;
        if (i > 0 && i2 > 0 && (aau = this.bTw.aau()) != null && aau.aIz() != null && aau.getSignData() != null) {
            ForumData aIz = aau.aIz();
            SignData signData = aau.getSignData();
            signData.levelup_score = aIz.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            aau.d(signData);
            signData.forumId = aIz.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            int i4 = -1;
            if (aec()) {
                i4 = aIz.getUser_level() + 1;
            }
            TbadkCoreApplication.m9getInst().addSignedForum(aIz.getName(), signData.sign_bonus_point, i4);
        }
    }

    public int aeh() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            if (this.chL != null && this.chL.aek() != null && this.chL.aek().getParent() != null) {
                return this.ccf.getHeaderViewsCount() - 2;
            }
            return this.ccf.getHeaderViewsCount() - 1;
        }
        return 0;
    }

    public void abm() {
        if (this.chL != null) {
            this.chL.abm();
        }
    }

    public static boolean h(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            return (nVar.bgI() == null || StringUtils.isNull(nVar.bgI().getBookId(), true) || nVar.bgI().getBookId().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean i(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            return ((nVar.bgm() == null || nVar.bgm().bgT() != 1) && nVar.bgH() == null && (nVar.bgn() == null || com.baidu.tbadk.core.util.x.r(nVar.bgn().pE())) && ((nVar.aIz() == null || nVar.aIz().getFrsBannerData() == null || nVar.aIz().getFrsBannerData().getType() != 2) && (nVar.bgJ() == null || StringUtils.isNull(nVar.bgJ().pL(), true)))) ? false : true;
        }
        return false;
    }

    public void jf(int i) {
        View findViewById;
        if (this.chL != null && this.chL.aek() != null && (findViewById = this.chL.aek().findViewById(w.h.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.chV != null) {
            this.chV.onTouchEvent(motionEvent);
        }
    }
}
