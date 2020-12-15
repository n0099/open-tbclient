package com.baidu.tieba.aiapps.apps.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetOpenBdussCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.LoginStatusChangeCallback;
import com.baidu.sapi2.dto.GetOpenBdussDTO;
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
import com.baidu.sapi2.ecommerce.callback.InvoiceBuildCallback;
import com.baidu.sapi2.ecommerce.dto.AddressManageDTO;
import com.baidu.sapi2.ecommerce.dto.InvoiceBuildDTO;
import com.baidu.sapi2.ecommerce.result.AddressManageResult;
import com.baidu.sapi2.ecommerce.result.InvoiceBuildResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.OpenBdussResult;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.bdprivate.api.b;
import com.baidu.swan.bdprivate.b.a;
import com.baidu.swan.bdprivate.d.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.tencent.open.SocialOperation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a {
    private b ged;
    private List<com.baidu.swan.apps.a.c> mListeners;
    public static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    private a() {
        this.mListeners = new ArrayList();
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    private static class C0627a {
        private static final a gei = new a();
    }

    public static a bNQ() {
        return C0627a.gei;
    }

    public void init(Context context) {
        ft(context);
        fs(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs(Context context) {
        if (this.ged == null) {
            this.ged = new b();
            this.ged.bjs = h.aNr().getString("bd_box_avatar_url", "");
            this.ged.bduss = h.aNr().getString("bd_box_bduss", "");
            this.ged.gel = h.aNr().getString("bd_box_ptoken", "");
            this.ged.uid = h.aNr().getString("bd_box_uid", "");
            this.ged.openBduss = h.aNr().getString("bd_box_open_bduss", "");
            this.ged.gej = h.aNr().getString("bd_box_union_id", "");
            this.ged.gek = ai.stringToMap(h.aNr().getString("bd_box_stoken", ""));
            this.ged.displayName = h.aNr().getString("bd_box_display_name", "");
        }
    }

    private void ft(final Context context) {
        SapiAccountManager.registerSilentShareListener(new SapiAccountManager.SilentShareListener() { // from class: com.baidu.tieba.aiapps.apps.a.a.1
            @Override // com.baidu.sapi2.SapiAccountManager.SilentShareListener
            public void onSilentShare() {
                context.sendBroadcast(new Intent("com.baidu.intent.action.SILENT_SHARE"));
                SapiAccountManager.unregisterSilentShareListener();
            }
        });
        SapiAccountManager.registerReceiveShareListener(new SapiAccountManager.ReceiveShareListener() { // from class: com.baidu.tieba.aiapps.apps.a.a.4
            @Override // com.baidu.sapi2.SapiAccountManager.ReceiveShareListener
            public void onReceiveShare() {
                a.this.fs(context);
            }
        });
        PassportSDK.setLoginStatusChangeCallback(new LoginStatusChangeCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.5
            @Override // com.baidu.sapi2.callback.LoginStatusChangeCallback
            public void onChange() {
                a.this.lI(SapiAccountManager.getInstance().isLogin());
            }
        });
    }

    public void a(GetUserInfoResult getUserInfoResult) {
        if (getUserInfoResult != null) {
            try {
                h.aNr().putString("host_account_info_string", getUserInfoResult.toString());
                if (this.ged == null) {
                    this.ged = new b();
                }
                this.ged.bduss = SapiAccountManager.getInstance().getSession().bduss;
                this.ged.gel = SapiAccountManager.getInstance().getSession().getPtoken();
                this.ged.displayName = getUserInfoResult.displayname;
                this.ged.uid = getUserInfoResult.uid;
                this.ged.bjs = getUserInfoResult.portraitHttps;
                h.aNr().putString("bd_box_display_name", this.ged.displayName);
                h.aNr().putString("bd_box_uid", this.ged.uid);
                h.aNr().putString("bd_box_avatar_url", this.ged.bjs);
                h.aNr().putString("bd_box_bduss", this.ged.bduss);
                h.aNr().putString("bd_box_ptoken", this.ged.gel);
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.6
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                    public void onBdussExpired(GetUserInfoResult getUserInfoResult2) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(GetUserInfoResult getUserInfoResult2) {
                        if (getUserInfoResult2 != null) {
                            a.this.ged.bjs = getUserInfoResult2.portraitHttps;
                        }
                        a.this.lI(true);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFailure(GetUserInfoResult getUserInfoResult2) {
                        a.this.lI(false);
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                    }
                }, this.ged.bduss);
                return;
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        }
        i(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNR() {
    }

    public void a(Context context, Bundle bundle, final com.baidu.swan.apps.a.a aVar) {
        int i;
        if (this.ged == null) {
            this.ged = new b();
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
        MessageManager.getInstance().registerListener(new CustomMessageListener(2921362) { // from class: com.baidu.tieba.aiapps.apps.a.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Integer) {
                    if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                        SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.7.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.sapi2.callback.LoginStatusAware
                            public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                                aVar.onResult(-1);
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.sapi2.callback.SapiCallback
                            public void onSuccess(GetUserInfoResult getUserInfoResult) {
                                a.this.ged.bduss = SapiAccountManager.getInstance().getSession().bduss;
                                a.this.ged.gel = SapiAccountManager.getInstance().getSession().getPtoken();
                                a.this.ged.displayName = getUserInfoResult.displayname;
                                a.this.ged.uid = getUserInfoResult.uid;
                                a.this.ged.bjs = getUserInfoResult.portraitHttps;
                                h.aNr().putString("bd_box_display_name", a.this.ged.displayName);
                                h.aNr().putString("bd_box_uid", a.this.ged.uid);
                                h.aNr().putString("bd_box_avatar_url", a.this.ged.bjs);
                                h.aNr().putString("bd_box_bduss", a.this.ged.bduss);
                                h.aNr().putString("bd_box_ptoken", a.this.ged.gel);
                                aVar.onResult(0);
                                a.this.lI(true);
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

    public void h(final com.baidu.swan.apps.a.a aVar) {
        SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.LoginStatusAware
            public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                aVar.onResult(-1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetUserInfoResult getUserInfoResult) {
                a.this.ged.bduss = SapiAccountManager.getInstance().getSession().bduss;
                a.this.ged.gel = SapiAccountManager.getInstance().getSession().getPtoken();
                a.this.ged.displayName = getUserInfoResult.displayname;
                a.this.ged.uid = getUserInfoResult.uid;
                a.this.ged.bjs = getUserInfoResult.portraitHttps;
                h.aNr().putString("bd_box_display_name", a.this.ged.displayName);
                h.aNr().putString("bd_box_uid", a.this.ged.uid);
                h.aNr().putString("bd_box_avatar_url", a.this.ged.bjs);
                h.aNr().putString("bd_box_bduss", a.this.ged.bduss);
                h.aNr().putString("bd_box_ptoken", a.this.ged.gel);
                a.this.bNR();
                aVar.onResult(0);
                a.this.lI(true);
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

    public void bNS() {
        try {
            SapiAccountManager.getInstance().getConfignation();
        } catch (Exception e) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SAPI_INIT, TbadkCoreApplication.getInst().getApp()));
        }
        try {
            SapiAccountManager.getInstance().isLogin();
            if (SapiAccountManager.getInstance().isLogin()) {
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.9
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                    public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(GetUserInfoResult getUserInfoResult) {
                        a.this.ged.bduss = SapiAccountManager.getInstance().getSession().bduss;
                        a.this.ged.gel = SapiAccountManager.getInstance().getSession().getPtoken();
                        a.this.ged.displayName = getUserInfoResult.displayname;
                        a.this.ged.uid = getUserInfoResult.uid;
                        a.this.ged.bjs = getUserInfoResult.portraitHttps;
                        h.aNr().putString("bd_box_display_name", a.this.ged.displayName);
                        h.aNr().putString("bd_box_uid", a.this.ged.uid);
                        h.aNr().putString("bd_box_avatar_url", a.this.ged.bjs);
                        h.aNr().putString("bd_box_bduss", a.this.ged.bduss);
                        h.aNr().putString("bd_box_ptoken", a.this.ged.gel);
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
        if (this.ged == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.ged.bduss)) {
            bNS();
        }
        return this.ged.bduss;
    }

    public String getUid() {
        if (this.ged == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.ged.uid)) {
            bNS();
        }
        return this.ged.uid;
    }

    public String bNT() {
        if (this.ged == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.ged.bjs)) {
            bNS();
        }
        return this.ged.bjs;
    }

    public String getDisplayName() {
        if (this.ged == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.ged.displayName)) {
            bNS();
        }
        return this.ged.displayName;
    }

    public boolean isLogin() {
        if (this.ged != null && TextUtils.isEmpty(this.ged.bduss)) {
            bNS();
        }
        return SapiAccountManager.getInstance().isLogin();
    }

    public void i(com.baidu.swan.apps.a.a aVar) {
        SapiAccountManager.getInstance().logout();
        lI(false);
        this.ged = new b();
        h.aNr().putString("bd_box_display_name", "");
        h.aNr().putString("bd_box_uid", "");
        h.aNr().putString("bd_box_avatar_url", "");
        h.aNr().putString("bd_box_bduss", "");
        h.aNr().putString("bd_box_ptoken", "");
        if (aVar != null) {
            aVar.onResult(0);
        }
    }

    public void a(com.baidu.swan.apps.a.c cVar) {
        this.mListeners.add(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lI(boolean z) {
        for (com.baidu.swan.apps.a.c cVar : this.mListeners) {
            cVar.eA(z);
        }
    }

    public void a(Context context, final String str, final a.InterfaceC0512a interfaceC0512a) {
        AddressManageDTO addressManageDTO = new AddressManageDTO();
        addressManageDTO.type = str;
        addressManageDTO.sweepLightLoading = true;
        PassportSDK.getInstance().loadAddressManage(context, addressManageDTO, new AddressManageCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.10
            @Override // com.baidu.sapi2.ecommerce.callback.AddressManageCallback
            public void onFinish(AddressManageResult addressManageResult) {
                if ("0".equals(str) || interfaceC0512a == null) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, String.format("管理收货地址流程结束（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg()));
                    }
                } else if (addressManageResult.getResultCode() != 0) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, String.format("选择收货地址错误（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg()));
                    }
                    interfaceC0512a.aQE();
                } else {
                    interfaceC0512a.li(addressManageResult.map.get("addrId"));
                }
            }
        });
    }

    public void a(Context context, final String str, final a.InterfaceC0514a interfaceC0514a) {
        InvoiceBuildDTO invoiceBuildDTO = new InvoiceBuildDTO();
        invoiceBuildDTO.TYPE = str;
        PassportSDK.getInstance().loadInvoiceBuild(context, invoiceBuildDTO, new InvoiceBuildCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.2
            @Override // com.baidu.sapi2.ecommerce.callback.InvoiceBuildCallback
            public void onFinish(InvoiceBuildResult invoiceBuildResult) {
                if ("0".equals(str) || interfaceC0514a == null) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, String.format("发票管理流程结束（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg()));
                    }
                } else if (invoiceBuildResult.getResultCode() != 0) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, String.format("获取发票错误（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg()));
                    }
                    interfaceC0514a.aQE();
                } else {
                    interfaceC0514a.cS(invoiceBuildResult.map.get(InvoiceBuildResult.KEY_INVOICE_ID), str);
                }
            }
        });
    }

    public void b(String str, ArrayList<String> arrayList, final b.a aVar) {
        if (this.ged == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return;
        }
        GetOpenBdussDTO getOpenBdussDTO = new GetOpenBdussDTO();
        getOpenBdussDTO.clientId = str;
        getOpenBdussDTO.targetTplList.addAll(arrayList);
        SapiAccountManager.getInstance().getAccountService().getOpenBduss(getOpenBdussDTO, new GetOpenBdussCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            /* renamed from: c */
            public void onSuccess(OpenBdussResult openBdussResult) {
                a.this.ged.openBduss = openBdussResult.openBduss;
                a.this.ged.gej = openBdussResult.unionid;
                a.this.ged.gek = openBdussResult.tplStokenMap;
                h.aNr().putString("bd_box_open_bduss", a.this.ged.openBduss);
                h.aNr().putString("bd_box_union_id", a.this.ged.gej);
                h.aNr().putString("bd_box_stoken", ai.mapToString(a.this.ged.gek));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("openbduss", a.this.ged.openBduss);
                    jSONObject.put(SocialOperation.GAME_UNION_ID, a.this.ged.gej);
                    JSONObject jSONObject2 = new JSONObject();
                    for (String str2 : a.this.ged.gek.keySet()) {
                        jSONObject2.put(str2, a.this.ged.gek.get(str2));
                    }
                    jSONObject.put("stokenmap", jSONObject2);
                    jSONObject.put("uid", a.this.ged.uid);
                    jSONObject.put("bduss", a.this.ged.bduss);
                    jSONObject.put(SapiAccountManager.SESSION_DISPLAYNAME, a.this.ged.displayName);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                aVar.vk(jSONObject.toString());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            /* renamed from: d */
            public void onFailure(OpenBdussResult openBdussResult) {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
            }
        });
    }
}
