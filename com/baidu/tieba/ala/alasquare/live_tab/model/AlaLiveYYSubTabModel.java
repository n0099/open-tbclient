package com.baidu.tieba.ala.alasquare.live_tab.model;

import androidx.core.view.InputDeviceCompat;
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
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.s0.v.d.c.e.j;
import d.a.s0.v.d.c.g.d;
import java.util.List;
/* loaded from: classes5.dex */
public class AlaLiveYYSubTabModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f13974e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13975f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13976g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f13977h;

    /* renamed from: i  reason: collision with root package name */
    public d f13978i;
    public long j;
    public int k;
    public String l;
    public String m;
    public int n;
    public b o;
    public HttpMessageListener p;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaLiveYYSubTabModel f13979a;

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
            this.f13979a = alaLiveYYSubTabModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021141 && (httpResponsedMessage instanceof AlaTabLiveResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == this.f13979a.f13977h) {
                AlaTabLiveResponsedMessage alaTabLiveResponsedMessage = (AlaTabLiveResponsedMessage) httpResponsedMessage;
                if (alaTabLiveResponsedMessage.getError() != 0 || !alaTabLiveResponsedMessage.isSuccess()) {
                    if (this.f13979a.o != null) {
                        this.f13979a.o.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), this.f13979a.f13976g);
                    }
                } else {
                    j jVar = alaTabLiveResponsedMessage.tabAllLiveInfo;
                    if (this.f13979a.f13976g) {
                        this.f13979a.f13978i.a(jVar);
                    } else {
                        AlaLiveTabFragment.N0(this.f13979a.k);
                        if (this.f13979a.f13978i != null) {
                            this.f13979a.f13978i.b();
                        }
                        AlaLiveYYSubTabModel alaLiveYYSubTabModel = this.f13979a;
                        alaLiveYYSubTabModel.f13978i = new d(jVar, alaLiveYYSubTabModel.l, this.f13979a.m);
                    }
                    AlaLiveYYSubTabModel alaLiveYYSubTabModel2 = this.f13979a;
                    alaLiveYYSubTabModel2.f13975f = alaLiveYYSubTabModel2.f13978i.f();
                    if (this.f13979a.o != null) {
                        this.f13979a.o.a(this.f13979a.f13975f, this.f13979a.f13978i.d());
                    }
                }
                this.f13979a.f13976g = false;
            }
        }
    }

    /* loaded from: classes5.dex */
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
        this.f13974e = tbPageContext;
        this.o = bVar;
        this.f13977h = BdUniqueId.gen();
        this.k = i2;
    }

    public final void H(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
            httpMessage.addParam("tab_id", this.k);
            String str = "N";
            if (d.a.c.e.p.j.z()) {
                if (d.a.c.e.p.j.H()) {
                    str = "1_0";
                } else if (d.a.c.e.p.j.v()) {
                    str = "0_13";
                } else if (d.a.c.e.p.j.u()) {
                    str = "0_3";
                } else if (d.a.c.e.p.j.t()) {
                    str = "0_2";
                }
            }
            httpMessage.addParam("network", str);
            httpMessage.addParam("ua_str", l.k(this.f13974e.getPageActivity()) + "_" + l.i(this.f13974e.getPageActivity()) + "_android_" + TbConfig.getVersion());
            httpMessage.addParam("session_id", this.j);
            httpMessage.addParam("refresh_type", i2);
            httpMessage.addParam("big_refresh_count", i3);
            httpMessage.addParam("fid", this.l);
            httpMessage.addParam("fname", this.m);
            httpMessage.setTag(this.f13977h);
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
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d dVar = this.f13978i;
            return (dVar == null || ListUtils.isEmpty(dVar.d())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().registerListener(this.p);
        }
    }

    public void loadMore() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.f13975f && !this.f13976g) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.j >= this.n * 30 * 1000) {
                this.j = currentTimeMillis;
            }
            this.f13976g = true;
            H(1, AlaLiveTabFragment.O0(this.k) - 1);
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
            this.j = System.currentTimeMillis();
            this.f13976g = false;
            H(0, AlaLiveTabFragment.O0(this.k));
        }
    }
}
