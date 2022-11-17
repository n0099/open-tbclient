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
public class fw4 {
    public static /* synthetic */ Interceptable $ic;
    public static final fw4 c;
    public static final fw4 d;
    public static final fw4 e;
    public static final fw4 f;
    public static final fw4 g;
    public static final fw4 h;
    public static final fw4 i;
    public static final fw4 j;
    public static final fw4 k;
    public static final fw4 l;
    public static final fw4 m;
    public static final fw4 n;
    public static final fw4 o;
    public static final fw4 p;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final boolean b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947778534, "Lcom/baidu/tieba/fw4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947778534, "Lcom/baidu/tieba/fw4;");
                return;
            }
        }
        c = new fw4("sync_finish", false);
        d = new fw4("main_page_load_finish", false);
        e = new fw4("pb_load_finish", false);
        f = new fw4("frs_load_finish", false);
        g = new fw4("main_page_recommend", true);
        h = new fw4("main_page_common_tab", true);
        i = new fw4("main_page_hot_topic", true);
        j = new fw4("main_page_concern", true);
        k = new fw4("main_page_enter_forum", true);
        l = new fw4("main_page_message", true);
        m = new fw4("main_page_person_info", true);
        n = new fw4("write_page", true);
        o = new fw4("pb_page", true);
        p = new fw4("frs_page", true);
    }

    public fw4(String str, boolean z) {
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

    public static fw4 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return new fw4("main_page_common_tab_" + str, true);
        }
        return (fw4) invokeL.objValue;
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
