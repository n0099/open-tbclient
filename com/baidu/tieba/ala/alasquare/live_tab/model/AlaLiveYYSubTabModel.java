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
import com.baidu.tieba.Cdo;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import com.baidu.tieba.bt5;
import com.baidu.tieba.ej;
import com.baidu.tieba.mu5;
import com.baidu.tieba.pt5;
import com.baidu.tieba.vu5;
import com.baidu.tieba.z16;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.AlaLiveInfo;
/* loaded from: classes3.dex */
public class AlaLiveYYSubTabModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public PollingModel b;
    public boolean c;
    public boolean d;
    public BdUniqueId e;
    public mu5 f;
    public long g;
    public int h;
    public int i;
    public String j;
    public String k;
    public int l;
    public c m;
    public HttpMessageListener n;

    /* loaded from: classes3.dex */
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
                if (alaTabLiveResponsedMessage.getError() != 0 || !alaTabLiveResponsedMessage.isSuccess()) {
                    if (this.a.m != null) {
                        this.a.m.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), this.a.d);
                    }
                } else {
                    pt5 pt5Var = alaTabLiveResponsedMessage.tabAllLiveInfo;
                    if (this.a.d) {
                        if (this.a.f != null) {
                            this.a.f.a(pt5Var);
                        }
                    } else {
                        bt5.a(this.a.h);
                        if (this.a.f != null) {
                            this.a.f.b();
                        }
                        AlaLiveYYSubTabModel alaLiveYYSubTabModel = this.a;
                        alaLiveYYSubTabModel.f = new mu5(pt5Var, alaLiveYYSubTabModel.j, this.a.k);
                        this.a.L();
                    }
                    if (this.a.f != null) {
                        AlaLiveYYSubTabModel alaLiveYYSubTabModel2 = this.a;
                        alaLiveYYSubTabModel2.c = alaLiveYYSubTabModel2.f.f();
                    }
                    if (this.a.m != null && this.a.f != null) {
                        this.a.m.a(this.a.c, this.a.f.d());
                    }
                }
                this.a.d = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements PollingModel.b {
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

        @Override // com.baidu.tbadk.core.leveiconlivepolling.PollingModel.b
        public void onSuccess(List<AlaLiveInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.a.L();
                if (this.a.m == null || this.a.f == null) {
                    return;
                }
                this.a.m.a(this.a.c, this.a.f.d());
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(boolean z, List<Cdo> list);

        void b(int i, String str, boolean z);
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
            pollingModel.X(new b(this));
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f == null) {
            return;
        }
        int i = this.i;
        String str = i == 3 ? "ala_sub_tab" : i == 4 ? "ala_sub_list" : "";
        vu5 vu5Var = new vu5();
        vu5Var.a = new z16(this.a.getUniqueId(), TbSingleton.getInstance().getLiveFollowSecondFloor(), str);
        this.f.g(vu5Var);
    }

    public final void M(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
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
            httpMessage.addParam("ua_str", ej.k(this.a.getPageActivity()) + "_" + ej.i(this.a.getPageActivity()) + "_android_" + TbConfig.getVersion());
            httpMessage.addParam("session_id", this.g);
            httpMessage.addParam("refresh_type", i);
            httpMessage.addParam("big_refresh_count", i2);
            httpMessage.addParam("fid", this.j);
            httpMessage.addParam("fname", this.k);
            httpMessage.setTag(this.e);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            mu5 mu5Var = this.f;
            return (mu5Var == null || ListUtils.isEmpty(mu5Var.d())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.c && !this.d) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.g >= this.l * 30 * 1000) {
                this.g = currentTimeMillis;
            }
            this.d = true;
            M(1, bt5.b(this.h) - 1);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
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
                pollingModel.Q(PollingModel.LIVE_FOLLOW_SECOND_FLOOR);
            }
            M(0, bt5.b(this.h));
        }
    }

    public void setForumInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            this.j = str;
            this.k = str2;
        }
    }
}
