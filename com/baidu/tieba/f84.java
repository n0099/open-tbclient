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
public class f84 extends y74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947717991, "Lcom/baidu/tieba/f84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947717991, "Lcom/baidu/tieba/f84;");
                return;
            }
        }
        boolean z = wj1.a;
    }

    public f84() {
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

    public static f84 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new f84();
        }
        return (f84) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.y74
    /* renamed from: d */
    public boolean b(Context context, xp2 xp2Var, vp2 vp2Var, m33 m33Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, xp2Var, vp2Var, m33Var, jSONObject)) == null) {
            return f(context, xp2Var, vp2Var, m33Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, xp2 xp2Var, vp2 vp2Var, m33 m33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, xp2Var, vp2Var, m33Var)) == null) {
            m02.i("map", "IncludePointsAction start");
            up1 A = zo2.U().A(xp2Var.c);
            if (!(A instanceof sp1)) {
                m02.c("map", "WebViewManager is null");
                return false;
            }
            w84 d = v74.b().c((sp1) A).d(xp2Var.b);
            if (d == null) {
                m02.c("map", "can not find map by id " + xp2Var.b);
                return false;
            }
            m02.i("map", "IncludePointsAction end");
            return g(xp2Var, d);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(xp2 xp2Var, w84 w84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, xp2Var, w84Var)) == null) {
            if (xp2Var == null || !xp2Var.isValid()) {
                return false;
            }
            BaiduMap map = w84Var.l.getMap();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Iterator it = xp2Var.z.iterator();
            while (it.hasNext()) {
                fq2 fq2Var = (fq2) it.next();
                builder.include(new LatLng(fq2Var.a, fq2Var.b));
            }
            LatLngBounds build = builder.build();
            int[] iArr = xp2Var.A;
            map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, iArr[3], iArr[0], iArr[1], iArr[2]));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
