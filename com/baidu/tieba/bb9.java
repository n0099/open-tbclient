package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bb9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(m39 m39Var, jy9 jy9Var, int i, int i2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65536, null, m39Var, jy9Var, i, i2) == null) {
            if (jy9Var != null) {
                str = jy9Var.O();
            } else {
                str = null;
            }
            c(m39Var, jy9Var, str, i, i2);
        }
    }

    public static void o(String str, String str2, String str3, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLI(65550, null, str, str2, str3, i) != null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("tid", str2);
        statisticItem.param("obj_source", str3);
        statisticItem.param("obj_type", i);
        TiebaStatic.log(statisticItem);
    }

    public static void u(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65556, null, str, str2, str3, str4) != null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("fid", str2);
        statisticItem.param("tid", str3);
        statisticItem.param("uid", str4);
        TiebaStatic.log(statisticItem);
    }

    public static void b(m39 m39Var, jy9 jy9Var, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65537, null, new Object[]{m39Var, jy9Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) != null) || m39Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        String str = null;
        if (jy9Var != null) {
            str = jy9Var.O();
        }
        h(statisticItem, m39Var, jy9Var, i, i2, false, str);
        statisticItem.param("obj_locate", i3);
        TiebaStatic.log(statisticItem);
    }

    public static void c(m39 m39Var, jy9 jy9Var, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{m39Var, jy9Var, str, Integer.valueOf(i), Integer.valueOf(i2)}) != null) || m39Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        h(statisticItem, m39Var, jy9Var, i, i2, false, str);
        TiebaStatic.log(statisticItem);
    }

    public static StatisticItem i(m39 m39Var, jy9 jy9Var, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{m39Var, jy9Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            String str = null;
            if (m39Var == null) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem("common_click");
            if (jy9Var != null) {
                str = jy9Var.O();
            }
            h(statisticItem, m39Var, jy9Var, i, i2, false, str);
            statisticItem.param("obj_locate", i3);
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static void d(BdUniqueId bdUniqueId, m39 m39Var, jy9 jy9Var, int i, int i2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{bdUniqueId, m39Var, jy9Var, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            if (jy9Var != null) {
                str = jy9Var.O();
            } else {
                str = null;
            }
            String str2 = str;
            f(bdUniqueId, m39Var, jy9Var, str2, str2, i, i2);
        }
    }

    public static void e(BdUniqueId bdUniqueId, m39 m39Var, jy9 jy9Var, int i, int i2, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{bdUniqueId, m39Var, jy9Var, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) {
            if (jy9Var != null) {
                str2 = jy9Var.O();
            } else {
                str2 = null;
            }
            String str3 = str2;
            g(bdUniqueId, m39Var, jy9Var, str3, str3, i, i2, str);
        }
    }

    public static void f(BdUniqueId bdUniqueId, m39 m39Var, jy9 jy9Var, String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{bdUniqueId, m39Var, jy9Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2)}) == null) && bdUniqueId != null && m39Var != null) {
            StatisticItem statisticItem = new StatisticItem("common_exp");
            h(statisticItem, m39Var, jy9Var, i, i2, false, str);
            lw9.g().d(bdUniqueId, str2, statisticItem);
        }
    }

    public static void g(BdUniqueId bdUniqueId, m39 m39Var, jy9 jy9Var, String str, String str2, int i, int i2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{bdUniqueId, m39Var, jy9Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3}) == null) && bdUniqueId != null && m39Var != null) {
            StatisticItem statisticItem = new StatisticItem("common_exp");
            h(statisticItem, m39Var, jy9Var, i, i2, false, str);
            statisticItem.param("common_exp_source_pb_comment", str3);
            lw9.g().d(bdUniqueId, str2, statisticItem);
        }
    }

    public static StatisticItem h(StatisticItem statisticItem, m39 m39Var, jy9 jy9Var, int i, int i2, boolean z, String str) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{statisticItem, m39Var, jy9Var, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), str})) == null) {
            if (m39Var == null) {
                return statisticItem;
            }
            StatisticItem param = statisticItem.param("page_type", "a005").param(TiebaStatic.Params.OBJ_FLOOR, i).param(TiebaStatic.Params.OBJ_ISAD, z ? 1 : 0);
            StatisticItem param2 = param.param("fid", m39Var.l() + "");
            StatisticItem param3 = param2.param("tid", m39Var.P() + "");
            param3.param("obj_id", str + "").param(TiebaStatic.Params.POST_TYPE, i2);
            if (jy9Var != null) {
                statisticItem.param("pid", jy9Var.O() + "");
            }
            if (m39Var.N() != null) {
                statisticItem.param("thread_type", m39Var.N().threadType);
                BaijiahaoData baijiahaoData = m39Var.N().getBaijiahaoData();
                if (baijiahaoData != null) {
                    statisticItem.param(TiebaStatic.Params.UGC_NID, baijiahaoData.oriUgcNid);
                    statisticItem.param(TiebaStatic.Params.UGC_VID, baijiahaoData.oriUgcVid);
                    statisticItem.param(TiebaStatic.Params.UGC_TYPE, baijiahaoData.oriUgcType);
                }
            }
            if (m39Var.T() == null) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            statisticItem.param(TiebaStatic.Params.IS_UP, i3);
            int i4 = 2;
            if (m39Var.N().isGoods()) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 1);
            } else if (jy9Var.S() != null) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 2);
            } else if (q16.x(jy9Var)) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 4);
            } else {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 0);
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().k);
            }
            if (!m39Var.i0()) {
                int i5 = m39Var.g;
                if (i5 == 2) {
                    i4 = 1;
                } else if (i5 == 1) {
                    i4 = 3;
                }
                statisticItem.param(TiebaStatic.Params.LIST_ORDER, i4);
            }
            if (m39Var.N() != null) {
                statisticItem.param(TiebaStatic.Params.IS_ZP, m39Var.N().isWorksInfo() ? 1 : 0);
            }
            if (PermissionUtil.isBrowseMode()) {
                statisticItem.param(TiebaStatic.Params.PURE_BROWSING, 1);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static int j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if ("游戏".equals(str)) {
                return 1;
            }
            if ("动漫".equals(str)) {
                return 2;
            }
            if ("电脑数码".equals(str)) {
                return 3;
            }
            return 4;
        }
        return invokeL.intValue;
    }

    public static String k(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getIntent() != null) {
                return tbPageContext.getPageActivity().getIntent().getStringExtra("thread_id");
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static int l(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && (tbPageContext.getPageActivity() instanceof AbsPbActivity)) {
                AbsPbActivity absPbActivity = (AbsPbActivity) tbPageContext.getPageActivity();
                if (absPbActivity.K1() != null && absPbActivity.K1().y1() != null) {
                    return absPbActivity.K1().y1().G();
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void m(h15 h15Var, int i, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(65548, null, h15Var, i, tbPageContext) == null) && h15Var != null && h15Var.getThreadData() != null) {
            StatisticItem statisticItem = new StatisticItem("common_click");
            if (h15Var.getThreadData().getForumData() != null) {
                statisticItem.param("obj_type", j(h15Var.getThreadData().getForumData().l));
            }
            statisticItem.param("obj_locate", h15Var.getThreadData().floorNum);
            statisticItem.param("tid", h15Var.getThreadData().getTid());
            statisticItem.param("fid", h15Var.getThreadData().getFid());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_source", i);
            statisticItem.param("page_type", "a005");
            statisticItem.param(TiebaStatic.Params.IS_REC, "1");
            statisticItem.param(TiebaStatic.Params.FROM_SOURCE, k(tbPageContext));
            statisticItem.param(TiebaStatic.Params.REC_TYPE, l(tbPageContext));
            TiebaStatic.log(statisticItem);
        }
    }

    public static void n(h15 h15Var, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, h15Var, tbPageContext) == null) && h15Var != null && h15Var.getThreadData() != null) {
            StatisticItem statisticItem = new StatisticItem("common_exp");
            if (h15Var.getThreadData().getForumData() != null) {
                statisticItem.param("obj_type", j(h15Var.getThreadData().getForumData().l));
            }
            statisticItem.param("tid", h15Var.getThreadData().getTid());
            statisticItem.param("fid", h15Var.getThreadData().getFid());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("page_type", "a005");
            statisticItem.param(TiebaStatic.Params.IS_REC, "1");
            statisticItem.param(TiebaStatic.Params.FROM_SOURCE, k(tbPageContext));
            statisticItem.param(TiebaStatic.Params.REC_TYPE, l(tbPageContext));
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, h15Var.position + 1);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void p(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65551, null, str, str2, str3) != null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        if (!StringUtils.isNull(str2)) {
            statisticItem.param("tid", str2);
        }
        if (!StringUtils.isNull(str3)) {
            statisticItem.param("post_id", str3);
        }
        TiebaStatic.log(statisticItem);
    }

    public static void q(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(65552, null, str, i, i2) != null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", i2);
        TiebaStatic.log(statisticItem);
    }

    public static void r(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(65553, null, str, str2, i) != null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("fid", str2);
        statisticItem.param("obj_locate", i);
        TiebaStatic.log(statisticItem);
    }

    public static void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65554, null, i) == null) {
            StatisticItem statisticItem = new StatisticItem("c14888");
            statisticItem.addParam("obj_locate", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, str) == null) {
            TiebaStatic.log(new StatisticItem(str));
        }
    }

    public static void v(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65557, null, str, str2) != null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("forum_id", str2);
        TiebaStatic.log(statisticItem);
    }

    public static void w(String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLJ(65558, null, str, j) != null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("forum_id", j);
        TiebaStatic.log(statisticItem);
    }
}
