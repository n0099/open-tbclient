package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiePlusStatic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes3.dex */
public class as6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, ThreadData threadData, TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, statisticItem, threadData, tbPageTag) == null) {
            if (!dj.isEmpty(threadData.mRecomWeight)) {
                statisticItem.param(TiebaStatic.Params.RECOM_WEIGHT, threadData.mRecomWeight);
            }
            if (!dj.isEmpty(threadData.mRecomExtra)) {
                statisticItem.param(TiebaStatic.Params.RECOM_EXTRA, threadData.mRecomExtra);
            }
            if (!dj.isEmpty(threadData.mRecomSource)) {
                statisticItem.param("recom_source", threadData.mRecomSource);
            }
            if (!dj.isEmpty(threadData.mRecomAbTag)) {
                statisticItem.param(TiebaStatic.Params.RECOM_AB_TAG, threadData.mRecomAbTag);
            }
            statisticItem.param(TiebaStatic.Params.RECOM_TYPE, threadData.getRecomCardType());
            tc5.a(statisticItem, tbPageTag);
        }
    }

    public static void b(ThreadData threadData, TbPageTag tbPageTag, String str) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, threadData, tbPageTag, str) == null) || threadData == null) {
            return;
        }
        int i2 = 2;
        if ("a070".equals(tbPageTag.locatePage)) {
            i = 1;
        } else if (!"a071".equals(tbPageTag.locatePage)) {
            return;
        } else {
            i = 2;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("tid", threadData.tid);
        statisticItem.param("fid", threadData.getFid());
        statisticItem.param("fname", threadData.getForum_name());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        if (threadData.getAuthor() != null && threadData.getAuthor().getAlaInfo() != null) {
            statisticItem.param("obj_param1", YYLiveUtil.calculateLiveType(threadData.getAuthor().getAlaInfo()));
            if (threadData.getAuthor().getAlaInfo().mYyExtData != null) {
                TiebaStaticHelper.addYYParam(statisticItem, threadData.getAuthor().getAlaInfo().mYyExtData);
            }
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, (threadData.getAuthor().getAlaInfo().live_status == 1 || threadData.getAuthor().getAlaInfo().friendRoomStatus == 2) ? 1 : 1);
        }
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, threadData.getYYStaticticType());
        statisticItem.param("obj_locate", i);
        TiebaStatic.log(statisticItem);
    }

    @Deprecated
    public static void c(ThreadData threadData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, threadData, str) == null) {
            d(threadData, str, 1);
        }
    }

    public static void d(ThreadData threadData, String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65539, null, threadData, str, i) == null) || threadData == null) {
            return;
        }
        if (threadData.isTiebaPlusAdThread) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_CLICK);
            statisticItem.addParam("obj_locate", threadData.tiePlusFrsStaticLocate);
            if (threadData.isVideoWorksInfo()) {
                statisticItem.addParam("obj_type", 3);
            } else if (threadData.isVideoThreadType()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam(TiePlusStatic.Params.CLI_LOCATE, i);
            statisticItem.addParam("tid", threadData.getTid());
            statisticItem.addParam(TiebaStatic.Params.FID_1, threadData.getFid());
            statisticItem.addParam(TiebaStatic.Params.FID_2, str);
            statisticItem.addParam("order_id", threadData.tiebaPlusOrderId);
            TiebaStatic.log(statisticItem);
            vn4.a(vn4.e, vn4.b, threadData.tiebaPlusOrderId, threadData.tiebaPlusToken, threadData.tiebaPlusExtraParam, threadData.statFloor);
        }
        if (threadData.getRecomSource() != null && threadData.getRecomSource().startsWith("manual")) {
            vn4.a(vn4.l, vn4.b, threadData.tiebaPlusOrderId, threadData.tiebaPlusToken, threadData.tiebaPlusExtraParam, threadData.statFloor);
        }
        if (TextUtils.isEmpty(threadData.tiePlusMonitorClickUrl)) {
            return;
        }
        ThirdStatisticHelper.sendReq(threadData.tiePlusMonitorClickUrl);
    }

    public static void e(ThreadData threadData, int i, BdUniqueId bdUniqueId, bs6 bs6Var, TbPageTag tbPageTag) {
        int i2;
        String str;
        boolean z;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{threadData, Integer.valueOf(i), bdUniqueId, bs6Var, tbPageTag}) == null) || threadData == null) {
            return;
        }
        String str2 = null;
        boolean z2 = (threadData.getThreadAlaInfo() == null || threadData.getThreadAlaInfo().user_info == null || threadData.getThreadAlaInfo().user_info.is_official != 2) ? false : true;
        boolean z3 = z2 && threadData.getThreadAlaInfo().frsLiveStageType == 0;
        if (z3) {
            str2 = String.valueOf(threadData.getThreadAlaInfo().live_id);
            i2 = 4;
        } else {
            i2 = 0;
        }
        if (!z3) {
            z3 = threadData.getThreadType() == 41;
            if (z3) {
                if (threadData.getTaskInfoData() != null) {
                    str2 = threadData.getTaskInfoData().f();
                }
                i2 = 2;
            }
        }
        if (threadData.isHeadLinePost) {
            str2 = threadData.getId();
            i2 = 14;
            z3 = true;
        }
        if (threadData.isSCard) {
            str = threadData.scardPacketId;
            z = true;
            i3 = 17;
        } else {
            str = str2;
            z = z3;
            i3 = i2;
        }
        StatisticItem c = jl8.c(threadData, "a006", "common_click", i, threadData.statFloor, z, str, null, i3);
        if (c == null) {
            return;
        }
        c.param(TiebaStatic.Params.LIST_ORDER, cs6.k().l(bs6Var));
        hr6.a(c);
        if (threadData.isGoods()) {
            c.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (threadData.getItem() != null) {
            c.param(TiebaStatic.Params.GUA_TYPE, 2);
            int indexOf = c.getParams().indexOf("obj_locate");
            if (indexOf >= 0) {
                int i4 = indexOf + 1;
                c.getParams().remove(i4);
                c.getParams().add(i4, 16);
            } else {
                c.param("obj_locate", 16);
            }
        } else if (hl5.t(threadData)) {
            c.param(TiebaStatic.Params.GUA_TYPE, 4);
        } else {
            c.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        a(c, threadData, tbPageTag);
        if (threadData.isGoods()) {
            c.param(TiebaStatic.Params.GUA_TYPE, 1);
        }
        if (z2) {
            c.param(TiebaStatic.Params.IS_OFFICIAL, threadData.getThreadAlaInfo().user_info.is_official);
        }
        if (z2 || threadData.isHeadLinePost || threadData.isSCard) {
            c.delete("thread_type");
            c.param("thread_type", threadData.getThreadType());
        }
        k(c, tbPageTag, true);
        ll8.g().c(bdUniqueId, c);
        j(threadData, i);
        p(threadData, tbPageTag, i);
    }

    public static void f(@NonNull PrivateForumPopInfoData privateForumPopInfoData, boolean z, @NonNull String str, @NonNull String str2, @NonNull boolean z2) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{privateForumPopInfoData, Boolean.valueOf(z), str, str2, Boolean.valueOf(z2)}) == null) {
            StatisticItem statisticItem = new StatisticItem();
            String C = privateForumPopInfoData.C();
            int hashCode = C.hashCode();
            if (hashCode != 1348979648) {
                if (hashCode == 1741969413 && C.equals("left_time")) {
                    c = 1;
                }
                c = 65535;
            } else {
                if (C.equals("create_success")) {
                    c = 0;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c == 1) {
                    if (z) {
                        if (z2) {
                            statisticItem.key("c14682");
                        } else {
                            statisticItem.key("c14681");
                        }
                    } else if (z2) {
                        statisticItem.key("c14680");
                    } else {
                        statisticItem.key("c14679");
                    }
                }
            } else if (z) {
                if (z2) {
                    statisticItem.key("c14678");
                } else {
                    statisticItem.key("c14677");
                }
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", str);
            statisticItem.param("fname", str2);
            statisticItem.eventStat();
        }
    }

    public static void g(ThreadData threadData, BdUniqueId bdUniqueId, TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, threadData, bdUniqueId, tbPageTag) == null) || threadData == null || bdUniqueId == null || !threadData.isHeadLinePost) {
            return;
        }
        boolean z = (threadData.getAuthor() == null || threadData.getAuthor().getUserId() == null || !threadData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (!threadData.isSmartFrsThread() || threadData.getFeedBackReasonMap() == null || z) {
            return;
        }
        StatisticItem param = new StatisticItem("common_exp").param("page_type", "a006").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 15).param("obj_id", threadData.getId()).param(TiebaStatic.Params.OBJ_FLOOR, threadData.statFloor).param("fid", threadData.getFid()).param("thread_type", threadData.getThreadType()).param("tid", threadData.getId()).param(TiebaStatic.Params.FIRST_DIR, threadData.getFirstClassName()).param(TiebaStatic.Params.SECOND_DIR, threadData.getSecondClassName());
        a(param, threadData, tbPageTag);
        String b = jl8.b(threadData.getTid(), "", "", threadData.getBaijiahaoData());
        ll8 g = ll8.g();
        g.d(bdUniqueId, b + "_15", param);
    }

    public static void h(BdUniqueId bdUniqueId, int i, ForumData forumData, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{bdUniqueId, Integer.valueOf(i), forumData, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || i <= 0) {
            return;
        }
        StatisticItem f = jl8.f("a006", "common_fill", true, i, i3);
        if (forumData != null) {
            if (!dj.isEmpty(forumData.getId())) {
                f.param("fid", forumData.getId());
            }
            if (!dj.isEmpty(forumData.getName())) {
                f.param("fname", forumData.getName());
            }
            if (!dj.isEmpty(forumData.getFirst_class())) {
                f.param(TiebaStatic.Params.FIRST_DIR, forumData.getFirst_class());
            }
            if (!dj.isEmpty(forumData.getSecond_class())) {
                f.param(TiebaStatic.Params.SECOND_DIR, forumData.getSecond_class());
            }
        }
        f.param(TiebaStatic.Params.LIST_ORDER, i2);
        ll8.g().c(bdUniqueId, f);
    }

    public static void i(BdUniqueId bdUniqueId, List<Cdo> list, ForumData forumData, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65544, null, bdUniqueId, list, forumData, i) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (list.get(i3) instanceof fn5) {
                i2++;
            }
            if (i2 <= 0) {
                return;
            }
            h(bdUniqueId, i2, forumData, i, 0);
        }
    }

    public static void j(ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, null, threadData, i) == null) {
            TiebaStatic.log(i != 2 ? null : jl8.k("c13692", threadData, 2));
        }
    }

    public static void k(StatisticItem statisticItem, TbPageTag tbPageTag, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65546, null, statisticItem, tbPageTag, z) == null) || statisticItem == null || tbPageTag == null) {
            return;
        }
        int i2 = 0;
        if ("a070".equals(tbPageTag.locatePage)) {
            i = 1;
        } else if ("a071".equals(tbPageTag.locatePage)) {
            i = 2;
        } else if ("a072".equals(tbPageTag.locatePage)) {
            i = 3;
        } else {
            int i3 = tbPageTag.tabId;
            if (502 == i3) {
                i = 5;
            } else {
                int i4 = tbPageTag.tabType;
                if (92 == i4 || 49 == i3 || 1120 == i3) {
                    i = 6;
                } else if (16 == i4) {
                    i = 7;
                } else if (3 == i4) {
                    i = 8;
                } else if (90 == i3) {
                    i = 9;
                } else if (505 == i3) {
                    i = 10;
                } else if (100 == i4) {
                    i = 11;
                } else {
                    i = tbPageTag.isGeneralTab == 1 ? 4 : 0;
                }
            }
        }
        if (z) {
            if (i > 0) {
                statisticItem.delete("obj_name");
                statisticItem.param("obj_name", i);
            }
        } else if (i > 0) {
            statisticItem.delete("obj_locate");
            statisticItem.param("obj_locate", i);
        }
        int i5 = tbPageTag.sortType;
        if (i5 == 1) {
            i2 = 3;
        } else if (i5 == 2) {
            i2 = 1;
        } else if (i5 == 3) {
            i2 = 2;
        } else if (i5 == 4) {
            i2 = 4;
        }
        if (i2 > 0) {
            if (i == 1 || i == 2) {
                statisticItem.delete(TiebaStatic.Params.LIST_ORDER);
                statisticItem.param(TiebaStatic.Params.LIST_ORDER, i2);
            }
        }
    }

    public static void l(ThreadData threadData, TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, threadData, tbPageTag) == null) || threadData == null) {
            return;
        }
        StatisticItem param = new StatisticItem("common_click").param("page_type", "a006").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 15).param("obj_id", threadData.getId()).param("fid", threadData.getFid()).param(TiebaStatic.Params.OBJ_FLOOR, threadData.statFloor).param("tid", threadData.getId()).param("thread_type", threadData.getThreadType()).param(TiebaStatic.Params.FIRST_DIR, threadData.getFirstClassName()).param(TiebaStatic.Params.SECOND_DIR, threadData.getSecondClassName()).param("nid", threadData.getNid()).param(TiebaStatic.Params.IS_ZP, threadData.isWorksInfo() ? 1 : 0);
        a(param, threadData, tbPageTag);
        TiebaStatic.log(param);
    }

    public static void m(ThreadData threadData, TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, threadData, tbPageTag) == null) || threadData == null || tbPageTag == null || !threadData.isTiebaPlusAdThread) {
            return;
        }
        int i = 2;
        if ("a071".equals(tbPageTag.locatePage)) {
            i = 3;
        } else if ("a072".equals(tbPageTag.locatePage)) {
            i = 5;
        } else if (tbPageTag.isGeneralTab == 1) {
            i = 4;
        }
        threadData.tiePlusFrsStaticLocate = i;
    }

    public static void n(ThreadData threadData, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, null, threadData, str) == null) || threadData == null) {
            return;
        }
        if (threadData.isTiebaPlusAdThread) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_EXPOSE);
            statisticItem.addParam("obj_locate", threadData.tiePlusFrsStaticLocate);
            if (threadData.isVideoWorksInfo()) {
                statisticItem.addParam("obj_type", 3);
            } else if (threadData.isVideoThreadType()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam("tid", threadData.getTid());
            statisticItem.addParam(TiebaStatic.Params.FID_1, threadData.getFid());
            statisticItem.addParam(TiebaStatic.Params.FID_2, str);
            statisticItem.addParam("order_id", threadData.tiebaPlusOrderId);
            TiebaStatic.log(statisticItem);
            vn4.a(vn4.d, vn4.b, threadData.tiebaPlusOrderId, threadData.tiebaPlusToken, threadData.tiebaPlusExtraParam, threadData.statFloor);
        }
        if (threadData.getRecomSource() != null && threadData.getRecomSource().startsWith("manual")) {
            vn4.a(vn4.k, vn4.b, threadData.tiebaPlusOrderId, threadData.tiebaPlusToken, threadData.tiebaPlusExtraParam, threadData.statFloor);
        }
        if (TextUtils.isEmpty(threadData.tiePlusMonitorShowUrl)) {
            return;
        }
        ThirdStatisticHelper.sendReq(threadData.tiePlusMonitorShowUrl);
    }

    public static void o(ThreadData threadData, BdUniqueId bdUniqueId, bs6 bs6Var, TbPageTag tbPageTag) {
        int i;
        String str;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65550, null, threadData, bdUniqueId, bs6Var, tbPageTag) == null) || threadData == null) {
            return;
        }
        String str2 = null;
        boolean z2 = (threadData.getThreadAlaInfo() == null || threadData.getThreadAlaInfo().user_info == null || threadData.getThreadAlaInfo().user_info.is_official != 2) ? false : true;
        boolean z3 = z2 && threadData.getThreadAlaInfo().frsLiveStageType == 0;
        if (z3) {
            str2 = String.valueOf(threadData.getThreadAlaInfo().live_id);
            i = 4;
        } else {
            i = 0;
        }
        if (!z3) {
            z3 = threadData.getThreadType() == 41;
            if (z3) {
                if (threadData.getTaskInfoData() != null) {
                    str2 = threadData.getTaskInfoData().f();
                }
                i = 2;
            }
        }
        if (threadData.isHeadLinePost) {
            str2 = threadData.getId();
            i = 14;
            z3 = true;
        }
        if (threadData.isSCard) {
            str = threadData.scardPacketId;
            z = true;
            i2 = 17;
        } else {
            str = str2;
            z = z3;
            i2 = i;
        }
        String str3 = str;
        StatisticItem d = jl8.d(threadData, "a006", "common_exp", threadData.statFloor, z, str, null, i2);
        if (d == null) {
            return;
        }
        hr6.a(d);
        d.param(TiebaStatic.Params.LIST_ORDER, cs6.k().l(bs6Var));
        if (threadData.isGoods()) {
            d.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (threadData.getItem() != null) {
            d.param(TiebaStatic.Params.GUA_TYPE, 2);
        } else if (hl5.t(threadData)) {
            d.param(TiebaStatic.Params.GUA_TYPE, 4);
        } else {
            d.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        a(d, threadData, tbPageTag);
        if (z2) {
            d.param(TiebaStatic.Params.IS_OFFICIAL, threadData.getThreadAlaInfo().user_info.is_official);
        }
        if (z2 || threadData.isHeadLinePost || threadData.isSCard) {
            d.delete("thread_type");
            d.param("thread_type", threadData.getThreadType());
        }
        k(d, tbPageTag, false);
        ll8.g().d(bdUniqueId, jl8.b(threadData.getTid(), str3, "", threadData.getBaijiahaoData()), d);
        if (threadData.isHeadLinePost) {
            g(threadData, bdUniqueId, tbPageTag);
        }
        q(threadData, tbPageTag);
    }

    public static void p(ThreadData threadData, TbPageTag tbPageTag, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65551, null, threadData, tbPageTag, i) == null) && threadData != null && 2 == i) {
            b(threadData, tbPageTag, CommonStatisticKey.KEY_YY_FRS_HEAD_SCULPTURE_CLICK);
        }
    }

    public static void q(ThreadData threadData, TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65552, null, threadData, tbPageTag) == null) || threadData == null) {
            return;
        }
        b(threadData, tbPageTag, CommonStatisticKey.KEY_YY_FRS_HEAD_SCULPTURE_SHOW);
    }
}
