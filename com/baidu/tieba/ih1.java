package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ih1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ih1 a;
    public static String b;
    public static String c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public interface a {
        void onFinish(String str);
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ ih1 b;

        public b(ih1 ih1Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ih1Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ih1Var;
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    nh1.a("sso onekey init");
                    this.b.f(this.a.getApplicationContext());
                    wh1.j().d(this.a.getApplicationContext());
                } catch (Throwable th) {
                    vi1.d(th);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ a b;
        public final /* synthetic */ long c;

        public c(ih1 ih1Var, Context context, a aVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ih1Var, context, aVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = aVar;
            this.c = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    nh1.a("sso onekey preLogin");
                    if (!jh1.f(this.a.getApplicationContext()).d()) {
                        uh1.b(this.b, rh1.a(), -1, null, false);
                        nh1.d("sso onekey preLogin fail, user not auth");
                        return;
                    }
                    wh1.j().e(this.a.getApplicationContext(), 0, null, this.c, this.b);
                } catch (Throwable th) {
                    vi1.d(th);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ a b;
        public final /* synthetic */ long c;

        public d(ih1 ih1Var, Context context, a aVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ih1Var, context, aVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = aVar;
            this.c = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    nh1.a("sso onekey login");
                    if (!jh1.f(this.a.getApplicationContext()).d()) {
                        uh1.b(this.b, rh1.a(), -1, null, false);
                        nh1.d("sso onekey login fail, user not auth");
                        return;
                    }
                    wh1.j().f(this.a.getApplicationContext(), this.c, this.b);
                } catch (Throwable th) {
                    vi1.d(th);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ a b;
        public final /* synthetic */ long c;

        public e(ih1 ih1Var, Context context, a aVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ih1Var, context, aVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = aVar;
            this.c = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    nh1.a("sso onekey verifyPhoneNum");
                    if (!jh1.f(this.a.getApplicationContext()).d()) {
                        uh1.b(this.b, rh1.a(), -1, null, false);
                        nh1.d("sso onekey verifyPhoneNum fail, user not auth");
                        return;
                    }
                    wh1.j().l(this.a.getApplicationContext(), this.c, this.b);
                } catch (Throwable th) {
                    vi1.d(th);
                }
            }
        }
    }

    public ih1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static ih1 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (ih1.class) {
                    if (a == null) {
                        a = new ih1();
                    }
                }
            }
            return a;
        }
        return (ih1) invokeV.objValue;
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            nh1.b(z);
        }
    }

    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            nh1.a("getCurrentOperatorName");
            if (!jh1.f(context.getApplicationContext()).d()) {
                nh1.d("getCurrentOperatorName fail, user not auth");
                return null;
            }
            int intValue = ((Integer) dj1.c(context.getApplicationContext()).second).intValue();
            if (intValue == 1) {
                return OneKeyLoginSdkCall.OPERATOR_CHINA_MOBILE;
            }
            if (intValue == 3) {
                return OneKeyLoginSdkCall.OPERATOR_CHINA_TELECOM;
            }
            if (intValue == 2) {
                return OneKeyLoginSdkCall.OPERATOR_CHINA_UNICOM;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public synchronized void e(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2) == null) {
            synchronized (this) {
                try {
                    b = str;
                    c = str2;
                    pi1.a().post(new b(this, context));
                } catch (Throwable th) {
                    vi1.d(th);
                }
            }
        }
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            String l0 = jh1.f(context).l0();
            if (TextUtils.isEmpty(l0)) {
                return;
            }
            String[] split = l0.split("_");
            if (split.length != 2) {
                jh1.f(context).h();
            }
            b = split[0];
            c = split[1];
        }
    }

    public void g(Context context, long j, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Long.valueOf(j), aVar}) == null) {
            try {
                pi1.a().post(new d(this, context, aVar, j));
            } catch (Throwable th) {
                vi1.d(th);
            }
        }
    }

    public void h(Context context, long j, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Long.valueOf(j), aVar}) == null) {
            try {
                pi1.a().post(new c(this, context, aVar, j));
            } catch (Throwable th) {
                vi1.d(th);
            }
        }
    }

    public void i(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, context, z) == null) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("setUserAuthPrivacyState, value:");
                sb.append(z);
                nh1.a(sb.toString());
                jh1.f(context.getApplicationContext()).W(z);
            } catch (Throwable th) {
                vi1.d(th);
            }
        }
    }

    public void j(Context context, long j, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, Long.valueOf(j), aVar}) == null) {
            try {
                pi1.a().post(new e(this, context, aVar, j));
            } catch (Throwable th) {
                vi1.d(th);
            }
        }
    }
}
