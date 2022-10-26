package com.baidu.tieba.barselect.data;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.CommitCardInfo.CommitCardInfoResIdl;
/* loaded from: classes3.dex */
public class CommitCardInfoSocketResMsg extends TbSocketReponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommitCardInfoSocketResMsg() {
        super(309643);
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
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            CommitCardInfoResIdl commitCardInfoResIdl = (CommitCardInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, CommitCardInfoResIdl.class);
            if (commitCardInfoResIdl != null) {
                setError(commitCardInfoResIdl.error.errorno.intValue());
                setErrorString(commitCardInfoResIdl.error.usermsg);
            }
            return commitCardInfoResIdl;
        }
        return invokeIL.objValue;
    }
}
