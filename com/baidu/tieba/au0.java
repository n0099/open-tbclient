package com.baidu.tieba;

import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class au0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ox0 a(BdVideoSeries bdVideoSeries, BdVideo bdVideo, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            ox0 ox0Var = new ox0();
            ox0Var.k(str2);
            ox0Var.l(nx0.c(bdVideo.getCurrentLength()) + "/" + nx0.c(bdVideo.getTotalLength()));
            ox0Var.p(bdVideoSeries.getVid());
            ox0Var.m(bdVideo.getType());
            ox0Var.j(System.currentTimeMillis());
            ox0Var.n(bdVideo.getTitle());
            ox0Var.o(str);
            ox0Var.r(bdVideoSeries.getPositionMs());
            ox0Var.q(bdVideo.getCurrentLength());
            ox0Var.s(bdVideo.getTotalLength());
            return ox0Var;
        }
        return (ox0) invokeLLLL.objValue;
    }
}
