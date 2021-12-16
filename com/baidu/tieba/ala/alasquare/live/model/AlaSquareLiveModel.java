package com.baidu.tieba.ala.alasquare.live.model;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.d.m.e.n;
import c.a.r0.s.r.d2;
import c.a.s0.a0.f.a.d;
import c.a.s0.a0.f.a.e;
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
/* loaded from: classes11.dex */
public class AlaSquareLiveModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public f f43225e;

    /* renamed from: f  reason: collision with root package name */
    public b f43226f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<FunctionListInfo> f43227g;

    /* renamed from: h  reason: collision with root package name */
    public HeadLiveInfo f43228h;

    /* renamed from: i  reason: collision with root package name */
    public List<c.a.s0.a0.f.b.b.a> f43229i;

    /* renamed from: j  reason: collision with root package name */
    public List<n> f43230j;

    /* renamed from: k  reason: collision with root package name */
    public List<n> f43231k;
    public int l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public List<Long> r;
    public c.a.d.c.g.a s;

    /* loaded from: classes11.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaSquareLiveModel a;

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
            this.a = alaSquareLiveModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            LinkedList<c.a.s0.a0.f.b.b.a> linkedList;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.p = false;
                if (responsedMessage == null) {
                    return;
                }
                if (responsedMessage.hasError()) {
                    if (this.a.o) {
                        this.a.o = false;
                    }
                    if (this.a.f43226f != null) {
                        this.a.f43226f.onLoadError(responsedMessage.getError(), responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof AlaSquareLiveSocketResponseMessage) {
                    AlaSquareLiveSocketResponseMessage alaSquareLiveSocketResponseMessage = (AlaSquareLiveSocketResponseMessage) responsedMessage;
                    alaSquareLiveSocketResponseMessage.setPn(this.a.l);
                    z = alaSquareLiveSocketResponseMessage.hasMore();
                    if (this.a.l == 1) {
                        this.a.f43227g.clear();
                        this.a.f43227g.addAll(alaSquareLiveSocketResponseMessage.getFunctionList());
                    }
                    linkedList = alaSquareLiveSocketResponseMessage.getCategoryList();
                    this.a.f43228h = alaSquareLiveSocketResponseMessage.getHeadLiveInfo();
                    this.a.q = alaSquareLiveSocketResponseMessage.getIsSmallFollow();
                } else if (responsedMessage instanceof AlaSquareLiveHttpResponseMessage) {
                    AlaSquareLiveHttpResponseMessage alaSquareLiveHttpResponseMessage = (AlaSquareLiveHttpResponseMessage) responsedMessage;
                    alaSquareLiveHttpResponseMessage.setPn(this.a.l);
                    z = alaSquareLiveHttpResponseMessage.hasMore();
                    if (this.a.l == 1) {
                        this.a.f43227g.clear();
                        this.a.f43227g.addAll(alaSquareLiveHttpResponseMessage.getFunctionList());
                    }
                    linkedList = alaSquareLiveHttpResponseMessage.getCategoryList();
                    this.a.f43228h = alaSquareLiveHttpResponseMessage.getHeadLiveInfo();
                    this.a.q = alaSquareLiveHttpResponseMessage.getIsSmallFollow();
                } else {
                    linkedList = null;
                    z = false;
                }
                boolean z2 = this.a.o;
                if (this.a.o) {
                    this.a.o = false;
                    d.c(this.a.f43229i, linkedList, this.a.r);
                } else {
                    AlaSquareLiveModel alaSquareLiveModel = this.a;
                    alaSquareLiveModel.f43229i = d.g(alaSquareLiveModel.f43229i, linkedList, this.a.m);
                    this.a.n = z;
                }
                this.a.J();
                if (this.a.f43226f != null) {
                    this.a.f43226f.a(z, false, z2);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
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
        this.f43225e = fVar;
        this.unique_id = bdUniqueId;
        this.f43226f = bVar;
        registerListener(aVar);
        S();
        this.f43229i = new ArrayList();
        this.f43227g = new LinkedList<>();
    }

    public static void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            c.a.s0.v3.f0.a.h(AlaCmdConfigSocket.CMD_SQUARE_LIVE, AlaSquareLiveSocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_SQUARE_LIVE, c.a.s0.v3.f0.a.a(AlaConfig.SQUARE_LIVE, AlaCmdConfigSocket.CMD_SQUARE_LIVE));
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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (d2 = d.d(this.f43225e.getString(R.string.square_live_category_title_hotest), this.f43229i)) == null) {
            return;
        }
        this.f43230j = (List) d2.first;
        this.f43231k = (List) d2.second;
    }

    public List<Long> K() {
        InterceptResult invokeV;
        e eVar;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (ListUtils.isEmpty(this.f43231k)) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            for (n nVar : this.f43231k) {
                if ((nVar instanceof e) && (d2Var = (eVar = (e) nVar).f14193h) != null && d2Var.o1() != null) {
                    linkedList.add(Long.valueOf(eVar.f14193h.o1().live_id));
                }
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public List<n> L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f43230j : (List) invokeV.objValue;
    }

    public LinkedList<FunctionListInfo> M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f43227g : (LinkedList) invokeV.objValue;
    }

    public HeadLiveInfo N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f43228h : (HeadLiveInfo) invokeV.objValue;
    }

    public int O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.q : invokeV.intValue;
    }

    public void P(List<Long> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || ListUtils.isEmpty(list) || this.o) {
            return;
        }
        this.r = list;
        R();
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.o = true;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.n : invokeV.booleanValue;
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
            LinkedList<FunctionListInfo> linkedList = this.f43227g;
            if (linkedList != null) {
                linkedList.clear();
                this.f43227g = null;
            }
            if (this.f43228h != null) {
                this.f43228h = null;
            }
            List<c.a.s0.a0.f.b.b.a> list = this.f43229i;
            if (list != null) {
                list.clear();
                this.f43229i = null;
            }
            List<n> list2 = this.f43230j;
            if (list2 != null) {
                list2.clear();
                this.f43230j = null;
            }
            List<n> list3 = this.f43231k;
            if (list3 != null) {
                list3.clear();
                this.f43231k = null;
            }
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            List<c.a.s0.a0.f.b.b.a> list = this.f43229i;
            if (list != null) {
                list.clear();
            }
            List<n> list2 = this.f43230j;
            if (list2 != null) {
                list2.clear();
            }
            List<n> list3 = this.f43231k;
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
