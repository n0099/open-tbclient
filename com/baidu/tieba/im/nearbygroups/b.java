package com.baidu.tieba.im.nearbygroups;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.im.data.NearbyGroupsData;
import com.baidu.tieba.im.model.bd;
/* loaded from: classes.dex */
class b implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ NearbyGroupsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NearbyGroupsActivity nearbyGroupsActivity) {
        this.a = nearbyGroupsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        bd bdVar;
        m mVar;
        m mVar2;
        m mVar3;
        bd bdVar2;
        bd bdVar3;
        bd bdVar4;
        bd bdVar5;
        String locationLat = TbadkApplication.m252getInst().getLocationLat();
        String locationLng = TbadkApplication.m252getInst().getLocationLng();
        bdVar = this.a.c;
        if (!bdVar.c() && !TextUtils.isEmpty(locationLat) && !TextUtils.isEmpty(locationLng)) {
            bdVar3 = this.a.c;
            bdVar3.b(locationLat);
            bdVar4 = this.a.c;
            bdVar4.a(locationLng);
            bdVar5 = this.a.c;
            bdVar5.f();
        } else if (!UtilHelper.isNetOk()) {
            mVar = this.a.b;
            if (mVar.g() == null) {
                mVar3 = this.a.b;
                mVar3.a(new NearbyGroupsData());
            }
            mVar2 = this.a.b;
            mVar2.e();
        } else {
            bdVar2 = this.a.c;
            bdVar2.c(true);
            com.baidu.adp.lib.c.a.a().a(true, this.a.a);
        }
    }
}
