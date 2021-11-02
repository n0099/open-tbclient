package com.baidu.tieba.godSquare.model.res;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetHotGod.DataRes;
import tbclient.GetHotGod.GetHotGodResIdl;
/* loaded from: classes9.dex */
public class GodSquareCacheResponsedMsg extends CustomResponsedMessage<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataRes mResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GodSquareCacheResponsedMsg() {
        super(2016446);
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

    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, bArr) == null) {
            GetHotGodResIdl getHotGodResIdl = (GetHotGodResIdl) new Wire(new Class[0]).parseFrom(bArr, GetHotGodResIdl.class);
            Error error = getHotGodResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getHotGodResIdl.error.usermsg);
            }
            if (getError() == 0 && (dataRes = getHotGodResIdl.data) != null) {
                this.mResult = dataRes;
            }
        }
    }

    public DataRes getResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mResult : (DataRes) invokeV.objValue;
    }
}
