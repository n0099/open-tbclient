package com.baidu.tieba.im.nearbygroups;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.data.NearbyGroupsData;
import com.baidu.tieba.im.model.NearbyGroupsModel;
/* loaded from: classes.dex */
class b implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ NearbyGroupsActivity bgc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NearbyGroupsActivity nearbyGroupsActivity) {
        this.bgc = nearbyGroupsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        NearbyGroupsModel nearbyGroupsModel;
        m mVar;
        m mVar2;
        m mVar3;
        NearbyGroupsModel nearbyGroupsModel2;
        NearbyGroupsModel nearbyGroupsModel3;
        NearbyGroupsModel nearbyGroupsModel4;
        NearbyGroupsModel nearbyGroupsModel5;
        String locationLat = TbadkApplication.m251getInst().getLocationLat();
        String locationLng = TbadkApplication.m251getInst().getLocationLng();
        nearbyGroupsModel = this.bgc.bga;
        if (!nearbyGroupsModel.getIsHaveReadCache() && !TextUtils.isEmpty(locationLat) && !TextUtils.isEmpty(locationLng)) {
            nearbyGroupsModel3 = this.bgc.bga;
            nearbyGroupsModel3.setLat(locationLat);
            nearbyGroupsModel4 = this.bgc.bga;
            nearbyGroupsModel4.setLng(locationLng);
            nearbyGroupsModel5 = this.bgc.bga;
            nearbyGroupsModel5.sendCacheMsg();
        } else if (!com.baidu.adp.lib.util.j.fh()) {
            mVar = this.bgc.bfZ;
            if (mVar.QY() == null) {
                mVar3 = this.bgc.bfZ;
                mVar3.a(new NearbyGroupsData());
            }
            mVar2 = this.bgc.bfZ;
            mVar2.Rb();
        } else {
            nearbyGroupsModel2 = this.bgc.bga;
            nearbyGroupsModel2.setIsHaveReadCache(true);
            com.baidu.adp.lib.d.a.dE().a(true, this.bgc.locationCallBack);
        }
    }
}
