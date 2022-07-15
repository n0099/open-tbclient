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
import com.baidu.mobstat.Config;
import com.baidu.sofire.core.ForHostApp;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.coreExtra.data.ChannelIconConfigFinalData;
import com.baidu.tieba.homepage.channel.message.HomePageChannelTabHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ab8;
import com.repackage.d9;
import com.repackage.rs6;
import com.repackage.ss6;
import com.repackage.v07;
import com.repackage.wh8;
import com.repackage.wz6;
import com.repackage.xz6;
import java.util.List;
/* loaded from: classes3.dex */
public class ChannelTabNetFeedModel extends BdBaseModel implements xz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public int c;
    public String d;
    public wz6 e;
    public ss6 f;
    public HttpMessageListener g;

    /* loaded from: classes3.dex */
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
                if (httpResponsedMessage == null || !(httpResponsedMessage instanceof HomePageChannelTabHttpResponsedMessage)) {
                    return;
                }
                rs6 rs6Var = ((HomePageChannelTabHttpResponsedMessage) httpResponsedMessage).channelTabRespData;
                this.a.mErrorCode = httpResponsedMessage.getError();
                this.a.mErrorString = httpResponsedMessage.getErrorString();
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.a.mErrorCode);
                errorData.setError_msg(this.a.mErrorString);
                if (this.a.e == null) {
                    return;
                }
                if (this.a.mErrorCode != 0 || rs6Var == null) {
                    this.a.e.f(errorData);
                } else {
                    this.a.J(rs6Var);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelTabNetFeedModel(TbPageContext tbPageContext, wz6 wz6Var) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, wz6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = true;
        this.b = false;
        this.c = 1;
        this.g = new a(this, CmdConfigHttp.CMD_HOME_CHANNEL_TAB_LIST);
        wh8.e(CmdConfigHttp.CMD_HOME_CHANNEL_TAB_LIST, TbConfig.CMD_HMEPAGE_CHANNEL_LIST, HomePageChannelTabHttpResponsedMessage.class, true, true, true, true);
        this.f = new ss6();
        this.e = wz6Var;
    }

    public final void I(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (i == 2) {
                i2 = this.c + 1;
            } else if (i != 1) {
                return;
            } else {
                i2 = 1;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_HOME_CHANNEL_TAB_LIST);
            httpMessage.addParam("tab_code", this.d);
            httpMessage.addParam(Config.PACKAGE_NAME, i2);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam("q_type", TbImageHelper.getInstance().getUrlQuality());
            if (ForHostApp.KEY_NAME_LOCAL.equals(this.d)) {
                httpMessage.addParam("app_pos", ab8.e().b());
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

    public final void J(rs6 rs6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rs6Var) == null) || this.e == null) {
            return;
        }
        v07 b = this.f.b(this.c, this.a, rs6Var);
        if (b != null) {
            this.c = b.d;
        }
        this.e.m0(b);
    }

    @Override // com.repackage.xz6
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.b) {
            return;
        }
        this.a = false;
        I(2);
    }

    @Override // com.repackage.xz6
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ss6 ss6Var = this.f;
            if (ss6Var == null) {
                return false;
            }
            return ss6Var.d();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.cancelMessage();
            this.b = false;
        }
    }

    @Override // com.repackage.xz6
    public void d(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            setUniqueId(bdUniqueId);
            MessageManager.getInstance().unRegisterListener(this.g);
            this.g.setTag(bdUniqueId);
            this.g.setSelfListener(true);
            registerListener(this.g);
        }
    }

    @Override // com.repackage.xz6
    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.g);
            this.b = false;
            this.a = true;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.xz6
    public List<ThreadData> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ss6 ss6Var = this.f;
            if (ss6Var == null) {
                return null;
            }
            return ss6Var.c();
        }
        return (List) invokeV.objValue;
    }

    @Override // com.repackage.xz6
    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.b) {
            return;
        }
        this.a = true;
        I(1);
    }

    @Override // com.repackage.xz6
    public void s(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048587, this, str, str2, i) == null) {
            this.d = str;
        }
    }
}
