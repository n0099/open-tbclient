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
    private int gUT;
    private FrsFragment han;
    private TBSpecificationBtn hxc;
    private BdUniqueId hxe;
    private int hxf;
    private boolean hxg;
    private CustomMessageListener hxh = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.vc.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData bOX;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            int i;
            if (g.this.han != null && (customResponsedMessage instanceof SignMessage) && (bOX = g.this.han.bOX()) != null && bOX.getForum() != null && (name = (forum = bOX.getForum()).getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == g.this.hxe) {
                TiebaStatic.eventStat(g.this.han.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
                String name2 = forum.getName();
                SignMessage signMessage = (SignMessage) customResponsedMessage;
                if (!AntiHelper.bq(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                    h bOt = g.this.han.bOt();
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(forum.getId())) {
                            if (bOt != null) {
                                bOt.DC(name2);
                            }
                            bOX.updateSignData(signData2);
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
                        if (bOt != null ? bOt.bVB() : false) {
                            i = forum.getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (g.this.bVn() && signData.contDays > 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.aUg().vJ(signData.userInfoJson);
                            TbPageContext<?> tbPageContext = g.this.han.getTbPageContext();
                            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(g.this.han.getActivity(), "", g.this.hxd, false, true, true);
                            tbWebViewActivityConfig.setPageTranslucent("open_full_screen_opacity_web_page");
                            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                            return;
                        }
                        com.baidu.tbadk.coreExtra.messageCenter.f.aUg().vJ(null);
                        if (bOt == null || bOt.bVz()) {
                            g.this.han.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                        } else {
                            g.this.han.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                        }
                        com.baidu.tieba.frs.n bOw = g.this.han.bOw();
                        if (bOw != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.aUg().a(g.this.han.getTbPageContext(), bOw.bCr());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002 && bOt != null) {
                        bOt.uQ(1);
                    }
                    g.this.han.showToast(signMessage.mSignErrorString);
                    return;
                }
                if (signMessage.signData != null) {
                    AntiHelper.a(g.this.han.getActivity(), signMessage.signData.blockPopInfoData, g.this.mInjectListener);
                } else {
                    AntiHelper.aW(g.this.han.getActivity(), signMessage.mSignErrorString);
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
    private CustomMessageListener hxi = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.vc.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData bOX;
            int i;
            if (g.this.han != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (bOX = g.this.han.bOX()) != null && bOX.getForum() != null) {
                ForumData forum = bOX.getForum();
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = forum.getUser_level();
                if (signData.forumId != null && signData.forumId.equals(forum.getId())) {
                    bOX.updateSignData(signData);
                    h bOt = g.this.han.bOt();
                    boolean z = false;
                    if (bOt != null) {
                        bOt.j(bOX);
                        z = bOt.bVB();
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
    private String hxd = TbSingleton.getInstance().getWalletSignLink();

    public g(FrsFragment frsFragment, BdUniqueId bdUniqueId) {
        this.han = frsFragment;
        this.hxe = bdUniqueId;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.hxc = tBSpecificationBtn;
    }

    public void registerListener() {
        if (this.han != null) {
            this.han.registerListener(this.hxh);
            this.han.registerListener(this.hxi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bVn() {
        return !TextUtils.isEmpty(this.hxd);
    }

    public void uL(int i) {
        if (this.hxc != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.hxc.getLayoutParams().width = -2;
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
            this.hxc.setPadding(dimenPixelSize2, 0, dimenPixelSize2, 0);
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.hxc.getStyleConfig();
            styleConfig.lD(dimenPixelSize);
            if (i > 0) {
                this.hxc.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.miss_sign_days), Integer.valueOf(i)));
                styleConfig.k(R.drawable.icon_pure_frs_sign_add16_svg, 0, true);
            } else {
                this.hxc.setText(TbadkCoreApplication.getInst().getString(R.string.signed));
                styleConfig.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
            }
            this.hxc.setTextSize(R.dimen.tbds34);
            this.hxc.aQm();
            this.hxc.setVisibility(0);
        }
    }

    public void bRC() {
        if (bVn()) {
            bVp();
        } else {
            bVo();
        }
    }

    private void bVo() {
        if (this.hxc != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds39);
            this.hxc.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
            this.hxc.setPadding(0, 0, 0, 0);
            this.hxc.setTextSize(R.dimen.tbds34);
            this.hxc.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.hxc.getStyleConfig();
            styleConfig.lD(dimenPixelSize);
            styleConfig.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
            this.hxc.aQm();
        }
    }

    private void bVp() {
        if (this.hxc != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
            this.hxc.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds187);
            this.hxc.setPadding(0, 0, 0, 0);
            this.hxc.setTextSize(R.dimen.tbds34);
            this.hxc.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            com.baidu.tbadk.core.view.commonBtn.a styleConfig = this.hxc.getStyleConfig();
            styleConfig.lD(dimenPixelSize);
            styleConfig.k(R.drawable.icon_frs_wallet_n, 0, false);
            this.hxc.aQm();
        }
    }

    public void np(boolean z) {
        if (z && !this.hxg) {
            an.uL("c13560").af("obj_type", 1).aOO();
            this.hxg = true;
        }
    }

    public float c(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.hxf = forumData.getLevelupScore();
        this.gUT = forumData.getCurScore();
        if (this.hxf > 0) {
            return this.gUT / this.hxf;
        }
        return 0.0f;
    }

    public void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.hxf - this.gUT) {
                z = true;
                this.hxf = signData.levelup_score;
            }
            this.gUT = i + this.gUT;
            if (this.gUT > this.hxf) {
                this.gUT = this.hxf;
            }
            if (this.hxf != 0) {
                f = this.gUT / this.hxf;
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
            if (signData.sign_bonus_point > 0 && bVar.bWx()) {
                a(bVar, signData);
                forum.setCurScore(this.gUT);
                forum.setLevelupScore(this.hxf);
                bVar.a(forum, frsViewData);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void bVq() {
        if (this.han != null) {
            FrsViewData bOX = this.han.bOX();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.han.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.han.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_SIGN)));
            } else if (bOX != null && bOX.getForum() != null) {
                ForumData forum = bOX.getForum();
                forum.setFromPage("frs");
                FrsActivityStatic.forumName = forum.getName() == null ? "" : forum.getName();
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, forum);
                customMessage.setTag(this.hxe);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    public void O(int i, int i2, int i3) {
        FrsViewData bOX;
        if (this.han != null && i > 0 && i2 > 0 && (bOX = this.han.bOX()) != null && bOX.getForum() != null && bOX.getSignData() != null) {
            ForumData forum = bOX.getForum();
            SignData signData = bOX.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            bOX.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            h bOt = this.han.bOt();
            boolean bVB = bOt != null ? bOt.bVB() : false;
            int i4 = -1;
            if (bVB) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }
}
