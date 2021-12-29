package com.baidu.tbadk.coreExtra.message;

import c.a.s0.f0.a;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import protobuf.ConfigVersion;
import protobuf.GroupInfo;
import protobuf.MaskInfo;
import protobuf.UpdateClientInfo.DataRes;
import protobuf.UpdateClientInfo.UpdateClientInfoResIdl;
import protobuf.UserInfo;
/* loaded from: classes11.dex */
public class ResponseOnlineMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConfigVersion configVersion;
    public List<GroupUpdateMessage> groupInfos;
    public boolean isUserAvailable;
    public MaskInfo maskInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseOnlineMessage() {
        super(1001);
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

    public ConfigVersion getConfigVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.configVersion : (ConfigVersion) invokeV.objValue;
    }

    public List<GroupUpdateMessage> getGroupInfos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.groupInfos : (List) invokeV.objValue;
    }

    public MaskInfo getMaskInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.maskInfo : (MaskInfo) invokeV.objValue;
    }

    public boolean isUserAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.isUserAvailable : invokeV.booleanValue;
    }

    public void setUserAvailable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.isUserAvailable = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            UpdateClientInfoResIdl updateClientInfoResIdl = (UpdateClientInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, UpdateClientInfoResIdl.class);
            setError(updateClientInfoResIdl.error.errorno.intValue());
            setErrorString(updateClientInfoResIdl.error.usermsg);
            if (getError() != 0) {
                a.b(1001, 0, 2, 0, 0);
                return;
            }
            a.b(1001, 0, 1, 0, 0);
            this.groupInfos = new ArrayList();
            DataRes dataRes = updateClientInfoResIdl.data;
            if (dataRes != null) {
                List<GroupInfo> list = dataRes.groupInfo;
                int size = list == null ? 0 : list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    GroupInfo groupInfo = updateClientInfoResIdl.data.groupInfo.get(i3);
                    GroupUpdateMessage groupUpdateMessage = new GroupUpdateMessage();
                    groupUpdateMessage.setGroupId(groupInfo.groupId.longValue());
                    groupUpdateMessage.setGroupType(groupInfo.groupType.intValue());
                    groupUpdateMessage.setLastMsgId(groupInfo.lastMsgId.longValue());
                    groupUpdateMessage.setName(groupInfo.name);
                    groupUpdateMessage.setNameShow(groupInfo.authorNameShow);
                    groupUpdateMessage.setPortrait(groupInfo.portrait);
                    groupUpdateMessage.setGrade(groupInfo.grade.intValue());
                    groupUpdateMessage.setAuthorId(String.valueOf(groupInfo.authorId));
                    groupUpdateMessage.setAuthorName(groupInfo.authorName);
                    groupUpdateMessage.setForumId(String.valueOf(groupInfo.forumId));
                    getGroupInfos().add(groupUpdateMessage);
                }
                UserInfo userInfo = updateClientInfoResIdl.data.userInfo;
                if (userInfo != null) {
                    SettingsSyncMessage settingsSyncMessage = new SettingsSyncMessage();
                    if (userInfo != null) {
                        settingsSyncMessage.setData(userInfo.portrait);
                    }
                }
                DataRes dataRes2 = updateClientInfoResIdl.data;
                this.maskInfo = dataRes2.maskInfo;
                this.configVersion = dataRes2.configVersion;
                this.isUserAvailable = dataRes2.isUserAvailable.longValue() != 0;
            }
        }
    }
}
