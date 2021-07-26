package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import d.a.q0.e1.h.j.i;
import java.util.List;
import tbclient.Error;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.PersonalizedResIdl;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class RecPersonalizeSocketResponse extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataRes resultData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecPersonalizeSocketResponse() {
        super(309264);
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

    public DataRes getResultData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.resultData : (DataRes) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        PersonalizedResIdl personalizedResIdl;
        DataRes dataRes;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (personalizedResIdl = (PersonalizedResIdl) new Wire(new Class[0]).parseFrom(bArr, PersonalizedResIdl.class)) == null) {
            return;
        }
        Error error = personalizedResIdl.error;
        if (error != null) {
            Integer num = error.errorno;
            if (num != null) {
                setError(num.intValue());
            }
            setErrorString(personalizedResIdl.error.usermsg);
        }
        i.f56179a = false;
        if (i.c(this) && (dataRes = personalizedResIdl.data) != null && (list = dataRes.thread_list) != null && list.size() == 0) {
            this.resultData = i.b();
            i.f56179a = true;
            i.a();
            return;
        }
        this.resultData = personalizedResIdl.data;
    }
}
