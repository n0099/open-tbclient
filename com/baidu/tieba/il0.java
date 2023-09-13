package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes6.dex */
public class il0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public AdDownloadStatus c;
    public String d;
    public boolean e;
    public String f;
    public String g;
    public File h;
    public float i;
    public float j;
    public Uri k;
    public long l;
    public long m;
    public int n;
    public String o;
    @NonNull
    public ml0 p;
    @NonNull
    public jl0 q;
    @NonNull
    public ll0 r;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-714979361, "Lcom/baidu/tieba/il0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-714979361, "Lcom/baidu/tieba/il0$a;");
                    return;
                }
            }
            int[] iArr = new int[AdDownloadStatus.values().length];
            a = iArr;
            try {
                iArr[AdDownloadStatus.COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AdDownloadStatus.INSTALLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public il0() {
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
        this.a = "";
        this.b = -1;
        this.c = AdDownloadStatus.NONE;
        this.i = 0.0f;
        this.j = 0.0f;
        this.n = -1;
        this.p = new ml0();
        this.q = new jl0();
        this.r = new ll0();
    }

    public boolean a() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (f() || !this.q.s) {
                return false;
            }
            if (TextUtils.isEmpty(this.p.c)) {
                str = xk0.a(this.d);
            } else {
                str = this.p.c;
            }
            if (TextUtils.isEmpty(str) && (!this.q.u || TextUtils.isEmpty(this.d))) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public static il0 c(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        fr0 fr0Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adBaseModel)) == null) {
            il0 il0Var = new il0();
            if (adBaseModel != null && (fr0Var = adBaseModel.l) != null && fr0Var.e) {
                il0Var.g = fr0Var.c;
                il0Var.h(fr0Var.d);
                il0Var.d = adBaseModel.l.a;
                AdOperator adOperator = adBaseModel.h;
                if (adOperator == null) {
                    str = null;
                } else {
                    str = adOperator.d;
                }
                il0Var.f = str;
                il0Var.p.a = adBaseModel.f.d;
            }
            return il0Var;
        }
        return (il0) invokeL.objValue;
    }

    @NonNull
    public static il0 d(fr0 fr0Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, fr0Var, str, str2)) == null) {
            il0 il0Var = new il0();
            if (fr0Var != null && fr0Var.e) {
                il0Var.g = fr0Var.c;
                il0Var.h(fr0Var.d);
                il0Var.d = fr0Var.a;
                ml0 ml0Var = il0Var.p;
                ml0Var.a = str;
                il0Var.f = str2;
                ml0Var.k = kl0.a(i31.c(fr0Var.f));
            }
            return il0Var;
        }
        return (il0) invokeLLL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.q.g != 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.g)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c = AdDownloadStatus.NONE;
            this.i = 0.0f;
            this.j = 0.0f;
            this.h = null;
            this.q.v = false;
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, str) != null) || str == null) {
            return;
        }
        this.a = str;
    }

    public void i(il0 il0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, il0Var) == null) {
            if (il0Var != null && TextUtils.equals(e(), il0Var.e())) {
                int i = a.a[il0Var.c.ordinal()];
                if (i != 1) {
                    if (i == 2 && !sm0.c(il0Var.d)) {
                        File file = il0Var.h;
                        if (file != null && file.exists()) {
                            il0Var.c = AdDownloadStatus.COMPLETED;
                        } else {
                            il0Var.g();
                        }
                    }
                } else if (sm0.c(il0Var.d)) {
                    il0Var.c = AdDownloadStatus.INSTALLED;
                } else if (!sm0.g(il0Var.h)) {
                    vk0.c().a(il0Var);
                    il0Var.g();
                }
                if (TextUtils.isEmpty(this.d)) {
                    this.d = il0Var.d;
                }
                this.b = il0Var.b;
                this.c = il0Var.c;
                this.i = il0Var.i;
                this.j = il0Var.j;
                this.h = il0Var.h;
                this.d = il0Var.d;
                this.l = il0Var.l;
                this.m = il0Var.m;
                jl0 jl0Var = this.q;
                jl0 jl0Var2 = il0Var.q;
                jl0Var.k = jl0Var2.k;
                jl0Var.l = jl0Var2.l;
                jl0Var.v = jl0Var2.v;
                jl0Var.w = jl0Var2.w;
                this.p.h = il0Var.p.h;
                this.k = il0Var.k;
            } else if (sm0.c(this.d)) {
                this.c = AdDownloadStatus.INSTALLED;
            }
        }
    }
}
