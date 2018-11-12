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
    private String bBY;
    private List<com.baidu.tieba.aiapps.apps.address.c.b> bCc = new ArrayList();
    private Bundle bCe;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c {
        private static final a bCF = new a();
    }

    public static a WJ() {
        return c.bCF;
    }

    public void l(Bundle bundle) {
        this.bCe = bundle;
        if (this.bCe != null) {
            String string = this.bCe.getString("openSource");
            if (!TextUtils.isEmpty(string)) {
                this.bBY = string;
            }
        }
    }

    public void a(com.baidu.tieba.aiapps.apps.address.b.b bVar) {
        new b(bVar, "list");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (TextUtils.equals(this.bBY, "aiapp")) {
            linkedHashMap.put("ma_id", this.bCe.getString(AiAppsLifecycleMessage.APP_ID_KEY));
            linkedHashMap.put(AiAppsApsUtils.APP_KEY, this.bCe.getString(WBConstants.SSO_APP_KEY));
            linkedHashMap.put("host_pkgname", this.bCe.getString("pkgName"));
            linkedHashMap.put("host_key_hash", this.bCe.getString("keyHash"));
            linkedHashMap.put("host_api_key", AiAppsRuntime.getAiAppAccountRuntime().getHostApiKey());
            linkedHashMap.put(ISapiAccount.SAPI_ACCOUNT_STOKEN, this.bCe.getString(ISapiAccount.SAPI_ACCOUNT_STOKEN));
        }
        a(null, bVar, linkedHashMap, "list");
    }

    public List<com.baidu.tieba.aiapps.apps.address.c.b> WK() {
        String readCacheData = h.readCacheData(AppRuntime.getAppContext(), "delivery_data.json");
        if (!TextUtils.isEmpty(readCacheData)) {
            try {
                this.bCc = com.baidu.tieba.aiapps.apps.address.c.c.o(new JSONArray(readCacheData));
            } catch (JSONException e) {
            }
        }
        return this.bCc;
    }

    public void WL() {
        AiAppExecutorUtils.postOnIO(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                h.cache(AppRuntime.getAppContext(), "delivery_data.json", com.baidu.tieba.aiapps.apps.address.c.c.am(a.this.bCc).toString(), 0);
            }
        }, "saveCacheToLocal");
    }

    public List<com.baidu.tieba.aiapps.apps.address.c.b> WM() {
        if (this.bCc == null) {
            this.bCc = new ArrayList();
        }
        return this.bCc;
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
            String jZ = jZ(str);
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(jZ)).addParam("data", jSONObject.toString()).cookieManager(AiAppsRuntime.getConfigRuntime().getCookieManager(true, false))).build().executeAsyncOnUIBack(bVar3);
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
            if (!TextUtils.isEmpty(bVar.bCL)) {
                hashMap.put(ISapiAccount.SAPI_ACCOUNT_PHONE, bVar.bCL);
            }
            if (bVar.bCN != null && !TextUtils.isEmpty(bVar.bCN.code)) {
                hashMap.put("l1", bVar.bCN.code);
            }
            if (bVar.bCO != null && !TextUtils.isEmpty(bVar.bCO.code)) {
                hashMap.put("l2", bVar.bCO.code);
            }
            if (bVar.bCP != null && !TextUtils.isEmpty(bVar.bCP.code)) {
                hashMap.put("l3", bVar.bCP.code);
            }
            if (!TextUtils.isEmpty(bVar.bCQ)) {
                hashMap.put("street", bVar.bCQ);
            }
            if (!TextUtils.isEmpty(bVar.bCR)) {
                hashMap.put("zipcode", bVar.bCR);
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b extends StringResponseCallback {
        private com.baidu.tieba.aiapps.apps.address.b.b bCE;
        private String mType;

        public b(com.baidu.tieba.aiapps.apps.address.b.b bVar, String str) {
            this.bCE = bVar;
            this.mType = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: v */
        public void onSuccess(String str, int i) {
            if (this.bCE != null) {
                this.bCE.WG();
                if (!TextUtils.isEmpty(str) && i == 200) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                            this.bCE.jX(jSONObject.optString("tipmsg"));
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
                                List<com.baidu.tieba.aiapps.apps.address.c.b> kd = com.baidu.tieba.aiapps.apps.address.c.c.kd(str);
                                a.this.bCc = kd;
                                this.bCE.h(kd, i);
                                a.this.WL();
                                return;
                            case 1:
                                this.bCE.O(str, i);
                                return;
                            case 2:
                                this.bCE.P(str, i);
                                return;
                            case 3:
                                this.bCE.P(str, i);
                                return;
                            case 4:
                                this.bCE.Q(str, i);
                                return;
                            default:
                                return;
                        }
                    } catch (JSONException e) {
                        this.bCE.onFailure();
                        return;
                    }
                }
                this.bCE.onFailure();
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (this.bCE != null) {
                this.bCE.WG();
                this.bCE.onFailure();
            }
        }
    }

    private String jZ(String str) {
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
                if (TextUtils.equals(this.bBY, "aiapp")) {
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
            return com.baidu.tieba.aiapps.apps.d.c.ke(com.baidu.tieba.aiapps.apps.d.c.Xi() + str2);
        }
        return str2;
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.address.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0185a implements com.baidu.tieba.aiapps.apps.address.b.b {
        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void WG() {
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
        public void jX(String str) {
        }
    }
}
