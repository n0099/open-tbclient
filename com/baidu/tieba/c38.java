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
public class c38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ThreadData threadData, int i, ArrayList<yh> arrayList) {
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

    public static void b(ThreadData threadData, int i, ArrayList<yh> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{threadData, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) {
            py4 py4Var = new py4();
            py4Var.t = threadData;
            py4Var.position = i;
            if (z) {
                py4Var.a = true;
            } else {
                py4Var.r = true;
            }
            py4Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(py4Var);
        }
    }

    public static ArrayList<yh> c(ArrayList<yh> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, arrayList)) == null) {
            ArrayList<yh> arrayList2 = new ArrayList<>();
            Iterator<yh> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                yh next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    threadData.isFromFeedTab = true;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        a(threadData, i, arrayList2);
                        py4 py4Var = new py4();
                        py4Var.t = threadData;
                        py4Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            py4Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            py4Var.d = true;
                            py4Var.u = imageWidthAndHeight[0];
                            py4Var.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            py4Var.e = true;
                        } else {
                            py4Var.b = true;
                        }
                        py4Var.t.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        py4Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(py4Var);
                        if (threadData.getItem() != null) {
                            py4 py4Var2 = new py4();
                            py4Var2.n = true;
                            py4Var2.t = threadData;
                            py4Var2.position = i;
                            py4Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(py4Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            py4 py4Var3 = new py4();
                            py4Var3.t = threadData;
                            py4Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                py4Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                py4Var3.q = true;
                            }
                            py4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(py4Var3);
                        }
                        py4 py4Var4 = new py4();
                        py4Var4.m = true;
                        py4Var4.t = threadData;
                        py4Var4.position = i;
                        py4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(py4Var4);
                        py4 py4Var5 = new py4();
                        py4Var5.g = true;
                        py4Var5.t = threadData;
                        py4Var5.position = i;
                        py4Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(py4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        py4 py4Var6 = new py4();
                        py4Var6.t = threadData;
                        py4Var6.position = i;
                        py4Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        py4Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(py4Var6);
                        if (threadData.getItem() != null) {
                            py4 py4Var7 = new py4();
                            py4Var7.n = true;
                            py4Var7.t = threadData;
                            py4Var7.position = i;
                            py4Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(py4Var7);
                        }
                        py4 py4Var8 = new py4();
                        py4Var8.m = true;
                        py4Var8.t = threadData;
                        py4Var8.position = i;
                        py4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(py4Var8);
                        py4 py4Var9 = new py4();
                        py4Var9.g = true;
                        py4Var9.t = threadData;
                        py4Var9.position = i;
                        py4Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(py4Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (qk6.R(threadData)) {
                        qk6 qk6Var = new qk6(threadData);
                        qk6Var.g = threadData.getTid();
                        qk6Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        qk6Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(qk6Var);
                    } else {
                        py4 py4Var10 = new py4();
                        py4Var10.t = threadData;
                        py4Var10.position = i;
                        py4Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(py4Var10);
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
                yh item = bdTypeRecyclerView.getItem(i3);
                ThreadData threadData = null;
                if (item instanceof py4) {
                    threadData = ((py4) item).getThreadData();
                } else if (item instanceof ThreadData) {
                    threadData = (ThreadData) item;
                } else if (item instanceof qk6) {
                    threadData = ((qk6) item).a;
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

    public static void e(boolean z, ArrayList<yh> arrayList, jv4 jv4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), arrayList, jv4Var}) == null) && jv4Var != null && arrayList != null && (i = jv4Var.floorPosition) >= 0) {
            if (i != 0 || z) {
                int size = arrayList.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    if (arrayList.get(i3) instanceof ThreadData) {
                        if (i == i2) {
                            ListUtils.add(arrayList, i3, jv4Var);
                            return;
                        }
                        i2++;
                    }
                }
            }
        }
    }
}
