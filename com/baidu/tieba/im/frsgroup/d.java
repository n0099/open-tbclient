package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.frsgroup.GroupListAdapter;
import com.baidu.tieba.im.message.RequestFrsGroupsLocalMessage;
import com.baidu.tieba.im.message.ResponseFrsGroupsLocalMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
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
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.im.model.i iVar;
        List<GroupInfoData> groups;
        com.baidu.tieba.im.model.i iVar2;
        GroupListAdapter groupListAdapter;
        GroupListAdapter groupListAdapter2;
        GroupListAdapter groupListAdapter3;
        GroupListAdapter groupListAdapter4;
        com.baidu.tieba.im.model.i iVar3;
        this.a.a(true);
        if (customResponsedMessage == null || !(customResponsedMessage instanceof ResponseFrsGroupsLocalMessage)) {
            this.a.a(com.baidu.tieba.x.neterror);
            return;
        }
        ResponseFrsGroupsLocalMessage responseFrsGroupsLocalMessage = (ResponseFrsGroupsLocalMessage) customResponsedMessage;
        Message<?> orginalMessage = responseFrsGroupsLocalMessage.getOrginalMessage();
        if (orginalMessage != null && (orginalMessage instanceof RequestFrsGroupsLocalMessage)) {
            String type = ((RequestFrsGroupsLocalMessage) orginalMessage).getType();
            iVar3 = this.a.c;
            if (!type.equals(String.valueOf(iVar3.g()))) {
                return;
            }
        }
        iVar = this.a.c;
        if (!iVar.e() && (groups = responseFrsGroupsLocalMessage.getGroups()) != null && !groups.isEmpty()) {
            iVar2 = this.a.c;
            iVar2.a(true);
            groupListAdapter = this.a.i;
            groupListAdapter.b(true);
            groupListAdapter2 = this.a.i;
            groupListAdapter2.a(GroupListAdapter.BOTTOM_TYPE.LINE);
            groupListAdapter3 = this.a.i;
            groupListAdapter3.a(groups);
            groupListAdapter4 = this.a.i;
            groupListAdapter4.notifyDataSetChanged();
        }
    }
}
