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
    private TBSpecificationBtn gMo;
    private BdUniqueId gMq;
    private int gMr;
    private boolean gMs;
    private int gkZ;
    private FrsFragment gqm;
    private CustomMessageListener gMt = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.vc.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData bEq;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            int i;
            if (g.this.gqm != null && (customResponsedMessage instanceof SignMessage) && (bEq = g.this.gqm.bEq()) != null && bEq.getForum() != null && (name = (forum = bEq.getForum()).getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == g.this.gMq) {
                TiebaStatic.eventStat(g.this.gqm.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
                String name2 = forum.getName();
                SignMessage signMessage = (SignMessage) customResponsedMessage;
                if (!AntiHelper.bb(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                    h bDN = g.this.gqm.bDN();
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(forum.getId())) {
                            if (bDN != null) {
                                bDN.BR(name2);
                            }
                            bEq.updateSignData(signData2);
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
                        if (bDN != null ? bDN.bKP() : false) {
                            i = forum.getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (g.this.bKB() && signData.contDays > 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.aLH().us(signData.userInfoJson);
                            TbPageContext<?> tbPageContext = g.this.gqm.getTbPageContext();
                            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(g.this.gqm.getActivity(), "", g.this.gMp, false, true, true);
                            tbWebViewActivityConfig.setPageTranslucent("open_full_screen_opacity_web_page");
                            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                            return;
                        }
                        com.baidu.tbadk.coreExtra.messageCenter.f.aLH().us(null);
                        if (bDN == null || bDN.bKN()) {
                            g.this.gqm.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                        } else {
                            g.this.gqm.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                        }
                        com.baidu.tieba.frs.l bDQ = g.this.gqm.bDQ();
                        if (bDQ != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.aLH().a(g.this.gqm.getTbPageContext(), bDQ.bsF());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002 && bDN != null) {
                        bDN.un(1);
                    }
                    g.this.gqm.showToast(signMessage.mSignErrorString);
                    return;
                }
                if (signMessage.signData != null) {
                    AntiHelper.a(g.this.gqm.getActivity(), signMessage.signData.blockPopInfoData, g.this.mInjectListener);
                } else {
                    AntiHelper.bn(g.this.gqm.getActivity(), signMessage.mSignErrorString);
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
    private CustomMessageListener gMu = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.vc.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData bEq;
            int i;
            if (g.this.gqm != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (bEq = g.this.gqm.bEq()) != null && bEq.getForum() != null) {
                ForumData forum = bEq.getForum();
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = forum.getUser_level();
                if (signData.forumId != null && signData.forumId.equals(forum.getId())) {
                    bEq.updateSignData(signData);
                    h bDN = g.this.gqm.bDN();
                    boolean z = false;
                    if (bDN != null) {
                        bDN.j(bEq);
                        z = bDN.bKP();
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
    private String gMp = TbSingleton.getInstance().getWalletSignLink();

    public g(FrsFragment frsFragment, BdUniqueId bdUniqueId) {
        this.gqm = frsFragment;
        this.gMq = bdUniqueId;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.gMo = tBSpecificationBtn;
    }

    public void registerListener() {
        if (this.gqm != null) {
            this.gqm.registerListener(this.gMt);
            this.gqm.registerListener(this.gMu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bKB() {
        return !TextUtils.isEmpty(this.gMp);
    }

    public void ui(int i) {
        if (this.gMo != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.gMo.getLayoutParams().width = -2;
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
            this.gMo.setPadding(dimenPixelSize2, 0, dimenPixelSize2, 0);
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.gMo.getStyleConfig();
            styleConfig.lr(dimenPixelSize);
            if (i > 0) {
                this.gMo.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.miss_sign_days), Integer.valueOf(i)));
                styleConfig.k(R.drawable.icon_pure_frs_sign_add16_svg, 0, true);
            } else {
                this.gMo.setText(TbadkCoreApplication.getInst().getString(R.string.signed));
                styleConfig.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
            }
            this.gMo.setTextSize(R.dimen.tbds34);
            this.gMo.aHO();
            this.gMo.setVisibility(0);
        }
    }

    public void bGN() {
        if (bKB()) {
            bKD();
        } else {
            bKC();
        }
    }

    private void bKC() {
        if (this.gMo != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.gMo.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
            this.gMo.setPadding(0, 0, 0, 0);
            this.gMo.setTextSize(R.dimen.tbds34);
            this.gMo.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.gMo.getStyleConfig();
            styleConfig.lr(dimenPixelSize);
            styleConfig.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
            this.gMo.aHO();
        }
    }

    private void bKD() {
        if (this.gMo != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
            this.gMo.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds187);
            this.gMo.setPadding(0, 0, 0, 0);
            this.gMo.setTextSize(R.dimen.tbds34);
            this.gMo.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.gMo.getStyleConfig();
            styleConfig.lr(dimenPixelSize);
            styleConfig.k(R.drawable.icon_frs_wallet_n, 0, false);
            this.gMo.aHO();
        }
    }

    public void mf(boolean z) {
        if (z && !this.gMs) {
            an.tv("c13560").X("obj_type", 1).aGz();
            this.gMs = true;
        }
    }

    public float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.gMr = forumData.getLevelupScore();
        this.gkZ = forumData.getCurScore();
        if (this.gMr > 0) {
            return this.gkZ / this.gMr;
        }
        return 0.0f;
    }

    public void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.gMr - this.gkZ) {
                z = true;
                this.gMr = signData.levelup_score;
            }
            this.gkZ = i + this.gkZ;
            if (this.gkZ > this.gMr) {
                this.gkZ = this.gMr;
            }
            if (this.gMr != 0) {
                f = this.gkZ / this.gMr;
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
            if (signData.sign_bonus_point > 0 && bVar.bLE()) {
                a(bVar, signData);
                forum.setCurScore(this.gkZ);
                forum.setLevelupScore(this.gMr);
                bVar.a(forum, frsViewData);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void bKE() {
        if (this.gqm != null) {
            FrsViewData bEq = this.gqm.bEq();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.gqm.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.gqm.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_SIGN)));
            } else if (bEq != null && bEq.getForum() != null) {
                ForumData forum = bEq.getForum();
                forum.setFromPage("frs");
                FrsActivityStatic.forumName = forum.getName() == null ? "" : forum.getName();
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, forum);
                customMessage.setTag(this.gMq);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    public void L(int i, int i2, int i3) {
        FrsViewData bEq;
        if (this.gqm != null && i > 0 && i2 > 0 && (bEq = this.gqm.bEq()) != null && bEq.getForum() != null && bEq.getSignData() != null) {
            ForumData forum = bEq.getForum();
            SignData signData = bEq.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            bEq.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            h bDN = this.gqm.bDN();
            boolean bKP = bDN != null ? bDN.bKP() : false;
            int i4 = -1;
            if (bKP) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }
}
