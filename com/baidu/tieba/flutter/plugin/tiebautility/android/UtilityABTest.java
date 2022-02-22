package com.baidu.tieba.flutter.plugin.tiebautility.android;

import c.a.t0.b.c;
import com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityAbtestAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class UtilityABTest implements TiebaUtilityAbtestAuto.HostUtilityABTest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public UtilityABTest() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityAbtestAuto.HostUtilityABTest
    public void experimentTypeForBarEntry(TiebaUtilityAbtestAuto.Result<TiebaUtilityAbtestAuto.ExperimentType> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, result) == null) {
            TiebaUtilityAbtestAuto.ExperimentType experimentType = new TiebaUtilityAbtestAuto.ExperimentType();
            if (c.d().b("11_8_forum_guide_b") != null) {
                experimentType.setResult(2L);
            } else if (c.d().b("11_8_forum_guide_a") != null) {
                experimentType.setResult(1L);
            } else {
                experimentType.setResult(1L);
            }
            result.success(experimentType);
        }
    }
}
