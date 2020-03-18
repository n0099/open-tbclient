package com.baidu.tieba.aiapps.apps.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.LoginStatusChangeCallback;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class a {
    private b edK;
    private List<com.baidu.swan.apps.a.c> mListeners;
    public static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    private a() {
        this.mListeners = new ArrayList();
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    private static class C0413a {
        private static final a edN = new a();
    }

    public static a aZK() {
        return C0413a.edN;
    }

    public void init(Context context) {
        ex(context);
        ew(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ew(Context context) {
        if (this.edK == null) {
            this.edK = new b();
            this.edK.aqz = h.afu().getString("bd_box_avatar_url", "");
            this.edK.bduss = h.afu().getString("bd_box_bduss", "");
            this.edK.edO = h.afu().getString("bd_box_ptoken", "");
            this.edK.uid = h.afu().getString("bd_box_uid", "");
            this.edK.displayName = h.afu().getString("bd_box_display_name", "");
        }
    }

    private void ex(final Context context) {
        SapiAccountManager.registerSilentShareListener(new SapiAccountManager.SilentShareListener() { // from class: com.baidu.tieba.aiapps.apps.a.a.1
            @Override // com.baidu.sapi2.SapiAccountManager.SilentShareListener
            public void onSilentShare() {
                context.sendBroadcast(new Intent("com.baidu.intent.action.SILENT_SHARE"));
                SapiAccountManager.unregisterSilentShareListener();
            }
        });
        SapiAccountManager.registerReceiveShareListener(new SapiAccountManager.ReceiveShareListener() { // from class: com.baidu.tieba.aiapps.apps.a.a.2
            @Override // com.baidu.sapi2.SapiAccountManager.ReceiveShareListener
            public void onReceiveShare() {
                a.this.ew(context);
            }
        });
        PassportSDK.setLoginStatusChangeCallback(new LoginStatusChangeCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.3
            @Override // com.baidu.sapi2.callback.LoginStatusChangeCallback
            public void onChange() {
                a.this.hG(SapiAccountManager.getInstance().isLogin());
            }
        });
    }

    public void a(GetUserInfoResult getUserInfoResult) {
        if (getUserInfoResult != null) {
            try {
                h.afu().putString("host_account_info_string", getUserInfoResult.toString());
                if (this.edK == null) {
                    this.edK = new b();
                }
                this.edK.bduss = SapiAccountManager.getInstance().getSession().bduss;
                this.edK.edO = SapiAccountManager.getInstance().getSession().getPtoken();
                this.edK.displayName = getUserInfoResult.displayname;
                this.edK.uid = getUserInfoResult.uid;
                this.edK.aqz = getUserInfoResult.portraitHttps;
                h.afu().putString("bd_box_display_name", this.edK.displayName);
                h.afu().putString("bd_box_uid", this.edK.uid);
                h.afu().putString("bd_box_avatar_url", this.edK.aqz);
                h.afu().putString("bd_box_bduss", this.edK.bduss);
                h.afu().putString("bd_box_ptoken", this.edK.edO);
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                    public void onBdussExpired(GetUserInfoResult getUserInfoResult2) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(GetUserInfoResult getUserInfoResult2) {
                        if (getUserInfoResult2 != null) {
                            a.this.edK.aqz = getUserInfoResult2.portraitHttps;
                        }
                        a.this.hG(true);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFailure(GetUserInfoResult getUserInfoResult2) {
                        a.this.hG(false);
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                    }
                }, this.edK.bduss);
                return;
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        }
        b(null);
    }

    public void a(Context context, Bundle bundle, final com.baidu.swan.apps.a.a aVar) {
        int i;
        if (this.edK == null) {
            this.edK = new b();
        }
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig(context, true, -1);
        loginActivityConfig.getIntent().putExtra("close", true);
        if (bundle != null && (i = bundle.getInt("key_login_mode", 1)) > 1) {
            if (i == 4) {
                i = 1;
            }
            loginActivityConfig.setIsFromAiapp(true);
            loginActivityConfig.setThirdPartyLoginForResult(i, "");
        }
        TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        MessageManager.getInstance().registerListener(new CustomMessageListener(2921362) { // from class: com.baidu.tieba.aiapps.apps.a.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Integer) {
                    if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                        SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.5.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.sapi2.callback.LoginStatusAware
                            public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                                aVar.onResult(-1);
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.sapi2.callback.SapiCallback
                            public void onSuccess(GetUserInfoResult getUserInfoResult) {
                                a.this.edK.bduss = SapiAccountManager.getInstance().getSession().bduss;
                                a.this.edK.edO = SapiAccountManager.getInstance().getSession().getPtoken();
                                a.this.edK.displayName = getUserInfoResult.displayname;
                                a.this.edK.uid = getUserInfoResult.uid;
                                a.this.edK.aqz = getUserInfoResult.portraitHttps;
                                h.afu().putString("bd_box_display_name", a.this.edK.displayName);
                                h.afu().putString("bd_box_uid", a.this.edK.uid);
                                h.afu().putString("bd_box_avatar_url", a.this.edK.aqz);
                                h.afu().putString("bd_box_bduss", a.this.edK.bduss);
                                h.afu().putString("bd_box_ptoken", a.this.edK.edO);
                                aVar.onResult(0);
                                a.this.hG(true);
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.sapi2.callback.SapiCallback
                            public void onFailure(GetUserInfoResult getUserInfoResult) {
                                aVar.onResult(-1);
                            }

                            @Override // com.baidu.sapi2.callback.SapiCallback
                            public void onStart() {
                            }

                            @Override // com.baidu.sapi2.callback.SapiCallback
                            public void onFinish() {
                            }
                        }, SapiAccountManager.getInstance().getSession().bduss);
                    }
                    aVar.onResult(((Integer) customResponsedMessage.getData()).intValue());
                }
            }
        });
    }

    public void aZL() {
        try {
            SapiAccountManager.getInstance().getConfignation();
        } catch (Exception e) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SAPI_INIT, TbadkCoreApplication.getInst().getApp()));
        }
        if (SapiAccountManager.getInstance().isLogin()) {
            SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.LoginStatusAware
                public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(GetUserInfoResult getUserInfoResult) {
                    a.this.edK.bduss = SapiAccountManager.getInstance().getSession().bduss;
                    a.this.edK.edO = SapiAccountManager.getInstance().getSession().getPtoken();
                    a.this.edK.displayName = getUserInfoResult.displayname;
                    a.this.edK.uid = getUserInfoResult.uid;
                    a.this.edK.aqz = getUserInfoResult.portraitHttps;
                    h.afu().putString("bd_box_display_name", a.this.edK.displayName);
                    h.afu().putString("bd_box_uid", a.this.edK.uid);
                    h.afu().putString("bd_box_avatar_url", a.this.edK.aqz);
                    h.afu().putString("bd_box_bduss", a.this.edK.bduss);
                    h.afu().putString("bd_box_ptoken", a.this.edK.edO);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(GetUserInfoResult getUserInfoResult) {
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                }
            }, SapiAccountManager.getInstance().getSession().bduss);
        }
    }

    public String getBduss() {
        if (this.edK == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.edK.bduss)) {
            aZL();
        }
        return this.edK.bduss;
    }

    public String getUid() {
        if (this.edK == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.edK.uid)) {
            aZL();
        }
        return this.edK.uid;
    }

    public String aZM() {
        if (this.edK == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.edK.aqz)) {
            aZL();
        }
        return this.edK.aqz;
    }

    public String getDisplayName() {
        if (this.edK == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.edK.displayName)) {
            aZL();
        }
        return this.edK.displayName;
    }

    public boolean isLogin() {
        if (this.edK != null && TextUtils.isEmpty(this.edK.bduss)) {
            aZL();
        }
        return SapiAccountManager.getInstance().isLogin();
    }

    public void b(com.baidu.swan.apps.a.a aVar) {
        SapiAccountManager.getInstance().logout();
        hG(false);
        this.edK = new b();
        h.afu().putString("bd_box_display_name", "");
        h.afu().putString("bd_box_uid", "");
        h.afu().putString("bd_box_avatar_url", "");
        h.afu().putString("bd_box_bduss", "");
        h.afu().putString("bd_box_ptoken", "");
        if (aVar != null) {
            aVar.onResult(0);
        }
    }

    public void a(com.baidu.swan.apps.a.c cVar) {
        this.mListeners.add(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hG(boolean z) {
        for (com.baidu.swan.apps.a.c cVar : this.mListeners) {
            cVar.bT(z);
        }
    }
}
