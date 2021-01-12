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
import org.json.JSONObject;
import tbclient.SignActivityInfo;
/* loaded from: classes2.dex */
public class g {
    private int iWM;
    private TBSpecificationBtn jEM;
    private BdUniqueId jEO;
    private int jEP;
    private boolean jEQ;
    private boolean jER;
    private FrsFragment jcX;
    private SignActivityInfo mSignActivityInfo;
    private String jES = "https://tieba.baidu.com/mo/q/signActivityPage";
    private CustomMessageListener jET = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.vc.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData cBN;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            int i;
            boolean z2;
            if (g.this.jcX != null && (customResponsedMessage instanceof SignMessage) && (cBN = g.this.jcX.cBN()) != null && cBN.getForum() != null && (name = (forum = cBN.getForum()).getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == g.this.jEO) {
                TiebaStatic.eventStat(g.this.jcX.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
                String name2 = forum.getName();
                SignMessage signMessage = (SignMessage) customResponsedMessage;
                if (!AntiHelper.bQ(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                    h cBf = g.this.jcX.cBf();
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(forum.getId())) {
                            if (cBf != null) {
                                cBf.Kz(name2);
                            }
                            cBN.updateSignData(signData2);
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
                        if (cBf != null ? cBf.cKf() : false) {
                            i = forum.getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        try {
                            int i2 = new JSONObject(signData.userInfoJson).getInt("activity_status");
                            z2 = i2 == 1 || i2 == 2;
                        } catch (Exception e) {
                            e.printStackTrace();
                            z2 = false;
                        }
                        if (!z2 || !g.this.jER) {
                            if (g.this.cJN() && signData.contDays > 0) {
                                com.baidu.tbadk.coreExtra.messageCenter.f.byi().BN(signData.userInfoJson);
                                TbPageContext<?> tbPageContext = g.this.jcX.getTbPageContext();
                                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(g.this.jcX.getActivity(), "", g.this.jEN, false, true, true);
                                tbWebViewActivityConfig.setPageTranslucent("open_full_screen_opacity_web_page");
                                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                                q.bhH().bhR().bhW();
                                return;
                            }
                            com.baidu.tbadk.coreExtra.messageCenter.f.byi().BN(null);
                            if (cBf == null || cBf.cKc()) {
                                g.this.jcX.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                            } else {
                                g.this.jcX.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                            }
                            com.baidu.tieba.frs.q cBi = g.this.jcX.cBi();
                            if (cBi != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.f.byi().a(g.this.jcX.getTbPageContext(), cBi.cmp());
                                return;
                            }
                            return;
                        }
                        if (signData != null && g.this.mSignActivityInfo != null) {
                            try {
                                JSONObject jSONObject = new JSONObject(signData.userInfoJson);
                                jSONObject.put("activity_id", g.this.mSignActivityInfo.activity_id);
                                jSONObject.put("activity_suc_msg", g.this.mSignActivityInfo.activity_suc_msg);
                                jSONObject.put("activity_fail_msg", g.this.mSignActivityInfo.activity_fail_msg);
                                jSONObject.put("gift_type", g.this.mSignActivityInfo.gift_type);
                                jSONObject.put("gift_url", g.this.mSignActivityInfo.gift_url);
                                jSONObject.put("gift_name", g.this.mSignActivityInfo.gift_name);
                                jSONObject.put("icon_name", g.this.mSignActivityInfo.icon_name);
                                jSONObject.put("icon_lifecycle", g.this.mSignActivityInfo.icon_lifecycle);
                                jSONObject.put("activity_name", g.this.mSignActivityInfo.activity_name);
                                jSONObject.put("image_url", g.this.mSignActivityInfo.image_url);
                                com.baidu.tbadk.coreExtra.messageCenter.f.byi().BN(jSONObject.toString());
                            } catch (Exception e2) {
                            }
                        }
                        TbPageContext<?> tbPageContext2 = g.this.jcX.getTbPageContext();
                        TbWebViewActivityConfig tbWebViewActivityConfig2 = new TbWebViewActivityConfig(g.this.jcX.getActivity(), "", g.this.jES, false, true, true);
                        tbWebViewActivityConfig2.setPageTranslucent("open_full_screen_opacity_web_page");
                        tbPageContext2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig2));
                        q.bhH().bhR().bhW();
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002 && cBf != null) {
                        cBf.Ar(1);
                    }
                    g.this.jcX.showToast(signMessage.mSignErrorString);
                    return;
                }
                if (signMessage.signData != null) {
                    AntiHelper.a(g.this.jcX.getActivity(), signMessage.signData.blockPopInfoData, g.this.mInjectListener);
                } else {
                    AntiHelper.bs(g.this.jcX.getActivity(), signMessage.mSignErrorString);
                }
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).an("obj_locate", ax.a.LOCATE_SIGN));
            }
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.g.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).an("obj_locate", ax.a.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).an("obj_locate", ax.a.LOCATE_SIGN));
        }
    };
    private CustomMessageListener jEU = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.vc.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData cBN;
            int i;
            if (g.this.jcX != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (cBN = g.this.jcX.cBN()) != null && cBN.getForum() != null) {
                ForumData forum = cBN.getForum();
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = forum.getUser_level();
                if (signData.forumId != null && signData.forumId.equals(forum.getId())) {
                    cBN.updateSignData(signData);
                    h cBf = g.this.jcX.cBf();
                    boolean z = false;
                    if (cBf != null) {
                        cBf.l(cBN);
                        z = cBf.cKf();
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
    private String jEN = TbSingleton.getInstance().getWalletSignLink();

    public g(FrsFragment frsFragment, BdUniqueId bdUniqueId) {
        this.jcX = frsFragment;
        this.jEO = bdUniqueId;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.jEM = tBSpecificationBtn;
    }

    public void registerListener() {
        if (this.jcX != null) {
            this.jcX.registerListener(this.jET);
            this.jcX.registerListener(this.jEU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cJN() {
        return !TextUtils.isEmpty(this.jEN);
    }

    public void Am(int i) {
        if (this.jEM != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
            this.jEM.getLayoutParams().width = -2;
            this.jEM.setPadding(0, 0, 0, 0);
            TBSpecificationButtonConfig styleConfig = this.jEM.getStyleConfig();
            styleConfig.setIconSize(dimenPixelSize);
            if (i > 0) {
                this.jEM.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.miss_sign_days), Integer.valueOf(i)));
                styleConfig.a(R.drawable.icon_pure_frs_sign_add16, 0, TBSpecificationButtonConfig.IconType.WEBP);
            } else {
                this.jEM.setText(TbadkCoreApplication.getInst().getString(R.string.signed));
                styleConfig.a(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
            }
            this.jEM.setTextSize(R.dimen.T_X08);
            this.jEM.btV();
            this.jEM.setVisibility(0);
        }
    }

    public void rr(boolean z) {
        if (z) {
            cJQ();
        } else if (cJN()) {
            cJP();
        } else {
            cJO();
        }
    }

    private void cJO() {
        if (this.jEM != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
            this.jEM.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
            this.jEM.setPadding(0, 0, 0, 0);
            this.jEM.setTextSize(R.dimen.T_X08);
            this.jEM.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            TBSpecificationButtonConfig styleConfig = this.jEM.getStyleConfig();
            styleConfig.setIconSize(dimenPixelSize);
            styleConfig.a(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.jEM.btV();
        }
    }

    private void cJP() {
        if (this.jEM != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
            this.jEM.getLayoutParams().width = -2;
            this.jEM.setPadding(0, 0, 0, 0);
            this.jEM.setTextSize(R.dimen.T_X08);
            this.jEM.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            TBSpecificationButtonConfig styleConfig = this.jEM.getStyleConfig();
            styleConfig.setIconSize(dimenPixelSize);
            styleConfig.pL(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
            styleConfig.a(TBSpecificationButtonConfig.WebpType.MASK);
            styleConfig.a(R.drawable.icon_mask_frs_gold20, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.jEM.btV();
        }
    }

    private void cJQ() {
        if (this.jEM != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
            this.jEM.getLayoutParams().width = -2;
            this.jEM.setPadding(0, 0, 0, 0);
            this.jEM.setTextSize(R.dimen.T_X08);
            this.jEM.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            TBSpecificationButtonConfig styleConfig = this.jEM.getStyleConfig();
            styleConfig.setIconSize(dimenPixelSize);
            styleConfig.pL(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
            styleConfig.a(TBSpecificationButtonConfig.WebpType.MASK);
            styleConfig.a(R.drawable.icon_mask_frs_gift20, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.jEM.btV();
        }
    }

    public void rs(boolean z) {
        if (z && !this.jEQ) {
            aq.AM("c13560").an("obj_type", 1).bsu();
            this.jEQ = true;
        }
    }

    public float f(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.jEP = forumData.getLevelupScore();
        this.iWM = forumData.getCurScore();
        if (this.jEP > 0) {
            return this.iWM / this.jEP;
        }
        return 0.0f;
    }

    public void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.jEP - this.iWM) {
                z = true;
                this.jEP = signData.levelup_score;
            }
            this.iWM = i + this.iWM;
            if (this.iWM > this.jEP) {
                this.iWM = this.jEP;
            }
            if (this.jEP != 0) {
                f = this.iWM / this.jEP;
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
            bVar.AO(signData.is_signed);
            if (signData.sign_bonus_point > 0 && bVar.cLg()) {
                a(bVar, signData);
                forum.setCurScore(this.iWM);
                forum.setLevelupScore(this.jEP);
                bVar.a(forum, frsViewData);
            }
        }
    }

    public void a(SignActivityInfo signActivityInfo) {
        this.mSignActivityInfo = signActivityInfo;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void u(boolean z, String str) {
        this.jER = z;
        TbSingleton.getInstance().setActivityId(str);
        if (this.jcX != null) {
            FrsViewData cBN = this.jcX.cBN();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.jcX.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.jcX.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_SIGN)));
            } else if (cBN != null && cBN.getForum() != null) {
                ForumData forum = cBN.getForum();
                forum.setFromPage("frs");
                FrsActivityStatic.forumName = forum.getName() == null ? "" : forum.getName();
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, forum);
                customMessage.setTag(this.jEO);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    public void T(int i, int i2, int i3) {
        FrsViewData cBN;
        if (this.jcX != null && i > 0 && i2 > 0 && (cBN = this.jcX.cBN()) != null && cBN.getForum() != null && cBN.getSignData() != null) {
            ForumData forum = cBN.getForum();
            SignData signData = cBN.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            cBN.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            h cBf = this.jcX.cBf();
            boolean cKf = cBf != null ? cBf.cKf() : false;
            int i4 = -1;
            if (cKf) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }
}
