package com.baidu.tieba.ala.alasquare.live_tab.model;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.m.e.n;
import c.a.r0.a0.f.c.e.j;
import c.a.r0.a0.f.c.g.d;
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
/* loaded from: classes10.dex */
public class AlaLiveYYSubTabModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f42813e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42814f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42815g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f42816h;

    /* renamed from: i  reason: collision with root package name */
    public d f42817i;

    /* renamed from: j  reason: collision with root package name */
    public long f42818j;

    /* renamed from: k  reason: collision with root package name */
    public int f42819k;
    public String l;
    public String m;
    public int n;
    public b o;
    public HttpMessageListener p;

    /* loaded from: classes10.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveYYSubTabModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaLiveYYSubTabModel alaLiveYYSubTabModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveYYSubTabModel, Integer.valueOf(i2)};
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
            this.a = alaLiveYYSubTabModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021141 && (httpResponsedMessage instanceof AlaTabLiveResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == this.a.f42816h) {
                AlaTabLiveResponsedMessage alaTabLiveResponsedMessage = (AlaTabLiveResponsedMessage) httpResponsedMessage;
                if (alaTabLiveResponsedMessage.getError() != 0 || !alaTabLiveResponsedMessage.isSuccess()) {
                    if (this.a.o != null) {
                        this.a.o.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), this.a.f42815g);
                    }
                } else {
                    j jVar = alaTabLiveResponsedMessage.tabAllLiveInfo;
                    if (this.a.f42815g) {
                        this.a.f42817i.a(jVar);
                    } else {
                        AlaLiveTabFragment.addRefreshNewCountYYTab(this.a.f42819k);
                        if (this.a.f42817i != null) {
                            this.a.f42817i.b();
                        }
                        AlaLiveYYSubTabModel alaLiveYYSubTabModel = this.a;
                        alaLiveYYSubTabModel.f42817i = new d(jVar, alaLiveYYSubTabModel.l, this.a.m);
                    }
                    AlaLiveYYSubTabModel alaLiveYYSubTabModel2 = this.a;
                    alaLiveYYSubTabModel2.f42814f = alaLiveYYSubTabModel2.f42817i.f();
                    if (this.a.o != null) {
                        this.a.o.a(this.a.f42814f, this.a.f42817i.d());
                    }
                }
                this.a.f42815g = false;
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a(boolean z, List<n> list);

        void b(int i2, String str, boolean z);
    }

    public AlaLiveYYSubTabModel(TbPageContext tbPageContext, b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = 60;
        this.p = new a(this, AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
        this.f42813e = tbPageContext;
        this.o = bVar;
        this.f42816h = BdUniqueId.gen();
        this.f42819k = i2;
    }

    public final void H(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
            httpMessage.addParam("tab_id", this.f42819k);
            String str = "N";
            if (c.a.d.f.p.j.z()) {
                if (c.a.d.f.p.j.H()) {
                    str = "1_0";
                } else if (c.a.d.f.p.j.v()) {
                    str = "0_13";
                } else if (c.a.d.f.p.j.u()) {
                    str = "0_3";
                } else if (c.a.d.f.p.j.t()) {
                    str = "0_2";
                }
            }
            httpMessage.addParam("network", str);
            httpMessage.addParam("ua_str", l.k(this.f42813e.getPageActivity()) + "_" + l.i(this.f42813e.getPageActivity()) + "_android_" + TbConfig.getVersion());
            httpMessage.addParam("session_id", this.f42818j);
            httpMessage.addParam("refresh_type", i2);
            httpMessage.addParam("big_refresh_count", i3);
            httpMessage.addParam("fid", this.l);
            httpMessage.addParam("fname", this.m);
            httpMessage.setTag(this.f42816h);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void I(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            this.l = str;
            this.m = str2;
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            d dVar = this.f42817i;
            return (dVar == null || ListUtils.isEmpty(dVar.d())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().registerListener(this.p);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void loadMore() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.f42814f && !this.f42815g) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f42818j >= this.n * 30 * 1000) {
                this.f42818j = currentTimeMillis;
            }
            this.f42815g = true;
            H(1, AlaLiveTabFragment.getRefreshNewCountYYTab(this.f42819k) - 1);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.p);
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f42818j = System.currentTimeMillis();
            this.f42815g = false;
            H(0, AlaLiveTabFragment.getRefreshNewCountYYTab(this.f42819k));
        }
    }
}
