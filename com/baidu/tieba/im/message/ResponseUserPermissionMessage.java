package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import protobuf.GroupPermission;
import protobuf.QueryUserPermission.QueryUserPermissionResIdl;
/* loaded from: classes4.dex */
public class ResponseUserPermissionMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GroupPermData groupPermData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseUserPermissionMessage() {
        super(103008);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public GroupPermData getGroupPermData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.groupPermData;
        }
        return (GroupPermData) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            QueryUserPermissionResIdl queryUserPermissionResIdl = (QueryUserPermissionResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryUserPermissionResIdl.class);
            setError(queryUserPermissionResIdl.error.errorno.intValue());
            setErrorString(queryUserPermissionResIdl.error.usermsg);
            if (getError() != 0) {
                return queryUserPermissionResIdl;
            }
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
            return queryUserPermissionResIdl;
        }
        return invokeIL.objValue;
    }
}
