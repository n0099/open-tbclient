package com.baidu.tieba.flutter.plugin.tiebautility.android;

import c.a.o0.s.m.b;
import com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityVideoCreationCenterAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class UtilityVideoCreationCenter implements TiebaUtilityVideoCreationCenterAuto.HostUtilityVideoCreationCenter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public UtilityVideoCreationCenter() {
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

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityVideoCreationCenterAuto.HostUtilityVideoCreationCenter
    public void sendThread(TiebaUtilityVideoCreationCenterAuto.VideoCreationCenterSendParams videoCreationCenterSendParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, videoCreationCenterSendParams) == null) {
            b.g(videoCreationCenterSendParams.getObjLocate());
        }
    }
}
