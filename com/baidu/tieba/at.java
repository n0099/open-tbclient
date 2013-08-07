package com.baidu.tieba;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
/* loaded from: classes.dex */
class at implements LocationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaApplication f912a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(TiebaApplication tiebaApplication) {
        this.f912a = tiebaApplication;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        aw awVar;
        if (location != null) {
            this.f912a.D = 0;
            this.f912a.f824a = System.currentTimeMillis();
            this.f912a.G = new aw(this.f912a, null);
            awVar = this.f912a.G;
            awVar.execute(location);
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
