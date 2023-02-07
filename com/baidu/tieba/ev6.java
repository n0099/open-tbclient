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
public class ev6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public fv6 b;
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
    public l67 o;

    public ev6(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
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
            frsDynamicModel.i0(this);
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
        frsCommonTabNetModel.i0(this);
        this.d.setUniqueId(frsCommonTabFragment.getUniqueId());
    }

    public void a(ThreadData threadData) {
        fv6 fv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) && threadData != null && (fv6Var = this.b) != null && fv6Var.c != null) {
            ArrayList<Cdo> arrayList = new ArrayList<>();
            arrayList.add(threadData);
            ArrayList<Cdo> s = s(arrayList);
            if (ListUtils.isEmpty(this.b.c)) {
                this.b.c.addAll(s);
            } else {
                if (this.b.c.size() == 1 && (this.b.c.get(0) instanceof is6)) {
                    this.b.c.remove(0);
                }
                this.b.c.addAll(0, s);
            }
            this.a.Y1(this.b);
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.h = true;
            if (!this.e) {
                if (this.d.a0()) {
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
            } else if (this.g.a0()) {
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
            g67.a();
        }
    }

    public final void b(List<Cdo> list) {
        JSONObject b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || mv7.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Cdo cdo : list) {
            if ((cdo instanceof ThreadData) && (b = ys8.b(((ThreadData) cdo).getRawThreadInfo())) != null) {
                arrayList.add(b);
            }
        }
        ys8.f().h(this.n, arrayList);
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.h = false;
            if (!this.e) {
                if (this.d.a0()) {
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
            } else if (this.g.a0()) {
                return;
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.f.qType = 2;
                } else {
                    this.f.qType = 1;
                }
                this.g.loadData();
            }
            g67.a();
        }
    }

    public final String c() {
        InterceptResult invokeV;
        int b;
        String d;
        ArrayList<Cdo> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.h) {
                b = 0;
            } else {
                b = qq8.b(this.b.c);
            }
            if (this.h) {
                d = "";
            } else {
                d = ys8.f().d(this.n);
            }
            fv6 fv6Var = this.b;
            if (fv6Var == null) {
                arrayList = null;
            } else {
                arrayList = fv6Var.c;
            }
            String e = qq8.e(arrayList, this.h);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            fv6 fv6Var = this.b;
            if (fv6Var == null) {
                return true;
            }
            return fv6Var.a;
        }
        return invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public fv6 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (fv6) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            fv6 fv6Var = this.b;
            if (fv6Var != null && !ListUtils.isEmpty(fv6Var.c)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public final void g(List<App> list, List<Cdo> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, list2) == null) {
            b(list2);
            qq8.i(qq8.h(list, "FRS_GENERAL_TAB"), list2, 0);
            qq8.a(list2, this.j, "FRS_GENERAL_TAB");
        }
    }

    public final boolean i(int i) {
        InterceptResult invokeI;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.a;
            if (frsCommonTabFragment == null || (frsViewData = frsCommonTabFragment.d) == null || frsViewData.mHeadLineDefaultNavTabId != i) {
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void l(String str) {
        fv6 fv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && (fv6Var = this.b) != null && !mv7.e(fv6Var.c)) {
            qq8.d(str, this.b.c);
            this.a.Y1(this.b);
        }
    }

    public void o(l67 l67Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, l67Var) == null) {
            this.o = l67Var;
        }
    }

    public void p(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
            this.k = j;
        }
    }

    public void r(int i) {
        FrsCommonTabRequestData frsCommonTabRequestData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048593, this, i) == null) && (frsCommonTabRequestData = this.c) != null) {
            frsCommonTabRequestData.tabType = i;
        }
    }

    public final boolean m(fv6 fv6Var) {
        InterceptResult invokeL;
        boolean z;
        l67 l67Var;
        l67 l67Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, fv6Var)) == null) {
            if (fv6Var == null) {
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
                Iterator<Cdo> it = fv6Var.c.iterator();
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
                int i = fv6Var.l;
                if (i != -1) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (l67.d()) {
                                    l67 l67Var3 = this.o;
                                    if (l67Var3 != null) {
                                        l67Var3.b(fv6Var.c, this.h, this.a.O());
                                    }
                                } else {
                                    g(fv6Var.k, fv6Var.c);
                                }
                            } else if (!ListUtils.isEmpty(fv6Var.m)) {
                                int intValue = fv6Var.m.get(0).ad_type.intValue();
                                if (intValue == 1) {
                                    g(fv6Var.k, fv6Var.c);
                                } else if (intValue == 2 && (l67Var2 = this.o) != null) {
                                    l67Var2.g(fv6Var.c, fv6Var.m, this.h, this.a.O());
                                }
                            }
                        } else {
                            l67 l67Var4 = this.o;
                            if (l67Var4 != null) {
                                l67Var4.b(fv6Var.c, this.h, this.a.O());
                            }
                        }
                    } else {
                        g(fv6Var.k, fv6Var.c);
                    }
                }
                this.b = fv6Var;
                fv6Var.c = s(fv6Var.c);
            } else {
                fv6 fv6Var2 = this.b;
                fv6Var2.a = fv6Var.a;
                fv6Var2.b.putAll(fv6Var.b);
                ArrayList<Cdo> arrayList2 = new ArrayList<>();
                Iterator<Cdo> it2 = fv6Var.c.iterator();
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
                int i2 = fv6Var.l;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (l67.d()) {
                                l67 l67Var5 = this.o;
                                if (l67Var5 != null) {
                                    l67Var5.b(fv6Var.c, this.h, this.a.O());
                                }
                            } else {
                                g(fv6Var.k, fv6Var.c);
                            }
                        } else if (!ListUtils.isEmpty(fv6Var.m)) {
                            int intValue2 = fv6Var.m.get(0).ad_type.intValue();
                            if (intValue2 == 1) {
                                g(fv6Var.k, fv6Var.c);
                            } else if (intValue2 == 2 && (l67Var = this.o) != null) {
                                l67Var.g(fv6Var.c, fv6Var.m, this.h, this.a.O());
                            }
                        }
                    } else {
                        l67 l67Var6 = this.o;
                        if (l67Var6 != null) {
                            l67Var6.b(fv6Var.c, this.h, this.a.O());
                        }
                    }
                } else {
                    g(fv6Var.k, fv6Var.c);
                }
                this.b.c.addAll(s(arrayList2));
            }
            this.a.Y1(this.b);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void q(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048592, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) != null) || mvcSocketResponsedMessage == null) {
            return;
        }
        fv6 fv6Var = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof fv6) {
                fv6Var = (fv6) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof gv6) {
                gv6 gv6Var = (gv6) mvcSocketResponsedMessage.getData();
                fv6 fv6Var2 = new fv6();
                ArrayList<Cdo> arrayList = gv6Var.a;
                fv6Var2.c = arrayList;
                fv6Var2.a = gv6Var.c;
                fv6Var2.b = gv6Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<Cdo> arrayList2 = fv6Var2.c;
                    Cdo cdo = (Cdo) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (cdo instanceof ThreadData) {
                        this.f.lastThreadId = dh.g(((ThreadData) cdo).getId(), 0L);
                    }
                }
                fv6Var = fv6Var2;
            }
        }
        if (fv6Var != null && m(fv6Var)) {
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

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void y(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048595, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        fv6 fv6Var = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof fv6) {
                fv6Var = (fv6) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof gv6) {
                gv6 gv6Var = (gv6) mvcHttpResponsedMessage.getData();
                fv6 fv6Var2 = new fv6();
                ArrayList<Cdo> arrayList = gv6Var.a;
                fv6Var2.c = arrayList;
                fv6Var2.a = gv6Var.c;
                fv6Var2.b = gv6Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<Cdo> arrayList2 = fv6Var2.c;
                    Cdo cdo = (Cdo) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (cdo instanceof ThreadData) {
                        this.f.lastThreadId = dh.g(((ThreadData) cdo).getId(), 0L);
                    }
                }
                fv6Var = fv6Var2;
            }
        }
        if (fv6Var != null && m(fv6Var)) {
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

    public final ArrayList<Cdo> s(ArrayList<Cdo> arrayList) {
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
                if (next instanceof hy4) {
                    ((hy4) next).setPosition(i);
                    arrayList2.add(next);
                } else if (next instanceof iy4) {
                    ((iy4) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        wz4 wz4Var = new wz4();
                        wz4Var.t = threadData;
                        wz4Var.position = i;
                        wz4Var.a = true;
                        wz4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(wz4Var);
                        wz4 wz4Var2 = new wz4();
                        wz4Var2.t = threadData;
                        wz4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            wz4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            wz4Var2.d = true;
                            wz4Var2.u = imageWidthAndHeight[0];
                            wz4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            wz4Var2.e = true;
                        } else {
                            wz4Var2.b = true;
                        }
                        wz4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(wz4Var2);
                        if (threadData.getPollData() != null) {
                            wz4 wz4Var3 = new wz4();
                            wz4Var3.o = true;
                            wz4Var3.t = threadData;
                            wz4Var3.position = i;
                            wz4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(wz4Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            wz4 wz4Var4 = new wz4();
                            wz4Var4.l = true;
                            wz4Var4.t = threadData;
                            wz4Var4.position = i;
                            wz4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(wz4Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            wz4 wz4Var5 = new wz4();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                wz4Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                wz4Var5.q = true;
                            }
                            wz4Var5.t = threadData;
                            wz4Var5.position = i;
                            wz4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(wz4Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            wz4 wz4Var6 = new wz4();
                            wz4Var6.h = true;
                            wz4Var6.t = threadData;
                            wz4Var6.position = i;
                            wz4Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(wz4Var6);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            wz4 wz4Var7 = new wz4();
                            wz4Var7.n = true;
                            wz4Var7.t = threadData;
                            wz4Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(wz4Var7);
                        }
                        wz4 wz4Var8 = new wz4();
                        wz4Var8.g = true;
                        wz4Var8.t = threadData;
                        wz4Var8.position = i;
                        wz4Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(wz4Var8);
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        wz4 wz4Var9 = new wz4();
                        wz4Var9.t = threadData;
                        wz4Var9.position = i;
                        wz4Var9.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        wz4Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(wz4Var9);
                        wz4 wz4Var10 = new wz4();
                        wz4Var10.t = threadData;
                        wz4Var10.position = i;
                        if (threadData instanceof qy4) {
                            wz4Var10.j = true;
                        } else {
                            wz4Var10.i = true;
                        }
                        wz4Var10.t.isJumpToFrsVideoTabPlay = z2;
                        wz4Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(wz4Var10);
                        if (threadData.getPollData() != null) {
                            wz4 wz4Var11 = new wz4();
                            wz4Var11.o = true;
                            wz4Var11.t = threadData;
                            wz4Var11.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            wz4Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(wz4Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            wz4 wz4Var12 = new wz4();
                            wz4Var12.l = true;
                            wz4Var12.t = threadData;
                            wz4Var12.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            wz4Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(wz4Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            wz4 wz4Var13 = new wz4();
                            wz4Var13.h = true;
                            wz4Var13.t = threadData;
                            wz4Var13.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            wz4Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(wz4Var13);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            wz4 wz4Var14 = new wz4();
                            wz4Var14.n = true;
                            wz4Var14.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            wz4Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(wz4Var14);
                        }
                        wz4 wz4Var15 = new wz4();
                        wz4Var15.g = true;
                        wz4Var15.t = threadData;
                        wz4Var15.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        wz4Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(wz4Var15);
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        wz4 wz4Var16 = new wz4();
                        wz4Var16.t = threadData;
                        wz4Var16.position = i;
                        wz4Var16.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        wz4Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(wz4Var16);
                        wz4 wz4Var17 = new wz4();
                        wz4Var17.t = threadData;
                        wz4Var17.position = i;
                        wz4Var17.k = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        wz4Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(wz4Var17);
                        if (threadData.getPollData() != null) {
                            wz4 wz4Var18 = new wz4();
                            wz4Var18.o = true;
                            wz4Var18.t = threadData;
                            wz4Var18.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            wz4Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(wz4Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            wz4 wz4Var19 = new wz4();
                            wz4Var19.l = true;
                            wz4Var19.t = threadData;
                            wz4Var19.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            wz4Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(wz4Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            wz4 wz4Var20 = new wz4();
                            wz4Var20.h = true;
                            wz4Var20.t = threadData;
                            wz4Var20.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            wz4Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(wz4Var20);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            wz4 wz4Var21 = new wz4();
                            wz4Var21.n = true;
                            wz4Var21.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            wz4Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(wz4Var21);
                        }
                        wz4 wz4Var22 = new wz4();
                        wz4Var22.g = true;
                        wz4Var22.t = threadData;
                        wz4Var22.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        wz4Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(wz4Var22);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        wz4 wz4Var23 = new wz4();
                        wz4Var23.t = threadData;
                        wz4Var23.position = i;
                        arrayList2.add(wz4Var23);
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
