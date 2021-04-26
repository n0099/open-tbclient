package com.baidu.tieba.flutter.plugin.tiebaUtility.android;

import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilitySettingsAuto;
import d.a.i0.r.l.f;
/* loaded from: classes4.dex */
public class UtilitySettings implements TiebaUtilitySettingsAuto.HostUtilitySettings {
    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilitySettingsAuto.HostUtilitySettings
    public void getMyPrivateStat(TiebaUtilitySettingsAuto.GetPrivateStatParam getPrivateStatParam, TiebaUtilitySettingsAuto.Result<TiebaUtilitySettingsAuto.PrivateStatResult> result) {
        if (getPrivateStatParam.getType() == null) {
            return;
        }
        TiebaUtilitySettingsAuto.PrivateStatResult privateStatResult = new TiebaUtilitySettingsAuto.PrivateStatResult();
        privateStatResult.setResult(Long.valueOf(f.a(getPrivateStatParam.getType().intValue())));
        result.success(privateStatResult);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilitySettingsAuto.HostUtilitySettings
    public void getUserBigPhotoHost(TiebaUtilitySettingsAuto.Result<TiebaUtilitySettingsAuto.PhotoHostResult> result) {
        TiebaUtilitySettingsAuto.PhotoHostResult photoHostResult = new TiebaUtilitySettingsAuto.PhotoHostResult();
        photoHostResult.setResult(TbConfig.getBigPhotoAdress());
        result.success(photoHostResult);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilitySettingsAuto.HostUtilitySettings
    public void getUserSmallPhotoHost(TiebaUtilitySettingsAuto.Result<TiebaUtilitySettingsAuto.PhotoHostResult> result) {
        TiebaUtilitySettingsAuto.PhotoHostResult photoHostResult = new TiebaUtilitySettingsAuto.PhotoHostResult();
        photoHostResult.setResult(TbConfig.getPhotoSmallAddress());
        result.success(photoHostResult);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilitySettingsAuto.HostUtilitySettings
    public void setMyPrivateStat(TiebaUtilitySettingsAuto.SetPrivateStatParam setPrivateStatParam, TiebaUtilitySettingsAuto.Result<TiebaUtilitySettingsAuto.PrivateStatResult> result) {
        if (setPrivateStatParam.getType() == null || setPrivateStatParam.getStat() == null) {
            return;
        }
        f.c(setPrivateStatParam.getType().intValue(), setPrivateStatParam.getStat().intValue());
    }
}
