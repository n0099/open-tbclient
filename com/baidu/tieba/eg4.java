package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.zv2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
@Singleton
@Service
/* loaded from: classes5.dex */
public class eg4 implements zv2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public static final long d;
    public static final c e;
    public transient /* synthetic */ FieldHolder $fh;
    public LocationClient a;
    public LocationClientOption b;

    public static boolean q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) ? i == 65 || i == 61 || i == 161 || i == 66 || i == 68 : invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.zv2
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.tieba.zv2
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.baidu.tieba.zv2
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.tieba.zv2
    public void f(zv2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eg4 a;

        public a(eg4 eg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eg4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a.requestLocation();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements zv2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(eg4 eg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.zv2.a
        public void a(ye3 ye3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, ye3Var) == null) && eg4.c) {
                Log.i("SwanAppLocationImpl", "onWarmUpSuccess::= result=" + ye3Var);
            }
        }

        @Override // com.baidu.tieba.zv2.a
        public void onFailed(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && eg4.c) {
                Log.i("SwanAppLocationImpl", "onWarmUpFailed:: errCode=" + i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public BDLocation b;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 0L;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void update(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bDLocation) == null) {
                synchronized (this) {
                    this.b = bDLocation;
                    this.a = System.currentTimeMillis();
                }
            }
        }

        public synchronized BDLocation c(long j) {
            InterceptResult invokeJ;
            BDLocation bDLocation;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                synchronized (this) {
                    if (d(j)) {
                        bDLocation = this.b;
                    } else {
                        bDLocation = null;
                    }
                }
                return bDLocation;
            }
            return (BDLocation) invokeJ.objValue;
        }

        public synchronized boolean d(long j) {
            InterceptResult invokeJ;
            boolean z;
            boolean z2;
            boolean z3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                synchronized (this) {
                    long currentTimeMillis = System.currentTimeMillis() - this.a;
                    if (this.b != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (currentTimeMillis < j) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && z2) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (eg4.c) {
                        Log.i("SwanAppLocationImpl", String.format("hitCache[%b] hasInfo[%b] isAgeOk[%b] cacheAge[%d] timeout[%d]", Boolean.valueOf(z3), Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(currentTimeMillis), Long.valueOf(j)));
                    }
                }
                return z3;
            }
            return invokeJ.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class d extends BDAbstractLocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LocationClient a;
        public zv2.a b;
        public String c;
        public boolean d;

        public d(LocationClient locationClient, zv2.a aVar, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {locationClient, aVar, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = locationClient;
            this.b = aVar;
            this.c = str;
            this.d = z;
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDLocation) == null) {
                this.a.unRegisterLocationListener(this);
                int locType = bDLocation.getLocType();
                if (!eg4.q(locType)) {
                    if (!this.d) {
                        this.b.onFailed(locType);
                        return;
                    }
                    return;
                }
                eg4.e.update(bDLocation);
                if (!this.d) {
                    this.b.a(eg4.o(bDLocation, this.c));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947733367, "Lcom/baidu/tieba/eg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947733367, "Lcom/baidu/tieba/eg4;");
                return;
            }
        }
        c = js1.a;
        d = TimeUnit.MINUTES.toMillis(3L);
        e = new c(null);
    }

    @Override // com.baidu.tieba.zv2
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            long p = p();
            if (e.b == null || (p > 0 && !e.d(p))) {
                if (c) {
                    Log.i("SwanAppLocationImpl", "onWarmUp");
                }
                b("gcj02", false, true, new b(this));
            }
        }
    }

    public eg4() {
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

    @Override // com.baidu.tieba.zv2
    public ye3 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BDLocation bDLocation = e.b;
            if (bDLocation == null) {
                return null;
            }
            return o(bDLocation, bDLocation.getCoorType());
        }
        return (ye3) invokeV.objValue;
    }

    public final long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return d;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.zv2
    public double[] g(@NonNull ye3 ye3Var, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, ye3Var, str)) == null) {
            return n(ye3Var.b, ye3Var.c, ye3Var.a, str);
        }
        return (double[]) invokeLL.objValue;
    }

    public static BDLocation m(double d2, double d3, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), str})) == null) {
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLongitude(d3);
            bDLocation.setLatitude(d2);
            if (TextUtils.equals(str, "gcj02")) {
                return bDLocation;
            }
            if (TextUtils.equals(str, "bd09")) {
                return LocationClient.getBDLocationInCoorType(bDLocation, "bd09");
            }
            if (TextUtils.equals(str, "bd09ll")) {
                return LocationClient.getBDLocationInCoorType(bDLocation, "bd09ll");
            }
            if (TextUtils.equals(str, "wgs84")) {
                return LocationClient.getBDLocationInCoorType(bDLocation, "gcj2wgs");
            }
            return bDLocation;
        }
        return (BDLocation) invokeCommon.objValue;
    }

    public static ye3 o(BDLocation bDLocation, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, bDLocation, str)) == null) {
            double longitude = bDLocation.getLongitude();
            double latitude = bDLocation.getLatitude();
            if (!TextUtils.equals(str, bDLocation.getCoorType())) {
                BDLocation m = m(latitude, longitude, str);
                longitude = m.getLongitude();
                latitude = m.getLatitude();
            }
            return new ye3(str, longitude, latitude, bDLocation.getSpeed(), bDLocation.getRadius(), bDLocation.getAltitude(), bDLocation.getCountry(), bDLocation.getCountryCode(), bDLocation.getCity(), bDLocation.getCityCode(), bDLocation.getProvince(), bDLocation.getDistrict(), bDLocation.getStreet(), bDLocation.getStreetNumber());
        }
        return (ye3) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.zv2
    public void b(String str, boolean z, boolean z2, zv2.a aVar) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), aVar}) == null) {
            BDLocation c2 = e.c(p());
            if (c2 != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                aVar.a(o(c2, str));
            }
            if (this.a == null) {
                this.a = new LocationClient(AppRuntime.getAppContext());
                LocationClientOption locationClientOption = new LocationClientOption();
                locationClientOption.setCoorType("gcj02");
                locationClientOption.setScanSpan(0);
                locationClientOption.setIgnoreKillProcess(true);
                locationClientOption.setIsNeedAddress(true);
                this.a.setLocOption(locationClientOption);
                this.b = locationClientOption;
                this.a.start();
            }
            this.a.registerLocationListener(new d(this.a, aVar, str, z3));
            this.b.setIsNeedAltitude(z2);
            this.a.setLocOption(this.b);
            tp3.a0(new a(this));
        }
    }

    public final double[] n(double d2, double d3, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), str, str2})) == null) {
            double[] dArr = new double[2];
            if (TextUtils.equals(str2, "gcj02")) {
                return dArr;
            }
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLongitude(d2);
            bDLocation.setLatitude(d3);
            if (TextUtils.equals(str2, "bd09")) {
                bDLocation = LocationClient.getBDLocationInCoorType(bDLocation, "bd09");
            } else if (TextUtils.equals(str2, "bd09ll")) {
                bDLocation = LocationClient.getBDLocationInCoorType(bDLocation, "bd09ll");
            } else if (TextUtils.equals(str2, "wgs84")) {
                bDLocation = LocationClient.getBDLocationInCoorType(bDLocation, "gcj2wgs");
            }
            dArr[0] = bDLocation.getLongitude();
            dArr[1] = bDLocation.getLatitude();
            return dArr;
        }
        return (double[]) invokeCommon.objValue;
    }
}
