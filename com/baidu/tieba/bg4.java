package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.zf4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bg4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements zf4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gf4 a;

        public a(gf4 gf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gf4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gf4Var;
        }

        @Override // com.baidu.tieba.zf4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                y72.i("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.zf4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                y72.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, ig4 ig4Var, kx2 kx2Var, gf4 gf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, ig4Var, kx2Var, gf4Var) == null) {
            b(context, ig4Var, kx2Var, gf4Var, false);
        }
    }

    public static void b(Context context, ig4 ig4Var, kx2 kx2Var, gf4 gf4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, ig4Var, kx2Var, gf4Var, Boolean.valueOf(z)}) == null) {
            if (ig4Var != null && kx2Var != null && kx2Var.isValid()) {
                BaiduMap map = ig4Var.l.getMap();
                eg4 eg4Var = new eg4(ig4Var);
                map.setOnMapClickListener(eg4Var);
                map.setOnMarkerClickListener(eg4Var);
                map.setOnMapLoadedCallback(eg4Var);
                map.setOnMapRenderCallbadk(eg4Var);
                map.setOnMapStatusChangeListener(eg4Var);
                map.setOnMyLocationClickListener(eg4Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(kx2Var.t);
                uiSettings.setRotateGesturesEnabled(kx2Var.u);
                uiSettings.setZoomGesturesEnabled(kx2Var.s);
                ig4Var.l.showZoomControls(false);
                ig4Var.l.showScaleControl(false);
                map.setBuildingsEnabled(kx2Var.x);
                uiSettings.setOverlookingGesturesEnabled(kx2Var.w);
                rx2 rx2Var = kx2Var.j;
                if (rx2Var != null && rx2Var.isValid()) {
                    y72.i("map", "initMapView coordinate is " + kx2Var.j);
                    rx2 rx2Var2 = kx2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(rx2Var2.a, rx2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) kx2Var.k));
                y72.i("map", "initMapView scale is " + kx2Var.k);
                boolean z2 = kx2Var.r;
                ig4Var.k = z2;
                if (z2) {
                    c(context, gf4Var);
                } else {
                    gf4Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(kx2Var.v);
                cg4.e(AppRuntime.getAppContext(), kx2Var, ig4Var);
                cg4.d(kx2Var, ig4Var, eg4Var);
                return;
            }
            y72.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, gf4 gf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, gf4Var) == null) {
            zf4.b(context, new a(gf4Var));
        }
    }
}
