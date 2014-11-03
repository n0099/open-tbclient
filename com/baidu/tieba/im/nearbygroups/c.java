package com.baidu.tieba.im.nearbygroups;

import android.location.Address;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.model.NearbyGroupsModel;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class c implements com.baidu.adp.lib.d.d {
    final /* synthetic */ NearbyGroupsActivity bgq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NearbyGroupsActivity nearbyGroupsActivity) {
        this.bgq = nearbyGroupsActivity;
    }

    @Override // com.baidu.adp.lib.d.d
    public void OnLocationGeted(int i, String str, Address address) {
        m mVar;
        m mVar2;
        m mVar3;
        m mVar4;
        m mVar5;
        m mVar6;
        m mVar7;
        NearbyGroupsModel nearbyGroupsModel;
        NearbyGroupsModel nearbyGroupsModel2;
        NearbyGroupsModel nearbyGroupsModel3;
        if (i == 0) {
            if (address != null) {
                mVar7 = this.bgq.bgn;
                mVar7.dr(false);
                String valueOf = String.valueOf(address.getLatitude());
                String valueOf2 = String.valueOf(address.getLongitude());
                TbadkApplication.m251getInst().setLocationLat(valueOf);
                TbadkApplication.m251getInst().setLocationLng(valueOf2);
                TbadkApplication.m251getInst().setLocationPos(address.getAdminArea());
                nearbyGroupsModel = this.bgq.bgo;
                nearbyGroupsModel.setLat(valueOf);
                nearbyGroupsModel2 = this.bgq.bgo;
                nearbyGroupsModel2.setLng(valueOf2);
                nearbyGroupsModel3 = this.bgq.bgo;
                nearbyGroupsModel3.update();
            }
        } else if (i == 1 || i == 2) {
            mVar = this.bgq.bgn;
            mVar.dq(false);
            mVar2 = this.bgq.bgn;
            mVar2.Re();
        } else {
            mVar3 = this.bgq.bgn;
            if (mVar3.Rb() != null) {
                mVar6 = this.bgq.bgn;
                if (mVar6.Rb().size() != 0) {
                    this.bgq.showToast(y.nearby_group_gps_error);
                    mVar5 = this.bgq.bgn;
                    mVar5.Re();
                }
            }
            mVar4 = this.bgq.bgn;
            mVar4.dr(true);
            mVar5 = this.bgq.bgn;
            mVar5.Re();
        }
    }
}
