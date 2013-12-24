package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.frsgroup.GroupListAdapter;
import com.baidu.tieba.im.message.bc;
import com.slidingmenu.lib.R;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ FrsGroupListFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsGroupListFragment frsGroupListFragment) {
        this.a = frsGroupListFragment;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.n nVar) {
        g gVar;
        com.baidu.tieba.im.model.c cVar;
        com.baidu.tieba.im.model.c cVar2;
        com.baidu.tieba.im.model.c cVar3;
        com.baidu.tieba.im.model.c cVar4;
        GroupListAdapter groupListAdapter;
        GroupListAdapter groupListAdapter2;
        com.baidu.tieba.im.model.c cVar5;
        com.baidu.tieba.im.model.c cVar6;
        GroupListAdapter groupListAdapter3;
        GroupListAdapter groupListAdapter4;
        com.baidu.tieba.im.model.c cVar7;
        GroupListAdapter groupListAdapter5;
        GroupListAdapter groupListAdapter6;
        GroupListAdapter groupListAdapter7;
        GroupListAdapter groupListAdapter8;
        com.baidu.tieba.im.model.c cVar8;
        List<GroupInfoData> a;
        com.baidu.tieba.im.model.c cVar9;
        GroupListAdapter groupListAdapter9;
        GroupListAdapter groupListAdapter10;
        GroupListAdapter groupListAdapter11;
        GroupListAdapter groupListAdapter12;
        com.baidu.tieba.im.model.c cVar10;
        if (nVar == null || !(nVar instanceof bc)) {
            this.a.b(R.string.neterror);
            return;
        }
        bc bcVar = (bc) nVar;
        com.baidu.tieba.im.message.n l = bcVar.l();
        if (l != null && (l instanceof com.baidu.tieba.im.message.z)) {
            String e = ((com.baidu.tieba.im.message.z) l).e();
            cVar10 = this.a.b;
            if (!e.equals(String.valueOf(cVar10.g()))) {
                return;
            }
        }
        if (bcVar.t() == -201) {
            cVar8 = this.a.b;
            if (!cVar8.e() && (a = bcVar.a()) != null && !a.isEmpty()) {
                cVar9 = this.a.b;
                cVar9.a(true);
                groupListAdapter9 = this.a.h;
                groupListAdapter9.b(true);
                groupListAdapter10 = this.a.h;
                groupListAdapter10.a(GroupListAdapter.BOTTOM_TYPE.LINE);
                groupListAdapter11 = this.a.h;
                groupListAdapter11.a(a);
                groupListAdapter12 = this.a.h;
                groupListAdapter12.notifyDataSetChanged();
                this.a.O();
            }
            this.a.a(true);
            return;
        }
        this.a.M();
        gVar = this.a.c;
        gVar.b(true);
        cVar = this.a.b;
        cVar.a(this.a.g());
        if (bcVar.i()) {
            if (bcVar.j() > 0) {
                if (!TextUtils.isEmpty(bcVar.k())) {
                    this.a.a(bcVar.k());
                    return;
                }
                return;
            }
            this.a.b(R.string.neterror);
            return;
        }
        List<GroupInfoData> a2 = bcVar.a();
        GroupPermData b = bcVar.b();
        cVar2 = this.a.b;
        cVar2.a(b);
        if (a2 != null) {
            cVar3 = this.a.b;
            if (cVar3.h()) {
                groupListAdapter8 = this.a.h;
                groupListAdapter8.a(true);
                this.a.e(true);
            }
            this.a.Y = com.baidu.tieba.im.d.c.a();
            int size = a2.size();
            cVar4 = this.a.b;
            if (size != cVar4.l()) {
                cVar7 = this.a.b;
                if (!cVar7.h()) {
                    groupListAdapter5 = this.a.h;
                    groupListAdapter5.a(GroupListAdapter.BOTTOM_TYPE.NO_MORE);
                } else if (a2.size() == 0) {
                    groupListAdapter7 = this.a.h;
                    groupListAdapter7.b(false);
                    this.a.P();
                    return;
                } else {
                    groupListAdapter6 = this.a.h;
                    groupListAdapter6.a(GroupListAdapter.BOTTOM_TYPE.LINE);
                }
            } else {
                groupListAdapter = this.a.h;
                groupListAdapter.a(GroupListAdapter.BOTTOM_TYPE.HAVE_MORE);
            }
            this.a.N();
            groupListAdapter2 = this.a.h;
            groupListAdapter2.b(true);
            cVar5 = this.a.b;
            cVar5.c(a2.size());
            cVar6 = this.a.b;
            cVar6.d(20);
            groupListAdapter3 = this.a.h;
            groupListAdapter3.a(a2);
            groupListAdapter4 = this.a.h;
            groupListAdapter4.notifyDataSetChanged();
            this.a.O();
        }
    }
}
