package com.baidu.tieba.ala.alasquare.live.model;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.f;
import c.a.e.l.e.n;
import c.a.q0.s.q.d2;
import c.a.r0.v.d.a.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.ala.AlaConfig;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes7.dex */
public class AlaSquareLiveModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public f f49372e;

    /* renamed from: f  reason: collision with root package name */
    public b f49373f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<FunctionListInfo> f49374g;

    /* renamed from: h  reason: collision with root package name */
    public HeadLiveInfo f49375h;

    /* renamed from: i  reason: collision with root package name */
    public List<c.a.r0.v.d.b.b.a> f49376i;

    /* renamed from: j  reason: collision with root package name */
    public List<n> f49377j;
    public List<n> k;
    public int l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public List<Long> r;
    public c.a.e.c.g.a s;

    /* loaded from: classes7.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaSquareLiveModel f49378a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaSquareLiveModel alaSquareLiveModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaSquareLiveModel, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49378a = alaSquareLiveModel;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            LinkedList<c.a.r0.v.d.b.b.a> linkedList;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f49378a.p = false;
                if (responsedMessage == null) {
                    return;
                }
                if (responsedMessage.hasError()) {
                    if (this.f49378a.o) {
                        this.f49378a.o = false;
                    }
                    if (this.f49378a.f49373f != null) {
                        this.f49378a.f49373f.onLoadError(responsedMessage.getError(), responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof AlaSquareLiveSocketResponseMessage) {
                    AlaSquareLiveSocketResponseMessage alaSquareLiveSocketResponseMessage = (AlaSquareLiveSocketResponseMessage) responsedMessage;
                    alaSquareLiveSocketResponseMessage.setPn(this.f49378a.l);
                    z = alaSquareLiveSocketResponseMessage.hasMore();
                    if (this.f49378a.l == 1) {
                        this.f49378a.f49374g.clear();
                        this.f49378a.f49374g.addAll(alaSquareLiveSocketResponseMessage.getFunctionList());
                    }
                    linkedList = alaSquareLiveSocketResponseMessage.getCategoryList();
                    this.f49378a.f49375h = alaSquareLiveSocketResponseMessage.getHeadLiveInfo();
                    this.f49378a.q = alaSquareLiveSocketResponseMessage.getIsSmallFollow();
                } else if (responsedMessage instanceof AlaSquareLiveHttpResponseMessage) {
                    AlaSquareLiveHttpResponseMessage alaSquareLiveHttpResponseMessage = (AlaSquareLiveHttpResponseMessage) responsedMessage;
                    alaSquareLiveHttpResponseMessage.setPn(this.f49378a.l);
                    z = alaSquareLiveHttpResponseMessage.hasMore();
                    if (this.f49378a.l == 1) {
                        this.f49378a.f49374g.clear();
                        this.f49378a.f49374g.addAll(alaSquareLiveHttpResponseMessage.getFunctionList());
                    }
                    linkedList = alaSquareLiveHttpResponseMessage.getCategoryList();
                    this.f49378a.f49375h = alaSquareLiveHttpResponseMessage.getHeadLiveInfo();
                    this.f49378a.q = alaSquareLiveHttpResponseMessage.getIsSmallFollow();
                } else {
                    linkedList = null;
                    z = false;
                }
                boolean z2 = this.f49378a.o;
                if (this.f49378a.o) {
                    this.f49378a.o = false;
                    c.a.r0.v.d.a.b.c(this.f49378a.f49376i, linkedList, this.f49378a.r);
                } else {
                    AlaSquareLiveModel alaSquareLiveModel = this.f49378a;
                    alaSquareLiveModel.f49376i = c.a.r0.v.d.a.b.g(alaSquareLiveModel.f49376i, linkedList, this.f49378a.m);
                    this.f49378a.n = z;
                }
                this.f49378a.J();
                if (this.f49378a.f49373f != null) {
                    this.f49378a.f49373f.a(z, false, z2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(boolean z, boolean z2, boolean z3);

        void onLoadError(int i2, String str);
    }

    public AlaSquareLiveModel(f fVar, BdUniqueId bdUniqueId, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, bdUniqueId, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 1;
        this.n = false;
        this.o = false;
        a aVar = new a(this, AlaCmdConfigHttp.CMD_SQUARE_LIVE, AlaCmdConfigSocket.CMD_SQUARE_LIVE);
        this.s = aVar;
        this.f49372e = fVar;
        this.unique_id = bdUniqueId;
        this.f49373f = bVar;
        registerListener(aVar);
        T();
        this.f49376i = new ArrayList();
        this.f49374g = new LinkedList<>();
    }

    public static void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            c.a.r0.j3.d0.a.h(AlaCmdConfigSocket.CMD_SQUARE_LIVE, AlaSquareLiveSocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_SQUARE_LIVE, c.a.r0.j3.d0.a.a(AlaConfig.SQUARE_LIVE, AlaCmdConfigSocket.CMD_SQUARE_LIVE));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(AlaSquareLiveHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void J() {
        Pair<List<n>, List<n>> d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (d2 = c.a.r0.v.d.a.b.d(this.f49372e.getString(R.string.square_live_category_title_hotest), this.f49376i)) == null) {
            return;
        }
        this.f49377j = (List) d2.first;
        this.k = (List) d2.second;
    }

    public List<Long> K() {
        InterceptResult invokeV;
        c cVar;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (ListUtils.isEmpty(this.k)) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            for (n nVar : this.k) {
                if ((nVar instanceof c) && (d2Var = (cVar = (c) nVar).f25469h) != null && d2Var.l1() != null) {
                    linkedList.add(Long.valueOf(cVar.f25469h.l1().live_id));
                }
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public List<n> L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f49377j : (List) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public LinkedList<FunctionListInfo> M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f49374g : (LinkedList) invokeV.objValue;
    }

    public HeadLiveInfo N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f49375h : (HeadLiveInfo) invokeV.objValue;
    }

    public int O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.q : invokeV.intValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public void Q(List<Long> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) || ListUtils.isEmpty(list) || this.o) {
            return;
        }
        this.r = list;
        S();
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.o = true;
            sendMessage(new AlaSquareLiveRequestMessage(1, false));
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

    public void loadMore() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && P()) {
            this.o = false;
            this.m = true;
            int i2 = this.l + 1;
            this.l = i2;
            sendMessage(new AlaSquareLiveRequestMessage(i2, false));
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            LinkedList<FunctionListInfo> linkedList = this.f49374g;
            if (linkedList != null) {
                linkedList.clear();
                this.f49374g = null;
            }
            if (this.f49375h != null) {
                this.f49375h = null;
            }
            List<c.a.r0.v.d.b.b.a> list = this.f49376i;
            if (list != null) {
                list.clear();
                this.f49376i = null;
            }
            List<n> list2 = this.f49377j;
            if (list2 != null) {
                list2.clear();
                this.f49377j = null;
            }
            List<n> list3 = this.k;
            if (list3 != null) {
                list3.clear();
                this.k = null;
            }
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            List<c.a.r0.v.d.b.b.a> list = this.f49376i;
            if (list != null) {
                list.clear();
            }
            List<n> list2 = this.f49377j;
            if (list2 != null) {
                list2.clear();
            }
            List<n> list3 = this.k;
            if (list3 != null) {
                list3.clear();
            }
            this.p = true;
            this.o = false;
            this.m = false;
            this.l = 1;
            sendMessage(new AlaSquareLiveRequestMessage(1, false));
        }
    }
}
