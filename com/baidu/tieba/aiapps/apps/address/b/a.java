package com.baidu.tieba.aiapps.apps.address.b;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.swan.apps.an.j;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.aiapps.apps.c.d;
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
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private String cRC;
    private List<com.baidu.tieba.aiapps.apps.address.c.b> cRG = new ArrayList();
    private Bundle cRI;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c {
        private static final a cSm = new a();
    }

    public static a ayq() {
        return c.cSm;
    }

    public void G(Bundle bundle) {
        this.cRI = bundle;
        if (this.cRI != null) {
            String string = this.cRI.getString("openSource");
            if (!TextUtils.isEmpty(string)) {
                this.cRC = string;
            }
        }
    }

    public void a(com.baidu.tieba.aiapps.apps.address.b.b bVar) {
        new b(bVar, IntentConfig.LIST);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (TextUtils.equals(this.cRC, "aiapp")) {
            linkedHashMap.put("ma_id", this.cRI.getString("appId"));
            linkedHashMap.put("app_key", this.cRI.getString(WBConstants.SSO_APP_KEY));
            linkedHashMap.put("host_pkgname", this.cRI.getString("pkgName"));
            linkedHashMap.put("host_key_hash", this.cRI.getString("keyHash"));
            linkedHashMap.put("host_api_key", com.baidu.tieba.aiapps.apps.c.a.vD());
            linkedHashMap.put(ISapiAccount.SAPI_ACCOUNT_STOKEN, this.cRI.getString(ISapiAccount.SAPI_ACCOUNT_STOKEN));
        }
        a(null, bVar, linkedHashMap, IntentConfig.LIST);
    }

    public List<com.baidu.tieba.aiapps.apps.address.c.b> ayr() {
        String ap = com.baidu.swan.c.b.ap(AppRuntime.getAppContext(), "delivery_data.json");
        if (!TextUtils.isEmpty(ap)) {
            try {
                this.cRG = com.baidu.tieba.aiapps.apps.address.c.c.D(new JSONArray(ap));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this.cRG;
    }

    public void ays() {
        j.a(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.c.b.b(AppRuntime.getAppContext(), "delivery_data.json", com.baidu.tieba.aiapps.apps.address.c.c.aA(a.this.cRG).toString(), 0);
            }
        }, "saveCacheToLocal");
    }

    public List<com.baidu.tieba.aiapps.apps.address.c.b> ayt() {
        if (this.cRG == null) {
            this.cRG = new ArrayList();
        }
        return this.cRG;
    }

    public void a(com.baidu.tieba.aiapps.apps.address.c.b bVar, com.baidu.tieba.aiapps.apps.address.b.b bVar2) {
        if (bVar == null || !bVar.isValid()) {
            if (DEBUG) {
                Log.d("DeliveryDataManager", "requestAddDelivery: deliveryAddr is invalid");
                return;
            }
            return;
        }
        a(bVar, bVar2, a(bVar), "add");
    }

    public void b(com.baidu.tieba.aiapps.apps.address.c.b bVar, com.baidu.tieba.aiapps.apps.address.b.b bVar2) {
        if (bVar == null || TextUtils.isEmpty(bVar.id)) {
            if (DEBUG) {
                Log.d("DeliveryDataManager", "requestDeleteDelivery: deliveryAddr-id is empty");
                return;
            }
            return;
        }
        a(bVar, bVar2, a(bVar), WriteImageActivityConfig.DELET_FLAG);
    }

    public void c(com.baidu.tieba.aiapps.apps.address.c.b bVar, com.baidu.tieba.aiapps.apps.address.b.b bVar2) {
        if (bVar == null || TextUtils.isEmpty(bVar.id)) {
            if (DEBUG) {
                Log.d("DeliveryDataManager", "requestUpdateDelivery: deliveryAddr is invalid");
                return;
            }
            return;
        }
        a(bVar, bVar2, a(bVar), "update");
    }

    public void d(com.baidu.tieba.aiapps.apps.address.c.b bVar, com.baidu.tieba.aiapps.apps.address.b.b bVar2) {
        if (bVar == null || TextUtils.isEmpty(bVar.id)) {
            if (DEBUG) {
                Log.d("DeliveryDataManager", "requestUpdateDefaultDelivery: deliveryAddr is invalid");
                return;
            }
            return;
        }
        a(bVar, bVar2, a(bVar), "updateDefault");
    }

    public void a(com.baidu.tieba.aiapps.apps.address.c.b bVar, com.baidu.tieba.aiapps.apps.address.b.b bVar2, Map<String, String> map, String str) {
        if (bVar == null && !TextUtils.equals(str, IntentConfig.LIST)) {
            if (DEBUG) {
                Log.d("DeliveryDataManager", "requestPostDelivery: deliveryAddr is null");
                return;
            }
            return;
        }
        b bVar3 = new b(bVar2, str);
        JSONObject jSONObject = new JSONObject();
        if (jSONObject != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
        String rt = rt(str);
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(rt)).addParam("data", jSONObject.toString()).cookieManager(com.baidu.tieba.aiapps.apps.a.a.Dp())).build().executeAsyncOnUIBack(bVar3);
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
            if (!TextUtils.isEmpty(bVar.cSs)) {
                hashMap.put(ISapiAccount.SAPI_ACCOUNT_PHONE, bVar.cSs);
            }
            if (bVar.cSu != null && !TextUtils.isEmpty(bVar.cSu.code)) {
                hashMap.put("l1", bVar.cSu.code);
            }
            if (bVar.cSv != null && !TextUtils.isEmpty(bVar.cSv.code)) {
                hashMap.put("l2", bVar.cSv.code);
            }
            if (bVar.cSw != null && !TextUtils.isEmpty(bVar.cSw.code)) {
                hashMap.put("l3", bVar.cSw.code);
            }
            if (!TextUtils.isEmpty(bVar.cSx)) {
                hashMap.put("street", bVar.cSx);
            }
            if (!TextUtils.isEmpty(bVar.cSy)) {
                hashMap.put("zipcode", bVar.cSy);
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b extends StringResponseCallback {
        private com.baidu.tieba.aiapps.apps.address.b.b cSl;
        private String mType;

        public b(com.baidu.tieba.aiapps.apps.address.b.b bVar, String str) {
            this.cSl = bVar;
            this.mType = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: I */
        public void onSuccess(String str, int i) {
            if (this.cSl != null) {
                this.cSl.aym();
                if (!TextUtils.isEmpty(str) && i == 200) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                            this.cSl.rr(jSONObject.optString("tipmsg"));
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
                                if (str2.equals(IntentConfig.LIST)) {
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
                                List<com.baidu.tieba.aiapps.apps.address.c.b> rx2 = com.baidu.tieba.aiapps.apps.address.c.c.rx(str);
                                a.this.cRG = rx2;
                                this.cSl.g(rx2, i);
                                a.this.ays();
                                return;
                            case 1:
                                this.cSl.am(str, i);
                                return;
                            case 2:
                                this.cSl.an(str, i);
                                return;
                            case 3:
                                this.cSl.an(str, i);
                                return;
                            case 4:
                                this.cSl.ao(str, i);
                                return;
                            default:
                                return;
                        }
                    } catch (JSONException e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                        this.cSl.onFailure();
                        return;
                    }
                }
                this.cSl.onFailure();
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (this.cSl != null) {
                this.cSl.aym();
                this.cSl.onFailure();
            }
        }
    }

    private String rt(String str) {
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
                if (str.equals(IntentConfig.LIST)) {
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
                if (TextUtils.equals(this.cRC, "aiapp")) {
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
            return d.ry(d.ayS() + str2);
        }
        return str2;
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.address.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0226a implements com.baidu.tieba.aiapps.apps.address.b.b {
        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void aym() {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void an(String str, int i) {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void ao(String str, int i) {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void am(String str, int i) {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void g(List<com.baidu.tieba.aiapps.apps.address.c.b> list, int i) {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void onFailure() {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void rr(String str) {
        }
    }
}
