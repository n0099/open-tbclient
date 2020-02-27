package com.baidu.tieba.frs.vc;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.message.SignMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes9.dex */
public class g {
    private TBSpecificationBtn gMa;
    private BdUniqueId gMc;
    private int gMd;
    private boolean gMe;
    private int gkK;
    private FrsFragment gpX;
    private CustomMessageListener gMf = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.vc.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData bEn;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            int i;
            if (g.this.gpX != null && (customResponsedMessage instanceof SignMessage) && (bEn = g.this.gpX.bEn()) != null && bEn.getForum() != null && (name = (forum = bEn.getForum()).getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == g.this.gMc) {
                TiebaStatic.eventStat(g.this.gpX.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
                String name2 = forum.getName();
                SignMessage signMessage = (SignMessage) customResponsedMessage;
                if (!AntiHelper.bb(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                    h bDK = g.this.gpX.bDK();
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(forum.getId())) {
                            if (bDK != null) {
                                bDK.BQ(name2);
                            }
                            bEn.updateSignData(signData2);
                            signData2.forumId = forum.getId();
                            signData2.forumName = forum.getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = forum.getUser_level();
                        if (bDK != null ? bDK.bKM() : false) {
                            i = forum.getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (g.this.bKy() && signData.contDays > 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.aLE().ur(signData.userInfoJson);
                            TbPageContext<?> tbPageContext = g.this.gpX.getTbPageContext();
                            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(g.this.gpX.getActivity(), "", g.this.gMb, false, true, true);
                            tbWebViewActivityConfig.setPageTranslucent("open_full_screen_opacity_web_page");
                            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                            return;
                        }
                        com.baidu.tbadk.coreExtra.messageCenter.f.aLE().ur(null);
                        if (bDK == null || bDK.bKK()) {
                            g.this.gpX.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                        } else {
                            g.this.gpX.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                        }
                        com.baidu.tieba.frs.l bDN = g.this.gpX.bDN();
                        if (bDN != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.aLE().a(g.this.gpX.getTbPageContext(), bDN.bsC());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002 && bDK != null) {
                        bDK.un(1);
                    }
                    g.this.gpX.showToast(signMessage.mSignErrorString);
                    return;
                }
                if (signMessage.signData != null) {
                    AntiHelper.a(g.this.gpX.getActivity(), signMessage.signData.blockPopInfoData, g.this.mInjectListener);
                } else {
                    AntiHelper.bn(g.this.gpX.getActivity(), signMessage.mSignErrorString);
                }
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_SIGN));
            }
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.g.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_SIGN));
        }
    };
    private CustomMessageListener gMg = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.vc.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData bEn;
            int i;
            if (g.this.gpX != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (bEn = g.this.gpX.bEn()) != null && bEn.getForum() != null) {
                ForumData forum = bEn.getForum();
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = forum.getUser_level();
                if (signData.forumId != null && signData.forumId.equals(forum.getId())) {
                    bEn.updateSignData(signData);
                    h bDK = g.this.gpX.bDK();
                    boolean z = false;
                    if (bDK != null) {
                        bDK.j(bEn);
                        z = bDK.bKM();
                    }
                    if (z) {
                        i = forum.getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private String gMb = TbSingleton.getInstance().getWalletSignLink();

    public g(FrsFragment frsFragment, BdUniqueId bdUniqueId) {
        this.gpX = frsFragment;
        this.gMc = bdUniqueId;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.gMa = tBSpecificationBtn;
    }

    public void registerListener() {
        if (this.gpX != null) {
            this.gpX.registerListener(this.gMf);
            this.gpX.registerListener(this.gMg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bKy() {
        return !TextUtils.isEmpty(this.gMb);
    }

    public void ui(int i) {
        if (this.gMa != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.gMa.getLayoutParams().width = -2;
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
            this.gMa.setPadding(dimenPixelSize2, 0, dimenPixelSize2, 0);
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.gMa.getStyleConfig();
            styleConfig.lr(dimenPixelSize);
            if (i > 0) {
                this.gMa.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.miss_sign_days), Integer.valueOf(i)));
                styleConfig.k(R.drawable.icon_pure_frs_sign_add16_svg, 0, true);
            } else {
                this.gMa.setText(TbadkCoreApplication.getInst().getString(R.string.signed));
                styleConfig.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
            }
            this.gMa.setTextSize(R.dimen.tbds34);
            this.gMa.aHL();
            this.gMa.setVisibility(0);
        }
    }

    public void bGK() {
        if (bKy()) {
            bKA();
        } else {
            bKz();
        }
    }

    private void bKz() {
        if (this.gMa != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.gMa.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
            this.gMa.setPadding(0, 0, 0, 0);
            this.gMa.setTextSize(R.dimen.tbds34);
            this.gMa.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.gMa.getStyleConfig();
            styleConfig.lr(dimenPixelSize);
            styleConfig.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
            this.gMa.aHL();
        }
    }

    private void bKA() {
        if (this.gMa != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
            this.gMa.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds187);
            this.gMa.setPadding(0, 0, 0, 0);
            this.gMa.setTextSize(R.dimen.tbds34);
            this.gMa.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.gMa.getStyleConfig();
            styleConfig.lr(dimenPixelSize);
            styleConfig.k(R.drawable.icon_frs_wallet_n, 0, false);
            this.gMa.aHL();
        }
    }

    public void mf(boolean z) {
        if (z && !this.gMe) {
            an.tv("c13560").X("obj_type", 1).aGx();
            this.gMe = true;
        }
    }

    public float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.gMd = forumData.getLevelupScore();
        this.gkK = forumData.getCurScore();
        if (this.gMd > 0) {
            return this.gkK / this.gMd;
        }
        return 0.0f;
    }

    public void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.gMd - this.gkK) {
                z = true;
                this.gMd = signData.levelup_score;
            }
            this.gkK = i + this.gkK;
            if (this.gkK > this.gMd) {
                this.gkK = this.gMd;
            }
            if (this.gMd != 0) {
                f = this.gkK / this.gMd;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.c(z, f);
        }
    }

    public void a(com.baidu.tieba.frs.view.b bVar, FrsViewData frsViewData) {
        ForumData forum;
        SignData signData;
        if (frsViewData != null && frsViewData.getForum() != null && bVar != null && (signData = (forum = frsViewData.getForum()).getSignData()) != null) {
            bVar.a(forum, frsViewData);
            bVar.uG(signData.is_signed);
            if (signData.sign_bonus_point > 0 && bVar.bLB()) {
                a(bVar, signData);
                forum.setCurScore(this.gkK);
                forum.setLevelupScore(this.gMd);
                bVar.a(forum, frsViewData);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void bKB() {
        if (this.gpX != null) {
            FrsViewData bEn = this.gpX.bEn();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.gpX.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.gpX.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_SIGN)));
            } else if (bEn != null && bEn.getForum() != null) {
                ForumData forum = bEn.getForum();
                forum.setFromPage("frs");
                FrsActivityStatic.forumName = forum.getName() == null ? "" : forum.getName();
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, forum);
                customMessage.setTag(this.gMc);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    public void L(int i, int i2, int i3) {
        FrsViewData bEn;
        if (this.gpX != null && i > 0 && i2 > 0 && (bEn = this.gpX.bEn()) != null && bEn.getForum() != null && bEn.getSignData() != null) {
            ForumData forum = bEn.getForum();
            SignData signData = bEn.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            bEn.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            h bDK = this.gpX.bDK();
            boolean bKM = bDK != null ? bDK.bKM() : false;
            int i4 = -1;
            if (bKM) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }
}
