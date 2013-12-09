package com.baidu.tieba.im.nearbygroups;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.NearbyGroupsData;
import com.baidu.tieba.im.model.s;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class d implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NearbyGroupsActivity f1846a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NearbyGroupsActivity nearbyGroupsActivity) {
        this.f1846a = nearbyGroupsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        s sVar;
        k kVar;
        k kVar2;
        k kVar3;
        s sVar2;
        s sVar3;
        s sVar4;
        s sVar5;
        String be = TiebaApplication.h().be();
        String bf = TiebaApplication.h().bf();
        sVar = this.f1846a.c;
        if (!sVar.c() && !TextUtils.isEmpty(be) && !TextUtils.isEmpty(bf)) {
            sVar3 = this.f1846a.c;
            sVar3.b(be);
            sVar4 = this.f1846a.c;
            sVar4.a(bf);
            sVar5 = this.f1846a.c;
            sVar5.f();
        } else if (UtilHelper.b()) {
            sVar2 = this.f1846a.c;
            sVar2.c(true);
            com.baidu.adp.lib.c.a.a().a(true, this.f1846a.f1843a);
        } else {
            kVar = this.f1846a.b;
            if (kVar.j() == null) {
                kVar3 = this.f1846a.b;
                kVar3.a(new NearbyGroupsData());
            }
            kVar2 = this.f1846a.b;
            kVar2.h();
        }
    }
}
