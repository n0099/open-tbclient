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
public class gg5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<Cdo> a(List<? extends Cdo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (Cdo cdo : list) {
                if (cdo instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) cdo;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        bu4 bu4Var = new bu4();
                        bu4Var.t = threadData;
                        bu4Var.position = i;
                        bu4Var.a = true;
                        bu4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(bu4Var);
                        bu4 bu4Var2 = new bu4();
                        bu4Var2.t = threadData;
                        bu4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            bu4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            bu4Var2.d = true;
                            bu4Var2.u = imageWidthAndHeight[0];
                            bu4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            bu4Var2.e = true;
                        } else {
                            bu4Var2.b = true;
                        }
                        bu4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(bu4Var2);
                        if (threadData.getItem() != null) {
                            bu4 bu4Var3 = new bu4();
                            bu4Var3.n = true;
                            bu4Var3.t = threadData;
                            bu4Var3.position = i;
                            bu4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(bu4Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            bu4 bu4Var4 = new bu4();
                            bu4Var4.t = threadData;
                            bu4Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                bu4Var4.p = true;
                            } else {
                                bu4Var4.q = true;
                            }
                            bu4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(bu4Var4);
                        }
                        bu4 bu4Var5 = new bu4();
                        bu4Var5.m = true;
                        bu4Var5.t = threadData;
                        bu4Var5.position = i;
                        bu4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(bu4Var5);
                        bu4 bu4Var6 = new bu4();
                        bu4Var6.g = true;
                        bu4Var6.t = threadData;
                        bu4Var6.position = i;
                        bu4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(bu4Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        bu4 bu4Var7 = new bu4();
                        bu4Var7.t = threadData;
                        bu4Var7.position = i;
                        bu4Var7.a = true;
                        bu4Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(bu4Var7);
                        bu4 bu4Var8 = new bu4();
                        bu4Var8.t = threadData;
                        bu4Var8.position = i;
                        bu4Var8.i = true;
                        bu4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(bu4Var8);
                        if (threadData.getItem() != null) {
                            bu4 bu4Var9 = new bu4();
                            bu4Var9.n = true;
                            bu4Var9.t = threadData;
                            bu4Var9.position = i;
                            bu4Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(bu4Var9);
                        }
                        bu4 bu4Var10 = new bu4();
                        bu4Var10.m = true;
                        bu4Var10.t = threadData;
                        bu4Var10.position = i;
                        bu4Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(bu4Var10);
                        bu4 bu4Var11 = new bu4();
                        bu4Var11.g = true;
                        bu4Var11.t = threadData;
                        bu4Var11.position = i;
                        bu4Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(bu4Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        bu4 bu4Var12 = new bu4();
                        bu4Var12.t = threadData;
                        bu4Var12.position = i;
                        arrayList.add(bu4Var12);
                    } else if (w26.W(threadData)) {
                        w26 w26Var = new w26(threadData);
                        w26Var.g = threadData.getTid();
                        arrayList.add(w26Var);
                    } else {
                        bu4 bu4Var13 = new bu4();
                        bu4Var13.t = threadData;
                        bu4Var13.position = i;
                        arrayList.add(bu4Var13);
                    }
                } else if (cdo instanceof BaseCardInfo) {
                    ((BaseCardInfo) cdo).position = i;
                    arrayList.add(cdo);
                } else {
                    arrayList.add(cdo);
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void b(List<Cdo> list, yq4 yq4Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, list, yq4Var) == null) || yq4Var == null || list == null || (i = yq4Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    fg5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, yq4Var);
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
