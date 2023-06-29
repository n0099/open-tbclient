package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dx0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static r01 a(@NonNull BdVideoSeries bdVideoSeries, @NonNull BdVideo bdVideo, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            r01 r01Var = new r01();
            r01Var.k(str2);
            r01Var.l(q01.c(bdVideo.getCurrentLength()) + "/" + q01.c(bdVideo.getTotalLength()));
            r01Var.p(bdVideoSeries.getVid());
            r01Var.m(bdVideo.getType());
            r01Var.j(System.currentTimeMillis());
            r01Var.n(bdVideo.getTitle());
            r01Var.o(str);
            r01Var.r(bdVideoSeries.getPositionMs());
            r01Var.q(bdVideo.getCurrentLength());
            r01Var.s(bdVideo.getTotalLength());
            return r01Var;
        }
        return (r01) invokeLLLL.objValue;
    }
}
