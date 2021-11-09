package com.baidu.tieba.homepage.tabfeed.model;

import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.q.d2;
import b.a.r0.h1.j.e;
import b.a.r0.h1.j.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.tabfeed.message.TabFeedListHttpResponsedMessage;
import com.baidu.tieba.homepage.tabfeed.message.TabFeedListRequestMessage;
import com.baidu.tieba.homepage.tabfeed.message.TabFeedListSocketResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class TabFeedNetFeedModel extends BdBaseModel implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f49775e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f49776f;

    /* renamed from: g  reason: collision with root package name */
    public int f49777g;

    /* renamed from: h  reason: collision with root package name */
    public String f49778h;

    /* renamed from: i  reason: collision with root package name */
    public String f49779i;
    public e j;
    public b.a.r0.h1.j.j.a k;
    public b.a.e.c.g.a l;

    /* loaded from: classes9.dex */
    public class a extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TabFeedNetFeedModel f49780a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TabFeedNetFeedModel tabFeedNetFeedModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabFeedNetFeedModel, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49780a = tabFeedNetFeedModel;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f49780a.f49776f = false;
                if (responsedMessage == null) {
                    return;
                }
                b.a.r0.h1.j.h.a aVar = null;
                if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                    aVar = ((TabFeedListHttpResponsedMessage) responsedMessage).tabFeedData;
                } else if (responsedMessage instanceof TabFeedListSocketResponsedMessage) {
                    aVar = ((TabFeedListSocketResponsedMessage) responsedMessage).tabFeedData;
                }
                this.f49780a.mErrorCode = responsedMessage.getError();
                this.f49780a.mErrorString = responsedMessage.getErrorString();
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.f49780a.mErrorCode);
                errorData.setError_msg(this.f49780a.mErrorString);
                if (this.f49780a.j == null) {
                    return;
                }
                if (this.f49780a.mErrorCode != 0 || aVar == null) {
                    this.f49780a.j.onServerError(errorData);
                } else {
                    this.f49780a.F(aVar);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabFeedNetFeedModel(TbPageContext tbPageContext, e eVar) {
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
                super((b.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f49775e = true;
        this.f49776f = false;
        this.f49777g = 1;
        this.l = new a(this, CmdConfigHttp.CMD_HOME_TAB_ACTIVITY_LIST, 309655);
        b.a.r0.l3.f0.a.h(309655, TabFeedListSocketResponsedMessage.class, false, false);
        b.a.r0.l3.f0.a.c(309655, CmdConfigHttp.CMD_HOME_TAB_ACTIVITY_LIST, TbConfig.URL_TAB_ACTIVITY_TAB, TabFeedListHttpResponsedMessage.class, false, false, true, false);
        this.k = new b.a.r0.h1.j.j.a();
        this.j = eVar;
    }

    public final void E(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            TabFeedListRequestMessage tabFeedListRequestMessage = new TabFeedListRequestMessage();
            tabFeedListRequestMessage.loadType = i2;
            tabFeedListRequestMessage.tabCode = this.f49779i;
            tabFeedListRequestMessage.tabName = this.f49778h;
            if (i2 == 2) {
                tabFeedListRequestMessage.pn = this.f49777g + 1;
            } else if (i2 != 1) {
                return;
            } else {
                tabFeedListRequestMessage.pn = 1;
            }
            this.f49776f = true;
            tabFeedListRequestMessage.setTag(getUniqueId());
            sendMessage(tabFeedListRequestMessage);
        }
    }

    public final void F(b.a.r0.h1.j.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (aVar != null) {
                this.f49777g = aVar.b();
            }
            if (this.j != null) {
                this.j.onNetCallback(this.k.a(this.f49775e, aVar));
            }
        }
    }

    @Override // b.a.r0.h1.j.f
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.a.r0.h1.j.j.a aVar = this.k;
            if (aVar == null) {
                return false;
            }
            return aVar.c();
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
            this.f49776f = false;
        }
    }

    @Override // b.a.r0.h1.j.f
    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.l);
            this.f49776f = false;
            this.f49775e = true;
        }
    }

    @Override // b.a.r0.h1.j.f
    public List<d2> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b.a.r0.h1.j.j.a aVar = this.k;
            if (aVar == null) {
                return null;
            }
            return aVar.b();
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

    @Override // b.a.r0.h1.j.f
    public void loadMore() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f49776f) {
            return;
        }
        this.f49775e = false;
        E(2);
    }

    @Override // b.a.r0.h1.j.f
    public void o(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048585, this, str, str2, i2) == null) {
            this.f49779i = str;
            this.f49778h = str2;
        }
    }

    @Override // b.a.r0.h1.j.f
    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f49776f) {
            return;
        }
        this.f49775e = true;
        E(1);
    }

    @Override // b.a.r0.h1.j.f
    public void registerListener(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bdUniqueId) == null) {
            setUniqueId(bdUniqueId);
            MessageManager.getInstance().unRegisterListener(this.l);
            this.l.getHttpMessageListener().setSelfListener(true);
            this.l.getSocketMessageListener().setSelfListener(true);
            registerListener(this.l);
        }
    }
}
