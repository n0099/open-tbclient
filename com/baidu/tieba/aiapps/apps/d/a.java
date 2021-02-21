package com.baidu.tieba.aiapps.apps.d;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.t.b.d;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class a implements d {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final long gmh = TimeUnit.MINUTES.toMillis(3);
    private static final C0603a gmi = new C0603a();
    private LocationClient eor;
    private LocationClientOption gmg;

    @Override // com.baidu.swan.apps.t.b.d
    public void a(String str, boolean z, boolean z2, d.a aVar) {
        BDLocation eZ = gmi.eZ(bNi());
        boolean z3 = eZ != null;
        if (z3) {
            aVar.a(a(eZ, str));
        }
        if (this.eor == null) {
            this.eor = new LocationClient(AppRuntime.getAppContext());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setCoorType("gcj02");
            locationClientOption.setScanSpan(0);
            locationClientOption.setIgnoreKillProcess(true);
            locationClientOption.setIsNeedAddress(true);
            this.eor.setLocOption(locationClientOption);
            this.gmg = locationClientOption;
            this.eor.start();
        }
        this.eor.registerLocationListener(new b(this.eor, aVar, str, z3));
        this.gmg.setIsNeedAltitude(z2);
        this.eor.setLocOption(this.gmg);
        ak.k(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.eor.requestLocation();
            }
        });
    }

    @Override // com.baidu.swan.apps.t.b.d
    public com.baidu.swan.apps.scheme.actions.f.b ayw() {
        BDLocation bDLocation = gmi.gmk;
        if (bDLocation == null) {
            return null;
        }
        return a(bDLocation, bDLocation.getCoorType());
    }

    @Override // com.baidu.swan.apps.t.b.d
    public void ayx() {
        long bNi = bNi();
        if (gmi.gmk == null || (bNi > 0 && !gmi.eY(bNi))) {
            if (DEBUG) {
                Log.i("SwanAppLocationImpl", "onWarmUp");
            }
            a("gcj02", false, true, new d.a() { // from class: com.baidu.tieba.aiapps.apps.d.a.2
                @Override // com.baidu.swan.apps.t.b.d.a
                public void a(com.baidu.swan.apps.scheme.actions.f.b bVar) {
                    if (a.DEBUG) {
                        Log.i("SwanAppLocationImpl", "onWarmUpSuccess::= result=" + bVar);
                    }
                }

                @Override // com.baidu.swan.apps.t.b.d.a
                public void onFailed(int i) {
                    if (a.DEBUG) {
                        Log.i("SwanAppLocationImpl", "onWarmUpFailed:: errCode=" + i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.t.b.d
    public double[] b(@NonNull com.baidu.swan.apps.scheme.actions.f.b bVar, @NonNull String str) {
        return a(bVar.longitude, bVar.latitude, bVar.coorType, str);
    }

    @Override // com.baidu.swan.apps.t.b.d
    public void a(d.a aVar) {
    }

    @Override // com.baidu.swan.apps.t.b.d
    public void ayy() {
    }

    @Override // com.baidu.swan.apps.t.b.d
    public void ayz() {
    }

    @Override // com.baidu.swan.apps.t.b.d
    public void ayA() {
    }

    @Override // com.baidu.swan.apps.t.b.d
    public void fQ(boolean z) {
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

    private long bNi() {
        return gmh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class b extends BDAbstractLocationListener {
        String coorType;
        LocationClient gml;
        d.a gmm;
        boolean gmn;

        public b(LocationClient locationClient, d.a aVar, String str, boolean z) {
            this.gml = locationClient;
            this.gmm = aVar;
            this.coorType = str;
            this.gmn = z;
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            this.gml.unRegisterLocationListener(this);
            int locType = bDLocation.getLocType();
            if (!a.ti(locType)) {
                if (!this.gmn) {
                    this.gmm.onFailed(locType);
                    return;
                }
                return;
            }
            a.gmi.e(bDLocation);
            if (!this.gmn) {
                this.gmm.a(a.a(bDLocation, this.coorType));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean ti(int i) {
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
            BDLocation a2 = a(latitude, longitude, str);
            longitude = a2.getLongitude();
            latitude = a2.getLatitude();
        }
        return new com.baidu.swan.apps.scheme.actions.f.b(str, longitude, latitude, bDLocation.getSpeed(), bDLocation.getRadius(), bDLocation.getAltitude(), bDLocation.getCountry(), bDLocation.getCountryCode(), bDLocation.getCity(), bDLocation.getCityCode(), bDLocation.getProvince(), bDLocation.getDistrict(), bDLocation.getStreet(), bDLocation.getStreetNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0603a {
        private BDLocation gmk;
        private long mCacheTime;

        private C0603a() {
            this.mCacheTime = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void e(BDLocation bDLocation) {
            this.gmk = bDLocation;
            this.mCacheTime = System.currentTimeMillis();
        }

        synchronized boolean eY(long j) {
            boolean z = true;
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis() - this.mCacheTime;
                boolean z2 = this.gmk != null;
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

        synchronized BDLocation eZ(long j) {
            return eY(j) ? this.gmk : null;
        }
    }
}
