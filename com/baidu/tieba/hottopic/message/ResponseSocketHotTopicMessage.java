package com.baidu.tieba.hottopic.message;

import c.a.r0.p1.l.e;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Hottopic.HottopicResIdl;
/* loaded from: classes10.dex */
public class ResponseSocketHotTopicMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e topicData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseSocketHotTopicMessage() {
        super(303050);
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
        this.topicData = null;
    }

    public e getHotTopicData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.topicData : (e) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            super.afterDispatchInBackGround(i2, (int) bArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        HottopicResIdl hottopicResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, bArr) == null) || (hottopicResIdl = (HottopicResIdl) new Wire(new Class[0]).parseFrom(bArr, HottopicResIdl.class)) == null) {
            return;
        }
        setError(hottopicResIdl.error.errorno.intValue());
        setErrorString(hottopicResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        Object extra = getOrginalMessage().getExtra();
        Integer num = extra instanceof Integer ? (Integer) extra : null;
        e eVar = new e();
        this.topicData = eVar;
        if (num != null) {
            eVar.s = num.intValue();
        }
        this.topicData.o(hottopicResIdl.data);
    }
}
