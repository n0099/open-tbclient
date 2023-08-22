package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
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
import com.baidu.tieba.ax7;
import com.baidu.tieba.bn;
import com.baidu.tieba.c45;
import com.baidu.tieba.e36;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.fx7;
import com.baidu.tieba.h36;
import com.baidu.tieba.hq7;
import com.baidu.tieba.kq7;
import com.baidu.tieba.ls5;
import com.baidu.tieba.pu7;
import com.baidu.tieba.qfa;
import com.baidu.tieba.r1a;
import com.baidu.tieba.sq7;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.xfa;
import com.baidu.tieba.xw5;
import com.baidu.tieba.z56;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
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
/* loaded from: classes6.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    public static int q = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final hq7 a;
    public boolean b;
    public long c;
    public final ArrayList<bn> d;
    public final ArrayList<String> e;
    public final ArrayList<bn> f;
    public int g;
    public int h;
    public int i;
    public boolean isLoading;
    public boolean j;
    public long k;
    public int l;
    public int loadIndex;
    public boolean loadingDone;
    public sq7 m;
    public kq7.b n;
    public fx7 o;
    public final NetMessageListener p;

    /* loaded from: classes6.dex */
    public interface b {
        void l(ArrayList<bn> arrayList);

        void onFailed(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1407106122, "Lcom/baidu/tieba/frs/loadmore/FrsLoadMoreModel;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1407106122, "Lcom/baidu/tieba/frs/loadmore/FrsLoadMoreModel;");
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
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

    /* loaded from: classes6.dex */
    public class a extends NetMessageListener {
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

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || this.a.a == null) {
                return;
            }
            FrsLoadMoreModel frsLoadMoreModel = this.a;
            frsLoadMoreModel.isLoading = false;
            if (responsedMessage == null) {
                frsLoadMoreModel.a.onFailed(this.a.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e29));
            } else if (responsedMessage.getError() != 0) {
                if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                    this.a.a.onFailed(responsedMessage.getErrorString());
                } else {
                    this.a.a.onFailed(this.a.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e29));
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                FrsViewData l1 = this.a.a.l1();
                if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                    LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                    if (l1 != null) {
                        l1.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                    }
                    this.a.a.l(loadMoreHttpResponseMessage.getThreadList());
                    if (this.a.a instanceof FrsFragment) {
                        ((FrsFragment) this.a.a).D = System.currentTimeMillis() - currentTimeMillis;
                        this.a.Y(true, responsedMessage);
                    }
                    this.a.X(loadMoreHttpResponseMessage);
                } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                    LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                    if (l1 != null) {
                        l1.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                    }
                    this.a.a.l(loadMoreResponseSocketMessage.getThreadList());
                    if (this.a.a instanceof FrsFragment) {
                        ((FrsFragment) this.a.a).D = System.currentTimeMillis() - currentTimeMillis;
                        this.a.Y(false, responsedMessage);
                    }
                    this.a.Z(loadMoreResponseSocketMessage);
                }
                if (!TextUtils.isEmpty(this.a.a.v()) && r1a.m().b() != null) {
                    r1a.m().b().g(this.a.a.v(), 2, false);
                }
                this.a.loadIndex++;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsLoadMoreModel(hq7 hq7Var, sq7 sq7Var) {
        super(hq7Var.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hq7Var, sq7Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.b = false;
        this.c = 0L;
        this.d = new ArrayList<>();
        this.e = new ArrayList<>();
        this.f = new ArrayList<>();
        this.h = 1;
        this.i = -1;
        this.j = false;
        this.l = 1;
        this.p = new a(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.a = hq7Var;
        setUniqueId(hq7Var.getUniqueId());
        this.m = sq7Var;
        this.p.getHttpMessageListener().setSelfListener(true);
        this.p.getSocketMessageListener().setSelfListener(true);
        registerListener(this.p);
    }

    public boolean R(List<Long> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() != 0) {
                if (this.loadIndex == 2 || this.loadingDone) {
                    return false;
                }
                return true;
            }
            this.loadingDone = true;
            return false;
        }
        return invokeL.booleanValue;
    }

    public void a0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            if (!ListUtils.isEmpty(this.d)) {
                b0(this.d, str);
            }
            if (!ListUtils.isEmpty(this.f)) {
                b0(this.f, str);
            }
        }
    }

    public void c0(bn bnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, bnVar) != null) || bnVar == null) {
            return;
        }
        ArrayList<bn> arrayList = this.d;
        if (arrayList != null) {
            arrayList.remove(bnVar);
        }
        ArrayList<bn> arrayList2 = this.f;
        if (arrayList2 != null) {
            arrayList2.remove(bnVar);
        }
    }

    public void d0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            ArrayList<bn> arrayList = this.d;
            if (arrayList != null) {
                T(arrayList, str);
            }
            ArrayList<bn> arrayList2 = this.f;
            if (arrayList2 != null) {
                T(arrayList2, str);
            }
        }
    }

    public void h0(fx7 fx7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, fx7Var) == null) {
            this.o = fx7Var;
        }
    }

    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.j = z;
        }
    }

    public void j0(kq7.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bVar) == null) {
            this.n = bVar;
        }
    }

    public void k0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.l = i;
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
            this.h = i;
        }
    }

    public void setSortType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.g = i;
        }
    }

    public final void Q(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, str, loadMoreRequestMessage) != null) || r1a.m().b() == null) {
            return;
        }
        loadMoreRequestMessage.setLoadCount(r1a.m().b().e(str, false) + 1);
    }

    public void S() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int size = this.f.size() + 30;
            int a2 = TbadkCoreApplication.getInst().getListItemRule().a() * 3;
            int count = ListUtils.getCount(this.d);
            if (size > a2 && this.f.size() > (i = size - a2)) {
                for (int i2 = 0; i2 < i; i2++) {
                    ArrayList<bn> arrayList = new ArrayList<>();
                    arrayList.add(this.f.remove(0));
                    ArrayList<bn> arrayList2 = null;
                    hq7 hq7Var = this.a;
                    if (hq7Var != null && hq7Var.l1() != null) {
                        arrayList2 = this.a.l1().switchThreadDataToThreadCardInfo(arrayList);
                    }
                    if (arrayList2 != null) {
                        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                            kq7.b bVar = this.n;
                            if (bVar != null) {
                                bVar.removeItem(count + i3);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void T(@NonNull ArrayList<bn> arrayList, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, arrayList, str) == null) {
            Iterator<bn> it = arrayList.iterator();
            while (it.hasNext()) {
                bn next = it.next();
                if ((next instanceof ThreadData) && TextUtils.equals(str, ((ThreadData) next).getTid())) {
                    it.remove();
                }
            }
        }
    }

    public ArrayList<bn> U(boolean z, boolean z2, boolean z3, ArrayList<bn> arrayList, qfa qfaVar, List<AdMixFloor> list, int i) {
        InterceptResult invokeCommon;
        hq7 hq7Var;
        hq7 hq7Var2;
        hq7 hq7Var3;
        hq7 hq7Var4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), arrayList, qfaVar, list, Integer.valueOf(i)})) == null) {
            if (z3) {
                this.d.clear();
                this.e.clear();
                this.f.clear();
            }
            HashSet hashSet = new HashSet();
            Iterator<bn> it = this.d.iterator();
            while (it.hasNext()) {
                bn next = it.next();
                if (next instanceof c45) {
                    ThreadData threadData = ((c45) next).t;
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
            ArrayList<bn> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            if (!ListUtils.isEmpty(arrayList)) {
                Iterator<bn> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    bn next2 = it2.next();
                    if (next2 instanceof c45) {
                        c45 c45Var = (c45) next2;
                        ThreadData threadData3 = c45Var.t;
                        threadData3.setForum_name(this.a.v());
                        hq7 hq7Var5 = this.a;
                        if (hq7Var5 != null && hq7Var5.l1() != null && this.a.l1().getForum() != null) {
                            if (!StringUtils.isNull(this.a.l1().getForum().getFirst_class())) {
                                threadData3.setFirstClassName(this.a.l1().getForum().getFirst_class());
                            }
                            if (!StringUtils.isNull(this.a.l1().getForum().getSecond_class())) {
                                threadData3.setSecondClassName(this.a.l1().getForum().getSecond_class());
                            }
                        }
                        if (threadData3.isNeedCheckRepeat()) {
                            if (!hashSet.contains(threadData3.getTid())) {
                                arrayList2.add(next2);
                                if (!arrayList3.contains(c45Var.t.tid)) {
                                    arrayList3.add(c45Var.t.tid);
                                }
                            }
                        } else {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(c45Var.t.tid)) {
                                arrayList3.add(c45Var.t.tid);
                            }
                        }
                    } else if (next2 instanceof ThreadData) {
                        ThreadData threadData4 = (ThreadData) next2;
                        threadData4.setForum_name(this.a.v());
                        hq7 hq7Var6 = this.a;
                        if (hq7Var6 != null && hq7Var6.l1() != null && this.a.l1().getForum() != null) {
                            if (!StringUtils.isNull(this.a.l1().getForum().getFirst_class())) {
                                threadData4.setFirstClassName(this.a.l1().getForum().getFirst_class());
                            }
                            if (!StringUtils.isNull(this.a.l1().getForum().getSecond_class())) {
                                threadData4.setSecondClassName(this.a.l1().getForum().getSecond_class());
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
                this.m.a(this.g, z2, arrayList2.size(), z, arrayList2, false);
            }
            if (i != -1) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (fx7.d()) {
                                if (this.o != null) {
                                    String valueOf = String.valueOf(this.k);
                                    if (this.k == 0 && (hq7Var4 = this.a) != null && hq7Var4.l1() != null && this.a.l1().getForum() != null && this.a.l1().getForum().getId() != null) {
                                        valueOf = this.a.l1().getForum().getId();
                                    }
                                    this.o.b(arrayList2, z3, valueOf);
                                }
                            } else {
                                hq7 hq7Var7 = this.a;
                                if (hq7Var7 != null) {
                                    FrsViewData l1 = hq7Var7.l1();
                                    if (this.j && l1 != null && (this.a instanceof h36)) {
                                        ArrayList<bn> arrayList4 = new ArrayList<>(this.d);
                                        arrayList4.addAll(this.f);
                                        l1.addRecommendAppToThreadList((h36) this.a, true, arrayList2, arrayList4, z2);
                                    }
                                }
                            }
                        } else if (!ListUtils.isEmpty(list)) {
                            int intValue = list.get(0).ad_type.intValue();
                            if (intValue == 1 && (hq7Var3 = this.a) != null) {
                                FrsViewData l12 = hq7Var3.l1();
                                if (this.j && l12 != null && (this.a instanceof h36)) {
                                    ArrayList<bn> arrayList5 = new ArrayList<>(this.d);
                                    arrayList5.addAll(this.f);
                                    l12.addRecommendAppToThreadList((h36) this.a, true, arrayList2, arrayList5, z2);
                                }
                            } else if (intValue == 2 && this.o != null) {
                                String valueOf2 = String.valueOf(this.k);
                                if (this.k == 0 && (hq7Var2 = this.a) != null && hq7Var2.l1() != null && this.a.l1().getForum() != null && this.a.l1().getForum().getId() != null) {
                                    valueOf2 = this.a.l1().getForum().getId();
                                }
                                this.o.g(arrayList2, list, z3, String.valueOf(valueOf2));
                            }
                        }
                    } else if (this.o != null) {
                        String valueOf3 = String.valueOf(this.k);
                        if (this.k == 0 && (hq7Var = this.a) != null && hq7Var.l1() != null && this.a.l1().getForum() != null && this.a.l1().getForum().getId() != null) {
                            valueOf3 = this.a.l1().getForum().getId();
                        }
                        this.o.b(arrayList2, z2, String.valueOf(valueOf3));
                    }
                } else {
                    hq7 hq7Var8 = this.a;
                    if (hq7Var8 != null) {
                        FrsViewData l13 = hq7Var8.l1();
                        if (this.j && l13 != null && (this.a instanceof h36)) {
                            ArrayList<bn> arrayList6 = new ArrayList<>(this.d);
                            arrayList6.addAll(this.f);
                            l13.addRecommendAppToThreadList((h36) this.a, true, arrayList2, arrayList6, z2);
                        }
                    }
                }
            }
            int b2 = TbadkCoreApplication.getInst().getListItemRule().b() - this.d.size();
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 < b2) {
                    this.d.add(arrayList2.get(i2));
                } else {
                    this.f.add(arrayList2.get(i2));
                }
            }
            ArrayList<bn> arrayList7 = new ArrayList<>();
            arrayList7.addAll(this.d);
            arrayList7.addAll(this.f);
            hq7 hq7Var9 = this.a;
            if (hq7Var9 instanceof h36) {
                pu7.b((h36) hq7Var9, hq7Var9.l1(), arrayList2, getPn());
                pu7.c(qfaVar, arrayList2, arrayList7);
            }
            return arrayList7;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public final String V(List<Long> list) {
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

    public int W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.loadIndex = 0;
            this.loadingDone = false;
            this.d.clear();
            this.e.clear();
            this.f.clear();
            this.i = -1;
            this.h = 1;
        }
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            registerListener(this.p);
        }
    }

    public final void X(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, loadMoreHttpResponseMessage) == null) && !this.b) {
            this.b = true;
            if (!PerformanceLoggerHelper.getInstance().isSmallFlow()) {
                return;
            }
            new ls5(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.c).c();
        }
    }

    public final void Z(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, loadMoreResponseSocketMessage) == null) && !this.b) {
            this.b = true;
            if (!PerformanceLoggerHelper.getInstance().isSmallFlow()) {
                return;
            }
            new ls5(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.c).c();
        }
    }

    public void Y(boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, responsedMessage) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && (this.a instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.c;
            ls5 ls5Var = new ls5(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.a).D, false, 0L, 0L, currentTimeMillis);
            ls5Var.B = currentTimeMillis;
            ls5Var.e(true);
        }
    }

    public final void b0(ArrayList<bn> arrayList, String str) {
        xfa xfaVar;
        xfa xfaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, arrayList, str) == null) {
            Iterator<bn> it = arrayList.iterator();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                i++;
                bn next = it.next();
                if (StringUtils.isNull(str)) {
                    if (!(next instanceof e36) && !(next instanceof z56)) {
                        if ((next instanceof ThreadData) && (xfaVar = ((ThreadData) next).funAdData) != null) {
                            xfaVar.p(true);
                            it.remove();
                        }
                    } else {
                        it.remove();
                    }
                } else {
                    if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof z56)) {
                        it.remove();
                    }
                    if (next instanceof e36) {
                        e36 e36Var = (e36) next;
                        if ((e36Var.a() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) e36Var.a()).a)) {
                            it.remove();
                            i2 = i;
                        }
                    } else if ((next instanceof ThreadData) && (xfaVar2 = ((ThreadData) next).funAdData) != null && xfaVar2.i()) {
                        it.remove();
                        i3 = i;
                    }
                }
            }
        }
    }

    public ArrayList<bn> e0() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int size = this.f.size() + 30;
            int a2 = TbadkCoreApplication.getInst().getListItemRule().a() * 3;
            if (size > a2 && this.f.size() > (i = size - a2)) {
                for (int i2 = 0; i2 < i; i2++) {
                    this.f.remove(0);
                }
            }
            ArrayList<bn> arrayList = new ArrayList<>();
            arrayList.addAll(this.d);
            arrayList.addAll(this.f);
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void f0(long j, List<Long> list, String str, int i, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j), list, str, Integer.valueOf(i), Boolean.valueOf(z), str2}) == null) {
            if (j != 0 && !ListUtils.isEmpty(list)) {
                String V = V(list);
                if (TextUtils.isEmpty(V)) {
                    return;
                }
                this.k = j;
                LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
                loadMoreRequestMessage.setForumId(j);
                loadMoreRequestMessage.setThreadIds(V);
                loadMoreRequestMessage.setNeedAbstract(0);
                loadMoreRequestMessage.setForumName(str);
                loadMoreRequestMessage.setPageNumber(i);
                loadMoreRequestMessage.setLastClickTid(JavaTypesHelper.toLong(xw5.a(), 0L));
                loadMoreRequestMessage.setSortType(this.g);
                loadMoreRequestMessage.setPageType(this.l);
                loadMoreRequestMessage.setAdFloorInfo(str2);
                loadMoreRequestMessage.setBrandForum(z);
                if (!TextUtils.isEmpty(str)) {
                    Q(str, loadMoreRequestMessage);
                }
                int i2 = q;
                q = i2 + 1;
                loadMoreRequestMessage.setRequestTimes(i2);
                sendMessage(loadMoreRequestMessage);
                this.isLoading = true;
                this.c = System.currentTimeMillis();
                ax7.a();
                return;
            }
            this.loadingDone = true;
        }
    }
}
