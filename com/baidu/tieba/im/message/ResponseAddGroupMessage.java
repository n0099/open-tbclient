package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.data.AddGroupInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import protobuf.AddGroup.AddGroupResIdl;
import protobuf.GroupInfo;
/* loaded from: classes4.dex */
public class ResponseAddGroupMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AddGroupInfoData groupInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseAddGroupMessage() {
        super(103101);
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

    public AddGroupInfoData getAddGroupInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.groupInfo;
        }
        return (AddGroupInfoData) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            AddGroupResIdl addGroupResIdl = (AddGroupResIdl) new Wire(new Class[0]).parseFrom(bArr, AddGroupResIdl.class);
            setError(addGroupResIdl.error.errorno.intValue());
            setErrorString(addGroupResIdl.error.usermsg);
            if (getError() != 0) {
                return addGroupResIdl;
            }
            AddGroupInfoData addGroupInfoData = new AddGroupInfoData();
            GroupInfo groupInfo = addGroupResIdl.data.group;
            addGroupInfoData.setGroupId(groupInfo.groupId.longValue());
            addGroupInfoData.setForumId(groupInfo.forumId.intValue());
            addGroupInfoData.setName(groupInfo.name);
            addGroupInfoData.setIntro(groupInfo.intro);
            addGroupInfoData.setPortrait(groupInfo.portrait);
            addGroupInfoData.setPosition(groupInfo.position);
            addGroupInfoData.setLng(String.valueOf(groupInfo.lng));
            addGroupInfoData.setLat(String.valueOf(groupInfo.lat));
            addGroupInfoData.setNotice(groupInfo.notice);
            addGroupInfoData.setAlbum(groupInfo.album);
            addGroupInfoData.setStatus(groupInfo.status.intValue());
            addGroupInfoData.setAuthorId(groupInfo.authorId.longValue());
            addGroupInfoData.setAuthorName(groupInfo.authorName);
            addGroupInfoData.setCreateTime(groupInfo.createTime.intValue());
            addGroupInfoData.setMaxMemberNum(groupInfo.maxMemberNum.intValue());
            addGroupInfoData.setMemberNum(groupInfo.memberNum.intValue());
            addGroupInfoData.setGroupType(groupInfo.groupType.intValue());
            this.groupInfo = addGroupInfoData;
            return addGroupResIdl;
        }
        return invokeIL.objValue;
    }
}
