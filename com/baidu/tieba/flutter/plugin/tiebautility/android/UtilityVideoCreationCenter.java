package com.baidu.tieba.flutter.plugin.tiebautility.android;

import c.a.q0.s.m.b;
import c.a.r0.d4.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
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
            b.e(videoCreationCenterSendParams.getObjLocate(), videoCreationCenterSendParams.getPageId(), videoCreationCenterSendParams.getTopicName(), videoCreationCenterSendParams.getTopicId());
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityVideoCreationCenterAuto.HostUtilityVideoCreationCenter
    public void showGuide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int b2 = i.b();
            if (i.d(b2)) {
                i.f(TbadkApplication.getInst().getCurrentActivity(), b2, 6);
            }
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityVideoCreationCenterAuto.HostUtilityVideoCreationCenter
    public void updateStatus(TiebaUtilityVideoCreationCenterAuto.VideoCreationCenterBoolValue videoCreationCenterBoolValue) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, videoCreationCenterBoolValue) == null) && videoCreationCenterBoolValue.getResult().booleanValue()) {
            c.a.q0.s.d0.b.j().v("key_work_video_guide_pop", 0);
        }
    }
}
