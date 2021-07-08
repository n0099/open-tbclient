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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.channel.message.HomePageChannelTabHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.q.b2;
import d.a.o0.s.c.n;
import d.a.p0.e1.j.e;
import d.a.p0.e1.j.f;
import d.a.p0.e1.j.h.c;
import java.util.List;
/* loaded from: classes4.dex */
public class ChannelTabNetFeedModel extends BdBaseModel implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16440e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f16441f;

    /* renamed from: g  reason: collision with root package name */
    public int f16442g;

    /* renamed from: h  reason: collision with root package name */
    public String f16443h;

    /* renamed from: i  reason: collision with root package name */
    public e f16444i;
    public d.a.p0.e1.b.b.a j;
    public HttpMessageListener k;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ChannelTabNetFeedModel f16445a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ChannelTabNetFeedModel channelTabNetFeedModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelTabNetFeedModel, Integer.valueOf(i2)};
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
            this.f16445a = channelTabNetFeedModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.f16445a.f16441f = false;
                if (httpResponsedMessage == null || !(httpResponsedMessage instanceof HomePageChannelTabHttpResponsedMessage)) {
                    return;
                }
                d.a.p0.e1.b.a.a aVar = ((HomePageChannelTabHttpResponsedMessage) httpResponsedMessage).channelTabRespData;
                this.f16445a.mErrorCode = httpResponsedMessage.getError();
                this.f16445a.mErrorString = httpResponsedMessage.getErrorString();
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.f16445a.mErrorCode);
                errorData.setError_msg(this.f16445a.mErrorString);
                if (this.f16445a.f16444i == null) {
                    return;
                }
                if (this.f16445a.mErrorCode != 0 || aVar == null) {
                    this.f16445a.f16444i.onServerError(errorData);
                } else {
                    this.f16445a.F(aVar);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelTabNetFeedModel(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.c.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16440e = true;
        this.f16441f = false;
        this.f16442g = 1;
        this.k = new a(this, CmdConfigHttp.CMD_HOME_CHANNEL_TAB_LIST);
        d.a.p0.h3.d0.a.e(CmdConfigHttp.CMD_HOME_CHANNEL_TAB_LIST, TbConfig.CMD_HMEPAGE_CHANNEL_LIST, HomePageChannelTabHttpResponsedMessage.class, true, true, true, true);
        this.j = new d.a.p0.e1.b.b.a();
        this.f16444i = eVar;
    }

    public final void E(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (i2 == 2) {
                i3 = this.f16442g + 1;
            } else if (i2 != 1) {
                return;
            } else {
                i3 = 1;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_HOME_CHANNEL_TAB_LIST);
            httpMessage.addParam(LowFlowsActivityConfig.TAB_CODE, this.f16443h);
            httpMessage.addParam(Config.PACKAGE_NAME, i3);
            httpMessage.addParam("rn", 20);
            if ("local".equals(this.f16443h)) {
                httpMessage.addParam("app_pos", d.a.p0.w2.g0.a.e().b());
            }
            n c2 = TbSingleton.getInstance().getChannelConfigModel().c();
            if (c2 != null && !TextUtils.isEmpty(c2.e())) {
                httpMessage.addParam("tid", c2.e());
            }
            httpMessage.setTag(getUniqueId());
            this.f16441f = true;
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void F(d.a.p0.e1.b.a.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || this.f16444i == null) {
            return;
        }
        c a2 = this.j.a(this.f16442g, this.f16440e, aVar);
        if (a2 != null) {
            this.f16442g = a2.f55728d;
        }
        this.f16444i.M(a2);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
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
            this.f16441f = false;
        }
    }

    @Override // d.a.p0.e1.j.f
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d.a.p0.e1.b.b.a aVar = this.j;
            if (aVar == null) {
                return false;
            }
            return aVar.c();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.p0.e1.j.f
    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.k);
            this.f16441f = false;
            this.f16440e = true;
        }
    }

    @Override // d.a.p0.e1.j.f
    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            setUniqueId(bdUniqueId);
            MessageManager.getInstance().unRegisterListener(this.k);
            this.k.setTag(bdUniqueId);
            this.k.setSelfListener(true);
            registerListener(this.k);
        }
    }

    @Override // d.a.p0.e1.j.f
    public List<b2> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            d.a.p0.e1.b.b.a aVar = this.j;
            if (aVar == null) {
                return null;
            }
            return aVar.b();
        }
        return (List) invokeV.objValue;
    }

    @Override // d.a.p0.e1.j.f
    public void loadMore() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f16441f) {
            return;
        }
        this.f16440e = false;
        E(2);
    }

    @Override // d.a.p0.e1.j.f
    public void o(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048586, this, str, str2, i2) == null) {
            this.f16443h = str;
        }
    }

    @Override // d.a.p0.e1.j.f
    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f16441f) {
            return;
        }
        this.f16440e = true;
        E(1);
    }
}
