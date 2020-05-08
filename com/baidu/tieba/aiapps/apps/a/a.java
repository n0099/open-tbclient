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
    private b eDG;
    private List<com.baidu.swan.apps.a.c> mListeners;
    public static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    private a() {
        this.mListeners = new ArrayList();
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    private static class C0465a {
        private static final a eDJ = new a();
    }

    public static a bhM() {
        return C0465a.eDJ;
    }

    public void init(Context context) {
        dX(context);
        dW(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dW(Context context) {
        if (this.eDG == null) {
            this.eDG = new b();
            this.eDG.aJo = h.any().getString("bd_box_avatar_url", "");
            this.eDG.bduss = h.any().getString("bd_box_bduss", "");
            this.eDG.eDK = h.any().getString("bd_box_ptoken", "");
            this.eDG.uid = h.any().getString("bd_box_uid", "");
            this.eDG.displayName = h.any().getString("bd_box_display_name", "");
        }
    }

    private void dX(final Context context) {
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
                a.this.dW(context);
            }
        });
        PassportSDK.setLoginStatusChangeCallback(new LoginStatusChangeCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.3
            @Override // com.baidu.sapi2.callback.LoginStatusChangeCallback
            public void onChange() {
                a.this.iE(SapiAccountManager.getInstance().isLogin());
            }
        });
    }

    public void a(GetUserInfoResult getUserInfoResult) {
        if (getUserInfoResult != null) {
            try {
                h.any().putString("host_account_info_string", getUserInfoResult.toString());
                if (this.eDG == null) {
                    this.eDG = new b();
                }
                this.eDG.bduss = SapiAccountManager.getInstance().getSession().bduss;
                this.eDG.eDK = SapiAccountManager.getInstance().getSession().getPtoken();
                this.eDG.displayName = getUserInfoResult.displayname;
                this.eDG.uid = getUserInfoResult.uid;
                this.eDG.aJo = getUserInfoResult.portraitHttps;
                h.any().putString("bd_box_display_name", this.eDG.displayName);
                h.any().putString("bd_box_uid", this.eDG.uid);
                h.any().putString("bd_box_avatar_url", this.eDG.aJo);
                h.any().putString("bd_box_bduss", this.eDG.bduss);
                h.any().putString("bd_box_ptoken", this.eDG.eDK);
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                    public void onBdussExpired(GetUserInfoResult getUserInfoResult2) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(GetUserInfoResult getUserInfoResult2) {
                        if (getUserInfoResult2 != null) {
                            a.this.eDG.aJo = getUserInfoResult2.portraitHttps;
                        }
                        a.this.iE(true);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFailure(GetUserInfoResult getUserInfoResult2) {
                        a.this.iE(false);
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                    }
                }, this.eDG.bduss);
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
        if (this.eDG == null) {
            this.eDG = new b();
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
                                a.this.eDG.bduss = SapiAccountManager.getInstance().getSession().bduss;
                                a.this.eDG.eDK = SapiAccountManager.getInstance().getSession().getPtoken();
                                a.this.eDG.displayName = getUserInfoResult.displayname;
                                a.this.eDG.uid = getUserInfoResult.uid;
                                a.this.eDG.aJo = getUserInfoResult.portraitHttps;
                                h.any().putString("bd_box_display_name", a.this.eDG.displayName);
                                h.any().putString("bd_box_uid", a.this.eDG.uid);
                                h.any().putString("bd_box_avatar_url", a.this.eDG.aJo);
                                h.any().putString("bd_box_bduss", a.this.eDG.bduss);
                                h.any().putString("bd_box_ptoken", a.this.eDG.eDK);
                                aVar.onResult(0);
                                a.this.iE(true);
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

    public void bhN() {
        try {
            SapiAccountManager.getInstance().getConfignation();
        } catch (Exception e) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SAPI_INIT, TbadkCoreApplication.getInst().getApp()));
        }
        try {
            SapiAccountManager.getInstance().isLogin();
            if (SapiAccountManager.getInstance().isLogin()) {
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.6
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                    public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(GetUserInfoResult getUserInfoResult) {
                        a.this.eDG.bduss = SapiAccountManager.getInstance().getSession().bduss;
                        a.this.eDG.eDK = SapiAccountManager.getInstance().getSession().getPtoken();
                        a.this.eDG.displayName = getUserInfoResult.displayname;
                        a.this.eDG.uid = getUserInfoResult.uid;
                        a.this.eDG.aJo = getUserInfoResult.portraitHttps;
                        h.any().putString("bd_box_display_name", a.this.eDG.displayName);
                        h.any().putString("bd_box_uid", a.this.eDG.uid);
                        h.any().putString("bd_box_avatar_url", a.this.eDG.aJo);
                        h.any().putString("bd_box_bduss", a.this.eDG.bduss);
                        h.any().putString("bd_box_ptoken", a.this.eDG.eDK);
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
        } catch (NullPointerException e2) {
        }
    }

    public String getBduss() {
        if (this.eDG == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.eDG.bduss)) {
            bhN();
        }
        return this.eDG.bduss;
    }

    public String getUid() {
        if (this.eDG == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.eDG.uid)) {
            bhN();
        }
        return this.eDG.uid;
    }

    public String bhO() {
        if (this.eDG == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.eDG.aJo)) {
            bhN();
        }
        return this.eDG.aJo;
    }

    public String getDisplayName() {
        if (this.eDG == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.eDG.displayName)) {
            bhN();
        }
        return this.eDG.displayName;
    }

    public boolean isLogin() {
        if (this.eDG != null && TextUtils.isEmpty(this.eDG.bduss)) {
            bhN();
        }
        return SapiAccountManager.getInstance().isLogin();
    }

    public void b(com.baidu.swan.apps.a.a aVar) {
        SapiAccountManager.getInstance().logout();
        iE(false);
        this.eDG = new b();
        h.any().putString("bd_box_display_name", "");
        h.any().putString("bd_box_uid", "");
        h.any().putString("bd_box_avatar_url", "");
        h.any().putString("bd_box_bduss", "");
        h.any().putString("bd_box_ptoken", "");
        if (aVar != null) {
            aVar.onResult(0);
        }
    }

    public void a(com.baidu.swan.apps.a.c cVar) {
        this.mListeners.add(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iE(boolean z) {
        for (com.baidu.swan.apps.a.c cVar : this.mListeners) {
            cVar.cP(z);
        }
    }
}
