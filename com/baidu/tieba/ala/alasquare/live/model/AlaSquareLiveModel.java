package com.baidu.tieba.ala.alasquare.live.model;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.d.o.e.n;
import c.a.p0.c0.f.a.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.ala.AlaConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live.message.AlaSquareLiveHttpResponseMessage;
import com.baidu.tieba.ala.alasquare.live.message.AlaSquareLiveRequestMessage;
import com.baidu.tieba.ala.alasquare.live.message.AlaSquareLiveSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.LiveSquare.FunctionListInfo;
import tbclient.LiveSquare.HeadLiveInfo;
/* loaded from: classes5.dex */
public class AlaSquareLiveModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f a;

    /* renamed from: b  reason: collision with root package name */
    public b f31248b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<FunctionListInfo> f31249c;

    /* renamed from: d  reason: collision with root package name */
    public HeadLiveInfo f31250d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.p0.c0.f.b.b.a> f31251e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f31252f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f31253g;

    /* renamed from: h  reason: collision with root package name */
    public int f31254h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public List<Long> n;
    public c.a.d.c.g.a o;

    /* loaded from: classes5.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaSquareLiveModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaSquareLiveModel alaSquareLiveModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaSquareLiveModel, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaSquareLiveModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            LinkedList<c.a.p0.c0.f.b.b.a> linkedList;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.l = false;
                if (responsedMessage == null) {
                    return;
                }
                if (responsedMessage.hasError()) {
                    if (this.a.k) {
                        this.a.k = false;
                    }
                    if (this.a.f31248b != null) {
                        this.a.f31248b.onLoadError(responsedMessage.getError(), responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof AlaSquareLiveSocketResponseMessage) {
                    AlaSquareLiveSocketResponseMessage alaSquareLiveSocketResponseMessage = (AlaSquareLiveSocketResponseMessage) responsedMessage;
                    alaSquareLiveSocketResponseMessage.setPn(this.a.f31254h);
                    z = alaSquareLiveSocketResponseMessage.hasMore();
                    if (this.a.f31254h == 1) {
                        this.a.f31249c.clear();
                        this.a.f31249c.addAll(alaSquareLiveSocketResponseMessage.getFunctionList());
                    }
                    linkedList = alaSquareLiveSocketResponseMessage.getCategoryList();
                    this.a.f31250d = alaSquareLiveSocketResponseMessage.getHeadLiveInfo();
                    this.a.m = alaSquareLiveSocketResponseMessage.getIsSmallFollow();
                } else if (responsedMessage instanceof AlaSquareLiveHttpResponseMessage) {
                    AlaSquareLiveHttpResponseMessage alaSquareLiveHttpResponseMessage = (AlaSquareLiveHttpResponseMessage) responsedMessage;
                    alaSquareLiveHttpResponseMessage.setPn(this.a.f31254h);
                    z = alaSquareLiveHttpResponseMessage.hasMore();
                    if (this.a.f31254h == 1) {
                        this.a.f31249c.clear();
                        this.a.f31249c.addAll(alaSquareLiveHttpResponseMessage.getFunctionList());
                    }
                    linkedList = alaSquareLiveHttpResponseMessage.getCategoryList();
                    this.a.f31250d = alaSquareLiveHttpResponseMessage.getHeadLiveInfo();
                    this.a.m = alaSquareLiveHttpResponseMessage.getIsSmallFollow();
                } else {
                    linkedList = null;
                    z = false;
                }
                boolean z2 = this.a.k;
                if (this.a.k) {
                    this.a.k = false;
                    c.a.p0.c0.f.a.b.c(this.a.f31251e, linkedList, this.a.n);
                } else {
                    AlaSquareLiveModel alaSquareLiveModel = this.a;
                    alaSquareLiveModel.f31251e = c.a.p0.c0.f.a.b.g(alaSquareLiveModel.f31251e, linkedList, this.a.i);
                    this.a.j = z;
                }
                this.a.L();
                if (this.a.f31248b != null) {
                    this.a.f31248b.a(z, false, z2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, boolean z2, boolean z3);

        void onLoadError(int i, String str);
    }

    public AlaSquareLiveModel(f fVar, BdUniqueId bdUniqueId, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, bdUniqueId, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31254h = 1;
        this.j = false;
        this.k = false;
        a aVar = new a(this, AlaCmdConfigHttp.CMD_SQUARE_LIVE, AlaCmdConfigSocket.CMD_SQUARE_LIVE);
        this.o = aVar;
        this.a = fVar;
        this.unique_id = bdUniqueId;
        this.f31248b = bVar;
        registerListener(aVar);
        U();
        this.f31251e = new ArrayList();
        this.f31249c = new LinkedList<>();
    }

    public static void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            c.a.p0.a4.g0.a.h(AlaCmdConfigSocket.CMD_SQUARE_LIVE, AlaSquareLiveSocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_SQUARE_LIVE, c.a.p0.a4.g0.a.a(AlaConfig.SQUARE_LIVE, AlaCmdConfigSocket.CMD_SQUARE_LIVE));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(AlaSquareLiveHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void L() {
        Pair<List<n>, List<n>> d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (d2 = c.a.p0.c0.f.a.b.d(this.a.getString(R.string.obfuscated_res_0x7f0f11a9), this.f31251e)) == null) {
            return;
        }
        this.f31252f = (List) d2.first;
        this.f31253g = (List) d2.second;
    }

    public List<Long> M() {
        InterceptResult invokeV;
        c cVar;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (ListUtils.isEmpty(this.f31253g)) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            for (n nVar : this.f31253g) {
                if ((nVar instanceof c) && (threadData = (cVar = (c) nVar).f12865d) != null && threadData.getThreadAlaInfo() != null) {
                    linkedList.add(Long.valueOf(cVar.f12865d.getThreadAlaInfo().live_id));
                }
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public List<n> N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31252f : (List) invokeV.objValue;
    }

    public LinkedList<FunctionListInfo> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31249c : (LinkedList) invokeV.objValue;
    }

    public HeadLiveInfo P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f31250d : (HeadLiveInfo) invokeV.objValue;
    }

    public int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.m : invokeV.intValue;
    }

    public void R(List<Long> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || ListUtils.isEmpty(list) || this.k) {
            return;
        }
        this.n = list;
        T();
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.k = true;
            sendMessage(new AlaSquareLiveRequestMessage(1, false));
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

    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.j : invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void loadMore() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && hasMore()) {
            this.k = false;
            this.i = true;
            int i = this.f31254h + 1;
            this.f31254h = i;
            sendMessage(new AlaSquareLiveRequestMessage(i, false));
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            LinkedList<FunctionListInfo> linkedList = this.f31249c;
            if (linkedList != null) {
                linkedList.clear();
                this.f31249c = null;
            }
            if (this.f31250d != null) {
                this.f31250d = null;
            }
            List<c.a.p0.c0.f.b.b.a> list = this.f31251e;
            if (list != null) {
                list.clear();
                this.f31251e = null;
            }
            List<n> list2 = this.f31252f;
            if (list2 != null) {
                list2.clear();
                this.f31252f = null;
            }
            List<n> list3 = this.f31253g;
            if (list3 != null) {
                list3.clear();
                this.f31253g = null;
            }
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            List<c.a.p0.c0.f.b.b.a> list = this.f31251e;
            if (list != null) {
                list.clear();
            }
            List<n> list2 = this.f31252f;
            if (list2 != null) {
                list2.clear();
            }
            List<n> list3 = this.f31253g;
            if (list3 != null) {
                list3.clear();
            }
            this.l = true;
            this.k = false;
            this.i = false;
            this.f31254h = 1;
            sendMessage(new AlaSquareLiveRequestMessage(1, false));
        }
    }
}
