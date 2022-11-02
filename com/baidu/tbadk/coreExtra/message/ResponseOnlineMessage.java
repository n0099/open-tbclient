package com.baidu.tbadk.coreExtra.message;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.v95;
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
/* loaded from: classes3.dex */
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

    public ConfigVersion getConfigVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.configVersion;
        }
        return (ConfigVersion) invokeV.objValue;
    }

    public List<GroupUpdateMessage> getGroupInfos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.groupInfos;
        }
        return (List) invokeV.objValue;
    }

    public MaskInfo getMaskInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.maskInfo;
        }
        return (MaskInfo) invokeV.objValue;
    }

    public boolean isUserAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.isUserAvailable;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            boolean z = false;
            UpdateClientInfoResIdl updateClientInfoResIdl = (UpdateClientInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, UpdateClientInfoResIdl.class);
            setError(updateClientInfoResIdl.error.errorno.intValue());
            setErrorString(updateClientInfoResIdl.error.usermsg);
            if (getError() != 0) {
                v95.b(1001, 0, 2, 0, 0);
                return updateClientInfoResIdl;
            }
            v95.b(1001, 0, 1, 0, 0);
            this.groupInfos = new ArrayList();
            DataRes dataRes = updateClientInfoResIdl.data;
            if (dataRes != null) {
                List<GroupInfo> list = dataRes.groupInfo;
                if (list == null) {
                    size = 0;
                } else {
                    size = list.size();
                }
                for (int i2 = 0; i2 < size; i2++) {
                    GroupInfo groupInfo = updateClientInfoResIdl.data.groupInfo.get(i2);
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
                if (dataRes2.isUserAvailable.longValue() != 0) {
                    z = true;
                }
                this.isUserAvailable = z;
            }
            return updateClientInfoResIdl;
        }
        return invokeIL.objValue;
    }

    public void setUserAvailable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.isUserAvailable = z;
        }
    }
}
