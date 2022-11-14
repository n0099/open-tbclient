package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ew4 {
    public static /* synthetic */ Interceptable $ic;
    public static final ew4 c;
    public static final ew4 d;
    public static final ew4 e;
    public static final ew4 f;
    public static final ew4 g;
    public static final ew4 h;
    public static final ew4 i;
    public static final ew4 j;
    public static final ew4 k;
    public static final ew4 l;
    public static final ew4 m;
    public static final ew4 n;
    public static final ew4 o;
    public static final ew4 p;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final boolean b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947748743, "Lcom/baidu/tieba/ew4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947748743, "Lcom/baidu/tieba/ew4;");
                return;
            }
        }
        c = new ew4("sync_finish", false);
        d = new ew4("main_page_load_finish", false);
        e = new ew4("pb_load_finish", false);
        f = new ew4("frs_load_finish", false);
        g = new ew4("main_page_recommend", true);
        h = new ew4("main_page_common_tab", true);
        i = new ew4("main_page_hot_topic", true);
        j = new ew4("main_page_concern", true);
        k = new ew4("main_page_enter_forum", true);
        l = new ew4("main_page_message", true);
        m = new ew4("main_page_person_info", true);
        n = new ew4("write_page", true);
        o = new ew4("pb_page", true);
        p = new ew4("frs_page", true);
    }

    public ew4(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = z;
    }

    public static ew4 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return new ew4("main_page_common_tab_" + str, true);
        }
        return (ew4) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }
}
