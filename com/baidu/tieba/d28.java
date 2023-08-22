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
public class d28 {
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

    public static void b(w05 w05Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{w05Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) && w05Var != null && w05Var.getThreadData() != null && context != null) {
            ThreadData threadData = w05Var.getThreadData();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, ImageViewerConfig.FROM_GAME_VIDEO, 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
            createFromThreadCfg.setFrom("from_game_video");
            createFromThreadCfg.setForumName(threadData.getForum_name());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (w05Var.getPbInputLocate() != null) {
                createFromThreadCfg.addLocateParam(w05Var.getPbInputLocate());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && a(threadData)) {
                createFromThreadCfg.setNeedPreLoad(true);
                zg7.update(threadData);
            }
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
            createFromThreadCfg.setJumpGodReply(z);
            vn6.a(threadData.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public static void c(ro6 ro6Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65538, null, ro6Var, i) != null) || ro6Var == null) {
            return;
        }
        int i2 = 1;
        StatisticItem n = ro6Var.n("c13488", true);
        if (n != null) {
            if (ro6Var.getThreadData() != null) {
                ThreadData threadData = ro6Var.getThreadData();
                if (threadData.getTopAgreePost() == null || (threadData.getTopAgreePost().e0() == null && threadData.getTopAgreePost().w0() == null)) {
                    i2 = 0;
                }
                n.param("obj_name", i2);
                if (threadData.getAuthor() != null) {
                    n.param(TiebaStatic.Params.AB_TYPE, threadData.getAuthor().hadConcerned() ? 1 : 0);
                }
            }
            n.param("obj_type", i);
            TiebaStatic.log(n);
        }
    }

    public static void d(ro6 ro6Var, int i) {
        StatisticItem n;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65539, null, ro6Var, i) == null) && ro6Var != null && ro6Var.getThreadData() != null && ap6.L(ro6Var.a) && (n = ro6Var.n("c13494", true)) != null) {
            n.param("obj_type", i);
            TbSingleton.getInstance().setCurrentClickTime(System.currentTimeMillis());
            TiebaStatic.log(n);
        }
    }

    public static void e(ro6 ro6Var, int i) {
        StatisticItem n;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, ro6Var, i) == null) && ro6Var != null && ap6.L(ro6Var.a) && (n = ro6Var.n("c13495", true)) != null) {
            n.param("obj_type", i);
            TiebaStatic.log(n);
        }
    }

    public static void f(ro6 ro6Var, int i) {
        StatisticItem n;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65541, null, ro6Var, i) == null) && ro6Var != null && ro6Var.getThreadData() != null && (n = ro6Var.n("c13496", true)) != null) {
            n.param("obj_type", i);
            TiebaStatic.log(n);
        }
    }
}
