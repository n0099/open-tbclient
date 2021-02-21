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
import com.baidu.live.data.ax;
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
    private boolean aJC;
    private String appId;
    private String bcX;
    private String extInfo;
    private String groupId;
    private PersonCardViewNew hUF;
    private PersonCardViewNew hUG;
    private PersonCardViewNew hUH;
    private PersonCardViewNew hUI;
    private c hUJ;
    private c hUK;
    JSONObject hUN;
    private PersonUserData hUO;
    private com.baidu.tieba.ala.person.c.a hUP;
    private e hUQ;
    private com.baidu.tieba.ala.person.a.c hUR;
    private com.baidu.tieba.ala.person.a.c hUS;
    private boolean hUT;
    private boolean hUV;
    private boolean hUW;
    private String hUY;
    private String hUZ;
    private String hVa;
    FrameLayout hVb;
    private String liveId;
    private String metaKey;
    private String otherParams;
    private String portrait;
    private String showName;
    private String userId;
    private String vid;
    private boolean hUL = false;
    private boolean hUM = false;
    private boolean hUU = false;
    private String hUX = "该用户开启了神秘人尊贵身份";
    private boolean isLocal = false;
    CustomMessageListener gNG = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                PersonCardActivity.this.otherParams = str;
                if (PersonCardActivity.this.hUH != null) {
                    PersonCardActivity.this.hUH.setOtherParams(PersonCardActivity.this.otherParams);
                }
                if (PersonCardActivity.this.hUI != null) {
                    PersonCardActivity.this.hUI.setOtherParams(PersonCardActivity.this.otherParams);
                }
            }
        }
    };
    private CustomMessageListener gNu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String string;
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(PersonCardActivity.this.userId)) {
                    if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().errno == 0) {
                        if (PersonCardActivity.this.hUP != null) {
                            PersonCardActivity.this.hUP.aE(PersonCardActivity.this.userId, PersonCardActivity.this.metaKey);
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
                                if (PersonCardActivity.this.bcX != null && PersonCardActivity.this.bcX.equals(updateAttentionMessage.getData().toUid)) {
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
                        PersonCardActivity.this.hUH.wp(0);
                        PersonCardActivity.this.hUI.wp(0);
                    } else {
                        PersonCardActivity.this.hUH.wp(1);
                        PersonCardActivity.this.hUI.wp(1);
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(PersonCardActivity.this.getUniqueId()) && !com.baidu.live.view.a.Xo().a(updateAttentionMessage.getData(), (BdPageContext<?>) PersonCardActivity.this.getPageContext(), false)) {
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
    CustomMessageListener aWK = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener hVc = new CustomMessageListener(2913186) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener hVd = new CustomMessageListener(2913203) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.j(PersonCardActivity.this.userId, PersonCardActivity.this.bcX, PersonCardActivity.this.groupId, "", PersonCardActivity.this.showName);
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
            this.hVb = (FrameLayout) findViewById(a.f.person_card_content_view);
            initModel();
            cmr();
            initView();
            this.hUJ.d(this.hUO);
            this.hUK.d(this.hUO);
            this.hUH.a(this.hUO, true);
            this.hUI.a(this.hUO, true);
            this.hUF.a(this.hUO, true);
            this.hUG.a(this.hUO, true);
            if (this.isLocal) {
                String str2 = this.hUZ;
                if (!TextUtils.isEmpty(this.hVa)) {
                    str2 = str2 + this.hVa;
                }
                this.hUO.user_info.user_id = this.userId;
                this.hUO.user_info.user_name = str2;
                this.hUO.user_info.user_nickname = str2;
                this.hUO.user_info.extInfoJson = this.hUN;
                eB(str2, this.hUY);
            }
            initListener();
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                i.ae(this.hUI.getRootView());
            } else {
                i.af(this.hUH.getRootView());
            }
            TiebaInitialize.log("c11899");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidate() {
        if (!isFinishing() && !this.hUU) {
            getContentView().removeAllViews();
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                if (this.hUM) {
                    this.hUG.getRootView().setVisibility(0);
                    this.hUF.getRootView().setVisibility(8);
                    this.hUK.getRootView().setVisibility(8);
                    this.hUJ.getRootView().setVisibility(8);
                    this.hUH.getRootView().setVisibility(8);
                    this.hUI.getRootView().setVisibility(8);
                    getContentView().addView(this.hUF.getRootView());
                    i.ae(this.hUG.getRootView());
                } else if (this.hUL) {
                    this.hUK.getRootView().setVisibility(0);
                    this.hUJ.getRootView().setVisibility(8);
                    this.hUH.getRootView().setVisibility(8);
                    this.hUI.getRootView().setVisibility(8);
                    this.hUG.getRootView().setVisibility(8);
                    this.hUF.getRootView().setVisibility(8);
                    getContentView().addView(this.hUK.getRootView());
                    i.ae(this.hUK.getRootView());
                } else {
                    this.hUJ.getRootView().setVisibility(8);
                    this.hUK.getRootView().setVisibility(8);
                    this.hUH.getRootView().setVisibility(8);
                    this.hUI.getRootView().setVisibility(0);
                    this.hUG.getRootView().setVisibility(8);
                    this.hUF.getRootView().setVisibility(8);
                    getContentView().addView(this.hUI.getRootView());
                    i.ae(this.hUI.getRootView());
                }
            } else if (this.hUM) {
                this.hUG.getRootView().setVisibility(8);
                this.hUF.getRootView().setVisibility(0);
                this.hUK.getRootView().setVisibility(8);
                this.hUJ.getRootView().setVisibility(8);
                this.hUH.getRootView().setVisibility(8);
                this.hUI.getRootView().setVisibility(8);
                getContentView().addView(this.hUF.getRootView());
                i.ae(this.hUF.getRootView());
            } else if (this.hUL) {
                this.hUJ.getRootView().setVisibility(0);
                this.hUK.getRootView().setVisibility(8);
                this.hUI.getRootView().setVisibility(8);
                this.hUH.getRootView().setVisibility(8);
                this.hUG.getRootView().setVisibility(8);
                this.hUF.getRootView().setVisibility(8);
                getContentView().addView(this.hUJ.getRootView());
                i.af(this.hUJ.getRootView());
            } else {
                this.hUJ.getRootView().setVisibility(8);
                this.hUK.getRootView().setVisibility(8);
                this.hUI.getRootView().setVisibility(8);
                this.hUH.getRootView().setVisibility(0);
                this.hUG.getRootView().setVisibility(8);
                this.hUF.getRootView().setVisibility(8);
                getContentView().addView(this.hUH.getRootView());
                i.af(this.hUH.getRootView());
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.hUU) {
            invalidate();
            this.hUH.bkp();
            this.hUI.bkp();
            this.hUJ.bkp();
            this.hUK.bkp();
            this.hUG.bkp();
            this.hUF.bkp();
        }
    }

    private void eB(String str, String str2) {
        this.hUJ.eC(str, str2);
        this.hUK.eC(str, str2);
    }

    private void Ih(String str) {
        if (str == null || str.length() == 0) {
            wk(0);
        }
        if (str != null && str.length() > 0) {
            try {
                this.hUN = new JSONObject(str);
                this.hUL = this.hUN.optInt("is_mysterious_man", 0) == 1;
                this.hUY = this.hUN.optString("mysterious_man_bd_portrait");
                this.hUZ = this.hUN.optString("mysterious_man_nickname");
                this.hVa = this.hUN.optString("mysterious_man_uid");
                this.hUX = this.hUN.optString("mysterious_show_text", "该用户开启了神秘人尊贵身份");
                if (this.userId != null && TbadkCoreApplication.getCurrentAccount() != null && TextUtils.equals(this.userId, TbadkCoreApplication.getCurrentAccount())) {
                    if (this.hUL) {
                        this.hUL = false;
                        this.hUM = true;
                    }
                    wk(0);
                } else if (!this.hUL) {
                    wk(2);
                } else {
                    this.isLocal = true;
                    wk(1);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ii(String str) {
        if (!isFinishing() && !this.hUU && str != null && str.length() != 0) {
            try {
                this.hUN = new JSONObject(str);
                this.hUL = this.hUN.optInt("is_mysterious_man", 0) == 1;
                this.hUY = this.hUN.optString("mysterious_man_bd_portrait");
                this.hUZ = this.hUN.optString("mysterious_man_nickname");
                this.hVa = this.hUN.optString("mysterious_man_uid");
                this.hUX = this.hUN.optString("mysterious_show_text", "该用户开启了神秘人尊贵身份");
                if (this.userId != null && TbadkCoreApplication.getCurrentAccount() != null && TextUtils.equals(this.userId, TbadkCoreApplication.getCurrentAccount()) && this.hUL) {
                    this.hUL = false;
                    this.hUM = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void cmr() {
        this.userId = getIntent().getStringExtra("PERSON_USER_ID");
        this.portrait = getIntent().getStringExtra("PERSON_PORTRAIT_URL");
        this.showName = getIntent().getStringExtra(AlaPersonCardActivityConfig.PERSON_SHOW_NAME);
        this.groupId = getIntent().getStringExtra("PERSON_GROUP_ID");
        this.liveId = getIntent().getStringExtra("PERSON_LIVE_ID");
        this.vid = getIntent().getStringExtra("vid");
        this.bcX = getIntent().getStringExtra("PERSON_LIVE_OWNER_UID");
        this.aJC = getIntent().getBooleanExtra("PERSON_LIVE_OWNER_FLAG", false);
        this.appId = getIntent().getStringExtra("PERSON_APP_ID");
        this.otherParams = getIntent().getStringExtra("other_params");
        this.hUV = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_IS_FROM_GUARD_CLUB, false);
        this.hUW = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_NAV_LIVEROOM_ENABLED, false);
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
        this.hUO = new PersonUserData();
        this.hUO.user_info = new ax();
        this.hUO.location_info = new AlaLocationData();
        this.hUO.relation_info = new AlaRelationData();
        this.hUO.user_info.user_id = "1111111";
        this.hUO.user_info.user_name = "";
        this.hUO.user_info.user_nickname = "";
        this.hUO.user_info.sex = intExtra;
        this.hUO.user_info.level_id = 1;
        this.hUO.user_info.description = "";
        this.hUO.user_info.send_count = 0L;
        this.hUO.user_info.fans_count = 0L;
        this.hUO.user_info.follow_count = 0L;
        this.hUO.user_info.portrait = "";
        this.hUO.user_info.third_app_id = this.appId;
        this.hUO.location_info.location = "火星";
        this.extInfo = getIntent().getStringExtra(AlaPersonCardActivityConfig.PERSON_EXT_INFO);
        Ih(this.extInfo);
    }

    private ViewGroup getContentView() {
        return this.hVb;
    }

    private void initView() {
        if (this.hUW && TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hUW = com.baidu.live.ae.a.Qj().buX.aMw;
        }
        this.hUJ = new c(this, false);
        this.hUJ.E(this.liveId, this.bcX, this.hUX);
        this.hUK = new c(this, true);
        this.hUK.E(this.liveId, this.bcX, this.hUX);
        this.hUH = new PersonCardViewNew(this, false, false);
        this.hUH.aN(this.liveId, this.bcX);
        this.hUH.setOtherParams(this.otherParams);
        this.hUH.oX(this.hUV);
        this.hUH.oY(this.hUW);
        this.hUI = new PersonCardViewNew(this, true, false);
        this.hUI.aN(this.liveId, this.bcX);
        this.hUI.setOtherParams(this.otherParams);
        this.hUI.oX(this.hUV);
        this.hUI.oY(this.hUW);
        this.hUF = new PersonCardViewNew(this, false, true);
        this.hUF.aN(this.liveId, this.bcX);
        this.hUF.setOtherParams(this.otherParams);
        this.hUF.oX(this.hUV);
        this.hUF.oY(this.hUW);
        this.hUG = new PersonCardViewNew(this, true, true);
        this.hUG.aN(this.liveId, this.bcX);
        this.hUG.setOtherParams(this.otherParams);
        this.hUG.oX(this.hUV);
        this.hUG.oY(this.hUW);
        invalidate();
        this.hUH.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.1
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cmy() {
                PersonCardActivity.this.cmx();
            }

            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cmz() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("live_id", PersonCardActivity.this.liveId);
                    jSONObject.put("vid", PersonCardActivity.this.vid == null ? "" : PersonCardActivity.this.vid);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "add_ impression").setContentExt("authorcard", "", jSONObject));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTagActivityConfig(PersonCardActivity.this.getPageContext().getPageActivity(), PersonCardActivity.this.bcX, PersonCardActivity.this.liveId)));
            }
        });
        this.hUI.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.3
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cmy() {
                PersonCardActivity.this.cmx();
            }

            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cmz() {
            }
        });
    }

    private void initListener() {
        registerListener(this.aWK);
        registerListener(this.gNu);
        registerListener(this.gNG);
        registerListener(this.hVc);
        registerListener(this.hVd);
    }

    private void initModel() {
        this.hUP = new com.baidu.tieba.ala.person.c.a(getPageContext());
        this.hUP.a(new a.InterfaceC0684a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.4
            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0684a
            public void b(PersonUserData personUserData) {
                if (personUserData != null && !PersonCardActivity.this.isFinishing() && !PersonCardActivity.this.hUU) {
                    if (PersonCardActivity.this.isLocal && personUserData.user_info != null) {
                        String str = PersonCardActivity.this.hUZ;
                        if (!TextUtils.isEmpty(PersonCardActivity.this.hVa)) {
                            str = str + PersonCardActivity.this.hVa;
                        }
                        personUserData.user_info.user_id = PersonCardActivity.this.userId;
                        personUserData.user_info.user_name = str;
                        personUserData.user_info.user_nickname = str;
                        personUserData.user_info.portrait = PersonCardActivity.this.hUY;
                        personUserData.user_info.extInfoJson = PersonCardActivity.this.hUN;
                        PersonCardActivity.this.portrait = personUserData.user_info.portrait;
                        PersonCardActivity.this.metaKey = personUserData.user_info.aOn;
                        PersonCardActivity.this.hUO.user_info = personUserData.user_info;
                        PersonCardActivity.this.hUO.login_user_info = personUserData.login_user_info;
                        PersonCardActivity.this.hUO.live_info = personUserData.live_info;
                    } else if (personUserData.user_info != null) {
                        PersonCardActivity.this.userId = personUserData.user_info.user_id;
                        PersonCardActivity.this.portrait = personUserData.user_info.portrait;
                        PersonCardActivity.this.metaKey = personUserData.user_info.aOn;
                        if (personUserData.user_info.extInfoJson != null) {
                            PersonCardActivity.this.extInfo = personUserData.user_info.extInfoJson.toString();
                        }
                        PersonCardActivity.this.Ii(PersonCardActivity.this.extInfo);
                        PersonCardActivity.this.hUH.a(personUserData, false, personUserData.hadPoked, PersonCardActivity.this.aJC);
                        PersonCardActivity.this.hUI.a(personUserData, false);
                        PersonCardActivity.this.hUJ.d(personUserData);
                        PersonCardActivity.this.hUK.d(personUserData);
                        PersonCardActivity.this.hUF.a(personUserData, false, personUserData.hadPoked, PersonCardActivity.this.aJC);
                        PersonCardActivity.this.hUG.a(personUserData, false);
                        PersonCardActivity.this.invalidate();
                    }
                }
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0684a
            public void a(com.baidu.tieba.ala.person.a.c cVar) {
                PersonCardActivity.this.hUR = cVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0684a
            public void b(com.baidu.tieba.ala.person.a.c cVar) {
                PersonCardActivity.this.hUS = cVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0684a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
        this.hUQ = new e(getPageContext());
        this.hUQ.a(new e.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.5
            @Override // com.baidu.live.personmanager.e.a
            public void Pg() {
                PersonCardActivity.this.showToast(a.h.ala_person_report_online_success);
            }

            @Override // com.baidu.live.personmanager.e.a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
    }

    public void j(String str, String str2, String str3, String str4, String str5) {
        this.hUR = null;
        this.hUS = null;
        this.hUP.k(str, str2, str3, str4, str5);
    }

    public void f(String str, String str2, String str3, String str4, String str5, String str6) {
        this.hUR = null;
        this.hUS = null;
        this.hUP.c(str, str2, str3, str4, str5, str6);
    }

    public boolean cms() {
        return (TextUtils.isEmpty(this.appId) || this.userId == null || this.userId.equals(this.bcX)) ? false : true;
    }

    public boolean Ij(String str) {
        return (TextUtils.isEmpty(this.bcX) || TextUtils.isEmpty(str) || !str.equals(this.bcX)) ? false : true;
    }

    public String cmt() {
        return this.bcX;
    }

    public void oU(boolean z) {
        this.hUH.oW(z);
        this.hUI.oW(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hUT = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.hUT) {
            this.hUH.onResume();
            this.hUI.onResume();
            this.hUJ.onResume();
            this.hUK.onResume();
            this.hUF.onResume();
            this.hUG.onResume();
        }
        this.hUT = false;
    }

    public void c(PersonUserData personUserData) {
        this.hUH.a(personUserData, false);
        this.hUI.a(personUserData, false);
        this.hUJ.d(personUserData);
        this.hUK.d(personUserData);
        this.userId = personUserData.user_info.user_id;
        this.portrait = personUserData.user_info.portrait;
        this.metaKey = personUserData.user_info.aOn;
        this.showName = personUserData.user_info.getNameShow();
        j(this.userId, this.bcX, this.groupId, this.metaKey, this.showName);
    }

    public void cmu() {
        f fVar = new f(this.portrait, this.userId, this.metaKey, "1", true, getUniqueId());
        fVar.setFrom("source_person_card");
        com.baidu.live.view.a.Xo().a(this.userId, fVar);
    }

    public void cmv() {
        f fVar = new f(this.portrait, this.userId, this.metaKey, "1", false, getUniqueId());
        fVar.setFrom("source_person_card");
        com.baidu.live.view.a.Xo().a(this.userId, fVar);
    }

    public void cmw() {
        this.hUQ.aF(this.userId, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmx() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new x(this, this.userId, this.groupId, this.liveId, this.aJC, this.bcX, this.otherParams)));
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            if (this instanceof Activity) {
                overridePendingTransition(a.C0195a.alpha_in, 0);
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
        if (this.hUP != null) {
            this.hUP.onDestroy();
        }
        if (this.hUF != null) {
            this.hUF.onDestroy();
        }
        if (this.hUG != null) {
            this.hUG.onDestroy();
        }
        if (this.hUH != null) {
            this.hUH.onDestroy();
        }
        if (this.hUI != null) {
            this.hUI.onDestroy();
        }
        if (this.hVc != null) {
            MessageManager.getInstance().unRegisterListener(this.hVc);
        }
        if (this.hVd != null) {
            MessageManager.getInstance().unRegisterListener(this.hVd);
        }
        if (this.hUJ != null) {
            this.hUJ.onDestroy();
        }
        if (this.hUK != null) {
            this.hUK.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (!this.hUU) {
            this.hUU = true;
            if (this.hUQ != null) {
                this.hUQ.onDestroy();
            }
            Animation animation = null;
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                if (this.hUM) {
                    if (this.hUG != null) {
                        animation = this.hUG.bWH();
                    }
                } else if (this.hUL) {
                    if (this.hUK != null) {
                        animation = this.hUK.bWH();
                    }
                } else if (this.hUI != null) {
                    animation = this.hUI.bWH();
                }
            } else if (this.hUM) {
                if (this.hUF != null) {
                    animation = this.hUF.bWH();
                }
            } else if (this.hUL) {
                if (this.hUJ != null) {
                    animation = this.hUJ.bWH();
                }
            } else if (this.hUH != null) {
                animation = this.hUH.bWH();
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
                            PersonCardActivity.this.overridePendingTransition(a.C0195a.alpha_in, a.C0195a.alpha_out);
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

    private void wk(int i) {
        if (!cms()) {
            f(this.userId, this.bcX, this.groupId, "", this.showName, String.valueOf(i));
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }
}
