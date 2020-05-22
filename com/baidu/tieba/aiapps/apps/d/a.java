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
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.u.b.d;
import java.util.concurrent.TimeUnit;
/* loaded from: classes12.dex */
public class a implements d {
    private LocationClient dfy;
    private LocationClientOption eSy;
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final long eSz = TimeUnit.MINUTES.toMillis(3);
    private static final C0513a eSA = new C0513a();

    @Override // com.baidu.swan.apps.u.b.d
    public void a(String str, boolean z, boolean z2, d.a aVar) {
        BDLocation dh = eSA.dh(bof());
        boolean z3 = dh != null;
        if (z3) {
            aVar.a(a(dh, str));
        }
        if (this.dfy == null) {
            this.dfy = new LocationClient(AppRuntime.getAppContext());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setCoorType("gcj02");
            locationClientOption.setScanSpan(0);
            locationClientOption.setIgnoreKillProcess(true);
            locationClientOption.setIsNeedAddress(true);
            this.dfy.setLocOption(locationClientOption);
            this.eSy = locationClientOption;
            this.dfy.start();
        }
        this.dfy.registerLocationListener(new b(this.dfy, aVar, str, z3));
        this.eSy.setIsNeedAltitude(z2);
        this.dfy.setLocOption(this.eSy);
        aj.p(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.dfy.requestLocation();
            }
        });
    }

    @Override // com.baidu.swan.apps.u.b.d
    public com.baidu.swan.apps.scheme.actions.f.b agi() {
        BDLocation bDLocation = eSA.eSD;
        if (bDLocation == null) {
            return null;
        }
        return a(bDLocation, bDLocation.getCoorType());
    }

    @Override // com.baidu.swan.apps.u.b.d
    public void agj() {
        long bof = bof();
        if (eSA.eSD == null || (bof > 0 && !eSA.dg(bof))) {
            if (DEBUG) {
                Log.i("SwanAppLocationImpl", "onWarmUp");
            }
            a("gcj02", false, true, new d.a() { // from class: com.baidu.tieba.aiapps.apps.d.a.2
                @Override // com.baidu.swan.apps.u.b.d.a
                public void a(com.baidu.swan.apps.scheme.actions.f.b bVar) {
                    if (a.DEBUG) {
                        Log.i("SwanAppLocationImpl", "onWarmUpSuccess::= result=" + bVar);
                    }
                }

                @Override // com.baidu.swan.apps.u.b.d.a
                public void onFailed(int i) {
                    if (a.DEBUG) {
                        Log.i("SwanAppLocationImpl", "onWarmUpFailed:: errCode=" + i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.u.b.d
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

    private long bof() {
        return eSz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class b extends BDAbstractLocationListener {
        String coorType;
        LocationClient eSE;
        d.a eSF;
        boolean eSG;

        public b(LocationClient locationClient, d.a aVar, String str, boolean z) {
            this.eSE = locationClient;
            this.eSF = aVar;
            this.coorType = str;
            this.eSG = z;
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            this.eSE.unRegisterLocationListener(this);
            int locType = bDLocation.getLocType();
            if (!a.pk(locType)) {
                if (!this.eSG) {
                    this.eSF.onFailed(locType);
                    return;
                }
                return;
            }
            a.eSA.e(bDLocation);
            if (!this.eSG) {
                this.eSF.a(a.a(bDLocation, this.coorType));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean pk(int i) {
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
    /* loaded from: classes12.dex */
    public static class C0513a {
        private long eSC;
        private BDLocation eSD;

        private C0513a() {
            this.eSC = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void e(BDLocation bDLocation) {
            this.eSD = bDLocation;
            this.eSC = System.currentTimeMillis();
        }

        synchronized boolean dg(long j) {
            boolean z = true;
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis() - this.eSC;
                boolean z2 = this.eSD != null;
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

        synchronized BDLocation dh(long j) {
            return dg(j) ? this.eSD : null;
        }
    }
}
