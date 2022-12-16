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
public class ii5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<xn> a(List<? extends xn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (xn xnVar : list) {
                if (xnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) xnVar;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        yu4 yu4Var = new yu4();
                        yu4Var.t = threadData;
                        yu4Var.position = i;
                        yu4Var.a = true;
                        yu4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(yu4Var);
                        yu4 yu4Var2 = new yu4();
                        yu4Var2.t = threadData;
                        yu4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            yu4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            yu4Var2.d = true;
                            yu4Var2.u = imageWidthAndHeight[0];
                            yu4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            yu4Var2.e = true;
                        } else {
                            yu4Var2.b = true;
                        }
                        yu4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(yu4Var2);
                        if (threadData.getItem() != null) {
                            yu4 yu4Var3 = new yu4();
                            yu4Var3.n = true;
                            yu4Var3.t = threadData;
                            yu4Var3.position = i;
                            yu4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(yu4Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            yu4 yu4Var4 = new yu4();
                            yu4Var4.t = threadData;
                            yu4Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                yu4Var4.p = true;
                            } else {
                                yu4Var4.q = true;
                            }
                            yu4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(yu4Var4);
                        }
                        yu4 yu4Var5 = new yu4();
                        yu4Var5.m = true;
                        yu4Var5.t = threadData;
                        yu4Var5.position = i;
                        yu4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(yu4Var5);
                        yu4 yu4Var6 = new yu4();
                        yu4Var6.g = true;
                        yu4Var6.t = threadData;
                        yu4Var6.position = i;
                        yu4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(yu4Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        yu4 yu4Var7 = new yu4();
                        yu4Var7.t = threadData;
                        yu4Var7.position = i;
                        yu4Var7.a = true;
                        yu4Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(yu4Var7);
                        yu4 yu4Var8 = new yu4();
                        yu4Var8.t = threadData;
                        yu4Var8.position = i;
                        yu4Var8.i = true;
                        yu4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(yu4Var8);
                        if (threadData.getItem() != null) {
                            yu4 yu4Var9 = new yu4();
                            yu4Var9.n = true;
                            yu4Var9.t = threadData;
                            yu4Var9.position = i;
                            yu4Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(yu4Var9);
                        }
                        yu4 yu4Var10 = new yu4();
                        yu4Var10.m = true;
                        yu4Var10.t = threadData;
                        yu4Var10.position = i;
                        yu4Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(yu4Var10);
                        yu4 yu4Var11 = new yu4();
                        yu4Var11.g = true;
                        yu4Var11.t = threadData;
                        yu4Var11.position = i;
                        yu4Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(yu4Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        yu4 yu4Var12 = new yu4();
                        yu4Var12.t = threadData;
                        yu4Var12.position = i;
                        arrayList.add(yu4Var12);
                    } else if (v56.W(threadData)) {
                        v56 v56Var = new v56(threadData);
                        v56Var.g = threadData.getTid();
                        arrayList.add(v56Var);
                    } else {
                        yu4 yu4Var13 = new yu4();
                        yu4Var13.t = threadData;
                        yu4Var13.position = i;
                        arrayList.add(yu4Var13);
                    }
                } else if (xnVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) xnVar).position = i;
                    arrayList.add(xnVar);
                } else {
                    arrayList.add(xnVar);
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void b(List<xn> list, vr4 vr4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, list, vr4Var) != null) || vr4Var == null || list == null || (i = vr4Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    hi5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, vr4Var);
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
