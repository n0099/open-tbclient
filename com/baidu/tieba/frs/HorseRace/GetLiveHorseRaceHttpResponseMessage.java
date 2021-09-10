package com.baidu.tieba.frs.HorseRace;

import c.a.r0.w0.k0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetHorseRaceLampList.GetHorseRaceLampListResIdl;
/* loaded from: classes7.dex */
public class GetLiveHorseRaceHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetLiveHorseRaceHttpResponseMessage() {
        super(CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST);
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
        this.mData = new a();
    }

    public a getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mData : (a) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetHorseRaceLampListResIdl getHorseRaceLampListResIdl;
        Error error;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            super.decodeInBackGround(i2, bArr);
            if (bArr == null || (error = (getHorseRaceLampListResIdl = (GetHorseRaceLampListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetHorseRaceLampListResIdl.class)).error) == null) {
                return;
            }
            setError(error.errorno.intValue());
            setErrorString(getHorseRaceLampListResIdl.error.usermsg);
            if (getError() != 0) {
                return;
            }
            this.mData.b(getHorseRaceLampListResIdl.data);
        }
    }
}
