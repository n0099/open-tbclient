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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes16.dex */
public class g {
    private int hBK;
    private FrsFragment hHU;
    private TBSpecificationBtn ifQ;
    private BdUniqueId ifS;
    private int ifT;
    private boolean ifU;
    private CustomMessageListener ifV = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.vc.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData cbZ;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            int i;
            if (g.this.hHU != null && (customResponsedMessage instanceof SignMessage) && (cbZ = g.this.hHU.cbZ()) != null && cbZ.getForum() != null && (name = (forum = cbZ.getForum()).getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == g.this.ifS) {
                TiebaStatic.eventStat(g.this.hHU.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
                String name2 = forum.getName();
                SignMessage signMessage = (SignMessage) customResponsedMessage;
                if (!AntiHelper.bB(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                    h cbt = g.this.hHU.cbt();
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(forum.getId())) {
                            if (cbt != null) {
                                cbt.Gy(name2);
                            }
                            cbZ.updateSignData(signData2);
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
                        if (cbt != null ? cbt.ciZ() : false) {
                            i = forum.getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (g.this.ciK() && signData.contDays > 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.bgj().yO(signData.userInfoJson);
                            TbPageContext<?> tbPageContext = g.this.hHU.getTbPageContext();
                            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(g.this.hHU.getActivity(), "", g.this.ifR, false, true, true);
                            tbWebViewActivityConfig.setPageTranslucent("open_full_screen_opacity_web_page");
                            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                            q.aQI().aQS().aQX();
                            return;
                        }
                        com.baidu.tbadk.coreExtra.messageCenter.f.bgj().yO(null);
                        if (cbt == null || cbt.ciX()) {
                            g.this.hHU.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                        } else {
                            g.this.hHU.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                        }
                        p cbw = g.this.hHU.cbw();
                        if (cbw != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.bgj().a(g.this.hHU.getTbPageContext(), cbw.bPb());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002 && cbt != null) {
                        cbt.wv(1);
                    }
                    g.this.hHU.showToast(signMessage.mSignErrorString);
                    return;
                }
                if (signMessage.signData != null) {
                    AntiHelper.a(g.this.hHU.getActivity(), signMessage.signData.blockPopInfoData, g.this.mInjectListener);
                } else {
                    AntiHelper.aW(g.this.hHU.getActivity(), signMessage.mSignErrorString);
                }
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ah("obj_locate", aw.a.LOCATE_SIGN));
            }
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.g.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ah("obj_locate", aw.a.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ah("obj_locate", aw.a.LOCATE_SIGN));
        }
    };
    private CustomMessageListener ifW = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.vc.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData cbZ;
            int i;
            if (g.this.hHU != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (cbZ = g.this.hHU.cbZ()) != null && cbZ.getForum() != null) {
                ForumData forum = cbZ.getForum();
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = forum.getUser_level();
                if (signData.forumId != null && signData.forumId.equals(forum.getId())) {
                    cbZ.updateSignData(signData);
                    h cbt = g.this.hHU.cbt();
                    boolean z = false;
                    if (cbt != null) {
                        cbt.k(cbZ);
                        z = cbt.ciZ();
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
    private String ifR = TbSingleton.getInstance().getWalletSignLink();

    public g(FrsFragment frsFragment, BdUniqueId bdUniqueId) {
        this.hHU = frsFragment;
        this.ifS = bdUniqueId;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.ifQ = tBSpecificationBtn;
    }

    public void registerListener() {
        if (this.hHU != null) {
            this.hHU.registerListener(this.ifV);
            this.hHU.registerListener(this.ifW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ciK() {
        return !TextUtils.isEmpty(this.ifR);
    }

    public void wq(int i) {
        if (this.ifQ != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.ifQ.getLayoutParams().width = -2;
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
            this.ifQ.setPadding(dimenPixelSize2, 0, dimenPixelSize2, 0);
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.ifQ.getStyleConfig();
            styleConfig.mR(dimenPixelSize);
            if (i > 0) {
                this.ifQ.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.miss_sign_days), Integer.valueOf(i)));
                styleConfig.k(R.drawable.icon_pure_frs_sign_add16_svg, 0, true);
            } else {
                this.ifQ.setText(TbadkCoreApplication.getInst().getString(R.string.signed));
                styleConfig.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
            }
            this.ifQ.setTextSize(R.dimen.tbds34);
            this.ifQ.bci();
            this.ifQ.setVisibility(0);
        }
    }

    public void ceO() {
        if (ciK()) {
            ciM();
        } else {
            ciL();
        }
    }

    private void ciL() {
        if (this.ifQ != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.ifQ.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
            this.ifQ.setPadding(0, 0, 0, 0);
            this.ifQ.setTextSize(R.dimen.tbds34);
            this.ifQ.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.ifQ.getStyleConfig();
            styleConfig.mR(dimenPixelSize);
            styleConfig.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
            this.ifQ.bci();
        }
    }

    private void ciM() {
        if (this.ifQ != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
            this.ifQ.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds187);
            this.ifQ.setPadding(0, 0, 0, 0);
            this.ifQ.setTextSize(R.dimen.tbds34);
            this.ifQ.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.ifQ.getStyleConfig();
            styleConfig.mR(dimenPixelSize);
            styleConfig.k(R.drawable.icon_frs_wallet_n, 0, false);
            this.ifQ.bci();
        }
    }

    public void oB(boolean z) {
        if (z && !this.ifU) {
            ap.xP("c13560").ah("obj_type", 1).baO();
            this.ifU = true;
        }
    }

    public float c(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.ifT = forumData.getLevelupScore();
        this.hBK = forumData.getCurScore();
        if (this.ifT > 0) {
            return this.hBK / this.ifT;
        }
        return 0.0f;
    }

    public void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.ifT - this.hBK) {
                z = true;
                this.ifT = signData.levelup_score;
            }
            this.hBK = i + this.hBK;
            if (this.hBK > this.ifT) {
                this.hBK = this.ifT;
            }
            if (this.ifT != 0) {
                f = this.hBK / this.ifT;
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
            bVar.wR(signData.is_signed);
            if (signData.sign_bonus_point > 0 && bVar.cjW()) {
                a(bVar, signData);
                forum.setCurScore(this.hBK);
                forum.setLevelupScore(this.ifT);
                bVar.a(forum, frsViewData);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void ciN() {
        if (this.hHU != null) {
            FrsViewData cbZ = this.hHU.cbZ();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.hHU.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.hHU.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_SIGN)));
            } else if (cbZ != null && cbZ.getForum() != null) {
                ForumData forum = cbZ.getForum();
                forum.setFromPage("frs");
                FrsActivityStatic.forumName = forum.getName() == null ? "" : forum.getName();
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, forum);
                customMessage.setTag(this.ifS);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    public void N(int i, int i2, int i3) {
        FrsViewData cbZ;
        if (this.hHU != null && i > 0 && i2 > 0 && (cbZ = this.hHU.cbZ()) != null && cbZ.getForum() != null && cbZ.getSignData() != null) {
            ForumData forum = cbZ.getForum();
            SignData signData = cbZ.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            cbZ.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            h cbt = this.hHU.cbt();
            boolean ciZ = cbt != null ? cbt.ciZ() : false;
            int i4 = -1;
            if (ciZ) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }
}
