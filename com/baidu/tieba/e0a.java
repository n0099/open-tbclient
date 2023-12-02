package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e0a {
    public static /* synthetic */ Interceptable $ic;
    public static e0a b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, Integer> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947681907, "Lcom/baidu/tieba/e0a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947681907, "Lcom/baidu/tieba/e0a;");
        }
    }

    public e0a() {
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
        this.a = new HashMap<>();
        c();
    }

    public static e0a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (e0a.class) {
                    if (b == null) {
                        b = new e0a();
                    }
                }
            }
            return b;
        }
        return (e0a) invokeV.objValue;
    }

    public int b(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Integer num = this.a.get(str);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }
        return invokeL.intValue;
    }

    public int d(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            Integer remove = this.a.remove(str);
            if (remove != null) {
                f();
                return remove.intValue();
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String string = SharedPrefHelper.getInstance().getString("key_recently_visited_pb_forum_post", "");
            if (!rd.isEmpty(string)) {
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.a.put(next, Integer.valueOf(jSONObject.getInt(next)));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, Integer> entry : this.a.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException e) {
                    BdLog.e(e);
                }
            }
            SharedPrefHelper.getInstance().putString("key_recently_visited_pb_forum_post", jSONObject.toString());
        }
    }

    public void e(@NonNull String str, @NonNull int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048579, this, str, i) != null) || this.a.size() >= Integer.MAX_VALUE) {
            return;
        }
        Integer num = this.a.get(str);
        if (num == null || i != num.intValue()) {
            this.a.put(str, Integer.valueOf(i));
            f();
        }
    }
}
