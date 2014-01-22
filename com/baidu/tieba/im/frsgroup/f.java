package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.frsgroup.GroupListAdapter;
import com.baidu.tieba.im.message.ag;
import com.baidu.tieba.im.message.bp;
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
    public void a(com.baidu.tieba.im.message.q qVar) {
        g gVar;
        com.baidu.tieba.im.model.d dVar;
        com.baidu.tieba.im.model.d dVar2;
        com.baidu.tieba.im.model.d dVar3;
        com.baidu.tieba.im.model.d dVar4;
        GroupListAdapter groupListAdapter;
        GroupListAdapter groupListAdapter2;
        com.baidu.tieba.im.model.d dVar5;
        com.baidu.tieba.im.model.d dVar6;
        GroupListAdapter groupListAdapter3;
        GroupListAdapter groupListAdapter4;
        com.baidu.tieba.im.model.d dVar7;
        GroupListAdapter groupListAdapter5;
        GroupListAdapter groupListAdapter6;
        GroupListAdapter groupListAdapter7;
        GroupListAdapter groupListAdapter8;
        com.baidu.tieba.im.model.d dVar8;
        List<GroupInfoData> a;
        com.baidu.tieba.im.model.d dVar9;
        GroupListAdapter groupListAdapter9;
        GroupListAdapter groupListAdapter10;
        GroupListAdapter groupListAdapter11;
        GroupListAdapter groupListAdapter12;
        com.baidu.tieba.im.model.d dVar10;
        if (qVar == null || !(qVar instanceof bp)) {
            this.a.c(R.string.neterror);
            return;
        }
        bp bpVar = (bp) qVar;
        com.baidu.tieba.im.message.q n = bpVar.n();
        if (n != null && (n instanceof ag)) {
            String e = ((ag) n).e();
            dVar10 = this.a.b;
            if (!e.equals(String.valueOf(dVar10.g()))) {
                return;
            }
        }
        if (bpVar.w() == -201) {
            dVar8 = this.a.b;
            if (!dVar8.e() && (a = bpVar.a()) != null && !a.isEmpty()) {
                dVar9 = this.a.b;
                dVar9.a(true);
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
        dVar = this.a.b;
        dVar.a(this.a.g());
        if (bpVar.k()) {
            if (bpVar.l() > 0) {
                if (!TextUtils.isEmpty(bpVar.m())) {
                    this.a.a(bpVar.m());
                    return;
                }
                return;
            }
            this.a.c(R.string.neterror);
            return;
        }
        List<GroupInfoData> a2 = bpVar.a();
        GroupPermData b = bpVar.b();
        dVar2 = this.a.b;
        dVar2.a(b);
        if (a2 != null) {
            dVar3 = this.a.b;
            if (dVar3.h()) {
                groupListAdapter8 = this.a.h;
                groupListAdapter8.a(true);
                this.a.e(true);
            }
            this.a.Y = com.baidu.tieba.im.d.c.a();
            int size = a2.size();
            dVar4 = this.a.b;
            if (size != dVar4.l()) {
                dVar7 = this.a.b;
                if (!dVar7.h()) {
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
            dVar5 = this.a.b;
            dVar5.c(a2.size());
            dVar6 = this.a.b;
            dVar6.d(20);
            groupListAdapter3 = this.a.h;
            groupListAdapter3.a(a2);
            groupListAdapter4 = this.a.h;
            groupListAdapter4.notifyDataSetChanged();
            this.a.O();
        }
    }
}
