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
import com.baidu.tieba.d68;
import com.baidu.tieba.ewa;
import com.baidu.tieba.f28;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.ju5;
import com.baidu.tieba.l36;
import com.baidu.tieba.lwa;
import com.baidu.tieba.mz4;
import com.baidu.tieba.pi;
import com.baidu.tieba.q06;
import com.baidu.tieba.s88;
import com.baidu.tieba.t06;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tp5;
import com.baidu.tieba.u18;
import com.baidu.tieba.wha;
import com.baidu.tieba.x18;
import com.baidu.tieba.x88;
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
    public final u18 a;
    public boolean b;
    public long c;
    public final ArrayList<pi> d;
    public final ArrayList<String> e;
    public final ArrayList<pi> f;
    public int g;
    public int h;
    public int i;
    public boolean isLoading;
    public boolean j;
    public long k;
    public int l;
    public int loadIndex;
    public boolean loadingDone;
    public f28 m;
    public x18.b n;
    public x88 o;
    public final NetMessageListener p;

    /* loaded from: classes6.dex */
    public interface b {
        void onFailed(String str);

        void q(ArrayList<pi> arrayList);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
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
                frsLoadMoreModel.a.onFailed(this.a.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e70));
            } else if (responsedMessage.getError() != 0) {
                if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                    this.a.a.onFailed(responsedMessage.getErrorString());
                } else {
                    this.a.a.onFailed(this.a.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e70));
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                FrsViewData Q1 = this.a.a.Q1();
                if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                    LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                    if (Q1 != null) {
                        Q1.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                    }
                    this.a.a.q(loadMoreHttpResponseMessage.getThreadList());
                    if (this.a.a instanceof FrsFragment) {
                        ((FrsFragment) this.a.a).D = System.currentTimeMillis() - currentTimeMillis;
                        this.a.Z(true, responsedMessage);
                    }
                    this.a.Y(loadMoreHttpResponseMessage);
                } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                    LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                    if (Q1 != null) {
                        Q1.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                    }
                    this.a.a.q(loadMoreResponseSocketMessage.getThreadList());
                    if (this.a.a instanceof FrsFragment) {
                        ((FrsFragment) this.a.a).D = System.currentTimeMillis() - currentTimeMillis;
                        this.a.Z(false, responsedMessage);
                    }
                    this.a.a0(loadMoreResponseSocketMessage);
                }
                if (!TextUtils.isEmpty(this.a.a.v()) && wha.m().b() != null) {
                    wha.m().b().g(this.a.a.v(), 2, false);
                }
                this.a.loadIndex++;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsLoadMoreModel(u18 u18Var, f28 f28Var) {
        super(u18Var.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {u18Var, f28Var};
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
        this.a = u18Var;
        setUniqueId(u18Var.getUniqueId());
        this.m = f28Var;
        this.p.getHttpMessageListener().setSelfListener(true);
        this.p.getSocketMessageListener().setSelfListener(true);
        registerListener(this.p);
    }

    public boolean S(List<Long> list) {
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

    public void b0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            if (!ListUtils.isEmpty(this.d)) {
                c0(this.d, str);
            }
            if (!ListUtils.isEmpty(this.f)) {
                c0(this.f, str);
            }
        }
    }

    public void d0(pi piVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, piVar) != null) || piVar == null) {
            return;
        }
        ArrayList<pi> arrayList = this.d;
        if (arrayList != null) {
            arrayList.remove(piVar);
        }
        ArrayList<pi> arrayList2 = this.f;
        if (arrayList2 != null) {
            arrayList2.remove(piVar);
        }
    }

    public void e0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            ArrayList<pi> arrayList = this.d;
            if (arrayList != null) {
                U(arrayList, str);
            }
            ArrayList<pi> arrayList2 = this.f;
            if (arrayList2 != null) {
                U(arrayList2, str);
            }
        }
    }

    public void i0(x88 x88Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, x88Var) == null) {
            this.o = x88Var;
        }
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.j = z;
        }
    }

    public void k0(x18.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bVar) == null) {
            this.n = bVar;
        }
    }

    public void l0(int i) {
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

    public final void R(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, str, loadMoreRequestMessage) != null) || wha.m().b() == null) {
            return;
        }
        loadMoreRequestMessage.setLoadCount(wha.m().b().e(str, false) + 1);
    }

    public void T() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int size = this.f.size() + 30;
            int a2 = TbadkCoreApplication.getInst().getListItemRule().a() * 3;
            int count = ListUtils.getCount(this.d);
            if (size > a2 && this.f.size() > (i = size - a2)) {
                for (int i2 = 0; i2 < i; i2++) {
                    ArrayList<pi> arrayList = new ArrayList<>();
                    arrayList.add(this.f.remove(0));
                    ArrayList<pi> arrayList2 = null;
                    u18 u18Var = this.a;
                    if (u18Var != null && u18Var.Q1() != null) {
                        arrayList2 = this.a.Q1().switchThreadDataToThreadCardInfo(arrayList);
                    }
                    if (arrayList2 != null) {
                        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                            x18.b bVar = this.n;
                            if (bVar != null) {
                                bVar.removeItem(count + i3);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void U(@NonNull ArrayList<pi> arrayList, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, arrayList, str) == null) {
            Iterator<pi> it = arrayList.iterator();
            while (it.hasNext()) {
                pi next = it.next();
                if ((next instanceof ThreadData) && TextUtils.equals(str, ((ThreadData) next).getTid())) {
                    it.remove();
                }
            }
        }
    }

    public ArrayList<pi> V(boolean z, boolean z2, boolean z3, ArrayList<pi> arrayList, ewa ewaVar, List<AdMixFloor> list, int i) {
        InterceptResult invokeCommon;
        u18 u18Var;
        u18 u18Var2;
        u18 u18Var3;
        u18 u18Var4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), arrayList, ewaVar, list, Integer.valueOf(i)})) == null) {
            if (z3) {
                this.d.clear();
                this.e.clear();
                this.f.clear();
            }
            HashSet hashSet = new HashSet();
            Iterator<pi> it = this.d.iterator();
            while (it.hasNext()) {
                pi next = it.next();
                if (next instanceof mz4) {
                    ThreadData threadData = ((mz4) next).t;
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
            ArrayList<pi> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            if (!ListUtils.isEmpty(arrayList)) {
                Iterator<pi> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    pi next2 = it2.next();
                    if (next2 instanceof mz4) {
                        mz4 mz4Var = (mz4) next2;
                        ThreadData threadData3 = mz4Var.t;
                        threadData3.setForum_name(this.a.v());
                        u18 u18Var5 = this.a;
                        if (u18Var5 != null && u18Var5.Q1() != null && this.a.Q1().getForum() != null) {
                            if (!StringUtils.isNull(this.a.Q1().getForum().getFirst_class())) {
                                threadData3.setFirstClassName(this.a.Q1().getForum().getFirst_class());
                            }
                            if (!StringUtils.isNull(this.a.Q1().getForum().getSecond_class())) {
                                threadData3.setSecondClassName(this.a.Q1().getForum().getSecond_class());
                            }
                        }
                        if (threadData3.isNeedCheckRepeat()) {
                            if (!hashSet.contains(threadData3.getTid())) {
                                arrayList2.add(next2);
                                if (!arrayList3.contains(mz4Var.t.tid)) {
                                    arrayList3.add(mz4Var.t.tid);
                                }
                            }
                        } else {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(mz4Var.t.tid)) {
                                arrayList3.add(mz4Var.t.tid);
                            }
                        }
                    } else if (next2 instanceof ThreadData) {
                        ThreadData threadData4 = (ThreadData) next2;
                        threadData4.setForum_name(this.a.v());
                        u18 u18Var6 = this.a;
                        if (u18Var6 != null && u18Var6.Q1() != null && this.a.Q1().getForum() != null) {
                            if (!StringUtils.isNull(this.a.Q1().getForum().getFirst_class())) {
                                threadData4.setFirstClassName(this.a.Q1().getForum().getFirst_class());
                            }
                            if (!StringUtils.isNull(this.a.Q1().getForum().getSecond_class())) {
                                threadData4.setSecondClassName(this.a.Q1().getForum().getSecond_class());
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
                            if (x88.d()) {
                                if (this.o != null) {
                                    String valueOf = String.valueOf(this.k);
                                    if (this.k == 0 && (u18Var4 = this.a) != null && u18Var4.Q1() != null && this.a.Q1().getForum() != null && this.a.Q1().getForum().getId() != null) {
                                        valueOf = this.a.Q1().getForum().getId();
                                    }
                                    this.o.b(arrayList2, z3, valueOf);
                                }
                            } else {
                                u18 u18Var7 = this.a;
                                if (u18Var7 != null) {
                                    FrsViewData Q1 = u18Var7.Q1();
                                    if (this.j && Q1 != null && (this.a instanceof t06)) {
                                        ArrayList<pi> arrayList4 = new ArrayList<>(this.d);
                                        arrayList4.addAll(this.f);
                                        Q1.addRecommendAppToThreadList((t06) this.a, true, arrayList2, arrayList4, z2);
                                    }
                                }
                            }
                        } else if (!ListUtils.isEmpty(list)) {
                            int intValue = list.get(0).ad_type.intValue();
                            if (intValue == 1 && (u18Var3 = this.a) != null) {
                                FrsViewData Q12 = u18Var3.Q1();
                                if (this.j && Q12 != null && (this.a instanceof t06)) {
                                    ArrayList<pi> arrayList5 = new ArrayList<>(this.d);
                                    arrayList5.addAll(this.f);
                                    Q12.addRecommendAppToThreadList((t06) this.a, true, arrayList2, arrayList5, z2);
                                }
                            } else if (intValue == 2 && this.o != null) {
                                String valueOf2 = String.valueOf(this.k);
                                if (this.k == 0 && (u18Var2 = this.a) != null && u18Var2.Q1() != null && this.a.Q1().getForum() != null && this.a.Q1().getForum().getId() != null) {
                                    valueOf2 = this.a.Q1().getForum().getId();
                                }
                                this.o.g(arrayList2, list, z3, String.valueOf(valueOf2));
                            }
                        }
                    } else if (this.o != null) {
                        String valueOf3 = String.valueOf(this.k);
                        if (this.k == 0 && (u18Var = this.a) != null && u18Var.Q1() != null && this.a.Q1().getForum() != null && this.a.Q1().getForum().getId() != null) {
                            valueOf3 = this.a.Q1().getForum().getId();
                        }
                        this.o.b(arrayList2, z2, String.valueOf(valueOf3));
                    }
                } else {
                    u18 u18Var8 = this.a;
                    if (u18Var8 != null) {
                        FrsViewData Q13 = u18Var8.Q1();
                        if (this.j && Q13 != null && (this.a instanceof t06)) {
                            ArrayList<pi> arrayList6 = new ArrayList<>(this.d);
                            arrayList6.addAll(this.f);
                            Q13.addRecommendAppToThreadList((t06) this.a, true, arrayList2, arrayList6, z2);
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
            ArrayList<pi> arrayList7 = new ArrayList<>();
            arrayList7.addAll(this.d);
            arrayList7.addAll(this.f);
            u18 u18Var9 = this.a;
            if (u18Var9 instanceof t06) {
                d68.b((t06) u18Var9, u18Var9.Q1(), arrayList2, getPn());
                d68.c(ewaVar, arrayList2, arrayList7);
            }
            return arrayList7;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public final String W(List<Long> list) {
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

    public int X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.loadIndex = 0;
            this.loadingDone = false;
            this.d.clear();
            this.e.clear();
            this.f.clear();
            this.i = -1;
            this.h = 1;
        }
    }

    public void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            registerListener(this.p);
        }
    }

    public final void Y(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, loadMoreHttpResponseMessage) == null) && !this.b) {
            this.b = true;
            if (!PerformanceLoggerHelper.getInstance().isSmallFlow()) {
                return;
            }
            new tp5(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.c).c();
        }
    }

    public final void a0(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, loadMoreResponseSocketMessage) == null) && !this.b) {
            this.b = true;
            if (!PerformanceLoggerHelper.getInstance().isSmallFlow()) {
                return;
            }
            new tp5(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.c).c();
        }
    }

    public void Z(boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, responsedMessage) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && (this.a instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.c;
            tp5 tp5Var = new tp5(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.a).D, false, 0L, 0L, currentTimeMillis);
            tp5Var.B = currentTimeMillis;
            tp5Var.e(true);
        }
    }

    public final void c0(ArrayList<pi> arrayList, String str) {
        lwa lwaVar;
        lwa lwaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, arrayList, str) == null) {
            Iterator<pi> it = arrayList.iterator();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                i++;
                pi next = it.next();
                if (StringUtils.isNull(str)) {
                    if (!(next instanceof q06) && !(next instanceof l36)) {
                        if ((next instanceof ThreadData) && (lwaVar = ((ThreadData) next).funAdData) != null) {
                            lwaVar.p(true);
                            it.remove();
                        }
                    } else {
                        it.remove();
                    }
                } else {
                    if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof l36)) {
                        it.remove();
                    }
                    if (next instanceof q06) {
                        q06 q06Var = (q06) next;
                        if ((q06Var.a() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) q06Var.a()).a)) {
                            it.remove();
                            i2 = i;
                        }
                    } else if ((next instanceof ThreadData) && (lwaVar2 = ((ThreadData) next).funAdData) != null && lwaVar2.i()) {
                        it.remove();
                        i3 = i;
                    }
                }
            }
        }
    }

    public ArrayList<pi> f0() {
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
            ArrayList<pi> arrayList = new ArrayList<>();
            arrayList.addAll(this.d);
            arrayList.addAll(this.f);
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void g0(long j, List<Long> list, String str, int i, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j), list, str, Integer.valueOf(i), Boolean.valueOf(z), str2}) == null) {
            if (j != 0 && !ListUtils.isEmpty(list)) {
                String W = W(list);
                if (TextUtils.isEmpty(W)) {
                    return;
                }
                this.k = j;
                LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
                loadMoreRequestMessage.setForumId(j);
                loadMoreRequestMessage.setThreadIds(W);
                loadMoreRequestMessage.setNeedAbstract(0);
                loadMoreRequestMessage.setForumName(str);
                loadMoreRequestMessage.setPageNumber(i);
                loadMoreRequestMessage.setLastClickTid(JavaTypesHelper.toLong(ju5.a(), 0L));
                loadMoreRequestMessage.setSortType(this.g);
                loadMoreRequestMessage.setPageType(this.l);
                loadMoreRequestMessage.setAdFloorInfo(str2);
                loadMoreRequestMessage.setBrandForum(z);
                if (!TextUtils.isEmpty(str)) {
                    R(str, loadMoreRequestMessage);
                }
                int i2 = q;
                q = i2 + 1;
                loadMoreRequestMessage.setRequestTimes(i2);
                sendMessage(loadMoreRequestMessage);
                this.isLoading = true;
                this.c = System.currentTimeMillis();
                s88.a();
                return;
            }
            this.loadingDone = true;
        }
    }
}
