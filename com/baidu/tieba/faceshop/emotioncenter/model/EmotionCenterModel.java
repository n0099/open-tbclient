package com.baidu.tieba.faceshop.emotioncenter.model;

import c.a.e.a.f;
import c.a.r0.r0.x.d.b;
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
import com.baidu.tieba.faceshop.emotioncenter.message.EmotionCenterResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class EmotionCenterModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f50614e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpMessageListener f50615f;

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionCenterModel f50616a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(EmotionCenterModel emotionCenterModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionCenterModel, Integer.valueOf(i2)};
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
            this.f50616a = emotionCenterModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            EmotionCenterResponseMessage emotionCenterResponseMessage;
            Object extra;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003354 && (httpResponsedMessage instanceof EmotionCenterResponseMessage)) {
                b bVar = null;
                if (httpResponsedMessage.getOrginalMessage() != null && (extra = httpResponsedMessage.getOrginalMessage().getExtra()) != null && (extra instanceof b)) {
                    bVar = (b) extra;
                }
                if (bVar == null || (emotionCenterResponseMessage = (EmotionCenterResponseMessage) httpResponsedMessage) == null) {
                    return;
                }
                if (this.f50616a.f50614e == 1) {
                    bVar.refreshSuccess(emotionCenterResponseMessage.data);
                } else {
                    bVar.loadMore(emotionCenterResponseMessage.data);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50614e = 1;
        this.f50615f = new a(this, CmdConfigHttp.CMD_GET_EMOTION_EMOTION_SHOP);
        registerTask();
        this.f50615f.setTag(getUniqueId());
        this.f50615f.setSelfListener(true);
        registerListener(this.f50615f);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_EMOTION_EMOTION_SHOP);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_EMOTION_EMOTION_SHOP, TbConfig.SERVER_ADDRESS + "c/e/meme/shop");
            tbHttpMessageTask.setResponsedClass(EmotionCenterResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void x(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_EMOTION_EMOTION_SHOP);
            int i2 = this.f50614e + 1;
            this.f50614e = i2;
            httpMessage.addParam("pn", i2);
            httpMessage.addParam("rn", 10);
            httpMessage.setExtra(bVar);
            sendMessage(httpMessage);
        }
    }

    public void y(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f50614e = 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_EMOTION_EMOTION_SHOP);
            httpMessage.addParam("pn", 1);
            httpMessage.addParam("rn", 10);
            httpMessage.setExtra(bVar);
            sendMessage(httpMessage);
        }
    }
}
