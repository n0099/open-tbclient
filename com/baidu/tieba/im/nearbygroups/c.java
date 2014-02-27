package com.baidu.tieba.im.nearbygroups;

import android.location.Address;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.model.ak;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class c implements com.baidu.adp.lib.c.d {
    final /* synthetic */ NearbyGroupsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NearbyGroupsActivity nearbyGroupsActivity) {
        this.a = nearbyGroupsActivity;
    }

    @Override // com.baidu.adp.lib.c.d
    public final void a(int i, Address address) {
        k kVar;
        k kVar2;
        k kVar3;
        k kVar4;
        k kVar5;
        k kVar6;
        ak akVar;
        ak akVar2;
        ak akVar3;
        if (i == 0) {
            if (address != null) {
                kVar6 = this.a.b;
                kVar6.b(false);
                String valueOf = String.valueOf(address.getLatitude());
                String valueOf2 = String.valueOf(address.getLongitude());
                TiebaApplication.g().x(valueOf);
                TiebaApplication.g().y(valueOf2);
                TiebaApplication.g().z(address.getAdminArea());
                akVar = this.a.c;
                akVar.b(valueOf);
                akVar2 = this.a.c;
                akVar2.a(valueOf2);
                akVar3 = this.a.c;
                akVar3.h();
                return;
            }
            return;
        }
        if (i == 1 || i == 2) {
            kVar = this.a.b;
            kVar.a(false);
        } else {
            kVar3 = this.a.b;
            if (kVar3.i() != null) {
                kVar5 = this.a.b;
                if (kVar5.i().size() != 0) {
                    this.a.showToast(R.string.nearby_group_gps_error);
                }
            }
            kVar4 = this.a.b;
            kVar4.b(true);
        }
        kVar2 = this.a.b;
        kVar2.g();
    }
}
