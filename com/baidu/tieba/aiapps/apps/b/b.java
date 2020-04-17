package com.baidu.tieba.aiapps.apps.b;

import android.content.Context;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Request;
/* loaded from: classes12.dex */
public class b extends com.baidu.swan.apps.w.b.a {
    private String bhU() {
        return d.bIa;
    }

    @Override // com.baidu.swan.apps.w.b.a, com.baidu.swan.apps.adaptation.a.o
    public boolean PK() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String PL() {
        return d.processCommonParams(String.format("%s/ma/reset", bhU()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String PM() {
        return d.processCommonParams(String.format("%s/ma/update", bhU()));
    }

    @Override // com.baidu.swan.apps.w.b.a, com.baidu.swan.apps.adaptation.a.o
    public String PR() {
        return "flFqXclepWs7RdugAszy9eERL7G5dS0I";
    }

    private Request k(String str, Map<String, String> map) {
        HttpUrl parse = HttpUrl.parse(bhU());
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments(str);
        for (Map.Entry<String, String> entry : com.baidu.tieba.aiapps.apps.h.a.biQ().bHZ.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        Request.Builder builder = new Request.Builder();
        builder.url(d.processCommonParams(build.toString()));
        builder.post(com.baidu.swan.apps.setting.oauth.c.n(map));
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
    public String PU() {
        return d.processCommonParams(String.format("%s/ma/game/rest/check_is_user_advised_to_rest", bhU()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String PV() {
        return d.processCommonParams(String.format("%s/ma/game/od/get_user_info", bhU()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String PW() {
        return d.processCommonParams(String.format("%s/ma/game/od/remove_user_cloud_storage", bhU()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String PX() {
        return d.processCommonParams(String.format("%s/ma/game/od/get_user_cloud_storage", bhU()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String PY() {
        return d.processCommonParams(String.format("%s/ma/game/od/set_user_cloud_storage", bhU()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String PZ() {
        return d.processCommonParams(String.format("%s/ma/game/od/get_friend_cloud_storage", bhU()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Qa() {
        return d.processCommonParams(String.format("%s/api/exchange/list", a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Qb() {
        return d.processCommonParams(String.format("%s/api/exchange/transfer_report", a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.w.b.a, com.baidu.swan.apps.adaptation.a.o
    public String Qc() {
        return d.processCommonParams(String.format("%s/api/subscribe/v1/relation/get", bhU()));
    }

    @Override // com.baidu.swan.apps.w.b.a, com.baidu.swan.apps.adaptation.a.o
    public String Qd() {
        return d.processCommonParams(String.format("%s/api/subscribe/v1/relation/receive", bhU()));
    }

    @Override // com.baidu.swan.apps.w.b.a, com.baidu.swan.apps.adaptation.a.o
    public String Qe() {
        return d.processCommonParams(String.format("%s/api/msgame/adblock", a.getGameServerHost()));
    }
}
