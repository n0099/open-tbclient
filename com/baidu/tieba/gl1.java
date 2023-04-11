package com.baidu.tieba;

import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.smallgame.sdk.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class gl1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int d = 1;
    public static int e = 2;
    public static int f = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, String> a;
    public Map<String, String> b;
    public SharedPreferences c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947797661, "Lcom/baidu/tieba/gl1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947797661, "Lcom/baidu/tieba/gl1;");
        }
    }

    public gl1() {
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
        this.a = new HashMap();
        this.b = new HashMap();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
        }
    }

    public String b(int i, String str) {
        InterceptResult invokeIL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str)) == null) {
            if (i == d) {
                str2 = this.a.get(str);
            } else if (i == e) {
                str2 = this.b.get(str);
            } else {
                if (i == f) {
                    SharedPreferences sharedPreferences = this.c;
                    if (sharedPreferences != null) {
                        str2 = sharedPreferences.getString(str, "");
                    } else {
                        Log.e("TAG", "prefs data store is null");
                    }
                }
                str2 = null;
            }
            if (str2 == null) {
                return "";
            }
            return str2;
        }
        return (String) invokeIL.objValue;
    }

    public void c(SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sharedPreferences) == null) {
            this.c = sharedPreferences;
        }
    }

    public void d(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i, str, str2) == null) {
            if (i == d) {
                this.a.put(str, str2);
            } else if (i == e) {
                this.b.put(str, str2);
            } else if (i == f) {
                SharedPreferences sharedPreferences = this.c;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putString(str, str2).commit();
                } else {
                    Log.e("TAG", "prefs data store is null");
                }
            }
        }
    }
}
