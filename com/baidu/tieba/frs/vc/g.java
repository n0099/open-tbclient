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
    private TBSpecificationBtn hMC;
    private BdUniqueId hME;
    private int hMF;
    private boolean hMG;
    private int hjQ;
    private FrsFragment hpm;
    private CustomMessageListener hMH = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.vc.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData bVu;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            int i;
            if (g.this.hpm != null && (customResponsedMessage instanceof SignMessage) && (bVu = g.this.hpm.bVu()) != null && bVu.getForum() != null && (name = (forum = bVu.getForum()).getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == g.this.hME) {
                TiebaStatic.eventStat(g.this.hpm.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
                String name2 = forum.getName();
                SignMessage signMessage = (SignMessage) customResponsedMessage;
                if (!AntiHelper.bv(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                    h bUQ = g.this.hpm.bUQ();
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(forum.getId())) {
                            if (bUQ != null) {
                                bUQ.Fl(name2);
                            }
                            bVu.updateSignData(signData2);
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
                        if (bUQ != null ? bUQ.cch() : false) {
                            i = forum.getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (g.this.cbS() && signData.contDays > 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.bao().xp(signData.userInfoJson);
                            TbPageContext<?> tbPageContext = g.this.hpm.getTbPageContext();
                            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(g.this.hpm.getActivity(), "", g.this.hMD, false, true, true);
                            tbWebViewActivityConfig.setPageTranslucent("open_full_screen_opacity_web_page");
                            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                            return;
                        }
                        com.baidu.tbadk.coreExtra.messageCenter.f.bao().xp(null);
                        if (bUQ == null || bUQ.ccf()) {
                            g.this.hpm.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                        } else {
                            g.this.hpm.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                        }
                        com.baidu.tieba.frs.n bUT = g.this.hpm.bUT();
                        if (bUT != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.bao().a(g.this.hpm.getTbPageContext(), bUT.bIN());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002 && bUQ != null) {
                        bUQ.vy(1);
                    }
                    g.this.hpm.showToast(signMessage.mSignErrorString);
                    return;
                }
                if (signMessage.signData != null) {
                    AntiHelper.a(g.this.hpm.getActivity(), signMessage.signData.blockPopInfoData, g.this.mInjectListener);
                } else {
                    AntiHelper.aX(g.this.hpm.getActivity(), signMessage.mSignErrorString);
                }
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", at.a.LOCATE_SIGN));
            }
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.g.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", at.a.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", at.a.LOCATE_SIGN));
        }
    };
    private CustomMessageListener hMI = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.vc.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData bVu;
            int i;
            if (g.this.hpm != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (bVu = g.this.hpm.bVu()) != null && bVu.getForum() != null) {
                ForumData forum = bVu.getForum();
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = forum.getUser_level();
                if (signData.forumId != null && signData.forumId.equals(forum.getId())) {
                    bVu.updateSignData(signData);
                    h bUQ = g.this.hpm.bUQ();
                    boolean z = false;
                    if (bUQ != null) {
                        bUQ.j(bVu);
                        z = bUQ.cch();
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
    private String hMD = TbSingleton.getInstance().getWalletSignLink();

    public g(FrsFragment frsFragment, BdUniqueId bdUniqueId) {
        this.hpm = frsFragment;
        this.hME = bdUniqueId;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.hMC = tBSpecificationBtn;
    }

    public void registerListener() {
        if (this.hpm != null) {
            this.hpm.registerListener(this.hMH);
            this.hpm.registerListener(this.hMI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cbS() {
        return !TextUtils.isEmpty(this.hMD);
    }

    public void vt(int i) {
        if (this.hMC != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.hMC.getLayoutParams().width = -2;
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
            this.hMC.setPadding(dimenPixelSize2, 0, dimenPixelSize2, 0);
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.hMC.getStyleConfig();
            styleConfig.mh(dimenPixelSize);
            if (i > 0) {
                this.hMC.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.miss_sign_days), Integer.valueOf(i)));
                styleConfig.k(R.drawable.icon_pure_frs_sign_add16_svg, 0, true);
            } else {
                this.hMC.setText(TbadkCoreApplication.getInst().getString(R.string.signed));
                styleConfig.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
            }
            this.hMC.setTextSize(R.dimen.tbds34);
            this.hMC.aWr();
            this.hMC.setVisibility(0);
        }
    }

    public void bYb() {
        if (cbS()) {
            cbU();
        } else {
            cbT();
        }
    }

    private void cbT() {
        if (this.hMC != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.hMC.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
            this.hMC.setPadding(0, 0, 0, 0);
            this.hMC.setTextSize(R.dimen.tbds34);
            this.hMC.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.hMC.getStyleConfig();
            styleConfig.mh(dimenPixelSize);
            styleConfig.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
            this.hMC.aWr();
        }
    }

    private void cbU() {
        if (this.hMC != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
            this.hMC.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds187);
            this.hMC.setPadding(0, 0, 0, 0);
            this.hMC.setTextSize(R.dimen.tbds34);
            this.hMC.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.hMC.getStyleConfig();
            styleConfig.mh(dimenPixelSize);
            styleConfig.k(R.drawable.icon_frs_wallet_n, 0, false);
            this.hMC.aWr();
        }
    }

    public void nK(boolean z) {
        if (z && !this.hMG) {
            an.wr("c13560").ag("obj_type", 1).aUT();
            this.hMG = true;
        }
    }

    public float c(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.hMF = forumData.getLevelupScore();
        this.hjQ = forumData.getCurScore();
        if (this.hMF > 0) {
            return this.hjQ / this.hMF;
        }
        return 0.0f;
    }

    public void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.hMF - this.hjQ) {
                z = true;
                this.hMF = signData.levelup_score;
            }
            this.hjQ = i + this.hjQ;
            if (this.hjQ > this.hMF) {
                this.hjQ = this.hMF;
            }
            if (this.hMF != 0) {
                f = this.hjQ / this.hMF;
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
            bVar.vT(signData.is_signed);
            if (signData.sign_bonus_point > 0 && bVar.cdd()) {
                a(bVar, signData);
                forum.setCurScore(this.hjQ);
                forum.setLevelupScore(this.hMF);
                bVar.a(forum, frsViewData);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void cbV() {
        if (this.hpm != null) {
            FrsViewData bVu = this.hpm.bVu();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.hpm.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.hpm.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_SIGN)));
            } else if (bVu != null && bVu.getForum() != null) {
                ForumData forum = bVu.getForum();
                forum.setFromPage("frs");
                FrsActivityStatic.forumName = forum.getName() == null ? "" : forum.getName();
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, forum);
                customMessage.setTag(this.hME);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    public void O(int i, int i2, int i3) {
        FrsViewData bVu;
        if (this.hpm != null && i > 0 && i2 > 0 && (bVu = this.hpm.bVu()) != null && bVu.getForum() != null && bVu.getSignData() != null) {
            ForumData forum = bVu.getForum();
            SignData signData = bVu.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            bVu.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            h bUQ = this.hpm.bUQ();
            boolean cch = bUQ != null ? bUQ.cch() : false;
            int i4 = -1;
            if (cch) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }
}
