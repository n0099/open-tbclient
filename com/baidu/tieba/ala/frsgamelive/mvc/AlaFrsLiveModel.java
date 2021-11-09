package com.baidu.tieba.ala.frsgamelive.mvc;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.f;
import b.a.e.l.e.n;
import b.a.q0.s.q.d2;
import b.a.r0.w.g.b.c;
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
/* loaded from: classes9.dex */
public class AlaFrsLiveModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FIRST_PN = 1;
    public static final int SORT_TYPE_HOT = 1;
    public static final int SORT_TYPE_NEW = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f47113e;

    /* renamed from: f  reason: collision with root package name */
    public int f47114f;

    /* renamed from: g  reason: collision with root package name */
    public int f47115g;

    /* renamed from: h  reason: collision with root package name */
    public String f47116h;

    /* renamed from: i  reason: collision with root package name */
    public int f47117i;
    public int j;
    public boolean k;
    public int l;
    public List<n> m;
    public boolean n;
    public b o;
    public HttpMessageListener p;

    /* loaded from: classes9.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaFrsLiveModel f47118a;

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
            this.f47118a = alaFrsLiveModel;
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
                        if (this.f47118a.o != null) {
                            this.f47118a.o.onLoadError(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    List<n> liveList = alaGameFrsLiveThreadsRespMessage.getLiveList();
                    if (this.f47118a.m == null) {
                        this.f47118a.m = new ArrayList();
                    }
                    if (this.f47118a.f47114f != 1 || ListUtils.getCount(liveList) != 0 || this.f47118a.j != 2) {
                        this.f47118a.n = false;
                        this.f47118a.k = alaGameFrsLiveThreadsRespMessage.hasMore();
                        this.f47118a.f47114f = alaGameFrsLiveThreadsRequestMessage.getPn();
                        this.f47118a.l = alaGameFrsLiveThreadsRespMessage.getLiveCount();
                        if (this.f47118a.f47114f == 1 || ListUtils.getCount(this.f47118a.m) == 0) {
                            if (liveList != null) {
                                this.f47118a.m.clear();
                                this.f47118a.m.addAll(liveList);
                            }
                        } else if (ListUtils.getCount(liveList) > 0) {
                            AlaFrsLiveModel alaFrsLiveModel = this.f47118a;
                            alaFrsLiveModel.m = alaFrsLiveModel.L(alaFrsLiveModel.m, liveList);
                        }
                    } else {
                        List<n> recommandList = alaGameFrsLiveThreadsRespMessage.getRecommandList();
                        this.f47118a.k = false;
                        this.f47118a.f47114f = alaGameFrsLiveThreadsRequestMessage.getPn();
                        this.f47118a.l = 0;
                        if (recommandList != null) {
                            this.f47118a.m.clear();
                            this.f47118a.m.addAll(recommandList);
                        }
                        this.f47118a.n = true;
                    }
                    if (this.f47118a.o != null) {
                        this.f47118a.o.a(this.f47118a.k);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
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
        this.f47114f = 1;
        this.f47115g = 30;
        this.f47117i = 1;
        this.j = 1;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f47117i : invokeV.intValue;
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
                if (nVar != null && (nVar instanceof c) && (d2Var = ((c) nVar).f24992e) != null && (d2Var.o1() == 49 || d2Var.o1() == 69)) {
                    String s1 = d2Var.s1();
                    if (!TextUtils.isEmpty(s1)) {
                        boolean z = false;
                        Iterator<n> it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            n next = it.next();
                            if (next != null && (next instanceof c) && (d2Var2 = ((c) next).f24992e) != null && s1.equals(d2Var2.s1())) {
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
                alaGameFrsLiveThreadsRequestMessage.setForumId(this.f47113e);
                alaGameFrsLiveThreadsRequestMessage.setPn(this.f47114f + 1);
                alaGameFrsLiveThreadsRequestMessage.setPs(this.f47115g);
                alaGameFrsLiveThreadsRequestMessage.setForumGameLabel(this.f47116h);
                alaGameFrsLiveThreadsRequestMessage.setSortType(this.f47117i);
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
            alaGameFrsLiveThreadsRequestMessage.setForumId(this.f47113e);
            alaGameFrsLiveThreadsRequestMessage.setPn(1);
            alaGameFrsLiveThreadsRequestMessage.setPs(this.f47115g);
            alaGameFrsLiveThreadsRequestMessage.setForumGameLabel(this.f47116h);
            alaGameFrsLiveThreadsRequestMessage.setSortType(this.f47117i);
            alaGameFrsLiveThreadsRequestMessage.setHttpParams();
            sendMessage(alaGameFrsLiveThreadsRequestMessage);
        }
    }

    public void O(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.j = i2;
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
            this.f47116h = str;
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.f47113e = str;
        }
    }

    public void setSortType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f47117i = i2;
        }
    }
}
