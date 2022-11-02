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
/* loaded from: classes4.dex */
public class ih5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<wn> a(List<? extends wn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (wn wnVar : list) {
                if (wnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) wnVar;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        vu4 vu4Var = new vu4();
                        vu4Var.t = threadData;
                        vu4Var.position = i;
                        vu4Var.a = true;
                        vu4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(vu4Var);
                        vu4 vu4Var2 = new vu4();
                        vu4Var2.t = threadData;
                        vu4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            vu4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            vu4Var2.d = true;
                            vu4Var2.u = imageWidthAndHeight[0];
                            vu4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            vu4Var2.e = true;
                        } else {
                            vu4Var2.b = true;
                        }
                        vu4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(vu4Var2);
                        if (threadData.getItem() != null) {
                            vu4 vu4Var3 = new vu4();
                            vu4Var3.n = true;
                            vu4Var3.t = threadData;
                            vu4Var3.position = i;
                            vu4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(vu4Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            vu4 vu4Var4 = new vu4();
                            vu4Var4.t = threadData;
                            vu4Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                vu4Var4.p = true;
                            } else {
                                vu4Var4.q = true;
                            }
                            vu4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(vu4Var4);
                        }
                        vu4 vu4Var5 = new vu4();
                        vu4Var5.m = true;
                        vu4Var5.t = threadData;
                        vu4Var5.position = i;
                        vu4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(vu4Var5);
                        vu4 vu4Var6 = new vu4();
                        vu4Var6.g = true;
                        vu4Var6.t = threadData;
                        vu4Var6.position = i;
                        vu4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(vu4Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        vu4 vu4Var7 = new vu4();
                        vu4Var7.t = threadData;
                        vu4Var7.position = i;
                        vu4Var7.a = true;
                        vu4Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(vu4Var7);
                        vu4 vu4Var8 = new vu4();
                        vu4Var8.t = threadData;
                        vu4Var8.position = i;
                        vu4Var8.i = true;
                        vu4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(vu4Var8);
                        if (threadData.getItem() != null) {
                            vu4 vu4Var9 = new vu4();
                            vu4Var9.n = true;
                            vu4Var9.t = threadData;
                            vu4Var9.position = i;
                            vu4Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(vu4Var9);
                        }
                        vu4 vu4Var10 = new vu4();
                        vu4Var10.m = true;
                        vu4Var10.t = threadData;
                        vu4Var10.position = i;
                        vu4Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(vu4Var10);
                        vu4 vu4Var11 = new vu4();
                        vu4Var11.g = true;
                        vu4Var11.t = threadData;
                        vu4Var11.position = i;
                        vu4Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(vu4Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        vu4 vu4Var12 = new vu4();
                        vu4Var12.t = threadData;
                        vu4Var12.position = i;
                        arrayList.add(vu4Var12);
                    } else if (n46.W(threadData)) {
                        n46 n46Var = new n46(threadData);
                        n46Var.g = threadData.getTid();
                        arrayList.add(n46Var);
                    } else {
                        vu4 vu4Var13 = new vu4();
                        vu4Var13.t = threadData;
                        vu4Var13.position = i;
                        arrayList.add(vu4Var13);
                    }
                } else if (wnVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) wnVar).position = i;
                    arrayList.add(wnVar);
                } else {
                    arrayList.add(wnVar);
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void b(List<wn> list, rr4 rr4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, list, rr4Var) != null) || rr4Var == null || list == null || (i = rr4Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    hh5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, rr4Var);
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
