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
/* loaded from: classes19.dex */
public class a {
    private b fsE;
    private List<com.baidu.swan.apps.a.c> mListeners;
    public static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    private a() {
        this.mListeners = new ArrayList();
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    private static class C0576a {
        private static final a fsJ = new a();
    }

    public static a bCy() {
        return C0576a.fsJ;
    }

    public void init(Context context) {
        eA(context);
        ez(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ez(Context context) {
        if (this.fsE == null) {
            this.fsE = new b();
            this.fsE.aYm = h.aDf().getString("bd_box_avatar_url", "");
            this.fsE.bduss = h.aDf().getString("bd_box_bduss", "");
            this.fsE.fsM = h.aDf().getString("bd_box_ptoken", "");
            this.fsE.uid = h.aDf().getString("bd_box_uid", "");
            this.fsE.openBduss = h.aDf().getString("bd_box_open_bduss", "");
            this.fsE.fsK = h.aDf().getString("bd_box_union_id", "");
            this.fsE.fsL = ai.stringToMap(h.aDf().getString("bd_box_stoken", ""));
            this.fsE.displayName = h.aDf().getString("bd_box_display_name", "");
        }
    }

    private void eA(final Context context) {
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
                a.this.ez(context);
            }
        });
        PassportSDK.setLoginStatusChangeCallback(new LoginStatusChangeCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.5
            @Override // com.baidu.sapi2.callback.LoginStatusChangeCallback
            public void onChange() {
                a.this.kr(SapiAccountManager.getInstance().isLogin());
            }
        });
    }

    public void a(GetUserInfoResult getUserInfoResult) {
        if (getUserInfoResult != null) {
            try {
                h.aDf().putString("host_account_info_string", getUserInfoResult.toString());
                if (this.fsE == null) {
                    this.fsE = new b();
                }
                this.fsE.bduss = SapiAccountManager.getInstance().getSession().bduss;
                this.fsE.fsM = SapiAccountManager.getInstance().getSession().getPtoken();
                this.fsE.displayName = getUserInfoResult.displayname;
                this.fsE.uid = getUserInfoResult.uid;
                this.fsE.aYm = getUserInfoResult.portraitHttps;
                h.aDf().putString("bd_box_display_name", this.fsE.displayName);
                h.aDf().putString("bd_box_uid", this.fsE.uid);
                h.aDf().putString("bd_box_avatar_url", this.fsE.aYm);
                h.aDf().putString("bd_box_bduss", this.fsE.bduss);
                h.aDf().putString("bd_box_ptoken", this.fsE.fsM);
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.6
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                    public void onBdussExpired(GetUserInfoResult getUserInfoResult2) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(GetUserInfoResult getUserInfoResult2) {
                        if (getUserInfoResult2 != null) {
                            a.this.fsE.aYm = getUserInfoResult2.portraitHttps;
                        }
                        a.this.kr(true);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFailure(GetUserInfoResult getUserInfoResult2) {
                        a.this.kr(false);
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                    }
                }, this.fsE.bduss);
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
    public void bCz() {
    }

    public void a(Context context, Bundle bundle, final com.baidu.swan.apps.a.a aVar) {
        int i;
        if (this.fsE == null) {
            this.fsE = new b();
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
                                a.this.fsE.bduss = SapiAccountManager.getInstance().getSession().bduss;
                                a.this.fsE.fsM = SapiAccountManager.getInstance().getSession().getPtoken();
                                a.this.fsE.displayName = getUserInfoResult.displayname;
                                a.this.fsE.uid = getUserInfoResult.uid;
                                a.this.fsE.aYm = getUserInfoResult.portraitHttps;
                                h.aDf().putString("bd_box_display_name", a.this.fsE.displayName);
                                h.aDf().putString("bd_box_uid", a.this.fsE.uid);
                                h.aDf().putString("bd_box_avatar_url", a.this.fsE.aYm);
                                h.aDf().putString("bd_box_bduss", a.this.fsE.bduss);
                                h.aDf().putString("bd_box_ptoken", a.this.fsE.fsM);
                                aVar.onResult(0);
                                a.this.kr(true);
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
                a.this.fsE.bduss = SapiAccountManager.getInstance().getSession().bduss;
                a.this.fsE.fsM = SapiAccountManager.getInstance().getSession().getPtoken();
                a.this.fsE.displayName = getUserInfoResult.displayname;
                a.this.fsE.uid = getUserInfoResult.uid;
                a.this.fsE.aYm = getUserInfoResult.portraitHttps;
                h.aDf().putString("bd_box_display_name", a.this.fsE.displayName);
                h.aDf().putString("bd_box_uid", a.this.fsE.uid);
                h.aDf().putString("bd_box_avatar_url", a.this.fsE.aYm);
                h.aDf().putString("bd_box_bduss", a.this.fsE.bduss);
                h.aDf().putString("bd_box_ptoken", a.this.fsE.fsM);
                a.this.bCz();
                aVar.onResult(0);
                a.this.kr(true);
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

    public void bCA() {
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
                        a.this.fsE.bduss = SapiAccountManager.getInstance().getSession().bduss;
                        a.this.fsE.fsM = SapiAccountManager.getInstance().getSession().getPtoken();
                        a.this.fsE.displayName = getUserInfoResult.displayname;
                        a.this.fsE.uid = getUserInfoResult.uid;
                        a.this.fsE.aYm = getUserInfoResult.portraitHttps;
                        h.aDf().putString("bd_box_display_name", a.this.fsE.displayName);
                        h.aDf().putString("bd_box_uid", a.this.fsE.uid);
                        h.aDf().putString("bd_box_avatar_url", a.this.fsE.aYm);
                        h.aDf().putString("bd_box_bduss", a.this.fsE.bduss);
                        h.aDf().putString("bd_box_ptoken", a.this.fsE.fsM);
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
        if (this.fsE == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.fsE.bduss)) {
            bCA();
        }
        return this.fsE.bduss;
    }

    public String getUid() {
        if (this.fsE == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.fsE.uid)) {
            bCA();
        }
        return this.fsE.uid;
    }

    public String bCB() {
        if (this.fsE == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.fsE.aYm)) {
            bCA();
        }
        return this.fsE.aYm;
    }

    public String getDisplayName() {
        if (this.fsE == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.fsE.displayName)) {
            bCA();
        }
        return this.fsE.displayName;
    }

    public boolean isLogin() {
        if (this.fsE != null && TextUtils.isEmpty(this.fsE.bduss)) {
            bCA();
        }
        return SapiAccountManager.getInstance().isLogin();
    }

    public void i(com.baidu.swan.apps.a.a aVar) {
        SapiAccountManager.getInstance().logout();
        kr(false);
        this.fsE = new b();
        h.aDf().putString("bd_box_display_name", "");
        h.aDf().putString("bd_box_uid", "");
        h.aDf().putString("bd_box_avatar_url", "");
        h.aDf().putString("bd_box_bduss", "");
        h.aDf().putString("bd_box_ptoken", "");
        if (aVar != null) {
            aVar.onResult(0);
        }
    }

    public void a(com.baidu.swan.apps.a.c cVar) {
        this.mListeners.add(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kr(boolean z) {
        for (com.baidu.swan.apps.a.c cVar : this.mListeners) {
            cVar.ds(z);
        }
    }

    public void a(Context context, final String str, final a.InterfaceC0464a interfaceC0464a) {
        AddressManageDTO addressManageDTO = new AddressManageDTO();
        addressManageDTO.type = str;
        addressManageDTO.sweepLightLoading = true;
        PassportSDK.getInstance().loadAddressManage(context, addressManageDTO, new AddressManageCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.10
            @Override // com.baidu.sapi2.ecommerce.callback.AddressManageCallback
            public void onFinish(AddressManageResult addressManageResult) {
                if ("0".equals(str) || interfaceC0464a == null) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, String.format("管理收货地址流程结束（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg()));
                    }
                } else if (addressManageResult.getResultCode() != 0) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, String.format("选择收货地址错误（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg()));
                    }
                    interfaceC0464a.aGt();
                } else {
                    interfaceC0464a.iU(addressManageResult.map.get("addrId"));
                }
            }
        });
    }

    public void a(Context context, final String str, final a.InterfaceC0466a interfaceC0466a) {
        InvoiceBuildDTO invoiceBuildDTO = new InvoiceBuildDTO();
        invoiceBuildDTO.TYPE = str;
        PassportSDK.getInstance().loadInvoiceBuild(context, invoiceBuildDTO, new InvoiceBuildCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.2
            @Override // com.baidu.sapi2.ecommerce.callback.InvoiceBuildCallback
            public void onFinish(InvoiceBuildResult invoiceBuildResult) {
                if ("0".equals(str) || interfaceC0466a == null) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, String.format("发票管理流程结束（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg()));
                    }
                } else if (invoiceBuildResult.getResultCode() != 0) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, String.format("获取发票错误（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg()));
                    }
                    interfaceC0466a.aGt();
                } else {
                    interfaceC0466a.cA(invoiceBuildResult.map.get(InvoiceBuildResult.KEY_INVOICE_ID), str);
                }
            }
        });
    }

    public void b(String str, ArrayList<String> arrayList, final b.a aVar) {
        if (this.fsE == null) {
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
                a.this.fsE.openBduss = openBdussResult.openBduss;
                a.this.fsE.fsK = openBdussResult.unionid;
                a.this.fsE.fsL = openBdussResult.tplStokenMap;
                h.aDf().putString("bd_box_open_bduss", a.this.fsE.openBduss);
                h.aDf().putString("bd_box_union_id", a.this.fsE.fsK);
                h.aDf().putString("bd_box_stoken", ai.mapToString(a.this.fsE.fsL));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("openbduss", a.this.fsE.openBduss);
                    jSONObject.put(SocialOperation.GAME_UNION_ID, a.this.fsE.fsK);
                    JSONObject jSONObject2 = new JSONObject();
                    for (String str2 : a.this.fsE.fsL.keySet()) {
                        jSONObject2.put(str2, a.this.fsE.fsL.get(str2));
                    }
                    jSONObject.put("stokenmap", jSONObject2);
                    jSONObject.put("uid", a.this.fsE.uid);
                    jSONObject.put("bduss", a.this.fsE.bduss);
                    jSONObject.put(SapiAccountManager.SESSION_DISPLAYNAME, a.this.fsE.displayName);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                aVar.sW(jSONObject.toString());
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
