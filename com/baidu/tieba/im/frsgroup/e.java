package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.frsgroup.GroupListAdapter;
import com.baidu.tieba.im.message.ResponseFrsGroupsLocalMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e extends com.baidu.adp.framework.c.a {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(b bVar, int i) {
        super(2001201);
        this.a = bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.im.model.k kVar;
        List<GroupInfoData> b;
        com.baidu.tieba.im.model.k kVar2;
        GroupListAdapter groupListAdapter;
        GroupListAdapter groupListAdapter2;
        GroupListAdapter groupListAdapter3;
        GroupListAdapter groupListAdapter4;
        com.baidu.tieba.im.model.k kVar3;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        this.a.a(true);
        if (customResponsedMessage2 == null || !(customResponsedMessage2 instanceof ResponseFrsGroupsLocalMessage)) {
            this.a.a(com.baidu.tieba.im.j.neterror);
            return;
        }
        ResponseFrsGroupsLocalMessage responseFrsGroupsLocalMessage = (ResponseFrsGroupsLocalMessage) customResponsedMessage2;
        com.baidu.adp.framework.message.d<?> h = responseFrsGroupsLocalMessage.h();
        if (h != null && (h instanceof com.baidu.tieba.im.message.af)) {
            String c = ((com.baidu.tieba.im.message.af) h).c();
            kVar3 = this.a.c;
            if (!c.equals(String.valueOf(kVar3.g()))) {
                return;
            }
        }
        kVar = this.a.c;
        if (kVar.e() || (b = responseFrsGroupsLocalMessage.b()) == null || b.isEmpty()) {
            return;
        }
        kVar2 = this.a.c;
        kVar2.a(true);
        groupListAdapter = this.a.i;
        groupListAdapter.b(true);
        groupListAdapter2 = this.a.i;
        groupListAdapter2.a(GroupListAdapter.BOTTOM_TYPE.LINE);
        groupListAdapter3 = this.a.i;
        groupListAdapter3.a(b);
        groupListAdapter4 = this.a.i;
        groupListAdapter4.notifyDataSetChanged();
        b.h(this.a);
    }
}
