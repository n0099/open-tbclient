package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class ce5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static StatisticItem a(StatisticItem statisticItem, TbPageTag tbPageTag) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, statisticItem, tbPageTag)) == null) {
            if (tbPageTag != null && statisticItem != null) {
                if (!TextUtils.isEmpty(tbPageTag.locatePage)) {
                    if (statisticItem.hasParam(TiebaStatic.Params.OBJ_TAB)) {
                        statisticItem.delete(TiebaStatic.Params.OBJ_TAB);
                    }
                    statisticItem.param(TiebaStatic.Params.OBJ_TAB, tbPageTag.locatePage);
                }
                statisticItem.param("sort_tab", tbPageTag.sortType);
                return statisticItem;
            }
            return null;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem h(Context context, StatisticItem statisticItem) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, statisticItem)) == null) {
            if (context != null && statisticItem != null) {
                TbPageTag l = l(context);
                if (l != null) {
                    if (!TextUtils.isEmpty(l.locatePage)) {
                        if (statisticItem.hasParam(TiebaStatic.Params.OBJ_TAB)) {
                            statisticItem.delete(TiebaStatic.Params.OBJ_TAB);
                        }
                        statisticItem.param(TiebaStatic.Params.OBJ_TAB, l.locatePage);
                    }
                    statisticItem.param("sort_tab", l.sortType);
                }
                return statisticItem;
            }
            return null;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem b(Context context, StatisticItem statisticItem) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, statisticItem)) == null) {
            if (context != null && statisticItem != null) {
                return c(statisticItem, j(context));
            }
            return statisticItem;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem c(StatisticItem statisticItem, be5 be5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, statisticItem, be5Var)) == null) {
            if (be5Var != null && statisticItem != null) {
                return d(statisticItem, be5Var.b(), be5Var.a());
            }
            return statisticItem;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem e(Context context, StatisticItem statisticItem) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, statisticItem)) == null) {
            if (context != null && statisticItem != null) {
                return f(statisticItem, j(context));
            }
            return statisticItem;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem f(StatisticItem statisticItem, be5 be5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, statisticItem, be5Var)) == null) {
            if (be5Var != null && statisticItem != null) {
                return g(statisticItem, be5Var.b(), be5Var.a());
            }
            return statisticItem;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem d(StatisticItem statisticItem, TbPageTag tbPageTag, TbPageTag tbPageTag2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, statisticItem, tbPageTag, tbPageTag2)) == null) {
            if (statisticItem == null) {
                return null;
            }
            if (tbPageTag2 != null) {
                if (!TextUtils.isEmpty(tbPageTag2.locatePage)) {
                    if (statisticItem.hasParam(TiebaStatic.Params.OBJ_TAB)) {
                        statisticItem.delete(TiebaStatic.Params.OBJ_TAB);
                    }
                    statisticItem.param(TiebaStatic.Params.OBJ_TAB, tbPageTag2.locatePage);
                }
                statisticItem.param("sort_tab", tbPageTag2.sortType);
            }
            if (tbPageTag != null && !TextUtils.isEmpty(tbPageTag.locatePage)) {
                statisticItem.param(GuildActivityConfig.FROM_PAGE, tbPageTag.locatePage);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeLLL.objValue;
    }

    public static StatisticItem g(StatisticItem statisticItem, TbPageTag tbPageTag, TbPageTag tbPageTag2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, statisticItem, tbPageTag, tbPageTag2)) == null) {
            if (statisticItem == null) {
                return null;
            }
            if (tbPageTag2 != null) {
                if (!TextUtils.isEmpty(tbPageTag2.locatePage)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PAGE, tbPageTag2.locatePage);
                }
                statisticItem.param("sort_tab", tbPageTag2.sortType);
            }
            if (tbPageTag != null && !TextUtils.isEmpty(tbPageTag.locatePage)) {
                if (statisticItem.hasParam(TiebaStatic.Params.OBJ_TAB)) {
                    statisticItem.delete(TiebaStatic.Params.OBJ_TAB);
                }
                statisticItem.param(TiebaStatic.Params.OBJ_TAB, tbPageTag.locatePage);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeLLL.objValue;
    }

    public static StatisticItem i(Context context, ThreadData threadData, String str) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, context, threadData, str)) == null) {
            if (context != null && threadData != null && !StringUtils.isNull(str)) {
                StatisticItem statisticItem = new StatisticItem(str);
                statisticItem.param("tid", threadData.getId()).param("fid", threadData.getFid()).param("thread_type", threadData.getThreadType()).param("card_type", threadData.getRecomCardType()).param("nid", threadData.getNid());
                if (threadData.getBaijiahaoData() != null && !xi.isEmpty(threadData.getBaijiahaoData().oriUgcVid)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, threadData.getBaijiahaoData().oriUgcVid);
                }
                StatisticItem param = statisticItem.param("weight", threadData.mRecomWeight).param("ab_tag", threadData.mRecomAbTag).param("extra", threadData.mRecomExtra);
                if (threadData.isSubPb) {
                    str2 = "2";
                } else {
                    str2 = "1";
                }
                param.param("obj_type", str2).param("source", threadData.mRecomSource);
                h(context, statisticItem);
                return statisticItem;
            }
            return null;
        }
        return (StatisticItem) invokeLLL.objValue;
    }

    public static be5 j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (context == null) {
                return null;
            }
            s9<?> b = x9.b(context);
            if (!(b instanceof ae5)) {
                return null;
            }
            return ((ae5) b).getTbPageInfo();
        }
        return (be5) invokeL.objValue;
    }

    public static TbPageTag k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            be5 j = j(context);
            if (j == null) {
                return null;
            }
            return j.a();
        }
        return (TbPageTag) invokeL.objValue;
    }

    public static TbPageTag m(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, intent)) == null) {
            if (intent != null) {
                return (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
            }
            return null;
        }
        return (TbPageTag) invokeL.objValue;
    }

    public static TbPageTag l(Context context) {
        InterceptResult invokeL;
        s9<?> b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            if (context != null && (b = x9.b(context)) != null && b.getPageContext() != null && b.getPageContext().getPageActivity() != null) {
                return m(b.getPageContext().getPageActivity().getIntent());
            }
            return null;
        }
        return (TbPageTag) invokeL.objValue;
    }
}
