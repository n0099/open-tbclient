package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.o27;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.UnreadTip.UnreadTipResIdl;
/* loaded from: classes4.dex */
public class ConcernUnreadTipHttpResMsg extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public o27 mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernUnreadTipHttpResMsg() {
        super(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP);
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
        UnreadTipResIdl unreadTipResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (unreadTipResIdl = (UnreadTipResIdl) new Wire(new Class[0]).parseFrom(bArr, UnreadTipResIdl.class)) == null) {
            return;
        }
        Error error = unreadTipResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(unreadTipResIdl.error.errmsg);
        }
        if (unreadTipResIdl.data != null) {
            o27 o27Var = new o27();
            this.mData = o27Var;
            o27Var.b(unreadTipResIdl.data);
        }
    }
}
