package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.data.MembersData;
import com.baidu.tieba.im.message.ResponseMembersMessage;
import com.baidu.tieba.im.message.ap;
import java.util.List;
/* loaded from: classes.dex */
final class q extends com.baidu.adp.framework.c.g {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(MembersActivity membersActivity, int i) {
        super(103005);
        this.a = membersActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        ah ahVar;
        com.baidu.tieba.im.model.z zVar;
        boolean d;
        boolean d2;
        com.baidu.tieba.im.model.z zVar2;
        com.baidu.tieba.im.model.z zVar3;
        com.baidu.tieba.im.model.z zVar4;
        boolean d3;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        ahVar = this.a.b;
        ad h = ahVar.h();
        MembersActivity.b(this.a);
        if (socketResponsedMessage2 == null || !(socketResponsedMessage2 instanceof ResponseMembersMessage)) {
            this.a.showToast(com.baidu.tieba.im.j.neterror);
            return;
        }
        ResponseMembersMessage responseMembersMessage = (ResponseMembersMessage) socketResponsedMessage2;
        com.baidu.adp.framework.message.d<?> h2 = responseMembersMessage.h();
        ap apVar = (h2 == null || !(h2 instanceof ap)) ? null : (ap) h2;
        zVar = this.a.c;
        zVar.a(apVar);
        if (responseMembersMessage.e() != 0) {
            if (responseMembersMessage.e() <= 0) {
                this.a.showToast(com.baidu.tieba.im.j.neterror);
                return;
            } else if (TextUtils.isEmpty(responseMembersMessage.f())) {
                return;
            } else {
                this.a.showToast(responseMembersMessage.f());
                return;
            }
        }
        MembersData d4 = responseMembersMessage.d();
        List<UserData> users = d4.getUsers();
        if (users != null) {
            d = this.a.d();
            if (d) {
                MembersActivity.a(this.a, d4.getPermission());
            }
            d2 = this.a.d();
            if (d2) {
                h.a(true);
            }
            int size = users.size();
            zVar2 = this.a.c;
            if (size != zVar2.e()) {
                h.b(false);
                h.c(false);
                d3 = this.a.d();
                if (d3 && users.size() == 0) {
                    MembersActivity.e(this.a);
                    return;
                }
            } else {
                h.c(true);
            }
            zVar3 = this.a.c;
            zVar3.c(users.size());
            zVar4 = this.a.c;
            zVar4.d(20);
            h.a(users);
            h.notifyDataSetChanged();
            this.a.c();
        }
    }
}
