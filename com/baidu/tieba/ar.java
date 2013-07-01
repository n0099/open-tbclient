package com.baidu.tieba;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
/* loaded from: classes.dex */
class ar implements LocationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaApplication f699a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(TiebaApplication tiebaApplication) {
        this.f699a = tiebaApplication;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        aw awVar;
        if (location != null) {
            this.f699a.D = 0;
            this.f699a.f618a = System.currentTimeMillis();
            this.f699a.G = new aw(this.f699a, null);
            awVar = this.f699a.G;
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
