package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.GroupPermData;
import com.squareup.wire.Wire;
import protobuf.GroupPermission;
import protobuf.QueryUserPermission.QueryUserPermissionResIdl;
/* loaded from: classes6.dex */
public class ResponseUserPermissionMessage extends SocketResponsedMessage {
    private GroupPermData groupPermData;

    public ResponseUserPermissionMessage() {
        super(103008);
    }

    public GroupPermData getGroupPermData() {
        return this.groupPermData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        QueryUserPermissionResIdl queryUserPermissionResIdl = (QueryUserPermissionResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryUserPermissionResIdl.class);
        setError(queryUserPermissionResIdl.error.errorno.intValue());
        setErrorString(queryUserPermissionResIdl.error.usermsg);
        if (getError() == 0) {
            GroupPermission groupPermission = queryUserPermissionResIdl.data.groupPerm;
            GroupPermData groupPermData = new GroupPermData();
            groupPermData.setCanCreateNormal(groupPermission.canCreateNormal.intValue());
            groupPermData.setCanCreateOfficial(groupPermission.canCreateOfficial.intValue());
            groupPermData.setCanCreatePersonal(groupPermission.canCreatePersonal.intValue());
            groupPermData.setCreateNormalTip(groupPermission.createNormalTip);
            groupPermData.setCreateOfficialTip(groupPermission.createOfficialTip);
            groupPermData.setCreatePersonalTip(groupPermission.createPersonalTip);
            groupPermData.setIsManager(groupPermission.isForumManager.intValue());
            groupPermData.setCanCreateNormalNum(groupPermission.canCreateNormalNum.intValue());
            groupPermData.setCanCreateOfficialNum(groupPermission.canCreateOfficialNum.intValue());
            groupPermData.setCanCreatePersonalNum(groupPermission.canCreatePersonalNum.intValue());
            this.groupPermData = groupPermData;
        }
    }
}
