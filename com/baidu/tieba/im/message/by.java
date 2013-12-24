package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.GroupPermData;
import java.util.LinkedList;
import protobuf.Im;
import protobuf.QueryUserPermission.QueryUserPermissionRes;
/* loaded from: classes.dex */
public class by extends bz implements com.baidu.tieba.im.coder.f {
    private GroupPermData a;

    public by() {
        super(103008);
    }

    public GroupPermData a() {
        return this.a;
    }

    public void a(GroupPermData groupPermData) {
        this.a = groupPermData;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<n> linkedList, byte[] bArr, int i) {
        QueryUserPermissionRes.QueryUserPermissionResIdl parseFrom = QueryUserPermissionRes.QueryUserPermissionResIdl.parseFrom(bArr);
        c(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!i()) {
            Im.GroupPermission groupPerm = parseFrom.getData().getGroupPerm();
            GroupPermData groupPermData = new GroupPermData();
            groupPermData.setCanCreateNormal(groupPerm.getCanCreateNormal());
            groupPermData.setCanCreateOfficial(groupPerm.getCanCreateOfficial());
            groupPermData.setCanCreatePersonal(groupPerm.getCanCreatePersonal());
            groupPermData.setCreateNormalTip(groupPerm.getCreateNormalTip());
            groupPermData.setCreateOfficialTip(groupPerm.getCreateOfficialTip());
            groupPermData.setCreatePersonalTip(groupPerm.getCreatePersonalTip());
            groupPermData.setIsManager(groupPerm.getIsForumManager());
            a(groupPermData);
        }
    }
}
