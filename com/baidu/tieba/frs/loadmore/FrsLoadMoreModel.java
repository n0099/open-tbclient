package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.bq4;
import com.repackage.d9;
import com.repackage.jl6;
import com.repackage.kh8;
import com.repackage.ml6;
import com.repackage.n85;
import com.repackage.ng;
import com.repackage.nh5;
import com.repackage.nn;
import com.repackage.no6;
import com.repackage.pq6;
import com.repackage.qh5;
import com.repackage.ul6;
import com.repackage.uq6;
import com.repackage.x88;
import com.repackage.xc5;
import com.repackage.za;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tbclient.AdMixFloor;
/* loaded from: classes3.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    public transient /* synthetic */ FieldHolder $fh;
    public final jl6 a;
    public boolean b;
    public long c;
    public final ArrayList<nn> d;
    public final ArrayList<String> e;
    public final ArrayList<nn> f;
    public int g;
    public int h;
    public int i;
    public boolean isLoading;
    public boolean j;
    public long k;
    public int l;
    public int loadIndex;
    public boolean loadingDone;
    public ul6 m;
    public ml6.b n;
    public uq6 o;
    public final za p;

    /* loaded from: classes3.dex */
    public class a extends za {
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

        @Override // com.repackage.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || this.a.a == null) {
                return;
            }
            FrsLoadMoreModel frsLoadMoreModel = this.a;
            frsLoadMoreModel.isLoading = false;
            if (responsedMessage == null) {
                frsLoadMoreModel.a.onFailed(this.a.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c37));
            } else if (responsedMessage.getError() != 0) {
                if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                    this.a.a.onFailed(responsedMessage.getErrorString());
                } else {
                    this.a.a.onFailed(this.a.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c37));
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                FrsViewData P0 = this.a.a.P0();
                if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                    LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                    if (P0 != null) {
                        P0.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                    }
                    this.a.a.h(loadMoreHttpResponseMessage.getThreadList());
                    if (this.a.a instanceof FrsFragment) {
                        ((FrsFragment) this.a.a).D = System.currentTimeMillis() - currentTimeMillis;
                        this.a.K(true, responsedMessage);
                    }
                    this.a.J(loadMoreHttpResponseMessage);
                } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                    LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                    if (P0 != null) {
                        P0.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                    }
                    this.a.a.h(loadMoreResponseSocketMessage.getThreadList());
                    if (this.a.a instanceof FrsFragment) {
                        ((FrsFragment) this.a.a).D = System.currentTimeMillis() - currentTimeMillis;
                        this.a.K(false, responsedMessage);
                    }
                    this.a.L(loadMoreResponseSocketMessage);
                }
                if (!TextUtils.isEmpty(this.a.a.c()) && x88.l().b() != null) {
                    x88.l().b().g(this.a.a.c(), 2, false);
                }
                this.a.loadIndex++;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void h(ArrayList<nn> arrayList);

        void onFailed(String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsLoadMoreModel(jl6 jl6Var, ul6 ul6Var) {
        super(jl6Var.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jl6Var, ul6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
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
        this.a = jl6Var;
        setUniqueId(jl6Var.getUniqueId());
        this.m = ul6Var;
        this.p.getHttpMessageListener().setSelfListener(true);
        this.p.getSocketMessageListener().setSelfListener(true);
        registerListener(this.p);
    }

    public final void C(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, loadMoreRequestMessage) == null) || x88.l().b() == null) {
            return;
        }
        loadMoreRequestMessage.setLoadCount(x88.l().b().e(str, false) + 1);
    }

    public boolean D(List<Long> list) {
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

    public void E() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int size = this.f.size() + 30;
            int a2 = TbadkCoreApplication.getInst().getListItemRule().a() * 3;
            int count = ListUtils.getCount(this.d);
            if (size <= a2 || this.f.size() <= (i = size - a2)) {
                return;
            }
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<nn> arrayList = new ArrayList<>();
                arrayList.add(this.f.remove(0));
                ArrayList<nn> arrayList2 = null;
                jl6 jl6Var = this.a;
                if (jl6Var != null && jl6Var.P0() != null) {
                    arrayList2 = this.a.P0().switchThreadDataToThreadCardInfo(arrayList);
                }
                if (arrayList2 != null) {
                    for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                        ml6.b bVar = this.n;
                        if (bVar != null) {
                            bVar.removeItem(count + i3);
                        }
                    }
                }
            }
        }
    }

    public final void F(@NonNull ArrayList<nn> arrayList, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, arrayList, str) == null) {
            Iterator<nn> it = arrayList.iterator();
            while (it.hasNext()) {
                nn next = it.next();
                if ((next instanceof ThreadData) && TextUtils.equals(str, ((ThreadData) next).getTid())) {
                    it.remove();
                }
            }
        }
    }

    public ArrayList<nn> G(boolean z, boolean z2, boolean z3, ArrayList<nn> arrayList, kh8 kh8Var, List<AdMixFloor> list, int i) {
        InterceptResult invokeCommon;
        jl6 jl6Var;
        jl6 jl6Var2;
        jl6 jl6Var3;
        jl6 jl6Var4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), arrayList, kh8Var, list, Integer.valueOf(i)})) == null) {
            if (z3) {
                this.d.clear();
                this.e.clear();
                this.f.clear();
            }
            HashSet hashSet = new HashSet();
            Iterator<nn> it = this.d.iterator();
            while (it.hasNext()) {
                nn next = it.next();
                if (next instanceof bq4) {
                    ThreadData threadData = ((bq4) next).s;
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
            ArrayList<nn> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            if (!ListUtils.isEmpty(arrayList)) {
                Iterator<nn> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    nn next2 = it2.next();
                    if (next2 instanceof bq4) {
                        bq4 bq4Var = (bq4) next2;
                        ThreadData threadData3 = bq4Var.s;
                        threadData3.setForum_name(this.a.c());
                        jl6 jl6Var5 = this.a;
                        if (jl6Var5 != null && jl6Var5.P0() != null && this.a.P0().getForum() != null) {
                            if (!StringUtils.isNull(this.a.P0().getForum().getFirst_class())) {
                                threadData3.setFirstClassName(this.a.P0().getForum().getFirst_class());
                            }
                            if (!StringUtils.isNull(this.a.P0().getForum().getSecond_class())) {
                                threadData3.setSecondClassName(this.a.P0().getForum().getSecond_class());
                            }
                        }
                        if (threadData3.isNeedCheckRepeat()) {
                            if (!hashSet.contains(threadData3.getTid())) {
                                arrayList2.add(next2);
                                if (!arrayList3.contains(bq4Var.s.tid)) {
                                    arrayList3.add(bq4Var.s.tid);
                                }
                            }
                        } else {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(bq4Var.s.tid)) {
                                arrayList3.add(bq4Var.s.tid);
                            }
                        }
                    } else if (next2 instanceof ThreadData) {
                        ThreadData threadData4 = (ThreadData) next2;
                        threadData4.setForum_name(this.a.c());
                        jl6 jl6Var6 = this.a;
                        if (jl6Var6 != null && jl6Var6.P0() != null && this.a.P0().getForum() != null) {
                            if (!StringUtils.isNull(this.a.P0().getForum().getFirst_class())) {
                                threadData4.setFirstClassName(this.a.P0().getForum().getFirst_class());
                            }
                            if (!StringUtils.isNull(this.a.P0().getForum().getSecond_class())) {
                                threadData4.setSecondClassName(this.a.P0().getForum().getSecond_class());
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
                if (i == 1) {
                    jl6 jl6Var7 = this.a;
                    if (jl6Var7 != null) {
                        FrsViewData P0 = jl6Var7.P0();
                        if (this.j && P0 != null && (this.a instanceof qh5)) {
                            ArrayList<nn> arrayList4 = new ArrayList<>(this.d);
                            arrayList4.addAll(this.f);
                            P0.addRecommendAppToThreadList((qh5) this.a, true, arrayList2, arrayList4, z2);
                        }
                    }
                } else if (i != 2) {
                    if (i != 3) {
                        if (uq6.d()) {
                            if (this.o != null) {
                                String valueOf = String.valueOf(this.k);
                                if (this.k == 0 && (jl6Var4 = this.a) != null && jl6Var4.P0() != null && this.a.P0().getForum() != null && this.a.P0().getForum().getId() != null) {
                                    valueOf = this.a.P0().getForum().getId();
                                }
                                this.o.b(arrayList2, z3, valueOf);
                            }
                        } else {
                            jl6 jl6Var8 = this.a;
                            if (jl6Var8 != null) {
                                FrsViewData P02 = jl6Var8.P0();
                                if (this.j && P02 != null && (this.a instanceof qh5)) {
                                    ArrayList<nn> arrayList5 = new ArrayList<>(this.d);
                                    arrayList5.addAll(this.f);
                                    P02.addRecommendAppToThreadList((qh5) this.a, true, arrayList2, arrayList5, z2);
                                }
                            }
                        }
                    } else if (!ListUtils.isEmpty(list)) {
                        int intValue = list.get(0).ad_type.intValue();
                        if (intValue == 1 && (jl6Var3 = this.a) != null) {
                            FrsViewData P03 = jl6Var3.P0();
                            if (this.j && P03 != null && (this.a instanceof qh5)) {
                                ArrayList<nn> arrayList6 = new ArrayList<>(this.d);
                                arrayList6.addAll(this.f);
                                P03.addRecommendAppToThreadList((qh5) this.a, true, arrayList2, arrayList6, z2);
                            }
                        } else if (intValue == 2 && this.o != null) {
                            String valueOf2 = String.valueOf(this.k);
                            if (this.k == 0 && (jl6Var2 = this.a) != null && jl6Var2.P0() != null && this.a.P0().getForum() != null && this.a.P0().getForum().getId() != null) {
                                valueOf2 = this.a.P0().getForum().getId();
                            }
                            this.o.g(arrayList2, list, z3, String.valueOf(valueOf2));
                        }
                    }
                } else if (this.o != null) {
                    String valueOf3 = String.valueOf(this.k);
                    if (this.k == 0 && (jl6Var = this.a) != null && jl6Var.P0() != null && this.a.P0().getForum() != null && this.a.P0().getForum().getId() != null) {
                        valueOf3 = this.a.P0().getForum().getId();
                    }
                    this.o.b(arrayList2, z2, String.valueOf(valueOf3));
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
            ArrayList<nn> arrayList7 = new ArrayList<>();
            arrayList7.addAll(this.d);
            arrayList7.addAll(this.f);
            jl6 jl6Var9 = this.a;
            if (jl6Var9 instanceof qh5) {
                no6.b((qh5) jl6Var9, jl6Var9.P0(), arrayList2, getPn());
                no6.c(kh8Var, arrayList2, arrayList7);
            }
            return arrayList7;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public final String H(List<Long> list) {
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

    public int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.i : invokeV.intValue;
    }

    public final void J(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, loadMoreHttpResponseMessage) == null) || this.b) {
            return;
        }
        this.b = true;
        if (PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            new n85(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.c).c();
        }
    }

    public void K(boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, responsedMessage) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && (this.a instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.c;
            n85 n85Var = new n85(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.a).D, false, 0L, 0L, currentTimeMillis);
            n85Var.B = currentTimeMillis;
            n85Var.e(true);
        }
    }

    public final void L(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, loadMoreResponseSocketMessage) == null) || this.b) {
            return;
        }
        this.b = true;
        if (PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            new n85(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.c).c();
        }
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (!ListUtils.isEmpty(this.d)) {
            N(this.d, str);
        }
        if (ListUtils.isEmpty(this.f)) {
            return;
        }
        N(this.f, str);
    }

    public final void N(ArrayList<nn> arrayList, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, arrayList, str) == null) {
            Iterator<nn> it = arrayList.iterator();
            while (it.hasNext()) {
                nn next = it.next();
                if (next instanceof nh5) {
                    nh5 nh5Var = (nh5) next;
                    if ((nh5Var.a() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) nh5Var.a()).a)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void O(nn nnVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, nnVar) == null) || nnVar == null) {
            return;
        }
        ArrayList<nn> arrayList = this.d;
        if (arrayList != null) {
            arrayList.remove(nnVar);
        }
        ArrayList<nn> arrayList2 = this.f;
        if (arrayList2 != null) {
            arrayList2.remove(nnVar);
        }
    }

    public void P(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            ArrayList<nn> arrayList = this.d;
            if (arrayList != null) {
                F(arrayList, str);
            }
            ArrayList<nn> arrayList2 = this.f;
            if (arrayList2 != null) {
                F(arrayList2, str);
            }
        }
    }

    public ArrayList<nn> Q() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            int size = this.f.size() + 30;
            int a2 = TbadkCoreApplication.getInst().getListItemRule().a() * 3;
            if (size > a2 && this.f.size() > (i = size - a2)) {
                for (int i2 = 0; i2 < i; i2++) {
                    this.f.remove(0);
                }
            }
            ArrayList<nn> arrayList = new ArrayList<>();
            arrayList.addAll(this.d);
            arrayList.addAll(this.f);
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void R(long j, List<Long> list, String str, int i, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j), list, str, Integer.valueOf(i), Boolean.valueOf(z), str2}) == null) {
            if (j != 0 && !ListUtils.isEmpty(list)) {
                String H = H(list);
                if (TextUtils.isEmpty(H)) {
                    return;
                }
                this.k = j;
                LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
                loadMoreRequestMessage.setForumId(j);
                loadMoreRequestMessage.setThreadIds(H);
                loadMoreRequestMessage.setNeedAbstract(0);
                loadMoreRequestMessage.setForumName(str);
                loadMoreRequestMessage.setPageNumber(i);
                loadMoreRequestMessage.setLastClickTid(ng.g(xc5.a(), 0L));
                loadMoreRequestMessage.setSortType(this.g);
                loadMoreRequestMessage.setPageType(this.l);
                loadMoreRequestMessage.setAdFloorInfo(str2);
                loadMoreRequestMessage.setBrandForum(z);
                if (!TextUtils.isEmpty(str)) {
                    C(str, loadMoreRequestMessage);
                }
                sendMessage(loadMoreRequestMessage);
                this.isLoading = true;
                this.c = System.currentTimeMillis();
                pq6.a();
                return;
            }
            this.loadingDone = true;
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.loadIndex = 0;
            this.loadingDone = false;
            this.d.clear();
            this.e.clear();
            this.f.clear();
            this.i = -1;
            this.h = 1;
        }
    }

    public void T(uq6 uq6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, uq6Var) == null) {
            this.o = uq6Var;
        }
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.j = z;
        }
    }

    public void V(ml6.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bVar) == null) {
            this.n = bVar;
        }
    }

    public void W(int i) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.h : invokeV.intValue;
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
            this.h = i;
        }
    }

    public void setSortType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.g = i;
        }
    }
}
