package com.baidu.tieba.frs.mc;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetAutoModel;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dh8;
import com.repackage.u75;
/* loaded from: classes3.dex */
public class FrsNetModel<T> extends NetAutoModel<FrsRequestData, dh8, T> implements NetModel.k<FrsRequestData, dh8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean n;
    public ResponsedMessage o;
    public Message p;
    public MvcNetMessage q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsNetModel(TbPageContext<T> tbPageContext, FrsRequestData frsRequestData) {
        super(tbPageContext, frsRequestData);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, frsRequestData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (u75) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? CmdConfigHttp.FRS_HTTP_CMD : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<? extends MvcProtobufHttpResponsedMessage> P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? FrsPageHttpResponseMessage.class : (Class) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TbConfig.FRS_ADDRESS : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 301001;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<? extends MvcSocketResponsedMessage> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? FRSPageSocketResponsedMessage.class : (Class) invokeV.objValue;
    }

    public Message d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.p : (Message) invokeV.objValue;
    }

    public MvcNetMessage e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.q : (MvcNetMessage) invokeV.objValue;
    }

    public FrsRequestData f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (FrsRequestData) this.c : (FrsRequestData) invokeV.objValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.n : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<dh8> getResponseDataClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? dh8.class : (Class) invokeV.objValue;
    }

    public ResponsedMessage getResponsedMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.o : (ResponsedMessage) invokeV.objValue;
    }

    public void h0(FrsRequestData frsRequestData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, frsRequestData) == null) {
            this.c = frsRequestData;
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public boolean isNeedCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? super.isNeedCache() : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel, com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            boolean loadData = super.loadData();
            this.n = loadData;
            return loadData;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void o(MvcSocketResponsedMessage<dh8, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, dh8> mvcSocketMessage, MvcNetMessage<FrsRequestData, dh8> mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            this.o = mvcSocketResponsedMessage;
            this.p = mvcSocketMessage;
            this.q = mvcNetMessage;
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void t(MvcHttpResponsedMessage<dh8> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, dh8> mvcHttpMessage, MvcNetMessage<FrsRequestData, dh8> mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            this.o = mvcHttpResponsedMessage;
            this.p = mvcHttpMessage;
            this.q = mvcNetMessage;
        }
    }
}
