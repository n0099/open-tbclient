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
import com.baidu.tieba.eb4;
import com.baidu.tieba.y42;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ab4 extends v42 implements OnGetGeoCoderResultListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, View.OnClickListener, bb4, eb4.b {
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
    public cb4 V0;
    public List<cb4> W0;
    public eb4 X0;
    public LocationDetailAdapter Y0;
    public db4 Z0;
    public boolean a1;
    public boolean b1;
    public b c1;
    public SelectedLocationInfo d1;

    /* loaded from: classes5.dex */
    public interface b {
        void a(SelectedLocationInfo selectedLocationInfo);

        void onCancel();

        void onError();
    }

    @Override // com.baidu.tieba.v42
    public void b2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
        }
    }

    @Override // com.baidu.tieba.v42, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.v42
    public boolean j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.v42
    public boolean l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, geoCodeResult) == null) {
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChange(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, mapStatus) == null) {
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, mapStatus) == null) {
        }
    }

    @Override // com.baidu.tieba.v42
    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReverseGeoCodeResult a;
        public final /* synthetic */ ab4 b;

        public a(ab4 ab4Var, ReverseGeoCodeResult reverseGeoCodeResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ab4Var, reverseGeoCodeResult};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ab4Var;
            this.a = reverseGeoCodeResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.s3(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947609398, "Lcom/baidu/tieba/ab4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947609398, "Lcom/baidu/tieba/ab4;");
                return;
            }
        }
        e1 = gj3.g(20.0f);
    }

    public ab4() {
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

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.C0();
            if (Build.VERSION.SDK_INT > 19) {
                this.S0.onDestroy();
            }
            this.Q0.destroy();
        }
    }

    @Override // com.baidu.tieba.v42
    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            l3(17);
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void d3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Activity activity = this.c0;
            if (activity != null) {
                activity.onBackPressed();
            }
            this.c1 = null;
        }
    }

    public final void k3() {
        Marker marker;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (marker = this.T0) != null) {
            marker.remove();
            this.T0 = null;
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            e3(this.R0.getMapStatus().target);
        }
    }

    @Override // com.baidu.tieba.v42, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onPause();
            this.S0.onPause();
            eb4 eb4Var = this.X0;
            if (eb4Var != null) {
                eb4Var.n(false);
            }
        }
    }

    @Override // com.baidu.tieba.v42, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onResume();
            this.S0.onResume();
            eb4 eb4Var = this.X0;
            if (eb4Var != null) {
                eb4Var.n(true);
            }
        }
    }

    public void p3() {
        y42 W;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && (W = cr2.V().W()) != null) {
            y42.b i = W.i("navigateTo");
            i.n(y42.g, y42.i);
            i.j(this);
            i.b();
        }
    }

    public final void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            eb4 eb4Var = new eb4(cr2.V().getActivity(), this.R0);
            this.X0 = eb4Var;
            eb4Var.n(true);
            this.X0.k(this);
            o3(true);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048605, this, mapStatus, i) == null) {
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

    public static ab4 i3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bundle)) == null) {
            ab4 ab4Var = new ab4();
            if (bundle != null) {
                ab4Var.n1(bundle);
            }
            return ab4Var;
        }
        return (ab4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.eb4.b
    public void a(BDLocation bDLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bDLocation) == null) {
            e3(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
        }
    }

    public final void e3(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, latLng) == null) {
            this.Q0.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
        }
    }

    public final void m3(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048595, this, z) == null) && this.I0 != null) {
            if (z) {
                i = R.drawable.obfuscated_res_0x7f0801a9;
            } else {
                i = R.drawable.obfuscated_res_0x7f0801a8;
            }
            this.I0.setImageResource(i);
        }
    }

    public void n3(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bVar) == null) {
            this.c1 = bVar;
        }
    }

    public final void o3(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
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

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, reverseGeoCodeResult) == null) && reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.G0.postDelayed(new a(this, reverseGeoCodeResult), 150L);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, mapStatus) == null) && this.a1) {
            j3(mapStatus.target, true, true);
            m3(false);
        }
    }

    public final void r3(cb4 cb4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048611, this, cb4Var) == null) && cb4Var != null && cb4Var.a != null) {
            Bundle bundle = new Bundle();
            bundle.putString("city", cb4Var.a.city);
            gb4 j3 = gb4.j3(bundle);
            j3.p1(this, 1);
            j3.p3();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            w94.a();
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d008a, viewGroup, false);
            f3(inflate);
            g3();
            if (a2()) {
                inflate = d2(inflate);
                C1(-1);
            }
            return J1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void M0(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i, strArr, iArr) == null) {
            super.M0(i, strArr, iArr);
            if (i == 3001) {
                if (iArr.length > 0 && iArr[0] == -1) {
                    h53.f(cr2.V().getActivity(), R.string.obfuscated_res_0x7f0f01cd).G();
                } else if (iArr.length > 0 && iArr[0] == 0) {
                    q3();
                }
            }
        }
    }

    public final void c3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.O0, Key.TRANSLATION_Y, 0.0f, -e1, 0.0f);
            ofFloat.setInterpolator(new AccelerateInterpolator());
            ofFloat.setDuration(500L);
            ofFloat.start();
        }
    }

    public final void g3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.R0.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
            this.R0.getUiSettings().setRotateGesturesEnabled(false);
            this.S0.showZoomControls(false);
            this.S0.setLogoPosition(LogoPosition.logoPostionRightBottom);
            if (h3()) {
                return;
            }
            q3();
        }
    }

    @Override // com.baidu.tieba.bb4
    public void d(cb4 cb4Var) {
        PoiInfo poiInfo;
        LatLng latLng;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, cb4Var) == null) && cb4Var != null && (poiInfo = cb4Var.a) != null && (latLng = poiInfo.location) != null) {
            this.V0 = cb4Var;
            this.R0.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            k3();
            if (this.U0 == null) {
                this.U0 = BitmapDescriptorFactory.fromResource(R.drawable.obfuscated_res_0x7f0801b3);
            }
            if (!cb4Var.c) {
                this.T0 = (Marker) this.R0.addOverlay(new MarkerOptions().position(cb4Var.a.location).zIndex(88).icon(this.U0));
            }
            if (!cb4Var.c) {
                m3(false);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f090b62) {
                eb4 eb4Var = this.X0;
                if (eb4Var != null && eb4Var.i() != null) {
                    BDLocation i = this.X0.i();
                    LatLng latLng = new LatLng(i.getLatitude(), i.getLongitude());
                    this.R0.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                    k3();
                    if (this.b1) {
                        j3(latLng, true, true);
                        this.b1 = false;
                    }
                    m3(true);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090b2a) {
                l3(16);
                d3();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09211d) {
                r3(this.V0);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09053b) {
                l3(17);
                d3();
            }
        }
    }

    public final void s3(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, reverseGeoCodeResult) == null) {
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
            cb4 cb4Var = new cb4(poiInfo, true, z);
            this.W0.clear();
            this.W0.add(cb4Var);
            this.W0.addAll(cb4.a(reverseGeoCodeResult.getPoiList()));
            this.Y0.setData(this.W0);
            this.V0 = cb4Var;
            if (this.W0.size() > 0) {
                o3(false);
            }
        }
    }

    public final void f3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            SDKInitializer.setCoordType(CoordType.GCJ02);
            this.W0 = new ArrayList(11);
            this.G0 = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091676);
            this.I0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090b62);
            this.H0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090b64);
            this.L0 = view2.findViewById(R.id.obfuscated_res_0x7f09053b);
            this.M0 = view2.findViewById(R.id.obfuscated_res_0x7f09211d);
            this.N0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b2a);
            this.O0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0906a2);
            this.J0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09155f);
            this.K0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0916f0);
            this.P0 = view2.findViewById(R.id.obfuscated_res_0x7f09165c);
            this.S0 = (TextureMapView) view2.findViewById(R.id.obfuscated_res_0x7f090377);
            this.I0.setOnClickListener(this);
            this.N0.setOnClickListener(this);
            this.M0.setOnClickListener(this);
            this.L0.setOnClickListener(this);
            this.Q0 = GeoCoder.newInstance();
            this.R0 = this.S0.getMap();
            this.Q0.setOnGetGeoCodeResultListener(this);
            this.R0.setOnMapLoadedCallback(this);
            this.R0.setOnMapStatusChangeListener(this);
            this.G0.setLayoutManager(new LinearLayoutManager(cr2.V().getActivity()));
            LocationDetailAdapter locationDetailAdapter = new LocationDetailAdapter(cr2.V().getActivity(), this.G0, this, false);
            this.Y0 = locationDetailAdapter;
            this.G0.setAdapter(locationDetailAdapter);
            this.G0.addItemDecoration(new LocationItemDecoration(cr2.V().getActivity(), true));
            db4 db4Var = new db4(this.J0, this.K0, this.H0);
            this.Z0 = db4Var;
            ((FlipperFrameLayout) this.J0).setViewFlipper(db4Var);
        }
    }

    public final boolean h3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                ArrayList arrayList = new ArrayList();
                if (cr2.V().getActivity().checkSelfPermission(com.kuaishou.weapon.p0.h.g) != 0) {
                    arrayList.add(com.kuaishou.weapon.p0.h.g);
                }
                if (arrayList.size() > 0) {
                    l1((String[]) arrayList.toArray(new String[arrayList.size()]), 0);
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j3(LatLng latLng, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{latLng, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            o3(true);
            e3(latLng);
            k3();
            if (z) {
                c3();
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
    public void u0(int i, int i2, Intent intent) {
        SelectedLocationInfo selectedLocationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048613, this, i, i2, intent) == null) {
            super.u0(i, i2, intent);
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
                j3(latLng, false, true);
                m3(false);
            }
        }
    }

    public final void l3(int i) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048594, this, i) != null) || (bVar = this.c1) == null) {
            return;
        }
        switch (i) {
            case 16:
                cb4 cb4Var = this.V0;
                if (cb4Var != null) {
                    PoiInfo poiInfo = cb4Var.a;
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
