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
/* loaded from: classes9.dex */
public class a {
    private b dYT;
    private List<com.baidu.swan.apps.a.c> mListeners;
    public static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    private a() {
        this.mListeners = new ArrayList();
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private static class C0400a {
        private static final a dYW = new a();
    }

    public static a aWU() {
        return C0400a.dYW;
    }

    public void init(Context context) {
        ev(context);
        eu(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eu(Context context) {
        if (this.dYT == null) {
            this.dYT = new b();
            this.dYT.bWT = h.acE().getString("bd_box_avatar_url", "");
            this.dYT.bduss = h.acE().getString("bd_box_bduss", "");
            this.dYT.dYX = h.acE().getString("bd_box_ptoken", "");
            this.dYT.uid = h.acE().getString("bd_box_uid", "");
            this.dYT.displayName = h.acE().getString("bd_box_display_name", "");
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
                a.this.ht(SapiAccountManager.getInstance().isLogin());
            }
        });
    }

    public void a(GetUserInfoResult getUserInfoResult) {
        if (getUserInfoResult != null) {
            try {
                h.acE().putString("host_account_info_string", getUserInfoResult.toString());
                if (this.dYT == null) {
                    this.dYT = new b();
                }
                this.dYT.bduss = SapiAccountManager.getInstance().getSession().bduss;
                this.dYT.dYX = SapiAccountManager.getInstance().getSession().getPtoken();
                this.dYT.displayName = getUserInfoResult.displayname;
                this.dYT.uid = getUserInfoResult.uid;
                this.dYT.bWT = getUserInfoResult.portraitHttps;
                h.acE().putString("bd_box_display_name", this.dYT.displayName);
                h.acE().putString("bd_box_uid", this.dYT.uid);
                h.acE().putString("bd_box_avatar_url", this.dYT.bWT);
                h.acE().putString("bd_box_bduss", this.dYT.bduss);
                h.acE().putString("bd_box_ptoken", this.dYT.dYX);
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                    public void onBdussExpired(GetUserInfoResult getUserInfoResult2) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(GetUserInfoResult getUserInfoResult2) {
                        if (getUserInfoResult2 != null) {
                            a.this.dYT.bWT = getUserInfoResult2.portraitHttps;
                        }
                        a.this.ht(true);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFailure(GetUserInfoResult getUserInfoResult2) {
                        a.this.ht(false);
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                    }
                }, this.dYT.bduss);
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
        if (this.dYT == null) {
            this.dYT = new b();
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
                                a.this.dYT.bduss = SapiAccountManager.getInstance().getSession().bduss;
                                a.this.dYT.dYX = SapiAccountManager.getInstance().getSession().getPtoken();
                                a.this.dYT.displayName = getUserInfoResult.displayname;
                                a.this.dYT.uid = getUserInfoResult.uid;
                                a.this.dYT.bWT = getUserInfoResult.portraitHttps;
                                h.acE().putString("bd_box_display_name", a.this.dYT.displayName);
                                h.acE().putString("bd_box_uid", a.this.dYT.uid);
                                h.acE().putString("bd_box_avatar_url", a.this.dYT.bWT);
                                h.acE().putString("bd_box_bduss", a.this.dYT.bduss);
                                h.acE().putString("bd_box_ptoken", a.this.dYT.dYX);
                                aVar.onResult(0);
                                a.this.ht(true);
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

    public void aWV() {
        if (SapiAccountManager.getInstance().isLogin()) {
            SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.LoginStatusAware
                public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(GetUserInfoResult getUserInfoResult) {
                    a.this.dYT.bduss = SapiAccountManager.getInstance().getSession().bduss;
                    a.this.dYT.dYX = SapiAccountManager.getInstance().getSession().getPtoken();
                    a.this.dYT.displayName = getUserInfoResult.displayname;
                    a.this.dYT.uid = getUserInfoResult.uid;
                    a.this.dYT.bWT = getUserInfoResult.portraitHttps;
                    h.acE().putString("bd_box_display_name", a.this.dYT.displayName);
                    h.acE().putString("bd_box_uid", a.this.dYT.uid);
                    h.acE().putString("bd_box_avatar_url", a.this.dYT.bWT);
                    h.acE().putString("bd_box_bduss", a.this.dYT.bduss);
                    h.acE().putString("bd_box_ptoken", a.this.dYT.dYX);
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
        if (this.dYT == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.dYT.bduss)) {
            aWV();
        }
        return this.dYT.bduss;
    }

    public String getUid() {
        if (this.dYT == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.dYT.uid)) {
            aWV();
        }
        return this.dYT.uid;
    }

    public String aWW() {
        if (this.dYT == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.dYT.bWT)) {
            aWV();
        }
        return this.dYT.bWT;
    }

    public String getDisplayName() {
        if (this.dYT == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.dYT.displayName)) {
            aWV();
        }
        return this.dYT.displayName;
    }

    public boolean isLogin() {
        if (this.dYT != null && TextUtils.isEmpty(this.dYT.bduss)) {
            aWV();
        }
        return SapiAccountManager.getInstance().isLogin();
    }

    public void b(com.baidu.swan.apps.a.a aVar) {
        SapiAccountManager.getInstance().logout();
        ht(false);
        this.dYT = new b();
        h.acE().putString("bd_box_display_name", "");
        h.acE().putString("bd_box_uid", "");
        h.acE().putString("bd_box_avatar_url", "");
        h.acE().putString("bd_box_bduss", "");
        h.acE().putString("bd_box_ptoken", "");
        if (aVar != null) {
            aVar.onResult(0);
        }
    }

    public void a(com.baidu.swan.apps.a.c cVar) {
        this.mListeners.add(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ht(boolean z) {
        for (com.baidu.swan.apps.a.c cVar : this.mListeners) {
            cVar.bF(z);
        }
    }
}
