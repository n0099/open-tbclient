package com.baidu.tieba.aiapps.apps.d;

import android.content.Context;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Request;
/* loaded from: classes4.dex */
public class b extends com.baidu.swan.apps.u.b.a {
    private String aDR() {
        return d.dbv;
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String wk() {
        return "tiebaclient";
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String getHostName() {
        return "tieba";
    }

    @Override // com.baidu.swan.apps.b.b.f
    public boolean wl() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String wm() {
        return d.sH(String.format("%s/ma/reset", aDR()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String wn() {
        return d.sH(String.format("%s/ma/update", aDR()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String wr() {
        return "flFqXclepWs7RdugAszy9eERL7G5dS0I";
    }

    private Request i(String str, Map<String, String> map) {
        HttpUrl parse = HttpUrl.parse(aDR());
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments(str);
        for (Map.Entry<String, String> entry : com.baidu.tieba.aiapps.apps.k.a.aFw().dfu.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        Request.Builder builder = new Request.Builder();
        builder.url(d.sH(build.toString()));
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
    public String wt() {
        return "MEwwDQYJKoZIhvcNAQEBBQADOwAwOAIxAMrOpIWOfuGDG1bjUXV5aPU5UQr0vmOqJif4uJC+7/2B9Nm27SEGINei70QIW4x/vwIDAQAB";
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String wv() {
        return d.sH(String.format("%s/ma/game/rest/check_is_user_advised_to_rest", aDR()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String ww() {
        return d.sH(String.format("%s/ma/game/od/get_user_info", aDR()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String wx() {
        return d.sH(String.format("%s/ma/game/od/remove_user_cloud_storage", aDR()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String wy() {
        return d.sH(String.format("%s/ma/game/od/get_user_cloud_storage", aDR()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String wz() {
        return d.sH(String.format("%s/ma/game/od/set_user_cloud_storage", aDR()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String wA() {
        return d.sH(String.format("%s/ma/game/od/get_friend_cloud_storage", aDR()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String wB() {
        return d.sH(String.format("%s/ma/game/od/get_follow_cloud_storage", aDR()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String wC() {
        return d.sH(String.format("%s/api/exchange/list", a.aDQ()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String wD() {
        return d.sH(String.format("%s/api/exchange/transfer_report", a.aDQ()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String wE() {
        return d.sH(String.format("%s/api/subscribe/v1/relation/get", aDR()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String wF() {
        return d.sH(String.format("%s/api/subscribe/v1/relation/receive", aDR()));
    }
}
