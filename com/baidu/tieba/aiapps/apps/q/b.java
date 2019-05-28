package com.baidu.tieba.aiapps.apps.q;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
/* loaded from: classes4.dex */
public class b {
    public static void putBoolean(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            a.aGg().putBoolean(str, z);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), d.class, e.e(1, str, String.valueOf(z)));
        }
    }

    public static boolean getBoolean(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            return a.aGg().getBoolean(str, z);
        }
        return DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, e.e(1, str, String.valueOf(z))).mResult.getBoolean("result_value");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends com.baidu.swan.c.d {
        private a() {
            super("night_mode_prefs_name");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.baidu.tieba.aiapps.apps.q.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C0287a {
            private static final a dgd = new a();
        }

        public static a aGg() {
            return C0287a.dgd;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class e {
        final int aVQ;
        final String aVR;
        final String aVS;

        e(int i, String str, String str2) {
            this.aVQ = i;
            this.aVR = str;
            this.aVS = str2;
        }

        static e J(Bundle bundle) {
            if (bundle.isEmpty()) {
                return null;
            }
            return new e(bundle.getInt("bundle_data_type_key"), bundle.getString("bundle_prefs_key"), bundle.getString("bundle_data_value_key"));
        }

        static Bundle e(int i, String str, String str2) {
            Bundle bundle = new Bundle();
            bundle.putString("bundle_prefs_key", str);
            bundle.putInt("bundle_data_type_key", i);
            bundle.putString("bundle_data_value_key", str2);
            return bundle;
        }

        public String toString() {
            return "SpMethodInfo{mDataType=" + this.aVQ + ", mPrefName='" + this.aVR + "', mDataValue='" + this.aVS + "'}";
        }
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static abstract class AbstractC0288b extends ProviderDelegation {
        protected abstract Bundle a(e eVar);

        private AbstractC0288b() {
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
    public static class d extends AbstractC0288b {
        private d() {
            super();
        }

        @Override // com.baidu.tieba.aiapps.apps.q.b.AbstractC0288b
        protected Bundle a(e eVar) {
            switch (eVar.aVQ) {
                case 1:
                    a.aGg().putBoolean(eVar.aVR, Boolean.parseBoolean(eVar.aVS));
                    break;
            }
            return Bundle.EMPTY;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c extends AbstractC0288b {
        private c() {
            super();
        }

        @Override // com.baidu.tieba.aiapps.apps.q.b.AbstractC0288b
        protected Bundle a(e eVar) {
            Bundle bundle = new Bundle();
            switch (eVar.aVQ) {
                case 1:
                    bundle.putBoolean("result_value", a.aGg().getBoolean(eVar.aVR, Boolean.parseBoolean(eVar.aVS)));
                    break;
            }
            return bundle;
        }
    }
}
