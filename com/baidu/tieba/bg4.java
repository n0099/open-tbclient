package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.hv2;
import com.baidu.tieba.ig4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bg4 extends tf4<tx2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements ig4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ rg4 b;
        public final /* synthetic */ pf4 c;
        public final /* synthetic */ bg4 d;

        public a(bg4 bg4Var, Context context, rg4 rg4Var, pf4 pf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bg4Var, context, rg4Var, pf4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = bg4Var;
            this.a = context;
            this.b = rg4Var;
            this.c = pf4Var;
        }

        @Override // com.baidu.tieba.ig4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h82.o("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.ig4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                h82.o("map", "location permission success");
                this.d.e(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements hv2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rg4 a;
        public final /* synthetic */ pf4 b;

        public b(bg4 bg4Var, rg4 rg4Var, pf4 pf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bg4Var, rg4Var, pf4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rg4Var;
            this.b = pf4Var;
        }

        @Override // com.baidu.tieba.hv2.a
        public void a(ge3 ge3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ge3Var) == null) {
                h82.i("map", "get location " + ge3Var.a().toString());
                BaiduMap map = this.a.l.getMap();
                map.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(ge3Var.c, ge3Var.b)));
                map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                map.setMyLocationEnabled(true);
                map.setMyLocationData(new MyLocationData.Builder().accuracy((float) ge3Var.e).latitude(ge3Var.c).longitude(ge3Var.b).build());
                this.b.p(true);
            }
        }

        @Override // com.baidu.tieba.hv2.a
        public void onFailed(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                h82.i("map", "get location error " + i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947643994, "Lcom/baidu/tieba/bg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947643994, "Lcom/baidu/tieba/bg4;");
                return;
            }
        }
        boolean z = rr1.a;
    }

    public bg4() {
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

    public static bg4 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new bg4();
        }
        return (bg4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tf4
    public boolean b(Context context, tx2 tx2Var, qx2 qx2Var, hb3 hb3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, tx2Var, qx2Var, hb3Var, jSONObject)) == null) {
            return g(context, tx2Var, qx2Var, hb3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final void e(Context context, rg4 rg4Var, pf4 pf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, rg4Var, pf4Var) == null) {
            ou2.I().b("gcj02", true, false, new b(this, rg4Var, pf4Var));
        }
    }

    public final boolean g(Context context, tx2 tx2Var, qx2 qx2Var, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, tx2Var, qx2Var, hb3Var)) == null) {
            h82.i("map", "MoveToLocationAction start");
            px1 A = uw2.T().A(tx2Var.c);
            if (!(A instanceof nx1)) {
                h82.c("map", "WebViewManager is null");
                return false;
            }
            pf4 c = qf4.b().c((nx1) A);
            rg4 d = c.d(tx2Var.b);
            if (d == null) {
                h82.c("map", "can not find map by id " + tx2Var.b);
                return false;
            } else if (!d.k) {
                h82.o("map", "can not move to location because showLocation is not set");
                return false;
            } else {
                BDLocation e = c.e();
                if (e != null && c.g()) {
                    d.l.getMap().animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(e.getLatitude(), e.getLongitude())));
                    d.l.getMap().setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    d.l.getMap().setMyLocationEnabled(true);
                    d.l.getMap().setMyLocationData(new MyLocationData.Builder().accuracy(e.getRadius()).latitude(e.getLatitude()).longitude(e.getLongitude()).build());
                    h82.i("map", "MoveToLocationAction end");
                    return true;
                }
                ig4.b(context, new a(this, context, d, c));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
