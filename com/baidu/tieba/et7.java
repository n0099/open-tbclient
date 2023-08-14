package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tbclient.FrsPage.CoverImageColor;
import tbclient.FrsPage.VideoImageColor;
/* loaded from: classes5.dex */
public class et7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, daa daaVar, ForumData forumData, int i, String str2) {
        StatisticItem i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{str, daaVar, forumData, Integer.valueOf(i), str2}) != null) || (i2 = i(str, daaVar, forumData, i, str2)) == null) {
            return;
        }
        if (daaVar != null && YYLiveUtil.isYYLiveLink(daaVar.p())) {
            i2.param(TiebaStatic.YYParams.YYLIVEID, 1);
        } else {
            i2.param(TiebaStatic.YYParams.YYLIVEID, "");
        }
        i2.param("obj_locate", 3);
        TiebaStatic.log(i2);
        if (daaVar != null) {
            ThirdStatisticHelper.sendReq((String) ListUtils.getItem(daaVar.l(), 1));
        }
    }

    public static void k(String str, daa daaVar, ForumData forumData, int i, String str2) {
        StatisticItem i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65546, null, new Object[]{str, daaVar, forumData, Integer.valueOf(i), str2}) != null) || (i2 = i(str, daaVar, forumData, i, str2)) == null) {
            return;
        }
        if (daaVar != null && YYLiveUtil.isYYLiveLink(daaVar.p())) {
            i2.param(TiebaStatic.YYParams.YYLIVEID, 1);
        } else {
            i2.param(TiebaStatic.YYParams.YYLIVEID, "");
        }
        TiebaStatic.log(i2);
        if (daaVar != null) {
            ThirdStatisticHelper.sendReq((String) ListUtils.getItem(daaVar.l(), 0));
        }
    }

    public static String b(u15 u15Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, u15Var, i)) == null) {
            if (u15Var == null) {
                return null;
            }
            List<VideoImageColor> m = u15Var.m();
            if (ListUtils.isEmpty(m)) {
                return null;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < m.size(); i3++) {
                if (m.get(i3) != null && i * 10 < m.get(i3).time.intValue()) {
                    int i4 = i3 - 1;
                    if (i4 >= 0) {
                        i2 = i4;
                    }
                    if (m.get(i2) == null) {
                        return null;
                    }
                    return m.get(i2).color;
                }
            }
            if (m.get(m.size() - 1) == null) {
                return null;
            }
            return m.get(m.size() - 1).color;
        }
        return (String) invokeLI.objValue;
    }

    public static String c(FrsViewData frsViewData) {
        InterceptResult invokeL;
        u15 u15Var;
        CoverImageColor b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, frsViewData)) == null) {
            if (frsViewData == null || frsViewData.getActivityHeadData() == null) {
                return null;
            }
            ArrayList<u15> b2 = frsViewData.getActivityHeadData().b();
            if (!ListUtils.isEmpty(b2)) {
                u15Var = b2.get(0);
            } else {
                u15Var = null;
            }
            if (u15Var == null || (b = u15Var.b()) == null) {
                return null;
            }
            return b.value;
        }
        return (String) invokeL.objValue;
    }

    public static void d(FrsViewData frsViewData, int i, BdUniqueId bdUniqueId) {
        StatisticItem h;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(65539, null, frsViewData, i, bdUniqueId) == null) && (h = h("common_click", frsViewData, i)) != null) {
            u9a.g().c(bdUniqueId, h);
        }
    }

    public static void e(FrsViewData frsViewData, int i, BdUniqueId bdUniqueId) {
        StatisticItem h;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, frsViewData, i, bdUniqueId) == null) && (h = h("common_exp", frsViewData, i)) != null && frsViewData != null && frsViewData.getActivityHeadData() != null && frsViewData.getActivityHeadData().c() != null) {
            u9a.g().d(bdUniqueId, s9a.b("", frsViewData.getActivityHeadData().c(), "", null), h);
        }
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            int autoPlaySwitch = TbadkCoreApplication.getInst().getAutoPlaySwitch();
            if ((autoPlaySwitch != 3 && BdNetTypeUtil.isWifiNet()) || (autoPlaySwitch == 2 && BdNetTypeUtil.isMobileNet())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void g(String str, daa daaVar, ForumData forumData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, str, daaVar, forumData) != null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        if (daaVar != null) {
            int i = 11;
            if (daaVar.getType() != 1) {
                if (daaVar.getType() == 2) {
                    i = 12;
                } else if (daaVar.getType() == 3) {
                    i = 13;
                } else if (daaVar.getType() == 4) {
                    i = 22;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i);
            statisticItem.param("obj_id", daaVar.c());
        }
        if (forumData != null) {
            statisticItem.param("fid", forumData.getId()).param("fname", forumData.getName());
        }
        TiebaStatic.log(statisticItem);
    }

    public static StatisticItem h(String str, FrsViewData frsViewData, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65543, null, str, frsViewData, i)) == null) {
            if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().c())) {
                StatisticItem statisticItem = new StatisticItem(str);
                statisticItem.param("page_type", "a006").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("fid", frsViewData.getForum().getId()).param("obj_id", frsViewData.getActivityHeadData().c()).param(TiebaStatic.Params.OBJ_AD_LOCATE, 1).param(TiebaStatic.Params.FIRST_DIR, frsViewData.getForum().getFirst_class()).param(TiebaStatic.Params.SECOND_DIR, frsViewData.getForum().getSecond_class()).param("obj_type", i);
                return statisticItem;
            }
            return null;
        }
        return (StatisticItem) invokeLLI.objValue;
    }

    public static StatisticItem i(String str, daa daaVar, ForumData forumData, int i, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{str, daaVar, forumData, Integer.valueOf(i), str2})) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            if (daaVar != null) {
                int i2 = 11;
                if (daaVar.getType() != 1) {
                    if (daaVar.getType() == 2) {
                        i2 = 12;
                    } else if (daaVar.getType() == 3) {
                        i2 = 13;
                    } else if (daaVar.getType() == 4) {
                        i2 = 22;
                    }
                }
                statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
                statisticItem.param("obj_id", daaVar.c());
                if (daaVar.getType() == 1) {
                    statisticItem.param("tid", daaVar.m());
                    statisticItem.param("thread_type", daaVar.n());
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            if (forumData != null) {
                statisticItem.param("fid", forumData.getId());
                statisticItem.param("fname", forumData.getName());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, forumData.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, forumData.getSecond_class());
            }
            statisticItem.param("obj_type", i);
            if (i == 2 && !StringUtils.isNull(str2)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str2);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static boolean j(daa daaVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, daaVar, str)) == null) {
            if (daaVar != null && !StringUtils.isNull(daaVar.q())) {
                SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                long j = sharedPrefHelper.getLong("key_frs_video_ad_last_show_time" + str, 0L);
                if (j < 0) {
                    return true;
                }
                return !TimeHelper.isSameDay(new Date(j), new Date(System.currentTimeMillis()));
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void l(String str, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, frsViewData) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.OBJ_AD_LOCATE, 1);
            if (frsViewData != null) {
                if (frsViewData.getForum() != null) {
                    statisticItem.param("fid", frsViewData.getForum().getId()).param("fname", frsViewData.getForum().getName());
                }
                if (frsViewData.getActivityHeadData() != null) {
                    statisticItem.param("obj_id", frsViewData.getActivityHeadData().c());
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }
}
