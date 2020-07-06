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
import com.baidu.tbadk.BdToken.q;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes9.dex */
public class g {
    private FrsFragment hBW;
    private TBSpecificationBtn hZO;
    private BdUniqueId hZQ;
    private int hZR;
    private boolean hZS;
    private int hvY;
    private CustomMessageListener hZT = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.vc.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData bYC;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            int i;
            if (g.this.hBW != null && (customResponsedMessage instanceof SignMessage) && (bYC = g.this.hBW.bYC()) != null && bYC.getForum() != null && (name = (forum = bYC.getForum()).getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == g.this.hZQ) {
                TiebaStatic.eventStat(g.this.hBW.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
                String name2 = forum.getName();
                SignMessage signMessage = (SignMessage) customResponsedMessage;
                if (!AntiHelper.bA(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                    h bXX = g.this.hBW.bXX();
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(forum.getId())) {
                            if (bXX != null) {
                                bXX.FM(name2);
                            }
                            bYC.updateSignData(signData2);
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
                        if (bXX != null ? bXX.cfA() : false) {
                            i = forum.getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (g.this.cfl() && signData.contDays > 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.bcq().xI(signData.userInfoJson);
                            TbPageContext<?> tbPageContext = g.this.hBW.getTbPageContext();
                            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(g.this.hBW.getActivity(), "", g.this.hZP, false, true, true);
                            tbWebViewActivityConfig.setPageTranslucent("open_full_screen_opacity_web_page");
                            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                            q.aMU().aNe().aNj();
                            return;
                        }
                        com.baidu.tbadk.coreExtra.messageCenter.f.bcq().xI(null);
                        if (bXX == null || bXX.cfy()) {
                            g.this.hBW.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                        } else {
                            g.this.hBW.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                        }
                        p bYa = g.this.hBW.bYa();
                        if (bYa != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.bcq().a(g.this.hBW.getTbPageContext(), bYa.bLT());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002 && bXX != null) {
                        bXX.wd(1);
                    }
                    g.this.hBW.showToast(signMessage.mSignErrorString);
                    return;
                }
                if (signMessage.signData != null) {
                    AntiHelper.a(g.this.hBW.getActivity(), signMessage.signData.blockPopInfoData, g.this.mInjectListener);
                } else {
                    AntiHelper.aX(g.this.hBW.getActivity(), signMessage.mSignErrorString);
                }
                TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", av.a.LOCATE_SIGN));
            }
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.g.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", av.a.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", av.a.LOCATE_SIGN));
        }
    };
    private CustomMessageListener hZU = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.vc.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData bYC;
            int i;
            if (g.this.hBW != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (bYC = g.this.hBW.bYC()) != null && bYC.getForum() != null) {
                ForumData forum = bYC.getForum();
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = forum.getUser_level();
                if (signData.forumId != null && signData.forumId.equals(forum.getId())) {
                    bYC.updateSignData(signData);
                    h bXX = g.this.hBW.bXX();
                    boolean z = false;
                    if (bXX != null) {
                        bXX.k(bYC);
                        z = bXX.cfA();
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
    private String hZP = TbSingleton.getInstance().getWalletSignLink();

    public g(FrsFragment frsFragment, BdUniqueId bdUniqueId) {
        this.hBW = frsFragment;
        this.hZQ = bdUniqueId;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.hZO = tBSpecificationBtn;
    }

    public void registerListener() {
        if (this.hBW != null) {
            this.hBW.registerListener(this.hZT);
            this.hBW.registerListener(this.hZU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cfl() {
        return !TextUtils.isEmpty(this.hZP);
    }

    public void vY(int i) {
        if (this.hZO != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.hZO.getLayoutParams().width = -2;
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
            this.hZO.setPadding(dimenPixelSize2, 0, dimenPixelSize2, 0);
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.hZO.getStyleConfig();
            styleConfig.my(dimenPixelSize);
            if (i > 0) {
                this.hZO.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.miss_sign_days), Integer.valueOf(i)));
                styleConfig.k(R.drawable.icon_pure_frs_sign_add16_svg, 0, true);
            } else {
                this.hZO.setText(TbadkCoreApplication.getInst().getString(R.string.signed));
                styleConfig.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
            }
            this.hZO.setTextSize(R.dimen.tbds34);
            this.hZO.aYj();
            this.hZO.setVisibility(0);
        }
    }

    public void cbq() {
        if (cfl()) {
            cfn();
        } else {
            cfm();
        }
    }

    private void cfm() {
        if (this.hZO != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.hZO.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
            this.hZO.setPadding(0, 0, 0, 0);
            this.hZO.setTextSize(R.dimen.tbds34);
            this.hZO.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.hZO.getStyleConfig();
            styleConfig.my(dimenPixelSize);
            styleConfig.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
            this.hZO.aYj();
        }
    }

    private void cfn() {
        if (this.hZO != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
            this.hZO.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds187);
            this.hZO.setPadding(0, 0, 0, 0);
            this.hZO.setTextSize(R.dimen.tbds34);
            this.hZO.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.hZO.getStyleConfig();
            styleConfig.my(dimenPixelSize);
            styleConfig.k(R.drawable.icon_frs_wallet_n, 0, false);
            this.hZO.aYj();
        }
    }

    public void nW(boolean z) {
        if (z && !this.hZS) {
            ao.wH("c13560").ag("obj_type", 1).aWN();
            this.hZS = true;
        }
    }

    public float c(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.hZR = forumData.getLevelupScore();
        this.hvY = forumData.getCurScore();
        if (this.hZR > 0) {
            return this.hvY / this.hZR;
        }
        return 0.0f;
    }

    public void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.hZR - this.hvY) {
                z = true;
                this.hZR = signData.levelup_score;
            }
            this.hvY = i + this.hvY;
            if (this.hvY > this.hZR) {
                this.hvY = this.hZR;
            }
            if (this.hZR != 0) {
                f = this.hvY / this.hZR;
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
            bVar.wz(signData.is_signed);
            if (signData.sign_bonus_point > 0 && bVar.cgx()) {
                a(bVar, signData);
                forum.setCurScore(this.hvY);
                forum.setLevelupScore(this.hZR);
                bVar.a(forum, frsViewData);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void cfo() {
        if (this.hBW != null) {
            FrsViewData bYC = this.hBW.bYC();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.hBW.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.hBW.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_SIGN)));
            } else if (bYC != null && bYC.getForum() != null) {
                ForumData forum = bYC.getForum();
                forum.setFromPage("frs");
                FrsActivityStatic.forumName = forum.getName() == null ? "" : forum.getName();
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, forum);
                customMessage.setTag(this.hZQ);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    public void O(int i, int i2, int i3) {
        FrsViewData bYC;
        if (this.hBW != null && i > 0 && i2 > 0 && (bYC = this.hBW.bYC()) != null && bYC.getForum() != null && bYC.getSignData() != null) {
            ForumData forum = bYC.getForum();
            SignData signData = bYC.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            bYC.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            h bXX = this.hBW.bXX();
            boolean cfA = bXX != null ? bXX.cfA() : false;
            int i4 = -1;
            if (cfA) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }
}
