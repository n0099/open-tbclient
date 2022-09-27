package com.baidu.tieba;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.tieba.t93;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes3.dex */
public class dc3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static Set<String> b;
    public static int c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;

        public a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                t93.b bVar = new t93.b(10010);
                bVar.l(String.valueOf(dc3.c));
                bVar.k(this.a);
                bVar.j(String.valueOf(this.b));
                bVar.h(l33.g0());
                bVar.m();
                if (this.b == 3) {
                    int unused = dc3.c = 0;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements un3<Pair<String, File>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(dc3 dc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dc3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.un3
        /* renamed from: a */
        public void run(@NonNull Pair<String, File> pair) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pair) == null) {
                if (dc3.b != null && pair.first != null && dc3.b.contains(pair.first)) {
                    new cc3(sm2.c(), pair.first).clearAll();
                    return;
                }
                File file = pair.second;
                if (file != null) {
                    pj4.L(file);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Callable<SharedPreferences> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cc3 a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;
        public final /* synthetic */ dc3 e;

        public c(dc3 dc3Var, cc3 cc3Var, long j, Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dc3Var, cc3Var, Long.valueOf(j), context, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = dc3Var;
            this.a = cc3Var;
            this.b = j;
            this.c = context;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public SharedPreferences call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.setCustomMeta(this.b | 1)) {
                    String l = this.e.l(this.c, this.d);
                    if (dc3.a) {
                        Log.i("SwanExtensionApiImpl", String.format("customMeta=%d, name=%s, spName=%s", Long.valueOf(this.b), this.d, l));
                    }
                    if (l == null) {
                        return null;
                    }
                    return this.c.getSharedPreferences(l, 0);
                }
                return null;
            }
            return (SharedPreferences) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final dc3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-866347339, "Lcom/baidu/tieba/dc3$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-866347339, "Lcom/baidu/tieba/dc3$d;");
                    return;
                }
            }
            a = new dc3(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947699701, "Lcom/baidu/tieba/dc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947699701, "Lcom/baidu/tieba/dc3;");
                return;
            }
        }
        a = vj1.a;
        b = new CopyOnWriteArraySet();
        c = 0;
    }

    public /* synthetic */ dc3(a aVar) {
        this();
    }

    @AnyThread
    public static void i(int i, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65544, null, i, str) == null) {
            fg3.f().execute(new a(str, i));
        }
    }

    public static dc3 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? d.a : (dc3) invokeV.objValue;
    }

    public final nj4 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? new vj4(str) : (nj4) invokeL.objValue;
    }

    public void g(@NonNull String str, Set<String> set, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, set, z) == null) {
            h(str, set, z);
            wb2.c(new File(cc3.e()), str, SwanKV.PREFS_SUFFIX, set, z, new b(this));
        }
    }

    public void h(@NonNull String str, Set<String> set, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, str, set, z) == null) {
            wb2.b(new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/"), str, ActivityChooserModel.HISTORY_FILE_EXTENSION, set, z);
        }
    }

    @NonNull
    @AnyThread
    public nj4 k(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, context, str, z)) == null) {
            try {
                cc3 cc3Var = new cc3(context, str, z ? 2 : 1);
                b.add(str);
                m(context, str, cc3Var);
                if (c > 0) {
                    i(3, str);
                }
                return cc3Var;
            } catch (NoClassDefFoundError | UnsatisfiedLinkError e) {
                if (a) {
                    Log.e("SwanExtensionApiImpl", "getSharedPrefsImpl", e);
                }
                c++;
                i(2, str);
                return f(str);
            }
        }
        return (nj4) invokeLLZ.objValue;
    }

    @Nullable
    public final String l(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, str)) == null) {
            if (str == null) {
                str = context.getPackageName() + "_preferences";
            }
            if ("default".equals(str)) {
                if (vj4.e(context, str).exists()) {
                    return str;
                }
                str = context.getPackageName() + "_preferences";
            }
            if (vj4.e(context, str).exists()) {
                return str;
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public final void m(Context context, String str, @NonNull cc3 cc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, context, str, cc3Var) == null) {
            long customMeta = cc3Var.getCustomMeta();
            if ((customMeta & 1) == 1) {
                return;
            }
            cc3Var.d(new c(this, cc3Var, customMeta, context, str));
        }
    }

    public dc3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
