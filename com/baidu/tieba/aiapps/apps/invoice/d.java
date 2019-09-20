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
    private static d deY;

    public static d aGp() {
        if (deY == null) {
            synchronized (d.class) {
                if (deY == null) {
                    deY = new d();
                }
            }
        }
        return deY;
    }

    public void a(InvoiceInfo invoiceInfo, final c.a aVar) {
        if (invoiceInfo != null) {
            String aFS = com.baidu.tieba.aiapps.apps.c.d.aFS();
            HashMap hashMap = new HashMap();
            hashMap.put("data", invoiceInfo.toJson().toString());
            a(aFS, hashMap, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: f */
                public com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo> parseResponse(Response response, int i) throws Exception {
                    com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo> dVar = new com.baidu.tieba.aiapps.apps.invoice.model.d<>(new InvoiceInfo());
                    if (response != null && response.body() != null) {
                        dVar.bh(o.df(response.body().string()));
                    }
                    return dVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: a */
                public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo> dVar, int i) {
                    if (aVar != null) {
                        if (!TextUtils.equals(dVar.dfp, "0") || dVar.dfr == null) {
                            d.this.a(dVar.dfp, dVar.dfq, aVar);
                        } else {
                            aVar.a(dVar.dfr);
                        }
                    }
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                    if (aVar != null) {
                        aVar.cp(LivenessStat.TYPE_STRING_DEFAULT, exc.getMessage());
                    }
                }
            });
        }
    }

    public void a(Context context, final String str, final String str2, final c.InterfaceC0294c interfaceC0294c) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (interfaceC0294c != null) {
                interfaceC0294c.cp(LivenessStat.TYPE_STRING_DEFAULT, "");
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
                        jSONObject.put("host_api_key", com.baidu.swan.apps.u.a.EA().wW());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", jSONObject.toString());
                    d.this.a(com.baidu.tieba.aiapps.apps.c.d.aFU(), hashMap, interfaceC0294c);
                } else if (interfaceC0294c != null) {
                    interfaceC0294c.cp(LivenessStat.TYPE_STRING_DEFAULT, "");
                }
            }
        }, "dev");
    }

    public void a(c.InterfaceC0294c interfaceC0294c) {
        a(com.baidu.tieba.aiapps.apps.c.d.aFT(), (Map<String, String>) null, interfaceC0294c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Map<String, String> map, final c.InterfaceC0294c interfaceC0294c) {
        a(str, map, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.a>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: f */
            public com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.a> parseResponse(Response response, int i) throws Exception {
                com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.a> dVar = new com.baidu.tieba.aiapps.apps.invoice.model.d<>(new com.baidu.tieba.aiapps.apps.invoice.model.a());
                if (response != null && response.body() != null) {
                    dVar.bh(o.df(response.body().string()));
                }
                return dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.a> dVar, int i) {
                if (interfaceC0294c != null) {
                    if (!TextUtils.equals(dVar.dfp, "0") || dVar.dfr == null) {
                        d.this.a(dVar.dfp, dVar.dfq, interfaceC0294c);
                    } else {
                        interfaceC0294c.aL(dVar.dfr.dfj);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (interfaceC0294c != null) {
                    interfaceC0294c.cp(LivenessStat.TYPE_STRING_DEFAULT, exc.getMessage());
                }
            }
        });
    }

    public void a(InvoiceInfo invoiceInfo, final c.e eVar) {
        String aFV = com.baidu.tieba.aiapps.apps.c.d.aFV();
        HashMap hashMap = new HashMap();
        hashMap.put("data", invoiceInfo.toJson().toString());
        a(aFV, hashMap, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: f */
            public com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo> parseResponse(Response response, int i) throws Exception {
                com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo> dVar = new com.baidu.tieba.aiapps.apps.invoice.model.d<>(new InvoiceInfo());
                if (response != null && response.body() != null) {
                    dVar.bh(o.df(response.body().string()));
                }
                return dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo> dVar, int i) {
                if (eVar != null) {
                    if (!TextUtils.equals(dVar.dfp, "0") || dVar.dfr == null) {
                        d.this.a(dVar.dfp, dVar.dfq, eVar);
                    } else {
                        eVar.b(dVar.dfr);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (eVar != null) {
                    eVar.cp(LivenessStat.TYPE_STRING_DEFAULT, exc.getMessage());
                }
            }
        });
    }

    public void a(final long j, final c.d dVar) {
        String aFW = com.baidu.tieba.aiapps.apps.c.d.aFW();
        com.baidu.tieba.aiapps.apps.invoice.model.b bVar = new com.baidu.tieba.aiapps.apps.invoice.model.b(j);
        HashMap hashMap = new HashMap();
        hashMap.put("data", bVar.toJson().toString());
        a(aFW, hashMap, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.d>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: f */
            public com.baidu.tieba.aiapps.apps.invoice.model.d parseResponse(Response response, int i) throws Exception {
                com.baidu.tieba.aiapps.apps.invoice.model.d dVar2 = new com.baidu.tieba.aiapps.apps.invoice.model.d();
                if (response != null && response.body() != null) {
                    dVar2.bh(o.df(response.body().string()));
                }
                return dVar2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.d dVar2, int i) {
                if (dVar != null) {
                    if (!TextUtils.equals(dVar2.dfp, "0")) {
                        d.this.a(dVar2.dfp, dVar2.dfq, dVar);
                    } else {
                        dVar.bZ(j);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (dVar != null) {
                    dVar.cp(LivenessStat.TYPE_STRING_DEFAULT, exc.getMessage());
                }
            }
        });
    }

    public void a(long j, final c.b bVar) {
        String aFX = com.baidu.tieba.aiapps.apps.c.d.aFX();
        com.baidu.tieba.aiapps.apps.invoice.model.b bVar2 = new com.baidu.tieba.aiapps.apps.invoice.model.b(j);
        HashMap hashMap = new HashMap();
        hashMap.put("data", bVar2.toJson().toString());
        a(aFX, hashMap, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.b>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: f */
            public com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.b> parseResponse(Response response, int i) throws Exception {
                com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.b> dVar = new com.baidu.tieba.aiapps.apps.invoice.model.d<>(new com.baidu.tieba.aiapps.apps.invoice.model.b());
                if (response != null && response.body() != null) {
                    dVar.bh(o.df(response.body().string()));
                }
                return dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.b> dVar, int i) {
                if (bVar != null) {
                    if (!TextUtils.equals(dVar.dfp, "0") || dVar.dfr == null) {
                        d.this.a(dVar.dfp, dVar.dfq, bVar);
                    } else {
                        bVar.bY(dVar.dfr.mId);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (bVar != null) {
                    bVar.cp(LivenessStat.TYPE_STRING_DEFAULT, exc.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, c cVar) {
        if (cVar != null) {
            if (TextUtils.equals(str, "401")) {
                cVar.tz(str2);
            } else {
                cVar.cp(str, str2);
            }
        }
    }

    private void a(String str, Map<String, String> map, ResponseCallback responseCallback) {
        if (!TextUtils.isEmpty(str)) {
            PostFormRequest.PostFormRequestBuilder postFormRequestBuilder = (PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(com.baidu.tieba.aiapps.apps.c.d.ty(str))).cookieManager(com.baidu.swan.apps.u.a.EL().Fj());
            if (map != null) {
                postFormRequestBuilder.params(map);
            }
            postFormRequestBuilder.build().executeAsyncOnUIBack(responseCallback);
        }
    }
}
