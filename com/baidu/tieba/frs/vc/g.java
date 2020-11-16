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
/* loaded from: classes21.dex */
public class g {
    private int iEn;
    private FrsFragment iKx;
    private TBSpecificationBtn jjt;
    private BdUniqueId jjv;
    private int jjw;
    private boolean jjx;
    private CustomMessageListener jjy = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.vc.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData cys;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            int i;
            if (g.this.iKx != null && (customResponsedMessage instanceof SignMessage) && (cys = g.this.iKx.cys()) != null && cys.getForum() != null && (name = (forum = cys.getForum()).getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == g.this.jjv) {
                TiebaStatic.eventStat(g.this.iKx.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
                String name2 = forum.getName();
                SignMessage signMessage = (SignMessage) customResponsedMessage;
                if (!AntiHelper.bP(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                    h cxL = g.this.iKx.cxL();
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(forum.getId())) {
                            if (cxL != null) {
                                cxL.KD(name2);
                            }
                            cys.updateSignData(signData2);
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
                        if (cxL != null ? cxL.cFF() : false) {
                            i = forum.getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (g.this.cFq() && signData.contDays > 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.bwh().Ct(signData.userInfoJson);
                            TbPageContext<?> tbPageContext = g.this.iKx.getTbPageContext();
                            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(g.this.iKx.getActivity(), "", g.this.jju, false, true, true);
                            tbWebViewActivityConfig.setPageTranslucent("open_full_screen_opacity_web_page");
                            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                            q.bgf().bgp().bgu();
                            return;
                        }
                        com.baidu.tbadk.coreExtra.messageCenter.f.bwh().Ct(null);
                        if (cxL == null || cxL.cFD()) {
                            g.this.iKx.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                        } else {
                            g.this.iKx.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                        }
                        com.baidu.tieba.frs.q cxO = g.this.iKx.cxO();
                        if (cxO != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.bwh().a(g.this.iKx.getTbPageContext(), cxO.cjt());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002 && cxL != null) {
                        cxL.AX(1);
                    }
                    g.this.iKx.showToast(signMessage.mSignErrorString);
                    return;
                }
                if (signMessage.signData != null) {
                    AntiHelper.a(g.this.iKx.getActivity(), signMessage.signData.blockPopInfoData, g.this.mInjectListener);
                } else {
                    AntiHelper.bj(g.this.iKx.getActivity(), signMessage.mSignErrorString);
                }
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ak("obj_locate", ay.a.LOCATE_SIGN));
            }
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.g.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ak("obj_locate", ay.a.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ak("obj_locate", ay.a.LOCATE_SIGN));
        }
    };
    private CustomMessageListener jjz = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.vc.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData cys;
            int i;
            if (g.this.iKx != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (cys = g.this.iKx.cys()) != null && cys.getForum() != null) {
                ForumData forum = cys.getForum();
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = forum.getUser_level();
                if (signData.forumId != null && signData.forumId.equals(forum.getId())) {
                    cys.updateSignData(signData);
                    h cxL = g.this.iKx.cxL();
                    boolean z = false;
                    if (cxL != null) {
                        cxL.l(cys);
                        z = cxL.cFF();
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
    private String jju = TbSingleton.getInstance().getWalletSignLink();

    public g(FrsFragment frsFragment, BdUniqueId bdUniqueId) {
        this.iKx = frsFragment;
        this.jjv = bdUniqueId;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.jjt = tBSpecificationBtn;
    }

    public void registerListener() {
        if (this.iKx != null) {
            this.iKx.registerListener(this.jjy);
            this.iKx.registerListener(this.jjz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cFq() {
        return !TextUtils.isEmpty(this.jju);
    }

    public void AS(int i) {
        if (this.jjt != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
            this.jjt.getLayoutParams().width = -2;
            this.jjt.setPadding(0, 0, 0, 0);
            TBSpecificationButtonConfig styleConfig = this.jjt.getStyleConfig();
            styleConfig.qB(dimenPixelSize);
            if (i > 0) {
                this.jjt.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.miss_sign_days), Integer.valueOf(i)));
                styleConfig.a(R.drawable.icon_pure_frs_sign_add16, 0, TBSpecificationButtonConfig.IconType.WEBP);
            } else {
                this.jjt.setText(TbadkCoreApplication.getInst().getString(R.string.signed));
                styleConfig.a(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
            }
            this.jjt.setTextSize(R.dimen.T_X08);
            this.jjt.brT();
            this.jjt.setVisibility(0);
        }
    }

    public void cBo() {
        if (cFq()) {
            cFs();
        } else {
            cFr();
        }
    }

    private void cFr() {
        if (this.jjt != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
            this.jjt.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
            this.jjt.setPadding(0, 0, 0, 0);
            this.jjt.setTextSize(R.dimen.T_X08);
            this.jjt.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            TBSpecificationButtonConfig styleConfig = this.jjt.getStyleConfig();
            styleConfig.qB(dimenPixelSize);
            styleConfig.a(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.jjt.brT();
        }
    }

    private void cFs() {
        if (this.jjt != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
            this.jjt.getLayoutParams().width = -2;
            this.jjt.setPadding(0, 0, 0, 0);
            this.jjt.setTextSize(R.dimen.T_X08);
            this.jjt.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            TBSpecificationButtonConfig styleConfig = this.jjt.getStyleConfig();
            styleConfig.qB(dimenPixelSize);
            styleConfig.qF(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
            styleConfig.a(R.drawable.icon_frs_wallet_n, 0, TBSpecificationButtonConfig.IconType.PIC);
            this.jjt.brT();
        }
    }

    public void qw(boolean z) {
        if (z && !this.jjx) {
            ar.Bs("c13560").ak("obj_type", 1).bqy();
            this.jjx = true;
        }
    }

    public float f(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.jjw = forumData.getLevelupScore();
        this.iEn = forumData.getCurScore();
        if (this.jjw > 0) {
            return this.iEn / this.jjw;
        }
        return 0.0f;
    }

    public void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.jjw - this.iEn) {
                z = true;
                this.jjw = signData.levelup_score;
            }
            this.iEn = i + this.iEn;
            if (this.iEn > this.jjw) {
                this.iEn = this.jjw;
            }
            if (this.jjw != 0) {
                f = this.iEn / this.jjw;
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
            bVar.Bt(signData.is_signed);
            if (signData.sign_bonus_point > 0 && bVar.cGE()) {
                a(bVar, signData);
                forum.setCurScore(this.iEn);
                forum.setLevelupScore(this.jjw);
                bVar.a(forum, frsViewData);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void cFt() {
        if (this.iKx != null) {
            FrsViewData cys = this.iKx.cys();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.iKx.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.iKx.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_SIGN)));
            } else if (cys != null && cys.getForum() != null) {
                ForumData forum = cys.getForum();
                forum.setFromPage("frs");
                FrsActivityStatic.forumName = forum.getName() == null ? "" : forum.getName();
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, forum);
                customMessage.setTag(this.jjv);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    public void S(int i, int i2, int i3) {
        FrsViewData cys;
        if (this.iKx != null && i > 0 && i2 > 0 && (cys = this.iKx.cys()) != null && cys.getForum() != null && cys.getSignData() != null) {
            ForumData forum = cys.getForum();
            SignData signData = cys.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            cys.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            h cxL = this.iKx.cxL();
            boolean cFF = cxL != null ? cxL.cFF() : false;
            int i4 = -1;
            if (cFF) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }
}
