package com.baidu.tieba.im.nearbygroups;

import android.location.Address;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.model.s;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class e implements com.baidu.adp.lib.c.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NearbyGroupsActivity f1846a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NearbyGroupsActivity nearbyGroupsActivity) {
        this.f1846a = nearbyGroupsActivity;
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
        s sVar;
        s sVar2;
        s sVar3;
        if (i == 0) {
            if (address != null) {
                kVar7 = this.f1846a.b;
                kVar7.b(false);
                String valueOf = String.valueOf(address.getLatitude());
                String valueOf2 = String.valueOf(address.getLongitude());
                TiebaApplication.h().y(valueOf);
                TiebaApplication.h().z(valueOf2);
                TiebaApplication.h().A(address.getAdminArea());
                sVar = this.f1846a.c;
                sVar.b(valueOf);
                sVar2 = this.f1846a.c;
                sVar2.a(valueOf2);
                sVar3 = this.f1846a.c;
                sVar3.h();
            }
        } else if (i == 1 || i == 2) {
            kVar = this.f1846a.b;
            kVar.a(false);
            kVar2 = this.f1846a.b;
            kVar2.h();
        } else {
            kVar3 = this.f1846a.b;
            if (kVar3.j() != null) {
                kVar6 = this.f1846a.b;
                if (kVar6.j().size() != 0) {
                    this.f1846a.showToast(R.string.nearby_group_gps_error);
                    kVar5 = this.f1846a.b;
                    kVar5.h();
                }
            }
            kVar4 = this.f1846a.b;
            kVar4.b(true);
            kVar5 = this.f1846a.b;
            kVar5.h();
        }
    }
}
