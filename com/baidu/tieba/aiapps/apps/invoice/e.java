package com.baidu.tieba.aiapps.apps.invoice;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.ng.ai.apps.aps.AiAppsApsUtils;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.media.audio.AiAppsAudioPlayer;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthDef;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthUtils;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import com.baidu.tieba.aiapps.apps.invoice.d;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    private static e bCA;
    private com.google.gson.d bCB = new com.google.gson.d();

    private e() {
    }

    public static e Xj() {
        if (bCA == null) {
            synchronized (e.class) {
                if (bCA == null) {
                    bCA = new e();
                }
            }
        }
        return bCA;
    }

    public void a(InvoiceInfo invoiceInfo, final d.a aVar) {
        if (invoiceInfo != null) {
            String Xd = com.baidu.tieba.aiapps.apps.d.c.Xd();
            HashMap hashMap = new HashMap();
            hashMap.put("data", this.bCB.toJson(invoiceInfo));
            a(Xd, hashMap, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.c<InvoiceInfo>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: b */
                public com.baidu.tieba.aiapps.apps.invoice.model.c<InvoiceInfo> parseResponse(Response response, int i) throws Exception {
                    if (response == null || response.body() == null) {
                        return null;
                    }
                    return (com.baidu.tieba.aiapps.apps.invoice.model.c) e.this.c(response.body().string(), new com.google.gson.b.a<com.baidu.tieba.aiapps.apps.invoice.model.c<InvoiceInfo>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.e.1.1
                    }.bZr());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: a */
                public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.c<InvoiceInfo> cVar, int i) {
                    if (aVar != null) {
                        if (!TextUtils.equals(cVar.bCV, "0") || cVar.mData == null) {
                            e.this.a(cVar.bCV, cVar.bCW, aVar);
                        } else {
                            aVar.a(cVar.mData);
                        }
                    }
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                    if (aVar != null) {
                        aVar.aU(AiAppsAudioPlayer.ERROR_UNKNOWN, exc.getMessage());
                    }
                }
            });
        }
    }

    public void a(Context context, final String str, final String str2, final d.c cVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (cVar != null) {
                cVar.aU(AiAppsAudioPlayer.ERROR_UNKNOWN, "");
                return;
            }
            return;
        }
        AiAppsRuntime.getAiAppAccountRuntime().getTplStoken((Activity) context, new TypedCallback<Bundle>() { // from class: com.baidu.tieba.aiapps.apps.invoice.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
            public void onCallback(Bundle bundle) {
                if (bundle != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("ma_id", str);
                        jSONObject.put(AiAppsApsUtils.APP_KEY, str2);
                        jSONObject.put("host_pkgname", OAuthUtils.getAppContext().getPackageName());
                        jSONObject.put("host_key_hash", OAuthUtils.getKeyHash());
                        jSONObject.put("host_api_key", AiAppsRuntime.getAiAppAccountRuntime().getHostApiKey());
                        jSONObject.put(ISapiAccount.SAPI_ACCOUNT_STOKEN, bundle.getString(OAuthDef.TPL, ""));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", jSONObject.toString());
                    e.this.a(com.baidu.tieba.aiapps.apps.d.c.Xc(), hashMap, cVar);
                } else if (cVar != null) {
                    cVar.aU(AiAppsAudioPlayer.ERROR_UNKNOWN, "");
                }
            }
        }, OAuthDef.TPL);
    }

    public void a(d.c cVar) {
        a(com.baidu.tieba.aiapps.apps.d.c.Xb(), (Map<String, String>) null, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Map<String, String> map, final d.c cVar) {
        a(str, map, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.c<com.baidu.tieba.aiapps.apps.invoice.model.a>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public com.baidu.tieba.aiapps.apps.invoice.model.c<com.baidu.tieba.aiapps.apps.invoice.model.a> parseResponse(Response response, int i) throws Exception {
                if (response == null || response.body() == null) {
                    return null;
                }
                return (com.baidu.tieba.aiapps.apps.invoice.model.c) e.this.c(response.body().string(), new com.google.gson.b.a<com.baidu.tieba.aiapps.apps.invoice.model.c<com.baidu.tieba.aiapps.apps.invoice.model.a>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.e.3.1
                }.bZr());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.c<com.baidu.tieba.aiapps.apps.invoice.model.a> cVar2, int i) {
                if (cVar != null) {
                    if (!TextUtils.equals(cVar2.bCV, "0") || cVar2.mData == null) {
                        e.this.a(cVar2.bCV, cVar2.bCW, cVar);
                    } else {
                        cVar.ar(cVar2.mData.bCP);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (cVar != null) {
                    cVar.aU(AiAppsAudioPlayer.ERROR_UNKNOWN, exc.getMessage());
                }
            }
        });
    }

    public void a(InvoiceInfo invoiceInfo, final d.e eVar) {
        String WY = com.baidu.tieba.aiapps.apps.d.c.WY();
        HashMap hashMap = new HashMap();
        hashMap.put("data", this.bCB.toJson(invoiceInfo));
        a(WY, hashMap, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.c<InvoiceInfo>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.e.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public com.baidu.tieba.aiapps.apps.invoice.model.c<InvoiceInfo> parseResponse(Response response, int i) throws Exception {
                if (response == null || response.body() == null) {
                    return null;
                }
                return (com.baidu.tieba.aiapps.apps.invoice.model.c) e.this.c(response.body().string(), new com.google.gson.b.a<com.baidu.tieba.aiapps.apps.invoice.model.c<InvoiceInfo>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.e.4.1
                }.bZr());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.c<InvoiceInfo> cVar, int i) {
                if (eVar != null) {
                    if (!TextUtils.equals(cVar.bCV, "0") || cVar.mData == null) {
                        e.this.a(cVar.bCV, cVar.bCW, eVar);
                    } else {
                        eVar.b(cVar.mData);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (eVar != null) {
                    eVar.aU(AiAppsAudioPlayer.ERROR_UNKNOWN, exc.getMessage());
                }
            }
        });
    }

    public void a(final long j, final d.InterfaceC0163d interfaceC0163d) {
        String WZ = com.baidu.tieba.aiapps.apps.d.c.WZ();
        com.baidu.tieba.aiapps.apps.invoice.model.b bVar = new com.baidu.tieba.aiapps.apps.invoice.model.b(j);
        HashMap hashMap = new HashMap();
        hashMap.put("data", this.bCB.toJson(bVar));
        a(WZ, hashMap, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.c>() { // from class: com.baidu.tieba.aiapps.apps.invoice.e.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public com.baidu.tieba.aiapps.apps.invoice.model.c parseResponse(Response response, int i) throws Exception {
                if (response == null || response.body() == null) {
                    return null;
                }
                return (com.baidu.tieba.aiapps.apps.invoice.model.c) e.this.c(response.body().string(), new com.google.gson.b.a<com.baidu.tieba.aiapps.apps.invoice.model.c>() { // from class: com.baidu.tieba.aiapps.apps.invoice.e.5.1
                }.bZr());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.c cVar, int i) {
                if (interfaceC0163d != null) {
                    if (!TextUtils.equals(cVar.bCV, "0")) {
                        e.this.a(cVar.bCV, cVar.bCW, interfaceC0163d);
                    } else {
                        interfaceC0163d.aU(j);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (interfaceC0163d != null) {
                    interfaceC0163d.aU(AiAppsAudioPlayer.ERROR_UNKNOWN, exc.getMessage());
                }
            }
        });
    }

    public void a(long j, final d.b bVar) {
        String Xa = com.baidu.tieba.aiapps.apps.d.c.Xa();
        com.baidu.tieba.aiapps.apps.invoice.model.b bVar2 = new com.baidu.tieba.aiapps.apps.invoice.model.b(j);
        HashMap hashMap = new HashMap();
        hashMap.put("data", this.bCB.toJson(bVar2));
        a(Xa, hashMap, new ResponseCallback<com.baidu.tieba.aiapps.apps.invoice.model.c<com.baidu.tieba.aiapps.apps.invoice.model.b>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.e.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public com.baidu.tieba.aiapps.apps.invoice.model.c<com.baidu.tieba.aiapps.apps.invoice.model.b> parseResponse(Response response, int i) throws Exception {
                if (response == null || response.body() == null) {
                    return null;
                }
                return (com.baidu.tieba.aiapps.apps.invoice.model.c) e.this.c(response.body().string(), new com.google.gson.b.a<com.baidu.tieba.aiapps.apps.invoice.model.c<com.baidu.tieba.aiapps.apps.invoice.model.b>>() { // from class: com.baidu.tieba.aiapps.apps.invoice.e.6.1
                }.bZr());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.tieba.aiapps.apps.invoice.model.c<com.baidu.tieba.aiapps.apps.invoice.model.b> cVar, int i) {
                if (bVar != null) {
                    if (!TextUtils.equals(cVar.bCV, "0") || cVar.mData == null) {
                        e.this.a(cVar.bCV, cVar.bCW, bVar);
                    } else {
                        bVar.aT(cVar.mData.mId);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (bVar != null) {
                    bVar.aU(AiAppsAudioPlayer.ERROR_UNKNOWN, exc.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, d dVar) {
        if (dVar != null) {
            if (TextUtils.equals(str, "401")) {
                dVar.kd(str2);
            } else {
                dVar.aU(str, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> T c(String str, Type type) {
        if (TextUtils.isEmpty(str) || type == null) {
            return null;
        }
        try {
            return (T) this.bCB.d(str, type);
        } catch (Exception e) {
            return null;
        }
    }

    private void a(String str, Map<String, String> map, ResponseCallback responseCallback) {
        if (!TextUtils.isEmpty(str)) {
            PostFormRequest.PostFormRequestBuilder postFormRequestBuilder = (PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(com.baidu.tieba.aiapps.apps.d.c.kc(str))).cookieManager(AiAppsRuntime.getConfigRuntime().getCookieManager(false, false));
            if (map != null) {
                postFormRequestBuilder.params(map);
            }
            postFormRequestBuilder.build().executeAsyncOnUIBack(responseCallback);
        }
    }
}
