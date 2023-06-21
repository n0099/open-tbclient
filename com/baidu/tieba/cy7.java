package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import tbclient.HotThreadList.DataRes;
import tbclient.HotThreadList.HotThreadListResIdl;
import tbclient.ThreadInfo;
/* loaded from: classes5.dex */
public class cy7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<wn> a(List<ThreadData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (ThreadData threadData : list) {
                int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                    threadData.position = i;
                    o45 o45Var = new o45();
                    o45Var.t = threadData;
                    o45Var.position = i;
                    o45Var.r = true;
                    o45Var.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(o45Var);
                    o45 o45Var2 = new o45();
                    o45Var2.t = threadData;
                    o45Var2.position = i;
                    if (threadData.isBJHNormalThreadType()) {
                        o45Var2.f = true;
                    } else if (threadData.picCount() == 1) {
                        o45Var2.d = true;
                        o45Var2.u = imageWidthAndHeight[0];
                        o45Var2.v = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        o45Var2.e = true;
                    } else {
                        o45Var2.b = true;
                    }
                    o45Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(o45Var2);
                    d(threadData, arrayList, i);
                    o45 o45Var3 = new o45();
                    o45Var3.g = true;
                    o45Var3.t = threadData;
                    o45Var3.position = i;
                    o45Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(o45Var3);
                } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                    threadData.position = i;
                    o45 o45Var4 = new o45();
                    o45Var4.t = threadData;
                    o45Var4.position = i;
                    o45Var4.r = true;
                    o45Var4.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(o45Var4);
                    o45 o45Var5 = new o45();
                    o45Var5.t = threadData;
                    o45Var5.position = i;
                    o45Var5.i = true;
                    o45Var5.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(o45Var5);
                    d(threadData, arrayList, i);
                    o45 o45Var6 = new o45();
                    o45Var6.g = true;
                    o45Var6.t = threadData;
                    o45Var6.position = i;
                    o45Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(o45Var6);
                } else {
                    threadData.setSupportType(BaseCardInfo.SupportType.TOP);
                }
                i++;
                threadData.setSupportType(BaseCardInfo.SupportType.TOP);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<wn> b(List<ThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (ThreadInfo threadInfo : list) {
                ThreadData threadData = new ThreadData();
                threadData.isFromHotRankTab = true;
                threadData.parserProtobuf(threadInfo);
                e(threadData);
                arrayList.add(threadData);
            }
            return a(arrayList);
        }
        return (List) invokeL.objValue;
    }

    public static List<wn> c(HotThreadListResIdl hotThreadListResIdl) {
        InterceptResult invokeL;
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, hotThreadListResIdl)) == null) {
            if (hotThreadListResIdl != null && (dataRes = hotThreadListResIdl.data) != null && !ListUtils.isEmpty(dataRes.thread_info)) {
                return b(hotThreadListResIdl.data.thread_info);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static void d(ThreadData threadData, ArrayList<wn> arrayList, int i) {
        ThreadRecommendInfoData threadRecommendInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65539, null, threadData, arrayList, i) == null) && threadData != null && arrayList != null && (threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData.getThreadRecommendInfoDataList(), 0)) != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason)) {
            o45 o45Var = new o45();
            o45Var.s = true;
            o45Var.t = threadData;
            o45Var.position = i;
            o45Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
            arrayList.add(o45Var);
        }
    }

    public static void e(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, threadData) == null) {
            String lengthLimitName = threadData.getLengthLimitName();
            String formatTimeForHomeC = StringHelper.getFormatTimeForHomeC(threadData.getLast_time_int() * 1000);
            if (!TextUtils.isEmpty(lengthLimitName) && !TextUtils.isEmpty(formatTimeForHomeC)) {
                lengthLimitName = lengthLimitName + "   " + formatTimeForHomeC;
            }
            threadData.setThreadExtendInfo(lengthLimitName);
        }
    }
}
