package com.baidu.tieba.aiapps.apps.c;

import android.content.Context;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Request;
/* loaded from: classes4.dex */
public class b extends com.baidu.swan.apps.u.b.a {
    private String aGb() {
        return d.dnv;
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String BK() {
        return "tiebaclient";
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String getHostName() {
        return "tieba";
    }

    @Override // com.baidu.swan.apps.b.b.f
    public boolean BL() {
        return isDebug();
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String BM() {
        return d.sh(String.format("%s/ma/reset", aGb()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String BN() {
        return d.sh(String.format("%s/ma/update", aGb()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String BR() {
        return "flFqXclepWs7RdugAszy9eERL7G5dS0I";
    }

    private Request i(String str, Map<String, String> map) {
        HttpUrl parse = HttpUrl.parse(aGb());
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments(str);
        for (Map.Entry<String, String> entry : com.baidu.tieba.aiapps.apps.j.a.aHM().drv.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        Request.Builder builder = new Request.Builder();
        builder.url(d.sh(build.toString()));
        builder.post(com.baidu.swan.apps.setting.oauth.c.o(map));
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
    public String BT() {
        return "MEwwDQYJKoZIhvcNAQEBBQADOwAwOAIxAMrOpIWOfuGDG1bjUXV5aPU5UQr0vmOqJif4uJC+7/2B9Nm27SEGINei70QIW4x/vwIDAQAB";
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String BV() {
        return d.sh(String.format("%s/ma/game/rest/check_is_user_advised_to_rest", aGb()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String BW() {
        return d.sh(String.format("%s/ma/game/od/get_user_info", aGb()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String BX() {
        return d.sh(String.format("%s/ma/game/od/remove_user_cloud_storage", aGb()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String BY() {
        return d.sh(String.format("%s/ma/game/od/get_user_cloud_storage", aGb()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String BZ() {
        return d.sh(String.format("%s/ma/game/od/set_user_cloud_storage", aGb()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String Ca() {
        return d.sh(String.format("%s/ma/game/od/get_friend_cloud_storage", aGb()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String Cb() {
        return d.sh(String.format("%s/ma/game/od/get_follow_cloud_storage", aGb()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String Cc() {
        return d.sh(String.format("%s/api/exchange/list", a.aGa()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String Cd() {
        return d.sh(String.format("%s/api/exchange/transfer_report", a.aGa()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String Ce() {
        return d.sh(String.format("%s/api/subscribe/v1/relation/get", aGb()));
    }

    @Override // com.baidu.swan.apps.b.b.f
    public String Cf() {
        return d.sh(String.format("%s/api/subscribe/v1/relation/receive", aGb()));
    }
}
