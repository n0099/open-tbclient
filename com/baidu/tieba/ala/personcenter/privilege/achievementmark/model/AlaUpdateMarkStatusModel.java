package com.baidu.tieba.ala.personcenter.privilege.achievementmark.model;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.message.AlaUpdateMarkStatusResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class AlaUpdateMarkStatusModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public Context b;
    public b c;
    public HttpMessageListener d;

    /* loaded from: classes5.dex */
    public interface b {
        void onResult(boolean z, String str);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaUpdateMarkStatusModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaUpdateMarkStatusModel alaUpdateMarkStatusModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaUpdateMarkStatusModel, Integer.valueOf(i)};
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
            this.a = alaUpdateMarkStatusModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || !(httpResponsedMessage instanceof AlaUpdateMarkStatusResponsedMessage) || httpResponsedMessage.getOrginalMessage() == null || this.a.a != httpResponsedMessage.getOrginalMessage().getTag() || this.a.c == null) {
                return;
            }
            if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError()) {
                this.a.c.onResult(true, httpResponsedMessage.getErrorString());
            } else {
                this.a.c.onResult(false, httpResponsedMessage.getErrorString());
            }
        }
    }

    public AlaUpdateMarkStatusModel(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new a(this, AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        this.b = context;
        P();
        O();
        this.a = BdUniqueId.gen();
    }

    public void Q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.c = bVar;
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().registerListener(this.d);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
            MessageManager.getInstance().unRegisterListener(this.d);
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_UPDATE_MARK_STATUS);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setResponsedClass(AlaUpdateMarkStatusResponsedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void R(boolean z, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
            if (z) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            httpMessage.addParam("action", i2);
            httpMessage.addParam("mark_id", i);
            httpMessage.setTag(this.a);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
