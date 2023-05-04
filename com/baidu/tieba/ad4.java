package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.yc4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ad4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements yc4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fc4 a;

        public a(fc4 fc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fc4Var;
        }

        @Override // com.baidu.tieba.yc4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                x42.i("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.yc4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                x42.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, hd4 hd4Var, ju2 ju2Var, fc4 fc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, hd4Var, ju2Var, fc4Var) == null) {
            b(context, hd4Var, ju2Var, fc4Var, false);
        }
    }

    public static void b(Context context, hd4 hd4Var, ju2 ju2Var, fc4 fc4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, hd4Var, ju2Var, fc4Var, Boolean.valueOf(z)}) == null) {
            if (hd4Var != null && ju2Var != null && ju2Var.isValid()) {
                BaiduMap map = hd4Var.l.getMap();
                dd4 dd4Var = new dd4(hd4Var);
                map.setOnMapClickListener(dd4Var);
                map.setOnMarkerClickListener(dd4Var);
                map.setOnMapLoadedCallback(dd4Var);
                map.setOnMapRenderCallbadk(dd4Var);
                map.setOnMapStatusChangeListener(dd4Var);
                map.setOnMyLocationClickListener(dd4Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(ju2Var.t);
                uiSettings.setRotateGesturesEnabled(ju2Var.u);
                uiSettings.setZoomGesturesEnabled(ju2Var.s);
                hd4Var.l.showZoomControls(false);
                hd4Var.l.showScaleControl(false);
                map.setBuildingsEnabled(ju2Var.x);
                uiSettings.setOverlookingGesturesEnabled(ju2Var.w);
                qu2 qu2Var = ju2Var.j;
                if (qu2Var != null && qu2Var.isValid()) {
                    x42.i("map", "initMapView coordinate is " + ju2Var.j);
                    qu2 qu2Var2 = ju2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(qu2Var2.a, qu2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) ju2Var.k));
                x42.i("map", "initMapView scale is " + ju2Var.k);
                boolean z2 = ju2Var.r;
                hd4Var.k = z2;
                if (z2) {
                    c(context, fc4Var);
                } else {
                    fc4Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(ju2Var.v);
                bd4.e(AppRuntime.getAppContext(), ju2Var, hd4Var);
                bd4.d(ju2Var, hd4Var, dd4Var);
                return;
            }
            x42.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, fc4 fc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, fc4Var) == null) {
            yc4.b(context, new a(fc4Var));
        }
    }
}
