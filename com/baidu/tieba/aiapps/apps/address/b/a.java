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
    private Bundle dbB;
    private String dbv;
    private List<com.baidu.tieba.aiapps.apps.address.c.b> dbz = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c {
        private static final a dcg = new a();
    }

    public static a aEN() {
        return c.dcg;
    }

    public void H(Bundle bundle) {
        this.dbB = bundle;
        if (this.dbB != null) {
            String string = this.dbB.getString("openSource");
            if (!TextUtils.isEmpty(string)) {
                this.dbv = string;
            }
        }
    }

    public void a(com.baidu.tieba.aiapps.apps.address.b.b bVar) {
        new b(bVar, IntentConfig.LIST);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (TextUtils.equals(this.dbv, "aiapp")) {
            linkedHashMap.put("ma_id", this.dbB.getString("appId"));
            linkedHashMap.put("app_key", this.dbB.getString("appKey"));
            linkedHashMap.put("host_pkgname", this.dbB.getString(PushClientConstants.TAG_PKG_NAME));
            linkedHashMap.put("host_key_hash", this.dbB.getString("keyHash"));
            linkedHashMap.put("stoken", this.dbB.getString("stoken"));
            linkedHashMap.put("host_api_key", com.baidu.swan.apps.u.a.Ew().wS());
        }
        a(null, bVar, linkedHashMap, IntentConfig.LIST);
    }

    public List<com.baidu.tieba.aiapps.apps.address.c.b> aEO() {
        String ac = com.baidu.swan.c.a.ac(AppRuntime.getAppContext(), "delivery_data.json");
        if (!TextUtils.isEmpty(ac)) {
            try {
                this.dbz = com.baidu.tieba.aiapps.apps.address.c.c.E(new JSONArray(ac));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this.dbz;
    }

    public void aEP() {
        j.a(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.c.a.c(AppRuntime.getAppContext(), "delivery_data.json", com.baidu.tieba.aiapps.apps.address.c.c.aH(a.this.dbz).toString(), 0);
            }
        }, "saveCacheToLocal");
    }

    public List<com.baidu.tieba.aiapps.apps.address.c.b> aEQ() {
        if (this.dbz == null) {
            this.dbz = new ArrayList();
        }
        return this.dbz;
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
        String sU = sU(str);
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(sU)).addParam("data", jSONObject.toString()).cookieManager(com.baidu.swan.apps.u.a.EH().Ff())).build().executeAsyncOnUIBack(bVar3);
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
            if (!TextUtils.isEmpty(bVar.dcm)) {
                hashMap.put("phone", bVar.dcm);
            }
            if (bVar.dco != null && !TextUtils.isEmpty(bVar.dco.code)) {
                hashMap.put("l1", bVar.dco.code);
            }
            if (bVar.dcp != null && !TextUtils.isEmpty(bVar.dcp.code)) {
                hashMap.put("l2", bVar.dcp.code);
            }
            if (bVar.dcq != null && !TextUtils.isEmpty(bVar.dcq.code)) {
                hashMap.put("l3", bVar.dcq.code);
            }
            if (!TextUtils.isEmpty(bVar.dcr)) {
                hashMap.put("street", bVar.dcr);
            }
            if (!TextUtils.isEmpty(bVar.dcs)) {
                hashMap.put("zipcode", bVar.dcs);
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b extends StringResponseCallback {
        private com.baidu.tieba.aiapps.apps.address.b.b dcf;
        private String mType;

        public b(com.baidu.tieba.aiapps.apps.address.b.b bVar, String str) {
            this.dcf = bVar;
            this.mType = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: x */
        public void onSuccess(String str, int i) {
            if (this.dcf != null) {
                this.dcf.aEJ();
                if (!TextUtils.isEmpty(str) && i == 200) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                            this.dcf.sS(jSONObject.optString("tipmsg"));
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
                                List<com.baidu.tieba.aiapps.apps.address.c.b> sY = com.baidu.tieba.aiapps.apps.address.c.c.sY(str);
                                a.this.dbz = sY;
                                this.dcf.g(sY, i);
                                a.this.aEP();
                                return;
                            case 1:
                                this.dcf.ai(str, i);
                                return;
                            case 2:
                                this.dcf.aj(str, i);
                                return;
                            case 3:
                                this.dcf.aj(str, i);
                                return;
                            case 4:
                                this.dcf.ak(str, i);
                                return;
                            default:
                                return;
                        }
                    } catch (JSONException e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                        this.dcf.onFailure();
                        return;
                    }
                }
                this.dcf.onFailure();
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (this.dcf != null) {
                this.dcf.aEJ();
                this.dcf.onFailure();
            }
        }
    }

    private String sU(String str) {
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
                if (TextUtils.equals(this.dbv, "aiapp")) {
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
            return d.sZ(d.aFs() + str2);
        }
        return str2;
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.address.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0283a implements com.baidu.tieba.aiapps.apps.address.b.b {
        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void aEJ() {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void aj(String str, int i) {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void ak(String str, int i) {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void ai(String str, int i) {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void g(List<com.baidu.tieba.aiapps.apps.address.c.b> list, int i) {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void onFailure() {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void sS(String str) {
        }
    }
}
