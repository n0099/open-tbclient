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
    private TBSpecificationBtn jJs;
    private BdUniqueId jJu;
    private int jJv;
    private boolean jJw;
    private boolean jJx;
    private int jbt;
    private FrsFragment jhE;
    private SignActivityInfo mSignActivityInfo;
    private String jJy = "https://tieba.baidu.com/mo/q/signActivityPage";
    private CustomMessageListener jJz = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.vc.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData cFE;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            int i;
            boolean z2;
            if (g.this.jhE != null && (customResponsedMessage instanceof SignMessage) && (cFE = g.this.jhE.cFE()) != null && cFE.getForum() != null && (name = (forum = cFE.getForum()).getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == g.this.jJu) {
                TiebaStatic.eventStat(g.this.jhE.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
                String name2 = forum.getName();
                SignMessage signMessage = (SignMessage) customResponsedMessage;
                if (!AntiHelper.bP(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                    h cEW = g.this.jhE.cEW();
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(forum.getId())) {
                            if (cEW != null) {
                                cEW.LK(name2);
                            }
                            cFE.updateSignData(signData2);
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
                        if (cEW != null ? cEW.cNW() : false) {
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
                        if (!z2 || !g.this.jJx) {
                            if (g.this.cNE() && signData.contDays > 0) {
                                com.baidu.tbadk.coreExtra.messageCenter.f.bCb().CZ(signData.userInfoJson);
                                TbPageContext<?> tbPageContext = g.this.jhE.getTbPageContext();
                                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(g.this.jhE.getActivity(), "", g.this.jJt, false, true, true);
                                tbWebViewActivityConfig.setPageTranslucent("open_full_screen_opacity_web_page");
                                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                                q.blA().blK().blP();
                                return;
                            }
                            com.baidu.tbadk.coreExtra.messageCenter.f.bCb().CZ(null);
                            if (cEW == null || cEW.cNT()) {
                                g.this.jhE.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                            } else {
                                g.this.jhE.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                            }
                            com.baidu.tieba.frs.q cEZ = g.this.jhE.cEZ();
                            if (cEZ != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.f.bCb().a(g.this.jhE.getTbPageContext(), cEZ.cqg());
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
                                com.baidu.tbadk.coreExtra.messageCenter.f.bCb().CZ(jSONObject.toString());
                            } catch (Exception e2) {
                            }
                        }
                        TbPageContext<?> tbPageContext2 = g.this.jhE.getTbPageContext();
                        TbWebViewActivityConfig tbWebViewActivityConfig2 = new TbWebViewActivityConfig(g.this.jhE.getActivity(), "", g.this.jJy, false, true, true);
                        tbWebViewActivityConfig2.setPageTranslucent("open_full_screen_opacity_web_page");
                        tbPageContext2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig2));
                        q.blA().blK().blP();
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002 && cEW != null) {
                        cEW.BX(1);
                    }
                    g.this.jhE.showToast(signMessage.mSignErrorString);
                    return;
                }
                if (signMessage.signData != null) {
                    AntiHelper.a(g.this.jhE.getActivity(), signMessage.signData.blockPopInfoData, g.this.mInjectListener);
                } else {
                    AntiHelper.bs(g.this.jhE.getActivity(), signMessage.mSignErrorString);
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
    private CustomMessageListener jJA = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.vc.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData cFE;
            int i;
            if (g.this.jhE != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (cFE = g.this.jhE.cFE()) != null && cFE.getForum() != null) {
                ForumData forum = cFE.getForum();
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = forum.getUser_level();
                if (signData.forumId != null && signData.forumId.equals(forum.getId())) {
                    cFE.updateSignData(signData);
                    h cEW = g.this.jhE.cEW();
                    boolean z = false;
                    if (cEW != null) {
                        cEW.l(cFE);
                        z = cEW.cNW();
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
    private String jJt = TbSingleton.getInstance().getWalletSignLink();

    public g(FrsFragment frsFragment, BdUniqueId bdUniqueId) {
        this.jhE = frsFragment;
        this.jJu = bdUniqueId;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.jJs = tBSpecificationBtn;
    }

    public void registerListener() {
        if (this.jhE != null) {
            this.jhE.registerListener(this.jJz);
            this.jhE.registerListener(this.jJA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cNE() {
        return !TextUtils.isEmpty(this.jJt);
    }

    public void BS(int i) {
        if (this.jJs != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
            this.jJs.getLayoutParams().width = -2;
            this.jJs.setPadding(0, 0, 0, 0);
            TBSpecificationButtonConfig styleConfig = this.jJs.getStyleConfig();
            styleConfig.setIconSize(dimenPixelSize);
            if (i > 0) {
                this.jJs.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.miss_sign_days), Integer.valueOf(i)));
                styleConfig.a(R.drawable.icon_pure_frs_sign_add16, 0, TBSpecificationButtonConfig.IconType.WEBP);
            } else {
                this.jJs.setText(TbadkCoreApplication.getInst().getString(R.string.signed));
                styleConfig.a(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
            }
            this.jJs.setTextSize(R.dimen.T_X08);
            this.jJs.bxO();
            this.jJs.setVisibility(0);
        }
    }

    public void rv(boolean z) {
        if (z) {
            cNH();
        } else if (cNE()) {
            cNG();
        } else {
            cNF();
        }
    }

    private void cNF() {
        if (this.jJs != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
            this.jJs.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
            this.jJs.setPadding(0, 0, 0, 0);
            this.jJs.setTextSize(R.dimen.T_X08);
            this.jJs.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            TBSpecificationButtonConfig styleConfig = this.jJs.getStyleConfig();
            styleConfig.setIconSize(dimenPixelSize);
            styleConfig.a(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.jJs.bxO();
        }
    }

    private void cNG() {
        if (this.jJs != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
            this.jJs.getLayoutParams().width = -2;
            this.jJs.setPadding(0, 0, 0, 0);
            this.jJs.setTextSize(R.dimen.T_X08);
            this.jJs.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            TBSpecificationButtonConfig styleConfig = this.jJs.getStyleConfig();
            styleConfig.setIconSize(dimenPixelSize);
            styleConfig.rr(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
            styleConfig.a(TBSpecificationButtonConfig.WebpType.MASK);
            styleConfig.a(R.drawable.icon_mask_frs_gold20, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.jJs.bxO();
        }
    }

    private void cNH() {
        if (this.jJs != null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
            this.jJs.getLayoutParams().width = -2;
            this.jJs.setPadding(0, 0, 0, 0);
            this.jJs.setTextSize(R.dimen.T_X08);
            this.jJs.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
            TBSpecificationButtonConfig styleConfig = this.jJs.getStyleConfig();
            styleConfig.setIconSize(dimenPixelSize);
            styleConfig.rr(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
            styleConfig.a(TBSpecificationButtonConfig.WebpType.MASK);
            styleConfig.a(R.drawable.icon_mask_frs_gift20, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.jJs.bxO();
        }
    }

    public void rw(boolean z) {
        if (z && !this.jJw) {
            aq.BY("c13560").an("obj_type", 1).bwn();
            this.jJw = true;
        }
    }

    public float f(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.jJv = forumData.getLevelupScore();
        this.jbt = forumData.getCurScore();
        if (this.jJv > 0) {
            return this.jbt / this.jJv;
        }
        return 0.0f;
    }

    public void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.jJv - this.jbt) {
                z = true;
                this.jJv = signData.levelup_score;
            }
            this.jbt = i + this.jbt;
            if (this.jbt > this.jJv) {
                this.jbt = this.jJv;
            }
            if (this.jJv != 0) {
                f = this.jbt / this.jJv;
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
            bVar.Cu(signData.is_signed);
            if (signData.sign_bonus_point > 0 && bVar.cOX()) {
                a(bVar, signData);
                forum.setCurScore(this.jbt);
                forum.setLevelupScore(this.jJv);
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
        this.jJx = z;
        TbSingleton.getInstance().setActivityId(str);
        if (this.jhE != null) {
            FrsViewData cFE = this.jhE.cFE();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.jhE.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.jhE.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_SIGN)));
            } else if (cFE != null && cFE.getForum() != null) {
                ForumData forum = cFE.getForum();
                forum.setFromPage("frs");
                FrsActivityStatic.forumName = forum.getName() == null ? "" : forum.getName();
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, forum);
                customMessage.setTag(this.jJu);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    public void T(int i, int i2, int i3) {
        FrsViewData cFE;
        if (this.jhE != null && i > 0 && i2 > 0 && (cFE = this.jhE.cFE()) != null && cFE.getForum() != null && cFE.getSignData() != null) {
            ForumData forum = cFE.getForum();
            SignData signData = cFE.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            cFE.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            h cEW = this.jhE.cEW();
            boolean cNW = cEW != null ? cEW.cNW() : false;
            int i4 = -1;
            if (cNW) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }
}
