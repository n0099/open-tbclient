package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.d.n.e.n;
import c.a.s0.d1.h0;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.e2;
import c.a.s0.s0.h;
import c.a.t0.e1.i1;
import c.a.t0.e1.r2.c;
import c.a.t0.e1.r2.k;
import c.a.t0.e1.z2.d;
import c.a.t0.k3.y;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes12.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final c.a.t0.e1.q2.a f43665e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f43666f;

    /* renamed from: g  reason: collision with root package name */
    public long f43667g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList<n> f43668h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList<String> f43669i;
    public boolean isLoading;

    /* renamed from: j  reason: collision with root package name */
    public final ArrayList<n> f43670j;
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
    public c.a.t0.g1.a s;
    public final c.a.d.c.g.a t;

    /* loaded from: classes12.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsLoadMoreModel a;

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
            this.a = frsLoadMoreModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || this.a.f43665e == null) {
                return;
            }
            FrsLoadMoreModel frsLoadMoreModel = this.a;
            frsLoadMoreModel.isLoading = false;
            if (responsedMessage == null) {
                frsLoadMoreModel.f43665e.onFailed(this.a.f43665e.getPageContext().getString(i1.neterror));
            } else if (responsedMessage.getError() != 0) {
                if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                    this.a.f43665e.onFailed(responsedMessage.getErrorString());
                } else {
                    this.a.f43665e.onFailed(this.a.f43665e.getPageContext().getString(i1.neterror));
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                FrsViewData frsViewData = this.a.f43665e.getFrsViewData();
                if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                    LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                    if (frsViewData != null) {
                        frsViewData.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                    }
                    this.a.f43665e.onSuccess(loadMoreHttpResponseMessage.getThreadList());
                    if (this.a.f43665e instanceof FrsFragment) {
                        ((FrsFragment) this.a.f43665e).drawTime = System.currentTimeMillis() - currentTimeMillis;
                        this.a.H(true, responsedMessage);
                    }
                    this.a.G(loadMoreHttpResponseMessage);
                } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                    LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                    if (frsViewData != null) {
                        frsViewData.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                    }
                    this.a.f43665e.onSuccess(loadMoreResponseSocketMessage.getThreadList());
                    if (this.a.f43665e instanceof FrsFragment) {
                        ((FrsFragment) this.a.f43665e).drawTime = System.currentTimeMillis() - currentTimeMillis;
                        this.a.H(false, responsedMessage);
                    }
                    this.a.I(loadMoreResponseSocketMessage);
                }
                if (!TextUtils.isEmpty(this.a.f43665e.getForumName()) && y.q().b() != null) {
                    y.q().b().g(this.a.f43665e.getForumName(), 2, false);
                }
                this.a.loadIndex++;
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface b {
        void onFailed(String str);

        void onSuccess(ArrayList<n> arrayList);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsLoadMoreModel(c.a.t0.e1.q2.a aVar, k kVar) {
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
        this.f43666f = false;
        this.f43667g = 0L;
        this.f43668h = new ArrayList<>();
        this.f43669i = new ArrayList<>();
        this.f43670j = new ArrayList<>();
        this.l = 1;
        this.m = -1;
        this.n = false;
        this.p = 1;
        this.t = new a(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.f43665e = aVar;
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
            int size = this.f43670j.size() + 30;
            int a2 = TbadkCoreApplication.getInst().getListItemRule().a() * 3;
            int count = ListUtils.getCount(this.f43668h);
            if (size <= a2 || this.f43670j.size() <= (i2 = size - a2)) {
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                ArrayList<n> arrayList = new ArrayList<>();
                arrayList.add(this.f43670j.remove(0));
                ArrayList<n> arrayList2 = null;
                c.a.t0.e1.q2.a aVar = this.f43665e;
                if (aVar != null && aVar.getFrsViewData() != null) {
                    arrayList2 = this.f43665e.getFrsViewData().switchThreadDataToThreadCardInfo(arrayList);
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

    public final void C(@NonNull ArrayList<n> arrayList, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, arrayList, str) == null) {
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if ((next instanceof e2) && TextUtils.equals(str, ((e2) next).w1())) {
                    it.remove();
                }
            }
        }
    }

    public ArrayList<n> D(boolean z, boolean z2, boolean z3, ArrayList<n> arrayList, c.a.t0.x3.j0.f fVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), arrayList, fVar})) == null) {
            if (z3) {
                this.f43668h.clear();
                this.f43669i.clear();
                this.f43670j.clear();
            }
            HashSet hashSet = new HashSet();
            Iterator<n> it = this.f43668h.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof d2) {
                    e2 e2Var = ((d2) next).w;
                    if (e2Var.w1() != null) {
                        hashSet.add(e2Var.w1());
                    }
                } else if (next instanceof e2) {
                    e2 e2Var2 = (e2) next;
                    if (e2Var2.w1() != null) {
                        hashSet.add(e2Var2.w1());
                    }
                }
            }
            ArrayList<n> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            if (!ListUtils.isEmpty(arrayList)) {
                Iterator<n> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    n next2 = it2.next();
                    if (next2 instanceof d2) {
                        d2 d2Var = (d2) next2;
                        e2 e2Var3 = d2Var.w;
                        e2Var3.N3(this.f43665e.getForumName());
                        c.a.t0.e1.q2.a aVar = this.f43665e;
                        if (aVar != null && aVar.getFrsViewData() != null && this.f43665e.getFrsViewData().getForum() != null) {
                            if (!StringUtils.isNull(this.f43665e.getFrsViewData().getForum().getFirst_class())) {
                                e2Var3.K3(this.f43665e.getFrsViewData().getForum().getFirst_class());
                            }
                            if (!StringUtils.isNull(this.f43665e.getFrsViewData().getForum().getSecond_class())) {
                                e2Var3.w4(this.f43665e.getFrsViewData().getForum().getSecond_class());
                            }
                        }
                        if (e2Var3.q2()) {
                            if (!hashSet.contains(e2Var3.w1())) {
                                arrayList2.add(next2);
                                if (!arrayList3.contains(d2Var.w.E)) {
                                    arrayList3.add(d2Var.w.E);
                                }
                            }
                        } else {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(d2Var.w.E)) {
                                arrayList3.add(d2Var.w.E);
                            }
                        }
                    } else if (next2 instanceof e2) {
                        e2 e2Var4 = (e2) next2;
                        e2Var4.N3(this.f43665e.getForumName());
                        c.a.t0.e1.q2.a aVar2 = this.f43665e;
                        if (aVar2 != null && aVar2.getFrsViewData() != null && this.f43665e.getFrsViewData().getForum() != null) {
                            if (!StringUtils.isNull(this.f43665e.getFrsViewData().getForum().getFirst_class())) {
                                e2Var4.K3(this.f43665e.getFrsViewData().getForum().getFirst_class());
                            }
                            if (!StringUtils.isNull(this.f43665e.getFrsViewData().getForum().getSecond_class())) {
                                e2Var4.w4(this.f43665e.getFrsViewData().getForum().getSecond_class());
                            }
                        }
                        if (e2Var4.q2()) {
                            if (!hashSet.contains(e2Var4.w1())) {
                                arrayList2.add(next2);
                                if (!arrayList3.contains(e2Var4.E)) {
                                    arrayList3.add(e2Var4.E);
                                }
                            }
                        } else {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(e2Var4.E)) {
                                arrayList3.add(e2Var4.E);
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
            if (c.a.t0.g1.a.d()) {
                c.a.t0.g1.a aVar3 = this.s;
                if (aVar3 != null) {
                    aVar3.b(arrayList2, z3, String.valueOf(this.o));
                }
            } else {
                c.a.t0.e1.q2.a aVar4 = this.f43665e;
                if (aVar4 != null) {
                    FrsViewData frsViewData = aVar4.getFrsViewData();
                    if (this.n && frsViewData != null && (this.f43665e instanceof c.a.t0.h.e.b)) {
                        ArrayList<n> arrayList4 = new ArrayList<>(this.f43668h);
                        arrayList4.addAll(this.f43670j);
                        frsViewData.addRecommendAppToThreadList((c.a.t0.h.e.b) this.f43665e, true, arrayList2, arrayList4, z2);
                    }
                }
            }
            int b2 = TbadkCoreApplication.getInst().getListItemRule().b() - this.f43668h.size();
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 < b2) {
                    this.f43668h.add(arrayList2.get(i2));
                } else {
                    this.f43670j.add(arrayList2.get(i2));
                }
            }
            ArrayList<n> arrayList5 = new ArrayList<>();
            arrayList5.addAll(this.f43668h);
            arrayList5.addAll(this.f43670j);
            c.a.t0.e1.q2.a aVar5 = this.f43665e;
            if (aVar5 instanceof c.a.t0.h.e.b) {
                d.b((c.a.t0.h.e.b) aVar5, aVar5.getFrsViewData(), arrayList2, getPn());
                d.c(fVar, arrayList2, arrayList5);
            }
            return arrayList5;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public final String E(List<Long> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
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

    public int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.m : invokeV.intValue;
    }

    public final void G(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, loadMoreHttpResponseMessage) == null) || this.f43666f) {
            return;
        }
        this.f43666f = true;
        if (c.a.s0.s0.k.d().g()) {
            new h(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.f43667g).c();
        }
    }

    public void H(boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048583, this, z, responsedMessage) == null) && c.a.s0.s0.k.d().g() && (this.f43665e instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.f43667g;
            h hVar = new h(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.f43665e).drawTime, false, 0L, 0L, currentTimeMillis);
            hVar.B = currentTimeMillis;
            hVar.e(true);
        }
    }

    public final void I(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, loadMoreResponseSocketMessage) == null) || this.f43666f) {
            return;
        }
        this.f43666f = true;
        if (c.a.s0.s0.k.d().g()) {
            new h(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.f43667g).c();
        }
    }

    public void J(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f43668h)) {
            K(this.f43668h, str);
        }
        if (ListUtils.isEmpty(this.f43670j)) {
            return;
        }
        K(this.f43670j, str);
    }

    public final void K(ArrayList<n> arrayList, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, arrayList, str) == null) {
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof c.a.t0.h.c) {
                    c.a.t0.h.c cVar = (c.a.t0.h.c) next;
                    if ((cVar.a() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) cVar.a()).g4)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void L(n nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, nVar) == null) || nVar == null) {
            return;
        }
        ArrayList<n> arrayList = this.f43668h;
        if (arrayList != null) {
            arrayList.remove(nVar);
        }
        ArrayList<n> arrayList2 = this.f43670j;
        if (arrayList2 != null) {
            arrayList2.remove(nVar);
        }
    }

    public void M(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            ArrayList<n> arrayList = this.f43668h;
            if (arrayList != null) {
                C(arrayList, str);
            }
            ArrayList<n> arrayList2 = this.f43670j;
            if (arrayList2 != null) {
                C(arrayList2, str);
            }
        }
    }

    public ArrayList<n> N() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            int size = this.f43670j.size() + 30;
            int a2 = TbadkCoreApplication.getInst().getListItemRule().a() * 3;
            if (size > a2 && this.f43670j.size() > (i2 = size - a2)) {
                for (int i3 = 0; i3 < i2; i3++) {
                    this.f43670j.remove(0);
                }
            }
            ArrayList<n> arrayList = new ArrayList<>();
            arrayList.addAll(this.f43668h);
            arrayList.addAll(this.f43670j);
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void O(long j2, List<Long> list, String str, int i2, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j2), list, str, Integer.valueOf(i2), Boolean.valueOf(z), str2}) == null) {
            if (j2 != 0 && !ListUtils.isEmpty(list)) {
                String E = E(list);
                if (TextUtils.isEmpty(E)) {
                    return;
                }
                this.o = j2;
                LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
                loadMoreRequestMessage.setForumId(j2);
                loadMoreRequestMessage.setThreadIds(E);
                loadMoreRequestMessage.setNeedAbstract(0);
                loadMoreRequestMessage.setForumName(str);
                loadMoreRequestMessage.setPageNumber(i2);
                loadMoreRequestMessage.setLastClickTid(c.a.d.f.m.b.g(h0.a(), 0L));
                loadMoreRequestMessage.setSortType(this.k);
                loadMoreRequestMessage.setPageType(this.p);
                loadMoreRequestMessage.setAdFloorInfo(str2);
                loadMoreRequestMessage.setBrandForum(z);
                if (!TextUtils.isEmpty(str)) {
                    z(str, loadMoreRequestMessage);
                }
                sendMessage(loadMoreRequestMessage);
                this.isLoading = true;
                this.f43667g = System.currentTimeMillis();
                return;
            }
            this.loadingDone = true;
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.loadIndex = 0;
            this.loadingDone = false;
            this.f43668h.clear();
            this.f43669i.clear();
            this.f43670j.clear();
            this.m = -1;
            this.l = 1;
        }
    }

    public void Q(c.a.t0.g1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            this.s = aVar;
        }
    }

    public void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.n = z;
        }
    }

    public void S(c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            this.r = bVar;
        }
    }

    public void T(int i2) {
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

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            registerListener(this.t);
        }
    }

    public void setHasMore(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.m = i2;
        }
    }

    public void setPn(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.l = i2;
        }
    }

    public void setSortType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.k = i2;
        }
    }

    public final void z(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048603, this, str, loadMoreRequestMessage) == null) || y.q().b() == null) {
            return;
        }
        loadMoreRequestMessage.setLoadCount(y.q().b().e(str, false) + 1);
    }
}
