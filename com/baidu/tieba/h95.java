package com.baidu.tieba;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionHelper;
import com.baidu.tbadk.data.LiveRemindRecommendData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class h95 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static int b;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, int i) {
        InterceptResult invokeLI;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, str, i)) == null) {
            if (i == 1) {
                str2 = "index";
            } else if (i == 2) {
                str2 = "pb_live";
            } else if (i == 3) {
                int i2 = a;
                if (i2 == 1) {
                    str2 = "video_bar_live";
                } else {
                    if (i2 == 2) {
                        str2 = "video_immer_live";
                    }
                    str2 = "";
                }
            } else {
                if (i == 4) {
                    str2 = YYLiveUtil.SOURCE_PB_DATU_EOF;
                }
                str2 = "";
            }
            return str + "?source=" + str2;
        }
        return (String) invokeLI.objValue;
    }

    public static String b(LiveRemindRecommendData liveRemindRecommendData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, liveRemindRecommendData)) == null) {
            if (liveRemindRecommendData != null && !StringUtils.isNull(liveRemindRecommendData.getLiveIconScheme())) {
                b = liveRemindRecommendData.getShowPage();
                String liveIconScheme = liveRemindRecommendData.getLiveIconScheme();
                if (liveRemindRecommendData.getShowPage() == 3) {
                    String c = c();
                    if (liveIconScheme.contains("closeLink")) {
                        return SchemeActionHelper.replaceUrlParameter(liveIconScheme.replace("VIDEOICONBACK", c + "_back"), "source", c);
                    }
                    return SchemeActionHelper.replaceUrlParameter(liveIconScheme, "source", c);
                }
                return liveIconScheme;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            int i = a;
            if (i == 1) {
                return YYLiveUtil.SOURCE_HOMEPAGE_VIDEO_CHANNEL;
            }
            if (i == 2) {
                return YYLiveUtil.SOURCE_HOMEPAGE_VIDEO_MIDDLE;
            }
            int i2 = b;
            if (i2 == 1) {
                return "index_gz";
            }
            if (i2 == 2) {
                return AddFriendActivityConfig.TYPE_PB_HEAD;
            }
            return YYLiveUtil.SOURCE_NOT_DEFINE;
        }
        return (String) invokeV.objValue;
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            new StatisticItem(TbadkCoreStatisticKey.KEY_HOME_LIVE_ICON_CLICK).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("obj_type", 1).eventStat();
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            new StatisticItem(TbadkCoreStatisticKey.KEY_HOME_LIVE_ICON_SHOW).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("obj_type", 1).eventStat();
        }
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return "";
            }
            String queryParameter = parse.getQueryParameter("source");
            if (StringUtils.isNull(queryParameter)) {
                return "";
            }
            return queryParameter;
        }
        return (String) invokeL.objValue;
    }

    public static void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, null, i) == null) {
            a = i;
        }
    }
}
