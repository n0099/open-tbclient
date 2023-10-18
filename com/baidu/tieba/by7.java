package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class by7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, threadData)) == null) {
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

    public static void b(jv4 jv4Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{jv4Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) && jv4Var != null && jv4Var.getThreadData() != null && context != null) {
            ThreadData threadData = jv4Var.getThreadData();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, ImageViewerConfig.FROM_GAME_VIDEO, 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
            createFromThreadCfg.setFrom("from_game_video");
            createFromThreadCfg.setForumName(threadData.getForum_name());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (jv4Var.getPbInputLocate() != null) {
                createFromThreadCfg.addLocateParam(jv4Var.getPbInputLocate());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && a(threadData)) {
                createFromThreadCfg.setNeedPreLoad(true);
                zc7.e(threadData);
            }
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
            createFromThreadCfg.setJumpGodReply(z);
            mj6.a(threadData.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public static void c(jk6 jk6Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65538, null, jk6Var, i) != null) || jk6Var == null) {
            return;
        }
        int i2 = 1;
        StatisticItem o = jk6Var.o("c13488", true);
        if (o != null) {
            if (jk6Var.getThreadData() != null) {
                ThreadData threadData = jk6Var.getThreadData();
                if (threadData.getTopAgreePost() == null || (threadData.getTopAgreePost().f0() == null && threadData.getTopAgreePost().x0() == null)) {
                    i2 = 0;
                }
                o.param("obj_name", i2);
                if (threadData.getAuthor() != null) {
                    o.param(TiebaStatic.Params.AB_TYPE, threadData.getAuthor().hadConcerned() ? 1 : 0);
                }
            }
            o.param("obj_type", i);
            TiebaStatic.log(o);
        }
    }

    public static void d(jk6 jk6Var, int i) {
        StatisticItem o;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65539, null, jk6Var, i) == null) && jk6Var != null && jk6Var.getThreadData() != null && sk6.L(jk6Var.a) && (o = jk6Var.o("c13494", true)) != null) {
            o.param("obj_type", i);
            TbSingleton.getInstance().setCurrentClickTime(System.currentTimeMillis());
            TiebaStatic.log(o);
        }
    }

    public static void e(jk6 jk6Var, int i) {
        StatisticItem o;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, jk6Var, i) == null) && jk6Var != null && sk6.L(jk6Var.a) && (o = jk6Var.o("c13495", true)) != null) {
            o.param("obj_type", i);
            TiebaStatic.log(o);
        }
    }

    public static void f(jk6 jk6Var, int i) {
        StatisticItem o;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65541, null, jk6Var, i) == null) && jk6Var != null && jk6Var.getThreadData() != null && (o = jk6Var.o("c13496", true)) != null) {
            o.param("obj_type", i);
            TiebaStatic.log(o);
        }
    }
}
