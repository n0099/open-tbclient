package com.baidu.tieba.im.nearbygroups;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.im.data.NearbyGroupsData;
import com.baidu.tieba.im.model.an;
/* loaded from: classes.dex */
class b implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ NearbyGroupsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NearbyGroupsActivity nearbyGroupsActivity) {
        this.a = nearbyGroupsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        an anVar;
        m mVar;
        m mVar2;
        m mVar3;
        an anVar2;
        an anVar3;
        an anVar4;
        an anVar5;
        String locationLat = TbadkApplication.m252getInst().getLocationLat();
        String locationLng = TbadkApplication.m252getInst().getLocationLng();
        anVar = this.a.c;
        if (!anVar.c() && !TextUtils.isEmpty(locationLat) && !TextUtils.isEmpty(locationLng)) {
            anVar3 = this.a.c;
            anVar3.b(locationLat);
            anVar4 = this.a.c;
            anVar4.a(locationLng);
            anVar5 = this.a.c;
            anVar5.f();
        } else if (!UtilHelper.isNetOk()) {
            mVar = this.a.b;
            if (mVar.h() == null) {
                mVar3 = this.a.b;
                mVar3.a(new NearbyGroupsData());
            }
            mVar2 = this.a.b;
            mVar2.f();
        } else {
            anVar2 = this.a.c;
            anVar2.c(true);
            com.baidu.adp.lib.c.a.a().a(true, this.a.a);
        }
    }
}
