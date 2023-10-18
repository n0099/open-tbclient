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
import com.baidu.tieba.cs5;
import com.baidu.tieba.ct7;
import com.baidu.tieba.f16;
import com.baidu.tieba.fea;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.jm7;
import com.baidu.tieba.kq7;
import com.baidu.tieba.ky5;
import com.baidu.tieba.mm7;
import com.baidu.tieba.mn5;
import com.baidu.tieba.nea;
import com.baidu.tieba.ny5;
import com.baidu.tieba.py4;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tz9;
import com.baidu.tieba.um7;
import com.baidu.tieba.xs7;
import com.baidu.tieba.yh;
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
    public final jm7 a;
    public boolean b;
    public long c;
    public final ArrayList<yh> d;
    public final ArrayList<String> e;
    public final ArrayList<yh> f;
    public int g;
    public int h;
    public int i;
    public boolean isLoading;
    public boolean j;
    public long k;
    public int l;
    public int loadIndex;
    public boolean loadingDone;
    public um7 m;
    public mm7.b n;
    public ct7 o;
    public final NetMessageListener p;

    /* loaded from: classes6.dex */
    public interface b {
        void n(ArrayList<yh> arrayList);

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
                frsLoadMoreModel.a.onFailed(this.a.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e4f));
            } else if (responsedMessage.getError() != 0) {
                if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                    this.a.a.onFailed(responsedMessage.getErrorString());
                } else {
                    this.a.a.onFailed(this.a.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e4f));
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                FrsViewData s1 = this.a.a.s1();
                if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                    LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                    if (s1 != null) {
                        s1.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                    }
                    this.a.a.n(loadMoreHttpResponseMessage.getThreadList());
                    if (this.a.a instanceof FrsFragment) {
                        ((FrsFragment) this.a.a).D = System.currentTimeMillis() - currentTimeMillis;
                        this.a.Y(true, responsedMessage);
                    }
                    this.a.X(loadMoreHttpResponseMessage);
                } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                    LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                    if (s1 != null) {
                        s1.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                    }
                    this.a.a.n(loadMoreResponseSocketMessage.getThreadList());
                    if (this.a.a instanceof FrsFragment) {
                        ((FrsFragment) this.a.a).D = System.currentTimeMillis() - currentTimeMillis;
                        this.a.Y(false, responsedMessage);
                    }
                    this.a.Z(loadMoreResponseSocketMessage);
                }
                if (!TextUtils.isEmpty(this.a.a.v()) && tz9.m().b() != null) {
                    tz9.m().b().g(this.a.a.v(), 2, false);
                }
                this.a.loadIndex++;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsLoadMoreModel(jm7 jm7Var, um7 um7Var) {
        super(jm7Var.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jm7Var, um7Var};
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
        this.a = jm7Var;
        setUniqueId(jm7Var.getUniqueId());
        this.m = um7Var;
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

    public void c0(yh yhVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, yhVar) != null) || yhVar == null) {
            return;
        }
        ArrayList<yh> arrayList = this.d;
        if (arrayList != null) {
            arrayList.remove(yhVar);
        }
        ArrayList<yh> arrayList2 = this.f;
        if (arrayList2 != null) {
            arrayList2.remove(yhVar);
        }
    }

    public void d0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            ArrayList<yh> arrayList = this.d;
            if (arrayList != null) {
                T(arrayList, str);
            }
            ArrayList<yh> arrayList2 = this.f;
            if (arrayList2 != null) {
                T(arrayList2, str);
            }
        }
    }

    public void h0(ct7 ct7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, ct7Var) == null) {
            this.o = ct7Var;
        }
    }

    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.j = z;
        }
    }

    public void j0(mm7.b bVar) {
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
        if ((interceptable != null && interceptable.invokeLL(1048576, this, str, loadMoreRequestMessage) != null) || tz9.m().b() == null) {
            return;
        }
        loadMoreRequestMessage.setLoadCount(tz9.m().b().e(str, false) + 1);
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
                    ArrayList<yh> arrayList = new ArrayList<>();
                    arrayList.add(this.f.remove(0));
                    ArrayList<yh> arrayList2 = null;
                    jm7 jm7Var = this.a;
                    if (jm7Var != null && jm7Var.s1() != null) {
                        arrayList2 = this.a.s1().switchThreadDataToThreadCardInfo(arrayList);
                    }
                    if (arrayList2 != null) {
                        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                            mm7.b bVar = this.n;
                            if (bVar != null) {
                                bVar.removeItem(count + i3);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void T(@NonNull ArrayList<yh> arrayList, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, arrayList, str) == null) {
            Iterator<yh> it = arrayList.iterator();
            while (it.hasNext()) {
                yh next = it.next();
                if ((next instanceof ThreadData) && TextUtils.equals(str, ((ThreadData) next).getTid())) {
                    it.remove();
                }
            }
        }
    }

    public ArrayList<yh> U(boolean z, boolean z2, boolean z3, ArrayList<yh> arrayList, fea feaVar, List<AdMixFloor> list, int i) {
        InterceptResult invokeCommon;
        jm7 jm7Var;
        jm7 jm7Var2;
        jm7 jm7Var3;
        jm7 jm7Var4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), arrayList, feaVar, list, Integer.valueOf(i)})) == null) {
            if (z3) {
                this.d.clear();
                this.e.clear();
                this.f.clear();
            }
            HashSet hashSet = new HashSet();
            Iterator<yh> it = this.d.iterator();
            while (it.hasNext()) {
                yh next = it.next();
                if (next instanceof py4) {
                    ThreadData threadData = ((py4) next).t;
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
            ArrayList<yh> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            if (!ListUtils.isEmpty(arrayList)) {
                Iterator<yh> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    yh next2 = it2.next();
                    if (next2 instanceof py4) {
                        py4 py4Var = (py4) next2;
                        ThreadData threadData3 = py4Var.t;
                        threadData3.setForum_name(this.a.v());
                        jm7 jm7Var5 = this.a;
                        if (jm7Var5 != null && jm7Var5.s1() != null && this.a.s1().getForum() != null) {
                            if (!StringUtils.isNull(this.a.s1().getForum().getFirst_class())) {
                                threadData3.setFirstClassName(this.a.s1().getForum().getFirst_class());
                            }
                            if (!StringUtils.isNull(this.a.s1().getForum().getSecond_class())) {
                                threadData3.setSecondClassName(this.a.s1().getForum().getSecond_class());
                            }
                        }
                        if (threadData3.isNeedCheckRepeat()) {
                            if (!hashSet.contains(threadData3.getTid())) {
                                arrayList2.add(next2);
                                if (!arrayList3.contains(py4Var.t.tid)) {
                                    arrayList3.add(py4Var.t.tid);
                                }
                            }
                        } else {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(py4Var.t.tid)) {
                                arrayList3.add(py4Var.t.tid);
                            }
                        }
                    } else if (next2 instanceof ThreadData) {
                        ThreadData threadData4 = (ThreadData) next2;
                        threadData4.setForum_name(this.a.v());
                        jm7 jm7Var6 = this.a;
                        if (jm7Var6 != null && jm7Var6.s1() != null && this.a.s1().getForum() != null) {
                            if (!StringUtils.isNull(this.a.s1().getForum().getFirst_class())) {
                                threadData4.setFirstClassName(this.a.s1().getForum().getFirst_class());
                            }
                            if (!StringUtils.isNull(this.a.s1().getForum().getSecond_class())) {
                                threadData4.setSecondClassName(this.a.s1().getForum().getSecond_class());
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
                            if (ct7.d()) {
                                if (this.o != null) {
                                    String valueOf = String.valueOf(this.k);
                                    if (this.k == 0 && (jm7Var4 = this.a) != null && jm7Var4.s1() != null && this.a.s1().getForum() != null && this.a.s1().getForum().getId() != null) {
                                        valueOf = this.a.s1().getForum().getId();
                                    }
                                    this.o.b(arrayList2, z3, valueOf);
                                }
                            } else {
                                jm7 jm7Var7 = this.a;
                                if (jm7Var7 != null) {
                                    FrsViewData s1 = jm7Var7.s1();
                                    if (this.j && s1 != null && (this.a instanceof ny5)) {
                                        ArrayList<yh> arrayList4 = new ArrayList<>(this.d);
                                        arrayList4.addAll(this.f);
                                        s1.addRecommendAppToThreadList((ny5) this.a, true, arrayList2, arrayList4, z2);
                                    }
                                }
                            }
                        } else if (!ListUtils.isEmpty(list)) {
                            int intValue = list.get(0).ad_type.intValue();
                            if (intValue == 1 && (jm7Var3 = this.a) != null) {
                                FrsViewData s12 = jm7Var3.s1();
                                if (this.j && s12 != null && (this.a instanceof ny5)) {
                                    ArrayList<yh> arrayList5 = new ArrayList<>(this.d);
                                    arrayList5.addAll(this.f);
                                    s12.addRecommendAppToThreadList((ny5) this.a, true, arrayList2, arrayList5, z2);
                                }
                            } else if (intValue == 2 && this.o != null) {
                                String valueOf2 = String.valueOf(this.k);
                                if (this.k == 0 && (jm7Var2 = this.a) != null && jm7Var2.s1() != null && this.a.s1().getForum() != null && this.a.s1().getForum().getId() != null) {
                                    valueOf2 = this.a.s1().getForum().getId();
                                }
                                this.o.g(arrayList2, list, z3, String.valueOf(valueOf2));
                            }
                        }
                    } else if (this.o != null) {
                        String valueOf3 = String.valueOf(this.k);
                        if (this.k == 0 && (jm7Var = this.a) != null && jm7Var.s1() != null && this.a.s1().getForum() != null && this.a.s1().getForum().getId() != null) {
                            valueOf3 = this.a.s1().getForum().getId();
                        }
                        this.o.b(arrayList2, z2, String.valueOf(valueOf3));
                    }
                } else {
                    jm7 jm7Var8 = this.a;
                    if (jm7Var8 != null) {
                        FrsViewData s13 = jm7Var8.s1();
                        if (this.j && s13 != null && (this.a instanceof ny5)) {
                            ArrayList<yh> arrayList6 = new ArrayList<>(this.d);
                            arrayList6.addAll(this.f);
                            s13.addRecommendAppToThreadList((ny5) this.a, true, arrayList2, arrayList6, z2);
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
            ArrayList<yh> arrayList7 = new ArrayList<>();
            arrayList7.addAll(this.d);
            arrayList7.addAll(this.f);
            jm7 jm7Var9 = this.a;
            if (jm7Var9 instanceof ny5) {
                kq7.b((ny5) jm7Var9, jm7Var9.s1(), arrayList2, getPn());
                kq7.c(feaVar, arrayList2, arrayList7);
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
            new mn5(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.c).c();
        }
    }

    public final void Z(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, loadMoreResponseSocketMessage) == null) && !this.b) {
            this.b = true;
            if (!PerformanceLoggerHelper.getInstance().isSmallFlow()) {
                return;
            }
            new mn5(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.c).c();
        }
    }

    public void Y(boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, responsedMessage) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && (this.a instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.c;
            mn5 mn5Var = new mn5(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.a).D, false, 0L, 0L, currentTimeMillis);
            mn5Var.B = currentTimeMillis;
            mn5Var.e(true);
        }
    }

    public final void b0(ArrayList<yh> arrayList, String str) {
        nea neaVar;
        nea neaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, arrayList, str) == null) {
            Iterator<yh> it = arrayList.iterator();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                i++;
                yh next = it.next();
                if (StringUtils.isNull(str)) {
                    if (!(next instanceof ky5) && !(next instanceof f16)) {
                        if ((next instanceof ThreadData) && (neaVar = ((ThreadData) next).funAdData) != null) {
                            neaVar.p(true);
                            it.remove();
                        }
                    } else {
                        it.remove();
                    }
                } else {
                    if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof f16)) {
                        it.remove();
                    }
                    if (next instanceof ky5) {
                        ky5 ky5Var = (ky5) next;
                        if ((ky5Var.a() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) ky5Var.a()).a)) {
                            it.remove();
                            i2 = i;
                        }
                    } else if ((next instanceof ThreadData) && (neaVar2 = ((ThreadData) next).funAdData) != null && neaVar2.i()) {
                        it.remove();
                        i3 = i;
                    }
                }
            }
        }
    }

    public ArrayList<yh> e0() {
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
            ArrayList<yh> arrayList = new ArrayList<>();
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
                loadMoreRequestMessage.setLastClickTid(JavaTypesHelper.toLong(cs5.a(), 0L));
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
                xs7.a();
                return;
            }
            this.loadingDone = true;
        }
    }
}
