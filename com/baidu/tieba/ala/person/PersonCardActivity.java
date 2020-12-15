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
import com.baidu.live.d.x;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.ar;
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
/* loaded from: classes4.dex */
public class PersonCardActivity extends BaseFragmentActivity {
    private boolean aLj;
    private String appId;
    private String bcY;
    private String groupId;
    private PersonCardViewNew hIC;
    private PersonCardViewNew hID;
    private String hIE;
    private PersonUserData hIF;
    private com.baidu.tieba.ala.person.c.a hIG;
    private e hIH;
    private c hII;
    private c hIJ;
    private boolean hIK;
    private boolean hIM;
    private boolean hIN;
    private String liveId;
    private String metaKey;
    private String otherParams;
    private String portrait;
    private String userId;
    private String vid;
    private boolean hIL = false;
    CustomMessageListener gDG = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                PersonCardActivity.this.otherParams = str;
                if (PersonCardActivity.this.hIC != null) {
                    PersonCardActivity.this.hIC.setOtherParams(PersonCardActivity.this.otherParams);
                }
                if (PersonCardActivity.this.hID != null) {
                    PersonCardActivity.this.hID.setOtherParams(PersonCardActivity.this.otherParams);
                }
            }
        }
    };
    private CustomMessageListener gDu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(PersonCardActivity.this.userId)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (PersonCardActivity.this.hIG != null) {
                            PersonCardActivity.this.hIG.aH(PersonCardActivity.this.userId, PersonCardActivity.this.metaKey);
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
                                if (PersonCardActivity.this.bcY != null && PersonCardActivity.this.bcY.equals(updateAttentionMessage.getData().toUid)) {
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
                        PersonCardActivity.this.hIC.xx(0);
                        PersonCardActivity.this.hID.xx(0);
                    } else {
                        PersonCardActivity.this.hIC.xx(1);
                        PersonCardActivity.this.hID.xx(1);
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(PersonCardActivity.this.getUniqueId()) && !com.baidu.live.view.a.Yo().a(updateAttentionMessage.getData(), (BdPageContext<?>) PersonCardActivity.this.getPageContext(), false)) {
                        if (updateAttentionMessage.getData().errorString != null) {
                            PersonCardActivity.this.showToast(updateAttentionMessage.getData().errorString);
                        } else {
                            PersonCardActivity.this.showToast(PersonCardActivity.this.getResources().getString(a.h.sdk_unfollow_failed_toast));
                        }
                    }
                }
            }
        }
    };
    CustomMessageListener aWM = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener hIO = new CustomMessageListener(2913186) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener hIP = new CustomMessageListener(2913203) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.j(PersonCardActivity.this.userId, PersonCardActivity.this.bcY, PersonCardActivity.this.groupId, "", PersonCardActivity.this.hIE);
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
                getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.c.sdk_transparent)));
            }
            cmm();
            initView();
            this.hIC.a(this.hIF, true);
            this.hID.a(this.hIF, true);
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                setContentView(this.hID.getRootView());
            } else {
                setContentView(this.hIC.getRootView());
            }
            initListener();
            KR();
            if (!cmn()) {
                j(this.userId, this.bcY, this.groupId, "", this.hIE);
            }
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                i.ae(this.hID.getRootView());
            } else {
                i.af(this.hIC.getRootView());
            }
            TiebaInitialize.log("c11899");
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.hIL) {
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                this.hIC.getRootView().setVisibility(8);
                this.hID.getRootView().setVisibility(0);
                setContentView(this.hID.getRootView());
                i.ae(this.hID.getRootView());
            } else {
                this.hID.getRootView().setVisibility(8);
                this.hIC.getRootView().setVisibility(0);
                setContentView(this.hIC.getRootView());
                i.af(this.hIC.getRootView());
            }
            this.hIC.blq();
            this.hID.blq();
        }
    }

    private void cmm() {
        this.userId = getIntent().getStringExtra("PERSON_USER_ID");
        this.portrait = getIntent().getStringExtra("PERSON_PORTRAIT_URL");
        this.hIE = getIntent().getStringExtra(AlaPersonCardActivityConfig.PERSON_SHOW_NAME);
        this.groupId = getIntent().getStringExtra("PERSON_GROUP_ID");
        this.liveId = getIntent().getStringExtra("PERSON_LIVE_ID");
        this.vid = getIntent().getStringExtra("vid");
        this.bcY = getIntent().getStringExtra("PERSON_LIVE_OWNER_UID");
        this.aLj = getIntent().getBooleanExtra("PERSON_LIVE_OWNER_FLAG", false);
        this.appId = getIntent().getStringExtra("PERSON_APP_ID");
        this.otherParams = getIntent().getStringExtra("other_params");
        this.hIM = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_IS_FROM_GUARD_CLUB, false);
        this.hIN = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_NAV_LIVEROOM_ENABLED, false);
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
        this.hIF = new PersonUserData();
        this.hIF.user_info = new ar();
        this.hIF.location_info = new AlaLocationData();
        this.hIF.relation_info = new AlaRelationData();
        this.hIF.user_info.user_id = this.userId;
        this.hIF.user_info.user_name = stringExtra;
        this.hIF.user_info.user_nickname = this.hIE;
        this.hIF.user_info.sex = intExtra;
        this.hIF.user_info.level_id = intExtra2;
        this.hIF.user_info.description = stringExtra4;
        this.hIF.user_info.send_count = longExtra;
        this.hIF.user_info.fans_count = longExtra2;
        this.hIF.user_info.follow_count = longExtra3;
        this.hIF.user_info.portrait = stringExtra2;
        this.hIF.user_info.third_app_id = this.appId;
        this.hIF.location_info.location = stringExtra3;
    }

    private void initView() {
        if (this.hIN && TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hIN = com.baidu.live.ae.a.RB().brA.aNV;
        }
        this.hIC = new PersonCardViewNew(this, false);
        this.hIC.aT(this.liveId, this.bcY);
        this.hIC.setOtherParams(this.otherParams);
        this.hIC.os(this.hIM);
        this.hIC.ot(this.hIN);
        this.hID = new PersonCardViewNew(this, true);
        this.hID.aT(this.liveId, this.bcY);
        this.hID.setOtherParams(this.otherParams);
        this.hID.os(this.hIM);
        this.hID.ot(this.hIN);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            this.hIC.getRootView().setVisibility(8);
            this.hID.getRootView().setVisibility(0);
        } else {
            this.hID.getRootView().setVisibility(8);
            this.hIC.getRootView().setVisibility(0);
        }
        this.hIC.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.1
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cmt() {
                PersonCardActivity.this.cms();
            }

            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cmu() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("live_id", PersonCardActivity.this.liveId);
                    jSONObject.put("vid", PersonCardActivity.this.vid == null ? "" : PersonCardActivity.this.vid);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "add_ impression").setContentExt("authorcard", "", jSONObject));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTagActivityConfig(PersonCardActivity.this.getPageContext().getPageActivity(), PersonCardActivity.this.bcY, PersonCardActivity.this.liveId)));
            }
        });
        this.hID.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.3
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cmt() {
                PersonCardActivity.this.cms();
            }

            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cmu() {
            }
        });
    }

    private void initListener() {
        registerListener(this.aWM);
        registerListener(this.gDu);
        registerListener(this.gDG);
        registerListener(this.hIO);
        registerListener(this.hIP);
    }

    private void KR() {
        this.hIG = new com.baidu.tieba.ala.person.c.a(getPageContext());
        this.hIG.a(new a.InterfaceC0708a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.4
            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0708a
            public void b(PersonUserData personUserData) {
                if (personUserData != null) {
                    if (personUserData.user_info != null) {
                        PersonCardActivity.this.userId = personUserData.user_info.user_id;
                        PersonCardActivity.this.portrait = personUserData.user_info.portrait;
                        PersonCardActivity.this.metaKey = personUserData.user_info.aPp;
                    }
                    PersonCardActivity.this.hIC.a(personUserData, false, personUserData.hadPoked, PersonCardActivity.this.aLj);
                    PersonCardActivity.this.hID.a(personUserData, false);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0708a
            public void a(c cVar) {
                PersonCardActivity.this.hII = cVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0708a
            public void b(c cVar) {
                PersonCardActivity.this.hIJ = cVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0708a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
        this.hIH = new e(getPageContext());
        this.hIH.a(new e.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.5
            @Override // com.baidu.live.personmanager.e.a
            public void Qv() {
                PersonCardActivity.this.showToast(a.h.ala_person_report_online_success);
            }

            @Override // com.baidu.live.personmanager.e.a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
    }

    public void j(String str, String str2, String str3, String str4, String str5) {
        this.hII = null;
        this.hIJ = null;
        this.hIG.k(str, str2, str3, str4, str5);
    }

    public boolean cmn() {
        return (TextUtils.isEmpty(this.appId) || this.userId == null || this.userId.equals(this.bcY)) ? false : true;
    }

    public boolean IS(String str) {
        return (TextUtils.isEmpty(this.bcY) || TextUtils.isEmpty(str) || !str.equals(this.bcY)) ? false : true;
    }

    public String cmo() {
        return this.bcY;
    }

    public void op(boolean z) {
        this.hIC.or(z);
        this.hID.or(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hIK = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.hIK) {
            this.hIC.onResume();
            this.hID.onResume();
        }
        this.hIK = false;
    }

    public void c(PersonUserData personUserData) {
        this.hIC.a(personUserData, false);
        this.hID.a(personUserData, false);
        this.userId = personUserData.user_info.user_id;
        this.portrait = personUserData.user_info.portrait;
        this.metaKey = personUserData.user_info.aPp;
        this.hIE = personUserData.user_info.getNameShow();
        j(this.userId, this.bcY, this.groupId, this.metaKey, this.hIE);
    }

    public void cmp() {
        f fVar = new f(this.portrait, this.userId, this.metaKey, "1", true, getUniqueId());
        fVar.setFrom("source_person_card");
        com.baidu.live.view.a.Yo().a(this.userId, fVar);
    }

    public void cmq() {
        f fVar = new f(this.portrait, this.userId, this.metaKey, "1", false, getUniqueId());
        fVar.setFrom("source_person_card");
        com.baidu.live.view.a.Yo().a(this.userId, fVar);
    }

    public void cmr() {
        this.hIH.aI(this.userId, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cms() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new x(this, this.userId, this.groupId, this.liveId, this.aLj, this.bcY, this.otherParams)));
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            if (this instanceof Activity) {
                overridePendingTransition(a.C0205a.alpha_in, 0);
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
        if (this.hIG != null) {
            this.hIG.onDestroy();
        }
        if (this.hIC != null) {
            this.hIC.onDestroy();
        }
        if (this.hID != null) {
            this.hID.onDestroy();
        }
        if (this.hIO != null) {
            MessageManager.getInstance().unRegisterListener(this.hIO);
        }
        if (this.hIP != null) {
            MessageManager.getInstance().unRegisterListener(this.hIP);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (!this.hIL) {
            this.hIL = true;
            if (this.hIH != null) {
                this.hIH.onDestroy();
            }
            Animation animation = null;
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                if (this.hID != null) {
                    animation = this.hID.bXi();
                }
            } else if (this.hIC != null) {
                animation = this.hIC.bXi();
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
                            PersonCardActivity.this.overridePendingTransition(a.C0205a.alpha_in, a.C0205a.alpha_out);
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
