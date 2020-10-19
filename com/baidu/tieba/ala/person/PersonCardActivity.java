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
    private boolean aIH;
    private String aYw;
    private String appId;
    private String groupId;
    private c hhA;
    private c hhB;
    private boolean hhC;
    private boolean hhE;
    private boolean hhF;
    private PersonCardViewNew hhu;
    private PersonCardViewNew hhv;
    private String hhw;
    private PersonUserData hhx;
    private com.baidu.tieba.ala.person.c.a hhy;
    private b hhz;
    private String liveId;
    private String metaKey;
    private String otherParams;
    private String portrait;
    private String userId;
    private String vid;
    private boolean hhD = false;
    CustomMessageListener gfx = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                PersonCardActivity.this.otherParams = str;
                if (PersonCardActivity.this.hhu != null) {
                    PersonCardActivity.this.hhu.setOtherParams(PersonCardActivity.this.otherParams);
                }
                if (PersonCardActivity.this.hhv != null) {
                    PersonCardActivity.this.hhv.setOtherParams(PersonCardActivity.this.otherParams);
                }
            }
        }
    };
    private CustomMessageListener gfl = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(PersonCardActivity.this.userId)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (PersonCardActivity.this.hhy != null) {
                            PersonCardActivity.this.hhy.es(PersonCardActivity.this.userId, PersonCardActivity.this.metaKey);
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
                                if (PersonCardActivity.this.aYw != null && PersonCardActivity.this.aYw.equals(updateAttentionMessage.getData().toUid)) {
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
                        PersonCardActivity.this.hhu.vN(0);
                        PersonCardActivity.this.hhv.vN(0);
                    } else {
                        PersonCardActivity.this.hhu.vN(1);
                        PersonCardActivity.this.hhv.vN(1);
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(PersonCardActivity.this.getUniqueId()) && !com.baidu.live.view.a.SY().a(updateAttentionMessage.getData(), (BdPageContext<?>) PersonCardActivity.this.getPageContext(), false) && updateAttentionMessage.getData().errorString != null) {
                        PersonCardActivity.this.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    CustomMessageListener aTf = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener hhG = new CustomMessageListener(2913186) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener hhH = new CustomMessageListener(2913203) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.j(PersonCardActivity.this.userId, PersonCardActivity.this.aYw, PersonCardActivity.this.groupId, "", PersonCardActivity.this.hhw);
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
            cdu();
            initView();
            this.hhu.a(this.hhx, true);
            this.hhv.a(this.hhx, true);
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                setContentView(this.hhv.getRootView());
            } else {
                setContentView(this.hhu.getRootView());
            }
            initListener();
            IF();
            if (!cdv()) {
                j(this.userId, this.aYw, this.groupId, "", this.hhw);
            }
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                i.aa(this.hhv.getRootView());
            } else {
                i.ab(this.hhu.getRootView());
            }
            TiebaInitialize.log("c11899");
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.hhD) {
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                this.hhu.getRootView().setVisibility(8);
                this.hhv.getRootView().setVisibility(0);
                setContentView(this.hhv.getRootView());
                i.aa(this.hhv.getRootView());
            } else {
                this.hhv.getRootView().setVisibility(8);
                this.hhu.getRootView().setVisibility(0);
                setContentView(this.hhu.getRootView());
                i.ab(this.hhu.getRootView());
            }
            this.hhu.bet();
            this.hhv.bet();
        }
    }

    private void cdu() {
        this.userId = getIntent().getStringExtra("PERSON_USER_ID");
        this.portrait = getIntent().getStringExtra("PERSON_PORTRAIT_URL");
        this.hhw = getIntent().getStringExtra(AlaPersonCardActivityConfig.PERSON_SHOW_NAME);
        this.groupId = getIntent().getStringExtra("PERSON_GROUP_ID");
        this.liveId = getIntent().getStringExtra("PERSON_LIVE_ID");
        this.vid = getIntent().getStringExtra("vid");
        this.aYw = getIntent().getStringExtra("PERSON_LIVE_OWNER_UID");
        this.aIH = getIntent().getBooleanExtra("PERSON_LIVE_OWNER_FLAG", false);
        this.appId = getIntent().getStringExtra("PERSON_APP_ID");
        this.otherParams = getIntent().getStringExtra("other_params");
        this.hhE = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_IS_FROM_GUARD_CLUB, false);
        this.hhF = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_NAV_LIVEROOM_ENABLED, false);
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
        this.hhx = new PersonUserData();
        this.hhx.user_info = new am();
        this.hhx.location_info = new AlaLocationData();
        this.hhx.relation_info = new AlaRelationData();
        this.hhx.user_info.user_id = this.userId;
        this.hhx.user_info.user_name = stringExtra;
        this.hhx.user_info.user_nickname = this.hhw;
        this.hhx.user_info.sex = intExtra;
        this.hhx.user_info.level_id = intExtra2;
        this.hhx.user_info.description = stringExtra4;
        this.hhx.user_info.send_count = longExtra;
        this.hhx.user_info.fans_count = longExtra2;
        this.hhx.user_info.follow_count = longExtra3;
        this.hhx.user_info.portrait = stringExtra2;
        this.hhx.user_info.third_app_id = this.appId;
        this.hhx.location_info.location = stringExtra3;
    }

    private void initView() {
        if (this.hhF && TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hhF = com.baidu.live.x.a.OS().blo.aLh;
        }
        this.hhu = new PersonCardViewNew(this, false);
        this.hhu.et(this.liveId, this.aYw);
        this.hhu.setOtherParams(this.otherParams);
        this.hhu.nw(this.hhE);
        this.hhu.nx(this.hhF);
        this.hhv = new PersonCardViewNew(this, true);
        this.hhv.et(this.liveId, this.aYw);
        this.hhv.setOtherParams(this.otherParams);
        this.hhv.nw(this.hhE);
        this.hhv.nx(this.hhF);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            this.hhu.getRootView().setVisibility(8);
            this.hhv.getRootView().setVisibility(0);
        } else {
            this.hhv.getRootView().setVisibility(8);
            this.hhu.getRootView().setVisibility(0);
        }
        this.hhu.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.1
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cdB() {
                PersonCardActivity.this.cdA();
            }

            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cdC() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("live_id", PersonCardActivity.this.liveId);
                    jSONObject.put("vid", PersonCardActivity.this.vid == null ? "" : PersonCardActivity.this.vid);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "add_ impression").setContentExt("authorcard", "", jSONObject));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTagActivityConfig(PersonCardActivity.this.getPageContext().getPageActivity(), PersonCardActivity.this.aYw, PersonCardActivity.this.liveId)));
            }
        });
        this.hhv.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.3
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cdB() {
                PersonCardActivity.this.cdA();
            }

            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cdC() {
            }
        });
    }

    private void initListener() {
        registerListener(this.aTf);
        registerListener(this.gfl);
        registerListener(this.gfx);
        registerListener(this.hhG);
        registerListener(this.hhH);
    }

    private void IF() {
        this.hhy = new com.baidu.tieba.ala.person.c.a(getPageContext());
        this.hhy.a(new a.InterfaceC0665a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.4
            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0665a
            public void c(PersonUserData personUserData) {
                if (personUserData != null) {
                    if (personUserData.user_info != null) {
                        PersonCardActivity.this.userId = personUserData.user_info.user_id;
                        PersonCardActivity.this.portrait = personUserData.user_info.portrait;
                        PersonCardActivity.this.metaKey = personUserData.user_info.aMu;
                    }
                    PersonCardActivity.this.hhu.a(personUserData, false);
                    PersonCardActivity.this.hhv.a(personUserData, false);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0665a
            public void a(c cVar) {
                PersonCardActivity.this.hhA = cVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0665a
            public void b(c cVar) {
                PersonCardActivity.this.hhB = cVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0665a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
        this.hhz = new b(getPageContext());
        this.hhz.a(new b.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.5
            @Override // com.baidu.live.personmanager.b.a
            public void NN() {
                PersonCardActivity.this.showToast(a.i.ala_person_report_online_success);
            }

            @Override // com.baidu.live.personmanager.b.a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
    }

    public void j(String str, String str2, String str3, String str4, String str5) {
        this.hhA = null;
        this.hhB = null;
        this.hhy.k(str, str2, str3, str4, str5);
    }

    public boolean cdv() {
        return (TextUtils.isEmpty(this.appId) || this.userId == null || this.userId.equals(this.aYw)) ? false : true;
    }

    public boolean HM(String str) {
        return (TextUtils.isEmpty(this.aYw) || TextUtils.isEmpty(str) || !str.equals(this.aYw)) ? false : true;
    }

    public String cdw() {
        return this.aYw;
    }

    public void nt(boolean z) {
        this.hhu.nv(z);
        this.hhv.nv(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hhC = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.hhC) {
            this.hhu.onResume();
            this.hhv.onResume();
        }
        this.hhC = false;
    }

    public void b(PersonUserData personUserData) {
        this.hhu.a(personUserData, false);
        this.hhv.a(personUserData, false);
        this.userId = personUserData.user_info.user_id;
        this.portrait = personUserData.user_info.portrait;
        this.metaKey = personUserData.user_info.aMu;
        this.hhw = personUserData.user_info.getNameShow();
        j(this.userId, this.aYw, this.groupId, this.metaKey, this.hhw);
    }

    public void cdx() {
        e eVar = new e(this.portrait, this.userId, this.metaKey, "1", true, getUniqueId());
        eVar.setFrom("source_person_card");
        com.baidu.live.view.a.SY().a(this.userId, eVar);
    }

    public void cdy() {
        e eVar = new e(this.portrait, this.userId, this.metaKey, "1", false, getUniqueId());
        eVar.setFrom("source_person_card");
        com.baidu.live.view.a.SY().a(this.userId, eVar);
    }

    public void cdz() {
        this.hhz.aC(this.userId, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdA() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new u(this, this.userId, this.groupId, this.liveId, this.aIH, this.aYw, this.otherParams)));
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
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hhy != null) {
            this.hhy.onDestroy();
        }
        if (this.hhu != null) {
            this.hhu.onDestroy();
        }
        if (this.hhv != null) {
            this.hhv.onDestroy();
        }
        if (this.hhG != null) {
            MessageManager.getInstance().unRegisterListener(this.hhG);
        }
        if (this.hhH != null) {
            MessageManager.getInstance().unRegisterListener(this.hhH);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (!this.hhD) {
            this.hhD = true;
            if (this.hhz != null) {
                this.hhz.onDestroy();
            }
            Animation animation = null;
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                if (this.hhv != null) {
                    animation = this.hhv.bPa();
                }
            } else if (this.hhu != null) {
                animation = this.hhu.bPa();
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

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }
}
