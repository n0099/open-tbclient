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
import com.repackage.ae5;
import com.repackage.bp6;
import com.repackage.br6;
import com.repackage.d9;
import com.repackage.fi8;
import com.repackage.gm6;
import com.repackage.gr6;
import com.repackage.jm6;
import com.repackage.ng;
import com.repackage.nn;
import com.repackage.p95;
import com.repackage.qi5;
import com.repackage.qq4;
import com.repackage.rm6;
import com.repackage.s98;
import com.repackage.ti5;
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
    public final gm6 a;
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
    public rm6 m;
    public jm6.b n;
    public gr6 o;
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
                frsLoadMoreModel.a.onFailed(this.a.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c2b));
            } else if (responsedMessage.getError() != 0) {
                if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                    this.a.a.onFailed(responsedMessage.getErrorString());
                } else {
                    this.a.a.onFailed(this.a.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c2b));
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                FrsViewData Q0 = this.a.a.Q0();
                if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                    LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                    if (Q0 != null) {
                        Q0.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                    }
                    this.a.a.h(loadMoreHttpResponseMessage.getThreadList());
                    if (this.a.a instanceof FrsFragment) {
                        ((FrsFragment) this.a.a).D = System.currentTimeMillis() - currentTimeMillis;
                        this.a.L(true, responsedMessage);
                    }
                    this.a.K(loadMoreHttpResponseMessage);
                } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                    LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                    if (Q0 != null) {
                        Q0.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                    }
                    this.a.a.h(loadMoreResponseSocketMessage.getThreadList());
                    if (this.a.a instanceof FrsFragment) {
                        ((FrsFragment) this.a.a).D = System.currentTimeMillis() - currentTimeMillis;
                        this.a.L(false, responsedMessage);
                    }
                    this.a.M(loadMoreResponseSocketMessage);
                }
                if (!TextUtils.isEmpty(this.a.a.c()) && s98.l().b() != null) {
                    s98.l().b().g(this.a.a.c(), 2, false);
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
    public FrsLoadMoreModel(gm6 gm6Var, rm6 rm6Var) {
        super(gm6Var.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gm6Var, rm6Var};
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
        this.a = gm6Var;
        setUniqueId(gm6Var.getUniqueId());
        this.m = rm6Var;
        this.p.getHttpMessageListener().setSelfListener(true);
        this.p.getSocketMessageListener().setSelfListener(true);
        registerListener(this.p);
    }

    public final void D(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, loadMoreRequestMessage) == null) || s98.l().b() == null) {
            return;
        }
        loadMoreRequestMessage.setLoadCount(s98.l().b().e(str, false) + 1);
    }

    public boolean E(List<Long> list) {
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

    public void F() {
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
                gm6 gm6Var = this.a;
                if (gm6Var != null && gm6Var.Q0() != null) {
                    arrayList2 = this.a.Q0().switchThreadDataToThreadCardInfo(arrayList);
                }
                if (arrayList2 != null) {
                    for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                        jm6.b bVar = this.n;
                        if (bVar != null) {
                            bVar.removeItem(count + i3);
                        }
                    }
                }
            }
        }
    }

    public final void G(@NonNull ArrayList<nn> arrayList, @NonNull String str) {
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

    public ArrayList<nn> H(boolean z, boolean z2, boolean z3, ArrayList<nn> arrayList, fi8 fi8Var, List<AdMixFloor> list, int i) {
        InterceptResult invokeCommon;
        gm6 gm6Var;
        gm6 gm6Var2;
        gm6 gm6Var3;
        gm6 gm6Var4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), arrayList, fi8Var, list, Integer.valueOf(i)})) == null) {
            if (z3) {
                this.d.clear();
                this.e.clear();
                this.f.clear();
            }
            HashSet hashSet = new HashSet();
            Iterator<nn> it = this.d.iterator();
            while (it.hasNext()) {
                nn next = it.next();
                if (next instanceof qq4) {
                    ThreadData threadData = ((qq4) next).s;
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
                    if (next2 instanceof qq4) {
                        qq4 qq4Var = (qq4) next2;
                        ThreadData threadData3 = qq4Var.s;
                        threadData3.setForum_name(this.a.c());
                        gm6 gm6Var5 = this.a;
                        if (gm6Var5 != null && gm6Var5.Q0() != null && this.a.Q0().getForum() != null) {
                            if (!StringUtils.isNull(this.a.Q0().getForum().getFirst_class())) {
                                threadData3.setFirstClassName(this.a.Q0().getForum().getFirst_class());
                            }
                            if (!StringUtils.isNull(this.a.Q0().getForum().getSecond_class())) {
                                threadData3.setSecondClassName(this.a.Q0().getForum().getSecond_class());
                            }
                        }
                        if (threadData3.isNeedCheckRepeat()) {
                            if (!hashSet.contains(threadData3.getTid())) {
                                arrayList2.add(next2);
                                if (!arrayList3.contains(qq4Var.s.tid)) {
                                    arrayList3.add(qq4Var.s.tid);
                                }
                            }
                        } else {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(qq4Var.s.tid)) {
                                arrayList3.add(qq4Var.s.tid);
                            }
                        }
                    } else if (next2 instanceof ThreadData) {
                        ThreadData threadData4 = (ThreadData) next2;
                        threadData4.setForum_name(this.a.c());
                        gm6 gm6Var6 = this.a;
                        if (gm6Var6 != null && gm6Var6.Q0() != null && this.a.Q0().getForum() != null) {
                            if (!StringUtils.isNull(this.a.Q0().getForum().getFirst_class())) {
                                threadData4.setFirstClassName(this.a.Q0().getForum().getFirst_class());
                            }
                            if (!StringUtils.isNull(this.a.Q0().getForum().getSecond_class())) {
                                threadData4.setSecondClassName(this.a.Q0().getForum().getSecond_class());
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
                    gm6 gm6Var7 = this.a;
                    if (gm6Var7 != null) {
                        FrsViewData Q0 = gm6Var7.Q0();
                        if (this.j && Q0 != null && (this.a instanceof ti5)) {
                            ArrayList<nn> arrayList4 = new ArrayList<>(this.d);
                            arrayList4.addAll(this.f);
                            Q0.addRecommendAppToThreadList((ti5) this.a, true, arrayList2, arrayList4, z2);
                        }
                    }
                } else if (i != 2) {
                    if (i != 3) {
                        if (gr6.d()) {
                            if (this.o != null) {
                                String valueOf = String.valueOf(this.k);
                                if (this.k == 0 && (gm6Var4 = this.a) != null && gm6Var4.Q0() != null && this.a.Q0().getForum() != null && this.a.Q0().getForum().getId() != null) {
                                    valueOf = this.a.Q0().getForum().getId();
                                }
                                this.o.b(arrayList2, z3, valueOf);
                            }
                        } else {
                            gm6 gm6Var8 = this.a;
                            if (gm6Var8 != null) {
                                FrsViewData Q02 = gm6Var8.Q0();
                                if (this.j && Q02 != null && (this.a instanceof ti5)) {
                                    ArrayList<nn> arrayList5 = new ArrayList<>(this.d);
                                    arrayList5.addAll(this.f);
                                    Q02.addRecommendAppToThreadList((ti5) this.a, true, arrayList2, arrayList5, z2);
                                }
                            }
                        }
                    } else if (!ListUtils.isEmpty(list)) {
                        int intValue = list.get(0).ad_type.intValue();
                        if (intValue == 1 && (gm6Var3 = this.a) != null) {
                            FrsViewData Q03 = gm6Var3.Q0();
                            if (this.j && Q03 != null && (this.a instanceof ti5)) {
                                ArrayList<nn> arrayList6 = new ArrayList<>(this.d);
                                arrayList6.addAll(this.f);
                                Q03.addRecommendAppToThreadList((ti5) this.a, true, arrayList2, arrayList6, z2);
                            }
                        } else if (intValue == 2 && this.o != null) {
                            String valueOf2 = String.valueOf(this.k);
                            if (this.k == 0 && (gm6Var2 = this.a) != null && gm6Var2.Q0() != null && this.a.Q0().getForum() != null && this.a.Q0().getForum().getId() != null) {
                                valueOf2 = this.a.Q0().getForum().getId();
                            }
                            this.o.g(arrayList2, list, z3, String.valueOf(valueOf2));
                        }
                    }
                } else if (this.o != null) {
                    String valueOf3 = String.valueOf(this.k);
                    if (this.k == 0 && (gm6Var = this.a) != null && gm6Var.Q0() != null && this.a.Q0().getForum() != null && this.a.Q0().getForum().getId() != null) {
                        valueOf3 = this.a.Q0().getForum().getId();
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
            gm6 gm6Var9 = this.a;
            if (gm6Var9 instanceof ti5) {
                bp6.b((ti5) gm6Var9, gm6Var9.Q0(), arrayList2, getPn());
                bp6.c(fi8Var, arrayList2, arrayList7);
            }
            return arrayList7;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public final String I(List<Long> list) {
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

    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.i : invokeV.intValue;
    }

    public final void K(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, loadMoreHttpResponseMessage) == null) || this.b) {
            return;
        }
        this.b = true;
        if (PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            new p95(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.c).c();
        }
    }

    public void L(boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, responsedMessage) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && (this.a instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.c;
            p95 p95Var = new p95(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.a).D, false, 0L, 0L, currentTimeMillis);
            p95Var.B = currentTimeMillis;
            p95Var.e(true);
        }
    }

    public final void M(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, loadMoreResponseSocketMessage) == null) || this.b) {
            return;
        }
        this.b = true;
        if (PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            new p95(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.c).c();
        }
    }

    public void N(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (!ListUtils.isEmpty(this.d)) {
            O(this.d, str);
        }
        if (ListUtils.isEmpty(this.f)) {
            return;
        }
        O(this.f, str);
    }

    public final void O(ArrayList<nn> arrayList, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, arrayList, str) == null) {
            Iterator<nn> it = arrayList.iterator();
            while (it.hasNext()) {
                nn next = it.next();
                if (next instanceof qi5) {
                    qi5 qi5Var = (qi5) next;
                    if ((qi5Var.a() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) qi5Var.a()).a)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void P(nn nnVar) {
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

    public void Q(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            ArrayList<nn> arrayList = this.d;
            if (arrayList != null) {
                G(arrayList, str);
            }
            ArrayList<nn> arrayList2 = this.f;
            if (arrayList2 != null) {
                G(arrayList2, str);
            }
        }
    }

    public ArrayList<nn> R() {
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

    public void S(long j, List<Long> list, String str, int i, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j), list, str, Integer.valueOf(i), Boolean.valueOf(z), str2}) == null) {
            if (j != 0 && !ListUtils.isEmpty(list)) {
                String I = I(list);
                if (TextUtils.isEmpty(I)) {
                    return;
                }
                this.k = j;
                LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
                loadMoreRequestMessage.setForumId(j);
                loadMoreRequestMessage.setThreadIds(I);
                loadMoreRequestMessage.setNeedAbstract(0);
                loadMoreRequestMessage.setForumName(str);
                loadMoreRequestMessage.setPageNumber(i);
                loadMoreRequestMessage.setLastClickTid(ng.g(ae5.a(), 0L));
                loadMoreRequestMessage.setSortType(this.g);
                loadMoreRequestMessage.setPageType(this.l);
                loadMoreRequestMessage.setAdFloorInfo(str2);
                loadMoreRequestMessage.setBrandForum(z);
                if (!TextUtils.isEmpty(str)) {
                    D(str, loadMoreRequestMessage);
                }
                sendMessage(loadMoreRequestMessage);
                this.isLoading = true;
                this.c = System.currentTimeMillis();
                br6.a();
                return;
            }
            this.loadingDone = true;
        }
    }

    public void T() {
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

    public void U(gr6 gr6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, gr6Var) == null) {
            this.o = gr6Var;
        }
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.j = z;
        }
    }

    public void W(jm6.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bVar) == null) {
            this.n = bVar;
        }
    }

    public void X(int i) {
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
