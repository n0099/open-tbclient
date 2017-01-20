package com.baidu.tieba.frs.f;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.base.e<FrsActivity> {
    private LikeModel Fq;
    private com.baidu.tieba.play.ac aLe;
    com.baidu.tieba.frs.entelechy.b.b bGd;
    private final View.OnClickListener bHz;
    private FrsActivity bLZ;
    private BdTypeListView bOT;
    private com.baidu.tieba.frs.view.c bVE;
    private int bVF;
    private int bVG;
    private String bVH;
    private Runnable bVI;
    private boolean bVJ;
    private com.baidu.tieba.tbadkCore.ah bVK;
    private boolean bVL;
    private com.baidu.tieba.frs.entelechy.b.a bVM;
    private boolean bVN;
    private CustomMessageListener bVO;
    private int bxk;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public u(FrsActivity frsActivity, com.baidu.tieba.frs.entelechy.b.a aVar) {
        super(frsActivity.getPageContext());
        this.bOT = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.bVH = null;
        this.bVJ = false;
        this.Fq = null;
        this.bVK = null;
        this.bVL = false;
        this.bVO = new v(this, CmdConfigCustom.CMD_SIGN_MODEL_TASK);
        this.bHz = new w(this);
        this.bLZ = frsActivity;
        this.bVM = aVar;
        if (this.bVM != null) {
            this.bGd = this.bVM.ZE();
        }
        frsActivity.registerListener(this.bVO);
    }

    public void a(com.baidu.tieba.play.ac acVar) {
        this.aLe = acVar;
    }

    public void g(Bundle bundle) {
        lH();
        adh();
        this.bVJ = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.bVE != null) {
            this.bVE.onDestory();
        }
        if (this.Fq != null) {
            this.Fq.bgZ();
        }
        if (this.bVI != null) {
            this.bLZ.mHandler.removeCallbacks(this.bVI);
        }
    }

    public void onActivityStop() {
        if (this.bVE != null) {
            this.bVE.onStop();
        }
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        if (this.bVE != null) {
            this.bVE.changeSkinType(i);
            return true;
        }
        return true;
    }

    public com.baidu.tieba.frs.view.c acU() {
        return this.bVE;
    }

    public void d(BdTypeListView bdTypeListView) {
        this.bOT = bdTypeListView;
    }

    public void ek(boolean z) {
        if (z) {
            if (this.bVE != null) {
                this.bOT.removeHeaderView(this.bVE.adw());
                this.bVL = false;
            }
        } else if (this.bVE != null && this.bVE.adw() != null && !this.bVL) {
            this.bOT.addHeaderView(this.bVE.adw(), this.bOT.getHeaderViewsCount());
            this.bVL = true;
        }
    }

    public void a(String str, com.baidu.tieba.tbadkCore.n nVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) && nVar != null && nVar.getUserData() != null && nVar.aJY() != null) {
            e(str, nVar.getUserData().getIsMem(), nVar.aJY().isLike());
        }
    }

    public void e(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.bVH, str);
        this.bxk = i2;
        this.bVH = str;
        acW();
        if (this.bVE == null || z) {
            this.bVE = this.bVM.a(str, this.bLZ, i);
            this.bVE.changeSkinType(this.mSkinType);
            this.bVE.setCommonClickListener(this.bHz);
        }
        if (!this.bLZ.XM()) {
            this.bOT.addHeaderView(this.bVE.getView());
        }
        if (this.aLe != null) {
            this.aLe.a(this.bVE.adB());
        }
        if (this.bGd != null) {
            this.bGd.a(this.bOT, this.bVE);
        }
        acX();
    }

    public void acV() {
        if (!this.bVL && this.bVE != null) {
            if (!this.bLZ.XM()) {
                this.bOT.addHeaderView(this.bVE.adw());
            }
            this.bVL = true;
        }
    }

    private void acW() {
        if (("normal_page".equals(this.bVH) || "frs_page".equals(this.bVH) || "book_page".equals(this.bVH)) && this.bVE != null) {
            this.bOT.removeHeaderView(this.bVE.getView());
            this.bOT.removeHeaderView(this.bVE.adw());
        }
        this.bVL = false;
    }

    private void acX() {
        if (this.bVI == null) {
            this.bVI = new x(this);
        }
        this.bLZ.mHandler.postDelayed(this.bVI, 4000L);
    }

    public void h(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(nVar.aJY(), nVar);
            }
        }
    }

    public void b(ForumData forumData, com.baidu.tieba.tbadkCore.n nVar) {
        if (forumData != null && nVar != null) {
            float a = a(forumData);
            if (this.bVE != null) {
                this.bVE.a(forumData, nVar);
                this.bVE.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.bVE.iO(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.bVE.eo(false);
                        return;
                    }
                    this.bVE.eo(true);
                    this.bVE.iO(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.bVF = forumData.getLevelupScore();
        this.bVG = forumData.getCurScore();
        if (this.bVF > 0) {
            return this.bVG / this.bVF;
        }
        return 0.0f;
    }

    public void iH(int i) {
        if (i > 1) {
            if (this.bVE != null) {
                this.bVE.ep(false);
            }
        } else if (this.bVE != null) {
            this.bVE.ep(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void a(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            acY();
        }
    }

    public void setIsMem(int i) {
        if (this.bVE != null) {
            this.bVE.setMemberType(i);
        }
    }

    public void ZM() {
        if (("normal_page".equals(this.bVH) || "frs_page".equals(this.bVH) || "book_page".equals(this.bVH)) && this.bVE != null) {
            this.bVE.ZM();
        }
    }

    public void acY() {
        if (this.bVE != null) {
            this.bVE.ZO();
        }
    }

    public void a(com.baidu.tieba.tbadkCore.n nVar, boolean z) {
        if (nVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, nVar.aJY(), nVar, z);
            }
        }
    }

    public void acZ() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            iJ(0);
        }
    }

    public void iI(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            iJ(i);
        }
    }

    public void iJ(int i) {
        if (this.bVE != null) {
            this.bVE.iN(i);
        }
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.tbadkCore.n nVar, boolean z) {
        if (this.bVE != null) {
            this.bVE.a(forumData, nVar);
            if (forumData != null) {
                this.bVE.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.bVE.eo(false);
                }
            }
        }
    }

    public boolean ada() {
        if (("normal_page".equals(this.bVH) || "frs_page".equals(this.bVH) || "book_page".equals(this.bVH)) && this.bVE != null) {
            return this.bVE.adu();
        }
        return false;
    }

    public void adb() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.bVE != null) {
            this.bVE.adA().setVisibility(0);
        }
    }

    public void adc() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.bVE != null) {
            this.bVE.adA().setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.frs.view.c cVar, SignData signData) {
        if (cVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.bVF - this.bVG) {
                z = true;
                this.bVF = signData.levelup_score;
            }
            this.bVG = i + this.bVG;
            if (this.bVG > this.bVF) {
                this.bVG = this.bVF;
            }
            if (this.bVF != 0) {
                f = this.bVG / this.bVF;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            cVar.d(z, f);
        }
    }

    public void iK(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.bVE != null) {
            this.bVE.iO(i);
        }
    }

    public void i(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null && nVar.aJY() != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(nVar.aJY().getSignData(), nVar.aJY(), nVar);
            }
        }
    }

    public void j(com.baidu.tieba.tbadkCore.n nVar) {
        SignData signData;
        ForumData aJY;
        if (nVar != null && nVar.aJY() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.bVE != null && (signData = nVar.aJY().getSignData()) != null && (aJY = nVar.aJY()) != null) {
                if (this.bVE.adB() != null) {
                    this.bVE.adB().setWithSign(true);
                }
                this.bVE.a(aJY, nVar);
                this.bVE.iO(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.bVE.adu()) {
                    a(this.bVE, signData);
                    aJY.setCurScore(this.bVG);
                    aJY.setLevelupScore(this.bVF);
                    if (this.bVE.adB() != null) {
                        this.bVE.adB().setWithSign(true);
                    }
                    this.bVE.a(aJY, nVar);
                    this.bVE.c(this.bVE.adz(), true);
                }
            }
        }
    }

    public void a(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.n nVar) {
        if (this.bVE != null && signData != null && forumData != null && nVar != null) {
            this.bVE.a(forumData, nVar);
            this.bVE.iO(signData.is_signed);
            if (signData.sign_bonus_point > 0 && this.bVE.adu()) {
                a(this.bVE, signData);
                forumData.setCurScore(this.bVG);
                forumData.setLevelupScore(this.bVF);
                this.bVE.a(forumData, nVar);
                this.bVE.c(this.bVE.adz(), true);
            }
        }
    }

    public boolean add() {
        if (("normal_page".equals(this.bVH) || "frs_page".equals(this.bVH) || "book_page".equals(this.bVH)) && this.bVE != null) {
            return this.bVE.add();
        }
        return false;
    }

    public boolean ade() {
        if (("normal_page".equals(this.bVH) || "frs_page".equals(this.bVH) || "book_page".equals(this.bVH)) && this.bVE != null) {
            return this.bVE.ade();
        }
        return false;
    }

    public BarImageView adf() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.bVE != null) {
            return this.bVE.adf();
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void el(boolean z) {
        if (this.bLZ != null) {
            com.baidu.tieba.tbadkCore.n XW = this.bLZ.XW();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.m9getInst().login(this.bLZ.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(r.l.login_to_use), true, 11002)));
            } else if (XW != null && XW.aJY() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.bLZ.getFrom())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10356").ab("fid", XW.aJY().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.bLZ.getFrom())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10590").s("obj_type", 2).ab("fid", XW.aJY().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.bLZ.getFrom())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10587").s("obj_type", 2).ab("fid", XW.aJY().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.bLZ.getFrom())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10578").s("obj_type", 2).ab("fid", XW.aJY().getId()));
                }
                this.Fq.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.bLZ.getFrom())) {
                    TiebaStatic.eventStat(this.bLZ.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.bLZ.getFrom())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10359").ab("fid", XW.aJY().getId()));
                }
                this.Fq.K(XW.aJY().getName(), XW.aJY().getId(), "FRS");
                this.bVN = z;
            }
        }
    }

    public void XZ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.bLZ.XW() != null && this.bLZ.XW().aJY() != null && this.bLZ.XW().aJY().getName() != null) {
            str = this.bLZ.XW().aJY().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cE(String.format(getPageContext().getString(r.l.attention_cancel_dialog_content), str));
        } else {
            aVar.cE(getPageContext().getString(r.l.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(r.l.editor_dialog_yes), new y(this));
        aVar.b(getPageContext().getString(r.l.editor_dialog_no), new z(this));
        aVar.b(getPageContext()).sV();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void adg() {
        com.baidu.tieba.tbadkCore.n XW = this.bLZ.XW();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(this.bLZ.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(r.l.login_to_use), true, 11014)));
        } else if (XW != null && XW.aJY() != null) {
            adb();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, XW.aJY()));
        }
    }

    private void lH() {
        this.Fq = new LikeModel(this.bLZ.getPageContext());
        this.Fq.setLoadDataCallBack(new aa(this));
    }

    private void adh() {
        this.bVK = new com.baidu.tieba.tbadkCore.ah();
        this.bVK.setFrom("from_frs");
        this.bVK.a(new ab(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        new ac(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void t(int i, int i2, int i3) {
        com.baidu.tieba.tbadkCore.n XW;
        if (i > 0 && i2 > 0 && (XW = this.bLZ.XW()) != null && XW.aJY() != null && XW.getSignData() != null) {
            ForumData aJY = XW.aJY();
            SignData signData = XW.getSignData();
            signData.levelup_score = aJY.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            XW.d(signData);
            signData.forumId = aJY.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            i(XW);
            int i4 = -1;
            if (ade()) {
                i4 = aJY.getUser_level() + 1;
            }
            TbadkCoreApplication.m9getInst().addSignedForum(aJY.getName(), signData.sign_bonus_point, i4);
        }
    }

    public int adi() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            if (this.bVE.adw() != null && this.bVE.adw().getParent() != null) {
                return this.bOT.getHeaderViewsCount() - 2;
            }
            return this.bOT.getHeaderViewsCount() - 1;
        }
        return 0;
    }

    public void ZB() {
        if (this.bVE != null) {
            this.bVE.ZB();
        }
    }

    public static boolean k(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            return (nVar.bgj() == null || StringUtils.isNull(nVar.bgj().getBookId(), true) || nVar.bgj().getBookId().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean l(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            return ((nVar.bfM() == null || nVar.bfM().bgu() != 1) && nVar.bgi() == null && com.baidu.tbadk.core.util.w.s(nVar.bgp()) && (nVar.bfN() == null || com.baidu.tbadk.core.util.w.s(nVar.bfN().ps())) && ((nVar.aJY() == null || nVar.aJY().getFrsBannerData() == null || nVar.aJY().getFrsBannerData().getType() != 2) && (nVar.bgk() == null || StringUtils.isNull(nVar.bgk().pL(), true)))) ? false : true;
        }
        return false;
    }

    public void iL(int i) {
        View findViewById;
        if (this.bVE != null && this.bVE.adw() != null && (findViewById = this.bVE.adw().findViewById(r.h.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }
}
