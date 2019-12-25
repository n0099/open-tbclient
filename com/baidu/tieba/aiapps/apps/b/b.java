package com.baidu.tieba.aiapps.apps.b;

import android.content.Context;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Request;
/* loaded from: classes9.dex */
public class b extends com.baidu.swan.apps.w.b.a {
    private String aXa() {
        return d.beA;
    }

    @Override // com.baidu.swan.apps.w.b.a, com.baidu.swan.apps.adaptation.a.o
    public boolean Fi() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Fj() {
        return d.processCommonParams(String.format("%s/ma/reset", aXa()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Fk() {
        return d.processCommonParams(String.format("%s/ma/update", aXa()));
    }

    @Override // com.baidu.swan.apps.w.b.a, com.baidu.swan.apps.adaptation.a.o
    public String Fp() {
        return "flFqXclepWs7RdugAszy9eERL7G5dS0I";
    }

    private Request k(String str, Map<String, String> map) {
        HttpUrl parse = HttpUrl.parse(aXa());
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments(str);
        for (Map.Entry<String, String> entry : com.baidu.tieba.aiapps.apps.h.a.aXX().bez.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        Request.Builder builder = new Request.Builder();
        builder.url(d.processCommonParams(build.toString()));
        builder.post(com.baidu.swan.apps.setting.oauth.c.p(map));
        return builder.build();
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public Request d(Context context, Map<String, String> map) {
        return k("ma/login", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public Request e(Context context, Map<String, String> map) {
        return k("ma/accredit_data", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public Request f(Context context, Map<String, String> map) {
        return k("ma/accredit_v1", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public Request g(Context context, Map<String, String> map) {
        return k("ma/user/checksessionkey", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public Request h(Context context, Map<String, String> map) {
        return k("ma/user/swanid", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public Request i(Context context, Map<String, String> map) {
        return k("ma/open/data", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Fs() {
        return d.processCommonParams(String.format("%s/ma/game/rest/check_is_user_advised_to_rest", aXa()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Ft() {
        return d.processCommonParams(String.format("%s/ma/game/od/get_user_info", aXa()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Fu() {
        return d.processCommonParams(String.format("%s/ma/game/od/remove_user_cloud_storage", aXa()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Fv() {
        return d.processCommonParams(String.format("%s/ma/game/od/get_user_cloud_storage", aXa()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Fw() {
        return d.processCommonParams(String.format("%s/ma/game/od/set_user_cloud_storage", aXa()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Fx() {
        return d.processCommonParams(String.format("%s/ma/game/od/get_friend_cloud_storage", aXa()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Fy() {
        return d.processCommonParams(String.format("%s/api/exchange/list", a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Fz() {
        return d.processCommonParams(String.format("%s/api/exchange/transfer_report", a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.w.b.a, com.baidu.swan.apps.adaptation.a.o
    public String FA() {
        return d.processCommonParams(String.format("%s/api/subscribe/v1/relation/get", aXa()));
    }

    @Override // com.baidu.swan.apps.w.b.a, com.baidu.swan.apps.adaptation.a.o
    public String FB() {
        return d.processCommonParams(String.format("%s/api/subscribe/v1/relation/receive", aXa()));
    }

    @Override // com.baidu.swan.apps.w.b.a, com.baidu.swan.apps.adaptation.a.o
    public String FC() {
        return d.processCommonParams(String.format("%s/api/msgame/adblock", a.getGameServerHost()));
    }
}
