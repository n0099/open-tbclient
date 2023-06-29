package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.dh4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class fh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements dh4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kg4 a;

        public a(kg4 kg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kg4Var;
        }

        @Override // com.baidu.tieba.dh4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c92.i("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.dh4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                c92.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, mh4 mh4Var, oy2 oy2Var, kg4 kg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, mh4Var, oy2Var, kg4Var) == null) {
            b(context, mh4Var, oy2Var, kg4Var, false);
        }
    }

    public static void b(Context context, mh4 mh4Var, oy2 oy2Var, kg4 kg4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, mh4Var, oy2Var, kg4Var, Boolean.valueOf(z)}) == null) {
            if (mh4Var != null && oy2Var != null && oy2Var.isValid()) {
                BaiduMap map = mh4Var.l.getMap();
                ih4 ih4Var = new ih4(mh4Var);
                map.setOnMapClickListener(ih4Var);
                map.setOnMarkerClickListener(ih4Var);
                map.setOnMapLoadedCallback(ih4Var);
                map.setOnMapRenderCallbadk(ih4Var);
                map.setOnMapStatusChangeListener(ih4Var);
                map.setOnMyLocationClickListener(ih4Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(oy2Var.t);
                uiSettings.setRotateGesturesEnabled(oy2Var.u);
                uiSettings.setZoomGesturesEnabled(oy2Var.s);
                mh4Var.l.showZoomControls(false);
                mh4Var.l.showScaleControl(false);
                map.setBuildingsEnabled(oy2Var.x);
                uiSettings.setOverlookingGesturesEnabled(oy2Var.w);
                vy2 vy2Var = oy2Var.j;
                if (vy2Var != null && vy2Var.isValid()) {
                    c92.i("map", "initMapView coordinate is " + oy2Var.j);
                    vy2 vy2Var2 = oy2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(vy2Var2.a, vy2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) oy2Var.k));
                c92.i("map", "initMapView scale is " + oy2Var.k);
                boolean z2 = oy2Var.r;
                mh4Var.k = z2;
                if (z2) {
                    c(context, kg4Var);
                } else {
                    kg4Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(oy2Var.v);
                gh4.e(AppRuntime.getAppContext(), oy2Var, mh4Var);
                gh4.d(oy2Var, mh4Var, ih4Var);
                return;
            }
            c92.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, kg4 kg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, kg4Var) == null) {
            dh4.b(context, new a(kg4Var));
        }
    }
}
