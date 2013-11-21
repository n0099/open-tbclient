package com.baidu.tieba;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
/* loaded from: classes.dex */
class ay implements LocationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaApplication f1113a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(TiebaApplication tiebaApplication) {
        this.f1113a = tiebaApplication;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        ba baVar;
        if (location != null) {
            this.f1113a.B = 0;
            this.f1113a.f1004a = System.currentTimeMillis();
            this.f1113a.E = new ba(this.f1113a, null);
            baVar = this.f1113a.E;
            baVar.execute(location);
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
