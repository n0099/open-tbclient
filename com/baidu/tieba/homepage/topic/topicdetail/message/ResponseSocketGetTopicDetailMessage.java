package com.baidu.tieba.homepage.topic.topicdetail.message;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.z27;
import com.squareup.wire.Wire;
import tbclient.NewHottopic.NewHottopicResIdl;
/* loaded from: classes3.dex */
public class ResponseSocketGetTopicDetailMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z27 mTopicDetailData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseSocketGetTopicDetailMessage() {
        super(309629);
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
            NewHottopicResIdl newHottopicResIdl = (NewHottopicResIdl) new Wire(new Class[0]).parseFrom(bArr, NewHottopicResIdl.class);
            if (newHottopicResIdl == null) {
                return null;
            }
            setError(newHottopicResIdl.error.errorno.intValue());
            setErrorString(newHottopicResIdl.error.usermsg);
            if (getError() == 0 && newHottopicResIdl.data != null) {
                z27 z27Var = new z27();
                this.mTopicDetailData = z27Var;
                z27Var.b(newHottopicResIdl.data);
            }
            return newHottopicResIdl;
        }
        return invokeIL.objValue;
    }

    public z27 getTopicDetailData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mTopicDetailData : (z27) invokeV.objValue;
    }
}
