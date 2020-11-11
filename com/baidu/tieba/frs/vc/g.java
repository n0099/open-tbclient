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
    private int iDz;
    private FrsFragment iJK;
    private TBSpecificationBtn jiI;
    private BdUniqueId jiK;
    private int jiL;
    private boolean jiM;
    private CustomMessageListener jiN = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.vc.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData cyP;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            int i;
            if (g.this.iJK != null && (customResponsedMessage instanceof SignMessage) && (cyP = g.this.iJK.cyP()) != null && cyP.getForum() != null && (name = (forum = cyP.getForum()).getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == g.this.jiK) {
                TiebaStatic.eventStat(g.this.iJK.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
                String name2 = forum.getName();
                SignMessage signMessage = (SignMessage) customResponsedMessage;
                if (!AntiHelper.bR(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                    h cyi = g.this.iJK.cyi();
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(forum.getId())) {
                            if (cyi != null) {
                                cyi.Lc(name2);
                            }
                            cyP.updateSignData(signData2);
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
                        if (cyi != null ? cyi.cGa() : false) {
                            i = forum.getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (g.this.cFL() && signData.contDays > 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.bwR().CU(signData.userInfoJson);
                            TbPageContext<?> tbPageContext = g.this.iJK.getTbPageContext();
                            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(g.this.iJK.getActivity(), "", g.this.jiJ, false, true, true);
                            tbWebViewActivityConfig.setPageTranslucent("open_full_screen_opacity_web_page");
                            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                            q.bgM().bgW().bhb();
                            return;
                        }
                        com.baidu.tbadk.coreExtra.messageCenter.f.bwR().CU(null);
                        if (cyi == null || cyi.cFY()) {
                            g.this.iJK.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                        } else {
                            g.this.iJK.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                        }
                        com.baidu.tieba.frs.q cyl = g.this.iJK.cyl();
                        if (cyl != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.bwR().a(g.this.iJK.getTbPageContext(), cyl.cka());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002 && cyi != null) {
                        cyi.Az(1);
                    }
                    g.this.iJK.showToast(signMessage.mSignErrorString);
                    return;
                }
                if (signMessage.signData != null) {
                    AntiHelper.a(g.this.iJK.getActivity(), signMessage.signData.blockPopInfoData, g.this.mInjectListener);
                } else {
                    AntiHelper.bm(g.this.iJK.getActivity(), signMessage.mSignErrorString);
                }
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ax.a.LOCATE_SIGN));
            }
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.g.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ax.a.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ax.a.LOCATE_SIGN));
        }
    };
    private CustomMessageListener jiO = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.vc.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData cyP;
            int i;
            if (g.this.iJK != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (cyP = g.this.iJK.cyP()) != null && cyP.getForum() != null) {
                ForumData forum = cyP.getForum();
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = forum.getUser_level();
                if (signData.forumId != null && signData.forumId.equals(forum.getId())) {
                    cyP.updateSignData(signData);
                    h cyi = g.this.iJK.cyi();
                    boolean z = false;
                    if (cyi != null) {
                        cyi.k(cyP);
                        z = cyi.cGa();
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
    private String jiJ = TbSingleton.getInstance().getWalletSignLink();

    public g(FrsFragment frsFragment, BdUniqueId bdUniqueId) {
        this.iJK = frsFragment;
        this.jiK = bdUniqueId;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.jiI = tBSpecificationBtn;
    }

    public void registerListener() {
        if (this.iJK != null) {
            this.iJK.registerListener(this.jiN);
            this.iJK.registerListener(this.jiO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cFL() {
        return !TextUtils.isEmpty(this.jiJ);
    }

    public void Au(int i) {
        if (this.jiI != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.jiI.getLayoutParams().width = -2;
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
            this.jiI.setPadding(dimenPixelSize2, 0, dimenPixelSize2, 0);
            TBSpecificationButtonConfig styleConfig = this.jiI.getStyleConfig();
            styleConfig.qd(dimenPixelSize);
            if (i > 0) {
                this.jiI.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.miss_sign_days), Integer.valueOf(i)));
                styleConfig.a(R.drawable.icon_pure_frs_sign_add16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
            } else {
                this.jiI.setText(TbadkCoreApplication.getInst().getString(R.string.signed));
                styleConfig.a(R.drawable.icon_pure_frs_sign16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
            }
            this.jiI.setTextSize(R.dimen.tbds34);
            this.jiI.bsD();
            this.jiI.setVisibility(0);
        }
    }

    public void cBL() {
        if (cFL()) {
            cFN();
        } else {
            cFM();
        }
    }

    private void cFM() {
        if (this.jiI != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.jiI.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
            this.jiI.setPadding(0, 0, 0, 0);
            this.jiI.setTextSize(R.dimen.tbds34);
            this.jiI.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            TBSpecificationButtonConfig styleConfig = this.jiI.getStyleConfig();
            styleConfig.qd(dimenPixelSize);
            styleConfig.a(R.drawable.icon_pure_frs_sign16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
            this.jiI.bsD();
        }
    }

    private void cFN() {
        if (this.jiI != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
            this.jiI.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds187);
            this.jiI.setPadding(0, 0, 0, 0);
            this.jiI.setTextSize(R.dimen.tbds34);
            this.jiI.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            TBSpecificationButtonConfig styleConfig = this.jiI.getStyleConfig();
            styleConfig.qd(dimenPixelSize);
            styleConfig.a(R.drawable.icon_frs_wallet_n, 0, TBSpecificationButtonConfig.IconType.PIC);
            this.jiI.bsD();
        }
    }

    public void qt(boolean z) {
        if (z && !this.jiM) {
            aq.BT("c13560").al("obj_type", 1).brk();
            this.jiM = true;
        }
    }

    public float f(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.jiL = forumData.getLevelupScore();
        this.iDz = forumData.getCurScore();
        if (this.jiL > 0) {
            return this.iDz / this.jiL;
        }
        return 0.0f;
    }

    public void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.jiL - this.iDz) {
                z = true;
                this.jiL = signData.levelup_score;
            }
            this.iDz = i + this.iDz;
            if (this.iDz > this.jiL) {
                this.iDz = this.jiL;
            }
            if (this.jiL != 0) {
                f = this.iDz / this.jiL;
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
            bVar.AV(signData.is_signed);
            if (signData.sign_bonus_point > 0 && bVar.cGZ()) {
                a(bVar, signData);
                forum.setCurScore(this.iDz);
                forum.setLevelupScore(this.jiL);
                bVar.a(forum, frsViewData);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void cFO() {
        if (this.iJK != null) {
            FrsViewData cyP = this.iJK.cyP();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.iJK.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.iJK.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_SIGN)));
            } else if (cyP != null && cyP.getForum() != null) {
                ForumData forum = cyP.getForum();
                forum.setFromPage("frs");
                FrsActivityStatic.forumName = forum.getName() == null ? "" : forum.getName();
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, forum);
                customMessage.setTag(this.jiK);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    public void Q(int i, int i2, int i3) {
        FrsViewData cyP;
        if (this.iJK != null && i > 0 && i2 > 0 && (cyP = this.iJK.cyP()) != null && cyP.getForum() != null && cyP.getSignData() != null) {
            ForumData forum = cyP.getForum();
            SignData signData = cyP.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            cyP.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            h cyi = this.iJK.cyi();
            boolean cGa = cyi != null ? cyi.cGa() : false;
            int i4 = -1;
            if (cGa) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }
}
