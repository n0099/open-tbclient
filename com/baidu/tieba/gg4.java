package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.eg4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gg4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements eg4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lf4 a;

        public a(lf4 lf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lf4Var;
        }

        @Override // com.baidu.tieba.eg4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d82.i("map", "location permission fail");
            }
        }

        @Override // com.baidu.tieba.eg4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p(true);
                d82.i("map", "location permission success");
            }
        }
    }

    public static void a(Context context, ng4 ng4Var, px2 px2Var, lf4 lf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, ng4Var, px2Var, lf4Var) == null) {
            b(context, ng4Var, px2Var, lf4Var, false);
        }
    }

    public static void b(Context context, ng4 ng4Var, px2 px2Var, lf4 lf4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, ng4Var, px2Var, lf4Var, Boolean.valueOf(z)}) == null) {
            if (ng4Var != null && px2Var != null && px2Var.isValid()) {
                BaiduMap map = ng4Var.l.getMap();
                jg4 jg4Var = new jg4(ng4Var);
                map.setOnMapClickListener(jg4Var);
                map.setOnMarkerClickListener(jg4Var);
                map.setOnMapLoadedCallback(jg4Var);
                map.setOnMapRenderCallbadk(jg4Var);
                map.setOnMapStatusChangeListener(jg4Var);
                map.setOnMyLocationClickListener(jg4Var);
                UiSettings uiSettings = map.getUiSettings();
                uiSettings.setScrollGesturesEnabled(px2Var.t);
                uiSettings.setRotateGesturesEnabled(px2Var.u);
                uiSettings.setZoomGesturesEnabled(px2Var.s);
                ng4Var.l.showZoomControls(false);
                ng4Var.l.showScaleControl(false);
                map.setBuildingsEnabled(px2Var.x);
                uiSettings.setOverlookingGesturesEnabled(px2Var.w);
                wx2 wx2Var = px2Var.j;
                if (wx2Var != null && wx2Var.isValid()) {
                    d82.i("map", "initMapView coordinate is " + px2Var.j);
                    wx2 wx2Var2 = px2Var.j;
                    map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(wx2Var2.a, wx2Var2.b)));
                }
                map.animateMapStatus(MapStatusUpdateFactory.zoomTo((float) px2Var.k));
                d82.i("map", "initMapView scale is " + px2Var.k);
                boolean z2 = px2Var.r;
                ng4Var.k = z2;
                if (z2) {
                    c(context, lf4Var);
                } else {
                    lf4Var.p(false);
                    map.setMyLocationEnabled(false);
                }
                uiSettings.setCompassEnabled(px2Var.v);
                hg4.e(AppRuntime.getAppContext(), px2Var, ng4Var);
                hg4.d(px2Var, ng4Var, jg4Var);
                return;
            }
            d82.c("map", "initMapView model is invalid");
        }
    }

    public static void c(Context context, lf4 lf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, lf4Var) == null) {
            eg4.b(context, new a(lf4Var));
        }
    }
}
