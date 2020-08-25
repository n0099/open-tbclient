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
    private boolean aEw;
    private String aSX;
    private String appId;
    private PersonCardViewNew gOL;
    private PersonCardViewNew gOM;
    private String gON;
    private PersonUserData gOO;
    private com.baidu.tieba.ala.person.c.a gOP;
    private b gOQ;
    private d gOR;
    private d gOS;
    private boolean gOT;
    private boolean gOV;
    private boolean gOW;
    private String groupId;
    private String liveId;
    private String metaKey;
    private String otherParams;
    private String portrait;
    private String userId;
    private String vid;
    private boolean gOU = false;
    CustomMessageListener fPP = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                PersonCardActivity.this.otherParams = str;
                if (PersonCardActivity.this.gOL != null) {
                    PersonCardActivity.this.gOL.setOtherParams(PersonCardActivity.this.otherParams);
                }
                if (PersonCardActivity.this.gOM != null) {
                    PersonCardActivity.this.gOM.setOtherParams(PersonCardActivity.this.otherParams);
                }
            }
        }
    };
    private CustomMessageListener fPD = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(PersonCardActivity.this.userId)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (PersonCardActivity.this.gOP != null) {
                            PersonCardActivity.this.gOP.eg(PersonCardActivity.this.userId, PersonCardActivity.this.metaKey);
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
                                if (TextUtils.equals(PersonCardActivity.this.aSX, PersonCardActivity.this.userId) && com.baidu.live.liveroom.a.KQ().KR()) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913093));
                                }
                                if (PersonCardActivity.this.aSX != null && PersonCardActivity.this.aSX.equals(updateAttentionMessage.getData().toUid)) {
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
                        PersonCardActivity.this.gOL.uO(0);
                        PersonCardActivity.this.gOM.uO(0);
                    } else {
                        PersonCardActivity.this.gOL.uO(1);
                        PersonCardActivity.this.gOM.uO(1);
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(PersonCardActivity.this.getUniqueId()) && !com.baidu.live.view.a.Qx().a(updateAttentionMessage.getData(), (BdPageContext<?>) PersonCardActivity.this.getPageContext(), false) && updateAttentionMessage.getData().errorString != null) {
                        PersonCardActivity.this.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    CustomMessageListener aNU = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener gOX = new CustomMessageListener(2913186) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener gOY = new CustomMessageListener(2913203) { // from class: com.baidu.tieba.ala.person.PersonCardActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.j(PersonCardActivity.this.userId, PersonCardActivity.this.aSX, PersonCardActivity.this.groupId, "", PersonCardActivity.this.gON);
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
            bXZ();
            initView();
            this.gOL.a(this.gOO, true);
            this.gOM.a(this.gOO, true);
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                setContentView(this.gOM.getRootView());
            } else {
                setContentView(this.gOL.getRootView());
            }
            initListener();
            Hh();
            if (!bYa()) {
                j(this.userId, this.aSX, this.groupId, "", this.gON);
            }
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                h.Y(this.gOM.getRootView());
            } else {
                h.Z(this.gOL.getRootView());
            }
            TiebaInitialize.log("c11899");
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.gOU) {
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                this.gOL.getRootView().setVisibility(8);
                this.gOM.getRootView().setVisibility(0);
                setContentView(this.gOM.getRootView());
                h.Y(this.gOM.getRootView());
            } else {
                this.gOM.getRootView().setVisibility(8);
                this.gOL.getRootView().setVisibility(0);
                setContentView(this.gOL.getRootView());
                h.Z(this.gOL.getRootView());
            }
            this.gOL.baR();
            this.gOM.baR();
        }
    }

    private void bXZ() {
        this.userId = getIntent().getStringExtra("PERSON_USER_ID");
        this.portrait = getIntent().getStringExtra("PERSON_PORTRAIT_URL");
        this.gON = getIntent().getStringExtra(AlaPersonCardActivityConfig.PERSON_SHOW_NAME);
        this.groupId = getIntent().getStringExtra("PERSON_GROUP_ID");
        this.liveId = getIntent().getStringExtra("PERSON_LIVE_ID");
        this.vid = getIntent().getStringExtra("vid");
        this.aSX = getIntent().getStringExtra("PERSON_LIVE_OWNER_UID");
        this.aEw = getIntent().getBooleanExtra("PERSON_LIVE_OWNER_FLAG", false);
        this.appId = getIntent().getStringExtra("PERSON_APP_ID");
        this.otherParams = getIntent().getStringExtra("other_params");
        this.gOV = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_IS_FROM_GUARD_CLUB, false);
        this.gOW = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_NAV_LIVEROOM_ENABLED, false);
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
        this.gOO = new PersonUserData();
        this.gOO.user_info = new ah();
        this.gOO.location_info = new AlaLocationData();
        this.gOO.relation_info = new AlaRelationData();
        this.gOO.user_info.user_id = this.userId;
        this.gOO.user_info.user_name = stringExtra;
        this.gOO.user_info.user_nickname = this.gON;
        this.gOO.user_info.sex = intExtra;
        this.gOO.user_info.level_id = intExtra2;
        this.gOO.user_info.description = stringExtra4;
        this.gOO.user_info.send_count = longExtra;
        this.gOO.user_info.fans_count = longExtra2;
        this.gOO.user_info.follow_count = longExtra3;
        this.gOO.user_info.portrait = stringExtra2;
        this.gOO.user_info.third_app_id = this.appId;
        this.gOO.location_info.location = stringExtra3;
    }

    private void initView() {
        if (this.gOW && TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gOW = com.baidu.live.w.a.Nk().beH.aGM;
        }
        this.gOL = new PersonCardViewNew(this, false);
        this.gOL.eh(this.liveId, this.aSX);
        this.gOL.setOtherParams(this.otherParams);
        this.gOL.mN(this.gOV);
        this.gOL.mO(this.gOW);
        this.gOM = new PersonCardViewNew(this, true);
        this.gOM.eh(this.liveId, this.aSX);
        this.gOM.setOtherParams(this.otherParams);
        this.gOM.mN(this.gOV);
        this.gOM.mO(this.gOW);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            this.gOL.getRootView().setVisibility(8);
            this.gOM.getRootView().setVisibility(0);
        } else {
            this.gOM.getRootView().setVisibility(8);
            this.gOL.getRootView().setVisibility(0);
        }
        this.gOL.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.1
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void bYg() {
                PersonCardActivity.this.bYf();
            }

            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void bYh() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("live_id", PersonCardActivity.this.liveId);
                    jSONObject.put("vid", PersonCardActivity.this.vid == null ? "" : PersonCardActivity.this.vid);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "add_ impression").setContentExt("authorcard", "", jSONObject));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTagActivityConfig(PersonCardActivity.this.getPageContext().getPageActivity(), PersonCardActivity.this.aSX, PersonCardActivity.this.liveId)));
            }
        });
        this.gOM.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.3
            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void bYg() {
                PersonCardActivity.this.bYf();
            }

            @Override // com.baidu.tieba.ala.person.view.PersonCardViewNew.a
            public void bYh() {
            }
        });
    }

    private void initListener() {
        registerListener(this.aNU);
        registerListener(this.fPD);
        registerListener(this.fPP);
        registerListener(this.gOX);
        registerListener(this.gOY);
    }

    private void Hh() {
        this.gOP = new com.baidu.tieba.ala.person.c.a(getPageContext());
        this.gOP.a(new a.InterfaceC0650a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.4
            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0650a
            public void c(PersonUserData personUserData) {
                if (personUserData != null) {
                    if (personUserData.user_info != null) {
                        PersonCardActivity.this.userId = personUserData.user_info.user_id;
                        PersonCardActivity.this.portrait = personUserData.user_info.portrait;
                        PersonCardActivity.this.metaKey = personUserData.user_info.aHS;
                    }
                    PersonCardActivity.this.gOL.a(personUserData, false);
                    PersonCardActivity.this.gOM.a(personUserData, false);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0650a
            public void a(d dVar) {
                PersonCardActivity.this.gOR = dVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0650a
            public void b(d dVar) {
                PersonCardActivity.this.gOS = dVar;
            }

            @Override // com.baidu.tieba.ala.person.c.a.InterfaceC0650a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
        this.gOQ = new b(getPageContext());
        this.gOQ.a(new b.a() { // from class: com.baidu.tieba.ala.person.PersonCardActivity.5
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
        this.gOR = null;
        this.gOS = null;
        this.gOP.k(str, str2, str3, str4, str5);
    }

    public boolean bYa() {
        return (TextUtils.isEmpty(this.appId) || this.userId == null || this.userId.equals(this.aSX)) ? false : true;
    }

    public boolean GE(String str) {
        return (TextUtils.isEmpty(this.aSX) || TextUtils.isEmpty(str) || !str.equals(this.aSX)) ? false : true;
    }

    public String bYb() {
        return this.aSX;
    }

    public void mK(boolean z) {
        this.gOL.mM(z);
        this.gOM.mM(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gOT = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.gOT) {
            this.gOL.onResume();
            this.gOM.onResume();
        }
        this.gOT = false;
    }

    public void b(PersonUserData personUserData) {
        this.gOL.a(personUserData, false);
        this.gOM.a(personUserData, false);
        this.userId = personUserData.user_info.user_id;
        this.portrait = personUserData.user_info.portrait;
        this.metaKey = personUserData.user_info.aHS;
        this.gON = personUserData.user_info.getNameShow();
        j(this.userId, this.aSX, this.groupId, this.metaKey, this.gON);
    }

    public void bYc() {
        com.baidu.live.data.d dVar = new com.baidu.live.data.d(this.portrait, this.userId, this.metaKey, "1", true, getUniqueId());
        dVar.setFrom("source_person_card");
        com.baidu.live.view.a.Qx().a(this.userId, dVar);
    }

    public void bYd() {
        com.baidu.live.data.d dVar = new com.baidu.live.data.d(this.portrait, this.userId, this.metaKey, "1", false, getUniqueId());
        dVar.setFrom("source_person_card");
        com.baidu.live.view.a.Qx().a(this.userId, dVar);
    }

    public void bYe() {
        this.gOQ.az(this.userId, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYf() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new u(this, this.userId, this.groupId, this.liveId, this.aEw, this.aSX, this.otherParams)));
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
        if (this.gOP != null) {
            this.gOP.onDestroy();
        }
        if (this.gOL != null) {
            this.gOL.onDestroy();
        }
        if (this.gOM != null) {
            this.gOM.onDestroy();
        }
        if (this.gOX != null) {
            MessageManager.getInstance().unRegisterListener(this.gOX);
        }
        if (this.gOY != null) {
            MessageManager.getInstance().unRegisterListener(this.gOY);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (!this.gOU) {
            this.gOU = true;
            if (this.gOQ != null) {
                this.gOQ.onDestroy();
            }
            Animation animation = null;
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                if (this.gOM != null) {
                    animation = this.gOM.bLf();
                }
            } else if (this.gOL != null) {
                animation = this.gOL.bLf();
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
