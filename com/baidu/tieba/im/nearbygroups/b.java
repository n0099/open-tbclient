package com.baidu.tieba.im.nearbygroups;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.im.data.NearbyGroupsData;
import com.baidu.tieba.im.model.ax;
/* loaded from: classes.dex */
final class b implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ NearbyGroupsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NearbyGroupsActivity nearbyGroupsActivity) {
        this.a = nearbyGroupsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public final void a(boolean z) {
        ax axVar;
        m mVar;
        m mVar2;
        m mVar3;
        ax axVar2;
        ax axVar3;
        ax axVar4;
        ax axVar5;
        TbadkApplication.j();
        String W = TbadkApplication.W();
        TbadkApplication.j();
        String Y = TbadkApplication.Y();
        axVar = this.a.c;
        if (!axVar.c() && !TextUtils.isEmpty(W) && !TextUtils.isEmpty(Y)) {
            axVar3 = this.a.c;
            axVar3.b(W);
            axVar4 = this.a.c;
            axVar4.a(Y);
            axVar5 = this.a.c;
            axVar5.f();
        } else if (!UtilHelper.a()) {
            mVar = this.a.b;
            if (mVar.i() == null) {
                mVar3 = this.a.b;
                mVar3.a(new NearbyGroupsData());
            }
            mVar2 = this.a.b;
            mVar2.g();
        } else {
            axVar2 = this.a.c;
            axVar2.c(true);
            com.baidu.adp.lib.c.a.a().a(true, this.a.a);
        }
    }
}
