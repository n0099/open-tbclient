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
    private b fWk;
    private List<com.baidu.swan.apps.a.c> mListeners;
    public static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    private a() {
        this.mListeners = new ArrayList();
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    private static class C0615a {
        private static final a fWp = new a();
    }

    public static a bKO() {
        return C0615a.fWp;
    }

    public void init(Context context) {
        eN(context);
        eM(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eM(Context context) {
        if (this.fWk == null) {
            this.fWk = new b();
            this.fWk.bgP = h.aKS().getString("bd_box_avatar_url", "");
            this.fWk.bduss = h.aKS().getString("bd_box_bduss", "");
            this.fWk.fWs = h.aKS().getString("bd_box_ptoken", "");
            this.fWk.uid = h.aKS().getString("bd_box_uid", "");
            this.fWk.openBduss = h.aKS().getString("bd_box_open_bduss", "");
            this.fWk.fWq = h.aKS().getString("bd_box_union_id", "");
            this.fWk.fWr = ai.stringToMap(h.aKS().getString("bd_box_stoken", ""));
            this.fWk.displayName = h.aKS().getString("bd_box_display_name", "");
        }
    }

    private void eN(final Context context) {
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
                a.this.eM(context);
            }
        });
        PassportSDK.setLoginStatusChangeCallback(new LoginStatusChangeCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.5
            @Override // com.baidu.sapi2.callback.LoginStatusChangeCallback
            public void onChange() {
                a.this.lm(SapiAccountManager.getInstance().isLogin());
            }
        });
    }

    public void a(GetUserInfoResult getUserInfoResult) {
        if (getUserInfoResult != null) {
            try {
                h.aKS().putString("host_account_info_string", getUserInfoResult.toString());
                if (this.fWk == null) {
                    this.fWk = new b();
                }
                this.fWk.bduss = SapiAccountManager.getInstance().getSession().bduss;
                this.fWk.fWs = SapiAccountManager.getInstance().getSession().getPtoken();
                this.fWk.displayName = getUserInfoResult.displayname;
                this.fWk.uid = getUserInfoResult.uid;
                this.fWk.bgP = getUserInfoResult.portraitHttps;
                h.aKS().putString("bd_box_display_name", this.fWk.displayName);
                h.aKS().putString("bd_box_uid", this.fWk.uid);
                h.aKS().putString("bd_box_avatar_url", this.fWk.bgP);
                h.aKS().putString("bd_box_bduss", this.fWk.bduss);
                h.aKS().putString("bd_box_ptoken", this.fWk.fWs);
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.6
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                    public void onBdussExpired(GetUserInfoResult getUserInfoResult2) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(GetUserInfoResult getUserInfoResult2) {
                        if (getUserInfoResult2 != null) {
                            a.this.fWk.bgP = getUserInfoResult2.portraitHttps;
                        }
                        a.this.lm(true);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFailure(GetUserInfoResult getUserInfoResult2) {
                        a.this.lm(false);
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                    }
                }, this.fWk.bduss);
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
    public void bKP() {
    }

    public void a(Context context, Bundle bundle, final com.baidu.swan.apps.a.a aVar) {
        int i;
        if (this.fWk == null) {
            this.fWk = new b();
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
                                a.this.fWk.bduss = SapiAccountManager.getInstance().getSession().bduss;
                                a.this.fWk.fWs = SapiAccountManager.getInstance().getSession().getPtoken();
                                a.this.fWk.displayName = getUserInfoResult.displayname;
                                a.this.fWk.uid = getUserInfoResult.uid;
                                a.this.fWk.bgP = getUserInfoResult.portraitHttps;
                                h.aKS().putString("bd_box_display_name", a.this.fWk.displayName);
                                h.aKS().putString("bd_box_uid", a.this.fWk.uid);
                                h.aKS().putString("bd_box_avatar_url", a.this.fWk.bgP);
                                h.aKS().putString("bd_box_bduss", a.this.fWk.bduss);
                                h.aKS().putString("bd_box_ptoken", a.this.fWk.fWs);
                                aVar.onResult(0);
                                a.this.lm(true);
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
                a.this.fWk.bduss = SapiAccountManager.getInstance().getSession().bduss;
                a.this.fWk.fWs = SapiAccountManager.getInstance().getSession().getPtoken();
                a.this.fWk.displayName = getUserInfoResult.displayname;
                a.this.fWk.uid = getUserInfoResult.uid;
                a.this.fWk.bgP = getUserInfoResult.portraitHttps;
                h.aKS().putString("bd_box_display_name", a.this.fWk.displayName);
                h.aKS().putString("bd_box_uid", a.this.fWk.uid);
                h.aKS().putString("bd_box_avatar_url", a.this.fWk.bgP);
                h.aKS().putString("bd_box_bduss", a.this.fWk.bduss);
                h.aKS().putString("bd_box_ptoken", a.this.fWk.fWs);
                a.this.bKP();
                aVar.onResult(0);
                a.this.lm(true);
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

    public void bKQ() {
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
                        a.this.fWk.bduss = SapiAccountManager.getInstance().getSession().bduss;
                        a.this.fWk.fWs = SapiAccountManager.getInstance().getSession().getPtoken();
                        a.this.fWk.displayName = getUserInfoResult.displayname;
                        a.this.fWk.uid = getUserInfoResult.uid;
                        a.this.fWk.bgP = getUserInfoResult.portraitHttps;
                        h.aKS().putString("bd_box_display_name", a.this.fWk.displayName);
                        h.aKS().putString("bd_box_uid", a.this.fWk.uid);
                        h.aKS().putString("bd_box_avatar_url", a.this.fWk.bgP);
                        h.aKS().putString("bd_box_bduss", a.this.fWk.bduss);
                        h.aKS().putString("bd_box_ptoken", a.this.fWk.fWs);
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
        if (this.fWk == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.fWk.bduss)) {
            bKQ();
        }
        return this.fWk.bduss;
    }

    public String getUid() {
        if (this.fWk == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.fWk.uid)) {
            bKQ();
        }
        return this.fWk.uid;
    }

    public String bKR() {
        if (this.fWk == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.fWk.bgP)) {
            bKQ();
        }
        return this.fWk.bgP;
    }

    public String getDisplayName() {
        if (this.fWk == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.fWk.displayName)) {
            bKQ();
        }
        return this.fWk.displayName;
    }

    public boolean isLogin() {
        if (this.fWk != null && TextUtils.isEmpty(this.fWk.bduss)) {
            bKQ();
        }
        return SapiAccountManager.getInstance().isLogin();
    }

    public void i(com.baidu.swan.apps.a.a aVar) {
        SapiAccountManager.getInstance().logout();
        lm(false);
        this.fWk = new b();
        h.aKS().putString("bd_box_display_name", "");
        h.aKS().putString("bd_box_uid", "");
        h.aKS().putString("bd_box_avatar_url", "");
        h.aKS().putString("bd_box_bduss", "");
        h.aKS().putString("bd_box_ptoken", "");
        if (aVar != null) {
            aVar.onResult(0);
        }
    }

    public void a(com.baidu.swan.apps.a.c cVar) {
        this.mListeners.add(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lm(boolean z) {
        for (com.baidu.swan.apps.a.c cVar : this.mListeners) {
            cVar.ei(z);
        }
    }

    public void a(Context context, final String str, final a.InterfaceC0502a interfaceC0502a) {
        AddressManageDTO addressManageDTO = new AddressManageDTO();
        addressManageDTO.type = str;
        addressManageDTO.sweepLightLoading = true;
        PassportSDK.getInstance().loadAddressManage(context, addressManageDTO, new AddressManageCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.10
            @Override // com.baidu.sapi2.ecommerce.callback.AddressManageCallback
            public void onFinish(AddressManageResult addressManageResult) {
                if ("0".equals(str) || interfaceC0502a == null) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, String.format("管理收货地址流程结束（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg()));
                    }
                } else if (addressManageResult.getResultCode() != 0) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, String.format("选择收货地址错误（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg()));
                    }
                    interfaceC0502a.aOg();
                } else {
                    interfaceC0502a.kH(addressManageResult.map.get("addrId"));
                }
            }
        });
    }

    public void a(Context context, final String str, final a.InterfaceC0504a interfaceC0504a) {
        InvoiceBuildDTO invoiceBuildDTO = new InvoiceBuildDTO();
        invoiceBuildDTO.TYPE = str;
        PassportSDK.getInstance().loadInvoiceBuild(context, invoiceBuildDTO, new InvoiceBuildCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.2
            @Override // com.baidu.sapi2.ecommerce.callback.InvoiceBuildCallback
            public void onFinish(InvoiceBuildResult invoiceBuildResult) {
                if ("0".equals(str) || interfaceC0504a == null) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, String.format("发票管理流程结束（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg()));
                    }
                } else if (invoiceBuildResult.getResultCode() != 0) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, String.format("获取发票错误（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg()));
                    }
                    interfaceC0504a.aOg();
                } else {
                    interfaceC0504a.cM(invoiceBuildResult.map.get(InvoiceBuildResult.KEY_INVOICE_ID), str);
                }
            }
        });
    }

    public void b(String str, ArrayList<String> arrayList, final b.a aVar) {
        if (this.fWk == null) {
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
                a.this.fWk.openBduss = openBdussResult.openBduss;
                a.this.fWk.fWq = openBdussResult.unionid;
                a.this.fWk.fWr = openBdussResult.tplStokenMap;
                h.aKS().putString("bd_box_open_bduss", a.this.fWk.openBduss);
                h.aKS().putString("bd_box_union_id", a.this.fWk.fWq);
                h.aKS().putString("bd_box_stoken", ai.mapToString(a.this.fWk.fWr));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("openbduss", a.this.fWk.openBduss);
                    jSONObject.put(SocialOperation.GAME_UNION_ID, a.this.fWk.fWq);
                    JSONObject jSONObject2 = new JSONObject();
                    for (String str2 : a.this.fWk.fWr.keySet()) {
                        jSONObject2.put(str2, a.this.fWk.fWr.get(str2));
                    }
                    jSONObject.put("stokenmap", jSONObject2);
                    jSONObject.put("uid", a.this.fWk.uid);
                    jSONObject.put("bduss", a.this.fWk.bduss);
                    jSONObject.put(SapiAccountManager.SESSION_DISPLAYNAME, a.this.fWk.displayName);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                aVar.uI(jSONObject.toString());
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
