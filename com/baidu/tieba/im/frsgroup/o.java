package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.data.MembersData;
import com.baidu.tieba.im.message.as;
import com.baidu.tieba.im.message.cf;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
final class o implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(com.baidu.tieba.im.message.s sVar) {
        ae aeVar;
        as asVar;
        com.baidu.tieba.im.model.l lVar;
        boolean e;
        boolean e2;
        com.baidu.tieba.im.model.l lVar2;
        com.baidu.tieba.im.model.l lVar3;
        com.baidu.tieba.im.model.l lVar4;
        boolean e3;
        aeVar = this.a.b;
        aa h = aeVar.h();
        MembersActivity.b(this.a);
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
            e = this.a.e();
            if (e) {
                MembersActivity.a(this.a, a.getPermission());
            }
            e2 = this.a.e();
            if (e2) {
                h.a(true);
            }
            int size = users.size();
            lVar2 = this.a.c;
            if (size != lVar2.e()) {
                h.b(false);
                h.c(false);
                e3 = this.a.e();
                if (e3 && users.size() == 0) {
                    MembersActivity.e(this.a);
                    return;
                }
            } else {
                h.c(true);
            }
            lVar3 = this.a.c;
            lVar3.c(users.size());
            lVar4 = this.a.c;
            lVar4.d(20);
            h.a(users);
            h.notifyDataSetChanged();
            this.a.c();
        }
    }
}
