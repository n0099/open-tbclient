package com.baidu.tieba;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
/* loaded from: classes.dex */
class bd implements LocationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaApplication f1161a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(TiebaApplication tiebaApplication) {
        this.f1161a = tiebaApplication;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        bf bfVar;
        if (location != null) {
            this.f1161a.E = 0;
            this.f1161a.f1014a = System.currentTimeMillis();
            this.f1161a.H = new bf(this.f1161a, null);
            bfVar = this.f1161a.H;
            bfVar.execute(location);
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
