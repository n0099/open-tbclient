package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class av0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static oy0 a(@NonNull BdVideoSeries bdVideoSeries, @NonNull BdVideo bdVideo, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            oy0 oy0Var = new oy0();
            oy0Var.k(str2);
            oy0Var.l(ny0.c(bdVideo.getCurrentLength()) + "/" + ny0.c(bdVideo.getTotalLength()));
            oy0Var.p(bdVideoSeries.getVid());
            oy0Var.m(bdVideo.getType());
            oy0Var.j(System.currentTimeMillis());
            oy0Var.n(bdVideo.getTitle());
            oy0Var.o(str);
            oy0Var.r(bdVideoSeries.getPositionMs());
            oy0Var.q(bdVideo.getCurrentLength());
            oy0Var.s(bdVideo.getTotalLength());
            return oy0Var;
        }
        return (oy0) invokeLLLL.objValue;
    }
}
