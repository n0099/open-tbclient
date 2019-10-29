package com.baidu.tieba.aiapps.apps.p;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
/* loaded from: classes4.dex */
public class b {
    public static void putBoolean(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            a.aIs().putBoolean(str, z);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), d.class, e.f(1, str, String.valueOf(z)));
        }
    }

    public static boolean getBoolean(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            return a.aIs().getBoolean(str, z);
        }
        return DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, e.f(1, str, String.valueOf(z))).mResult.getBoolean("result_value");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends com.baidu.swan.c.d {
        private a() {
            super("night_mode_prefs_name");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.baidu.tieba.aiapps.apps.p.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C0331a {
            private static final a dsX = new a();
        }

        public static a aIs() {
            return C0331a.dsX;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class e {
        final int bqb;
        final String bqc;
        final String bqd;

        e(int i, String str, String str2) {
            this.bqb = i;
            this.bqc = str;
            this.bqd = str2;
        }

        static e J(Bundle bundle) {
            if (bundle.isEmpty()) {
                return null;
            }
            return new e(bundle.getInt("bundle_data_type_key"), bundle.getString("bundle_prefs_key"), bundle.getString("bundle_data_value_key"));
        }

        static Bundle f(int i, String str, String str2) {
            Bundle bundle = new Bundle();
            bundle.putString("bundle_prefs_key", str);
            bundle.putInt("bundle_data_type_key", i);
            bundle.putString("bundle_data_value_key", str2);
            return bundle;
        }

        public String toString() {
            return "SpMethodInfo{mDataType=" + this.bqb + ", mPrefName='" + this.bqc + "', mDataValue='" + this.bqd + "'}";
        }
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static abstract class AbstractC0332b extends ProviderDelegation {
        protected abstract Bundle a(e eVar);

        private AbstractC0332b() {
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public final Bundle execCall(Bundle bundle) {
            if (bundle.isEmpty()) {
                return Bundle.EMPTY;
            }
            return a(e.J(bundle));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class d extends AbstractC0332b {
        private d() {
            super();
        }

        @Override // com.baidu.tieba.aiapps.apps.p.b.AbstractC0332b
        protected Bundle a(e eVar) {
            switch (eVar.bqb) {
                case 1:
                    a.aIs().putBoolean(eVar.bqc, Boolean.parseBoolean(eVar.bqd));
                    break;
            }
            return Bundle.EMPTY;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c extends AbstractC0332b {
        private c() {
            super();
        }

        @Override // com.baidu.tieba.aiapps.apps.p.b.AbstractC0332b
        protected Bundle a(e eVar) {
            Bundle bundle = new Bundle();
            switch (eVar.bqb) {
                case 1:
                    bundle.putBoolean("result_value", a.aIs().getBoolean(eVar.bqc, Boolean.parseBoolean(eVar.bqd)));
                    break;
            }
            return bundle;
        }
    }
}
