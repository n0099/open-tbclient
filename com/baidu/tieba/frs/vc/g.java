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
/* loaded from: classes22.dex */
public class g {
    private FrsFragment iDN;
    private int ixC;
    private TBSpecificationBtn jcK;
    private BdUniqueId jcM;
    private int jcN;
    private boolean jcO;
    private CustomMessageListener jcP = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.vc.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData cwo;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            int i;
            if (g.this.iDN != null && (customResponsedMessage instanceof SignMessage) && (cwo = g.this.iDN.cwo()) != null && cwo.getForum() != null && (name = (forum = cwo.getForum()).getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == g.this.jcM) {
                TiebaStatic.eventStat(g.this.iDN.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
                String name2 = forum.getName();
                SignMessage signMessage = (SignMessage) customResponsedMessage;
                if (!AntiHelper.bN(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                    h cvH = g.this.iDN.cvH();
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(forum.getId())) {
                            if (cvH != null) {
                                cvH.KL(name2);
                            }
                            cwo.updateSignData(signData2);
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
                        if (cvH != null ? cvH.cDz() : false) {
                            i = forum.getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (g.this.cDk() && signData.contDays > 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.bur().CG(signData.userInfoJson);
                            TbPageContext<?> tbPageContext = g.this.iDN.getTbPageContext();
                            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(g.this.iDN.getActivity(), "", g.this.jcL, false, true, true);
                            tbWebViewActivityConfig.setPageTranslucent("open_full_screen_opacity_web_page");
                            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                            q.bem().bew().beB();
                            return;
                        }
                        com.baidu.tbadk.coreExtra.messageCenter.f.bur().CG(null);
                        if (cvH == null || cvH.cDx()) {
                            g.this.iDN.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                        } else {
                            g.this.iDN.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                        }
                        com.baidu.tieba.frs.q cvK = g.this.iDN.cvK();
                        if (cvK != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.bur().a(g.this.iDN.getTbPageContext(), cvK.chy());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002 && cvH != null) {
                        cvH.Am(1);
                    }
                    g.this.iDN.showToast(signMessage.mSignErrorString);
                    return;
                }
                if (signMessage.signData != null) {
                    AntiHelper.a(g.this.iDN.getActivity(), signMessage.signData.blockPopInfoData, g.this.mInjectListener);
                } else {
                    AntiHelper.bm(g.this.iDN.getActivity(), signMessage.mSignErrorString);
                }
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aj("obj_locate", ax.a.LOCATE_SIGN));
            }
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.g.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aj("obj_locate", ax.a.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aj("obj_locate", ax.a.LOCATE_SIGN));
        }
    };
    private CustomMessageListener jcQ = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.vc.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData cwo;
            int i;
            if (g.this.iDN != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (cwo = g.this.iDN.cwo()) != null && cwo.getForum() != null) {
                ForumData forum = cwo.getForum();
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = forum.getUser_level();
                if (signData.forumId != null && signData.forumId.equals(forum.getId())) {
                    cwo.updateSignData(signData);
                    h cvH = g.this.iDN.cvH();
                    boolean z = false;
                    if (cvH != null) {
                        cvH.k(cwo);
                        z = cvH.cDz();
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
    private String jcL = TbSingleton.getInstance().getWalletSignLink();

    public g(FrsFragment frsFragment, BdUniqueId bdUniqueId) {
        this.iDN = frsFragment;
        this.jcM = bdUniqueId;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.jcK = tBSpecificationBtn;
    }

    public void registerListener() {
        if (this.iDN != null) {
            this.iDN.registerListener(this.jcP);
            this.iDN.registerListener(this.jcQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cDk() {
        return !TextUtils.isEmpty(this.jcL);
    }

    public void Ah(int i) {
        if (this.jcK != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.jcK.getLayoutParams().width = -2;
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
            this.jcK.setPadding(dimenPixelSize2, 0, dimenPixelSize2, 0);
            TBSpecificationButtonConfig styleConfig = this.jcK.getStyleConfig();
            styleConfig.pT(dimenPixelSize);
            if (i > 0) {
                this.jcK.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.miss_sign_days), Integer.valueOf(i)));
                styleConfig.a(R.drawable.icon_pure_frs_sign_add16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
            } else {
                this.jcK.setText(TbadkCoreApplication.getInst().getString(R.string.signed));
                styleConfig.a(R.drawable.icon_pure_frs_sign16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
            }
            this.jcK.setTextSize(R.dimen.tbds34);
            this.jcK.bqd();
            this.jcK.setVisibility(0);
        }
    }

    public void czk() {
        if (cDk()) {
            cDm();
        } else {
            cDl();
        }
    }

    private void cDl() {
        if (this.jcK != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.jcK.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
            this.jcK.setPadding(0, 0, 0, 0);
            this.jcK.setTextSize(R.dimen.tbds34);
            this.jcK.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            TBSpecificationButtonConfig styleConfig = this.jcK.getStyleConfig();
            styleConfig.pT(dimenPixelSize);
            styleConfig.a(R.drawable.icon_pure_frs_sign16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
            this.jcK.bqd();
        }
    }

    private void cDm() {
        if (this.jcK != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
            this.jcK.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds187);
            this.jcK.setPadding(0, 0, 0, 0);
            this.jcK.setTextSize(R.dimen.tbds34);
            this.jcK.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            TBSpecificationButtonConfig styleConfig = this.jcK.getStyleConfig();
            styleConfig.pT(dimenPixelSize);
            styleConfig.a(R.drawable.icon_frs_wallet_n, 0, TBSpecificationButtonConfig.IconType.PIC);
            this.jcK.bqd();
        }
    }

    public void qk(boolean z) {
        if (z && !this.jcO) {
            aq.BF("c13560").aj("obj_type", 1).boK();
            this.jcO = true;
        }
    }

    public float f(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.jcN = forumData.getLevelupScore();
        this.ixC = forumData.getCurScore();
        if (this.jcN > 0) {
            return this.ixC / this.jcN;
        }
        return 0.0f;
    }

    public void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.jcN - this.ixC) {
                z = true;
                this.jcN = signData.levelup_score;
            }
            this.ixC = i + this.ixC;
            if (this.ixC > this.jcN) {
                this.ixC = this.jcN;
            }
            if (this.jcN != 0) {
                f = this.ixC / this.jcN;
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
            bVar.AI(signData.is_signed);
            if (signData.sign_bonus_point > 0 && bVar.cEy()) {
                a(bVar, signData);
                forum.setCurScore(this.ixC);
                forum.setLevelupScore(this.jcN);
                bVar.a(forum, frsViewData);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void cDn() {
        if (this.iDN != null) {
            FrsViewData cwo = this.iDN.cwo();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.iDN.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.iDN.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_SIGN)));
            } else if (cwo != null && cwo.getForum() != null) {
                ForumData forum = cwo.getForum();
                forum.setFromPage("frs");
                FrsActivityStatic.forumName = forum.getName() == null ? "" : forum.getName();
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, forum);
                customMessage.setTag(this.jcM);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    public void Q(int i, int i2, int i3) {
        FrsViewData cwo;
        if (this.iDN != null && i > 0 && i2 > 0 && (cwo = this.iDN.cwo()) != null && cwo.getForum() != null && cwo.getSignData() != null) {
            ForumData forum = cwo.getForum();
            SignData signData = cwo.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            cwo.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            h cvH = this.iDN.cvH();
            boolean cDz = cvH != null ? cvH.cDz() : false;
            int i4 = -1;
            if (cDz) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }
}
