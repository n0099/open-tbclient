package com.baidu.tieba.im.nearbygroups;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.NearbyGroupsData;
import com.baidu.tieba.im.model.ad;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class d implements com.baidu.adp.widget.ListView.b {
    final /* synthetic */ NearbyGroupsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NearbyGroupsActivity nearbyGroupsActivity) {
        this.a = nearbyGroupsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        ad adVar;
        k kVar;
        k kVar2;
        k kVar3;
        ad adVar2;
        ad adVar3;
        ad adVar4;
        ad adVar5;
        String bf = TiebaApplication.g().bf();
        String bg = TiebaApplication.g().bg();
        adVar = this.a.c;
        if (!adVar.c() && !TextUtils.isEmpty(bf) && !TextUtils.isEmpty(bg)) {
            adVar3 = this.a.c;
            adVar3.b(bf);
            adVar4 = this.a.c;
            adVar4.a(bg);
            adVar5 = this.a.c;
            adVar5.f();
        } else if (UtilHelper.b()) {
            adVar2 = this.a.c;
            adVar2.c(true);
            com.baidu.adp.lib.c.a.a().a(true, this.a.a);
        } else {
            kVar = this.a.b;
            if (kVar.j() == null) {
                kVar3 = this.a.b;
                kVar3.a(new NearbyGroupsData());
            }
            kVar2 = this.a.b;
            kVar2.h();
        }
    }
}
