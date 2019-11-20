package com.baidu.tieba.ala.person;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.animation.Animation;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.c;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.b;
import com.baidu.live.data.s;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.utils.g;
import com.baidu.megapp.ma.Util;
import com.baidu.tieba.ala.person.c.a;
import com.baidu.tieba.ala.person.c.d;
import com.baidu.tieba.ala.person.view.PersonCardViewNew;
/* loaded from: classes6.dex */
public class PersonCardActivity extends BaseFragmentActivity {
    private String aaH;
    private String appId;
    private com.baidu.tieba.ala.person.c.a esA;
    private d esB;
    private com.baidu.tieba.ala.person.a.d esC;
    private com.baidu.tieba.ala.person.a.d esD;
    private boolean esE;
    private boolean esF;
    private PersonCardViewNew esx;
    private PersonCardViewNew esy;
    private PersonUserData esz;
    private String groupId;
    private String liveId;
    private String metaKey;
    private String otherParams;
    private String portrait;
    private String showName;
    private String userId;
    private boolean isFinish = false;
    CustomMessageListener dEz = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                PersonCardActivity.this.otherParams = str;
                if (PersonCardActivity.this.esx != null) {
                    PersonCardActivity.this.esx.setOtherParams(PersonCardActivity.this.otherParams);
                }
                if (PersonCardActivity.this.esy != null) {
                    PersonCardActivity.this.esy.setOtherParams(PersonCardActivity.this.otherParams);
                }
            }
        }
    };
    private CustomMessageListener dEn = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(PersonCardActivity.this.userId)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (PersonCardActivity.this.esA != null) {
                            PersonCardActivity.this.esA.cs(PersonCardActivity.this.userId, PersonCardActivity.this.metaKey);
                        }
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && message.getTag().equals(PersonCardActivity.this.getUniqueId())) {
                            if (updateAttentionMessage.getData().isAttention) {
                                if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isTieba()) {
                                    PersonCardActivity.this.showToast(PersonCardActivity.this.getResources().getString(a.i.sdk_attention_success_toast));
                                    if (TextUtils.equals(PersonCardActivity.this.aaH, PersonCardActivity.this.userId) && com.baidu.live.liveroom.a.tZ().ua()) {
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913093));
                                    }
                                    PersonCardActivity.this.finish();
                                    return;
                                } else if (c.np().getBoolean("sp_key_live_play_attention_guide_support", false) && !c.np().getBoolean("ala_attention_guide_has_displayed" + TbadkCoreApplication.getCurrentAccount(), false) && PersonCardActivity.this.aaH != null && PersonCardActivity.this.aaH.equals(updateAttentionMessage.getData().toUid)) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913092));
                                    PersonCardActivity.this.finish();
                                    return;
                                } else {
                                    return;
                                }
                            }
                            PersonCardActivity.this.showToast(PersonCardActivity.this.getResources().getString(a.i.sdk_unfollow_success_toast));
                            return;
                        }
                        return;
                    }
                    if (!updateAttentionMessage.isAttention()) {
                        PersonCardActivity.this.esx.og(0);
                        PersonCardActivity.this.esy.og(0);
                    } else {
                        PersonCardActivity.this.esx.og(1);
                        PersonCardActivity.this.esy.og(1);
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(PersonCardActivity.this.getUniqueId()) && !com.baidu.live.view.a.wy().a(updateAttentionMessage.getData(), PersonCardActivity.this.getPageContext(), false) && updateAttentionMessage.getData().errorString != null) {
                        PersonCardActivity.this.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    CustomMessageListener afT = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.5
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
        aXe();
        initView();
        this.esx.a(this.esz, true);
        this.esy.a(this.esz, true);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            setContentView(this.esy.getRootView());
        } else {
            setContentView(this.esx.getRootView());
        }
        initListener();
        dv();
        if (!aXf()) {
            g(this.userId, this.aaH, this.groupId, "", this.showName);
        }
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            g.P(this.esy.getRootView());
        } else {
            g.Q(this.esx.getRootView());
        }
        TiebaInitialize.log("c11899");
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.isFinish) {
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                this.esx.getRootView().setVisibility(8);
                this.esy.getRootView().setVisibility(0);
                setContentView(this.esy.getRootView());
                g.P(this.esy.getRootView());
            } else {
                this.esy.getRootView().setVisibility(8);
                this.esx.getRootView().setVisibility(0);
                setContentView(this.esx.getRootView());
                g.Q(this.esx.getRootView());
            }
            this.esx.afC();
            this.esy.afC();
        }
    }

    private void aXe() {
        this.userId = getIntent().getStringExtra("PERSON_USER_ID");
        this.portrait = getIntent().getStringExtra("PERSON_PORTRAIT_URL");
        this.showName = getIntent().getStringExtra(AlaPersonCardActivityConfig.PERSON_SHOW_NAME);
        this.groupId = getIntent().getStringExtra("PERSON_GROUP_ID");
        this.liveId = getIntent().getStringExtra("PERSON_LIVE_ID");
        this.aaH = getIntent().getStringExtra("PERSON_LIVE_OWNER_UID");
        this.appId = getIntent().getStringExtra("PERSON_APP_ID");
        this.otherParams = getIntent().getStringExtra("other_params");
        this.esF = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_IS_FROM_GUARD_CLUB, false);
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
        this.esz = new PersonUserData();
        this.esz.user_info = new s();
        this.esz.location_info = new AlaLocationData();
        this.esz.relation_info = new AlaRelationData();
        this.esz.user_info.user_id = this.userId;
        this.esz.user_info.user_name = stringExtra;
        this.esz.user_info.user_nickname = this.showName;
        this.esz.user_info.sex = intExtra;
        this.esz.user_info.level_id = intExtra2;
        this.esz.user_info.description = stringExtra4;
        this.esz.user_info.send_count = longExtra;
        this.esz.user_info.fans_count = longExtra2;
        this.esz.user_info.follow_count = longExtra3;
        this.esz.user_info.portrait = stringExtra2;
        this.esz.user_info.third_app_id = this.appId;
        this.esz.location_info.location = stringExtra3;
    }

    private void initView() {
        this.esx = new PersonCardViewNew(this, false);
        this.esx.setOtherParams(this.otherParams);
        this.esx.is(this.esF);
        this.esy = new PersonCardViewNew(this, true);
        this.esy.setOtherParams(this.otherParams);
        this.esy.is(this.esF);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            this.esx.getRootView().setVisibility(8);
            this.esy.getRootView().setVisibility(0);
            return;
        }
        this.esy.getRootView().setVisibility(8);
        this.esx.getRootView().setVisibility(0);
    }

    private void initListener() {
        registerListener(this.afT);
        registerListener(this.dEn);
        registerListener(this.dEz);
    }

    private void dv() {
        this.esA = new com.baidu.tieba.ala.person.c.a(getPageContext());
        this.esA.a(new a.InterfaceC0379a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.1
            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0379a
            public void b(PersonUserData personUserData) {
                if (personUserData != null) {
                    if (personUserData.user_info != null) {
                        PersonCardActivity.this.userId = personUserData.user_info.user_id;
                        PersonCardActivity.this.portrait = personUserData.user_info.portrait;
                        PersonCardActivity.this.metaKey = personUserData.user_info.Sn;
                    }
                    PersonCardActivity.this.esx.a(personUserData, false);
                    PersonCardActivity.this.esy.a(personUserData, false);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0379a
            public void a(com.baidu.tieba.ala.person.a.d dVar) {
                PersonCardActivity.this.esC = dVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0379a
            public void b(com.baidu.tieba.ala.person.a.d dVar) {
                PersonCardActivity.this.esD = dVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0379a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
        this.esB = new d(getPageContext());
        this.esB.a(new d.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.2
            @Override // com.baidu.tieba.ala.person.c.d.a
            public void aXl() {
                PersonCardActivity.this.showToast(a.i.ala_person_report_online_success);
            }

            @Override // com.baidu.tieba.ala.person.c.d.a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
    }

    public void g(String str, String str2, String str3, String str4, String str5) {
        this.esC = null;
        this.esD = null;
        this.esA.h(str, str2, str3, str4, str5);
    }

    public boolean aXf() {
        return (TextUtils.isEmpty(this.appId) || this.userId == null || this.userId.equals(this.aaH)) ? false : true;
    }

    public boolean ug(String str) {
        return (TextUtils.isEmpty(this.aaH) || TextUtils.isEmpty(str) || !str.equals(this.aaH)) ? false : true;
    }

    public String aXg() {
        return this.aaH;
    }

    public void io(boolean z) {
        this.esx.iq(z);
        this.esy.iq(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.esE = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.esE) {
            this.esx.onResume();
            this.esy.onResume();
        }
        this.esE = false;
    }

    public void a(PersonUserData personUserData) {
        this.esx.a(personUserData, false);
        this.esy.a(personUserData, false);
        this.userId = personUserData.user_info.user_id;
        this.portrait = personUserData.user_info.portrait;
        this.metaKey = personUserData.user_info.Sn;
        this.showName = personUserData.user_info.getNameShow();
        g(this.userId, this.aaH, this.groupId, this.metaKey, this.showName);
    }

    public void aXh() {
        com.baidu.live.view.a.wy().a(this.userId, new b(this.portrait, this.userId, this.metaKey, "1", true, getUniqueId()));
    }

    public void aXi() {
        com.baidu.live.view.a.wy().a(this.userId, new b(this.portrait, this.userId, this.metaKey, "1", false, getUniqueId()));
    }

    public void aXj() {
        this.esB.ui(this.userId);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (this instanceof Activity) {
            overridePendingTransition(a.C0068a.alpha_in, 0);
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_bottom", "anim"), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_out_to_bottom", "anim"));
        } else {
            overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "sdk_fade_in", "anim"), 0);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.esA != null) {
            this.esA.onDestroy();
        }
        if (this.esB != null) {
            this.esB.onDestroy();
        }
        this.esx.onDestroy();
        this.esy.onDestroy();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Animation aXz;
        if (!this.isFinish) {
            this.isFinish = true;
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                aXz = this.esy.aXz();
            } else {
                aXz = this.esx.aXz();
            }
            aXz.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.6
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    PersonCardActivity.super.finish();
                    if (PersonCardActivity.this instanceof Activity) {
                        PersonCardActivity.this.overridePendingTransition(a.C0068a.alpha_in, a.C0068a.alpha_out);
                    } else {
                        PersonCardActivity.this.overridePendingTransition(0, Util.getHostResourcesId(PersonCardActivity.this.getActivity(), TbConfig.PACKAGE_NAME, "sdk_fade_out", "anim"));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    public void aXk() {
        super.finish();
    }

    public void closeActivity() {
        super.finish();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }
}
