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
public class bq5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<yh> a(List<? extends yh> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (yh yhVar : list) {
                if (yhVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) yhVar;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        py4 py4Var = new py4();
                        py4Var.t = threadData;
                        py4Var.position = i;
                        py4Var.a = true;
                        py4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(py4Var);
                        py4 py4Var2 = new py4();
                        py4Var2.t = threadData;
                        py4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            py4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            py4Var2.d = true;
                            py4Var2.u = imageWidthAndHeight[0];
                            py4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            py4Var2.e = true;
                        } else {
                            py4Var2.b = true;
                        }
                        py4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(py4Var2);
                        if (threadData.getItem() != null) {
                            py4 py4Var3 = new py4();
                            py4Var3.n = true;
                            py4Var3.t = threadData;
                            py4Var3.position = i;
                            py4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(py4Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            py4 py4Var4 = new py4();
                            py4Var4.t = threadData;
                            py4Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                py4Var4.p = true;
                            } else {
                                py4Var4.q = true;
                            }
                            py4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(py4Var4);
                        }
                        py4 py4Var5 = new py4();
                        py4Var5.m = true;
                        py4Var5.t = threadData;
                        py4Var5.position = i;
                        py4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(py4Var5);
                        py4 py4Var6 = new py4();
                        py4Var6.g = true;
                        py4Var6.t = threadData;
                        py4Var6.position = i;
                        py4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(py4Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        py4 py4Var7 = new py4();
                        py4Var7.t = threadData;
                        py4Var7.position = i;
                        py4Var7.a = true;
                        py4Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(py4Var7);
                        py4 py4Var8 = new py4();
                        py4Var8.t = threadData;
                        py4Var8.position = i;
                        py4Var8.i = true;
                        py4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(py4Var8);
                        if (threadData.getItem() != null) {
                            py4 py4Var9 = new py4();
                            py4Var9.n = true;
                            py4Var9.t = threadData;
                            py4Var9.position = i;
                            py4Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(py4Var9);
                        }
                        py4 py4Var10 = new py4();
                        py4Var10.m = true;
                        py4Var10.t = threadData;
                        py4Var10.position = i;
                        py4Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(py4Var10);
                        py4 py4Var11 = new py4();
                        py4Var11.g = true;
                        py4Var11.t = threadData;
                        py4Var11.position = i;
                        py4Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(py4Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        py4 py4Var12 = new py4();
                        py4Var12.t = threadData;
                        py4Var12.position = i;
                        arrayList.add(py4Var12);
                    } else if (qk6.R(threadData)) {
                        qk6 qk6Var = new qk6(threadData);
                        qk6Var.g = threadData.getTid();
                        arrayList.add(qk6Var);
                    } else {
                        py4 py4Var13 = new py4();
                        py4Var13.t = threadData;
                        py4Var13.position = i;
                        arrayList.add(py4Var13);
                    }
                } else if (yhVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) yhVar).position = i;
                    arrayList.add(yhVar);
                } else {
                    arrayList.add(yhVar);
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void b(List<yh> list, jv4 jv4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, list, jv4Var) != null) || jv4Var == null || list == null || (i = jv4Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    aq5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, jv4Var);
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
