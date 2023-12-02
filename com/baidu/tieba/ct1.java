package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ct1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;
    public volatile long c;
    public long d;
    public long e;
    public long f;
    public String g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947686185, "Lcom/baidu/tieba/ct1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947686185, "Lcom/baidu/tieba/ct1;");
                return;
            }
        }
        boolean z = vm1.a;
    }

    public ct1() {
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
        this.g = "1";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @NonNull
    public String a() {
        InterceptResult invokeV;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = this.g;
            switch (str.hashCode()) {
                case 48:
                    if (str.equals("0")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 49:
                    if (str.equals("1")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 50:
                    if (str.equals("2")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 51:
                    if (str.equals("3")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c != 3) {
                            return "unknown";
                        }
                        return "fip";
                    }
                    return "ftp";
                }
                return "fcp";
            }
            return "fmp";
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "WebViewPaintTiming{fp=" + this.a + ", fcp=" + this.b + ", fmp=" + this.c + ", ftp=" + this.d + ", fip=" + this.e + ", mMinCache=" + this.f + ", fmpType='" + this.g + "', fmpTypeName='" + a() + "'}";
        }
        return (String) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long j = this.f;
            if (j > 0) {
                return j;
            }
            long[] jArr = {this.d, this.e, this.b};
            long j2 = Long.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                long j3 = jArr[i];
                if (j3 > 0 && j3 < j2) {
                    j2 = j3;
                }
            }
            if (j2 != Long.MAX_VALUE) {
                this.f = j2;
            }
            return this.f;
        }
        return invokeV.longValue;
    }

    public String c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            if (j == this.d) {
                return "2";
            }
            if (j == this.e) {
                return "3";
            }
            if (j == this.b || j != this.c) {
                return "1";
            }
            return "0";
        }
        return (String) invokeJ.objValue;
    }
}
