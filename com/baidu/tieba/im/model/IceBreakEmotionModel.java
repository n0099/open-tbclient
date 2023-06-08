package com.baidu.tieba.im.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.im.message.IceBreakHttpResponsedMessage;
import com.baidu.tieba.k9;
import com.baidu.tieba.u78;
import com.baidu.tieba.v78;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class IceBreakEmotionModel extends BdBaseModel<IceBreakEmotionModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IceBreakRequestCallback mCallback;

    /* loaded from: classes6.dex */
    public interface IceBreakRequestCallback {
        void onSuccess(List<v78> list);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IceBreakEmotionModel(TbPageContext tbPageContext) {
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
                super((k9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        registerHttpTask();
        registerHttpListener();
    }

    public void setRequestCallback(IceBreakRequestCallback iceBreakRequestCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iceBreakRequestCallback) == null) {
            this.mCallback = iceBreakRequestCallback;
        }
    }

    private void registerHttpListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            HttpMessageListener httpMessageListener = new HttpMessageListener(this, CmdConfigHttp.CMD_GET_ICE_BREAK_EMOTIONS) { // from class: com.baidu.tieba.im.model.IceBreakEmotionModel.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IceBreakEmotionModel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(r8)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    u78 u78Var;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeL(1048576, this, httpResponsedMessage) != null) || !(httpResponsedMessage instanceof IceBreakHttpResponsedMessage) || httpResponsedMessage.getError() != 0 || (u78Var = ((IceBreakHttpResponsedMessage) httpResponsedMessage).data) == null) {
                        return;
                    }
                    List<v78> a = u78Var.a();
                    if (!ListUtils.isEmpty(a) && this.this$0.mCallback != null) {
                        this.this$0.mCallback.onSuccess(a);
                    }
                }
            };
            httpMessageListener.setSelfListener(true);
            registerListener(httpMessageListener);
        }
    }

    public void request() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_ICE_BREAK_EMOTIONS));
        }
    }

    private void registerHttpTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_ICE_BREAK_EMOTIONS, TbConfig.SERVER_ADDRESS + "c/e/meme/getNewFriendMemes");
            tbHttpMessageTask.setResponsedClass(IceBreakHttpResponsedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }
}
