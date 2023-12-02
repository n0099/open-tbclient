package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class b6a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void A(@Nullable PbModel pbModel) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65536, null, pbModel) != null) || pbModel == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13401");
        statisticItem.param("tid", pbModel.M1());
        statisticItem.param("fid", pbModel.getForumId());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        if (pbModel.s1().R() != null) {
            statisticItem.param("nid", pbModel.s1().R().getNid());
        }
        TiebaStatic.log(statisticItem);
    }

    public static int n(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, tbPageContext)) == null) {
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && (tbPageContext.getPageActivity() instanceof AbsPbActivity)) {
                AbsPbActivity absPbActivity = (AbsPbActivity) tbPageContext.getPageActivity();
                if (absPbActivity.B1() != null && absPbActivity.B1().s1() != null) {
                    return absPbActivity.B1().s1().J();
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void B(@Nullable PbModel pbModel, @Nullable mwa mwaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, pbModel, mwaVar) == null) && pbModel != null && mwaVar != null) {
            TiebaStatic.log(new StatisticItem("c13700").param("tid", pbModel.N1()).param("fid", pbModel.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", mwaVar.U()).param("obj_source", 1).param("obj_type", 3));
        }
    }

    public static void x(int i, @Nullable PbModel pbModel) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(65574, null, i, pbModel) != null) || pbModel == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13402").param("tid", pbModel.M1()).param("fid", pbModel.s1().o()).param("obj_locate", i).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public static void C(@NonNull PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, pbModel) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", pbModel.getForumId());
            statisticItem.param("fname", pbModel.R0());
            statisticItem.param("tid", pbModel.M1());
            TiebaStatic.log(statisticItem);
        }
    }

    public static void F(@NonNull PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, pbModel) == null) {
            TiebaStatic.log(new StatisticItem("c12378").param("tid", pbModel.M1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", pbModel.getForumId()));
        }
    }

    public static int l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, str)) == null) {
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

    public static String m(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, tbPageContext)) == null) {
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getIntent() != null) {
                return tbPageContext.getPageActivity().getIntent().getStringExtra("thread_id");
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static void z(@Nullable ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65576, null, threadData) != null) || threadData == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13399");
        statisticItem.param("tid", threadData.getId());
        statisticItem.param("fid", threadData.getFid());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("nid", threadData.getNid());
        TiebaStatic.log(statisticItem);
    }

    public static void D(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65539, null, str, str2, str3, str4) != null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("fid", str2);
        statisticItem.param("tid", str3);
        statisticItem.param("uid", str4);
        TiebaStatic.log(statisticItem);
    }

    public static void a(zv9 zv9Var, mwa mwaVar, int i, int i2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65551, null, zv9Var, mwaVar, i, i2) == null) {
            if (mwaVar != null) {
                str = mwaVar.U();
            } else {
                str = null;
            }
            c(zv9Var, mwaVar, str, i, i2);
        }
    }

    public static void s(String str, String str2, String str3, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLI(65569, null, str, str2, str3, i) != null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("tid", str2);
        statisticItem.param("obj_source", str3);
        statisticItem.param("obj_type", i);
        TiebaStatic.log(statisticItem);
    }

    public static void E(int i, int i2, int i3, @Nullable PbModel pbModel) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), pbModel}) == null) && pbModel != null && pbModel.s1() != null && pbModel.s1().R() != null) {
            ThreadData R = pbModel.s1().R();
            int i4 = 1;
            if (R.isBJHArticleThreadType()) {
                i4 = 2;
            } else if (R.isBJHVideoThreadType()) {
                i4 = 3;
            } else if (R.isBJHNormalThreadType()) {
                i4 = 4;
            } else if (R.isBJHVideoDynamicThreadType()) {
                i4 = 5;
            }
            TiebaStatic.log(new StatisticItem("c12526").param("tid", pbModel.M1()).param("obj_locate", i).param("obj_id", R.getAuthor().getUserId()).param("obj_type", i3).param("obj_source", i2).param("obj_param1", i4));
        }
    }

    public static void G(@NonNull ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, threadData) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_MORE_DIALOG_MUSK_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("tid", threadData.getId());
            statisticItem.param("fid", threadData.getFid());
            statisticItem.param("fname", threadData.getForum_name());
            TiebaStatic.log(statisticItem);
            StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem2.param("tid", threadData.getId());
            statisticItem2.param("fid", threadData.getFid());
            statisticItem2.param("fname", threadData.getForum_name());
            statisticItem2.param("obj_source", 3);
            TiebaStatic.log(statisticItem2);
        }
    }

    public static void H(@Nullable ThreadData threadData, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(65543, null, threadData, i, i2) != null) || threadData == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, i).param("obj_locate", i2).param("obj_id", threadData.getFid()).param("tid", threadData.getId()).param("thread_type", threadData.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData.isWorksInfo() ? 1 : 0));
    }

    public static void r(fw4 fw4Var, TbPageContext tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65568, null, fw4Var, tbPageContext, str) == null) && fw4Var != null && fw4Var.getThreadData() != null) {
            StatisticItem statisticItem = new StatisticItem("common_exp");
            if (fw4Var.getThreadData().getForumData() != null) {
                statisticItem.param("obj_type", l(fw4Var.getThreadData().getForumData().l));
            }
            statisticItem.param("tid", fw4Var.getThreadData().getTid());
            statisticItem.param("fid", fw4Var.getThreadData().getFid());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("page_type", "a005");
            statisticItem.param(TiebaStatic.Params.IS_REC, str);
            statisticItem.param(TiebaStatic.Params.FROM_SOURCE, m(tbPageContext));
            statisticItem.param(TiebaStatic.Params.REC_TYPE, n(tbPageContext));
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, fw4Var.position + 1);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void I(int i, @Nullable PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65544, null, i, pbModel) == null) {
            J(i, 0, pbModel);
        }
    }

    public static void L(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65547, null, str, str2) != null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("forum_id", str2);
        TiebaStatic.log(statisticItem);
    }

    public static void M(String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLJ(65548, null, str, j) != null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("forum_id", j);
        TiebaStatic.log(statisticItem);
    }

    public static void q(fw4 fw4Var, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65567, null, fw4Var, tbPageContext) == null) {
            r(fw4Var, tbPageContext, "1");
        }
    }

    public static void J(int i, int i2, @Nullable PbModel pbModel) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIIL(65545, null, i, i2, pbModel) != null) || pbModel == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13398");
        statisticItem.param("tid", pbModel.M1());
        statisticItem.param("fid", pbModel.getForumId());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("obj_locate", i);
        if (i2 > 0) {
            statisticItem.param("obj_type", i2);
        }
        TiebaStatic.log(statisticItem);
    }

    public static void t(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65570, null, str, str2, str3) != null) || StringUtils.isNull(str)) {
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

    public static void K(int i, @Nullable PbModel pbModel, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65546, null, new Object[]{Integer.valueOf(i), pbModel, Integer.valueOf(i2)}) != null) || pbModel == null) {
            return;
        }
        int i3 = 0;
        if (pbModel.K1() == 2 && i == 0) {
            i3 = 1;
        } else if (pbModel.K1() == 3 && i != 2) {
            i3 = 2;
        } else if (i == 2 && pbModel.K1() != 3) {
            i3 = 3;
        }
        TiebaStatic.log("c12097");
        TiebaStatic.log(new StatisticItem("c12097").param("obj_source", i2).param("obj_type", i3));
    }

    public static void N(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65549, null, i, i2) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", i).param("obj_type", i2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0129  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void O(@Nullable PbModel pbModel, @Nullable AbsPbActivity absPbActivity, @Nullable n1a n1aVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65550, null, pbModel, absPbActivity, n1aVar, i) == null) && pbModel != null && pbModel.s1() != null && pbModel.s1().R() != null) {
            ThreadData R = pbModel.s1().R();
            int i3 = 5;
            int i4 = 1;
            if (R != null) {
                if (R.isBJHArticleThreadType()) {
                    i2 = 2;
                } else if (R.isBJHVideoThreadType()) {
                    i2 = 3;
                } else if (R.isBJHNormalThreadType()) {
                    i2 = 4;
                } else if (R.isBJHVideoDynamicThreadType()) {
                    i2 = 5;
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                statisticItem.param("tid", pbModel.M1());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", pbModel.getForumId());
                statisticItem.param("obj_locate", i);
                statisticItem.param("obj_name", i2);
                if (R != null) {
                    if (R.isBJHArticleThreadType()) {
                        i3 = 10;
                    } else if (R.isBJHVideoThreadType()) {
                        i3 = 9;
                    } else if (R.isBJHVideoDynamicThreadType()) {
                        i3 = 8;
                    } else if (R.isBJHNormalThreadType()) {
                        i3 = 7;
                    } else if (R.isShareThread) {
                        i3 = 6;
                    } else {
                        int i5 = R.threadType;
                        if (i5 == 0) {
                            i3 = 1;
                        } else if (i5 == 40) {
                            i3 = 2;
                        } else if (i5 == 49) {
                            i3 = 3;
                        } else if (i5 == 54) {
                            i3 = 4;
                        }
                    }
                    statisticItem.param("card_type", R.getRecomCardType());
                    statisticItem.param("recom_source", R.mRecomSource);
                    statisticItem.param("ab_tag", R.mRecomAbTag);
                    statisticItem.param("weight", R.mRecomWeight);
                    statisticItem.param("extra", R.mRecomExtra);
                    statisticItem.param("nid", R.getNid());
                    if (R.getBaijiahaoData() != null && !rd.isEmpty(R.getBaijiahaoData().oriUgcVid)) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, R.getBaijiahaoData().oriUgcVid);
                    }
                    i4 = i3;
                }
                statisticItem.param("obj_type", i4);
                if (!rd.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                }
                if (absPbActivity != null) {
                    cp5.e(absPbActivity, statisticItem);
                }
                if (n1aVar != null) {
                    statisticItem.param("obj_param1", n1aVar.V0());
                }
                TiebaStatic.log(statisticItem);
            }
            i2 = 1;
            StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem2.param("tid", pbModel.M1());
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem2.param("fid", pbModel.getForumId());
            statisticItem2.param("obj_locate", i);
            statisticItem2.param("obj_name", i2);
            if (R != null) {
            }
            statisticItem2.param("obj_type", i4);
            if (!rd.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            }
            if (absPbActivity != null) {
            }
            if (n1aVar != null) {
            }
            TiebaStatic.log(statisticItem2);
        }
    }

    public static void b(zv9 zv9Var, mwa mwaVar, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65552, null, new Object[]{zv9Var, mwaVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) != null) || zv9Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        String str = null;
        if (mwaVar != null) {
            str = mwaVar.U();
        }
        i(statisticItem, zv9Var, mwaVar, i, i2, false, str);
        statisticItem.param("obj_locate", i3);
        TiebaStatic.log(statisticItem);
    }

    public static void c(zv9 zv9Var, mwa mwaVar, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65553, null, new Object[]{zv9Var, mwaVar, str, Integer.valueOf(i), Integer.valueOf(i2)}) != null) || zv9Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        i(statisticItem, zv9Var, mwaVar, i, i2, false, str);
        TiebaStatic.log(statisticItem);
    }

    public static StatisticItem k(zv9 zv9Var, mwa mwaVar, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65561, null, new Object[]{zv9Var, mwaVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            String str = null;
            if (zv9Var == null) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem("common_click");
            if (mwaVar != null) {
                str = mwaVar.U();
            }
            i(statisticItem, zv9Var, mwaVar, i, i2, false, str);
            statisticItem.param("obj_locate", i3);
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static void d(BdUniqueId bdUniqueId, zv9 zv9Var, mwa mwaVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{bdUniqueId, zv9Var, mwaVar, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            f(bdUniqueId, zv9Var, mwaVar, i, i2, "", "");
        }
    }

    public static void e(BdUniqueId bdUniqueId, zv9 zv9Var, mwa mwaVar, int i, int i2, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{bdUniqueId, zv9Var, mwaVar, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) {
            if (mwaVar != null) {
                str2 = mwaVar.U();
            } else {
                str2 = null;
            }
            String str3 = str2;
            g(bdUniqueId, zv9Var, mwaVar, str3, str3, i, i2, str);
        }
    }

    public static void f(BdUniqueId bdUniqueId, zv9 zv9Var, mwa mwaVar, int i, int i2, String str, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65556, null, new Object[]{bdUniqueId, zv9Var, mwaVar, Integer.valueOf(i), Integer.valueOf(i2), str, str2}) == null) {
            if (mwaVar != null) {
                str3 = mwaVar.U();
            } else {
                str3 = null;
            }
            String str4 = str3;
            h(bdUniqueId, zv9Var, mwaVar, str4, str4, i, i2, str, str2);
        }
    }

    public static StatisticItem i(StatisticItem statisticItem, zv9 zv9Var, mwa mwaVar, int i, int i2, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, null, new Object[]{statisticItem, zv9Var, mwaVar, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), str})) == null) {
            j(statisticItem, zv9Var, mwaVar, i, i2, z, str, "", "");
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static void g(BdUniqueId bdUniqueId, zv9 zv9Var, mwa mwaVar, String str, String str2, int i, int i2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65557, null, new Object[]{bdUniqueId, zv9Var, mwaVar, str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3}) == null) && bdUniqueId != null && zv9Var != null) {
            StatisticItem statisticItem = new StatisticItem("common_exp");
            i(statisticItem, zv9Var, mwaVar, i, i2, false, str);
            statisticItem.param("common_exp_source_pb_comment", str3);
            pua.g().d(bdUniqueId, str2, statisticItem);
        }
    }

    public static void h(BdUniqueId bdUniqueId, zv9 zv9Var, mwa mwaVar, String str, String str2, int i, int i2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{bdUniqueId, zv9Var, mwaVar, str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3, str4}) == null) && bdUniqueId != null && zv9Var != null) {
            StatisticItem statisticItem = new StatisticItem("common_exp");
            j(statisticItem, zv9Var, mwaVar, i, i2, false, str, str3, str4);
            pua.g().d(bdUniqueId, str2, statisticItem);
        }
    }

    public static StatisticItem j(StatisticItem statisticItem, zv9 zv9Var, mwa mwaVar, int i, int i2, boolean z, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65560, null, new Object[]{statisticItem, zv9Var, mwaVar, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), str, str2, str3})) == null) {
            if (zv9Var == null) {
                return statisticItem;
            }
            StatisticItem param = statisticItem.param("page_type", "a005").param(TiebaStatic.Params.OBJ_FLOOR, i).param(TiebaStatic.Params.OBJ_ISAD, z ? 1 : 0);
            StatisticItem param2 = param.param("fid", zv9Var.o() + "");
            StatisticItem param3 = param2.param("tid", zv9Var.T() + "");
            param3.param("obj_id", str + "").param(TiebaStatic.Params.POST_TYPE, i2);
            if (mwaVar != null) {
                statisticItem.param("pid", mwaVar.U() + "");
            }
            if (zv9Var.R() != null) {
                statisticItem.param("thread_type", zv9Var.R().threadType);
                BaijiahaoData baijiahaoData = zv9Var.R().getBaijiahaoData();
                if (baijiahaoData != null) {
                    statisticItem.param(TiebaStatic.Params.UGC_NID, baijiahaoData.oriUgcNid);
                    statisticItem.param(TiebaStatic.Params.UGC_VID, baijiahaoData.oriUgcVid);
                    statisticItem.param(TiebaStatic.Params.UGC_TYPE, baijiahaoData.oriUgcType);
                }
            }
            if (zv9Var.X() == null) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            statisticItem.param(TiebaStatic.Params.IS_UP, i3);
            int i4 = 2;
            if (zv9Var.R().isGoods()) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 1);
            } else if (mwaVar.X() != null) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 2);
            } else if (ty5.y(mwaVar)) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 4);
            } else {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 0);
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().k);
            }
            if (!zv9Var.a()) {
                int i5 = zv9Var.g;
                if (i5 == 2) {
                    i4 = 1;
                } else if (i5 == 1) {
                    i4 = 3;
                }
                statisticItem.param(TiebaStatic.Params.LIST_ORDER, i4);
            }
            if (zv9Var.R() != null) {
                statisticItem.param(TiebaStatic.Params.IS_ZP, zv9Var.R().isWorksInfo() ? 1 : 0);
            }
            if (PermissionUtil.isBrowseMode()) {
                statisticItem.param(TiebaStatic.Params.PURE_BROWSING, 1);
            }
            if (mwaVar != null && mwaVar.b0() != null) {
                if (str3 == null) {
                    str3 = "";
                }
                statisticItem.addParam("obj_id", str3);
                if (str2 == null) {
                    str2 = "";
                }
                statisticItem.addParam("obj_name", str2);
                statisticItem.addParam("resource_id", mwaVar.b0().h());
                statisticItem.addParam(TiebaStatic.Params.OBJ_TO, mwaVar.b0().d());
            }
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static void o(fw4 fw4Var, int i, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65565, null, fw4Var, i, tbPageContext) == null) {
            p(fw4Var, i, tbPageContext, "1");
        }
    }

    public static void u(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(65571, null, str, str2, i) != null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("fid", str2);
        statisticItem.param("obj_locate", i);
        TiebaStatic.log(statisticItem);
    }

    public static void p(fw4 fw4Var, int i, TbPageContext tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(65566, null, fw4Var, i, tbPageContext, str) == null) && fw4Var != null && fw4Var.getThreadData() != null) {
            StatisticItem statisticItem = new StatisticItem("common_click");
            if (fw4Var.getThreadData().getForumData() != null) {
                statisticItem.param("obj_type", l(fw4Var.getThreadData().getForumData().l));
            }
            statisticItem.param("obj_locate", fw4Var.getThreadData().floorNum);
            statisticItem.param("tid", fw4Var.getThreadData().getTid());
            statisticItem.param("fid", fw4Var.getThreadData().getFid());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_source", i);
            statisticItem.param("page_type", "a005");
            statisticItem.param(TiebaStatic.Params.IS_REC, str);
            statisticItem.param(TiebaStatic.Params.FROM_SOURCE, m(tbPageContext));
            statisticItem.param(TiebaStatic.Params.REC_TYPE, n(tbPageContext));
            TiebaStatic.log(statisticItem);
        }
    }

    public static void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65572, null, i) == null) {
            StatisticItem statisticItem = new StatisticItem("c14888");
            statisticItem.addParam("obj_locate", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65573, null, str) == null) {
            TiebaStatic.log(new StatisticItem(str));
        }
    }

    public static void y(@Nullable SmartApp smartApp, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65575, null, smartApp, pbModel) == null) && smartApp != null && pbModel != null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", pbModel.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.naws_app_id.longValue()).param("obj_source", "PB_card").param("tid", pbModel.M1()).param("obj_param1", smartApp.is_game.intValue()));
        }
    }
}
