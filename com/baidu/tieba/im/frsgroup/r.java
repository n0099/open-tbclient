package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.tieba.im.data.MembersData;
import com.baidu.tieba.im.data.UserData;
import com.baidu.tieba.im.message.ai;
import com.baidu.tieba.im.message.bm;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
class r implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.o oVar) {
        aa aaVar;
        ai aiVar;
        com.baidu.tieba.im.model.m mVar;
        boolean i;
        boolean i2;
        com.baidu.tieba.im.model.m mVar2;
        com.baidu.tieba.im.model.m mVar3;
        com.baidu.tieba.im.model.m mVar4;
        boolean i3;
        aaVar = this.a.b;
        w i4 = aaVar.i();
        this.a.h();
        if (oVar == null || !(oVar instanceof bm)) {
            this.a.showToast(R.string.neterror);
            return;
        }
        bm bmVar = (bm) oVar;
        com.baidu.tieba.im.message.o l = bmVar.l();
        if (l == null || !(l instanceof ai)) {
            aiVar = null;
        } else {
            aiVar = (ai) l;
        }
        mVar = this.a.c;
        mVar.a(aiVar);
        if (bmVar.i()) {
            if (bmVar.j() > 0) {
                if (!TextUtils.isEmpty(bmVar.k())) {
                    this.a.showToast(bmVar.k());
                    return;
                }
                return;
            }
            this.a.showToast(R.string.neterror);
            return;
        }
        MembersData a = bmVar.a();
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
            mVar2 = this.a.c;
            if (size != mVar2.e()) {
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
            mVar3 = this.a.c;
            mVar3.c(users.size());
            mVar4 = this.a.c;
            mVar4.d(20);
            i4.a(users);
            i4.notifyDataSetChanged();
            this.a.c();
        }
    }
}
