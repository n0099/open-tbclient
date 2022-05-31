package com.baidu.tieba.ala.alasquare.live_tab.model;

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
import com.repackage.hn5;
import com.repackage.ji;
import com.repackage.jn;
import com.repackage.li;
import com.repackage.no5;
import com.repackage.pn5;
import com.yy.hiidostatis.inner.FlushManager;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaLiveTabRecomModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public int b;
    public boolean c;
    public boolean d;
    public BdUniqueId e;
    public no5 f;
    public long g;
    public int h;
    public b i;
    public HttpMessageListener j;

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTabRecomModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaLiveTabRecomModel alaLiveTabRecomModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTabRecomModel, Integer.valueOf(i)};
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
            this.a = alaLiveTabRecomModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021141 && (httpResponsedMessage instanceof AlaTabLiveResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == this.a.e) {
                AlaTabLiveResponsedMessage alaTabLiveResponsedMessage = (AlaTabLiveResponsedMessage) httpResponsedMessage;
                hn5 hn5Var = new hn5();
                if (alaTabLiveResponsedMessage.getError() != 0 || !alaTabLiveResponsedMessage.isSuccess()) {
                    if (this.a.i != null) {
                        this.a.i.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), this.a.d);
                    }
                    hn5Var.a = false;
                    httpResponsedMessage.getError();
                    httpResponsedMessage.getErrorString();
                } else {
                    pn5 pn5Var = alaTabLiveResponsedMessage.tabAllLiveInfo;
                    if (this.a.d) {
                        this.a.f.a(pn5Var);
                        AlaLiveTabRecomModel.E(this.a);
                    } else {
                        AlaLiveTabFragment.i++;
                        if (this.a.f != null) {
                            this.a.f.b();
                        }
                        this.a.f = new no5(alaTabLiveResponsedMessage);
                    }
                    AlaLiveTabRecomModel alaLiveTabRecomModel = this.a;
                    alaLiveTabRecomModel.c = alaLiveTabRecomModel.f.h();
                    if (this.a.i != null) {
                        this.a.i.a(this.a.c, this.a.f.d());
                    }
                    hn5Var.a = true;
                }
                hn5Var.b = this.a.d;
                hn5Var.c = alaTabLiveResponsedMessage.superEntranceInfo;
                this.a.I(hn5Var);
                this.a.d = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z, List<jn> list);

        void b(int i, String str, boolean z);
    }

    public AlaLiveTabRecomModel(TbPageContext tbPageContext, b bVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new a(this, AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
        this.a = tbPageContext;
        this.i = bVar;
        this.e = BdUniqueId.gen();
        this.h = i;
    }

    public static /* synthetic */ int E(AlaLiveTabRecomModel alaLiveTabRecomModel) {
        int i = alaLiveTabRecomModel.b;
        alaLiveTabRecomModel.b = i + 1;
        return i;
    }

    public final void I(hn5 hn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hn5Var) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE, hn5Var));
        }
    }

    public final void J(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3) == null) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
            httpMessage.addParam("tab_id", this.h);
            String str = "N";
            if (ji.z()) {
                if (ji.H()) {
                    str = "1_0";
                } else if (ji.v()) {
                    str = "0_13";
                } else if (ji.u()) {
                    str = "0_3";
                } else if (ji.t()) {
                    str = "0_2";
                }
            }
            httpMessage.addParam("network", str);
            httpMessage.addParam("ua_str", li.k(this.a.getPageActivity()) + "_" + li.i(this.a.getPageActivity()) + "_android_" + TbConfig.getVersion());
            httpMessage.addParam("session_id", this.g);
            httpMessage.addParam("refresh_type", i2);
            httpMessage.addParam("big_refresh_count", i3);
            httpMessage.setTag(this.e);
            MessageManager.getInstance().sendMessage(httpMessage);
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
            MessageManager.getInstance().registerListener(this.j);
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
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.c && !this.d) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.g >= FlushManager.ReportTimer.DEFAULT_INTERVAL) {
                this.g = currentTimeMillis;
            }
            this.d = true;
            J(this.b + 1, 1, AlaLiveTabFragment.i - 1);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.j);
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.g = System.currentTimeMillis();
            this.d = false;
            this.b = 1;
            J(1, 0, AlaLiveTabFragment.i);
        }
    }
}
