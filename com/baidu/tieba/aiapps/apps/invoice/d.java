package com.baidu.tieba.aiapps.apps.invoice;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.tieba.aiapps.apps.invoice.c;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    private static d cTd;
    private com.google.gson.d cTe = new com.google.gson.d();

    private d() {
    }

    public static d azg() {
        if (cTd == null) {
            synchronized (d.class) {
                if (cTd == null) {
                    cTd = new d();
                }
            }
        }
        return cTd;
    }

    public void a(InvoiceInfo invoiceInfo, final c.a aVar) {
        if (invoiceInfo != null) {
            String ayY = com.baidu.tieba.aiapps.apps.c.d.ayY();
            HashMap hashMap = new HashMap();
            hashMap.put("data", this.cTe.toJson(invoiceInfo));
            a(ayY, hashMap, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.c<InvoiceInfo>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: e */
                public com.baidu.tieba.aiapps.apps.invoice.model.c<InvoiceInfo> parseResponse(Response response, int i) throws Exception {
                    if (response == null || response.body() == null) {
                        return null;
                    }
                    return (com.baidu.tieba.aiapps.apps.invoice.model.c) d.this.c(response.body().string(), new com.google.gson.b.a<com.baidu.tieba.aiapps.apps.invoice.model.c<InvoiceInfo>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.1.1
                    }.cBH());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: a */
                public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.c<InvoiceInfo> cVar, int i) {
                    if (aVar != null) {
                        if (!TextUtils.equals(cVar.cTB, "0") || cVar.mData == null) {
                            d.this.a(cVar.cTB, cVar.cTC, aVar);
                        } else {
                            aVar.a(cVar.mData);
                        }
                    }
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                    if (aVar != null) {
                        aVar.cd(LivenessStat.TYPE_STRING_DEFAULT, exc.getMessage());
                    }
                }
            });
        }
    }

    public void a(Context context, final String str, final String str2, final c.InterfaceC0228c interfaceC0228c) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (interfaceC0228c != null) {
                interfaceC0228c.cd(LivenessStat.TYPE_STRING_DEFAULT, "");
                return;
            }
            return;
        }
        com.baidu.tieba.aiapps.apps.a.a.a((Context) ((Activity) context), new com.baidu.swan.apps.an.c.a<Bundle>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.c.a
            /* renamed from: o */
            public void D(Bundle bundle) {
                if (bundle != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("ma_id", str);
                        jSONObject.put("app_key", str2);
                        jSONObject.put("host_pkgname", com.baidu.swan.apps.setting.oauth.c.getAppContext().getPackageName());
                        jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
                        jSONObject.put("host_api_key", com.baidu.tieba.aiapps.apps.c.a.vD());
                        jSONObject.put(ISapiAccount.SAPI_ACCOUNT_STOKEN, bundle.getString("dev", ""));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", jSONObject.toString());
                    d.this.a(com.baidu.tieba.aiapps.apps.c.d.ayX(), hashMap, interfaceC0228c);
                } else if (interfaceC0228c != null) {
                    interfaceC0228c.cd(LivenessStat.TYPE_STRING_DEFAULT, "");
                }
            }
        }, "dev");
    }

    public void a(c.InterfaceC0228c interfaceC0228c) {
        a(com.baidu.tieba.aiapps.apps.c.d.ayW(), (Map<String, String>) null, interfaceC0228c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Map<String, String> map, final c.InterfaceC0228c interfaceC0228c) {
        a(str, map, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.c<com.baidu.tieba.aiapps.apps.invoice.model.a>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: e */
            public com.baidu.tieba.aiapps.apps.invoice.model.c<com.baidu.tieba.aiapps.apps.invoice.model.a> parseResponse(Response response, int i) throws Exception {
                if (response == null || response.body() == null) {
                    return null;
                }
                return (com.baidu.tieba.aiapps.apps.invoice.model.c) d.this.c(response.body().string(), new com.google.gson.b.a<com.baidu.tieba.aiapps.apps.invoice.model.c<com.baidu.tieba.aiapps.apps.invoice.model.a>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.3.1
                }.cBH());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.c<com.baidu.tieba.aiapps.apps.invoice.model.a> cVar, int i) {
                if (interfaceC0228c != null) {
                    if (!TextUtils.equals(cVar.cTB, "0") || cVar.mData == null) {
                        d.this.a(cVar.cTB, cVar.cTC, interfaceC0228c);
                    } else {
                        interfaceC0228c.aE(cVar.mData.cTv);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (interfaceC0228c != null) {
                    interfaceC0228c.cd(LivenessStat.TYPE_STRING_DEFAULT, exc.getMessage());
                }
            }
        });
    }

    public void a(InvoiceInfo invoiceInfo, final c.e eVar) {
        String ayT = com.baidu.tieba.aiapps.apps.c.d.ayT();
        HashMap hashMap = new HashMap();
        hashMap.put("data", this.cTe.toJson(invoiceInfo));
        a(ayT, hashMap, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.c<InvoiceInfo>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: e */
            public com.baidu.tieba.aiapps.apps.invoice.model.c<InvoiceInfo> parseResponse(Response response, int i) throws Exception {
                if (response == null || response.body() == null) {
                    return null;
                }
                return (com.baidu.tieba.aiapps.apps.invoice.model.c) d.this.c(response.body().string(), new com.google.gson.b.a<com.baidu.tieba.aiapps.apps.invoice.model.c<InvoiceInfo>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.4.1
                }.cBH());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.c<InvoiceInfo> cVar, int i) {
                if (eVar != null) {
                    if (!TextUtils.equals(cVar.cTB, "0") || cVar.mData == null) {
                        d.this.a(cVar.cTB, cVar.cTC, eVar);
                    } else {
                        eVar.b(cVar.mData);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (eVar != null) {
                    eVar.cd(LivenessStat.TYPE_STRING_DEFAULT, exc.getMessage());
                }
            }
        });
    }

    public void a(final long j, final c.d dVar) {
        String ayU = com.baidu.tieba.aiapps.apps.c.d.ayU();
        com.baidu.tieba.aiapps.apps.invoice.model.b bVar = new com.baidu.tieba.aiapps.apps.invoice.model.b(j);
        HashMap hashMap = new HashMap();
        hashMap.put("data", this.cTe.toJson(bVar));
        a(ayU, hashMap, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.c>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: e */
            public com.baidu.tieba.aiapps.apps.invoice.model.c parseResponse(Response response, int i) throws Exception {
                if (response == null || response.body() == null) {
                    return null;
                }
                return (com.baidu.tieba.aiapps.apps.invoice.model.c) d.this.c(response.body().string(), new com.google.gson.b.a<com.baidu.tieba.aiapps.apps.invoice.model.c>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.5.1
                }.cBH());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.c cVar, int i) {
                if (dVar != null) {
                    if (!TextUtils.equals(cVar.cTB, "0")) {
                        d.this.a(cVar.cTB, cVar.cTC, dVar);
                    } else {
                        dVar.bG(j);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (dVar != null) {
                    dVar.cd(LivenessStat.TYPE_STRING_DEFAULT, exc.getMessage());
                }
            }
        });
    }

    public void a(long j, final c.b bVar) {
        String ayV = com.baidu.tieba.aiapps.apps.c.d.ayV();
        com.baidu.tieba.aiapps.apps.invoice.model.b bVar2 = new com.baidu.tieba.aiapps.apps.invoice.model.b(j);
        HashMap hashMap = new HashMap();
        hashMap.put("data", this.cTe.toJson(bVar2));
        a(ayV, hashMap, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.c<com.baidu.tieba.aiapps.apps.invoice.model.b>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: e */
            public com.baidu.tieba.aiapps.apps.invoice.model.c<com.baidu.tieba.aiapps.apps.invoice.model.b> parseResponse(Response response, int i) throws Exception {
                if (response == null || response.body() == null) {
                    return null;
                }
                return (com.baidu.tieba.aiapps.apps.invoice.model.c) d.this.c(response.body().string(), new com.google.gson.b.a<com.baidu.tieba.aiapps.apps.invoice.model.c<com.baidu.tieba.aiapps.apps.invoice.model.b>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.6.1
                }.cBH());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.c<com.baidu.tieba.aiapps.apps.invoice.model.b> cVar, int i) {
                if (bVar != null) {
                    if (!TextUtils.equals(cVar.cTB, "0") || cVar.mData == null) {
                        d.this.a(cVar.cTB, cVar.cTC, bVar);
                    } else {
                        bVar.bF(cVar.mData.mId);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (bVar != null) {
                    bVar.cd(LivenessStat.TYPE_STRING_DEFAULT, exc.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, c cVar) {
        if (cVar != null) {
            if (TextUtils.equals(str, "401")) {
                cVar.rz(str2);
            } else {
                cVar.cd(str, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> T c(String str, Type type) {
        if (TextUtils.isEmpty(str) || type == null) {
            return null;
        }
        try {
            return (T) this.cTe.d(str, type);
        } catch (Exception e) {
            return null;
        }
    }

    private void a(String str, Map<String, String> map, ResponseCallback responseCallback) {
        if (!TextUtils.isEmpty(str)) {
            PostFormRequest.PostFormRequestBuilder postFormRequestBuilder = (PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(com.baidu.tieba.aiapps.apps.c.d.ry(str))).cookieManager(com.baidu.tieba.aiapps.apps.a.a.Dp());
            if (map != null) {
                postFormRequestBuilder.params(map);
            }
            postFormRequestBuilder.build().executeAsyncOnUIBack(responseCallback);
        }
    }
}
