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
            a.azW().putBoolean(str, z);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), d.class, e.d(1, str, String.valueOf(z)));
        }
    }

    public static boolean getBoolean(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            return a.azW().getBoolean(str, z);
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
        public static final class C0232a {
            private static final a cWF = new a();
        }

        public static a azW() {
            return C0232a.cWF;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class e {
        final int aSW;
        final String aSX;
        final String aSY;

        e(int i, String str, String str2) {
            this.aSW = i;
            this.aSX = str;
            this.aSY = str2;
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
            return "SpMethodInfo{mDataType=" + this.aSW + ", mPrefName='" + this.aSX + "', mDataValue='" + this.aSY + "'}";
        }
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static abstract class AbstractC0233b extends ProviderDelegation {
        protected abstract Bundle a(e eVar);

        private AbstractC0233b() {
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
    public static class d extends AbstractC0233b {
        private d() {
            super();
        }

        @Override // com.baidu.tieba.aiapps.apps.o.b.AbstractC0233b
        protected Bundle a(e eVar) {
            switch (eVar.aSW) {
                case 1:
                    a.azW().putBoolean(eVar.aSX, Boolean.parseBoolean(eVar.aSY));
                    break;
            }
            return Bundle.EMPTY;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c extends AbstractC0233b {
        private c() {
            super();
        }

        @Override // com.baidu.tieba.aiapps.apps.o.b.AbstractC0233b
        protected Bundle a(e eVar) {
            Bundle bundle = new Bundle();
            switch (eVar.aSW) {
                case 1:
                    bundle.putBoolean("result_value", a.azW().getBoolean(eVar.aSX, Boolean.parseBoolean(eVar.aSY)));
                    break;
            }
            return bundle;
        }
    }
}
