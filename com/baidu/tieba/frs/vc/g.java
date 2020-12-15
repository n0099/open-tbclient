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
    private int iPh;
    private FrsFragment iVs;
    private TBSpecificationBtn jwX;
    private BdUniqueId jwZ;
    private int jxa;
    private boolean jxb;
    private CustomMessageListener jxc = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.vc.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData cCK;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            int i;
            if (g.this.iVs != null && (customResponsedMessage instanceof SignMessage) && (cCK = g.this.iVs.cCK()) != null && cCK.getForum() != null && (name = (forum = cCK.getForum()).getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == g.this.jwZ) {
                TiebaStatic.eventStat(g.this.iVs.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
                String name2 = forum.getName();
                SignMessage signMessage = (SignMessage) customResponsedMessage;
                if (!AntiHelper.bP(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                    h cCc = g.this.iVs.cCc();
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(forum.getId())) {
                            if (cCc != null) {
                                cCc.LK(name2);
                            }
                            cCK.updateSignData(signData2);
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
                        if (cCc != null ? cCc.cKV() : false) {
                            i = forum.getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (g.this.cKE() && signData.contDays > 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.bzH().Db(signData.userInfoJson);
                            TbPageContext<?> tbPageContext = g.this.iVs.getTbPageContext();
                            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(g.this.iVs.getActivity(), "", g.this.jwY, false, true, true);
                            tbWebViewActivityConfig.setPageTranslucent("open_full_screen_opacity_web_page");
                            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                            q.bjk().bju().bjz();
                            return;
                        }
                        com.baidu.tbadk.coreExtra.messageCenter.f.bzH().Db(null);
                        if (cCc == null || cCc.cKT()) {
                            g.this.iVs.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                        } else {
                            g.this.iVs.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                        }
                        com.baidu.tieba.frs.q cCf = g.this.iVs.cCf();
                        if (cCf != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.bzH().a(g.this.iVs.getTbPageContext(), cCf.cno());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002 && cCc != null) {
                        cCc.BL(1);
                    }
                    g.this.iVs.showToast(signMessage.mSignErrorString);
                    return;
                }
                if (signMessage.signData != null) {
                    AntiHelper.a(g.this.iVs.getActivity(), signMessage.signData.blockPopInfoData, g.this.mInjectListener);
                } else {
                    AntiHelper.bn(g.this.iVs.getActivity(), signMessage.mSignErrorString);
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
    private CustomMessageListener jxd = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.vc.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData cCK;
            int i;
            if (g.this.iVs != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (cCK = g.this.iVs.cCK()) != null && cCK.getForum() != null) {
                ForumData forum = cCK.getForum();
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = forum.getUser_level();
                if (signData.forumId != null && signData.forumId.equals(forum.getId())) {
                    cCK.updateSignData(signData);
                    h cCc = g.this.iVs.cCc();
                    boolean z = false;
                    if (cCc != null) {
                        cCc.l(cCK);
                        z = cCc.cKV();
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
    private String jwY = TbSingleton.getInstance().getWalletSignLink();

    public g(FrsFragment frsFragment, BdUniqueId bdUniqueId) {
        this.iVs = frsFragment;
        this.jwZ = bdUniqueId;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.jwX = tBSpecificationBtn;
    }

    public void registerListener() {
        if (this.iVs != null) {
            this.iVs.registerListener(this.jxc);
            this.iVs.registerListener(this.jxd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cKE() {
        return !TextUtils.isEmpty(this.jwY);
    }

    public void BG(int i) {
        if (this.jwX != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
            this.jwX.getLayoutParams().width = -2;
            this.jwX.setPadding(0, 0, 0, 0);
            TBSpecificationButtonConfig styleConfig = this.jwX.getStyleConfig();
            styleConfig.rc(dimenPixelSize);
            if (i > 0) {
                this.jwX.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.miss_sign_days), Integer.valueOf(i)));
                styleConfig.a(R.drawable.icon_pure_frs_sign_add16, 0, TBSpecificationButtonConfig.IconType.WEBP);
            } else {
                this.jwX.setText(TbadkCoreApplication.getInst().getString(R.string.signed));
                styleConfig.a(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
            }
            this.jwX.setTextSize(R.dimen.T_X08);
            this.jwX.bvt();
            this.jwX.setVisibility(0);
        }
    }

    public void cFF() {
        if (cKE()) {
            cKG();
        } else {
            cKF();
        }
    }

    private void cKF() {
        if (this.jwX != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
            this.jwX.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
            this.jwX.setPadding(0, 0, 0, 0);
            this.jwX.setTextSize(R.dimen.T_X08);
            this.jwX.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            TBSpecificationButtonConfig styleConfig = this.jwX.getStyleConfig();
            styleConfig.rc(dimenPixelSize);
            styleConfig.a(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.jwX.bvt();
        }
    }

    private void cKG() {
        if (this.jwX != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
            this.jwX.getLayoutParams().width = -2;
            this.jwX.setPadding(0, 0, 0, 0);
            this.jwX.setTextSize(R.dimen.T_X08);
            this.jwX.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            TBSpecificationButtonConfig styleConfig = this.jwX.getStyleConfig();
            styleConfig.rc(dimenPixelSize);
            styleConfig.rg(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
            styleConfig.a(R.drawable.icon_frs_wallet_n, 0, TBSpecificationButtonConfig.IconType.PIC);
            this.jwX.bvt();
        }
    }

    public void qX(boolean z) {
        if (z && !this.jxb) {
            ar.BZ("c13560").al("obj_type", 1).btT();
            this.jxb = true;
        }
    }

    public float f(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.jxa = forumData.getLevelupScore();
        this.iPh = forumData.getCurScore();
        if (this.jxa > 0) {
            return this.iPh / this.jxa;
        }
        return 0.0f;
    }

    public void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.jxa - this.iPh) {
                z = true;
                this.jxa = signData.levelup_score;
            }
            this.iPh = i + this.iPh;
            if (this.iPh > this.jxa) {
                this.iPh = this.jxa;
            }
            if (this.jxa != 0) {
                f = this.iPh / this.jxa;
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
            if (signData.sign_bonus_point > 0 && bVar.cLU()) {
                a(bVar, signData);
                forum.setCurScore(this.iPh);
                forum.setLevelupScore(this.jxa);
                bVar.a(forum, frsViewData);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void cKH() {
        if (this.iVs != null) {
            FrsViewData cCK = this.iVs.cCK();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.iVs.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.iVs.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_SIGN)));
            } else if (cCK != null && cCK.getForum() != null) {
                ForumData forum = cCK.getForum();
                forum.setFromPage("frs");
                FrsActivityStatic.forumName = forum.getName() == null ? "" : forum.getName();
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, forum);
                customMessage.setTag(this.jwZ);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    public void R(int i, int i2, int i3) {
        FrsViewData cCK;
        if (this.iVs != null && i > 0 && i2 > 0 && (cCK = this.iVs.cCK()) != null && cCK.getForum() != null && cCK.getSignData() != null) {
            ForumData forum = cCK.getForum();
            SignData signData = cCK.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            cCK.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            h cCc = this.iVs.cCc();
            boolean cKV = cCc != null ? cCc.cKV() : false;
            int i4 = -1;
            if (cKV) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }
}
