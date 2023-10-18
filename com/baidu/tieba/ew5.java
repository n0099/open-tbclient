package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class ew5 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947748774, "Lcom/baidu/tieba/ew5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947748774, "Lcom/baidu/tieba/ew5;");
                return;
            }
        }
        a = new a(null);
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

        @JvmStatic
        public final void a(StatisticItem item, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLLL(1048576, this, item, str, str2, str3, str4) == null) {
                Intrinsics.checkNotNullParameter(item, "item");
                if (!TextUtils.isEmpty(str)) {
                    item.param("obj_id", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    item.param(TiebaStatic.Params.OBJ_ISAD, str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    item.param(TiebaStatic.Params.OBJ_PARAM2, c(str3));
                }
                if (!TextUtils.isEmpty(str4)) {
                    item.param(TiebaStatic.Params.OBJ_TO, c(str4));
                }
            }
        }

        @JvmStatic
        public final void b(StatisticItem item, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item, str, str2, str3) == null) {
                Intrinsics.checkNotNullParameter(item, "item");
                if (!TextUtils.isEmpty(str)) {
                    item.param("obj_id", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    item.param(TiebaStatic.Params.OBJ_ISAD, str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    item.param(TiebaStatic.Params.OBJ_PARAM2, c(str3));
                }
            }
        }

        public final String c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                if (str == null) {
                    return "";
                }
                try {
                    return URLEncoder.encode(str, "UTF-8");
                } catch (Exception unused) {
                    return str;
                }
            }
            return (String) invokeL.objValue;
        }
    }
}
