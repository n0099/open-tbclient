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
/* loaded from: classes4.dex */
public class fe4 extends yd4<xv2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947761236, "Lcom/baidu/tieba/fe4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947761236, "Lcom/baidu/tieba/fe4;");
                return;
            }
        }
        boolean z = wp1.a;
    }

    public fe4() {
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

    public static fe4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new fe4();
        }
        return (fe4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yd4
    /* renamed from: d */
    public boolean b(Context context, xv2 xv2Var, vv2 vv2Var, m93 m93Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, xv2Var, vv2Var, m93Var, jSONObject)) == null) {
            return f(context, xv2Var, vv2Var, m93Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, xv2 xv2Var, vv2 vv2Var, m93 m93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, xv2Var, vv2Var, m93Var)) == null) {
            m62.i("map", "IncludePointsAction start");
            uv1 A = zu2.U().A(xv2Var.c);
            if (!(A instanceof sv1)) {
                m62.c("map", "WebViewManager is null");
                return false;
            }
            we4 d = vd4.b().c((sv1) A).d(xv2Var.b);
            if (d == null) {
                m62.c("map", "can not find map by id " + xv2Var.b);
                return false;
            }
            m62.i("map", "IncludePointsAction end");
            return g(xv2Var, d);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(xv2 xv2Var, we4 we4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, xv2Var, we4Var)) == null) {
            if (xv2Var == null || !xv2Var.isValid()) {
                return false;
            }
            BaiduMap map = we4Var.l.getMap();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Iterator<fw2> it = xv2Var.z.iterator();
            while (it.hasNext()) {
                fw2 next = it.next();
                builder.include(new LatLng(next.a, next.b));
            }
            LatLngBounds build = builder.build();
            int[] iArr = xv2Var.A;
            map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, iArr[3], iArr[0], iArr[1], iArr[2]));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
