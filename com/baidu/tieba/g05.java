package com.baidu.tieba;

import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigdayImageLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.EmotionShareLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.FixedNinePatchLoaderProc;
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
/* loaded from: classes6.dex */
public class g05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            BdResourceLoader.getInstance().registerLoaderProc(10, new SimpleLoaderProc(true, true, false, 10));
            BdResourceLoader.getInstance().registerLoaderProc(11, new SimpleLoaderProc(false, true, false, 10));
            BdResourceLoader.getInstance().registerLoaderProc(42, new SimpleLoaderProc(true, false, false, 10));
            BdResourceLoader.getInstance().registerLoaderProc(13, new SimpleLoaderProc(true, true, false, 13));
            BdResourceLoader.getInstance().registerLoaderProc(14, new SimpleLoaderProc(false, true, false, 13));
            BdResourceLoader.getInstance().registerLoaderProc(17, new SimpleLoaderProc(true, true, false, 17));
            BdResourceLoader.getInstance().registerLoaderProc(18, new SimpleLoaderProc(false, true, false, 17));
            BdResourceLoader.getInstance().registerLoaderProc(39, new SimpleBlurLoaderProc(true, 39));
            BdResourceLoader.getInstance().registerLoaderProc(12, new PortraitLoaderProc(false, false, 12));
            BdResourceLoader.getInstance().registerLoaderProc(26, new PortraitLoaderProc(true, false, 26));
            BdResourceLoader.getInstance().registerLoaderProc(28, new PortraitLoaderProc(false, false, 26));
            BdResourceLoader.getInstance().registerLoaderProc(40, new PortraitBlurLoaderProc(false, false, 40));
            BdResourceLoader.getInstance().registerLoaderProc(19, new NinePatchLoaderProc(19));
            BdResourceLoader.getInstance().registerLoaderProc(59, new FixedNinePatchLoaderProc(59));
            BdResourceLoader.getInstance().registerLoaderProc(24, new LocalPicDrawableLoaderProc(24));
            BdResourceLoader.getInstance().registerLoaderProc(25, new PortraitLoaderProc(false, true, 26));
            BdResourceLoader.getInstance().registerLoaderProc(27, new BigImageLoaderProc(27));
            BdResourceLoader.getInstance().registerLoaderProc(29, new SimpleForeverLoaderProc(true, 29));
            BdResourceLoader.getInstance().registerLoaderProc(32, new LocalFileDrawableLoaderProc(32));
            BdResourceLoader.getInstance().registerLoaderProc(23, new zb5());
            BdResourceLoader.getInstance().registerLoaderProc(33, new MemeLoaderProc2());
            BdResourceLoader.getInstance().registerLoaderProc(34, new EmotionShareLoaderProc());
            BdResourceLoader.getInstance().registerLoaderProc(35, new LocalFileImageLoaderProc(160, 160));
            BdResourceLoader.getInstance().registerLoaderProc(36, new LocalFileImageLoaderProc());
            BdResourceLoader.getInstance().registerLoaderProc(43, new LocalFileImageLoaderProc2());
            BdResourceLoader.getInstance().registerLoaderProc(37, new LocalVideoThumbLoaderProc());
            BdResourceLoader.getInstance().registerLoaderProc(38, new ImageLoaderProc());
            BdResourceLoader.getInstance().registerLoaderProc(41, new BigdayImageLoaderProc());
            BdResourceLoader.getInstance().registerLoaderProc(44, new FlutterLoaderProc(true, 44, false));
            BdResourceLoader.getInstance().registerLoaderProc(15, new SimpleLoaderProc(false, true, true, 15));
            BdResourceLoader.getInstance().registerLoaderProc(16, new SimpleLoaderProc(false, true, true, 16));
            BdResourceLoader.getInstance().registerLoaderProc(21, new SimpleLoaderProc(false, true, true, 21));
            BdResourceLoader.getInstance().registerLoaderProc(30, new SimpleLoaderProc(true, true, false, 30));
            BdResourceLoader.getInstance().registerLoaderProc(31, new SimpleLoaderProc(false, true, false, 30));
            BdResourceLoader.getInstance().registerLoaderProc(45, new SimpleForeverMemoryLoaderProc(true, true, true, 45));
            BdResourceLoader.getInstance().registerLoaderProc(46, new SimpleLoaderProc(true, true, false, 46));
            BdResourceLoader.getInstance().registerLoaderProc(47, new SimpleLoaderProc(false, true, false, 46));
        }
    }
}
