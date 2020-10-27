package com.baidu.tieba.aiapps.apps.d;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.platform.comapi.location.CoordinateType;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.t.b.d;
import java.util.concurrent.TimeUnit;
/* loaded from: classes25.dex */
public class a implements d {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final long fQT = TimeUnit.MINUTES.toMillis(3);
    private static final C0605a fQU = new C0605a();
    private LocationClient dWJ;
    private LocationClientOption fQS;

    @Override // com.baidu.swan.apps.t.b.d
    public void a(String str, boolean z, boolean z2, d.a aVar) {
        BDLocation dU = fQU.dU(bIy());
        boolean z3 = dU != null;
        if (z3) {
            aVar.a(a(dU, str));
        }
        if (this.dWJ == null) {
            this.dWJ = new LocationClient(AppRuntime.getAppContext());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setCoorType("gcj02");
            locationClientOption.setScanSpan(0);
            locationClientOption.setIgnoreKillProcess(true);
            locationClientOption.setIsNeedAddress(true);
            this.dWJ.setLocOption(locationClientOption);
            this.fQS = locationClientOption;
            this.dWJ.start();
        }
        this.dWJ.registerLocationListener(new b(this.dWJ, aVar, str, z3));
        this.fQS.setIsNeedAltitude(z2);
        this.dWJ.setLocOption(this.fQS);
        ak.m(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.dWJ.requestLocation();
            }
        });
    }

    @Override // com.baidu.swan.apps.t.b.d
    public com.baidu.swan.apps.scheme.actions.f.b avz() {
        BDLocation bDLocation = fQU.fQX;
        if (bDLocation == null) {
            return null;
        }
        return a(bDLocation, bDLocation.getCoorType());
    }

    @Override // com.baidu.swan.apps.t.b.d
    public void avA() {
        long bIy = bIy();
        if (fQU.fQX == null || (bIy > 0 && !fQU.dT(bIy))) {
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
    public void avB() {
    }

    @Override // com.baidu.swan.apps.t.b.d
    public void avC() {
    }

    @Override // com.baidu.swan.apps.t.b.d
    public void avD() {
    }

    @Override // com.baidu.swan.apps.t.b.d
    public void fi(boolean z) {
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

    private long bIy() {
        return fQT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class b extends BDAbstractLocationListener {
        String coorType;
        LocationClient fQY;
        d.a fQZ;
        boolean fRa;

        public b(LocationClient locationClient, d.a aVar, String str, boolean z) {
            this.fQY = locationClient;
            this.fQZ = aVar;
            this.coorType = str;
            this.fRa = z;
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            this.fQY.unRegisterLocationListener(this);
            int locType = bDLocation.getLocType();
            if (!a.tl(locType)) {
                if (!this.fRa) {
                    this.fQZ.onFailed(locType);
                    return;
                }
                return;
            }
            a.fQU.f(bDLocation);
            if (!this.fRa) {
                this.fQZ.a(a.a(bDLocation, this.coorType));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean tl(int i) {
        return i == 65 || i == 61 || i == 161 || i == 66 || i == 68;
    }

    private static BDLocation b(double d, double d2, String str) {
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
            BDLocation b2 = b(latitude, longitude, str);
            longitude = b2.getLongitude();
            latitude = b2.getLatitude();
        }
        return new com.baidu.swan.apps.scheme.actions.f.b(str, longitude, latitude, bDLocation.getSpeed(), bDLocation.getRadius(), bDLocation.getAltitude(), bDLocation.getCountry(), bDLocation.getCountryCode(), bDLocation.getCity(), bDLocation.getCityCode(), bDLocation.getProvince(), bDLocation.getDistrict(), bDLocation.getStreet(), bDLocation.getStreetNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0605a {
        private long fQW;
        private BDLocation fQX;

        private C0605a() {
            this.fQW = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void f(BDLocation bDLocation) {
            this.fQX = bDLocation;
            this.fQW = System.currentTimeMillis();
        }

        synchronized boolean dT(long j) {
            boolean z = true;
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis() - this.fQW;
                boolean z2 = this.fQX != null;
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

        synchronized BDLocation dU(long j) {
            return dT(j) ? this.fQX : null;
        }
    }
}
