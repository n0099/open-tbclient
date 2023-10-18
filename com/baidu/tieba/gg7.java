package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
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
/* loaded from: classes6.dex */
public class gg7 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public hg7 b;
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
    public ct7 o;

    public gg7(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
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
            frsDynamicRequestData.scrH = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
            this.f.scrW = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
            this.f.scrDip = BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst());
            FrsDynamicModel frsDynamicModel = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.f);
            this.g = frsDynamicModel;
            frsDynamicModel.p0(this);
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
        frsCommonTabNetModel.p0(this);
        this.d.setUniqueId(frsCommonTabFragment.getUniqueId());
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void H(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        hg7 hg7Var = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof hg7) {
                hg7Var = (hg7) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof ig7) {
                ig7 ig7Var = (ig7) mvcHttpResponsedMessage.getData();
                hg7 hg7Var2 = new hg7();
                ArrayList<yh> arrayList = ig7Var.a;
                hg7Var2.c = arrayList;
                hg7Var2.a = ig7Var.c;
                hg7Var2.b = ig7Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<yh> arrayList2 = hg7Var2.c;
                    yh yhVar = (yh) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (yhVar instanceof ThreadData) {
                        this.f.lastThreadId = JavaTypesHelper.toLong(((ThreadData) yhVar).getId(), 0L);
                    }
                }
                hg7Var = hg7Var2;
            }
        }
        if (hg7Var != null && n(hg7Var)) {
            return;
        }
        this.l = mvcHttpResponsedMessage.getError();
        this.m = mvcHttpResponsedMessage.getErrorString();
        ErrorData errorData = new ErrorData();
        errorData.setError_code(this.l);
        errorData.setError_msg(this.m);
        if (this.l != 0) {
            this.a.f(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void v(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048596, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) != null) || mvcSocketResponsedMessage == null) {
            return;
        }
        hg7 hg7Var = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof hg7) {
                hg7Var = (hg7) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof ig7) {
                ig7 ig7Var = (ig7) mvcSocketResponsedMessage.getData();
                hg7 hg7Var2 = new hg7();
                ArrayList<yh> arrayList = ig7Var.a;
                hg7Var2.c = arrayList;
                hg7Var2.a = ig7Var.c;
                hg7Var2.b = ig7Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<yh> arrayList2 = hg7Var2.c;
                    yh yhVar = (yh) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (yhVar instanceof ThreadData) {
                        this.f.lastThreadId = JavaTypesHelper.toLong(((ThreadData) yhVar).getId(), 0L);
                    }
                }
                hg7Var = hg7Var2;
            }
        }
        if (hg7Var != null && n(hg7Var)) {
            return;
        }
        this.l = mvcSocketResponsedMessage.getError();
        this.m = mvcSocketResponsedMessage.getErrorString();
        ErrorData errorData = new ErrorData();
        errorData.setError_code(this.l);
        errorData.setError_msg(this.m);
        if (this.l != 0) {
            this.a.f(errorData);
        }
    }

    public void a(ThreadData threadData) {
        hg7 hg7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) && threadData != null && (hg7Var = this.b) != null && hg7Var.c != null) {
            ArrayList<yh> arrayList = new ArrayList<>();
            arrayList.add(threadData);
            ArrayList<yh> s = s(arrayList);
            if (ListUtils.isEmpty(this.b.c)) {
                this.b.c.addAll(s);
            } else {
                if (this.b.c.size() == 1 && (this.b.c.get(0) instanceof gd7)) {
                    this.b.c.remove(0);
                }
                this.b.c.addAll(0, s);
            }
            this.a.x2(this.b);
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.h = true;
            if (!this.e) {
                if (this.d.h0()) {
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
            } else if (this.g.h0()) {
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
            xs7.a();
        }
    }

    public final void b(List<yh> list) {
        JSONObject b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) != null) || ez8.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (yh yhVar : list) {
            if ((yhVar instanceof ThreadData) && (b = h1a.b(((ThreadData) yhVar).getRawThreadInfo())) != null) {
                arrayList.add(b);
            }
        }
        h1a.f().h(this.n, arrayList);
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.h = false;
            if (!this.e) {
                if (this.d.h0()) {
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
            } else if (this.g.h0()) {
                return;
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.f.qType = 2;
                } else {
                    this.f.qType = 1;
                }
                this.g.loadData();
            }
            xs7.a();
        }
    }

    public final String c() {
        InterceptResult invokeV;
        int b;
        String d;
        ArrayList<yh> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.h) {
                b = 0;
            } else {
                b = wy9.b(this.b.c);
            }
            if (this.h) {
                d = "";
            } else {
                d = h1a.f().d(this.n);
            }
            hg7 hg7Var = this.b;
            if (hg7Var == null) {
                arrayList = null;
            } else {
                arrayList = hg7Var.c;
            }
            String e = wy9.e(arrayList, this.h);
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
            hg7 hg7Var = this.b;
            if (hg7Var == null) {
                return true;
            }
            return hg7Var.a;
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

    public hg7 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (hg7) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            hg7 hg7Var = this.b;
            if (hg7Var != null && !ListUtils.isEmpty(hg7Var.c)) {
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
            FrsCommonTabNetModel frsCommonTabNetModel = this.d;
            if (frsCommonTabNetModel != null) {
                return frsCommonTabNetModel.h0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public final void g(List<App> list, List<yh> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, list, list2) == null) {
            b(list2);
            wy9.i(wy9.h(list, "FRS_GENERAL_TAB"), list2, 0);
            wy9.a(list2, this.j, "FRS_GENERAL_TAB");
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

    public void m(String str) {
        hg7 hg7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, str) == null) && (hg7Var = this.b) != null && !ez8.e(hg7Var.c)) {
            wy9.d(str, this.b.c);
            this.a.x2(this.b);
        }
    }

    public void p(ct7 ct7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ct7Var) == null) {
            this.o = ct7Var;
        }
    }

    public void q(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j) == null) {
            this.k = j;
        }
    }

    public void r(int i) {
        FrsCommonTabRequestData frsCommonTabRequestData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048594, this, i) == null) && (frsCommonTabRequestData = this.c) != null) {
            frsCommonTabRequestData.tabType = i;
        }
    }

    public final boolean n(hg7 hg7Var) {
        InterceptResult invokeL;
        boolean z;
        ct7 ct7Var;
        ct7 ct7Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, hg7Var)) == null) {
            if (hg7Var == null) {
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
                Iterator<yh> it = hg7Var.c.iterator();
                while (it.hasNext()) {
                    yh next = it.next();
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
                int i = hg7Var.l;
                if (i != -1) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (ct7.d()) {
                                    ct7 ct7Var3 = this.o;
                                    if (ct7Var3 != null) {
                                        ct7Var3.b(hg7Var.c, this.h, this.a.r0());
                                    }
                                } else {
                                    g(hg7Var.k, hg7Var.c);
                                }
                            } else if (!ListUtils.isEmpty(hg7Var.m)) {
                                int intValue = hg7Var.m.get(0).ad_type.intValue();
                                if (intValue == 1) {
                                    g(hg7Var.k, hg7Var.c);
                                } else if (intValue == 2 && (ct7Var2 = this.o) != null) {
                                    ct7Var2.g(hg7Var.c, hg7Var.m, this.h, this.a.r0());
                                }
                            }
                        } else {
                            ct7 ct7Var4 = this.o;
                            if (ct7Var4 != null) {
                                ct7Var4.b(hg7Var.c, this.h, this.a.r0());
                            }
                        }
                    } else {
                        g(hg7Var.k, hg7Var.c);
                    }
                }
                this.b = hg7Var;
                hg7Var.c = s(hg7Var.c);
            } else {
                hg7 hg7Var2 = this.b;
                hg7Var2.a = hg7Var.a;
                hg7Var2.b.putAll(hg7Var.b);
                ArrayList<yh> arrayList2 = new ArrayList<>();
                Iterator<yh> it2 = hg7Var.c.iterator();
                while (it2.hasNext()) {
                    yh next2 = it2.next();
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
                    String str = ((VideoItemData) arrayList.get(0)).forum_id;
                    FrsVideoTabPlayActivityConfig.getVideoTabListByFid(str).clear();
                    FrsVideoTabPlayActivityConfig.getVideoTabListByFid(str).addAll(arrayList);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921628));
                }
                int i2 = hg7Var.l;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (ct7.d()) {
                                ct7 ct7Var5 = this.o;
                                if (ct7Var5 != null) {
                                    ct7Var5.b(hg7Var.c, this.h, this.a.r0());
                                }
                            } else {
                                g(hg7Var.k, hg7Var.c);
                            }
                        } else if (!ListUtils.isEmpty(hg7Var.m)) {
                            int intValue2 = hg7Var.m.get(0).ad_type.intValue();
                            if (intValue2 == 1) {
                                g(hg7Var.k, hg7Var.c);
                            } else if (intValue2 == 2 && (ct7Var = this.o) != null) {
                                ct7Var.g(hg7Var.c, hg7Var.m, this.h, this.a.r0());
                            }
                        }
                    } else {
                        ct7 ct7Var6 = this.o;
                        if (ct7Var6 != null) {
                            ct7Var6.b(hg7Var.c, this.h, this.a.r0());
                        }
                    }
                } else {
                    g(hg7Var.k, hg7Var.c);
                }
                this.b.c.addAll(s(arrayList2));
            }
            this.a.x2(this.b);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final ArrayList<yh> s(ArrayList<yh> arrayList) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, arrayList)) == null) {
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
            ArrayList<yh> arrayList2 = new ArrayList<>();
            Iterator<yh> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                yh next = it.next();
                if (next instanceof bx4) {
                    ((bx4) next).setPosition(i);
                    arrayList2.add(next);
                } else if (next instanceof cx4) {
                    ((cx4) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        py4 py4Var = new py4();
                        py4Var.t = threadData;
                        py4Var.position = i;
                        py4Var.a = true;
                        py4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(py4Var);
                        py4 py4Var2 = new py4();
                        py4Var2.t = threadData;
                        py4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            py4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            py4Var2.d = true;
                            py4Var2.u = imageWidthAndHeight[0];
                            py4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            py4Var2.e = true;
                        } else {
                            py4Var2.b = true;
                        }
                        py4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(py4Var2);
                        if (threadData.getPollData() != null) {
                            py4 py4Var3 = new py4();
                            py4Var3.o = true;
                            py4Var3.t = threadData;
                            py4Var3.position = i;
                            py4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(py4Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            py4 py4Var4 = new py4();
                            py4Var4.l = true;
                            py4Var4.t = threadData;
                            py4Var4.position = i;
                            py4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(py4Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            py4 py4Var5 = new py4();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                py4Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                py4Var5.q = true;
                            }
                            py4Var5.t = threadData;
                            py4Var5.position = i;
                            py4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(py4Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            py4 py4Var6 = new py4();
                            py4Var6.h = true;
                            py4Var6.t = threadData;
                            py4Var6.position = i;
                            py4Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(py4Var6);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            py4 py4Var7 = new py4();
                            py4Var7.n = true;
                            py4Var7.t = threadData;
                            py4Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(py4Var7);
                        }
                        py4 py4Var8 = new py4();
                        py4Var8.g = true;
                        py4Var8.t = threadData;
                        py4Var8.position = i;
                        py4Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(py4Var8);
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        py4 py4Var9 = new py4();
                        py4Var9.t = threadData;
                        py4Var9.position = i;
                        py4Var9.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        py4Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(py4Var9);
                        py4 py4Var10 = new py4();
                        py4Var10.t = threadData;
                        py4Var10.position = i;
                        if (threadData instanceof jx4) {
                            py4Var10.j = true;
                        } else {
                            py4Var10.i = true;
                        }
                        py4Var10.t.isJumpToFrsVideoTabPlay = z2;
                        py4Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(py4Var10);
                        if (threadData.getPollData() != null) {
                            py4 py4Var11 = new py4();
                            py4Var11.o = true;
                            py4Var11.t = threadData;
                            py4Var11.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            py4Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(py4Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            py4 py4Var12 = new py4();
                            py4Var12.l = true;
                            py4Var12.t = threadData;
                            py4Var12.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            py4Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(py4Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            py4 py4Var13 = new py4();
                            py4Var13.h = true;
                            py4Var13.t = threadData;
                            py4Var13.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            py4Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(py4Var13);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            py4 py4Var14 = new py4();
                            py4Var14.n = true;
                            py4Var14.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            py4Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(py4Var14);
                        }
                        py4 py4Var15 = new py4();
                        py4Var15.g = true;
                        py4Var15.t = threadData;
                        py4Var15.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        py4Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(py4Var15);
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        py4 py4Var16 = new py4();
                        py4Var16.t = threadData;
                        py4Var16.position = i;
                        py4Var16.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        py4Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(py4Var16);
                        py4 py4Var17 = new py4();
                        py4Var17.t = threadData;
                        py4Var17.position = i;
                        py4Var17.k = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        py4Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(py4Var17);
                        if (threadData.getPollData() != null) {
                            py4 py4Var18 = new py4();
                            py4Var18.o = true;
                            py4Var18.t = threadData;
                            py4Var18.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            py4Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(py4Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            py4 py4Var19 = new py4();
                            py4Var19.l = true;
                            py4Var19.t = threadData;
                            py4Var19.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            py4Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(py4Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            py4 py4Var20 = new py4();
                            py4Var20.h = true;
                            py4Var20.t = threadData;
                            py4Var20.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            py4Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(py4Var20);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            py4 py4Var21 = new py4();
                            py4Var21.n = true;
                            py4Var21.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            py4Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(py4Var21);
                        }
                        py4 py4Var22 = new py4();
                        py4Var22.g = true;
                        py4Var22.t = threadData;
                        py4Var22.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        py4Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(py4Var22);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        py4 py4Var23 = new py4();
                        py4Var23.t = threadData;
                        py4Var23.position = i;
                        arrayList2.add(py4Var23);
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
