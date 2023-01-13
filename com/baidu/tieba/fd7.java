package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fd7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(g96 g96Var, StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, g96Var, statisticItem) == null) && g96Var != null && g96Var.getThreadData() != null && statisticItem != null) {
            if (g96Var.getThreadData().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = g96Var.getThreadData().getBaijiahaoData();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData.oriUgcNid);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, baijiahaoData.oriUgcVid);
                return;
            }
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
        }
    }

    public static boolean b(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, threadData)) == null) {
            if (threadData == null || threadData.isShareThread) {
                return false;
            }
            int i = threadData.threadType;
            if (i != 0 && i != 11 && i != 40 && !threadData.isUgcThreadType()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void c(fs4 fs4Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{fs4Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) && fs4Var != null && fs4Var.getThreadData() != null && context != null) {
            ThreadData threadData = fs4Var.getThreadData();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, "video_tab", 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
            createFromThreadCfg.setFrom("from_video_tab");
            createFromThreadCfg.setForumName(threadData.getForum_name());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (fs4Var.getPbInputLocate() != null) {
                createFromThreadCfg.addLocateParam(fs4Var.getPbInputLocate());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && b(threadData)) {
                createFromThreadCfg.setNeedPreLoad(true);
                qn6.update(threadData);
            }
            createFromThreadCfg.setVideo_source("video_tab");
            createFromThreadCfg.setJumpGodReply(z);
            l86.a(threadData.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public static void d(g96 g96Var) {
        StatisticItem r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, g96Var) == null) && g96Var != null && (r = g96Var.r("c13583", true)) != null) {
            a(g96Var, r);
            TiebaStatic.log(r);
        }
    }

    public static void e(g96 g96Var) {
        StatisticItem r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, g96Var) == null) && g96Var != null && (r = g96Var.r("c13584", true)) != null) {
            a(g96Var, r);
            r.param(TiebaStatic.Params.OBJ_FLOOR, g96Var.position + 1);
            TiebaStatic.log(r);
        }
    }

    public static void f(g96 g96Var) {
        StatisticItem r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, g96Var) == null) && g96Var != null && (r = g96Var.r("c13585", true)) != null) {
            a(g96Var, r);
            TiebaStatic.log(r);
        }
    }

    public static void g(g96 g96Var) {
        StatisticItem r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, g96Var) == null) && g96Var != null && (r = g96Var.r("c13586", true)) != null) {
            a(g96Var, r);
            TiebaStatic.log(r);
        }
    }

    public static void h(g96 g96Var) {
        StatisticItem r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, g96Var) == null) && g96Var != null && (r = g96Var.r("c13587", true)) != null) {
            a(g96Var, r);
            TiebaStatic.log(r);
        }
    }
}
