package com.baidu.tieba.gift.send;

import androidx.core.view.InputDeviceCompat;
import c.a.t0.d1.c0;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SendFreeGift.DataReq;
import tbclient.SendFreeGift.SendFreeGiftReqIdl;
/* loaded from: classes12.dex */
public class SendFreeGiftRequest extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int giftId;
    public long postId;
    public String sceneFrom;
    public int sendCount;
    public long threadId;
    public long toUserId;
    public String toUserName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendFreeGiftRequest() {
        super(CmdConfigHttp.CMD_SEND_FREE_GIFT, 309050);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.gift_id = Integer.valueOf(this.giftId);
            builder.benefit_userid = Long.valueOf(this.toUserId);
            builder.benefit_username = this.toUserName;
            builder.scene_from = this.sceneFrom;
            builder.thread_id = Long.valueOf(this.threadId);
            builder.post_id = Long.valueOf(this.postId);
            builder.num = Integer.valueOf(this.sendCount);
            if (z || SocketAddCommonParamSwitch.getIsOn()) {
                c0.a(builder, true);
            }
            SendFreeGiftReqIdl.Builder builder2 = new SendFreeGiftReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public int getGiftId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.giftId : invokeV.intValue;
    }

    public long getPostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.postId : invokeV.longValue;
    }

    public String getSceneFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.sceneFrom : (String) invokeV.objValue;
    }

    public int getSendCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.sendCount : invokeV.intValue;
    }

    public long getThreadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.threadId : invokeV.longValue;
    }

    public long getToUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.toUserId : invokeV.longValue;
    }

    public String getToUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.toUserName : (String) invokeV.objValue;
    }

    public void setGiftId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.giftId = i2;
        }
    }

    public void setPostId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) {
            this.postId = j2;
        }
    }

    public void setSceneFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.sceneFrom = str;
        }
    }

    public void setSendCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.sendCount = i2;
        }
    }

    public void setThreadId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j2) == null) {
            this.threadId = j2;
        }
    }

    public void setToUserId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) {
            this.toUserId = j2;
        }
    }

    public void setToUserName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.toUserName = str;
        }
    }
}
