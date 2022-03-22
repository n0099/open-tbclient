package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.d.o.e.n;
import c.a.o0.c1.h0;
import c.a.o0.r.r.a2;
import c.a.o0.r0.h;
import c.a.p0.f1.h2.c;
import c.a.p0.f1.h2.k;
import c.a.p0.f1.r2.d;
import c.a.p0.l3.z;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
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
import tbclient.AdMixFloor;
/* loaded from: classes5.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.p0.f1.g2.a a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f32772b;

    /* renamed from: c  reason: collision with root package name */
    public long f32773c;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<n> f32774d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<String> f32775e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<n> f32776f;

    /* renamed from: g  reason: collision with root package name */
    public int f32777g;

    /* renamed from: h  reason: collision with root package name */
    public int f32778h;
    public int i;
    public boolean isLoading;
    public boolean j;
    public long k;
    public int l;
    public int loadIndex;
    public boolean loadingDone;
    public k m;
    public c.b n;
    public c.a.p0.h1.a o;
    public final c.a.d.c.g.a p;

    /* loaded from: classes5.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsLoadMoreModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FrsLoadMoreModel frsLoadMoreModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsLoadMoreModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = frsLoadMoreModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || this.a.a == null) {
                return;
            }
            FrsLoadMoreModel frsLoadMoreModel = this.a;
            frsLoadMoreModel.isLoading = false;
            if (responsedMessage == null) {
                frsLoadMoreModel.a.onFailed(this.a.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c15));
            } else if (responsedMessage.getError() != 0) {
                if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                    this.a.a.onFailed(responsedMessage.getErrorString());
                } else {
                    this.a.a.onFailed(this.a.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c15));
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                FrsViewData f0 = this.a.a.f0();
                if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                    LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                    if (f0 != null) {
                        f0.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                    }
                    this.a.a.g(loadMoreHttpResponseMessage.getThreadList());
                    if (this.a.a instanceof FrsFragment) {
                        ((FrsFragment) this.a.a).D = System.currentTimeMillis() - currentTimeMillis;
                        this.a.J(true, responsedMessage);
                    }
                    this.a.I(loadMoreHttpResponseMessage);
                } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                    LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                    if (f0 != null) {
                        f0.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                    }
                    this.a.a.g(loadMoreResponseSocketMessage.getThreadList());
                    if (this.a.a instanceof FrsFragment) {
                        ((FrsFragment) this.a.a).D = System.currentTimeMillis() - currentTimeMillis;
                        this.a.J(false, responsedMessage);
                    }
                    this.a.K(loadMoreResponseSocketMessage);
                }
                if (!TextUtils.isEmpty(this.a.a.a()) && z.q().b() != null) {
                    z.q().b().g(this.a.a.a(), 2, false);
                }
                this.a.loadIndex++;
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void g(ArrayList<n> arrayList);

        void onFailed(String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsLoadMoreModel(c.a.p0.f1.g2.a aVar, k kVar) {
        super(aVar.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, kVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.f32772b = false;
        this.f32773c = 0L;
        this.f32774d = new ArrayList<>();
        this.f32775e = new ArrayList<>();
        this.f32776f = new ArrayList<>();
        this.f32778h = 1;
        this.i = -1;
        this.j = false;
        this.l = 1;
        this.p = new a(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.a = aVar;
        setUniqueId(aVar.getUniqueId());
        this.m = kVar;
        this.p.getHttpMessageListener().setSelfListener(true);
        this.p.getSocketMessageListener().setSelfListener(true);
        registerListener(this.p);
    }

    public final void B(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, loadMoreRequestMessage) == null) || z.q().b() == null) {
            return;
        }
        loadMoreRequestMessage.setLoadCount(z.q().b().e(str, false) + 1);
    }

    public boolean C(List<Long> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() != 0) {
                return (this.loadIndex == 2 || this.loadingDone) ? false : true;
            }
            this.loadingDone = true;
            return false;
        }
        return invokeL.booleanValue;
    }

    public void D() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int size = this.f32776f.size() + 30;
            int a2 = TbadkCoreApplication.getInst().getListItemRule().a() * 3;
            int count = ListUtils.getCount(this.f32774d);
            if (size <= a2 || this.f32776f.size() <= (i = size - a2)) {
                return;
            }
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<n> arrayList = new ArrayList<>();
                arrayList.add(this.f32776f.remove(0));
                ArrayList<n> arrayList2 = null;
                c.a.p0.f1.g2.a aVar = this.a;
                if (aVar != null && aVar.f0() != null) {
                    arrayList2 = this.a.f0().switchThreadDataToThreadCardInfo(arrayList);
                }
                if (arrayList2 != null) {
                    for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                        c.b bVar = this.n;
                        if (bVar != null) {
                            bVar.removeItem(count + i3);
                        }
                    }
                }
            }
        }
    }

    public final void E(@NonNull ArrayList<n> arrayList, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, arrayList, str) == null) {
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if ((next instanceof ThreadData) && TextUtils.equals(str, ((ThreadData) next).getTid())) {
                    it.remove();
                }
            }
        }
    }

    public ArrayList<n> F(boolean z, boolean z2, boolean z3, ArrayList<n> arrayList, c.a.p0.a4.k0.f fVar, List<AdMixFloor> list, int i) {
        InterceptResult invokeCommon;
        c.a.p0.h1.a aVar;
        c.a.p0.f1.g2.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), arrayList, fVar, list, Integer.valueOf(i)})) == null) {
            if (z3) {
                this.f32774d.clear();
                this.f32775e.clear();
                this.f32776f.clear();
            }
            HashSet hashSet = new HashSet();
            Iterator<n> it = this.f32774d.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof a2) {
                    ThreadData threadData = ((a2) next).s;
                    if (threadData.getTid() != null) {
                        hashSet.add(threadData.getTid());
                    }
                } else if (next instanceof ThreadData) {
                    ThreadData threadData2 = (ThreadData) next;
                    if (threadData2.getTid() != null) {
                        hashSet.add(threadData2.getTid());
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
                        ThreadData threadData3 = a2Var.s;
                        threadData3.setForum_name(this.a.a());
                        c.a.p0.f1.g2.a aVar3 = this.a;
                        if (aVar3 != null && aVar3.f0() != null && this.a.f0().getForum() != null) {
                            if (!StringUtils.isNull(this.a.f0().getForum().getFirst_class())) {
                                threadData3.setFirstClassName(this.a.f0().getForum().getFirst_class());
                            }
                            if (!StringUtils.isNull(this.a.f0().getForum().getSecond_class())) {
                                threadData3.setSecondClassName(this.a.f0().getForum().getSecond_class());
                            }
                        }
                        if (threadData3.isNeedCheckRepeat()) {
                            if (!hashSet.contains(threadData3.getTid())) {
                                arrayList2.add(next2);
                                if (!arrayList3.contains(a2Var.s.tid)) {
                                    arrayList3.add(a2Var.s.tid);
                                }
                            }
                        } else {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(a2Var.s.tid)) {
                                arrayList3.add(a2Var.s.tid);
                            }
                        }
                    } else if (next2 instanceof ThreadData) {
                        ThreadData threadData4 = (ThreadData) next2;
                        threadData4.setForum_name(this.a.a());
                        c.a.p0.f1.g2.a aVar4 = this.a;
                        if (aVar4 != null && aVar4.f0() != null && this.a.f0().getForum() != null) {
                            if (!StringUtils.isNull(this.a.f0().getForum().getFirst_class())) {
                                threadData4.setFirstClassName(this.a.f0().getForum().getFirst_class());
                            }
                            if (!StringUtils.isNull(this.a.f0().getForum().getSecond_class())) {
                                threadData4.setSecondClassName(this.a.f0().getForum().getSecond_class());
                            }
                        }
                        if (threadData4.isNeedCheckRepeat()) {
                            if (!hashSet.contains(threadData4.getTid())) {
                                arrayList2.add(next2);
                                if (!arrayList3.contains(threadData4.tid)) {
                                    arrayList3.add(threadData4.tid);
                                }
                            }
                        } else {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(threadData4.tid)) {
                                arrayList3.add(threadData4.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                    }
                }
            }
            if (this.m != null) {
                this.m.a(this.f32777g, z2, arrayList2.size(), z, arrayList2, false);
            }
            if (i != -1) {
                if (i == 1) {
                    c.a.p0.f1.g2.a aVar5 = this.a;
                    if (aVar5 != null) {
                        FrsViewData f0 = aVar5.f0();
                        if (this.j && f0 != null && (this.a instanceof c.a.p0.h.e.b)) {
                            ArrayList<n> arrayList4 = new ArrayList<>(this.f32774d);
                            arrayList4.addAll(this.f32776f);
                            f0.addRecommendAppToThreadList((c.a.p0.h.e.b) this.a, true, arrayList2, arrayList4, z2);
                        }
                    }
                } else if (i == 2) {
                    c.a.p0.h1.a aVar6 = this.o;
                    if (aVar6 != null) {
                        aVar6.b(arrayList2, z2, String.valueOf(this.k));
                    }
                } else if (i != 3) {
                    if (c.a.p0.h1.a.d()) {
                        c.a.p0.h1.a aVar7 = this.o;
                        if (aVar7 != null) {
                            aVar7.b(arrayList2, z3, String.valueOf(this.k));
                        }
                    } else {
                        c.a.p0.f1.g2.a aVar8 = this.a;
                        if (aVar8 != null) {
                            FrsViewData f02 = aVar8.f0();
                            if (this.j && f02 != null && (this.a instanceof c.a.p0.h.e.b)) {
                                ArrayList<n> arrayList5 = new ArrayList<>(this.f32774d);
                                arrayList5.addAll(this.f32776f);
                                f02.addRecommendAppToThreadList((c.a.p0.h.e.b) this.a, true, arrayList2, arrayList5, z2);
                            }
                        }
                    }
                } else if (!ListUtils.isEmpty(list)) {
                    int intValue = list.get(0).ad_type.intValue();
                    if (intValue == 1 && (aVar2 = this.a) != null) {
                        FrsViewData f03 = aVar2.f0();
                        if (this.j && f03 != null && (this.a instanceof c.a.p0.h.e.b)) {
                            ArrayList<n> arrayList6 = new ArrayList<>(this.f32774d);
                            arrayList6.addAll(this.f32776f);
                            f03.addRecommendAppToThreadList((c.a.p0.h.e.b) this.a, true, arrayList2, arrayList6, z2);
                        }
                    } else if (intValue == 2 && (aVar = this.o) != null) {
                        aVar.g(arrayList2, list, z3, String.valueOf(this.k));
                    }
                }
            }
            int b2 = TbadkCoreApplication.getInst().getListItemRule().b() - this.f32774d.size();
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 < b2) {
                    this.f32774d.add(arrayList2.get(i2));
                } else {
                    this.f32776f.add(arrayList2.get(i2));
                }
            }
            ArrayList<n> arrayList7 = new ArrayList<>();
            arrayList7.addAll(this.f32774d);
            arrayList7.addAll(this.f32776f);
            c.a.p0.f1.g2.a aVar9 = this.a;
            if (aVar9 instanceof c.a.p0.h.e.b) {
                d.b((c.a.p0.h.e.b) aVar9, aVar9.f0(), arrayList2, getPn());
                d.c(fVar, arrayList2, arrayList7);
            }
            return arrayList7;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public final String G(List<Long> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list != null && list.size() != 0) {
                StringBuilder sb = new StringBuilder();
                int size = list.size();
                int i = 0;
                int i2 = this.loadIndex;
                if (i2 == 0) {
                    size = 30;
                } else if (i2 != 1) {
                    return "";
                } else {
                    i = 30;
                }
                if (size > list.size()) {
                    size = list.size();
                }
                if (i >= list.size()) {
                    this.loadingDone = true;
                    return "";
                }
                while (i < size) {
                    if (i == list.size() - 1) {
                        this.loadingDone = true;
                    }
                    Long l = list.get(i);
                    if (l != null) {
                        if (i == size - 1) {
                            sb.append(l);
                        } else {
                            sb.append(l);
                            sb.append(",");
                        }
                    }
                    i++;
                }
                return sb.toString();
            }
            this.loadingDone = true;
            return "";
        }
        return (String) invokeL.objValue;
    }

    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.i : invokeV.intValue;
    }

    public final void I(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, loadMoreHttpResponseMessage) == null) || this.f32772b) {
            return;
        }
        this.f32772b = true;
        if (PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            new h(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.f32773c).c();
        }
    }

    public void J(boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, responsedMessage) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && (this.a instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.f32773c;
            h hVar = new h(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.a).D, false, 0L, 0L, currentTimeMillis);
            hVar.B = currentTimeMillis;
            hVar.e(true);
        }
    }

    public final void K(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, loadMoreResponseSocketMessage) == null) || this.f32772b) {
            return;
        }
        this.f32772b = true;
        if (PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            new h(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.f32773c).c();
        }
    }

    public void L(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f32774d)) {
            M(this.f32774d, str);
        }
        if (ListUtils.isEmpty(this.f32776f)) {
            return;
        }
        M(this.f32776f, str);
    }

    public final void M(ArrayList<n> arrayList, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, arrayList, str) == null) {
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof c.a.p0.h.c) {
                    c.a.p0.h.c cVar = (c.a.p0.h.c) next;
                    if ((cVar.a() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) cVar.a()).a)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void N(n nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, nVar) == null) || nVar == null) {
            return;
        }
        ArrayList<n> arrayList = this.f32774d;
        if (arrayList != null) {
            arrayList.remove(nVar);
        }
        ArrayList<n> arrayList2 = this.f32776f;
        if (arrayList2 != null) {
            arrayList2.remove(nVar);
        }
    }

    public void O(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            ArrayList<n> arrayList = this.f32774d;
            if (arrayList != null) {
                E(arrayList, str);
            }
            ArrayList<n> arrayList2 = this.f32776f;
            if (arrayList2 != null) {
                E(arrayList2, str);
            }
        }
    }

    public ArrayList<n> P() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            int size = this.f32776f.size() + 30;
            int a2 = TbadkCoreApplication.getInst().getListItemRule().a() * 3;
            if (size > a2 && this.f32776f.size() > (i = size - a2)) {
                for (int i2 = 0; i2 < i; i2++) {
                    this.f32776f.remove(0);
                }
            }
            ArrayList<n> arrayList = new ArrayList<>();
            arrayList.addAll(this.f32774d);
            arrayList.addAll(this.f32776f);
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void Q(long j, List<Long> list, String str, int i, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j), list, str, Integer.valueOf(i), Boolean.valueOf(z), str2}) == null) {
            if (j != 0 && !ListUtils.isEmpty(list)) {
                String G = G(list);
                if (TextUtils.isEmpty(G)) {
                    return;
                }
                this.k = j;
                LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
                loadMoreRequestMessage.setForumId(j);
                loadMoreRequestMessage.setThreadIds(G);
                loadMoreRequestMessage.setNeedAbstract(0);
                loadMoreRequestMessage.setForumName(str);
                loadMoreRequestMessage.setPageNumber(i);
                loadMoreRequestMessage.setLastClickTid(c.a.d.f.m.b.g(h0.a(), 0L));
                loadMoreRequestMessage.setSortType(this.f32777g);
                loadMoreRequestMessage.setPageType(this.l);
                loadMoreRequestMessage.setAdFloorInfo(str2);
                loadMoreRequestMessage.setBrandForum(z);
                if (!TextUtils.isEmpty(str)) {
                    B(str, loadMoreRequestMessage);
                }
                sendMessage(loadMoreRequestMessage);
                this.isLoading = true;
                this.f32773c = System.currentTimeMillis();
                c.a.p0.g1.d.a();
                return;
            }
            this.loadingDone = true;
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.loadIndex = 0;
            this.loadingDone = false;
            this.f32774d.clear();
            this.f32775e.clear();
            this.f32776f.clear();
            this.i = -1;
            this.f32778h = 1;
        }
    }

    public void S(c.a.p0.h1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            this.o = aVar;
        }
    }

    public void T(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.j = z;
        }
    }

    public void U(c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bVar) == null) {
            this.n = bVar;
        }
    }

    public void V(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.l = i;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f32778h : invokeV.intValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            registerListener(this.p);
        }
    }

    public void setHasMore(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.i = i;
        }
    }

    public void setPn(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.f32778h = i;
        }
    }

    public void setSortType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.f32777g = i;
        }
    }
}
