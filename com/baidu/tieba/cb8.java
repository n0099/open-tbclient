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
public class cb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<oi> a(List<ThreadData> list) {
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
                    hz4 hz4Var = new hz4();
                    hz4Var.t = threadData;
                    hz4Var.position = i;
                    hz4Var.r = true;
                    hz4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(hz4Var);
                    hz4 hz4Var2 = new hz4();
                    hz4Var2.t = threadData;
                    hz4Var2.position = i;
                    if (threadData.isBJHNormalThreadType()) {
                        hz4Var2.f = true;
                    } else if (threadData.picCount() == 1) {
                        hz4Var2.d = true;
                        hz4Var2.u = imageWidthAndHeight[0];
                        hz4Var2.v = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        hz4Var2.e = true;
                    } else {
                        hz4Var2.b = true;
                    }
                    hz4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(hz4Var2);
                    d(threadData, arrayList, i);
                    hz4 hz4Var3 = new hz4();
                    hz4Var3.g = true;
                    hz4Var3.t = threadData;
                    hz4Var3.position = i;
                    hz4Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(hz4Var3);
                } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                    threadData.position = i;
                    hz4 hz4Var4 = new hz4();
                    hz4Var4.t = threadData;
                    hz4Var4.position = i;
                    hz4Var4.r = true;
                    hz4Var4.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(hz4Var4);
                    hz4 hz4Var5 = new hz4();
                    hz4Var5.t = threadData;
                    hz4Var5.position = i;
                    hz4Var5.i = true;
                    hz4Var5.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(hz4Var5);
                    d(threadData, arrayList, i);
                    hz4 hz4Var6 = new hz4();
                    hz4Var6.g = true;
                    hz4Var6.t = threadData;
                    hz4Var6.position = i;
                    hz4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(hz4Var6);
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

    public static List<oi> b(List<ThreadInfo> list) {
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

    public static List<oi> c(HotThreadListResIdl hotThreadListResIdl) {
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

    public static void d(ThreadData threadData, ArrayList<oi> arrayList, int i) {
        ThreadRecommendInfoData threadRecommendInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65539, null, threadData, arrayList, i) == null) && threadData != null && arrayList != null && (threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData.getThreadRecommendInfoDataList(), 0)) != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason)) {
            hz4 hz4Var = new hz4();
            hz4Var.s = true;
            hz4Var.t = threadData;
            hz4Var.position = i;
            hz4Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
            arrayList.add(hz4Var);
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
