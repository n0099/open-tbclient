package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class aw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static oz0 a(@NonNull BdVideoSeries bdVideoSeries, @NonNull BdVideo bdVideo, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            oz0 oz0Var = new oz0();
            oz0Var.k(str2);
            oz0Var.l(nz0.c(bdVideo.getCurrentLength()) + "/" + nz0.c(bdVideo.getTotalLength()));
            oz0Var.p(bdVideoSeries.getVid());
            oz0Var.m(bdVideo.getType());
            oz0Var.j(System.currentTimeMillis());
            oz0Var.n(bdVideo.getTitle());
            oz0Var.o(str);
            oz0Var.r(bdVideoSeries.getPositionMs());
            oz0Var.q(bdVideo.getCurrentLength());
            oz0Var.s(bdVideo.getTotalLength());
            return oz0Var;
        }
        return (oz0) invokeLLLL.objValue;
    }
}
