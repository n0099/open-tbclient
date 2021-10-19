package com.baidu.tieba.gift.myGiftList;

import c.a.q0.d1.z;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetMyGift.DataReq;
import tbclient.GetMyGift.GetMyGiftReqIdl;
/* loaded from: classes7.dex */
public class GetPersonalGiftListRequest extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int pageNumber;
    public String type;
    public long userId;
    public int userType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetPersonalGiftListRequest() {
        super(CmdConfigHttp.CMD_GET_PERSONAL_GIFT_LIST, 309052);
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
            builder.pn = Integer.valueOf(this.pageNumber);
            builder.uid = Long.valueOf(this.userId);
            builder.st_type = this.type;
            builder.account_type = Integer.valueOf(this.userType);
            if (z) {
                z.a(builder, true);
            }
            GetMyGiftReqIdl.Builder builder2 = new GetMyGiftReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public int getPageNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.pageNumber : invokeV.intValue;
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.type : (String) invokeV.objValue;
    }

    public long getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.userId : invokeV.longValue;
    }

    public void setPageNumber(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.pageNumber = i2;
        }
    }

    public void setType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.type = str;
        }
    }

    public void setUserId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            this.userId = j2;
        }
    }
}
