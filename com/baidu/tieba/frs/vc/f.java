package com.baidu.tieba.frs.vc;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
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
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.message.SignMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes4.dex */
public class f extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private LikeModel crO;
    private Runnable dAP;
    private FrsFragment fNh;
    private boolean fSA;
    private com.baidu.tieba.f.a fSB;
    private BdUniqueId fSC;
    private FrsTabViewController fSD;
    private AntiHelper.a fSE;
    private CustomMessageListener fSF;
    private com.baidu.tieba.frs.view.b fSr;
    private int fSs;
    private String fSt;
    private Runnable fSu;
    private int fSv;
    private boolean fSw;
    private y fSx;
    private boolean fSy;
    private com.baidu.tieba.frs.entelechy.b.a fSz;
    private int frc;
    private final View.OnClickListener fwH;
    private FrsHeaderViewContainer fwZ;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.fwZ = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.fSt = null;
        this.fSw = false;
        this.crO = null;
        this.fSx = null;
        this.fSy = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).O("obj_locate", at.a.LOCATE_SIGN));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).O("obj_locate", at.a.LOCATE_SIGN));
            }
        };
        this.fSE = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.4
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).O("obj_locate", at.a.LOCATE_LIKE_BAR));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).O("obj_locate", at.a.LOCATE_LIKE_BAR));
            }
        };
        this.fSF = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.vc.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                FrsViewData bkn;
                String name;
                SignData signData;
                boolean z;
                int i;
                if (f.this.fNh != null && (customResponsedMessage instanceof SignMessage) && (bkn = f.this.fNh.bkn()) != null && bkn.getForum() != null && (name = bkn.getForum().getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == f.this.fSC) {
                    TiebaStatic.eventStat(f.this.fNh.getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name2 = bkn.getForum().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.aG(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                        if (signMessage.signData != null) {
                            AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener);
                        } else {
                            AntiHelper.aS(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                        }
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).O("obj_locate", at.a.LOCATE_SIGN));
                        return;
                    }
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(bkn.getForum().getId())) {
                            f.this.wB(name2);
                            bkn.updateSignData(signData2);
                            signData2.forumId = bkn.getForum().getId();
                            signData2.forumName = bkn.getForum().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = bkn.getForum().getUser_level();
                        if (f.this.bqF()) {
                            i = bkn.getForum().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (!f.this.bqD()) {
                            f.this.fNh.showToast(f.this.getPageContext().getResources().getString(R.string.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                        } else {
                            f.this.fNh.showToast(f.this.getPageContext().getResources().getString(R.string.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                        }
                        if (f.this.fNh.bjN() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.art().a(f.this.fNh.getTbPageContext(), f.this.fNh.bjN().aYb());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.rU(1);
                    }
                    f.this.fNh.showToast(signMessage.mSignErrorString);
                }
            }
        };
        this.dAP = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.8
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.fwZ != null) {
                    int childCount = f.this.fwZ.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(f.this.fwZ.getChildAt(i));
                    }
                }
            }

            private void refreshImage(View view) {
                if (view != null) {
                    if (view instanceof com.baidu.adp.newwidget.ImageView.h) {
                        ((com.baidu.adp.newwidget.ImageView.h) view).refresh();
                    }
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view;
                        int childCount = viewGroup.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            refreshImage(viewGroup.getChildAt(i));
                        }
                    }
                }
            }
        };
        this.fwH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsViewData bkn = f.this.fNh.bkn();
                if (bkn != null && bkn.getForum() != null && f.this.fSr != null && (view == f.this.fSr.bry() || view == f.this.fSr.brz() || view == f.this.fSr.brA())) {
                    if (f.this.fNh != null && bkn.getForum() != null) {
                        TiebaStatic.log(new an("c12046").bS("fid", bkn.getForum().getId()).O("obj_locate", f.this.fNh.bkp() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), bkn.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                }
                int id = view.getId();
                if (id == R.id.tv_love) {
                    if (!f.this.fNh.bko()) {
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            f.this.fNh.showToast(R.string.neterror);
                        } else if (!bc.checkUpIsLogin(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new an("c10517").O("obj_locate", 1).bS("fid", f.this.fNh.getForumId()));
                        } else {
                            f.this.kG(true);
                            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                an anVar = new an("c10048");
                                anVar.bS("fid", f.this.fNh.getForumId());
                                anVar.bS("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(anVar);
                            }
                        }
                    }
                } else if (id == R.id.tv_sign) {
                    if (!f.this.fNh.bko()) {
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            f.this.fNh.showToast(R.string.neterror);
                        } else if (bc.checkUpIsLogin(f.this.mContext.getPageActivity())) {
                            if (!f.this.bqE()) {
                                f.this.bqH();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(f.this.fNh.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.toInt(f.this.fNh.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                            }
                        }
                    }
                } else if (id == R.id.frs_header_games) {
                    if (bc.checkUpIsLogin(f.this.mContext.getPageActivity()) && bkn != null && bkn.getGameUrl() != null) {
                        ba.amO().a((TbPageContext) f.this.getPageContext(), new String[]{bkn.getGameUrl()}, true);
                    }
                } else if (id == R.id.frs_bawu_center) {
                    if (bkn != null && bkn.getUserData() != null && bkn.getUserData().isBawu()) {
                        String bawuCenterUrl = bkn.getBawuCenterUrl();
                        if (!aq.isEmpty(bawuCenterUrl)) {
                            com.baidu.tbadk.browser.a.startWebActivity(f.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            if (bkn.getForum() != null) {
                                TiebaStatic.log(new an("c10502").bS("fid", bkn.getForum().getId()).bS("uid", bkn.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == R.id.level_container && !f.this.fNh.bko() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page") || f.this.mPageType.equals("brand_page")) && f.this.fSr != null) {
                        f.this.fSr.i(view, false);
                    }
                }
            }
        };
        this.fNh = frsFragment;
        this.fSz = aVar;
        this.fwZ = frsHeaderViewContainer;
        this.fSC = BdUniqueId.gen();
        this.fSB = new com.baidu.tieba.f.a();
        this.fSB.a(new a.InterfaceC0405a() { // from class: com.baidu.tieba.frs.vc.f.6
            @Override // com.baidu.tieba.f.a.InterfaceC0405a
            public void t(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0405a
            public void u(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0405a
            public void v(int i, int i2) {
            }
        });
    }

    public void Q(Bundle bundle) {
        this.fNh.registerListener(this.fSF);
        aJT();
        bqI();
        this.fSw = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void aGF() {
        if (this.fSr != null) {
            this.fSr.onDestory();
        }
        if (this.crO != null) {
            this.crO.cnD();
        }
        if (this.fSu != null) {
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.fSu);
        }
    }

    public void anE() {
        if (this.fSr != null) {
            this.fSr.onStop();
        }
        if (this.fwZ != null) {
            this.fwZ.removeCallbacks(this.dAP);
        }
    }

    public void jJ(boolean z) {
        if (this.fSr != null) {
            this.fSr.jJ(z);
        }
    }

    public boolean rQ(int i) {
        this.mSkinType = i;
        if (this.fSr != null) {
            this.fSr.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void kF(boolean z) {
        if (z) {
            if (this.fSr != null) {
                this.fwZ.removeHeaderView(this.fSr.brx());
                this.fSy = false;
            }
        } else if (this.fSr != null && this.fSr.brx() != null && !this.fSy) {
            this.fwZ.addHeaderView(this.fSr.brx(), this.fwZ.getHeaderViewsCount());
            this.fSy = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        this.mPageType = str;
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            t(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean bqv() {
        return true;
    }

    private void t(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.fSt, str);
        this.fSv = i2;
        this.fSt = str;
        bqx();
        if (this.fSr == null || z) {
            this.fSr = this.fSz.a(str, this.fNh, i);
            this.fSr.changeSkinType(this.mSkinType);
            this.fSr.w(this.fwH);
        }
        this.fwZ.addHeaderView(this.fSr.getView());
        wA(this.mPageType);
        bqz();
    }

    public void bqw() {
        if (!this.fSy && this.fSr != null) {
            this.fwZ.addHeaderView(this.fSr.brx());
            this.fSy = true;
        }
    }

    private void bqx() {
        if (this.fSr != null) {
            this.fwZ.removeHeaderView(this.fSr.getView());
            this.fwZ.removeHeaderView(this.fSr.brx());
            bqy();
        }
        this.fSy = false;
    }

    private void bqy() {
        if (this.fSD != null && this.fNh != null && this.fNh.aod() != null) {
            this.fNh.aod().removeHeaderView(this.fSD.bqM());
        }
    }

    private void wA(String str) {
        RelativeLayout bqM;
        if (this.fSD != null && this.fNh != null && this.fNh.aod() != null && (bqM = this.fSD.bqM()) != null) {
            if ("brand_page".equals(str)) {
                this.fNh.aod().removeHeaderView(bqM);
                return;
            }
            this.fNh.aod().removeHeaderView(bqM);
            this.fNh.aod().addHeaderView(bqM, 0);
        }
    }

    private void bqz() {
        if (this.fSu == null) {
            this.fSu = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.fNh.bjN() == null || !f.this.fNh.bjN().bko()) && f.this.fwZ.isShown() && f.this.fNh.isPrimary() && !f.this.fSw && f.this.fSv == 1 && f.this.fNh.bjN() != null && f.this.fNh.bjN().bkJ() != null && !f.this.fNh.bjN().bkJ().bqs() && f.this.fNh.bkt()) {
                            if (("frs_page".equals(f.this.fSt) || "normal_page".equals(f.this.fSt) || "brand_page".equals(f.this.mPageType) || "book_page".equals(f.this.fSt)) && f.this.fSr != null && f.this.fSr.brw()) {
                                TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.bmR();
                                f.this.fNh.fuk = true;
                                f.this.fSw = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.fSu, 4000L);
    }

    public void i(FrsViewData frsViewData) {
        if (frsViewData != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                b(frsViewData.getForum(), frsViewData);
                if ("brand_page".equals(this.mPageType)) {
                    this.fSr.bmG();
                }
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float b = b(forumData);
            if (this.fSr != null) {
                this.fSr.a(forumData, frsViewData);
                this.fSr.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                if (forumData.getSignData() != null) {
                    this.fSr.sn(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.fSr.kN(false);
                        return;
                    }
                    this.fSr.kN(true);
                    this.fSr.sn(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.fSs = forumData.getLevelupScore();
        this.frc = forumData.getCurScore();
        if (this.fSs > 0) {
            return this.frc / this.fSs;
        }
        return 0.0f;
    }

    public void rR(int i) {
        if (i > 1) {
            if (this.fSr != null) {
                this.fSr.kO(false);
            }
        } else if (this.fSr != null) {
            this.fSr.kO(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void bqA() {
        if (this.fwZ != null) {
            this.fwZ.removeCallbacks(this.dAP);
            this.fwZ.postDelayed(this.dAP, 100L);
        }
    }

    public void e(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            bqB();
        }
    }

    public void setIsMem(int i) {
        if (this.fSr != null) {
            this.fSr.setMemberType(i);
        }
    }

    public void bmR() {
        if (("normal_page".equals(this.fSt) || "frs_page".equals(this.fSt) || "book_page".equals(this.fSt) || "brand_page".equals(this.mPageType)) && this.fSr != null) {
            this.fSr.bmR();
        }
    }

    public void bqB() {
        if (this.fSr != null) {
            this.fSr.bmT();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                a(1, frsViewData.getForum(), frsViewData, z);
            }
        }
    }

    public void bqC() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            rT(0);
        }
    }

    public void rS(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            rT(i);
        }
    }

    public void rT(int i) {
        if (this.fSr != null) {
            this.fSr.sm(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.fSr != null) {
            this.fSr.a(forumData, frsViewData);
            if (forumData != null) {
                this.fSr.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.fSr.kN(false);
                }
            }
        }
    }

    public boolean bqD() {
        if (("normal_page".equals(this.fSt) || "frs_page".equals(this.fSt) || "book_page".equals(this.fSt) || "brand_page".equals(this.mPageType)) && this.fSr != null) {
            return this.fSr.brv();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.fSs - this.frc) {
                z = true;
                this.fSs = signData.levelup_score;
            }
            this.frc = i + this.frc;
            if (this.frc > this.fSs) {
                this.frc = this.fSs;
            }
            if (this.fSs != 0) {
                f = this.frc / this.fSs;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.d(z, f);
        }
    }

    public void rU(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.fSr != null) {
            this.fSr.sn(i);
        }
    }

    public void j(FrsViewData frsViewData) {
        SignData signData;
        ForumData forum;
        if (frsViewData != null && frsViewData.getForum() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.fSr != null && (signData = frsViewData.getForum().getSignData()) != null && (forum = frsViewData.getForum()) != null) {
                this.fSr.a(forum, frsViewData);
                this.fSr.sn(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.fSr.brv()) {
                    a(this.fSr, signData);
                    forum.setCurScore(this.frc);
                    forum.setLevelupScore(this.fSs);
                    this.fSr.a(forum, frsViewData);
                }
            }
        }
    }

    public boolean bqE() {
        if (("normal_page".equals(this.fSt) || "frs_page".equals(this.fSt) || "book_page".equals(this.fSt) || "brand_page".equals(this.mPageType)) && this.fSr != null) {
            return this.fSr.bqE();
        }
        return false;
    }

    public boolean bqF() {
        if (("normal_page".equals(this.fSt) || "frs_page".equals(this.fSt) || "book_page".equals(this.fSt) || "brand_page".equals(this.mPageType)) && this.fSr != null) {
            return this.fSr.bqF();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void kG(boolean z) {
        if (this.fNh != null) {
            FrsViewData bkn = this.fNh.bkn();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.fNh.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11002)));
            } else if (bkn != null && bkn.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.fNh.getFrom())) {
                    TiebaStatic.log(new an("c10356").bS("fid", bkn.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.fNh.getFrom())) {
                    TiebaStatic.log(new an("c10590").O("obj_type", 2).bS("fid", bkn.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.fNh.getFrom())) {
                    TiebaStatic.log(new an("c10587").O("obj_type", 2).bS("fid", bkn.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.fNh.getFrom())) {
                    TiebaStatic.log(new an("c10578").O("obj_type", 2).bS("fid", bkn.getForum().getId()));
                }
                this.crO.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.fNh.getFrom())) {
                    TiebaStatic.eventStat(this.fNh.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.fNh.getFrom())) {
                    TiebaStatic.log(new an("c10359").bS("fid", bkn.getForum().getId()));
                }
                this.crO.ag(bkn.getForum().getName(), bkn.getForum().getId(), "FRS");
                this.fSA = z;
            }
        }
    }

    public void bqG() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.fNh.bkn() != null && this.fNh.bkn().getForum() != null && this.fNh.bkn().getForum().getName() != null) {
            str = this.fNh.bkn().getForum().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.nn(String.format(getPageContext().getString(R.string.attention_cancel_dialog_content), str));
        } else {
            aVar.nn(getPageContext().getString(R.string.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.10
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                FrsViewData bkn = f.this.fNh.bkn();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.fNh.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(f.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_UNLIKE)));
                } else if (bkn != null && bkn.getForum() != null) {
                    f.this.fSx.I(bkn.getForum().getName(), com.baidu.adp.lib.g.b.toLong(bkn.getForum().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).akM();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void bqH() {
        FrsViewData bkn = this.fNh.bkn();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.fNh.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_SIGN)));
        } else if (bkn != null && bkn.getForum() != null) {
            FrsActivityStatic.forumName = bkn.getForum().getName() == null ? "" : bkn.getForum().getName();
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, bkn.getForum());
            customMessage.setTag(this.fSC);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wB(String str) {
        if (this.fNh.bjI() != null && this.fNh.bjI().bpe() != null) {
            com.baidu.tieba.tbadkCore.d.cnj().av(com.baidu.tieba.tbadkCore.d.cnj().e("1~" + str, this.fNh.bjI().bpe().getSortType(), this.fNh.bjI().bpe().getIsGood(), this.fNh.bjI().bpe().getCategoryId()), false);
        }
    }

    private void aJT() {
        this.crO = new LikeModel(this.fNh.getPageContext());
        this.crO.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                t tVar;
                boolean z = false;
                FrsViewData bkn = f.this.fNh.bkn();
                if (bkn != null && bkn.getForum() != null && obj != null) {
                    if (AntiHelper.aG(f.this.crO.getErrorCode(), f.this.crO.getErrorString())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.crO.getBlockPopInfoData(), f.this.fSE) != null) {
                            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).O("obj_locate", at.a.LOCATE_LIKE_BAR));
                            return;
                        }
                        return;
                    }
                    String name = bkn.getForum().getName();
                    String id = bkn.getForum().getId();
                    if (!(obj instanceof t)) {
                        tVar = null;
                    } else {
                        tVar = (t) obj;
                    }
                    boolean z2 = tVar != null && f.this.crO.getErrorCode() == 0;
                    if (tVar.getErrorCode() == 3250013) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), tVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake_n_svg, 3000, true).akR();
                    } else {
                        z = z2;
                    }
                    if (tVar == null || !z) {
                        if (f.this.crO.getErrorCode() == 22) {
                            f.this.fNh.showToast(f.this.getPageContext().getString(R.string.had_liked_forum));
                        } else {
                            f.this.fNh.showToast(f.this.crO.getErrorString());
                        }
                    } else {
                        f.this.wB(name);
                        tVar.setLike(1);
                        bkn.updateLikeData(tVar);
                        bkn.setLikeFeedForumDataList(tVar.cnv());
                        f.this.a(bkn, f.this.fSA);
                        f.this.fSA = true;
                        f.this.fNh.showToast(f.this.getPageContext().getResources().getString(R.string.attention_success));
                        f.this.l(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, tVar));
                    }
                    f.this.fNh.an(Boolean.valueOf(z));
                }
            }
        });
    }

    private void bqI() {
        this.fSx = new y();
        this.fSx.setFrom("from_frs");
        this.fSx.a(new y.a() { // from class: com.baidu.tieba.frs.vc.f.3
            @Override // com.baidu.tieba.tbadkCore.y.a
            public void A(String str, long j) {
                FrsViewData bkn = f.this.fNh.bkn();
                if (bkn != null && bkn.getForum() != null) {
                    String name = bkn.getForum().getName();
                    String id = bkn.getForum().getId();
                    if (j == com.baidu.adp.lib.g.b.toLong(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.wB(str);
                        bkn.getForum().setLike(0);
                        f.this.rS(0);
                        f.this.fNh.am(true);
                        f.this.l(false, id);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, id));
                        t tVar = new t();
                        tVar.setLike(0);
                        tVar.setFid(id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, tVar));
                    }
                }
            }

            @Override // com.baidu.tieba.tbadkCore.y.a
            public void B(String str, long j) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.bEd().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void K(int i, int i2, int i3) {
        FrsViewData bkn;
        if (i > 0 && i2 > 0 && (bkn = this.fNh.bkn()) != null && bkn.getForum() != null && bkn.getSignData() != null) {
            ForumData forum = bkn.getForum();
            SignData signData = bkn.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            bkn.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            int i4 = -1;
            if (bqF()) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void bmO() {
        if (this.fSr != null) {
            this.fSr.bmO();
        }
    }

    public static boolean k(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().agW(), true) || frsViewData.getBookInfo().agW().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean l(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().cnw() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || v.isEmpty(frsViewData.getActivityHeadData().agU())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().ahd(), true)))) ? false : true;
        }
        return false;
    }

    public void rV(int i) {
        View findViewById;
        if (this.fSr != null && this.fSr.brx() != null && (findViewById = this.fSr.brx().findViewById(R.id.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void C(MotionEvent motionEvent) {
        if (this.fSB != null) {
            this.fSB.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.fSD = frsTabViewController;
    }
}
