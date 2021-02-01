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
import com.baidu.tieba.ala.person.a.c;
import com.baidu.tieba.ala.person.c.a;
import com.baidu.tieba.ala.person.view.PersonCardViewNew;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class PersonCardActivity extends BaseFragmentActivity {
    private boolean aJC;
    private String appId;
    private String bcX;
    private String extInfo;
    private String groupId;
    private PersonUserData hUA;
    private com.baidu.tieba.ala.person.c.a hUB;
    private e hUC;
    private c hUD;
    private c hUE;
    private boolean hUF;
    private boolean hUH;
    private boolean hUI;
    private String hUK;
    private String hUL;
    private String hUM;
    FrameLayout hUN;
    private PersonCardViewNew hUr;
    private PersonCardViewNew hUs;
    private PersonCardViewNew hUt;
    private PersonCardViewNew hUu;
    private com.baidu.tieba.ala.person.view.c hUv;
    private com.baidu.tieba.ala.person.view.c hUw;
    JSONObject hUz;
    private String liveId;
    private String metaKey;
    private String otherParams;
    private String portrait;
    private String showName;
    private String userId;
    private String vid;
    private boolean hUx = false;
    private boolean hUy = false;
    private boolean hUG = false;
    private String hUJ = "该用户开启了神秘人尊贵身份";
    private boolean isLocal = false;
    CustomMessageListener gNs = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                PersonCardActivity.this.otherParams = str;
                if (PersonCardActivity.this.hUt != null) {
                    PersonCardActivity.this.hUt.setOtherParams(PersonCardActivity.this.otherParams);
                }
                if (PersonCardActivity.this.hUu != null) {
                    PersonCardActivity.this.hUu.setOtherParams(PersonCardActivity.this.otherParams);
                }
            }
        }
    };
    private CustomMessageListener gNg = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String string;
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(PersonCardActivity.this.userId)) {
                    if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().errno == 0) {
                        if (PersonCardActivity.this.hUB != null) {
                            PersonCardActivity.this.hUB.aE(PersonCardActivity.this.userId, PersonCardActivity.this.metaKey);
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
                        PersonCardActivity.this.hUt.wp(0);
                        PersonCardActivity.this.hUu.wp(0);
                    } else {
                        PersonCardActivity.this.hUt.wp(1);
                        PersonCardActivity.this.hUu.wp(1);
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
    CustomMessageListener hUO = new CustomMessageListener(2913186) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener hUP = new CustomMessageListener(2913203) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.10
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
            this.hUN = (FrameLayout) findViewById(a.f.person_card_content_view);
            initModel();
            cmk();
            initView();
            this.hUv.d(this.hUA);
            this.hUw.d(this.hUA);
            this.hUt.a(this.hUA, true);
            this.hUu.a(this.hUA, true);
            this.hUr.a(this.hUA, true);
            this.hUs.a(this.hUA, true);
            if (this.isLocal) {
                String str2 = this.hUL;
                if (!TextUtils.isEmpty(this.hUM)) {
                    str2 = str2 + this.hUM;
                }
                this.hUA.user_info.user_id = this.userId;
                this.hUA.user_info.user_name = str2;
                this.hUA.user_info.user_nickname = str2;
                this.hUA.user_info.extInfoJson = this.hUz;
                eB(str2, this.hUK);
            }
            initListener();
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                i.ae(this.hUu.getRootView());
            } else {
                i.af(this.hUt.getRootView());
            }
            TiebaInitialize.log("c11899");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidate() {
        if (!isFinishing() && !this.hUG) {
            getContentView().removeAllViews();
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                if (this.hUy) {
                    this.hUs.getRootView().setVisibility(0);
                    this.hUr.getRootView().setVisibility(8);
                    this.hUw.getRootView().setVisibility(8);
                    this.hUv.getRootView().setVisibility(8);
                    this.hUt.getRootView().setVisibility(8);
                    this.hUu.getRootView().setVisibility(8);
                    getContentView().addView(this.hUr.getRootView());
                    i.ae(this.hUs.getRootView());
                } else if (this.hUx) {
                    this.hUw.getRootView().setVisibility(0);
                    this.hUv.getRootView().setVisibility(8);
                    this.hUt.getRootView().setVisibility(8);
                    this.hUu.getRootView().setVisibility(8);
                    this.hUs.getRootView().setVisibility(8);
                    this.hUr.getRootView().setVisibility(8);
                    getContentView().addView(this.hUw.getRootView());
                    i.ae(this.hUw.getRootView());
                } else {
                    this.hUv.getRootView().setVisibility(8);
                    this.hUw.getRootView().setVisibility(8);
                    this.hUt.getRootView().setVisibility(8);
                    this.hUu.getRootView().setVisibility(0);
                    this.hUs.getRootView().setVisibility(8);
                    this.hUr.getRootView().setVisibility(8);
                    getContentView().addView(this.hUu.getRootView());
                    i.ae(this.hUu.getRootView());
                }
            } else if (this.hUy) {
                this.hUs.getRootView().setVisibility(8);
                this.hUr.getRootView().setVisibility(0);
                this.hUw.getRootView().setVisibility(8);
                this.hUv.getRootView().setVisibility(8);
                this.hUt.getRootView().setVisibility(8);
                this.hUu.getRootView().setVisibility(8);
                getContentView().addView(this.hUr.getRootView());
                i.ae(this.hUr.getRootView());
            } else if (this.hUx) {
                this.hUv.getRootView().setVisibility(0);
                this.hUw.getRootView().setVisibility(8);
                this.hUu.getRootView().setVisibility(8);
                this.hUt.getRootView().setVisibility(8);
                this.hUs.getRootView().setVisibility(8);
                this.hUr.getRootView().setVisibility(8);
                getContentView().addView(this.hUv.getRootView());
                i.af(this.hUv.getRootView());
            } else {
                this.hUv.getRootView().setVisibility(8);
                this.hUw.getRootView().setVisibility(8);
                this.hUu.getRootView().setVisibility(8);
                this.hUt.getRootView().setVisibility(0);
                this.hUs.getRootView().setVisibility(8);
                this.hUr.getRootView().setVisibility(8);
                getContentView().addView(this.hUt.getRootView());
                i.af(this.hUt.getRootView());
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.hUG) {
            invalidate();
            this.hUt.bkp();
            this.hUu.bkp();
            this.hUv.bkp();
            this.hUw.bkp();
            this.hUs.bkp();
            this.hUr.bkp();
        }
    }

    private void eB(String str, String str2) {
        this.hUv.eC(str, str2);
        this.hUw.eC(str, str2);
    }

    private void Ig(String str) {
        if (str == null || str.length() == 0) {
            wk(0);
        }
        if (str != null && str.length() > 0) {
            try {
                this.hUz = new JSONObject(str);
                this.hUx = this.hUz.optInt("is_mysterious_man", 0) == 1;
                this.hUK = this.hUz.optString("mysterious_man_bd_portrait");
                this.hUL = this.hUz.optString("mysterious_man_nickname");
                this.hUM = this.hUz.optString("mysterious_man_uid");
                this.hUJ = this.hUz.optString("mysterious_show_text", "该用户开启了神秘人尊贵身份");
                if (this.userId != null && TbadkCoreApplication.getCurrentAccount() != null && TextUtils.equals(this.userId, TbadkCoreApplication.getCurrentAccount())) {
                    if (this.hUx) {
                        this.hUx = false;
                        this.hUy = true;
                    }
                    wk(0);
                } else if (!this.hUx) {
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
    public void Ih(String str) {
        if (!isFinishing() && !this.hUG && str != null && str.length() != 0) {
            try {
                this.hUz = new JSONObject(str);
                this.hUx = this.hUz.optInt("is_mysterious_man", 0) == 1;
                this.hUK = this.hUz.optString("mysterious_man_bd_portrait");
                this.hUL = this.hUz.optString("mysterious_man_nickname");
                this.hUM = this.hUz.optString("mysterious_man_uid");
                this.hUJ = this.hUz.optString("mysterious_show_text", "该用户开启了神秘人尊贵身份");
                if (this.userId != null && TbadkCoreApplication.getCurrentAccount() != null && TextUtils.equals(this.userId, TbadkCoreApplication.getCurrentAccount()) && this.hUx) {
                    this.hUx = false;
                    this.hUy = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void cmk() {
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
        this.hUH = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_IS_FROM_GUARD_CLUB, false);
        this.hUI = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_NAV_LIVEROOM_ENABLED, false);
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
        this.hUA = new PersonUserData();
        this.hUA.user_info = new ax();
        this.hUA.location_info = new AlaLocationData();
        this.hUA.relation_info = new AlaRelationData();
        this.hUA.user_info.user_id = "1111111";
        this.hUA.user_info.user_name = "";
        this.hUA.user_info.user_nickname = "";
        this.hUA.user_info.sex = intExtra;
        this.hUA.user_info.level_id = 1;
        this.hUA.user_info.description = "";
        this.hUA.user_info.send_count = 0L;
        this.hUA.user_info.fans_count = 0L;
        this.hUA.user_info.follow_count = 0L;
        this.hUA.user_info.portrait = "";
        this.hUA.user_info.third_app_id = this.appId;
        this.hUA.location_info.location = "火星";
        this.extInfo = getIntent().getStringExtra(AlaPersonCardActivityConfig.PERSON_EXT_INFO);
        Ig(this.extInfo);
    }

    private ViewGroup getContentView() {
        return this.hUN;
    }

    private void initView() {
        if (this.hUI && TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hUI = com.baidu.live.ae.a.Qj().buX.aMw;
        }
        this.hUv = new com.baidu.tieba.ala.person.view.c(this, false);
        this.hUv.E(this.liveId, this.bcX, this.hUJ);
        this.hUw = new com.baidu.tieba.ala.person.view.c(this, true);
        this.hUw.E(this.liveId, this.bcX, this.hUJ);
        this.hUt = new PersonCardViewNew(this, false, false);
        this.hUt.aN(this.liveId, this.bcX);
        this.hUt.setOtherParams(this.otherParams);
        this.hUt.oX(this.hUH);
        this.hUt.oY(this.hUI);
        this.hUu = new PersonCardViewNew(this, true, false);
        this.hUu.aN(this.liveId, this.bcX);
        this.hUu.setOtherParams(this.otherParams);
        this.hUu.oX(this.hUH);
        this.hUu.oY(this.hUI);
        this.hUr = new PersonCardViewNew(this, false, true);
        this.hUr.aN(this.liveId, this.bcX);
        this.hUr.setOtherParams(this.otherParams);
        this.hUr.oX(this.hUH);
        this.hUr.oY(this.hUI);
        this.hUs = new PersonCardViewNew(this, true, true);
        this.hUs.aN(this.liveId, this.bcX);
        this.hUs.setOtherParams(this.otherParams);
        this.hUs.oX(this.hUH);
        this.hUs.oY(this.hUI);
        invalidate();
        this.hUt.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.1
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cmr() {
                PersonCardActivity.this.cmq();
            }

            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cms() {
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
        this.hUu.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.3
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cmr() {
                PersonCardActivity.this.cmq();
            }

            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cms() {
            }
        });
    }

    private void initListener() {
        registerListener(this.aWK);
        registerListener(this.gNg);
        registerListener(this.gNs);
        registerListener(this.hUO);
        registerListener(this.hUP);
    }

    private void initModel() {
        this.hUB = new com.baidu.tieba.ala.person.c.a(getPageContext());
        this.hUB.a(new a.InterfaceC0683a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.4
            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0683a
            public void b(PersonUserData personUserData) {
                if (personUserData != null && !PersonCardActivity.this.isFinishing() && !PersonCardActivity.this.hUG) {
                    if (PersonCardActivity.this.isLocal && personUserData.user_info != null) {
                        String str = PersonCardActivity.this.hUL;
                        if (!TextUtils.isEmpty(PersonCardActivity.this.hUM)) {
                            str = str + PersonCardActivity.this.hUM;
                        }
                        personUserData.user_info.user_id = PersonCardActivity.this.userId;
                        personUserData.user_info.user_name = str;
                        personUserData.user_info.user_nickname = str;
                        personUserData.user_info.portrait = PersonCardActivity.this.hUK;
                        personUserData.user_info.extInfoJson = PersonCardActivity.this.hUz;
                        PersonCardActivity.this.portrait = personUserData.user_info.portrait;
                        PersonCardActivity.this.metaKey = personUserData.user_info.aOn;
                        PersonCardActivity.this.hUA.user_info = personUserData.user_info;
                        PersonCardActivity.this.hUA.login_user_info = personUserData.login_user_info;
                        PersonCardActivity.this.hUA.live_info = personUserData.live_info;
                    } else if (personUserData.user_info != null) {
                        PersonCardActivity.this.userId = personUserData.user_info.user_id;
                        PersonCardActivity.this.portrait = personUserData.user_info.portrait;
                        PersonCardActivity.this.metaKey = personUserData.user_info.aOn;
                        if (personUserData.user_info.extInfoJson != null) {
                            PersonCardActivity.this.extInfo = personUserData.user_info.extInfoJson.toString();
                        }
                        PersonCardActivity.this.Ih(PersonCardActivity.this.extInfo);
                        PersonCardActivity.this.hUt.a(personUserData, false, personUserData.hadPoked, PersonCardActivity.this.aJC);
                        PersonCardActivity.this.hUu.a(personUserData, false);
                        PersonCardActivity.this.hUv.d(personUserData);
                        PersonCardActivity.this.hUw.d(personUserData);
                        PersonCardActivity.this.hUr.a(personUserData, false, personUserData.hadPoked, PersonCardActivity.this.aJC);
                        PersonCardActivity.this.hUs.a(personUserData, false);
                        PersonCardActivity.this.invalidate();
                    }
                }
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0683a
            public void a(c cVar) {
                PersonCardActivity.this.hUD = cVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0683a
            public void b(c cVar) {
                PersonCardActivity.this.hUE = cVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0683a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
        this.hUC = new e(getPageContext());
        this.hUC.a(new e.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.5
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
        this.hUD = null;
        this.hUE = null;
        this.hUB.k(str, str2, str3, str4, str5);
    }

    public void f(String str, String str2, String str3, String str4, String str5, String str6) {
        this.hUD = null;
        this.hUE = null;
        this.hUB.c(str, str2, str3, str4, str5, str6);
    }

    public boolean cml() {
        return (TextUtils.isEmpty(this.appId) || this.userId == null || this.userId.equals(this.bcX)) ? false : true;
    }

    public boolean Ii(String str) {
        return (TextUtils.isEmpty(this.bcX) || TextUtils.isEmpty(str) || !str.equals(this.bcX)) ? false : true;
    }

    public String cmm() {
        return this.bcX;
    }

    public void oU(boolean z) {
        this.hUt.oW(z);
        this.hUu.oW(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hUF = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.hUF) {
            this.hUt.onResume();
            this.hUu.onResume();
            this.hUv.onResume();
            this.hUw.onResume();
            this.hUr.onResume();
            this.hUs.onResume();
        }
        this.hUF = false;
    }

    public void c(PersonUserData personUserData) {
        this.hUt.a(personUserData, false);
        this.hUu.a(personUserData, false);
        this.hUv.d(personUserData);
        this.hUw.d(personUserData);
        this.userId = personUserData.user_info.user_id;
        this.portrait = personUserData.user_info.portrait;
        this.metaKey = personUserData.user_info.aOn;
        this.showName = personUserData.user_info.getNameShow();
        j(this.userId, this.bcX, this.groupId, this.metaKey, this.showName);
    }

    public void cmn() {
        f fVar = new f(this.portrait, this.userId, this.metaKey, "1", true, getUniqueId());
        fVar.setFrom("source_person_card");
        com.baidu.live.view.a.Xo().a(this.userId, fVar);
    }

    public void cmo() {
        f fVar = new f(this.portrait, this.userId, this.metaKey, "1", false, getUniqueId());
        fVar.setFrom("source_person_card");
        com.baidu.live.view.a.Xo().a(this.userId, fVar);
    }

    public void cmp() {
        this.hUC.aF(this.userId, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmq() {
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
        if (this.hUB != null) {
            this.hUB.onDestroy();
        }
        if (this.hUr != null) {
            this.hUr.onDestroy();
        }
        if (this.hUs != null) {
            this.hUs.onDestroy();
        }
        if (this.hUt != null) {
            this.hUt.onDestroy();
        }
        if (this.hUu != null) {
            this.hUu.onDestroy();
        }
        if (this.hUO != null) {
            MessageManager.getInstance().unRegisterListener(this.hUO);
        }
        if (this.hUP != null) {
            MessageManager.getInstance().unRegisterListener(this.hUP);
        }
        if (this.hUv != null) {
            this.hUv.onDestroy();
        }
        if (this.hUw != null) {
            this.hUw.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (!this.hUG) {
            this.hUG = true;
            if (this.hUC != null) {
                this.hUC.onDestroy();
            }
            Animation animation = null;
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                if (this.hUy) {
                    if (this.hUs != null) {
                        animation = this.hUs.bWA();
                    }
                } else if (this.hUx) {
                    if (this.hUw != null) {
                        animation = this.hUw.bWA();
                    }
                } else if (this.hUu != null) {
                    animation = this.hUu.bWA();
                }
            } else if (this.hUy) {
                if (this.hUr != null) {
                    animation = this.hUr.bWA();
                }
            } else if (this.hUx) {
                if (this.hUv != null) {
                    animation = this.hUv.bWA();
                }
            } else if (this.hUt != null) {
                animation = this.hUt.bWA();
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
        if (!cml()) {
            f(this.userId, this.bcX, this.groupId, "", this.showName, String.valueOf(i));
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }
}
