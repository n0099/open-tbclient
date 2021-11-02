package com.baidu.tieba.face;

import android.text.TextUtils;
import b.a.e.e.p.l;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class SearchEmotionModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f47790e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpMessageListener f47791f;

    /* loaded from: classes9.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SearchEmotionModel f47792a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SearchEmotionModel searchEmotionModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchEmotionModel, Integer.valueOf(i2)};
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
            this.f47792a = searchEmotionModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003330 && (httpResponsedMessage instanceof SearchEmotionResponseMessage) && this.f47792a.f47790e != null) {
                SearchEmotionResponseMessage searchEmotionResponseMessage = (SearchEmotionResponseMessage) httpResponsedMessage;
                if (searchEmotionResponseMessage.getData() != null) {
                    if (httpResponsedMessage.getOrginalMessage() == null || !(httpResponsedMessage.getOrginalMessage().getExtra() instanceof String)) {
                        return;
                    }
                    this.f47792a.f47790e.a((String) httpResponsedMessage.getOrginalMessage().getExtra(), searchEmotionResponseMessage.getData());
                    return;
                }
                if (!TextUtils.isEmpty(searchEmotionResponseMessage.getErrorString())) {
                    l.M(TbadkCoreApplication.getInst(), searchEmotionResponseMessage.getErrorString());
                }
                this.f47792a.f47790e.onFail(searchEmotionResponseMessage.getError(), searchEmotionResponseMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(String str, b.a.r0.r0.c.a aVar);

        void onFail(int i2, String str);
    }

    public SearchEmotionModel() {
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
        this.f47791f = new a(this, CmdConfigHttp.CMD_SEARCH_PB_EMOTION);
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.f47791f.setTag(getUniqueId());
        this.f47791f.setSelfListener(true);
        registerListener(this.f47791f);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            MessageManager.getInstance().unRegisterListener(getUniqueId());
            this.f47790e = null;
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
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SEARCH_PB_EMOTION, TbConfig.SERVER_ADDRESS + "c/e/meme/search");
            tbHttpMessageTask.setResponsedClass(SearchEmotionResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void x(String str, int i2, int i3, b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), bVar}) == null) || bVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f47790e = bVar;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_PB_EMOTION);
        httpMessage.addParam(TiebaStatic.Params.H5_FORUM_NAME, str);
        httpMessage.addParam("pn", i2);
        httpMessage.addParam("rn", i3);
        httpMessage.setExtra(str);
        sendMessage(httpMessage);
    }
}
