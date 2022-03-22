package com.baidu.tieba.ala.alasquare.special_forum.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.o.e.n;
import c.a.p0.c0.f.g.c.c;
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
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes5.dex */
public class SpecialRecommendTabModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f31348b;

    /* renamed from: c  reason: collision with root package name */
    public b f31349c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f31350d;

    /* renamed from: e  reason: collision with root package name */
    public List<ThreadData> f31351e;

    /* renamed from: f  reason: collision with root package name */
    public long f31352f;

    /* renamed from: g  reason: collision with root package name */
    public int f31353g;

    /* renamed from: h  reason: collision with root package name */
    public HttpMessageListener f31354h;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialRecommendTabModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SpecialRecommendTabModel specialRecommendTabModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialRecommendTabModel, Integer.valueOf(i)};
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
                    if (this.a.a == 0) {
                        SpecialLiveFragment.U++;
                        this.a.f31350d.clear();
                        this.a.f31351e.clear();
                    }
                    boolean z = alaSpecialRecommendResponse.hasMore;
                    if (ListUtils.getCount(alaSpecialRecommendResponse.livesList) > 0) {
                        this.a.I(alaSpecialRecommendResponse.livesList);
                    }
                    SpecialRecommendTabModel specialRecommendTabModel = this.a;
                    specialRecommendTabModel.F(specialRecommendTabModel.f31351e);
                    if (this.a.a == 0 && (cVar = alaSpecialRecommendResponse.mSpecialActivityListData) != null) {
                        this.a.G(cVar);
                    }
                    SpecialRecommendTabModel.z(this.a);
                    if (this.a.f31349c != null) {
                        this.a.f31349c.b(this.a.f31350d, z);
                    }
                } else if (this.a.f31349c != null) {
                    this.a.f31349c.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i, String str);

        void b(List<n> list, boolean z);
    }

    public SpecialRecommendTabModel(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 1;
        this.f31353g = 60;
        this.f31354h = new a(this, AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB);
        this.f31348b = tbPageContext;
        this.f31350d = new LinkedList();
        this.f31351e = new ArrayList();
        MessageManager.getInstance().registerListener(this.f31354h);
    }

    public static /* synthetic */ int z(SpecialRecommendTabModel specialRecommendTabModel) {
        int i = specialRecommendTabModel.a;
        specialRecommendTabModel.a = i + 1;
        return i;
    }

    public void F(List<ThreadData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f31350d = new LinkedList();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            c.a.p0.c0.f.h.b.b bVar = new c.a.p0.c0.f.h.b.b();
            c.a.p0.c0.f.a.c cVar = new c.a.p0.c0.f.a.c();
            cVar.f12865d = list.get(i);
            bVar.a = cVar;
            int i2 = i + 1;
            if (i2 < size) {
                c.a.p0.c0.f.a.c cVar2 = new c.a.p0.c0.f.a.c();
                cVar2.f12865d = list.get(i2);
                bVar.f13116b = cVar2;
            }
            this.f31350d.add(bVar);
        }
    }

    public final void G(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || cVar == null || ListUtils.isEmpty(cVar.a)) {
            return;
        }
        if (ListUtils.getCount(this.f31350d) > 2) {
            this.f31350d.add(2, cVar);
        } else {
            this.f31350d.add(cVar);
        }
    }

    public final void H(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3) == null) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB);
            httpMessage.addParam(Config.PACKAGE_NAME, i);
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
            httpMessage.addParam("ua_str", c.a.d.f.p.n.k(this.f31348b.getPageActivity()) + "_" + c.a.d.f.p.n.i(this.f31348b.getPageActivity()) + "_android_" + TbConfig.getVersion());
            httpMessage.addParam("refresh_type", i2);
            httpMessage.addParam("session_id", this.f31352f);
            httpMessage.addParam("big_refresh_count", i3);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void I(List<ThreadData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            for (ThreadData threadData : list) {
                String tid = threadData.getTid();
                if (!TextUtils.isEmpty(tid)) {
                    boolean z = false;
                    Iterator<ThreadData> it = this.f31351e.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (tid.equals(it.next().getTid())) {
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (!z) {
                        this.f31351e.add(threadData);
                    }
                }
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f31352f >= this.f31353g * 30 * 1000) {
                this.f31352f = currentTimeMillis;
            }
            H(this.a, 1, SpecialLiveFragment.U - 1);
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a = 0;
            this.f31352f = System.currentTimeMillis();
            H(0, 0, SpecialLiveFragment.U);
        }
    }

    public void L(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f31349c = bVar;
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
            MessageManager.getInstance().unRegisterListener(this.f31354h);
        }
    }
}
