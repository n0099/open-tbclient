package com.baidu.tieba;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tieba.g8b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.Flow;
import java.util.ConcurrentModificationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h8b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public static volatile h8b l;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ScheduledExecutorService b;
    public ExecutorService c;
    public k8b d;
    public g8b e;
    public int f;
    public boolean g;
    public z8b h;
    public boolean i;
    public boolean j;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h8b a;

        public a(h8b h8bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h8bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h8bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e == null) {
                    if (h8b.k) {
                        Log.d("UBCBehaviorProcessor", "sendArrivalData#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.a.e.E();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r8b a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ h8b c;

        public b(h8b h8bVar, r8b r8bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h8bVar, r8bVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = h8bVar;
            this.a = r8bVar;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.c.e == null) {
                    if (h8b.k) {
                        Log.d("UBCBehaviorProcessor", "processUploadRealTimeEvent#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.c.e.w(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ h8b c;

        public c(h8b h8bVar, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h8bVar, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = h8bVar;
            this.a = z;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.c.e == null) {
                    if (h8b.k) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                if (this.a) {
                    this.c.e.Q(this.b);
                } else {
                    this.c.e.P(this.b);
                }
                m9b.m().B(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h8b a;

        public d(h8b h8bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h8bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h8bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.e == null) {
                return;
            }
            this.a.e.S();
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h8b a;

        public e(h8b h8bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h8bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h8bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e == null) {
                    if (h8b.k) {
                        Log.d("UBCBehaviorProcessor", "upload#ubc init not finish");
                        return;
                    }
                    return;
                }
                if (Math.abs(System.currentTimeMillis() - o9b.a().c("ubc_last_upload_all_time", 0L)) < 3600000) {
                    return;
                }
                this.a.e.S();
                long currentTimeMillis = System.currentTimeMillis();
                o9b.a().e("ubc_last_upload_all_time", currentTimeMillis);
                o9b.a().e("ubc_last_upload_non_real", currentTimeMillis);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h8b a;

        public f(h8b h8bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h8bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h8bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.e == null) {
                return;
            }
            this.a.e.M();
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h8b a;

        public g(h8b h8bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h8bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h8bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e == null) {
                    if (h8b.k) {
                        Log.d("UBCBehaviorProcessor", "saveCache#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.a.e.m();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g8b.c a;
        public final /* synthetic */ h8b b;

        public h(h8b h8bVar, g8b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h8bVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h8bVar;
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.e == null) {
                    if (h8b.k) {
                        Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.b.e.N(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g8b.c a;
        public final /* synthetic */ h8b b;

        public i(h8b h8bVar, g8b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h8bVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h8bVar;
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.e == null) {
                    if (h8b.k) {
                        Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.b.e.N(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h8b a;

        public j(h8b h8bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h8bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h8bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e == null) {
                    if (h8b.k) {
                        Log.d("UBCBehaviorProcessor", "processOneFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.a.e.v();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h8b a;

        public k(h8b h8bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h8bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h8bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e == null) {
                    if (h8b.k) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.a.e.u();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h8b a;

        public l(h8b h8bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h8bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h8bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e == null) {
                    if (h8b.k) {
                        Log.d("UBCBehaviorProcessor", "sendQualityData#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.a.e.F();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public a9b a;
        public boolean b;
        public w8b c;
        public final /* synthetic */ h8b d;

        public m(h8b h8bVar, a9b a9bVar, boolean z, w8b w8bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h8bVar, a9bVar, Boolean.valueOf(z), w8bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = h8bVar;
            this.a = a9bVar;
            this.b = z;
            this.c = w8bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.d.e == null) {
                    if (h8b.k) {
                        Log.d("UBCBehaviorProcessor", "ConfigUpdateRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.d.e.K(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public r8b a;
        public String b;
        public final /* synthetic */ h8b c;

        public n(h8b h8bVar, String str, String str2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h8bVar, str, str2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = h8bVar;
            this.a = new r8b(str, str2, i);
            this.b = str;
        }

        public n(h8b h8bVar, String str, String str2, int i, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h8bVar, str, str2, Integer.valueOf(i), str3};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.c = h8bVar;
            r8b r8bVar = new r8b(str, str2, i);
            this.a = r8bVar;
            this.b = str;
            r8bVar.r(str3);
        }

        public n(h8b h8bVar, String str, String str2, int i, String str3, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h8bVar, str, str2, Integer.valueOf(i), str3, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.c = h8bVar;
            this.a = new r8b(str, str2, i, str3, i2);
            this.b = str;
        }

        public n(h8b h8bVar, String str, String str2, int i, String str3, long j, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h8bVar, str, str2, Integer.valueOf(i), str3, Long.valueOf(j), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65539, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.c = h8bVar;
            this.a = new r8b(str, str2, i, str3, j, i2);
            this.b = str;
        }

        public n(h8b h8bVar, String str, JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h8bVar, str, jSONObject, Integer.valueOf(i)};
                interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
            this.c = h8bVar;
            this.a = new r8b(str, jSONObject, i);
            this.b = str;
        }

        public n(h8b h8bVar, String str, JSONObject jSONObject, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h8bVar, str, jSONObject, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65541, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65541, newInitContext);
                    return;
                }
            }
            this.c = h8bVar;
            r8b r8bVar = new r8b(str, jSONObject, i);
            this.a = r8bVar;
            this.b = str;
            r8bVar.r(str2);
        }

        public final boolean a(String str, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
                if ((i & 16) != 0 && !f9b.i().c(str)) {
                    return false;
                }
                if (this.c.d != null && !this.c.d.g(str, i)) {
                    return false;
                }
                if (this.c.d != null && this.c.d.F(str)) {
                    return false;
                }
                if (this.c.d != null && this.c.d.h(str)) {
                    return false;
                }
                if (this.c.d != null && this.c.d.d(str)) {
                    return false;
                }
                return true;
            }
            return invokeLI.booleanValue;
        }

        public final void b(String str, String str2) {
            int length;
            int s;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) && (length = str2.length()) > (s = k8b.o().s())) {
                h9b.a().g(String.valueOf(s), String.valueOf(length), str);
                if (h8b.k) {
                    Log.e("UBCBehaviorProcessor", "UBC log too large, id=" + str + ", content=" + str2);
                    throw new RuntimeException(String.format("UBC log too large(size=%dKB / threshold=%dKB), log id=%s, please deal with. Any question connect UBC owner. content=%s", Integer.valueOf(length / 1024), Integer.valueOf(s / 1024), str, str2));
                }
            }
        }

        public final void c() {
            r8b r8bVar;
            JSONObject m;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (r8bVar = this.a) == null) {
                return;
            }
            String l = r8bVar.l();
            if (TextUtils.isEmpty(l)) {
                return;
            }
            String f = this.a.f();
            if (TextUtils.isEmpty(f) && (m = this.a.m()) != null) {
                try {
                    f = m.toString();
                } catch (ConcurrentModificationException e) {
                    if (this.c.h != null) {
                        this.c.h.b(l, e.toString());
                        return;
                    }
                    return;
                }
            }
            if (!TextUtils.isEmpty(f)) {
                b(l, f);
                if (this.c.h != null) {
                    this.c.h.a(l, f);
                }
            }
        }

        public void d(boolean z) {
            r8b r8bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (r8bVar = this.a) != null) {
                r8bVar.u(z);
            }
        }

        public void e(String str) {
            r8b r8bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (r8bVar = this.a) != null) {
                r8bVar.x(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (this.c.e == null) {
                    if (h8b.k) {
                        Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                if (!this.c.i) {
                    if (this.c.h == null) {
                        this.c.h = (z8b) ServiceManager.getService(z8b.a);
                    }
                    this.c.i = true;
                }
                if (this.c.d != null && this.c.d.b(this.b) == 1) {
                    c();
                }
                if (this.a.j() == -1) {
                    if (!a(this.a.l(), this.a.n())) {
                        return;
                    }
                    if (this.c.d != null && this.c.d.J(this.a.l())) {
                        d(true);
                    }
                    b9b.f().a(this.a.l(), true);
                }
                this.a.v();
                String l = this.a.l();
                if (TextUtils.isEmpty(l)) {
                    return;
                }
                if (this.c.d != null) {
                    String j = this.c.d.j(l);
                    if (!TextUtils.isEmpty(j)) {
                        this.a.s(j);
                    }
                }
                if (this.c.d != null && this.c.d.b(this.b) == 2) {
                    c();
                }
                if (this.a.j() == -1 && TextUtils.equals(l, "1876")) {
                    this.c.e.C(this.a);
                } else if ((this.a.n() & 8) != 0) {
                    this.c.e.B(this.a);
                } else if ((this.a.n() & 128) != 0) {
                    if (this.c.j) {
                        this.c.e.t(this.a);
                    } else {
                        this.c.e.A(this.a);
                    }
                } else if (this.a != null && this.c.d != null && this.c.d.f(l)) {
                    this.c.e.X(this.a);
                } else if (this.c.j) {
                    this.c.e.t(this.a);
                } else {
                    this.c.e.A(this.a);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;
        public final /* synthetic */ h8b c;

        public o(h8b h8bVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h8bVar, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = h8bVar;
            this.a = str;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.c.e == null) {
                    if (h8b.k) {
                        Log.d("UBCBehaviorProcessor", "FlowCancelRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.c.e.h(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public t8b a;
        public final /* synthetic */ h8b b;

        public p(h8b h8bVar, Flow flow, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h8bVar, flow, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h8bVar;
            t8b t8bVar = new t8b(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.a = t8bVar;
            t8bVar.q(flow.getStartTime());
            this.a.C("1");
            h8b.n(h8bVar);
        }

        public p(h8b h8bVar, Flow flow, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h8bVar, flow, str, str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.b = h8bVar;
            t8b t8bVar = new t8b(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.a = t8bVar;
            t8bVar.q(flow.getStartTime());
            this.a.C("1");
            h8b.n(h8bVar);
            this.a.r(str2);
        }

        public p(h8b h8bVar, Flow flow, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h8bVar, flow, jSONObject};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.b = h8bVar;
            t8b t8bVar = new t8b(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.a = t8bVar;
            t8bVar.q(flow.getStartTime());
            this.a.C("1");
            h8b.n(h8bVar);
        }

        public p(h8b h8bVar, Flow flow, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h8bVar, flow, jSONObject, str};
                interceptable.invokeUnInit(65539, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.b = h8bVar;
            t8b t8bVar = new t8b(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.a = t8bVar;
            t8bVar.q(flow.getStartTime());
            this.a.C("1");
            h8b.n(h8bVar);
            this.a.r(str);
        }

        public void a(boolean z) {
            t8b t8bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (t8bVar = this.a) != null) {
                t8bVar.u(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.b.e == null) {
                    if (h8b.k) {
                        Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.a.x();
                if (!TextUtils.isEmpty(this.b.d.j(this.a.l()))) {
                    this.a.s(this.b.d.j(this.a.l()));
                }
                this.b.e.I(this.a);
                f9b.q(this.b.f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;
        public int c;
        public long d;
        public JSONArray e;
        public final /* synthetic */ h8b f;

        public q(h8b h8bVar, String str, int i, int i2, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h8bVar, str, Integer.valueOf(i), Integer.valueOf(i2), jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = h8bVar;
            this.a = str;
            this.b = i;
            this.c = i2;
            this.d = System.currentTimeMillis();
            this.e = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f.e == null) {
                    if (h8b.k) {
                        Log.d("UBCBehaviorProcessor", "FlowEndRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                b9b.f().a(this.a, true);
                this.f.e.l(this.a, this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;
        public String c;
        public final /* synthetic */ h8b d;

        public r(h8b h8bVar, String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h8bVar, str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = h8bVar;
            this.a = str;
            this.b = i;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.d.e == null) {
                    if (h8b.k) {
                        Log.d("UBCBehaviorProcessor", "FlowUpdateRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.d.e.L(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h8b a;

        public s(h8b h8bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h8bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h8bVar;
        }

        public /* synthetic */ s(h8b h8bVar, d dVar) {
            this(h8bVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(10);
                this.a.d = k8b.o();
                this.a.e = new g8b(this.a.a);
                this.a.e.H();
                h8b h8bVar = this.a;
                h8bVar.j = h8bVar.d.N();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947778999, "Lcom/baidu/tieba/h8b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947778999, "Lcom/baidu/tieba/h8b;");
                return;
            }
        }
        k = f9b.m();
    }

    public h8b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = false;
        y(f9b.b());
    }

    public static h8b w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            if (l == null) {
                synchronized (h8b.class) {
                    if (l == null) {
                        l = new h8b();
                    }
                }
            }
            return l;
        }
        return (h8b) invokeV.objValue;
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b.execute(new k(this));
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.execute(new j(this));
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || !mk1.g()) {
            return;
        }
        this.b.execute(new a(this));
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.b.execute(new l(this));
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || this.g) {
            return;
        }
        this.g = true;
        this.b.execute(new e(this));
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.b.execute(new f(this));
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.b.execute(new d(this));
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.b.execute(new g(this));
        }
    }

    public static /* synthetic */ int n(h8b h8bVar) {
        int i2 = h8bVar.f;
        h8bVar.f = i2 + 1;
        return i2;
    }

    public void R(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jSONObject) == null) {
            S(jSONObject, null);
        }
    }

    public String x(String str) {
        InterceptResult invokeL;
        int q2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            g8b g8bVar = this.e;
            if (g8bVar != null && (q2 = g8bVar.q(str)) != -1) {
                return String.valueOf(q2);
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public void I(r8b r8bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, r8bVar, z) == null) {
            this.b.execute(new b(this, r8bVar, z));
        }
    }

    public void J(Runnable runnable, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048585, this, runnable, j2) == null) {
            this.b.schedule(runnable, j2, TimeUnit.MILLISECONDS);
        }
    }

    public void S(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, jSONObject, str) == null) {
            T(jSONObject, str, false, null, null);
        }
    }

    public void V(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, str, z) == null) {
            this.b.execute(new c(this, z, str));
        }
    }

    public void s(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048603, this, str, i2) == null) {
            this.b.execute(new o(this, str, i2));
        }
    }

    public void A(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, str, str2, i2) == null) {
            this.b.execute(new n(this, str, str2, i2));
        }
    }

    public void C(String str, JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, jSONObject, i2) == null) {
            this.b.execute(new n(this, str, jSONObject, i2));
        }
    }

    public void M(a9b a9bVar, boolean z, w8b w8bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{a9bVar, Boolean.valueOf(z), w8bVar}) == null) {
            this.b.execute(new m(this, a9bVar, z, w8bVar));
        }
    }

    public void N(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048589, this, str, i2, str2) == null) {
            this.b.execute(new r(this, str, i2, str2));
        }
    }

    public void B(String str, String str2, int i2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, i2, str3) == null) {
            this.b.execute(new n(this, str, str2, i2, str3));
        }
    }

    public void D(String str, JSONObject jSONObject, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048579, this, str, jSONObject, i2, str2) == null) {
            this.b.execute(new n(this, str, jSONObject, i2, str2));
        }
    }

    public void U(JSONObject jSONObject, boolean z, r8b r8bVar, x8b x8bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{jSONObject, Boolean.valueOf(z), r8bVar, x8bVar}) == null) {
            T(jSONObject, null, z, r8bVar, x8bVar);
        }
    }

    public void z(String str, String str2, String str3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048609, this, str, str2, str3, i2) == null) {
            n nVar = new n(this, str, str2, i2);
            if (!TextUtils.isEmpty(str3)) {
                nVar.e(str3);
            }
            this.b.execute(nVar);
        }
    }

    public void F(String str, String str2, int i2, String str3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3)}) == null) {
            this.b.execute(new n(this, str, str2, i2, str3, i3));
        }
    }

    public void G(String str, String str2, int i2, String str3, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            this.b.execute(new n(this, str, str2, i2, str3, j2, i3));
        }
    }

    public void Q(p9b p9bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, p9bVar, str) == null) {
            if (k) {
                Log.d("UBCBehaviorProcessor", "uploadData isDataInFile:" + p9bVar.x());
                if (p9bVar.x()) {
                    p9bVar.F("UBCDEBUG");
                } else {
                    Log.d("UBCDEBUG", p9bVar.u().toString());
                }
            }
            if (!f9b.l() && !p9bVar.A()) {
                return;
            }
            g8b.c cVar = new g8b.c();
            boolean x = p9bVar.x();
            cVar.a = x;
            if (x) {
                cVar.c = p9bVar.o();
                cVar.f = p9bVar.m();
            } else {
                cVar.d = p9bVar.u();
            }
            cVar.h = p9bVar.A();
            cVar.e = str;
            m9b.m().z();
            this.c.execute(new i(this, cVar));
        }
    }

    public Flow t(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048604, this, str, i2)) == null) {
            Flow flow = new Flow(str, this.f, i2);
            k8b k8bVar = this.d;
            if (k8bVar != null && !k8bVar.g(str, i2)) {
                flow.setValid(false);
                return flow;
            } else if ((i2 & 16) != 0 && !f9b.i().c(str)) {
                flow.setValid(false);
                return flow;
            } else {
                k8b k8bVar2 = this.d;
                if (k8bVar2 != null && k8bVar2.h(str)) {
                    flow.setValid(false);
                    return flow;
                }
                k8b k8bVar3 = this.d;
                if (k8bVar3 != null && k8bVar3.F(str)) {
                    flow.setValid(false);
                    return flow;
                }
                k8b k8bVar4 = this.d;
                if (k8bVar4 != null && !k8bVar4.K(str)) {
                    flow.setValid(false);
                }
                return flow;
            }
        }
        return (Flow) invokeLI.objValue;
    }

    public final void T(JSONObject jSONObject, String str, boolean z, r8b r8bVar, x8b x8bVar) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{jSONObject, str, Boolean.valueOf(z), r8bVar, x8bVar}) == null) {
            if (k) {
                Log.d("UBCBehaviorProcessor", "uploadData:" + str);
                Log.d("UBCDEBUG", jSONObject.toString());
            }
            boolean l2 = f9b.l();
            if (r8bVar != null && (r8bVar.n() & 128) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!l2 && !z2) {
                return;
            }
            g8b.c cVar = new g8b.c();
            cVar.a = false;
            cVar.d = jSONObject;
            cVar.e = str;
            cVar.g = z;
            cVar.h = z2;
            cVar.b = r8bVar;
            cVar.i = x8bVar;
            this.c.execute(new h(this, cVar));
        }
    }

    public synchronized Flow o(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Flow t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048599, this, str, str2, i2)) == null) {
            synchronized (this) {
                t = t(str, i2);
                if (t != null && t.getValid()) {
                    p pVar = new p(this, t, str2);
                    if (this.d != null && this.d.J(str)) {
                        pVar.a(true);
                    }
                    this.b.execute(pVar);
                }
            }
            return t;
        }
        return (Flow) invokeLLI.objValue;
    }

    public synchronized Flow q(String str, JSONObject jSONObject, int i2) {
        InterceptResult invokeLLI;
        Flow t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048601, this, str, jSONObject, i2)) == null) {
            synchronized (this) {
                t = t(str, i2);
                if (t != null && t.getValid()) {
                    p pVar = new p(this, t, jSONObject);
                    if (this.d != null && this.d.J(str)) {
                        pVar.a(true);
                    }
                    this.b.execute(pVar);
                }
            }
            return t;
        }
        return (Flow) invokeLLI.objValue;
    }

    public synchronized Flow p(String str, String str2, int i2, String str3) {
        InterceptResult invokeLLIL;
        Flow t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048600, this, str, str2, i2, str3)) == null) {
            synchronized (this) {
                t = t(str, i2);
                if (t != null && t.getValid()) {
                    p pVar = new p(this, t, str2, str3);
                    if (this.d != null && this.d.J(str)) {
                        pVar.a(true);
                    }
                    this.b.execute(pVar);
                }
            }
            return t;
        }
        return (Flow) invokeLLIL.objValue;
    }

    public synchronized Flow r(String str, JSONObject jSONObject, int i2, String str2) {
        InterceptResult invokeLLIL;
        Flow t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048602, this, str, jSONObject, i2, str2)) == null) {
            synchronized (this) {
                t = t(str, i2);
                if (t != null && t.getValid()) {
                    p pVar = new p(this, t, jSONObject, str2);
                    if (this.d != null && this.d.J(str)) {
                        pVar.a(true);
                    }
                    this.b.execute(pVar);
                }
            }
            return t;
        }
        return (Flow) invokeLLIL.objValue;
    }

    public void u(String str, int i2, int i3, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), jSONArray}) == null) {
            this.b.execute(new q(this, str, i2, i3, jSONArray));
        }
    }

    public final void y(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, context) == null) && this.a == null && context != null) {
            if (context instanceof Application) {
                this.a = context;
            } else {
                this.a = context.getApplicationContext();
            }
            this.f = f9b.d();
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.b = newSingleThreadScheduledExecutor;
            newSingleThreadScheduledExecutor.execute(new s(this, null));
            this.c = Executors.newSingleThreadExecutor();
        }
    }
}
