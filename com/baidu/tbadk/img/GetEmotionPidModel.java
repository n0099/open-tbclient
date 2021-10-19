package com.baidu.tbadk.img;

import android.text.TextUtils;
import c.a.q0.d0.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class GetEmotionPidModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f48423e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpMessageListener f48424f;

    /* loaded from: classes6.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GetEmotionPidModel f48425a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GetEmotionPidModel getEmotionPidModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {getEmotionPidModel, Integer.valueOf(i2)};
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
            this.f48425a = getEmotionPidModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003331 && (httpResponsedMessage instanceof GetEmotionPidResponseMessage) && this.f48425a.f48423e != null) {
                GetEmotionPidResponseMessage getEmotionPidResponseMessage = (GetEmotionPidResponseMessage) httpResponsedMessage;
                if (getEmotionPidResponseMessage.getImageInfo() != null) {
                    this.f48425a.f48423e.a(getEmotionPidResponseMessage.getImageInfo());
                } else {
                    this.f48425a.f48423e.onFail(getEmotionPidResponseMessage.getError(), getEmotionPidResponseMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(c cVar);

        void onFail(int i2, String str);
    }

    public GetEmotionPidModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f48424f = new a(this, CmdConfigHttp.CMD_GET_PB_EMOTION_PID);
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.f48424f.setTag(getUniqueId());
        this.f48424f.setSelfListener(true);
        registerListener(this.f48424f);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            MessageManager.getInstance().unRegisterListener(this.f48424f);
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_PB_EMOTION_PID);
            return true;
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

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_PB_EMOTION_PID, TbConfig.SERVER_ADDRESS + "c/e/meme/pic2id");
            tbHttpMessageTask.setResponsedClass(GetEmotionPidResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void x(String str, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, bVar) == null) {
            this.f48423e = bVar;
            if (TextUtils.isEmpty(str)) {
                if (bVar != null) {
                    bVar.onFail(0, "picUrl is empty");
                    return;
                }
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_PB_EMOTION_PID);
            httpMessage.addParam("pic_url", c.a.q0.m.c.q(str));
            sendMessage(httpMessage);
        }
    }
}
