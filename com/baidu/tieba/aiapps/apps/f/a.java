package com.baidu.tieba.aiapps.apps.f;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.w.b.f;
import java.util.concurrent.TimeUnit;
/* loaded from: classes12.dex */
public class a implements f {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final long eDZ = TimeUnit.MINUTES.toMillis(3);
    private static final C0445a eEa = new C0445a();
    private LocationClient cUs;
    private LocationClientOption eDY;

    @Override // com.baidu.swan.apps.w.b.f
    public void a(String str, boolean z, boolean z2, f.a aVar) {
        BDLocation df = eEa.df(bia());
        boolean z3 = df != null;
        if (z3) {
            aVar.a(a(df, str));
        }
        if (this.cUs == null) {
            this.cUs = new LocationClient(AppRuntime.getAppContext());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setCoorType("gcj02");
            locationClientOption.setScanSpan(0);
            locationClientOption.setIgnoreKillProcess(true);
            locationClientOption.setIsNeedAddress(true);
            this.cUs.setLocOption(locationClientOption);
            this.eDY = locationClientOption;
            this.cUs.start();
        }
        this.cUs.registerLocationListener(new b(this.cUs, aVar, str, z3));
        this.eDY.setIsNeedAltitude(z2);
        this.cUs.setLocOption(this.eDY);
        ai.o(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.f.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.cUs.requestLocation();
            }
        });
    }

    @Override // com.baidu.swan.apps.w.b.f
    public com.baidu.swan.apps.scheme.actions.f.b acZ() {
        BDLocation bDLocation = eEa.eEd;
        if (bDLocation == null) {
            return null;
        }
        return a(bDLocation, bDLocation.getCoorType());
    }

    @Override // com.baidu.swan.apps.w.b.f
    public void ada() {
        long bia = bia();
        if (eEa.eEd == null || (bia > 0 && !eEa.de(bia))) {
            if (DEBUG) {
                Log.i("SwanAppLocationImpl", "onWarmUp");
            }
            a("gcj02", false, true, new f.a() { // from class: com.baidu.tieba.aiapps.apps.f.a.2
                @Override // com.baidu.swan.apps.w.b.f.a
                public void a(com.baidu.swan.apps.scheme.actions.f.b bVar) {
                    if (a.DEBUG) {
                        Log.i("SwanAppLocationImpl", "onWarmUpSuccess::= result=" + bVar);
                    }
                }

                @Override // com.baidu.swan.apps.w.b.f.a
                public void onFailed(int i) {
                    if (a.DEBUG) {
                        Log.i("SwanAppLocationImpl", "onWarmUpFailed:: errCode=" + i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.w.b.f
    public double[] b(@NonNull com.baidu.swan.apps.scheme.actions.f.b bVar, @NonNull String str) {
        return a(bVar.longitude, bVar.latitude, bVar.coorType, str);
    }

    private double[] a(double d, double d2, String str, String str2) {
        double[] dArr = new double[2];
        if (TextUtils.equals(str2, "gcj02")) {
            return dArr;
        }
        BDLocation bDLocation = new BDLocation();
        bDLocation.setLongitude(d);
        bDLocation.setLatitude(d2);
        if (TextUtils.equals(str2, BDLocation.BDLOCATION_GCJ02_TO_BD09)) {
            bDLocation = LocationClient.getBDLocationInCoorType(bDLocation, BDLocation.BDLOCATION_GCJ02_TO_BD09);
        } else if (TextUtils.equals(str2, "bd09ll")) {
            bDLocation = LocationClient.getBDLocationInCoorType(bDLocation, "bd09ll");
        } else if (TextUtils.equals(str2, CoordinateType.WGS84)) {
            bDLocation = LocationClient.getBDLocationInCoorType(bDLocation, "gcj2wgs");
        }
        dArr[0] = bDLocation.getLongitude();
        dArr[1] = bDLocation.getLatitude();
        return dArr;
    }

    private long bia() {
        return eDZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class b extends BDAbstractLocationListener {
        String coorType;
        LocationClient eEe;
        f.a eEf;
        boolean eEg;

        public b(LocationClient locationClient, f.a aVar, String str, boolean z) {
            this.eEe = locationClient;
            this.eEf = aVar;
            this.coorType = str;
            this.eEg = z;
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            this.eEe.unRegisterLocationListener(this);
            int locType = bDLocation.getLocType();
            if (!a.oD(locType)) {
                if (!this.eEg) {
                    this.eEf.onFailed(locType);
                    return;
                }
                return;
            }
            a.eEa.e(bDLocation);
            if (!this.eEg) {
                this.eEf.a(a.a(bDLocation, this.coorType));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean oD(int i) {
        return i == 65 || i == 61 || i == 161 || i == 66 || i == 68;
    }

    private static BDLocation a(double d, double d2, String str) {
        BDLocation bDLocation = new BDLocation();
        bDLocation.setLongitude(d2);
        bDLocation.setLatitude(d);
        if (!TextUtils.equals(str, "gcj02")) {
            if (TextUtils.equals(str, BDLocation.BDLOCATION_GCJ02_TO_BD09)) {
                return LocationClient.getBDLocationInCoorType(bDLocation, BDLocation.BDLOCATION_GCJ02_TO_BD09);
            }
            if (TextUtils.equals(str, "bd09ll")) {
                return LocationClient.getBDLocationInCoorType(bDLocation, "bd09ll");
            }
            if (TextUtils.equals(str, CoordinateType.WGS84)) {
                return LocationClient.getBDLocationInCoorType(bDLocation, "gcj2wgs");
            }
            return bDLocation;
        }
        return bDLocation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.baidu.swan.apps.scheme.actions.f.b a(BDLocation bDLocation, String str) {
        double longitude = bDLocation.getLongitude();
        double latitude = bDLocation.getLatitude();
        if (!TextUtils.equals(str, bDLocation.getCoorType())) {
            BDLocation a = a(latitude, longitude, str);
            longitude = a.getLongitude();
            latitude = a.getLatitude();
        }
        return new com.baidu.swan.apps.scheme.actions.f.b(str, longitude, latitude, bDLocation.getSpeed(), bDLocation.getRadius(), bDLocation.getAltitude(), bDLocation.getCountry(), bDLocation.getCountryCode(), bDLocation.getCity(), bDLocation.getCityCode(), bDLocation.getProvince(), bDLocation.getDistrict(), bDLocation.getStreet(), bDLocation.getStreetNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class C0445a {
        private long eEc;
        private BDLocation eEd;

        private C0445a() {
            this.eEc = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void e(BDLocation bDLocation) {
            this.eEd = bDLocation;
            this.eEc = System.currentTimeMillis();
        }

        synchronized boolean de(long j) {
            boolean z = true;
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis() - this.eEc;
                boolean z2 = this.eEd != null;
                boolean z3 = currentTimeMillis < j;
                if (!z2 || !z3) {
                    z = false;
                }
                if (a.DEBUG) {
                    Log.i("SwanAppLocationImpl", String.format("hitCache[%b] hasInfo[%b] isAgeOk[%b] cacheAge[%d] timeout[%d]", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Long.valueOf(currentTimeMillis), Long.valueOf(j)));
                }
            }
            return z;
        }

        synchronized BDLocation df(long j) {
            return de(j) ? this.eEd : null;
        }
    }
}
