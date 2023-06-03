package com.baidu.tieba;

import android.util.Log;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes5.dex */
public class ev5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<vn> a(List<? extends vn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (vn vnVar : list) {
                if (vnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) vnVar;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        l45 l45Var = new l45();
                        l45Var.t = threadData;
                        l45Var.position = i;
                        l45Var.a = true;
                        l45Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(l45Var);
                        l45 l45Var2 = new l45();
                        l45Var2.t = threadData;
                        l45Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            l45Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            l45Var2.d = true;
                            l45Var2.u = imageWidthAndHeight[0];
                            l45Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            l45Var2.e = true;
                        } else {
                            l45Var2.b = true;
                        }
                        l45Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(l45Var2);
                        if (threadData.getItem() != null) {
                            l45 l45Var3 = new l45();
                            l45Var3.n = true;
                            l45Var3.t = threadData;
                            l45Var3.position = i;
                            l45Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(l45Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            l45 l45Var4 = new l45();
                            l45Var4.t = threadData;
                            l45Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                l45Var4.p = true;
                            } else {
                                l45Var4.q = true;
                            }
                            l45Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(l45Var4);
                        }
                        l45 l45Var5 = new l45();
                        l45Var5.m = true;
                        l45Var5.t = threadData;
                        l45Var5.position = i;
                        l45Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(l45Var5);
                        l45 l45Var6 = new l45();
                        l45Var6.g = true;
                        l45Var6.t = threadData;
                        l45Var6.position = i;
                        l45Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(l45Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        l45 l45Var7 = new l45();
                        l45Var7.t = threadData;
                        l45Var7.position = i;
                        l45Var7.a = true;
                        l45Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(l45Var7);
                        l45 l45Var8 = new l45();
                        l45Var8.t = threadData;
                        l45Var8.position = i;
                        l45Var8.i = true;
                        l45Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(l45Var8);
                        if (threadData.getItem() != null) {
                            l45 l45Var9 = new l45();
                            l45Var9.n = true;
                            l45Var9.t = threadData;
                            l45Var9.position = i;
                            l45Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(l45Var9);
                        }
                        l45 l45Var10 = new l45();
                        l45Var10.m = true;
                        l45Var10.t = threadData;
                        l45Var10.position = i;
                        l45Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(l45Var10);
                        l45 l45Var11 = new l45();
                        l45Var11.g = true;
                        l45Var11.t = threadData;
                        l45Var11.position = i;
                        l45Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(l45Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        l45 l45Var12 = new l45();
                        l45Var12.t = threadData;
                        l45Var12.position = i;
                        arrayList.add(l45Var12);
                    } else if (to6.X(threadData)) {
                        to6 to6Var = new to6(threadData);
                        to6Var.g = threadData.getTid();
                        arrayList.add(to6Var);
                    } else {
                        l45 l45Var13 = new l45();
                        l45Var13.t = threadData;
                        l45Var13.position = i;
                        arrayList.add(l45Var13);
                    }
                } else if (vnVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) vnVar).position = i;
                    arrayList.add(vnVar);
                } else {
                    arrayList.add(vnVar);
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void b(List<vn> list, f15 f15Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, list, f15Var) != null) || f15Var == null || list == null || (i = f15Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    dv5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, f15Var);
                    return;
                }
                i2++;
            }
        }
    }

    public static List<ThreadData> c(List<ThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (ThreadInfo threadInfo : list) {
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf(threadInfo);
                threadData.insertItemToTitleOrAbstractText();
                arrayList.add(threadData);
            }
            Log.i("Template", "parserThreadList-> size = " + arrayList.size());
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
