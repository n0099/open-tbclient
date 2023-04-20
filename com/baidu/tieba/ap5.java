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
/* loaded from: classes3.dex */
public class ap5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<in> a(List<? extends in> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (in inVar : list) {
                if (inVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) inVar;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        pz4 pz4Var = new pz4();
                        pz4Var.t = threadData;
                        pz4Var.position = i;
                        pz4Var.a = true;
                        pz4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(pz4Var);
                        pz4 pz4Var2 = new pz4();
                        pz4Var2.t = threadData;
                        pz4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            pz4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            pz4Var2.d = true;
                            pz4Var2.u = imageWidthAndHeight[0];
                            pz4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            pz4Var2.e = true;
                        } else {
                            pz4Var2.b = true;
                        }
                        pz4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(pz4Var2);
                        if (threadData.getItem() != null) {
                            pz4 pz4Var3 = new pz4();
                            pz4Var3.n = true;
                            pz4Var3.t = threadData;
                            pz4Var3.position = i;
                            pz4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(pz4Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            pz4 pz4Var4 = new pz4();
                            pz4Var4.t = threadData;
                            pz4Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                pz4Var4.p = true;
                            } else {
                                pz4Var4.q = true;
                            }
                            pz4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(pz4Var4);
                        }
                        pz4 pz4Var5 = new pz4();
                        pz4Var5.m = true;
                        pz4Var5.t = threadData;
                        pz4Var5.position = i;
                        pz4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(pz4Var5);
                        pz4 pz4Var6 = new pz4();
                        pz4Var6.g = true;
                        pz4Var6.t = threadData;
                        pz4Var6.position = i;
                        pz4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(pz4Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        pz4 pz4Var7 = new pz4();
                        pz4Var7.t = threadData;
                        pz4Var7.position = i;
                        pz4Var7.a = true;
                        pz4Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(pz4Var7);
                        pz4 pz4Var8 = new pz4();
                        pz4Var8.t = threadData;
                        pz4Var8.position = i;
                        pz4Var8.i = true;
                        pz4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(pz4Var8);
                        if (threadData.getItem() != null) {
                            pz4 pz4Var9 = new pz4();
                            pz4Var9.n = true;
                            pz4Var9.t = threadData;
                            pz4Var9.position = i;
                            pz4Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(pz4Var9);
                        }
                        pz4 pz4Var10 = new pz4();
                        pz4Var10.m = true;
                        pz4Var10.t = threadData;
                        pz4Var10.position = i;
                        pz4Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(pz4Var10);
                        pz4 pz4Var11 = new pz4();
                        pz4Var11.g = true;
                        pz4Var11.t = threadData;
                        pz4Var11.position = i;
                        pz4Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(pz4Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        pz4 pz4Var12 = new pz4();
                        pz4Var12.t = threadData;
                        pz4Var12.position = i;
                        arrayList.add(pz4Var12);
                    } else if (mh6.W(threadData)) {
                        mh6 mh6Var = new mh6(threadData);
                        mh6Var.g = threadData.getTid();
                        arrayList.add(mh6Var);
                    } else {
                        pz4 pz4Var13 = new pz4();
                        pz4Var13.t = threadData;
                        pz4Var13.position = i;
                        arrayList.add(pz4Var13);
                    }
                } else if (inVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) inVar).position = i;
                    arrayList.add(inVar);
                } else {
                    arrayList.add(inVar);
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void b(List<in> list, kw4 kw4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, list, kw4Var) != null) || kw4Var == null || list == null || (i = kw4Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    zo5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, kw4Var);
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
