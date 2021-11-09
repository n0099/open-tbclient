package com.baidu.tieba.ala.alasquare.special_forum.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.j;
import b.a.e.e.p.l;
import b.a.e.l.e.n;
import b.a.q0.s.q.d2;
import b.a.r0.w.f.a.e;
import b.a.r0.w.f.g.c.c;
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
/* loaded from: classes9.dex */
public class SpecialRecommendTabModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f47022e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f47023f;

    /* renamed from: g  reason: collision with root package name */
    public b f47024g;

    /* renamed from: h  reason: collision with root package name */
    public List<n> f47025h;

    /* renamed from: i  reason: collision with root package name */
    public List<d2> f47026i;
    public long j;
    public int k;
    public HttpMessageListener l;

    /* loaded from: classes9.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialRecommendTabModel f47027a;

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
            this.f47027a = specialRecommendTabModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            c cVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021095 && (httpResponsedMessage instanceof AlaSpecialRecommendResponse)) {
                AlaSpecialRecommendResponse alaSpecialRecommendResponse = (AlaSpecialRecommendResponse) httpResponsedMessage;
                if (alaSpecialRecommendResponse.isSuccess()) {
                    if (this.f47027a.f47022e == 0) {
                        SpecialLiveFragment.mRefreshNewCountRecommendTab++;
                        this.f47027a.f47025h.clear();
                        this.f47027a.f47026i.clear();
                    }
                    boolean z = alaSpecialRecommendResponse.hasMore;
                    if (ListUtils.getCount(alaSpecialRecommendResponse.livesList) > 0) {
                        this.f47027a.G(alaSpecialRecommendResponse.livesList);
                    }
                    SpecialRecommendTabModel specialRecommendTabModel = this.f47027a;
                    specialRecommendTabModel.D(specialRecommendTabModel.f47026i);
                    if (this.f47027a.f47022e == 0 && (cVar = alaSpecialRecommendResponse.mSpecialActivityListData) != null) {
                        this.f47027a.E(cVar);
                    }
                    SpecialRecommendTabModel.x(this.f47027a);
                    if (this.f47027a.f47024g != null) {
                        this.f47027a.f47024g.b(this.f47027a.f47025h, z);
                    }
                } else if (this.f47027a.f47024g != null) {
                    this.f47027a.f47024g.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
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
        this.f47022e = 1;
        this.k = 60;
        this.l = new a(this, AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB);
        this.f47023f = tbPageContext;
        this.f47025h = new LinkedList();
        this.f47026i = new ArrayList();
        MessageManager.getInstance().registerListener(this.l);
    }

    public static /* synthetic */ int x(SpecialRecommendTabModel specialRecommendTabModel) {
        int i2 = specialRecommendTabModel.f47022e;
        specialRecommendTabModel.f47022e = i2 + 1;
        return i2;
    }

    public void D(List<d2> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f47025h = new LinkedList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            b.a.r0.w.f.h.b.b bVar = new b.a.r0.w.f.h.b.b();
            e eVar = new e();
            eVar.f24510h = list.get(i2);
            bVar.f24892e = eVar;
            int i3 = i2 + 1;
            if (i3 < size) {
                e eVar2 = new e();
                eVar2.f24510h = list.get(i3);
                bVar.f24893f = eVar2;
            }
            this.f47025h.add(bVar);
        }
    }

    public final void E(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || cVar == null || ListUtils.isEmpty(cVar.f24824e)) {
            return;
        }
        if (ListUtils.getCount(this.f47025h) > 2) {
            this.f47025h.add(2, cVar);
        } else {
            this.f47025h.add(cVar);
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
            httpMessage.addParam("ua_str", l.k(this.f47023f.getPageActivity()) + "_" + l.i(this.f47023f.getPageActivity()) + "_android_" + TbConfig.getVersion());
            httpMessage.addParam("refresh_type", i3);
            httpMessage.addParam("session_id", this.j);
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
                    Iterator<d2> it = this.f47026i.iterator();
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
                        this.f47026i.add(d2Var);
                    }
                }
            }
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.j >= this.k * 30 * 1000) {
                this.j = currentTimeMillis;
            }
            F(this.f47022e, 1, SpecialLiveFragment.mRefreshNewCountRecommendTab - 1);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f47022e = 0;
            this.j = System.currentTimeMillis();
            F(0, 0, SpecialLiveFragment.mRefreshNewCountRecommendTab);
        }
    }

    public void J(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f47024g = bVar;
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
