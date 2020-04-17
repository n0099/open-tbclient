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
    private String aEe;
    private String appId;
    private boolean aqL;
    private PersonCardViewNew fUR;
    private PersonCardViewNew fUS;
    private PersonUserData fUT;
    private com.baidu.tieba.ala.person.c.a fUU;
    private d fUV;
    private com.baidu.tieba.ala.person.a.d fUW;
    private com.baidu.tieba.ala.person.a.d fUX;
    private boolean fUY;
    private boolean fnM;
    private String groupId;
    private String liveId;
    private String metaKey;
    private String otherParams;
    private String portrait;
    private String showName;
    private String userId;
    private boolean isFinish = false;
    CustomMessageListener fal = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                PersonCardActivity.this.otherParams = str;
                if (PersonCardActivity.this.fUR != null) {
                    PersonCardActivity.this.fUR.setOtherParams(PersonCardActivity.this.otherParams);
                }
                if (PersonCardActivity.this.fUS != null) {
                    PersonCardActivity.this.fUS.setOtherParams(PersonCardActivity.this.otherParams);
                }
            }
        }
    };
    private CustomMessageListener eZZ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(PersonCardActivity.this.userId)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (PersonCardActivity.this.fUU != null) {
                            PersonCardActivity.this.fUU.dj(PersonCardActivity.this.userId, PersonCardActivity.this.metaKey);
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
                                if (TextUtils.equals(PersonCardActivity.this.aEe, PersonCardActivity.this.userId) && com.baidu.live.liveroom.a.Dl().Dm()) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913093));
                                }
                                if (PersonCardActivity.this.aEe != null && PersonCardActivity.this.aEe.equals(updateAttentionMessage.getData().toUid)) {
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
                        PersonCardActivity.this.fUR.rf(0);
                        PersonCardActivity.this.fUS.rf(0);
                    } else {
                        PersonCardActivity.this.fUR.rf(1);
                        PersonCardActivity.this.fUS.rf(1);
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(PersonCardActivity.this.getUniqueId()) && !com.baidu.live.view.a.Ht().a(updateAttentionMessage.getData(), (BdPageContext<?>) PersonCardActivity.this.getPageContext(), false) && updateAttentionMessage.getData().errorString != null) {
                        PersonCardActivity.this.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    CustomMessageListener azu = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener fUZ = new CustomMessageListener(2913186) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.8
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
            bpw();
            initView();
            this.fUR.a(this.fUT, true);
            this.fUS.a(this.fUT, true);
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                setContentView(this.fUS.getRootView());
            } else {
                setContentView(this.fUR.getRootView());
            }
            initListener();
            zq();
            if (!bBu()) {
                g(this.userId, this.aEe, this.groupId, "", this.showName);
            }
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                h.U(this.fUS.getRootView());
            } else {
                h.V(this.fUR.getRootView());
            }
            TiebaInitialize.log("c11899");
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.isFinish) {
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                this.fUR.getRootView().setVisibility(8);
                this.fUS.getRootView().setVisibility(0);
                setContentView(this.fUS.getRootView());
                h.U(this.fUS.getRootView());
            } else {
                this.fUS.getRootView().setVisibility(8);
                this.fUR.getRootView().setVisibility(0);
                setContentView(this.fUR.getRootView());
                h.V(this.fUR.getRootView());
            }
            this.fUR.aHq();
            this.fUS.aHq();
        }
    }

    private void bpw() {
        this.userId = getIntent().getStringExtra("PERSON_USER_ID");
        this.portrait = getIntent().getStringExtra("PERSON_PORTRAIT_URL");
        this.showName = getIntent().getStringExtra(AlaPersonCardActivityConfig.PERSON_SHOW_NAME);
        this.groupId = getIntent().getStringExtra("PERSON_GROUP_ID");
        this.liveId = getIntent().getStringExtra("PERSON_LIVE_ID");
        this.aEe = getIntent().getStringExtra("PERSON_LIVE_OWNER_UID");
        this.aqL = getIntent().getBooleanExtra("PERSON_LIVE_OWNER_FLAG", false);
        this.appId = getIntent().getStringExtra("PERSON_APP_ID");
        this.otherParams = getIntent().getStringExtra("other_params");
        this.fUY = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_IS_FROM_GUARD_CLUB, false);
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
        this.fUT = new PersonUserData();
        this.fUT.user_info = new z();
        this.fUT.location_info = new AlaLocationData();
        this.fUT.relation_info = new AlaRelationData();
        this.fUT.user_info.user_id = this.userId;
        this.fUT.user_info.user_name = stringExtra;
        this.fUT.user_info.user_nickname = this.showName;
        this.fUT.user_info.sex = intExtra;
        this.fUT.user_info.level_id = intExtra2;
        this.fUT.user_info.description = stringExtra4;
        this.fUT.user_info.send_count = longExtra;
        this.fUT.user_info.fans_count = longExtra2;
        this.fUT.user_info.follow_count = longExtra3;
        this.fUT.user_info.portrait = stringExtra2;
        this.fUT.user_info.third_app_id = this.appId;
        this.fUT.location_info.location = stringExtra3;
    }

    private void initView() {
        this.fUR = new PersonCardViewNew(this, false);
        this.fUR.setOtherParams(this.otherParams);
        this.fUR.lc(this.fUY);
        this.fUS = new PersonCardViewNew(this, true);
        this.fUS.setOtherParams(this.otherParams);
        this.fUS.lc(this.fUY);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            this.fUR.getRootView().setVisibility(8);
            this.fUS.getRootView().setVisibility(0);
        } else {
            this.fUS.getRootView().setVisibility(8);
            this.fUR.getRootView().setVisibility(0);
        }
        this.fUR.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.1
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void bBA() {
                PersonCardActivity.this.bBz();
            }
        });
        this.fUS.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.2
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void bBA() {
                PersonCardActivity.this.bBz();
            }
        });
    }

    private void initListener() {
        registerListener(this.azu);
        registerListener(this.eZZ);
        registerListener(this.fal);
        registerListener(this.fUZ);
    }

    private void zq() {
        this.fUU = new com.baidu.tieba.ala.person.c.a(getPageContext());
        this.fUU.a(new a.InterfaceC0511a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.3
            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0511a
            public void c(PersonUserData personUserData) {
                if (personUserData != null) {
                    if (personUserData.user_info != null) {
                        PersonCardActivity.this.userId = personUserData.user_info.user_id;
                        PersonCardActivity.this.portrait = personUserData.user_info.portrait;
                        PersonCardActivity.this.metaKey = personUserData.user_info.atN;
                    }
                    PersonCardActivity.this.fUR.a(personUserData, false);
                    PersonCardActivity.this.fUS.a(personUserData, false);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0511a
            public void a(com.baidu.tieba.ala.person.a.d dVar) {
                PersonCardActivity.this.fUW = dVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0511a
            public void b(com.baidu.tieba.ala.person.a.d dVar) {
                PersonCardActivity.this.fUX = dVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0511a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
        this.fUV = new d(getPageContext());
        this.fUV.a(new d.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.4
            @Override // com.baidu.tieba.ala.person.c.d.a
            public void bBB() {
                PersonCardActivity.this.showToast(a.i.ala_person_report_online_success);
            }

            @Override // com.baidu.tieba.ala.person.c.d.a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
    }

    public void g(String str, String str2, String str3, String str4, String str5) {
        this.fUW = null;
        this.fUX = null;
        this.fUU.h(str, str2, str3, str4, str5);
    }

    public boolean bBu() {
        return (TextUtils.isEmpty(this.appId) || this.userId == null || this.userId.equals(this.aEe)) ? false : true;
    }

    public boolean Bh(String str) {
        return (TextUtils.isEmpty(this.aEe) || TextUtils.isEmpty(str) || !str.equals(this.aEe)) ? false : true;
    }

    public String bBv() {
        return this.aEe;
    }

    public void kZ(boolean z) {
        this.fUR.lb(z);
        this.fUS.lb(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.fnM = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.fnM) {
            this.fUR.onResume();
            this.fUS.onResume();
        }
        this.fnM = false;
    }

    public void b(PersonUserData personUserData) {
        this.fUR.a(personUserData, false);
        this.fUS.a(personUserData, false);
        this.userId = personUserData.user_info.user_id;
        this.portrait = personUserData.user_info.portrait;
        this.metaKey = personUserData.user_info.atN;
        this.showName = personUserData.user_info.getNameShow();
        g(this.userId, this.aEe, this.groupId, this.metaKey, this.showName);
    }

    public void bBw() {
        b bVar = new b(this.portrait, this.userId, this.metaKey, "1", true, getUniqueId());
        bVar.setFrom("source_person_card");
        com.baidu.live.view.a.Ht().a(this.userId, bVar);
    }

    public void bBx() {
        b bVar = new b(this.portrait, this.userId, this.metaKey, "1", false, getUniqueId());
        bVar.setFrom("source_person_card");
        com.baidu.live.view.a.Ht().a(this.userId, bVar);
    }

    public void bBy() {
        this.fUV.Bj(this.userId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBz() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new s(this, this.userId, this.groupId, this.liveId, this.aqL, this.aEe, this.otherParams)));
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (this instanceof Activity) {
            overridePendingTransition(a.C0128a.alpha_in, 0);
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
        if (this.fUU != null) {
            this.fUU.onDestroy();
        }
        if (this.fUV != null) {
            this.fUV.onDestroy();
        }
        if (this.fUR != null) {
            this.fUR.onDestroy();
        }
        if (this.fUS != null) {
            this.fUS.onDestroy();
        }
        if (this.fUZ != null) {
            MessageManager.getInstance().unRegisterListener(this.fUZ);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (!this.isFinish) {
            this.isFinish = true;
            Animation animation = null;
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                if (this.fUS != null) {
                    animation = this.fUS.bpK();
                }
            } else if (this.fUR != null) {
                animation = this.fUR.bpK();
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
                            PersonCardActivity.this.overridePendingTransition(a.C0128a.alpha_in, a.C0128a.alpha_out);
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
