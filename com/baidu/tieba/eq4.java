package com.baidu.tieba;

import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigdayImageLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.EmotionShareLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.FlutterLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.ImageLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.LocalFileDrawableLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.LocalFileImageLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.LocalFileImageLoaderProc2;
import com.baidu.tbadk.core.util.resourceLoaderProc.LocalPicDrawableLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.LocalVideoThumbLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.MemeLoaderProc2;
import com.baidu.tbadk.core.util.resourceLoaderProc.NinePatchLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.PortraitBlurLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.PortraitLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.SimpleBlurLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.SimpleForeverLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.SimpleForeverMemoryLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.SimpleLoaderProc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class eq4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            ah.h().o(10, new SimpleLoaderProc(true, true, false, 10));
            ah.h().o(11, new SimpleLoaderProc(false, true, false, 10));
            ah.h().o(42, new SimpleLoaderProc(true, false, false, 10));
            ah.h().o(13, new SimpleLoaderProc(true, true, false, 13));
            ah.h().o(14, new SimpleLoaderProc(false, true, false, 13));
            ah.h().o(17, new SimpleLoaderProc(true, true, false, 17));
            ah.h().o(18, new SimpleLoaderProc(false, true, false, 17));
            ah.h().o(39, new SimpleBlurLoaderProc(true, 39));
            ah.h().o(12, new PortraitLoaderProc(false, false, 12));
            ah.h().o(26, new PortraitLoaderProc(true, false, 26));
            ah.h().o(28, new PortraitLoaderProc(false, false, 26));
            ah.h().o(40, new PortraitBlurLoaderProc(false, false, 40));
            ah.h().o(19, new NinePatchLoaderProc(19));
            ah.h().o(24, new LocalPicDrawableLoaderProc(24));
            ah.h().o(25, new PortraitLoaderProc(false, true, 26));
            ah.h().o(27, new BigImageLoaderProc(27));
            ah.h().o(29, new SimpleForeverLoaderProc(true, 29));
            ah.h().o(32, new LocalFileDrawableLoaderProc(32));
            ah.h().o(23, new f05());
            ah.h().o(33, new MemeLoaderProc2());
            ah.h().o(34, new EmotionShareLoaderProc());
            ah.h().o(35, new LocalFileImageLoaderProc(160, 160));
            ah.h().o(36, new LocalFileImageLoaderProc());
            ah.h().o(43, new LocalFileImageLoaderProc2());
            ah.h().o(37, new LocalVideoThumbLoaderProc());
            ah.h().o(38, new ImageLoaderProc());
            ah.h().o(41, new BigdayImageLoaderProc());
            ah.h().o(44, new FlutterLoaderProc(true, 44, false));
            ah.h().o(15, new SimpleLoaderProc(false, true, true, 15));
            ah.h().o(16, new SimpleLoaderProc(false, true, true, 16));
            ah.h().o(21, new SimpleLoaderProc(false, true, true, 21));
            ah.h().o(30, new SimpleLoaderProc(true, true, false, 30));
            ah.h().o(31, new SimpleLoaderProc(false, true, false, 30));
            ah.h().o(45, new SimpleForeverMemoryLoaderProc(true, true, true, 45));
            ah.h().o(46, new SimpleLoaderProc(true, true, false, 46));
            ah.h().o(47, new SimpleLoaderProc(false, true, false, 46));
        }
    }
}
