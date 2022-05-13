package com.baidu.tieba.frs.dynamic;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.eg6;
import tbclient.Error;
import tbclient.StarTrends.StarTrendsResIdl;
/* loaded from: classes3.dex */
public class FrsDynamicSocketResponsedMessage extends MvcSocketResponsedMessage<eg6, StarTrendsResIdl> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public eg6 responseData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsDynamicSocketResponsedMessage() {
        super(309602);
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

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    public Class<StarTrendsResIdl> getProtobufResponseIdlClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? StarTrendsResIdl.class : (Class) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage, com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Error error;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            eg6 eg6Var = new eg6();
            this.responseData = eg6Var;
            StarTrendsResIdl a = eg6Var.a(bArr);
            if (a != null && (error = a.error) != null) {
                Integer num = error.errorno;
                if (num != null) {
                    setError(num.intValue());
                    this.responseData.d = a.error.errorno.intValue();
                }
                setErrorString(a.error.usermsg);
            }
            setData(this.responseData);
        }
    }
}
