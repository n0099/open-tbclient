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
/* loaded from: classes6.dex */
public class i58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ThreadData threadData, int i, ArrayList<ym> arrayList) {
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

    public static void b(ThreadData threadData, int i, ArrayList<ym> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{threadData, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) {
            w35 w35Var = new w35();
            w35Var.t = threadData;
            w35Var.position = i;
            if (z) {
                w35Var.a = true;
            } else {
                w35Var.r = true;
            }
            w35Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(w35Var);
        }
    }

    public static ArrayList<ym> c(ArrayList<ym> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, arrayList)) == null) {
            ArrayList<ym> arrayList2 = new ArrayList<>();
            Iterator<ym> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                ym next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    threadData.isFromFeedTab = true;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        a(threadData, i, arrayList2);
                        w35 w35Var = new w35();
                        w35Var.t = threadData;
                        w35Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            w35Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            w35Var.d = true;
                            w35Var.u = imageWidthAndHeight[0];
                            w35Var.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            w35Var.e = true;
                        } else {
                            w35Var.b = true;
                        }
                        w35Var.t.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        w35Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(w35Var);
                        if (threadData.getItem() != null) {
                            w35 w35Var2 = new w35();
                            w35Var2.n = true;
                            w35Var2.t = threadData;
                            w35Var2.position = i;
                            w35Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(w35Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            w35 w35Var3 = new w35();
                            w35Var3.t = threadData;
                            w35Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                w35Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                w35Var3.q = true;
                            }
                            w35Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(w35Var3);
                        }
                        w35 w35Var4 = new w35();
                        w35Var4.m = true;
                        w35Var4.t = threadData;
                        w35Var4.position = i;
                        w35Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(w35Var4);
                        w35 w35Var5 = new w35();
                        w35Var5.g = true;
                        w35Var5.t = threadData;
                        w35Var5.position = i;
                        w35Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(w35Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        w35 w35Var6 = new w35();
                        w35Var6.t = threadData;
                        w35Var6.position = i;
                        w35Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        w35Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(w35Var6);
                        if (threadData.getItem() != null) {
                            w35 w35Var7 = new w35();
                            w35Var7.n = true;
                            w35Var7.t = threadData;
                            w35Var7.position = i;
                            w35Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(w35Var7);
                        }
                        w35 w35Var8 = new w35();
                        w35Var8.m = true;
                        w35Var8.t = threadData;
                        w35Var8.position = i;
                        w35Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(w35Var8);
                        w35 w35Var9 = new w35();
                        w35Var9.g = true;
                        w35Var9.t = threadData;
                        w35Var9.position = i;
                        w35Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(w35Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (rn6.R(threadData)) {
                        rn6 rn6Var = new rn6(threadData);
                        rn6Var.g = threadData.getTid();
                        rn6Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        rn6Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(rn6Var);
                    } else {
                        w35 w35Var10 = new w35();
                        w35Var10.t = threadData;
                        w35Var10.position = i;
                        w35Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(w35Var10);
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
                ym item = bdTypeRecyclerView.getItem(i3);
                ThreadData threadData = null;
                if (item instanceof w35) {
                    threadData = ((w35) item).getThreadData();
                } else if (item instanceof ThreadData) {
                    threadData = (ThreadData) item;
                } else if (item instanceof rn6) {
                    threadData = ((rn6) item).a;
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

    public static void e(boolean z, ArrayList<ym> arrayList, q05 q05Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), arrayList, q05Var}) == null) && q05Var != null && arrayList != null && (i = q05Var.floorPosition) >= 0) {
            if (i != 0 || z) {
                int size = arrayList.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    if (arrayList.get(i3) instanceof ThreadData) {
                        if (i == i2) {
                            ListUtils.add(arrayList, i3, q05Var);
                            return;
                        }
                        i2++;
                    }
                }
            }
        }
    }
}
