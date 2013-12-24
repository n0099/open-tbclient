package com.baidu.tieba.im.nearbygroups;

import android.location.Address;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.model.ad;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class e implements com.baidu.adp.lib.c.d {
    final /* synthetic */ NearbyGroupsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NearbyGroupsActivity nearbyGroupsActivity) {
        this.a = nearbyGroupsActivity;
    }

    @Override // com.baidu.adp.lib.c.d
    public void a(int i, String str, Address address) {
        k kVar;
        k kVar2;
        k kVar3;
        k kVar4;
        k kVar5;
        k kVar6;
        k kVar7;
        ad adVar;
        ad adVar2;
        ad adVar3;
        if (i == 0) {
            if (address != null) {
                kVar7 = this.a.b;
                kVar7.b(false);
                String valueOf = String.valueOf(address.getLatitude());
                String valueOf2 = String.valueOf(address.getLongitude());
                TiebaApplication.h().y(valueOf);
                TiebaApplication.h().z(valueOf2);
                TiebaApplication.h().A(address.getAdminArea());
                adVar = this.a.c;
                adVar.b(valueOf);
                adVar2 = this.a.c;
                adVar2.a(valueOf2);
                adVar3 = this.a.c;
                adVar3.h();
            }
        } else if (i == 1 || i == 2) {
            kVar = this.a.b;
            kVar.a(false);
            kVar2 = this.a.b;
            kVar2.h();
        } else {
            kVar3 = this.a.b;
            if (kVar3.j() != null) {
                kVar6 = this.a.b;
                if (kVar6.j().size() != 0) {
                    this.a.showToast(R.string.nearby_group_gps_error);
                    kVar5 = this.a.b;
                    kVar5.h();
                }
            }
            kVar4 = this.a.b;
            kVar4.b(true);
            kVar5 = this.a.b;
            kVar5.h();
        }
    }
}
