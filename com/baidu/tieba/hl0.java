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
public class hl0 {
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
    public ll0 p;
    public il0 q;
    public kl0 r;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-743608512, "Lcom/baidu/tieba/hl0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-743608512, "Lcom/baidu/tieba/hl0$a;");
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

    public hl0() {
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
        this.p = new ll0();
        this.q = new il0();
        this.r = new kl0();
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
                str = wk0.a(this.d);
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
    public static hl0 c(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        br0 br0Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adBaseModel)) == null) {
            hl0 hl0Var = new hl0();
            if (adBaseModel != null && (br0Var = adBaseModel.l) != null && br0Var.e) {
                hl0Var.g = br0Var.c;
                hl0Var.h(br0Var.d);
                hl0Var.d = adBaseModel.l.a;
                AdOperator adOperator = adBaseModel.h;
                if (adOperator == null) {
                    str = null;
                } else {
                    str = adOperator.d;
                }
                hl0Var.f = str;
                hl0Var.p.a = adBaseModel.f.d;
            }
            return hl0Var;
        }
        return (hl0) invokeL.objValue;
    }

    @NonNull
    public static hl0 d(br0 br0Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, br0Var, str, str2)) == null) {
            hl0 hl0Var = new hl0();
            if (br0Var != null && br0Var.e) {
                hl0Var.g = br0Var.c;
                hl0Var.h(br0Var.d);
                hl0Var.d = br0Var.a;
                ll0 ll0Var = hl0Var.p;
                ll0Var.a = str;
                hl0Var.f = str2;
                ll0Var.k = jl0.a(e31.c(br0Var.f));
            }
            return hl0Var;
        }
        return (hl0) invokeLLL.objValue;
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

    public void i(hl0 hl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, hl0Var) == null) {
            if (hl0Var != null && TextUtils.equals(e(), hl0Var.e())) {
                int i = a.a[hl0Var.c.ordinal()];
                if (i != 1) {
                    if (i == 2 && !rm0.c(hl0Var.d)) {
                        File file = hl0Var.h;
                        if (file != null && file.exists()) {
                            hl0Var.c = AdDownloadStatus.COMPLETED;
                        } else {
                            hl0Var.g();
                            return;
                        }
                    }
                } else if (rm0.c(hl0Var.d)) {
                    hl0Var.c = AdDownloadStatus.INSTALLED;
                } else if (!rm0.g(hl0Var.h)) {
                    uk0.c().a(hl0Var);
                    hl0Var.g();
                }
                if (TextUtils.isEmpty(this.d)) {
                    this.d = hl0Var.d;
                }
                this.b = hl0Var.b;
                this.c = hl0Var.c;
                this.i = hl0Var.i;
                this.j = hl0Var.j;
                this.h = hl0Var.h;
                this.d = hl0Var.d;
                this.l = hl0Var.l;
                this.m = hl0Var.m;
                il0 il0Var = this.q;
                il0 il0Var2 = hl0Var.q;
                il0Var.k = il0Var2.k;
                il0Var.l = il0Var2.l;
                il0Var.v = il0Var2.v;
                this.p.h = hl0Var.p.h;
                this.k = hl0Var.k;
            } else if (rm0.c(this.d)) {
                this.c = AdDownloadStatus.INSTALLED;
            }
        }
    }
}
