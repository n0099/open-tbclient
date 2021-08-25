package com.baidu.tieba.ala.personcenter.model;

import c.a.e.a.f;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.personcenter.messages.AlaPersonCenterResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class AlaPersonCenterModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.v.j.f.a f49565e;

    /* renamed from: f  reason: collision with root package name */
    public String f49566f;

    /* renamed from: g  reason: collision with root package name */
    public final HttpMessageListener f49567g;

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaPersonCenterModel f49568a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaPersonCenterModel alaPersonCenterModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaPersonCenterModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49568a = alaPersonCenterModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1021001 || this.f49568a.f49565e == null) {
                return;
            }
            int statusCode = httpResponsedMessage.getStatusCode();
            if (statusCode != 200 || !(httpResponsedMessage instanceof AlaPersonCenterResponseMessage)) {
                this.f49568a.f49565e.b(statusCode, null, null);
                return;
            }
            AlaPersonCenterResponseMessage alaPersonCenterResponseMessage = (AlaPersonCenterResponseMessage) httpResponsedMessage;
            if (alaPersonCenterResponseMessage.getError() == 0) {
                this.f49568a.f49565e.c(alaPersonCenterResponseMessage.getPersonCenterData(), 1);
            } else {
                this.f49568a.f49565e.b(alaPersonCenterResponseMessage.getError(), alaPersonCenterResponseMessage.getErrMsg(), null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaPersonCenterModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f49567g = new a(this, AlaCmdConfigHttp.CMD_ALA_USER_CENTER);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_USER_CENTER, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_USER_CENTER_URL);
        tbHttpMessageTask.setResponsedClass(AlaPersonCenterResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.f49567g.setSelfListener(true);
        this.f49567g.setTag(getUniqueId());
        registerListener(this.f49567g);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_USER_CENTER);
            httpMessage.addParam("user_id", this.f49566f);
            sendMessage(httpMessage);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            cancelMessage();
            MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_USER_CENTER);
            MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_PERSON_GET_LIVES);
        }
    }

    public void setUid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f49566f = str;
        }
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? LoadData() : invokeV.booleanValue;
    }

    public void y(c.a.q0.v.j.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.f49565e = aVar;
        }
    }
}
