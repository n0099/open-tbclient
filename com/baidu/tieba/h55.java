package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h55 {
    public static /* synthetic */ Interceptable $ic;
    public static final h55 c;
    public static final h55 d;
    public static final h55 e;
    public static final h55 f;
    public static final h55 g;
    public static final h55 h;
    public static final h55 i;
    public static final h55 j;
    public static final h55 k;
    public static final h55 l;
    public static final h55 m;
    public static final h55 n;
    public static final h55 o;
    public static final h55 p;
    public static final h55 q;
    public static final h55 r;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final boolean b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947774721, "Lcom/baidu/tieba/h55;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947774721, "Lcom/baidu/tieba/h55;");
                return;
            }
        }
        c = new h55("sync_finish", false);
        d = new h55("main_page_load_finish", false);
        e = new h55("pb_load_finish", false);
        f = new h55("frs_load_finish", false);
        g = new h55("main_page_recommend", true);
        h = new h55("main_page_common_tab", true);
        i = new h55("main_page_hot_topic", true);
        j = new h55("main_page_concern", true);
        k = new h55("main_page_enter_forum", true);
        l = new h55("main_page_message", true);
        m = new h55("main_page_person_info", true);
        n = new h55("write_page", true);
        o = new h55("pb_page", true);
        p = new h55("frs_page", true);
        q = new h55("main_page_idle", false);
        r = new h55("splash_close", false);
    }

    public h55(String str, boolean z) {
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

    public static h55 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return new h55("main_page_common_tab_" + str, true);
        }
        return (h55) invokeL.objValue;
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
