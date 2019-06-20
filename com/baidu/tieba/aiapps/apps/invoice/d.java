package com.baidu.tieba.aiapps.apps.invoice;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.swan.apps.an.o;
import com.baidu.tieba.aiapps.apps.invoice.c;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    private static d dbD;

    public static d aEt() {
        if (dbD == null) {
            synchronized (d.class) {
                if (dbD == null) {
                    dbD = new d();
                }
            }
        }
        return dbD;
    }

    public void a(InvoiceInfo invoiceInfo, final c.a aVar) {
        if (invoiceInfo != null) {
            String aDW = com.baidu.tieba.aiapps.apps.d.d.aDW();
            HashMap hashMap = new HashMap();
            hashMap.put("data", invoiceInfo.toJson().toString());
            a(aDW, hashMap, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: f */
                public com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo> parseResponse(Response response, int i) throws Exception {
                    com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo> dVar = new com.baidu.tieba.aiapps.apps.invoice.model.d<>(new InvoiceInfo());
                    if (response != null && response.body() != null) {
                        dVar.bh(o.cY(response.body().string()));
                    }
                    return dVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: a */
                public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo> dVar, int i) {
                    if (aVar != null) {
                        if (!TextUtils.equals(dVar.dbU, "0") || dVar.dbW == null) {
                            d.this.a(dVar.dbU, dVar.dbV, aVar);
                        } else {
                            aVar.a(dVar.dbW);
                        }
                    }
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                    if (aVar != null) {
                        aVar.cn(LivenessStat.TYPE_STRING_DEFAULT, exc.getMessage());
                    }
                }
            });
        }
    }

    public void a(Context context, final String str, final String str2, final c.InterfaceC0282c interfaceC0282c) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (interfaceC0282c != null) {
                interfaceC0282c.cn(LivenessStat.TYPE_STRING_DEFAULT, "");
                return;
            }
            return;
        }
        com.baidu.tieba.aiapps.apps.a.c.a(context, new com.baidu.swan.apps.an.d.a<Bundle>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: o */
            public void D(Bundle bundle) {
                if (bundle != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("ma_id", str);
                        jSONObject.put("app_key", str2);
                        jSONObject.put("host_pkgname", com.baidu.swan.apps.setting.oauth.c.getAppContext().getPackageName());
                        jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
                        jSONObject.put(ISapiAccount.SAPI_ACCOUNT_STOKEN, bundle.getString("dev", ""));
                        jSONObject.put("host_api_key", com.baidu.swan.apps.u.a.DN().wr());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", jSONObject.toString());
                    d.this.a(com.baidu.tieba.aiapps.apps.d.d.aDY(), hashMap, interfaceC0282c);
                } else if (interfaceC0282c != null) {
                    interfaceC0282c.cn(LivenessStat.TYPE_STRING_DEFAULT, "");
                }
            }
        }, "dev");
    }

    public void a(c.InterfaceC0282c interfaceC0282c) {
        a(com.baidu.tieba.aiapps.apps.d.d.aDX(), (Map<String, String>) null, interfaceC0282c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Map<String, String> map, final c.InterfaceC0282c interfaceC0282c) {
        a(str, map, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.a>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: f */
            public com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.a> parseResponse(Response response, int i) throws Exception {
                com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.a> dVar = new com.baidu.tieba.aiapps.apps.invoice.model.d<>(new com.baidu.tieba.aiapps.apps.invoice.model.a());
                if (response != null && response.body() != null) {
                    dVar.bh(o.cY(response.body().string()));
                }
                return dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.a> dVar, int i) {
                if (interfaceC0282c != null) {
                    if (!TextUtils.equals(dVar.dbU, "0") || dVar.dbW == null) {
                        d.this.a(dVar.dbU, dVar.dbV, interfaceC0282c);
                    } else {
                        interfaceC0282c.aL(dVar.dbW.dbO);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (interfaceC0282c != null) {
                    interfaceC0282c.cn(LivenessStat.TYPE_STRING_DEFAULT, exc.getMessage());
                }
            }
        });
    }

    public void a(InvoiceInfo invoiceInfo, final c.e eVar) {
        String aDZ = com.baidu.tieba.aiapps.apps.d.d.aDZ();
        HashMap hashMap = new HashMap();
        hashMap.put("data", invoiceInfo.toJson().toString());
        a(aDZ, hashMap, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: f */
            public com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo> parseResponse(Response response, int i) throws Exception {
                com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo> dVar = new com.baidu.tieba.aiapps.apps.invoice.model.d<>(new InvoiceInfo());
                if (response != null && response.body() != null) {
                    dVar.bh(o.cY(response.body().string()));
                }
                return dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo> dVar, int i) {
                if (eVar != null) {
                    if (!TextUtils.equals(dVar.dbU, "0") || dVar.dbW == null) {
                        d.this.a(dVar.dbU, dVar.dbV, eVar);
                    } else {
                        eVar.b(dVar.dbW);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (eVar != null) {
                    eVar.cn(LivenessStat.TYPE_STRING_DEFAULT, exc.getMessage());
                }
            }
        });
    }

    public void a(final long j, final c.d dVar) {
        String aEa = com.baidu.tieba.aiapps.apps.d.d.aEa();
        com.baidu.tieba.aiapps.apps.invoice.model.b bVar = new com.baidu.tieba.aiapps.apps.invoice.model.b(j);
        HashMap hashMap = new HashMap();
        hashMap.put("data", bVar.toJson().toString());
        a(aEa, hashMap, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.d>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: f */
            public com.baidu.tieba.aiapps.apps.invoice.model.d parseResponse(Response response, int i) throws Exception {
                com.baidu.tieba.aiapps.apps.invoice.model.d dVar2 = new com.baidu.tieba.aiapps.apps.invoice.model.d();
                if (response != null && response.body() != null) {
                    dVar2.bh(o.cY(response.body().string()));
                }
                return dVar2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.d dVar2, int i) {
                if (dVar != null) {
                    if (!TextUtils.equals(dVar2.dbU, "0")) {
                        d.this.a(dVar2.dbU, dVar2.dbV, dVar);
                    } else {
                        dVar.bV(j);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (dVar != null) {
                    dVar.cn(LivenessStat.TYPE_STRING_DEFAULT, exc.getMessage());
                }
            }
        });
    }

    public void a(long j, final c.b bVar) {
        String aEb = com.baidu.tieba.aiapps.apps.d.d.aEb();
        com.baidu.tieba.aiapps.apps.invoice.model.b bVar2 = new com.baidu.tieba.aiapps.apps.invoice.model.b(j);
        HashMap hashMap = new HashMap();
        hashMap.put("data", bVar2.toJson().toString());
        a(aEb, hashMap, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.b>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: f */
            public com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.b> parseResponse(Response response, int i) throws Exception {
                com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.b> dVar = new com.baidu.tieba.aiapps.apps.invoice.model.d<>(new com.baidu.tieba.aiapps.apps.invoice.model.b());
                if (response != null && response.body() != null) {
                    dVar.bh(o.cY(response.body().string()));
                }
                return dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.b> dVar, int i) {
                if (bVar != null) {
                    if (!TextUtils.equals(dVar.dbU, "0") || dVar.dbW == null) {
                        d.this.a(dVar.dbU, dVar.dbV, bVar);
                    } else {
                        bVar.bU(dVar.dbW.mId);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (bVar != null) {
                    bVar.cn(LivenessStat.TYPE_STRING_DEFAULT, exc.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, c cVar) {
        if (cVar != null) {
            if (TextUtils.equals(str, "401")) {
                cVar.sH(str2);
            } else {
                cVar.cn(str, str2);
            }
        }
    }

    private void a(String str, Map<String, String> map, ResponseCallback responseCallback) {
        if (!TextUtils.isEmpty(str)) {
            PostFormRequest.PostFormRequestBuilder postFormRequestBuilder = (PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(com.baidu.tieba.aiapps.apps.d.d.sG(str))).cookieManager(com.baidu.swan.apps.u.a.DY().Ew());
            if (map != null) {
                postFormRequestBuilder.params(map);
            }
            postFormRequestBuilder.build().executeAsyncOnUIBack(responseCallback);
        }
    }
}
