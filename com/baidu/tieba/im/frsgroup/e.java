package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.frsgroup.GroupListAdapter;
import com.baidu.tieba.im.message.al;
import com.baidu.tieba.im.message.bx;
import com.slidingmenu.lib.R;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.a = cVar;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(com.baidu.tieba.im.message.s sVar) {
        i iVar;
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
        if (sVar == null || !(sVar instanceof bx)) {
            this.a.a(R.string.neterror);
            return;
        }
        bx bxVar = (bx) sVar;
        com.baidu.tieba.im.message.s o = bxVar.o();
        if (o != null && (o instanceof al)) {
            String c = ((al) o).c();
            dVar10 = this.a.c;
            if (!c.equals(String.valueOf(dVar10.g()))) {
                return;
            }
        }
        if (bxVar.w() == -201) {
            dVar8 = this.a.c;
            if (!dVar8.e() && (a = bxVar.a()) != null && !a.isEmpty()) {
                dVar9 = this.a.c;
                dVar9.a(true);
                groupListAdapter9 = this.a.i;
                groupListAdapter9.b(true);
                groupListAdapter10 = this.a.i;
                groupListAdapter10.a(GroupListAdapter.BOTTOM_TYPE.LINE);
                groupListAdapter11 = this.a.i;
                groupListAdapter11.a(a);
                groupListAdapter12 = this.a.i;
                groupListAdapter12.notifyDataSetChanged();
                c.d(this.a);
            }
            this.a.a(true);
            return;
        }
        c.e(this.a);
        iVar = this.a.d;
        iVar.b(true);
        dVar = this.a.c;
        dVar.a(this.a.getTag());
        if (bxVar.l()) {
            if (bxVar.m() > 0) {
                if (!TextUtils.isEmpty(bxVar.n())) {
                    this.a.a(bxVar.n());
                    return;
                }
                return;
            }
            this.a.a(R.string.neterror);
            return;
        }
        List<GroupInfoData> a2 = bxVar.a();
        GroupPermData b = bxVar.b();
        dVar2 = this.a.c;
        dVar2.a(b);
        if (a2 != null) {
            dVar3 = this.a.c;
            if (dVar3.h()) {
                groupListAdapter8 = this.a.i;
                groupListAdapter8.a(true);
                this.a.b(true);
            }
            this.a.k = BdUtilHelper.a();
            int size = a2.size();
            dVar4 = this.a.c;
            if (size != dVar4.k()) {
                dVar7 = this.a.c;
                if (!dVar7.h()) {
                    groupListAdapter5 = this.a.i;
                    groupListAdapter5.a(GroupListAdapter.BOTTOM_TYPE.NO_MORE);
                } else if (a2.size() == 0) {
                    groupListAdapter7 = this.a.i;
                    groupListAdapter7.b(false);
                    c.g(this.a);
                    return;
                } else {
                    groupListAdapter6 = this.a.i;
                    groupListAdapter6.a(GroupListAdapter.BOTTOM_TYPE.LINE);
                }
            } else {
                groupListAdapter = this.a.i;
                groupListAdapter.a(GroupListAdapter.BOTTOM_TYPE.HAVE_MORE);
            }
            c.h(this.a);
            groupListAdapter2 = this.a.i;
            groupListAdapter2.b(true);
            dVar5 = this.a.c;
            dVar5.c(a2.size());
            dVar6 = this.a.c;
            dVar6.d(20);
            groupListAdapter3 = this.a.i;
            groupListAdapter3.a(a2);
            groupListAdapter4 = this.a.i;
            groupListAdapter4.notifyDataSetChanged();
            c.d(this.a);
        }
    }
}
