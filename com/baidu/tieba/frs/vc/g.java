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
    private TBSpecificationBtn hLP;
    private BdUniqueId hLR;
    private int hLS;
    private boolean hLT;
    private int hjF;
    private FrsFragment hpb;
    private CustomMessageListener hLU = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.vc.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData bVs;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            int i;
            if (g.this.hpb != null && (customResponsedMessage instanceof SignMessage) && (bVs = g.this.hpb.bVs()) != null && bVs.getForum() != null && (name = (forum = bVs.getForum()).getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == g.this.hLR) {
                TiebaStatic.eventStat(g.this.hpb.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
                String name2 = forum.getName();
                SignMessage signMessage = (SignMessage) customResponsedMessage;
                if (!AntiHelper.bv(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                    h bUO = g.this.hpb.bUO();
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(forum.getId())) {
                            if (bUO != null) {
                                bUO.Fl(name2);
                            }
                            bVs.updateSignData(signData2);
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
                        if (bUO != null ? bUO.cbZ() : false) {
                            i = forum.getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (g.this.cbK() && signData.contDays > 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.ban().xp(signData.userInfoJson);
                            TbPageContext<?> tbPageContext = g.this.hpb.getTbPageContext();
                            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(g.this.hpb.getActivity(), "", g.this.hLQ, false, true, true);
                            tbWebViewActivityConfig.setPageTranslucent("open_full_screen_opacity_web_page");
                            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                            return;
                        }
                        com.baidu.tbadk.coreExtra.messageCenter.f.ban().xp(null);
                        if (bUO == null || bUO.cbX()) {
                            g.this.hpb.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                        } else {
                            g.this.hpb.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                        }
                        com.baidu.tieba.frs.n bUR = g.this.hpb.bUR();
                        if (bUR != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.ban().a(g.this.hpb.getTbPageContext(), bUR.bIL());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002 && bUO != null) {
                        bUO.vw(1);
                    }
                    g.this.hpb.showToast(signMessage.mSignErrorString);
                    return;
                }
                if (signMessage.signData != null) {
                    AntiHelper.a(g.this.hpb.getActivity(), signMessage.signData.blockPopInfoData, g.this.mInjectListener);
                } else {
                    AntiHelper.aX(g.this.hpb.getActivity(), signMessage.mSignErrorString);
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
    private CustomMessageListener hLV = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.vc.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData bVs;
            int i;
            if (g.this.hpb != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (bVs = g.this.hpb.bVs()) != null && bVs.getForum() != null) {
                ForumData forum = bVs.getForum();
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = forum.getUser_level();
                if (signData.forumId != null && signData.forumId.equals(forum.getId())) {
                    bVs.updateSignData(signData);
                    h bUO = g.this.hpb.bUO();
                    boolean z = false;
                    if (bUO != null) {
                        bUO.j(bVs);
                        z = bUO.cbZ();
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
    private String hLQ = TbSingleton.getInstance().getWalletSignLink();

    public g(FrsFragment frsFragment, BdUniqueId bdUniqueId) {
        this.hpb = frsFragment;
        this.hLR = bdUniqueId;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.hLP = tBSpecificationBtn;
    }

    public void registerListener() {
        if (this.hpb != null) {
            this.hpb.registerListener(this.hLU);
            this.hpb.registerListener(this.hLV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cbK() {
        return !TextUtils.isEmpty(this.hLQ);
    }

    public void vr(int i) {
        if (this.hLP != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.hLP.getLayoutParams().width = -2;
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
            this.hLP.setPadding(dimenPixelSize2, 0, dimenPixelSize2, 0);
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.hLP.getStyleConfig();
            styleConfig.mf(dimenPixelSize);
            if (i > 0) {
                this.hLP.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.miss_sign_days), Integer.valueOf(i)));
                styleConfig.k(R.drawable.icon_pure_frs_sign_add16_svg, 0, true);
            } else {
                this.hLP.setText(TbadkCoreApplication.getInst().getString(R.string.signed));
                styleConfig.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
            }
            this.hLP.setTextSize(R.dimen.tbds34);
            this.hLP.aWq();
            this.hLP.setVisibility(0);
        }
    }

    public void bXY() {
        if (cbK()) {
            cbM();
        } else {
            cbL();
        }
    }

    private void cbL() {
        if (this.hLP != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.hLP.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
            this.hLP.setPadding(0, 0, 0, 0);
            this.hLP.setTextSize(R.dimen.tbds34);
            this.hLP.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.hLP.getStyleConfig();
            styleConfig.mf(dimenPixelSize);
            styleConfig.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
            this.hLP.aWq();
        }
    }

    private void cbM() {
        if (this.hLP != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
            this.hLP.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds187);
            this.hLP.setPadding(0, 0, 0, 0);
            this.hLP.setTextSize(R.dimen.tbds34);
            this.hLP.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.hLP.getStyleConfig();
            styleConfig.mf(dimenPixelSize);
            styleConfig.k(R.drawable.icon_frs_wallet_n, 0, false);
            this.hLP.aWq();
        }
    }

    public void nK(boolean z) {
        if (z && !this.hLT) {
            an.wr("c13560").ag("obj_type", 1).aUS();
            this.hLT = true;
        }
    }

    public float c(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.hLS = forumData.getLevelupScore();
        this.hjF = forumData.getCurScore();
        if (this.hLS > 0) {
            return this.hjF / this.hLS;
        }
        return 0.0f;
    }

    public void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.hLS - this.hjF) {
                z = true;
                this.hLS = signData.levelup_score;
            }
            this.hjF = i + this.hjF;
            if (this.hjF > this.hLS) {
                this.hjF = this.hLS;
            }
            if (this.hLS != 0) {
                f = this.hjF / this.hLS;
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
            bVar.vR(signData.is_signed);
            if (signData.sign_bonus_point > 0 && bVar.ccV()) {
                a(bVar, signData);
                forum.setCurScore(this.hjF);
                forum.setLevelupScore(this.hLS);
                bVar.a(forum, frsViewData);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void cbN() {
        if (this.hpb != null) {
            FrsViewData bVs = this.hpb.bVs();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.hpb.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.hpb.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_SIGN)));
            } else if (bVs != null && bVs.getForum() != null) {
                ForumData forum = bVs.getForum();
                forum.setFromPage("frs");
                FrsActivityStatic.forumName = forum.getName() == null ? "" : forum.getName();
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, forum);
                customMessage.setTag(this.hLR);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    public void O(int i, int i2, int i3) {
        FrsViewData bVs;
        if (this.hpb != null && i > 0 && i2 > 0 && (bVs = this.hpb.bVs()) != null && bVs.getForum() != null && bVs.getSignData() != null) {
            ForumData forum = bVs.getForum();
            SignData signData = bVs.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            bVs.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            h bUO = this.hpb.bUO();
            boolean cbZ = bUO != null ? bUO.cbZ() : false;
            int i4 = -1;
            if (cbZ) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }
}
