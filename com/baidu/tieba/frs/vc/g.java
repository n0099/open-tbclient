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
    private int gUN;
    private FrsFragment hah;
    private TBSpecificationBtn hwW;
    private BdUniqueId hwY;
    private int hwZ;
    private boolean hxa;
    private CustomMessageListener hxb = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.vc.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData bOY;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            int i;
            if (g.this.hah != null && (customResponsedMessage instanceof SignMessage) && (bOY = g.this.hah.bOY()) != null && bOY.getForum() != null && (name = (forum = bOY.getForum()).getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == g.this.hwY) {
                TiebaStatic.eventStat(g.this.hah.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
                String name2 = forum.getName();
                SignMessage signMessage = (SignMessage) customResponsedMessage;
                if (!AntiHelper.bq(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                    h bOu = g.this.hah.bOu();
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(forum.getId())) {
                            if (bOu != null) {
                                bOu.Dz(name2);
                            }
                            bOY.updateSignData(signData2);
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
                        if (bOu != null ? bOu.bVC() : false) {
                            i = forum.getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (g.this.bVo() && signData.contDays > 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.aUi().vG(signData.userInfoJson);
                            TbPageContext<?> tbPageContext = g.this.hah.getTbPageContext();
                            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(g.this.hah.getActivity(), "", g.this.hwX, false, true, true);
                            tbWebViewActivityConfig.setPageTranslucent("open_full_screen_opacity_web_page");
                            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                            return;
                        }
                        com.baidu.tbadk.coreExtra.messageCenter.f.aUi().vG(null);
                        if (bOu == null || bOu.bVA()) {
                            g.this.hah.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                        } else {
                            g.this.hah.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                        }
                        com.baidu.tieba.frs.n bOx = g.this.hah.bOx();
                        if (bOx != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.aUi().a(g.this.hah.getTbPageContext(), bOx.bCt());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002 && bOu != null) {
                        bOu.uQ(1);
                    }
                    g.this.hah.showToast(signMessage.mSignErrorString);
                    return;
                }
                if (signMessage.signData != null) {
                    AntiHelper.a(g.this.hah.getActivity(), signMessage.signData.blockPopInfoData, g.this.mInjectListener);
                } else {
                    AntiHelper.bi(g.this.hah.getActivity(), signMessage.mSignErrorString);
                }
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).af("obj_locate", at.a.LOCATE_SIGN));
            }
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.g.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).af("obj_locate", at.a.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).af("obj_locate", at.a.LOCATE_SIGN));
        }
    };
    private CustomMessageListener hxc = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.vc.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData bOY;
            int i;
            if (g.this.hah != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (bOY = g.this.hah.bOY()) != null && bOY.getForum() != null) {
                ForumData forum = bOY.getForum();
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = forum.getUser_level();
                if (signData.forumId != null && signData.forumId.equals(forum.getId())) {
                    bOY.updateSignData(signData);
                    h bOu = g.this.hah.bOu();
                    boolean z = false;
                    if (bOu != null) {
                        bOu.j(bOY);
                        z = bOu.bVC();
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
    private String hwX = TbSingleton.getInstance().getWalletSignLink();

    public g(FrsFragment frsFragment, BdUniqueId bdUniqueId) {
        this.hah = frsFragment;
        this.hwY = bdUniqueId;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.hwW = tBSpecificationBtn;
    }

    public void registerListener() {
        if (this.hah != null) {
            this.hah.registerListener(this.hxb);
            this.hah.registerListener(this.hxc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bVo() {
        return !TextUtils.isEmpty(this.hwX);
    }

    public void uL(int i) {
        if (this.hwW != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.hwW.getLayoutParams().width = -2;
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
            this.hwW.setPadding(dimenPixelSize2, 0, dimenPixelSize2, 0);
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.hwW.getStyleConfig();
            styleConfig.lD(dimenPixelSize);
            if (i > 0) {
                this.hwW.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.miss_sign_days), Integer.valueOf(i)));
                styleConfig.k(R.drawable.icon_pure_frs_sign_add16_svg, 0, true);
            } else {
                this.hwW.setText(TbadkCoreApplication.getInst().getString(R.string.signed));
                styleConfig.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
            }
            this.hwW.setTextSize(R.dimen.tbds34);
            this.hwW.aQp();
            this.hwW.setVisibility(0);
        }
    }

    public void bRD() {
        if (bVo()) {
            bVq();
        } else {
            bVp();
        }
    }

    private void bVp() {
        if (this.hwW != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.hwW.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
            this.hwW.setPadding(0, 0, 0, 0);
            this.hwW.setTextSize(R.dimen.tbds34);
            this.hwW.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.hwW.getStyleConfig();
            styleConfig.lD(dimenPixelSize);
            styleConfig.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
            this.hwW.aQp();
        }
    }

    private void bVq() {
        if (this.hwW != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
            this.hwW.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds187);
            this.hwW.setPadding(0, 0, 0, 0);
            this.hwW.setTextSize(R.dimen.tbds34);
            this.hwW.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.hwW.getStyleConfig();
            styleConfig.lD(dimenPixelSize);
            styleConfig.k(R.drawable.icon_frs_wallet_n, 0, false);
            this.hwW.aQp();
        }
    }

    public void np(boolean z) {
        if (z && !this.hxa) {
            an.uI("c13560").af("obj_type", 1).aOR();
            this.hxa = true;
        }
    }

    public float c(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.hwZ = forumData.getLevelupScore();
        this.gUN = forumData.getCurScore();
        if (this.hwZ > 0) {
            return this.gUN / this.hwZ;
        }
        return 0.0f;
    }

    public void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.hwZ - this.gUN) {
                z = true;
                this.hwZ = signData.levelup_score;
            }
            this.gUN = i + this.gUN;
            if (this.gUN > this.hwZ) {
                this.gUN = this.hwZ;
            }
            if (this.hwZ != 0) {
                f = this.gUN / this.hwZ;
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
            bVar.vl(signData.is_signed);
            if (signData.sign_bonus_point > 0 && bVar.bWy()) {
                a(bVar, signData);
                forum.setCurScore(this.gUN);
                forum.setLevelupScore(this.hwZ);
                bVar.a(forum, frsViewData);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void bVr() {
        if (this.hah != null) {
            FrsViewData bOY = this.hah.bOY();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.hah.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.hah.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_SIGN)));
            } else if (bOY != null && bOY.getForum() != null) {
                ForumData forum = bOY.getForum();
                forum.setFromPage("frs");
                FrsActivityStatic.forumName = forum.getName() == null ? "" : forum.getName();
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, forum);
                customMessage.setTag(this.hwY);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    public void O(int i, int i2, int i3) {
        FrsViewData bOY;
        if (this.hah != null && i > 0 && i2 > 0 && (bOY = this.hah.bOY()) != null && bOY.getForum() != null && bOY.getSignData() != null) {
            ForumData forum = bOY.getForum();
            SignData signData = bOY.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            bOY.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            h bOu = this.hah.bOu();
            boolean bVC = bOu != null ? bOu.bVC() : false;
            int i4 = -1;
            if (bVC) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }
}
