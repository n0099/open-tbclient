package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.g94;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class i94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements g94.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n84 a;

        public a(n84 n84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n84Var;
        }

        @Override // com.baidu.tieba.g94.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f12.i("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.g94.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                f12.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, p94 p94Var, rq2 rq2Var, n84 n84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, p94Var, rq2Var, n84Var) == null) {
            b(context, p94Var, rq2Var, n84Var, false);
        }
    }

    public static void b(Context context, p94 p94Var, rq2 rq2Var, n84 n84Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, p94Var, rq2Var, n84Var, Boolean.valueOf(z)}) == null) {
            if (p94Var != null && rq2Var != null && rq2Var.isValid()) {
                BaiduMap map = p94Var.l.getMap();
                l94 l94Var = new l94(p94Var);
                map.setOnMapClickListener(l94Var);
                map.setOnMarkerClickListener(l94Var);
                map.setOnMapLoadedCallback(l94Var);
                map.setOnMapRenderCallbadk(l94Var);
                map.setOnMapStatusChangeListener(l94Var);
                map.setOnMyLocationClickListener(l94Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(rq2Var.t);
                uiSettings.setRotateGesturesEnabled(rq2Var.u);
                uiSettings.setZoomGesturesEnabled(rq2Var.s);
                p94Var.l.showZoomControls(false);
                p94Var.l.showScaleControl(false);
                map.setBuildingsEnabled(rq2Var.x);
                uiSettings.setOverlookingGesturesEnabled(rq2Var.w);
                yq2 yq2Var = rq2Var.j;
                if (yq2Var != null && yq2Var.isValid()) {
                    f12.i("map", "initMapView coordinate is " + rq2Var.j);
                    yq2 yq2Var2 = rq2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(yq2Var2.a, yq2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) rq2Var.k));
                f12.i("map", "initMapView scale is " + rq2Var.k);
                boolean z2 = rq2Var.r;
                p94Var.k = z2;
                if (z2) {
                    c(context, n84Var);
                } else {
                    n84Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(rq2Var.v);
                j94.e(AppRuntime.getAppContext(), rq2Var, p94Var);
                j94.d(rq2Var, p94Var, l94Var);
                return;
            }
            f12.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, n84 n84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, n84Var) == null) {
            g94.b(context, new a(n84Var));
        }
    }
}
