package com.baidu.tieba.aiapps.apps.c;

import android.content.Context;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Request;
/* loaded from: classes4.dex */
public class b extends com.baidu.swan.apps.u.b.a {
    @Override // com.baidu.swan.apps.u.b.a, com.baidu.swan.apps.b.b.f
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String vw() {
        return a.vw();
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String getHostName() {
        return a.getHostName();
    }

    @Override // com.baidu.swan.apps.b.b.f
    public boolean vx() {
        return false;
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String vy() {
        return d.ry(String.format("%s/ma/reset", d.getHost()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String vz() {
        return d.ry(String.format("%s/ma/update", d.getHost()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String vD() {
        return a.vD();
    }

    private Request j(String str, Map<String, String> map) {
        HttpUrl parse = HttpUrl.parse(d.getHost());
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments(str);
        for (Map.Entry<String, String> entry : com.baidu.tieba.aiapps.apps.i.a.azK().cVX.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        Request.Builder builder = new Request.Builder();
        builder.url(d.ry(build.toString()));
        builder.post(com.baidu.swan.apps.setting.oauth.c.n(map));
        return builder.build();
    }

    @Override // com.baidu.swan.apps.b.b.f
    public Request d(Context context, Map<String, String> map) {
        return j("ma/login", map);
    }

    @Override // com.baidu.swan.apps.b.b.f
    public Request e(Context context, Map<String, String> map) {
        return j("ma/accredit_data", map);
    }

    @Override // com.baidu.swan.apps.b.b.f
    public Request f(Context context, Map<String, String> map) {
        return j("ma/accredit_v1", map);
    }

    @Override // com.baidu.swan.apps.b.b.f
    public Request g(Context context, Map<String, String> map) {
        return j("ma/user/checksessionkey", map);
    }

    @Override // com.baidu.swan.apps.b.b.f
    public Request h(Context context, Map<String, String> map) {
        return j("ma/user/swanid", map);
    }

    @Override // com.baidu.swan.apps.b.b.f
    public Request i(Context context, Map<String, String> map) {
        return j("ma/open/data", map);
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String vF() {
        return a.vF();
    }

    @Override // com.baidu.swan.apps.u.b.a, com.baidu.swan.apps.b.b.f
    public String vO() {
        return String.format("%s/api/subscribe/v1/relation/get", d.getHost());
    }

    @Override // com.baidu.swan.apps.u.b.a, com.baidu.swan.apps.b.b.f
    public String vP() {
        return String.format("%s/api/subscribe/v1/relation/receive", d.getHost());
    }
}
