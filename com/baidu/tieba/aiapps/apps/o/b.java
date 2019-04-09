package com.baidu.tieba.aiapps.apps.o;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
/* loaded from: classes4.dex */
public class b {
    public static void putBoolean(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            a.azS().putBoolean(str, z);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), d.class, e.d(1, str, String.valueOf(z)));
        }
    }

    public static boolean getBoolean(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            return a.azS().getBoolean(str, z);
        }
        return DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, e.d(1, str, String.valueOf(z))).mResult.getBoolean("result_value");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends com.baidu.swan.c.d {
        private a() {
            super("night_mode_prefs_name");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.baidu.tieba.aiapps.apps.o.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C0271a {
            private static final a cWE = new a();
        }

        public static a azS() {
            return C0271a.cWE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class e {
        final int aTb;
        final String aTc;
        final String aTd;

        e(int i, String str, String str2) {
            this.aTb = i;
            this.aTc = str;
            this.aTd = str2;
        }

        static e I(Bundle bundle) {
            if (bundle.isEmpty()) {
                return null;
            }
            return new e(bundle.getInt("bundle_data_type_key"), bundle.getString("bundle_prefs_key"), bundle.getString("bundle_data_value_key"));
        }

        static Bundle d(int i, String str, String str2) {
            Bundle bundle = new Bundle();
            bundle.putString("bundle_prefs_key", str);
            bundle.putInt("bundle_data_type_key", i);
            bundle.putString("bundle_data_value_key", str2);
            return bundle;
        }

        public String toString() {
            return "SpMethodInfo{mDataType=" + this.aTb + ", mPrefName='" + this.aTc + "', mDataValue='" + this.aTd + "'}";
        }
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static abstract class AbstractC0272b extends ProviderDelegation {
        protected abstract Bundle a(e eVar);

        private AbstractC0272b() {
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public final Bundle execCall(Bundle bundle) {
            if (bundle.isEmpty()) {
                return Bundle.EMPTY;
            }
            return a(e.I(bundle));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class d extends AbstractC0272b {
        private d() {
            super();
        }

        @Override // com.baidu.tieba.aiapps.apps.o.b.AbstractC0272b
        protected Bundle a(e eVar) {
            switch (eVar.aTb) {
                case 1:
                    a.azS().putBoolean(eVar.aTc, Boolean.parseBoolean(eVar.aTd));
                    break;
            }
            return Bundle.EMPTY;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c extends AbstractC0272b {
        private c() {
            super();
        }

        @Override // com.baidu.tieba.aiapps.apps.o.b.AbstractC0272b
        protected Bundle a(e eVar) {
            Bundle bundle = new Bundle();
            switch (eVar.aTb) {
                case 1:
                    bundle.putBoolean("result_value", a.azS().getBoolean(eVar.aTc, Boolean.parseBoolean(eVar.aTd)));
                    break;
            }
            return bundle;
        }
    }
}
