package com.baidu.tieba.aiapps.apps.c;

import android.content.Context;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Request;
/* loaded from: classes4.dex */
public class b extends com.baidu.swan.apps.u.b.a {
    private String aFQ() {
        return d.deS;
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String wP() {
        return "tiebaclient";
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String getHostName() {
        return "tieba";
    }

    @Override // com.baidu.swan.apps.b.b.f
    public boolean wQ() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String wR() {
        return d.ty(String.format("%s/ma/reset", aFQ()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String wS() {
        return d.ty(String.format("%s/ma/update", aFQ()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String wW() {
        return "flFqXclepWs7RdugAszy9eERL7G5dS0I";
    }

    private Request i(String str, Map<String, String> map) {
        HttpUrl parse = HttpUrl.parse(aFQ());
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments(str);
        for (Map.Entry<String, String> entry : com.baidu.tieba.aiapps.apps.j.a.aHB().diR.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        Request.Builder builder = new Request.Builder();
        builder.url(d.ty(build.toString()));
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
    public String wY() {
        return "MEwwDQYJKoZIhvcNAQEBBQADOwAwOAIxAMrOpIWOfuGDG1bjUXV5aPU5UQr0vmOqJif4uJC+7/2B9Nm27SEGINei70QIW4x/vwIDAQAB";
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String xa() {
        return d.ty(String.format("%s/ma/game/rest/check_is_user_advised_to_rest", aFQ()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String xb() {
        return d.ty(String.format("%s/ma/game/od/get_user_info", aFQ()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String xc() {
        return d.ty(String.format("%s/ma/game/od/remove_user_cloud_storage", aFQ()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String xd() {
        return d.ty(String.format("%s/ma/game/od/get_user_cloud_storage", aFQ()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String xe() {
        return d.ty(String.format("%s/ma/game/od/set_user_cloud_storage", aFQ()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String xf() {
        return d.ty(String.format("%s/ma/game/od/get_friend_cloud_storage", aFQ()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String xg() {
        return d.ty(String.format("%s/ma/game/od/get_follow_cloud_storage", aFQ()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String xh() {
        return d.ty(String.format("%s/api/exchange/list", a.aFP()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String xi() {
        return d.ty(String.format("%s/api/exchange/transfer_report", a.aFP()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String xj() {
        return d.ty(String.format("%s/api/subscribe/v1/relation/get", aFQ()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String xk() {
        return d.ty(String.format("%s/api/subscribe/v1/relation/receive", aFQ()));
    }
}
