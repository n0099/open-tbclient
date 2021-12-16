package com.baidu.tieba.im.message;

import c.a.s0.s1.w.b;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import protobuf.BlockInfo;
import protobuf.CommitPersonalMsg.CommitPersonalMsgResIdl;
import protobuf.CommitPersonalMsg.DataRes;
/* loaded from: classes12.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.toUserId = null;
        this.toUserType = 0;
    }

    public String getToUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.toUserId : (String) invokeV.objValue;
    }

    public int getToUserType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.toUserType : invokeV.intValue;
    }

    public void setToUserId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.toUserId = str;
        }
    }

    public void setToUserType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.toUserType = i2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.message.ResponseCommitMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            CommitPersonalMsgResIdl commitPersonalMsgResIdl = (CommitPersonalMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, CommitPersonalMsgResIdl.class);
            setError(commitPersonalMsgResIdl.error.errorno.intValue());
            setErrorString(commitPersonalMsgResIdl.error.usermsg);
            DataRes dataRes = commitPersonalMsgResIdl.data;
            if (dataRes == null) {
                BdStatisticsManager.getInstance().error("im", 0L, (String) null, "comment", "personalchat_resdatanull");
                return;
            }
            long longValue = dataRes.msgId.longValue();
            setToUserType(commitPersonalMsgResIdl.data.toUserType.intValue());
            setMsgId(b.a(longValue));
            setRecordId(commitPersonalMsgResIdl.data.recordId.longValue());
            setGroupId(String.valueOf(commitPersonalMsgResIdl.data.groupId));
            setToUserId(String.valueOf(commitPersonalMsgResIdl.data.toUid));
            BlockInfo blockInfo = commitPersonalMsgResIdl.data.blockInfo;
            if (blockInfo == null || StringUtils.isNull(blockInfo.blockErrmsg)) {
                return;
            }
            BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
            BlockInfo blockInfo2 = commitPersonalMsgResIdl.data.blockInfo;
            blockPopInfoData.block_info = blockInfo2.blockErrmsg;
            blockPopInfoData.ahead_info = blockInfo2.blockConfirm;
            blockPopInfoData.ahead_url = blockInfo2.blockDealurl;
            blockPopInfoData.ok_info = blockInfo2.blockCancel;
            setBlockPopInfoData(blockPopInfoData);
        }
    }
}
