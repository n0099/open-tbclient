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
    private TBSpecificationBtn gMc;
    private BdUniqueId gMe;
    private int gMf;
    private boolean gMg;
    private int gkM;
    private FrsFragment gpZ;
    private CustomMessageListener gMh = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.vc.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData bEp;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            int i;
            if (g.this.gpZ != null && (customResponsedMessage instanceof SignMessage) && (bEp = g.this.gpZ.bEp()) != null && bEp.getForum() != null && (name = (forum = bEp.getForum()).getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == g.this.gMe) {
                TiebaStatic.eventStat(g.this.gpZ.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
                String name2 = forum.getName();
                SignMessage signMessage = (SignMessage) customResponsedMessage;
                if (!AntiHelper.bb(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                    h bDM = g.this.gpZ.bDM();
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(forum.getId())) {
                            if (bDM != null) {
                                bDM.BQ(name2);
                            }
                            bEp.updateSignData(signData2);
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
                        if (bDM != null ? bDM.bKO() : false) {
                            i = forum.getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (g.this.bKA() && signData.contDays > 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.aLG().ur(signData.userInfoJson);
                            TbPageContext<?> tbPageContext = g.this.gpZ.getTbPageContext();
                            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(g.this.gpZ.getActivity(), "", g.this.gMd, false, true, true);
                            tbWebViewActivityConfig.setPageTranslucent("open_full_screen_opacity_web_page");
                            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                            return;
                        }
                        com.baidu.tbadk.coreExtra.messageCenter.f.aLG().ur(null);
                        if (bDM == null || bDM.bKM()) {
                            g.this.gpZ.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                        } else {
                            g.this.gpZ.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                        }
                        com.baidu.tieba.frs.l bDP = g.this.gpZ.bDP();
                        if (bDP != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.aLG().a(g.this.gpZ.getTbPageContext(), bDP.bsE());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002 && bDM != null) {
                        bDM.un(1);
                    }
                    g.this.gpZ.showToast(signMessage.mSignErrorString);
                    return;
                }
                if (signMessage.signData != null) {
                    AntiHelper.a(g.this.gpZ.getActivity(), signMessage.signData.blockPopInfoData, g.this.mInjectListener);
                } else {
                    AntiHelper.bn(g.this.gpZ.getActivity(), signMessage.mSignErrorString);
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
    private CustomMessageListener gMi = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.vc.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData bEp;
            int i;
            if (g.this.gpZ != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (bEp = g.this.gpZ.bEp()) != null && bEp.getForum() != null) {
                ForumData forum = bEp.getForum();
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = forum.getUser_level();
                if (signData.forumId != null && signData.forumId.equals(forum.getId())) {
                    bEp.updateSignData(signData);
                    h bDM = g.this.gpZ.bDM();
                    boolean z = false;
                    if (bDM != null) {
                        bDM.j(bEp);
                        z = bDM.bKO();
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
    private String gMd = TbSingleton.getInstance().getWalletSignLink();

    public g(FrsFragment frsFragment, BdUniqueId bdUniqueId) {
        this.gpZ = frsFragment;
        this.gMe = bdUniqueId;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.gMc = tBSpecificationBtn;
    }

    public void registerListener() {
        if (this.gpZ != null) {
            this.gpZ.registerListener(this.gMh);
            this.gpZ.registerListener(this.gMi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bKA() {
        return !TextUtils.isEmpty(this.gMd);
    }

    public void ui(int i) {
        if (this.gMc != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.gMc.getLayoutParams().width = -2;
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
            this.gMc.setPadding(dimenPixelSize2, 0, dimenPixelSize2, 0);
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.gMc.getStyleConfig();
            styleConfig.lr(dimenPixelSize);
            if (i > 0) {
                this.gMc.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.miss_sign_days), Integer.valueOf(i)));
                styleConfig.k(R.drawable.icon_pure_frs_sign_add16_svg, 0, true);
            } else {
                this.gMc.setText(TbadkCoreApplication.getInst().getString(R.string.signed));
                styleConfig.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
            }
            this.gMc.setTextSize(R.dimen.tbds34);
            this.gMc.aHN();
            this.gMc.setVisibility(0);
        }
    }

    public void bGM() {
        if (bKA()) {
            bKC();
        } else {
            bKB();
        }
    }

    private void bKB() {
        if (this.gMc != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.gMc.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
            this.gMc.setPadding(0, 0, 0, 0);
            this.gMc.setTextSize(R.dimen.tbds34);
            this.gMc.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.gMc.getStyleConfig();
            styleConfig.lr(dimenPixelSize);
            styleConfig.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
            this.gMc.aHN();
        }
    }

    private void bKC() {
        if (this.gMc != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
            this.gMc.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds187);
            this.gMc.setPadding(0, 0, 0, 0);
            this.gMc.setTextSize(R.dimen.tbds34);
            this.gMc.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.gMc.getStyleConfig();
            styleConfig.lr(dimenPixelSize);
            styleConfig.k(R.drawable.icon_frs_wallet_n, 0, false);
            this.gMc.aHN();
        }
    }

    public void mf(boolean z) {
        if (z && !this.gMg) {
            an.tv("c13560").X("obj_type", 1).aGz();
            this.gMg = true;
        }
    }

    public float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.gMf = forumData.getLevelupScore();
        this.gkM = forumData.getCurScore();
        if (this.gMf > 0) {
            return this.gkM / this.gMf;
        }
        return 0.0f;
    }

    public void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.gMf - this.gkM) {
                z = true;
                this.gMf = signData.levelup_score;
            }
            this.gkM = i + this.gkM;
            if (this.gkM > this.gMf) {
                this.gkM = this.gMf;
            }
            if (this.gMf != 0) {
                f = this.gkM / this.gMf;
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
            if (signData.sign_bonus_point > 0 && bVar.bLD()) {
                a(bVar, signData);
                forum.setCurScore(this.gkM);
                forum.setLevelupScore(this.gMf);
                bVar.a(forum, frsViewData);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void bKD() {
        if (this.gpZ != null) {
            FrsViewData bEp = this.gpZ.bEp();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.gpZ.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.gpZ.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_SIGN)));
            } else if (bEp != null && bEp.getForum() != null) {
                ForumData forum = bEp.getForum();
                forum.setFromPage("frs");
                FrsActivityStatic.forumName = forum.getName() == null ? "" : forum.getName();
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, forum);
                customMessage.setTag(this.gMe);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    public void L(int i, int i2, int i3) {
        FrsViewData bEp;
        if (this.gpZ != null && i > 0 && i2 > 0 && (bEp = this.gpZ.bEp()) != null && bEp.getForum() != null && bEp.getSignData() != null) {
            ForumData forum = bEp.getForum();
            SignData signData = bEp.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            bEp.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            h bDM = this.gpZ.bDM();
            boolean bKO = bDM != null ? bDM.bKO() : false;
            int i4 = -1;
            if (bKO) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }
}
