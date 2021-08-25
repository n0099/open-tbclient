package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.f;
import c.a.e.l.e.n;
import c.a.p0.b1.e0;
import c.a.p0.o0.h;
import c.a.p0.s.q.b2;
import c.a.p0.s.q.c2;
import c.a.q0.v0.e2.c;
import c.a.q0.v0.e2.k;
import c.a.q0.x2.y;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final c.a.q0.v0.d2.a f51337e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f51338f;

    /* renamed from: g  reason: collision with root package name */
    public long f51339g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList<n> f51340h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList<String> f51341i;
    public boolean isLoading;

    /* renamed from: j  reason: collision with root package name */
    public final ArrayList<n> f51342j;
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
    public c.a.q0.x0.a s;
    public final c.a.e.c.g.a t;

    /* loaded from: classes7.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsLoadMoreModel f51343a;

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
            this.f51343a = frsLoadMoreModel;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || this.f51343a.f51337e == null) {
                return;
            }
            FrsLoadMoreModel frsLoadMoreModel = this.f51343a;
            frsLoadMoreModel.isLoading = false;
            if (responsedMessage == null) {
                frsLoadMoreModel.f51337e.onFailed(this.f51343a.f51337e.getPageContext().getString(R.string.neterror));
            } else if (responsedMessage.getError() != 0) {
                if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                    this.f51343a.f51337e.onFailed(responsedMessage.getErrorString());
                } else {
                    this.f51343a.f51337e.onFailed(this.f51343a.f51337e.getPageContext().getString(R.string.neterror));
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                FrsViewData frsViewData = this.f51343a.f51337e.getFrsViewData();
                if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                    LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                    if (frsViewData != null) {
                        frsViewData.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                    }
                    this.f51343a.f51337e.onSuccess(loadMoreHttpResponseMessage.getThreadList());
                    if (this.f51343a.f51337e instanceof FrsFragment) {
                        ((FrsFragment) this.f51343a.f51337e).drawTime = System.currentTimeMillis() - currentTimeMillis;
                        this.f51343a.G(true, responsedMessage);
                    }
                    this.f51343a.F(loadMoreHttpResponseMessage);
                } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                    LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                    if (frsViewData != null) {
                        frsViewData.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                    }
                    this.f51343a.f51337e.onSuccess(loadMoreResponseSocketMessage.getThreadList());
                    if (this.f51343a.f51337e instanceof FrsFragment) {
                        ((FrsFragment) this.f51343a.f51337e).drawTime = System.currentTimeMillis() - currentTimeMillis;
                        this.f51343a.G(false, responsedMessage);
                    }
                    this.f51343a.H(loadMoreResponseSocketMessage);
                }
                if (!TextUtils.isEmpty(this.f51343a.f51337e.getForumName()) && y.o().b() != null) {
                    y.o().b().g(this.f51343a.f51337e.getForumName(), 2, false);
                }
                this.f51343a.loadIndex++;
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void onFailed(String str);

        void onSuccess(ArrayList<n> arrayList);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsLoadMoreModel(c.a.q0.v0.d2.a aVar, k kVar) {
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
        this.f51338f = false;
        this.f51339g = 0L;
        this.f51340h = new ArrayList<>();
        this.f51341i = new ArrayList<>();
        this.f51342j = new ArrayList<>();
        this.l = 1;
        this.m = -1;
        this.n = false;
        this.p = 1;
        this.t = new a(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.f51337e = aVar;
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
            int size = this.f51342j.size() + 30;
            int a2 = TbadkCoreApplication.getInst().getListItemRule().a() * 3;
            int count = ListUtils.getCount(this.f51340h);
            if (size <= a2 || this.f51342j.size() <= (i2 = size - a2)) {
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                ArrayList<n> arrayList = new ArrayList<>();
                arrayList.add(this.f51342j.remove(0));
                ArrayList<n> arrayList2 = null;
                c.a.q0.v0.d2.a aVar = this.f51337e;
                if (aVar != null && aVar.getFrsViewData() != null) {
                    arrayList2 = this.f51337e.getFrsViewData().switchThreadDataToThreadCardInfo(arrayList);
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

    public ArrayList<n> C(boolean z, boolean z2, boolean z3, ArrayList<n> arrayList, c.a.q0.i3.i0.f fVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), arrayList, fVar})) == null) {
            if (z3) {
                this.f51340h.clear();
                this.f51341i.clear();
                this.f51342j.clear();
            }
            HashSet hashSet = new HashSet();
            Iterator<n> it = this.f51340h.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof b2) {
                    c2 c2Var = ((b2) next).w;
                    if (c2Var.q1() != null) {
                        hashSet.add(c2Var.q1());
                    }
                } else if (next instanceof c2) {
                    c2 c2Var2 = (c2) next;
                    if (c2Var2.q1() != null) {
                        hashSet.add(c2Var2.q1());
                    }
                }
            }
            ArrayList<n> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            if (!ListUtils.isEmpty(arrayList)) {
                Iterator<n> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    n next2 = it2.next();
                    if (next2 instanceof b2) {
                        b2 b2Var = (b2) next2;
                        c2 c2Var3 = b2Var.w;
                        c2Var3.B3(this.f51337e.getForumName());
                        c.a.q0.v0.d2.a aVar = this.f51337e;
                        if (aVar != null && aVar.getFrsViewData() != null && this.f51337e.getFrsViewData().getForum() != null) {
                            if (!StringUtils.isNull(this.f51337e.getFrsViewData().getForum().getFirst_class())) {
                                c2Var3.y3(this.f51337e.getFrsViewData().getForum().getFirst_class());
                            }
                            if (!StringUtils.isNull(this.f51337e.getFrsViewData().getForum().getSecond_class())) {
                                c2Var3.h4(this.f51337e.getFrsViewData().getForum().getSecond_class());
                            }
                        }
                        if (c2Var3.i2()) {
                            if (!hashSet.contains(c2Var3.q1())) {
                                arrayList2.add(next2);
                                if (!arrayList3.contains(b2Var.w.B)) {
                                    arrayList3.add(b2Var.w.B);
                                }
                            }
                        } else {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(b2Var.w.B)) {
                                arrayList3.add(b2Var.w.B);
                            }
                        }
                    } else if (next2 instanceof c2) {
                        c2 c2Var4 = (c2) next2;
                        c2Var4.B3(this.f51337e.getForumName());
                        c.a.q0.v0.d2.a aVar2 = this.f51337e;
                        if (aVar2 != null && aVar2.getFrsViewData() != null && this.f51337e.getFrsViewData().getForum() != null) {
                            if (!StringUtils.isNull(this.f51337e.getFrsViewData().getForum().getFirst_class())) {
                                c2Var4.y3(this.f51337e.getFrsViewData().getForum().getFirst_class());
                            }
                            if (!StringUtils.isNull(this.f51337e.getFrsViewData().getForum().getSecond_class())) {
                                c2Var4.h4(this.f51337e.getFrsViewData().getForum().getSecond_class());
                            }
                        }
                        if (c2Var4.i2()) {
                            if (!hashSet.contains(c2Var4.q1())) {
                                arrayList2.add(next2);
                                if (!arrayList3.contains(c2Var4.B)) {
                                    arrayList3.add(c2Var4.B);
                                }
                            }
                        } else {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(c2Var4.B)) {
                                arrayList3.add(c2Var4.B);
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
            if (c.a.q0.x0.a.d()) {
                c.a.q0.x0.a aVar3 = this.s;
                if (aVar3 != null) {
                    aVar3.b(arrayList2, z3, String.valueOf(this.o));
                }
            } else {
                c.a.q0.v0.d2.a aVar4 = this.f51337e;
                if (aVar4 != null) {
                    FrsViewData frsViewData = aVar4.getFrsViewData();
                    if (this.n && frsViewData != null && (this.f51337e instanceof c.a.q0.f.e.b)) {
                        ArrayList<n> arrayList4 = new ArrayList<>(this.f51340h);
                        arrayList4.addAll(this.f51342j);
                        frsViewData.addRecommendAppToThreadList((c.a.q0.f.e.b) this.f51337e, true, arrayList2, arrayList4, z2);
                    }
                }
            }
            int b2 = TbadkCoreApplication.getInst().getListItemRule().b() - this.f51340h.size();
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 < b2) {
                    this.f51340h.add(arrayList2.get(i2));
                } else {
                    this.f51342j.add(arrayList2.get(i2));
                }
            }
            ArrayList<n> arrayList5 = new ArrayList<>();
            arrayList5.addAll(this.f51340h);
            arrayList5.addAll(this.f51342j);
            c.a.q0.v0.d2.a aVar5 = this.f51337e;
            if (aVar5 instanceof c.a.q0.f.e.b) {
                c.a.q0.v0.m2.a.b((c.a.q0.f.e.b) aVar5, aVar5.getFrsViewData(), arrayList2, getPn());
                c.a.q0.v0.m2.a.c(fVar, arrayList2, arrayList5);
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
        if (!(interceptable == null || interceptable.invokeL(1048581, this, loadMoreHttpResponseMessage) == null) || this.f51338f) {
            return;
        }
        this.f51338f = true;
        if (c.a.p0.o0.k.d().g()) {
            new h(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.f51339g).c();
        }
    }

    public void G(boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048582, this, z, responsedMessage) == null) && c.a.p0.o0.k.d().g() && (this.f51337e instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.f51339g;
            h hVar = new h(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.f51337e).drawTime, false, 0L, 0L, currentTimeMillis);
            hVar.B = currentTimeMillis;
            hVar.e(true);
        }
    }

    public final void H(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, loadMoreResponseSocketMessage) == null) || this.f51338f) {
            return;
        }
        this.f51338f = true;
        if (c.a.p0.o0.k.d().g()) {
            new h(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.f51339g).c();
        }
    }

    public void I(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f51340h)) {
            J(this.f51340h, str);
        }
        if (ListUtils.isEmpty(this.f51342j)) {
            return;
        }
        J(this.f51342j, str);
    }

    public final void J(ArrayList<n> arrayList, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, arrayList, str) == null) {
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof c.a.q0.f.c) {
                    c.a.q0.f.c cVar = (c.a.q0.f.c) next;
                    if ((cVar.b() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) cVar.b()).T3)) {
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
        ArrayList<n> arrayList = this.f51340h;
        if (arrayList != null) {
            arrayList.remove(nVar);
        }
        ArrayList<n> arrayList2 = this.f51342j;
        if (arrayList2 != null) {
            arrayList2.remove(nVar);
        }
    }

    public ArrayList<n> L() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int size = this.f51342j.size() + 30;
            int a2 = TbadkCoreApplication.getInst().getListItemRule().a() * 3;
            if (size > a2 && this.f51342j.size() > (i2 = size - a2)) {
                for (int i3 = 0; i3 < i2; i3++) {
                    this.f51342j.remove(0);
                }
            }
            ArrayList<n> arrayList = new ArrayList<>();
            arrayList.addAll(this.f51340h);
            arrayList.addAll(this.f51342j);
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

    public void M(long j2, List<Long> list, String str, int i2, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j2), list, str, Integer.valueOf(i2), Boolean.valueOf(z), str2}) == null) {
            if (j2 != 0 && !ListUtils.isEmpty(list)) {
                String D = D(list);
                if (TextUtils.isEmpty(D)) {
                    return;
                }
                this.o = j2;
                LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
                loadMoreRequestMessage.setForumId(j2);
                loadMoreRequestMessage.setThreadIds(D);
                loadMoreRequestMessage.setNeedAbstract(0);
                loadMoreRequestMessage.setForumName(str);
                loadMoreRequestMessage.setPageNumber(i2);
                loadMoreRequestMessage.setLastClickTid(c.a.e.e.m.b.f(e0.a(), 0L));
                loadMoreRequestMessage.setSortType(this.k);
                loadMoreRequestMessage.setPageType(this.p);
                loadMoreRequestMessage.setAdFloorInfo(str2);
                loadMoreRequestMessage.setBrandForum(z);
                if (!TextUtils.isEmpty(str)) {
                    z(str, loadMoreRequestMessage);
                }
                sendMessage(loadMoreRequestMessage);
                this.isLoading = true;
                this.f51339g = System.currentTimeMillis();
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
            this.f51340h.clear();
            this.f51341i.clear();
            this.f51342j.clear();
            this.m = -1;
            this.l = 1;
        }
    }

    public void O(c.a.q0.x0.a aVar) {
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

    public void Q(c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            this.r = bVar;
        }
    }

    public void R(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.p = i2;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.l : invokeV.intValue;
    }

    public void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            registerListener(this.t);
        }
    }

    public void setHasMore(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.m = i2;
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
        if (!(interceptable == null || interceptable.invokeLL(1048601, this, str, loadMoreRequestMessage) == null) || y.o().b() == null) {
            return;
        }
        loadMoreRequestMessage.setLoadCount(y.o().b().e(str, false) + 1);
    }
}
