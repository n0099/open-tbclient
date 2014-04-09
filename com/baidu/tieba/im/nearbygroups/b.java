package com.baidu.tieba.im.nearbygroups;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.im.data.NearbyGroupsData;
import com.baidu.tieba.im.model.ay;
/* loaded from: classes.dex */
final class b implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ NearbyGroupsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NearbyGroupsActivity nearbyGroupsActivity) {
        this.a = nearbyGroupsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public final void a(boolean z) {
        ay ayVar;
        m mVar;
        m mVar2;
        m mVar3;
        ay ayVar2;
        ay ayVar3;
        ay ayVar4;
        ay ayVar5;
        TbadkApplication.j();
        String W = TbadkApplication.W();
        TbadkApplication.j();
        String Y = TbadkApplication.Y();
        ayVar = this.a.c;
        if (!ayVar.c() && !TextUtils.isEmpty(W) && !TextUtils.isEmpty(Y)) {
            ayVar3 = this.a.c;
            ayVar3.b(W);
            ayVar4 = this.a.c;
            ayVar4.a(Y);
            ayVar5 = this.a.c;
            ayVar5.f();
        } else if (!UtilHelper.a()) {
            mVar = this.a.b;
            if (mVar.i() == null) {
                mVar3 = this.a.b;
                mVar3.a(new NearbyGroupsData());
            }
            mVar2 = this.a.b;
            mVar2.g();
        } else {
            ayVar2 = this.a.c;
            ayVar2.c(true);
            com.baidu.adp.lib.c.a.a().a(true, this.a.a);
        }
    }
}
