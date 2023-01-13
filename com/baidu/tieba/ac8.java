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
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class ac8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(y48 y48Var, PostData postData, int i, int i2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65536, null, y48Var, postData, i, i2) == null) {
            if (postData != null) {
                str = postData.O();
            } else {
                str = null;
            }
            c(y48Var, postData, str, i, i2);
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

    public static void b(y48 y48Var, PostData postData, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65537, null, new Object[]{y48Var, postData, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) != null) || y48Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        String str = null;
        if (postData != null) {
            str = postData.O();
        }
        h(statisticItem, y48Var, postData, i, i2, false, str);
        statisticItem.param("obj_locate", i3);
        TiebaStatic.log(statisticItem);
    }

    public static void c(y48 y48Var, PostData postData, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{y48Var, postData, str, Integer.valueOf(i), Integer.valueOf(i2)}) != null) || y48Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        h(statisticItem, y48Var, postData, i, i2, false, str);
        TiebaStatic.log(statisticItem);
    }

    public static StatisticItem i(y48 y48Var, PostData postData, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{y48Var, postData, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            String str = null;
            if (y48Var == null) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem("common_click");
            if (postData != null) {
                str = postData.O();
            }
            h(statisticItem, y48Var, postData, i, i2, false, str);
            statisticItem.param("obj_locate", i3);
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static void d(BdUniqueId bdUniqueId, y48 y48Var, PostData postData, int i, int i2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{bdUniqueId, y48Var, postData, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            if (postData != null) {
                str = postData.O();
            } else {
                str = null;
            }
            String str2 = str;
            f(bdUniqueId, y48Var, postData, str2, str2, i, i2);
        }
    }

    public static void e(BdUniqueId bdUniqueId, y48 y48Var, PostData postData, int i, int i2, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{bdUniqueId, y48Var, postData, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) {
            if (postData != null) {
                str2 = postData.O();
            } else {
                str2 = null;
            }
            String str3 = str2;
            g(bdUniqueId, y48Var, postData, str3, str3, i, i2, str);
        }
    }

    public static void f(BdUniqueId bdUniqueId, y48 y48Var, PostData postData, String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{bdUniqueId, y48Var, postData, str, str2, Integer.valueOf(i), Integer.valueOf(i2)}) == null) && bdUniqueId != null && y48Var != null) {
            StatisticItem statisticItem = new StatisticItem("common_exp");
            h(statisticItem, y48Var, postData, i, i2, false, str);
            kv8.g().d(bdUniqueId, str2, statisticItem);
        }
    }

    public static void g(BdUniqueId bdUniqueId, y48 y48Var, PostData postData, String str, String str2, int i, int i2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{bdUniqueId, y48Var, postData, str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3}) == null) && bdUniqueId != null && y48Var != null) {
            StatisticItem statisticItem = new StatisticItem("common_exp");
            h(statisticItem, y48Var, postData, i, i2, false, str);
            statisticItem.param("common_exp_source_pb_comment", str3);
            kv8.g().d(bdUniqueId, str2, statisticItem);
        }
    }

    public static StatisticItem h(StatisticItem statisticItem, y48 y48Var, PostData postData, int i, int i2, boolean z, String str) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{statisticItem, y48Var, postData, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), str})) == null) {
            if (y48Var == null) {
                return statisticItem;
            }
            StatisticItem param = statisticItem.param("page_type", "a005").param(TiebaStatic.Params.OBJ_FLOOR, i).param(TiebaStatic.Params.OBJ_ISAD, z ? 1 : 0);
            StatisticItem param2 = param.param("fid", y48Var.m() + "");
            StatisticItem param3 = param2.param("tid", y48Var.S() + "");
            param3.param("obj_id", str + "").param(TiebaStatic.Params.POST_TYPE, i2);
            if (postData != null) {
                statisticItem.param("pid", postData.O() + "");
            }
            if (y48Var.Q() != null) {
                statisticItem.param("thread_type", y48Var.Q().threadType);
                BaijiahaoData baijiahaoData = y48Var.Q().getBaijiahaoData();
                if (baijiahaoData != null) {
                    statisticItem.param(TiebaStatic.Params.UGC_NID, baijiahaoData.oriUgcNid);
                    statisticItem.param(TiebaStatic.Params.UGC_VID, baijiahaoData.oriUgcVid);
                    statisticItem.param(TiebaStatic.Params.UGC_TYPE, baijiahaoData.oriUgcType);
                }
            }
            if (y48Var.W() == null) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            statisticItem.param(TiebaStatic.Params.IS_UP, i3);
            int i4 = 2;
            if (y48Var.Q().isGoods()) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 1);
            } else if (postData.S() != null) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 2);
            } else if (mo5.w(postData)) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 4);
            } else {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 0);
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().k);
            }
            if (!y48Var.l0()) {
                int i5 = y48Var.g;
                if (i5 == 2) {
                    i4 = 1;
                } else if (i5 == 1) {
                    i4 = 3;
                }
                statisticItem.param(TiebaStatic.Params.LIST_ORDER, i4);
            }
            if (y48Var.Q() != null) {
                statisticItem.param(TiebaStatic.Params.IS_ZP, y48Var.Q().isWorksInfo() ? 1 : 0);
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
                if (absPbActivity.l1() != null && absPbActivity.l1().l1() != null) {
                    return absPbActivity.l1().l1().J();
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void m(fs4 fs4Var, int i, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(65548, null, fs4Var, i, tbPageContext) == null) && fs4Var != null && fs4Var.getThreadData() != null) {
            StatisticItem statisticItem = new StatisticItem("common_click");
            if (fs4Var.getThreadData().getForumData() != null) {
                statisticItem.param("obj_type", j(fs4Var.getThreadData().getForumData().i));
            }
            statisticItem.param("obj_locate", fs4Var.getThreadData().floorNum);
            statisticItem.param("tid", fs4Var.getThreadData().getTid());
            statisticItem.param("fid", fs4Var.getThreadData().getFid());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_source", i);
            statisticItem.param("page_type", "a005");
            statisticItem.param(TiebaStatic.Params.IS_REC, "1");
            statisticItem.param(TiebaStatic.Params.FROM_SOURCE, k(tbPageContext));
            statisticItem.param(TiebaStatic.Params.REC_TYPE, l(tbPageContext));
            TiebaStatic.log(statisticItem);
        }
    }

    public static void n(fs4 fs4Var, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, fs4Var, tbPageContext) == null) && fs4Var != null && fs4Var.getThreadData() != null) {
            StatisticItem statisticItem = new StatisticItem("common_exp");
            if (fs4Var.getThreadData().getForumData() != null) {
                statisticItem.param("obj_type", j(fs4Var.getThreadData().getForumData().i));
            }
            statisticItem.param("tid", fs4Var.getThreadData().getTid());
            statisticItem.param("fid", fs4Var.getThreadData().getFid());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("page_type", "a005");
            statisticItem.param(TiebaStatic.Params.IS_REC, "1");
            statisticItem.param(TiebaStatic.Params.FROM_SOURCE, k(tbPageContext));
            statisticItem.param(TiebaStatic.Params.REC_TYPE, l(tbPageContext));
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, fs4Var.position + 1);
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
