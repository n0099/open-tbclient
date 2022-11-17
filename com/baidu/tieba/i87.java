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
public class i87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(t46 t46Var, StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, t46Var, statisticItem) == null) && t46Var != null && t46Var.getThreadData() != null && statisticItem != null) {
            if (t46Var.getThreadData().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = t46Var.getThreadData().getBaijiahaoData();
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

    public static void c(tr4 tr4Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{tr4Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) && tr4Var != null && tr4Var.getThreadData() != null && context != null) {
            ThreadData threadData = tr4Var.getThreadData();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, "video_tab", 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
            createFromThreadCfg.setFrom("from_video_tab");
            createFromThreadCfg.setForumName(threadData.getForum_name());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (tr4Var.getPbInputLocate() != null) {
                createFromThreadCfg.addLocateParam(tr4Var.getPbInputLocate());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && b(threadData)) {
                createFromThreadCfg.setNeedPreLoad(true);
                ij6.update(threadData);
            }
            createFromThreadCfg.setVideo_source("video_tab");
            createFromThreadCfg.setJumpGodReply(z);
            x36.a(threadData.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public static void d(t46 t46Var) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, t46Var) == null) && t46Var != null && (w = t46Var.w("c13583", true)) != null) {
            a(t46Var, w);
            TiebaStatic.log(w);
        }
    }

    public static void e(t46 t46Var) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t46Var) == null) && t46Var != null && (w = t46Var.w("c13584", true)) != null) {
            a(t46Var, w);
            w.param(TiebaStatic.Params.OBJ_FLOOR, t46Var.position + 1);
            TiebaStatic.log(w);
        }
    }

    public static void f(t46 t46Var) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, t46Var) == null) && t46Var != null && (w = t46Var.w("c13585", true)) != null) {
            a(t46Var, w);
            TiebaStatic.log(w);
        }
    }

    public static void g(t46 t46Var) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, t46Var) == null) && t46Var != null && (w = t46Var.w("c13586", true)) != null) {
            a(t46Var, w);
            TiebaStatic.log(w);
        }
    }

    public static void h(t46 t46Var) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, t46Var) == null) && t46Var != null && (w = t46Var.w("c13587", true)) != null) {
            a(t46Var, w);
            TiebaStatic.log(w);
        }
    }
}
