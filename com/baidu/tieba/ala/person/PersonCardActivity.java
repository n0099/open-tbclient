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
/* loaded from: classes10.dex */
public class PersonCardActivity extends BaseFragmentActivity {
    private boolean aLc;
    private String appId;
    private String bez;
    private String extInfo;
    private String groupId;
    private c hWA;
    private c hWB;
    private boolean hWC;
    private boolean hWE;
    private boolean hWF;
    private String hWH;
    private String hWI;
    private String hWJ;
    FrameLayout hWK;
    private PersonCardViewNew hWo;
    private PersonCardViewNew hWp;
    private PersonCardViewNew hWq;
    private PersonCardViewNew hWr;
    private com.baidu.tieba.ala.person.view.c hWs;
    private com.baidu.tieba.ala.person.view.c hWt;
    JSONObject hWw;
    private PersonUserData hWx;
    private com.baidu.tieba.ala.person.c.a hWy;
    private e hWz;
    private String liveId;
    private String metaKey;
    private String otherParams;
    private String portrait;
    private String showName;
    private String userId;
    private String vid;
    private boolean hWu = false;
    private boolean hWv = false;
    private boolean hWD = false;
    private String hWG = "该用户开启了神秘人尊贵身份";
    private boolean isLocal = false;
    CustomMessageListener gPp = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                PersonCardActivity.this.otherParams = str;
                if (PersonCardActivity.this.hWq != null) {
                    PersonCardActivity.this.hWq.setOtherParams(PersonCardActivity.this.otherParams);
                }
                if (PersonCardActivity.this.hWr != null) {
                    PersonCardActivity.this.hWr.setOtherParams(PersonCardActivity.this.otherParams);
                }
            }
        }
    };
    private CustomMessageListener gPd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String string;
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(PersonCardActivity.this.userId)) {
                    if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().errno == 0) {
                        if (PersonCardActivity.this.hWy != null) {
                            PersonCardActivity.this.hWy.aE(PersonCardActivity.this.userId, PersonCardActivity.this.metaKey);
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
                                if (PersonCardActivity.this.bez != null && PersonCardActivity.this.bez.equals(updateAttentionMessage.getData().toUid)) {
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
                        PersonCardActivity.this.hWq.wq(0);
                        PersonCardActivity.this.hWr.wq(0);
                    } else {
                        PersonCardActivity.this.hWq.wq(1);
                        PersonCardActivity.this.hWr.wq(1);
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(PersonCardActivity.this.getUniqueId()) && !com.baidu.live.view.a.Xr().a(updateAttentionMessage.getData(), (BdPageContext<?>) PersonCardActivity.this.getPageContext(), false)) {
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
    CustomMessageListener aYk = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener hWL = new CustomMessageListener(2913186) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener hWM = new CustomMessageListener(2913203) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.j(PersonCardActivity.this.userId, PersonCardActivity.this.bez, PersonCardActivity.this.groupId, "", PersonCardActivity.this.showName);
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
            this.hWK = (FrameLayout) findViewById(a.f.person_card_content_view);
            initModel();
            cmx();
            initView();
            this.hWs.d(this.hWx);
            this.hWt.d(this.hWx);
            this.hWq.a(this.hWx, true);
            this.hWr.a(this.hWx, true);
            this.hWo.a(this.hWx, true);
            this.hWp.a(this.hWx, true);
            if (this.isLocal) {
                String str2 = this.hWI;
                if (!TextUtils.isEmpty(this.hWJ)) {
                    str2 = str2 + this.hWJ;
                }
                this.hWx.user_info.user_id = this.userId;
                this.hWx.user_info.user_name = str2;
                this.hWx.user_info.user_nickname = str2;
                this.hWx.user_info.extInfoJson = this.hWw;
                eB(str2, this.hWH);
            }
            initListener();
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                i.ae(this.hWr.getRootView());
            } else {
                i.af(this.hWq.getRootView());
            }
            TiebaInitialize.log("c11899");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidate() {
        if (!isFinishing() && !this.hWD) {
            getContentView().removeAllViews();
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                if (this.hWv) {
                    this.hWp.getRootView().setVisibility(0);
                    this.hWo.getRootView().setVisibility(8);
                    this.hWt.getRootView().setVisibility(8);
                    this.hWs.getRootView().setVisibility(8);
                    this.hWq.getRootView().setVisibility(8);
                    this.hWr.getRootView().setVisibility(8);
                    getContentView().addView(this.hWo.getRootView());
                    i.ae(this.hWp.getRootView());
                } else if (this.hWu) {
                    this.hWt.getRootView().setVisibility(0);
                    this.hWs.getRootView().setVisibility(8);
                    this.hWq.getRootView().setVisibility(8);
                    this.hWr.getRootView().setVisibility(8);
                    this.hWp.getRootView().setVisibility(8);
                    this.hWo.getRootView().setVisibility(8);
                    getContentView().addView(this.hWt.getRootView());
                    i.ae(this.hWt.getRootView());
                } else {
                    this.hWs.getRootView().setVisibility(8);
                    this.hWt.getRootView().setVisibility(8);
                    this.hWq.getRootView().setVisibility(8);
                    this.hWr.getRootView().setVisibility(0);
                    this.hWp.getRootView().setVisibility(8);
                    this.hWo.getRootView().setVisibility(8);
                    getContentView().addView(this.hWr.getRootView());
                    i.ae(this.hWr.getRootView());
                }
            } else if (this.hWv) {
                this.hWp.getRootView().setVisibility(8);
                this.hWo.getRootView().setVisibility(0);
                this.hWt.getRootView().setVisibility(8);
                this.hWs.getRootView().setVisibility(8);
                this.hWq.getRootView().setVisibility(8);
                this.hWr.getRootView().setVisibility(8);
                getContentView().addView(this.hWo.getRootView());
                i.ae(this.hWo.getRootView());
            } else if (this.hWu) {
                this.hWs.getRootView().setVisibility(0);
                this.hWt.getRootView().setVisibility(8);
                this.hWr.getRootView().setVisibility(8);
                this.hWq.getRootView().setVisibility(8);
                this.hWp.getRootView().setVisibility(8);
                this.hWo.getRootView().setVisibility(8);
                getContentView().addView(this.hWs.getRootView());
                i.af(this.hWs.getRootView());
            } else {
                this.hWs.getRootView().setVisibility(8);
                this.hWt.getRootView().setVisibility(8);
                this.hWr.getRootView().setVisibility(8);
                this.hWq.getRootView().setVisibility(0);
                this.hWp.getRootView().setVisibility(8);
                this.hWo.getRootView().setVisibility(8);
                getContentView().addView(this.hWq.getRootView());
                i.af(this.hWq.getRootView());
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.hWD) {
            invalidate();
            this.hWq.bkr();
            this.hWr.bkr();
            this.hWs.bkr();
            this.hWt.bkr();
            this.hWp.bkr();
            this.hWo.bkr();
        }
    }

    private void eB(String str, String str2) {
        this.hWs.eC(str, str2);
        this.hWt.eC(str, str2);
    }

    private void Iq(String str) {
        if (str == null || str.length() == 0) {
            wl(0);
        }
        if (str != null && str.length() > 0) {
            try {
                this.hWw = new JSONObject(str);
                this.hWu = this.hWw.optInt("is_mysterious_man", 0) == 1;
                this.hWH = this.hWw.optString("mysterious_man_bd_portrait");
                this.hWI = this.hWw.optString("mysterious_man_nickname");
                this.hWJ = this.hWw.optString("mysterious_man_uid");
                this.hWG = this.hWw.optString("mysterious_show_text", "该用户开启了神秘人尊贵身份");
                if (this.userId != null && TbadkCoreApplication.getCurrentAccount() != null && TextUtils.equals(this.userId, TbadkCoreApplication.getCurrentAccount())) {
                    if (this.hWu) {
                        this.hWu = false;
                        this.hWv = true;
                    }
                    wl(0);
                } else if (!this.hWu) {
                    wl(2);
                } else {
                    this.isLocal = true;
                    wl(1);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ir(String str) {
        if (!isFinishing() && !this.hWD && str != null && str.length() != 0) {
            try {
                this.hWw = new JSONObject(str);
                this.hWu = this.hWw.optInt("is_mysterious_man", 0) == 1;
                this.hWH = this.hWw.optString("mysterious_man_bd_portrait");
                this.hWI = this.hWw.optString("mysterious_man_nickname");
                this.hWJ = this.hWw.optString("mysterious_man_uid");
                this.hWG = this.hWw.optString("mysterious_show_text", "该用户开启了神秘人尊贵身份");
                if (this.userId != null && TbadkCoreApplication.getCurrentAccount() != null && TextUtils.equals(this.userId, TbadkCoreApplication.getCurrentAccount()) && this.hWu) {
                    this.hWu = false;
                    this.hWv = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void cmx() {
        this.userId = getIntent().getStringExtra("PERSON_USER_ID");
        this.portrait = getIntent().getStringExtra("PERSON_PORTRAIT_URL");
        this.showName = getIntent().getStringExtra(AlaPersonCardActivityConfig.PERSON_SHOW_NAME);
        this.groupId = getIntent().getStringExtra("PERSON_GROUP_ID");
        this.liveId = getIntent().getStringExtra("PERSON_LIVE_ID");
        this.vid = getIntent().getStringExtra("vid");
        this.bez = getIntent().getStringExtra("PERSON_LIVE_OWNER_UID");
        this.aLc = getIntent().getBooleanExtra("PERSON_LIVE_OWNER_FLAG", false);
        this.appId = getIntent().getStringExtra("PERSON_APP_ID");
        this.otherParams = getIntent().getStringExtra("other_params");
        this.hWE = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_IS_FROM_GUARD_CLUB, false);
        this.hWF = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_NAV_LIVEROOM_ENABLED, false);
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
        this.hWx = new PersonUserData();
        this.hWx.user_info = new ax();
        this.hWx.location_info = new AlaLocationData();
        this.hWx.relation_info = new AlaRelationData();
        this.hWx.user_info.user_id = "1111111";
        this.hWx.user_info.user_name = "";
        this.hWx.user_info.user_nickname = "";
        this.hWx.user_info.sex = intExtra;
        this.hWx.user_info.level_id = 1;
        this.hWx.user_info.description = "";
        this.hWx.user_info.send_count = 0L;
        this.hWx.user_info.fans_count = 0L;
        this.hWx.user_info.follow_count = 0L;
        this.hWx.user_info.portrait = "";
        this.hWx.user_info.third_app_id = this.appId;
        this.hWx.location_info.location = "火星";
        this.extInfo = getIntent().getStringExtra(AlaPersonCardActivityConfig.PERSON_EXT_INFO);
        Iq(this.extInfo);
    }

    private ViewGroup getContentView() {
        return this.hWK;
    }

    private void initView() {
        if (this.hWF && TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hWF = com.baidu.live.ae.a.Qm().bwx.aNW;
        }
        this.hWs = new com.baidu.tieba.ala.person.view.c(this, false);
        this.hWs.E(this.liveId, this.bez, this.hWG);
        this.hWt = new com.baidu.tieba.ala.person.view.c(this, true);
        this.hWt.E(this.liveId, this.bez, this.hWG);
        this.hWq = new PersonCardViewNew(this, false, false);
        this.hWq.aN(this.liveId, this.bez);
        this.hWq.setOtherParams(this.otherParams);
        this.hWq.oX(this.hWE);
        this.hWq.oY(this.hWF);
        this.hWr = new PersonCardViewNew(this, true, false);
        this.hWr.aN(this.liveId, this.bez);
        this.hWr.setOtherParams(this.otherParams);
        this.hWr.oX(this.hWE);
        this.hWr.oY(this.hWF);
        this.hWo = new PersonCardViewNew(this, false, true);
        this.hWo.aN(this.liveId, this.bez);
        this.hWo.setOtherParams(this.otherParams);
        this.hWo.oX(this.hWE);
        this.hWo.oY(this.hWF);
        this.hWp = new PersonCardViewNew(this, true, true);
        this.hWp.aN(this.liveId, this.bez);
        this.hWp.setOtherParams(this.otherParams);
        this.hWp.oX(this.hWE);
        this.hWp.oY(this.hWF);
        invalidate();
        this.hWq.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.1
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cmE() {
                PersonCardActivity.this.cmD();
            }

            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cmF() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("live_id", PersonCardActivity.this.liveId);
                    jSONObject.put("vid", PersonCardActivity.this.vid == null ? "" : PersonCardActivity.this.vid);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "add_ impression").setContentExt("authorcard", "", jSONObject));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTagActivityConfig(PersonCardActivity.this.getPageContext().getPageActivity(), PersonCardActivity.this.bez, PersonCardActivity.this.liveId)));
            }
        });
        this.hWr.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.3
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cmE() {
                PersonCardActivity.this.cmD();
            }

            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cmF() {
            }
        });
    }

    private void initListener() {
        registerListener(this.aYk);
        registerListener(this.gPd);
        registerListener(this.gPp);
        registerListener(this.hWL);
        registerListener(this.hWM);
    }

    private void initModel() {
        this.hWy = new com.baidu.tieba.ala.person.c.a(getPageContext());
        this.hWy.a(new a.InterfaceC0690a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.4
            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0690a
            public void b(PersonUserData personUserData) {
                if (personUserData != null && !PersonCardActivity.this.isFinishing() && !PersonCardActivity.this.hWD) {
                    if (PersonCardActivity.this.isLocal && personUserData.user_info != null) {
                        String str = PersonCardActivity.this.hWI;
                        if (!TextUtils.isEmpty(PersonCardActivity.this.hWJ)) {
                            str = str + PersonCardActivity.this.hWJ;
                        }
                        personUserData.user_info.user_id = PersonCardActivity.this.userId;
                        personUserData.user_info.user_name = str;
                        personUserData.user_info.user_nickname = str;
                        personUserData.user_info.portrait = PersonCardActivity.this.hWH;
                        personUserData.user_info.extInfoJson = PersonCardActivity.this.hWw;
                        PersonCardActivity.this.portrait = personUserData.user_info.portrait;
                        PersonCardActivity.this.metaKey = personUserData.user_info.aPN;
                        PersonCardActivity.this.hWx.user_info = personUserData.user_info;
                        PersonCardActivity.this.hWx.login_user_info = personUserData.login_user_info;
                        PersonCardActivity.this.hWx.live_info = personUserData.live_info;
                    } else if (personUserData.user_info != null) {
                        PersonCardActivity.this.userId = personUserData.user_info.user_id;
                        PersonCardActivity.this.portrait = personUserData.user_info.portrait;
                        PersonCardActivity.this.metaKey = personUserData.user_info.aPN;
                        if (personUserData.user_info.extInfoJson != null) {
                            PersonCardActivity.this.extInfo = personUserData.user_info.extInfoJson.toString();
                        }
                        PersonCardActivity.this.Ir(PersonCardActivity.this.extInfo);
                        PersonCardActivity.this.hWq.a(personUserData, false, personUserData.hadPoked, PersonCardActivity.this.aLc);
                        PersonCardActivity.this.hWr.a(personUserData, false);
                        PersonCardActivity.this.hWs.d(personUserData);
                        PersonCardActivity.this.hWt.d(personUserData);
                        PersonCardActivity.this.hWo.a(personUserData, false, personUserData.hadPoked, PersonCardActivity.this.aLc);
                        PersonCardActivity.this.hWp.a(personUserData, false);
                        PersonCardActivity.this.invalidate();
                    }
                }
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0690a
            public void a(c cVar) {
                PersonCardActivity.this.hWA = cVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0690a
            public void b(c cVar) {
                PersonCardActivity.this.hWB = cVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0690a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
        this.hWz = new e(getPageContext());
        this.hWz.a(new e.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.5
            @Override // com.baidu.live.personmanager.e.a
            public void Pj() {
                PersonCardActivity.this.showToast(a.h.ala_person_report_online_success);
            }

            @Override // com.baidu.live.personmanager.e.a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
    }

    public void j(String str, String str2, String str3, String str4, String str5) {
        this.hWA = null;
        this.hWB = null;
        this.hWy.k(str, str2, str3, str4, str5);
    }

    public void f(String str, String str2, String str3, String str4, String str5, String str6) {
        this.hWA = null;
        this.hWB = null;
        this.hWy.c(str, str2, str3, str4, str5, str6);
    }

    public boolean cmy() {
        return (TextUtils.isEmpty(this.appId) || this.userId == null || this.userId.equals(this.bez)) ? false : true;
    }

    public boolean Is(String str) {
        return (TextUtils.isEmpty(this.bez) || TextUtils.isEmpty(str) || !str.equals(this.bez)) ? false : true;
    }

    public String cmz() {
        return this.bez;
    }

    public void oU(boolean z) {
        this.hWq.oW(z);
        this.hWr.oW(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hWC = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.hWC) {
            this.hWq.onResume();
            this.hWr.onResume();
            this.hWs.onResume();
            this.hWt.onResume();
            this.hWo.onResume();
            this.hWp.onResume();
        }
        this.hWC = false;
    }

    public void c(PersonUserData personUserData) {
        this.hWq.a(personUserData, false);
        this.hWr.a(personUserData, false);
        this.hWs.d(personUserData);
        this.hWt.d(personUserData);
        this.userId = personUserData.user_info.user_id;
        this.portrait = personUserData.user_info.portrait;
        this.metaKey = personUserData.user_info.aPN;
        this.showName = personUserData.user_info.getNameShow();
        j(this.userId, this.bez, this.groupId, this.metaKey, this.showName);
    }

    public void cmA() {
        f fVar = new f(this.portrait, this.userId, this.metaKey, "1", true, getUniqueId());
        fVar.setFrom("source_person_card");
        com.baidu.live.view.a.Xr().a(this.userId, fVar);
    }

    public void cmB() {
        f fVar = new f(this.portrait, this.userId, this.metaKey, "1", false, getUniqueId());
        fVar.setFrom("source_person_card");
        com.baidu.live.view.a.Xr().a(this.userId, fVar);
    }

    public void cmC() {
        this.hWz.aF(this.userId, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmD() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new x(this, this.userId, this.groupId, this.liveId, this.aLc, this.bez, this.otherParams)));
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            if (this instanceof Activity) {
                overridePendingTransition(a.C0201a.alpha_in, 0);
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
        if (this.hWy != null) {
            this.hWy.onDestroy();
        }
        if (this.hWo != null) {
            this.hWo.onDestroy();
        }
        if (this.hWp != null) {
            this.hWp.onDestroy();
        }
        if (this.hWq != null) {
            this.hWq.onDestroy();
        }
        if (this.hWr != null) {
            this.hWr.onDestroy();
        }
        if (this.hWL != null) {
            MessageManager.getInstance().unRegisterListener(this.hWL);
        }
        if (this.hWM != null) {
            MessageManager.getInstance().unRegisterListener(this.hWM);
        }
        if (this.hWs != null) {
            this.hWs.onDestroy();
        }
        if (this.hWt != null) {
            this.hWt.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (!this.hWD) {
            this.hWD = true;
            if (this.hWz != null) {
                this.hWz.onDestroy();
            }
            Animation animation = null;
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                if (this.hWv) {
                    if (this.hWp != null) {
                        animation = this.hWp.bWN();
                    }
                } else if (this.hWu) {
                    if (this.hWt != null) {
                        animation = this.hWt.bWN();
                    }
                } else if (this.hWr != null) {
                    animation = this.hWr.bWN();
                }
            } else if (this.hWv) {
                if (this.hWo != null) {
                    animation = this.hWo.bWN();
                }
            } else if (this.hWu) {
                if (this.hWs != null) {
                    animation = this.hWs.bWN();
                }
            } else if (this.hWq != null) {
                animation = this.hWq.bWN();
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
                            PersonCardActivity.this.overridePendingTransition(a.C0201a.alpha_in, a.C0201a.alpha_out);
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

    private void wl(int i) {
        if (!cmy()) {
            f(this.userId, this.bez, this.groupId, "", this.showName, String.valueOf(i));
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }
}
