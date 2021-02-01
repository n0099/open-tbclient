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
    private TBSpecificationBtn jKq;
    private BdUniqueId jKs;
    private int jKt;
    private boolean jKu;
    private boolean jKv;
    private int jct;
    private FrsFragment jiE;
    private SignActivityInfo mSignActivityInfo;
    private String jKw = "https://tieba.baidu.com/mo/q/signActivityPage";
    private CustomMessageListener jKx = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.vc.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData cCZ;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            int i;
            boolean z2;
            if (g.this.jiE != null && (customResponsedMessage instanceof SignMessage) && (cCZ = g.this.jiE.cCZ()) != null && cCZ.getForum() != null && (name = (forum = cCZ.getForum()).getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == g.this.jKs) {
                TiebaStatic.eventStat(g.this.jiE.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
                String name2 = forum.getName();
                SignMessage signMessage = (SignMessage) customResponsedMessage;
                if (!AntiHelper.bX(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                    h cCr = g.this.jiE.cCr();
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(forum.getId())) {
                            if (cCr != null) {
                                cCr.Lk(name2);
                            }
                            cCZ.updateSignData(signData2);
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
                        if (cCr != null ? cCr.cLt() : false) {
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
                        if (!z2 || !g.this.jKv) {
                            if (g.this.cLb() && signData.contDays > 0) {
                                com.baidu.tbadk.coreExtra.messageCenter.f.byA().Ce(signData.userInfoJson);
                                TbPageContext<?> tbPageContext = g.this.jiE.getTbPageContext();
                                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(g.this.jiE.getActivity(), "", g.this.jKr, false, true, true);
                                tbWebViewActivityConfig.setPageTranslucent("open_full_screen_opacity_web_page");
                                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                                q.bhU().bie().bij();
                                return;
                            }
                            com.baidu.tbadk.coreExtra.messageCenter.f.byA().Ce(null);
                            if (cCr == null || cCr.cLq()) {
                                g.this.jiE.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                            } else {
                                g.this.jiE.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                            }
                            com.baidu.tieba.frs.q cCu = g.this.jiE.cCu();
                            if (cCu != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.f.byA().a(g.this.jiE.getTbPageContext(), cCu.cnn());
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
                                com.baidu.tbadk.coreExtra.messageCenter.f.byA().Ce(jSONObject.toString());
                            } catch (Exception e2) {
                            }
                        }
                        TbPageContext<?> tbPageContext2 = g.this.jiE.getTbPageContext();
                        TbWebViewActivityConfig tbWebViewActivityConfig2 = new TbWebViewActivityConfig(g.this.jiE.getActivity(), "", g.this.jKw, false, true, true);
                        tbWebViewActivityConfig2.setPageTranslucent("open_full_screen_opacity_web_page");
                        tbPageContext2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig2));
                        q.bhU().bie().bij();
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002 && cCr != null) {
                        cCr.AB(1);
                    }
                    g.this.jiE.showToast(signMessage.mSignErrorString);
                    return;
                }
                if (signMessage.signData != null) {
                    AntiHelper.a(g.this.jiE.getActivity(), signMessage.signData.blockPopInfoData, g.this.mInjectListener);
                } else {
                    AntiHelper.br(g.this.jiE.getActivity(), signMessage.mSignErrorString);
                }
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ap("obj_locate", ay.a.LOCATE_SIGN));
            }
        }
    };
    private AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.g.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ap("obj_locate", ay.a.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ap("obj_locate", ay.a.LOCATE_SIGN));
        }
    };
    private CustomMessageListener jKy = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.vc.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData cCZ;
            int i;
            if (g.this.jiE != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (cCZ = g.this.jiE.cCZ()) != null && cCZ.getForum() != null) {
                ForumData forum = cCZ.getForum();
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = forum.getUser_level();
                if (signData.forumId != null && signData.forumId.equals(forum.getId())) {
                    cCZ.updateSignData(signData);
                    h cCr = g.this.jiE.cCr();
                    boolean z = false;
                    if (cCr != null) {
                        cCr.l(cCZ);
                        z = cCr.cLt();
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
    private String jKr = TbSingleton.getInstance().getWalletSignLink();

    public g(FrsFragment frsFragment, BdUniqueId bdUniqueId) {
        this.jiE = frsFragment;
        this.jKs = bdUniqueId;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.jKq = tBSpecificationBtn;
    }

    public void registerListener() {
        if (this.jiE != null) {
            this.jiE.registerListener(this.jKx);
            this.jiE.registerListener(this.jKy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cLb() {
        return !TextUtils.isEmpty(this.jKr);
    }

    public void Aw(int i) {
        if (this.jKq != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
            this.jKq.getLayoutParams().width = -2;
            this.jKq.setPadding(0, 0, 0, 0);
            TBSpecificationButtonConfig styleConfig = this.jKq.getStyleConfig();
            styleConfig.setIconSize(dimenPixelSize);
            if (i > 0) {
                this.jKq.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.miss_sign_days), Integer.valueOf(i)));
                styleConfig.a(R.drawable.icon_pure_frs_sign_add16, 0, TBSpecificationButtonConfig.IconType.WEBP);
            } else {
                this.jKq.setText(TbadkCoreApplication.getInst().getString(R.string.signed));
                styleConfig.a(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
            }
            this.jKq.setTextSize(R.dimen.T_X08);
            this.jKq.bup();
            this.jKq.setVisibility(0);
        }
    }

    public void rB(boolean z) {
        if (z) {
            cLe();
        } else if (cLb()) {
            cLd();
        } else {
            cLc();
        }
    }

    private void cLc() {
        if (this.jKq != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
            this.jKq.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
            this.jKq.setPadding(0, 0, 0, 0);
            this.jKq.setTextSize(R.dimen.T_X08);
            this.jKq.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            TBSpecificationButtonConfig styleConfig = this.jKq.getStyleConfig();
            styleConfig.setIconSize(dimenPixelSize);
            styleConfig.a(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.jKq.bup();
        }
    }

    private void cLd() {
        if (this.jKq != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
            this.jKq.getLayoutParams().width = -2;
            this.jKq.setPadding(0, 0, 0, 0);
            this.jKq.setTextSize(R.dimen.T_X08);
            this.jKq.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            TBSpecificationButtonConfig styleConfig = this.jKq.getStyleConfig();
            styleConfig.setIconSize(dimenPixelSize);
            styleConfig.pQ(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
            styleConfig.a(TBSpecificationButtonConfig.WebpType.MASK);
            styleConfig.a(R.drawable.icon_mask_frs_gold20, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.jKq.bup();
        }
    }

    private void cLe() {
        if (this.jKq != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
            this.jKq.getLayoutParams().width = -2;
            this.jKq.setPadding(0, 0, 0, 0);
            this.jKq.setTextSize(R.dimen.T_X08);
            this.jKq.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            TBSpecificationButtonConfig styleConfig = this.jKq.getStyleConfig();
            styleConfig.setIconSize(dimenPixelSize);
            styleConfig.pQ(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
            styleConfig.a(TBSpecificationButtonConfig.WebpType.MASK);
            styleConfig.a(R.drawable.icon_mask_frs_gift20, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.jKq.bup();
        }
    }

    public void rC(boolean z) {
        if (z && !this.jKu) {
            ar.Bd("c13560").ap("obj_type", 1).bsO();
            this.jKu = true;
        }
    }

    public float f(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.jKt = forumData.getLevelupScore();
        this.jct = forumData.getCurScore();
        if (this.jKt > 0) {
            return this.jct / this.jKt;
        }
        return 0.0f;
    }

    public void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.jKt - this.jct) {
                z = true;
                this.jKt = signData.levelup_score;
            }
            this.jct = i + this.jct;
            if (this.jct > this.jKt) {
                this.jct = this.jKt;
            }
            if (this.jKt != 0) {
                f = this.jct / this.jKt;
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
            bVar.Bd(signData.is_signed);
            if (signData.sign_bonus_point > 0 && bVar.cMV()) {
                a(bVar, signData);
                forum.setCurScore(this.jct);
                forum.setLevelupScore(this.jKt);
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
        this.jKv = z;
        TbSingleton.getInstance().setActivityId(str);
        if (this.jiE != null) {
            FrsViewData cCZ = this.jiE.cCZ();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.jiE.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.jiE.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_SIGN)));
            } else if (cCZ != null && cCZ.getForum() != null) {
                ForumData forum = cCZ.getForum();
                forum.setFromPage("frs");
                FrsActivityStatic.forumName = forum.getName() == null ? "" : forum.getName();
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, forum);
                customMessage.setTag(this.jKs);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    public void T(int i, int i2, int i3) {
        FrsViewData cCZ;
        if (this.jiE != null && i > 0 && i2 > 0 && (cCZ = this.jiE.cCZ()) != null && cCZ.getForum() != null && cCZ.getSignData() != null) {
            ForumData forum = cCZ.getForum();
            SignData signData = cCZ.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            cCZ.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            h cCr = this.jiE.cCr();
            boolean cLt = cCr != null ? cCr.cLt() : false;
            int i4 = -1;
            if (cLt) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }
}
