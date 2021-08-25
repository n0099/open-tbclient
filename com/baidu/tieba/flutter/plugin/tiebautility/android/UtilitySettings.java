package com.baidu.tieba.flutter.plugin.tiebautility.android;

import c.a.p0.s.l.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilitySettingsAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class UtilitySettings implements TiebaUtilitySettingsAuto.HostUtilitySettings {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public UtilitySettings() {
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

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilitySettingsAuto.HostUtilitySettings
    public void getMyPrivateStat(TiebaUtilitySettingsAuto.GetPrivateStatParam getPrivateStatParam, TiebaUtilitySettingsAuto.Result<TiebaUtilitySettingsAuto.PrivateStatResult> result) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, getPrivateStatParam, result) == null) || getPrivateStatParam.getType() == null) {
            return;
        }
        TiebaUtilitySettingsAuto.PrivateStatResult privateStatResult = new TiebaUtilitySettingsAuto.PrivateStatResult();
        privateStatResult.setResult(Long.valueOf(f.a(getPrivateStatParam.getType().intValue())));
        result.success(privateStatResult);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilitySettingsAuto.HostUtilitySettings
    public void getUserBigPhotoHost(TiebaUtilitySettingsAuto.Result<TiebaUtilitySettingsAuto.PhotoHostResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, result) == null) {
            TiebaUtilitySettingsAuto.PhotoHostResult photoHostResult = new TiebaUtilitySettingsAuto.PhotoHostResult();
            photoHostResult.setResult(TbConfig.getBigPhotoAdress());
            result.success(photoHostResult);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilitySettingsAuto.HostUtilitySettings
    public void getUserSmallPhotoHost(TiebaUtilitySettingsAuto.Result<TiebaUtilitySettingsAuto.PhotoHostResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, result) == null) {
            TiebaUtilitySettingsAuto.PhotoHostResult photoHostResult = new TiebaUtilitySettingsAuto.PhotoHostResult();
            photoHostResult.setResult(TbConfig.getPhotoSmallAddress());
            result.success(photoHostResult);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilitySettingsAuto.HostUtilitySettings
    public void setMyPrivateStat(TiebaUtilitySettingsAuto.SetPrivateStatParam setPrivateStatParam, TiebaUtilitySettingsAuto.Result<TiebaUtilitySettingsAuto.PrivateStatResult> result) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, setPrivateStatParam, result) == null) || setPrivateStatParam.getType() == null || setPrivateStatParam.getStat() == null) {
            return;
        }
        f.c(setPrivateStatParam.getType().intValue(), setPrivateStatParam.getStat().intValue());
    }
}
