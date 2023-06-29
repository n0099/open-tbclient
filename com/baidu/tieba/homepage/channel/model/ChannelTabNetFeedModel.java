package com.baidu.tieba.homepage.channel.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.coreExtra.data.ChannelIconConfigFinalData;
import com.baidu.tieba.gv7;
import com.baidu.tieba.homepage.channel.message.HomePageChannelTabHttpResponsedMessage;
import com.baidu.tieba.hv7;
import com.baidu.tieba.l9;
import com.baidu.tieba.v38;
import com.baidu.tieba.v3a;
import com.baidu.tieba.w28;
import com.baidu.tieba.x28;
import com.baidu.tieba.xt9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class ChannelTabNetFeedModel extends BdBaseModel implements x28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public int c;
    public String d;
    public w28 e;
    public hv7 f;
    public HttpMessageListener g;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelTabNetFeedModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ChannelTabNetFeedModel channelTabNetFeedModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelTabNetFeedModel, Integer.valueOf(i)};
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
            this.a = channelTabNetFeedModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.a.b = false;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof HomePageChannelTabHttpResponsedMessage)) {
                    gv7 gv7Var = ((HomePageChannelTabHttpResponsedMessage) httpResponsedMessage).channelTabRespData;
                    this.a.mErrorCode = httpResponsedMessage.getError();
                    this.a.mErrorString = httpResponsedMessage.getErrorString();
                    ErrorData errorData = new ErrorData();
                    errorData.setError_code(this.a.mErrorCode);
                    errorData.setError_msg(this.a.mErrorString);
                    if (this.a.e == null) {
                        return;
                    }
                    if (this.a.mErrorCode == 0 && gv7Var != null) {
                        this.a.d0(gv7Var);
                    } else {
                        this.a.e.g(errorData);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelTabNetFeedModel(TbPageContext tbPageContext, w28 w28Var) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, w28Var};
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
        this.a = true;
        this.b = false;
        this.c = 1;
        this.g = new a(this, CmdConfigHttp.CMD_HOME_CHANNEL_TAB_LIST);
        v3a.e(CmdConfigHttp.CMD_HOME_CHANNEL_TAB_LIST, TbConfig.CMD_HMEPAGE_CHANNEL_LIST, HomePageChannelTabHttpResponsedMessage.class, true, true, true, true);
        this.f = new hv7();
        this.e = w28Var;
    }

    public final void d0(gv7 gv7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, gv7Var) == null) && this.e != null) {
            v38 b = this.f.b(this.c, this.a, gv7Var);
            if (b != null) {
                this.c = b.d;
            }
            this.e.t0(b);
        }
    }

    @Override // com.baidu.tieba.x28
    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            setUniqueId(bdUniqueId);
            MessageManager.getInstance().unRegisterListener(this.g);
            this.g.setTag(bdUniqueId);
            this.g.setSelfListener(true);
            registerListener(this.g);
        }
    }

    @Override // com.baidu.tieba.x28
    public void J(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, str, str2, i) == null) {
            this.d = str;
        }
    }

    @Override // com.baidu.tieba.x28
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.b) {
            return;
        }
        this.a = false;
        c0(2);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.cancelMessage();
            this.b = false;
        }
    }

    @Override // com.baidu.tieba.x28
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            hv7 hv7Var = this.f;
            if (hv7Var == null) {
                return false;
            }
            return hv7Var.d();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.x28
    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.g);
            this.b = false;
            this.a = true;
        }
    }

    @Override // com.baidu.tieba.x28
    public void refresh() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || this.b) {
            return;
        }
        this.a = true;
        c0(1);
    }

    @Override // com.baidu.tieba.x28
    public List<ThreadData> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            hv7 hv7Var = this.f;
            if (hv7Var == null) {
                return null;
            }
            return hv7Var.c();
        }
        return (List) invokeV.objValue;
    }

    public final void c0(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (i == 2) {
                i2 = this.c + 1;
            } else if (i == 1) {
                i2 = 1;
            } else {
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_HOME_CHANNEL_TAB_LIST);
            httpMessage.addParam("tab_code", this.d);
            httpMessage.addParam("pn", i2);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam("q_type", TbImageHelper.getInstance().getUrlQuality());
            if ("local".equals(this.d)) {
                httpMessage.addParam("app_pos", xt9.e().b());
            }
            ChannelIconConfigFinalData c = TbSingleton.getInstance().getChannelConfigModel().c();
            if (c != null && !TextUtils.isEmpty(c.getTid())) {
                httpMessage.addParam("tid", c.getTid());
            }
            httpMessage.setTag(getUniqueId());
            this.b = true;
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
