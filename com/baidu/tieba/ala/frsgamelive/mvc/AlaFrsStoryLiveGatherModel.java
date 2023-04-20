package com.baidu.tieba.ala.frsgamelive.mvc;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.a9;
import com.baidu.tieba.ala.frsgamelive.message.AlaFrsStoryLiveGatherRequestMessage;
import com.baidu.tieba.ala.frsgamelive.message.AlaFrsStoryLiveGatherRespMessage;
import com.baidu.tieba.g76;
import com.baidu.tieba.h76;
import com.baidu.tieba.in;
import com.baidu.tieba.u76;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaFrsStoryLiveGatherModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FIRST_PN = 1;
    public static final int SORT_TYPE_HOT = 1;
    public static final int SORT_TYPE_NEW = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public boolean d;
    public int e;
    public boolean f;
    public int g;
    public List<ThreadData> h;
    public List<ThreadData> i;
    public List<in> j;
    public List<in> k;
    public List<in> l;
    public int m;
    public b n;
    public HttpMessageListener o;

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, String str);

        void b(boolean z);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaFrsStoryLiveGatherModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaFrsStoryLiveGatherModel alaFrsStoryLiveGatherModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaFrsStoryLiveGatherModel, Integer.valueOf(i)};
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
            this.a = alaFrsStoryLiveGatherModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || httpResponsedMessage == null || !(httpResponsedMessage instanceof AlaFrsStoryLiveGatherRespMessage)) {
                return;
            }
            AlaFrsStoryLiveGatherRespMessage alaFrsStoryLiveGatherRespMessage = (AlaFrsStoryLiveGatherRespMessage) httpResponsedMessage;
            if (!(httpResponsedMessage.getOrginalMessage() instanceof AlaFrsStoryLiveGatherRequestMessage)) {
                return;
            }
            AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = (AlaFrsStoryLiveGatherRequestMessage) httpResponsedMessage.getOrginalMessage();
            if (httpResponsedMessage.hasError()) {
                if (this.a.n != null) {
                    this.a.n.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                    return;
                }
                return;
            }
            List<ThreadData> liveList = alaFrsStoryLiveGatherRespMessage.getLiveList();
            List<ThreadData> recommandList = alaFrsStoryLiveGatherRespMessage.getRecommandList();
            if (this.a.b != 1 || ListUtils.getCount(liveList) > 10) {
                this.a.m = 0;
                this.a.f = alaFrsStoryLiveGatherRespMessage.hasMore();
                this.a.b = alaFrsStoryLiveGatherRequestMessage.getPn();
                this.a.g = alaFrsStoryLiveGatherRespMessage.getLiveCount();
                if (this.a.b != 1 && ListUtils.getCount(this.a.h) != 0) {
                    if (ListUtils.getCount(liveList) > 0) {
                        AlaFrsStoryLiveGatherModel alaFrsStoryLiveGatherModel = this.a;
                        alaFrsStoryLiveGatherModel.h = alaFrsStoryLiveGatherModel.j0(alaFrsStoryLiveGatherModel.h, liveList);
                    }
                } else {
                    this.a.h = liveList;
                }
            } else {
                this.a.f = false;
                this.a.b = alaFrsStoryLiveGatherRequestMessage.getPn();
                this.a.g = ListUtils.getCount(liveList);
                this.a.h = liveList;
                this.a.i = recommandList;
                this.a.m = 1;
            }
            AlaFrsStoryLiveGatherModel alaFrsStoryLiveGatherModel2 = this.a;
            alaFrsStoryLiveGatherModel2.i0(alaFrsStoryLiveGatherModel2.h, this.a.i);
            if (this.a.n != null) {
                this.a.n.b(this.a.f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaFrsStoryLiveGatherModel(a9 a9Var) {
        super(a9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 1;
        this.c = 30;
        this.e = 1;
        this.m = 1;
        a aVar = new a(this, AlaCmdConfigHttp.CMD_ALA_FRS_STORY_LIVE_GATHER);
        this.o = aVar;
        registerListener(aVar);
    }

    public void n0(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.n = bVar;
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.a = str;
        }
    }

    public void setSortType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.e = i;
        }
    }

    public List<in> d0(List<ThreadData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && !ListUtils.isEmpty(list)) {
                LinkedList linkedList = new LinkedList();
                int size = list.size();
                for (int i = 0; i < size; i += 2) {
                    u76 u76Var = new u76();
                    ThreadData threadData = list.get(i);
                    u76Var.a = threadData;
                    if (threadData.getAuthor() != null) {
                        TiebaStatic.log(new StatisticItem("c12549").param("obj_param1", u76Var.a.getAuthor().getUserId()));
                    }
                    int i2 = i + 1;
                    if (i2 < size) {
                        ThreadData threadData2 = list.get(i2);
                        u76Var.b = threadData2;
                        if (threadData2.getAuthor() != null) {
                            TiebaStatic.log(new StatisticItem("c12549").param("obj_param1", u76Var.b.getAuthor().getUserId()));
                        }
                    }
                    linkedList.add(u76Var);
                }
                return linkedList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public List<in> e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.l;
        }
        return (List) invokeV.objValue;
    }

    public int f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public List<ThreadData> g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.h;
        }
        return (List) invokeV.objValue;
    }

    public int h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public final void i0(List<ThreadData> list, List<ThreadData> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, list2) == null) {
            this.j = d0(list);
            this.k = d0(list2);
            if (ListUtils.getCount(this.j) == 0 && ListUtils.getCount(this.k) == 0) {
                return;
            }
            List<in> list3 = this.l;
            if (list3 == null) {
                this.l = new ArrayList();
            } else {
                list3.clear();
            }
            List<in> list4 = this.j;
            if (list4 != null && list4.size() != 0) {
                this.l.addAll(this.j);
                this.d = true;
            } else {
                this.l.add(new g76());
                this.d = false;
            }
            if (ListUtils.getCount(this.k) > 0 && !this.f) {
                this.l.add(new h76());
                for (int i = 0; i < 3 && i < ListUtils.getCount(this.k); i++) {
                    if (this.k.get(i) != null) {
                        this.l.add(this.k.get(i));
                    }
                }
            }
        }
    }

    public final List<ThreadData> j0(List<ThreadData> list, List<ThreadData> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, list, list2)) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(list);
            for (ThreadData threadData : list2) {
                if (threadData != null && (threadData.getThreadType() == 49 || threadData.getThreadType() == 69)) {
                    String tid = threadData.getTid();
                    if (!TextUtils.isEmpty(tid)) {
                        boolean z = false;
                        Iterator<ThreadData> it = list.iterator();
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
                            linkedList.add(threadData);
                        }
                    }
                }
            }
            return linkedList;
        }
        return (List) invokeLL.objValue;
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!this.f) {
                return false;
            }
            AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = new AlaFrsStoryLiveGatherRequestMessage();
            alaFrsStoryLiveGatherRequestMessage.setForumId(this.a);
            alaFrsStoryLiveGatherRequestMessage.setPn(this.b + 1);
            alaFrsStoryLiveGatherRequestMessage.setPs(this.c);
            alaFrsStoryLiveGatherRequestMessage.setSortType(this.e);
            alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.m);
            alaFrsStoryLiveGatherRequestMessage.setHttpParams();
            sendMessage(alaFrsStoryLiveGatherRequestMessage);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = new AlaFrsStoryLiveGatherRequestMessage();
            alaFrsStoryLiveGatherRequestMessage.setForumId(this.a);
            alaFrsStoryLiveGatherRequestMessage.setPn(1);
            alaFrsStoryLiveGatherRequestMessage.setPs(this.c);
            alaFrsStoryLiveGatherRequestMessage.setSortType(this.e);
            alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.m);
            alaFrsStoryLiveGatherRequestMessage.setHttpParams();
            sendMessage(alaFrsStoryLiveGatherRequestMessage);
        }
    }
}
