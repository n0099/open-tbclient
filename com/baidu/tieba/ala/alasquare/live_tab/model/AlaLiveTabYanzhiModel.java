package com.baidu.tieba.ala.alasquare.live_tab.model;

import c.a.d.f.p.l;
import c.a.d.o.e.n;
import c.a.p0.c0.f.c.e.j;
import c.a.p0.c0.f.c.g.c;
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
import com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.FlushManager;
import java.util.List;
/* loaded from: classes5.dex */
public class AlaLiveTabYanzhiModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public int f31291b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f31292c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f31293d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f31294e;

    /* renamed from: f  reason: collision with root package name */
    public c f31295f;

    /* renamed from: g  reason: collision with root package name */
    public long f31296g;

    /* renamed from: h  reason: collision with root package name */
    public String f31297h;
    public String i;
    public b j;
    public HttpMessageListener k;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTabYanzhiModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaLiveTabYanzhiModel alaLiveTabYanzhiModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTabYanzhiModel, Integer.valueOf(i)};
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
            this.a = alaLiveTabYanzhiModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021141 && (httpResponsedMessage instanceof AlaTabLiveResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == this.a.f31294e) {
                AlaTabLiveResponsedMessage alaTabLiveResponsedMessage = (AlaTabLiveResponsedMessage) httpResponsedMessage;
                if (alaTabLiveResponsedMessage.getError() != 0 || !alaTabLiveResponsedMessage.isSuccess()) {
                    if (this.a.j != null) {
                        this.a.j.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), this.a.f31293d);
                    }
                } else {
                    j jVar = alaTabLiveResponsedMessage.tabAllLiveInfo;
                    if (this.a.f31293d) {
                        this.a.f31295f.a(jVar);
                        AlaLiveTabYanzhiModel.E(this.a);
                    } else {
                        AlaLiveTabFragment.j++;
                        if (this.a.f31295f != null) {
                            this.a.f31295f.b();
                        }
                        AlaLiveTabYanzhiModel alaLiveTabYanzhiModel = this.a;
                        alaLiveTabYanzhiModel.f31295f = new c(jVar, alaLiveTabYanzhiModel.f31297h, this.a.i);
                    }
                    AlaLiveTabYanzhiModel alaLiveTabYanzhiModel2 = this.a;
                    alaLiveTabYanzhiModel2.f31292c = alaLiveTabYanzhiModel2.f31295f.f();
                    if (this.a.j != null) {
                        this.a.j.a(this.a.f31292c, this.a.f31295f.d());
                    }
                }
                this.a.f31293d = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, List<n> list);

        void b(int i, String str, boolean z);
    }

    public AlaLiveTabYanzhiModel(TbPageContext tbPageContext, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new a(this, AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
        this.a = tbPageContext;
        this.j = bVar;
        this.f31294e = BdUniqueId.gen();
    }

    public static /* synthetic */ int E(AlaLiveTabYanzhiModel alaLiveTabYanzhiModel) {
        int i = alaLiveTabYanzhiModel.f31291b;
        alaLiveTabYanzhiModel.f31291b = i + 1;
        return i;
    }

    public final void J(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
            httpMessage.addParam("tab_id", 2);
            String str = "N";
            if (l.z()) {
                if (l.H()) {
                    str = "1_0";
                } else if (l.v()) {
                    str = "0_13";
                } else if (l.u()) {
                    str = "0_3";
                } else if (l.t()) {
                    str = "0_2";
                }
            }
            httpMessage.addParam("network", str);
            httpMessage.addParam("ua_str", c.a.d.f.p.n.k(this.a.getPageActivity()) + "_" + c.a.d.f.p.n.i(this.a.getPageActivity()) + "_android_" + TbConfig.getVersion());
            httpMessage.addParam("session_id", this.f31296g);
            httpMessage.addParam("refresh_type", i2);
            httpMessage.addParam("big_refresh_count", i3);
            httpMessage.addParam("fid", this.f31297h);
            httpMessage.addParam("fname", this.i);
            httpMessage.setTag(this.f31294e);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void K(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            this.f31297h = str;
            this.i = str2;
        }
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
            MessageManager.getInstance().registerListener(this.k);
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
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f31292c && !this.f31293d) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f31296g >= FlushManager.ReportTimer.DEFAULT_INTERVAL) {
                this.f31296g = currentTimeMillis;
            }
            this.f31293d = true;
            J(this.f31291b + 1, 1, AlaLiveTabFragment.j - 1);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.k);
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f31296g = System.currentTimeMillis();
            this.f31293d = false;
            this.f31291b = 1;
            J(1, 0, AlaLiveTabFragment.j);
        }
    }
}
