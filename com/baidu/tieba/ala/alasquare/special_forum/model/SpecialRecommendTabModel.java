package com.baidu.tieba.ala.alasquare.special_forum.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
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
import d.a.d.e.p.j;
import d.a.d.e.p.l;
import d.a.d.k.e.n;
import d.a.p0.s.q.b2;
import d.a.q0.v.d.f.c.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class SpecialRecommendTabModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f14145e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f14146f;

    /* renamed from: g  reason: collision with root package name */
    public b f14147g;

    /* renamed from: h  reason: collision with root package name */
    public List<n> f14148h;

    /* renamed from: i  reason: collision with root package name */
    public List<b2> f14149i;
    public long j;
    public int k;
    public HttpMessageListener l;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialRecommendTabModel f14150a;

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
            this.f14150a = specialRecommendTabModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            c cVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021095 && (httpResponsedMessage instanceof AlaSpecialRecommendResponse)) {
                AlaSpecialRecommendResponse alaSpecialRecommendResponse = (AlaSpecialRecommendResponse) httpResponsedMessage;
                if (alaSpecialRecommendResponse.isSuccess()) {
                    if (this.f14150a.f14145e == 0) {
                        SpecialLiveFragment.Y++;
                        this.f14150a.f14148h.clear();
                        this.f14150a.f14149i.clear();
                    }
                    boolean z = alaSpecialRecommendResponse.hasMore;
                    if (ListUtils.getCount(alaSpecialRecommendResponse.livesList) > 0) {
                        this.f14150a.G(alaSpecialRecommendResponse.livesList);
                    }
                    SpecialRecommendTabModel specialRecommendTabModel = this.f14150a;
                    specialRecommendTabModel.D(specialRecommendTabModel.f14149i);
                    if (this.f14150a.f14145e == 0 && (cVar = alaSpecialRecommendResponse.mSpecialActivityListData) != null) {
                        this.f14150a.E(cVar);
                    }
                    SpecialRecommendTabModel.x(this.f14150a);
                    if (this.f14150a.f14147g != null) {
                        this.f14150a.f14147g.b(this.f14150a.f14148h, z);
                    }
                } else if (this.f14150a.f14147g != null) {
                    this.f14150a.f14147g.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
        this.f14145e = 1;
        this.k = 60;
        this.l = new a(this, AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB);
        this.f14146f = tbPageContext;
        this.f14148h = new LinkedList();
        this.f14149i = new ArrayList();
        MessageManager.getInstance().registerListener(this.l);
    }

    public static /* synthetic */ int x(SpecialRecommendTabModel specialRecommendTabModel) {
        int i2 = specialRecommendTabModel.f14145e;
        specialRecommendTabModel.f14145e = i2 + 1;
        return i2;
    }

    public void D(List<b2> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f14148h = new LinkedList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            d.a.q0.v.d.g.b.b bVar = new d.a.q0.v.d.g.b.b();
            d.a.q0.v.d.a.c cVar = new d.a.q0.v.d.a.c();
            cVar.f64863h = list.get(i2);
            bVar.f65232e = cVar;
            int i3 = i2 + 1;
            if (i3 < size) {
                d.a.q0.v.d.a.c cVar2 = new d.a.q0.v.d.a.c();
                cVar2.f64863h = list.get(i3);
                bVar.f65233f = cVar2;
            }
            this.f14148h.add(bVar);
        }
    }

    public final void E(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || cVar == null || ListUtils.isEmpty(cVar.f65164e)) {
            return;
        }
        if (ListUtils.getCount(this.f14148h) > 2) {
            this.f14148h.add(2, cVar);
        } else {
            this.f14148h.add(cVar);
        }
    }

    public final void F(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4) == null) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB);
            httpMessage.addParam(Config.PACKAGE_NAME, i2);
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
            httpMessage.addParam("ua_str", l.k(this.f14146f.getPageActivity()) + "_" + l.i(this.f14146f.getPageActivity()) + "_android_" + TbConfig.getVersion());
            httpMessage.addParam("refresh_type", i3);
            httpMessage.addParam("session_id", this.j);
            httpMessage.addParam("big_refresh_count", i4);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void G(List<b2> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            for (b2 b2Var : list) {
                String o1 = b2Var.o1();
                if (!TextUtils.isEmpty(o1)) {
                    boolean z = false;
                    Iterator<b2> it = this.f14149i.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (o1.equals(it.next().o1())) {
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (!z) {
                        this.f14149i.add(b2Var);
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
            F(this.f14145e, 1, SpecialLiveFragment.Y - 1);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f14145e = 0;
            this.j = System.currentTimeMillis();
            F(0, 0, SpecialLiveFragment.Y);
        }
    }

    public void J(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f14147g = bVar;
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
