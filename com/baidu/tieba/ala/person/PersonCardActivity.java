package com.baidu.tieba.ala.person;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.animation.Animation;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.b.u;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.am;
import com.baidu.live.data.e;
import com.baidu.live.personmanager.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveTagActivityConfig;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.i;
import com.baidu.megapp.ma.Util;
import com.baidu.tieba.ala.person.a.c;
import com.baidu.tieba.ala.person.c.a;
import com.baidu.tieba.ala.person.view.PersonCardViewNew;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PersonCardActivity extends BaseFragmentActivity {
    private boolean aFD;
    private String aVl;
    private String appId;
    private PersonUserData gSA;
    private com.baidu.tieba.ala.person.c.a gSB;
    private b gSC;
    private c gSD;
    private c gSE;
    private boolean gSF;
    private boolean gSH;
    private boolean gSI;
    private PersonCardViewNew gSx;
    private PersonCardViewNew gSy;
    private String gSz;
    private String groupId;
    private String liveId;
    private String metaKey;
    private String otherParams;
    private String portrait;
    private String userId;
    private String vid;
    private boolean gSG = false;
    CustomMessageListener fTe = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                PersonCardActivity.this.otherParams = str;
                if (PersonCardActivity.this.gSx != null) {
                    PersonCardActivity.this.gSx.setOtherParams(PersonCardActivity.this.otherParams);
                }
                if (PersonCardActivity.this.gSy != null) {
                    PersonCardActivity.this.gSy.setOtherParams(PersonCardActivity.this.otherParams);
                }
            }
        }
    };
    private CustomMessageListener fSS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(PersonCardActivity.this.userId)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (PersonCardActivity.this.gSB != null) {
                            PersonCardActivity.this.gSB.el(PersonCardActivity.this.userId, PersonCardActivity.this.metaKey);
                        }
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && message.getTag().equals(PersonCardActivity.this.getUniqueId())) {
                            if (updateAttentionMessage.getData().isAttention) {
                                if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
                                    PersonCardActivity.this.showToast(PersonCardActivity.this.getResources().getString(a.i.sdk_attention_success_toast));
                                    PersonCardActivity.this.finish();
                                } else {
                                    PersonCardActivity.this.showToast(PersonCardActivity.this.getResources().getString(a.i.sdk_attention_success_toast));
                                }
                                if (PersonCardActivity.this.aVl != null && PersonCardActivity.this.aVl.equals(updateAttentionMessage.getData().toUid)) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
                                    return;
                                }
                                return;
                            }
                            PersonCardActivity.this.showToast(PersonCardActivity.this.getResources().getString(a.i.sdk_unfollow_success_toast));
                            return;
                        }
                        return;
                    }
                    if (!updateAttentionMessage.isAttention()) {
                        PersonCardActivity.this.gSx.vh(0);
                        PersonCardActivity.this.gSy.vh(0);
                    } else {
                        PersonCardActivity.this.gSx.vh(1);
                        PersonCardActivity.this.gSy.vh(1);
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(PersonCardActivity.this.getUniqueId()) && !com.baidu.live.view.a.Rg().a(updateAttentionMessage.getData(), (BdPageContext<?>) PersonCardActivity.this.getPageContext(), false) && updateAttentionMessage.getData().errorString != null) {
                        PersonCardActivity.this.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    CustomMessageListener aPU = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener gSJ = new CustomMessageListener(2913186) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener gSK = new CustomMessageListener(2913203) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.j(PersonCardActivity.this.userId, PersonCardActivity.this.aVl, PersonCardActivity.this.groupId, "", PersonCardActivity.this.gSz);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (!isFinishing()) {
            String str = Build.DISPLAY;
            if (str != null && str.contains("Flyme")) {
                getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.d.sdk_transparent)));
            }
            bZW();
            initView();
            this.gSx.a(this.gSA, true);
            this.gSy.a(this.gSA, true);
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                setContentView(this.gSy.getRootView());
            } else {
                setContentView(this.gSx.getRootView());
            }
            initListener();
            HI();
            if (!bZX()) {
                j(this.userId, this.aVl, this.groupId, "", this.gSz);
            }
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                i.aa(this.gSy.getRootView());
            } else {
                i.ab(this.gSx.getRootView());
            }
            TiebaInitialize.log("c11899");
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.gSG) {
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                this.gSx.getRootView().setVisibility(8);
                this.gSy.getRootView().setVisibility(0);
                setContentView(this.gSy.getRootView());
                i.aa(this.gSy.getRootView());
            } else {
                this.gSy.getRootView().setVisibility(8);
                this.gSx.getRootView().setVisibility(0);
                setContentView(this.gSx.getRootView());
                i.ab(this.gSx.getRootView());
            }
            this.gSx.bbL();
            this.gSy.bbL();
        }
    }

    private void bZW() {
        this.userId = getIntent().getStringExtra("PERSON_USER_ID");
        this.portrait = getIntent().getStringExtra("PERSON_PORTRAIT_URL");
        this.gSz = getIntent().getStringExtra(AlaPersonCardActivityConfig.PERSON_SHOW_NAME);
        this.groupId = getIntent().getStringExtra("PERSON_GROUP_ID");
        this.liveId = getIntent().getStringExtra("PERSON_LIVE_ID");
        this.vid = getIntent().getStringExtra("vid");
        this.aVl = getIntent().getStringExtra("PERSON_LIVE_OWNER_UID");
        this.aFD = getIntent().getBooleanExtra("PERSON_LIVE_OWNER_FLAG", false);
        this.appId = getIntent().getStringExtra("PERSON_APP_ID");
        this.otherParams = getIntent().getStringExtra("other_params");
        this.gSH = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_IS_FROM_GUARD_CLUB, false);
        this.gSI = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_NAV_LIVEROOM_ENABLED, false);
        String stringExtra = getIntent().getStringExtra("PERSON_USER_NAME");
        String stringExtra2 = getIntent().getStringExtra("PERSON_PORTRAIT_URL");
        int intExtra = getIntent().getIntExtra("PERSON_SEX", 0);
        int intExtra2 = getIntent().getIntExtra("PERSON_LEVEL", 1);
        String stringExtra3 = getIntent().getStringExtra("PERSON_LOCATION");
        String stringExtra4 = getIntent().getStringExtra("PERSON_DESCRIPTION");
        long longExtra = getIntent().getLongExtra("PERSON_SEND_COUNT", 0L);
        long longExtra2 = getIntent().getLongExtra("PERSON_FANS_COUNT", 0L);
        long longExtra3 = getIntent().getLongExtra("PERSON_FOLLOWS_COUNT", 0L);
        getIntent().getIntExtra("PERSON_FOLLOW_STATUS", 0);
        this.gSA = new PersonUserData();
        this.gSA.user_info = new am();
        this.gSA.location_info = new AlaLocationData();
        this.gSA.relation_info = new AlaRelationData();
        this.gSA.user_info.user_id = this.userId;
        this.gSA.user_info.user_name = stringExtra;
        this.gSA.user_info.user_nickname = this.gSz;
        this.gSA.user_info.sex = intExtra;
        this.gSA.user_info.level_id = intExtra2;
        this.gSA.user_info.description = stringExtra4;
        this.gSA.user_info.send_count = longExtra;
        this.gSA.user_info.fans_count = longExtra2;
        this.gSA.user_info.follow_count = longExtra3;
        this.gSA.user_info.portrait = stringExtra2;
        this.gSA.user_info.third_app_id = this.appId;
        this.gSA.location_info.location = stringExtra3;
    }

    private void initView() {
        if (this.gSI && TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gSI = com.baidu.live.x.a.NN().bhy.aId;
        }
        this.gSx = new PersonCardViewNew(this, false);
        this.gSx.em(this.liveId, this.aVl);
        this.gSx.setOtherParams(this.otherParams);
        this.gSx.mT(this.gSH);
        this.gSx.mU(this.gSI);
        this.gSy = new PersonCardViewNew(this, true);
        this.gSy.em(this.liveId, this.aVl);
        this.gSy.setOtherParams(this.otherParams);
        this.gSy.mT(this.gSH);
        this.gSy.mU(this.gSI);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            this.gSx.getRootView().setVisibility(8);
            this.gSy.getRootView().setVisibility(0);
        } else {
            this.gSy.getRootView().setVisibility(8);
            this.gSx.getRootView().setVisibility(0);
        }
        this.gSx.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.1
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cad() {
                PersonCardActivity.this.cac();
            }

            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cae() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("live_id", PersonCardActivity.this.liveId);
                    jSONObject.put("vid", PersonCardActivity.this.vid == null ? "" : PersonCardActivity.this.vid);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "add_ impression").setContentExt("authorcard", "", jSONObject));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTagActivityConfig(PersonCardActivity.this.getPageContext().getPageActivity(), PersonCardActivity.this.aVl, PersonCardActivity.this.liveId)));
            }
        });
        this.gSy.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.3
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cad() {
                PersonCardActivity.this.cac();
            }

            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cae() {
            }
        });
    }

    private void initListener() {
        registerListener(this.aPU);
        registerListener(this.fSS);
        registerListener(this.fTe);
        registerListener(this.gSJ);
        registerListener(this.gSK);
    }

    private void HI() {
        this.gSB = new com.baidu.tieba.ala.person.c.a(getPageContext());
        this.gSB.a(new a.InterfaceC0647a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.4
            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0647a
            public void c(PersonUserData personUserData) {
                if (personUserData != null) {
                    if (personUserData.user_info != null) {
                        PersonCardActivity.this.userId = personUserData.user_info.user_id;
                        PersonCardActivity.this.portrait = personUserData.user_info.portrait;
                        PersonCardActivity.this.metaKey = personUserData.user_info.aJp;
                    }
                    PersonCardActivity.this.gSx.a(personUserData, false);
                    PersonCardActivity.this.gSy.a(personUserData, false);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0647a
            public void a(c cVar) {
                PersonCardActivity.this.gSD = cVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0647a
            public void b(c cVar) {
                PersonCardActivity.this.gSE = cVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0647a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
        this.gSC = new b(getPageContext());
        this.gSC.a(new b.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.5
            @Override // com.baidu.live.personmanager.b.a
            public void MI() {
                PersonCardActivity.this.showToast(a.i.ala_person_report_online_success);
            }

            @Override // com.baidu.live.personmanager.b.a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
    }

    public void j(String str, String str2, String str3, String str4, String str5) {
        this.gSD = null;
        this.gSE = null;
        this.gSB.k(str, str2, str3, str4, str5);
    }

    public boolean bZX() {
        return (TextUtils.isEmpty(this.appId) || this.userId == null || this.userId.equals(this.aVl)) ? false : true;
    }

    public boolean GY(String str) {
        return (TextUtils.isEmpty(this.aVl) || TextUtils.isEmpty(str) || !str.equals(this.aVl)) ? false : true;
    }

    public String bZY() {
        return this.aVl;
    }

    public void mQ(boolean z) {
        this.gSx.mS(z);
        this.gSy.mS(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gSF = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.gSF) {
            this.gSx.onResume();
            this.gSy.onResume();
        }
        this.gSF = false;
    }

    public void b(PersonUserData personUserData) {
        this.gSx.a(personUserData, false);
        this.gSy.a(personUserData, false);
        this.userId = personUserData.user_info.user_id;
        this.portrait = personUserData.user_info.portrait;
        this.metaKey = personUserData.user_info.aJp;
        this.gSz = personUserData.user_info.getNameShow();
        j(this.userId, this.aVl, this.groupId, this.metaKey, this.gSz);
    }

    public void bZZ() {
        e eVar = new e(this.portrait, this.userId, this.metaKey, "1", true, getUniqueId());
        eVar.setFrom("source_person_card");
        com.baidu.live.view.a.Rg().a(this.userId, eVar);
    }

    public void caa() {
        e eVar = new e(this.portrait, this.userId, this.metaKey, "1", false, getUniqueId());
        eVar.setFrom("source_person_card");
        com.baidu.live.view.a.Rg().a(this.userId, eVar);
    }

    public void cab() {
        this.gSC.az(this.userId, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cac() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new u(this, this.userId, this.groupId, this.liveId, this.aFD, this.aVl, this.otherParams)));
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            if (this instanceof Activity) {
                overridePendingTransition(a.C0186a.alpha_in, 0);
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
                overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_bottom", ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_out_to_bottom", ResUtils.ANIM));
            } else {
                overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "sdk_fade_in", ResUtils.ANIM), 0);
            }
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gSB != null) {
            this.gSB.onDestroy();
        }
        if (this.gSx != null) {
            this.gSx.onDestroy();
        }
        if (this.gSy != null) {
            this.gSy.onDestroy();
        }
        if (this.gSJ != null) {
            MessageManager.getInstance().unRegisterListener(this.gSJ);
        }
        if (this.gSK != null) {
            MessageManager.getInstance().unRegisterListener(this.gSK);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (!this.gSG) {
            this.gSG = true;
            if (this.gSC != null) {
                this.gSC.onDestroy();
            }
            Animation animation = null;
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                if (this.gSy != null) {
                    animation = this.gSy.bMq();
                }
            } else if (this.gSx != null) {
                animation = this.gSx.bMq();
            }
            if (animation == null) {
                super.finish();
            } else {
                animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        PersonCardActivity.super.finish();
                        if (PersonCardActivity.this instanceof Activity) {
                            PersonCardActivity.this.overridePendingTransition(a.C0186a.alpha_in, a.C0186a.alpha_out);
                        } else {
                            PersonCardActivity.this.overridePendingTransition(0, Util.getHostResourcesId(PersonCardActivity.this.getActivity(), TbConfig.PACKAGE_NAME, "sdk_fade_out", ResUtils.ANIM));
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
            }
        }
    }

    public void closeActivity() {
        super.finish();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }
}
