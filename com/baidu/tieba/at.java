package com.baidu.tieba;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
/* loaded from: classes.dex */
class at implements LocationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaApplication f1071a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(TiebaApplication tiebaApplication) {
        this.f1071a = tiebaApplication;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        av avVar;
        if (location != null) {
            this.f1071a.B = 0;
            this.f1071a.f988a = System.currentTimeMillis();
            this.f1071a.E = new av(this.f1071a, null);
            avVar = this.f1071a.E;
            avVar.execute(location);
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
