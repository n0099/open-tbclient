package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class ex {
    public static /* synthetic */ Interceptable $ic;
    public static ex b;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Integer, ActivityCompat.OnRequestPermissionsResultCallback> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448303962, "Lcom/baidu/tieba/ex;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448303962, "Lcom/baidu/tieba/ex;");
                return;
            }
        }
        b = new ex();
    }

    public ex() {
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
    }

    public static ex b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b;
        }
        return (ex) invokeV.objValue;
    }

    public void a(int i, ActivityCompat.OnRequestPermissionsResultCallback onRequestPermissionsResultCallback) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048576, this, i, onRequestPermissionsResultCallback) != null) || this.a == null) {
            return;
        }
        synchronized (ex.class) {
            if (this.a.containsKey(Integer.valueOf(i))) {
                this.a.remove(Integer.valueOf(i));
            }
            this.a.put(Integer.valueOf(i), onRequestPermissionsResultCallback);
        }
    }

    public ActivityCompat.OnRequestPermissionsResultCallback c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            Map<Integer, ActivityCompat.OnRequestPermissionsResultCallback> map = this.a;
            if (map != null && map.containsKey(Integer.valueOf(i))) {
                return this.a.get(Integer.valueOf(i));
            }
            return null;
        }
        return (ActivityCompat.OnRequestPermissionsResultCallback) invokeI.objValue;
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            synchronized (ex.class) {
                if (this.a != null && this.a.containsKey(Integer.valueOf(i))) {
                    this.a.remove(Integer.valueOf(i));
                }
            }
        }
    }
}
