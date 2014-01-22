package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.tieba.im.data.MembersData;
import com.baidu.tieba.im.data.UserData;
import com.baidu.tieba.im.message.am;
import com.baidu.tieba.im.message.bw;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
class t implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.q qVar) {
        ac acVar;
        am amVar;
        com.baidu.tieba.im.model.n nVar;
        boolean i;
        boolean i2;
        com.baidu.tieba.im.model.n nVar2;
        com.baidu.tieba.im.model.n nVar3;
        com.baidu.tieba.im.model.n nVar4;
        boolean i3;
        acVar = this.a.b;
        y i4 = acVar.i();
        this.a.h();
        if (qVar == null || !(qVar instanceof bw)) {
            this.a.showToast(R.string.neterror);
            return;
        }
        bw bwVar = (bw) qVar;
        com.baidu.tieba.im.message.q n = bwVar.n();
        if (n == null || !(n instanceof am)) {
            amVar = null;
        } else {
            amVar = (am) n;
        }
        nVar = this.a.c;
        nVar.a(amVar);
        if (bwVar.k()) {
            if (bwVar.l() > 0) {
                if (!TextUtils.isEmpty(bwVar.m())) {
                    this.a.showToast(bwVar.m());
                    return;
                }
                return;
            }
            this.a.showToast(R.string.neterror);
            return;
        }
        MembersData a = bwVar.a();
        List<UserData> users = a.getUsers();
        if (users != null) {
            i = this.a.i();
            if (i) {
                this.a.a(a.getPermission());
            }
            i2 = this.a.i();
            if (i2) {
                i4.a(true);
            }
            int size = users.size();
            nVar2 = this.a.c;
            if (size != nVar2.e()) {
                i4.b(false);
                i4.c(false);
                i3 = this.a.i();
                if (i3 && users.size() == 0) {
                    this.a.j();
                    return;
                }
            } else {
                i4.c(true);
            }
            nVar3 = this.a.c;
            nVar3.c(users.size());
            nVar4 = this.a.c;
            nVar4.d(20);
            i4.a(users);
            i4.notifyDataSetChanged();
            this.a.c();
        }
    }
}
