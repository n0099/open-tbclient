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
    private LikeModel csF;
    private Runnable dBG;
    private FrsFragment fNY;
    private com.baidu.tieba.frs.view.b fTi;
    private int fTj;
    private String fTk;
    private Runnable fTl;
    private int fTm;
    private boolean fTn;
    private y fTo;
    private boolean fTp;
    private com.baidu.tieba.frs.entelechy.b.a fTq;
    private boolean fTr;
    private com.baidu.tieba.f.a fTs;
    private BdUniqueId fTt;
    private FrsTabViewController fTu;
    private AntiHelper.a fTv;
    private CustomMessageListener fTw;
    private int frU;
    private FrsHeaderViewContainer fxQ;
    private final View.OnClickListener fxy;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.fxQ = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.fTk = null;
        this.fTn = false;
        this.csF = null;
        this.fTo = null;
        this.fTp = false;
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
        this.fTv = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.4
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).O("obj_locate", at.a.LOCATE_LIKE_BAR));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).O("obj_locate", at.a.LOCATE_LIKE_BAR));
            }
        };
        this.fTw = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.vc.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                FrsViewData bkp;
                String name;
                SignData signData;
                boolean z;
                int i;
                if (f.this.fNY != null && (customResponsedMessage instanceof SignMessage) && (bkp = f.this.fNY.bkp()) != null && bkp.getForum() != null && (name = bkp.getForum().getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == f.this.fTt) {
                    TiebaStatic.eventStat(f.this.fNY.getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name2 = bkp.getForum().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.aH(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
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
                        if (signData2.forumId != null && signData2.forumId.equals(bkp.getForum().getId())) {
                            f.this.wB(name2);
                            bkp.updateSignData(signData2);
                            signData2.forumId = bkp.getForum().getId();
                            signData2.forumName = bkp.getForum().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = bkp.getForum().getUser_level();
                        if (f.this.bqH()) {
                            i = bkp.getForum().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (!f.this.bqF()) {
                            f.this.fNY.showToast(f.this.getPageContext().getResources().getString(R.string.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                        } else {
                            f.this.fNY.showToast(f.this.getPageContext().getResources().getString(R.string.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                        }
                        if (f.this.fNY.bjP() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.arv().a(f.this.fNY.getTbPageContext(), f.this.fNY.bjP().aYd());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.rV(1);
                    }
                    f.this.fNY.showToast(signMessage.mSignErrorString);
                }
            }
        };
        this.dBG = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.8
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.fxQ != null) {
                    int childCount = f.this.fxQ.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(f.this.fxQ.getChildAt(i));
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
        this.fxy = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsViewData bkp = f.this.fNY.bkp();
                if (bkp != null && bkp.getForum() != null && f.this.fTi != null && (view == f.this.fTi.brA() || view == f.this.fTi.brB() || view == f.this.fTi.brC())) {
                    if (f.this.fNY != null && bkp.getForum() != null) {
                        TiebaStatic.log(new an("c12046").bS("fid", bkp.getForum().getId()).O("obj_locate", f.this.fNY.bkr() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), bkp.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                }
                int id = view.getId();
                if (id == R.id.tv_love) {
                    if (!f.this.fNY.bkq()) {
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            f.this.fNY.showToast(R.string.neterror);
                        } else if (!bc.checkUpIsLogin(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new an("c10517").O("obj_locate", 1).bS("fid", f.this.fNY.getForumId()));
                        } else {
                            f.this.kG(true);
                            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                an anVar = new an("c10048");
                                anVar.bS("fid", f.this.fNY.getForumId());
                                anVar.bS("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(anVar);
                            }
                        }
                    }
                } else if (id == R.id.tv_sign) {
                    if (!f.this.fNY.bkq()) {
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            f.this.fNY.showToast(R.string.neterror);
                        } else if (bc.checkUpIsLogin(f.this.mContext.getPageActivity())) {
                            if (!f.this.bqG()) {
                                f.this.bqJ();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(f.this.fNY.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.toInt(f.this.fNY.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                            }
                        }
                    }
                } else if (id == R.id.frs_header_games) {
                    if (bc.checkUpIsLogin(f.this.mContext.getPageActivity()) && bkp != null && bkp.getGameUrl() != null) {
                        ba.amQ().a((TbPageContext) f.this.getPageContext(), new String[]{bkp.getGameUrl()}, true);
                    }
                } else if (id == R.id.frs_bawu_center) {
                    if (bkp != null && bkp.getUserData() != null && bkp.getUserData().isBawu()) {
                        String bawuCenterUrl = bkp.getBawuCenterUrl();
                        if (!aq.isEmpty(bawuCenterUrl)) {
                            com.baidu.tbadk.browser.a.startWebActivity(f.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            if (bkp.getForum() != null) {
                                TiebaStatic.log(new an("c10502").bS("fid", bkp.getForum().getId()).bS("uid", bkp.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == R.id.level_container && !f.this.fNY.bkq() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page") || f.this.mPageType.equals("brand_page")) && f.this.fTi != null) {
                        f.this.fTi.i(view, false);
                    }
                }
            }
        };
        this.fNY = frsFragment;
        this.fTq = aVar;
        this.fxQ = frsHeaderViewContainer;
        this.fTt = BdUniqueId.gen();
        this.fTs = new com.baidu.tieba.f.a();
        this.fTs.a(new a.InterfaceC0405a() { // from class: com.baidu.tieba.frs.vc.f.6
            @Override // com.baidu.tieba.f.a.InterfaceC0405a
            public void v(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0405a
            public void w(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0405a
            public void x(int i, int i2) {
            }
        });
    }

    public void Q(Bundle bundle) {
        this.fNY.registerListener(this.fTw);
        aJV();
        bqK();
        this.fTn = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void aGH() {
        if (this.fTi != null) {
            this.fTi.onDestory();
        }
        if (this.csF != null) {
            this.csF.cnF();
        }
        if (this.fTl != null) {
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.fTl);
        }
    }

    public void anG() {
        if (this.fTi != null) {
            this.fTi.onStop();
        }
        if (this.fxQ != null) {
            this.fxQ.removeCallbacks(this.dBG);
        }
    }

    public void jJ(boolean z) {
        if (this.fTi != null) {
            this.fTi.jJ(z);
        }
    }

    public boolean rR(int i) {
        this.mSkinType = i;
        if (this.fTi != null) {
            this.fTi.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void kF(boolean z) {
        if (z) {
            if (this.fTi != null) {
                this.fxQ.removeHeaderView(this.fTi.brz());
                this.fTp = false;
            }
        } else if (this.fTi != null && this.fTi.brz() != null && !this.fTp) {
            this.fxQ.addHeaderView(this.fTi.brz(), this.fxQ.getHeaderViewsCount());
            this.fTp = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        this.mPageType = str;
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            t(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean bqx() {
        return true;
    }

    private void t(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.fTk, str);
        this.fTm = i2;
        this.fTk = str;
        bqz();
        if (this.fTi == null || z) {
            this.fTi = this.fTq.a(str, this.fNY, i);
            this.fTi.changeSkinType(this.mSkinType);
            this.fTi.w(this.fxy);
        }
        this.fxQ.addHeaderView(this.fTi.getView());
        wA(this.mPageType);
        bqB();
    }

    public void bqy() {
        if (!this.fTp && this.fTi != null) {
            this.fxQ.addHeaderView(this.fTi.brz());
            this.fTp = true;
        }
    }

    private void bqz() {
        if (this.fTi != null) {
            this.fxQ.removeHeaderView(this.fTi.getView());
            this.fxQ.removeHeaderView(this.fTi.brz());
            bqA();
        }
        this.fTp = false;
    }

    private void bqA() {
        if (this.fTu != null && this.fNY != null && this.fNY.aof() != null) {
            this.fNY.aof().removeHeaderView(this.fTu.bqO());
        }
    }

    private void wA(String str) {
        RelativeLayout bqO;
        if (this.fTu != null && this.fNY != null && this.fNY.aof() != null && (bqO = this.fTu.bqO()) != null) {
            if ("brand_page".equals(str)) {
                this.fNY.aof().removeHeaderView(bqO);
                return;
            }
            this.fNY.aof().removeHeaderView(bqO);
            this.fNY.aof().addHeaderView(bqO, 0);
        }
    }

    private void bqB() {
        if (this.fTl == null) {
            this.fTl = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.fNY.bjP() == null || !f.this.fNY.bjP().bkq()) && f.this.fxQ.isShown() && f.this.fNY.isPrimary() && !f.this.fTn && f.this.fTm == 1 && f.this.fNY.bjP() != null && f.this.fNY.bjP().bkL() != null && !f.this.fNY.bjP().bkL().bqu() && f.this.fNY.bkv()) {
                            if (("frs_page".equals(f.this.fTk) || "normal_page".equals(f.this.fTk) || "brand_page".equals(f.this.mPageType) || "book_page".equals(f.this.fTk)) && f.this.fTi != null && f.this.fTi.bry()) {
                                TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.bmT();
                                f.this.fNY.fvb = true;
                                f.this.fTn = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.fTl, 4000L);
    }

    public void i(FrsViewData frsViewData) {
        if (frsViewData != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                b(frsViewData.getForum(), frsViewData);
                if ("brand_page".equals(this.mPageType)) {
                    this.fTi.bmI();
                }
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float b = b(forumData);
            if (this.fTi != null) {
                this.fTi.a(forumData, frsViewData);
                this.fTi.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                if (forumData.getSignData() != null) {
                    this.fTi.so(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.fTi.kN(false);
                        return;
                    }
                    this.fTi.kN(true);
                    this.fTi.so(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.fTj = forumData.getLevelupScore();
        this.frU = forumData.getCurScore();
        if (this.fTj > 0) {
            return this.frU / this.fTj;
        }
        return 0.0f;
    }

    public void rS(int i) {
        if (i > 1) {
            if (this.fTi != null) {
                this.fTi.kO(false);
            }
        } else if (this.fTi != null) {
            this.fTi.kO(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void bqC() {
        if (this.fxQ != null) {
            this.fxQ.removeCallbacks(this.dBG);
            this.fxQ.postDelayed(this.dBG, 100L);
        }
    }

    public void e(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            bqD();
        }
    }

    public void setIsMem(int i) {
        if (this.fTi != null) {
            this.fTi.setMemberType(i);
        }
    }

    public void bmT() {
        if (("normal_page".equals(this.fTk) || "frs_page".equals(this.fTk) || "book_page".equals(this.fTk) || "brand_page".equals(this.mPageType)) && this.fTi != null) {
            this.fTi.bmT();
        }
    }

    public void bqD() {
        if (this.fTi != null) {
            this.fTi.bmV();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                a(1, frsViewData.getForum(), frsViewData, z);
            }
        }
    }

    public void bqE() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            rU(0);
        }
    }

    public void rT(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            rU(i);
        }
    }

    public void rU(int i) {
        if (this.fTi != null) {
            this.fTi.sn(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.fTi != null) {
            this.fTi.a(forumData, frsViewData);
            if (forumData != null) {
                this.fTi.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.fTi.kN(false);
                }
            }
        }
    }

    public boolean bqF() {
        if (("normal_page".equals(this.fTk) || "frs_page".equals(this.fTk) || "book_page".equals(this.fTk) || "brand_page".equals(this.mPageType)) && this.fTi != null) {
            return this.fTi.brx();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.fTj - this.frU) {
                z = true;
                this.fTj = signData.levelup_score;
            }
            this.frU = i + this.frU;
            if (this.frU > this.fTj) {
                this.frU = this.fTj;
            }
            if (this.fTj != 0) {
                f = this.frU / this.fTj;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.d(z, f);
        }
    }

    public void rV(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.fTi != null) {
            this.fTi.so(i);
        }
    }

    public void j(FrsViewData frsViewData) {
        SignData signData;
        ForumData forum;
        if (frsViewData != null && frsViewData.getForum() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.fTi != null && (signData = frsViewData.getForum().getSignData()) != null && (forum = frsViewData.getForum()) != null) {
                this.fTi.a(forum, frsViewData);
                this.fTi.so(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.fTi.brx()) {
                    a(this.fTi, signData);
                    forum.setCurScore(this.frU);
                    forum.setLevelupScore(this.fTj);
                    this.fTi.a(forum, frsViewData);
                }
            }
        }
    }

    public boolean bqG() {
        if (("normal_page".equals(this.fTk) || "frs_page".equals(this.fTk) || "book_page".equals(this.fTk) || "brand_page".equals(this.mPageType)) && this.fTi != null) {
            return this.fTi.bqG();
        }
        return false;
    }

    public boolean bqH() {
        if (("normal_page".equals(this.fTk) || "frs_page".equals(this.fTk) || "book_page".equals(this.fTk) || "brand_page".equals(this.mPageType)) && this.fTi != null) {
            return this.fTi.bqH();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void kG(boolean z) {
        if (this.fNY != null) {
            FrsViewData bkp = this.fNY.bkp();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.fNY.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11002)));
            } else if (bkp != null && bkp.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.fNY.getFrom())) {
                    TiebaStatic.log(new an("c10356").bS("fid", bkp.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.fNY.getFrom())) {
                    TiebaStatic.log(new an("c10590").O("obj_type", 2).bS("fid", bkp.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.fNY.getFrom())) {
                    TiebaStatic.log(new an("c10587").O("obj_type", 2).bS("fid", bkp.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.fNY.getFrom())) {
                    TiebaStatic.log(new an("c10578").O("obj_type", 2).bS("fid", bkp.getForum().getId()));
                }
                this.csF.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.fNY.getFrom())) {
                    TiebaStatic.eventStat(this.fNY.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.fNY.getFrom())) {
                    TiebaStatic.log(new an("c10359").bS("fid", bkp.getForum().getId()));
                }
                this.csF.ag(bkp.getForum().getName(), bkp.getForum().getId(), "FRS");
                this.fTr = z;
            }
        }
    }

    public void bqI() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.fNY.bkp() != null && this.fNY.bkp().getForum() != null && this.fNY.bkp().getForum().getName() != null) {
            str = this.fNY.bkp().getForum().getName();
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
                FrsViewData bkp = f.this.fNY.bkp();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.fNY.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(f.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_UNLIKE)));
                } else if (bkp != null && bkp.getForum() != null) {
                    f.this.fTo.I(bkp.getForum().getName(), com.baidu.adp.lib.g.b.toLong(bkp.getForum().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).akO();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void bqJ() {
        FrsViewData bkp = this.fNY.bkp();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.fNY.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_SIGN)));
        } else if (bkp != null && bkp.getForum() != null) {
            FrsActivityStatic.forumName = bkp.getForum().getName() == null ? "" : bkp.getForum().getName();
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, bkp.getForum());
            customMessage.setTag(this.fTt);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wB(String str) {
        if (this.fNY.bjK() != null && this.fNY.bjK().bpg() != null) {
            com.baidu.tieba.tbadkCore.d.cnl().av(com.baidu.tieba.tbadkCore.d.cnl().e("1~" + str, this.fNY.bjK().bpg().getSortType(), this.fNY.bjK().bpg().getIsGood(), this.fNY.bjK().bpg().getCategoryId()), false);
        }
    }

    private void aJV() {
        this.csF = new LikeModel(this.fNY.getPageContext());
        this.csF.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                t tVar;
                boolean z = false;
                FrsViewData bkp = f.this.fNY.bkp();
                if (bkp != null && bkp.getForum() != null && obj != null) {
                    if (AntiHelper.aH(f.this.csF.getErrorCode(), f.this.csF.getErrorString())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.csF.getBlockPopInfoData(), f.this.fTv) != null) {
                            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).O("obj_locate", at.a.LOCATE_LIKE_BAR));
                            return;
                        }
                        return;
                    }
                    String name = bkp.getForum().getName();
                    String id = bkp.getForum().getId();
                    if (!(obj instanceof t)) {
                        tVar = null;
                    } else {
                        tVar = (t) obj;
                    }
                    boolean z2 = tVar != null && f.this.csF.getErrorCode() == 0;
                    if (tVar.getErrorCode() == 3250013) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), tVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake_n_svg, 3000, true).akT();
                    } else {
                        z = z2;
                    }
                    if (tVar == null || !z) {
                        if (f.this.csF.getErrorCode() == 22) {
                            f.this.fNY.showToast(f.this.getPageContext().getString(R.string.had_liked_forum));
                        } else {
                            f.this.fNY.showToast(f.this.csF.getErrorString());
                        }
                    } else {
                        f.this.wB(name);
                        tVar.setLike(1);
                        bkp.updateLikeData(tVar);
                        bkp.setLikeFeedForumDataList(tVar.cnx());
                        f.this.a(bkp, f.this.fTr);
                        f.this.fTr = true;
                        f.this.fNY.showToast(f.this.getPageContext().getResources().getString(R.string.attention_success));
                        f.this.l(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, tVar));
                    }
                    f.this.fNY.an(Boolean.valueOf(z));
                }
            }
        });
    }

    private void bqK() {
        this.fTo = new y();
        this.fTo.setFrom("from_frs");
        this.fTo.a(new y.a() { // from class: com.baidu.tieba.frs.vc.f.3
            @Override // com.baidu.tieba.tbadkCore.y.a
            public void A(String str, long j) {
                FrsViewData bkp = f.this.fNY.bkp();
                if (bkp != null && bkp.getForum() != null) {
                    String name = bkp.getForum().getName();
                    String id = bkp.getForum().getId();
                    if (j == com.baidu.adp.lib.g.b.toLong(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.wB(str);
                        bkp.getForum().setLike(0);
                        f.this.rT(0);
                        f.this.fNY.am(true);
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
        com.baidu.tieba.im.settingcache.d.bEf().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void K(int i, int i2, int i3) {
        FrsViewData bkp;
        if (i > 0 && i2 > 0 && (bkp = this.fNY.bkp()) != null && bkp.getForum() != null && bkp.getSignData() != null) {
            ForumData forum = bkp.getForum();
            SignData signData = bkp.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            bkp.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            int i4 = -1;
            if (bqH()) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void bmQ() {
        if (this.fTi != null) {
            this.fTi.bmQ();
        }
    }

    public static boolean k(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().agY(), true) || frsViewData.getBookInfo().agY().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean l(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().cny() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || v.isEmpty(frsViewData.getActivityHeadData().agW())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().ahf(), true)))) ? false : true;
        }
        return false;
    }

    public void rW(int i) {
        View findViewById;
        if (this.fTi != null && this.fTi.brz() != null && (findViewById = this.fTi.brz().findViewById(R.id.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void C(MotionEvent motionEvent) {
        if (this.fTs != null) {
            this.fTs.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.fTu = frsTabViewController;
    }
}
