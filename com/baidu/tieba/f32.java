package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class f32 implements d32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static volatile f32 c;
    public transient /* synthetic */ FieldHolder $fh;
    public List<d32> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947713124, "Lcom/baidu/tieba/f32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947713124, "Lcom/baidu/tieba/f32;");
                return;
            }
        }
        b = rr1.a;
    }

    public f32() {
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
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        arrayList.add(new e32());
    }

    public static f32 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (f32.class) {
                    if (c == null) {
                        c = new f32();
                    }
                }
            }
            return c;
        }
        return (f32) invokeV.objValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (b) {
                    Log.d("Api-Marker", "release: ");
                }
                if (c == null) {
                    return;
                }
                c = null;
            }
        }
    }

    @Override // com.baidu.tieba.d32
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (b) {
                Log.d("Api-Marker", "markStart: " + str);
            }
            for (int i = 0; i < this.a.size(); i++) {
                this.a.get(i).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.d32
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (b) {
                Log.d("Api-Marker", "markEnd: " + str);
            }
            for (int i = 0; i < this.a.size(); i++) {
                this.a.get(i).b(str);
            }
        }
    }
}
