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
public class fn6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public gn6 b;
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
    public cy6 o;

    public fn6(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
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
            frsDynamicRequestData.scrH = yi.j(TbadkCoreApplication.getInst());
            this.f.scrW = yi.l(TbadkCoreApplication.getInst());
            this.f.scrDip = yi.i(TbadkCoreApplication.getInst());
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
        gn6 gn6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) && threadData != null && (gn6Var = this.b) != null && gn6Var.c != null) {
            ArrayList<xn> arrayList = new ArrayList<>();
            arrayList.add(threadData);
            ArrayList<xn> s = s(arrayList);
            if (ListUtils.isEmpty(this.b.c)) {
                this.b.c.addAll(s);
            } else {
                if (this.b.c.size() == 1 && (this.b.c.get(0) instanceof kk6)) {
                    this.b.c.remove(0);
                }
                this.b.c.addAll(0, s);
            }
            this.a.T1(this.b);
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
            xx6.a();
        }
    }

    public final void b(List<xn> list) {
        JSONObject b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || fm7.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (xn xnVar : list) {
            if ((xnVar instanceof ThreadData) && (b = mk8.b(((ThreadData) xnVar).getRawThreadInfo())) != null) {
                arrayList.add(b);
            }
        }
        mk8.f().h(this.n, arrayList);
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
            xx6.a();
        }
    }

    public final String c() {
        InterceptResult invokeV;
        int b;
        String d;
        ArrayList<xn> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.h) {
                b = 0;
            } else {
                b = ei8.b(this.b.c);
            }
            if (this.h) {
                d = "";
            } else {
                d = mk8.f().d(this.n);
            }
            gn6 gn6Var = this.b;
            if (gn6Var == null) {
                arrayList = null;
            } else {
                arrayList = gn6Var.c;
            }
            String e = ei8.e(arrayList, this.h);
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
            gn6 gn6Var = this.b;
            if (gn6Var == null) {
                return true;
            }
            return gn6Var.a;
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

    public gn6 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (gn6) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            gn6 gn6Var = this.b;
            if (gn6Var != null && !ListUtils.isEmpty(gn6Var.c)) {
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

    public final void g(List<App> list, List<xn> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, list2) == null) {
            b(list2);
            ei8.i(ei8.h(list, "FRS_GENERAL_TAB"), list2, 0);
            ei8.a(list2, this.j, "FRS_GENERAL_TAB");
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
        gn6 gn6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && (gn6Var = this.b) != null && !fm7.e(gn6Var.c)) {
            ei8.d(str, this.b.c);
            this.a.T1(this.b);
        }
    }

    public void o(cy6 cy6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cy6Var) == null) {
            this.o = cy6Var;
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

    public final boolean m(gn6 gn6Var) {
        InterceptResult invokeL;
        boolean z;
        cy6 cy6Var;
        cy6 cy6Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, gn6Var)) == null) {
            if (gn6Var == null) {
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
                Iterator<xn> it = gn6Var.c.iterator();
                while (it.hasNext()) {
                    xn next = it.next();
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
                int i = gn6Var.l;
                if (i != -1) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (cy6.d()) {
                                    cy6 cy6Var3 = this.o;
                                    if (cy6Var3 != null) {
                                        cy6Var3.b(gn6Var.c, this.h, this.a.W());
                                    }
                                } else {
                                    g(gn6Var.k, gn6Var.c);
                                }
                            } else if (!ListUtils.isEmpty(gn6Var.m)) {
                                int intValue = gn6Var.m.get(0).ad_type.intValue();
                                if (intValue == 1) {
                                    g(gn6Var.k, gn6Var.c);
                                } else if (intValue == 2 && (cy6Var2 = this.o) != null) {
                                    cy6Var2.g(gn6Var.c, gn6Var.m, this.h, this.a.W());
                                }
                            }
                        } else {
                            cy6 cy6Var4 = this.o;
                            if (cy6Var4 != null) {
                                cy6Var4.b(gn6Var.c, this.h, this.a.W());
                            }
                        }
                    } else {
                        g(gn6Var.k, gn6Var.c);
                    }
                }
                this.b = gn6Var;
                gn6Var.c = s(gn6Var.c);
            } else {
                gn6 gn6Var2 = this.b;
                gn6Var2.a = gn6Var.a;
                gn6Var2.b.putAll(gn6Var.b);
                ArrayList<xn> arrayList2 = new ArrayList<>();
                Iterator<xn> it2 = gn6Var.c.iterator();
                while (it2.hasNext()) {
                    xn next2 = it2.next();
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
                int i2 = gn6Var.l;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (cy6.d()) {
                                cy6 cy6Var5 = this.o;
                                if (cy6Var5 != null) {
                                    cy6Var5.b(gn6Var.c, this.h, this.a.W());
                                }
                            } else {
                                g(gn6Var.k, gn6Var.c);
                            }
                        } else if (!ListUtils.isEmpty(gn6Var.m)) {
                            int intValue2 = gn6Var.m.get(0).ad_type.intValue();
                            if (intValue2 == 1) {
                                g(gn6Var.k, gn6Var.c);
                            } else if (intValue2 == 2 && (cy6Var = this.o) != null) {
                                cy6Var.g(gn6Var.c, gn6Var.m, this.h, this.a.W());
                            }
                        }
                    } else {
                        cy6 cy6Var6 = this.o;
                        if (cy6Var6 != null) {
                            cy6Var6.b(gn6Var.c, this.h, this.a.W());
                        }
                    }
                } else {
                    g(gn6Var.k, gn6Var.c);
                }
                this.b.c.addAll(s(arrayList2));
            }
            this.a.T1(this.b);
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
        gn6 gn6Var = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof gn6) {
                gn6Var = (gn6) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof hn6) {
                hn6 hn6Var = (hn6) mvcSocketResponsedMessage.getData();
                gn6 gn6Var2 = new gn6();
                ArrayList<xn> arrayList = hn6Var.a;
                gn6Var2.c = arrayList;
                gn6Var2.a = hn6Var.c;
                gn6Var2.b = hn6Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<xn> arrayList2 = gn6Var2.c;
                    xn xnVar = (xn) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (xnVar instanceof ThreadData) {
                        this.f.lastThreadId = xg.g(((ThreadData) xnVar).getId(), 0L);
                    }
                }
                gn6Var = gn6Var2;
            }
        }
        if (gn6Var != null && m(gn6Var)) {
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

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void y(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048595, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        gn6 gn6Var = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof gn6) {
                gn6Var = (gn6) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof hn6) {
                hn6 hn6Var = (hn6) mvcHttpResponsedMessage.getData();
                gn6 gn6Var2 = new gn6();
                ArrayList<xn> arrayList = hn6Var.a;
                gn6Var2.c = arrayList;
                gn6Var2.a = hn6Var.c;
                gn6Var2.b = hn6Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<xn> arrayList2 = gn6Var2.c;
                    xn xnVar = (xn) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (xnVar instanceof ThreadData) {
                        this.f.lastThreadId = xg.g(((ThreadData) xnVar).getId(), 0L);
                    }
                }
                gn6Var = gn6Var2;
            }
        }
        if (gn6Var != null && m(gn6Var)) {
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

    public final ArrayList<xn> s(ArrayList<xn> arrayList) {
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
            ArrayList<xn> arrayList2 = new ArrayList<>();
            Iterator<xn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                xn next = it.next();
                if (next instanceof jt4) {
                    ((jt4) next).setPosition(i);
                    arrayList2.add(next);
                } else if (next instanceof kt4) {
                    ((kt4) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        yu4 yu4Var = new yu4();
                        yu4Var.t = threadData;
                        yu4Var.position = i;
                        yu4Var.a = true;
                        yu4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(yu4Var);
                        yu4 yu4Var2 = new yu4();
                        yu4Var2.t = threadData;
                        yu4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            yu4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            yu4Var2.d = true;
                            yu4Var2.u = imageWidthAndHeight[0];
                            yu4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            yu4Var2.e = true;
                        } else {
                            yu4Var2.b = true;
                        }
                        yu4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(yu4Var2);
                        if (threadData.getPollData() != null) {
                            yu4 yu4Var3 = new yu4();
                            yu4Var3.o = true;
                            yu4Var3.t = threadData;
                            yu4Var3.position = i;
                            yu4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(yu4Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            yu4 yu4Var4 = new yu4();
                            yu4Var4.l = true;
                            yu4Var4.t = threadData;
                            yu4Var4.position = i;
                            yu4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(yu4Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            yu4 yu4Var5 = new yu4();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                yu4Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                yu4Var5.q = true;
                            }
                            yu4Var5.t = threadData;
                            yu4Var5.position = i;
                            yu4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(yu4Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            yu4 yu4Var6 = new yu4();
                            yu4Var6.h = true;
                            yu4Var6.t = threadData;
                            yu4Var6.position = i;
                            yu4Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(yu4Var6);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            yu4 yu4Var7 = new yu4();
                            yu4Var7.n = true;
                            yu4Var7.t = threadData;
                            yu4Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(yu4Var7);
                        }
                        yu4 yu4Var8 = new yu4();
                        yu4Var8.g = true;
                        yu4Var8.t = threadData;
                        yu4Var8.position = i;
                        yu4Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(yu4Var8);
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        yu4 yu4Var9 = new yu4();
                        yu4Var9.t = threadData;
                        yu4Var9.position = i;
                        yu4Var9.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        yu4Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(yu4Var9);
                        yu4 yu4Var10 = new yu4();
                        yu4Var10.t = threadData;
                        yu4Var10.position = i;
                        if (threadData instanceof st4) {
                            yu4Var10.j = true;
                        } else {
                            yu4Var10.i = true;
                        }
                        yu4Var10.t.isJumpToFrsVideoTabPlay = z2;
                        yu4Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(yu4Var10);
                        if (threadData.getPollData() != null) {
                            yu4 yu4Var11 = new yu4();
                            yu4Var11.o = true;
                            yu4Var11.t = threadData;
                            yu4Var11.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            yu4Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(yu4Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            yu4 yu4Var12 = new yu4();
                            yu4Var12.l = true;
                            yu4Var12.t = threadData;
                            yu4Var12.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            yu4Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(yu4Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            yu4 yu4Var13 = new yu4();
                            yu4Var13.h = true;
                            yu4Var13.t = threadData;
                            yu4Var13.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            yu4Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(yu4Var13);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            yu4 yu4Var14 = new yu4();
                            yu4Var14.n = true;
                            yu4Var14.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            yu4Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(yu4Var14);
                        }
                        yu4 yu4Var15 = new yu4();
                        yu4Var15.g = true;
                        yu4Var15.t = threadData;
                        yu4Var15.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        yu4Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(yu4Var15);
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        yu4 yu4Var16 = new yu4();
                        yu4Var16.t = threadData;
                        yu4Var16.position = i;
                        yu4Var16.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        yu4Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(yu4Var16);
                        yu4 yu4Var17 = new yu4();
                        yu4Var17.t = threadData;
                        yu4Var17.position = i;
                        yu4Var17.k = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        yu4Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(yu4Var17);
                        if (threadData.getPollData() != null) {
                            yu4 yu4Var18 = new yu4();
                            yu4Var18.o = true;
                            yu4Var18.t = threadData;
                            yu4Var18.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            yu4Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(yu4Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            yu4 yu4Var19 = new yu4();
                            yu4Var19.l = true;
                            yu4Var19.t = threadData;
                            yu4Var19.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            yu4Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(yu4Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            yu4 yu4Var20 = new yu4();
                            yu4Var20.h = true;
                            yu4Var20.t = threadData;
                            yu4Var20.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            yu4Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(yu4Var20);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            yu4 yu4Var21 = new yu4();
                            yu4Var21.n = true;
                            yu4Var21.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            yu4Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(yu4Var21);
                        }
                        yu4 yu4Var22 = new yu4();
                        yu4Var22.g = true;
                        yu4Var22.t = threadData;
                        yu4Var22.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        yu4Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(yu4Var22);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        yu4 yu4Var23 = new yu4();
                        yu4Var23.t = threadData;
                        yu4Var23.position = i;
                        arrayList2.add(yu4Var23);
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
