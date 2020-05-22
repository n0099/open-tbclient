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
    private b eSf;
    private List<com.baidu.swan.apps.a.c> mListeners;
    public static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    private a() {
        this.mListeners = new ArrayList();
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    private static class C0512a {
        private static final a eSk = new a();
    }

    public static a bnX() {
        return C0512a.eSk;
    }

    public void init(Context context) {
        eo(context);
        en(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void en(Context context) {
        if (this.eSf == null) {
            this.eSf = new b();
            this.eSf.aOX = h.arO().getString("bd_box_avatar_url", "");
            this.eSf.bduss = h.arO().getString("bd_box_bduss", "");
            this.eSf.eSn = h.arO().getString("bd_box_ptoken", "");
            this.eSf.uid = h.arO().getString("bd_box_uid", "");
            this.eSf.openBduss = h.arO().getString("bd_box_open_bduss", "");
            this.eSf.eSl = h.arO().getString("bd_box_union_id", "");
            this.eSf.eSm = ah.stringToMap(h.arO().getString("bd_box_stoken", ""));
            this.eSf.displayName = h.arO().getString("bd_box_display_name", "");
        }
    }

    private void eo(final Context context) {
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
                a.this.en(context);
            }
        });
        PassportSDK.setLoginStatusChangeCallback(new LoginStatusChangeCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.4
            @Override // com.baidu.sapi2.callback.LoginStatusChangeCallback
            public void onChange() {
                a.this.jb(SapiAccountManager.getInstance().isLogin());
            }
        });
    }

    public void a(GetUserInfoResult getUserInfoResult) {
        if (getUserInfoResult != null) {
            try {
                h.arO().putString("host_account_info_string", getUserInfoResult.toString());
                if (this.eSf == null) {
                    this.eSf = new b();
                }
                this.eSf.bduss = SapiAccountManager.getInstance().getSession().bduss;
                this.eSf.eSn = SapiAccountManager.getInstance().getSession().getPtoken();
                this.eSf.displayName = getUserInfoResult.displayname;
                this.eSf.uid = getUserInfoResult.uid;
                this.eSf.aOX = getUserInfoResult.portraitHttps;
                h.arO().putString("bd_box_display_name", this.eSf.displayName);
                h.arO().putString("bd_box_uid", this.eSf.uid);
                h.arO().putString("bd_box_avatar_url", this.eSf.aOX);
                h.arO().putString("bd_box_bduss", this.eSf.bduss);
                h.arO().putString("bd_box_ptoken", this.eSf.eSn);
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.5
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                    public void onBdussExpired(GetUserInfoResult getUserInfoResult2) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(GetUserInfoResult getUserInfoResult2) {
                        if (getUserInfoResult2 != null) {
                            a.this.eSf.aOX = getUserInfoResult2.portraitHttps;
                        }
                        a.this.jb(true);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFailure(GetUserInfoResult getUserInfoResult2) {
                        a.this.jb(false);
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                    }
                }, this.eSf.bduss);
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
        if (this.eSf == null) {
            this.eSf = new b();
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
                                a.this.eSf.bduss = SapiAccountManager.getInstance().getSession().bduss;
                                a.this.eSf.eSn = SapiAccountManager.getInstance().getSession().getPtoken();
                                a.this.eSf.displayName = getUserInfoResult.displayname;
                                a.this.eSf.uid = getUserInfoResult.uid;
                                a.this.eSf.aOX = getUserInfoResult.portraitHttps;
                                h.arO().putString("bd_box_display_name", a.this.eSf.displayName);
                                h.arO().putString("bd_box_uid", a.this.eSf.uid);
                                h.arO().putString("bd_box_avatar_url", a.this.eSf.aOX);
                                h.arO().putString("bd_box_bduss", a.this.eSf.bduss);
                                h.arO().putString("bd_box_ptoken", a.this.eSf.eSn);
                                aVar.onResult(0);
                                a.this.jb(true);
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

    public void bnY() {
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
                        a.this.eSf.bduss = SapiAccountManager.getInstance().getSession().bduss;
                        a.this.eSf.eSn = SapiAccountManager.getInstance().getSession().getPtoken();
                        a.this.eSf.displayName = getUserInfoResult.displayname;
                        a.this.eSf.uid = getUserInfoResult.uid;
                        a.this.eSf.aOX = getUserInfoResult.portraitHttps;
                        h.arO().putString("bd_box_display_name", a.this.eSf.displayName);
                        h.arO().putString("bd_box_uid", a.this.eSf.uid);
                        h.arO().putString("bd_box_avatar_url", a.this.eSf.aOX);
                        h.arO().putString("bd_box_bduss", a.this.eSf.bduss);
                        h.arO().putString("bd_box_ptoken", a.this.eSf.eSn);
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
        if (this.eSf == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.eSf.bduss)) {
            bnY();
        }
        return this.eSf.bduss;
    }

    public String getUid() {
        if (this.eSf == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.eSf.uid)) {
            bnY();
        }
        return this.eSf.uid;
    }

    public String bnZ() {
        if (this.eSf == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.eSf.aOX)) {
            bnY();
        }
        return this.eSf.aOX;
    }

    public String getDisplayName() {
        if (this.eSf == null) {
            if (DEBUG) {
                throw new NullPointerException("AccountInfo is null");
            }
            return "";
        }
        if (TextUtils.isEmpty(this.eSf.displayName)) {
            bnY();
        }
        return this.eSf.displayName;
    }

    public boolean isLogin() {
        if (this.eSf != null && TextUtils.isEmpty(this.eSf.bduss)) {
            bnY();
        }
        return SapiAccountManager.getInstance().isLogin();
    }

    public void c(com.baidu.swan.apps.a.a aVar) {
        SapiAccountManager.getInstance().logout();
        jb(false);
        this.eSf = new b();
        h.arO().putString("bd_box_display_name", "");
        h.arO().putString("bd_box_uid", "");
        h.arO().putString("bd_box_avatar_url", "");
        h.arO().putString("bd_box_bduss", "");
        h.arO().putString("bd_box_ptoken", "");
        if (aVar != null) {
            aVar.onResult(0);
        }
    }

    public void a(com.baidu.swan.apps.a.c cVar) {
        this.mListeners.add(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jb(boolean z) {
        for (com.baidu.swan.apps.a.c cVar : this.mListeners) {
            cVar.db(z);
        }
    }

    public void a(Context context, final String str, final a.InterfaceC0408a interfaceC0408a) {
        AddressManageDTO addressManageDTO = new AddressManageDTO();
        addressManageDTO.type = str;
        addressManageDTO.sweepLightLoading = true;
        PassportSDK.getInstance().loadAddressManage(context, addressManageDTO, new AddressManageCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.8
            @Override // com.baidu.sapi2.callback.AddressManageCallback
            public void onFinish(AddressManageResult addressManageResult) {
                if ("0".equals(str) || interfaceC0408a == null) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, String.format("管理收货地址流程结束（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg()));
                    }
                } else if (addressManageResult.getResultCode() != 0) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, String.format("选择收货地址错误（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg()));
                    }
                    interfaceC0408a.auM();
                } else {
                    interfaceC0408a.hg(addressManageResult.map.get("addrId"));
                }
            }
        });
    }

    public void a(Context context, final String str, final a.InterfaceC0412a interfaceC0412a) {
        InvoiceBuildDTO invoiceBuildDTO = new InvoiceBuildDTO();
        invoiceBuildDTO.TYPE = str;
        PassportSDK.getInstance().loadInvoiceBuild(context, invoiceBuildDTO, new InvoiceBuildCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.9
            @Override // com.baidu.sapi2.callback.InvoiceBuildCallback
            public void onFinish(InvoiceBuildResult invoiceBuildResult) {
                if ("0".equals(str) || interfaceC0412a == null) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, String.format("发票管理流程结束（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg()));
                    }
                } else if (invoiceBuildResult.getResultCode() != 0) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, String.format("获取发票错误（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg()));
                    }
                    interfaceC0412a.auM();
                } else {
                    interfaceC0412a.ce(invoiceBuildResult.map.get(InvoiceBuildResult.KEY_INVOICE_ID), str);
                }
            }
        });
    }

    public void b(String str, ArrayList<String> arrayList, final b.a aVar) {
        if (this.eSf == null) {
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
                a.this.eSf.openBduss = openBdussResult.openBduss;
                a.this.eSf.eSl = openBdussResult.unionid;
                a.this.eSf.eSm = openBdussResult.tplStokenMap;
                h.arO().putString("bd_box_open_bduss", a.this.eSf.openBduss);
                h.arO().putString("bd_box_union_id", a.this.eSf.eSl);
                h.arO().putString("bd_box_stoken", ah.mapToString(a.this.eSf.eSm));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("openbduss", a.this.eSf.openBduss);
                    jSONObject.put(SocialOperation.GAME_UNION_ID, a.this.eSf.eSl);
                    JSONObject jSONObject2 = new JSONObject();
                    for (String str2 : a.this.eSf.eSm.keySet()) {
                        jSONObject2.put(str2, a.this.eSf.eSm.get(str2));
                    }
                    jSONObject.put("stokenmap", jSONObject2);
                    jSONObject.put("uid", a.this.eSf.uid);
                    jSONObject.put("bduss", a.this.eSf.bduss);
                    jSONObject.put(SapiAccountManager.SESSION_DISPLAYNAME, a.this.eSf.displayName);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                aVar.pX(jSONObject.toString());
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
