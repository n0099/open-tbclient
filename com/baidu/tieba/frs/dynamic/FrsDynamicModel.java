package com.baidu.tieba.frs.dynamic;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetAutoModel;
import com.baidu.tieba.ik6;
import com.baidu.tieba.sb5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FrsDynamicModel<T> extends NetAutoModel<FrsDynamicRequestData, ik6, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsDynamicModel(TbPageContext<T> tbPageContext, FrsDynamicRequestData frsDynamicRequestData) {
        super(tbPageContext, frsDynamicRequestData);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, frsDynamicRequestData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (sb5) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? CmdConfigHttp.CMD_FRS_DYNAMIC : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<? extends MvcProtobufHttpResponsedMessage> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? FrsDynamicHttpResponseMessage.class : (Class) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public String P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TbConfig.FRS_DYNAMIC_ADDRESS : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 309602;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<? extends MvcSocketResponsedMessage> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? FrsDynamicSocketResponsedMessage.class : (Class) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<ik6> getResponseDataClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ik6.class : (Class) invokeV.objValue;
    }
}
