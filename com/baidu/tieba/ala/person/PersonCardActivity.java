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
/* loaded from: classes10.dex */
public class PersonCardActivity extends BaseFragmentActivity {
    private boolean aGY;
    private String aZQ;
    private String appId;
    private String extInfo;
    private String groupId;
    private PersonCardViewNew hPW;
    private PersonCardViewNew hPX;
    private PersonCardViewNew hPY;
    private PersonCardViewNew hPZ;
    private c hQa;
    private c hQb;
    JSONObject hQe;
    private PersonUserData hQf;
    private com.baidu.tieba.ala.person.c.a hQg;
    private e hQh;
    private com.baidu.tieba.ala.person.a.c hQi;
    private com.baidu.tieba.ala.person.a.c hQj;
    private boolean hQk;
    private boolean hQm;
    private boolean hQn;
    private String hQp;
    private String hQq;
    private String hQr;
    FrameLayout hQs;
    private String liveId;
    private String metaKey;
    private String otherParams;
    private String portrait;
    private String showName;
    private String userId;
    private String vid;
    private boolean hQc = false;
    private boolean hQd = false;
    private boolean hQl = false;
    private String hQo = "该用户开启了神秘人尊贵身份";
    private boolean isLocal = false;
    CustomMessageListener gKM = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                PersonCardActivity.this.otherParams = str;
                if (PersonCardActivity.this.hPY != null) {
                    PersonCardActivity.this.hPY.setOtherParams(PersonCardActivity.this.otherParams);
                }
                if (PersonCardActivity.this.hPZ != null) {
                    PersonCardActivity.this.hPZ.setOtherParams(PersonCardActivity.this.otherParams);
                }
            }
        }
    };
    private CustomMessageListener gKA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String string;
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(PersonCardActivity.this.userId)) {
                    if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().errno == 0) {
                        if (PersonCardActivity.this.hQg != null) {
                            PersonCardActivity.this.hQg.aE(PersonCardActivity.this.userId, PersonCardActivity.this.metaKey);
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
                                if (PersonCardActivity.this.aZQ != null && PersonCardActivity.this.aZQ.equals(updateAttentionMessage.getData().toUid)) {
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
                        PersonCardActivity.this.hPY.we(0);
                        PersonCardActivity.this.hPZ.we(0);
                    } else {
                        PersonCardActivity.this.hPY.we(1);
                        PersonCardActivity.this.hPZ.we(1);
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(PersonCardActivity.this.getUniqueId()) && !com.baidu.live.view.a.VF().a(updateAttentionMessage.getData(), (BdPageContext<?>) PersonCardActivity.this.getPageContext(), false)) {
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
    CustomMessageListener aTF = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener hQt = new CustomMessageListener(2913186) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener hQu = new CustomMessageListener(2913203) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.j(PersonCardActivity.this.userId, PersonCardActivity.this.aZQ, PersonCardActivity.this.groupId, "", PersonCardActivity.this.showName);
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
            this.hQs = (FrameLayout) findViewById(a.f.person_card_content_view);
            initModel();
            clm();
            initView();
            this.hQa.d(this.hQf);
            this.hQb.d(this.hQf);
            this.hPY.a(this.hQf, true);
            this.hPZ.a(this.hQf, true);
            this.hPW.a(this.hQf, true);
            this.hPX.a(this.hQf, true);
            if (this.isLocal) {
                String str2 = this.hQq;
                if (!TextUtils.isEmpty(this.hQr)) {
                    str2 = str2 + this.hQr;
                }
                this.hQf.user_info.user_id = this.userId;
                this.hQf.user_info.user_name = str2;
                this.hQf.user_info.user_nickname = str2;
                this.hQf.user_info.extInfoJson = this.hQe;
                eC(str2, this.hQp);
            }
            initListener();
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                i.ae(this.hPZ.getRootView());
            } else {
                i.af(this.hPY.getRootView());
            }
            TiebaInitialize.log("c11899");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidate() {
        if (!isFinishing() && !this.hQl) {
            getContentView().removeAllViews();
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                if (this.hQd) {
                    this.hPX.getRootView().setVisibility(0);
                    this.hPW.getRootView().setVisibility(8);
                    this.hQb.getRootView().setVisibility(8);
                    this.hQa.getRootView().setVisibility(8);
                    this.hPY.getRootView().setVisibility(8);
                    this.hPZ.getRootView().setVisibility(8);
                    getContentView().addView(this.hPW.getRootView());
                    i.ae(this.hPX.getRootView());
                } else if (this.hQc) {
                    this.hQb.getRootView().setVisibility(0);
                    this.hQa.getRootView().setVisibility(8);
                    this.hPY.getRootView().setVisibility(8);
                    this.hPZ.getRootView().setVisibility(8);
                    this.hPX.getRootView().setVisibility(8);
                    this.hPW.getRootView().setVisibility(8);
                    getContentView().addView(this.hQb.getRootView());
                    i.ae(this.hQb.getRootView());
                } else {
                    this.hQa.getRootView().setVisibility(8);
                    this.hQb.getRootView().setVisibility(8);
                    this.hPY.getRootView().setVisibility(8);
                    this.hPZ.getRootView().setVisibility(0);
                    this.hPX.getRootView().setVisibility(8);
                    this.hPW.getRootView().setVisibility(8);
                    getContentView().addView(this.hPZ.getRootView());
                    i.ae(this.hPZ.getRootView());
                }
            } else if (this.hQd) {
                this.hPX.getRootView().setVisibility(8);
                this.hPW.getRootView().setVisibility(0);
                this.hQb.getRootView().setVisibility(8);
                this.hQa.getRootView().setVisibility(8);
                this.hPY.getRootView().setVisibility(8);
                this.hPZ.getRootView().setVisibility(8);
                getContentView().addView(this.hPW.getRootView());
                i.ae(this.hPW.getRootView());
            } else if (this.hQc) {
                this.hQa.getRootView().setVisibility(0);
                this.hQb.getRootView().setVisibility(8);
                this.hPZ.getRootView().setVisibility(8);
                this.hPY.getRootView().setVisibility(8);
                this.hPX.getRootView().setVisibility(8);
                this.hPW.getRootView().setVisibility(8);
                getContentView().addView(this.hQa.getRootView());
                i.af(this.hQa.getRootView());
            } else {
                this.hQa.getRootView().setVisibility(8);
                this.hQb.getRootView().setVisibility(8);
                this.hPZ.getRootView().setVisibility(8);
                this.hPY.getRootView().setVisibility(0);
                this.hPX.getRootView().setVisibility(8);
                this.hPW.getRootView().setVisibility(8);
                getContentView().addView(this.hPY.getRootView());
                i.af(this.hPY.getRootView());
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.hQl) {
            invalidate();
            this.hPY.bjV();
            this.hPZ.bjV();
            this.hQa.bjV();
            this.hQb.bjV();
            this.hPX.bjV();
            this.hPW.bjV();
        }
    }

    private void eC(String str, String str2) {
        this.hQa.eD(str, str2);
        this.hQb.eD(str, str2);
    }

    private void HC(String str) {
        if (str == null || str.length() == 0) {
            vZ(0);
        }
        if (str != null && str.length() > 0) {
            try {
                this.hQe = new JSONObject(str);
                this.hQc = this.hQe.optInt("is_mysterious_man", 0) == 1;
                this.hQp = this.hQe.optString("mysterious_man_bd_portrait");
                this.hQq = this.hQe.optString("mysterious_man_nickname");
                this.hQr = this.hQe.optString("mysterious_man_uid");
                this.hQo = this.hQe.optString("mysterious_show_text", "该用户开启了神秘人尊贵身份");
                if (this.userId != null && TbadkCoreApplication.getCurrentAccount() != null && TextUtils.equals(this.userId, TbadkCoreApplication.getCurrentAccount())) {
                    if (this.hQc) {
                        this.hQc = false;
                        this.hQd = true;
                    }
                    vZ(0);
                } else if (!this.hQc) {
                    vZ(2);
                } else {
                    this.isLocal = true;
                    vZ(1);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HD(String str) {
        if (!isFinishing() && !this.hQl && str != null && str.length() != 0) {
            try {
                this.hQe = new JSONObject(str);
                this.hQc = this.hQe.optInt("is_mysterious_man", 0) == 1;
                this.hQp = this.hQe.optString("mysterious_man_bd_portrait");
                this.hQq = this.hQe.optString("mysterious_man_nickname");
                this.hQr = this.hQe.optString("mysterious_man_uid");
                this.hQo = this.hQe.optString("mysterious_show_text", "该用户开启了神秘人尊贵身份");
                if (this.userId != null && TbadkCoreApplication.getCurrentAccount() != null && TextUtils.equals(this.userId, TbadkCoreApplication.getCurrentAccount()) && this.hQc) {
                    this.hQc = false;
                    this.hQd = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void clm() {
        this.userId = getIntent().getStringExtra("PERSON_USER_ID");
        this.portrait = getIntent().getStringExtra("PERSON_PORTRAIT_URL");
        this.showName = getIntent().getStringExtra(AlaPersonCardActivityConfig.PERSON_SHOW_NAME);
        this.groupId = getIntent().getStringExtra("PERSON_GROUP_ID");
        this.liveId = getIntent().getStringExtra("PERSON_LIVE_ID");
        this.vid = getIntent().getStringExtra("vid");
        this.aZQ = getIntent().getStringExtra("PERSON_LIVE_OWNER_UID");
        this.aGY = getIntent().getBooleanExtra("PERSON_LIVE_OWNER_FLAG", false);
        this.appId = getIntent().getStringExtra("PERSON_APP_ID");
        this.otherParams = getIntent().getStringExtra("other_params");
        this.hQm = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_IS_FROM_GUARD_CLUB, false);
        this.hQn = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_NAV_LIVEROOM_ENABLED, false);
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
        this.hQf = new PersonUserData();
        this.hQf.user_info = new at();
        this.hQf.location_info = new AlaLocationData();
        this.hQf.relation_info = new AlaRelationData();
        this.hQf.user_info.user_id = "1111111";
        this.hQf.user_info.user_name = "";
        this.hQf.user_info.user_nickname = "";
        this.hQf.user_info.sex = intExtra;
        this.hQf.user_info.level_id = 1;
        this.hQf.user_info.description = "";
        this.hQf.user_info.send_count = 0L;
        this.hQf.user_info.fans_count = 0L;
        this.hQf.user_info.follow_count = 0L;
        this.hQf.user_info.portrait = "";
        this.hQf.user_info.third_app_id = this.appId;
        this.hQf.location_info.location = "火星";
        this.extInfo = getIntent().getStringExtra(AlaPersonCardActivityConfig.PERSON_EXT_INFO);
        HC(this.extInfo);
    }

    private ViewGroup getContentView() {
        return this.hQs;
    }

    private void initView() {
        if (this.hQn && TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hQn = com.baidu.live.af.a.OJ().bru.aJM;
        }
        this.hQa = new c(this, false);
        this.hQa.D(this.liveId, this.aZQ, this.hQo);
        this.hQb = new c(this, true);
        this.hQb.D(this.liveId, this.aZQ, this.hQo);
        this.hPY = new PersonCardViewNew(this, false, false);
        this.hPY.aN(this.liveId, this.aZQ);
        this.hPY.setOtherParams(this.otherParams);
        this.hPY.oN(this.hQm);
        this.hPY.oO(this.hQn);
        this.hPZ = new PersonCardViewNew(this, true, false);
        this.hPZ.aN(this.liveId, this.aZQ);
        this.hPZ.setOtherParams(this.otherParams);
        this.hPZ.oN(this.hQm);
        this.hPZ.oO(this.hQn);
        this.hPW = new PersonCardViewNew(this, false, true);
        this.hPW.aN(this.liveId, this.aZQ);
        this.hPW.setOtherParams(this.otherParams);
        this.hPW.oN(this.hQm);
        this.hPW.oO(this.hQn);
        this.hPX = new PersonCardViewNew(this, true, true);
        this.hPX.aN(this.liveId, this.aZQ);
        this.hPX.setOtherParams(this.otherParams);
        this.hPX.oN(this.hQm);
        this.hPX.oO(this.hQn);
        invalidate();
        this.hPY.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.1
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void clt() {
                PersonCardActivity.this.cls();
            }

            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void clu() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("live_id", PersonCardActivity.this.liveId);
                    jSONObject.put("vid", PersonCardActivity.this.vid == null ? "" : PersonCardActivity.this.vid);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "add_ impression").setContentExt("authorcard", "", jSONObject));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTagActivityConfig(PersonCardActivity.this.getPageContext().getPageActivity(), PersonCardActivity.this.aZQ, PersonCardActivity.this.liveId)));
            }
        });
        this.hPZ.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.3
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void clt() {
                PersonCardActivity.this.cls();
            }

            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void clu() {
            }
        });
    }

    private void initListener() {
        registerListener(this.aTF);
        registerListener(this.gKA);
        registerListener(this.gKM);
        registerListener(this.hQt);
        registerListener(this.hQu);
    }

    private void initModel() {
        this.hQg = new com.baidu.tieba.ala.person.c.a(getPageContext());
        this.hQg.a(new a.InterfaceC0683a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.4
            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0683a
            public void b(PersonUserData personUserData) {
                if (personUserData != null && !PersonCardActivity.this.isFinishing() && !PersonCardActivity.this.hQl) {
                    if (PersonCardActivity.this.isLocal && personUserData.user_info != null) {
                        String str = PersonCardActivity.this.hQq;
                        if (!TextUtils.isEmpty(PersonCardActivity.this.hQr)) {
                            str = str + PersonCardActivity.this.hQr;
                        }
                        personUserData.user_info.user_id = PersonCardActivity.this.userId;
                        personUserData.user_info.user_name = str;
                        personUserData.user_info.user_nickname = str;
                        personUserData.user_info.portrait = PersonCardActivity.this.hQp;
                        personUserData.user_info.extInfoJson = PersonCardActivity.this.hQe;
                        PersonCardActivity.this.portrait = personUserData.user_info.portrait;
                        PersonCardActivity.this.metaKey = personUserData.user_info.aLr;
                        PersonCardActivity.this.hQf.user_info = personUserData.user_info;
                        PersonCardActivity.this.hQf.login_user_info = personUserData.login_user_info;
                        PersonCardActivity.this.hQf.live_info = personUserData.live_info;
                    } else if (personUserData.user_info != null) {
                        PersonCardActivity.this.userId = personUserData.user_info.user_id;
                        PersonCardActivity.this.portrait = personUserData.user_info.portrait;
                        PersonCardActivity.this.metaKey = personUserData.user_info.aLr;
                        if (personUserData.user_info.extInfoJson != null) {
                            PersonCardActivity.this.extInfo = personUserData.user_info.extInfoJson.toString();
                        }
                        PersonCardActivity.this.HD(PersonCardActivity.this.extInfo);
                        PersonCardActivity.this.hPY.a(personUserData, false, personUserData.hadPoked, PersonCardActivity.this.aGY);
                        PersonCardActivity.this.hPZ.a(personUserData, false);
                        PersonCardActivity.this.hQa.d(personUserData);
                        PersonCardActivity.this.hQb.d(personUserData);
                        PersonCardActivity.this.hPW.a(personUserData, false, personUserData.hadPoked, PersonCardActivity.this.aGY);
                        PersonCardActivity.this.hPX.a(personUserData, false);
                        PersonCardActivity.this.invalidate();
                    }
                }
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0683a
            public void a(com.baidu.tieba.ala.person.a.c cVar) {
                PersonCardActivity.this.hQi = cVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0683a
            public void b(com.baidu.tieba.ala.person.a.c cVar) {
                PersonCardActivity.this.hQj = cVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0683a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
        this.hQh = new e(getPageContext());
        this.hQh.a(new e.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.5
            @Override // com.baidu.live.personmanager.e.a
            public void NE() {
                PersonCardActivity.this.showToast(a.h.ala_person_report_online_success);
            }

            @Override // com.baidu.live.personmanager.e.a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
    }

    public void j(String str, String str2, String str3, String str4, String str5) {
        this.hQi = null;
        this.hQj = null;
        this.hQg.k(str, str2, str3, str4, str5);
    }

    public void f(String str, String str2, String str3, String str4, String str5, String str6) {
        this.hQi = null;
        this.hQj = null;
        this.hQg.c(str, str2, str3, str4, str5, str6);
    }

    public boolean cln() {
        return (TextUtils.isEmpty(this.appId) || this.userId == null || this.userId.equals(this.aZQ)) ? false : true;
    }

    public boolean HE(String str) {
        return (TextUtils.isEmpty(this.aZQ) || TextUtils.isEmpty(str) || !str.equals(this.aZQ)) ? false : true;
    }

    public String clo() {
        return this.aZQ;
    }

    public void oK(boolean z) {
        this.hPY.oM(z);
        this.hPZ.oM(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hQk = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.hQk) {
            this.hPY.onResume();
            this.hPZ.onResume();
            this.hQa.onResume();
            this.hQb.onResume();
            this.hPW.onResume();
            this.hPX.onResume();
        }
        this.hQk = false;
    }

    public void c(PersonUserData personUserData) {
        this.hPY.a(personUserData, false);
        this.hPZ.a(personUserData, false);
        this.hQa.d(personUserData);
        this.hQb.d(personUserData);
        this.userId = personUserData.user_info.user_id;
        this.portrait = personUserData.user_info.portrait;
        this.metaKey = personUserData.user_info.aLr;
        this.showName = personUserData.user_info.getNameShow();
        j(this.userId, this.aZQ, this.groupId, this.metaKey, this.showName);
    }

    public void clp() {
        f fVar = new f(this.portrait, this.userId, this.metaKey, "1", true, getUniqueId());
        fVar.setFrom("source_person_card");
        com.baidu.live.view.a.VF().a(this.userId, fVar);
    }

    public void clq() {
        f fVar = new f(this.portrait, this.userId, this.metaKey, "1", false, getUniqueId());
        fVar.setFrom("source_person_card");
        com.baidu.live.view.a.VF().a(this.userId, fVar);
    }

    public void clr() {
        this.hQh.aF(this.userId, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cls() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new x(this, this.userId, this.groupId, this.liveId, this.aGY, this.aZQ, this.otherParams)));
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            if (this instanceof Activity) {
                overridePendingTransition(a.C0194a.alpha_in, 0);
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
        if (this.hQg != null) {
            this.hQg.onDestroy();
        }
        if (this.hPY != null) {
            this.hPY.onDestroy();
        }
        if (this.hPZ != null) {
            this.hPZ.onDestroy();
        }
        if (this.hQt != null) {
            MessageManager.getInstance().unRegisterListener(this.hQt);
        }
        if (this.hQu != null) {
            MessageManager.getInstance().unRegisterListener(this.hQu);
        }
        if (this.hQa != null) {
            this.hQa.onDestroy();
        }
        if (this.hQb != null) {
            this.hQb.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (!this.hQl) {
            this.hQl = true;
            if (this.hQh != null) {
                this.hQh.onDestroy();
            }
            Animation animation = null;
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                if (this.hQd) {
                    if (this.hPX != null) {
                        animation = this.hPX.bVW();
                    }
                } else if (this.hQc) {
                    if (this.hQb != null) {
                        animation = this.hQb.bVW();
                    }
                } else if (this.hPZ != null) {
                    animation = this.hPZ.bVW();
                }
            } else if (this.hQd) {
                if (this.hPW != null) {
                    animation = this.hPW.bVW();
                }
            } else if (this.hQc) {
                if (this.hQa != null) {
                    animation = this.hQa.bVW();
                }
            } else if (this.hPY != null) {
                animation = this.hPY.bVW();
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
                            PersonCardActivity.this.overridePendingTransition(a.C0194a.alpha_in, a.C0194a.alpha_out);
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

    private void vZ(int i) {
        if (!cln()) {
            f(this.userId, this.aZQ, this.groupId, "", this.showName, String.valueOf(i));
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }
}
