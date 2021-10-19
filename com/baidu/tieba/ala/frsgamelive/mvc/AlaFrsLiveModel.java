package com.baidu.tieba.ala.frsgamelive.mvc;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.f;
import c.a.e.l.e.n;
import c.a.q0.s.q.d2;
import c.a.r0.w.g.b.c;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.frsgamelive.message.AlaGameFrsLiveThreadsRequestMessage;
import com.baidu.tieba.ala.frsgamelive.message.AlaGameFrsLiveThreadsRespMessage;
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
public class AlaFrsLiveModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FIRST_PN = 1;
    public static final int SORT_TYPE_HOT = 1;
    public static final int SORT_TYPE_NEW = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f49675e;

    /* renamed from: f  reason: collision with root package name */
    public int f49676f;

    /* renamed from: g  reason: collision with root package name */
    public int f49677g;

    /* renamed from: h  reason: collision with root package name */
    public String f49678h;

    /* renamed from: i  reason: collision with root package name */
    public int f49679i;

    /* renamed from: j  reason: collision with root package name */
    public int f49680j;
    public boolean k;
    public int l;
    public List<n> m;
    public boolean n;
    public b o;
    public HttpMessageListener p;

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaFrsLiveModel f49681a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaFrsLiveModel alaFrsLiveModel, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaFrsLiveModel, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49681a = alaFrsLiveModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGameFrsLiveThreadsRespMessage)) {
                AlaGameFrsLiveThreadsRespMessage alaGameFrsLiveThreadsRespMessage = (AlaGameFrsLiveThreadsRespMessage) httpResponsedMessage;
                if (httpResponsedMessage.getOrginalMessage() instanceof AlaGameFrsLiveThreadsRequestMessage) {
                    AlaGameFrsLiveThreadsRequestMessage alaGameFrsLiveThreadsRequestMessage = (AlaGameFrsLiveThreadsRequestMessage) httpResponsedMessage.getOrginalMessage();
                    if (httpResponsedMessage.hasError()) {
                        if (this.f49681a.o != null) {
                            this.f49681a.o.onLoadError(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    List<n> liveList = alaGameFrsLiveThreadsRespMessage.getLiveList();
                    if (this.f49681a.m == null) {
                        this.f49681a.m = new ArrayList();
                    }
                    if (this.f49681a.f49676f != 1 || ListUtils.getCount(liveList) != 0 || this.f49681a.f49680j != 2) {
                        this.f49681a.n = false;
                        this.f49681a.k = alaGameFrsLiveThreadsRespMessage.hasMore();
                        this.f49681a.f49676f = alaGameFrsLiveThreadsRequestMessage.getPn();
                        this.f49681a.l = alaGameFrsLiveThreadsRespMessage.getLiveCount();
                        if (this.f49681a.f49676f == 1 || ListUtils.getCount(this.f49681a.m) == 0) {
                            if (liveList != null) {
                                this.f49681a.m.clear();
                                this.f49681a.m.addAll(liveList);
                            }
                        } else if (ListUtils.getCount(liveList) > 0) {
                            AlaFrsLiveModel alaFrsLiveModel = this.f49681a;
                            alaFrsLiveModel.m = alaFrsLiveModel.L(alaFrsLiveModel.m, liveList);
                        }
                    } else {
                        List<n> recommandList = alaGameFrsLiveThreadsRespMessage.getRecommandList();
                        this.f49681a.k = false;
                        this.f49681a.f49676f = alaGameFrsLiveThreadsRequestMessage.getPn();
                        this.f49681a.l = 0;
                        if (recommandList != null) {
                            this.f49681a.m.clear();
                            this.f49681a.m.addAll(recommandList);
                        }
                        this.f49681a.n = true;
                    }
                    if (this.f49681a.o != null) {
                        this.f49681a.o.a(this.f49681a.k);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(boolean z);

        void onLoadError(int i2, String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaFrsLiveModel(f fVar) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f49676f = 1;
        this.f49677g = 30;
        this.f49679i = 1;
        this.f49680j = 1;
        this.n = false;
        a aVar = new a(this, AlaCmdConfigHttp.CMD_ALA_LIVE_FRS_GAME, true);
        this.p = aVar;
        registerListener(aVar);
    }

    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.l : invokeV.intValue;
    }

    public int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f49679i : invokeV.intValue;
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public final List<n> L(List<n> list, List<n> list2) {
        InterceptResult invokeLL;
        d2 d2Var;
        d2 d2Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, list, list2)) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(list);
            for (n nVar : list2) {
                if (nVar != null && (nVar instanceof c) && (d2Var = ((c) nVar).f26147e) != null && (d2Var.o1() == 49 || d2Var.o1() == 69)) {
                    String s1 = d2Var.s1();
                    if (!TextUtils.isEmpty(s1)) {
                        boolean z = false;
                        Iterator<n> it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            n next = it.next();
                            if (next != null && (next instanceof c) && (d2Var2 = ((c) next).f26147e) != null && s1.equals(d2Var2.s1())) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            linkedList.add(nVar);
                        }
                    }
                }
            }
            return linkedList;
        }
        return (List) invokeLL.objValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.k) {
                AlaGameFrsLiveThreadsRequestMessage alaGameFrsLiveThreadsRequestMessage = new AlaGameFrsLiveThreadsRequestMessage();
                alaGameFrsLiveThreadsRequestMessage.setForumId(this.f49675e);
                alaGameFrsLiveThreadsRequestMessage.setPn(this.f49676f + 1);
                alaGameFrsLiveThreadsRequestMessage.setPs(this.f49677g);
                alaGameFrsLiveThreadsRequestMessage.setForumGameLabel(this.f49678h);
                alaGameFrsLiveThreadsRequestMessage.setSortType(this.f49679i);
                alaGameFrsLiveThreadsRequestMessage.setHttpParams();
                sendMessage(alaGameFrsLiveThreadsRequestMessage);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            AlaGameFrsLiveThreadsRequestMessage alaGameFrsLiveThreadsRequestMessage = new AlaGameFrsLiveThreadsRequestMessage();
            alaGameFrsLiveThreadsRequestMessage.setForumId(this.f49675e);
            alaGameFrsLiveThreadsRequestMessage.setPn(1);
            alaGameFrsLiveThreadsRequestMessage.setPs(this.f49677g);
            alaGameFrsLiveThreadsRequestMessage.setForumGameLabel(this.f49678h);
            alaGameFrsLiveThreadsRequestMessage.setSortType(this.f49679i);
            alaGameFrsLiveThreadsRequestMessage.setHttpParams();
            sendMessage(alaGameFrsLiveThreadsRequestMessage);
        }
    }

    public void O(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f49680j = i2;
        }
    }

    public void P(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.o = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void clearData() {
        List<n> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (list = this.m) == null) {
            return;
        }
        list.clear();
    }

    public List<n> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.m : (List) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setForumGameLabel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f49678h = str;
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.f49675e = str;
        }
    }

    public void setSortType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f49679i = i2;
        }
    }
}
