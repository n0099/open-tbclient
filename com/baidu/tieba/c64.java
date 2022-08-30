package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.a64;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c64 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements a64.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h54 a;

        public a(h54 h54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h54Var;
        }

        @Override // com.baidu.tieba.a64.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ay1.i("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.a64.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                ay1.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, j64 j64Var, mn2 mn2Var, h54 h54Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, j64Var, mn2Var, h54Var) == null) {
            b(context, j64Var, mn2Var, h54Var, false);
        }
    }

    public static void b(Context context, j64 j64Var, mn2 mn2Var, h54 h54Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, j64Var, mn2Var, h54Var, Boolean.valueOf(z)}) == null) {
            if (j64Var != null && mn2Var != null && mn2Var.isValid()) {
                BaiduMap map = j64Var.l.getMap();
                f64 f64Var = new f64(j64Var);
                map.setOnMapClickListener(f64Var);
                map.setOnMarkerClickListener(f64Var);
                map.setOnMapLoadedCallback(f64Var);
                map.setOnMapRenderCallbadk(f64Var);
                map.setOnMapStatusChangeListener(f64Var);
                map.setOnMyLocationClickListener(f64Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(mn2Var.t);
                uiSettings.setRotateGesturesEnabled(mn2Var.u);
                uiSettings.setZoomGesturesEnabled(mn2Var.s);
                j64Var.l.showZoomControls(false);
                j64Var.l.showScaleControl(false);
                map.setBuildingsEnabled(mn2Var.x);
                uiSettings.setOverlookingGesturesEnabled(mn2Var.w);
                tn2 tn2Var = mn2Var.j;
                if (tn2Var != null && tn2Var.isValid()) {
                    ay1.i("map", "initMapView coordinate is " + mn2Var.j);
                    tn2 tn2Var2 = mn2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(tn2Var2.a, tn2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) mn2Var.k));
                ay1.i("map", "initMapView scale is " + mn2Var.k);
                boolean z2 = mn2Var.r;
                j64Var.k = z2;
                if (z2) {
                    c(context, h54Var);
                } else {
                    h54Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(mn2Var.v);
                d64.e(AppRuntime.getAppContext(), mn2Var, j64Var);
                d64.d(mn2Var, j64Var, f64Var);
                return;
            }
            ay1.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, h54 h54Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, h54Var) == null) {
            a64.b(context, new a(h54Var));
        }
    }
}
