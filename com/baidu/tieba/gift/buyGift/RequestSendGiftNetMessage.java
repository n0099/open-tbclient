package com.baidu.tieba.gift.buyGift;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SendGiftAndroid.DataReq;
import tbclient.SendGiftAndroid.SendGiftAndroidReqIdl;
@Deprecated
/* loaded from: classes10.dex */
public class RequestSendGiftNetMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FROM_PERSON_CENTER = 1;
    public static final int FROM_PERSON_CHAT = 2;
    public static final int FROM_PHOTO_LIVE = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public long mFrom;
    public int mGiftId;
    public int mNum;
    public String mPassword;
    public int mPrice;
    public long mReceiverId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestSendGiftNetMessage() {
        super(CmdConfigHttp.SEND_GIFT, 308007);
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
            builder.gift_from = Long.valueOf(this.mFrom);
            builder.gift_id = Integer.valueOf(this.mGiftId);
            builder.num = Integer.valueOf(this.mNum);
            builder.price = Integer.valueOf(this.mPrice);
            builder.receiver_id = Long.valueOf(this.mReceiverId);
            builder.password = this.mPassword;
            SendGiftAndroidReqIdl.Builder builder2 = new SendGiftAndroidReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public void setParams(long j2, int i2, int i3, int i4, long j3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j3), str}) == null) {
            this.mReceiverId = j2;
            this.mGiftId = i2;
            this.mPrice = i3;
            this.mNum = i4;
            this.mFrom = j3;
            this.mPassword = str;
        }
    }
}
