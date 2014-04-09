package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.GroupPermData;
import protobuf.Im;
import protobuf.QueryUserPermission.QueryUserPermissionRes;
/* loaded from: classes.dex */
public class ResponseUserPermissionMessage extends SocketResponsedMessage {
    private GroupPermData a;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        QueryUserPermissionRes.QueryUserPermissionResIdl parseFrom = QueryUserPermissionRes.QueryUserPermissionResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        d(parseFrom.getError().getUsermsg());
        if (e() == 0) {
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

    public ResponseUserPermissionMessage() {
        super(103008);
    }

    public final GroupPermData d() {
        return this.a;
    }
}
