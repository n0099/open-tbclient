package com.baidu.tieba;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
/* loaded from: classes.dex */
class am implements LocationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaApplication f939a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(TiebaApplication tiebaApplication) {
        this.f939a = tiebaApplication;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        ao aoVar;
        if (location != null) {
            this.f939a.B = 0;
            this.f939a.f859a = System.currentTimeMillis();
            this.f939a.E = new ao(this.f939a, null);
            aoVar = this.f939a.E;
            aoVar.execute(location);
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
