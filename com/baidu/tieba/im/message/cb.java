package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.GroupPermData;
import java.util.LinkedList;
import protobuf.Im;
import protobuf.QueryUserPermission.QueryUserPermissionRes;
/* loaded from: classes.dex */
public class cb extends cc implements com.baidu.tieba.im.coder.f {
    private GroupPermData a;

    public cb() {
        super(103008);
    }

    public GroupPermData a() {
        return this.a;
    }

    public void a(GroupPermData groupPermData) {
        this.a = groupPermData;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<o> linkedList, byte[] bArr, int i) {
        QueryUserPermissionRes.QueryUserPermissionResIdl parseFrom = QueryUserPermissionRes.QueryUserPermissionResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
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
            groupPermData.setCanCreateNormalNum(groupPerm.getCanCreateNormalNum());
            groupPermData.setCanCreateOfficialNum(groupPerm.getCanCreateOfficialNum());
            groupPermData.setCanCreatePersonalNum(groupPerm.getCanCreatePersonalNum());
            a(groupPermData);
        }
    }
}
