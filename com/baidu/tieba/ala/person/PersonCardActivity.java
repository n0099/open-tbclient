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
import com.baidu.live.c.u;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.ah;
import com.baidu.live.o.b;
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
import com.baidu.tieba.ala.person.a.d;
import com.baidu.tieba.ala.person.c.a;
import com.baidu.tieba.ala.person.view.PersonCardViewNew;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class PersonCardActivity extends BaseFragmentActivity {
    private boolean aEy;
    private String aSZ;
    private String appId;
    private PersonCardViewNew gOP;
    private PersonCardViewNew gOQ;
    private String gOR;
    private PersonUserData gOS;
    private com.baidu.tieba.ala.person.c.a gOT;
    private b gOU;
    private d gOV;
    private d gOW;
    private boolean gOX;
    private boolean gOZ;
    private boolean gPa;
    private String groupId;
    private String liveId;
    private String metaKey;
    private String otherParams;
    private String portrait;
    private String userId;
    private String vid;
    private boolean gOY = false;
    CustomMessageListener fPT = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                PersonCardActivity.this.otherParams = str;
                if (PersonCardActivity.this.gOP != null) {
                    PersonCardActivity.this.gOP.setOtherParams(PersonCardActivity.this.otherParams);
                }
                if (PersonCardActivity.this.gOQ != null) {
                    PersonCardActivity.this.gOQ.setOtherParams(PersonCardActivity.this.otherParams);
                }
            }
        }
    };
    private CustomMessageListener fPH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(PersonCardActivity.this.userId)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (PersonCardActivity.this.gOT != null) {
                            PersonCardActivity.this.gOT.eh(PersonCardActivity.this.userId, PersonCardActivity.this.metaKey);
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
                                if (TextUtils.equals(PersonCardActivity.this.aSZ, PersonCardActivity.this.userId) && com.baidu.live.liveroom.a.KQ().KR()) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913093));
                                }
                                if (PersonCardActivity.this.aSZ != null && PersonCardActivity.this.aSZ.equals(updateAttentionMessage.getData().toUid)) {
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
                        PersonCardActivity.this.gOP.uO(0);
                        PersonCardActivity.this.gOQ.uO(0);
                    } else {
                        PersonCardActivity.this.gOP.uO(1);
                        PersonCardActivity.this.gOQ.uO(1);
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(PersonCardActivity.this.getUniqueId()) && !com.baidu.live.view.a.Qx().a(updateAttentionMessage.getData(), (BdPageContext<?>) PersonCardActivity.this.getPageContext(), false) && updateAttentionMessage.getData().errorString != null) {
                        PersonCardActivity.this.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    CustomMessageListener aNW = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener gPb = new CustomMessageListener(2913186) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener gPc = new CustomMessageListener(2913203) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.j(PersonCardActivity.this.userId, PersonCardActivity.this.aSZ, PersonCardActivity.this.groupId, "", PersonCardActivity.this.gOR);
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
            bYa();
            initView();
            this.gOP.a(this.gOS, true);
            this.gOQ.a(this.gOS, true);
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                setContentView(this.gOQ.getRootView());
            } else {
                setContentView(this.gOP.getRootView());
            }
            initListener();
            Hh();
            if (!bYb()) {
                j(this.userId, this.aSZ, this.groupId, "", this.gOR);
            }
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                h.Y(this.gOQ.getRootView());
            } else {
                h.Z(this.gOP.getRootView());
            }
            TiebaInitialize.log("c11899");
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.gOY) {
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                this.gOP.getRootView().setVisibility(8);
                this.gOQ.getRootView().setVisibility(0);
                setContentView(this.gOQ.getRootView());
                h.Y(this.gOQ.getRootView());
            } else {
                this.gOQ.getRootView().setVisibility(8);
                this.gOP.getRootView().setVisibility(0);
                setContentView(this.gOP.getRootView());
                h.Z(this.gOP.getRootView());
            }
            this.gOP.baR();
            this.gOQ.baR();
        }
    }

    private void bYa() {
        this.userId = getIntent().getStringExtra("PERSON_USER_ID");
        this.portrait = getIntent().getStringExtra("PERSON_PORTRAIT_URL");
        this.gOR = getIntent().getStringExtra(AlaPersonCardActivityConfig.PERSON_SHOW_NAME);
        this.groupId = getIntent().getStringExtra("PERSON_GROUP_ID");
        this.liveId = getIntent().getStringExtra("PERSON_LIVE_ID");
        this.vid = getIntent().getStringExtra("vid");
        this.aSZ = getIntent().getStringExtra("PERSON_LIVE_OWNER_UID");
        this.aEy = getIntent().getBooleanExtra("PERSON_LIVE_OWNER_FLAG", false);
        this.appId = getIntent().getStringExtra("PERSON_APP_ID");
        this.otherParams = getIntent().getStringExtra("other_params");
        this.gOZ = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_IS_FROM_GUARD_CLUB, false);
        this.gPa = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_NAV_LIVEROOM_ENABLED, false);
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
        this.gOS = new PersonUserData();
        this.gOS.user_info = new ah();
        this.gOS.location_info = new AlaLocationData();
        this.gOS.relation_info = new AlaRelationData();
        this.gOS.user_info.user_id = this.userId;
        this.gOS.user_info.user_name = stringExtra;
        this.gOS.user_info.user_nickname = this.gOR;
        this.gOS.user_info.sex = intExtra;
        this.gOS.user_info.level_id = intExtra2;
        this.gOS.user_info.description = stringExtra4;
        this.gOS.user_info.send_count = longExtra;
        this.gOS.user_info.fans_count = longExtra2;
        this.gOS.user_info.follow_count = longExtra3;
        this.gOS.user_info.portrait = stringExtra2;
        this.gOS.user_info.third_app_id = this.appId;
        this.gOS.location_info.location = stringExtra3;
    }

    private void initView() {
        if (this.gPa && TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gPa = com.baidu.live.w.a.Nk().beJ.aGO;
        }
        this.gOP = new PersonCardViewNew(this, false);
        this.gOP.ei(this.liveId, this.aSZ);
        this.gOP.setOtherParams(this.otherParams);
        this.gOP.mP(this.gOZ);
        this.gOP.mQ(this.gPa);
        this.gOQ = new PersonCardViewNew(this, true);
        this.gOQ.ei(this.liveId, this.aSZ);
        this.gOQ.setOtherParams(this.otherParams);
        this.gOQ.mP(this.gOZ);
        this.gOQ.mQ(this.gPa);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            this.gOP.getRootView().setVisibility(8);
            this.gOQ.getRootView().setVisibility(0);
        } else {
            this.gOQ.getRootView().setVisibility(8);
            this.gOP.getRootView().setVisibility(0);
        }
        this.gOP.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.1
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void bYh() {
                PersonCardActivity.this.bYg();
            }

            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void bYi() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("live_id", PersonCardActivity.this.liveId);
                    jSONObject.put("vid", PersonCardActivity.this.vid == null ? "" : PersonCardActivity.this.vid);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "add_ impression").setContentExt("authorcard", "", jSONObject));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTagActivityConfig(PersonCardActivity.this.getPageContext().getPageActivity(), PersonCardActivity.this.aSZ, PersonCardActivity.this.liveId)));
            }
        });
        this.gOQ.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.3
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void bYh() {
                PersonCardActivity.this.bYg();
            }

            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void bYi() {
            }
        });
    }

    private void initListener() {
        registerListener(this.aNW);
        registerListener(this.fPH);
        registerListener(this.fPT);
        registerListener(this.gPb);
        registerListener(this.gPc);
    }

    private void Hh() {
        this.gOT = new com.baidu.tieba.ala.person.c.a(getPageContext());
        this.gOT.a(new a.InterfaceC0650a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.4
            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0650a
            public void c(PersonUserData personUserData) {
                if (personUserData != null) {
                    if (personUserData.user_info != null) {
                        PersonCardActivity.this.userId = personUserData.user_info.user_id;
                        PersonCardActivity.this.portrait = personUserData.user_info.portrait;
                        PersonCardActivity.this.metaKey = personUserData.user_info.aHU;
                    }
                    PersonCardActivity.this.gOP.a(personUserData, false);
                    PersonCardActivity.this.gOQ.a(personUserData, false);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0650a
            public void a(d dVar) {
                PersonCardActivity.this.gOV = dVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0650a
            public void b(d dVar) {
                PersonCardActivity.this.gOW = dVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0650a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
        this.gOU = new b(getPageContext());
        this.gOU.a(new b.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.5
            @Override // com.baidu.live.o.b.a
            public void Mf() {
                PersonCardActivity.this.showToast(a.i.ala_person_report_online_success);
            }

            @Override // com.baidu.live.o.b.a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
    }

    public void j(String str, String str2, String str3, String str4, String str5) {
        this.gOV = null;
        this.gOW = null;
        this.gOT.k(str, str2, str3, str4, str5);
    }

    public boolean bYb() {
        return (TextUtils.isEmpty(this.appId) || this.userId == null || this.userId.equals(this.aSZ)) ? false : true;
    }

    public boolean GF(String str) {
        return (TextUtils.isEmpty(this.aSZ) || TextUtils.isEmpty(str) || !str.equals(this.aSZ)) ? false : true;
    }

    public String bYc() {
        return this.aSZ;
    }

    public void mM(boolean z) {
        this.gOP.mO(z);
        this.gOQ.mO(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gOX = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.gOX) {
            this.gOP.onResume();
            this.gOQ.onResume();
        }
        this.gOX = false;
    }

    public void b(PersonUserData personUserData) {
        this.gOP.a(personUserData, false);
        this.gOQ.a(personUserData, false);
        this.userId = personUserData.user_info.user_id;
        this.portrait = personUserData.user_info.portrait;
        this.metaKey = personUserData.user_info.aHU;
        this.gOR = personUserData.user_info.getNameShow();
        j(this.userId, this.aSZ, this.groupId, this.metaKey, this.gOR);
    }

    public void bYd() {
        com.baidu.live.data.d dVar = new com.baidu.live.data.d(this.portrait, this.userId, this.metaKey, "1", true, getUniqueId());
        dVar.setFrom("source_person_card");
        com.baidu.live.view.a.Qx().a(this.userId, dVar);
    }

    public void bYe() {
        com.baidu.live.data.d dVar = new com.baidu.live.data.d(this.portrait, this.userId, this.metaKey, "1", false, getUniqueId());
        dVar.setFrom("source_person_card");
        com.baidu.live.view.a.Qx().a(this.userId, dVar);
    }

    public void bYf() {
        this.gOU.az(this.userId, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYg() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new u(this, this.userId, this.groupId, this.liveId, this.aEy, this.aSZ, this.otherParams)));
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            if (this instanceof Activity) {
                overridePendingTransition(a.C0185a.alpha_in, 0);
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
        if (this.gOT != null) {
            this.gOT.onDestroy();
        }
        if (this.gOP != null) {
            this.gOP.onDestroy();
        }
        if (this.gOQ != null) {
            this.gOQ.onDestroy();
        }
        if (this.gPb != null) {
            MessageManager.getInstance().unRegisterListener(this.gPb);
        }
        if (this.gPc != null) {
            MessageManager.getInstance().unRegisterListener(this.gPc);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (!this.gOY) {
            this.gOY = true;
            if (this.gOU != null) {
                this.gOU.onDestroy();
            }
            Animation animation = null;
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                if (this.gOQ != null) {
                    animation = this.gOQ.bLg();
                }
            } else if (this.gOP != null) {
                animation = this.gOP.bLg();
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
                            PersonCardActivity.this.overridePendingTransition(a.C0185a.alpha_in, a.C0185a.alpha_out);
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
