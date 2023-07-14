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
/* loaded from: classes5.dex */
public class cl7 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public dl7 b;
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
    public by7 o;

    public cl7(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
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
            frsDynamicModel.x0(this);
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
        frsCommonTabNetModel.x0(this);
        this.d.setUniqueId(frsCommonTabFragment.getUniqueId());
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void A(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048576, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) != null) || mvcSocketResponsedMessage == null) {
            return;
        }
        dl7 dl7Var = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof dl7) {
                dl7Var = (dl7) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof el7) {
                el7 el7Var = (el7) mvcSocketResponsedMessage.getData();
                dl7 dl7Var2 = new dl7();
                ArrayList<yn> arrayList = el7Var.a;
                dl7Var2.c = arrayList;
                dl7Var2.a = el7Var.c;
                dl7Var2.b = el7Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<yn> arrayList2 = dl7Var2.c;
                    yn ynVar = (yn) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (ynVar instanceof ThreadData) {
                        this.f.lastThreadId = wg.g(((ThreadData) ynVar).getId(), 0L);
                    }
                }
                dl7Var = dl7Var2;
            }
        }
        if (dl7Var != null && n(dl7Var)) {
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
    public void M(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        dl7 dl7Var = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof dl7) {
                dl7Var = (dl7) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof el7) {
                el7 el7Var = (el7) mvcHttpResponsedMessage.getData();
                dl7 dl7Var2 = new dl7();
                ArrayList<yn> arrayList = el7Var.a;
                dl7Var2.c = arrayList;
                dl7Var2.a = el7Var.c;
                dl7Var2.b = el7Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<yn> arrayList2 = dl7Var2.c;
                    yn ynVar = (yn) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (ynVar instanceof ThreadData) {
                        this.f.lastThreadId = wg.g(((ThreadData) ynVar).getId(), 0L);
                    }
                }
                dl7Var = dl7Var2;
            }
        }
        if (dl7Var != null && n(dl7Var)) {
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

    public void a(ThreadData threadData) {
        dl7 dl7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) && threadData != null && (dl7Var = this.b) != null && dl7Var.c != null) {
            ArrayList<yn> arrayList = new ArrayList<>();
            arrayList.add(threadData);
            ArrayList<yn> s = s(arrayList);
            if (ListUtils.isEmpty(this.b.c)) {
                this.b.c.addAll(s);
            } else {
                if (this.b.c.size() == 1 && (this.b.c.get(0) instanceof gi7)) {
                    this.b.c.remove(0);
                }
                this.b.c.addAll(0, s);
            }
            this.a.c2(this.b);
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.h = true;
            if (!this.e) {
                if (this.d.p0()) {
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
            } else if (this.g.p0()) {
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
            wx7.a();
        }
    }

    public final void b(List<yn> list) {
        JSONObject b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, list) != null) || g09.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (yn ynVar : list) {
            if ((ynVar instanceof ThreadData) && (b = i0a.b(((ThreadData) ynVar).getRawThreadInfo())) != null) {
                arrayList.add(b);
            }
        }
        i0a.f().h(this.n, arrayList);
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.h = false;
            if (!this.e) {
                if (this.d.p0()) {
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
            } else if (this.g.p0()) {
                return;
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.f.qType = 2;
                } else {
                    this.f.qType = 1;
                }
                this.g.loadData();
            }
            wx7.a();
        }
    }

    public final String c() {
        InterceptResult invokeV;
        int b;
        String d;
        ArrayList<yn> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.h) {
                b = 0;
            } else {
                b = xx9.b(this.b.c);
            }
            if (this.h) {
                d = "";
            } else {
                d = i0a.f().d(this.n);
            }
            dl7 dl7Var = this.b;
            if (dl7Var == null) {
                arrayList = null;
            } else {
                arrayList = dl7Var.c;
            }
            String e = xx9.e(arrayList, this.h);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            dl7 dl7Var = this.b;
            if (dl7Var == null) {
                return true;
            }
            return dl7Var.a;
        }
        return invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public dl7 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (dl7) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            dl7 dl7Var = this.b;
            if (dl7Var != null && !ListUtils.isEmpty(dl7Var.c)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            FrsCommonTabNetModel frsCommonTabNetModel = this.d;
            if (frsCommonTabNetModel != null) {
                return frsCommonTabNetModel.p0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public final void g(List<App> list, List<yn> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, list2) == null) {
            b(list2);
            xx9.i(xx9.h(list, "FRS_GENERAL_TAB"), list2, 0);
            xx9.a(list2, this.j, "FRS_GENERAL_TAB");
        }
    }

    public final boolean i(int i) {
        InterceptResult invokeI;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.a;
            if (frsCommonTabFragment == null || (frsViewData = frsCommonTabFragment.d) == null || frsViewData.mHeadLineDefaultNavTabId != i) {
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void m(String str) {
        dl7 dl7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, str) == null) && (dl7Var = this.b) != null && !g09.e(dl7Var.c)) {
            xx9.d(str, this.b.c);
            this.a.c2(this.b);
        }
    }

    public void p(by7 by7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, by7Var) == null) {
            this.o = by7Var;
        }
    }

    public void q(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            this.k = j;
        }
    }

    public void r(int i) {
        FrsCommonTabRequestData frsCommonTabRequestData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048595, this, i) == null) && (frsCommonTabRequestData = this.c) != null) {
            frsCommonTabRequestData.tabType = i;
        }
    }

    public final boolean n(dl7 dl7Var) {
        InterceptResult invokeL;
        boolean z;
        by7 by7Var;
        by7 by7Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, dl7Var)) == null) {
            if (dl7Var == null) {
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
                Iterator<yn> it = dl7Var.c.iterator();
                while (it.hasNext()) {
                    yn next = it.next();
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
                int i = dl7Var.l;
                if (i != -1) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (by7.d()) {
                                    by7 by7Var3 = this.o;
                                    if (by7Var3 != null) {
                                        by7Var3.b(dl7Var.c, this.h, this.a.d0());
                                    }
                                } else {
                                    g(dl7Var.k, dl7Var.c);
                                }
                            } else if (!ListUtils.isEmpty(dl7Var.m)) {
                                int intValue = dl7Var.m.get(0).ad_type.intValue();
                                if (intValue == 1) {
                                    g(dl7Var.k, dl7Var.c);
                                } else if (intValue == 2 && (by7Var2 = this.o) != null) {
                                    by7Var2.g(dl7Var.c, dl7Var.m, this.h, this.a.d0());
                                }
                            }
                        } else {
                            by7 by7Var4 = this.o;
                            if (by7Var4 != null) {
                                by7Var4.b(dl7Var.c, this.h, this.a.d0());
                            }
                        }
                    } else {
                        g(dl7Var.k, dl7Var.c);
                    }
                }
                this.b = dl7Var;
                dl7Var.c = s(dl7Var.c);
            } else {
                dl7 dl7Var2 = this.b;
                dl7Var2.a = dl7Var.a;
                dl7Var2.b.putAll(dl7Var.b);
                ArrayList<yn> arrayList2 = new ArrayList<>();
                Iterator<yn> it2 = dl7Var.c.iterator();
                while (it2.hasNext()) {
                    yn next2 = it2.next();
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
                int i2 = dl7Var.l;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (by7.d()) {
                                by7 by7Var5 = this.o;
                                if (by7Var5 != null) {
                                    by7Var5.b(dl7Var.c, this.h, this.a.d0());
                                }
                            } else {
                                g(dl7Var.k, dl7Var.c);
                            }
                        } else if (!ListUtils.isEmpty(dl7Var.m)) {
                            int intValue2 = dl7Var.m.get(0).ad_type.intValue();
                            if (intValue2 == 1) {
                                g(dl7Var.k, dl7Var.c);
                            } else if (intValue2 == 2 && (by7Var = this.o) != null) {
                                by7Var.g(dl7Var.c, dl7Var.m, this.h, this.a.d0());
                            }
                        }
                    } else {
                        by7 by7Var6 = this.o;
                        if (by7Var6 != null) {
                            by7Var6.b(dl7Var.c, this.h, this.a.d0());
                        }
                    }
                } else {
                    g(dl7Var.k, dl7Var.c);
                }
                this.b.c.addAll(s(arrayList2));
            }
            this.a.c2(this.b);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final ArrayList<yn> s(ArrayList<yn> arrayList) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, arrayList)) == null) {
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
            ArrayList<yn> arrayList2 = new ArrayList<>();
            Iterator<yn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                yn next = it.next();
                if (next instanceof k35) {
                    ((k35) next).setPosition(i);
                    arrayList2.add(next);
                } else if (next instanceof l35) {
                    ((l35) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        z45 z45Var = new z45();
                        z45Var.t = threadData;
                        z45Var.position = i;
                        z45Var.a = true;
                        z45Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(z45Var);
                        z45 z45Var2 = new z45();
                        z45Var2.t = threadData;
                        z45Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            z45Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            z45Var2.d = true;
                            z45Var2.u = imageWidthAndHeight[0];
                            z45Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            z45Var2.e = true;
                        } else {
                            z45Var2.b = true;
                        }
                        z45Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(z45Var2);
                        if (threadData.getPollData() != null) {
                            z45 z45Var3 = new z45();
                            z45Var3.o = true;
                            z45Var3.t = threadData;
                            z45Var3.position = i;
                            z45Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(z45Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            z45 z45Var4 = new z45();
                            z45Var4.l = true;
                            z45Var4.t = threadData;
                            z45Var4.position = i;
                            z45Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(z45Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            z45 z45Var5 = new z45();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                z45Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                z45Var5.q = true;
                            }
                            z45Var5.t = threadData;
                            z45Var5.position = i;
                            z45Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(z45Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            z45 z45Var6 = new z45();
                            z45Var6.h = true;
                            z45Var6.t = threadData;
                            z45Var6.position = i;
                            z45Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(z45Var6);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            z45 z45Var7 = new z45();
                            z45Var7.n = true;
                            z45Var7.t = threadData;
                            z45Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(z45Var7);
                        }
                        z45 z45Var8 = new z45();
                        z45Var8.g = true;
                        z45Var8.t = threadData;
                        z45Var8.position = i;
                        z45Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(z45Var8);
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        z45 z45Var9 = new z45();
                        z45Var9.t = threadData;
                        z45Var9.position = i;
                        z45Var9.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        z45Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(z45Var9);
                        z45 z45Var10 = new z45();
                        z45Var10.t = threadData;
                        z45Var10.position = i;
                        if (threadData instanceof t35) {
                            z45Var10.j = true;
                        } else {
                            z45Var10.i = true;
                        }
                        z45Var10.t.isJumpToFrsVideoTabPlay = z2;
                        z45Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(z45Var10);
                        if (threadData.getPollData() != null) {
                            z45 z45Var11 = new z45();
                            z45Var11.o = true;
                            z45Var11.t = threadData;
                            z45Var11.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            z45Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(z45Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            z45 z45Var12 = new z45();
                            z45Var12.l = true;
                            z45Var12.t = threadData;
                            z45Var12.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            z45Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(z45Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            z45 z45Var13 = new z45();
                            z45Var13.h = true;
                            z45Var13.t = threadData;
                            z45Var13.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            z45Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(z45Var13);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            z45 z45Var14 = new z45();
                            z45Var14.n = true;
                            z45Var14.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            z45Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(z45Var14);
                        }
                        z45 z45Var15 = new z45();
                        z45Var15.g = true;
                        z45Var15.t = threadData;
                        z45Var15.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        z45Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(z45Var15);
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        z45 z45Var16 = new z45();
                        z45Var16.t = threadData;
                        z45Var16.position = i;
                        z45Var16.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        z45Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(z45Var16);
                        z45 z45Var17 = new z45();
                        z45Var17.t = threadData;
                        z45Var17.position = i;
                        z45Var17.k = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        z45Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(z45Var17);
                        if (threadData.getPollData() != null) {
                            z45 z45Var18 = new z45();
                            z45Var18.o = true;
                            z45Var18.t = threadData;
                            z45Var18.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            z45Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(z45Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            z45 z45Var19 = new z45();
                            z45Var19.l = true;
                            z45Var19.t = threadData;
                            z45Var19.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            z45Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(z45Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            z45 z45Var20 = new z45();
                            z45Var20.h = true;
                            z45Var20.t = threadData;
                            z45Var20.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            z45Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(z45Var20);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            z45 z45Var21 = new z45();
                            z45Var21.n = true;
                            z45Var21.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            z45Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(z45Var21);
                        }
                        z45 z45Var22 = new z45();
                        z45Var22.g = true;
                        z45Var22.t = threadData;
                        z45Var22.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        z45Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(z45Var22);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        z45 z45Var23 = new z45();
                        z45Var23.t = threadData;
                        z45Var23.position = i;
                        arrayList2.add(z45Var23);
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
