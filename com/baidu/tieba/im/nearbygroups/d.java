package com.baidu.tieba.im.nearbygroups;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.NearbyGroupsData;
import com.baidu.tieba.im.model.af;
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
        af afVar;
        k kVar;
        k kVar2;
        k kVar3;
        af afVar2;
        af afVar3;
        af afVar4;
        af afVar5;
        String bf = TiebaApplication.h().bf();
        String bh = TiebaApplication.h().bh();
        afVar = this.a.c;
        if (!afVar.c() && !TextUtils.isEmpty(bf) && !TextUtils.isEmpty(bh)) {
            afVar3 = this.a.c;
            afVar3.b(bf);
            afVar4 = this.a.c;
            afVar4.a(bh);
            afVar5 = this.a.c;
            afVar5.f();
        } else if (UtilHelper.b()) {
            afVar2 = this.a.c;
            afVar2.c(true);
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
