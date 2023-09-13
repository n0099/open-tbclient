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
/* loaded from: classes5.dex */
public class ag4 extends tf4<sx2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947614203, "Lcom/baidu/tieba/ag4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947614203, "Lcom/baidu/tieba/ag4;");
                return;
            }
        }
        boolean z = rr1.a;
    }

    public ag4() {
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

    public static ag4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new ag4();
        }
        return (ag4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tf4
    /* renamed from: d */
    public boolean b(Context context, sx2 sx2Var, qx2 qx2Var, hb3 hb3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, sx2Var, qx2Var, hb3Var, jSONObject)) == null) {
            return f(context, sx2Var, qx2Var, hb3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, sx2 sx2Var, qx2 qx2Var, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, sx2Var, qx2Var, hb3Var)) == null) {
            h82.i("map", "IncludePointsAction start");
            px1 A = uw2.T().A(sx2Var.c);
            if (!(A instanceof nx1)) {
                h82.c("map", "WebViewManager is null");
                return false;
            }
            rg4 d = qf4.b().c((nx1) A).d(sx2Var.b);
            if (d == null) {
                h82.c("map", "can not find map by id " + sx2Var.b);
                return false;
            }
            h82.i("map", "IncludePointsAction end");
            return g(sx2Var, d);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(sx2 sx2Var, rg4 rg4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, sx2Var, rg4Var)) == null) {
            if (sx2Var == null || !sx2Var.isValid()) {
                return false;
            }
            BaiduMap map = rg4Var.l.getMap();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Iterator<ay2> it = sx2Var.z.iterator();
            while (it.hasNext()) {
                ay2 next = it.next();
                builder.include(new LatLng(next.a, next.b));
            }
            LatLngBounds build = builder.build();
            int[] iArr = sx2Var.A;
            map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, iArr[3], iArr[0], iArr[1], iArr[2]));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
