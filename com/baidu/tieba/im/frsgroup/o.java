package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.data.MembersData;
import com.baidu.tieba.im.message.as;
import com.baidu.tieba.im.message.cf;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
class o implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.s sVar) {
        ae aeVar;
        as asVar;
        com.baidu.tieba.im.model.l lVar;
        boolean i;
        boolean i2;
        com.baidu.tieba.im.model.l lVar2;
        com.baidu.tieba.im.model.l lVar3;
        com.baidu.tieba.im.model.l lVar4;
        boolean i3;
        aeVar = this.a.b;
        aa i4 = aeVar.i();
        this.a.h();
        if (sVar == null || !(sVar instanceof cf)) {
            this.a.showToast(R.string.neterror);
            return;
        }
        cf cfVar = (cf) sVar;
        com.baidu.tieba.im.message.s o = cfVar.o();
        if (o == null || !(o instanceof as)) {
            asVar = null;
        } else {
            asVar = (as) o;
        }
        lVar = this.a.c;
        lVar.a(asVar);
        if (cfVar.l()) {
            if (cfVar.m() > 0) {
                if (!TextUtils.isEmpty(cfVar.n())) {
                    this.a.showToast(cfVar.n());
                    return;
                }
                return;
            }
            this.a.showToast(R.string.neterror);
            return;
        }
        MembersData a = cfVar.a();
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
            lVar2 = this.a.c;
            if (size != lVar2.e()) {
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
            lVar3 = this.a.c;
            lVar3.c(users.size());
            lVar4 = this.a.c;
            lVar4.d(20);
            i4.a(users);
            i4.notifyDataSetChanged();
            this.a.c();
        }
    }
}
