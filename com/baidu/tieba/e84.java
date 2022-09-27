package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e84 extends x74<wp2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947688200, "Lcom/baidu/tieba/e84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947688200, "Lcom/baidu/tieba/e84;");
                return;
            }
        }
        boolean z = vj1.a;
    }

    public e84() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static e84 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new e84() : (e84) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.x74
    /* renamed from: d */
    public boolean b(Context context, wp2 wp2Var, up2 up2Var, l33 l33Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, wp2Var, up2Var, l33Var, jSONObject)) == null) ? f(context, wp2Var, up2Var, l33Var) : invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, wp2 wp2Var, up2 up2Var, l33 l33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, wp2Var, up2Var, l33Var)) == null) {
            l02.i("map", "IncludePointsAction start");
            tp1 A = yo2.U().A(wp2Var.c);
            if (!(A instanceof rp1)) {
                l02.c("map", "WebViewManager is null");
                return false;
            }
            v84 d = u74.b().c((rp1) A).d(wp2Var.b);
            if (d == null) {
                l02.c("map", "can not find map by id " + wp2Var.b);
                return false;
            }
            l02.i("map", "IncludePointsAction end");
            return g(wp2Var, d);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(wp2 wp2Var, v84 v84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, wp2Var, v84Var)) == null) {
            if (wp2Var == null || !wp2Var.isValid()) {
                return false;
            }
            BaiduMap map = v84Var.l.getMap();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Iterator<eq2> it = wp2Var.z.iterator();
            while (it.hasNext()) {
                eq2 next = it.next();
                builder.include(new LatLng(next.a, next.b));
            }
            LatLngBounds build = builder.build();
            int[] iArr = wp2Var.A;
            map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, iArr[3], iArr[0], iArr[1], iArr[2]));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
