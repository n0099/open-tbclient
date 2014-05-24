package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.frsgroup.GroupListAdapter;
import com.baidu.tieba.im.message.RequestFrsGroupsMessage;
import com.baidu.tieba.im.message.ResponseFrsGroupsMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, int i) {
        super(i);
        this.a = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
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
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseFrsGroupsMessage)) {
            this.a.a(com.baidu.tieba.y.neterror);
            return;
        }
        ResponseFrsGroupsMessage responseFrsGroupsMessage = (ResponseFrsGroupsMessage) socketResponsedMessage;
        Message<?> orginalMessage = responseFrsGroupsMessage.getOrginalMessage();
        if (orginalMessage != null && (orginalMessage instanceof RequestFrsGroupsMessage)) {
            String type = ((RequestFrsGroupsMessage) orginalMessage).getType();
            kVar9 = this.a.c;
            if (!type.equals(String.valueOf(kVar9.g()))) {
                return;
            }
        }
        this.a.l();
        kVar = this.a.d;
        kVar.b(true);
        kVar2 = this.a.c;
        kVar2.a(this.a.getTag());
        if (responseFrsGroupsMessage.getError() != 0) {
            if (responseFrsGroupsMessage.getError() > 0) {
                if (!TextUtils.isEmpty(responseFrsGroupsMessage.getErrorString())) {
                    this.a.b(responseFrsGroupsMessage.getErrorString());
                    return;
                }
                return;
            }
            this.a.a(com.baidu.tieba.y.neterror);
            return;
        }
        List<GroupInfoData> groups = responseFrsGroupsMessage.getGroups();
        GroupPermData groupPerm = responseFrsGroupsMessage.getGroupPerm();
        kVar3 = this.a.c;
        kVar3.a(groupPerm);
        if (groups != null) {
            kVar4 = this.a.c;
            if (kVar4.h()) {
                groupListAdapter8 = this.a.i;
                groupListAdapter8.a(true);
                this.a.c(true);
            }
            this.a.k = com.baidu.adp.lib.util.k.a();
            int size = groups.size();
            kVar5 = this.a.c;
            if (size != kVar5.l()) {
                kVar8 = this.a.c;
                if (!kVar8.h()) {
                    groupListAdapter5 = this.a.i;
                    groupListAdapter5.a(GroupListAdapter.BOTTOM_TYPE.NO_MORE);
                } else if (groups.size() == 0) {
                    groupListAdapter7 = this.a.i;
                    groupListAdapter7.b(false);
                    this.a.o();
                    return;
                } else {
                    groupListAdapter6 = this.a.i;
                    groupListAdapter6.a(GroupListAdapter.BOTTOM_TYPE.LINE);
                }
            } else {
                groupListAdapter = this.a.i;
                groupListAdapter.a(GroupListAdapter.BOTTOM_TYPE.HAVE_MORE);
            }
            this.a.m();
            groupListAdapter2 = this.a.i;
            groupListAdapter2.b(true);
            kVar6 = this.a.c;
            kVar6.c(groups.size());
            kVar7 = this.a.c;
            kVar7.d(20);
            groupListAdapter3 = this.a.i;
            groupListAdapter3.a(groups);
            groupListAdapter4 = this.a.i;
            groupListAdapter4.notifyDataSetChanged();
            this.a.n();
        }
    }
}
