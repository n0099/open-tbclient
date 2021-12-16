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
/* loaded from: classes12.dex */
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

    public AddGroupInfoData getAddGroupInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.groupInfo : (AddGroupInfoData) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            AddGroupResIdl addGroupResIdl = (AddGroupResIdl) new Wire(new Class[0]).parseFrom(bArr, AddGroupResIdl.class);
            setError(addGroupResIdl.error.errorno.intValue());
            setErrorString(addGroupResIdl.error.usermsg);
            if (getError() != 0) {
                return;
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
            addGroupInfoData.setAuthorNameShow(groupInfo.authorNameShow);
            addGroupInfoData.setCreateTime(groupInfo.createTime.intValue());
            addGroupInfoData.setMaxMemberNum(groupInfo.maxMemberNum.intValue());
            addGroupInfoData.setMemberNum(groupInfo.memberNum.intValue());
            addGroupInfoData.setGroupType(groupInfo.groupType.intValue());
            this.groupInfo = addGroupInfoData;
        }
    }
}
