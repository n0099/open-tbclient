package com.baidu.tieba.ala.alasquare.live_tab.model;

import b.a.e.e.p.l;
import b.a.e.l.e.n;
import b.a.r0.w.f.c.e.j;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class AlaLiveTabFriendModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f46930e;

    /* renamed from: f  reason: collision with root package name */
    public int f46931f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f46932g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f46933h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f46934i;
    public b.a.r0.w.f.c.g.a j;
    public long k;
    public b l;
    public HttpMessageListener m;

    /* loaded from: classes9.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaLiveTabFriendModel f46935a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaLiveTabFriendModel alaLiveTabFriendModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTabFriendModel, Integer.valueOf(i2)};
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
            this.f46935a = alaLiveTabFriendModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021141 && (httpResponsedMessage instanceof AlaTabLiveResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == this.f46935a.f46934i) {
                AlaTabLiveResponsedMessage alaTabLiveResponsedMessage = (AlaTabLiveResponsedMessage) httpResponsedMessage;
                if (alaTabLiveResponsedMessage.getError() != 0 || !alaTabLiveResponsedMessage.isSuccess()) {
                    if (this.f46935a.l != null) {
                        this.f46935a.l.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), this.f46935a.f46933h);
                    }
                } else {
                    j jVar = alaTabLiveResponsedMessage.tabAllLiveInfo;
                    if (this.f46935a.f46933h) {
                        this.f46935a.j.a(jVar);
                        AlaLiveTabFriendModel.C(this.f46935a);
                    } else {
                        AlaLiveTabFragment.REFRESH_NEW_COUNT_FRIEND_TAB++;
                        if (this.f46935a.j != null) {
                            this.f46935a.j.b();
                        }
                        this.f46935a.j = new b.a.r0.w.f.c.g.a(alaTabLiveResponsedMessage);
                    }
                    AlaLiveTabFriendModel alaLiveTabFriendModel = this.f46935a;
                    alaLiveTabFriendModel.f46932g = alaLiveTabFriendModel.j.f();
                    if (this.f46935a.l != null) {
                        this.f46935a.l.a(this.f46935a.f46932g, this.f46935a.j.d());
                    }
                }
                this.f46935a.f46933h = false;
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(boolean z, List<n> list);

        void b(int i2, String str, boolean z);
    }

    public AlaLiveTabFriendModel(TbPageContext tbPageContext, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new a(this, AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
        this.f46930e = tbPageContext;
        this.l = bVar;
        this.f46934i = BdUniqueId.gen();
    }

    public static /* synthetic */ int C(AlaLiveTabFriendModel alaLiveTabFriendModel) {
        int i2 = alaLiveTabFriendModel.f46931f;
        alaLiveTabFriendModel.f46931f = i2 + 1;
        return i2;
    }

    public final void F(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048576, this, i2, i3, i4) == null) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
            httpMessage.addParam("tab_id", 3);
            String str = "N";
            if (b.a.e.e.p.j.z()) {
                if (b.a.e.e.p.j.H()) {
                    str = "1_0";
                } else if (b.a.e.e.p.j.v()) {
                    str = "0_13";
                } else if (b.a.e.e.p.j.u()) {
                    str = "0_3";
                } else if (b.a.e.e.p.j.t()) {
                    str = "0_2";
                }
            }
            httpMessage.addParam("network", str);
            httpMessage.addParam("ua_str", l.k(this.f46930e.getPageActivity()) + "_" + l.i(this.f46930e.getPageActivity()) + "_android_" + TbConfig.getVersion());
            httpMessage.addParam("session_id", this.k);
            httpMessage.addParam("refresh_type", i3);
            httpMessage.addParam("big_refresh_count", i4);
            httpMessage.setTag(this.f46934i);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.a.r0.w.f.c.g.a aVar = this.j;
            return (aVar == null || ListUtils.isEmpty(aVar.d())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().registerListener(this.m);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void loadMore() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f46932g && !this.f46933h) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.k >= 1800000) {
                this.k = currentTimeMillis;
            }
            this.f46933h = true;
            F(this.f46931f + 1, 1, AlaLiveTabFragment.REFRESH_NEW_COUNT_FRIEND_TAB - 1);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.m);
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.k = System.currentTimeMillis();
            this.f46933h = false;
            this.f46931f = 1;
            F(1, 0, AlaLiveTabFragment.REFRESH_NEW_COUNT_FRIEND_TAB);
        }
    }
}
