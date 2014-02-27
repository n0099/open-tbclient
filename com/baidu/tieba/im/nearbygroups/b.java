package com.baidu.tieba.im.nearbygroups;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.NearbyGroupsData;
import com.baidu.tieba.im.model.ak;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
final class b implements com.baidu.adp.widget.ListView.b {
    final /* synthetic */ NearbyGroupsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NearbyGroupsActivity nearbyGroupsActivity) {
        this.a = nearbyGroupsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public final void a(boolean z) {
        ak akVar;
        k kVar;
        k kVar2;
        k kVar3;
        ak akVar2;
        ak akVar3;
        ak akVar4;
        ak akVar5;
        String aU = TiebaApplication.g().aU();
        String aW = TiebaApplication.g().aW();
        akVar = this.a.c;
        if (!akVar.c() && !TextUtils.isEmpty(aU) && !TextUtils.isEmpty(aW)) {
            akVar3 = this.a.c;
            akVar3.b(aU);
            akVar4 = this.a.c;
            akVar4.a(aW);
            akVar5 = this.a.c;
            akVar5.f();
        } else if (!UtilHelper.b()) {
            kVar = this.a.b;
            if (kVar.i() == null) {
                kVar3 = this.a.b;
                kVar3.a(new NearbyGroupsData());
            }
            kVar2 = this.a.b;
            kVar2.g();
        } else {
            akVar2 = this.a.c;
            akVar2.c(true);
            com.baidu.adp.lib.c.a.a().a(true, this.a.a);
        }
    }
}
