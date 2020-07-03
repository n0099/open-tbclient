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
import com.baidu.swan.apps.aq.ah;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.bdprivate.api.b;
import com.baidu.swan.bdprivate.b.a;
import com.baidu.swan.bdprivate.e.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.tencent.open.SocialOperation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class a {
    private b fcB;
    private List<com.baidu.swan.apps.a.c> mListeners;
    public static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    private a() {
        this.mListeners = new ArrayList();
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    private static class C0520a {
        private static final a fcG = new a();
    }

    public static a bqz() {
        return C0520a.fcG;
    }

    public void init(Context context) {
        ep(context);
        eo(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eo(Context context) {
        if (this.fcB == null) {
            this.fcB = new b();
            this.fcB.aRD = h.asV().getString("bd_box_avatar_url", "");
            this.fcB.bduss = h.asV().getString("bd_box_bduss", "");
            this.fcB.fcJ = h.asV().getString("bd_box_ptoken", "");
            this.fcB.uid = h.asV().getString("bd_box_uid", "");
            this.fcB.openBduss = h.asV().getString("bd_box_open_bduss", "");
            this.fcB.fcH = h.asV().getString("bd_box_union_id", "");
            this.fcB.fcI = ah.stringToMap(h.asV().getString("bd_box_stoken", ""));
            this.fcB.displayName = h.asV().getString("bd_box_display_name", "");
        }
    }

    private void ep(final Context context) {
        SapiAccountManager.registerSilentShareListener(new SapiAccountManager.SilentShareListener() { // from class: com.baidu.tieba.aiapps.apps.a.a.1
            @Override // com.baidu.sapi2.SapiAccountManager.SilentShareListener
            public void onSilentShare() {
                context.sendBroadcast(new Intent("com.baidu.intent.action.SILENT_SHARE"));
                SapiAccountManager.unregisterSilentShareListener();
            }
        });
        SapiAccountManager.registerReceiveShareListener(new SapiAccountManager.ReceiveShareListener() { // from class: com.baidu.tieba.aiapps.apps.a.a.3
            @Override // com.baidu.sapi2.SapiAccountManager.ReceiveShareListener
            public void onReceiveShare() {
                a.this.eo(context);
            }
        });
        PassportSDK.setLoginStatusChangeCallback(new LoginStatusChangeCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.4
            @Override // com.baidu.sapi2.callback.LoginStatusChangeCallback
            public void onChange() {
                a.this.jn(SapiAccountManager.getInstance().isLogin());
            }
        });
    }

    public void a(GetUserInfoResult getUserInfoResult) {
        if (getUserInfoResult != null) {
            try {
                h.asV().putString("host_account_info_string", getUserInfoResult.toString());
                if (this.fcB == null) {
                    this.fcB = new b();
                }
                this.fcB.bduss = SapiAccountManager.getInstance().getSession().bduss;
                this.fcB.fcJ = SapiAccountManager.getInstance().getSession().getPtoken();
                this.fcB.displayName = getUserInfoResult.displayname;
                this.fcB.uid = getUserInfoResult.uid;
                this.fcB.aRD = getUserInfoResult.portraitHttps;
                h.asV().putString("bd_box_display_name", this.fcB.displayName);
                h.asV().putString("bd_box_uid", this.fcB.uid);
                h.asV().putString("bd_box_avatar_url", this.fcB.aRD);
                h.asV().putString("bd_box_bduss", this.fcB.bduss);
                h.asV().putString("bd_box_ptoken", this.fcB.fcJ);
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.5
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                    public void onBdussExpired(GetUserInfoResult getUserInfoResult2) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(GetUserInfoResult getUserInfoResult2) {
                        if (getUserInfoResult2 != null) {
                            a.this.fcB.aRD = getUserInfoResult2.portraitHttps;
                        }
                        a.this.jn(true);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFailure(GetUserInfoResult getUserInfoResult2) {
                        a.this.jn(false);
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                    }
                }, this.fcB.bduss);
                return;
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        }
        c(null);
    }

    public void a(Context context, Bundle bundle, final com.baidu.swan.apps.a.a aVar) {
        int i;
        if (this.fcB == null) {
            this.fcB = new b();
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
        MessageManager.getInstance().registerListener(new CustomMessageListener(2921362) { // from class: com.baidu.tieba.aiapps.apps.a.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Integer) {
                    if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                        SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.6.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.sapi2.callback.LoginStatusAware
                            public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                                aVar.onResult(-1);
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.sapi2.callback.SapiCallback
                            public void onSuccess(GetUserInfoResult getUserInfoResult) {
                                a.this.fcB.bduss = SapiAccountManager.getInstance().getSession().bduss;
                                a.this.fcB.fcJ = SapiAccountManager.getInstance().getSession().getPtoken();
                                a.this.fcB.displayName = getUserInfoResult.displayname;
                                a.this.fcB.uid = getUserInfoResult.uid;
                                a.this.fcB.aRD = getUserInfoResult.portraitHttps;
                                h.asV().putString("bd_box_display_name", a.this.fcB.displayName);
                                h.asV().putString("bd_box_uid", a.this.fcB.uid);
                                h.asV().putString("bd_box_avatar_url", a.this.fcB.aRD);
                                h.asV().putString("bd_box_bduss", a.this.fcB.bduss);
                                h.asV().putString("bd_box_ptoken", a.this.fcB.fcJ);
                                aVar.onResult(0);
                                a.this.jn(true);
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

    public void bqA() {
        try {
            SapiAccountManager.getInstance().getConfignation();
        } catch (Exception e) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SAPI_INIT, TbadkCoreApplication.getInst().getApp()));
        }
        try {
            SapiAccountManager.getInstance().isLogin();
            if (SapiAccountManager.getInstance().isLogin()) {
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.7
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                    public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(GetUserInfoResult getUserInfoResult) {
                        a.this.fcB.bduss = SapiAccountManager.getInstance().getSession().bduss;
                        a.this.fcB.fcJ = SapiAccountManager.getInstance().getSession().getPtoken();
                        a.this.fcB.displayName = getUserInfoResult.displayname;
                        a.this.fcB.uid = getUserInfoResult.uid;
                        a.this.fcB.aRD = getUserInfoResult.portraitHttps;
                        h.asV().putString("bd_box_display_name", a.this.fcB.displayName);
                        h.asV().putString("bd_box_uid", a.this.fcB.uid);
                        h.asV().putString("bd_box_avatar_url", a.this.fcB.aRD);
                        h.asV().putString("bd_box_bduss", a.this.fcB.bduss);
                        h.asV().putString("bd_box_ptoken", a.this.fcB.fcJ);
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
        if (this.fcB == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.fcB.bduss)) {
            bqA();
        }
        return this.fcB.bduss;
    }

    public String getUid() {
        if (this.fcB == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.fcB.uid)) {
            bqA();
        }
        return this.fcB.uid;
    }

    public String bqB() {
        if (this.fcB == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.fcB.aRD)) {
            bqA();
        }
        return this.fcB.aRD;
    }

    public String getDisplayName() {
        if (this.fcB == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.fcB.displayName)) {
            bqA();
        }
        return this.fcB.displayName;
    }

    public boolean isLogin() {
        if (this.fcB != null && TextUtils.isEmpty(this.fcB.bduss)) {
            bqA();
        }
        return SapiAccountManager.getInstance().isLogin();
    }

    public void c(com.baidu.swan.apps.a.a aVar) {
        SapiAccountManager.getInstance().logout();
        jn(false);
        this.fcB = new b();
        h.asV().putString("bd_box_display_name", "");
        h.asV().putString("bd_box_uid", "");
        h.asV().putString("bd_box_avatar_url", "");
        h.asV().putString("bd_box_bduss", "");
        h.asV().putString("bd_box_ptoken", "");
        if (aVar != null) {
            aVar.onResult(0);
        }
    }

    public void a(com.baidu.swan.apps.a.c cVar) {
        this.mListeners.add(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jn(boolean z) {
        for (com.baidu.swan.apps.a.c cVar : this.mListeners) {
            cVar.dg(z);
        }
    }

    public void a(Context context, final String str, final a.InterfaceC0414a interfaceC0414a) {
        AddressManageDTO addressManageDTO = new AddressManageDTO();
        addressManageDTO.type = str;
        addressManageDTO.sweepLightLoading = true;
        PassportSDK.getInstance().loadAddressManage(context, addressManageDTO, new AddressManageCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.8
            @Override // com.baidu.sapi2.callback.AddressManageCallback
            public void onFinish(AddressManageResult addressManageResult) {
                if ("0".equals(str) || interfaceC0414a == null) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, String.format("管理收货地址流程结束（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg()));
                    }
                } else if (addressManageResult.getResultCode() != 0) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, String.format("选择收货地址错误（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg()));
                    }
                    interfaceC0414a.avS();
                } else {
                    interfaceC0414a.ho(addressManageResult.map.get("addrId"));
                }
            }
        });
    }

    public void a(Context context, final String str, final a.InterfaceC0418a interfaceC0418a) {
        InvoiceBuildDTO invoiceBuildDTO = new InvoiceBuildDTO();
        invoiceBuildDTO.TYPE = str;
        PassportSDK.getInstance().loadInvoiceBuild(context, invoiceBuildDTO, new InvoiceBuildCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.9
            @Override // com.baidu.sapi2.callback.InvoiceBuildCallback
            public void onFinish(InvoiceBuildResult invoiceBuildResult) {
                if ("0".equals(str) || interfaceC0418a == null) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, String.format("发票管理流程结束（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg()));
                    }
                } else if (invoiceBuildResult.getResultCode() != 0) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, String.format("获取发票错误（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg()));
                    }
                    interfaceC0418a.avS();
                } else {
                    interfaceC0418a.cg(invoiceBuildResult.map.get(InvoiceBuildResult.KEY_INVOICE_ID), str);
                }
            }
        });
    }

    public void b(String str, ArrayList<String> arrayList, final b.a aVar) {
        if (this.fcB == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return;
        }
        GetOpenBdussDTO getOpenBdussDTO = new GetOpenBdussDTO();
        getOpenBdussDTO.clientId = str;
        getOpenBdussDTO.targetTplList.addAll(arrayList);
        SapiAccountManager.getInstance().getAccountService().getOpenBduss(getOpenBdussDTO, new GetOpenBdussCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            /* renamed from: c */
            public void onSuccess(OpenBdussResult openBdussResult) {
                a.this.fcB.openBduss = openBdussResult.openBduss;
                a.this.fcB.fcH = openBdussResult.unionid;
                a.this.fcB.fcI = openBdussResult.tplStokenMap;
                h.asV().putString("bd_box_open_bduss", a.this.fcB.openBduss);
                h.asV().putString("bd_box_union_id", a.this.fcB.fcH);
                h.asV().putString("bd_box_stoken", ah.mapToString(a.this.fcB.fcI));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("openbduss", a.this.fcB.openBduss);
                    jSONObject.put(SocialOperation.GAME_UNION_ID, a.this.fcB.fcH);
                    JSONObject jSONObject2 = new JSONObject();
                    for (String str2 : a.this.fcB.fcI.keySet()) {
                        jSONObject2.put(str2, a.this.fcB.fcI.get(str2));
                    }
                    jSONObject.put("stokenmap", jSONObject2);
                    jSONObject.put("uid", a.this.fcB.uid);
                    jSONObject.put("bduss", a.this.fcB.bduss);
                    jSONObject.put(SapiAccountManager.SESSION_DISPLAYNAME, a.this.fcB.displayName);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                aVar.qf(jSONObject.toString());
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
