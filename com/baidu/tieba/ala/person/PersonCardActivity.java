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
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.b;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.u.a;
import com.baidu.live.utils.h;
import com.baidu.megapp.ma.Util;
import com.baidu.tieba.ala.person.c.a;
import com.baidu.tieba.ala.person.c.d;
import com.baidu.tieba.ala.person.view.PersonCardViewNew;
/* loaded from: classes3.dex */
public class PersonCardActivity extends BaseFragmentActivity {
    private String alD;
    private String appId;
    private boolean eIM;
    private PersonCardViewNew fpK;
    private PersonCardViewNew fpL;
    private PersonUserData fpM;
    private com.baidu.tieba.ala.person.c.a fpN;
    private d fpO;
    private com.baidu.tieba.ala.person.a.d fpP;
    private com.baidu.tieba.ala.person.a.d fpQ;
    private boolean fpR;
    private String groupId;
    private String liveId;
    private String metaKey;
    private String otherParams;
    private String portrait;
    private String showName;
    private String userId;
    private boolean isFinish = false;
    CustomMessageListener evL = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                PersonCardActivity.this.otherParams = str;
                if (PersonCardActivity.this.fpK != null) {
                    PersonCardActivity.this.fpK.setOtherParams(PersonCardActivity.this.otherParams);
                }
                if (PersonCardActivity.this.fpL != null) {
                    PersonCardActivity.this.fpL.setOtherParams(PersonCardActivity.this.otherParams);
                }
            }
        }
    };
    private CustomMessageListener evz = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(PersonCardActivity.this.userId)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (PersonCardActivity.this.fpN != null) {
                            PersonCardActivity.this.fpN.cW(PersonCardActivity.this.userId, PersonCardActivity.this.metaKey);
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
                                if (TextUtils.equals(PersonCardActivity.this.alD, PersonCardActivity.this.userId) && com.baidu.live.liveroom.a.ym().yn()) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913093));
                                }
                                if (PersonCardActivity.this.alD != null && PersonCardActivity.this.alD.equals(updateAttentionMessage.getData().toUid)) {
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
                        PersonCardActivity.this.fpK.qK(0);
                        PersonCardActivity.this.fpL.qK(0);
                    } else {
                        PersonCardActivity.this.fpK.qK(1);
                        PersonCardActivity.this.fpL.qK(1);
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(PersonCardActivity.this.getUniqueId()) && !com.baidu.live.view.a.Bj().a(updateAttentionMessage.getData(), PersonCardActivity.this.getPageContext(), false) && updateAttentionMessage.getData().errorString != null) {
                        PersonCardActivity.this.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    CustomMessageListener agU = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        String str = Build.DISPLAY;
        if (str != null && str.contains("Flyme")) {
            getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.d.sdk_transparent)));
        }
        bfZ();
        initView();
        this.fpK.a(this.fpM, true);
        this.fpL.a(this.fpM, true);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            setContentView(this.fpL.getRootView());
        } else {
            setContentView(this.fpK.getRootView());
        }
        initListener();
        dQ();
        if (!brL()) {
            g(this.userId, this.alD, this.groupId, "", this.showName);
        }
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            h.S(this.fpL.getRootView());
        } else {
            h.T(this.fpK.getRootView());
        }
        TiebaInitialize.log("c11899");
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.isFinish) {
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                this.fpK.getRootView().setVisibility(8);
                this.fpL.getRootView().setVisibility(0);
                setContentView(this.fpL.getRootView());
                h.S(this.fpL.getRootView());
            } else {
                this.fpL.getRootView().setVisibility(8);
                this.fpK.getRootView().setVisibility(0);
                setContentView(this.fpK.getRootView());
                h.T(this.fpK.getRootView());
            }
            this.fpK.azc();
            this.fpL.azc();
        }
    }

    private void bfZ() {
        this.userId = getIntent().getStringExtra("PERSON_USER_ID");
        this.portrait = getIntent().getStringExtra("PERSON_PORTRAIT_URL");
        this.showName = getIntent().getStringExtra(AlaPersonCardActivityConfig.PERSON_SHOW_NAME);
        this.groupId = getIntent().getStringExtra("PERSON_GROUP_ID");
        this.liveId = getIntent().getStringExtra("PERSON_LIVE_ID");
        this.alD = getIntent().getStringExtra("PERSON_LIVE_OWNER_UID");
        this.appId = getIntent().getStringExtra("PERSON_APP_ID");
        this.otherParams = getIntent().getStringExtra("other_params");
        this.fpR = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_IS_FROM_GUARD_CLUB, false);
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
        this.fpM = new PersonUserData();
        this.fpM.user_info = new x();
        this.fpM.location_info = new AlaLocationData();
        this.fpM.relation_info = new AlaRelationData();
        this.fpM.user_info.user_id = this.userId;
        this.fpM.user_info.user_name = stringExtra;
        this.fpM.user_info.user_nickname = this.showName;
        this.fpM.user_info.sex = intExtra;
        this.fpM.user_info.level_id = intExtra2;
        this.fpM.user_info.description = stringExtra4;
        this.fpM.user_info.send_count = longExtra;
        this.fpM.user_info.fans_count = longExtra2;
        this.fpM.user_info.follow_count = longExtra3;
        this.fpM.user_info.portrait = stringExtra2;
        this.fpM.user_info.third_app_id = this.appId;
        this.fpM.location_info.location = stringExtra3;
    }

    private void initView() {
        this.fpK = new PersonCardViewNew(this, false);
        this.fpK.setOtherParams(this.otherParams);
        this.fpK.jW(this.fpR);
        this.fpL = new PersonCardViewNew(this, true);
        this.fpL.setOtherParams(this.otherParams);
        this.fpL.jW(this.fpR);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            this.fpK.getRootView().setVisibility(8);
            this.fpL.getRootView().setVisibility(0);
            return;
        }
        this.fpL.getRootView().setVisibility(8);
        this.fpK.getRootView().setVisibility(0);
    }

    private void initListener() {
        registerListener(this.agU);
        registerListener(this.evz);
        registerListener(this.evL);
    }

    private void dQ() {
        this.fpN = new com.baidu.tieba.ala.person.c.a(getPageContext());
        this.fpN.a(new a.InterfaceC0475a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.1
            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0475a
            public void c(PersonUserData personUserData) {
                if (personUserData != null) {
                    if (personUserData.user_info != null) {
                        PersonCardActivity.this.userId = personUserData.user_info.user_id;
                        PersonCardActivity.this.portrait = personUserData.user_info.portrait;
                        PersonCardActivity.this.metaKey = personUserData.user_info.abj;
                    }
                    PersonCardActivity.this.fpK.a(personUserData, false);
                    PersonCardActivity.this.fpL.a(personUserData, false);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0475a
            public void a(com.baidu.tieba.ala.person.a.d dVar) {
                PersonCardActivity.this.fpP = dVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0475a
            public void b(com.baidu.tieba.ala.person.a.d dVar) {
                PersonCardActivity.this.fpQ = dVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0475a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
        this.fpO = new d(getPageContext());
        this.fpO.a(new d.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.2
            @Override // com.baidu.tieba.ala.person.c.d.a
            public void brQ() {
                PersonCardActivity.this.showToast(a.i.ala_person_report_online_success);
            }

            @Override // com.baidu.tieba.ala.person.c.d.a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
    }

    public void g(String str, String str2, String str3, String str4, String str5) {
        this.fpP = null;
        this.fpQ = null;
        this.fpN.h(str, str2, str3, str4, str5);
    }

    public boolean brL() {
        return (TextUtils.isEmpty(this.appId) || this.userId == null || this.userId.equals(this.alD)) ? false : true;
    }

    public boolean zA(String str) {
        return (TextUtils.isEmpty(this.alD) || TextUtils.isEmpty(str) || !str.equals(this.alD)) ? false : true;
    }

    public String brM() {
        return this.alD;
    }

    public void jT(boolean z) {
        this.fpK.jV(z);
        this.fpL.jV(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eIM = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.eIM) {
            this.fpK.onResume();
            this.fpL.onResume();
        }
        this.eIM = false;
    }

    public void b(PersonUserData personUserData) {
        this.fpK.a(personUserData, false);
        this.fpL.a(personUserData, false);
        this.userId = personUserData.user_info.user_id;
        this.portrait = personUserData.user_info.portrait;
        this.metaKey = personUserData.user_info.abj;
        this.showName = personUserData.user_info.getNameShow();
        g(this.userId, this.alD, this.groupId, this.metaKey, this.showName);
    }

    public void brN() {
        com.baidu.live.view.a.Bj().a(this.userId, new b(this.portrait, this.userId, this.metaKey, "1", true, getUniqueId()));
    }

    public void brO() {
        com.baidu.live.view.a.Bj().a(this.userId, new b(this.portrait, this.userId, this.metaKey, "1", false, getUniqueId()));
    }

    public void brP() {
        this.fpO.zC(this.userId);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (this instanceof Activity) {
            overridePendingTransition(a.C0102a.alpha_in, 0);
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_bottom", ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_out_to_bottom", ResUtils.ANIM));
        } else {
            overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "sdk_fade_in", ResUtils.ANIM), 0);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fpN != null) {
            this.fpN.onDestroy();
        }
        if (this.fpO != null) {
            this.fpO.onDestroy();
        }
        this.fpK.onDestroy();
        this.fpL.onDestroy();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Animation bgn;
        if (!this.isFinish) {
            this.isFinish = true;
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                bgn = this.fpL.bgn();
            } else {
                bgn = this.fpK.bgn();
            }
            bgn.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.6
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    PersonCardActivity.super.finish();
                    if (PersonCardActivity.this instanceof Activity) {
                        PersonCardActivity.this.overridePendingTransition(a.C0102a.alpha_in, a.C0102a.alpha_out);
                    } else {
                        PersonCardActivity.this.overridePendingTransition(0, Util.getHostResourcesId(PersonCardActivity.this.getActivity(), TbConfig.PACKAGE_NAME, "sdk_fade_out", ResUtils.ANIM));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    public void bga() {
        super.finish();
    }

    public void closeActivity() {
        super.finish();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }
}
