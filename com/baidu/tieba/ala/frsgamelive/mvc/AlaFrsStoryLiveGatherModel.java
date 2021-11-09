package com.baidu.tieba.ala.frsgamelive.mvc;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.f;
import b.a.e.l.e.n;
import b.a.q0.s.q.d2;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.frsgamelive.message.AlaFrsStoryLiveGatherRequestMessage;
import com.baidu.tieba.ala.frsgamelive.message.AlaFrsStoryLiveGatherRespMessage;
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
public class AlaFrsStoryLiveGatherModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FIRST_PN = 1;
    public static final int SORT_TYPE_HOT = 1;
    public static final int SORT_TYPE_NEW = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f47126e;

    /* renamed from: f  reason: collision with root package name */
    public int f47127f;

    /* renamed from: g  reason: collision with root package name */
    public int f47128g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f47129h;

    /* renamed from: i  reason: collision with root package name */
    public int f47130i;
    public boolean j;
    public int k;
    public List<d2> l;
    public List<d2> m;
    public List<n> n;
    public List<n> o;
    public List<n> p;
    public int q;
    public b r;
    public HttpMessageListener s;

    /* loaded from: classes9.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaFrsStoryLiveGatherModel f47131a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaFrsStoryLiveGatherModel alaFrsStoryLiveGatherModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaFrsStoryLiveGatherModel, Integer.valueOf(i2)};
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
            this.f47131a = alaFrsStoryLiveGatherModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage instanceof AlaFrsStoryLiveGatherRespMessage)) {
                AlaFrsStoryLiveGatherRespMessage alaFrsStoryLiveGatherRespMessage = (AlaFrsStoryLiveGatherRespMessage) httpResponsedMessage;
                if (httpResponsedMessage.getOrginalMessage() instanceof AlaFrsStoryLiveGatherRequestMessage) {
                    AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = (AlaFrsStoryLiveGatherRequestMessage) httpResponsedMessage.getOrginalMessage();
                    if (httpResponsedMessage.hasError()) {
                        if (this.f47131a.r != null) {
                            this.f47131a.r.onLoadError(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    List<d2> liveList = alaFrsStoryLiveGatherRespMessage.getLiveList();
                    List<d2> recommandList = alaFrsStoryLiveGatherRespMessage.getRecommandList();
                    if (this.f47131a.f47127f != 1 || ListUtils.getCount(liveList) > 10) {
                        this.f47131a.q = 0;
                        this.f47131a.j = alaFrsStoryLiveGatherRespMessage.hasMore();
                        this.f47131a.f47127f = alaFrsStoryLiveGatherRequestMessage.getPn();
                        this.f47131a.k = alaFrsStoryLiveGatherRespMessage.getLiveCount();
                        if (this.f47131a.f47127f == 1 || ListUtils.getCount(this.f47131a.l) == 0) {
                            this.f47131a.l = liveList;
                        } else if (ListUtils.getCount(liveList) > 0) {
                            AlaFrsStoryLiveGatherModel alaFrsStoryLiveGatherModel = this.f47131a;
                            alaFrsStoryLiveGatherModel.l = alaFrsStoryLiveGatherModel.P(alaFrsStoryLiveGatherModel.l, liveList);
                        }
                    } else {
                        this.f47131a.j = false;
                        this.f47131a.f47127f = alaFrsStoryLiveGatherRequestMessage.getPn();
                        this.f47131a.k = ListUtils.getCount(liveList);
                        this.f47131a.l = liveList;
                        this.f47131a.m = recommandList;
                        this.f47131a.q = 1;
                    }
                    AlaFrsStoryLiveGatherModel alaFrsStoryLiveGatherModel2 = this.f47131a;
                    alaFrsStoryLiveGatherModel2.O(alaFrsStoryLiveGatherModel2.l, this.f47131a.m);
                    if (this.f47131a.r != null) {
                        this.f47131a.r.a(this.f47131a.j);
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
    public AlaFrsStoryLiveGatherModel(f fVar) {
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
        this.f47127f = 1;
        this.f47128g = 30;
        this.f47130i = 1;
        this.q = 1;
        a aVar = new a(this, AlaCmdConfigHttp.CMD_ALA_FRS_STORY_LIVE_GATHER);
        this.s = aVar;
        registerListener(aVar);
    }

    public List<n> J(List<d2> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list == null || ListUtils.isEmpty(list)) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2 += 2) {
                b.a.r0.w.j.b.a aVar = new b.a.r0.w.j.b.a();
                d2 d2Var = list.get(i2);
                aVar.f25087e = d2Var;
                if (d2Var.J() != null) {
                    TiebaStatic.log(new StatisticItem("c12549").param("obj_param1", aVar.f25087e.J().getUserId()));
                }
                int i3 = i2 + 1;
                if (i3 < size) {
                    d2 d2Var2 = list.get(i3);
                    aVar.f25088f = d2Var2;
                    if (d2Var2.J() != null) {
                        TiebaStatic.log(new StatisticItem("c12549").param("obj_param1", aVar.f25088f.J().getUserId()));
                    }
                }
                linkedList.add(aVar);
            }
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    public List<n> K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.p : (List) invokeV.objValue;
    }

    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : invokeV.intValue;
    }

    public List<d2> M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l : (List) invokeV.objValue;
    }

    public int N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f47130i : invokeV.intValue;
    }

    public final void O(List<d2> list, List<d2> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, list, list2) == null) {
            this.n = J(list);
            this.o = J(list2);
            if (ListUtils.getCount(this.n) == 0 && ListUtils.getCount(this.o) == 0) {
                return;
            }
            List<n> list3 = this.p;
            if (list3 == null) {
                this.p = new ArrayList();
            } else {
                list3.clear();
            }
            List<n> list4 = this.n;
            if (list4 != null && list4.size() != 0) {
                this.p.addAll(this.n);
                this.f47129h = true;
            } else {
                this.p.add(new b.a.r0.w.g.b.a());
                this.f47129h = false;
            }
            if (ListUtils.getCount(this.o) <= 0 || this.j) {
                return;
            }
            this.p.add(new b.a.r0.w.g.b.b());
            for (int i2 = 0; i2 < 3 && i2 < ListUtils.getCount(this.o); i2++) {
                if (this.o.get(i2) != null) {
                    this.p.add(this.o.get(i2));
                }
            }
        }
    }

    public final List<d2> P(List<d2> list, List<d2> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, list, list2)) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(list);
            for (d2 d2Var : list2) {
                if (d2Var != null && (d2Var.o1() == 49 || d2Var.o1() == 69)) {
                    String s1 = d2Var.s1();
                    if (!TextUtils.isEmpty(s1)) {
                        boolean z = false;
                        Iterator<d2> it = list.iterator();
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
                            linkedList.add(d2Var);
                        }
                    }
                }
            }
            return linkedList;
        }
        return (List) invokeLL.objValue;
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f47129h : invokeV.booleanValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j) {
                AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = new AlaFrsStoryLiveGatherRequestMessage();
                alaFrsStoryLiveGatherRequestMessage.setForumId(this.f47126e);
                alaFrsStoryLiveGatherRequestMessage.setPn(this.f47127f + 1);
                alaFrsStoryLiveGatherRequestMessage.setPs(this.f47128g);
                alaFrsStoryLiveGatherRequestMessage.setSortType(this.f47130i);
                alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.q);
                alaFrsStoryLiveGatherRequestMessage.setHttpParams();
                sendMessage(alaFrsStoryLiveGatherRequestMessage);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = new AlaFrsStoryLiveGatherRequestMessage();
            alaFrsStoryLiveGatherRequestMessage.setForumId(this.f47126e);
            alaFrsStoryLiveGatherRequestMessage.setPn(1);
            alaFrsStoryLiveGatherRequestMessage.setPs(this.f47128g);
            alaFrsStoryLiveGatherRequestMessage.setSortType(this.f47130i);
            alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.q);
            alaFrsStoryLiveGatherRequestMessage.setHttpParams();
            sendMessage(alaFrsStoryLiveGatherRequestMessage);
        }
    }

    public void T(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.r = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
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

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f47126e = str;
        }
    }

    public void setSortType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f47130i = i2;
        }
    }
}
