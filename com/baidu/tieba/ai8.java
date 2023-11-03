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
/* loaded from: classes5.dex */
public class ai8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(fm6 fm6Var, StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, fm6Var, statisticItem) == null) && fm6Var != null && fm6Var.getThreadData() != null && statisticItem != null) {
            if (fm6Var.getThreadData().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = fm6Var.getThreadData().getBaijiahaoData();
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

    public static void c(bw4 bw4Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{bw4Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) && bw4Var != null && bw4Var.getThreadData() != null && context != null) {
            ThreadData threadData = bw4Var.getThreadData();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, "video_tab", 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
            createFromThreadCfg.setFrom("from_video_tab");
            createFromThreadCfg.setForumName(threadData.getForum_name());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (bw4Var.getPbInputLocate() != null) {
                createFromThreadCfg.addLocateParam(bw4Var.getPbInputLocate());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && b(threadData)) {
                createFromThreadCfg.setNeedPreLoad(true);
                qp7.e(threadData);
            }
            createFromThreadCfg.setVideo_source("video_tab");
            createFromThreadCfg.setJumpGodReply(z);
            il6.a(threadData.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public static void d(fm6 fm6Var) {
        StatisticItem o;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, fm6Var) == null) && fm6Var != null && (o = fm6Var.o("c13583", true)) != null) {
            a(fm6Var, o);
            TiebaStatic.log(o);
        }
    }

    public static void e(fm6 fm6Var) {
        StatisticItem o;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fm6Var) == null) && fm6Var != null && (o = fm6Var.o("c13584", true)) != null) {
            a(fm6Var, o);
            o.param(TiebaStatic.Params.OBJ_FLOOR, fm6Var.position + 1);
            TiebaStatic.log(o);
        }
    }

    public static void f(fm6 fm6Var) {
        StatisticItem o;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, fm6Var) == null) && fm6Var != null && (o = fm6Var.o("c13585", true)) != null) {
            a(fm6Var, o);
            TiebaStatic.log(o);
        }
    }

    public static void g(fm6 fm6Var) {
        StatisticItem o;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, fm6Var) == null) && fm6Var != null && (o = fm6Var.o("c13586", true)) != null) {
            a(fm6Var, o);
            TiebaStatic.log(o);
        }
    }

    public static void h(fm6 fm6Var) {
        StatisticItem o;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, fm6Var) == null) && fm6Var != null && (o = fm6Var.o("c13587", true)) != null) {
            a(fm6Var, o);
            TiebaStatic.log(o);
        }
    }
}
