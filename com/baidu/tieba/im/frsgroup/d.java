package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.frsgroup.GroupListAdapter;
import com.baidu.tieba.im.message.ResponseFrsGroupsMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends com.baidu.adp.framework.c.g {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, int i) {
        super(103002);
        this.a = bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        k kVar;
        com.baidu.tieba.im.model.k kVar2;
        com.baidu.tieba.im.model.k kVar3;
        com.baidu.tieba.im.model.k kVar4;
        com.baidu.tieba.im.model.k kVar5;
        GroupListAdapter groupListAdapter;
        GroupListAdapter groupListAdapter2;
        com.baidu.tieba.im.model.k kVar6;
        com.baidu.tieba.im.model.k kVar7;
        GroupListAdapter groupListAdapter3;
        GroupListAdapter groupListAdapter4;
        com.baidu.tieba.im.model.k kVar8;
        GroupListAdapter groupListAdapter5;
        GroupListAdapter groupListAdapter6;
        GroupListAdapter groupListAdapter7;
        GroupListAdapter groupListAdapter8;
        com.baidu.tieba.im.model.k kVar9;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (socketResponsedMessage2 == null || !(socketResponsedMessage2 instanceof ResponseFrsGroupsMessage)) {
            this.a.showToast(com.baidu.tieba.im.j.neterror);
            return;
        }
        ResponseFrsGroupsMessage responseFrsGroupsMessage = (ResponseFrsGroupsMessage) socketResponsedMessage2;
        com.baidu.adp.framework.message.d<?> h = responseFrsGroupsMessage.h();
        if (h != null && (h instanceof com.baidu.tieba.im.message.ag)) {
            String j = ((com.baidu.tieba.im.message.ag) h).j();
            kVar9 = this.a.b;
            if (!j.equals(String.valueOf(kVar9.g()))) {
                return;
            }
        }
        b.d(this.a);
        kVar = this.a.c;
        kVar.b(true);
        kVar2 = this.a.b;
        kVar2.a(this.a.getTag());
        if (responseFrsGroupsMessage.e() != 0) {
            if (responseFrsGroupsMessage.e() <= 0) {
                this.a.showToast(com.baidu.tieba.im.j.neterror);
                return;
            } else if (TextUtils.isEmpty(responseFrsGroupsMessage.f())) {
                return;
            } else {
                this.a.showToast(responseFrsGroupsMessage.f());
                return;
            }
        }
        List<GroupInfoData> d = responseFrsGroupsMessage.d();
        GroupPermData i = responseFrsGroupsMessage.i();
        kVar3 = this.a.b;
        kVar3.a(i);
        if (d != null) {
            kVar4 = this.a.b;
            if (kVar4.h()) {
                groupListAdapter8 = this.a.h;
                groupListAdapter8.a(true);
                this.a.b(true);
            }
            this.a.j = com.baidu.adp.lib.util.i.a();
            int size = d.size();
            kVar5 = this.a.b;
            if (size != kVar5.k()) {
                kVar8 = this.a.b;
                if (!kVar8.h()) {
                    groupListAdapter5 = this.a.h;
                    groupListAdapter5.a(GroupListAdapter.BOTTOM_TYPE.NO_MORE);
                } else if (d.size() == 0) {
                    groupListAdapter7 = this.a.h;
                    groupListAdapter7.b(false);
                    b.f(this.a);
                    return;
                } else {
                    groupListAdapter6 = this.a.h;
                    groupListAdapter6.a(GroupListAdapter.BOTTOM_TYPE.LINE);
                }
            } else {
                groupListAdapter = this.a.h;
                groupListAdapter.a(GroupListAdapter.BOTTOM_TYPE.HAVE_MORE);
            }
            b.g(this.a);
            groupListAdapter2 = this.a.h;
            groupListAdapter2.b(true);
            kVar6 = this.a.b;
            kVar6.c(d.size());
            kVar7 = this.a.b;
            kVar7.d(20);
            groupListAdapter3 = this.a.h;
            groupListAdapter3.a(d);
            groupListAdapter4 = this.a.h;
            groupListAdapter4.notifyDataSetChanged();
            b.h(this.a);
        }
    }
}
