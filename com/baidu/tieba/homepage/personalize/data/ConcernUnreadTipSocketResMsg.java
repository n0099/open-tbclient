package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mz6;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.UnreadTip.UnreadTipResIdl;
/* loaded from: classes3.dex */
public class ConcernUnreadTipSocketResMsg extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mz6 mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernUnreadTipSocketResMsg() {
        super(309541);
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
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
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
            mz6 mz6Var = new mz6();
            this.mData = mz6Var;
            mz6Var.b(unreadTipResIdl.data);
        }
    }
}
