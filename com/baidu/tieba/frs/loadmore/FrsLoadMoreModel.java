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
import com.baidu.tieba.a46;
import com.baidu.tieba.bs7;
import com.baidu.tieba.cn;
import com.baidu.tieba.d46;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.ft5;
import com.baidu.tieba.h45;
import com.baidu.tieba.i3a;
import com.baidu.tieba.jha;
import com.baidu.tieba.ky7;
import com.baidu.tieba.py7;
import com.baidu.tieba.qr7;
import com.baidu.tieba.rha;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tr7;
import com.baidu.tieba.tx5;
import com.baidu.tieba.v66;
import com.baidu.tieba.yv7;
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
/* loaded from: classes5.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    public static int q = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final qr7 a;
    public boolean b;
    public long c;
    public final ArrayList<cn> d;
    public final ArrayList<String> e;
    public final ArrayList<cn> f;
    public int g;
    public int h;
    public int i;
    public boolean isLoading;
    public boolean j;
    public long k;
    public int l;
    public int loadIndex;
    public boolean loadingDone;
    public bs7 m;
    public tr7.b n;
    public py7 o;
    public final NetMessageListener p;

    /* loaded from: classes5.dex */
    public interface b {
        void l(ArrayList<cn> arrayList);

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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
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

    /* loaded from: classes5.dex */
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
                frsLoadMoreModel.a.onFailed(this.a.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e40));
            } else if (responsedMessage.getError() != 0) {
                if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                    this.a.a.onFailed(responsedMessage.getErrorString());
                } else {
                    this.a.a.onFailed(this.a.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e40));
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                FrsViewData m1 = this.a.a.m1();
                if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                    LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                    if (m1 != null) {
                        m1.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                    }
                    this.a.a.l(loadMoreHttpResponseMessage.getThreadList());
                    if (this.a.a instanceof FrsFragment) {
                        ((FrsFragment) this.a.a).D = System.currentTimeMillis() - currentTimeMillis;
                        this.a.X(true, responsedMessage);
                    }
                    this.a.W(loadMoreHttpResponseMessage);
                } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                    LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                    if (m1 != null) {
                        m1.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                    }
                    this.a.a.l(loadMoreResponseSocketMessage.getThreadList());
                    if (this.a.a instanceof FrsFragment) {
                        ((FrsFragment) this.a.a).D = System.currentTimeMillis() - currentTimeMillis;
                        this.a.X(false, responsedMessage);
                    }
                    this.a.Y(loadMoreResponseSocketMessage);
                }
                if (!TextUtils.isEmpty(this.a.a.v()) && i3a.m().b() != null) {
                    i3a.m().b().g(this.a.a.v(), 2, false);
                }
                this.a.loadIndex++;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsLoadMoreModel(qr7 qr7Var, bs7 bs7Var) {
        super(qr7Var.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qr7Var, bs7Var};
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
        this.a = qr7Var;
        setUniqueId(qr7Var.getUniqueId());
        this.m = bs7Var;
        this.p.getHttpMessageListener().setSelfListener(true);
        this.p.getSocketMessageListener().setSelfListener(true);
        registerListener(this.p);
    }

    public boolean Q(List<Long> list) {
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

    public void Z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            if (!ListUtils.isEmpty(this.d)) {
                a0(this.d, str);
            }
            if (!ListUtils.isEmpty(this.f)) {
                a0(this.f, str);
            }
        }
    }

    public void b0(cn cnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, cnVar) != null) || cnVar == null) {
            return;
        }
        ArrayList<cn> arrayList = this.d;
        if (arrayList != null) {
            arrayList.remove(cnVar);
        }
        ArrayList<cn> arrayList2 = this.f;
        if (arrayList2 != null) {
            arrayList2.remove(cnVar);
        }
    }

    public void c0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            ArrayList<cn> arrayList = this.d;
            if (arrayList != null) {
                S(arrayList, str);
            }
            ArrayList<cn> arrayList2 = this.f;
            if (arrayList2 != null) {
                S(arrayList2, str);
            }
        }
    }

    public void g0(py7 py7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, py7Var) == null) {
            this.o = py7Var;
        }
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.j = z;
        }
    }

    public void i0(tr7.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bVar) == null) {
            this.n = bVar;
        }
    }

    public void j0(int i) {
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

    public final void P(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, str, loadMoreRequestMessage) != null) || i3a.m().b() == null) {
            return;
        }
        loadMoreRequestMessage.setLoadCount(i3a.m().b().e(str, false) + 1);
    }

    public void R() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int size = this.f.size() + 30;
            int a2 = TbadkCoreApplication.getInst().getListItemRule().a() * 3;
            int count = ListUtils.getCount(this.d);
            if (size > a2 && this.f.size() > (i = size - a2)) {
                for (int i2 = 0; i2 < i; i2++) {
                    ArrayList<cn> arrayList = new ArrayList<>();
                    arrayList.add(this.f.remove(0));
                    ArrayList<cn> arrayList2 = null;
                    qr7 qr7Var = this.a;
                    if (qr7Var != null && qr7Var.m1() != null) {
                        arrayList2 = this.a.m1().switchThreadDataToThreadCardInfo(arrayList);
                    }
                    if (arrayList2 != null) {
                        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                            tr7.b bVar = this.n;
                            if (bVar != null) {
                                bVar.removeItem(count + i3);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void S(@NonNull ArrayList<cn> arrayList, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, arrayList, str) == null) {
            Iterator<cn> it = arrayList.iterator();
            while (it.hasNext()) {
                cn next = it.next();
                if ((next instanceof ThreadData) && TextUtils.equals(str, ((ThreadData) next).getTid())) {
                    it.remove();
                }
            }
        }
    }

    public ArrayList<cn> T(boolean z, boolean z2, boolean z3, ArrayList<cn> arrayList, jha jhaVar, List<AdMixFloor> list, int i) {
        InterceptResult invokeCommon;
        qr7 qr7Var;
        qr7 qr7Var2;
        qr7 qr7Var3;
        qr7 qr7Var4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), arrayList, jhaVar, list, Integer.valueOf(i)})) == null) {
            if (z3) {
                this.d.clear();
                this.e.clear();
                this.f.clear();
            }
            HashSet hashSet = new HashSet();
            Iterator<cn> it = this.d.iterator();
            while (it.hasNext()) {
                cn next = it.next();
                if (next instanceof h45) {
                    ThreadData threadData = ((h45) next).t;
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
            ArrayList<cn> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            if (!ListUtils.isEmpty(arrayList)) {
                Iterator<cn> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    cn next2 = it2.next();
                    if (next2 instanceof h45) {
                        h45 h45Var = (h45) next2;
                        ThreadData threadData3 = h45Var.t;
                        threadData3.setForum_name(this.a.v());
                        qr7 qr7Var5 = this.a;
                        if (qr7Var5 != null && qr7Var5.m1() != null && this.a.m1().getForum() != null) {
                            if (!StringUtils.isNull(this.a.m1().getForum().getFirst_class())) {
                                threadData3.setFirstClassName(this.a.m1().getForum().getFirst_class());
                            }
                            if (!StringUtils.isNull(this.a.m1().getForum().getSecond_class())) {
                                threadData3.setSecondClassName(this.a.m1().getForum().getSecond_class());
                            }
                        }
                        if (threadData3.isNeedCheckRepeat()) {
                            if (!hashSet.contains(threadData3.getTid())) {
                                arrayList2.add(next2);
                                if (!arrayList3.contains(h45Var.t.tid)) {
                                    arrayList3.add(h45Var.t.tid);
                                }
                            }
                        } else {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(h45Var.t.tid)) {
                                arrayList3.add(h45Var.t.tid);
                            }
                        }
                    } else if (next2 instanceof ThreadData) {
                        ThreadData threadData4 = (ThreadData) next2;
                        threadData4.setForum_name(this.a.v());
                        qr7 qr7Var6 = this.a;
                        if (qr7Var6 != null && qr7Var6.m1() != null && this.a.m1().getForum() != null) {
                            if (!StringUtils.isNull(this.a.m1().getForum().getFirst_class())) {
                                threadData4.setFirstClassName(this.a.m1().getForum().getFirst_class());
                            }
                            if (!StringUtils.isNull(this.a.m1().getForum().getSecond_class())) {
                                threadData4.setSecondClassName(this.a.m1().getForum().getSecond_class());
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
                            if (py7.d()) {
                                if (this.o != null) {
                                    String valueOf = String.valueOf(this.k);
                                    if (this.k == 0 && (qr7Var4 = this.a) != null && qr7Var4.m1() != null && this.a.m1().getForum() != null && this.a.m1().getForum().getId() != null) {
                                        valueOf = this.a.m1().getForum().getId();
                                    }
                                    this.o.b(arrayList2, z3, valueOf);
                                }
                            } else {
                                qr7 qr7Var7 = this.a;
                                if (qr7Var7 != null) {
                                    FrsViewData m1 = qr7Var7.m1();
                                    if (this.j && m1 != null && (this.a instanceof d46)) {
                                        ArrayList<cn> arrayList4 = new ArrayList<>(this.d);
                                        arrayList4.addAll(this.f);
                                        m1.addRecommendAppToThreadList((d46) this.a, true, arrayList2, arrayList4, z2);
                                    }
                                }
                            }
                        } else if (!ListUtils.isEmpty(list)) {
                            int intValue = list.get(0).ad_type.intValue();
                            if (intValue == 1 && (qr7Var3 = this.a) != null) {
                                FrsViewData m12 = qr7Var3.m1();
                                if (this.j && m12 != null && (this.a instanceof d46)) {
                                    ArrayList<cn> arrayList5 = new ArrayList<>(this.d);
                                    arrayList5.addAll(this.f);
                                    m12.addRecommendAppToThreadList((d46) this.a, true, arrayList2, arrayList5, z2);
                                }
                            } else if (intValue == 2 && this.o != null) {
                                String valueOf2 = String.valueOf(this.k);
                                if (this.k == 0 && (qr7Var2 = this.a) != null && qr7Var2.m1() != null && this.a.m1().getForum() != null && this.a.m1().getForum().getId() != null) {
                                    valueOf2 = this.a.m1().getForum().getId();
                                }
                                this.o.g(arrayList2, list, z3, String.valueOf(valueOf2));
                            }
                        }
                    } else if (this.o != null) {
                        String valueOf3 = String.valueOf(this.k);
                        if (this.k == 0 && (qr7Var = this.a) != null && qr7Var.m1() != null && this.a.m1().getForum() != null && this.a.m1().getForum().getId() != null) {
                            valueOf3 = this.a.m1().getForum().getId();
                        }
                        this.o.b(arrayList2, z2, String.valueOf(valueOf3));
                    }
                } else {
                    qr7 qr7Var8 = this.a;
                    if (qr7Var8 != null) {
                        FrsViewData m13 = qr7Var8.m1();
                        if (this.j && m13 != null && (this.a instanceof d46)) {
                            ArrayList<cn> arrayList6 = new ArrayList<>(this.d);
                            arrayList6.addAll(this.f);
                            m13.addRecommendAppToThreadList((d46) this.a, true, arrayList2, arrayList6, z2);
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
            ArrayList<cn> arrayList7 = new ArrayList<>();
            arrayList7.addAll(this.d);
            arrayList7.addAll(this.f);
            qr7 qr7Var9 = this.a;
            if (qr7Var9 instanceof d46) {
                yv7.b((d46) qr7Var9, qr7Var9.m1(), arrayList2, getPn());
                yv7.c(jhaVar, arrayList2, arrayList7);
            }
            return arrayList7;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public final String U(List<Long> list) {
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

    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public void f0() {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
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

    public final void W(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, loadMoreHttpResponseMessage) == null) && !this.b) {
            this.b = true;
            if (!PerformanceLoggerHelper.getInstance().isSmallFlow()) {
                return;
            }
            new ft5(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.c).c();
        }
    }

    public final void Y(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, loadMoreResponseSocketMessage) == null) && !this.b) {
            this.b = true;
            if (!PerformanceLoggerHelper.getInstance().isSmallFlow()) {
                return;
            }
            new ft5(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.c).c();
        }
    }

    public void X(boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, responsedMessage) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && (this.a instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.c;
            ft5 ft5Var = new ft5(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.a).D, false, 0L, 0L, currentTimeMillis);
            ft5Var.B = currentTimeMillis;
            ft5Var.e(true);
        }
    }

    public final void a0(ArrayList<cn> arrayList, String str) {
        rha rhaVar;
        rha rhaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, arrayList, str) == null) {
            Iterator<cn> it = arrayList.iterator();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                i++;
                cn next = it.next();
                if (StringUtils.isNull(str)) {
                    if (!(next instanceof a46) && !(next instanceof v66)) {
                        if ((next instanceof ThreadData) && (rhaVar = ((ThreadData) next).funAdData) != null) {
                            rhaVar.p(true);
                            it.remove();
                        }
                    } else {
                        it.remove();
                    }
                } else {
                    if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof v66)) {
                        it.remove();
                    }
                    if (next instanceof a46) {
                        a46 a46Var = (a46) next;
                        if ((a46Var.a() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) a46Var.a()).a)) {
                            it.remove();
                            i2 = i;
                        }
                    } else if ((next instanceof ThreadData) && (rhaVar2 = ((ThreadData) next).funAdData) != null && rhaVar2.i()) {
                        it.remove();
                        i3 = i;
                    }
                }
            }
        }
    }

    public ArrayList<cn> d0() {
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
            ArrayList<cn> arrayList = new ArrayList<>();
            arrayList.addAll(this.d);
            arrayList.addAll(this.f);
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void e0(long j, List<Long> list, String str, int i, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j), list, str, Integer.valueOf(i), Boolean.valueOf(z), str2}) == null) {
            if (j != 0 && !ListUtils.isEmpty(list)) {
                String U = U(list);
                if (TextUtils.isEmpty(U)) {
                    return;
                }
                this.k = j;
                LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
                loadMoreRequestMessage.setForumId(j);
                loadMoreRequestMessage.setThreadIds(U);
                loadMoreRequestMessage.setNeedAbstract(0);
                loadMoreRequestMessage.setForumName(str);
                loadMoreRequestMessage.setPageNumber(i);
                loadMoreRequestMessage.setLastClickTid(JavaTypesHelper.toLong(tx5.a(), 0L));
                loadMoreRequestMessage.setSortType(this.g);
                loadMoreRequestMessage.setPageType(this.l);
                loadMoreRequestMessage.setAdFloorInfo(str2);
                loadMoreRequestMessage.setBrandForum(z);
                if (!TextUtils.isEmpty(str)) {
                    P(str, loadMoreRequestMessage);
                }
                int i2 = q;
                q = i2 + 1;
                loadMoreRequestMessage.setRequestTimes(i2);
                sendMessage(loadMoreRequestMessage);
                this.isLoading = true;
                this.c = System.currentTimeMillis();
                ky7.a();
                return;
            }
            this.loadingDone = true;
        }
    }
}
