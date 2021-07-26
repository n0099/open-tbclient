package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.f;
import d.a.d.k.e.n;
import d.a.p0.b1.c0;
import d.a.p0.o0.h;
import d.a.p0.s.q.a2;
import d.a.p0.s.q.b2;
import d.a.q0.u0.e2.c;
import d.a.q0.u0.e2.k;
import d.a.q0.w2.w;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.q0.u0.d2.a f16006e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f16007f;

    /* renamed from: g  reason: collision with root package name */
    public long f16008g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList<n> f16009h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList<String> f16010i;
    public boolean isLoading;
    public final ArrayList<n> j;
    public int k;
    public int l;
    public int loadIndex;
    public boolean loadingDone;
    public int m;
    public boolean n;
    public long o;
    public int p;
    public k q;
    public c.b r;
    public d.a.q0.w0.a s;
    public final d.a.d.c.g.a t;

    /* loaded from: classes4.dex */
    public class a extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsLoadMoreModel f16011a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FrsLoadMoreModel frsLoadMoreModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsLoadMoreModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f16011a = frsLoadMoreModel;
        }

        @Override // d.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || this.f16011a.f16006e == null) {
                return;
            }
            FrsLoadMoreModel frsLoadMoreModel = this.f16011a;
            frsLoadMoreModel.isLoading = false;
            if (responsedMessage == null) {
                frsLoadMoreModel.f16006e.onFailed(this.f16011a.f16006e.getPageContext().getString(R.string.neterror));
            } else if (responsedMessage.getError() != 0) {
                if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                    this.f16011a.f16006e.onFailed(responsedMessage.getErrorString());
                } else {
                    this.f16011a.f16006e.onFailed(this.f16011a.f16006e.getPageContext().getString(R.string.neterror));
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                FrsViewData l0 = this.f16011a.f16006e.l0();
                if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                    LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                    if (l0 != null) {
                        l0.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                    }
                    this.f16011a.f16006e.a(loadMoreHttpResponseMessage.getThreadList());
                    if (this.f16011a.f16006e instanceof FrsFragment) {
                        ((FrsFragment) this.f16011a.f16006e).H = System.currentTimeMillis() - currentTimeMillis;
                        this.f16011a.G(true, responsedMessage);
                    }
                    this.f16011a.F(loadMoreHttpResponseMessage);
                } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                    LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                    if (l0 != null) {
                        l0.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                    }
                    this.f16011a.f16006e.a(loadMoreResponseSocketMessage.getThreadList());
                    if (this.f16011a.f16006e instanceof FrsFragment) {
                        ((FrsFragment) this.f16011a.f16006e).H = System.currentTimeMillis() - currentTimeMillis;
                        this.f16011a.G(false, responsedMessage);
                    }
                    this.f16011a.H(loadMoreResponseSocketMessage);
                }
                if (!TextUtils.isEmpty(this.f16011a.f16006e.g()) && w.o().b() != null) {
                    w.o().b().g(this.f16011a.f16006e.g(), 2, false);
                }
                this.f16011a.loadIndex++;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(ArrayList<n> arrayList);

        void onFailed(String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsLoadMoreModel(d.a.q0.u0.d2.a aVar, k kVar) {
        super(aVar.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, kVar};
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
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.f16007f = false;
        this.f16008g = 0L;
        this.f16009h = new ArrayList<>();
        this.f16010i = new ArrayList<>();
        this.j = new ArrayList<>();
        this.l = 1;
        this.m = -1;
        this.n = false;
        this.p = 1;
        this.t = new a(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.f16006e = aVar;
        setUniqueId(aVar.getUniqueId());
        this.q = kVar;
        this.t.getHttpMessageListener().setSelfListener(true);
        this.t.getSocketMessageListener().setSelfListener(true);
        registerListener(this.t);
    }

    public boolean A(List<Long> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list != null && list.size() != 0) {
                return (this.loadIndex == 2 || this.loadingDone) ? false : true;
            }
            this.loadingDone = true;
            return false;
        }
        return invokeL.booleanValue;
    }

    public void B() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int size = this.j.size() + 30;
            int a2 = TbadkCoreApplication.getInst().getListItemRule().a() * 3;
            int count = ListUtils.getCount(this.f16009h);
            if (size <= a2 || this.j.size() <= (i2 = size - a2)) {
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                ArrayList<n> arrayList = new ArrayList<>();
                arrayList.add(this.j.remove(0));
                ArrayList<n> arrayList2 = null;
                d.a.q0.u0.d2.a aVar = this.f16006e;
                if (aVar != null && aVar.l0() != null) {
                    arrayList2 = this.f16006e.l0().switchThreadDataToThreadCardInfo(arrayList);
                }
                if (arrayList2 != null) {
                    for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                        c.b bVar = this.r;
                        if (bVar != null) {
                            bVar.removeItem(count + i4);
                        }
                    }
                }
            }
        }
    }

    public ArrayList<n> C(boolean z, boolean z2, boolean z3, ArrayList<n> arrayList, d.a.q0.h3.h0.f fVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), arrayList, fVar})) == null) {
            if (z3) {
                this.f16009h.clear();
                this.f16010i.clear();
                this.j.clear();
            }
            HashSet hashSet = new HashSet();
            Iterator<n> it = this.f16009h.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof a2) {
                    b2 b2Var = ((a2) next).w;
                    if (b2Var.o1() != null) {
                        hashSet.add(b2Var.o1());
                    }
                } else if (next instanceof b2) {
                    b2 b2Var2 = (b2) next;
                    if (b2Var2.o1() != null) {
                        hashSet.add(b2Var2.o1());
                    }
                }
            }
            ArrayList<n> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            if (!ListUtils.isEmpty(arrayList)) {
                Iterator<n> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    n next2 = it2.next();
                    if (next2 instanceof a2) {
                        a2 a2Var = (a2) next2;
                        b2 b2Var3 = a2Var.w;
                        b2Var3.s3(this.f16006e.g());
                        d.a.q0.u0.d2.a aVar = this.f16006e;
                        if (aVar != null && aVar.l0() != null && this.f16006e.l0().getForum() != null) {
                            if (!StringUtils.isNull(this.f16006e.l0().getForum().getFirst_class())) {
                                b2Var3.p3(this.f16006e.l0().getForum().getFirst_class());
                            }
                            if (!StringUtils.isNull(this.f16006e.l0().getForum().getSecond_class())) {
                                b2Var3.Y3(this.f16006e.l0().getForum().getSecond_class());
                            }
                        }
                        if (b2Var3.d2()) {
                            if (!hashSet.contains(b2Var3.o1())) {
                                arrayList2.add(next2);
                                if (!arrayList3.contains(a2Var.w.A)) {
                                    arrayList3.add(a2Var.w.A);
                                }
                            }
                        } else {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(a2Var.w.A)) {
                                arrayList3.add(a2Var.w.A);
                            }
                        }
                    } else if (next2 instanceof b2) {
                        b2 b2Var4 = (b2) next2;
                        b2Var4.s3(this.f16006e.g());
                        d.a.q0.u0.d2.a aVar2 = this.f16006e;
                        if (aVar2 != null && aVar2.l0() != null && this.f16006e.l0().getForum() != null) {
                            if (!StringUtils.isNull(this.f16006e.l0().getForum().getFirst_class())) {
                                b2Var4.p3(this.f16006e.l0().getForum().getFirst_class());
                            }
                            if (!StringUtils.isNull(this.f16006e.l0().getForum().getSecond_class())) {
                                b2Var4.Y3(this.f16006e.l0().getForum().getSecond_class());
                            }
                        }
                        if (b2Var4.d2()) {
                            if (!hashSet.contains(b2Var4.o1())) {
                                arrayList2.add(next2);
                                if (!arrayList3.contains(b2Var4.A)) {
                                    arrayList3.add(b2Var4.A);
                                }
                            }
                        } else {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(b2Var4.A)) {
                                arrayList3.add(b2Var4.A);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                    }
                }
            }
            if (this.q != null) {
                this.q.a(this.k, z2, arrayList2.size(), z, arrayList2, false);
            }
            if (d.a.q0.w0.a.d()) {
                d.a.q0.w0.a aVar3 = this.s;
                if (aVar3 != null) {
                    aVar3.b(arrayList2, z3, String.valueOf(this.o));
                }
            } else {
                d.a.q0.u0.d2.a aVar4 = this.f16006e;
                if (aVar4 != null) {
                    FrsViewData l0 = aVar4.l0();
                    if (this.n && l0 != null && (this.f16006e instanceof d.a.q0.e.e.b)) {
                        ArrayList<n> arrayList4 = new ArrayList<>(this.f16009h);
                        arrayList4.addAll(this.j);
                        l0.addRecommendAppToThreadList((d.a.q0.e.e.b) this.f16006e, true, arrayList2, arrayList4, z2);
                    }
                }
            }
            int b2 = TbadkCoreApplication.getInst().getListItemRule().b() - this.f16009h.size();
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 < b2) {
                    this.f16009h.add(arrayList2.get(i2));
                } else {
                    this.j.add(arrayList2.get(i2));
                }
            }
            ArrayList<n> arrayList5 = new ArrayList<>();
            arrayList5.addAll(this.f16009h);
            arrayList5.addAll(this.j);
            d.a.q0.u0.d2.a aVar5 = this.f16006e;
            if (aVar5 instanceof d.a.q0.e.e.b) {
                d.a.q0.u0.n2.a.b((d.a.q0.e.e.b) aVar5, aVar5.l0(), arrayList2, getPn());
                d.a.q0.u0.n2.a.c(fVar, arrayList2, arrayList5);
            }
            return arrayList5;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public final String D(List<Long> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list != null && list.size() != 0) {
                StringBuilder sb = new StringBuilder();
                int size = list.size();
                int i2 = 0;
                int i3 = this.loadIndex;
                if (i3 == 0) {
                    size = 30;
                } else if (i3 != 1) {
                    return "";
                } else {
                    i2 = 30;
                }
                if (size > list.size()) {
                    size = list.size();
                }
                if (i2 >= list.size()) {
                    this.loadingDone = true;
                    return "";
                }
                while (i2 < size) {
                    if (i2 == list.size() - 1) {
                        this.loadingDone = true;
                    }
                    Long l = list.get(i2);
                    if (l != null) {
                        if (i2 == size - 1) {
                            sb.append(l);
                        } else {
                            sb.append(l);
                            sb.append(",");
                        }
                    }
                    i2++;
                }
                return sb.toString();
            }
            this.loadingDone = true;
            return "";
        }
        return (String) invokeL.objValue;
    }

    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : invokeV.intValue;
    }

    public final void F(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, loadMoreHttpResponseMessage) == null) || this.f16007f) {
            return;
        }
        this.f16007f = true;
        if (d.a.p0.o0.k.d().g()) {
            new h(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.f16008g).c();
        }
    }

    public void G(boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048582, this, z, responsedMessage) == null) && d.a.p0.o0.k.d().g() && (this.f16006e instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.f16008g;
            h hVar = new h(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.f16006e).H, false, 0L, 0L, currentTimeMillis);
            hVar.B = currentTimeMillis;
            hVar.e(true);
        }
    }

    public final void H(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, loadMoreResponseSocketMessage) == null) || this.f16007f) {
            return;
        }
        this.f16007f = true;
        if (d.a.p0.o0.k.d().g()) {
            new h(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.f16008g).c();
        }
    }

    public void I(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f16009h)) {
            J(this.f16009h, str);
        }
        if (ListUtils.isEmpty(this.j)) {
            return;
        }
        J(this.j, str);
    }

    public final void J(ArrayList<n> arrayList, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, arrayList, str) == null) {
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof d.a.q0.e.c) {
                    d.a.q0.e.c cVar = (d.a.q0.e.c) next;
                    if ((cVar.b() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) cVar.b()).R3)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void K(n nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, nVar) == null) || nVar == null) {
            return;
        }
        ArrayList<n> arrayList = this.f16009h;
        if (arrayList != null) {
            arrayList.remove(nVar);
        }
        ArrayList<n> arrayList2 = this.j;
        if (arrayList2 != null) {
            arrayList2.remove(nVar);
        }
    }

    public ArrayList<n> L() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int size = this.j.size() + 30;
            int a2 = TbadkCoreApplication.getInst().getListItemRule().a() * 3;
            if (size > a2 && this.j.size() > (i2 = size - a2)) {
                for (int i3 = 0; i3 < i2; i3++) {
                    this.j.remove(0);
                }
            }
            ArrayList<n> arrayList = new ArrayList<>();
            arrayList.addAll(this.f16009h);
            arrayList.addAll(this.j);
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void M(long j, List<Long> list, String str, int i2, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), list, str, Integer.valueOf(i2), Boolean.valueOf(z), str2}) == null) {
            if (j != 0 && !ListUtils.isEmpty(list)) {
                String D = D(list);
                if (TextUtils.isEmpty(D)) {
                    return;
                }
                this.o = j;
                LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
                loadMoreRequestMessage.setForumId(j);
                loadMoreRequestMessage.setThreadIds(D);
                loadMoreRequestMessage.setNeedAbstract(0);
                loadMoreRequestMessage.setForumName(str);
                loadMoreRequestMessage.setPageNumber(i2);
                loadMoreRequestMessage.setLastClickTid(d.a.d.e.m.b.f(c0.a(), 0L));
                loadMoreRequestMessage.setSortType(this.k);
                loadMoreRequestMessage.setPageType(this.p);
                loadMoreRequestMessage.setAdFloorInfo(str2);
                loadMoreRequestMessage.setBrandForum(z);
                if (!TextUtils.isEmpty(str)) {
                    z(str, loadMoreRequestMessage);
                }
                sendMessage(loadMoreRequestMessage);
                this.isLoading = true;
                this.f16008g = System.currentTimeMillis();
                return;
            }
            this.loadingDone = true;
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.loadIndex = 0;
            this.loadingDone = false;
            this.f16009h.clear();
            this.f16010i.clear();
            this.j.clear();
            this.m = -1;
            this.l = 1;
        }
    }

    public void O(d.a.q0.w0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
            this.s = aVar;
        }
    }

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.n = z;
        }
    }

    public void Q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.m = i2;
        }
    }

    public void R(c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            this.r = bVar;
        }
    }

    public void S(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.p = i2;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.l : invokeV.intValue;
    }

    public void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            registerListener(this.t);
        }
    }

    public void setPn(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.l = i2;
        }
    }

    public void setSortType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.k = i2;
        }
    }

    public final void z(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048601, this, str, loadMoreRequestMessage) == null) || w.o().b() == null) {
            return;
        }
        loadMoreRequestMessage.setLoadCount(w.o().b().e(str, false) + 1);
    }
}
