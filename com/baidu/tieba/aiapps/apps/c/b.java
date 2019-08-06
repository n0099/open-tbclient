package com.baidu.tieba.aiapps.apps.c;

import android.content.Context;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Request;
/* loaded from: classes4.dex */
public class b extends com.baidu.swan.apps.u.b.a {
    private String aFm() {
        return d.ddf;
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String wL() {
        return "tiebaclient";
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String getHostName() {
        return "tieba";
    }

    @Override // com.baidu.swan.apps.b.b.f
    public boolean wM() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String wN() {
        return d.sZ(String.format("%s/ma/reset", aFm()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String wO() {
        return d.sZ(String.format("%s/ma/update", aFm()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String wS() {
        return "flFqXclepWs7RdugAszy9eERL7G5dS0I";
    }

    private Request i(String str, Map<String, String> map) {
        HttpUrl parse = HttpUrl.parse(aFm());
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments(str);
        for (Map.Entry<String, String> entry : com.baidu.tieba.aiapps.apps.j.a.aGX().dhg.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        Request.Builder builder = new Request.Builder();
        builder.url(d.sZ(build.toString()));
        builder.post(com.baidu.swan.apps.setting.oauth.c.n(map));
        return builder.build();
    }

    @Override // com.baidu.swan.apps.b.b.f
    public Request d(Context context, Map<String, String> map) {
        return i("ma/login", map);
    }

    @Override // com.baidu.swan.apps.b.b.f
    public Request e(Context context, Map<String, String> map) {
        return i("ma/accredit_data", map);
    }

    @Override // com.baidu.swan.apps.b.b.f
    public Request f(Context context, Map<String, String> map) {
        return i("ma/accredit_v1", map);
    }

    @Override // com.baidu.swan.apps.b.b.f
    public Request g(Context context, Map<String, String> map) {
        return i("ma/user/checksessionkey", map);
    }

    @Override // com.baidu.swan.apps.b.b.f
    public Request h(Context context, Map<String, String> map) {
        return i("ma/user/swanid", map);
    }

    @Override // com.baidu.swan.apps.b.b.f
    public Request i(Context context, Map<String, String> map) {
        return i("ma/open/data", map);
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String wU() {
        return "MEwwDQYJKoZIhvcNAQEBBQADOwAwOAIxAMrOpIWOfuGDG1bjUXV5aPU5UQr0vmOqJif4uJC+7/2B9Nm27SEGINei70QIW4x/vwIDAQAB";
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String wW() {
        return d.sZ(String.format("%s/ma/game/rest/check_is_user_advised_to_rest", aFm()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String wX() {
        return d.sZ(String.format("%s/ma/game/od/get_user_info", aFm()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String wY() {
        return d.sZ(String.format("%s/ma/game/od/remove_user_cloud_storage", aFm()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String wZ() {
        return d.sZ(String.format("%s/ma/game/od/get_user_cloud_storage", aFm()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String xa() {
        return d.sZ(String.format("%s/ma/game/od/set_user_cloud_storage", aFm()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String xb() {
        return d.sZ(String.format("%s/ma/game/od/get_friend_cloud_storage", aFm()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String xc() {
        return d.sZ(String.format("%s/ma/game/od/get_follow_cloud_storage", aFm()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String xd() {
        return d.sZ(String.format("%s/api/exchange/list", a.aFl()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String xe() {
        return d.sZ(String.format("%s/api/exchange/transfer_report", a.aFl()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String xf() {
        return d.sZ(String.format("%s/api/subscribe/v1/relation/get", aFm()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String xg() {
        return d.sZ(String.format("%s/api/subscribe/v1/relation/receive", aFm()));
    }
}
