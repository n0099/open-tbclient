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
public class gm0 {
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
    public km0 p;
    public hm0 q;
    public jm0 r;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-771314142, "Lcom/baidu/tieba/gm0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-771314142, "Lcom/baidu/tieba/gm0$a;");
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

    public gm0() {
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
        this.p = new km0();
        this.q = new hm0();
        this.r = new jm0();
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
                str = vl0.a(this.d);
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
    public static gm0 c(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        xr0 xr0Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adBaseModel)) == null) {
            gm0 gm0Var = new gm0();
            if (adBaseModel != null && (xr0Var = adBaseModel.l) != null && xr0Var.e) {
                gm0Var.g = xr0Var.c;
                gm0Var.h(xr0Var.d);
                gm0Var.d = adBaseModel.l.a;
                AdOperator adOperator = adBaseModel.h;
                if (adOperator == null) {
                    str = null;
                } else {
                    str = adOperator.d;
                }
                gm0Var.f = str;
                gm0Var.p.a = adBaseModel.f.d;
            }
            return gm0Var;
        }
        return (gm0) invokeL.objValue;
    }

    @NonNull
    public static gm0 d(xr0 xr0Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, xr0Var, str, str2)) == null) {
            gm0 gm0Var = new gm0();
            if (xr0Var != null && xr0Var.e) {
                gm0Var.g = xr0Var.c;
                gm0Var.h(xr0Var.d);
                gm0Var.d = xr0Var.a;
                km0 km0Var = gm0Var.p;
                km0Var.a = str;
                gm0Var.f = str2;
                km0Var.k = im0.a(y31.c(xr0Var.f));
            }
            return gm0Var;
        }
        return (gm0) invokeLLL.objValue;
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

    public void i(gm0 gm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, gm0Var) == null) {
            if (gm0Var != null && TextUtils.equals(e(), gm0Var.e())) {
                int i = a.a[gm0Var.c.ordinal()];
                if (i != 1) {
                    if (i == 2 && !qn0.c(gm0Var.d)) {
                        File file = gm0Var.h;
                        if (file != null && file.exists()) {
                            gm0Var.c = AdDownloadStatus.COMPLETED;
                        } else {
                            gm0Var.g();
                            return;
                        }
                    }
                } else if (qn0.c(gm0Var.d)) {
                    gm0Var.c = AdDownloadStatus.INSTALLED;
                } else if (!qn0.g(gm0Var.h)) {
                    tl0.c().a(gm0Var);
                    gm0Var.g();
                }
                if (TextUtils.isEmpty(this.d)) {
                    this.d = gm0Var.d;
                }
                this.b = gm0Var.b;
                this.c = gm0Var.c;
                this.i = gm0Var.i;
                this.j = gm0Var.j;
                this.h = gm0Var.h;
                this.d = gm0Var.d;
                this.l = gm0Var.l;
                this.m = gm0Var.m;
                hm0 hm0Var = this.q;
                hm0 hm0Var2 = gm0Var.q;
                hm0Var.k = hm0Var2.k;
                hm0Var.l = hm0Var2.l;
                hm0Var.v = hm0Var2.v;
                this.p.h = gm0Var.p.h;
                this.k = gm0Var.k;
            } else if (qn0.c(this.d)) {
                this.c = AdDownloadStatus.INSTALLED;
            }
        }
    }
}
