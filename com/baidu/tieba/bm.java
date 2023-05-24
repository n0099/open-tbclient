package com.baidu.tieba;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes5.dex */
public final class bm {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448300738, "Lcom/baidu/tieba/bm;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448300738, "Lcom/baidu/tieba/bm;");
                return;
            }
        }
        a = new a(null);
    }

    @JvmStatic
    public static final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            a.b(str);
        }
    }

    @JvmStatic
    public static final void b(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            a.c(str, str2, str3);
        }
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
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

        public final String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    return TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, Build.SUPPORTED_ABIS);
                }
                return Build.CPU_ABI2;
            }
            return (String) invokeV.objValue;
        }

        public final String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    return Application.getProcessName();
                }
                return "";
            }
            return (String) invokeV.objValue;
        }

        @JvmStatic
        public final void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                zk8 defaultLog = DefaultLog.getInstance();
                defaultLog.c("libnama check", "abi:" + a() + ", process: " + d() + ", thread:" + Thread.currentThread().getId() + ", msg: " + str);
            }
        }

        @JvmStatic
        public final void c(String name, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, name, str, str2) == null) {
                Intrinsics.checkNotNullParameter(name, "name");
                if (str != null && !TextUtils.isEmpty(name)) {
                    boolean z = false;
                    if (StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) "nama", false, 2, (Object) null)) {
                        zk8 defaultLog = DefaultLog.getInstance();
                        StringBuilder sb = new StringBuilder();
                        if ((str2 == null || str2.length() == 0) ? true : true) {
                            str2 = "";
                        }
                        sb.append(str2);
                        sb.append(", name:");
                        sb.append(name);
                        sb.append(", abi:");
                        sb.append(a());
                        sb.append(", process: ");
                        sb.append(d());
                        sb.append(", thread:");
                        sb.append(Thread.currentThread().getId());
                        sb.append(", packageinfo: ");
                        sb.append(str);
                        defaultLog.c("libnama check", sb.toString());
                    }
                }
            }
        }
    }
}
