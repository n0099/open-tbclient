package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.GroupPermData;
import java.util.LinkedList;
import protobuf.Im;
import protobuf.QueryUserPermission.QueryUserPermissionRes;
/* loaded from: classes.dex */
public class cz extends da implements com.baidu.tieba.im.coder.f {
    private GroupPermData a;

    public cz() {
        super(103008);
    }

    public final GroupPermData a() {
        return this.a;
    }

    @Override // com.baidu.tieba.im.coder.f
    public final void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        QueryUserPermissionRes.QueryUserPermissionResIdl parseFrom = QueryUserPermissionRes.QueryUserPermissionResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!l()) {
            Im.GroupPermission groupPerm = parseFrom.getData().getGroupPerm();
            GroupPermData groupPermData = new GroupPermData();
            groupPermData.setCanCreateNormal(groupPerm.getCanCreateNormal());
            groupPermData.setCanCreateOfficial(groupPerm.getCanCreateOfficial());
            groupPermData.setCanCreatePersonal(groupPerm.getCanCreatePersonal());
            groupPermData.setCreateNormalTip(groupPerm.getCreateNormalTip());
            groupPermData.setCreateOfficialTip(groupPerm.getCreateOfficialTip());
            groupPermData.setCreatePersonalTip(groupPerm.getCreatePersonalTip());
            groupPermData.setIsManager(groupPerm.getIsForumManager());
            groupPermData.setCanCreateNormalNum(groupPerm.getCanCreateNormalNum());
            groupPermData.setCanCreateOfficialNum(groupPerm.getCanCreateOfficialNum());
            groupPermData.setCanCreatePersonalNum(groupPerm.getCanCreatePersonalNum());
            this.a = groupPermData;
        }
    }
}
