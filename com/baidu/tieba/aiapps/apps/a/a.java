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
/* loaded from: classes10.dex */
public class a {
    private b dZc;
    private List<com.baidu.swan.apps.a.c> mListeners;
    public static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    private a() {
        this.mListeners = new ArrayList();
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class C0402a {
        private static final a dZf = new a();
    }

    public static a aXo() {
        return C0402a.dZf;
    }

    public void init(Context context) {
        ev(context);
        eu(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eu(Context context) {
        if (this.dZc == null) {
            this.dZc = new b();
            this.dZc.bXf = h.adb().getString("bd_box_avatar_url", "");
            this.dZc.bduss = h.adb().getString("bd_box_bduss", "");
            this.dZc.dZg = h.adb().getString("bd_box_ptoken", "");
            this.dZc.uid = h.adb().getString("bd_box_uid", "");
            this.dZc.displayName = h.adb().getString("bd_box_display_name", "");
        }
    }

    private void ev(final Context context) {
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
                a.this.eu(context);
            }
        });
        PassportSDK.setLoginStatusChangeCallback(new LoginStatusChangeCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.3
            @Override // com.baidu.sapi2.callback.LoginStatusChangeCallback
            public void onChange() {
                a.this.hy(SapiAccountManager.getInstance().isLogin());
            }
        });
    }

    public void a(GetUserInfoResult getUserInfoResult) {
        if (getUserInfoResult != null) {
            try {
                h.adb().putString("host_account_info_string", getUserInfoResult.toString());
                if (this.dZc == null) {
                    this.dZc = new b();
                }
                this.dZc.bduss = SapiAccountManager.getInstance().getSession().bduss;
                this.dZc.dZg = SapiAccountManager.getInstance().getSession().getPtoken();
                this.dZc.displayName = getUserInfoResult.displayname;
                this.dZc.uid = getUserInfoResult.uid;
                this.dZc.bXf = getUserInfoResult.portraitHttps;
                h.adb().putString("bd_box_display_name", this.dZc.displayName);
                h.adb().putString("bd_box_uid", this.dZc.uid);
                h.adb().putString("bd_box_avatar_url", this.dZc.bXf);
                h.adb().putString("bd_box_bduss", this.dZc.bduss);
                h.adb().putString("bd_box_ptoken", this.dZc.dZg);
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                    public void onBdussExpired(GetUserInfoResult getUserInfoResult2) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(GetUserInfoResult getUserInfoResult2) {
                        if (getUserInfoResult2 != null) {
                            a.this.dZc.bXf = getUserInfoResult2.portraitHttps;
                        }
                        a.this.hy(true);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFailure(GetUserInfoResult getUserInfoResult2) {
                        a.this.hy(false);
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                    }
                }, this.dZc.bduss);
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
        if (this.dZc == null) {
            this.dZc = new b();
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
                                a.this.dZc.bduss = SapiAccountManager.getInstance().getSession().bduss;
                                a.this.dZc.dZg = SapiAccountManager.getInstance().getSession().getPtoken();
                                a.this.dZc.displayName = getUserInfoResult.displayname;
                                a.this.dZc.uid = getUserInfoResult.uid;
                                a.this.dZc.bXf = getUserInfoResult.portraitHttps;
                                h.adb().putString("bd_box_display_name", a.this.dZc.displayName);
                                h.adb().putString("bd_box_uid", a.this.dZc.uid);
                                h.adb().putString("bd_box_avatar_url", a.this.dZc.bXf);
                                h.adb().putString("bd_box_bduss", a.this.dZc.bduss);
                                h.adb().putString("bd_box_ptoken", a.this.dZc.dZg);
                                aVar.onResult(0);
                                a.this.hy(true);
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

    public void aXp() {
        try {
            SapiAccountManager.getInstance().getConfignation();
        } catch (Exception e) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SAPI_INIT, TbadkCoreApplication.getInst().getApp()));
        }
        Boolean.valueOf(false);
        try {
            if (Boolean.valueOf(SapiAccountManager.getInstance().isLogin()).booleanValue()) {
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.6
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                    public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(GetUserInfoResult getUserInfoResult) {
                        a.this.dZc.bduss = SapiAccountManager.getInstance().getSession().bduss;
                        a.this.dZc.dZg = SapiAccountManager.getInstance().getSession().getPtoken();
                        a.this.dZc.displayName = getUserInfoResult.displayname;
                        a.this.dZc.uid = getUserInfoResult.uid;
                        a.this.dZc.bXf = getUserInfoResult.portraitHttps;
                        h.adb().putString("bd_box_display_name", a.this.dZc.displayName);
                        h.adb().putString("bd_box_uid", a.this.dZc.uid);
                        h.adb().putString("bd_box_avatar_url", a.this.dZc.bXf);
                        h.adb().putString("bd_box_bduss", a.this.dZc.bduss);
                        h.adb().putString("bd_box_ptoken", a.this.dZc.dZg);
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
        } catch (Exception e2) {
        }
    }

    public String getBduss() {
        if (this.dZc == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.dZc.bduss)) {
            aXp();
        }
        return this.dZc.bduss;
    }

    public String getUid() {
        if (this.dZc == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.dZc.uid)) {
            aXp();
        }
        return this.dZc.uid;
    }

    public String aXq() {
        if (this.dZc == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.dZc.bXf)) {
            aXp();
        }
        return this.dZc.bXf;
    }

    public String getDisplayName() {
        if (this.dZc == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.dZc.displayName)) {
            aXp();
        }
        return this.dZc.displayName;
    }

    public boolean isLogin() {
        if (this.dZc != null && TextUtils.isEmpty(this.dZc.bduss)) {
            aXp();
        }
        return SapiAccountManager.getInstance().isLogin();
    }

    public void b(com.baidu.swan.apps.a.a aVar) {
        SapiAccountManager.getInstance().logout();
        hy(false);
        this.dZc = new b();
        h.adb().putString("bd_box_display_name", "");
        h.adb().putString("bd_box_uid", "");
        h.adb().putString("bd_box_avatar_url", "");
        h.adb().putString("bd_box_bduss", "");
        h.adb().putString("bd_box_ptoken", "");
        if (aVar != null) {
            aVar.onResult(0);
        }
    }

    public void a(com.baidu.swan.apps.a.c cVar) {
        this.mListeners.add(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hy(boolean z) {
        for (com.baidu.swan.apps.a.c cVar : this.mListeners) {
            cVar.bK(z);
        }
    }
}
