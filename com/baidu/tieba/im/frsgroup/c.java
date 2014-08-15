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
public class c extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.a = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        j jVar;
        com.baidu.tieba.im.model.i iVar;
        com.baidu.tieba.im.model.i iVar2;
        com.baidu.tieba.im.model.i iVar3;
        com.baidu.tieba.im.model.i iVar4;
        GroupListAdapter groupListAdapter;
        GroupListAdapter groupListAdapter2;
        com.baidu.tieba.im.model.i iVar5;
        com.baidu.tieba.im.model.i iVar6;
        GroupListAdapter groupListAdapter3;
        GroupListAdapter groupListAdapter4;
        com.baidu.tieba.im.model.i iVar7;
        GroupListAdapter groupListAdapter5;
        GroupListAdapter groupListAdapter6;
        GroupListAdapter groupListAdapter7;
        GroupListAdapter groupListAdapter8;
        com.baidu.tieba.im.model.i iVar8;
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseFrsGroupsMessage)) {
            this.a.a(com.baidu.tieba.x.neterror);
            return;
        }
        ResponseFrsGroupsMessage responseFrsGroupsMessage = (ResponseFrsGroupsMessage) socketResponsedMessage;
        Message<?> orginalMessage = responseFrsGroupsMessage.getOrginalMessage();
        if (orginalMessage != null && (orginalMessage instanceof RequestFrsGroupsMessage)) {
            String type = ((RequestFrsGroupsMessage) orginalMessage).getType();
            iVar8 = this.a.c;
            if (!type.equals(String.valueOf(iVar8.g()))) {
                return;
            }
        }
        this.a.l();
        jVar = this.a.d;
        jVar.b(true);
        iVar = this.a.c;
        iVar.a(this.a.getTag());
        if (responseFrsGroupsMessage.getError() != 0) {
            if (responseFrsGroupsMessage.getError() > 0) {
                if (!TextUtils.isEmpty(responseFrsGroupsMessage.getErrorString())) {
                    this.a.b(responseFrsGroupsMessage.getErrorString());
                    return;
                }
                return;
            }
            this.a.a(com.baidu.tieba.x.neterror);
            return;
        }
        List<GroupInfoData> groups = responseFrsGroupsMessage.getGroups();
        GroupPermData groupPerm = responseFrsGroupsMessage.getGroupPerm();
        iVar2 = this.a.c;
        iVar2.a(groupPerm);
        if (groups != null) {
            iVar3 = this.a.c;
            if (iVar3.h()) {
                groupListAdapter8 = this.a.i;
                groupListAdapter8.a(true);
                this.a.c(true);
            }
            int size = groups.size();
            iVar4 = this.a.c;
            if (size != iVar4.k()) {
                iVar7 = this.a.c;
                if (!iVar7.h()) {
                    groupListAdapter5 = this.a.i;
                    groupListAdapter5.a(GroupListAdapter.BOTTOM_TYPE.NO_MORE);
                } else if (groups.size() == 0) {
                    groupListAdapter7 = this.a.i;
                    groupListAdapter7.b(false);
                    this.a.n();
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
            iVar5 = this.a.c;
            iVar5.c(groups.size());
            iVar6 = this.a.c;
            iVar6.d(20);
            groupListAdapter3 = this.a.i;
            groupListAdapter3.a(groups);
            groupListAdapter4 = this.a.i;
            groupListAdapter4.notifyDataSetChanged();
        }
    }
}
