package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.zg4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements zg4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gg4 a;

        public a(gg4 gg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gg4Var;
        }

        @Override // com.baidu.tieba.zg4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                y82.i("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.zg4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                y82.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, ih4 ih4Var, ky2 ky2Var, gg4 gg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, ih4Var, ky2Var, gg4Var) == null) {
            b(context, ih4Var, ky2Var, gg4Var, false);
        }
    }

    public static void b(Context context, ih4 ih4Var, ky2 ky2Var, gg4 gg4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, ih4Var, ky2Var, gg4Var, Boolean.valueOf(z)}) == null) {
            if (ih4Var != null && ky2Var != null && ky2Var.isValid()) {
                BaiduMap map = ih4Var.l.getMap();
                eh4 eh4Var = new eh4(ih4Var);
                map.setOnMapClickListener(eh4Var);
                map.setOnMarkerClickListener(eh4Var);
                map.setOnMapLoadedCallback(eh4Var);
                map.setOnMapRenderCallbadk(eh4Var);
                map.setOnMapStatusChangeListener(eh4Var);
                map.setOnMyLocationClickListener(eh4Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(ky2Var.t);
                uiSettings.setRotateGesturesEnabled(ky2Var.u);
                uiSettings.setZoomGesturesEnabled(ky2Var.s);
                ih4Var.l.showZoomControls(false);
                ih4Var.l.showScaleControl(false);
                map.setBuildingsEnabled(ky2Var.x);
                uiSettings.setOverlookingGesturesEnabled(ky2Var.w);
                ry2 ry2Var = ky2Var.j;
                if (ry2Var != null && ry2Var.isValid()) {
                    y82.i("map", "initMapView coordinate is " + ky2Var.j);
                    ry2 ry2Var2 = ky2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(ry2Var2.a, ry2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) ky2Var.k));
                y82.i("map", "initMapView scale is " + ky2Var.k);
                boolean z2 = ky2Var.r;
                ih4Var.k = z2;
                if (z2) {
                    c(context, gg4Var);
                } else {
                    gg4Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(ky2Var.v);
                ch4.e(AppRuntime.getAppContext(), ky2Var, ih4Var);
                ch4.d(ky2Var, ih4Var, eh4Var);
                return;
            }
            y82.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, gg4 gg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, gg4Var) == null) {
            zg4.b(context, new a(gg4Var));
        }
    }
}
