package com.baidu.tieba.im.message;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class ResponseCommitMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String groupId;
    public BlockPopInfoData mBlockPopInfoData;
    public long msgId;
    public long recordId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseCommitMessage(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public abstract /* synthetic */ void decodeInBackGround(int i2, T t) throws Exception;

    public BlockPopInfoData getBlockPopInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBlockPopInfoData : (BlockPopInfoData) invokeV.objValue;
    }

    public String getGroupId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.groupId : (String) invokeV.objValue;
    }

    public long getMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.msgId : invokeV.longValue;
    }

    public long getRecordId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.recordId : invokeV.longValue;
    }

    public void setBlockPopInfoData(BlockPopInfoData blockPopInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, blockPopInfoData) == null) {
            this.mBlockPopInfoData = blockPopInfoData;
        }
    }

    public void setGroupId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.groupId = str;
        }
    }

    public void setMsgId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.msgId = j;
        }
    }

    public void setRecordId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.recordId = j;
        }
    }
}
