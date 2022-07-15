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
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bp5;
import com.repackage.mq5;
import com.repackage.ni;
import com.repackage.nn;
import com.repackage.pi;
import com.repackage.pp5;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaLiveYYSubTabModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public boolean b;
    public boolean c;
    public BdUniqueId d;
    public mq5 e;
    public long f;
    public int g;
    public String h;
    public String i;
    public int j;
    public b k;
    public HttpMessageListener l;

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
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021141 && (httpResponsedMessage instanceof AlaTabLiveResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == this.a.d) {
                AlaTabLiveResponsedMessage alaTabLiveResponsedMessage = (AlaTabLiveResponsedMessage) httpResponsedMessage;
                if (alaTabLiveResponsedMessage.getError() != 0 || !alaTabLiveResponsedMessage.isSuccess()) {
                    if (this.a.k != null) {
                        this.a.k.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), this.a.c);
                    }
                } else {
                    pp5 pp5Var = alaTabLiveResponsedMessage.tabAllLiveInfo;
                    if (this.a.c) {
                        this.a.e.a(pp5Var);
                    } else {
                        bp5.a(this.a.g);
                        if (this.a.e != null) {
                            this.a.e.b();
                        }
                        AlaLiveYYSubTabModel alaLiveYYSubTabModel = this.a;
                        alaLiveYYSubTabModel.e = new mq5(pp5Var, alaLiveYYSubTabModel.h, this.a.i);
                    }
                    AlaLiveYYSubTabModel alaLiveYYSubTabModel2 = this.a;
                    alaLiveYYSubTabModel2.b = alaLiveYYSubTabModel2.e.f();
                    if (this.a.k != null) {
                        this.a.k.a(this.a.b, this.a.e.d());
                    }
                }
                this.a.c = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z, List<nn> list);

        void b(int i, String str, boolean z);
    }

    public AlaLiveYYSubTabModel(TbPageContext tbPageContext, b bVar, int i) {
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
        this.j = 60;
        this.l = new a(this, AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
        this.a = tbPageContext;
        this.k = bVar;
        this.d = BdUniqueId.gen();
        this.g = i;
    }

    public final void L(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
            httpMessage.addParam("tab_id", this.g);
            String str = "N";
            if (ni.z()) {
                if (ni.H()) {
                    str = "1_0";
                } else if (ni.v()) {
                    str = "0_13";
                } else if (ni.u()) {
                    str = "0_3";
                } else if (ni.t()) {
                    str = "0_2";
                }
            }
            httpMessage.addParam("network", str);
            httpMessage.addParam("ua_str", pi.k(this.a.getPageActivity()) + "_" + pi.i(this.a.getPageActivity()) + "_android_" + TbConfig.getVersion());
            httpMessage.addParam("session_id", this.f);
            httpMessage.addParam("refresh_type", i);
            httpMessage.addParam("big_refresh_count", i2);
            httpMessage.addParam("fid", this.h);
            httpMessage.addParam("fname", this.i);
            httpMessage.setTag(this.d);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.b && !this.c) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f >= this.j * 30 * 1000) {
                this.f = currentTimeMillis;
            }
            this.c = true;
            L(1, bp5.b(this.g) - 1);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            mq5 mq5Var = this.e;
            return (mq5Var == null || ListUtils.isEmpty(mq5Var.d())) ? false : true;
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
            MessageManager.getInstance().registerListener(this.l);
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

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f = System.currentTimeMillis();
            this.c = false;
            L(0, bp5.b(this.g));
        }
    }

    public void setForumInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            this.h = str;
            this.i = str2;
        }
    }
}
