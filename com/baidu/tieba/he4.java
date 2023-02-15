package com.baidu.tieba;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.LogoPosition;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.swan.map.location.FlipperFrameLayout;
import com.baidu.swan.map.location.LocationDetailAdapter;
import com.baidu.swan.map.location.LocationItemDecoration;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.f82;
import com.baidu.tieba.le4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class he4 extends c82 implements OnGetGeoCoderResultListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, View.OnClickListener, ie4, le4.b {
    public static /* synthetic */ Interceptable $ic;
    public static final int e1;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView G0;
    public FrameLayout H0;
    public ImageView I0;
    public FrameLayout J0;
    public FrameLayout K0;
    public View L0;
    public View M0;
    public TextView N0;
    public ImageView O0;
    public View P0;
    public GeoCoder Q0;
    public BaiduMap R0;
    public TextureMapView S0;
    public Marker T0;
    public BitmapDescriptor U0;
    public je4 V0;
    public List<je4> W0;
    public le4 X0;
    public LocationDetailAdapter Y0;
    public ke4 Z0;
    public boolean a1;
    public boolean b1;
    public b c1;
    public SelectedLocationInfo d1;

    /* loaded from: classes4.dex */
    public interface b {
        void a(SelectedLocationInfo selectedLocationInfo);

        void onCancel();

        void onError();
    }

    @Override // com.baidu.tieba.c82
    public void U1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
        }
    }

    @Override // com.baidu.tieba.c82
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.c82
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.c82, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.c82
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, geoCodeResult) == null) {
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChange(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, mapStatus) == null) {
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, mapStatus) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReverseGeoCodeResult a;
        public final /* synthetic */ he4 b;

        public a(he4 he4Var, ReverseGeoCodeResult reverseGeoCodeResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he4Var, reverseGeoCodeResult};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = he4Var;
            this.a = reverseGeoCodeResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.l3(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947820818, "Lcom/baidu/tieba/he4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947820818, "Lcom/baidu/tieba/he4;");
                return;
            }
        }
        e1 = nm3.g(20.0f);
    }

    public he4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.c82
    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            e3(17);
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Activity activity = this.c0;
            if (activity != null) {
                activity.onBackPressed();
            }
            this.c1 = null;
        }
    }

    public final void d3() {
        Marker marker;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (marker = this.T0) != null) {
            marker.remove();
            this.T0 = null;
        }
    }

    public void i3() {
        f82 V;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (V = ju2.U().V()) != null) {
            f82.b i = V.i("navigateTo");
            i.n(f82.g, f82.i);
            i.j(this);
            i.b();
        }
    }

    public final void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            le4 le4Var = new le4(ju2.U().getActivity(), this.R0);
            this.X0 = le4Var;
            le4Var.n(true);
            this.X0.k(this);
            h3(true);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            X2(this.R0.getMapStatus().target);
        }
    }

    @Override // com.baidu.tieba.c82, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onPause();
            this.S0.onPause();
            le4 le4Var = this.X0;
            if (le4Var != null) {
                le4Var.n(false);
            }
        }
    }

    @Override // com.baidu.tieba.c82, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onResume();
            this.S0.onResume();
            le4 le4Var = this.X0;
            if (le4Var != null) {
                le4Var.n(true);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.y0();
            if (Build.VERSION.SDK_INT > 19) {
                this.S0.onDestroy();
            }
            this.Q0.destroy();
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048608, this, mapStatus, i) == null) {
            boolean z2 = false;
            if (i == 1) {
                z = true;
            } else {
                z = false;
            }
            this.a1 = z;
            this.b1 = (z || this.b1) ? true : true;
        }
    }

    public static he4 b3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bundle)) == null) {
            he4 he4Var = new he4();
            if (bundle != null) {
                he4Var.j1(bundle);
            }
            return he4Var;
        }
        return (he4) invokeL.objValue;
    }

    public final void X2(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, latLng) == null) {
            this.Q0.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
        }
    }

    @Override // com.baidu.tieba.le4.b
    public void a(BDLocation bDLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bDLocation) == null) {
            X2(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
        }
    }

    public final void f3(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && this.I0 != null) {
            if (z) {
                i = R.drawable.obfuscated_res_0x7f08018e;
            } else {
                i = R.drawable.obfuscated_res_0x7f08018d;
            }
            this.I0.setImageResource(i);
        }
    }

    public void g3(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            this.c1 = bVar;
        }
    }

    public final void h3(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            if (z) {
                this.W0.clear();
                this.Y0.setData(this.W0);
            }
            View view2 = this.P0;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }

    public final void k3(je4 je4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, je4Var) == null) && je4Var != null && je4Var.a != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", je4Var.a.city);
            ne4 c3 = ne4.c3(bundle);
            c3.l1(this, 1);
            c3.i3();
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, reverseGeoCodeResult) == null) && reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.G0.postDelayed(new a(this, reverseGeoCodeResult), 150L);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, mapStatus) == null) && this.a1) {
            c3(mapStatus.target, true, true);
            f3(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void I0(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i, strArr, iArr) == null) {
            super.I0(i, strArr, iArr);
            if (i == 3001) {
                if (iArr.length > 0 && iArr[0] == -1) {
                    o83.f(ju2.U().getActivity(), R.string.obfuscated_res_0x7f0f01a0).G();
                } else if (iArr.length > 0 && iArr[0] == 0) {
                    j3();
                }
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048612, this, layoutInflater, viewGroup, bundle)) == null) {
            dd4.a();
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0084, viewGroup, false);
            Y2(inflate);
            Z2();
            if (T1()) {
                inflate = W1(inflate);
                w1(-1);
            }
            return D1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    public final void V2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.O0, Key.TRANSLATION_Y, 0.0f, -e1, 0.0f);
            ofFloat.setInterpolator(new AccelerateInterpolator());
            ofFloat.setDuration(500L);
            ofFloat.start();
        }
    }

    public final void Z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.R0.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
            this.R0.getUiSettings().setRotateGesturesEnabled(false);
            this.S0.showZoomControls(false);
            this.S0.setLogoPosition(LogoPosition.logoPostionRightBottom);
            if (a3()) {
                return;
            }
            j3();
        }
    }

    public final void Y2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            SDKInitializer.setCoordType(CoordType.GCJ02);
            this.W0 = new ArrayList(11);
            this.G0 = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f09152f);
            this.I0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090a80);
            this.H0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090a82);
            this.L0 = view2.findViewById(R.id.obfuscated_res_0x7f0904b8);
            this.M0 = view2.findViewById(R.id.obfuscated_res_0x7f091f0e);
            this.N0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a4c);
            this.O0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090607);
            this.J0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f091422);
            this.K0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0915a7);
            this.P0 = view2.findViewById(R.id.obfuscated_res_0x7f091518);
            this.S0 = (TextureMapView) view2.findViewById(R.id.obfuscated_res_0x7f090365);
            this.I0.setOnClickListener(this);
            this.N0.setOnClickListener(this);
            this.M0.setOnClickListener(this);
            this.L0.setOnClickListener(this);
            this.Q0 = GeoCoder.newInstance();
            this.R0 = this.S0.getMap();
            this.Q0.setOnGetGeoCodeResultListener(this);
            this.R0.setOnMapLoadedCallback(this);
            this.R0.setOnMapStatusChangeListener(this);
            this.G0.setLayoutManager(new LinearLayoutManager(ju2.U().getActivity()));
            LocationDetailAdapter locationDetailAdapter = new LocationDetailAdapter(ju2.U().getActivity(), this.G0, this, false);
            this.Y0 = locationDetailAdapter;
            this.G0.setAdapter(locationDetailAdapter);
            this.G0.addItemDecoration(new LocationItemDecoration(ju2.U().getActivity(), true));
            ke4 ke4Var = new ke4(this.J0, this.K0, this.H0);
            this.Z0 = ke4Var;
            ((FlipperFrameLayout) this.J0).setViewFlipper(ke4Var);
        }
    }

    public final boolean a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                ArrayList arrayList = new ArrayList();
                if (ju2.U().getActivity().checkSelfPermission(com.kuaishou.weapon.p0.h.g) != 0) {
                    arrayList.add(com.kuaishou.weapon.p0.h.g);
                }
                if (arrayList.size() > 0) {
                    requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), 0);
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c3(LatLng latLng, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{latLng, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            h3(true);
            X2(latLng);
            d3();
            if (z) {
                V2();
                if (this.Z0.d()) {
                    this.Z0.e(false);
                }
            }
            if (z2) {
                this.G0.smoothScrollToPosition(0);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void q0(int i, int i2, Intent intent) {
        SelectedLocationInfo selectedLocationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048611, this, i, i2, intent) == null) {
            super.q0(i, i2, intent);
            if (intent == null || i != 1 || (selectedLocationInfo = (SelectedLocationInfo) intent.getParcelableExtra(SelectedLocationInfo.LOCATION_KEY)) == null) {
                return;
            }
            double d = selectedLocationInfo.mLatitude;
            double d2 = selectedLocationInfo.mLongitude;
            if (!Double.isNaN(d) && !Double.isNaN(d2)) {
                this.d1 = selectedLocationInfo;
                LatLng latLng = new LatLng(d, d2);
                this.R0.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                this.b1 = true;
                c3(latLng, false, true);
                f3(false);
            }
        }
    }

    @Override // com.baidu.tieba.ie4
    public void e(je4 je4Var) {
        PoiInfo poiInfo;
        LatLng latLng;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, je4Var) == null) && je4Var != null && (poiInfo = je4Var.a) != null && (latLng = poiInfo.location) != null) {
            this.V0 = je4Var;
            this.R0.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            d3();
            if (this.U0 == null) {
                this.U0 = BitmapDescriptorFactory.fromResource(R.drawable.obfuscated_res_0x7f080198);
            }
            if (!je4Var.c) {
                this.T0 = (Marker) this.R0.addOverlay(new MarkerOptions().position(je4Var.a.location).zIndex(88).icon(this.U0));
            }
            if (!je4Var.c) {
                f3(false);
            }
        }
    }

    public final void l3(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, reverseGeoCodeResult) == null) {
            PoiInfo poiInfo = new PoiInfo();
            SelectedLocationInfo selectedLocationInfo = this.d1;
            if (selectedLocationInfo != null) {
                poiInfo.name = selectedLocationInfo.mName;
                SelectedLocationInfo selectedLocationInfo2 = this.d1;
                poiInfo.location = new LatLng(selectedLocationInfo2.mLatitude, selectedLocationInfo2.mLongitude);
                poiInfo.address = this.d1.mAddress;
                this.d1 = null;
                z = false;
            } else {
                String address = reverseGeoCodeResult.getAddress();
                String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                if (TextUtils.isEmpty(address)) {
                    address = "[位置]";
                }
                poiInfo.name = address;
                poiInfo.location = reverseGeoCodeResult.getLocation();
                poiInfo.address = sematicDescription;
                ReverseGeoCodeResult.AddressComponent addressDetail = reverseGeoCodeResult.getAddressDetail();
                if (addressDetail != null) {
                    poiInfo.city = addressDetail.city;
                }
                z = true;
            }
            je4 je4Var = new je4(poiInfo, true, z);
            this.W0.clear();
            this.W0.add(je4Var);
            this.W0.addAll(je4.a(reverseGeoCodeResult.getPoiList()));
            this.Y0.setData(this.W0);
            this.V0 = je4Var;
            if (this.W0.size() > 0) {
                h3(false);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f090a80) {
                le4 le4Var = this.X0;
                if (le4Var != null && le4Var.i() != null) {
                    BDLocation i = this.X0.i();
                    LatLng latLng = new LatLng(i.getLatitude(), i.getLongitude());
                    this.R0.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                    d3();
                    if (this.b1) {
                        c3(latLng, true, true);
                        this.b1 = false;
                    }
                    f3(true);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090a4c) {
                e3(16);
                W2();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091f0e) {
                k3(this.V0);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0904b8) {
                e3(17);
                W2();
            }
        }
    }

    public final void e3(int i) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048591, this, i) != null) || (bVar = this.c1) == null) {
            return;
        }
        switch (i) {
            case 16:
                je4 je4Var = this.V0;
                if (je4Var != null) {
                    PoiInfo poiInfo = je4Var.a;
                    if (TextUtils.equals(poiInfo.name, "[位置]")) {
                        poiInfo.name = "";
                    }
                    this.c1.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                    return;
                }
                return;
            case 17:
                bVar.onCancel();
                return;
            case 18:
                bVar.onError();
                return;
            default:
                return;
        }
    }
}
