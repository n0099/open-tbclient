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
import com.baidu.live.c.s;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.b;
import com.baidu.live.data.z;
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
    private String aEk;
    private String appId;
    private boolean aqR;
    private PersonCardViewNew fUW;
    private PersonCardViewNew fUX;
    private PersonUserData fUY;
    private com.baidu.tieba.ala.person.c.a fUZ;
    private d fVa;
    private com.baidu.tieba.ala.person.a.d fVb;
    private com.baidu.tieba.ala.person.a.d fVc;
    private boolean fVd;
    private boolean fnR;
    private String groupId;
    private String liveId;
    private String metaKey;
    private String otherParams;
    private String portrait;
    private String showName;
    private String userId;
    private boolean isFinish = false;
    CustomMessageListener faq = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                PersonCardActivity.this.otherParams = str;
                if (PersonCardActivity.this.fUW != null) {
                    PersonCardActivity.this.fUW.setOtherParams(PersonCardActivity.this.otherParams);
                }
                if (PersonCardActivity.this.fUX != null) {
                    PersonCardActivity.this.fUX.setOtherParams(PersonCardActivity.this.otherParams);
                }
            }
        }
    };
    private CustomMessageListener fae = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(PersonCardActivity.this.userId)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (PersonCardActivity.this.fUZ != null) {
                            PersonCardActivity.this.fUZ.dj(PersonCardActivity.this.userId, PersonCardActivity.this.metaKey);
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
                                if (TextUtils.equals(PersonCardActivity.this.aEk, PersonCardActivity.this.userId) && com.baidu.live.liveroom.a.Dk().Dl()) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913093));
                                }
                                if (PersonCardActivity.this.aEk != null && PersonCardActivity.this.aEk.equals(updateAttentionMessage.getData().toUid)) {
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
                        PersonCardActivity.this.fUW.rf(0);
                        PersonCardActivity.this.fUX.rf(0);
                    } else {
                        PersonCardActivity.this.fUW.rf(1);
                        PersonCardActivity.this.fUX.rf(1);
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(PersonCardActivity.this.getUniqueId()) && !com.baidu.live.view.a.Hs().a(updateAttentionMessage.getData(), (BdPageContext<?>) PersonCardActivity.this.getPageContext(), false) && updateAttentionMessage.getData().errorString != null) {
                        PersonCardActivity.this.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    CustomMessageListener azA = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener fVe = new CustomMessageListener(2913186) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.8
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
        if (!isFinishing()) {
            String str = Build.DISPLAY;
            if (str != null && str.contains("Flyme")) {
                getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.d.sdk_transparent)));
            }
            bpu();
            initView();
            this.fUW.a(this.fUY, true);
            this.fUX.a(this.fUY, true);
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                setContentView(this.fUX.getRootView());
            } else {
                setContentView(this.fUW.getRootView());
            }
            initListener();
            zp();
            if (!bBs()) {
                g(this.userId, this.aEk, this.groupId, "", this.showName);
            }
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                h.U(this.fUX.getRootView());
            } else {
                h.V(this.fUW.getRootView());
            }
            TiebaInitialize.log("c11899");
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.isFinish) {
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                this.fUW.getRootView().setVisibility(8);
                this.fUX.getRootView().setVisibility(0);
                setContentView(this.fUX.getRootView());
                h.U(this.fUX.getRootView());
            } else {
                this.fUX.getRootView().setVisibility(8);
                this.fUW.getRootView().setVisibility(0);
                setContentView(this.fUW.getRootView());
                h.V(this.fUW.getRootView());
            }
            this.fUW.aHo();
            this.fUX.aHo();
        }
    }

    private void bpu() {
        this.userId = getIntent().getStringExtra("PERSON_USER_ID");
        this.portrait = getIntent().getStringExtra("PERSON_PORTRAIT_URL");
        this.showName = getIntent().getStringExtra(AlaPersonCardActivityConfig.PERSON_SHOW_NAME);
        this.groupId = getIntent().getStringExtra("PERSON_GROUP_ID");
        this.liveId = getIntent().getStringExtra("PERSON_LIVE_ID");
        this.aEk = getIntent().getStringExtra("PERSON_LIVE_OWNER_UID");
        this.aqR = getIntent().getBooleanExtra("PERSON_LIVE_OWNER_FLAG", false);
        this.appId = getIntent().getStringExtra("PERSON_APP_ID");
        this.otherParams = getIntent().getStringExtra("other_params");
        this.fVd = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_IS_FROM_GUARD_CLUB, false);
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
        this.fUY = new PersonUserData();
        this.fUY.user_info = new z();
        this.fUY.location_info = new AlaLocationData();
        this.fUY.relation_info = new AlaRelationData();
        this.fUY.user_info.user_id = this.userId;
        this.fUY.user_info.user_name = stringExtra;
        this.fUY.user_info.user_nickname = this.showName;
        this.fUY.user_info.sex = intExtra;
        this.fUY.user_info.level_id = intExtra2;
        this.fUY.user_info.description = stringExtra4;
        this.fUY.user_info.send_count = longExtra;
        this.fUY.user_info.fans_count = longExtra2;
        this.fUY.user_info.follow_count = longExtra3;
        this.fUY.user_info.portrait = stringExtra2;
        this.fUY.user_info.third_app_id = this.appId;
        this.fUY.location_info.location = stringExtra3;
    }

    private void initView() {
        this.fUW = new PersonCardViewNew(this, false);
        this.fUW.setOtherParams(this.otherParams);
        this.fUW.lc(this.fVd);
        this.fUX = new PersonCardViewNew(this, true);
        this.fUX.setOtherParams(this.otherParams);
        this.fUX.lc(this.fVd);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            this.fUW.getRootView().setVisibility(8);
            this.fUX.getRootView().setVisibility(0);
        } else {
            this.fUX.getRootView().setVisibility(8);
            this.fUW.getRootView().setVisibility(0);
        }
        this.fUW.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.1
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void bBy() {
                PersonCardActivity.this.bBx();
            }
        });
        this.fUX.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.2
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void bBy() {
                PersonCardActivity.this.bBx();
            }
        });
    }

    private void initListener() {
        registerListener(this.azA);
        registerListener(this.fae);
        registerListener(this.faq);
        registerListener(this.fVe);
    }

    private void zp() {
        this.fUZ = new com.baidu.tieba.ala.person.c.a(getPageContext());
        this.fUZ.a(new a.InterfaceC0532a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.3
            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0532a
            public void c(PersonUserData personUserData) {
                if (personUserData != null) {
                    if (personUserData.user_info != null) {
                        PersonCardActivity.this.userId = personUserData.user_info.user_id;
                        PersonCardActivity.this.portrait = personUserData.user_info.portrait;
                        PersonCardActivity.this.metaKey = personUserData.user_info.atT;
                    }
                    PersonCardActivity.this.fUW.a(personUserData, false);
                    PersonCardActivity.this.fUX.a(personUserData, false);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0532a
            public void a(com.baidu.tieba.ala.person.a.d dVar) {
                PersonCardActivity.this.fVb = dVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0532a
            public void b(com.baidu.tieba.ala.person.a.d dVar) {
                PersonCardActivity.this.fVc = dVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0532a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
        this.fVa = new d(getPageContext());
        this.fVa.a(new d.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.4
            @Override // com.baidu.tieba.ala.person.c.d.a
            public void bBz() {
                PersonCardActivity.this.showToast(a.i.ala_person_report_online_success);
            }

            @Override // com.baidu.tieba.ala.person.c.d.a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
    }

    public void g(String str, String str2, String str3, String str4, String str5) {
        this.fVb = null;
        this.fVc = null;
        this.fUZ.h(str, str2, str3, str4, str5);
    }

    public boolean bBs() {
        return (TextUtils.isEmpty(this.appId) || this.userId == null || this.userId.equals(this.aEk)) ? false : true;
    }

    public boolean Bk(String str) {
        return (TextUtils.isEmpty(this.aEk) || TextUtils.isEmpty(str) || !str.equals(this.aEk)) ? false : true;
    }

    public String bBt() {
        return this.aEk;
    }

    public void kZ(boolean z) {
        this.fUW.lb(z);
        this.fUX.lb(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.fnR = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.fnR) {
            this.fUW.onResume();
            this.fUX.onResume();
        }
        this.fnR = false;
    }

    public void b(PersonUserData personUserData) {
        this.fUW.a(personUserData, false);
        this.fUX.a(personUserData, false);
        this.userId = personUserData.user_info.user_id;
        this.portrait = personUserData.user_info.portrait;
        this.metaKey = personUserData.user_info.atT;
        this.showName = personUserData.user_info.getNameShow();
        g(this.userId, this.aEk, this.groupId, this.metaKey, this.showName);
    }

    public void bBu() {
        b bVar = new b(this.portrait, this.userId, this.metaKey, "1", true, getUniqueId());
        bVar.setFrom("source_person_card");
        com.baidu.live.view.a.Hs().a(this.userId, bVar);
    }

    public void bBv() {
        b bVar = new b(this.portrait, this.userId, this.metaKey, "1", false, getUniqueId());
        bVar.setFrom("source_person_card");
        com.baidu.live.view.a.Hs().a(this.userId, bVar);
    }

    public void bBw() {
        this.fVa.Bm(this.userId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBx() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new s(this, this.userId, this.groupId, this.liveId, this.aqR, this.aEk, this.otherParams)));
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (this instanceof Activity) {
            overridePendingTransition(a.C0149a.alpha_in, 0);
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
        if (this.fUZ != null) {
            this.fUZ.onDestroy();
        }
        if (this.fVa != null) {
            this.fVa.onDestroy();
        }
        if (this.fUW != null) {
            this.fUW.onDestroy();
        }
        if (this.fUX != null) {
            this.fUX.onDestroy();
        }
        if (this.fVe != null) {
            MessageManager.getInstance().unRegisterListener(this.fVe);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (!this.isFinish) {
            this.isFinish = true;
            Animation animation = null;
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                if (this.fUX != null) {
                    animation = this.fUX.bpI();
                }
            } else if (this.fUW != null) {
                animation = this.fUW.bpI();
            }
            if (animation == null) {
                super.finish();
            } else {
                animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.9
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        PersonCardActivity.super.finish();
                        if (PersonCardActivity.this instanceof Activity) {
                            PersonCardActivity.this.overridePendingTransition(a.C0149a.alpha_in, a.C0149a.alpha_out);
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
