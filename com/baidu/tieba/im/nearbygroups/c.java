package com.baidu.tieba.im.nearbygroups;

import android.location.Address;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.model.bd;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class c implements com.baidu.adp.lib.c.d {
    final /* synthetic */ NearbyGroupsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NearbyGroupsActivity nearbyGroupsActivity) {
        this.a = nearbyGroupsActivity;
    }

    @Override // com.baidu.adp.lib.c.d
    public void a(int i, String str, Address address) {
        m mVar;
        m mVar2;
        m mVar3;
        m mVar4;
        m mVar5;
        m mVar6;
        m mVar7;
        bd bdVar;
        bd bdVar2;
        bd bdVar3;
        if (i == 0) {
            if (address != null) {
                mVar7 = this.a.b;
                mVar7.b(false);
                String valueOf = String.valueOf(address.getLatitude());
                String valueOf2 = String.valueOf(address.getLongitude());
                TbadkApplication.m252getInst().setLocationLat(valueOf);
                TbadkApplication.m252getInst().setLocationLng(valueOf2);
                TbadkApplication.m252getInst().setLocationPos(address.getAdminArea());
                bdVar = this.a.c;
                bdVar.b(valueOf);
                bdVar2 = this.a.c;
                bdVar2.a(valueOf2);
                bdVar3 = this.a.c;
                bdVar3.h();
            }
        } else if (i == 1 || i == 2) {
            mVar = this.a.b;
            mVar.a(false);
            mVar2 = this.a.b;
            mVar2.f();
        } else {
            mVar3 = this.a.b;
            if (mVar3.h() != null) {
                mVar6 = this.a.b;
                if (mVar6.h().size() != 0) {
                    this.a.showToast(y.nearby_group_gps_error);
                    mVar5 = this.a.b;
                    mVar5.f();
                }
            }
            mVar4 = this.a.b;
            mVar4.b(true);
            mVar5 = this.a.b;
            mVar5.f();
        }
    }
}
