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
import com.baidu.sapi2.callback.AddressManageCallback;
import com.baidu.sapi2.callback.GetOpenBdussCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.InvoiceBuildCallback;
import com.baidu.sapi2.callback.LoginStatusChangeCallback;
import com.baidu.sapi2.dto.AddressManageDTO;
import com.baidu.sapi2.dto.GetOpenBdussDTO;
import com.baidu.sapi2.dto.InvoiceBuildDTO;
import com.baidu.sapi2.result.AddressManageResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.InvoiceBuildResult;
import com.baidu.sapi2.result.OpenBdussResult;
import com.baidu.swan.apps.aq.aj;
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
/* loaded from: classes19.dex */
public class a {
    private b fhd;
    private List<com.baidu.swan.apps.a.c> mListeners;
    public static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    private a() {
        this.mListeners = new ArrayList();
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    private static class C0530a {
        private static final a fhi = new a();
    }

    public static a btC() {
        return C0530a.fhi;
    }

    public void init(Context context) {
        es(context);
        er(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void er(Context context) {
        if (this.fhd == null) {
            this.fhd = new b();
            this.fhd.aSW = h.auW().getString("bd_box_avatar_url", "");
            this.fhd.bduss = h.auW().getString("bd_box_bduss", "");
            this.fhd.fhl = h.auW().getString("bd_box_ptoken", "");
            this.fhd.uid = h.auW().getString("bd_box_uid", "");
            this.fhd.openBduss = h.auW().getString("bd_box_open_bduss", "");
            this.fhd.fhj = h.auW().getString("bd_box_union_id", "");
            this.fhd.fhk = aj.stringToMap(h.auW().getString("bd_box_stoken", ""));
            this.fhd.displayName = h.auW().getString("bd_box_display_name", "");
        }
    }

    private void es(final Context context) {
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
                a.this.er(context);
            }
        });
        PassportSDK.setLoginStatusChangeCallback(new LoginStatusChangeCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.5
            @Override // com.baidu.sapi2.callback.LoginStatusChangeCallback
            public void onChange() {
                a.this.jR(SapiAccountManager.getInstance().isLogin());
            }
        });
    }

    public void a(GetUserInfoResult getUserInfoResult) {
        if (getUserInfoResult != null) {
            try {
                h.auW().putString("host_account_info_string", getUserInfoResult.toString());
                if (this.fhd == null) {
                    this.fhd = new b();
                }
                this.fhd.bduss = SapiAccountManager.getInstance().getSession().bduss;
                this.fhd.fhl = SapiAccountManager.getInstance().getSession().getPtoken();
                this.fhd.displayName = getUserInfoResult.displayname;
                this.fhd.uid = getUserInfoResult.uid;
                this.fhd.aSW = getUserInfoResult.portraitHttps;
                h.auW().putString("bd_box_display_name", this.fhd.displayName);
                h.auW().putString("bd_box_uid", this.fhd.uid);
                h.auW().putString("bd_box_avatar_url", this.fhd.aSW);
                h.auW().putString("bd_box_bduss", this.fhd.bduss);
                h.auW().putString("bd_box_ptoken", this.fhd.fhl);
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.6
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                    public void onBdussExpired(GetUserInfoResult getUserInfoResult2) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(GetUserInfoResult getUserInfoResult2) {
                        if (getUserInfoResult2 != null) {
                            a.this.fhd.aSW = getUserInfoResult2.portraitHttps;
                        }
                        a.this.jR(true);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFailure(GetUserInfoResult getUserInfoResult2) {
                        a.this.jR(false);
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                    }
                }, this.fhd.bduss);
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
    public void btD() {
    }

    public void a(Context context, Bundle bundle, final com.baidu.swan.apps.a.a aVar) {
        int i;
        if (this.fhd == null) {
            this.fhd = new b();
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
                                a.this.fhd.bduss = SapiAccountManager.getInstance().getSession().bduss;
                                a.this.fhd.fhl = SapiAccountManager.getInstance().getSession().getPtoken();
                                a.this.fhd.displayName = getUserInfoResult.displayname;
                                a.this.fhd.uid = getUserInfoResult.uid;
                                a.this.fhd.aSW = getUserInfoResult.portraitHttps;
                                h.auW().putString("bd_box_display_name", a.this.fhd.displayName);
                                h.auW().putString("bd_box_uid", a.this.fhd.uid);
                                h.auW().putString("bd_box_avatar_url", a.this.fhd.aSW);
                                h.auW().putString("bd_box_bduss", a.this.fhd.bduss);
                                h.auW().putString("bd_box_ptoken", a.this.fhd.fhl);
                                aVar.onResult(0);
                                a.this.jR(true);
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
                a.this.fhd.bduss = SapiAccountManager.getInstance().getSession().bduss;
                a.this.fhd.fhl = SapiAccountManager.getInstance().getSession().getPtoken();
                a.this.fhd.displayName = getUserInfoResult.displayname;
                a.this.fhd.uid = getUserInfoResult.uid;
                a.this.fhd.aSW = getUserInfoResult.portraitHttps;
                h.auW().putString("bd_box_display_name", a.this.fhd.displayName);
                h.auW().putString("bd_box_uid", a.this.fhd.uid);
                h.auW().putString("bd_box_avatar_url", a.this.fhd.aSW);
                h.auW().putString("bd_box_bduss", a.this.fhd.bduss);
                h.auW().putString("bd_box_ptoken", a.this.fhd.fhl);
                a.this.btD();
                aVar.onResult(0);
                a.this.jR(true);
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

    public void btE() {
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
                        a.this.fhd.bduss = SapiAccountManager.getInstance().getSession().bduss;
                        a.this.fhd.fhl = SapiAccountManager.getInstance().getSession().getPtoken();
                        a.this.fhd.displayName = getUserInfoResult.displayname;
                        a.this.fhd.uid = getUserInfoResult.uid;
                        a.this.fhd.aSW = getUserInfoResult.portraitHttps;
                        h.auW().putString("bd_box_display_name", a.this.fhd.displayName);
                        h.auW().putString("bd_box_uid", a.this.fhd.uid);
                        h.auW().putString("bd_box_avatar_url", a.this.fhd.aSW);
                        h.auW().putString("bd_box_bduss", a.this.fhd.bduss);
                        h.auW().putString("bd_box_ptoken", a.this.fhd.fhl);
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
        if (this.fhd == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.fhd.bduss)) {
            btE();
        }
        return this.fhd.bduss;
    }

    public String getUid() {
        if (this.fhd == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.fhd.uid)) {
            btE();
        }
        return this.fhd.uid;
    }

    public String btF() {
        if (this.fhd == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.fhd.aSW)) {
            btE();
        }
        return this.fhd.aSW;
    }

    public String getDisplayName() {
        if (this.fhd == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.fhd.displayName)) {
            btE();
        }
        return this.fhd.displayName;
    }

    public boolean isLogin() {
        if (this.fhd != null && TextUtils.isEmpty(this.fhd.bduss)) {
            btE();
        }
        return SapiAccountManager.getInstance().isLogin();
    }

    public void i(com.baidu.swan.apps.a.a aVar) {
        SapiAccountManager.getInstance().logout();
        jR(false);
        this.fhd = new b();
        h.auW().putString("bd_box_display_name", "");
        h.auW().putString("bd_box_uid", "");
        h.auW().putString("bd_box_avatar_url", "");
        h.auW().putString("bd_box_bduss", "");
        h.auW().putString("bd_box_ptoken", "");
        if (aVar != null) {
            aVar.onResult(0);
        }
    }

    public void a(com.baidu.swan.apps.a.c cVar) {
        this.mListeners.add(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jR(boolean z) {
        for (com.baidu.swan.apps.a.c cVar : this.mListeners) {
            cVar.dj(z);
        }
    }

    public void a(Context context, final String str, final a.InterfaceC0421a interfaceC0421a) {
        AddressManageDTO addressManageDTO = new AddressManageDTO();
        addressManageDTO.type = str;
        addressManageDTO.sweepLightLoading = true;
        PassportSDK.getInstance().loadAddressManage(context, addressManageDTO, new AddressManageCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.10
            @Override // com.baidu.sapi2.callback.AddressManageCallback
            public void onFinish(AddressManageResult addressManageResult) {
                if ("0".equals(str) || interfaceC0421a == null) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, String.format("管理收货地址流程结束（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg()));
                    }
                } else if (addressManageResult.getResultCode() != 0) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, String.format("选择收货地址错误（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg()));
                    }
                    interfaceC0421a.ayl();
                } else {
                    interfaceC0421a.hw(addressManageResult.map.get("addrId"));
                }
            }
        });
    }

    public void a(Context context, final String str, final a.InterfaceC0423a interfaceC0423a) {
        InvoiceBuildDTO invoiceBuildDTO = new InvoiceBuildDTO();
        invoiceBuildDTO.TYPE = str;
        PassportSDK.getInstance().loadInvoiceBuild(context, invoiceBuildDTO, new InvoiceBuildCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.2
            @Override // com.baidu.sapi2.callback.InvoiceBuildCallback
            public void onFinish(InvoiceBuildResult invoiceBuildResult) {
                if ("0".equals(str) || interfaceC0423a == null) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, String.format("发票管理流程结束（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg()));
                    }
                } else if (invoiceBuildResult.getResultCode() != 0) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, String.format("获取发票错误（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg()));
                    }
                    interfaceC0423a.ayl();
                } else {
                    interfaceC0423a.ch(invoiceBuildResult.map.get(InvoiceBuildResult.KEY_INVOICE_ID), str);
                }
            }
        });
    }

    public void b(String str, ArrayList<String> arrayList, final b.a aVar) {
        if (this.fhd == null) {
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
                a.this.fhd.openBduss = openBdussResult.openBduss;
                a.this.fhd.fhj = openBdussResult.unionid;
                a.this.fhd.fhk = openBdussResult.tplStokenMap;
                h.auW().putString("bd_box_open_bduss", a.this.fhd.openBduss);
                h.auW().putString("bd_box_union_id", a.this.fhd.fhj);
                h.auW().putString("bd_box_stoken", aj.mapToString(a.this.fhd.fhk));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("openbduss", a.this.fhd.openBduss);
                    jSONObject.put(SocialOperation.GAME_UNION_ID, a.this.fhd.fhj);
                    JSONObject jSONObject2 = new JSONObject();
                    for (String str2 : a.this.fhd.fhk.keySet()) {
                        jSONObject2.put(str2, a.this.fhd.fhk.get(str2));
                    }
                    jSONObject.put("stokenmap", jSONObject2);
                    jSONObject.put("uid", a.this.fhd.uid);
                    jSONObject.put("bduss", a.this.fhd.bduss);
                    jSONObject.put(SapiAccountManager.SESSION_DISPLAYNAME, a.this.fhd.displayName);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                aVar.qT(jSONObject.toString());
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
