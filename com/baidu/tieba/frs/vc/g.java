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
/* loaded from: classes21.dex */
public class g {
    private int hWf;
    private BdUniqueId iBA;
    private int iBB;
    private boolean iBC;
    private TBSpecificationBtn iBy;
    private FrsFragment icq;
    private CustomMessageListener iBD = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.vc.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData cpJ;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            int i;
            if (g.this.icq != null && (customResponsedMessage instanceof SignMessage) && (cpJ = g.this.icq.cpJ()) != null && cpJ.getForum() != null && (name = (forum = cpJ.getForum()).getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == g.this.iBA) {
                TiebaStatic.eventStat(g.this.icq.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
                String name2 = forum.getName();
                SignMessage signMessage = (SignMessage) customResponsedMessage;
                if (!AntiHelper.bC(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                    h cpc = g.this.icq.cpc();
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(forum.getId())) {
                            if (cpc != null) {
                                cpc.Jz(name2);
                            }
                            cpJ.updateSignData(signData2);
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
                        if (cpc != null ? cpc.cwV() : false) {
                            i = forum.getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (g.this.cwG() && signData.contDays > 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.bpO().BB(signData.userInfoJson);
                            TbPageContext<?> tbPageContext = g.this.icq.getTbPageContext();
                            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(g.this.icq.getActivity(), "", g.this.iBz, false, true, true);
                            tbWebViewActivityConfig.setPageTranslucent("open_full_screen_opacity_web_page");
                            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                            q.aZL().aZV().baa();
                            return;
                        }
                        com.baidu.tbadk.coreExtra.messageCenter.f.bpO().BB(null);
                        if (cpc == null || cpc.cwT()) {
                            g.this.icq.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                        } else {
                            g.this.icq.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                        }
                        com.baidu.tieba.frs.q cpf = g.this.icq.cpf();
                        if (cpf != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.bpO().a(g.this.icq.getTbPageContext(), cpf.caY());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002 && cpc != null) {
                        cpc.zn(1);
                    }
                    g.this.icq.showToast(signMessage.mSignErrorString);
                    return;
                }
                if (signMessage.signData != null) {
                    AntiHelper.a(g.this.icq.getActivity(), signMessage.signData.blockPopInfoData, g.this.mInjectListener);
                } else {
                    AntiHelper.bh(g.this.icq.getActivity(), signMessage.mSignErrorString);
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
    private CustomMessageListener iBE = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.vc.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData cpJ;
            int i;
            if (g.this.icq != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (cpJ = g.this.icq.cpJ()) != null && cpJ.getForum() != null) {
                ForumData forum = cpJ.getForum();
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = forum.getUser_level();
                if (signData.forumId != null && signData.forumId.equals(forum.getId())) {
                    cpJ.updateSignData(signData);
                    h cpc = g.this.icq.cpc();
                    boolean z = false;
                    if (cpc != null) {
                        cpc.k(cpJ);
                        z = cpc.cwV();
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
    private String iBz = TbSingleton.getInstance().getWalletSignLink();

    public g(FrsFragment frsFragment, BdUniqueId bdUniqueId) {
        this.icq = frsFragment;
        this.iBA = bdUniqueId;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.iBy = tBSpecificationBtn;
    }

    public void registerListener() {
        if (this.icq != null) {
            this.icq.registerListener(this.iBD);
            this.icq.registerListener(this.iBE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cwG() {
        return !TextUtils.isEmpty(this.iBz);
    }

    public void zi(int i) {
        if (this.iBy != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.iBy.getLayoutParams().width = -2;
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
            this.iBy.setPadding(dimenPixelSize2, 0, dimenPixelSize2, 0);
            TBSpecificationButtonConfig styleConfig = this.iBy.getStyleConfig();
            styleConfig.pj(dimenPixelSize);
            if (i > 0) {
                this.iBy.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.miss_sign_days), Integer.valueOf(i)));
                styleConfig.a(R.drawable.icon_pure_frs_sign_add16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
            } else {
                this.iBy.setText(TbadkCoreApplication.getInst().getString(R.string.signed));
                styleConfig.a(R.drawable.icon_pure_frs_sign16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
            }
            this.iBy.setTextSize(R.dimen.tbds34);
            this.iBy.blA();
            this.iBy.setVisibility(0);
        }
    }

    public void csG() {
        if (cwG()) {
            cwI();
        } else {
            cwH();
        }
    }

    private void cwH() {
        if (this.iBy != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.iBy.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
            this.iBy.setPadding(0, 0, 0, 0);
            this.iBy.setTextSize(R.dimen.tbds34);
            this.iBy.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            TBSpecificationButtonConfig styleConfig = this.iBy.getStyleConfig();
            styleConfig.pj(dimenPixelSize);
            styleConfig.a(R.drawable.icon_pure_frs_sign16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
            this.iBy.blA();
        }
    }

    private void cwI() {
        if (this.iBy != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
            this.iBy.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds187);
            this.iBy.setPadding(0, 0, 0, 0);
            this.iBy.setTextSize(R.dimen.tbds34);
            this.iBy.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            TBSpecificationButtonConfig styleConfig = this.iBy.getStyleConfig();
            styleConfig.pj(dimenPixelSize);
            styleConfig.a(R.drawable.icon_frs_wallet_n, 0, TBSpecificationButtonConfig.IconType.PIC);
            this.iBy.blA();
        }
    }

    public void pn(boolean z) {
        if (z && !this.iBC) {
            aq.AA("c13560").ai("obj_type", 1).bki();
            this.iBC = true;
        }
    }

    public float f(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.iBB = forumData.getLevelupScore();
        this.hWf = forumData.getCurScore();
        if (this.iBB > 0) {
            return this.hWf / this.iBB;
        }
        return 0.0f;
    }

    public void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.iBB - this.hWf) {
                z = true;
                this.iBB = signData.levelup_score;
            }
            this.hWf = i + this.hWf;
            if (this.hWf > this.iBB) {
                this.hWf = this.iBB;
            }
            if (this.iBB != 0) {
                f = this.hWf / this.iBB;
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
            bVar.zJ(signData.is_signed);
            if (signData.sign_bonus_point > 0 && bVar.cxU()) {
                a(bVar, signData);
                forum.setCurScore(this.hWf);
                forum.setLevelupScore(this.iBB);
                bVar.a(forum, frsViewData);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void cwJ() {
        if (this.icq != null) {
            FrsViewData cpJ = this.icq.cpJ();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.icq.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.icq.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_SIGN)));
            } else if (cpJ != null && cpJ.getForum() != null) {
                ForumData forum = cpJ.getForum();
                forum.setFromPage("frs");
                FrsActivityStatic.forumName = forum.getName() == null ? "" : forum.getName();
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, forum);
                customMessage.setTag(this.iBA);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    public void O(int i, int i2, int i3) {
        FrsViewData cpJ;
        if (this.icq != null && i > 0 && i2 > 0 && (cpJ = this.icq.cpJ()) != null && cpJ.getForum() != null && cpJ.getSignData() != null) {
            ForumData forum = cpJ.getForum();
            SignData signData = cpJ.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            cpJ.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            h cpc = this.icq.cpc();
            boolean cwV = cpc != null ? cpc.cwV() : false;
            int i4 = -1;
            if (cwV) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }
}
