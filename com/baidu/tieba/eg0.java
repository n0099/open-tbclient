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
/* loaded from: classes5.dex */
public class eg0 {
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
    public ig0 p;
    @NonNull
    public fg0 q;
    @NonNull
    public hg0 r;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-834113570, "Lcom/baidu/tieba/eg0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-834113570, "Lcom/baidu/tieba/eg0$a;");
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

    public eg0() {
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
        this.p = new ig0();
        this.q = new fg0();
        this.r = new hg0();
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
                str = tf0.a(this.d);
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
    public static eg0 c(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        bm0 bm0Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adBaseModel)) == null) {
            eg0 eg0Var = new eg0();
            if (adBaseModel != null && (bm0Var = adBaseModel.l) != null && bm0Var.e) {
                eg0Var.g = bm0Var.c;
                eg0Var.h(bm0Var.d);
                eg0Var.d = adBaseModel.l.a;
                AdOperator adOperator = adBaseModel.h;
                if (adOperator == null) {
                    str = null;
                } else {
                    str = adOperator.b;
                }
                eg0Var.f = str;
                eg0Var.p.a = adBaseModel.f.d;
            }
            return eg0Var;
        }
        return (eg0) invokeL.objValue;
    }

    @NonNull
    public static eg0 d(bm0 bm0Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, bm0Var, str, str2)) == null) {
            eg0 eg0Var = new eg0();
            if (bm0Var != null && bm0Var.e) {
                eg0Var.g = bm0Var.c;
                eg0Var.h(bm0Var.d);
                eg0Var.d = bm0Var.a;
                ig0 ig0Var = eg0Var.p;
                ig0Var.a = str;
                eg0Var.f = str2;
                ig0Var.k = gg0.a(ux0.c(bm0Var.f));
            }
            return eg0Var;
        }
        return (eg0) invokeLLL.objValue;
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

    public void i(eg0 eg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eg0Var) == null) {
            if (eg0Var != null && TextUtils.equals(e(), eg0Var.e())) {
                int i = a.a[eg0Var.c.ordinal()];
                if (i != 1) {
                    if (i == 2 && !oh0.c(eg0Var.d)) {
                        File file = eg0Var.h;
                        if (file != null && file.exists()) {
                            eg0Var.c = AdDownloadStatus.COMPLETED;
                        } else {
                            eg0Var.g();
                        }
                    }
                } else if (oh0.c(eg0Var.d)) {
                    eg0Var.c = AdDownloadStatus.INSTALLED;
                } else if (!oh0.g(eg0Var.h)) {
                    rf0.c().a(eg0Var);
                    eg0Var.g();
                }
                if (TextUtils.isEmpty(this.d)) {
                    this.d = eg0Var.d;
                }
                this.b = eg0Var.b;
                this.c = eg0Var.c;
                this.i = eg0Var.i;
                this.j = eg0Var.j;
                this.h = eg0Var.h;
                this.d = eg0Var.d;
                this.l = eg0Var.l;
                this.m = eg0Var.m;
                fg0 fg0Var = this.q;
                fg0 fg0Var2 = eg0Var.q;
                fg0Var.k = fg0Var2.k;
                fg0Var.l = fg0Var2.l;
                fg0Var.v = fg0Var2.v;
                fg0Var.w = fg0Var2.w;
                this.p.h = eg0Var.p.h;
                this.k = eg0Var.k;
            } else if (oh0.c(this.d)) {
                this.c = AdDownloadStatus.INSTALLED;
            }
        }
    }
}
