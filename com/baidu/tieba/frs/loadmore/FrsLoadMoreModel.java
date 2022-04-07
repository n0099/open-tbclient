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
import com.repackage.an6;
import com.repackage.b9;
import com.repackage.bq6;
import com.repackage.dh5;
import com.repackage.es6;
import com.repackage.fa8;
import com.repackage.gh5;
import com.repackage.in6;
import com.repackage.js6;
import com.repackage.mg;
import com.repackage.mk8;
import com.repackage.p85;
import com.repackage.rq4;
import com.repackage.uo;
import com.repackage.wa;
import com.repackage.xc5;
import com.repackage.xm6;
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
    public final xm6 a;
    public boolean b;
    public long c;
    public final ArrayList<uo> d;
    public final ArrayList<String> e;
    public final ArrayList<uo> f;
    public int g;
    public int h;
    public int i;
    public boolean isLoading;
    public boolean j;
    public long k;
    public int l;
    public int loadIndex;
    public boolean loadingDone;
    public in6 m;
    public an6.b n;
    public js6 o;
    public final wa p;

    /* loaded from: classes3.dex */
    public class a extends wa {
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

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || this.a.a == null) {
                return;
            }
            FrsLoadMoreModel frsLoadMoreModel = this.a;
            frsLoadMoreModel.isLoading = false;
            if (responsedMessage == null) {
                frsLoadMoreModel.a.onFailed(this.a.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c18));
            } else if (responsedMessage.getError() != 0) {
                if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                    this.a.a.onFailed(responsedMessage.getErrorString());
                } else {
                    this.a.a.onFailed(this.a.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c18));
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                FrsViewData g0 = this.a.a.g0();
                if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                    LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                    if (g0 != null) {
                        g0.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                    }
                    this.a.a.e(loadMoreHttpResponseMessage.getThreadList());
                    if (this.a.a instanceof FrsFragment) {
                        ((FrsFragment) this.a.a).D = System.currentTimeMillis() - currentTimeMillis;
                        this.a.J(true, responsedMessage);
                    }
                    this.a.I(loadMoreHttpResponseMessage);
                } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                    LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                    if (g0 != null) {
                        g0.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                    }
                    this.a.a.e(loadMoreResponseSocketMessage.getThreadList());
                    if (this.a.a instanceof FrsFragment) {
                        ((FrsFragment) this.a.a).D = System.currentTimeMillis() - currentTimeMillis;
                        this.a.J(false, responsedMessage);
                    }
                    this.a.K(loadMoreResponseSocketMessage);
                }
                if (!TextUtils.isEmpty(this.a.a.a()) && fa8.q().b() != null) {
                    fa8.q().b().g(this.a.a.a(), 2, false);
                }
                this.a.loadIndex++;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void e(ArrayList<uo> arrayList);

        void onFailed(String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsLoadMoreModel(xm6 xm6Var, in6 in6Var) {
        super(xm6Var.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xm6Var, in6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
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
        this.a = xm6Var;
        setUniqueId(xm6Var.getUniqueId());
        this.m = in6Var;
        this.p.getHttpMessageListener().setSelfListener(true);
        this.p.getSocketMessageListener().setSelfListener(true);
        registerListener(this.p);
    }

    public final void B(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, loadMoreRequestMessage) == null) || fa8.q().b() == null) {
            return;
        }
        loadMoreRequestMessage.setLoadCount(fa8.q().b().e(str, false) + 1);
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
            int size = this.f.size() + 30;
            int a2 = TbadkCoreApplication.getInst().getListItemRule().a() * 3;
            int count = ListUtils.getCount(this.d);
            if (size <= a2 || this.f.size() <= (i = size - a2)) {
                return;
            }
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<uo> arrayList = new ArrayList<>();
                arrayList.add(this.f.remove(0));
                ArrayList<uo> arrayList2 = null;
                xm6 xm6Var = this.a;
                if (xm6Var != null && xm6Var.g0() != null) {
                    arrayList2 = this.a.g0().switchThreadDataToThreadCardInfo(arrayList);
                }
                if (arrayList2 != null) {
                    for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                        an6.b bVar = this.n;
                        if (bVar != null) {
                            bVar.removeItem(count + i3);
                        }
                    }
                }
            }
        }
    }

    public final void E(@NonNull ArrayList<uo> arrayList, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, arrayList, str) == null) {
            Iterator<uo> it = arrayList.iterator();
            while (it.hasNext()) {
                uo next = it.next();
                if ((next instanceof ThreadData) && TextUtils.equals(str, ((ThreadData) next).getTid())) {
                    it.remove();
                }
            }
        }
    }

    public ArrayList<uo> F(boolean z, boolean z2, boolean z3, ArrayList<uo> arrayList, mk8 mk8Var, List<AdMixFloor> list, int i) {
        InterceptResult invokeCommon;
        xm6 xm6Var;
        xm6 xm6Var2;
        xm6 xm6Var3;
        xm6 xm6Var4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), arrayList, mk8Var, list, Integer.valueOf(i)})) == null) {
            if (z3) {
                this.d.clear();
                this.e.clear();
                this.f.clear();
            }
            HashSet hashSet = new HashSet();
            Iterator<uo> it = this.d.iterator();
            while (it.hasNext()) {
                uo next = it.next();
                if (next instanceof rq4) {
                    ThreadData threadData = ((rq4) next).s;
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
            ArrayList<uo> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            if (!ListUtils.isEmpty(arrayList)) {
                Iterator<uo> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    uo next2 = it2.next();
                    if (next2 instanceof rq4) {
                        rq4 rq4Var = (rq4) next2;
                        ThreadData threadData3 = rq4Var.s;
                        threadData3.setForum_name(this.a.a());
                        xm6 xm6Var5 = this.a;
                        if (xm6Var5 != null && xm6Var5.g0() != null && this.a.g0().getForum() != null) {
                            if (!StringUtils.isNull(this.a.g0().getForum().getFirst_class())) {
                                threadData3.setFirstClassName(this.a.g0().getForum().getFirst_class());
                            }
                            if (!StringUtils.isNull(this.a.g0().getForum().getSecond_class())) {
                                threadData3.setSecondClassName(this.a.g0().getForum().getSecond_class());
                            }
                        }
                        if (threadData3.isNeedCheckRepeat()) {
                            if (!hashSet.contains(threadData3.getTid())) {
                                arrayList2.add(next2);
                                if (!arrayList3.contains(rq4Var.s.tid)) {
                                    arrayList3.add(rq4Var.s.tid);
                                }
                            }
                        } else {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(rq4Var.s.tid)) {
                                arrayList3.add(rq4Var.s.tid);
                            }
                        }
                    } else if (next2 instanceof ThreadData) {
                        ThreadData threadData4 = (ThreadData) next2;
                        threadData4.setForum_name(this.a.a());
                        xm6 xm6Var6 = this.a;
                        if (xm6Var6 != null && xm6Var6.g0() != null && this.a.g0().getForum() != null) {
                            if (!StringUtils.isNull(this.a.g0().getForum().getFirst_class())) {
                                threadData4.setFirstClassName(this.a.g0().getForum().getFirst_class());
                            }
                            if (!StringUtils.isNull(this.a.g0().getForum().getSecond_class())) {
                                threadData4.setSecondClassName(this.a.g0().getForum().getSecond_class());
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
                    xm6 xm6Var7 = this.a;
                    if (xm6Var7 != null) {
                        FrsViewData g0 = xm6Var7.g0();
                        if (this.j && g0 != null && (this.a instanceof gh5)) {
                            ArrayList<uo> arrayList4 = new ArrayList<>(this.d);
                            arrayList4.addAll(this.f);
                            g0.addRecommendAppToThreadList((gh5) this.a, true, arrayList2, arrayList4, z2);
                        }
                    }
                } else if (i != 2) {
                    if (i != 3) {
                        if (js6.d()) {
                            if (this.o != null) {
                                String valueOf = String.valueOf(this.k);
                                if (this.k == 0 && (xm6Var4 = this.a) != null && xm6Var4.g0() != null && this.a.g0().getForum() != null && this.a.g0().getForum().getId() != null) {
                                    valueOf = this.a.g0().getForum().getId();
                                }
                                this.o.b(arrayList2, z3, valueOf);
                            }
                        } else {
                            xm6 xm6Var8 = this.a;
                            if (xm6Var8 != null) {
                                FrsViewData g02 = xm6Var8.g0();
                                if (this.j && g02 != null && (this.a instanceof gh5)) {
                                    ArrayList<uo> arrayList5 = new ArrayList<>(this.d);
                                    arrayList5.addAll(this.f);
                                    g02.addRecommendAppToThreadList((gh5) this.a, true, arrayList2, arrayList5, z2);
                                }
                            }
                        }
                    } else if (!ListUtils.isEmpty(list)) {
                        int intValue = list.get(0).ad_type.intValue();
                        if (intValue == 1 && (xm6Var3 = this.a) != null) {
                            FrsViewData g03 = xm6Var3.g0();
                            if (this.j && g03 != null && (this.a instanceof gh5)) {
                                ArrayList<uo> arrayList6 = new ArrayList<>(this.d);
                                arrayList6.addAll(this.f);
                                g03.addRecommendAppToThreadList((gh5) this.a, true, arrayList2, arrayList6, z2);
                            }
                        } else if (intValue == 2 && this.o != null) {
                            String valueOf2 = String.valueOf(this.k);
                            if (this.k == 0 && (xm6Var2 = this.a) != null && xm6Var2.g0() != null && this.a.g0().getForum() != null && this.a.g0().getForum().getId() != null) {
                                valueOf2 = this.a.g0().getForum().getId();
                            }
                            this.o.g(arrayList2, list, z3, String.valueOf(valueOf2));
                        }
                    }
                } else if (this.o != null) {
                    String valueOf3 = String.valueOf(this.k);
                    if (this.k == 0 && (xm6Var = this.a) != null && xm6Var.g0() != null && this.a.g0().getForum() != null && this.a.g0().getForum().getId() != null) {
                        valueOf3 = this.a.g0().getForum().getId();
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
            ArrayList<uo> arrayList7 = new ArrayList<>();
            arrayList7.addAll(this.d);
            arrayList7.addAll(this.f);
            xm6 xm6Var9 = this.a;
            if (xm6Var9 instanceof gh5) {
                bq6.b((gh5) xm6Var9, xm6Var9.g0(), arrayList2, getPn());
                bq6.c(mk8Var, arrayList2, arrayList7);
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
        if (!(interceptable == null || interceptable.invokeL(1048583, this, loadMoreHttpResponseMessage) == null) || this.b) {
            return;
        }
        this.b = true;
        if (PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            new p85(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.c).c();
        }
    }

    public void J(boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, responsedMessage) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && (this.a instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.c;
            p85 p85Var = new p85(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.a).D, false, 0L, 0L, currentTimeMillis);
            p85Var.B = currentTimeMillis;
            p85Var.e(true);
        }
    }

    public final void K(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, loadMoreResponseSocketMessage) == null) || this.b) {
            return;
        }
        this.b = true;
        if (PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            new p85(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.c).c();
        }
    }

    public void L(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (!ListUtils.isEmpty(this.d)) {
            M(this.d, str);
        }
        if (ListUtils.isEmpty(this.f)) {
            return;
        }
        M(this.f, str);
    }

    public final void M(ArrayList<uo> arrayList, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, arrayList, str) == null) {
            Iterator<uo> it = arrayList.iterator();
            while (it.hasNext()) {
                uo next = it.next();
                if (next instanceof dh5) {
                    dh5 dh5Var = (dh5) next;
                    if ((dh5Var.a() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) dh5Var.a()).a)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void N(uo uoVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, uoVar) == null) || uoVar == null) {
            return;
        }
        ArrayList<uo> arrayList = this.d;
        if (arrayList != null) {
            arrayList.remove(uoVar);
        }
        ArrayList<uo> arrayList2 = this.f;
        if (arrayList2 != null) {
            arrayList2.remove(uoVar);
        }
    }

    public void O(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            ArrayList<uo> arrayList = this.d;
            if (arrayList != null) {
                E(arrayList, str);
            }
            ArrayList<uo> arrayList2 = this.f;
            if (arrayList2 != null) {
                E(arrayList2, str);
            }
        }
    }

    public ArrayList<uo> P() {
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
            ArrayList<uo> arrayList = new ArrayList<>();
            arrayList.addAll(this.d);
            arrayList.addAll(this.f);
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
                loadMoreRequestMessage.setLastClickTid(mg.g(xc5.a(), 0L));
                loadMoreRequestMessage.setSortType(this.g);
                loadMoreRequestMessage.setPageType(this.l);
                loadMoreRequestMessage.setAdFloorInfo(str2);
                loadMoreRequestMessage.setBrandForum(z);
                if (!TextUtils.isEmpty(str)) {
                    B(str, loadMoreRequestMessage);
                }
                sendMessage(loadMoreRequestMessage);
                this.isLoading = true;
                this.c = System.currentTimeMillis();
                es6.a();
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
            this.d.clear();
            this.e.clear();
            this.f.clear();
            this.i = -1;
            this.h = 1;
        }
    }

    public void S(js6 js6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, js6Var) == null) {
            this.o = js6Var;
        }
    }

    public void T(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.j = z;
        }
    }

    public void U(an6.b bVar) {
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
