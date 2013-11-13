package com.baidu.tieba;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
/* loaded from: classes.dex */
class av implements LocationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaApplication f1107a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(TiebaApplication tiebaApplication) {
        this.f1107a = tiebaApplication;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        ax axVar;
        if (location != null) {
            this.f1107a.B = 0;
            this.f1107a.f1002a = System.currentTimeMillis();
            this.f1107a.E = new ax(this.f1107a, null);
            axVar = this.f1107a.E;
            axVar.execute(location);
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
