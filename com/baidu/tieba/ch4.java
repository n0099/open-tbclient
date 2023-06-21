package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.ah4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ch4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements ah4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hg4 a;

        public a(hg4 hg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hg4Var;
        }

        @Override // com.baidu.tieba.ah4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                z82.i("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.ah4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                z82.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, jh4 jh4Var, ly2 ly2Var, hg4 hg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, jh4Var, ly2Var, hg4Var) == null) {
            b(context, jh4Var, ly2Var, hg4Var, false);
        }
    }

    public static void b(Context context, jh4 jh4Var, ly2 ly2Var, hg4 hg4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, jh4Var, ly2Var, hg4Var, Boolean.valueOf(z)}) == null) {
            if (jh4Var != null && ly2Var != null && ly2Var.isValid()) {
                BaiduMap map = jh4Var.l.getMap();
                fh4 fh4Var = new fh4(jh4Var);
                map.setOnMapClickListener(fh4Var);
                map.setOnMarkerClickListener(fh4Var);
                map.setOnMapLoadedCallback(fh4Var);
                map.setOnMapRenderCallbadk(fh4Var);
                map.setOnMapStatusChangeListener(fh4Var);
                map.setOnMyLocationClickListener(fh4Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(ly2Var.t);
                uiSettings.setRotateGesturesEnabled(ly2Var.u);
                uiSettings.setZoomGesturesEnabled(ly2Var.s);
                jh4Var.l.showZoomControls(false);
                jh4Var.l.showScaleControl(false);
                map.setBuildingsEnabled(ly2Var.x);
                uiSettings.setOverlookingGesturesEnabled(ly2Var.w);
                sy2 sy2Var = ly2Var.j;
                if (sy2Var != null && sy2Var.isValid()) {
                    z82.i("map", "initMapView coordinate is " + ly2Var.j);
                    sy2 sy2Var2 = ly2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(sy2Var2.a, sy2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) ly2Var.k));
                z82.i("map", "initMapView scale is " + ly2Var.k);
                boolean z2 = ly2Var.r;
                jh4Var.k = z2;
                if (z2) {
                    c(context, hg4Var);
                } else {
                    hg4Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(ly2Var.v);
                dh4.e(AppRuntime.getAppContext(), ly2Var, jh4Var);
                dh4.d(ly2Var, jh4Var, fh4Var);
                return;
            }
            z82.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, hg4 hg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, hg4Var) == null) {
            ah4.b(context, new a(hg4Var));
        }
    }
}
