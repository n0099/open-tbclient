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
import com.baidu.live.b.w;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.aq;
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
    private boolean aKf;
    private String appId;
    private String bbl;
    private String groupId;
    private PersonCardViewNew hzo;
    private PersonCardViewNew hzp;
    private String hzq;
    private PersonUserData hzr;
    private com.baidu.tieba.ala.person.c.a hzs;
    private e hzt;
    private c hzu;
    private c hzv;
    private boolean hzw;
    private boolean hzy;
    private boolean hzz;
    private String liveId;
    private String metaKey;
    private String otherParams;
    private String portrait;
    private String userId;
    private String vid;
    private boolean hzx = false;
    CustomMessageListener gvo = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                PersonCardActivity.this.otherParams = str;
                if (PersonCardActivity.this.hzo != null) {
                    PersonCardActivity.this.hzo.setOtherParams(PersonCardActivity.this.otherParams);
                }
                if (PersonCardActivity.this.hzp != null) {
                    PersonCardActivity.this.hzp.setOtherParams(PersonCardActivity.this.otherParams);
                }
            }
        }
    };
    private CustomMessageListener gvc = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(PersonCardActivity.this.userId)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (PersonCardActivity.this.hzs != null) {
                            PersonCardActivity.this.hzs.aE(PersonCardActivity.this.userId, PersonCardActivity.this.metaKey);
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
                                if (PersonCardActivity.this.bbl != null && PersonCardActivity.this.bbl.equals(updateAttentionMessage.getData().toUid)) {
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
                        PersonCardActivity.this.hzo.wu(0);
                        PersonCardActivity.this.hzp.wu(0);
                    } else {
                        PersonCardActivity.this.hzo.wu(1);
                        PersonCardActivity.this.hzp.wu(1);
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(PersonCardActivity.this.getUniqueId()) && !com.baidu.live.view.a.Wx().a(updateAttentionMessage.getData(), (BdPageContext<?>) PersonCardActivity.this.getPageContext(), false) && updateAttentionMessage.getData().errorString != null) {
                        PersonCardActivity.this.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    CustomMessageListener aVt = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener hzA = new CustomMessageListener(2913186) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener hzB = new CustomMessageListener(2913203) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.j(PersonCardActivity.this.userId, PersonCardActivity.this.bbl, PersonCardActivity.this.groupId, "", PersonCardActivity.this.hzq);
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
            ciY();
            initView();
            this.hzo.a(this.hzr, true);
            this.hzp.a(this.hzr, true);
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                setContentView(this.hzp.getRootView());
            } else {
                setContentView(this.hzo.getRootView());
            }
            initListener();
            Jz();
            if (!ciZ()) {
                j(this.userId, this.bbl, this.groupId, "", this.hzq);
            }
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                i.ae(this.hzp.getRootView());
            } else {
                i.af(this.hzo.getRootView());
            }
            TiebaInitialize.log("c11899");
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.hzx) {
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                this.hzo.getRootView().setVisibility(8);
                this.hzp.getRootView().setVisibility(0);
                setContentView(this.hzp.getRootView());
                i.ae(this.hzp.getRootView());
            } else {
                this.hzp.getRootView().setVisibility(8);
                this.hzo.getRootView().setVisibility(0);
                setContentView(this.hzo.getRootView());
                i.af(this.hzo.getRootView());
            }
            this.hzo.biM();
            this.hzp.biM();
        }
    }

    private void ciY() {
        this.userId = getIntent().getStringExtra("PERSON_USER_ID");
        this.portrait = getIntent().getStringExtra("PERSON_PORTRAIT_URL");
        this.hzq = getIntent().getStringExtra(AlaPersonCardActivityConfig.PERSON_SHOW_NAME);
        this.groupId = getIntent().getStringExtra("PERSON_GROUP_ID");
        this.liveId = getIntent().getStringExtra("PERSON_LIVE_ID");
        this.vid = getIntent().getStringExtra("vid");
        this.bbl = getIntent().getStringExtra("PERSON_LIVE_OWNER_UID");
        this.aKf = getIntent().getBooleanExtra("PERSON_LIVE_OWNER_FLAG", false);
        this.appId = getIntent().getStringExtra("PERSON_APP_ID");
        this.otherParams = getIntent().getStringExtra("other_params");
        this.hzy = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_IS_FROM_GUARD_CLUB, false);
        this.hzz = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_NAV_LIVEROOM_ENABLED, false);
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
        this.hzr = new PersonUserData();
        this.hzr.user_info = new aq();
        this.hzr.location_info = new AlaLocationData();
        this.hzr.relation_info = new AlaRelationData();
        this.hzr.user_info.user_id = this.userId;
        this.hzr.user_info.user_name = stringExtra;
        this.hzr.user_info.user_nickname = this.hzq;
        this.hzr.user_info.sex = intExtra;
        this.hzr.user_info.level_id = intExtra2;
        this.hzr.user_info.description = stringExtra4;
        this.hzr.user_info.send_count = longExtra;
        this.hzr.user_info.fans_count = longExtra2;
        this.hzr.user_info.follow_count = longExtra3;
        this.hzr.user_info.portrait = stringExtra2;
        this.hzr.user_info.third_app_id = this.appId;
        this.hzr.location_info.location = stringExtra3;
    }

    private void initView() {
        if (this.hzz && TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hzz = com.baidu.live.aa.a.PQ().bod.aML;
        }
        this.hzo = new PersonCardViewNew(this, false);
        this.hzo.aQ(this.liveId, this.bbl);
        this.hzo.setOtherParams(this.otherParams);
        this.hzo.nW(this.hzy);
        this.hzo.nX(this.hzz);
        this.hzp = new PersonCardViewNew(this, true);
        this.hzp.aQ(this.liveId, this.bbl);
        this.hzp.setOtherParams(this.otherParams);
        this.hzp.nW(this.hzy);
        this.hzp.nX(this.hzz);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            this.hzo.getRootView().setVisibility(8);
            this.hzp.getRootView().setVisibility(0);
        } else {
            this.hzp.getRootView().setVisibility(8);
            this.hzo.getRootView().setVisibility(0);
        }
        this.hzo.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.1
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cjf() {
                PersonCardActivity.this.cje();
            }

            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cjg() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("live_id", PersonCardActivity.this.liveId);
                    jSONObject.put("vid", PersonCardActivity.this.vid == null ? "" : PersonCardActivity.this.vid);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "add_ impression").setContentExt("authorcard", "", jSONObject));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTagActivityConfig(PersonCardActivity.this.getPageContext().getPageActivity(), PersonCardActivity.this.bbl, PersonCardActivity.this.liveId)));
            }
        });
        this.hzp.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.3
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cjf() {
                PersonCardActivity.this.cje();
            }

            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void cjg() {
            }
        });
    }

    private void initListener() {
        registerListener(this.aVt);
        registerListener(this.gvc);
        registerListener(this.gvo);
        registerListener(this.hzA);
        registerListener(this.hzB);
    }

    private void Jz() {
        this.hzs = new com.baidu.tieba.ala.person.c.a(getPageContext());
        this.hzs.a(new a.InterfaceC0695a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.4
            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0695a
            public void b(PersonUserData personUserData) {
                if (personUserData != null) {
                    if (personUserData.user_info != null) {
                        PersonCardActivity.this.userId = personUserData.user_info.user_id;
                        PersonCardActivity.this.portrait = personUserData.user_info.portrait;
                        PersonCardActivity.this.metaKey = personUserData.user_info.aOb;
                    }
                    PersonCardActivity.this.hzo.a(personUserData, false);
                    PersonCardActivity.this.hzp.a(personUserData, false);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0695a
            public void a(c cVar) {
                PersonCardActivity.this.hzu = cVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0695a
            public void b(c cVar) {
                PersonCardActivity.this.hzv = cVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0695a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
        this.hzt = new e(getPageContext());
        this.hzt.a(new e.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.5
            @Override // com.baidu.live.personmanager.e.a
            public void OL() {
                PersonCardActivity.this.showToast(a.h.ala_person_report_online_success);
            }

            @Override // com.baidu.live.personmanager.e.a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
    }

    public void j(String str, String str2, String str3, String str4, String str5) {
        this.hzu = null;
        this.hzv = null;
        this.hzs.k(str, str2, str3, str4, str5);
    }

    public boolean ciZ() {
        return (TextUtils.isEmpty(this.appId) || this.userId == null || this.userId.equals(this.bbl)) ? false : true;
    }

    public boolean IC(String str) {
        return (TextUtils.isEmpty(this.bbl) || TextUtils.isEmpty(str) || !str.equals(this.bbl)) ? false : true;
    }

    public String cja() {
        return this.bbl;
    }

    public void nT(boolean z) {
        this.hzo.nV(z);
        this.hzp.nV(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hzw = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.hzw) {
            this.hzo.onResume();
            this.hzp.onResume();
        }
        this.hzw = false;
    }

    public void c(PersonUserData personUserData) {
        this.hzo.a(personUserData, false);
        this.hzp.a(personUserData, false);
        this.userId = personUserData.user_info.user_id;
        this.portrait = personUserData.user_info.portrait;
        this.metaKey = personUserData.user_info.aOb;
        this.hzq = personUserData.user_info.getNameShow();
        j(this.userId, this.bbl, this.groupId, this.metaKey, this.hzq);
    }

    public void cjb() {
        f fVar = new f(this.portrait, this.userId, this.metaKey, "1", true, getUniqueId());
        fVar.setFrom("source_person_card");
        com.baidu.live.view.a.Wx().a(this.userId, fVar);
    }

    public void cjc() {
        f fVar = new f(this.portrait, this.userId, this.metaKey, "1", false, getUniqueId());
        fVar.setFrom("source_person_card");
        com.baidu.live.view.a.Wx().a(this.userId, fVar);
    }

    public void cjd() {
        this.hzt.aF(this.userId, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cje() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new w(this, this.userId, this.groupId, this.liveId, this.aKf, this.bbl, this.otherParams)));
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            if (this instanceof Activity) {
                overridePendingTransition(a.C0197a.alpha_in, 0);
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
        if (this.hzs != null) {
            this.hzs.onDestroy();
        }
        if (this.hzo != null) {
            this.hzo.onDestroy();
        }
        if (this.hzp != null) {
            this.hzp.onDestroy();
        }
        if (this.hzA != null) {
            MessageManager.getInstance().unRegisterListener(this.hzA);
        }
        if (this.hzB != null) {
            MessageManager.getInstance().unRegisterListener(this.hzB);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (!this.hzx) {
            this.hzx = true;
            if (this.hzt != null) {
                this.hzt.onDestroy();
            }
            Animation animation = null;
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                if (this.hzp != null) {
                    animation = this.hzp.bUe();
                }
            } else if (this.hzo != null) {
                animation = this.hzo.bUe();
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
                            PersonCardActivity.this.overridePendingTransition(a.C0197a.alpha_in, a.C0197a.alpha_out);
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
