package com.baidu.tieba.ala.person;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.d.x;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.at;
import com.baidu.live.data.f;
import com.baidu.live.personmanager.e;
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
import com.baidu.tieba.ala.person.c.a;
import com.baidu.tieba.ala.person.view.PersonCardViewNew;
import com.baidu.tieba.ala.person.view.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class PersonCardActivity extends BaseFragmentActivity {
    private boolean aLL;
    private String appId;
    private String beG;
    private String extInfo;
    private String groupId;
    private PersonCardViewNew hUC;
    private PersonCardViewNew hUD;
    private PersonCardViewNew hUE;
    private PersonCardViewNew hUF;
    private c hUG;
    private c hUH;
    private String hUI;
    JSONObject hUL;
    private PersonUserData hUM;
    private com.baidu.tieba.ala.person.c.a hUN;
    private e hUO;
    private com.baidu.tieba.ala.person.a.c hUP;
    private com.baidu.tieba.ala.person.a.c hUQ;
    private boolean hUR;
    private boolean hUT;
    private boolean hUU;
    private String hUW;
    private String hUX;
    private String hUY;
    FrameLayout hUZ;
    private String liveId;
    private String metaKey;
    private String otherParams;
    private String portrait;
    private String userId;
    private String vid;
    private boolean hUJ = false;
    private boolean hUK = false;
    private boolean hUS = false;
    private String hUV = "该用户开启了神秘人尊贵身份";
    private boolean isLocal = false;
    CustomMessageListener gPs = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                PersonCardActivity.this.otherParams = str;
                if (PersonCardActivity.this.hUE != null) {
                    PersonCardActivity.this.hUE.setOtherParams(PersonCardActivity.this.otherParams);
                }
                if (PersonCardActivity.this.hUF != null) {
                    PersonCardActivity.this.hUF.setOtherParams(PersonCardActivity.this.otherParams);
                }
            }
        }
    };
    private CustomMessageListener gPg = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String string;
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(PersonCardActivity.this.userId)) {
                    if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().errno == 0) {
                        if (PersonCardActivity.this.hUN != null) {
                            PersonCardActivity.this.hUN.aF(PersonCardActivity.this.userId, PersonCardActivity.this.metaKey);
                        }
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && message.getTag().equals(PersonCardActivity.this.getUniqueId())) {
                            if (updateAttentionMessage.getData().isAttention) {
                                if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
                                    PersonCardActivity.this.showToast(PersonCardActivity.this.getResources().getString(a.h.sdk_attention_success_toast));
                                    PersonCardActivity.this.finish();
                                } else {
                                    PersonCardActivity.this.showToast(PersonCardActivity.this.getResources().getString(a.h.sdk_attention_success_toast));
                                }
                                if (PersonCardActivity.this.beG != null && PersonCardActivity.this.beG.equals(updateAttentionMessage.getData().toUid)) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
                                    return;
                                }
                                return;
                            }
                            PersonCardActivity.this.showToast(PersonCardActivity.this.getResources().getString(a.h.sdk_unfollow_success_toast));
                            return;
                        }
                        return;
                    }
                    if (!updateAttentionMessage.isAttention()) {
                        PersonCardActivity.this.hUE.xK(0);
                        PersonCardActivity.this.hUF.xK(0);
                    } else {
                        PersonCardActivity.this.hUE.xK(1);
                        PersonCardActivity.this.hUF.xK(1);
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(PersonCardActivity.this.getUniqueId()) && !com.baidu.live.view.a.Zx().a(updateAttentionMessage.getData(), (BdPageContext<?>) PersonCardActivity.this.getPageContext(), false)) {
                        if (!TextUtils.isEmpty(updateAttentionMessage.getData().usermsg)) {
                            string = updateAttentionMessage.getData().usermsg;
                        } else if (!TextUtils.isEmpty(updateAttentionMessage.getData().errmsg)) {
                            string = updateAttentionMessage.getData().errmsg;
                        } else if (!TextUtils.isEmpty(updateAttentionMessage.getData().errorString)) {
                            string = updateAttentionMessage.getData().errorString;
                        } else {
                            string = PersonCardActivity.this.getResources().getString(a.h.sdk_op_failed_toast);
                        }
                        PersonCardActivity.this.showToast(string);
                    }
                }
            }
        }
    };
    CustomMessageListener aYs = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener hVa = new CustomMessageListener(2913186) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener hVb = new CustomMessageListener(2913203) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.j(PersonCardActivity.this.userId, PersonCardActivity.this.beG, PersonCardActivity.this.groupId, "", PersonCardActivity.this.hUI);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (!isFinishing()) {
            String str = Build.DISPLAY;
            if (str != null && str.contains("Flyme")) {
                getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.c.sdk_transparent)));
            }
            setContentView(a.g.ala_person_card_temp_view);
            this.hUZ = (FrameLayout) findViewById(a.f.person_card_content_view);
            initModel();
            cpd();
            initView();
            this.hUG.d(this.hUM);
            this.hUH.d(this.hUM);
            this.hUE.a(this.hUM, true);
            this.hUF.a(this.hUM, true);
            this.hUC.a(this.hUM, true);
            this.hUD.a(this.hUM, true);
            if (this.isLocal) {
                String str2 = this.hUX;
                if (!TextUtils.isEmpty(this.hUY)) {
                    str2 = str2 + this.hUY;
                }
                this.hUM.user_info.user_id = this.userId;
                this.hUM.user_info.user_name = str2;
                this.hUM.user_info.user_nickname = str2;
                this.hUM.user_info.extInfoJson = this.hUL;
                eD(str2, this.hUW);
            }
            initListener();
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                i.ae(this.hUF.getRootView());
            } else {
                i.af(this.hUE.getRootView());
            }
            TiebaInitialize.log("c11899");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidate() {
        if (!isFinishing() && !this.hUS) {
            getContentView().removeAllViews();
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                if (this.hUK) {
                    this.hUD.getRootView().setVisibility(0);
                    this.hUC.getRootView().setVisibility(8);
                    this.hUH.getRootView().setVisibility(8);
                    this.hUG.getRootView().setVisibility(8);
                    this.hUE.getRootView().setVisibility(8);
                    this.hUF.getRootView().setVisibility(8);
                    getContentView().addView(this.hUC.getRootView());
                    i.ae(this.hUD.getRootView());
                } else if (this.hUJ) {
                    this.hUH.getRootView().setVisibility(0);
                    this.hUG.getRootView().setVisibility(8);
                    this.hUE.getRootView().setVisibility(8);
                    this.hUF.getRootView().setVisibility(8);
                    this.hUD.getRootView().setVisibility(8);
                    this.hUC.getRootView().setVisibility(8);
                    getContentView().addView(this.hUH.getRootView());
                    i.ae(this.hUH.getRootView());
                } else {
                    this.hUG.getRootView().setVisibility(8);
                    this.hUH.getRootView().setVisibility(8);
                    this.hUE.getRootView().setVisibility(8);
                    this.hUF.getRootView().setVisibility(0);
                    this.hUD.getRootView().setVisibility(8);
                    this.hUC.getRootView().setVisibility(8);
                    getContentView().addView(this.hUF.getRootView());
                    i.ae(this.hUF.getRootView());
                }
            } else if (this.hUK) {
                this.hUD.getRootView().setVisibility(8);
                this.hUC.getRootView().setVisibility(0);
                this.hUH.getRootView().setVisibility(8);
                this.hUG.getRootView().setVisibility(8);
                this.hUE.getRootView().setVisibility(8);
                this.hUF.getRootView().setVisibility(8);
                getContentView().addView(this.hUC.getRootView());
                i.ae(this.hUC.getRootView());
            } else if (this.hUJ) {
                this.hUG.getRootView().setVisibility(0);
                this.hUH.getRootView().setVisibility(8);
                this.hUF.getRootView().setVisibility(8);
                this.hUE.getRootView().setVisibility(8);
                this.hUD.getRootView().setVisibility(8);
                this.hUC.getRootView().setVisibility(8);
                getContentView().addView(this.hUG.getRootView());
                i.af(this.hUG.getRootView());
            } else {
                this.hUG.getRootView().setVisibility(8);
                this.hUH.getRootView().setVisibility(8);
                this.hUF.getRootView().setVisibility(8);
                this.hUE.getRootView().setVisibility(0);
                this.hUD.getRootView().setVisibility(8);
                this.hUC.getRootView().setVisibility(8);
                getContentView().addView(this.hUE.getRootView());
                i.af(this.hUE.getRootView());
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.hUS) {
            invalidate();
            this.hUE.bnO();
            this.hUF.bnO();
            this.hUG.bnO();
            this.hUH.bnO();
            this.hUD.bnO();
            this.hUC.bnO();
        }
    }

    private void eD(String str, String str2) {
        this.hUG.eE(str, str2);
        this.hUH.eE(str, str2);
    }

    private void IO(String str) {
        if (str == null || str.length() == 0) {
            xF(0);
        }
        if (str != null && str.length() > 0) {
            try {
                this.hUL = new JSONObject(str);
                this.hUJ = this.hUL.optInt("is_mysterious_man", 0) == 1;
                this.hUW = this.hUL.optString("mysterious_man_bd_portrait");
                this.hUX = this.hUL.optString("mysterious_man_nickname");
                this.hUY = this.hUL.optString("mysterious_man_uid");
                this.hUV = this.hUL.optString("mysterious_show_text", "该用户开启了神秘人尊贵身份");
                if (this.userId != null && TbadkCoreApplication.getCurrentAccount() != null && TextUtils.equals(this.userId, TbadkCoreApplication.getCurrentAccount())) {
                    if (this.hUJ) {
                        this.hUJ = false;
                        this.hUK = true;
                    }
                    xF(0);
                } else if (!this.hUJ) {
                    xF(2);
                } else {
                    this.isLocal = true;
                    xF(1);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IP(String str) {
        if (!isFinishing() && !this.hUS && str != null && str.length() != 0) {
            try {
                this.hUL = new JSONObject(str);
                this.hUJ = this.hUL.optInt("is_mysterious_man", 0) == 1;
                this.hUW = this.hUL.optString("mysterious_man_bd_portrait");
                this.hUX = this.hUL.optString("mysterious_man_nickname");
                this.hUY = this.hUL.optString("mysterious_man_uid");
                this.hUV = this.hUL.optString("mysterious_show_text", "该用户开启了神秘人尊贵身份");
                if (this.userId != null && TbadkCoreApplication.getCurrentAccount() != null && TextUtils.equals(this.userId, TbadkCoreApplication.getCurrentAccount()) && this.hUJ) {
                    this.hUJ = false;
                    this.hUK = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void cpd() {
        this.userId = getIntent().getStringExtra("PERSON_USER_ID");
        this.portrait = getIntent().getStringExtra("PERSON_PORTRAIT_URL");
        this.hUI = getIntent().getStringExtra(AlaPersonCardActivityConfig.PERSON_SHOW_NAME);
        this.groupId = getIntent().getStringExtra("PERSON_GROUP_ID");
        this.liveId = getIntent().getStringExtra("PERSON_LIVE_ID");
        this.vid = getIntent().getStringExtra("vid");
        this.beG = getIntent().getStringExtra("PERSON_LIVE_OWNER_UID");
        this.aLL = getIntent().getBooleanExtra("PERSON_LIVE_OWNER_FLAG", false);
        this.appId = getIntent().getStringExtra("PERSON_APP_ID");
        this.otherParams = getIntent().getStringExtra("other_params");
        this.hUT = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_IS_FROM_GUARD_CLUB, false);
        this.hUU = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_NAV_LIVEROOM_ENABLED, false);
        getIntent().getStringExtra("PERSON_USER_NAME");
        getIntent().getStringExtra("PERSON_PORTRAIT_URL");
        int intExtra = getIntent().getIntExtra("PERSON_SEX", 0);
        getIntent().getIntExtra("PERSON_LEVEL", 1);
        getIntent().getStringExtra("PERSON_LOCATION");
        getIntent().getStringExtra("PERSON_DESCRIPTION");
        getIntent().getLongExtra("PERSON_SEND_COUNT", 0L);
        getIntent().getLongExtra("PERSON_FANS_COUNT", 0L);
        getIntent().getLongExtra("PERSON_FOLLOWS_COUNT", 0L);
        getIntent().getIntExtra("PERSON_FOLLOW_STATUS", 0);
        this.hUM = new PersonUserData();
        this.hUM.user_info = new at();
        this.hUM.location_info = new AlaLocationData();
        this.hUM.relation_info = new AlaRelationData();
        this.hUM.user_info.user_id = "1111111";
        this.hUM.user_info.user_name = "";
        this.hUM.user_info.user_nickname = "";
        this.hUM.user_info.sex = intExtra;
        this.hUM.user_info.level_id = 1;
        this.hUM.user_info.description = "";
        this.hUM.user_info.send_count = 0L;
        this.hUM.user_info.fans_count = 0L;
        this.hUM.user_info.follow_count = 0L;
        this.hUM.user_info.portrait = "";
        this.hUM.user_info.third_app_id = this.appId;
        this.hUM.location_info.location = "火星";
        this.extInfo = getIntent().getStringExtra(AlaPersonCardActivityConfig.PERSON_EXT_INFO);
        IO(this.extInfo);
    }

    private ViewGroup getContentView() {
        return this.hUZ;
    }

    private void initView() {
        if (this.hUU && TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hUU = com.baidu.live.af.a.SE().bwi.aOz;
        }
        this.hUG = new c(this, false);
        this.hUG.E(this.liveId, this.beG, this.hUV);
        this.hUH = new c(this, true);
        this.hUH.E(this.liveId, this.beG, this.hUV);
        this.hUE = new PersonCardViewNew(this, false, false);
        this.hUE.aO(this.liveId, this.beG);
        this.hUE.setOtherParams(this.otherParams);
        this.hUE.oR(this.hUT);
        this.hUE.oS(this.hUU);
        this.hUF = new PersonCardViewNew(this, true, false);
        this.hUF.aO(this.liveId, this.beG);
        this.hUF.setOtherParams(this.otherParams);
        this.hUF.oR(this.hUT);
        this.hUF.oS(this.hUU);
        this.hUC = new PersonCardViewNew(this, false, true);
        this.hUC.aO(this.liveId, this.beG);
        this.hUC.setOtherParams(this.otherParams);
        this.hUC.oR(this.hUT);
        this.hUC.oS(this.hUU);
        this.hUD = new PersonCardViewNew(this, true, true);
        this.hUD.aO(this.liveId, this.beG);
        this.hUD.setOtherParams(this.otherParams);
        this.hUD.oR(this.hUT);
        this.hUD.oS(this.hUU);
        invalidate();
        this.hUE.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.1
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cpk() {
                PersonCardActivity.this.cpj();
            }

            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cpl() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("live_id", PersonCardActivity.this.liveId);
                    jSONObject.put("vid", PersonCardActivity.this.vid == null ? "" : PersonCardActivity.this.vid);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "add_ impression").setContentExt("authorcard", "", jSONObject));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTagActivityConfig(PersonCardActivity.this.getPageContext().getPageActivity(), PersonCardActivity.this.beG, PersonCardActivity.this.liveId)));
            }
        });
        this.hUF.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.3
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cpk() {
                PersonCardActivity.this.cpj();
            }

            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cpl() {
            }
        });
    }

    private void initListener() {
        registerListener(this.aYs);
        registerListener(this.gPg);
        registerListener(this.gPs);
        registerListener(this.hVa);
        registerListener(this.hVb);
    }

    private void initModel() {
        this.hUN = new com.baidu.tieba.ala.person.c.a(getPageContext());
        this.hUN.a(new a.InterfaceC0700a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.4
            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0700a
            public void b(PersonUserData personUserData) {
                if (personUserData != null && !PersonCardActivity.this.isFinishing() && !PersonCardActivity.this.hUS) {
                    if (PersonCardActivity.this.isLocal && personUserData.user_info != null) {
                        String str = PersonCardActivity.this.hUX;
                        if (!TextUtils.isEmpty(PersonCardActivity.this.hUY)) {
                            str = str + PersonCardActivity.this.hUY;
                        }
                        personUserData.user_info.user_id = PersonCardActivity.this.userId;
                        personUserData.user_info.user_name = str;
                        personUserData.user_info.user_nickname = str;
                        personUserData.user_info.portrait = PersonCardActivity.this.hUW;
                        personUserData.user_info.extInfoJson = PersonCardActivity.this.hUL;
                        PersonCardActivity.this.portrait = personUserData.user_info.portrait;
                        PersonCardActivity.this.metaKey = personUserData.user_info.aQe;
                        PersonCardActivity.this.hUM.user_info = personUserData.user_info;
                        PersonCardActivity.this.hUM.login_user_info = personUserData.login_user_info;
                        PersonCardActivity.this.hUM.live_info = personUserData.live_info;
                    } else if (personUserData.user_info != null) {
                        PersonCardActivity.this.userId = personUserData.user_info.user_id;
                        PersonCardActivity.this.portrait = personUserData.user_info.portrait;
                        PersonCardActivity.this.metaKey = personUserData.user_info.aQe;
                        if (personUserData.user_info.extInfoJson != null) {
                            PersonCardActivity.this.extInfo = personUserData.user_info.extInfoJson.toString();
                        }
                        PersonCardActivity.this.IP(PersonCardActivity.this.extInfo);
                        PersonCardActivity.this.hUE.a(personUserData, false, personUserData.hadPoked, PersonCardActivity.this.aLL);
                        PersonCardActivity.this.hUF.a(personUserData, false);
                        PersonCardActivity.this.hUG.d(personUserData);
                        PersonCardActivity.this.hUH.d(personUserData);
                        PersonCardActivity.this.hUC.a(personUserData, false, personUserData.hadPoked, PersonCardActivity.this.aLL);
                        PersonCardActivity.this.hUD.a(personUserData, false);
                        PersonCardActivity.this.invalidate();
                    }
                }
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0700a
            public void a(com.baidu.tieba.ala.person.a.c cVar) {
                PersonCardActivity.this.hUP = cVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0700a
            public void b(com.baidu.tieba.ala.person.a.c cVar) {
                PersonCardActivity.this.hUQ = cVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0700a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
        this.hUO = new e(getPageContext());
        this.hUO.a(new e.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.5
            @Override // com.baidu.live.personmanager.e.a
            public void Rz() {
                PersonCardActivity.this.showToast(a.h.ala_person_report_online_success);
            }

            @Override // com.baidu.live.personmanager.e.a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
    }

    public void j(String str, String str2, String str3, String str4, String str5) {
        this.hUP = null;
        this.hUQ = null;
        this.hUN.k(str, str2, str3, str4, str5);
    }

    public void f(String str, String str2, String str3, String str4, String str5, String str6) {
        this.hUP = null;
        this.hUQ = null;
        this.hUN.c(str, str2, str3, str4, str5, str6);
    }

    public boolean cpe() {
        return (TextUtils.isEmpty(this.appId) || this.userId == null || this.userId.equals(this.beG)) ? false : true;
    }

    public boolean IQ(String str) {
        return (TextUtils.isEmpty(this.beG) || TextUtils.isEmpty(str) || !str.equals(this.beG)) ? false : true;
    }

    public String cpf() {
        return this.beG;
    }

    public void oO(boolean z) {
        this.hUE.oQ(z);
        this.hUF.oQ(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hUR = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.hUR) {
            this.hUE.onResume();
            this.hUF.onResume();
            this.hUG.onResume();
            this.hUH.onResume();
            this.hUC.onResume();
            this.hUD.onResume();
        }
        this.hUR = false;
    }

    public void c(PersonUserData personUserData) {
        this.hUE.a(personUserData, false);
        this.hUF.a(personUserData, false);
        this.hUG.d(personUserData);
        this.hUH.d(personUserData);
        this.userId = personUserData.user_info.user_id;
        this.portrait = personUserData.user_info.portrait;
        this.metaKey = personUserData.user_info.aQe;
        this.hUI = personUserData.user_info.getNameShow();
        j(this.userId, this.beG, this.groupId, this.metaKey, this.hUI);
    }

    public void cpg() {
        f fVar = new f(this.portrait, this.userId, this.metaKey, "1", true, getUniqueId());
        fVar.setFrom("source_person_card");
        com.baidu.live.view.a.Zx().a(this.userId, fVar);
    }

    public void cph() {
        f fVar = new f(this.portrait, this.userId, this.metaKey, "1", false, getUniqueId());
        fVar.setFrom("source_person_card");
        com.baidu.live.view.a.Zx().a(this.userId, fVar);
    }

    public void cpi() {
        this.hUO.aG(this.userId, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpj() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new x(this, this.userId, this.groupId, this.liveId, this.aLL, this.beG, this.otherParams)));
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            if (this instanceof Activity) {
                overridePendingTransition(a.C0203a.alpha_in, 0);
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
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
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hUN != null) {
            this.hUN.onDestroy();
        }
        if (this.hUE != null) {
            this.hUE.onDestroy();
        }
        if (this.hUF != null) {
            this.hUF.onDestroy();
        }
        if (this.hVa != null) {
            MessageManager.getInstance().unRegisterListener(this.hVa);
        }
        if (this.hVb != null) {
            MessageManager.getInstance().unRegisterListener(this.hVb);
        }
        if (this.hUG != null) {
            this.hUG.onDestroy();
        }
        if (this.hUH != null) {
            this.hUH.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (!this.hUS) {
            this.hUS = true;
            if (this.hUO != null) {
                this.hUO.onDestroy();
            }
            Animation animation = null;
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                if (this.hUK) {
                    if (this.hUD != null) {
                        animation = this.hUD.bZN();
                    }
                } else if (this.hUJ) {
                    if (this.hUH != null) {
                        animation = this.hUH.bZN();
                    }
                } else if (this.hUF != null) {
                    animation = this.hUF.bZN();
                }
            } else if (this.hUK) {
                if (this.hUC != null) {
                    animation = this.hUC.bZN();
                }
            } else if (this.hUJ) {
                if (this.hUG != null) {
                    animation = this.hUG.bZN();
                }
            } else if (this.hUE != null) {
                animation = this.hUE.bZN();
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
                            BdLog.e("PersonCard hide");
                            PersonCardActivity.this.overridePendingTransition(a.C0203a.alpha_in, a.C0203a.alpha_out);
                            return;
                        }
                        PersonCardActivity.this.overridePendingTransition(0, Util.getHostResourcesId(PersonCardActivity.this.getActivity(), TbConfig.PACKAGE_NAME, "sdk_fade_out", ResUtils.ANIM));
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

    private void xF(int i) {
        if (!cpe()) {
            f(this.userId, this.beG, this.groupId, "", this.hUI, String.valueOf(i));
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }
}
