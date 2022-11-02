package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class e57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ThreadData threadData, int i, ArrayList<wn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65536, null, threadData, i, arrayList) == null) {
            if (threadData.getTabShowMode() == 1) {
                b(threadData, i, arrayList, true);
            } else if (threadData.getForumData() != null && !StringUtils.isNull(threadData.getForumData().b)) {
                b(threadData, i, arrayList, false);
            } else {
                b(threadData, i, arrayList, true);
            }
        }
    }

    public static void b(ThreadData threadData, int i, ArrayList<wn> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{threadData, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) {
            vu4 vu4Var = new vu4();
            vu4Var.t = threadData;
            vu4Var.position = i;
            if (z) {
                vu4Var.a = true;
            } else {
                vu4Var.r = true;
            }
            vu4Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(vu4Var);
        }
    }

    public static ArrayList<wn> c(ArrayList<wn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, arrayList)) == null) {
            ArrayList<wn> arrayList2 = new ArrayList<>();
            Iterator<wn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                wn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    threadData.isFromFeedTab = true;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        a(threadData, i, arrayList2);
                        vu4 vu4Var = new vu4();
                        vu4Var.t = threadData;
                        vu4Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            vu4Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            vu4Var.d = true;
                            vu4Var.u = imageWidthAndHeight[0];
                            vu4Var.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            vu4Var.e = true;
                        } else {
                            vu4Var.b = true;
                        }
                        vu4Var.t.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        vu4Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(vu4Var);
                        if (threadData.getItem() != null) {
                            vu4 vu4Var2 = new vu4();
                            vu4Var2.n = true;
                            vu4Var2.t = threadData;
                            vu4Var2.position = i;
                            vu4Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(vu4Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            vu4 vu4Var3 = new vu4();
                            vu4Var3.t = threadData;
                            vu4Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                vu4Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                vu4Var3.q = true;
                            }
                            vu4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(vu4Var3);
                        }
                        vu4 vu4Var4 = new vu4();
                        vu4Var4.m = true;
                        vu4Var4.t = threadData;
                        vu4Var4.position = i;
                        vu4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(vu4Var4);
                        vu4 vu4Var5 = new vu4();
                        vu4Var5.g = true;
                        vu4Var5.t = threadData;
                        vu4Var5.position = i;
                        vu4Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(vu4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        vu4 vu4Var6 = new vu4();
                        vu4Var6.t = threadData;
                        vu4Var6.position = i;
                        vu4Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        vu4Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(vu4Var6);
                        if (threadData.getItem() != null) {
                            vu4 vu4Var7 = new vu4();
                            vu4Var7.n = true;
                            vu4Var7.t = threadData;
                            vu4Var7.position = i;
                            vu4Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(vu4Var7);
                        }
                        vu4 vu4Var8 = new vu4();
                        vu4Var8.m = true;
                        vu4Var8.t = threadData;
                        vu4Var8.position = i;
                        vu4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(vu4Var8);
                        vu4 vu4Var9 = new vu4();
                        vu4Var9.g = true;
                        vu4Var9.t = threadData;
                        vu4Var9.position = i;
                        vu4Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(vu4Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (n46.W(threadData)) {
                        n46 n46Var = new n46(threadData);
                        n46Var.g = threadData.getTid();
                        n46Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        n46Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(n46Var);
                    } else {
                        vu4 vu4Var10 = new vu4();
                        vu4Var10.t = threadData;
                        vu4Var10.position = i;
                        vu4Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(vu4Var10);
                    }
                } else if (next instanceof BaseCardInfo) {
                    ((BaseCardInfo) next).position = i;
                    arrayList2.add(next);
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

    public static String d(f55 f55Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, f55Var)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (skinType != 1) {
                if (skinType != 4) {
                    return f55Var.a();
                }
                return f55Var.b();
            }
            return f55Var.c();
        }
        return (String) invokeL.objValue;
    }

    public static String e(f55 f55Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, f55Var)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (skinType != 1) {
                if (skinType != 4) {
                    return f55Var.d();
                }
                return f55Var.e();
            }
            return f55Var.f();
        }
        return (String) invokeL.objValue;
    }

    public static f55 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (!ListUtils.isEmpty(TbSingleton.getInstance().getHomePageLuckyConfig())) {
                for (f55 f55Var : TbSingleton.getInstance().getHomePageLuckyConfig()) {
                    if (!StringUtils.isNull(f55Var.g()) && f55Var.g().equals(str)) {
                        return f55Var;
                    }
                }
            }
            return null;
        }
        return (f55) invokeL.objValue;
    }

    public static List<Integer> g(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z = false;
            int i = -1;
            int i2 = -1;
            for (int i3 = 0; i3 < bdTypeRecyclerView.getCount(); i3++) {
                wn B = bdTypeRecyclerView.B(i3);
                ThreadData threadData = null;
                if (B instanceof vu4) {
                    threadData = ((vu4) B).getThreadData();
                } else if (B instanceof ThreadData) {
                    threadData = (ThreadData) B;
                } else if (B instanceof n46) {
                    threadData = ((n46) B).a;
                }
                if (threadData != null && threadData.getTid().equals(str)) {
                    if (!z) {
                        i = i3;
                    }
                    z = true;
                    i2 = i3;
                }
            }
            arrayList.add(Integer.valueOf(i));
            arrayList.add(Integer.valueOf(i2));
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static void h(boolean z, ArrayList<wn> arrayList, rr4 rr4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Boolean.valueOf(z), arrayList, rr4Var}) == null) && rr4Var != null && arrayList != null && (i = rr4Var.floorPosition) >= 0) {
            if (i != 0 || z) {
                int size = arrayList.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    if (arrayList.get(i3) instanceof ThreadData) {
                        if (i == i2) {
                            ListUtils.add(arrayList, i3, rr4Var);
                            return;
                        }
                        i2++;
                    }
                }
            }
        }
    }
}
