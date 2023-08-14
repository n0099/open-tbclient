package com.baidu.tieba.hottopic.message;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.v88;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Hottopic.HottopicResIdl;
/* loaded from: classes6.dex */
public class ResponseSocketHotTopicMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v88 topicData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseSocketHotTopicMessage() {
        super(303050);
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
        this.topicData = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            super.afterDispatchInBackGround(i, (int) bArr);
        }
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bArr)) == null) {
            HottopicResIdl hottopicResIdl = (HottopicResIdl) new Wire(new Class[0]).parseFrom(bArr, HottopicResIdl.class);
            if (hottopicResIdl != null) {
                setError(hottopicResIdl.error.errorno.intValue());
                setErrorString(hottopicResIdl.error.usermsg);
                if (getError() != 0) {
                    return hottopicResIdl;
                }
                Integer num = null;
                Object extra = getOrginalMessage().getExtra();
                if (extra instanceof Integer) {
                    num = (Integer) extra;
                }
                v88 v88Var = new v88();
                this.topicData = v88Var;
                if (num != null) {
                    v88Var.p = num.intValue();
                }
                this.topicData.h(hottopicResIdl.data);
            }
            return hottopicResIdl;
        }
        return invokeIL.objValue;
    }

    public v88 getHotTopicData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.topicData;
        }
        return (v88) invokeV.objValue;
    }
}
