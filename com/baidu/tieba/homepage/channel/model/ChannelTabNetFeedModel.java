package com.baidu.tieba.homepage.channel.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.s.r.d2;
import c.a.r0.t.c.o;
import c.a.s0.o1.j.e;
import c.a.s0.o1.j.f;
import c.a.s0.o1.j.h.d;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.channel.message.HomePageChannelTabHttpResponsedMessage;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes12.dex */
public class ChannelTabNetFeedModel extends BdBaseModel implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f45561e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f45562f;

    /* renamed from: g  reason: collision with root package name */
    public int f45563g;

    /* renamed from: h  reason: collision with root package name */
    public String f45564h;

    /* renamed from: i  reason: collision with root package name */
    public e f45565i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.s0.o1.b.b.a f45566j;

    /* renamed from: k  reason: collision with root package name */
    public HttpMessageListener f45567k;

    /* loaded from: classes12.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelTabNetFeedModel a;

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
            this.a = channelTabNetFeedModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.a.f45562f = false;
                if (httpResponsedMessage == null || !(httpResponsedMessage instanceof HomePageChannelTabHttpResponsedMessage)) {
                    return;
                }
                c.a.s0.o1.b.a.a aVar = ((HomePageChannelTabHttpResponsedMessage) httpResponsedMessage).channelTabRespData;
                this.a.mErrorCode = httpResponsedMessage.getError();
                this.a.mErrorString = httpResponsedMessage.getErrorString();
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.a.mErrorCode);
                errorData.setError_msg(this.a.mErrorString);
                if (this.a.f45565i == null) {
                    return;
                }
                if (this.a.mErrorCode != 0 || aVar == null) {
                    this.a.f45565i.onServerError(errorData);
                } else {
                    this.a.F(aVar);
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
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f45561e = true;
        this.f45562f = false;
        this.f45563g = 1;
        this.f45567k = new a(this, CmdConfigHttp.CMD_HOME_CHANNEL_TAB_LIST);
        c.a.s0.v3.f0.a.e(CmdConfigHttp.CMD_HOME_CHANNEL_TAB_LIST, TbConfig.CMD_HMEPAGE_CHANNEL_LIST, HomePageChannelTabHttpResponsedMessage.class, true, true, true, true);
        this.f45566j = new c.a.s0.o1.b.b.a();
        this.f45565i = eVar;
    }

    public final void E(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (i2 == 2) {
                i3 = this.f45563g + 1;
            } else if (i2 != 1) {
                return;
            } else {
                i3 = 1;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_HOME_CHANNEL_TAB_LIST);
            httpMessage.addParam("tab_code", this.f45564h);
            httpMessage.addParam("pn", i3);
            httpMessage.addParam("rn", 20);
            if (MainTabActivity.TAB_CODE_LOCAL.equals(this.f45564h)) {
                httpMessage.addParam("app_pos", c.a.s0.j3.j0.a.e().b());
            }
            o c2 = TbSingleton.getInstance().getChannelConfigModel().c();
            if (c2 != null && !TextUtils.isEmpty(c2.e())) {
                httpMessage.addParam("tid", c2.e());
            }
            httpMessage.setTag(getUniqueId());
            this.f45562f = true;
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void F(c.a.s0.o1.b.a.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || this.f45565i == null) {
            return;
        }
        d b2 = this.f45566j.b(this.f45563g, this.f45561e, aVar);
        if (b2 != null) {
            this.f45563g = b2.f21164d;
        }
        this.f45565i.onNetCallback(b2);
    }

    @Override // c.a.s0.o1.j.f
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.s0.o1.b.b.a aVar = this.f45566j;
            if (aVar == null) {
                return false;
            }
            return aVar.d();
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
            this.f45562f = false;
        }
    }

    @Override // c.a.s0.o1.j.f
    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f45567k);
            this.f45562f = false;
            this.f45561e = true;
        }
    }

    @Override // c.a.s0.o1.j.f
    public List<d2> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.s0.o1.b.b.a aVar = this.f45566j;
            if (aVar == null) {
                return null;
            }
            return aVar.c();
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.o1.j.f
    public void loadMore() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f45562f) {
            return;
        }
        this.f45561e = false;
        E(2);
    }

    @Override // c.a.s0.o1.j.f
    public void o(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048585, this, str, str2, i2) == null) {
            this.f45564h = str;
        }
    }

    @Override // c.a.s0.o1.j.f
    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f45562f) {
            return;
        }
        this.f45561e = true;
        E(1);
    }

    @Override // c.a.s0.o1.j.f
    public void registerListener(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bdUniqueId) == null) {
            setUniqueId(bdUniqueId);
            MessageManager.getInstance().unRegisterListener(this.f45567k);
            this.f45567k.setTag(bdUniqueId);
            this.f45567k.setSelfListener(true);
            registerListener(this.f45567k);
        }
    }
}
