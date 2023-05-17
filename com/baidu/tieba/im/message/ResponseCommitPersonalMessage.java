package com.baidu.tieba.im.message;

import androidx.annotation.Nullable;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tieba.r58;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import protobuf.BlockInfo;
import protobuf.CommitPersonalMsg.CommitPersonalMsgResIdl;
import protobuf.CommitPersonalMsg.DataRes;
/* loaded from: classes6.dex */
public class ResponseCommitPersonalMessage extends ResponseCommitMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CANT_CHAT = 2230303;
    public transient /* synthetic */ FieldHolder $fh;
    public String toUserId;
    public int toUserType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseCommitPersonalMessage() {
        super(205001);
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
        this.toUserId = null;
        this.toUserType = 0;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            CommitPersonalMsgResIdl commitPersonalMsgResIdl = (CommitPersonalMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, CommitPersonalMsgResIdl.class);
            setError(commitPersonalMsgResIdl.error.errorno.intValue());
            setErrorString(commitPersonalMsgResIdl.error.usermsg);
            DataRes dataRes = commitPersonalMsgResIdl.data;
            if (dataRes == null) {
                BdStatisticsManager.getInstance().error("im", 0L, (String) null, "comment", "personalchat_resdatanull");
                return commitPersonalMsgResIdl;
            }
            long longValue = dataRes.msgId.longValue();
            setToUserType(commitPersonalMsgResIdl.data.toUserType.intValue());
            setMsgId(r58.a(longValue));
            setRecordId(commitPersonalMsgResIdl.data.recordId.longValue());
            setGroupId(String.valueOf(commitPersonalMsgResIdl.data.groupId));
            setToUserId(String.valueOf(commitPersonalMsgResIdl.data.toUid));
            BlockInfo blockInfo = commitPersonalMsgResIdl.data.blockInfo;
            if (blockInfo != null && !StringUtils.isNull(blockInfo.blockErrmsg)) {
                BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                BlockInfo blockInfo2 = commitPersonalMsgResIdl.data.blockInfo;
                blockPopInfoData.block_info = blockInfo2.blockErrmsg;
                blockPopInfoData.ahead_info = blockInfo2.blockConfirm;
                blockPopInfoData.ahead_url = blockInfo2.blockDealurl;
                blockPopInfoData.ok_info = blockInfo2.blockCancel;
                setBlockPopInfoData(blockPopInfoData);
            }
            return commitPersonalMsgResIdl;
        }
        return invokeIL.objValue;
    }

    public String getToUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.toUserId;
        }
        return (String) invokeV.objValue;
    }

    public int getToUserType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.toUserType;
        }
        return invokeV.intValue;
    }

    public void setToUserId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.toUserId = str;
        }
    }

    public void setToUserType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.toUserType = i;
        }
    }
}
