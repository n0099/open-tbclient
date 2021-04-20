package com.baidu.tieba.flutter.plugin.tiebaUtility.android;

import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityAppInfoAuto;
import d.b.h0.s.c.n;
import d.b.h0.z0.n0;
/* loaded from: classes4.dex */
public class UtilityAppInfo implements TiebaUtilityAppInfoAuto.HostUtilityAppInfo {
    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityAppInfoAuto.HostUtilityAppInfo
    public void getAppVersion(TiebaUtilityAppInfoAuto.Result<TiebaUtilityAppInfoAuto.AppInfoStringResult> result) {
        TiebaUtilityAppInfoAuto.AppInfoStringResult appInfoStringResult = new TiebaUtilityAppInfoAuto.AppInfoStringResult();
        appInfoStringResult.setResult(TbConfig.getVersion());
        result.success(appInfoStringResult);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityAppInfoAuto.HostUtilityAppInfo
    public void getChannelTabInfo(TiebaUtilityAppInfoAuto.Result<TiebaUtilityAppInfoAuto.ChannelTab> result) {
        TiebaUtilityAppInfoAuto.ChannelTab channelTab = new TiebaUtilityAppInfoAuto.ChannelTab();
        n c2 = TbSingleton.getInstance().getChannelConfigModel().c();
        if (c2 != null) {
            if (!TextUtils.isEmpty(c2.e())) {
                channelTab.setTid(c2.e());
            }
            if (!TextUtils.isEmpty(c2.d())) {
                channelTab.setTabCode(c2.d());
            }
            channelTab.setTabType(String.valueOf(c2.a()));
        }
        result.success(channelTab);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityAppInfoAuto.HostUtilityAppInfo
    public void getWebViewUserAgent(TiebaUtilityAppInfoAuto.Result<TiebaUtilityAppInfoAuto.AppInfoStringResult> result) {
        TiebaUtilityAppInfoAuto.AppInfoStringResult appInfoStringResult = new TiebaUtilityAppInfoAuto.AppInfoStringResult();
        appInfoStringResult.setResult(n0.b());
        result.success(appInfoStringResult);
    }
}
