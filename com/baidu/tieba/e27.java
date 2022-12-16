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
/* loaded from: classes4.dex */
public class e27 {
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

    public static void b(vr4 vr4Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{vr4Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) && vr4Var != null && vr4Var.getThreadData() != null && context != null) {
            ThreadData threadData = vr4Var.getThreadData();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, ImageViewerConfig.FROM_GAME_VIDEO, 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
            createFromThreadCfg.setFrom("from_game_video");
            createFromThreadCfg.setForumName(threadData.getForum_name());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (vr4Var.getPbInputLocate() != null) {
                createFromThreadCfg.addLocateParam(vr4Var.getPbInputLocate());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && a(threadData)) {
                createFromThreadCfg.setNeedPreLoad(true);
                dk6.update(threadData);
            }
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
            createFromThreadCfg.setJumpGodReply(z);
            s46.a(threadData.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public static void c(o56 o56Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65538, null, o56Var, i) != null) || o56Var == null) {
            return;
        }
        int i2 = 1;
        StatisticItem r = o56Var.r("c13488", true);
        if (r != null) {
            if (o56Var.getThreadData() != null) {
                ThreadData threadData = o56Var.getThreadData();
                if (threadData.getTopAgreePost() == null || (threadData.getTopAgreePost().X() == null && threadData.getTopAgreePost().o0() == null)) {
                    i2 = 0;
                }
                r.param("obj_name", i2);
                if (threadData.getAuthor() != null) {
                    r.param(TiebaStatic.Params.AB_TYPE, threadData.getAuthor().hadConcerned() ? 1 : 0);
                }
            }
            r.param("obj_type", i);
            TiebaStatic.log(r);
        }
    }

    public static void d(o56 o56Var, int i) {
        StatisticItem r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65539, null, o56Var, i) == null) && o56Var != null && o56Var.getThreadData() != null && x56.R(o56Var.a) && (r = o56Var.r("c13494", true)) != null) {
            r.param("obj_type", i);
            TbSingleton.getInstance().setCurrentClickTime(System.currentTimeMillis());
            TiebaStatic.log(r);
        }
    }

    public static void e(o56 o56Var, int i) {
        StatisticItem r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, o56Var, i) == null) && o56Var != null && x56.R(o56Var.a) && (r = o56Var.r("c13495", true)) != null) {
            r.param("obj_type", i);
            TiebaStatic.log(r);
        }
    }

    public static void f(o56 o56Var, int i) {
        StatisticItem r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65541, null, o56Var, i) == null) && o56Var != null && o56Var.getThreadData() != null && (r = o56Var.r("c13496", true)) != null) {
            r.param("obj_type", i);
            TiebaStatic.log(r);
        }
    }
}
