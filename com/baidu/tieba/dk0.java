package com.baidu.tieba;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class dk0 implements gk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final l11 a;

    /* loaded from: classes4.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public static gk0 a;
        public static final gk0 b;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public static class a implements gk0 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Throwable a;

            @Override // com.baidu.tieba.gk0
            public void b(HashMap<String, lk0> hashMap) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
                }
            }

            @Override // com.baidu.tieba.gk0
            public void c(x01 x01Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, x01Var) == null) {
                }
            }

            @Override // com.baidu.tieba.gk0
            public void update(x01 x01Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, x01Var) == null) {
                }
            }

            public a(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {th};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = th;
                if (this.a != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("v", "5.10.0.26");
                    hashMap.put("e", this.a.toString());
                    z01.b(new ClogBuilder().y(ClogBuilder.LogType.CHECK).k("12").l("4000").m(new JSONObject(hashMap).toString()));
                }
            }

            @Override // com.baidu.tieba.gk0
            public List<lk0> a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return new ArrayList();
                }
                return (List) invokeV.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-859048482, "Lcom/baidu/tieba/dk0$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-859048482, "Lcom/baidu/tieba/dk0$f;");
                    return;
                }
            }
            try {
                if (x31.b()) {
                    a = new dk0(null);
                } else {
                    a = b(null);
                }
            } catch (Throwable th) {
                a = b(th);
            }
            b = a;
        }

        public static gk0 b(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, th)) == null) {
                return new a(th);
            }
            return (gk0) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ dk0 b;

        public a(dk0 dk0Var, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk0Var, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dk0Var;
            this.a = set;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.a.beginTransaction();
                try {
                    for (String str : this.a) {
                        x01 x01Var = new x01();
                        x01Var.o(str);
                        this.b.a.delete(x01Var, new j11[0]);
                    }
                    this.b.a.setTransactionSuccessful();
                } finally {
                    this.b.a.endTransaction();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HashMap a;
        public final /* synthetic */ dk0 b;

        public b(dk0 dk0Var, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk0Var, hashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dk0Var;
            this.a = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.a.beginTransaction();
                try {
                    for (Map.Entry entry : this.a.entrySet()) {
                        lk0 lk0Var = (lk0) entry.getValue();
                        if (lk0Var != null) {
                            x01 a = ek0.a(lk0Var);
                            if (!TextUtils.isEmpty(a.g())) {
                                this.b.a.a(a, new j11[0]);
                            }
                        }
                    }
                    this.b.a.setTransactionSuccessful();
                } finally {
                    this.b.a.endTransaction();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x01 a;
        public final /* synthetic */ dk0 b;

        public c(dk0 dk0Var, x01 x01Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk0Var, x01Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dk0Var;
            this.a = x01Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.a.a(this.a, new j11[0]);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x01 a;
        public final /* synthetic */ dk0 b;

        public d(dk0 dk0Var, x01 x01Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk0Var, x01Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dk0Var;
            this.a = x01Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.a.update(this.a, new j11[0]);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Runnable a;

        public e(dk0 dk0Var, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk0Var, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.run();
                } catch (Throwable th) {
                    if (!ng0.a) {
                        Log.d("AdDownloadDBHelper", "wrapExecutor", th);
                        return;
                    }
                    throw th;
                }
            }
        }
    }

    public dk0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        fk0 fk0Var = new fk0();
        fk0Var.getReadableDatabase();
        fk0Var.close();
        SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(zi0.b().getDatabasePath("nad.core.download.db").getPath(), null, 0);
        openDatabase.setLocale(Locale.US);
        this.a = new hk0(openDatabase);
    }

    public /* synthetic */ dk0(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.gk0
    public void b(HashMap<String, lk0> hashMap) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) != null) || q01.c(hashMap)) {
            return;
        }
        f(new b(this, hashMap), "update_apk_data", 3);
    }

    @Override // com.baidu.tieba.gk0
    public void c(x01 x01Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, x01Var) != null) || TextUtils.isEmpty(x01Var.g())) {
            return;
        }
        f(new c(this, x01Var), "update_apk_data", 3);
    }

    @Override // com.baidu.tieba.gk0
    public void update(x01 x01Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, x01Var) != null) || TextUtils.isEmpty(x01Var.g())) {
            return;
        }
        f(new d(this, x01Var), "update_apk_data", 3);
    }

    public static gk0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return f.b;
        }
        return (gk0) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0068  */
    @Override // com.baidu.tieba.gk0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<lk0> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            x01 x01Var = new x01();
            x11 e2 = x11.e();
            e2.a("o", x01Var.b().d());
            e2.c("o", x01Var);
            HashSet hashSet = new HashSet();
            Cursor query = this.a.query(e2);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (query.moveToFirst()) {
                    do {
                        x01 x01Var2 = new x01();
                        q11.b(x01Var2, query);
                        if (x01Var2.x() + ck0.b < currentTimeMillis) {
                            hashSet.add(x01Var2.g());
                        } else {
                            o01.b(arrayList, ek0.b(x01Var2));
                        }
                    } while (query.moveToNext());
                    cj0.a(query);
                    if (hashSet.size() > 0) {
                        f(new a(this, hashSet), "remove_outdated_apk_data", 3);
                    }
                    return arrayList;
                }
                cj0.a(query);
                if (hashSet.size() > 0) {
                }
                return arrayList;
            } catch (Throwable th) {
                cj0.a(query);
                throw th;
            }
        }
        return (List) invokeV.objValue;
    }

    public final void f(@NonNull Runnable runnable, @NonNull String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, runnable, str, i) == null) {
            a21.c(new e(this, runnable), str, i);
        }
    }
}
