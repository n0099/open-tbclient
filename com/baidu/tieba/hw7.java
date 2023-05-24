package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
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
/* loaded from: classes5.dex */
public class hw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ThreadData threadData, int i, ArrayList<rn> arrayList) {
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

    public static void b(ThreadData threadData, int i, ArrayList<rn> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{threadData, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) {
            o15 o15Var = new o15();
            o15Var.t = threadData;
            o15Var.position = i;
            if (z) {
                o15Var.a = true;
            } else {
                o15Var.r = true;
            }
            o15Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(o15Var);
        }
    }

    public static ArrayList<rn> c(ArrayList<rn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, arrayList)) == null) {
            ArrayList<rn> arrayList2 = new ArrayList<>();
            Iterator<rn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                rn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    threadData.isFromFeedTab = true;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        a(threadData, i, arrayList2);
                        o15 o15Var = new o15();
                        o15Var.t = threadData;
                        o15Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            o15Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            o15Var.d = true;
                            o15Var.u = imageWidthAndHeight[0];
                            o15Var.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            o15Var.e = true;
                        } else {
                            o15Var.b = true;
                        }
                        o15Var.t.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        o15Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(o15Var);
                        if (threadData.getItem() != null) {
                            o15 o15Var2 = new o15();
                            o15Var2.n = true;
                            o15Var2.t = threadData;
                            o15Var2.position = i;
                            o15Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(o15Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            o15 o15Var3 = new o15();
                            o15Var3.t = threadData;
                            o15Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                o15Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                o15Var3.q = true;
                            }
                            o15Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(o15Var3);
                        }
                        o15 o15Var4 = new o15();
                        o15Var4.m = true;
                        o15Var4.t = threadData;
                        o15Var4.position = i;
                        o15Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(o15Var4);
                        o15 o15Var5 = new o15();
                        o15Var5.g = true;
                        o15Var5.t = threadData;
                        o15Var5.position = i;
                        o15Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(o15Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        o15 o15Var6 = new o15();
                        o15Var6.t = threadData;
                        o15Var6.position = i;
                        o15Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        o15Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(o15Var6);
                        if (threadData.getItem() != null) {
                            o15 o15Var7 = new o15();
                            o15Var7.n = true;
                            o15Var7.t = threadData;
                            o15Var7.position = i;
                            o15Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(o15Var7);
                        }
                        o15 o15Var8 = new o15();
                        o15Var8.m = true;
                        o15Var8.t = threadData;
                        o15Var8.position = i;
                        o15Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(o15Var8);
                        o15 o15Var9 = new o15();
                        o15Var9.g = true;
                        o15Var9.t = threadData;
                        o15Var9.position = i;
                        o15Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(o15Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (kk6.W(threadData)) {
                        kk6 kk6Var = new kk6(threadData);
                        kk6Var.g = threadData.getTid();
                        kk6Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        kk6Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(kk6Var);
                    } else {
                        o15 o15Var10 = new o15();
                        o15Var10.t = threadData;
                        o15Var10.position = i;
                        o15Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(o15Var10);
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

    public static List<Integer> d(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z = false;
            int i = -1;
            int i2 = -1;
            for (int i3 = 0; i3 < bdTypeRecyclerView.getCount(); i3++) {
                rn item = bdTypeRecyclerView.getItem(i3);
                ThreadData threadData = null;
                if (item instanceof o15) {
                    threadData = ((o15) item).getThreadData();
                } else if (item instanceof ThreadData) {
                    threadData = (ThreadData) item;
                } else if (item instanceof kk6) {
                    threadData = ((kk6) item).a;
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

    public static void e(boolean z, ArrayList<rn> arrayList, jy4 jy4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), arrayList, jy4Var}) == null) && jy4Var != null && arrayList != null && (i = jy4Var.floorPosition) >= 0) {
            if (i != 0 || z) {
                int size = arrayList.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    if (arrayList.get(i3) instanceof ThreadData) {
                        if (i == i2) {
                            ListUtils.add(arrayList, i3, jy4Var);
                            return;
                        }
                        i2++;
                    }
                }
            }
        }
    }
}
