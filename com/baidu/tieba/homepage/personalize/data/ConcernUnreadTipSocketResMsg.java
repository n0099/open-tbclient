package com.baidu.tieba.homepage.personalize.data;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.k07;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.UnreadTip.UnreadTipResIdl;
/* loaded from: classes3.dex */
public class ConcernUnreadTipSocketResMsg extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k07 mData;

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

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            UnreadTipResIdl unreadTipResIdl = (UnreadTipResIdl) new Wire(new Class[0]).parseFrom(bArr, UnreadTipResIdl.class);
            if (unreadTipResIdl != null) {
                Error error = unreadTipResIdl.error;
                if (error != null) {
                    setError(error.errorno.intValue());
                    setErrorString(unreadTipResIdl.error.errmsg);
                }
                if (unreadTipResIdl.data != null) {
                    k07 k07Var = new k07();
                    this.mData = k07Var;
                    k07Var.b(unreadTipResIdl.data);
                }
            }
            return unreadTipResIdl;
        }
        return invokeIL.objValue;
    }
}
