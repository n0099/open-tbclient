package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static uz0 a(@NonNull BdVideoSeries bdVideoSeries, @NonNull BdVideo bdVideo, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            uz0 uz0Var = new uz0();
            uz0Var.k(str2);
            uz0Var.l(tz0.c(bdVideo.getCurrentLength()) + "/" + tz0.c(bdVideo.getTotalLength()));
            uz0Var.p(bdVideoSeries.getVid());
            uz0Var.m(bdVideo.getType());
            uz0Var.j(System.currentTimeMillis());
            uz0Var.n(bdVideo.getTitle());
            uz0Var.o(str);
            uz0Var.r(bdVideoSeries.getPositionMs());
            uz0Var.q(bdVideo.getCurrentLength());
            uz0Var.s(bdVideo.getTotalLength());
            return uz0Var;
        }
        return (uz0) invokeLLLL.objValue;
    }
}
