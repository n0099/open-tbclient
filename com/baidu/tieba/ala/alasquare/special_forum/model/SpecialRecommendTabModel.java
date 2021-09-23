package com.baidu.tieba.ala.alasquare.special_forum.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.q0.s.q.d2;
import c.a.r0.v.f.g.c.c;
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
/* loaded from: classes7.dex */
public class SpecialRecommendTabModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f49648e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f49649f;

    /* renamed from: g  reason: collision with root package name */
    public b f49650g;

    /* renamed from: h  reason: collision with root package name */
    public List<n> f49651h;

    /* renamed from: i  reason: collision with root package name */
    public List<d2> f49652i;

    /* renamed from: j  reason: collision with root package name */
    public long f49653j;
    public int k;
    public HttpMessageListener l;

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialRecommendTabModel f49654a;

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
            this.f49654a = specialRecommendTabModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            c cVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021095 && (httpResponsedMessage instanceof AlaSpecialRecommendResponse)) {
                AlaSpecialRecommendResponse alaSpecialRecommendResponse = (AlaSpecialRecommendResponse) httpResponsedMessage;
                if (alaSpecialRecommendResponse.isSuccess()) {
                    if (this.f49654a.f49648e == 0) {
                        SpecialLiveFragment.mRefreshNewCountRecommendTab++;
                        this.f49654a.f49651h.clear();
                        this.f49654a.f49652i.clear();
                    }
                    boolean z = alaSpecialRecommendResponse.hasMore;
                    if (ListUtils.getCount(alaSpecialRecommendResponse.livesList) > 0) {
                        this.f49654a.G(alaSpecialRecommendResponse.livesList);
                    }
                    SpecialRecommendTabModel specialRecommendTabModel = this.f49654a;
                    specialRecommendTabModel.D(specialRecommendTabModel.f49652i);
                    if (this.f49654a.f49648e == 0 && (cVar = alaSpecialRecommendResponse.mSpecialActivityListData) != null) {
                        this.f49654a.E(cVar);
                    }
                    SpecialRecommendTabModel.x(this.f49654a);
                    if (this.f49654a.f49650g != null) {
                        this.f49654a.f49650g.b(this.f49654a.f49651h, z);
                    }
                } else if (this.f49654a.f49650g != null) {
                    this.f49654a.f49650g.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
        this.f49648e = 1;
        this.k = 60;
        this.l = new a(this, AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB);
        this.f49649f = tbPageContext;
        this.f49651h = new LinkedList();
        this.f49652i = new ArrayList();
        MessageManager.getInstance().registerListener(this.l);
    }

    public static /* synthetic */ int x(SpecialRecommendTabModel specialRecommendTabModel) {
        int i2 = specialRecommendTabModel.f49648e;
        specialRecommendTabModel.f49648e = i2 + 1;
        return i2;
    }

    public void D(List<d2> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f49651h = new LinkedList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            c.a.r0.v.f.h.b.b bVar = new c.a.r0.v.f.h.b.b();
            c.a.r0.v.f.a.c cVar = new c.a.r0.v.f.a.c();
            cVar.f25492h = list.get(i2);
            bVar.f25884e = cVar;
            int i3 = i2 + 1;
            if (i3 < size) {
                c.a.r0.v.f.a.c cVar2 = new c.a.r0.v.f.a.c();
                cVar2.f25492h = list.get(i3);
                bVar.f25885f = cVar2;
            }
            this.f49651h.add(bVar);
        }
    }

    public final void E(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || cVar == null || ListUtils.isEmpty(cVar.f25813e)) {
            return;
        }
        if (ListUtils.getCount(this.f49651h) > 2) {
            this.f49651h.add(2, cVar);
        } else {
            this.f49651h.add(cVar);
        }
    }

    public final void F(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4) == null) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB);
            httpMessage.addParam("pn", i2);
            httpMessage.addParam("tab_id", 1);
            String str = "N";
            if (j.z()) {
                if (j.H()) {
                    str = "1_0";
                } else if (j.v()) {
                    str = "0_13";
                } else if (j.u()) {
                    str = "0_3";
                } else if (j.t()) {
                    str = "0_2";
                }
            }
            httpMessage.addParam("network", str);
            httpMessage.addParam("ua_str", l.k(this.f49649f.getPageActivity()) + "_" + l.i(this.f49649f.getPageActivity()) + "_android_" + TbConfig.getVersion());
            httpMessage.addParam("refresh_type", i3);
            httpMessage.addParam("session_id", this.f49653j);
            httpMessage.addParam("big_refresh_count", i4);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void G(List<d2> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            for (d2 d2Var : list) {
                String s1 = d2Var.s1();
                if (!TextUtils.isEmpty(s1)) {
                    boolean z = false;
                    Iterator<d2> it = this.f49652i.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (s1.equals(it.next().s1())) {
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (!z) {
                        this.f49652i.add(d2Var);
                    }
                }
            }
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f49653j >= this.k * 30 * 1000) {
                this.f49653j = currentTimeMillis;
            }
            F(this.f49648e, 1, SpecialLiveFragment.mRefreshNewCountRecommendTab - 1);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f49648e = 0;
            this.f49653j = System.currentTimeMillis();
            F(0, 0, SpecialLiveFragment.mRefreshNewCountRecommendTab);
        }
    }

    public void J(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f49650g = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
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
