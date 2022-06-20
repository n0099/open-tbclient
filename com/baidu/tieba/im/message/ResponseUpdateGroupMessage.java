package com.baidu.tieba.im.message;

import androidx.annotation.Nullable;
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
/* loaded from: classes3.dex */
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

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            UpdateGroupResIdl updateGroupResIdl = (UpdateGroupResIdl) new Wire(new Class[0]).parseFrom(bArr, UpdateGroupResIdl.class);
            setError(updateGroupResIdl.error.errorno.intValue());
            setErrorString(updateGroupResIdl.error.usermsg);
            if (getError() != 0) {
                return updateGroupResIdl;
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
            return updateGroupResIdl;
        }
        return invokeIL.objValue;
    }

    public UpdateGroupInfoData getUpdateGroupInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.groupInfo : (UpdateGroupInfoData) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseUpdateGroupMessage(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
