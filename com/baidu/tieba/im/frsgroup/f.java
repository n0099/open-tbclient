package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.frsgroup.GroupListAdapter;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.RequestFrsGroupsMessage;
import com.baidu.tieba.im.message.ResponseFrsGroupsMessage;
import com.slidingmenu.lib.R;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tieba.im.messageCenter.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsGroupListFragment f1708a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsGroupListFragment frsGroupListFragment) {
        this.f1708a = frsGroupListFragment;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(Message message) {
        g gVar;
        com.baidu.tieba.im.model.b bVar;
        com.baidu.tieba.im.model.b bVar2;
        com.baidu.tieba.im.model.b bVar3;
        com.baidu.tieba.im.model.b bVar4;
        GroupListAdapter groupListAdapter;
        GroupListAdapter groupListAdapter2;
        com.baidu.tieba.im.model.b bVar5;
        com.baidu.tieba.im.model.b bVar6;
        GroupListAdapter groupListAdapter3;
        GroupListAdapter groupListAdapter4;
        com.baidu.tieba.im.model.b bVar7;
        GroupListAdapter groupListAdapter5;
        GroupListAdapter groupListAdapter6;
        GroupListAdapter groupListAdapter7;
        GroupListAdapter groupListAdapter8;
        com.baidu.tieba.im.model.b bVar8;
        List<GroupInfoData> groups;
        com.baidu.tieba.im.model.b bVar9;
        GroupListAdapter groupListAdapter9;
        GroupListAdapter groupListAdapter10;
        GroupListAdapter groupListAdapter11;
        GroupListAdapter groupListAdapter12;
        com.baidu.tieba.im.model.b bVar10;
        if (message == null || !(message instanceof ResponseFrsGroupsMessage)) {
            this.f1708a.b(R.string.neterror);
            return;
        }
        ResponseFrsGroupsMessage responseFrsGroupsMessage = (ResponseFrsGroupsMessage) message;
        Message orginalMessage = responseFrsGroupsMessage.getOrginalMessage();
        if (orginalMessage != null && (orginalMessage instanceof RequestFrsGroupsMessage)) {
            String type = ((RequestFrsGroupsMessage) orginalMessage).getType();
            bVar10 = this.f1708a.b;
            if (!type.equals(String.valueOf(bVar10.g()))) {
                return;
            }
        }
        if (responseFrsGroupsMessage.getCmd() == -201) {
            bVar8 = this.f1708a.b;
            if (!bVar8.e() && (groups = responseFrsGroupsMessage.getGroups()) != null && !groups.isEmpty()) {
                bVar9 = this.f1708a.b;
                bVar9.a(true);
                groupListAdapter9 = this.f1708a.h;
                groupListAdapter9.b(true);
                groupListAdapter10 = this.f1708a.h;
                groupListAdapter10.a(GroupListAdapter.BOTTOM_TYPE.LINE);
                groupListAdapter11 = this.f1708a.h;
                groupListAdapter11.a(groups);
                groupListAdapter12 = this.f1708a.h;
                groupListAdapter12.notifyDataSetChanged();
                this.f1708a.O();
            }
            this.f1708a.a(true);
            return;
        }
        this.f1708a.M();
        gVar = this.f1708a.c;
        gVar.b(true);
        bVar = this.f1708a.b;
        bVar.a(this.f1708a.g());
        if (responseFrsGroupsMessage.hasError()) {
            if (responseFrsGroupsMessage.getErrNo() > 0) {
                if (!TextUtils.isEmpty(responseFrsGroupsMessage.getErrMsg())) {
                    this.f1708a.a(responseFrsGroupsMessage.getErrMsg());
                    return;
                }
                return;
            }
            this.f1708a.b(R.string.neterror);
            return;
        }
        List<GroupInfoData> groups2 = responseFrsGroupsMessage.getGroups();
        GroupPermData groupPerm = responseFrsGroupsMessage.getGroupPerm();
        bVar2 = this.f1708a.b;
        bVar2.a(groupPerm);
        if (groups2 != null) {
            bVar3 = this.f1708a.b;
            if (bVar3.h()) {
                groupListAdapter8 = this.f1708a.h;
                groupListAdapter8.a(true);
                this.f1708a.e(true);
            }
            this.f1708a.Y = com.baidu.tieba.im.e.c.a();
            int size = groups2.size();
            bVar4 = this.f1708a.b;
            if (size != bVar4.l()) {
                bVar7 = this.f1708a.b;
                if (!bVar7.h()) {
                    groupListAdapter5 = this.f1708a.h;
                    groupListAdapter5.a(GroupListAdapter.BOTTOM_TYPE.NO_MORE);
                } else if (groups2.size() == 0) {
                    groupListAdapter7 = this.f1708a.h;
                    groupListAdapter7.b(false);
                    this.f1708a.P();
                    return;
                } else {
                    groupListAdapter6 = this.f1708a.h;
                    groupListAdapter6.a(GroupListAdapter.BOTTOM_TYPE.LINE);
                }
            } else {
                groupListAdapter = this.f1708a.h;
                groupListAdapter.a(GroupListAdapter.BOTTOM_TYPE.HAVE_MORE);
            }
            this.f1708a.N();
            groupListAdapter2 = this.f1708a.h;
            groupListAdapter2.b(true);
            bVar5 = this.f1708a.b;
            bVar5.c(groups2.size());
            bVar6 = this.f1708a.b;
            bVar6.d(20);
            groupListAdapter3 = this.f1708a.h;
            groupListAdapter3.a(groups2);
            groupListAdapter4 = this.f1708a.h;
            groupListAdapter4.notifyDataSetChanged();
            this.f1708a.O();
        }
    }
}
