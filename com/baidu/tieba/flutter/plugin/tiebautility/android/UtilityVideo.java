package com.baidu.tieba.flutter.plugin.tiebautility.android;

import androidx.core.view.InputDeviceCompat;
import c.a.o0.b1.r0;
import c.a.p0.o2.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityVideoAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class UtilityVideo implements TiebaUtilityVideoAuto.HostUtilityVideo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public UtilityVideo() {
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

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityVideoAuto.HostUtilityVideo
    public void getResumeTimeForVideo(TiebaUtilityVideoAuto.VideoStringParam videoStringParam, TiebaUtilityVideoAuto.Result<TiebaUtilityVideoAuto.ResumeTimeResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, videoStringParam, result) == null) {
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityVideoAuto.HostUtilityVideo
    public void getVideoMute(TiebaUtilityVideoAuto.Result<TiebaUtilityVideoAuto.VideoBoolValue> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, result) == null) {
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityVideoAuto.HostUtilityVideo
    public void isVideoCardMute(TiebaUtilityVideoAuto.Result<TiebaUtilityVideoAuto.VideoBoolValue> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, result) == null) {
            TiebaUtilityVideoAuto.VideoBoolValue videoBoolValue = new TiebaUtilityVideoAuto.VideoBoolValue();
            videoBoolValue.setResult(Boolean.valueOf(TbSingleton.getInstance().isVideoCardMute()));
            result.success(videoBoolValue);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityVideoAuto.HostUtilityVideo
    public void setVideoCardMute(TiebaUtilityVideoAuto.VideoBoolValue videoBoolValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, videoBoolValue) == null) {
            boolean booleanValue = videoBoolValue.getResult().booleanValue();
            TbSingleton.getInstance().setVideoCardMute(booleanValue);
            r0.e(new WeakReference(TbadkCoreApplication.getInst()), !booleanValue);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityVideoAuto.HostUtilityVideo
    public void setVideoMute(TiebaUtilityVideoAuto.VideoBoolValue videoBoolValue, TiebaUtilityVideoAuto.Result<TiebaUtilityVideoAuto.VideoBoolValue> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, videoBoolValue, result) == null) {
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityVideoAuto.HostUtilityVideo
    public void updateTime(TiebaUtilityVideoAuto.VideoTimeParam videoTimeParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, videoTimeParam) == null) {
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityVideoAuto.HostUtilityVideo
    public void videoPositionCacheManagerGetCachePosition(TiebaUtilityVideoAuto.VideoStringParam videoStringParam, TiebaUtilityVideoAuto.Result<TiebaUtilityVideoAuto.CachePosition> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, videoStringParam, result) == null) {
            int c2 = n.d().c(videoStringParam.getResult());
            TiebaUtilityVideoAuto.CachePosition cachePosition = new TiebaUtilityVideoAuto.CachePosition();
            cachePosition.setResult(Long.valueOf(c2));
            result.success(cachePosition);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityVideoAuto.HostUtilityVideo
    public void videoPositionCacheManagerRemove(TiebaUtilityVideoAuto.VideoStringParam videoStringParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, videoStringParam) == null) {
            n.d().e(videoStringParam.getResult());
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityVideoAuto.HostUtilityVideo
    public void videoPositionCacheManagerUpdate(TiebaUtilityVideoAuto.VideoTimeParam videoTimeParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, videoTimeParam) == null) {
            n.d().f(videoTimeParam.getVideoUrl(), videoTimeParam.getDurtion() != null ? videoTimeParam.getDurtion().intValue() : 0);
        }
    }
}
