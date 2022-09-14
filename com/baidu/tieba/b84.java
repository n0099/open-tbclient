package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.z74;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements z74.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g74 a;

        public a(g74 g74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g74Var;
        }

        @Override // com.baidu.tieba.z74.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                yz1.i("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.z74.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                yz1.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, i84 i84Var, kp2 kp2Var, g74 g74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, i84Var, kp2Var, g74Var) == null) {
            b(context, i84Var, kp2Var, g74Var, false);
        }
    }

    public static void b(Context context, i84 i84Var, kp2 kp2Var, g74 g74Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, i84Var, kp2Var, g74Var, Boolean.valueOf(z)}) == null) {
            if (i84Var != null && kp2Var != null && kp2Var.isValid()) {
                BaiduMap map = i84Var.l.getMap();
                e84 e84Var = new e84(i84Var);
                map.setOnMapClickListener(e84Var);
                map.setOnMarkerClickListener(e84Var);
                map.setOnMapLoadedCallback(e84Var);
                map.setOnMapRenderCallbadk(e84Var);
                map.setOnMapStatusChangeListener(e84Var);
                map.setOnMyLocationClickListener(e84Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(kp2Var.t);
                uiSettings.setRotateGesturesEnabled(kp2Var.u);
                uiSettings.setZoomGesturesEnabled(kp2Var.s);
                i84Var.l.showZoomControls(false);
                i84Var.l.showScaleControl(false);
                map.setBuildingsEnabled(kp2Var.x);
                uiSettings.setOverlookingGesturesEnabled(kp2Var.w);
                rp2 rp2Var = kp2Var.j;
                if (rp2Var != null && rp2Var.isValid()) {
                    yz1.i("map", "initMapView coordinate is " + kp2Var.j);
                    rp2 rp2Var2 = kp2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(rp2Var2.a, rp2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) kp2Var.k));
                yz1.i("map", "initMapView scale is " + kp2Var.k);
                boolean z2 = kp2Var.r;
                i84Var.k = z2;
                if (z2) {
                    c(context, g74Var);
                } else {
                    g74Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(kp2Var.v);
                c84.e(AppRuntime.getAppContext(), kp2Var, i84Var);
                c84.d(kp2Var, i84Var, e84Var);
                return;
            }
            yz1.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, g74 g74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, g74Var) == null) {
            z74.b(context, new a(g74Var));
        }
    }
}
