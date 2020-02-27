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
    private static final long edE = TimeUnit.MINUTES.toMillis(3);
    private static final C0414a edF = new C0414a();
    private LocationClient cvj;
    private LocationClientOption edD;

    @Override // com.baidu.swan.apps.w.b.f
    public void a(String str, boolean z, boolean z2, f.a aVar) {
        BDLocation cy = edF.cy(aZP());
        boolean z3 = cy != null;
        if (z3) {
            aVar.a(a(cy, str));
        }
        if (this.cvj == null) {
            this.cvj = new LocationClient(AppRuntime.getAppContext());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setCoorType("gcj02");
            locationClientOption.setScanSpan(0);
            locationClientOption.setIgnoreKillProcess(true);
            locationClientOption.setIsNeedAddress(true);
            this.cvj.setLocOption(locationClientOption);
            this.edD = locationClientOption;
            this.cvj.start();
        }
        this.cvj.registerLocationListener(new b(this.cvj, aVar, str, z3));
        this.edD.setIsNeedAltitude(z2);
        this.cvj.setLocOption(this.edD);
        ai.l(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.f.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.cvj.requestLocation();
            }
        });
    }

    @Override // com.baidu.swan.apps.w.b.f
    public com.baidu.swan.apps.scheme.actions.f.b Vf() {
        BDLocation bDLocation = edF.edI;
        if (bDLocation == null) {
            return null;
        }
        return a(bDLocation, bDLocation.getCoorType());
    }

    @Override // com.baidu.swan.apps.w.b.f
    public void Vg() {
        long aZP = aZP();
        if (edF.edI == null || (aZP > 0 && !edF.cx(aZP))) {
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

    private long aZP() {
        return edE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class b extends BDAbstractLocationListener {
        String coorType;
        LocationClient edJ;
        f.a edK;
        boolean edL;

        public b(LocationClient locationClient, f.a aVar, String str, boolean z) {
            this.edJ = locationClient;
            this.edK = aVar;
            this.coorType = str;
            this.edL = z;
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            this.edJ.unRegisterLocationListener(this);
            int locType = bDLocation.getLocType();
            if (!a.oo(locType)) {
                if (!this.edL) {
                    this.edK.onFailed(locType);
                    return;
                }
                return;
            }
            a.edF.e(bDLocation);
            if (!this.edL) {
                this.edK.a(a.a(bDLocation, this.coorType));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean oo(int i) {
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
    public static class C0414a {
        private long edH;
        private BDLocation edI;

        private C0414a() {
            this.edH = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void e(BDLocation bDLocation) {
            this.edI = bDLocation;
            this.edH = System.currentTimeMillis();
        }

        synchronized boolean cx(long j) {
            boolean z = true;
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis() - this.edH;
                boolean z2 = this.edI != null;
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

        synchronized BDLocation cy(long j) {
            return cx(j) ? this.edI : null;
        }
    }
}
