package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public final class gm2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public tf3<gm2> b;
    public final List<b> c;
    public String d;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<String> a;
        public final List<String> b;
        public String c;
        public final List<StackTraceElement> d;
        public final /* synthetic */ gm2 e;

        public /* synthetic */ b(gm2 gm2Var, a aVar) {
            this(gm2Var);
        }

        public synchronized b a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                synchronized (this) {
                    List<String> list = this.a;
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    list.add(str);
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.c = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public synchronized b c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                synchronized (this) {
                    d(this.d.size());
                }
                return this;
            }
            return (b) invokeV.objValue;
        }

        public synchronized b d(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                synchronized (this) {
                    if (i < 1) {
                        i = 1;
                    }
                    if (i > this.d.size()) {
                        i = this.d.size();
                    }
                    for (int i2 = 0; i2 < i; i2++) {
                        gm2 gm2Var = this.e;
                        gm2Var.e("[Trace]==> " + this.d.get(i2).toString());
                    }
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public synchronized b e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                synchronized (this) {
                    d(1);
                }
                return this;
            }
            return (b) invokeV.objValue;
        }

        public b(gm2 gm2Var) {
            StackTraceElement[] stackTrace;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gm2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = gm2Var;
            this.a = new ArrayList();
            this.b = new ArrayList();
            this.d = new ArrayList();
            int i3 = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i3++;
                if (i3 > 2 && !stackTraceElement.getClassName().startsWith(gm2Var.d)) {
                    this.d.add(stackTraceElement);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements tf3<gm2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(gm2 gm2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gm2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final void b(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) && gm2.e) {
                Log.i(str, str2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tf3
        /* renamed from: c */
        public void a(gm2 gm2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gm2Var) == null) && gm2.e) {
                for (b bVar : gm2Var.c) {
                    for (String str : bVar.a) {
                        String h = gm2Var.h();
                        String str2 = TextUtils.isEmpty(bVar.c) ? h : bVar.c;
                        b(str2, h + " >>> " + str);
                    }
                }
            }
        }

        public /* synthetic */ c(gm2 gm2Var, a aVar) {
            this(gm2Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947798653, "Lcom/baidu/tieba/gm2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947798653, "Lcom/baidu/tieba/gm2;");
                return;
            }
        }
        e = kh1.a;
    }

    public gm2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new ArrayList();
        this.d = gm2.class.getPackage().getName();
    }

    public synchronized b d() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                bVar = new b(this, null);
                this.c.add(bVar);
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public synchronized b e(String str) {
        InterceptResult invokeL;
        b d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            synchronized (this) {
                d = d();
                d.a(str);
            }
            return d;
        }
        return (b) invokeL.objValue;
    }

    public synchronized b f(String str, String str2) {
        InterceptResult invokeLL;
        b e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            synchronized (this) {
                e2 = e(str2);
                e2.b(str);
            }
            return e2;
        }
        return (b) invokeLL.objValue;
    }

    public gm2 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.a = str;
            return this;
        }
        return (gm2) invokeL.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public synchronized List<b> i() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList(this.c);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public synchronized gm2 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                k(this.b);
            }
            return this;
        }
        return (gm2) invokeV.objValue;
    }

    public synchronized gm2 k(tf3<gm2> tf3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tf3Var)) == null) {
            synchronized (this) {
                if (tf3Var == null) {
                    try {
                        tf3Var = new c(this, null);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                tf3Var.a(this);
            }
            return this;
        }
        return (gm2) invokeL.objValue;
    }

    public gm2 l(tf3<gm2> tf3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tf3Var)) == null) {
            this.b = tf3Var;
            return this;
        }
        return (gm2) invokeL.objValue;
    }
}
