package com.baidu.tieba.aiapps.apps.address.b;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.swan.apps.an.j;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.aiapps.apps.c.d;
import com.vivo.push.PushClientConstants;
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
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String ddp;
    private List<com.baidu.tieba.aiapps.apps.address.c.b> ddt = new ArrayList();
    private Bundle ddw;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c {
        private static final a dea = new a();
    }

    public static a aFt() {
        return c.dea;
    }

    public void H(Bundle bundle) {
        this.ddw = bundle;
        if (this.ddw != null) {
            String string = this.ddw.getString("openSource");
            if (!TextUtils.isEmpty(string)) {
                this.ddp = string;
            }
        }
    }

    public void a(com.baidu.tieba.aiapps.apps.address.b.b bVar) {
        new b(bVar, IntentConfig.LIST);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (TextUtils.equals(this.ddp, "aiapp")) {
            linkedHashMap.put("ma_id", this.ddw.getString("appId"));
            linkedHashMap.put("app_key", this.ddw.getString("appKey"));
            linkedHashMap.put("host_pkgname", this.ddw.getString(PushClientConstants.TAG_PKG_NAME));
            linkedHashMap.put("host_key_hash", this.ddw.getString("keyHash"));
            linkedHashMap.put("stoken", this.ddw.getString("stoken"));
            linkedHashMap.put("host_api_key", com.baidu.swan.apps.u.a.EA().wW());
        }
        a(null, bVar, linkedHashMap, IntentConfig.LIST);
    }

    public List<com.baidu.tieba.aiapps.apps.address.c.b> aFu() {
        String ac = com.baidu.swan.c.a.ac(AppRuntime.getAppContext(), "delivery_data.json");
        if (!TextUtils.isEmpty(ac)) {
            try {
                this.ddt = com.baidu.tieba.aiapps.apps.address.c.c.E(new JSONArray(ac));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this.ddt;
    }

    public void aFv() {
        j.a(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.c.a.c(AppRuntime.getAppContext(), "delivery_data.json", com.baidu.tieba.aiapps.apps.address.c.c.aH(a.this.ddt).toString(), 0);
            }
        }, "saveCacheToLocal");
    }

    public List<com.baidu.tieba.aiapps.apps.address.c.b> aFw() {
        if (this.ddt == null) {
            this.ddt = new ArrayList();
        }
        return this.ddt;
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
        if (map != null) {
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
        String tt = tt(str);
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(tt)).addParam("data", jSONObject.toString()).cookieManager(com.baidu.swan.apps.u.a.EL().Fj())).build().executeAsyncOnUIBack(bVar3);
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
            if (!TextUtils.isEmpty(bVar.deg)) {
                hashMap.put("phone", bVar.deg);
            }
            if (bVar.dei != null && !TextUtils.isEmpty(bVar.dei.code)) {
                hashMap.put("l1", bVar.dei.code);
            }
            if (bVar.dej != null && !TextUtils.isEmpty(bVar.dej.code)) {
                hashMap.put("l2", bVar.dej.code);
            }
            if (bVar.dek != null && !TextUtils.isEmpty(bVar.dek.code)) {
                hashMap.put("l3", bVar.dek.code);
            }
            if (!TextUtils.isEmpty(bVar.del)) {
                hashMap.put("street", bVar.del);
            }
            if (!TextUtils.isEmpty(bVar.dem)) {
                hashMap.put("zipcode", bVar.dem);
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b extends StringResponseCallback {
        private com.baidu.tieba.aiapps.apps.address.b.b ddZ;
        private String mType;

        public b(com.baidu.tieba.aiapps.apps.address.b.b bVar, String str) {
            this.ddZ = bVar;
            this.mType = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: x */
        public void onSuccess(String str, int i) {
            if (this.ddZ != null) {
                this.ddZ.aFp();
                if (!TextUtils.isEmpty(str) && i == 200) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                            this.ddZ.tr(jSONObject.optString("tipmsg"));
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
                                List<com.baidu.tieba.aiapps.apps.address.c.b> tx = com.baidu.tieba.aiapps.apps.address.c.c.tx(str);
                                a.this.ddt = tx;
                                this.ddZ.g(tx, i);
                                a.this.aFv();
                                return;
                            case 1:
                                this.ddZ.ak(str, i);
                                return;
                            case 2:
                                this.ddZ.al(str, i);
                                return;
                            case 3:
                                this.ddZ.al(str, i);
                                return;
                            case 4:
                                this.ddZ.am(str, i);
                                return;
                            default:
                                return;
                        }
                    } catch (JSONException e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                        this.ddZ.onFailure();
                        return;
                    }
                }
                this.ddZ.onFailure();
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (this.ddZ != null) {
                this.ddZ.aFp();
                this.ddZ.onFailure();
            }
        }
    }

    private String tt(String str) {
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
                if (TextUtils.equals(this.ddp, "aiapp")) {
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
            return d.ty(d.aFY() + str2);
        }
        return str2;
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.address.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0292a implements com.baidu.tieba.aiapps.apps.address.b.b {
        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void aFp() {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void al(String str, int i) {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void am(String str, int i) {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void ak(String str, int i) {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void g(List<com.baidu.tieba.aiapps.apps.address.c.b> list, int i) {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void onFailure() {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void tr(String str) {
        }
    }
}
