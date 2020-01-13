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
/* loaded from: classes7.dex */
public class g {
    private TBSpecificationBtn gKb;
    private BdUniqueId gKd;
    private int gKe;
    private boolean gKf;
    private int giJ;
    private FrsFragment gnW;
    private CustomMessageListener gKg = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.vc.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData bCK;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            int i;
            if (g.this.gnW != null && (customResponsedMessage instanceof SignMessage) && (bCK = g.this.gnW.bCK()) != null && bCK.getForum() != null && (name = (forum = bCK.getForum()).getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == g.this.gKd) {
                TiebaStatic.eventStat(g.this.gnW.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
                String name2 = forum.getName();
                SignMessage signMessage = (SignMessage) customResponsedMessage;
                if (!AntiHelper.bc(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                    h bCh = g.this.gnW.bCh();
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(forum.getId())) {
                            if (bCh != null) {
                                bCh.BA(name2);
                            }
                            bCK.updateSignData(signData2);
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
                        if (bCh != null ? bCh.bJl() : false) {
                            i = forum.getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (g.this.bIW() && signData.contDays > 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.aJl().ua(signData.userInfoJson);
                            TbPageContext<?> tbPageContext = g.this.gnW.getTbPageContext();
                            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(g.this.gnW.getActivity(), "", g.this.gKc, false, true, true);
                            tbWebViewActivityConfig.setPageTranslucent("open_full_screen_opacity_web_page");
                            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                            return;
                        }
                        com.baidu.tbadk.coreExtra.messageCenter.f.aJl().ua(null);
                        if (bCh == null || bCh.bJj()) {
                            g.this.gnW.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                        } else {
                            g.this.gnW.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                        }
                        com.baidu.tieba.frs.l bCk = g.this.gnW.bCk();
                        if (bCk != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.aJl().a(g.this.gnW.getTbPageContext(), bCk.bqY());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002 && bCh != null) {
                        bCh.uh(1);
                    }
                    g.this.gnW.showToast(signMessage.mSignErrorString);
                    return;
                }
                if (signMessage.signData != null) {
                    AntiHelper.a(g.this.gnW.getActivity(), signMessage.signData.blockPopInfoData, g.this.mInjectListener);
                } else {
                    AntiHelper.bn(g.this.gnW.getActivity(), signMessage.mSignErrorString);
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
    private CustomMessageListener gKh = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.vc.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData bCK;
            int i;
            if (g.this.gnW != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (bCK = g.this.gnW.bCK()) != null && bCK.getForum() != null) {
                ForumData forum = bCK.getForum();
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = forum.getUser_level();
                if (signData.forumId != null && signData.forumId.equals(forum.getId())) {
                    bCK.updateSignData(signData);
                    h bCh = g.this.gnW.bCh();
                    boolean z = false;
                    if (bCh != null) {
                        bCh.j(bCK);
                        z = bCh.bJl();
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
    private String gKc = TbSingleton.getInstance().getWalletSignLink();

    public g(FrsFragment frsFragment, BdUniqueId bdUniqueId) {
        this.gnW = frsFragment;
        this.gKd = bdUniqueId;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.gKb = tBSpecificationBtn;
    }

    public void registerListener() {
        if (this.gnW != null) {
            this.gnW.registerListener(this.gKg);
            this.gnW.registerListener(this.gKh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bIW() {
        return !TextUtils.isEmpty(this.gKc);
    }

    public void uc(int i) {
        if (this.gKb != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.gKb.getLayoutParams().width = -2;
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
            this.gKb.setPadding(dimenPixelSize2, 0, dimenPixelSize2, 0);
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.gKb.getStyleConfig();
            styleConfig.la(dimenPixelSize);
            if (i > 0) {
                this.gKb.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.miss_sign_days), Integer.valueOf(i)));
                styleConfig.j(R.drawable.icon_pure_frs_sign_add16_svg, 0, true);
            } else {
                this.gKb.setText(TbadkCoreApplication.getInst().getString(R.string.signed));
                styleConfig.j(R.drawable.icon_pure_frs_sign16_svg, 0, true);
            }
            this.gKb.setTextSize(R.dimen.tbds34);
            this.gKb.aFw();
            this.gKb.setVisibility(0);
        }
    }

    public void bFi() {
        if (bIW()) {
            bIY();
        } else {
            bIX();
        }
    }

    private void bIX() {
        if (this.gKb != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.gKb.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
            this.gKb.setPadding(0, 0, 0, 0);
            this.gKb.setTextSize(R.dimen.tbds34);
            this.gKb.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.gKb.getStyleConfig();
            styleConfig.la(dimenPixelSize);
            styleConfig.j(R.drawable.icon_pure_frs_sign16_svg, 0, true);
            this.gKb.aFw();
        }
    }

    private void bIY() {
        if (this.gKb != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
            this.gKb.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds187);
            this.gKb.setPadding(0, 0, 0, 0);
            this.gKb.setTextSize(R.dimen.tbds34);
            this.gKb.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.gKb.getStyleConfig();
            styleConfig.la(dimenPixelSize);
            styleConfig.j(R.drawable.icon_frs_wallet_n, 0, false);
            this.gKb.aFw();
        }
    }

    public void md(boolean z) {
        if (z && !this.gKf) {
            an.tf("c13560").Z("obj_type", 1).aEm();
            this.gKf = true;
        }
    }

    public float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.gKe = forumData.getLevelupScore();
        this.giJ = forumData.getCurScore();
        if (this.gKe > 0) {
            return this.giJ / this.gKe;
        }
        return 0.0f;
    }

    public void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.gKe - this.giJ) {
                z = true;
                this.gKe = signData.levelup_score;
            }
            this.giJ = i + this.giJ;
            if (this.giJ > this.gKe) {
                this.giJ = this.gKe;
            }
            if (this.gKe != 0) {
                f = this.giJ / this.gKe;
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
            bVar.uA(signData.is_signed);
            if (signData.sign_bonus_point > 0 && bVar.bJZ()) {
                a(bVar, signData);
                forum.setCurScore(this.giJ);
                forum.setLevelupScore(this.gKe);
                bVar.a(forum, frsViewData);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void bIZ() {
        if (this.gnW != null) {
            FrsViewData bCK = this.gnW.bCK();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.gnW.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.gnW.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_SIGN)));
            } else if (bCK != null && bCK.getForum() != null) {
                ForumData forum = bCK.getForum();
                forum.setFromPage("frs");
                FrsActivityStatic.forumName = forum.getName() == null ? "" : forum.getName();
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, forum);
                customMessage.setTag(this.gKd);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    public void K(int i, int i2, int i3) {
        FrsViewData bCK;
        if (this.gnW != null && i > 0 && i2 > 0 && (bCK = this.gnW.bCK()) != null && bCK.getForum() != null && bCK.getSignData() != null) {
            ForumData forum = bCK.getForum();
            SignData signData = bCK.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            bCK.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            h bCh = this.gnW.bCh();
            boolean bJl = bCh != null ? bCh.bJl() : false;
            int i4 = -1;
            if (bJl) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }
}
