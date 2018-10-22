package com.baidu.tieba.aiapps.apps.address.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.b.a.h.h;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.ng.ai.apps.aps.AiAppsApsUtils;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsLifecycleMessage;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private String bBm;
    private List<com.baidu.tieba.aiapps.apps.address.c.b> bBq = new ArrayList();
    private Bundle bBs;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c {
        private static final a bBT = new a();
    }

    public static a Wz() {
        return c.bBT;
    }

    public void i(Bundle bundle) {
        this.bBs = bundle;
        if (this.bBs != null) {
            String string = this.bBs.getString("openSource");
            if (!TextUtils.isEmpty(string)) {
                this.bBm = string;
            }
        }
    }

    public void a(com.baidu.tieba.aiapps.apps.address.b.b bVar) {
        new b(bVar, "list");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (TextUtils.equals(this.bBm, "aiapp")) {
            linkedHashMap.put("ma_id", this.bBs.getString(AiAppsLifecycleMessage.APP_ID_KEY));
            linkedHashMap.put(AiAppsApsUtils.APP_KEY, this.bBs.getString(WBConstants.SSO_APP_KEY));
            linkedHashMap.put("host_pkgname", this.bBs.getString("pkgName"));
            linkedHashMap.put("host_key_hash", this.bBs.getString("keyHash"));
            linkedHashMap.put("host_api_key", AiAppsRuntime.getAiAppAccountRuntime().getHostApiKey());
            linkedHashMap.put(ISapiAccount.SAPI_ACCOUNT_STOKEN, this.bBs.getString(ISapiAccount.SAPI_ACCOUNT_STOKEN));
        }
        a(null, bVar, linkedHashMap, "list");
    }

    public List<com.baidu.tieba.aiapps.apps.address.c.b> WA() {
        String readCacheData = h.readCacheData(AppRuntime.getAppContext(), "delivery_data.json");
        if (!TextUtils.isEmpty(readCacheData)) {
            try {
                this.bBq = com.baidu.tieba.aiapps.apps.address.c.c.m(new JSONArray(readCacheData));
            } catch (JSONException e) {
            }
        }
        return this.bBq;
    }

    public void WB() {
        AiAppExecutorUtils.postOnIO(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                h.cache(AppRuntime.getAppContext(), "delivery_data.json", com.baidu.tieba.aiapps.apps.address.c.c.an(a.this.bBq).toString(), 0);
            }
        }, "saveCacheToLocal");
    }

    public List<com.baidu.tieba.aiapps.apps.address.c.b> WC() {
        if (this.bBq == null) {
            this.bBq = new ArrayList();
        }
        return this.bBq;
    }

    public void a(com.baidu.tieba.aiapps.apps.address.c.b bVar, com.baidu.tieba.aiapps.apps.address.b.b bVar2) {
        if (bVar != null && bVar.isValid()) {
            a(bVar, bVar2, a(bVar), "add");
        }
    }

    public void b(com.baidu.tieba.aiapps.apps.address.c.b bVar, com.baidu.tieba.aiapps.apps.address.b.b bVar2) {
        if (bVar != null && !TextUtils.isEmpty(bVar.id)) {
            a(bVar, bVar2, a(bVar), WriteImageActivityConfig.DELET_FLAG);
        }
    }

    public void c(com.baidu.tieba.aiapps.apps.address.c.b bVar, com.baidu.tieba.aiapps.apps.address.b.b bVar2) {
        if (bVar != null && !TextUtils.isEmpty(bVar.id)) {
            a(bVar, bVar2, a(bVar), "update");
        }
    }

    public void d(com.baidu.tieba.aiapps.apps.address.c.b bVar, com.baidu.tieba.aiapps.apps.address.b.b bVar2) {
        if (bVar != null && !TextUtils.isEmpty(bVar.id)) {
            a(bVar, bVar2, a(bVar), "updateDefault");
        }
    }

    public void a(com.baidu.tieba.aiapps.apps.address.c.b bVar, com.baidu.tieba.aiapps.apps.address.b.b bVar2, Map<String, String> map, String str) {
        if (bVar != null || TextUtils.equals(str, "list")) {
            b bVar3 = new b(bVar2, str);
            JSONObject jSONObject = new JSONObject();
            if (jSONObject != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    try {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    } catch (JSONException e) {
                    }
                }
            }
            String jX = jX(str);
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(jX)).addParam("data", jSONObject.toString()).cookieManager(AiAppsRuntime.getConfigRuntime().getCookieManager(true, false))).build().executeAsyncOnUIBack(bVar3);
        }
    }

    private Map<String, String> a(com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        HashMap hashMap = new HashMap();
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.id)) {
                hashMap.put("id", bVar.id);
            }
            if (!TextUtils.isEmpty(bVar.userName)) {
                hashMap.put("name", bVar.userName);
            }
            if (!TextUtils.isEmpty(bVar.bBZ)) {
                hashMap.put(ISapiAccount.SAPI_ACCOUNT_PHONE, bVar.bBZ);
            }
            if (bVar.bCb != null && !TextUtils.isEmpty(bVar.bCb.code)) {
                hashMap.put("l1", bVar.bCb.code);
            }
            if (bVar.bCc != null && !TextUtils.isEmpty(bVar.bCc.code)) {
                hashMap.put("l2", bVar.bCc.code);
            }
            if (bVar.bCd != null && !TextUtils.isEmpty(bVar.bCd.code)) {
                hashMap.put("l3", bVar.bCd.code);
            }
            if (!TextUtils.isEmpty(bVar.bCe)) {
                hashMap.put("street", bVar.bCe);
            }
            if (!TextUtils.isEmpty(bVar.bCf)) {
                hashMap.put("zipcode", bVar.bCf);
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b extends StringResponseCallback {
        private com.baidu.tieba.aiapps.apps.address.b.b bBS;
        private String mType;

        public b(com.baidu.tieba.aiapps.apps.address.b.b bVar, String str) {
            this.bBS = bVar;
            this.mType = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: v */
        public void onSuccess(String str, int i) {
            if (this.bBS != null) {
                this.bBS.Ww();
                if (!TextUtils.isEmpty(str) && i == 200) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                            this.bBS.jV(jSONObject.optString("tipmsg"));
                            return;
                        }
                        String str2 = this.mType;
                        char c = 65535;
                        switch (str2.hashCode()) {
                            case -1335458389:
                                if (str2.equals(WriteImageActivityConfig.DELET_FLAG)) {
                                    c = 4;
                                    break;
                                }
                                break;
                            case -838846263:
                                if (str2.equals("update")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case 96417:
                                if (str2.equals("add")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 3322014:
                                if (str2.equals("list")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 48853304:
                                if (str2.equals("updateDefault")) {
                                    c = 3;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                                List<com.baidu.tieba.aiapps.apps.address.c.b> kb = com.baidu.tieba.aiapps.apps.address.c.c.kb(str);
                                a.this.bBq = kb;
                                this.bBS.h(kb, i);
                                a.this.WB();
                                return;
                            case 1:
                                this.bBS.O(str, i);
                                return;
                            case 2:
                                this.bBS.P(str, i);
                                return;
                            case 3:
                                this.bBS.P(str, i);
                                return;
                            case 4:
                                this.bBS.Q(str, i);
                                return;
                            default:
                                return;
                        }
                    } catch (JSONException e) {
                        this.bBS.onFailure();
                        return;
                    }
                }
                this.bBS.onFailure();
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (this.bBS != null) {
                this.bBS.Ww();
                this.bBS.onFailure();
            }
        }
    }

    private String jX(String str) {
        String str2 = "";
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1335458389:
                if (str.equals(WriteImageActivityConfig.DELET_FLAG)) {
                    c2 = 4;
                    break;
                }
                break;
            case -838846263:
                if (str.equals("update")) {
                    c2 = 2;
                    break;
                }
                break;
            case 96417:
                if (str.equals("add")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3322014:
                if (str.equals("list")) {
                    c2 = 0;
                    break;
                }
                break;
            case 48853304:
                if (str.equals("updateDefault")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                if (TextUtils.equals(this.bBm, "aiapp")) {
                    str2 = "/oa_list";
                    break;
                } else {
                    str2 = "/list";
                    break;
                }
            case 1:
                str2 = "/create";
                break;
            case 2:
                str2 = "/modify";
                break;
            case 3:
                str2 = "/modify_default";
                break;
            case 4:
                str2 = "/del";
                break;
        }
        if (!TextUtils.isEmpty(str2)) {
            return com.baidu.tieba.aiapps.apps.d.c.kc(com.baidu.tieba.aiapps.apps.d.c.WY() + str2);
        }
        return str2;
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.address.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0160a implements com.baidu.tieba.aiapps.apps.address.b.b {
        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void Ww() {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void P(String str, int i) {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void Q(String str, int i) {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void O(String str, int i) {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void h(List<com.baidu.tieba.aiapps.apps.address.c.b> list, int i) {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void onFailure() {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void jV(String str) {
        }
    }
}
