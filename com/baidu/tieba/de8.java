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
public class de8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<pi> a(List<ThreadData> list) {
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
                    mz4 mz4Var = new mz4();
                    mz4Var.t = threadData;
                    mz4Var.position = i;
                    mz4Var.r = true;
                    mz4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(mz4Var);
                    mz4 mz4Var2 = new mz4();
                    mz4Var2.t = threadData;
                    mz4Var2.position = i;
                    if (threadData.isBJHNormalThreadType()) {
                        mz4Var2.f = true;
                    } else if (threadData.picCount() == 1) {
                        mz4Var2.d = true;
                        mz4Var2.u = imageWidthAndHeight[0];
                        mz4Var2.v = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        mz4Var2.e = true;
                    } else {
                        mz4Var2.b = true;
                    }
                    mz4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(mz4Var2);
                    d(threadData, arrayList, i);
                    mz4 mz4Var3 = new mz4();
                    mz4Var3.g = true;
                    mz4Var3.t = threadData;
                    mz4Var3.position = i;
                    mz4Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(mz4Var3);
                } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                    threadData.position = i;
                    mz4 mz4Var4 = new mz4();
                    mz4Var4.t = threadData;
                    mz4Var4.position = i;
                    mz4Var4.r = true;
                    mz4Var4.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(mz4Var4);
                    mz4 mz4Var5 = new mz4();
                    mz4Var5.t = threadData;
                    mz4Var5.position = i;
                    mz4Var5.i = true;
                    mz4Var5.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(mz4Var5);
                    d(threadData, arrayList, i);
                    mz4 mz4Var6 = new mz4();
                    mz4Var6.g = true;
                    mz4Var6.t = threadData;
                    mz4Var6.position = i;
                    mz4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(mz4Var6);
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

    public static List<pi> b(List<ThreadInfo> list) {
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

    public static List<pi> c(HotThreadListResIdl hotThreadListResIdl) {
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

    public static void d(ThreadData threadData, ArrayList<pi> arrayList, int i) {
        ThreadRecommendInfoData threadRecommendInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65539, null, threadData, arrayList, i) == null) && threadData != null && arrayList != null && (threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData.getThreadRecommendInfoDataList(), 0)) != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason)) {
            mz4 mz4Var = new mz4();
            mz4Var.s = true;
            mz4Var.t = threadData;
            mz4Var.position = i;
            mz4Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
            arrayList.add(mz4Var);
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
