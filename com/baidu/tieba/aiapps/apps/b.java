package com.baidu.tieba.aiapps.apps;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.b.a.b;
import com.baidu.swan.apps.setting.a.g;
import com.baidu.swan.apps.setting.oauth.a.e;
import com.baidu.swan.apps.setting.oauth.a.f;
/* loaded from: classes4.dex */
public class b implements b.c {
    @Override // com.baidu.swan.apps.b.a.b.c
    public com.baidu.swan.apps.b.b.b uV() {
        return new a();
    }

    public static void axQ() {
        com.baidu.swan.apps.b.a.b.a(new b());
    }

    /* loaded from: classes4.dex */
    private static class a implements com.baidu.swan.apps.b.b.b {
        private a() {
        }

        @Override // com.baidu.swan.apps.b.b.b
        @NonNull
        public com.baidu.swan.apps.setting.oauth.a.a a(Activity activity, boolean z, String str) {
            return new com.baidu.swan.apps.q.a.b.a.a(activity, z, str);
        }

        @Override // com.baidu.swan.apps.b.b.b
        @NonNull
        public com.baidu.swan.apps.setting.oauth.a.b a(Activity activity, boolean z, String str, boolean z2) {
            return new com.baidu.swan.apps.q.a.b.a.b(activity, z, str, z2);
        }

        @Override // com.baidu.swan.apps.b.b.b
        @NonNull
        public e a(Activity activity, g.a aVar, Bundle bundle) {
            return new com.baidu.swan.apps.q.a.b.a.e(activity, aVar, bundle);
        }

        @Override // com.baidu.swan.apps.b.b.b
        @NonNull
        public com.baidu.swan.apps.setting.oauth.a.c c(Activity activity, String str) {
            return new com.baidu.swan.apps.q.a.b.a.c(activity, str);
        }

        @Override // com.baidu.swan.apps.b.b.b
        @NonNull
        public com.baidu.swan.apps.setting.oauth.a.d u(Activity activity) {
            return new com.baidu.swan.apps.q.a.b.a.d(activity);
        }

        @Override // com.baidu.swan.apps.b.b.b
        @NonNull
        public f b(Activity activity, String str, String str2) {
            return new com.baidu.swan.apps.q.a.b.a.f(activity, str, str2);
        }
    }
}
