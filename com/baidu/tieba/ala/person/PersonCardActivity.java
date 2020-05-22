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
import com.baidu.live.c.s;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.ad;
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
import com.baidu.live.u.a;
import com.baidu.live.utils.h;
import com.baidu.megapp.ma.Util;
import com.baidu.tieba.ala.person.c.a;
import com.baidu.tieba.ala.person.c.d;
import com.baidu.tieba.ala.person.view.PersonCardViewNew;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PersonCardActivity extends BaseFragmentActivity {
    private String aJJ;
    private String appId;
    private boolean avR;
    private PersonCardViewNew gjP;
    private PersonCardViewNew gjQ;
    private PersonUserData gjR;
    private com.baidu.tieba.ala.person.c.a gjS;
    private d gjT;
    private com.baidu.tieba.ala.person.a.d gjU;
    private com.baidu.tieba.ala.person.a.d gjV;
    private boolean gjW;
    private boolean gjX;
    private String groupId;
    private String liveId;
    private String metaKey;
    private String otherParams;
    private String portrait;
    private String showName;
    private String userId;
    private String vid;
    private boolean isFinish = false;
    CustomMessageListener fnT = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                PersonCardActivity.this.otherParams = str;
                if (PersonCardActivity.this.gjP != null) {
                    PersonCardActivity.this.gjP.setOtherParams(PersonCardActivity.this.otherParams);
                }
                if (PersonCardActivity.this.gjQ != null) {
                    PersonCardActivity.this.gjQ.setOtherParams(PersonCardActivity.this.otherParams);
                }
            }
        }
    };
    private CustomMessageListener fnH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(PersonCardActivity.this.userId)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (PersonCardActivity.this.gjS != null) {
                            PersonCardActivity.this.gjS.dJ(PersonCardActivity.this.userId, PersonCardActivity.this.metaKey);
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
                                if (TextUtils.equals(PersonCardActivity.this.aJJ, PersonCardActivity.this.userId) && com.baidu.live.liveroom.a.EI().EJ()) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913093));
                                }
                                if (PersonCardActivity.this.aJJ != null && PersonCardActivity.this.aJJ.equals(updateAttentionMessage.getData().toUid)) {
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
                        PersonCardActivity.this.gjP.rI(0);
                        PersonCardActivity.this.gjQ.rI(0);
                    } else {
                        PersonCardActivity.this.gjP.rI(1);
                        PersonCardActivity.this.gjQ.rI(1);
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(PersonCardActivity.this.getUniqueId()) && !com.baidu.live.view.a.Jl().a(updateAttentionMessage.getData(), (BdPageContext<?>) PersonCardActivity.this.getPageContext(), false) && updateAttentionMessage.getData().errorString != null) {
                        PersonCardActivity.this.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    CustomMessageListener aES = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener gjY = new CustomMessageListener(2913186) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener gjZ = new CustomMessageListener(2913203) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.g(PersonCardActivity.this.userId, PersonCardActivity.this.aJJ, PersonCardActivity.this.groupId, "", PersonCardActivity.this.showName);
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
            bHJ();
            initView();
            this.gjP.a(this.gjR, true);
            this.gjQ.a(this.gjR, true);
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                setContentView(this.gjQ.getRootView());
            } else {
                setContentView(this.gjP.getRootView());
            }
            initListener();
            AC();
            if (!bHK()) {
                g(this.userId, this.aJJ, this.groupId, "", this.showName);
            }
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                h.T(this.gjQ.getRootView());
            } else {
                h.U(this.gjP.getRootView());
            }
            TiebaInitialize.log("c11899");
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.isFinish) {
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                this.gjP.getRootView().setVisibility(8);
                this.gjQ.getRootView().setVisibility(0);
                setContentView(this.gjQ.getRootView());
                h.T(this.gjQ.getRootView());
            } else {
                this.gjQ.getRootView().setVisibility(8);
                this.gjP.getRootView().setVisibility(0);
                setContentView(this.gjP.getRootView());
                h.U(this.gjP.getRootView());
            }
            this.gjP.aNc();
            this.gjQ.aNc();
        }
    }

    private void bHJ() {
        this.userId = getIntent().getStringExtra("PERSON_USER_ID");
        this.portrait = getIntent().getStringExtra("PERSON_PORTRAIT_URL");
        this.showName = getIntent().getStringExtra(AlaPersonCardActivityConfig.PERSON_SHOW_NAME);
        this.groupId = getIntent().getStringExtra("PERSON_GROUP_ID");
        this.liveId = getIntent().getStringExtra("PERSON_LIVE_ID");
        this.vid = getIntent().getStringExtra("vid");
        this.aJJ = getIntent().getStringExtra("PERSON_LIVE_OWNER_UID");
        this.avR = getIntent().getBooleanExtra("PERSON_LIVE_OWNER_FLAG", false);
        this.appId = getIntent().getStringExtra("PERSON_APP_ID");
        this.otherParams = getIntent().getStringExtra("other_params");
        this.gjX = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_IS_FROM_GUARD_CLUB, false);
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
        this.gjR = new PersonUserData();
        this.gjR.user_info = new ad();
        this.gjR.location_info = new AlaLocationData();
        this.gjR.relation_info = new AlaRelationData();
        this.gjR.user_info.user_id = this.userId;
        this.gjR.user_info.user_name = stringExtra;
        this.gjR.user_info.user_nickname = this.showName;
        this.gjR.user_info.sex = intExtra;
        this.gjR.user_info.level_id = intExtra2;
        this.gjR.user_info.description = stringExtra4;
        this.gjR.user_info.send_count = longExtra;
        this.gjR.user_info.fans_count = longExtra2;
        this.gjR.user_info.follow_count = longExtra3;
        this.gjR.user_info.portrait = stringExtra2;
        this.gjR.user_info.third_app_id = this.appId;
        this.gjR.location_info.location = stringExtra3;
    }

    private void initView() {
        this.gjP = new PersonCardViewNew(this, false);
        this.gjP.setOtherParams(this.otherParams);
        this.gjP.lz(this.gjX);
        this.gjQ = new PersonCardViewNew(this, true);
        this.gjQ.setOtherParams(this.otherParams);
        this.gjQ.lz(this.gjX);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            this.gjP.getRootView().setVisibility(8);
            this.gjQ.getRootView().setVisibility(0);
        } else {
            this.gjQ.getRootView().setVisibility(8);
            this.gjP.getRootView().setVisibility(0);
        }
        this.gjP.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.1
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void bHQ() {
                PersonCardActivity.this.bHP();
            }

            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void bHR() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("live_id", PersonCardActivity.this.liveId);
                    jSONObject.put("vid", PersonCardActivity.this.vid == null ? "" : PersonCardActivity.this.vid);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "add_ impression").setContentExt("authorcard", "", jSONObject));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTagActivityConfig(PersonCardActivity.this.getPageContext().getPageActivity(), PersonCardActivity.this.aJJ, PersonCardActivity.this.liveId)));
            }
        });
        this.gjQ.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.3
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void bHQ() {
                PersonCardActivity.this.bHP();
            }

            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void bHR() {
            }
        });
    }

    private void initListener() {
        registerListener(this.aES);
        registerListener(this.fnH);
        registerListener(this.fnT);
        registerListener(this.gjY);
        registerListener(this.gjZ);
    }

    private void AC() {
        this.gjS = new com.baidu.tieba.ala.person.c.a(getPageContext());
        this.gjS.a(new a.InterfaceC0582a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.4
            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0582a
            public void c(PersonUserData personUserData) {
                if (personUserData != null) {
                    if (personUserData.user_info != null) {
                        PersonCardActivity.this.userId = personUserData.user_info.user_id;
                        PersonCardActivity.this.portrait = personUserData.user_info.portrait;
                        PersonCardActivity.this.metaKey = personUserData.user_info.ayW;
                    }
                    PersonCardActivity.this.gjP.a(personUserData, false);
                    PersonCardActivity.this.gjQ.a(personUserData, false);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0582a
            public void a(com.baidu.tieba.ala.person.a.d dVar) {
                PersonCardActivity.this.gjU = dVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0582a
            public void b(com.baidu.tieba.ala.person.a.d dVar) {
                PersonCardActivity.this.gjV = dVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0582a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
        this.gjT = new d(getPageContext());
        this.gjT.a(new d.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.5
            @Override // com.baidu.tieba.ala.person.c.d.a
            public void bHS() {
                PersonCardActivity.this.showToast(a.i.ala_person_report_online_success);
            }

            @Override // com.baidu.tieba.ala.person.c.d.a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
    }

    public void g(String str, String str2, String str3, String str4, String str5) {
        this.gjU = null;
        this.gjV = null;
        this.gjS.h(str, str2, str3, str4, str5);
    }

    public boolean bHK() {
        return (TextUtils.isEmpty(this.appId) || this.userId == null || this.userId.equals(this.aJJ)) ? false : true;
    }

    public boolean CS(String str) {
        return (TextUtils.isEmpty(this.aJJ) || TextUtils.isEmpty(str) || !str.equals(this.aJJ)) ? false : true;
    }

    public String bHL() {
        return this.aJJ;
    }

    public void lw(boolean z) {
        this.gjP.ly(z);
        this.gjQ.ly(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gjW = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.gjW) {
            this.gjP.onResume();
            this.gjQ.onResume();
        }
        this.gjW = false;
    }

    public void b(PersonUserData personUserData) {
        this.gjP.a(personUserData, false);
        this.gjQ.a(personUserData, false);
        this.userId = personUserData.user_info.user_id;
        this.portrait = personUserData.user_info.portrait;
        this.metaKey = personUserData.user_info.ayW;
        this.showName = personUserData.user_info.getNameShow();
        g(this.userId, this.aJJ, this.groupId, this.metaKey, this.showName);
    }

    public void bHM() {
        com.baidu.live.data.d dVar = new com.baidu.live.data.d(this.portrait, this.userId, this.metaKey, "1", true, getUniqueId());
        dVar.setFrom("source_person_card");
        com.baidu.live.view.a.Jl().a(this.userId, dVar);
    }

    public void bHN() {
        com.baidu.live.data.d dVar = new com.baidu.live.data.d(this.portrait, this.userId, this.metaKey, "1", false, getUniqueId());
        dVar.setFrom("source_person_card");
        com.baidu.live.view.a.Jl().a(this.userId, dVar);
    }

    public void bHO() {
        this.gjT.CU(this.userId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHP() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new s(this, this.userId, this.groupId, this.liveId, this.avR, this.aJJ, this.otherParams)));
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            if (this instanceof Activity) {
                overridePendingTransition(a.C0182a.alpha_in, 0);
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
        if (this.gjS != null) {
            this.gjS.onDestroy();
        }
        if (this.gjT != null) {
            this.gjT.onDestroy();
        }
        if (this.gjP != null) {
            this.gjP.onDestroy();
        }
        if (this.gjQ != null) {
            this.gjQ.onDestroy();
        }
        if (this.gjY != null) {
            MessageManager.getInstance().unRegisterListener(this.gjY);
        }
        if (this.gjZ != null) {
            MessageManager.getInstance().unRegisterListener(this.gjZ);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (!this.isFinish) {
            this.isFinish = true;
            Animation animation = null;
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                if (this.gjQ != null) {
                    animation = this.gjQ.bvz();
                }
            } else if (this.gjP != null) {
                animation = this.gjP.bvz();
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
                            PersonCardActivity.this.overridePendingTransition(a.C0182a.alpha_in, a.C0182a.alpha_out);
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
