package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bx0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static p01 a(@NonNull BdVideoSeries bdVideoSeries, @NonNull BdVideo bdVideo, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            p01 p01Var = new p01();
            p01Var.k(str2);
            p01Var.l(o01.c(bdVideo.getCurrentLength()) + "/" + o01.c(bdVideo.getTotalLength()));
            p01Var.p(bdVideoSeries.getVid());
            p01Var.m(bdVideo.getType());
            p01Var.j(System.currentTimeMillis());
            p01Var.n(bdVideo.getTitle());
            p01Var.o(str);
            p01Var.r(bdVideoSeries.getPositionMs());
            p01Var.q(bdVideo.getCurrentLength());
            p01Var.s(bdVideo.getTotalLength());
            return p01Var;
        }
        return (p01) invokeLLLL.objValue;
    }
}
