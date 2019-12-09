package com.baidu.tieba.aiapps.apps.invoice;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
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
    private static d dnB;

    public static d aGA() {
        if (dnB == null) {
            synchronized (d.class) {
                if (dnB == null) {
                    dnB = new d();
                }
            }
        }
        return dnB;
    }

    public void a(InvoiceInfo invoiceInfo, final c.a aVar) {
        if (invoiceInfo != null) {
            String aGd = com.baidu.tieba.aiapps.apps.c.d.aGd();
            HashMap hashMap = new HashMap();
            hashMap.put("data", invoiceInfo.toJson().toString());
            a(aGd, hashMap, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: f */
                public com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo> parseResponse(Response response, int i) throws Exception {
                    com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo> dVar = new com.baidu.tieba.aiapps.apps.invoice.model.d<>(new InvoiceInfo());
                    if (response != null && response.body() != null) {
                        dVar.bF(o.dP(response.body().string()));
                    }
                    return dVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: a */
                public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo> dVar, int i) {
                    if (aVar != null) {
                        if (!TextUtils.equals(dVar.dnS, "0") || dVar.dnU == null) {
                            d.this.a(dVar.dnS, dVar.dnT, aVar);
                        } else {
                            aVar.a(dVar.dnU);
                        }
                    }
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                    if (aVar != null) {
                        aVar.ci(LivenessStat.TYPE_STRING_DEFAULT, exc.getMessage());
                    }
                }
            });
        }
    }

    public void a(Context context, final String str, final String str2, final c.InterfaceC0321c interfaceC0321c) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (interfaceC0321c != null) {
                interfaceC0321c.ci(LivenessStat.TYPE_STRING_DEFAULT, "");
                return;
            }
            return;
        }
        com.baidu.tieba.aiapps.apps.a.c.a(context, new com.baidu.swan.apps.an.d.a<Bundle>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: o */
            public void B(Bundle bundle) {
                if (bundle != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("ma_id", str);
                        jSONObject.put("app_key", str2);
                        jSONObject.put("host_pkgname", com.baidu.swan.apps.setting.oauth.c.getAppContext().getPackageName());
                        jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
                        jSONObject.put("stoken", bundle.getString("dev", ""));
                        jSONObject.put("host_api_key", com.baidu.swan.apps.u.a.Jv().BR());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", jSONObject.toString());
                    d.this.a(com.baidu.tieba.aiapps.apps.c.d.aGf(), hashMap, interfaceC0321c);
                } else if (interfaceC0321c != null) {
                    interfaceC0321c.ci(LivenessStat.TYPE_STRING_DEFAULT, "");
                }
            }
        }, "dev");
    }

    public void a(c.InterfaceC0321c interfaceC0321c) {
        a(com.baidu.tieba.aiapps.apps.c.d.aGe(), (Map<String, String>) null, interfaceC0321c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Map<String, String> map, final c.InterfaceC0321c interfaceC0321c) {
        a(str, map, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.a>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: f */
            public com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.a> parseResponse(Response response, int i) throws Exception {
                com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.a> dVar = new com.baidu.tieba.aiapps.apps.invoice.model.d<>(new com.baidu.tieba.aiapps.apps.invoice.model.a());
                if (response != null && response.body() != null) {
                    dVar.bF(o.dP(response.body().string()));
                }
                return dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.a> dVar, int i) {
                if (interfaceC0321c != null) {
                    if (!TextUtils.equals(dVar.dnS, "0") || dVar.dnU == null) {
                        d.this.a(dVar.dnS, dVar.dnT, interfaceC0321c);
                    } else {
                        interfaceC0321c.be(dVar.dnU.dnM);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (interfaceC0321c != null) {
                    interfaceC0321c.ci(LivenessStat.TYPE_STRING_DEFAULT, exc.getMessage());
                }
            }
        });
    }

    public void a(InvoiceInfo invoiceInfo, final c.e eVar) {
        String aGg = com.baidu.tieba.aiapps.apps.c.d.aGg();
        HashMap hashMap = new HashMap();
        hashMap.put("data", invoiceInfo.toJson().toString());
        a(aGg, hashMap, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: f */
            public com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo> parseResponse(Response response, int i) throws Exception {
                com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo> dVar = new com.baidu.tieba.aiapps.apps.invoice.model.d<>(new InvoiceInfo());
                if (response != null && response.body() != null) {
                    dVar.bF(o.dP(response.body().string()));
                }
                return dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.d<InvoiceInfo> dVar, int i) {
                if (eVar != null) {
                    if (!TextUtils.equals(dVar.dnS, "0") || dVar.dnU == null) {
                        d.this.a(dVar.dnS, dVar.dnT, eVar);
                    } else {
                        eVar.b(dVar.dnU);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (eVar != null) {
                    eVar.ci(LivenessStat.TYPE_STRING_DEFAULT, exc.getMessage());
                }
            }
        });
    }

    public void a(final long j, final c.d dVar) {
        String aGh = com.baidu.tieba.aiapps.apps.c.d.aGh();
        com.baidu.tieba.aiapps.apps.invoice.model.b bVar = new com.baidu.tieba.aiapps.apps.invoice.model.b(j);
        HashMap hashMap = new HashMap();
        hashMap.put("data", bVar.toJson().toString());
        a(aGh, hashMap, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.d>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: f */
            public com.baidu.tieba.aiapps.apps.invoice.model.d parseResponse(Response response, int i) throws Exception {
                com.baidu.tieba.aiapps.apps.invoice.model.d dVar2 = new com.baidu.tieba.aiapps.apps.invoice.model.d();
                if (response != null && response.body() != null) {
                    dVar2.bF(o.dP(response.body().string()));
                }
                return dVar2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.d dVar2, int i) {
                if (dVar != null) {
                    if (!TextUtils.equals(dVar2.dnS, "0")) {
                        d.this.a(dVar2.dnS, dVar2.dnT, dVar);
                    } else {
                        dVar.bN(j);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (dVar != null) {
                    dVar.ci(LivenessStat.TYPE_STRING_DEFAULT, exc.getMessage());
                }
            }
        });
    }

    public void a(long j, final c.b bVar) {
        String aGi = com.baidu.tieba.aiapps.apps.c.d.aGi();
        com.baidu.tieba.aiapps.apps.invoice.model.b bVar2 = new com.baidu.tieba.aiapps.apps.invoice.model.b(j);
        HashMap hashMap = new HashMap();
        hashMap.put("data", bVar2.toJson().toString());
        a(aGi, hashMap, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.b>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: f */
            public com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.b> parseResponse(Response response, int i) throws Exception {
                com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.b> dVar = new com.baidu.tieba.aiapps.apps.invoice.model.d<>(new com.baidu.tieba.aiapps.apps.invoice.model.b());
                if (response != null && response.body() != null) {
                    dVar.bF(o.dP(response.body().string()));
                }
                return dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.d<com.baidu.tieba.aiapps.apps.invoice.model.b> dVar, int i) {
                if (bVar != null) {
                    if (!TextUtils.equals(dVar.dnS, "0") || dVar.dnU == null) {
                        d.this.a(dVar.dnS, dVar.dnT, bVar);
                    } else {
                        bVar.bM(dVar.dnU.mId);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (bVar != null) {
                    bVar.ci(LivenessStat.TYPE_STRING_DEFAULT, exc.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, c cVar) {
        if (cVar != null) {
            if (TextUtils.equals(str, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND)) {
                cVar.si(str2);
            } else {
                cVar.ci(str, str2);
            }
        }
    }

    private void a(String str, Map<String, String> map, ResponseCallback responseCallback) {
        if (!TextUtils.isEmpty(str)) {
            PostFormRequest.PostFormRequestBuilder postFormRequestBuilder = (PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(com.baidu.tieba.aiapps.apps.c.d.sh(str))).cookieManager(com.baidu.swan.apps.u.a.JG().Ke());
            if (map != null) {
                postFormRequestBuilder.params(map);
            }
            postFormRequestBuilder.build().executeAsyncOnUIBack(responseCallback);
        }
    }
}
