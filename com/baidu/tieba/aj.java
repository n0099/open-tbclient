package com.baidu.tieba;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
/* loaded from: classes.dex */
class aj implements LocationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaApplication f922a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(TiebaApplication tiebaApplication) {
        this.f922a = tiebaApplication;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        al alVar;
        if (location != null) {
            this.f922a.D = 0;
            this.f922a.f846a = System.currentTimeMillis();
            this.f922a.G = new al(this.f922a, null);
            alVar = this.f922a.G;
            alVar.execute(location);
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
