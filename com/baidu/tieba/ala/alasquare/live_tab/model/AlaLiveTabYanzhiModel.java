package com.baidu.tieba.ala.alasquare.live_tab.model;

import c.a.d.f.p.l;
import c.a.d.m.e.n;
import c.a.r0.a0.f.c.e.j;
import c.a.r0.a0.f.c.g.c;
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
/* loaded from: classes10.dex */
public class AlaLiveTabYanzhiModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f42806e;

    /* renamed from: f  reason: collision with root package name */
    public int f42807f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42808g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f42809h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f42810i;

    /* renamed from: j  reason: collision with root package name */
    public c f42811j;

    /* renamed from: k  reason: collision with root package name */
    public long f42812k;
    public String l;
    public String m;
    public b n;
    public HttpMessageListener o;

    /* loaded from: classes10.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTabYanzhiModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaLiveTabYanzhiModel alaLiveTabYanzhiModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTabYanzhiModel, Integer.valueOf(i2)};
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
            this.a = alaLiveTabYanzhiModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021141 && (httpResponsedMessage instanceof AlaTabLiveResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == this.a.f42810i) {
                AlaTabLiveResponsedMessage alaTabLiveResponsedMessage = (AlaTabLiveResponsedMessage) httpResponsedMessage;
                if (alaTabLiveResponsedMessage.getError() != 0 || !alaTabLiveResponsedMessage.isSuccess()) {
                    if (this.a.n != null) {
                        this.a.n.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), this.a.f42809h);
                    }
                } else {
                    j jVar = alaTabLiveResponsedMessage.tabAllLiveInfo;
                    if (this.a.f42809h) {
                        this.a.f42811j.a(jVar);
                        AlaLiveTabYanzhiModel.C(this.a);
                    } else {
                        AlaLiveTabFragment.REFRESH_NEW_COUNT_YANZHI_TAB++;
                        if (this.a.f42811j != null) {
                            this.a.f42811j.b();
                        }
                        AlaLiveTabYanzhiModel alaLiveTabYanzhiModel = this.a;
                        alaLiveTabYanzhiModel.f42811j = new c(jVar, alaLiveTabYanzhiModel.l, this.a.m);
                    }
                    AlaLiveTabYanzhiModel alaLiveTabYanzhiModel2 = this.a;
                    alaLiveTabYanzhiModel2.f42808g = alaLiveTabYanzhiModel2.f42811j.f();
                    if (this.a.n != null) {
                        this.a.n.a(this.a.f42808g, this.a.f42811j.d());
                    }
                }
                this.a.f42809h = false;
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a(boolean z, List<n> list);

        void b(int i2, String str, boolean z);
    }

    public AlaLiveTabYanzhiModel(TbPageContext tbPageContext, b bVar) {
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
        this.o = new a(this, AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
        this.f42806e = tbPageContext;
        this.n = bVar;
        this.f42810i = BdUniqueId.gen();
    }

    public static /* synthetic */ int C(AlaLiveTabYanzhiModel alaLiveTabYanzhiModel) {
        int i2 = alaLiveTabYanzhiModel.f42807f;
        alaLiveTabYanzhiModel.f42807f = i2 + 1;
        return i2;
    }

    public final void H(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048576, this, i2, i3, i4) == null) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
            httpMessage.addParam("tab_id", 2);
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
            httpMessage.addParam("ua_str", l.k(this.f42806e.getPageActivity()) + "_" + l.i(this.f42806e.getPageActivity()) + "_android_" + TbConfig.getVersion());
            httpMessage.addParam("session_id", this.f42812k);
            httpMessage.addParam("refresh_type", i3);
            httpMessage.addParam("big_refresh_count", i4);
            httpMessage.addParam("fid", this.l);
            httpMessage.addParam("fname", this.m);
            httpMessage.setTag(this.f42810i);
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
            MessageManager.getInstance().registerListener(this.o);
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
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f42808g && !this.f42809h) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f42812k >= FlushManager.ReportTimer.DEFAULT_INTERVAL) {
                this.f42812k = currentTimeMillis;
            }
            this.f42809h = true;
            H(this.f42807f + 1, 1, AlaLiveTabFragment.REFRESH_NEW_COUNT_YANZHI_TAB - 1);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.o);
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f42812k = System.currentTimeMillis();
            this.f42809h = false;
            this.f42807f = 1;
            H(1, 0, AlaLiveTabFragment.REFRESH_NEW_COUNT_YANZHI_TAB);
        }
    }
}
