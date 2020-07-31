package com.baidu.tieba.aiapps.apps.d;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.t.b.d;
import java.util.concurrent.TimeUnit;
/* loaded from: classes19.dex */
public class a implements d {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final long fhC = TimeUnit.MINUTES.toMillis(3);
    private static final C0532a fhD = new C0532a();
    private LocationClient dqe;
    private LocationClientOption fhB;

    @Override // com.baidu.swan.apps.t.b.d
    public void a(String str, boolean z, boolean z2, d.a aVar) {
        BDLocation dx = fhD.dx(btL());
        boolean z3 = dx != null;
        if (z3) {
            aVar.a(a(dx, str));
        }
        if (this.dqe == null) {
            this.dqe = new LocationClient(AppRuntime.getAppContext());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setCoorType("gcj02");
            locationClientOption.setScanSpan(0);
            locationClientOption.setIgnoreKillProcess(true);
            locationClientOption.setIsNeedAddress(true);
            this.dqe.setLocOption(locationClientOption);
            this.fhB = locationClientOption;
            this.dqe.start();
        }
        this.dqe.registerLocationListener(new b(this.dqe, aVar, str, z3));
        this.fhB.setIsNeedAltitude(z2);
        this.dqe.setLocOption(this.fhB);
        al.p(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.dqe.requestLocation();
            }
        });
    }

    @Override // com.baidu.swan.apps.t.b.d
    public com.baidu.swan.apps.scheme.actions.f.b aiD() {
        BDLocation bDLocation = fhD.fhG;
        if (bDLocation == null) {
            return null;
        }
        return a(bDLocation, bDLocation.getCoorType());
    }

    @Override // com.baidu.swan.apps.t.b.d
    public void aiE() {
        long btL = btL();
        if (fhD.fhG == null || (btL > 0 && !fhD.dw(btL))) {
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
    public void aiF() {
    }

    @Override // com.baidu.swan.apps.t.b.d
    public void aiG() {
    }

    @Override // com.baidu.swan.apps.t.b.d
    public void aiH() {
    }

    @Override // com.baidu.swan.apps.t.b.d
    public void eh(boolean z) {
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

    private long btL() {
        return fhC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public static class b extends BDAbstractLocationListener {
        String coorType;
        LocationClient fhH;
        d.a fhI;
        boolean fhJ;

        public b(LocationClient locationClient, d.a aVar, String str, boolean z) {
            this.fhH = locationClient;
            this.fhI = aVar;
            this.coorType = str;
            this.fhJ = z;
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            this.fhH.unRegisterLocationListener(this);
            int locType = bDLocation.getLocType();
            if (!a.pY(locType)) {
                if (!this.fhJ) {
                    this.fhI.onFailed(locType);
                    return;
                }
                return;
            }
            a.fhD.e(bDLocation);
            if (!this.fhJ) {
                this.fhI.a(a.a(bDLocation, this.coorType));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean pY(int i) {
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
    /* renamed from: com.baidu.tieba.aiapps.apps.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static class C0532a {
        private long fhF;
        private BDLocation fhG;

        private C0532a() {
            this.fhF = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void e(BDLocation bDLocation) {
            this.fhG = bDLocation;
            this.fhF = System.currentTimeMillis();
        }

        synchronized boolean dw(long j) {
            boolean z = true;
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis() - this.fhF;
                boolean z2 = this.fhG != null;
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

        synchronized BDLocation dx(long j) {
            return dw(j) ? this.fhG : null;
        }
    }
}
