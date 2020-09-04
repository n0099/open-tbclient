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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes16.dex */
public class g {
    private int hPf;
    private FrsFragment hVq;
    private TBSpecificationBtn iuc;
    private BdUniqueId iue;
    private int iuf;
    private boolean iug;
    private CustomMessageListener iuh = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.vc.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData cmx;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            int i;
            if (g.this.hVq != null && (customResponsedMessage instanceof SignMessage) && (cmx = g.this.hVq.cmx()) != null && cmx.getForum() != null && (name = (forum = cmx.getForum()).getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == g.this.iue) {
                TiebaStatic.eventStat(g.this.hVq.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
                String name2 = forum.getName();
                SignMessage signMessage = (SignMessage) customResponsedMessage;
                if (!AntiHelper.by(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                    h clQ = g.this.hVq.clQ();
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(forum.getId())) {
                            if (clQ != null) {
                                clQ.Jb(name2);
                            }
                            cmx.updateSignData(signData2);
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
                        if (clQ != null ? clQ.ctE() : false) {
                            i = forum.getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (g.this.ctp() && signData.contDays > 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.boU().Bf(signData.userInfoJson);
                            TbPageContext<?> tbPageContext = g.this.hVq.getTbPageContext();
                            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(g.this.hVq.getActivity(), "", g.this.iud, false, true, true);
                            tbWebViewActivityConfig.setPageTranslucent("open_full_screen_opacity_web_page");
                            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                            q.aYY().aZi().aZn();
                            return;
                        }
                        com.baidu.tbadk.coreExtra.messageCenter.f.boU().Bf(null);
                        if (clQ == null || clQ.ctC()) {
                            g.this.hVq.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                        } else {
                            g.this.hVq.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                        }
                        com.baidu.tieba.frs.q clT = g.this.hVq.clT();
                        if (clT != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.boU().a(g.this.hVq.getTbPageContext(), clT.bZc());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002 && clQ != null) {
                        clQ.yO(1);
                    }
                    g.this.hVq.showToast(signMessage.mSignErrorString);
                    return;
                }
                if (signMessage.signData != null) {
                    AntiHelper.a(g.this.hVq.getActivity(), signMessage.signData.blockPopInfoData, g.this.mInjectListener);
                } else {
                    AntiHelper.bb(g.this.hVq.getActivity(), signMessage.mSignErrorString);
                }
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_SIGN));
            }
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.g.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_SIGN));
        }
    };
    private CustomMessageListener iui = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.vc.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData cmx;
            int i;
            if (g.this.hVq != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (cmx = g.this.hVq.cmx()) != null && cmx.getForum() != null) {
                ForumData forum = cmx.getForum();
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = forum.getUser_level();
                if (signData.forumId != null && signData.forumId.equals(forum.getId())) {
                    cmx.updateSignData(signData);
                    h clQ = g.this.hVq.clQ();
                    boolean z = false;
                    if (clQ != null) {
                        clQ.k(cmx);
                        z = clQ.ctE();
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
    private String iud = TbSingleton.getInstance().getWalletSignLink();

    public g(FrsFragment frsFragment, BdUniqueId bdUniqueId) {
        this.hVq = frsFragment;
        this.iue = bdUniqueId;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.iuc = tBSpecificationBtn;
    }

    public void registerListener() {
        if (this.hVq != null) {
            this.hVq.registerListener(this.iuh);
            this.hVq.registerListener(this.iui);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ctp() {
        return !TextUtils.isEmpty(this.iud);
    }

    public void yJ(int i) {
        if (this.iuc != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.iuc.getLayoutParams().width = -2;
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
            this.iuc.setPadding(dimenPixelSize2, 0, dimenPixelSize2, 0);
            TBSpecificationButtonConfig styleConfig = this.iuc.getStyleConfig();
            styleConfig.oX(dimenPixelSize);
            if (i > 0) {
                this.iuc.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.miss_sign_days), Integer.valueOf(i)));
                styleConfig.a(R.drawable.icon_pure_frs_sign_add16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
            } else {
                this.iuc.setText(TbadkCoreApplication.getInst().getString(R.string.signed));
                styleConfig.a(R.drawable.icon_pure_frs_sign16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
            }
            this.iuc.setTextSize(R.dimen.tbds34);
            this.iuc.bkF();
            this.iuc.setVisibility(0);
        }
    }

    public void cpt() {
        if (ctp()) {
            ctr();
        } else {
            ctq();
        }
    }

    private void ctq() {
        if (this.iuc != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.iuc.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
            this.iuc.setPadding(0, 0, 0, 0);
            this.iuc.setTextSize(R.dimen.tbds34);
            this.iuc.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            TBSpecificationButtonConfig styleConfig = this.iuc.getStyleConfig();
            styleConfig.oX(dimenPixelSize);
            styleConfig.a(R.drawable.icon_pure_frs_sign16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
            this.iuc.bkF();
        }
    }

    private void ctr() {
        if (this.iuc != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
            this.iuc.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds187);
            this.iuc.setPadding(0, 0, 0, 0);
            this.iuc.setTextSize(R.dimen.tbds34);
            this.iuc.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            TBSpecificationButtonConfig styleConfig = this.iuc.getStyleConfig();
            styleConfig.oX(dimenPixelSize);
            styleConfig.a(R.drawable.icon_frs_wallet_n, 0, TBSpecificationButtonConfig.IconType.PIC);
            this.iuc.bkF();
        }
    }

    public void ph(boolean z) {
        if (z && !this.iug) {
            aq.Ae("c13560").ai("obj_type", 1).bjn();
            this.iug = true;
        }
    }

    public float d(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.iuf = forumData.getLevelupScore();
        this.hPf = forumData.getCurScore();
        if (this.iuf > 0) {
            return this.hPf / this.iuf;
        }
        return 0.0f;
    }

    public void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.iuf - this.hPf) {
                z = true;
                this.iuf = signData.levelup_score;
            }
            this.hPf = i + this.hPf;
            if (this.hPf > this.iuf) {
                this.hPf = this.iuf;
            }
            if (this.iuf != 0) {
                f = this.hPf / this.iuf;
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
            bVar.zl(signData.is_signed);
            if (signData.sign_bonus_point > 0 && bVar.cuB()) {
                a(bVar, signData);
                forum.setCurScore(this.hPf);
                forum.setLevelupScore(this.iuf);
                bVar.a(forum, frsViewData);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void cts() {
        if (this.hVq != null) {
            FrsViewData cmx = this.hVq.cmx();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.hVq.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.hVq.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_SIGN)));
            } else if (cmx != null && cmx.getForum() != null) {
                ForumData forum = cmx.getForum();
                forum.setFromPage("frs");
                FrsActivityStatic.forumName = forum.getName() == null ? "" : forum.getName();
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, forum);
                customMessage.setTag(this.iue);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    public void M(int i, int i2, int i3) {
        FrsViewData cmx;
        if (this.hVq != null && i > 0 && i2 > 0 && (cmx = this.hVq.cmx()) != null && cmx.getForum() != null && cmx.getSignData() != null) {
            ForumData forum = cmx.getForum();
            SignData signData = cmx.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            cmx.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            h clQ = this.hVq.clQ();
            boolean ctE = clQ != null ? clQ.ctE() : false;
            int i4 = -1;
            if (ctE) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }
}
