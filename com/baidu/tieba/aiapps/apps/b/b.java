package com.baidu.tieba.aiapps.apps.b;

import android.content.Context;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Request;
/* loaded from: classes12.dex */
public class b extends com.baidu.swan.apps.w.b.a {
    private String aZL() {
        return d.bjE;
    }

    @Override // com.baidu.swan.apps.w.b.a, com.baidu.swan.apps.adaptation.a.o
    public boolean HV() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String HW() {
        return d.processCommonParams(String.format("%s/ma/reset", aZL()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String HX() {
        return d.processCommonParams(String.format("%s/ma/update", aZL()));
    }

    @Override // com.baidu.swan.apps.w.b.a, com.baidu.swan.apps.adaptation.a.o
    public String Ic() {
        return "flFqXclepWs7RdugAszy9eERL7G5dS0I";
    }

    private Request j(String str, Map<String, String> map) {
        HttpUrl parse = HttpUrl.parse(aZL());
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments(str);
        for (Map.Entry<String, String> entry : com.baidu.tieba.aiapps.apps.h.a.baI().bjD.entrySet()) {
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
        return j("ma/login", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public Request e(Context context, Map<String, String> map) {
        return j("ma/accredit_data", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public Request f(Context context, Map<String, String> map) {
        return j("ma/accredit_v1", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public Request g(Context context, Map<String, String> map) {
        return j("ma/user/checksessionkey", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public Request h(Context context, Map<String, String> map) {
        return j("ma/user/swanid", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public Request i(Context context, Map<String, String> map) {
        return j("ma/open/data", map);
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String If() {
        return d.processCommonParams(String.format("%s/ma/game/rest/check_is_user_advised_to_rest", aZL()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Ig() {
        return d.processCommonParams(String.format("%s/ma/game/od/get_user_info", aZL()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Ih() {
        return d.processCommonParams(String.format("%s/ma/game/od/remove_user_cloud_storage", aZL()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Ii() {
        return d.processCommonParams(String.format("%s/ma/game/od/get_user_cloud_storage", aZL()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Ij() {
        return d.processCommonParams(String.format("%s/ma/game/od/set_user_cloud_storage", aZL()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Ik() {
        return d.processCommonParams(String.format("%s/ma/game/od/get_friend_cloud_storage", aZL()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Il() {
        return d.processCommonParams(String.format("%s/api/exchange/list", a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.adaptation.a.o
    public String Im() {
        return d.processCommonParams(String.format("%s/api/exchange/transfer_report", a.getGameServerHost()));
    }

    @Override // com.baidu.swan.apps.w.b.a, com.baidu.swan.apps.adaptation.a.o
    public String In() {
        return d.processCommonParams(String.format("%s/api/subscribe/v1/relation/get", aZL()));
    }

    @Override // com.baidu.swan.apps.w.b.a, com.baidu.swan.apps.adaptation.a.o
    public String Io() {
        return d.processCommonParams(String.format("%s/api/subscribe/v1/relation/receive", aZL()));
    }

    @Override // com.baidu.swan.apps.w.b.a, com.baidu.swan.apps.adaptation.a.o
    public String Ip() {
        return d.processCommonParams(String.format("%s/api/msgame/adblock", a.getGameServerHost()));
    }
}
