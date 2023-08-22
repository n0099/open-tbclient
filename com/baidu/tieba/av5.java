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
public class av5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<bn> a(List<? extends bn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (bn bnVar : list) {
                if (bnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) bnVar;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        c45 c45Var = new c45();
                        c45Var.t = threadData;
                        c45Var.position = i;
                        c45Var.a = true;
                        c45Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(c45Var);
                        c45 c45Var2 = new c45();
                        c45Var2.t = threadData;
                        c45Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            c45Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            c45Var2.d = true;
                            c45Var2.u = imageWidthAndHeight[0];
                            c45Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            c45Var2.e = true;
                        } else {
                            c45Var2.b = true;
                        }
                        c45Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(c45Var2);
                        if (threadData.getItem() != null) {
                            c45 c45Var3 = new c45();
                            c45Var3.n = true;
                            c45Var3.t = threadData;
                            c45Var3.position = i;
                            c45Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(c45Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            c45 c45Var4 = new c45();
                            c45Var4.t = threadData;
                            c45Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                c45Var4.p = true;
                            } else {
                                c45Var4.q = true;
                            }
                            c45Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(c45Var4);
                        }
                        c45 c45Var5 = new c45();
                        c45Var5.m = true;
                        c45Var5.t = threadData;
                        c45Var5.position = i;
                        c45Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(c45Var5);
                        c45 c45Var6 = new c45();
                        c45Var6.g = true;
                        c45Var6.t = threadData;
                        c45Var6.position = i;
                        c45Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(c45Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        c45 c45Var7 = new c45();
                        c45Var7.t = threadData;
                        c45Var7.position = i;
                        c45Var7.a = true;
                        c45Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(c45Var7);
                        c45 c45Var8 = new c45();
                        c45Var8.t = threadData;
                        c45Var8.position = i;
                        c45Var8.i = true;
                        c45Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(c45Var8);
                        if (threadData.getItem() != null) {
                            c45 c45Var9 = new c45();
                            c45Var9.n = true;
                            c45Var9.t = threadData;
                            c45Var9.position = i;
                            c45Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(c45Var9);
                        }
                        c45 c45Var10 = new c45();
                        c45Var10.m = true;
                        c45Var10.t = threadData;
                        c45Var10.position = i;
                        c45Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(c45Var10);
                        c45 c45Var11 = new c45();
                        c45Var11.g = true;
                        c45Var11.t = threadData;
                        c45Var11.position = i;
                        c45Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(c45Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        c45 c45Var12 = new c45();
                        c45Var12.t = threadData;
                        c45Var12.position = i;
                        arrayList.add(c45Var12);
                    } else if (yo6.R(threadData)) {
                        yo6 yo6Var = new yo6(threadData);
                        yo6Var.g = threadData.getTid();
                        arrayList.add(yo6Var);
                    } else {
                        c45 c45Var13 = new c45();
                        c45Var13.t = threadData;
                        c45Var13.position = i;
                        arrayList.add(c45Var13);
                    }
                } else if (bnVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) bnVar).position = i;
                    arrayList.add(bnVar);
                } else {
                    arrayList.add(bnVar);
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void b(List<bn> list, w05 w05Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, list, w05Var) != null) || w05Var == null || list == null || (i = w05Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    zu5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, w05Var);
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
