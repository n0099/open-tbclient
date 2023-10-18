package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.w18;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Error;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.PersonalizedResIdl;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class RecPersonalizeHttpResponse extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataRes resultData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecPersonalizeHttpResponse(int i) {
        super(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        PersonalizedResIdl personalizedResIdl;
        DataRes dataRes;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) != null) || (personalizedResIdl = (PersonalizedResIdl) new Wire(new Class[0]).parseFrom(bArr, PersonalizedResIdl.class)) == null) {
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
        w18.a = false;
        if (w18.c(this) && (dataRes = personalizedResIdl.data) != null && (list = dataRes.thread_list) != null && list.size() == 0) {
            this.resultData = w18.b();
            w18.a = true;
            w18.a();
            return;
        }
        this.resultData = personalizedResIdl.data;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public DataRes getResultData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.resultData;
        }
        return (DataRes) invokeV.objValue;
    }
}
