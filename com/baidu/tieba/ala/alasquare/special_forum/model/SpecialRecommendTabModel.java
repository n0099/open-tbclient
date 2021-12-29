package com.baidu.tieba.ala.alasquare.special_forum.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.n.e.n;
import c.a.s0.s.q.d2;
import c.a.t0.a0.f.a.e;
import c.a.t0.a0.f.g.c.c;
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
import com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment;
import com.baidu.tieba.ala.alasquare.special_forum.message.AlaSpecialRecommendResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes12.dex */
public class SpecialRecommendTabModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f43552e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f43553f;

    /* renamed from: g  reason: collision with root package name */
    public b f43554g;

    /* renamed from: h  reason: collision with root package name */
    public List<n> f43555h;

    /* renamed from: i  reason: collision with root package name */
    public List<d2> f43556i;

    /* renamed from: j  reason: collision with root package name */
    public long f43557j;

    /* renamed from: k  reason: collision with root package name */
    public int f43558k;
    public HttpMessageListener l;

    /* loaded from: classes12.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialRecommendTabModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SpecialRecommendTabModel specialRecommendTabModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialRecommendTabModel, Integer.valueOf(i2)};
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
            this.a = specialRecommendTabModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            c cVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021095 && (httpResponsedMessage instanceof AlaSpecialRecommendResponse)) {
                AlaSpecialRecommendResponse alaSpecialRecommendResponse = (AlaSpecialRecommendResponse) httpResponsedMessage;
                if (alaSpecialRecommendResponse.isSuccess()) {
                    if (this.a.f43552e == 0) {
                        SpecialLiveFragment.mRefreshNewCountRecommendTab++;
                        this.a.f43555h.clear();
                        this.a.f43556i.clear();
                    }
                    boolean z = alaSpecialRecommendResponse.hasMore;
                    if (ListUtils.getCount(alaSpecialRecommendResponse.livesList) > 0) {
                        this.a.G(alaSpecialRecommendResponse.livesList);
                    }
                    SpecialRecommendTabModel specialRecommendTabModel = this.a;
                    specialRecommendTabModel.D(specialRecommendTabModel.f43556i);
                    if (this.a.f43552e == 0 && (cVar = alaSpecialRecommendResponse.mSpecialActivityListData) != null) {
                        this.a.E(cVar);
                    }
                    SpecialRecommendTabModel.x(this.a);
                    if (this.a.f43554g != null) {
                        this.a.f43554g.b(this.a.f43555h, z);
                    }
                } else if (this.a.f43554g != null) {
                    this.a.f43554g.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface b {
        void a(int i2, String str);

        void b(List<n> list, boolean z);
    }

    public SpecialRecommendTabModel(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43552e = 1;
        this.f43558k = 60;
        this.l = new a(this, AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB);
        this.f43553f = tbPageContext;
        this.f43555h = new LinkedList();
        this.f43556i = new ArrayList();
        MessageManager.getInstance().registerListener(this.l);
    }

    public static /* synthetic */ int x(SpecialRecommendTabModel specialRecommendTabModel) {
        int i2 = specialRecommendTabModel.f43552e;
        specialRecommendTabModel.f43552e = i2 + 1;
        return i2;
    }

    public void D(List<d2> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f43555h = new LinkedList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            c.a.t0.a0.f.h.b.b bVar = new c.a.t0.a0.f.h.b.b();
            e eVar = new e();
            eVar.f14693h = list.get(i2);
            bVar.f15029e = eVar;
            int i3 = i2 + 1;
            if (i3 < size) {
                e eVar2 = new e();
                eVar2.f14693h = list.get(i3);
                bVar.f15030f = eVar2;
            }
            this.f43555h.add(bVar);
        }
    }

    public final void E(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || cVar == null || ListUtils.isEmpty(cVar.f14969e)) {
            return;
        }
        if (ListUtils.getCount(this.f43555h) > 2) {
            this.f43555h.add(2, cVar);
        } else {
            this.f43555h.add(cVar);
        }
    }

    public final void F(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4) == null) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB);
            httpMessage.addParam("pn", i2);
            httpMessage.addParam("tab_id", 1);
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
            httpMessage.addParam("ua_str", c.a.d.f.p.n.k(this.f43553f.getPageActivity()) + "_" + c.a.d.f.p.n.i(this.f43553f.getPageActivity()) + "_android_" + TbConfig.getVersion());
            httpMessage.addParam("refresh_type", i3);
            httpMessage.addParam("session_id", this.f43557j);
            httpMessage.addParam("big_refresh_count", i4);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void G(List<d2> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            for (d2 d2Var : list) {
                String v1 = d2Var.v1();
                if (!TextUtils.isEmpty(v1)) {
                    boolean z = false;
                    Iterator<d2> it = this.f43556i.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (v1.equals(it.next().v1())) {
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (!z) {
                        this.f43556i.add(d2Var);
                    }
                }
            }
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f43557j >= this.f43558k * 30 * 1000) {
                this.f43557j = currentTimeMillis;
            }
            F(this.f43552e, 1, SpecialLiveFragment.mRefreshNewCountRecommendTab - 1);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f43552e = 0;
            this.f43557j = System.currentTimeMillis();
            F(0, 0, SpecialLiveFragment.mRefreshNewCountRecommendTab);
        }
    }

    public void J(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f43554g = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }
}
