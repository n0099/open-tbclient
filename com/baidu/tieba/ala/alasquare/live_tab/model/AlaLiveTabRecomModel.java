package com.baidu.tieba.ala.alasquare.live_tab.model;

import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.q0.v.d.c.e.j;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigCustom;
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
import java.util.List;
/* loaded from: classes7.dex */
public class AlaLiveTabRecomModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f49309e;

    /* renamed from: f  reason: collision with root package name */
    public int f49310f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49311g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f49312h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f49313i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.v.d.c.g.b f49314j;
    public long k;
    public int l;
    public b m;
    public HttpMessageListener n;

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaLiveTabRecomModel f49315a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaLiveTabRecomModel alaLiveTabRecomModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTabRecomModel, Integer.valueOf(i2)};
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
            this.f49315a = alaLiveTabRecomModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021141 && (httpResponsedMessage instanceof AlaTabLiveResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == this.f49315a.f49313i) {
                AlaTabLiveResponsedMessage alaTabLiveResponsedMessage = (AlaTabLiveResponsedMessage) httpResponsedMessage;
                c.a.q0.v.d.c.e.b bVar = new c.a.q0.v.d.c.e.b();
                if (alaTabLiveResponsedMessage.getError() != 0 || !alaTabLiveResponsedMessage.isSuccess()) {
                    if (this.f49315a.m != null) {
                        this.f49315a.m.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), this.f49315a.f49312h);
                    }
                    bVar.f25076a = false;
                    httpResponsedMessage.getError();
                    httpResponsedMessage.getErrorString();
                } else {
                    j jVar = alaTabLiveResponsedMessage.tabAllLiveInfo;
                    if (this.f49315a.f49312h) {
                        this.f49315a.f49314j.a(jVar);
                        AlaLiveTabRecomModel.C(this.f49315a);
                    } else {
                        AlaLiveTabFragment.REFRESH_NEW_COUNT_RECOMMEND_TAB++;
                        if (this.f49315a.f49314j != null) {
                            this.f49315a.f49314j.b();
                        }
                        this.f49315a.f49314j = new c.a.q0.v.d.c.g.b(alaTabLiveResponsedMessage);
                    }
                    AlaLiveTabRecomModel alaLiveTabRecomModel = this.f49315a;
                    alaLiveTabRecomModel.f49311g = alaLiveTabRecomModel.f49314j.h();
                    if (this.f49315a.m != null) {
                        this.f49315a.m.a(this.f49315a.f49311g, this.f49315a.f49314j.d());
                    }
                    bVar.f25076a = true;
                }
                bVar.f25077b = this.f49315a.f49312h;
                bVar.f25078c = alaTabLiveResponsedMessage.superEntranceInfo;
                this.f49315a.G(bVar);
                this.f49315a.f49312h = false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(boolean z, List<n> list);

        void b(int i2, String str, boolean z);
    }

    public AlaLiveTabRecomModel(TbPageContext tbPageContext, b bVar, int i2) {
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
        this.n = new a(this, AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
        this.f49309e = tbPageContext;
        this.m = bVar;
        this.f49313i = BdUniqueId.gen();
        this.l = i2;
    }

    public static /* synthetic */ int C(AlaLiveTabRecomModel alaLiveTabRecomModel) {
        int i2 = alaLiveTabRecomModel.f49310f;
        alaLiveTabRecomModel.f49310f = i2 + 1;
        return i2;
    }

    public final void G(c.a.q0.v.d.c.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE, bVar));
        }
    }

    public final void H(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4) == null) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
            httpMessage.addParam("tab_id", this.l);
            String str = "N";
            if (c.a.e.e.p.j.z()) {
                if (c.a.e.e.p.j.H()) {
                    str = "1_0";
                } else if (c.a.e.e.p.j.v()) {
                    str = "0_13";
                } else if (c.a.e.e.p.j.u()) {
                    str = "0_3";
                } else if (c.a.e.e.p.j.t()) {
                    str = "0_2";
                }
            }
            httpMessage.addParam("network", str);
            httpMessage.addParam("ua_str", l.k(this.f49309e.getPageActivity()) + "_" + l.i(this.f49309e.getPageActivity()) + "_android_" + TbConfig.getVersion());
            httpMessage.addParam("session_id", this.k);
            httpMessage.addParam("refresh_type", i3);
            httpMessage.addParam("big_refresh_count", i4);
            httpMessage.setTag(this.f49313i);
            MessageManager.getInstance().sendMessage(httpMessage);
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

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().registerListener(this.n);
        }
    }

    public void loadMore() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f49311g && !this.f49312h) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.k >= 1800000) {
                this.k = currentTimeMillis;
            }
            this.f49312h = true;
            H(this.f49310f + 1, 1, AlaLiveTabFragment.REFRESH_NEW_COUNT_RECOMMEND_TAB - 1);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.n);
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.k = System.currentTimeMillis();
            this.f49312h = false;
            this.f49310f = 1;
            H(1, 0, AlaLiveTabFragment.REFRESH_NEW_COUNT_RECOMMEND_TAB);
        }
    }
}
