package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tieba.dv2;
import com.baidu.tieba.h02;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class i02 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i02 b;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* loaded from: classes6.dex */
    public interface c {
        void b(h02.c cVar, int i);

        void f(h02.c cVar, String str);

        void g(h02.c cVar, ce3 ce3Var);
    }

    /* loaded from: classes6.dex */
    public class a implements g63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h02.c a;
        public final /* synthetic */ i02 b;

        public a(i02 i02Var, h02.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i02Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i02Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.g63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.b.c(this.a);
            }
        }

        @Override // com.baidu.tieba.g63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                d82.c("GetLocationHelper", str);
                ji3.b(GameAssistConstKt.METHOD_GET_LOCATION, 5002, "user no permission", 10005, str);
                this.b.a.f(this.a, str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements dv2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h02.c a;
        public final /* synthetic */ i02 b;

        public b(i02 i02Var, h02.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i02Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i02Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.dv2.a
        public void a(ce3 ce3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ce3Var) == null) {
                this.b.a.g(this.a, ce3Var);
            }
        }

        @Override // com.baidu.tieba.dv2.a
        public void onFailed(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                ji3.b(GameAssistConstKt.METHOD_GET_LOCATION, 4000, "sdk's errCode is " + i, 1001, String.valueOf(i));
                this.b.a.b(this.a, i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947799614, "Lcom/baidu/tieba/i02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947799614, "Lcom/baidu/tieba/i02;");
                return;
            }
        }
        boolean z = nr1.a;
    }

    public i02() {
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

    public static i02 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (b == null) {
                synchronized (i02.class) {
                    if (b == null) {
                        b = new i02();
                    }
                }
            }
            return b;
        }
        return (i02) invokeV.objValue;
    }

    public final void c(h02.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            String str = "gcj02";
            if (!TextUtils.equals(cVar.a, "gcj02")) {
                if (TextUtils.equals(cVar.a, "bd09ll")) {
                    str = "bd09ll";
                } else {
                    str = "wgs84";
                }
            }
            ku2.I().b(str, false, cVar.b, new b(this, cVar));
        }
    }

    public void e(@NonNull h02.c cVar, @NonNull c cVar2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, cVar2, z) == null) {
            this.a = cVar2;
            if (xo3.M()) {
                c(cVar);
            } else if (z) {
                ji3.b(GameAssistConstKt.METHOD_GET_LOCATION, 1002, "GetLocation does not supported when app is invisible", 10005, "GetLocation does not supported when app is invisible");
                this.a.f(cVar, "GetLocation does not supported when app is invisible");
            } else {
                f63.g(cb3.K().w(), new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new a(this, cVar));
            }
        }
    }
}
