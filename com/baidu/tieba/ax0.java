package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ax0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static o01 a(@NonNull BdVideoSeries bdVideoSeries, @NonNull BdVideo bdVideo, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            o01 o01Var = new o01();
            o01Var.k(str2);
            o01Var.l(n01.c(bdVideo.getCurrentLength()) + "/" + n01.c(bdVideo.getTotalLength()));
            o01Var.p(bdVideoSeries.getVid());
            o01Var.m(bdVideo.getType());
            o01Var.j(System.currentTimeMillis());
            o01Var.n(bdVideo.getTitle());
            o01Var.o(str);
            o01Var.r(bdVideoSeries.getPositionMs());
            o01Var.q(bdVideo.getCurrentLength());
            o01Var.s(bdVideo.getTotalLength());
            return o01Var;
        }
        return (o01) invokeLLLL.objValue;
    }
}
