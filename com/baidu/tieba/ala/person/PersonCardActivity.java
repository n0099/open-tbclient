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
import com.baidu.live.data.af;
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
/* loaded from: classes4.dex */
public class PersonCardActivity extends BaseFragmentActivity {
    private String aNK;
    private String appId;
    private boolean azm;
    private PersonCardViewNew gCo;
    private PersonCardViewNew gCp;
    private PersonUserData gCq;
    private com.baidu.tieba.ala.person.c.a gCr;
    private b gCs;
    private d gCt;
    private d gCu;
    private boolean gCv;
    private boolean gCw;
    private boolean gCx;
    private String groupId;
    private String liveId;
    private String metaKey;
    private String otherParams;
    private String portrait;
    private String showName;
    private String userId;
    private String vid;
    private boolean isFinish = false;
    CustomMessageListener fEy = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                PersonCardActivity.this.otherParams = str;
                if (PersonCardActivity.this.gCo != null) {
                    PersonCardActivity.this.gCo.setOtherParams(PersonCardActivity.this.otherParams);
                }
                if (PersonCardActivity.this.gCp != null) {
                    PersonCardActivity.this.gCp.setOtherParams(PersonCardActivity.this.otherParams);
                }
            }
        }
    };
    private CustomMessageListener fEm = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(PersonCardActivity.this.userId)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (PersonCardActivity.this.gCr != null) {
                            PersonCardActivity.this.gCr.dP(PersonCardActivity.this.userId, PersonCardActivity.this.metaKey);
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
                                if (TextUtils.equals(PersonCardActivity.this.aNK, PersonCardActivity.this.userId) && com.baidu.live.liveroom.a.Fj().Fk()) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913093));
                                }
                                if (PersonCardActivity.this.aNK != null && PersonCardActivity.this.aNK.equals(updateAttentionMessage.getData().toUid)) {
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
                        PersonCardActivity.this.gCo.sA(0);
                        PersonCardActivity.this.gCp.sA(0);
                    } else {
                        PersonCardActivity.this.gCo.sA(1);
                        PersonCardActivity.this.gCp.sA(1);
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(PersonCardActivity.this.getUniqueId()) && !com.baidu.live.view.a.KF().a(updateAttentionMessage.getData(), (BdPageContext<?>) PersonCardActivity.this.getPageContext(), false) && updateAttentionMessage.getData().errorString != null) {
                        PersonCardActivity.this.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    CustomMessageListener aIJ = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener gCy = new CustomMessageListener(2913186) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener gCz = new CustomMessageListener(2913203) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.h(PersonCardActivity.this.userId, PersonCardActivity.this.aNK, PersonCardActivity.this.groupId, "", PersonCardActivity.this.showName);
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
            bNZ();
            initView();
            this.gCo.a(this.gCq, true);
            this.gCp.a(this.gCq, true);
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                setContentView(this.gCp.getRootView());
            } else {
                setContentView(this.gCo.getRootView());
            }
            initListener();
            BE();
            if (!bOa()) {
                h(this.userId, this.aNK, this.groupId, "", this.showName);
            }
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                h.X(this.gCp.getRootView());
            } else {
                h.Y(this.gCo.getRootView());
            }
            TiebaInitialize.log("c11899");
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.isFinish) {
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                this.gCo.getRootView().setVisibility(8);
                this.gCp.getRootView().setVisibility(0);
                setContentView(this.gCp.getRootView());
                h.X(this.gCp.getRootView());
            } else {
                this.gCp.getRootView().setVisibility(8);
                this.gCo.getRootView().setVisibility(0);
                setContentView(this.gCo.getRootView());
                h.Y(this.gCo.getRootView());
            }
            this.gCo.aSA();
            this.gCp.aSA();
        }
    }

    private void bNZ() {
        this.userId = getIntent().getStringExtra("PERSON_USER_ID");
        this.portrait = getIntent().getStringExtra("PERSON_PORTRAIT_URL");
        this.showName = getIntent().getStringExtra(AlaPersonCardActivityConfig.PERSON_SHOW_NAME);
        this.groupId = getIntent().getStringExtra("PERSON_GROUP_ID");
        this.liveId = getIntent().getStringExtra("PERSON_LIVE_ID");
        this.vid = getIntent().getStringExtra("vid");
        this.aNK = getIntent().getStringExtra("PERSON_LIVE_OWNER_UID");
        this.azm = getIntent().getBooleanExtra("PERSON_LIVE_OWNER_FLAG", false);
        this.appId = getIntent().getStringExtra("PERSON_APP_ID");
        this.otherParams = getIntent().getStringExtra("other_params");
        this.gCw = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_IS_FROM_GUARD_CLUB, false);
        this.gCx = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_NAV_LIVEROOM_ENABLED, false);
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
        this.gCq = new PersonUserData();
        this.gCq.user_info = new af();
        this.gCq.location_info = new AlaLocationData();
        this.gCq.relation_info = new AlaRelationData();
        this.gCq.user_info.user_id = this.userId;
        this.gCq.user_info.user_name = stringExtra;
        this.gCq.user_info.user_nickname = this.showName;
        this.gCq.user_info.sex = intExtra;
        this.gCq.user_info.level_id = intExtra2;
        this.gCq.user_info.description = stringExtra4;
        this.gCq.user_info.send_count = longExtra;
        this.gCq.user_info.fans_count = longExtra2;
        this.gCq.user_info.follow_count = longExtra3;
        this.gCq.user_info.portrait = stringExtra2;
        this.gCq.user_info.third_app_id = this.appId;
        this.gCq.location_info.location = stringExtra3;
    }

    private void initView() {
        if (this.gCx && TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gCx = com.baidu.live.v.a.Hs().aZn.aBC;
        }
        this.gCo = new PersonCardViewNew(this, false);
        this.gCo.dQ(this.liveId, this.aNK);
        this.gCo.setOtherParams(this.otherParams);
        this.gCo.ml(this.gCw);
        this.gCo.mm(this.gCx);
        this.gCp = new PersonCardViewNew(this, true);
        this.gCp.dQ(this.liveId, this.aNK);
        this.gCp.setOtherParams(this.otherParams);
        this.gCp.ml(this.gCw);
        this.gCp.mm(this.gCx);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            this.gCo.getRootView().setVisibility(8);
            this.gCp.getRootView().setVisibility(0);
        } else {
            this.gCp.getRootView().setVisibility(8);
            this.gCo.getRootView().setVisibility(0);
        }
        this.gCo.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.1
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void bOg() {
                PersonCardActivity.this.bOf();
            }

            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void bOh() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("live_id", PersonCardActivity.this.liveId);
                    jSONObject.put("vid", PersonCardActivity.this.vid == null ? "" : PersonCardActivity.this.vid);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "add_ impression").setContentExt("authorcard", "", jSONObject));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTagActivityConfig(PersonCardActivity.this.getPageContext().getPageActivity(), PersonCardActivity.this.aNK, PersonCardActivity.this.liveId)));
            }
        });
        this.gCp.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.3
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void bOg() {
                PersonCardActivity.this.bOf();
            }

            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void bOh() {
            }
        });
    }

    private void initListener() {
        registerListener(this.aIJ);
        registerListener(this.fEm);
        registerListener(this.fEy);
        registerListener(this.gCy);
        registerListener(this.gCz);
    }

    private void BE() {
        this.gCr = new com.baidu.tieba.ala.person.c.a(getPageContext());
        this.gCr.a(new a.InterfaceC0600a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.4
            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0600a
            public void c(PersonUserData personUserData) {
                if (personUserData != null) {
                    if (personUserData.user_info != null) {
                        PersonCardActivity.this.userId = personUserData.user_info.user_id;
                        PersonCardActivity.this.portrait = personUserData.user_info.portrait;
                        PersonCardActivity.this.metaKey = personUserData.user_info.aCI;
                    }
                    PersonCardActivity.this.gCo.a(personUserData, false);
                    PersonCardActivity.this.gCp.a(personUserData, false);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0600a
            public void a(d dVar) {
                PersonCardActivity.this.gCt = dVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0600a
            public void b(d dVar) {
                PersonCardActivity.this.gCu = dVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0600a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
        this.gCs = new b(getPageContext());
        this.gCs.a(new b.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.5
            @Override // com.baidu.live.o.b.a
            public void Gr() {
                PersonCardActivity.this.showToast(a.i.ala_person_report_online_success);
            }

            @Override // com.baidu.live.o.b.a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
    }

    public void h(String str, String str2, String str3, String str4, String str5) {
        this.gCt = null;
        this.gCu = null;
        this.gCr.j(str, str2, str3, str4, str5);
    }

    public boolean bOa() {
        return (TextUtils.isEmpty(this.appId) || this.userId == null || this.userId.equals(this.aNK)) ? false : true;
    }

    public boolean Ef(String str) {
        return (TextUtils.isEmpty(this.aNK) || TextUtils.isEmpty(str) || !str.equals(this.aNK)) ? false : true;
    }

    public String bOb() {
        return this.aNK;
    }

    public void mi(boolean z) {
        this.gCo.mk(z);
        this.gCp.mk(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gCv = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.gCv) {
            this.gCo.onResume();
            this.gCp.onResume();
        }
        this.gCv = false;
    }

    public void b(PersonUserData personUserData) {
        this.gCo.a(personUserData, false);
        this.gCp.a(personUserData, false);
        this.userId = personUserData.user_info.user_id;
        this.portrait = personUserData.user_info.portrait;
        this.metaKey = personUserData.user_info.aCI;
        this.showName = personUserData.user_info.getNameShow();
        h(this.userId, this.aNK, this.groupId, this.metaKey, this.showName);
    }

    public void bOc() {
        com.baidu.live.data.d dVar = new com.baidu.live.data.d(this.portrait, this.userId, this.metaKey, "1", true, getUniqueId());
        dVar.setFrom("source_person_card");
        com.baidu.live.view.a.KF().a(this.userId, dVar);
    }

    public void bOd() {
        com.baidu.live.data.d dVar = new com.baidu.live.data.d(this.portrait, this.userId, this.metaKey, "1", false, getUniqueId());
        dVar.setFrom("source_person_card");
        com.baidu.live.view.a.KF().a(this.userId, dVar);
    }

    public void bOe() {
        this.gCs.av(this.userId, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOf() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new u(this, this.userId, this.groupId, this.liveId, this.azm, this.aNK, this.otherParams)));
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            if (this instanceof Activity) {
                overridePendingTransition(a.C0178a.alpha_in, 0);
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
        if (this.gCr != null) {
            this.gCr.onDestroy();
        }
        if (this.gCo != null) {
            this.gCo.onDestroy();
        }
        if (this.gCp != null) {
            this.gCp.onDestroy();
        }
        if (this.gCy != null) {
            MessageManager.getInstance().unRegisterListener(this.gCy);
        }
        if (this.gCz != null) {
            MessageManager.getInstance().unRegisterListener(this.gCz);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (!this.isFinish) {
            this.isFinish = true;
            if (this.gCs != null) {
                this.gCs.onDestroy();
            }
            Animation animation = null;
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                if (this.gCp != null) {
                    animation = this.gCp.bBL();
                }
            } else if (this.gCo != null) {
                animation = this.gCo.bBL();
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
                            PersonCardActivity.this.overridePendingTransition(a.C0178a.alpha_in, a.C0178a.alpha_out);
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
