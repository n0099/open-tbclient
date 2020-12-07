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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes22.dex */
public class g {
    private int iPf;
    private FrsFragment iVq;
    private TBSpecificationBtn jwV;
    private BdUniqueId jwX;
    private int jwY;
    private boolean jwZ;
    private CustomMessageListener jxa = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.vc.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData cCJ;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            int i;
            if (g.this.iVq != null && (customResponsedMessage instanceof SignMessage) && (cCJ = g.this.iVq.cCJ()) != null && cCJ.getForum() != null && (name = (forum = cCJ.getForum()).getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == g.this.jwX) {
                TiebaStatic.eventStat(g.this.iVq.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
                String name2 = forum.getName();
                SignMessage signMessage = (SignMessage) customResponsedMessage;
                if (!AntiHelper.bP(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                    h cCb = g.this.iVq.cCb();
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(forum.getId())) {
                            if (cCb != null) {
                                cCb.LK(name2);
                            }
                            cCJ.updateSignData(signData2);
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
                        if (cCb != null ? cCb.cKU() : false) {
                            i = forum.getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (g.this.cKD() && signData.contDays > 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.bzH().Db(signData.userInfoJson);
                            TbPageContext<?> tbPageContext = g.this.iVq.getTbPageContext();
                            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(g.this.iVq.getActivity(), "", g.this.jwW, false, true, true);
                            tbWebViewActivityConfig.setPageTranslucent("open_full_screen_opacity_web_page");
                            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                            q.bjk().bju().bjz();
                            return;
                        }
                        com.baidu.tbadk.coreExtra.messageCenter.f.bzH().Db(null);
                        if (cCb == null || cCb.cKS()) {
                            g.this.iVq.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                        } else {
                            g.this.iVq.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                        }
                        com.baidu.tieba.frs.q cCe = g.this.iVq.cCe();
                        if (cCe != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.bzH().a(g.this.iVq.getTbPageContext(), cCe.cnn());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002 && cCb != null) {
                        cCb.BL(1);
                    }
                    g.this.iVq.showToast(signMessage.mSignErrorString);
                    return;
                }
                if (signMessage.signData != null) {
                    AntiHelper.a(g.this.iVq.getActivity(), signMessage.signData.blockPopInfoData, g.this.mInjectListener);
                } else {
                    AntiHelper.bn(g.this.iVq.getActivity(), signMessage.mSignErrorString);
                }
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ay.a.LOCATE_SIGN));
            }
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.g.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ay.a.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ay.a.LOCATE_SIGN));
        }
    };
    private CustomMessageListener jxb = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.vc.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData cCJ;
            int i;
            if (g.this.iVq != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (cCJ = g.this.iVq.cCJ()) != null && cCJ.getForum() != null) {
                ForumData forum = cCJ.getForum();
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = forum.getUser_level();
                if (signData.forumId != null && signData.forumId.equals(forum.getId())) {
                    cCJ.updateSignData(signData);
                    h cCb = g.this.iVq.cCb();
                    boolean z = false;
                    if (cCb != null) {
                        cCb.l(cCJ);
                        z = cCb.cKU();
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
    private String jwW = TbSingleton.getInstance().getWalletSignLink();

    public g(FrsFragment frsFragment, BdUniqueId bdUniqueId) {
        this.iVq = frsFragment;
        this.jwX = bdUniqueId;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.jwV = tBSpecificationBtn;
    }

    public void registerListener() {
        if (this.iVq != null) {
            this.iVq.registerListener(this.jxa);
            this.iVq.registerListener(this.jxb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cKD() {
        return !TextUtils.isEmpty(this.jwW);
    }

    public void BG(int i) {
        if (this.jwV != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
            this.jwV.getLayoutParams().width = -2;
            this.jwV.setPadding(0, 0, 0, 0);
            TBSpecificationButtonConfig styleConfig = this.jwV.getStyleConfig();
            styleConfig.rc(dimenPixelSize);
            if (i > 0) {
                this.jwV.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.miss_sign_days), Integer.valueOf(i)));
                styleConfig.a(R.drawable.icon_pure_frs_sign_add16, 0, TBSpecificationButtonConfig.IconType.WEBP);
            } else {
                this.jwV.setText(TbadkCoreApplication.getInst().getString(R.string.signed));
                styleConfig.a(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
            }
            this.jwV.setTextSize(R.dimen.T_X08);
            this.jwV.bvt();
            this.jwV.setVisibility(0);
        }
    }

    public void cFE() {
        if (cKD()) {
            cKF();
        } else {
            cKE();
        }
    }

    private void cKE() {
        if (this.jwV != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
            this.jwV.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
            this.jwV.setPadding(0, 0, 0, 0);
            this.jwV.setTextSize(R.dimen.T_X08);
            this.jwV.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            TBSpecificationButtonConfig styleConfig = this.jwV.getStyleConfig();
            styleConfig.rc(dimenPixelSize);
            styleConfig.a(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.jwV.bvt();
        }
    }

    private void cKF() {
        if (this.jwV != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
            this.jwV.getLayoutParams().width = -2;
            this.jwV.setPadding(0, 0, 0, 0);
            this.jwV.setTextSize(R.dimen.T_X08);
            this.jwV.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            TBSpecificationButtonConfig styleConfig = this.jwV.getStyleConfig();
            styleConfig.rc(dimenPixelSize);
            styleConfig.rg(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
            styleConfig.a(R.drawable.icon_frs_wallet_n, 0, TBSpecificationButtonConfig.IconType.PIC);
            this.jwV.bvt();
        }
    }

    public void qX(boolean z) {
        if (z && !this.jwZ) {
            ar.BZ("c13560").al("obj_type", 1).btT();
            this.jwZ = true;
        }
    }

    public float f(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.jwY = forumData.getLevelupScore();
        this.iPf = forumData.getCurScore();
        if (this.jwY > 0) {
            return this.iPf / this.jwY;
        }
        return 0.0f;
    }

    public void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.jwY - this.iPf) {
                z = true;
                this.jwY = signData.levelup_score;
            }
            this.iPf = i + this.iPf;
            if (this.iPf > this.jwY) {
                this.iPf = this.jwY;
            }
            if (this.jwY != 0) {
                f = this.iPf / this.jwY;
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
            bVar.Ci(signData.is_signed);
            if (signData.sign_bonus_point > 0 && bVar.cLT()) {
                a(bVar, signData);
                forum.setCurScore(this.iPf);
                forum.setLevelupScore(this.jwY);
                bVar.a(forum, frsViewData);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void cKG() {
        if (this.iVq != null) {
            FrsViewData cCJ = this.iVq.cCJ();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.iVq.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.iVq.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_SIGN)));
            } else if (cCJ != null && cCJ.getForum() != null) {
                ForumData forum = cCJ.getForum();
                forum.setFromPage("frs");
                FrsActivityStatic.forumName = forum.getName() == null ? "" : forum.getName();
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, forum);
                customMessage.setTag(this.jwX);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    public void R(int i, int i2, int i3) {
        FrsViewData cCJ;
        if (this.iVq != null && i > 0 && i2 > 0 && (cCJ = this.iVq.cCJ()) != null && cCJ.getForum() != null && cCJ.getSignData() != null) {
            ForumData forum = cCJ.getForum();
            SignData signData = cCJ.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            cCJ.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            h cCb = this.iVq.cCb();
            boolean cKU = cCb != null ? cCb.cKU() : false;
            int i4 = -1;
            if (cKU) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }
}
