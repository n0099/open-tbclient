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
import com.baidu.live.data.w;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.utils.h;
import com.baidu.megapp.ma.Util;
import com.baidu.tieba.ala.person.c.a;
import com.baidu.tieba.ala.person.c.d;
import com.baidu.tieba.ala.person.view.PersonCardViewNew;
/* loaded from: classes2.dex */
public class PersonCardActivity extends BaseFragmentActivity {
    private String ajv;
    private String appId;
    private boolean eER;
    private PersonCardViewNew fnf;
    private PersonCardViewNew fng;
    private PersonUserData fnh;
    private com.baidu.tieba.ala.person.c.a fni;
    private d fnj;
    private com.baidu.tieba.ala.person.a.d fnk;
    private com.baidu.tieba.ala.person.a.d fnl;
    private boolean fnm;
    private String groupId;
    private String liveId;
    private String metaKey;
    private String otherParams;
    private String portrait;
    private String showName;
    private String userId;
    private boolean isFinish = false;
    CustomMessageListener erA = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                PersonCardActivity.this.otherParams = str;
                if (PersonCardActivity.this.fnf != null) {
                    PersonCardActivity.this.fnf.setOtherParams(PersonCardActivity.this.otherParams);
                }
                if (PersonCardActivity.this.fng != null) {
                    PersonCardActivity.this.fng.setOtherParams(PersonCardActivity.this.otherParams);
                }
            }
        }
    };
    private CustomMessageListener ern = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(PersonCardActivity.this.userId)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (PersonCardActivity.this.fni != null) {
                            PersonCardActivity.this.fni.cN(PersonCardActivity.this.userId, PersonCardActivity.this.metaKey);
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
                                if (TextUtils.equals(PersonCardActivity.this.ajv, PersonCardActivity.this.userId) && com.baidu.live.liveroom.a.wl().wm()) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913093));
                                }
                                if (PersonCardActivity.this.ajv != null && PersonCardActivity.this.ajv.equals(updateAttentionMessage.getData().toUid)) {
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
                        PersonCardActivity.this.fnf.qD(0);
                        PersonCardActivity.this.fng.qD(0);
                    } else {
                        PersonCardActivity.this.fnf.qD(1);
                        PersonCardActivity.this.fng.qD(1);
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(PersonCardActivity.this.getUniqueId()) && !com.baidu.live.view.a.yR().a(updateAttentionMessage.getData(), PersonCardActivity.this.getPageContext(), false) && updateAttentionMessage.getData().errorString != null) {
                        PersonCardActivity.this.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    CustomMessageListener aeN = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.5
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
        bdN();
        initView();
        this.fnf.a(this.fnh, true);
        this.fng.a(this.fnh, true);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            setContentView(this.fng.getRootView());
        } else {
            setContentView(this.fnf.getRootView());
        }
        initListener();
        dP();
        if (!bqf()) {
            g(this.userId, this.ajv, this.groupId, "", this.showName);
        }
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            h.S(this.fng.getRootView());
        } else {
            h.T(this.fnf.getRootView());
        }
        TiebaInitialize.log("c11899");
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.isFinish) {
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                this.fnf.getRootView().setVisibility(8);
                this.fng.getRootView().setVisibility(0);
                setContentView(this.fng.getRootView());
                h.S(this.fng.getRootView());
            } else {
                this.fng.getRootView().setVisibility(8);
                this.fnf.getRootView().setVisibility(0);
                setContentView(this.fnf.getRootView());
                h.T(this.fnf.getRootView());
            }
            this.fnf.awN();
            this.fng.awN();
        }
    }

    private void bdN() {
        this.userId = getIntent().getStringExtra("PERSON_USER_ID");
        this.portrait = getIntent().getStringExtra("PERSON_PORTRAIT_URL");
        this.showName = getIntent().getStringExtra(AlaPersonCardActivityConfig.PERSON_SHOW_NAME);
        this.groupId = getIntent().getStringExtra("PERSON_GROUP_ID");
        this.liveId = getIntent().getStringExtra("PERSON_LIVE_ID");
        this.ajv = getIntent().getStringExtra("PERSON_LIVE_OWNER_UID");
        this.appId = getIntent().getStringExtra("PERSON_APP_ID");
        this.otherParams = getIntent().getStringExtra("other_params");
        this.fnm = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_IS_FROM_GUARD_CLUB, false);
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
        this.fnh = new PersonUserData();
        this.fnh.user_info = new w();
        this.fnh.location_info = new AlaLocationData();
        this.fnh.relation_info = new AlaRelationData();
        this.fnh.user_info.user_id = this.userId;
        this.fnh.user_info.user_name = stringExtra;
        this.fnh.user_info.user_nickname = this.showName;
        this.fnh.user_info.sex = intExtra;
        this.fnh.user_info.level_id = intExtra2;
        this.fnh.user_info.description = stringExtra4;
        this.fnh.user_info.send_count = longExtra;
        this.fnh.user_info.fans_count = longExtra2;
        this.fnh.user_info.follow_count = longExtra3;
        this.fnh.user_info.portrait = stringExtra2;
        this.fnh.user_info.third_app_id = this.appId;
        this.fnh.location_info.location = stringExtra3;
    }

    private void initView() {
        this.fnf = new PersonCardViewNew(this, false);
        this.fnf.setOtherParams(this.otherParams);
        this.fnf.jU(this.fnm);
        this.fng = new PersonCardViewNew(this, true);
        this.fng.setOtherParams(this.otherParams);
        this.fng.jU(this.fnm);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            this.fnf.getRootView().setVisibility(8);
            this.fng.getRootView().setVisibility(0);
            return;
        }
        this.fng.getRootView().setVisibility(8);
        this.fnf.getRootView().setVisibility(0);
    }

    private void initListener() {
        registerListener(this.aeN);
        registerListener(this.ern);
        registerListener(this.erA);
    }

    private void dP() {
        this.fni = new com.baidu.tieba.ala.person.c.a(getPageContext());
        this.fni.a(new a.InterfaceC0467a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.1
            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0467a
            public void b(PersonUserData personUserData) {
                if (personUserData != null) {
                    if (personUserData.user_info != null) {
                        PersonCardActivity.this.userId = personUserData.user_info.user_id;
                        PersonCardActivity.this.portrait = personUserData.user_info.portrait;
                        PersonCardActivity.this.metaKey = personUserData.user_info.Zq;
                    }
                    PersonCardActivity.this.fnf.a(personUserData, false);
                    PersonCardActivity.this.fng.a(personUserData, false);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0467a
            public void a(com.baidu.tieba.ala.person.a.d dVar) {
                PersonCardActivity.this.fnk = dVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0467a
            public void b(com.baidu.tieba.ala.person.a.d dVar) {
                PersonCardActivity.this.fnl = dVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0467a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
        this.fnj = new d(getPageContext());
        this.fnj.a(new d.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.2
            @Override // com.baidu.tieba.ala.person.c.d.a
            public void bqk() {
                PersonCardActivity.this.showToast(a.i.ala_person_report_online_success);
            }

            @Override // com.baidu.tieba.ala.person.c.d.a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
    }

    public void g(String str, String str2, String str3, String str4, String str5) {
        this.fnk = null;
        this.fnl = null;
        this.fni.h(str, str2, str3, str4, str5);
    }

    public boolean bqf() {
        return (TextUtils.isEmpty(this.appId) || this.userId == null || this.userId.equals(this.ajv)) ? false : true;
    }

    public boolean zi(String str) {
        return (TextUtils.isEmpty(this.ajv) || TextUtils.isEmpty(str) || !str.equals(this.ajv)) ? false : true;
    }

    public String bqg() {
        return this.ajv;
    }

    public void jR(boolean z) {
        this.fnf.jT(z);
        this.fng.jT(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eER = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.eER) {
            this.fnf.onResume();
            this.fng.onResume();
        }
        this.eER = false;
    }

    public void a(PersonUserData personUserData) {
        this.fnf.a(personUserData, false);
        this.fng.a(personUserData, false);
        this.userId = personUserData.user_info.user_id;
        this.portrait = personUserData.user_info.portrait;
        this.metaKey = personUserData.user_info.Zq;
        this.showName = personUserData.user_info.getNameShow();
        g(this.userId, this.ajv, this.groupId, this.metaKey, this.showName);
    }

    public void bqh() {
        com.baidu.live.view.a.yR().a(this.userId, new b(this.portrait, this.userId, this.metaKey, "1", true, getUniqueId()));
    }

    public void bqi() {
        com.baidu.live.view.a.yR().a(this.userId, new b(this.portrait, this.userId, this.metaKey, "1", false, getUniqueId()));
    }

    public void bqj() {
        this.fnj.zk(this.userId);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (this instanceof Activity) {
            overridePendingTransition(a.C0086a.alpha_in, 0);
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
        if (this.fni != null) {
            this.fni.onDestroy();
        }
        if (this.fnj != null) {
            this.fnj.onDestroy();
        }
        this.fnf.onDestroy();
        this.fng.onDestroy();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Animation beb;
        if (!this.isFinish) {
            this.isFinish = true;
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                beb = this.fng.beb();
            } else {
                beb = this.fnf.beb();
            }
            beb.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.6
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    PersonCardActivity.super.finish();
                    if (PersonCardActivity.this instanceof Activity) {
                        PersonCardActivity.this.overridePendingTransition(a.C0086a.alpha_in, a.C0086a.alpha_out);
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

    public void bdO() {
        super.finish();
    }

    public void closeActivity() {
        super.finish();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }
}
