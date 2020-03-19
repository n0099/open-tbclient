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
    private TBSpecificationBtn gNt;
    private BdUniqueId gNv;
    private int gNw;
    private boolean gNx;
    private int glH;
    private FrsFragment gqW;
    private CustomMessageListener gNy = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.vc.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData bEz;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            int i;
            if (g.this.gqW != null && (customResponsedMessage instanceof SignMessage) && (bEz = g.this.gqW.bEz()) != null && bEz.getForum() != null && (name = (forum = bEz.getForum()).getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == g.this.gNv) {
                TiebaStatic.eventStat(g.this.gqW.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
                String name2 = forum.getName();
                SignMessage signMessage = (SignMessage) customResponsedMessage;
                if (!AntiHelper.bb(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                    h bDV = g.this.gqW.bDV();
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(forum.getId())) {
                            if (bDV != null) {
                                bDV.BR(name2);
                            }
                            bEz.updateSignData(signData2);
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
                        if (bDV != null ? bDV.bLc() : false) {
                            i = forum.getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (g.this.bKO() && signData.contDays > 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.aLL().us(signData.userInfoJson);
                            TbPageContext<?> tbPageContext = g.this.gqW.getTbPageContext();
                            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(g.this.gqW.getActivity(), "", g.this.gNu, false, true, true);
                            tbWebViewActivityConfig.setPageTranslucent("open_full_screen_opacity_web_page");
                            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                            return;
                        }
                        com.baidu.tbadk.coreExtra.messageCenter.f.aLL().us(null);
                        if (bDV == null || bDV.bLa()) {
                            g.this.gqW.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                        } else {
                            g.this.gqW.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                        }
                        com.baidu.tieba.frs.m bDY = g.this.gqW.bDY();
                        if (bDY != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.aLL().a(g.this.gqW.getTbPageContext(), bDY.bsL());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002 && bDV != null) {
                        bDV.ut(1);
                    }
                    g.this.gqW.showToast(signMessage.mSignErrorString);
                    return;
                }
                if (signMessage.signData != null) {
                    AntiHelper.a(g.this.gqW.getActivity(), signMessage.signData.blockPopInfoData, g.this.mInjectListener);
                } else {
                    AntiHelper.bn(g.this.gqW.getActivity(), signMessage.mSignErrorString);
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
    private CustomMessageListener gNz = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.vc.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData bEz;
            int i;
            if (g.this.gqW != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (bEz = g.this.gqW.bEz()) != null && bEz.getForum() != null) {
                ForumData forum = bEz.getForum();
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = forum.getUser_level();
                if (signData.forumId != null && signData.forumId.equals(forum.getId())) {
                    bEz.updateSignData(signData);
                    h bDV = g.this.gqW.bDV();
                    boolean z = false;
                    if (bDV != null) {
                        bDV.j(bEz);
                        z = bDV.bLc();
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
    private String gNu = TbSingleton.getInstance().getWalletSignLink();

    public g(FrsFragment frsFragment, BdUniqueId bdUniqueId) {
        this.gqW = frsFragment;
        this.gNv = bdUniqueId;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.gNt = tBSpecificationBtn;
    }

    public void registerListener() {
        if (this.gqW != null) {
            this.gqW.registerListener(this.gNy);
            this.gqW.registerListener(this.gNz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bKO() {
        return !TextUtils.isEmpty(this.gNu);
    }

    public void uo(int i) {
        if (this.gNt != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.gNt.getLayoutParams().width = -2;
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
            this.gNt.setPadding(dimenPixelSize2, 0, dimenPixelSize2, 0);
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.gNt.getStyleConfig();
            styleConfig.lr(dimenPixelSize);
            if (i > 0) {
                this.gNt.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.miss_sign_days), Integer.valueOf(i)));
                styleConfig.k(R.drawable.icon_pure_frs_sign_add16_svg, 0, true);
            } else {
                this.gNt.setText(TbadkCoreApplication.getInst().getString(R.string.signed));
                styleConfig.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
            }
            this.gNt.setTextSize(R.dimen.tbds34);
            this.gNt.aHS();
            this.gNt.setVisibility(0);
        }
    }

    public void bHc() {
        if (bKO()) {
            bKQ();
        } else {
            bKP();
        }
    }

    private void bKP() {
        if (this.gNt != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.gNt.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
            this.gNt.setPadding(0, 0, 0, 0);
            this.gNt.setTextSize(R.dimen.tbds34);
            this.gNt.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.gNt.getStyleConfig();
            styleConfig.lr(dimenPixelSize);
            styleConfig.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
            this.gNt.aHS();
        }
    }

    private void bKQ() {
        if (this.gNt != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
            this.gNt.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds187);
            this.gNt.setPadding(0, 0, 0, 0);
            this.gNt.setTextSize(R.dimen.tbds34);
            this.gNt.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.gNt.getStyleConfig();
            styleConfig.lr(dimenPixelSize);
            styleConfig.k(R.drawable.icon_frs_wallet_n, 0, false);
            this.gNt.aHS();
        }
    }

    public void ml(boolean z) {
        if (z && !this.gNx) {
            an.tv("c13560").X("obj_type", 1).aGD();
            this.gNx = true;
        }
    }

    public float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.gNw = forumData.getLevelupScore();
        this.glH = forumData.getCurScore();
        if (this.gNw > 0) {
            return this.glH / this.gNw;
        }
        return 0.0f;
    }

    public void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.gNw - this.glH) {
                z = true;
                this.gNw = signData.levelup_score;
            }
            this.glH = i + this.glH;
            if (this.glH > this.gNw) {
                this.glH = this.gNw;
            }
            if (this.gNw != 0) {
                f = this.glH / this.gNw;
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
            bVar.uN(signData.is_signed);
            if (signData.sign_bonus_point > 0 && bVar.bLS()) {
                a(bVar, signData);
                forum.setCurScore(this.glH);
                forum.setLevelupScore(this.gNw);
                bVar.a(forum, frsViewData);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void bKR() {
        if (this.gqW != null) {
            FrsViewData bEz = this.gqW.bEz();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.gqW.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.gqW.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_SIGN)));
            } else if (bEz != null && bEz.getForum() != null) {
                ForumData forum = bEz.getForum();
                forum.setFromPage("frs");
                FrsActivityStatic.forumName = forum.getName() == null ? "" : forum.getName();
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, forum);
                customMessage.setTag(this.gNv);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    public void L(int i, int i2, int i3) {
        FrsViewData bEz;
        if (this.gqW != null && i > 0 && i2 > 0 && (bEz = this.gqW.bEz()) != null && bEz.getForum() != null && bEz.getSignData() != null) {
            ForumData forum = bEz.getForum();
            SignData signData = bEz.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            bEz.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            h bDV = this.gqW.bDV();
            boolean bLc = bDV != null ? bDV.bLc() : false;
            int i4 = -1;
            if (bLc) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }
}
