package com.baidu.tieba.faceshop.emotioncenter.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d37;
import com.baidu.tieba.faceshop.emotioncenter.message.EmotionCenterResponseMessage;
import com.baidu.tieba.l9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class EmotionCenterModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final HttpMessageListener b;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionCenterModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(EmotionCenterModel emotionCenterModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionCenterModel, Integer.valueOf(i)};
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
            this.a = emotionCenterModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            EmotionCenterResponseMessage emotionCenterResponseMessage;
            Object extra;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003354 && (httpResponsedMessage instanceof EmotionCenterResponseMessage)) {
                d37 d37Var = null;
                if (httpResponsedMessage.getOrginalMessage() != null && (extra = httpResponsedMessage.getOrginalMessage().getExtra()) != null && (extra instanceof d37)) {
                    d37Var = (d37) extra;
                }
                if (d37Var != null && (emotionCenterResponseMessage = (EmotionCenterResponseMessage) httpResponsedMessage) != null) {
                    if (this.a.a == 1) {
                        d37Var.h1(emotionCenterResponseMessage.data);
                    } else {
                        d37Var.F0(emotionCenterResponseMessage.data);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionCenterModel(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((l9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 1;
        this.b = new a(this, CmdConfigHttp.CMD_GET_EMOTION_EMOTION_SHOP);
        registerTask();
        this.b.setTag(getUniqueId());
        this.b.setSelfListener(true);
        registerListener(this.b);
    }

    public void V(d37 d37Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, d37Var) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_EMOTION_EMOTION_SHOP);
            int i = this.a + 1;
            this.a = i;
            httpMessage.addParam("pn", i);
            httpMessage.addParam("rn", 10);
            httpMessage.setExtra(d37Var);
            sendMessage(httpMessage);
        }
    }

    public void W(d37 d37Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d37Var) == null) {
            this.a = 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_EMOTION_EMOTION_SHOP);
            httpMessage.addParam("pn", 1);
            httpMessage.addParam("rn", 10);
            httpMessage.setExtra(d37Var);
            sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_EMOTION_EMOTION_SHOP);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_EMOTION_EMOTION_SHOP, TbConfig.SERVER_ADDRESS + "c/e/meme/shop");
            tbHttpMessageTask.setResponsedClass(EmotionCenterResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }
}
