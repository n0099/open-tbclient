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
/* loaded from: classes4.dex */
public class dy6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public ey6 b;
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
    public h97 o;

    public dy6(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
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
            frsDynamicRequestData.scrH = ej.j(TbadkCoreApplication.getInst());
            this.f.scrW = ej.l(TbadkCoreApplication.getInst());
            this.f.scrDip = ej.i(TbadkCoreApplication.getInst());
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
    public void C(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        ey6 ey6Var = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof ey6) {
                ey6Var = (ey6) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof fy6) {
                fy6 fy6Var = (fy6) mvcHttpResponsedMessage.getData();
                ey6 ey6Var2 = new ey6();
                ArrayList<Cdo> arrayList = fy6Var.a;
                ey6Var2.c = arrayList;
                ey6Var2.a = fy6Var.c;
                ey6Var2.b = fy6Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<Cdo> arrayList2 = ey6Var2.c;
                    Cdo cdo = (Cdo) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (cdo instanceof ThreadData) {
                        this.f.lastThreadId = dh.g(((ThreadData) cdo).getId(), 0L);
                    }
                }
                ey6Var = ey6Var2;
            }
        }
        if (ey6Var != null && m(ey6Var)) {
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
    public void t(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048595, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) != null) || mvcSocketResponsedMessage == null) {
            return;
        }
        ey6 ey6Var = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof ey6) {
                ey6Var = (ey6) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof fy6) {
                fy6 fy6Var = (fy6) mvcSocketResponsedMessage.getData();
                ey6 ey6Var2 = new ey6();
                ArrayList<Cdo> arrayList = fy6Var.a;
                ey6Var2.c = arrayList;
                ey6Var2.a = fy6Var.c;
                ey6Var2.b = fy6Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<Cdo> arrayList2 = ey6Var2.c;
                    Cdo cdo = (Cdo) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (cdo instanceof ThreadData) {
                        this.f.lastThreadId = dh.g(((ThreadData) cdo).getId(), 0L);
                    }
                }
                ey6Var = ey6Var2;
            }
        }
        if (ey6Var != null && m(ey6Var)) {
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
        ey6 ey6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) && threadData != null && (ey6Var = this.b) != null && ey6Var.c != null) {
            ArrayList<Cdo> arrayList = new ArrayList<>();
            arrayList.add(threadData);
            ArrayList<Cdo> r = r(arrayList);
            if (ListUtils.isEmpty(this.b.c)) {
                this.b.c.addAll(r);
            } else {
                if (this.b.c.size() == 1 && (this.b.c.get(0) instanceof hv6)) {
                    this.b.c.remove(0);
                }
                this.b.c.addAll(0, r);
            }
            this.a.X1(this.b);
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
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
            c97.a();
        }
    }

    public final void b(List<Cdo> list) {
        JSONObject b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) != null) || ry7.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Cdo cdo : list) {
            if ((cdo instanceof ThreadData) && (b = ox8.b(((ThreadData) cdo).getRawThreadInfo())) != null) {
                arrayList.add(b);
            }
        }
        ox8.f().h(this.n, arrayList);
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
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
            c97.a();
        }
    }

    public final String c() {
        InterceptResult invokeV;
        int b;
        String d;
        ArrayList<Cdo> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.h) {
                b = 0;
            } else {
                b = gv8.b(this.b.c);
            }
            if (this.h) {
                d = "";
            } else {
                d = ox8.f().d(this.n);
            }
            ey6 ey6Var = this.b;
            if (ey6Var == null) {
                arrayList = null;
            } else {
                arrayList = ey6Var.c;
            }
            String e = gv8.e(arrayList, this.h);
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
            ey6 ey6Var = this.b;
            if (ey6Var == null) {
                return true;
            }
            return ey6Var.a;
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

    public ey6 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (ey6) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ey6 ey6Var = this.b;
            if (ey6Var != null && !ListUtils.isEmpty(ey6Var.c)) {
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

    public final void g(List<App> list, List<Cdo> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, list, list2) == null) {
            b(list2);
            gv8.i(gv8.h(list, "FRS_GENERAL_TAB"), list2, 0);
            gv8.a(list2, this.j, "FRS_GENERAL_TAB");
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
        ey6 ey6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, str) == null) && (ey6Var = this.b) != null && !ry7.e(ey6Var.c)) {
            gv8.d(str, this.b.c);
            this.a.X1(this.b);
        }
    }

    public void o(h97 h97Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, h97Var) == null) {
            this.o = h97Var;
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

    public final boolean m(ey6 ey6Var) {
        InterceptResult invokeL;
        boolean z;
        h97 h97Var;
        h97 h97Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, ey6Var)) == null) {
            if (ey6Var == null) {
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
                Iterator<Cdo> it = ey6Var.c.iterator();
                while (it.hasNext()) {
                    Cdo next = it.next();
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
                int i = ey6Var.l;
                if (i != -1) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (h97.d()) {
                                    h97 h97Var3 = this.o;
                                    if (h97Var3 != null) {
                                        h97Var3.b(ey6Var.c, this.h, this.a.O());
                                    }
                                } else {
                                    g(ey6Var.k, ey6Var.c);
                                }
                            } else if (!ListUtils.isEmpty(ey6Var.m)) {
                                int intValue = ey6Var.m.get(0).ad_type.intValue();
                                if (intValue == 1) {
                                    g(ey6Var.k, ey6Var.c);
                                } else if (intValue == 2 && (h97Var2 = this.o) != null) {
                                    h97Var2.g(ey6Var.c, ey6Var.m, this.h, this.a.O());
                                }
                            }
                        } else {
                            h97 h97Var4 = this.o;
                            if (h97Var4 != null) {
                                h97Var4.b(ey6Var.c, this.h, this.a.O());
                            }
                        }
                    } else {
                        g(ey6Var.k, ey6Var.c);
                    }
                }
                this.b = ey6Var;
                ey6Var.c = r(ey6Var.c);
            } else {
                ey6 ey6Var2 = this.b;
                ey6Var2.a = ey6Var.a;
                ey6Var2.b.putAll(ey6Var.b);
                ArrayList<Cdo> arrayList2 = new ArrayList<>();
                Iterator<Cdo> it2 = ey6Var.c.iterator();
                while (it2.hasNext()) {
                    Cdo next2 = it2.next();
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
                int i2 = ey6Var.l;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (h97.d()) {
                                h97 h97Var5 = this.o;
                                if (h97Var5 != null) {
                                    h97Var5.b(ey6Var.c, this.h, this.a.O());
                                }
                            } else {
                                g(ey6Var.k, ey6Var.c);
                            }
                        } else if (!ListUtils.isEmpty(ey6Var.m)) {
                            int intValue2 = ey6Var.m.get(0).ad_type.intValue();
                            if (intValue2 == 1) {
                                g(ey6Var.k, ey6Var.c);
                            } else if (intValue2 == 2 && (h97Var = this.o) != null) {
                                h97Var.g(ey6Var.c, ey6Var.m, this.h, this.a.O());
                            }
                        }
                    } else {
                        h97 h97Var6 = this.o;
                        if (h97Var6 != null) {
                            h97Var6.b(ey6Var.c, this.h, this.a.O());
                        }
                    }
                } else {
                    g(ey6Var.k, ey6Var.c);
                }
                this.b.c.addAll(r(arrayList2));
            }
            this.a.X1(this.b);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final ArrayList<Cdo> r(ArrayList<Cdo> arrayList) {
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
            ArrayList<Cdo> arrayList2 = new ArrayList<>();
            Iterator<Cdo> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                Cdo next = it.next();
                if (next instanceof oz4) {
                    ((oz4) next).setPosition(i);
                    arrayList2.add(next);
                } else if (next instanceof pz4) {
                    ((pz4) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        d15 d15Var = new d15();
                        d15Var.t = threadData;
                        d15Var.position = i;
                        d15Var.a = true;
                        d15Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(d15Var);
                        d15 d15Var2 = new d15();
                        d15Var2.t = threadData;
                        d15Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            d15Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            d15Var2.d = true;
                            d15Var2.u = imageWidthAndHeight[0];
                            d15Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            d15Var2.e = true;
                        } else {
                            d15Var2.b = true;
                        }
                        d15Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(d15Var2);
                        if (threadData.getPollData() != null) {
                            d15 d15Var3 = new d15();
                            d15Var3.o = true;
                            d15Var3.t = threadData;
                            d15Var3.position = i;
                            d15Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d15Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            d15 d15Var4 = new d15();
                            d15Var4.l = true;
                            d15Var4.t = threadData;
                            d15Var4.position = i;
                            d15Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d15Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            d15 d15Var5 = new d15();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                d15Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                d15Var5.q = true;
                            }
                            d15Var5.t = threadData;
                            d15Var5.position = i;
                            d15Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d15Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            d15 d15Var6 = new d15();
                            d15Var6.h = true;
                            d15Var6.t = threadData;
                            d15Var6.position = i;
                            d15Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d15Var6);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            d15 d15Var7 = new d15();
                            d15Var7.n = true;
                            d15Var7.t = threadData;
                            d15Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d15Var7);
                        }
                        d15 d15Var8 = new d15();
                        d15Var8.g = true;
                        d15Var8.t = threadData;
                        d15Var8.position = i;
                        d15Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(d15Var8);
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        d15 d15Var9 = new d15();
                        d15Var9.t = threadData;
                        d15Var9.position = i;
                        d15Var9.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        d15Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(d15Var9);
                        d15 d15Var10 = new d15();
                        d15Var10.t = threadData;
                        d15Var10.position = i;
                        if (threadData instanceof xz4) {
                            d15Var10.j = true;
                        } else {
                            d15Var10.i = true;
                        }
                        d15Var10.t.isJumpToFrsVideoTabPlay = z2;
                        d15Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(d15Var10);
                        if (threadData.getPollData() != null) {
                            d15 d15Var11 = new d15();
                            d15Var11.o = true;
                            d15Var11.t = threadData;
                            d15Var11.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            d15Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d15Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            d15 d15Var12 = new d15();
                            d15Var12.l = true;
                            d15Var12.t = threadData;
                            d15Var12.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            d15Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d15Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            d15 d15Var13 = new d15();
                            d15Var13.h = true;
                            d15Var13.t = threadData;
                            d15Var13.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            d15Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d15Var13);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            d15 d15Var14 = new d15();
                            d15Var14.n = true;
                            d15Var14.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            d15Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d15Var14);
                        }
                        d15 d15Var15 = new d15();
                        d15Var15.g = true;
                        d15Var15.t = threadData;
                        d15Var15.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        d15Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(d15Var15);
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        d15 d15Var16 = new d15();
                        d15Var16.t = threadData;
                        d15Var16.position = i;
                        d15Var16.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        d15Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(d15Var16);
                        d15 d15Var17 = new d15();
                        d15Var17.t = threadData;
                        d15Var17.position = i;
                        d15Var17.k = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        d15Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(d15Var17);
                        if (threadData.getPollData() != null) {
                            d15 d15Var18 = new d15();
                            d15Var18.o = true;
                            d15Var18.t = threadData;
                            d15Var18.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            d15Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d15Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            d15 d15Var19 = new d15();
                            d15Var19.l = true;
                            d15Var19.t = threadData;
                            d15Var19.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            d15Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d15Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            d15 d15Var20 = new d15();
                            d15Var20.h = true;
                            d15Var20.t = threadData;
                            d15Var20.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            d15Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d15Var20);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            d15 d15Var21 = new d15();
                            d15Var21.n = true;
                            d15Var21.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            d15Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d15Var21);
                        }
                        d15 d15Var22 = new d15();
                        d15Var22.g = true;
                        d15Var22.t = threadData;
                        d15Var22.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        d15Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(d15Var22);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        d15 d15Var23 = new d15();
                        d15Var23.t = threadData;
                        d15Var23.position = i;
                        arrayList2.add(d15Var23);
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
