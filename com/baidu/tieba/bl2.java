package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes5.dex */
public class bl2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bl2 b;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, vm2> a;

    public bl2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
    }

    public static bl2 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (bl2.class) {
                    if (b == null) {
                        b = new bl2();
                    }
                }
            }
            return b;
        }
        return (bl2) invokeV.objValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            if (b != null) {
                b.b();
            }
            b = null;
        }
    }

    public final synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                k32.i("RtcRoomWidgetManager", "release");
                Iterator it = new ArrayList(this.a.values()).iterator();
                while (it.hasNext()) {
                    ((vm2) it.next()).onRelease();
                }
                this.a.clear();
            }
        }
    }

    public synchronized void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            synchronized (this) {
                k32.i("RtcRoomWidgetManager", "onWebViewDetach slaveId=" + str);
                Iterator it = new ArrayList(this.a.values()).iterator();
                while (it.hasNext()) {
                    vm2 vm2Var = (vm2) it.next();
                    if (TextUtils.equals(vm2Var.b(), str)) {
                        vm2Var.onRelease();
                    }
                }
            }
        }
    }
}
