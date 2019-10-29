package com.baidu.tieba.aiapps.apps.address.b;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.swan.apps.an.j;
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
    private String dmK;
    private List<com.baidu.tieba.aiapps.apps.address.c.b> dmO = new ArrayList();
    private Bundle dmQ;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c {
        private static final a dnv = new a();
    }

    public static a aFF() {
        return c.dnv;
    }

    public void H(Bundle bundle) {
        this.dmQ = bundle;
        if (this.dmQ != null) {
            String string = this.dmQ.getString("openSource");
            if (!TextUtils.isEmpty(string)) {
                this.dmK = string;
            }
        }
    }

    public void a(com.baidu.tieba.aiapps.apps.address.b.b bVar) {
        new b(bVar, "list");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (TextUtils.equals(this.dmK, "aiapp")) {
            linkedHashMap.put("ma_id", this.dmQ.getString("appId"));
            linkedHashMap.put("app_key", this.dmQ.getString("appKey"));
            linkedHashMap.put("host_pkgname", this.dmQ.getString(PushClientConstants.TAG_PKG_NAME));
            linkedHashMap.put("host_key_hash", this.dmQ.getString("keyHash"));
            linkedHashMap.put("stoken", this.dmQ.getString("stoken"));
            linkedHashMap.put("host_api_key", com.baidu.swan.apps.u.a.Ju().BQ());
        }
        a(null, bVar, linkedHashMap, "list");
    }

    public List<com.baidu.tieba.aiapps.apps.address.c.b> aFG() {
        String ab = com.baidu.swan.c.a.ab(AppRuntime.getAppContext(), "delivery_data.json");
        if (!TextUtils.isEmpty(ab)) {
            try {
                this.dmO = com.baidu.tieba.aiapps.apps.address.c.c.M(new JSONArray(ab));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this.dmO;
    }

    public void aFH() {
        j.a(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.c.a.c(AppRuntime.getAppContext(), "delivery_data.json", com.baidu.tieba.aiapps.apps.address.c.c.ba(a.this.dmO).toString(), 0);
            }
        }, "saveCacheToLocal");
    }

    public List<com.baidu.tieba.aiapps.apps.address.c.b> aFI() {
        if (this.dmO == null) {
            this.dmO = new ArrayList();
        }
        return this.dmO;
    }

    public void a(com.baidu.tieba.aiapps.apps.address.c.b bVar, com.baidu.tieba.aiapps.apps.address.b.b bVar2) {
        if (bVar == null || !bVar.isValid()) {
            if (DEBUG) {
                Log.d("DeliveryDataManager", "requestAddDelivery: deliveryAddr is invalid");
                return;
            }
            return;
        }
        a(bVar, bVar2, a(bVar), IMTrack.DbBuilder.ACTION_ADD);
    }

    public void b(com.baidu.tieba.aiapps.apps.address.c.b bVar, com.baidu.tieba.aiapps.apps.address.b.b bVar2) {
        if (bVar == null || TextUtils.isEmpty(bVar.id)) {
            if (DEBUG) {
                Log.d("DeliveryDataManager", "requestDeleteDelivery: deliveryAddr-id is empty");
                return;
            }
            return;
        }
        a(bVar, bVar2, a(bVar), "delete");
    }

    public void c(com.baidu.tieba.aiapps.apps.address.c.b bVar, com.baidu.tieba.aiapps.apps.address.b.b bVar2) {
        if (bVar == null || TextUtils.isEmpty(bVar.id)) {
            if (DEBUG) {
                Log.d("DeliveryDataManager", "requestUpdateDelivery: deliveryAddr is invalid");
                return;
            }
            return;
        }
        a(bVar, bVar2, a(bVar), IMTrack.DbBuilder.ACTION_UPDATE);
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
        if (bVar == null && !TextUtils.equals(str, "list")) {
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
        String sc = sc(str);
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(sc)).addParam("data", jSONObject.toString()).cookieManager(com.baidu.swan.apps.u.a.JF().Kd())).build().executeAsyncOnUIBack(bVar3);
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
            if (!TextUtils.isEmpty(bVar.dnB)) {
                hashMap.put("phone", bVar.dnB);
            }
            if (bVar.dnD != null && !TextUtils.isEmpty(bVar.dnD.code)) {
                hashMap.put("l1", bVar.dnD.code);
            }
            if (bVar.dnE != null && !TextUtils.isEmpty(bVar.dnE.code)) {
                hashMap.put("l2", bVar.dnE.code);
            }
            if (bVar.dnF != null && !TextUtils.isEmpty(bVar.dnF.code)) {
                hashMap.put("l3", bVar.dnF.code);
            }
            if (!TextUtils.isEmpty(bVar.dnG)) {
                hashMap.put("street", bVar.dnG);
            }
            if (!TextUtils.isEmpty(bVar.dnH)) {
                hashMap.put("zipcode", bVar.dnH);
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b extends StringResponseCallback {
        private com.baidu.tieba.aiapps.apps.address.b.b dnu;
        private String mType;

        public b(com.baidu.tieba.aiapps.apps.address.b.b bVar, String str) {
            this.dnu = bVar;
            this.mType = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: x */
        public void onSuccess(String str, int i) {
            if (this.dnu != null) {
                this.dnu.aFB();
                if (!TextUtils.isEmpty(str) && i == 200) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                            this.dnu.sa(jSONObject.optString("tipmsg"));
                            return;
                        }
                        String str2 = this.mType;
                        char c = 65535;
                        switch (str2.hashCode()) {
                            case -1335458389:
                                if (str2.equals("delete")) {
                                    c = 4;
                                    break;
                                }
                                break;
                            case -838846263:
                                if (str2.equals(IMTrack.DbBuilder.ACTION_UPDATE)) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case 96417:
                                if (str2.equals(IMTrack.DbBuilder.ACTION_ADD)) {
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
                                List<com.baidu.tieba.aiapps.apps.address.c.b> sg = com.baidu.tieba.aiapps.apps.address.c.c.sg(str);
                                a.this.dmO = sg;
                                this.dnu.d(sg, i);
                                a.this.aFH();
                                return;
                            case 1:
                                this.dnu.ab(str, i);
                                return;
                            case 2:
                                this.dnu.ac(str, i);
                                return;
                            case 3:
                                this.dnu.ac(str, i);
                                return;
                            case 4:
                                this.dnu.ad(str, i);
                                return;
                            default:
                                return;
                        }
                    } catch (JSONException e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                        this.dnu.onFailure();
                        return;
                    }
                }
                this.dnu.onFailure();
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (this.dnu != null) {
                this.dnu.aFB();
                this.dnu.onFailure();
            }
        }
    }

    private String sc(String str) {
        String str2 = "";
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1335458389:
                if (str.equals("delete")) {
                    c2 = 4;
                    break;
                }
                break;
            case -838846263:
                if (str.equals(IMTrack.DbBuilder.ACTION_UPDATE)) {
                    c2 = 2;
                    break;
                }
                break;
            case 96417:
                if (str.equals(IMTrack.DbBuilder.ACTION_ADD)) {
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
                if (TextUtils.equals(this.dmK, "aiapp")) {
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
            return d.sh(d.aGl() + str2);
        }
        return str2;
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.address.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0324a implements com.baidu.tieba.aiapps.apps.address.b.b {
        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void aFB() {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void ac(String str, int i) {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void ad(String str, int i) {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void ab(String str, int i) {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void d(List<com.baidu.tieba.aiapps.apps.address.c.b> list, int i) {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void onFailure() {
        }

        @Override // com.baidu.tieba.aiapps.apps.address.b.b
        public void sa(String str) {
        }
    }
}
