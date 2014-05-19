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
public class e extends CustomMessageListener {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(b bVar, int i) {
        super(i);
        this.a = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.im.model.k kVar;
        List<GroupInfoData> groups;
        com.baidu.tieba.im.model.k kVar2;
        GroupListAdapter groupListAdapter;
        GroupListAdapter groupListAdapter2;
        GroupListAdapter groupListAdapter3;
        GroupListAdapter groupListAdapter4;
        com.baidu.tieba.im.model.k kVar3;
        this.a.a(true);
        if (customResponsedMessage == null || !(customResponsedMessage instanceof ResponseFrsGroupsLocalMessage)) {
            this.a.a(com.baidu.tieba.u.neterror);
            return;
        }
        ResponseFrsGroupsLocalMessage responseFrsGroupsLocalMessage = (ResponseFrsGroupsLocalMessage) customResponsedMessage;
        Message<?> orginalMessage = responseFrsGroupsLocalMessage.getOrginalMessage();
        if (orginalMessage != null && (orginalMessage instanceof RequestFrsGroupsLocalMessage)) {
            String type = ((RequestFrsGroupsLocalMessage) orginalMessage).getType();
            kVar3 = this.a.c;
            if (!type.equals(String.valueOf(kVar3.g()))) {
                return;
            }
        }
        kVar = this.a.c;
        if (!kVar.e() && (groups = responseFrsGroupsLocalMessage.getGroups()) != null && !groups.isEmpty()) {
            kVar2 = this.a.c;
            kVar2.a(true);
            groupListAdapter = this.a.i;
            groupListAdapter.b(true);
            groupListAdapter2 = this.a.i;
            groupListAdapter2.a(GroupListAdapter.BOTTOM_TYPE.LINE);
            groupListAdapter3 = this.a.i;
            groupListAdapter3.a(groups);
            groupListAdapter4 = this.a.i;
            groupListAdapter4.notifyDataSetChanged();
            this.a.n();
        }
    }
}
