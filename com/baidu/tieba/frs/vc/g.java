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
import com.baidu.live.tbadk.ubc.UbcStatConstant;
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
import org.json.JSONObject;
import tbclient.SignActivityInfo;
/* loaded from: classes2.dex */
public class g {
    private TBSpecificationBtn jMn;
    private BdUniqueId jMp;
    private int jMq;
    private boolean jMr;
    private boolean jMs;
    private int jeq;
    private FrsFragment jkB;
    private SignActivityInfo mSignActivityInfo;
    private String jMt = "https://tieba.baidu.com/mo/q/signActivityPage";
    private CustomMessageListener jMu = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.vc.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData cDm;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            int i;
            boolean z2;
            if (g.this.jkB != null && (customResponsedMessage instanceof SignMessage) && (cDm = g.this.jkB.cDm()) != null && cDm.getForum() != null && (name = (forum = cDm.getForum()).getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == g.this.jMp) {
                TiebaStatic.eventStat(g.this.jkB.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
                String name2 = forum.getName();
                SignMessage signMessage = (SignMessage) customResponsedMessage;
                if (!AntiHelper.bX(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                    h cCE = g.this.jkB.cCE();
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(forum.getId())) {
                            if (cCE != null) {
                                cCE.Lu(name2);
                            }
                            cDm.updateSignData(signData2);
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
                        if (cCE != null ? cCE.cLG() : false) {
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
                        if (!z2 || !g.this.jMs) {
                            if (g.this.cLo() && signData.contDays > 0) {
                                com.baidu.tbadk.coreExtra.messageCenter.f.byD().Cl(signData.userInfoJson);
                                TbPageContext<?> tbPageContext = g.this.jkB.getTbPageContext();
                                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(g.this.jkB.getActivity(), "", g.this.jMo, false, true, true);
                                tbWebViewActivityConfig.setPageTranslucent("open_full_screen_opacity_web_page");
                                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                                q.bhW().big().bil();
                                return;
                            }
                            com.baidu.tbadk.coreExtra.messageCenter.f.byD().Cl(null);
                            if (cCE == null || cCE.cLD()) {
                                g.this.jkB.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                            } else {
                                g.this.jkB.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                            }
                            com.baidu.tieba.frs.q cCH = g.this.jkB.cCH();
                            if (cCH != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.f.byD().a(g.this.jkB.getTbPageContext(), cCH.cnA());
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
                                jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_ACTIVITY_NAME, g.this.mSignActivityInfo.activity_name);
                                jSONObject.put("image_url", g.this.mSignActivityInfo.image_url);
                                com.baidu.tbadk.coreExtra.messageCenter.f.byD().Cl(jSONObject.toString());
                            } catch (Exception e2) {
                            }
                        }
                        TbPageContext<?> tbPageContext2 = g.this.jkB.getTbPageContext();
                        TbWebViewActivityConfig tbWebViewActivityConfig2 = new TbWebViewActivityConfig(g.this.jkB.getActivity(), "", g.this.jMt, false, true, true);
                        tbWebViewActivityConfig2.setPageTranslucent("open_full_screen_opacity_web_page");
                        tbPageContext2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig2));
                        q.bhW().big().bil();
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002 && cCE != null) {
                        cCE.AC(1);
                    }
                    g.this.jkB.showToast(signMessage.mSignErrorString);
                    return;
                }
                if (signMessage.signData != null) {
                    AntiHelper.a(g.this.jkB.getActivity(), signMessage.signData.blockPopInfoData, g.this.mInjectListener);
                } else {
                    AntiHelper.bq(g.this.jkB.getActivity(), signMessage.mSignErrorString);
                }
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aq("obj_locate", ay.a.LOCATE_SIGN));
            }
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.g.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aq("obj_locate", ay.a.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aq("obj_locate", ay.a.LOCATE_SIGN));
        }
    };
    private CustomMessageListener jMv = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.vc.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData cDm;
            int i;
            if (g.this.jkB != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (cDm = g.this.jkB.cDm()) != null && cDm.getForum() != null) {
                ForumData forum = cDm.getForum();
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = forum.getUser_level();
                if (signData.forumId != null && signData.forumId.equals(forum.getId())) {
                    cDm.updateSignData(signData);
                    h cCE = g.this.jkB.cCE();
                    boolean z = false;
                    if (cCE != null) {
                        cCE.l(cDm);
                        z = cCE.cLG();
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
    private String jMo = TbSingleton.getInstance().getWalletSignLink();

    public g(FrsFragment frsFragment, BdUniqueId bdUniqueId) {
        this.jkB = frsFragment;
        this.jMp = bdUniqueId;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.jMn = tBSpecificationBtn;
    }

    public void registerListener() {
        if (this.jkB != null) {
            this.jkB.registerListener(this.jMu);
            this.jkB.registerListener(this.jMv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cLo() {
        return !TextUtils.isEmpty(this.jMo);
    }

    public void Ax(int i) {
        if (this.jMn != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
            this.jMn.getLayoutParams().width = -2;
            this.jMn.setPadding(0, 0, 0, 0);
            TBSpecificationButtonConfig styleConfig = this.jMn.getStyleConfig();
            styleConfig.setIconSize(dimenPixelSize);
            if (i > 0) {
                this.jMn.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.miss_sign_days), Integer.valueOf(i)));
                styleConfig.a(R.drawable.icon_pure_frs_sign_add16, 0, TBSpecificationButtonConfig.IconType.WEBP);
            } else {
                this.jMn.setText(TbadkCoreApplication.getInst().getString(R.string.signed));
                styleConfig.a(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
            }
            this.jMn.setTextSize(R.dimen.T_X08);
            this.jMn.bus();
            this.jMn.setVisibility(0);
        }
    }

    public void rB(boolean z) {
        if (z) {
            cLr();
        } else if (cLo()) {
            cLq();
        } else {
            cLp();
        }
    }

    private void cLp() {
        if (this.jMn != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
            this.jMn.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
            this.jMn.setPadding(0, 0, 0, 0);
            this.jMn.setTextSize(R.dimen.T_X08);
            this.jMn.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            TBSpecificationButtonConfig styleConfig = this.jMn.getStyleConfig();
            styleConfig.setIconSize(dimenPixelSize);
            styleConfig.a(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.jMn.bus();
        }
    }

    private void cLq() {
        if (this.jMn != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
            this.jMn.getLayoutParams().width = -2;
            this.jMn.setPadding(0, 0, 0, 0);
            this.jMn.setTextSize(R.dimen.T_X08);
            this.jMn.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            TBSpecificationButtonConfig styleConfig = this.jMn.getStyleConfig();
            styleConfig.setIconSize(dimenPixelSize);
            styleConfig.pR(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
            styleConfig.a(TBSpecificationButtonConfig.WebpType.MASK);
            styleConfig.a(R.drawable.icon_mask_frs_gold20, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.jMn.bus();
        }
    }

    private void cLr() {
        if (this.jMn != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
            this.jMn.getLayoutParams().width = -2;
            this.jMn.setPadding(0, 0, 0, 0);
            this.jMn.setTextSize(R.dimen.T_X08);
            this.jMn.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            TBSpecificationButtonConfig styleConfig = this.jMn.getStyleConfig();
            styleConfig.setIconSize(dimenPixelSize);
            styleConfig.pR(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
            styleConfig.a(TBSpecificationButtonConfig.WebpType.MASK);
            styleConfig.a(R.drawable.icon_mask_frs_gift20, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.jMn.bus();
        }
    }

    public void rC(boolean z) {
        if (z && !this.jMr) {
            ar.Bk("c13560").aq("obj_type", 1).bsR();
            this.jMr = true;
        }
    }

    public float f(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.jMq = forumData.getLevelupScore();
        this.jeq = forumData.getCurScore();
        if (this.jMq > 0) {
            return this.jeq / this.jMq;
        }
        return 0.0f;
    }

    public void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.jMq - this.jeq) {
                z = true;
                this.jMq = signData.levelup_score;
            }
            this.jeq = i + this.jeq;
            if (this.jeq > this.jMq) {
                this.jeq = this.jMq;
            }
            if (this.jMq != 0) {
                f = this.jeq / this.jMq;
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
            bVar.Be(signData.is_signed);
            if (signData.sign_bonus_point > 0 && bVar.cNi()) {
                a(bVar, signData);
                forum.setCurScore(this.jeq);
                forum.setLevelupScore(this.jMq);
                bVar.a(forum, frsViewData);
            }
        }
    }

    public void a(SignActivityInfo signActivityInfo) {
        this.mSignActivityInfo = signActivityInfo;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void B(boolean z, String str) {
        this.jMs = z;
        TbSingleton.getInstance().setActivityId(str);
        if (this.jkB != null) {
            FrsViewData cDm = this.jkB.cDm();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.jkB.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.jkB.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_SIGN)));
            } else if (cDm != null && cDm.getForum() != null) {
                ForumData forum = cDm.getForum();
                forum.setFromPage("frs");
                FrsActivityStatic.forumName = forum.getName() == null ? "" : forum.getName();
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, forum);
                customMessage.setTag(this.jMp);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    public void T(int i, int i2, int i3) {
        FrsViewData cDm;
        if (this.jkB != null && i > 0 && i2 > 0 && (cDm = this.jkB.cDm()) != null && cDm.getForum() != null && cDm.getSignData() != null) {
            ForumData forum = cDm.getForum();
            SignData signData = cDm.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            cDm.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            h cCE = this.jkB.cCE();
            boolean cLG = cCE != null ? cCE.cLG() : false;
            int i4 = -1;
            if (cLG) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }
}
