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
import com.baidu.tieba.ala.frsgamelive.message.AlaGameFrsLiveThreadsRequestMessage;
import com.baidu.tieba.ala.frsgamelive.message.AlaGameFrsLiveThreadsRespMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b9;
import com.repackage.is5;
import com.repackage.uo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaFrsLiveModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FIRST_PN = 1;
    public static final int SORT_TYPE_HOT = 1;
    public static final int SORT_TYPE_NEW = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public String d;
    public int e;
    public int f;
    public boolean g;
    public int h;
    public List<uo> i;
    public boolean j;
    public b k;
    public HttpMessageListener l;

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaFrsLiveModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaFrsLiveModel alaFrsLiveModel, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaFrsLiveModel, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaFrsLiveModel;
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
                        if (this.a.k != null) {
                            this.a.k.onLoadError(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    List<uo> liveList = alaGameFrsLiveThreadsRespMessage.getLiveList();
                    if (this.a.i == null) {
                        this.a.i = new ArrayList();
                    }
                    if (this.a.b != 1 || ListUtils.getCount(liveList) != 0 || this.a.f != 2) {
                        this.a.j = false;
                        this.a.g = alaGameFrsLiveThreadsRespMessage.hasMore();
                        this.a.b = alaGameFrsLiveThreadsRequestMessage.getPn();
                        this.a.h = alaGameFrsLiveThreadsRespMessage.getLiveCount();
                        if (this.a.b == 1 || ListUtils.getCount(this.a.i) == 0) {
                            if (liveList != null) {
                                this.a.i.clear();
                                this.a.i.addAll(liveList);
                            }
                        } else if (ListUtils.getCount(liveList) > 0) {
                            AlaFrsLiveModel alaFrsLiveModel = this.a;
                            alaFrsLiveModel.i = alaFrsLiveModel.M(alaFrsLiveModel.i, liveList);
                        }
                    } else {
                        List<uo> recommandList = alaGameFrsLiveThreadsRespMessage.getRecommandList();
                        this.a.g = false;
                        this.a.b = alaGameFrsLiveThreadsRequestMessage.getPn();
                        this.a.h = 0;
                        if (recommandList != null) {
                            this.a.i.clear();
                            this.a.i.addAll(recommandList);
                        }
                        this.a.j = true;
                    }
                    if (this.a.k != null) {
                        this.a.k.a(this.a.g);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z);

        void onLoadError(int i, String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaFrsLiveModel(b9 b9Var) {
        super(b9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 1;
        this.c = 30;
        this.e = 1;
        this.f = 1;
        this.j = false;
        a aVar = new a(this, AlaCmdConfigHttp.CMD_ALA_LIVE_FRS_GAME, true);
        this.l = aVar;
        registerListener(aVar);
    }

    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.h : invokeV.intValue;
    }

    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.e : invokeV.intValue;
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public final List<uo> M(List<uo> list, List<uo> list2) {
        InterceptResult invokeLL;
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, list, list2)) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(list);
            for (uo uoVar : list2) {
                if (uoVar != null && (uoVar instanceof is5) && (threadData = ((is5) uoVar).a) != null && (threadData.getThreadType() == 49 || threadData.getThreadType() == 69)) {
                    String tid = threadData.getTid();
                    if (!TextUtils.isEmpty(tid)) {
                        boolean z = false;
                        Iterator<uo> it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            uo next = it.next();
                            if (next != null && (next instanceof is5) && (threadData2 = ((is5) next).a) != null && tid.equals(threadData2.getTid())) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            linkedList.add(uoVar);
                        }
                    }
                }
            }
            return linkedList;
        }
        return (List) invokeLL.objValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.g) {
                AlaGameFrsLiveThreadsRequestMessage alaGameFrsLiveThreadsRequestMessage = new AlaGameFrsLiveThreadsRequestMessage();
                alaGameFrsLiveThreadsRequestMessage.setForumId(this.a);
                alaGameFrsLiveThreadsRequestMessage.setPn(this.b + 1);
                alaGameFrsLiveThreadsRequestMessage.setPs(this.c);
                alaGameFrsLiveThreadsRequestMessage.setForumGameLabel(this.d);
                alaGameFrsLiveThreadsRequestMessage.setSortType(this.e);
                alaGameFrsLiveThreadsRequestMessage.setHttpParams();
                sendMessage(alaGameFrsLiveThreadsRequestMessage);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            AlaGameFrsLiveThreadsRequestMessage alaGameFrsLiveThreadsRequestMessage = new AlaGameFrsLiveThreadsRequestMessage();
            alaGameFrsLiveThreadsRequestMessage.setForumId(this.a);
            alaGameFrsLiveThreadsRequestMessage.setPn(1);
            alaGameFrsLiveThreadsRequestMessage.setPs(this.c);
            alaGameFrsLiveThreadsRequestMessage.setForumGameLabel(this.d);
            alaGameFrsLiveThreadsRequestMessage.setSortType(this.e);
            alaGameFrsLiveThreadsRequestMessage.setHttpParams();
            sendMessage(alaGameFrsLiveThreadsRequestMessage);
        }
    }

    public void P(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.f = i;
        }
    }

    public void Q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.k = bVar;
        }
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

    public void clearData() {
        List<uo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (list = this.i) == null) {
            return;
        }
        list.clear();
    }

    public List<uo> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.i : (List) invokeV.objValue;
    }

    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.g : invokeV.booleanValue;
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
            this.d = str;
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.a = str;
        }
    }

    public void setSortType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.e = i;
        }
    }
}
