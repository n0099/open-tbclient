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
    private b edh;
    private List<com.baidu.swan.apps.a.c> mListeners;
    public static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    private a() {
        this.mListeners = new ArrayList();
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    private static class C0413a {
        private static final a edk = new a();
    }

    public static a aZF() {
        return C0413a.edk;
    }

    public void init(Context context) {
        ey(context);
        ex(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ex(Context context) {
        if (this.edh == null) {
            this.edh = new b();
            this.edh.aqo = h.afr().getString("bd_box_avatar_url", "");
            this.edh.bduss = h.afr().getString("bd_box_bduss", "");
            this.edh.edl = h.afr().getString("bd_box_ptoken", "");
            this.edh.uid = h.afr().getString("bd_box_uid", "");
            this.edh.displayName = h.afr().getString("bd_box_display_name", "");
        }
    }

    private void ey(final Context context) {
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
                a.this.ex(context);
            }
        });
        PassportSDK.setLoginStatusChangeCallback(new LoginStatusChangeCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.3
            @Override // com.baidu.sapi2.callback.LoginStatusChangeCallback
            public void onChange() {
                a.this.hF(SapiAccountManager.getInstance().isLogin());
            }
        });
    }

    public void a(GetUserInfoResult getUserInfoResult) {
        if (getUserInfoResult != null) {
            try {
                h.afr().putString("host_account_info_string", getUserInfoResult.toString());
                if (this.edh == null) {
                    this.edh = new b();
                }
                this.edh.bduss = SapiAccountManager.getInstance().getSession().bduss;
                this.edh.edl = SapiAccountManager.getInstance().getSession().getPtoken();
                this.edh.displayName = getUserInfoResult.displayname;
                this.edh.uid = getUserInfoResult.uid;
                this.edh.aqo = getUserInfoResult.portraitHttps;
                h.afr().putString("bd_box_display_name", this.edh.displayName);
                h.afr().putString("bd_box_uid", this.edh.uid);
                h.afr().putString("bd_box_avatar_url", this.edh.aqo);
                h.afr().putString("bd_box_bduss", this.edh.bduss);
                h.afr().putString("bd_box_ptoken", this.edh.edl);
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                    public void onBdussExpired(GetUserInfoResult getUserInfoResult2) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(GetUserInfoResult getUserInfoResult2) {
                        if (getUserInfoResult2 != null) {
                            a.this.edh.aqo = getUserInfoResult2.portraitHttps;
                        }
                        a.this.hF(true);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFailure(GetUserInfoResult getUserInfoResult2) {
                        a.this.hF(false);
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                    }
                }, this.edh.bduss);
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
        if (this.edh == null) {
            this.edh = new b();
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
                                a.this.edh.bduss = SapiAccountManager.getInstance().getSession().bduss;
                                a.this.edh.edl = SapiAccountManager.getInstance().getSession().getPtoken();
                                a.this.edh.displayName = getUserInfoResult.displayname;
                                a.this.edh.uid = getUserInfoResult.uid;
                                a.this.edh.aqo = getUserInfoResult.portraitHttps;
                                h.afr().putString("bd_box_display_name", a.this.edh.displayName);
                                h.afr().putString("bd_box_uid", a.this.edh.uid);
                                h.afr().putString("bd_box_avatar_url", a.this.edh.aqo);
                                h.afr().putString("bd_box_bduss", a.this.edh.bduss);
                                h.afr().putString("bd_box_ptoken", a.this.edh.edl);
                                aVar.onResult(0);
                                a.this.hF(true);
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

    public void aZG() {
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
                    a.this.edh.bduss = SapiAccountManager.getInstance().getSession().bduss;
                    a.this.edh.edl = SapiAccountManager.getInstance().getSession().getPtoken();
                    a.this.edh.displayName = getUserInfoResult.displayname;
                    a.this.edh.uid = getUserInfoResult.uid;
                    a.this.edh.aqo = getUserInfoResult.portraitHttps;
                    h.afr().putString("bd_box_display_name", a.this.edh.displayName);
                    h.afr().putString("bd_box_uid", a.this.edh.uid);
                    h.afr().putString("bd_box_avatar_url", a.this.edh.aqo);
                    h.afr().putString("bd_box_bduss", a.this.edh.bduss);
                    h.afr().putString("bd_box_ptoken", a.this.edh.edl);
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
        if (this.edh == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.edh.bduss)) {
            aZG();
        }
        return this.edh.bduss;
    }

    public String getUid() {
        if (this.edh == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.edh.uid)) {
            aZG();
        }
        return this.edh.uid;
    }

    public String aZH() {
        if (this.edh == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.edh.aqo)) {
            aZG();
        }
        return this.edh.aqo;
    }

    public String getDisplayName() {
        if (this.edh == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.edh.displayName)) {
            aZG();
        }
        return this.edh.displayName;
    }

    public boolean isLogin() {
        if (this.edh != null && TextUtils.isEmpty(this.edh.bduss)) {
            aZG();
        }
        return SapiAccountManager.getInstance().isLogin();
    }

    public void b(com.baidu.swan.apps.a.a aVar) {
        SapiAccountManager.getInstance().logout();
        hF(false);
        this.edh = new b();
        h.afr().putString("bd_box_display_name", "");
        h.afr().putString("bd_box_uid", "");
        h.afr().putString("bd_box_avatar_url", "");
        h.afr().putString("bd_box_bduss", "");
        h.afr().putString("bd_box_ptoken", "");
        if (aVar != null) {
            aVar.onResult(0);
        }
    }

    public void a(com.baidu.swan.apps.a.c cVar) {
        this.mListeners.add(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hF(boolean z) {
        for (com.baidu.swan.apps.a.c cVar : this.mListeners) {
            cVar.bS(z);
        }
    }
}
