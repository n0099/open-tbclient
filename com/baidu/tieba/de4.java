package com.baidu.tieba;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.map.view.OpenLocationBottomMenu;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.f82;
import com.baidu.tieba.we4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class de4 extends c82 implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMarkerClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextureMapView G0;
    public BaiduMap H0;
    public String I0;
    public Marker J0;
    public String K0;
    public String L0;
    public ImageView M0;
    public TextView N0;
    public TextView O0;
    public GeoCoder P0;
    public PopupWindow Q0;
    public OpenLocationBottomMenu R0;
    public View S0;
    public ImageView T0;
    public we4 U0;
    public BDLocation V0;
    public boolean W0;
    public ArrayList<String> X0;
    public float Y0;

    @Override // com.baidu.tieba.c82
    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.c82
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.c82
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.c82, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ de4 a;

        public a(de4 de4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = de4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.u3();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements OnGetGeoCoderResultListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ de4 a;

        @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
        public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, geoCodeResult) == null) {
            }
        }

        public b(de4 de4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = de4Var;
        }

        @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
        public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, reverseGeoCodeResult) == null) {
                if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
                    if (this.a.O0 != null && TextUtils.isEmpty(this.a.L0)) {
                        String address = reverseGeoCodeResult.getAddress();
                        de4 de4Var = this.a;
                        if (address == null) {
                            address = de4Var.getResources().getString(R.string.obfuscated_res_0x7f0f15e5);
                        }
                        de4Var.L0 = address;
                        this.a.O0.setText(this.a.L0);
                    }
                    if (this.a.N0 != null && TextUtils.isEmpty(this.a.K0)) {
                        String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                        de4 de4Var2 = this.a;
                        if (sematicDescription == null) {
                            sematicDescription = de4Var2.getResources().getString(R.string.obfuscated_res_0x7f0f15e5);
                        }
                        de4Var2.K0 = sematicDescription;
                        this.a.N0.setText(this.a.K0);
                    }
                    w52.i("map", "mAddress +" + this.a.L0 + " mName" + this.a.K0);
                    return;
                }
                this.a.N0.setText(R.string.obfuscated_res_0x7f0f15e5);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ de4 a;

        public c(de4 de4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = de4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.h3();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ de4 a;

        public d(de4 de4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = de4Var;
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                de4 de4Var = this.a;
                de4Var.g3(de4Var.S0, 1.0f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ de4 a;

        public e(de4 de4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = de4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.U0 != null && this.a.U0.i() != null) {
                BDLocation i = this.a.U0.i();
                this.a.H0.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(i.getLatitude(), i.getLongitude())));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements we4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ de4 a;

        public f(de4 de4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = de4Var;
        }

        @Override // com.baidu.tieba.we4.b
        public void a(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, bDLocation) != null) {
                return;
            }
            this.a.V0 = bDLocation;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947701654, "Lcom/baidu/tieba/de4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947701654, "Lcom/baidu/tieba/de4;");
                return;
            }
        }
        boolean z = gp1.a;
    }

    public de4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.I0 = "";
        this.Y0 = 0.5f;
    }

    @Override // com.baidu.tieba.c82
    public void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.I0);
            ju2.U().u(new xi2("sharebtn", hashMap));
        }
    }

    public void h3() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (popupWindow = this.Q0) != null && popupWindow.x()) {
            this.Q0.r();
        }
    }

    public BDLocation i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.V0;
        }
        return (BDLocation) invokeV.objValue;
    }

    @Override // com.baidu.tieba.c82
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            p3();
            this.g0.t(ds2.M().a(), H1());
        }
    }

    public boolean j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.W0;
        }
        return invokeV.booleanValue;
    }

    public List<String> k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.X0;
        }
        return (List) invokeV.objValue;
    }

    public BaiduMap l3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.H0;
        }
        return (BaiduMap) invokeV.objValue;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            w52.i("map", "onMapLoaded");
            s3();
        }
    }

    public void v3() {
        f82 V;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (V = ju2.U().V()) != null) {
            f82.b i = V.i("navigateTo");
            i.n(f82.g, f82.i);
            i.j(this);
            i.b();
        }
    }

    public final void w3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            we4 we4Var = new we4(ju2.U().getActivity(), this.H0);
            this.U0 = we4Var;
            we4Var.n(true);
            this.U0.k(new f(this));
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0() {
        TextureMapView textureMapView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.y0();
            GeoCoder geoCoder = this.P0;
            if (geoCoder != null) {
                geoCoder.destroy();
            }
            OpenLocationBottomMenu.l();
            we4 we4Var = this.U0;
            if (we4Var != null) {
                we4Var.n(false);
            }
            if (Build.VERSION.SDK_INT > 19 && (textureMapView = this.G0) != null) {
                textureMapView.onDestroy();
            }
        }
    }

    public static de4 r3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bundle)) == null) {
            de4 de4Var = new de4();
            if (bundle != null) {
                de4Var.j1(bundle);
            }
            dd4.a();
            return de4Var;
        }
        return (de4) invokeL.objValue;
    }

    public final void n3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view2) == null) {
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090d70);
            this.T0 = imageView;
            imageView.setOnClickListener(new e(this));
        }
    }

    public final void q3(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, latLng) == null) {
            this.P0 = GeoCoder.newInstance();
            this.P0.setOnGetGeoCodeResultListener(new b(this));
            this.P0.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
        }
    }

    public void t3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.W0 = z;
        }
    }

    public final void g3(View view2, float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLF(1048580, this, view2, f2) != null) || view2 == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view2.getRootView();
        ViewGroupOverlay overlay = viewGroup.getOverlay();
        if (Float.valueOf(f2).equals(Float.valueOf(1.0f))) {
            overlay.clear();
            return;
        }
        ColorDrawable colorDrawable = new ColorDrawable(-16777216);
        colorDrawable.setBounds(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
        colorDrawable.setAlpha((int) (f2 * 255.0f));
        overlay.add(colorDrawable);
    }

    public final void m3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            this.S0 = view2;
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09152d);
            this.M0 = imageView;
            imageView.setOnClickListener(new a(this));
            this.N0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091533);
            this.O0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091532);
        }
    }

    public final void o3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            TextureMapView textureMapView = (TextureMapView) view2.findViewById(R.id.obfuscated_res_0x7f090365);
            this.G0 = textureMapView;
            BaiduMap map = textureMapView.getMap();
            this.H0 = map;
            map.getUiSettings().setRotateGesturesEnabled(false);
            this.G0.showZoomControls(false);
            this.H0.getUiSettings().setOverlookingGesturesEnabled(false);
            this.H0.setOnMapLoadedCallback(this);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, marker)) == null) {
            if (marker == this.J0 && !TextUtils.isEmpty(this.K0)) {
                LinearLayout linearLayout = new LinearLayout(AppRuntime.getAppContext());
                linearLayout.setOrientation(1);
                TextView textView = new TextView(AppRuntime.getAppContext());
                textView.setText(this.K0);
                textView.setTextSize(18.0f);
                TextView textView2 = new TextView(AppRuntime.getAppContext());
                textView2.setText(this.L0);
                textView2.setTextSize(15.0f);
                linearLayout.addView(textView);
                linearLayout.addView(textView2);
                this.H0.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void p3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.g0 == null) {
            this.g0 = new df4(getContext(), this.f0, 12, ds2.K(), new fo3());
            new my2(this.g0, this).z();
        }
    }

    public final void s3() {
        Bundle p;
        String str;
        TextView textView;
        TextView textView2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (p = p()) != null && p.size() > 0) {
            this.I0 = p.getString("slaveId");
            double d2 = p.getDouble("latitude");
            double d3 = p.getDouble("longitude");
            double d4 = p.getDouble("scale");
            this.K0 = p.getString("name");
            this.L0 = p.getString("address");
            LatLng latLng = new LatLng(d2, d3);
            if (TextUtils.isEmpty(this.K0)) {
                if (TextUtils.isEmpty(this.L0)) {
                    q3(latLng);
                } else {
                    this.K0 = getResources().getString(R.string.obfuscated_res_0x7f0f15e4);
                }
            }
            this.H0.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.H0.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d4));
            BitmapDescriptor fromResource = BitmapDescriptorFactory.fromResource(R.drawable.obfuscated_res_0x7f08018c);
            if (TextUtils.isEmpty(this.K0)) {
                str = "";
            } else {
                str = this.K0;
            }
            this.J0 = (Marker) this.H0.addOverlay(new MarkerOptions().position(latLng).icon(fromResource).title(str).anchor(0.5f, 0.5f));
            w52.i("map", "show marker");
            if (!TextUtils.isEmpty(this.K0) && (textView2 = this.N0) != null) {
                textView2.setText(this.K0);
            }
            if (!TextUtils.isEmpty(this.L0) && (textView = this.O0) != null) {
                textView.setText(this.L0);
            }
            this.X0 = p.getStringArrayList("ignoredApps");
        }
    }

    public final void u3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || (activity = getActivity()) == null) {
            return;
        }
        PopupWindow popupWindow = this.Q0;
        if (popupWindow != null && popupWindow.x()) {
            return;
        }
        View inflate = View.inflate(activity, R.layout.obfuscated_res_0x7f0d00c0, null);
        inflate.setOnClickListener(new c(this));
        OpenLocationBottomMenu openLocationBottomMenu = (OpenLocationBottomMenu) inflate.findViewById(R.id.obfuscated_res_0x7f091851);
        this.R0 = openLocationBottomMenu;
        openLocationBottomMenu.setFragment(this);
        PopupWindow popupWindow2 = new PopupWindow(activity);
        this.Q0 = popupWindow2;
        popupWindow2.E(inflate);
        this.Q0.M(-1);
        this.Q0.G(-2);
        this.Q0.F(true);
        this.Q0.K(true);
        this.Q0.B(R.style.obfuscated_res_0x7f100141);
        this.Q0.O(this.S0, 80, 0, 0);
        this.Q0.J(new d(this));
        g3(this.S0, this.Y0);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048600, this, layoutInflater, viewGroup, bundle)) == null) {
            w52.i("map", "start MapLocationFragment");
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0088, viewGroup, false);
            U1(inflate);
            x2(Z1());
            J2(false);
            o3(inflate);
            m3(inflate);
            w3();
            n3(inflate);
            v2(AppRuntime.getAppContext().getResources().getString(R.string.obfuscated_res_0x7f0f01a1));
            if (T1()) {
                inflate = W1(inflate);
            }
            return D1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
