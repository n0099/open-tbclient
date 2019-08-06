package com.baidu.tieba.aiapps.apps.invoice;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
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
    private static d ddl;

    public static d aFL() {
        if (ddl == null) {
            synchronized (d.class) {
                if (ddl == null) {
                    ddl = new d();
                }
            }
        }
        return ddl;
    }

    public void a(InvoiceInfo invoiceInfo, final c.a aVar) {
        if (invoiceInfo != null) {
            String aFo = com.baidu.tieba.aiapps.apps.c.d.aFo();
            HashMap hashMap = new HashMap();
            hashMap.put("data", invoiceInfo.toJson().toString());
            a(aFo, hashMap, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: f */
                public com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo> parseResponse(Response response, int i) throws Exception {
                    com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo> dVar = new com.baidu.tieba.aiapps.apps.invoice.model.d<>(new InvoiceInfo());
                    if (response != null && response.body() != null) {
                        dVar.bh(o.dd(response.body().string()));
                    }
                    return dVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: a */
                public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo> dVar, int i) {
                    if (aVar != null) {
                        if (!TextUtils.equals(dVar.ddD, "0") || dVar.ddF == null) {
                            d.this.a(dVar.ddD, dVar.ddE, aVar);
                        } else {
                            aVar.a(dVar.ddF);
                        }
                    }
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                    if (aVar != null) {
                        aVar.co(LivenessStat.TYPE_STRING_DEFAULT, exc.getMessage());
                    }
                }
            });
        }
    }

    public void a(Context context, final String str, final String str2, final c.InterfaceC0285c interfaceC0285c) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (interfaceC0285c != null) {
                interfaceC0285c.co(LivenessStat.TYPE_STRING_DEFAULT, "");
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
                        jSONObject.put("stoken", bundle.getString("dev", ""));
                        jSONObject.put("host_api_key", com.baidu.swan.apps.u.a.Ew().wS());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", jSONObject.toString());
                    d.this.a(com.baidu.tieba.aiapps.apps.c.d.aFq(), hashMap, interfaceC0285c);
                } else if (interfaceC0285c != null) {
                    interfaceC0285c.co(LivenessStat.TYPE_STRING_DEFAULT, "");
                }
            }
        }, "dev");
    }

    public void a(c.InterfaceC0285c interfaceC0285c) {
        a(com.baidu.tieba.aiapps.apps.c.d.aFp(), (Map<String, String>) null, interfaceC0285c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Map<String, String> map, final c.InterfaceC0285c interfaceC0285c) {
        a(str, map, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.a>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: f */
            public com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.a> parseResponse(Response response, int i) throws Exception {
                com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.a> dVar = new com.baidu.tieba.aiapps.apps.invoice.model.d<>(new com.baidu.tieba.aiapps.apps.invoice.model.a());
                if (response != null && response.body() != null) {
                    dVar.bh(o.dd(response.body().string()));
                }
                return dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.a> dVar, int i) {
                if (interfaceC0285c != null) {
                    if (!TextUtils.equals(dVar.ddD, "0") || dVar.ddF == null) {
                        d.this.a(dVar.ddD, dVar.ddE, interfaceC0285c);
                    } else {
                        interfaceC0285c.aL(dVar.ddF.ddx);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (interfaceC0285c != null) {
                    interfaceC0285c.co(LivenessStat.TYPE_STRING_DEFAULT, exc.getMessage());
                }
            }
        });
    }

    public void a(InvoiceInfo invoiceInfo, final c.e eVar) {
        String aFr = com.baidu.tieba.aiapps.apps.c.d.aFr();
        HashMap hashMap = new HashMap();
        hashMap.put("data", invoiceInfo.toJson().toString());
        a(aFr, hashMap, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: f */
            public com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo> parseResponse(Response response, int i) throws Exception {
                com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo> dVar = new com.baidu.tieba.aiapps.apps.invoice.model.d<>(new InvoiceInfo());
                if (response != null && response.body() != null) {
                    dVar.bh(o.dd(response.body().string()));
                }
                return dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo> dVar, int i) {
                if (eVar != null) {
                    if (!TextUtils.equals(dVar.ddD, "0") || dVar.ddF == null) {
                        d.this.a(dVar.ddD, dVar.ddE, eVar);
                    } else {
                        eVar.b(dVar.ddF);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (eVar != null) {
                    eVar.co(LivenessStat.TYPE_STRING_DEFAULT, exc.getMessage());
                }
            }
        });
    }

    public void a(final long j, final c.d dVar) {
        String aFs = com.baidu.tieba.aiapps.apps.c.d.aFs();
        com.baidu.tieba.aiapps.apps.invoice.model.b bVar = new com.baidu.tieba.aiapps.apps.invoice.model.b(j);
        HashMap hashMap = new HashMap();
        hashMap.put("data", bVar.toJson().toString());
        a(aFs, hashMap, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.d>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: f */
            public com.baidu.tieba.aiapps.apps.invoice.model.d parseResponse(Response response, int i) throws Exception {
                com.baidu.tieba.aiapps.apps.invoice.model.d dVar2 = new com.baidu.tieba.aiapps.apps.invoice.model.d();
                if (response != null && response.body() != null) {
                    dVar2.bh(o.dd(response.body().string()));
                }
                return dVar2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.d dVar2, int i) {
                if (dVar != null) {
                    if (!TextUtils.equals(dVar2.ddD, "0")) {
                        d.this.a(dVar2.ddD, dVar2.ddE, dVar);
                    } else {
                        dVar.bW(j);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (dVar != null) {
                    dVar.co(LivenessStat.TYPE_STRING_DEFAULT, exc.getMessage());
                }
            }
        });
    }

    public void a(long j, final c.b bVar) {
        String aFt = com.baidu.tieba.aiapps.apps.c.d.aFt();
        com.baidu.tieba.aiapps.apps.invoice.model.b bVar2 = new com.baidu.tieba.aiapps.apps.invoice.model.b(j);
        HashMap hashMap = new HashMap();
        hashMap.put("data", bVar2.toJson().toString());
        a(aFt, hashMap, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.b>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: f */
            public com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.b> parseResponse(Response response, int i) throws Exception {
                com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.b> dVar = new com.baidu.tieba.aiapps.apps.invoice.model.d<>(new com.baidu.tieba.aiapps.apps.invoice.model.b());
                if (response != null && response.body() != null) {
                    dVar.bh(o.dd(response.body().string()));
                }
                return dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.b> dVar, int i) {
                if (bVar != null) {
                    if (!TextUtils.equals(dVar.ddD, "0") || dVar.ddF == null) {
                        d.this.a(dVar.ddD, dVar.ddE, bVar);
                    } else {
                        bVar.bV(dVar.ddF.mId);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (bVar != null) {
                    bVar.co(LivenessStat.TYPE_STRING_DEFAULT, exc.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, c cVar) {
        if (cVar != null) {
            if (TextUtils.equals(str, "401")) {
                cVar.ta(str2);
            } else {
                cVar.co(str, str2);
            }
        }
    }

    private void a(String str, Map<String, String> map, ResponseCallback responseCallback) {
        if (!TextUtils.isEmpty(str)) {
            PostFormRequest.PostFormRequestBuilder postFormRequestBuilder = (PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(com.baidu.tieba.aiapps.apps.c.d.sZ(str))).cookieManager(com.baidu.swan.apps.u.a.EH().Ff());
            if (map != null) {
                postFormRequestBuilder.params(map);
            }
            postFormRequestBuilder.build().executeAsyncOnUIBack(responseCallback);
        }
    }
}
