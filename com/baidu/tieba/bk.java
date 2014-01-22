package com.baidu.tieba;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
/* loaded from: classes.dex */
class bk implements LocationListener {
    final /* synthetic */ TiebaApplication a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(TiebaApplication tiebaApplication) {
        this.a = tiebaApplication;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        bm bmVar;
        if (location != null) {
            this.a.C = 0;
            this.a.a = System.currentTimeMillis();
            this.a.F = new bm(this.a, null);
            bmVar = this.a.F;
            bmVar.execute(location);
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
