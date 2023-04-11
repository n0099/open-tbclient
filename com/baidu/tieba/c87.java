package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsVideoTabPlayActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.commontab.FrsCommonTabNetModel;
import com.baidu.tieba.frs.commontab.FrsCommonTabRequestData;
import com.baidu.tieba.frs.dynamic.FrsDynamicModel;
import com.baidu.tieba.frs.dynamic.FrsDynamicRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes3.dex */
public class c87 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public d87 b;
    public FrsCommonTabRequestData c;
    public FrsCommonTabNetModel d;
    public boolean e;
    public FrsDynamicRequestData f;
    public FrsDynamicModel g;
    public boolean h;
    public HashSet<String> i;
    public int j;
    public long k;
    public int l;
    public String m;
    public String n;
    public kk7 o;

    public c87(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsCommonTabFragment, Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new HashSet<>();
        this.j = 1;
        this.k = -1L;
        if (frsCommonTabFragment == null) {
            return;
        }
        this.a = frsCommonTabFragment;
        this.n = "FRS_GENERAL_TAB" + i2;
        if (i2 == 89) {
            this.e = true;
            FrsDynamicRequestData frsDynamicRequestData = new FrsDynamicRequestData();
            this.f = frsDynamicRequestData;
            frsDynamicRequestData.forumId = i;
            frsDynamicRequestData.scrH = ii.j(TbadkCoreApplication.getInst());
            this.f.scrW = ii.l(TbadkCoreApplication.getInst());
            this.f.scrDip = ii.i(TbadkCoreApplication.getInst());
            FrsDynamicModel frsDynamicModel = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.f);
            this.g = frsDynamicModel;
            frsDynamicModel.s0(this);
            this.g.setUniqueId(frsCommonTabFragment.getUniqueId());
            return;
        }
        this.e = false;
        FrsCommonTabRequestData frsCommonTabRequestData = new FrsCommonTabRequestData();
        this.c = frsCommonTabRequestData;
        frsCommonTabRequestData.fid = i;
        frsCommonTabRequestData.tabId = i2;
        frsCommonTabRequestData.isDefaultNavTab = i(i2) ? 1 : 0;
        FrsCommonTabRequestData frsCommonTabRequestData2 = this.c;
        frsCommonTabRequestData2.tabName = str;
        frsCommonTabRequestData2.isGeneralTab = i3;
        FrsCommonTabNetModel frsCommonTabNetModel = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.c);
        this.d = frsCommonTabNetModel;
        frsCommonTabNetModel.s0(this);
        this.d.setUniqueId(frsCommonTabFragment.getUniqueId());
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void H(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        d87 d87Var = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof d87) {
                d87Var = (d87) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof e87) {
                e87 e87Var = (e87) mvcHttpResponsedMessage.getData();
                d87 d87Var2 = new d87();
                ArrayList<hn> arrayList = e87Var.a;
                d87Var2.c = arrayList;
                d87Var2.a = e87Var.c;
                d87Var2.b = e87Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<hn> arrayList2 = d87Var2.c;
                    hn hnVar = (hn) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (hnVar instanceof ThreadData) {
                        this.f.lastThreadId = gg.g(((ThreadData) hnVar).getId(), 0L);
                    }
                }
                d87Var = d87Var2;
            }
        }
        if (d87Var != null && m(d87Var)) {
            return;
        }
        this.l = mvcHttpResponsedMessage.getError();
        this.m = mvcHttpResponsedMessage.getErrorString();
        ErrorData errorData = new ErrorData();
        errorData.setError_code(this.l);
        errorData.setError_msg(this.m);
        if (this.l != 0) {
            this.a.g(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void w(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048595, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) != null) || mvcSocketResponsedMessage == null) {
            return;
        }
        d87 d87Var = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof d87) {
                d87Var = (d87) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof e87) {
                e87 e87Var = (e87) mvcSocketResponsedMessage.getData();
                d87 d87Var2 = new d87();
                ArrayList<hn> arrayList = e87Var.a;
                d87Var2.c = arrayList;
                d87Var2.a = e87Var.c;
                d87Var2.b = e87Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<hn> arrayList2 = d87Var2.c;
                    hn hnVar = (hn) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (hnVar instanceof ThreadData) {
                        this.f.lastThreadId = gg.g(((ThreadData) hnVar).getId(), 0L);
                    }
                }
                d87Var = d87Var2;
            }
        }
        if (d87Var != null && m(d87Var)) {
            return;
        }
        this.l = mvcSocketResponsedMessage.getError();
        this.m = mvcSocketResponsedMessage.getErrorString();
        ErrorData errorData = new ErrorData();
        errorData.setError_code(this.l);
        errorData.setError_msg(this.m);
        if (this.l != 0) {
            this.a.g(errorData);
        }
    }

    public void a(ThreadData threadData) {
        d87 d87Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) && threadData != null && (d87Var = this.b) != null && d87Var.c != null) {
            ArrayList<hn> arrayList = new ArrayList<>();
            arrayList.add(threadData);
            ArrayList<hn> r = r(arrayList);
            if (ListUtils.isEmpty(this.b.c)) {
                this.b.c.addAll(r);
            } else {
                if (this.b.c.size() == 1 && (this.b.c.get(0) instanceof g57)) {
                    this.b.c.remove(0);
                }
                this.b.c.addAll(0, r);
            }
            this.a.Z1(this.b);
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.h = true;
            if (!this.e) {
                if (this.d.k0()) {
                    return;
                }
                this.j = 1;
                FrsCommonTabRequestData frsCommonTabRequestData = this.c;
                frsCommonTabRequestData.pn = 1;
                frsCommonTabRequestData.sortType = i;
                long j = this.k;
                if (j >= 0) {
                    frsCommonTabRequestData.lastThreadId = j;
                }
                this.c.adExtParams = c();
                this.d.loadData();
            } else if (this.g.k0()) {
                return;
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.f.qType = 2;
                } else {
                    this.f.qType = 1;
                }
                this.f.lastThreadId = 0L;
                this.g.loadData();
            }
            fk7.a();
        }
    }

    public final void b(List<hn> list) {
        JSONObject b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) != null) || me8.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (hn hnVar : list) {
            if ((hnVar instanceof ThreadData) && (b = ic9.b(((ThreadData) hnVar).getRawThreadInfo())) != null) {
                arrayList.add(b);
            }
        }
        ic9.f().h(this.n, arrayList);
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.h = false;
            if (!this.e) {
                if (this.d.k0()) {
                    return;
                }
                int i2 = this.j + 1;
                this.j = i2;
                FrsCommonTabRequestData frsCommonTabRequestData = this.c;
                frsCommonTabRequestData.pn = i2;
                frsCommonTabRequestData.sortType = i;
                frsCommonTabRequestData.lastThreadId = -1L;
                frsCommonTabRequestData.adExtParams = c();
                this.d.loadData();
            } else if (this.g.k0()) {
                return;
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.f.qType = 2;
                } else {
                    this.f.qType = 1;
                }
                this.g.loadData();
            }
            fk7.a();
        }
    }

    public final String c() {
        InterceptResult invokeV;
        int b;
        String d;
        ArrayList<hn> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.h) {
                b = 0;
            } else {
                b = z99.b(this.b.c);
            }
            if (this.h) {
                d = "";
            } else {
                d = ic9.f().d(this.n);
            }
            d87 d87Var = this.b;
            if (d87Var == null) {
                arrayList = null;
            } else {
                arrayList = d87Var.c;
            }
            String e = z99.e(arrayList, this.h);
            AdExtParam.a b2 = AdExtParam.a.b();
            b2.g(b);
            b2.e(e);
            b2.c(d);
            b2.f(this.a.f);
            return b2.a();
        }
        return (String) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d87 d87Var = this.b;
            if (d87Var == null) {
                return true;
            }
            return d87Var.a;
        }
        return invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public d87 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (d87) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            d87 d87Var = this.b;
            if (d87Var != null && !ListUtils.isEmpty(d87Var.c)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public final void g(List<App> list, List<hn> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, list, list2) == null) {
            b(list2);
            z99.i(z99.h(list, "FRS_GENERAL_TAB"), list2, 0);
            z99.a(list2, this.j, "FRS_GENERAL_TAB");
        }
    }

    public final boolean i(int i) {
        InterceptResult invokeI;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.a;
            if (frsCommonTabFragment == null || (frsViewData = frsCommonTabFragment.d) == null || frsViewData.mHeadLineDefaultNavTabId != i) {
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void l(String str) {
        d87 d87Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, str) == null) && (d87Var = this.b) != null && !me8.e(d87Var.c)) {
            z99.d(str, this.b.c);
            this.a.Z1(this.b);
        }
    }

    public void o(kk7 kk7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, kk7Var) == null) {
            this.o = kk7Var;
        }
    }

    public void p(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.k = j;
        }
    }

    public void q(int i) {
        FrsCommonTabRequestData frsCommonTabRequestData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048593, this, i) == null) && (frsCommonTabRequestData = this.c) != null) {
            frsCommonTabRequestData.tabType = i;
        }
    }

    public final boolean m(d87 d87Var) {
        InterceptResult invokeL;
        boolean z;
        kk7 kk7Var;
        kk7 kk7Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, d87Var)) == null) {
            if (d87Var == null) {
                return false;
            }
            if (this.a.h == 100) {
                z = true;
            } else {
                z = false;
            }
            ArrayList arrayList = new ArrayList();
            if (this.h) {
                this.i.clear();
                Iterator<hn> it = d87Var.c.iterator();
                while (it.hasNext()) {
                    hn next = it.next();
                    if (next instanceof ThreadData) {
                        ThreadData threadData = (ThreadData) next;
                        String tid = threadData.getTid();
                        if (!this.i.contains(tid)) {
                            this.i.add(tid);
                        }
                        if (z && threadData.getThreadVideoInfo() != null && !TextUtils.isEmpty(threadData.getThreadVideoInfo().video_url)) {
                            VideoItemData videoItemData = new VideoItemData();
                            videoItemData.buildWithThreadData(threadData);
                            arrayList.add(videoItemData);
                        }
                    }
                }
                if (z && !arrayList.isEmpty()) {
                    FrsVideoTabPlayActivityConfig.putVideoTabListByFid(((VideoItemData) arrayList.get(0)).forum_id, arrayList);
                }
                int i = d87Var.l;
                if (i != -1) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (kk7.d()) {
                                    kk7 kk7Var3 = this.o;
                                    if (kk7Var3 != null) {
                                        kk7Var3.b(d87Var.c, this.h, this.a.R());
                                    }
                                } else {
                                    g(d87Var.k, d87Var.c);
                                }
                            } else if (!ListUtils.isEmpty(d87Var.m)) {
                                int intValue = d87Var.m.get(0).ad_type.intValue();
                                if (intValue == 1) {
                                    g(d87Var.k, d87Var.c);
                                } else if (intValue == 2 && (kk7Var2 = this.o) != null) {
                                    kk7Var2.g(d87Var.c, d87Var.m, this.h, this.a.R());
                                }
                            }
                        } else {
                            kk7 kk7Var4 = this.o;
                            if (kk7Var4 != null) {
                                kk7Var4.b(d87Var.c, this.h, this.a.R());
                            }
                        }
                    } else {
                        g(d87Var.k, d87Var.c);
                    }
                }
                this.b = d87Var;
                d87Var.c = r(d87Var.c);
            } else {
                d87 d87Var2 = this.b;
                d87Var2.a = d87Var.a;
                d87Var2.b.putAll(d87Var.b);
                ArrayList<hn> arrayList2 = new ArrayList<>();
                Iterator<hn> it2 = d87Var.c.iterator();
                while (it2.hasNext()) {
                    hn next2 = it2.next();
                    if (next2 instanceof ThreadData) {
                        ThreadData threadData2 = (ThreadData) next2;
                        String tid2 = threadData2.getTid();
                        if (!this.i.contains(tid2)) {
                            threadData2.isFromBrandForum = this.a.l;
                            arrayList2.add(threadData2);
                            this.i.add(tid2);
                            if (z && threadData2.getThreadVideoInfo() != null && !TextUtils.isEmpty(threadData2.getThreadVideoInfo().video_url)) {
                                VideoItemData videoItemData2 = new VideoItemData();
                                videoItemData2.buildWithThreadData(threadData2);
                                arrayList.add(videoItemData2);
                            }
                        }
                    }
                }
                if (z && !arrayList.isEmpty()) {
                    FrsVideoTabPlayActivityConfig.getVideoTabListByFid(((VideoItemData) arrayList.get(0)).forum_id).addAll(arrayList);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921628));
                }
                int i2 = d87Var.l;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (kk7.d()) {
                                kk7 kk7Var5 = this.o;
                                if (kk7Var5 != null) {
                                    kk7Var5.b(d87Var.c, this.h, this.a.R());
                                }
                            } else {
                                g(d87Var.k, d87Var.c);
                            }
                        } else if (!ListUtils.isEmpty(d87Var.m)) {
                            int intValue2 = d87Var.m.get(0).ad_type.intValue();
                            if (intValue2 == 1) {
                                g(d87Var.k, d87Var.c);
                            } else if (intValue2 == 2 && (kk7Var = this.o) != null) {
                                kk7Var.g(d87Var.c, d87Var.m, this.h, this.a.R());
                            }
                        }
                    } else {
                        kk7 kk7Var6 = this.o;
                        if (kk7Var6 != null) {
                            kk7Var6.b(d87Var.c, this.h, this.a.R());
                        }
                    }
                } else {
                    g(d87Var.k, d87Var.c);
                }
                this.b.c.addAll(r(arrayList2));
            }
            this.a.Z1(this.b);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final ArrayList<hn> r(ArrayList<hn> arrayList) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, arrayList)) == null) {
            if (this.a.h == 16) {
                z = true;
            } else {
                z = false;
            }
            if (this.a.h == 100) {
                z2 = true;
            } else {
                z2 = false;
            }
            ArrayList<hn> arrayList2 = new ArrayList<>();
            Iterator<hn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                hn next = it.next();
                if (next instanceof zx4) {
                    ((zx4) next).setPosition(i);
                    arrayList2.add(next);
                } else if (next instanceof ay4) {
                    ((ay4) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        oz4 oz4Var = new oz4();
                        oz4Var.t = threadData;
                        oz4Var.position = i;
                        oz4Var.a = true;
                        oz4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(oz4Var);
                        oz4 oz4Var2 = new oz4();
                        oz4Var2.t = threadData;
                        oz4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            oz4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            oz4Var2.d = true;
                            oz4Var2.u = imageWidthAndHeight[0];
                            oz4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            oz4Var2.e = true;
                        } else {
                            oz4Var2.b = true;
                        }
                        oz4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(oz4Var2);
                        if (threadData.getPollData() != null) {
                            oz4 oz4Var3 = new oz4();
                            oz4Var3.o = true;
                            oz4Var3.t = threadData;
                            oz4Var3.position = i;
                            oz4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(oz4Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            oz4 oz4Var4 = new oz4();
                            oz4Var4.l = true;
                            oz4Var4.t = threadData;
                            oz4Var4.position = i;
                            oz4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(oz4Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            oz4 oz4Var5 = new oz4();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                oz4Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                oz4Var5.q = true;
                            }
                            oz4Var5.t = threadData;
                            oz4Var5.position = i;
                            oz4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(oz4Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            oz4 oz4Var6 = new oz4();
                            oz4Var6.h = true;
                            oz4Var6.t = threadData;
                            oz4Var6.position = i;
                            oz4Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(oz4Var6);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            oz4 oz4Var7 = new oz4();
                            oz4Var7.n = true;
                            oz4Var7.t = threadData;
                            oz4Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(oz4Var7);
                        }
                        oz4 oz4Var8 = new oz4();
                        oz4Var8.g = true;
                        oz4Var8.t = threadData;
                        oz4Var8.position = i;
                        oz4Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(oz4Var8);
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        oz4 oz4Var9 = new oz4();
                        oz4Var9.t = threadData;
                        oz4Var9.position = i;
                        oz4Var9.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        oz4Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(oz4Var9);
                        oz4 oz4Var10 = new oz4();
                        oz4Var10.t = threadData;
                        oz4Var10.position = i;
                        if (threadData instanceof iy4) {
                            oz4Var10.j = true;
                        } else {
                            oz4Var10.i = true;
                        }
                        oz4Var10.t.isJumpToFrsVideoTabPlay = z2;
                        oz4Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(oz4Var10);
                        if (threadData.getPollData() != null) {
                            oz4 oz4Var11 = new oz4();
                            oz4Var11.o = true;
                            oz4Var11.t = threadData;
                            oz4Var11.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            oz4Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(oz4Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            oz4 oz4Var12 = new oz4();
                            oz4Var12.l = true;
                            oz4Var12.t = threadData;
                            oz4Var12.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            oz4Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(oz4Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            oz4 oz4Var13 = new oz4();
                            oz4Var13.h = true;
                            oz4Var13.t = threadData;
                            oz4Var13.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            oz4Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(oz4Var13);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            oz4 oz4Var14 = new oz4();
                            oz4Var14.n = true;
                            oz4Var14.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            oz4Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(oz4Var14);
                        }
                        oz4 oz4Var15 = new oz4();
                        oz4Var15.g = true;
                        oz4Var15.t = threadData;
                        oz4Var15.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        oz4Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(oz4Var15);
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        oz4 oz4Var16 = new oz4();
                        oz4Var16.t = threadData;
                        oz4Var16.position = i;
                        oz4Var16.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        oz4Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(oz4Var16);
                        oz4 oz4Var17 = new oz4();
                        oz4Var17.t = threadData;
                        oz4Var17.position = i;
                        oz4Var17.k = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        oz4Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(oz4Var17);
                        if (threadData.getPollData() != null) {
                            oz4 oz4Var18 = new oz4();
                            oz4Var18.o = true;
                            oz4Var18.t = threadData;
                            oz4Var18.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            oz4Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(oz4Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            oz4 oz4Var19 = new oz4();
                            oz4Var19.l = true;
                            oz4Var19.t = threadData;
                            oz4Var19.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            oz4Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(oz4Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            oz4 oz4Var20 = new oz4();
                            oz4Var20.h = true;
                            oz4Var20.t = threadData;
                            oz4Var20.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            oz4Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(oz4Var20);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            oz4 oz4Var21 = new oz4();
                            oz4Var21.n = true;
                            oz4Var21.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            oz4Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(oz4Var21);
                        }
                        oz4 oz4Var22 = new oz4();
                        oz4Var22.g = true;
                        oz4Var22.t = threadData;
                        oz4Var22.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        oz4Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(oz4Var22);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        oz4 oz4Var23 = new oz4();
                        oz4Var23.t = threadData;
                        oz4Var23.position = i;
                        arrayList2.add(oz4Var23);
                    }
                    i++;
                    threadData.setSupportType(BaseCardInfo.SupportType.TOP);
                } else {
                    arrayList2.add(next);
                }
                i++;
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }
}
