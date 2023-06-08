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
public class gv5 {
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
                        n45 n45Var = new n45();
                        n45Var.t = threadData;
                        n45Var.position = i;
                        n45Var.a = true;
                        n45Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(n45Var);
                        n45 n45Var2 = new n45();
                        n45Var2.t = threadData;
                        n45Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            n45Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            n45Var2.d = true;
                            n45Var2.u = imageWidthAndHeight[0];
                            n45Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            n45Var2.e = true;
                        } else {
                            n45Var2.b = true;
                        }
                        n45Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(n45Var2);
                        if (threadData.getItem() != null) {
                            n45 n45Var3 = new n45();
                            n45Var3.n = true;
                            n45Var3.t = threadData;
                            n45Var3.position = i;
                            n45Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(n45Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            n45 n45Var4 = new n45();
                            n45Var4.t = threadData;
                            n45Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                n45Var4.p = true;
                            } else {
                                n45Var4.q = true;
                            }
                            n45Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(n45Var4);
                        }
                        n45 n45Var5 = new n45();
                        n45Var5.m = true;
                        n45Var5.t = threadData;
                        n45Var5.position = i;
                        n45Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(n45Var5);
                        n45 n45Var6 = new n45();
                        n45Var6.g = true;
                        n45Var6.t = threadData;
                        n45Var6.position = i;
                        n45Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(n45Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        n45 n45Var7 = new n45();
                        n45Var7.t = threadData;
                        n45Var7.position = i;
                        n45Var7.a = true;
                        n45Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(n45Var7);
                        n45 n45Var8 = new n45();
                        n45Var8.t = threadData;
                        n45Var8.position = i;
                        n45Var8.i = true;
                        n45Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(n45Var8);
                        if (threadData.getItem() != null) {
                            n45 n45Var9 = new n45();
                            n45Var9.n = true;
                            n45Var9.t = threadData;
                            n45Var9.position = i;
                            n45Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(n45Var9);
                        }
                        n45 n45Var10 = new n45();
                        n45Var10.m = true;
                        n45Var10.t = threadData;
                        n45Var10.position = i;
                        n45Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(n45Var10);
                        n45 n45Var11 = new n45();
                        n45Var11.g = true;
                        n45Var11.t = threadData;
                        n45Var11.position = i;
                        n45Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(n45Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        n45 n45Var12 = new n45();
                        n45Var12.t = threadData;
                        n45Var12.position = i;
                        arrayList.add(n45Var12);
                    } else if (vo6.X(threadData)) {
                        vo6 vo6Var = new vo6(threadData);
                        vo6Var.g = threadData.getTid();
                        arrayList.add(vo6Var);
                    } else {
                        n45 n45Var13 = new n45();
                        n45Var13.t = threadData;
                        n45Var13.position = i;
                        arrayList.add(n45Var13);
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

    public static void b(List<vn> list, h15 h15Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, list, h15Var) != null) || h15Var == null || list == null || (i = h15Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    fv5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, h15Var);
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
