package com.baidu.tieba;

import com.baidu.searchbox.fluency.BdTracesManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.mutiprocess.fps.ImageFpsEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class fr5 implements qq5<ImageFpsEvent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fr5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qq5
    /* renamed from: a */
    public boolean onEvent(ImageFpsEvent imageFpsEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageFpsEvent)) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                return false;
            }
            BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(ImageViewerConfig.KEY_FPS_IMAGE);
            return true;
        }
        return invokeL.booleanValue;
    }
}
