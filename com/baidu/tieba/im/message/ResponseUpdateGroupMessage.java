package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.data.UpdateGroupInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import protobuf.GroupInfo;
import protobuf.UpdateGroup.UpdateGroupResIdl;
/* loaded from: classes5.dex */
public class ResponseUpdateGroupMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public UpdateGroupInfoData groupInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseUpdateGroupMessage() {
        super(103102);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public UpdateGroupInfoData getUpdateGroupInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.groupInfo : (UpdateGroupInfoData) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseUpdateGroupMessage(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            UpdateGroupResIdl updateGroupResIdl = (UpdateGroupResIdl) new Wire(new Class[0]).parseFrom(bArr, UpdateGroupResIdl.class);
            setError(updateGroupResIdl.error.errorno.intValue());
            setErrorString(updateGroupResIdl.error.usermsg);
            if (getError() != 0) {
                return;
            }
            UpdateGroupInfoData updateGroupInfoData = new UpdateGroupInfoData();
            GroupInfo groupInfo = updateGroupResIdl.data.group;
            if (groupInfo != null) {
                updateGroupInfoData.setGroupId(groupInfo.groupId.longValue());
                updateGroupInfoData.setForumId(groupInfo.forumId.intValue());
                updateGroupInfoData.setName(groupInfo.name);
                updateGroupInfoData.setIntro(groupInfo.intro);
                updateGroupInfoData.setPortrait(groupInfo.portrait);
                updateGroupInfoData.setPosition(groupInfo.position);
                updateGroupInfoData.setLng(String.valueOf(groupInfo.lng));
                updateGroupInfoData.setLat(String.valueOf(groupInfo.lat));
                updateGroupInfoData.setNotice(groupInfo.notice);
                updateGroupInfoData.setAlbum(groupInfo.album);
                updateGroupInfoData.setStatus(groupInfo.status.intValue());
                updateGroupInfoData.setAuthorId(groupInfo.authorId.longValue());
                updateGroupInfoData.setAuthorName(groupInfo.authorName);
                updateGroupInfoData.setAuthorNameShow(groupInfo.authorNameShow);
                updateGroupInfoData.setCreateTime(groupInfo.createTime.intValue());
                updateGroupInfoData.setMaxMemberNum(groupInfo.maxMemberNum.intValue());
                updateGroupInfoData.setMemberNum(groupInfo.memberNum.intValue());
                updateGroupInfoData.setGroupType(groupInfo.groupType.intValue());
                updateGroupInfoData.setFlag(groupInfo.flag.intValue());
                this.groupInfo = updateGroupInfoData;
            }
        }
    }
}
