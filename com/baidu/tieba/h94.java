package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.f94;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class h94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements f94.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m84 a;

        public a(m84 m84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m84Var;
        }

        @Override // com.baidu.tieba.f94.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e12.i("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.f94.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                e12.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, o94 o94Var, qq2 qq2Var, m84 m84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, o94Var, qq2Var, m84Var) == null) {
            b(context, o94Var, qq2Var, m84Var, false);
        }
    }

    public static void b(Context context, o94 o94Var, qq2 qq2Var, m84 m84Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, o94Var, qq2Var, m84Var, Boolean.valueOf(z)}) == null) {
            if (o94Var != null && qq2Var != null && qq2Var.isValid()) {
                BaiduMap map = o94Var.l.getMap();
                k94 k94Var = new k94(o94Var);
                map.setOnMapClickListener(k94Var);
                map.setOnMarkerClickListener(k94Var);
                map.setOnMapLoadedCallback(k94Var);
                map.setOnMapRenderCallbadk(k94Var);
                map.setOnMapStatusChangeListener(k94Var);
                map.setOnMyLocationClickListener(k94Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(qq2Var.t);
                uiSettings.setRotateGesturesEnabled(qq2Var.u);
                uiSettings.setZoomGesturesEnabled(qq2Var.s);
                o94Var.l.showZoomControls(false);
                o94Var.l.showScaleControl(false);
                map.setBuildingsEnabled(qq2Var.x);
                uiSettings.setOverlookingGesturesEnabled(qq2Var.w);
                xq2 xq2Var = qq2Var.j;
                if (xq2Var != null && xq2Var.isValid()) {
                    e12.i("map", "initMapView coordinate is " + qq2Var.j);
                    xq2 xq2Var2 = qq2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(xq2Var2.a, xq2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) qq2Var.k));
                e12.i("map", "initMapView scale is " + qq2Var.k);
                boolean z2 = qq2Var.r;
                o94Var.k = z2;
                if (z2) {
                    c(context, m84Var);
                } else {
                    m84Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(qq2Var.v);
                i94.e(AppRuntime.getAppContext(), qq2Var, o94Var);
                i94.d(qq2Var, o94Var, k94Var);
                return;
            }
            e12.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, m84 m84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, m84Var) == null) {
            f94.b(context, new a(m84Var));
        }
    }
}
