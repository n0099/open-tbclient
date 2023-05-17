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
public class cr5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<rn> a(List<? extends rn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (rn rnVar : list) {
                if (rnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) rnVar;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        o15 o15Var = new o15();
                        o15Var.t = threadData;
                        o15Var.position = i;
                        o15Var.a = true;
                        o15Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(o15Var);
                        o15 o15Var2 = new o15();
                        o15Var2.t = threadData;
                        o15Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            o15Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            o15Var2.d = true;
                            o15Var2.u = imageWidthAndHeight[0];
                            o15Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            o15Var2.e = true;
                        } else {
                            o15Var2.b = true;
                        }
                        o15Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(o15Var2);
                        if (threadData.getItem() != null) {
                            o15 o15Var3 = new o15();
                            o15Var3.n = true;
                            o15Var3.t = threadData;
                            o15Var3.position = i;
                            o15Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(o15Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            o15 o15Var4 = new o15();
                            o15Var4.t = threadData;
                            o15Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                o15Var4.p = true;
                            } else {
                                o15Var4.q = true;
                            }
                            o15Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(o15Var4);
                        }
                        o15 o15Var5 = new o15();
                        o15Var5.m = true;
                        o15Var5.t = threadData;
                        o15Var5.position = i;
                        o15Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(o15Var5);
                        o15 o15Var6 = new o15();
                        o15Var6.g = true;
                        o15Var6.t = threadData;
                        o15Var6.position = i;
                        o15Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(o15Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        o15 o15Var7 = new o15();
                        o15Var7.t = threadData;
                        o15Var7.position = i;
                        o15Var7.a = true;
                        o15Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(o15Var7);
                        o15 o15Var8 = new o15();
                        o15Var8.t = threadData;
                        o15Var8.position = i;
                        o15Var8.i = true;
                        o15Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(o15Var8);
                        if (threadData.getItem() != null) {
                            o15 o15Var9 = new o15();
                            o15Var9.n = true;
                            o15Var9.t = threadData;
                            o15Var9.position = i;
                            o15Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(o15Var9);
                        }
                        o15 o15Var10 = new o15();
                        o15Var10.m = true;
                        o15Var10.t = threadData;
                        o15Var10.position = i;
                        o15Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(o15Var10);
                        o15 o15Var11 = new o15();
                        o15Var11.g = true;
                        o15Var11.t = threadData;
                        o15Var11.position = i;
                        o15Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(o15Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        o15 o15Var12 = new o15();
                        o15Var12.t = threadData;
                        o15Var12.position = i;
                        arrayList.add(o15Var12);
                    } else if (jk6.W(threadData)) {
                        jk6 jk6Var = new jk6(threadData);
                        jk6Var.g = threadData.getTid();
                        arrayList.add(jk6Var);
                    } else {
                        o15 o15Var13 = new o15();
                        o15Var13.t = threadData;
                        o15Var13.position = i;
                        arrayList.add(o15Var13);
                    }
                } else if (rnVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) rnVar).position = i;
                    arrayList.add(rnVar);
                } else {
                    arrayList.add(rnVar);
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void b(List<rn> list, jy4 jy4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, list, jy4Var) != null) || jy4Var == null || list == null || (i = jy4Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    br5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, jy4Var);
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
