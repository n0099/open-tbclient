package com.baidu.tieba.ala.alasquare.live_tab.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import com.baidu.tieba.bb6;
import com.baidu.tieba.ic6;
import com.baidu.tieba.io6;
import com.baidu.tieba.na6;
import com.baidu.tieba.vi;
import com.baidu.tieba.vn;
import com.baidu.tieba.yb6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.AlaLiveInfo;
/* loaded from: classes5.dex */
public class AlaLiveYYSubTabModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public PollingModel b;
    public boolean c;
    public boolean d;
    public BdUniqueId e;
    public yb6 f;
    public long g;
    public int h;
    public int i;
    public String j;
    public String k;
    public int l;
    public c m;
    public HttpMessageListener n;

    /* loaded from: classes5.dex */
    public interface c {
        void a(boolean z, List<vn> list);

        void b(int i, String str, boolean z);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveYYSubTabModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaLiveYYSubTabModel alaLiveYYSubTabModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveYYSubTabModel, Integer.valueOf(i)};
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
            this.a = alaLiveYYSubTabModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021141 && (httpResponsedMessage instanceof AlaTabLiveResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == this.a.e) {
                AlaTabLiveResponsedMessage alaTabLiveResponsedMessage = (AlaTabLiveResponsedMessage) httpResponsedMessage;
                if (alaTabLiveResponsedMessage.getError() == 0 && alaTabLiveResponsedMessage.isSuccess()) {
                    bb6 bb6Var = alaTabLiveResponsedMessage.tabAllLiveInfo;
                    if (this.a.d) {
                        if (this.a.f != null) {
                            this.a.f.a(bb6Var);
                        }
                    } else {
                        na6.a(this.a.h);
                        if (this.a.f != null) {
                            this.a.f.b();
                        }
                        AlaLiveYYSubTabModel alaLiveYYSubTabModel = this.a;
                        alaLiveYYSubTabModel.f = new yb6(bb6Var, alaLiveYYSubTabModel.j, this.a.k);
                        this.a.g0();
                    }
                    if (this.a.f != null) {
                        AlaLiveYYSubTabModel alaLiveYYSubTabModel2 = this.a;
                        alaLiveYYSubTabModel2.c = alaLiveYYSubTabModel2.f.f();
                    }
                    if (this.a.m != null && this.a.f != null) {
                        this.a.m.a(this.a.c, this.a.f.d());
                    }
                } else if (this.a.m != null) {
                    this.a.m.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), this.a.d);
                }
                this.a.d = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements PollingModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveYYSubTabModel a;

        public b(AlaLiveYYSubTabModel alaLiveYYSubTabModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveYYSubTabModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaLiveYYSubTabModel;
        }

        @Override // com.baidu.tbadk.core.leveiconlivepolling.PollingModel.d
        public void onSuccess(List<AlaLiveInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.a.g0();
                if (this.a.m != null && this.a.f != null) {
                    this.a.m.a(this.a.c, this.a.f.d());
                }
            }
        }
    }

    public AlaLiveYYSubTabModel(TbPageContext tbPageContext, c cVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cVar, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 60;
        this.n = new a(this, AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
        this.a = tbPageContext;
        this.m = cVar;
        this.e = BdUniqueId.gen();
        this.h = i;
        this.i = i2;
        if (this.b == null) {
            PollingModel pollingModel = new PollingModel(tbPageContext, tbPageContext.getUniqueId());
            this.b = pollingModel;
            pollingModel.P0(new b(this));
        }
    }

    public void setForumInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            this.j = str;
            this.k = str2;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c && !this.d) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.g >= this.l * 30 * 1000) {
                this.g = currentTimeMillis;
            }
            this.d = true;
            h0(1, na6.b(this.h) - 1);
        }
    }

    public final void g0() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.f == null) {
            return;
        }
        int i = this.i;
        if (i == 3) {
            str = "ala_sub_tab";
        } else if (i == 4) {
            str = "ala_sub_list";
        } else {
            str = "";
        }
        ic6 ic6Var = new ic6();
        ic6Var.a = new io6(this.a.getUniqueId(), TbSingleton.getInstance().getLiveFollowSecondFloor(), str);
        this.f.g(ic6Var);
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            yb6 yb6Var = this.f;
            if (yb6Var != null && !ListUtils.isEmpty(yb6Var.d())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().registerListener(this.n);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            PollingModel pollingModel = this.b;
            if (pollingModel != null) {
                pollingModel.onDestroy();
            }
            MessageManager.getInstance().unRegisterListener(this.n);
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.g = System.currentTimeMillis();
            this.d = false;
            PollingModel pollingModel = this.b;
            if (pollingModel != null) {
                pollingModel.C0(PollingModel.LIVE_FOLLOW_SECOND_FLOOR);
            }
            h0(0, na6.b(this.h));
        }
    }

    public final void h0(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
            httpMessage.addParam("tab_id", this.h);
            String str = "N";
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                if (BdNetTypeUtil.isWifiNet()) {
                    str = "1_0";
                } else if (BdNetTypeUtil.is4GNet()) {
                    str = "0_13";
                } else if (BdNetTypeUtil.is3GNet()) {
                    str = "0_3";
                } else if (BdNetTypeUtil.is2GNet()) {
                    str = "0_2";
                }
            }
            httpMessage.addParam("network", str);
            httpMessage.addParam("ua_str", vi.l(this.a.getPageActivity()) + "_" + vi.j(this.a.getPageActivity()) + "_android_" + TbConfig.getVersion());
            httpMessage.addParam("session_id", this.g);
            httpMessage.addParam("refresh_type", i);
            httpMessage.addParam("big_refresh_count", i2);
            httpMessage.addParam("fid", this.j);
            httpMessage.addParam("fname", this.k);
            httpMessage.setTag(this.e);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
