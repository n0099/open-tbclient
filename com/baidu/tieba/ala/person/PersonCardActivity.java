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
import com.baidu.live.c.t;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.ae;
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
import com.baidu.live.utils.h;
import com.baidu.megapp.ma.Util;
import com.baidu.tieba.ala.person.c.a;
import com.baidu.tieba.ala.person.c.d;
import com.baidu.tieba.ala.person.view.PersonCardViewNew;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PersonCardActivity extends BaseFragmentActivity {
    private String aMp;
    private String appId;
    private boolean axZ;
    private String groupId;
    private PersonCardViewNew gwN;
    private PersonCardViewNew gwO;
    private PersonUserData gwP;
    private com.baidu.tieba.ala.person.c.a gwQ;
    private d gwR;
    private com.baidu.tieba.ala.person.a.d gwS;
    private com.baidu.tieba.ala.person.a.d gwT;
    private boolean gwU;
    private boolean gwV;
    private boolean gwW;
    private String liveId;
    private String metaKey;
    private String otherParams;
    private String portrait;
    private String showName;
    private String userId;
    private String vid;
    private boolean isFinish = false;
    CustomMessageListener fzr = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                PersonCardActivity.this.otherParams = str;
                if (PersonCardActivity.this.gwN != null) {
                    PersonCardActivity.this.gwN.setOtherParams(PersonCardActivity.this.otherParams);
                }
                if (PersonCardActivity.this.gwO != null) {
                    PersonCardActivity.this.gwO.setOtherParams(PersonCardActivity.this.otherParams);
                }
            }
        }
    };
    private CustomMessageListener fzf = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(PersonCardActivity.this.userId)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (PersonCardActivity.this.gwQ != null) {
                            PersonCardActivity.this.gwQ.dO(PersonCardActivity.this.userId, PersonCardActivity.this.metaKey);
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
                                if (TextUtils.equals(PersonCardActivity.this.aMp, PersonCardActivity.this.userId) && com.baidu.live.liveroom.a.Fp().Fq()) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913093));
                                }
                                if (PersonCardActivity.this.aMp != null && PersonCardActivity.this.aMp.equals(updateAttentionMessage.getData().toUid)) {
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
                        PersonCardActivity.this.gwN.si(0);
                        PersonCardActivity.this.gwO.si(0);
                    } else {
                        PersonCardActivity.this.gwN.si(1);
                        PersonCardActivity.this.gwO.si(1);
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(PersonCardActivity.this.getUniqueId()) && !com.baidu.live.view.a.Ky().a(updateAttentionMessage.getData(), (BdPageContext<?>) PersonCardActivity.this.getPageContext(), false) && updateAttentionMessage.getData().errorString != null) {
                        PersonCardActivity.this.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    CustomMessageListener aHo = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener gwX = new CustomMessageListener(2913186) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener gwY = new CustomMessageListener(2913203) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.g(PersonCardActivity.this.userId, PersonCardActivity.this.aMp, PersonCardActivity.this.groupId, "", PersonCardActivity.this.showName);
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
            bKQ();
            initView();
            this.gwN.a(this.gwP, true);
            this.gwO.a(this.gwP, true);
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                setContentView(this.gwO.getRootView());
            } else {
                setContentView(this.gwN.getRootView());
            }
            initListener();
            Bc();
            if (!bKR()) {
                g(this.userId, this.aMp, this.groupId, "", this.showName);
            }
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                h.U(this.gwO.getRootView());
            } else {
                h.V(this.gwN.getRootView());
            }
            TiebaInitialize.log("c11899");
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.isFinish) {
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                this.gwN.getRootView().setVisibility(8);
                this.gwO.getRootView().setVisibility(0);
                setContentView(this.gwO.getRootView());
                h.U(this.gwO.getRootView());
            } else {
                this.gwO.getRootView().setVisibility(8);
                this.gwN.getRootView().setVisibility(0);
                setContentView(this.gwN.getRootView());
                h.V(this.gwN.getRootView());
            }
            this.gwN.aOF();
            this.gwO.aOF();
        }
    }

    private void bKQ() {
        this.userId = getIntent().getStringExtra("PERSON_USER_ID");
        this.portrait = getIntent().getStringExtra("PERSON_PORTRAIT_URL");
        this.showName = getIntent().getStringExtra(AlaPersonCardActivityConfig.PERSON_SHOW_NAME);
        this.groupId = getIntent().getStringExtra("PERSON_GROUP_ID");
        this.liveId = getIntent().getStringExtra("PERSON_LIVE_ID");
        this.vid = getIntent().getStringExtra("vid");
        this.aMp = getIntent().getStringExtra("PERSON_LIVE_OWNER_UID");
        this.axZ = getIntent().getBooleanExtra("PERSON_LIVE_OWNER_FLAG", false);
        this.appId = getIntent().getStringExtra("PERSON_APP_ID");
        this.otherParams = getIntent().getStringExtra("other_params");
        this.gwV = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_IS_FROM_GUARD_CLUB, false);
        this.gwW = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_NAV_LIVEROOM_ENABLED, false);
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
        this.gwP = new PersonUserData();
        this.gwP.user_info = new ae();
        this.gwP.location_info = new AlaLocationData();
        this.gwP.relation_info = new AlaRelationData();
        this.gwP.user_info.user_id = this.userId;
        this.gwP.user_info.user_name = stringExtra;
        this.gwP.user_info.user_nickname = this.showName;
        this.gwP.user_info.sex = intExtra;
        this.gwP.user_info.level_id = intExtra2;
        this.gwP.user_info.description = stringExtra4;
        this.gwP.user_info.send_count = longExtra;
        this.gwP.user_info.fans_count = longExtra2;
        this.gwP.user_info.follow_count = longExtra3;
        this.gwP.user_info.portrait = stringExtra2;
        this.gwP.user_info.third_app_id = this.appId;
        this.gwP.location_info.location = stringExtra3;
    }

    private void initView() {
        if (this.gwW && TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gwW = com.baidu.live.v.a.Hm().aZp.aAp;
        }
        this.gwN = new PersonCardViewNew(this, false);
        this.gwN.setOtherParams(this.otherParams);
        this.gwN.lH(this.gwV);
        this.gwN.lI(this.gwW);
        this.gwO = new PersonCardViewNew(this, true);
        this.gwO.setOtherParams(this.otherParams);
        this.gwO.lH(this.gwV);
        this.gwO.lI(this.gwW);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            this.gwN.getRootView().setVisibility(8);
            this.gwO.getRootView().setVisibility(0);
        } else {
            this.gwO.getRootView().setVisibility(8);
            this.gwN.getRootView().setVisibility(0);
        }
        this.gwN.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.1
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void bKX() {
                PersonCardActivity.this.bKW();
            }

            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void bKY() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("live_id", PersonCardActivity.this.liveId);
                    jSONObject.put("vid", PersonCardActivity.this.vid == null ? "" : PersonCardActivity.this.vid);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "add_ impression").setContentExt("authorcard", "", jSONObject));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTagActivityConfig(PersonCardActivity.this.getPageContext().getPageActivity(), PersonCardActivity.this.aMp, PersonCardActivity.this.liveId)));
            }
        });
        this.gwO.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.3
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void bKX() {
                PersonCardActivity.this.bKW();
            }

            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void bKY() {
            }
        });
    }

    private void initListener() {
        registerListener(this.aHo);
        registerListener(this.fzf);
        registerListener(this.fzr);
        registerListener(this.gwX);
        registerListener(this.gwY);
    }

    private void Bc() {
        this.gwQ = new com.baidu.tieba.ala.person.c.a(getPageContext());
        this.gwQ.a(new a.InterfaceC0591a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.4
            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0591a
            public void c(PersonUserData personUserData) {
                if (personUserData != null) {
                    if (personUserData.user_info != null) {
                        PersonCardActivity.this.userId = personUserData.user_info.user_id;
                        PersonCardActivity.this.portrait = personUserData.user_info.portrait;
                        PersonCardActivity.this.metaKey = personUserData.user_info.aBn;
                    }
                    PersonCardActivity.this.gwN.a(personUserData, false);
                    PersonCardActivity.this.gwO.a(personUserData, false);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0591a
            public void a(com.baidu.tieba.ala.person.a.d dVar) {
                PersonCardActivity.this.gwS = dVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0591a
            public void b(com.baidu.tieba.ala.person.a.d dVar) {
                PersonCardActivity.this.gwT = dVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0591a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
        this.gwR = new d(getPageContext());
        this.gwR.a(new d.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.5
            @Override // com.baidu.tieba.ala.person.c.d.a
            public void bKZ() {
                PersonCardActivity.this.showToast(a.i.ala_person_report_online_success);
            }

            @Override // com.baidu.tieba.ala.person.c.d.a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
    }

    public void g(String str, String str2, String str3, String str4, String str5) {
        this.gwS = null;
        this.gwT = null;
        this.gwQ.h(str, str2, str3, str4, str5);
    }

    public boolean bKR() {
        return (TextUtils.isEmpty(this.appId) || this.userId == null || this.userId.equals(this.aMp)) ? false : true;
    }

    public boolean Dt(String str) {
        return (TextUtils.isEmpty(this.aMp) || TextUtils.isEmpty(str) || !str.equals(this.aMp)) ? false : true;
    }

    public String bKS() {
        return this.aMp;
    }

    public void lE(boolean z) {
        this.gwN.lG(z);
        this.gwO.lG(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gwU = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.gwU) {
            this.gwN.onResume();
            this.gwO.onResume();
        }
        this.gwU = false;
    }

    public void b(PersonUserData personUserData) {
        this.gwN.a(personUserData, false);
        this.gwO.a(personUserData, false);
        this.userId = personUserData.user_info.user_id;
        this.portrait = personUserData.user_info.portrait;
        this.metaKey = personUserData.user_info.aBn;
        this.showName = personUserData.user_info.getNameShow();
        g(this.userId, this.aMp, this.groupId, this.metaKey, this.showName);
    }

    public void bKT() {
        com.baidu.live.data.d dVar = new com.baidu.live.data.d(this.portrait, this.userId, this.metaKey, "1", true, getUniqueId());
        dVar.setFrom("source_person_card");
        com.baidu.live.view.a.Ky().a(this.userId, dVar);
    }

    public void bKU() {
        com.baidu.live.data.d dVar = new com.baidu.live.data.d(this.portrait, this.userId, this.metaKey, "1", false, getUniqueId());
        dVar.setFrom("source_person_card");
        com.baidu.live.view.a.Ky().a(this.userId, dVar);
    }

    public void bKV() {
        this.gwR.Dv(this.userId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKW() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new t(this, this.userId, this.groupId, this.liveId, this.axZ, this.aMp, this.otherParams)));
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            if (this instanceof Activity) {
                overridePendingTransition(a.C0176a.alpha_in, 0);
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
        if (this.gwQ != null) {
            this.gwQ.onDestroy();
        }
        if (this.gwR != null) {
            this.gwR.onDestroy();
        }
        if (this.gwN != null) {
            this.gwN.onDestroy();
        }
        if (this.gwO != null) {
            this.gwO.onDestroy();
        }
        if (this.gwX != null) {
            MessageManager.getInstance().unRegisterListener(this.gwX);
        }
        if (this.gwY != null) {
            MessageManager.getInstance().unRegisterListener(this.gwY);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (!this.isFinish) {
            this.isFinish = true;
            Animation animation = null;
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                if (this.gwO != null) {
                    animation = this.gwO.byx();
                }
            } else if (this.gwN != null) {
                animation = this.gwN.byx();
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
                            PersonCardActivity.this.overridePendingTransition(a.C0176a.alpha_in, a.C0176a.alpha_out);
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
