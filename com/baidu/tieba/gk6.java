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
public class gk6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public hk6 b;
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
    public dv6 o;

    public gk6(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
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
            frsDynamicRequestData.scrH = ej.i(TbadkCoreApplication.getInst());
            this.f.scrW = ej.k(TbadkCoreApplication.getInst());
            this.f.scrDip = ej.h(TbadkCoreApplication.getInst());
            FrsDynamicModel frsDynamicModel = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.f);
            this.g = frsDynamicModel;
            frsDynamicModel.b0(this);
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
        frsCommonTabNetModel.b0(this);
        this.d.setUniqueId(frsCommonTabFragment.getUniqueId());
    }

    public void a(ThreadData threadData) {
        hk6 hk6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || threadData == null || (hk6Var = this.b) == null || hk6Var.c == null) {
            return;
        }
        ArrayList<Cdo> arrayList = new ArrayList<>();
        arrayList.add(threadData);
        ArrayList<Cdo> t = t(arrayList);
        if (ListUtils.isEmpty(this.b.c)) {
            this.b.c.addAll(t);
        } else {
            if (this.b.c.size() == 1 && (this.b.c.get(0) instanceof lh6)) {
                this.b.c.remove(0);
            }
            this.b.c.addAll(0, t);
        }
        this.a.L1(this.b);
    }

    public final void b(List<Cdo> list) {
        JSONObject b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ah7.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Cdo cdo : list) {
            if ((cdo instanceof ThreadData) && (b = nf8.b(((ThreadData) cdo).getRawThreadInfo())) != null) {
                arrayList.add(b);
            }
        }
        nf8.f().h(this.n, arrayList);
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int b = this.h ? 0 : fd8.b(this.b.c);
            String d = this.h ? "" : nf8.f().d(this.n);
            hk6 hk6Var = this.b;
            String e = fd8.e(hk6Var == null ? null : hk6Var.c, this.h);
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
            hk6 hk6Var = this.b;
            if (hk6Var == null) {
                return true;
            }
            return hk6Var.a;
        }
        return invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j : invokeV.intValue;
    }

    public hk6 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : (hk6) invokeV.objValue;
    }

    public final void g(List<App> list, List<Cdo> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, list2) == null) {
            b(list2);
            fd8.i(fd8.h(list, "FRS_GENERAL_TAB"), list2, 0);
            fd8.a(list2, this.j, "FRS_GENERAL_TAB");
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            hk6 hk6Var = this.b;
            return (hk6Var == null || ListUtils.isEmpty(hk6Var.c)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean i(int i) {
        InterceptResult invokeI;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.a;
            return (frsCommonTabFragment == null || (frsViewData = frsCommonTabFragment.d) == null || frsViewData.mHeadLineDefaultNavTabId != i) ? false : true;
        }
        return invokeI.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.h : invokeV.booleanValue;
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.h = false;
            if (!this.e) {
                if (this.d.T()) {
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
            } else if (this.g.T()) {
                return;
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.f.qType = 2;
                } else {
                    this.f.qType = 1;
                }
                this.g.loadData();
            }
            yu6.a();
        }
    }

    public void l(String str) {
        hk6 hk6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || (hk6Var = this.b) == null || ah7.e(hk6Var.c)) {
            return;
        }
        fd8.d(str, this.b.c);
        this.a.L1(this.b);
    }

    public final boolean m(hk6 hk6Var) {
        InterceptResult invokeL;
        dv6 dv6Var;
        dv6 dv6Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, hk6Var)) == null) {
            if (hk6Var == null) {
                return false;
            }
            boolean z = this.a.h == 100;
            ArrayList arrayList = new ArrayList();
            if (this.h) {
                this.i.clear();
                Iterator<Cdo> it = hk6Var.c.iterator();
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
                int i = hk6Var.l;
                if (i != -1) {
                    if (i == 1) {
                        g(hk6Var.k, hk6Var.c);
                    } else if (i == 2) {
                        dv6 dv6Var3 = this.o;
                        if (dv6Var3 != null) {
                            dv6Var3.b(hk6Var.c, this.h, this.a.U());
                        }
                    } else if (i != 3) {
                        if (dv6.d()) {
                            dv6 dv6Var4 = this.o;
                            if (dv6Var4 != null) {
                                dv6Var4.b(hk6Var.c, this.h, this.a.U());
                            }
                        } else {
                            g(hk6Var.k, hk6Var.c);
                        }
                    } else if (!ListUtils.isEmpty(hk6Var.m)) {
                        int intValue = hk6Var.m.get(0).ad_type.intValue();
                        if (intValue == 1) {
                            g(hk6Var.k, hk6Var.c);
                        } else if (intValue == 2 && (dv6Var2 = this.o) != null) {
                            dv6Var2.g(hk6Var.c, hk6Var.m, this.h, this.a.U());
                        }
                    }
                }
                this.b = hk6Var;
                hk6Var.c = t(hk6Var.c);
            } else {
                hk6 hk6Var2 = this.b;
                hk6Var2.a = hk6Var.a;
                hk6Var2.b.putAll(hk6Var.b);
                ArrayList<Cdo> arrayList2 = new ArrayList<>();
                Iterator<Cdo> it2 = hk6Var.c.iterator();
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
                int i2 = hk6Var.l;
                if (i2 == 1) {
                    g(hk6Var.k, hk6Var.c);
                } else if (i2 == 2) {
                    dv6 dv6Var5 = this.o;
                    if (dv6Var5 != null) {
                        dv6Var5.b(hk6Var.c, this.h, this.a.U());
                    }
                } else if (i2 != 3) {
                    if (dv6.d()) {
                        dv6 dv6Var6 = this.o;
                        if (dv6Var6 != null) {
                            dv6Var6.b(hk6Var.c, this.h, this.a.U());
                        }
                    } else {
                        g(hk6Var.k, hk6Var.c);
                    }
                } else if (!ListUtils.isEmpty(hk6Var.m)) {
                    int intValue2 = hk6Var.m.get(0).ad_type.intValue();
                    if (intValue2 == 1) {
                        g(hk6Var.k, hk6Var.c);
                    } else if (intValue2 == 2 && (dv6Var = this.o) != null) {
                        dv6Var.g(hk6Var.c, hk6Var.m, this.h, this.a.U());
                    }
                }
                this.b.c.addAll(t(arrayList2));
            }
            this.a.L1(this.b);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048589, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        hk6 hk6Var = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof hk6) {
                hk6Var = (hk6) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof ik6) {
                ik6 ik6Var = (ik6) mvcSocketResponsedMessage.getData();
                hk6 hk6Var2 = new hk6();
                ArrayList<Cdo> arrayList = ik6Var.a;
                hk6Var2.c = arrayList;
                hk6Var2.a = ik6Var.c;
                hk6Var2.b = ik6Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<Cdo> arrayList2 = hk6Var2.c;
                    Cdo cdo = (Cdo) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (cdo instanceof ThreadData) {
                        this.f.lastThreadId = dh.g(((ThreadData) cdo).getId(), 0L);
                    }
                }
                hk6Var = hk6Var2;
            }
        }
        if (hk6Var == null || !m(hk6Var)) {
            this.l = mvcSocketResponsedMessage.getError();
            this.m = mvcSocketResponsedMessage.getErrorString();
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.l);
            errorData.setError_msg(this.m);
            if (this.l != 0) {
                this.a.f(errorData);
            }
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.h = true;
            if (!this.e) {
                if (this.d.T()) {
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
            } else if (this.g.T()) {
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
            yu6.a();
        }
    }

    public void p(dv6 dv6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, dv6Var) == null) {
            this.o = dv6Var;
        }
    }

    public void q(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.k = j;
        }
    }

    public void r(int i) {
        FrsCommonTabRequestData frsCommonTabRequestData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i) == null) || (frsCommonTabRequestData = this.c) == null) {
            return;
        }
        frsCommonTabRequestData.tabType = i;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void s(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048594, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null) {
            return;
        }
        hk6 hk6Var = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof hk6) {
                hk6Var = (hk6) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof ik6) {
                ik6 ik6Var = (ik6) mvcHttpResponsedMessage.getData();
                hk6 hk6Var2 = new hk6();
                ArrayList<Cdo> arrayList = ik6Var.a;
                hk6Var2.c = arrayList;
                hk6Var2.a = ik6Var.c;
                hk6Var2.b = ik6Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<Cdo> arrayList2 = hk6Var2.c;
                    Cdo cdo = (Cdo) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (cdo instanceof ThreadData) {
                        this.f.lastThreadId = dh.g(((ThreadData) cdo).getId(), 0L);
                    }
                }
                hk6Var = hk6Var2;
            }
        }
        if (hk6Var == null || !m(hk6Var)) {
            this.l = mvcHttpResponsedMessage.getError();
            this.m = mvcHttpResponsedMessage.getErrorString();
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.l);
            errorData.setError_msg(this.m);
            if (this.l != 0) {
                this.a.f(errorData);
            }
        }
    }

    public final ArrayList<Cdo> t(ArrayList<Cdo> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, arrayList)) == null) {
            boolean z = this.a.h == 16;
            boolean z2 = this.a.h == 100;
            ArrayList<Cdo> arrayList2 = new ArrayList<>();
            Iterator<Cdo> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                Cdo next = it.next();
                if (next instanceof ms4) {
                    ((ms4) next).setPosition(i);
                    arrayList2.add(next);
                } else if (next instanceof os4) {
                    ((os4) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        bu4 bu4Var = new bu4();
                        bu4Var.t = threadData;
                        bu4Var.position = i;
                        bu4Var.a = true;
                        bu4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(bu4Var);
                        bu4 bu4Var2 = new bu4();
                        bu4Var2.t = threadData;
                        bu4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            bu4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            bu4Var2.d = true;
                            bu4Var2.u = imageWidthAndHeight[0];
                            bu4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            bu4Var2.e = true;
                        } else {
                            bu4Var2.b = true;
                        }
                        bu4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(bu4Var2);
                        if (threadData.getPollData() != null) {
                            bu4 bu4Var3 = new bu4();
                            bu4Var3.o = true;
                            bu4Var3.t = threadData;
                            bu4Var3.position = i;
                            bu4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(bu4Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            bu4 bu4Var4 = new bu4();
                            bu4Var4.l = true;
                            bu4Var4.t = threadData;
                            bu4Var4.position = i;
                            bu4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(bu4Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            bu4 bu4Var5 = new bu4();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                bu4Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                bu4Var5.q = true;
                            }
                            bu4Var5.t = threadData;
                            bu4Var5.position = i;
                            bu4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(bu4Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            bu4 bu4Var6 = new bu4();
                            bu4Var6.h = true;
                            bu4Var6.t = threadData;
                            bu4Var6.position = i;
                            bu4Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(bu4Var6);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            bu4 bu4Var7 = new bu4();
                            bu4Var7.n = true;
                            bu4Var7.t = threadData;
                            bu4Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(bu4Var7);
                        }
                        bu4 bu4Var8 = new bu4();
                        bu4Var8.g = true;
                        bu4Var8.t = threadData;
                        bu4Var8.position = i;
                        bu4Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(bu4Var8);
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        bu4 bu4Var9 = new bu4();
                        bu4Var9.t = threadData;
                        bu4Var9.position = i;
                        bu4Var9.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        bu4Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(bu4Var9);
                        bu4 bu4Var10 = new bu4();
                        bu4Var10.t = threadData;
                        bu4Var10.position = i;
                        if (threadData instanceof ws4) {
                            bu4Var10.j = true;
                        } else {
                            bu4Var10.i = true;
                        }
                        bu4Var10.t.isJumpToFrsVideoTabPlay = z2;
                        bu4Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(bu4Var10);
                        if (threadData.getPollData() != null) {
                            bu4 bu4Var11 = new bu4();
                            bu4Var11.o = true;
                            bu4Var11.t = threadData;
                            bu4Var11.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            bu4Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(bu4Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            bu4 bu4Var12 = new bu4();
                            bu4Var12.l = true;
                            bu4Var12.t = threadData;
                            bu4Var12.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            bu4Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(bu4Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            bu4 bu4Var13 = new bu4();
                            bu4Var13.h = true;
                            bu4Var13.t = threadData;
                            bu4Var13.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            bu4Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(bu4Var13);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            bu4 bu4Var14 = new bu4();
                            bu4Var14.n = true;
                            bu4Var14.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            bu4Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(bu4Var14);
                        }
                        bu4 bu4Var15 = new bu4();
                        bu4Var15.g = true;
                        bu4Var15.t = threadData;
                        bu4Var15.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        bu4Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(bu4Var15);
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        bu4 bu4Var16 = new bu4();
                        bu4Var16.t = threadData;
                        bu4Var16.position = i;
                        bu4Var16.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        bu4Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(bu4Var16);
                        bu4 bu4Var17 = new bu4();
                        bu4Var17.t = threadData;
                        bu4Var17.position = i;
                        bu4Var17.k = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        bu4Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(bu4Var17);
                        if (threadData.getPollData() != null) {
                            bu4 bu4Var18 = new bu4();
                            bu4Var18.o = true;
                            bu4Var18.t = threadData;
                            bu4Var18.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            bu4Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(bu4Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            bu4 bu4Var19 = new bu4();
                            bu4Var19.l = true;
                            bu4Var19.t = threadData;
                            bu4Var19.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            bu4Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(bu4Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            bu4 bu4Var20 = new bu4();
                            bu4Var20.h = true;
                            bu4Var20.t = threadData;
                            bu4Var20.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            bu4Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(bu4Var20);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            bu4 bu4Var21 = new bu4();
                            bu4Var21.n = true;
                            bu4Var21.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            bu4Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(bu4Var21);
                        }
                        bu4 bu4Var22 = new bu4();
                        bu4Var22.g = true;
                        bu4Var22.t = threadData;
                        bu4Var22.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        bu4Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(bu4Var22);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        bu4 bu4Var23 = new bu4();
                        bu4Var23.t = threadData;
                        bu4Var23.position = i;
                        arrayList2.add(bu4Var23);
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
