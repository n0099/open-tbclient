package com.baidu.tieba.im.nearbygroups;

import android.location.Address;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.model.ay;
/* loaded from: classes.dex */
final class c implements com.baidu.adp.lib.c.d {
    final /* synthetic */ NearbyGroupsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NearbyGroupsActivity nearbyGroupsActivity) {
        this.a = nearbyGroupsActivity;
    }

    @Override // com.baidu.adp.lib.c.d
    public final void a(int i, Address address) {
        m mVar;
        m mVar2;
        m mVar3;
        m mVar4;
        m mVar5;
        m mVar6;
        ay ayVar;
        ay ayVar2;
        ay ayVar3;
        if (i == 0) {
            if (address != null) {
                mVar6 = this.a.b;
                mVar6.b(false);
                String valueOf = String.valueOf(address.getLatitude());
                String valueOf2 = String.valueOf(address.getLongitude());
                TbadkApplication.j();
                TbadkApplication.i(valueOf);
                TbadkApplication.j();
                TbadkApplication.j(valueOf2);
                TbadkApplication.j();
                TbadkApplication.k(address.getAdminArea());
                ayVar = this.a.c;
                ayVar.b(valueOf);
                ayVar2 = this.a.c;
                ayVar2.a(valueOf2);
                ayVar3 = this.a.c;
                ayVar3.h();
                return;
            }
            return;
        }
        if (i == 1 || i == 2) {
            mVar = this.a.b;
            mVar.a(false);
        } else {
            mVar3 = this.a.b;
            if (mVar3.i() != null) {
                mVar5 = this.a.b;
                if (mVar5.i().size() != 0) {
                    this.a.showToast(com.baidu.tieba.im.j.nearby_group_gps_error);
                }
            }
            mVar4 = this.a.b;
            mVar4.b(true);
        }
        mVar2 = this.a.b;
        mVar2.g();
    }
}
