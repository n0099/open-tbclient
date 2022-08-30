package com.baidu.tieba.homepage.gamevideo.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.RecomVertical.DataRes;
import tbclient.RecomVertical.RecomVerticalResIdl;
/* loaded from: classes4.dex */
public class GameVideoHttpResMessage extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataRes mResultData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameVideoHttpResMessage() {
        super(CmdConfigHttp.CMD_GAME_VIDEO);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        RecomVerticalResIdl recomVerticalResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (recomVerticalResIdl = (RecomVerticalResIdl) new Wire(new Class[0]).parseFrom(bArr, RecomVerticalResIdl.class)) == null) {
            return;
        }
        Error error = recomVerticalResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(recomVerticalResIdl.error.errmsg);
        }
        this.mResultData = recomVerticalResIdl.data;
    }
}
