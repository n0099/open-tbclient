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
public class es5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<pi> a(List<? extends pi> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (pi piVar : list) {
                if (piVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) piVar;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        jz4 jz4Var = new jz4();
                        jz4Var.t = threadData;
                        jz4Var.position = i;
                        jz4Var.a = true;
                        jz4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(jz4Var);
                        jz4 jz4Var2 = new jz4();
                        jz4Var2.t = threadData;
                        jz4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            jz4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            jz4Var2.d = true;
                            jz4Var2.u = imageWidthAndHeight[0];
                            jz4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            jz4Var2.e = true;
                        } else {
                            jz4Var2.b = true;
                        }
                        jz4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(jz4Var2);
                        if (threadData.getItem() != null) {
                            jz4 jz4Var3 = new jz4();
                            jz4Var3.n = true;
                            jz4Var3.t = threadData;
                            jz4Var3.position = i;
                            jz4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(jz4Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            jz4 jz4Var4 = new jz4();
                            jz4Var4.t = threadData;
                            jz4Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                jz4Var4.p = true;
                            } else {
                                jz4Var4.q = true;
                            }
                            jz4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(jz4Var4);
                        }
                        jz4 jz4Var5 = new jz4();
                        jz4Var5.m = true;
                        jz4Var5.t = threadData;
                        jz4Var5.position = i;
                        jz4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(jz4Var5);
                        jz4 jz4Var6 = new jz4();
                        jz4Var6.g = true;
                        jz4Var6.t = threadData;
                        jz4Var6.position = i;
                        jz4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(jz4Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        jz4 jz4Var7 = new jz4();
                        jz4Var7.t = threadData;
                        jz4Var7.position = i;
                        jz4Var7.a = true;
                        jz4Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(jz4Var7);
                        jz4 jz4Var8 = new jz4();
                        jz4Var8.t = threadData;
                        jz4Var8.position = i;
                        jz4Var8.i = true;
                        jz4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(jz4Var8);
                        if (threadData.getItem() != null) {
                            jz4 jz4Var9 = new jz4();
                            jz4Var9.n = true;
                            jz4Var9.t = threadData;
                            jz4Var9.position = i;
                            jz4Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(jz4Var9);
                        }
                        jz4 jz4Var10 = new jz4();
                        jz4Var10.m = true;
                        jz4Var10.t = threadData;
                        jz4Var10.position = i;
                        jz4Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(jz4Var10);
                        jz4 jz4Var11 = new jz4();
                        jz4Var11.g = true;
                        jz4Var11.t = threadData;
                        jz4Var11.position = i;
                        jz4Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(jz4Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        jz4 jz4Var12 = new jz4();
                        jz4Var12.t = threadData;
                        jz4Var12.position = i;
                        arrayList.add(jz4Var12);
                    } else if (ym6.R(threadData)) {
                        ym6 ym6Var = new ym6(threadData);
                        ym6Var.g = threadData.getTid();
                        arrayList.add(ym6Var);
                    } else {
                        jz4 jz4Var13 = new jz4();
                        jz4Var13.t = threadData;
                        jz4Var13.position = i;
                        arrayList.add(jz4Var13);
                    }
                } else if (piVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) piVar).position = i;
                    arrayList.add(piVar);
                } else {
                    arrayList.add(piVar);
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void b(List<pi> list, cw4 cw4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, list, cw4Var) != null) || cw4Var == null || list == null || (i = cw4Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    ds5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, cw4Var);
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
