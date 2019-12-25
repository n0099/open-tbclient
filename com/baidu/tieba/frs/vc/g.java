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
/* loaded from: classes6.dex */
public class g {
    private TBSpecificationBtn gGM;
    private BdUniqueId gGO;
    private int gGP;
    private boolean gGQ;
    private int gfz;
    private FrsFragment gkN;
    private CustomMessageListener gGR = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.vc.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData bBI;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            int i;
            if (g.this.gkN != null && (customResponsedMessage instanceof SignMessage) && (bBI = g.this.gkN.bBI()) != null && bBI.getForum() != null && (name = (forum = bBI.getForum()).getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == g.this.gGO) {
                TiebaStatic.eventStat(g.this.gkN.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
                String name2 = forum.getName();
                SignMessage signMessage = (SignMessage) customResponsedMessage;
                if (!AntiHelper.aW(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                    h bBf = g.this.gkN.bBf();
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(forum.getId())) {
                            if (bBf != null) {
                                bBf.Bq(name2);
                            }
                            bBI.updateSignData(signData2);
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
                        if (bBf != null ? bBf.bIj() : false) {
                            i = forum.getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (g.this.bHU() && signData.contDays > 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.aIR().tV(signData.userInfoJson);
                            TbPageContext<?> tbPageContext = g.this.gkN.getTbPageContext();
                            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(g.this.gkN.getActivity(), "", g.this.gGN, false, true, true);
                            tbWebViewActivityConfig.setPageTranslucent("open_full_screen_opacity_web_page");
                            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                            return;
                        }
                        com.baidu.tbadk.coreExtra.messageCenter.f.aIR().tV(null);
                        if (bBf == null || bBf.bIh()) {
                            g.this.gkN.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                        } else {
                            g.this.gkN.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                        }
                        com.baidu.tieba.frs.l bBi = g.this.gkN.bBi();
                        if (bBi != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.aIR().a(g.this.gkN.getTbPageContext(), bBi.bpX());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002 && bBf != null) {
                        bBf.uc(1);
                    }
                    g.this.gkN.showToast(signMessage.mSignErrorString);
                    return;
                }
                if (signMessage.signData != null) {
                    AntiHelper.a(g.this.gkN.getActivity(), signMessage.signData.blockPopInfoData, g.this.mInjectListener);
                } else {
                    AntiHelper.bj(g.this.gkN.getActivity(), signMessage.mSignErrorString);
                }
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).Z("obj_locate", at.a.LOCATE_SIGN));
            }
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.g.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).Z("obj_locate", at.a.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).Z("obj_locate", at.a.LOCATE_SIGN));
        }
    };
    private CustomMessageListener gGS = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.vc.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData bBI;
            int i;
            if (g.this.gkN != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (bBI = g.this.gkN.bBI()) != null && bBI.getForum() != null) {
                ForumData forum = bBI.getForum();
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = forum.getUser_level();
                if (signData.forumId != null && signData.forumId.equals(forum.getId())) {
                    bBI.updateSignData(signData);
                    h bBf = g.this.gkN.bBf();
                    boolean z = false;
                    if (bBf != null) {
                        bBf.j(bBI);
                        z = bBf.bIj();
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
    private String gGN = TbSingleton.getInstance().getWalletSignLink();

    public g(FrsFragment frsFragment, BdUniqueId bdUniqueId) {
        this.gkN = frsFragment;
        this.gGO = bdUniqueId;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.gGM = tBSpecificationBtn;
    }

    public void registerListener() {
        if (this.gkN != null) {
            this.gkN.registerListener(this.gGR);
            this.gkN.registerListener(this.gGS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bHU() {
        return !TextUtils.isEmpty(this.gGN);
    }

    public void tX(int i) {
        if (this.gGM != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.gGM.getLayoutParams().width = -2;
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
            this.gGM.setPadding(dimenPixelSize2, 0, dimenPixelSize2, 0);
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.gGM.getStyleConfig();
            styleConfig.la(dimenPixelSize);
            if (i > 0) {
                this.gGM.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.miss_sign_days), Integer.valueOf(i)));
                styleConfig.j(R.drawable.icon_pure_frs_sign_add16_svg, 0, true);
            } else {
                this.gGM.setText(TbadkCoreApplication.getInst().getString(R.string.signed));
                styleConfig.j(R.drawable.icon_pure_frs_sign16_svg, 0, true);
            }
            this.gGM.setTextSize(R.dimen.tbds34);
            this.gGM.aFd();
            this.gGM.setVisibility(0);
        }
    }

    public void bEg() {
        if (bHU()) {
            bHW();
        } else {
            bHV();
        }
    }

    private void bHV() {
        if (this.gGM != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.gGM.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
            this.gGM.setPadding(0, 0, 0, 0);
            this.gGM.setTextSize(R.dimen.tbds34);
            this.gGM.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.gGM.getStyleConfig();
            styleConfig.la(dimenPixelSize);
            styleConfig.j(R.drawable.icon_pure_frs_sign16_svg, 0, true);
            this.gGM.aFd();
        }
    }

    private void bHW() {
        if (this.gGM != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
            this.gGM.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds187);
            this.gGM.setPadding(0, 0, 0, 0);
            this.gGM.setTextSize(R.dimen.tbds34);
            this.gGM.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.gGM.getStyleConfig();
            styleConfig.la(dimenPixelSize);
            styleConfig.j(R.drawable.icon_frs_wallet_n, 0, false);
            this.gGM.aFd();
        }
    }

    public void lS(boolean z) {
        if (z && !this.gGQ) {
            an.tb("c13560").Z("obj_type", 1).aDT();
            this.gGQ = true;
        }
    }

    public float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.gGP = forumData.getLevelupScore();
        this.gfz = forumData.getCurScore();
        if (this.gGP > 0) {
            return this.gfz / this.gGP;
        }
        return 0.0f;
    }

    public void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.gGP - this.gfz) {
                z = true;
                this.gGP = signData.levelup_score;
            }
            this.gfz = i + this.gfz;
            if (this.gfz > this.gGP) {
                this.gfz = this.gGP;
            }
            if (this.gGP != 0) {
                f = this.gfz / this.gGP;
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
            bVar.uv(signData.is_signed);
            if (signData.sign_bonus_point > 0 && bVar.bIX()) {
                a(bVar, signData);
                forum.setCurScore(this.gfz);
                forum.setLevelupScore(this.gGP);
                bVar.a(forum, frsViewData);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void bHX() {
        if (this.gkN != null) {
            FrsViewData bBI = this.gkN.bBI();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.gkN.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.gkN.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_SIGN)));
            } else if (bBI != null && bBI.getForum() != null) {
                ForumData forum = bBI.getForum();
                forum.setFromPage("frs");
                FrsActivityStatic.forumName = forum.getName() == null ? "" : forum.getName();
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, forum);
                customMessage.setTag(this.gGO);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    public void K(int i, int i2, int i3) {
        FrsViewData bBI;
        if (this.gkN != null && i > 0 && i2 > 0 && (bBI = this.gkN.bBI()) != null && bBI.getForum() != null && bBI.getSignData() != null) {
            ForumData forum = bBI.getForum();
            SignData signData = bBI.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            bBI.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            h bBf = this.gkN.bBf();
            boolean bIj = bBf != null ? bBf.bIj() : false;
            int i4 = -1;
            if (bIj) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }
}
