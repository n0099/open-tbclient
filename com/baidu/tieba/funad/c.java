package com.baidu.tieba.funad;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.fun.ad.sdk.ChannelNativeAds_5;
import com.fun.ad.sdk.FunNativeAd;
/* loaded from: classes5.dex */
public class c {
    public static boolean a(FunNativeAd funNativeAd) {
        ChannelNativeAds_5 channelNativeAds_5;
        return (funNativeAd == null || (channelNativeAds_5 = funNativeAd.getChannelNativeAds_5()) == null || channelNativeAds_5.gdtNative != null || channelNativeAds_5.csjNative != null || channelNativeAds_5.ksNative == null || TextUtils.isEmpty(channelNativeAds_5.ksNative.getAppIconUrl())) ? false : true;
    }

    public static int b(FunNativeAd funNativeAd) {
        ChannelNativeAds_5 channelNativeAds_5;
        if (funNativeAd == null || (channelNativeAds_5 = funNativeAd.getChannelNativeAds_5()) == null) {
            return -1;
        }
        if (channelNativeAds_5.gdtNative != null) {
            return R.drawable.icon_mask_advertisement_guangdiantong_12;
        }
        if (channelNativeAds_5.ksNative != null) {
            return R.drawable.icon_mask_advertisement_kuaishou_12;
        }
        if (channelNativeAds_5.csjNative != null) {
            return R.drawable.icon_mask_advertisement_chuanshanjia_12;
        }
        return -1;
    }

    public static boolean c(FunNativeAd funNativeAd) {
        boolean z = true;
        if (funNativeAd == null) {
            return false;
        }
        ChannelNativeAds_5 channelNativeAds_5 = funNativeAd.getChannelNativeAds_5();
        if (channelNativeAds_5 == null) {
            z = false;
        } else if ((channelNativeAds_5.ksNative == null || funNativeAd.getInteractionType() != FunNativeAd.InteractionType.TYPE_DOWNLOAD) && (channelNativeAds_5.csjNative == null || (channelNativeAds_5.csjNative.getAppSize() == 0 && channelNativeAds_5.csjNative.getAppScore() == 0))) {
            z = false;
        }
        return z;
    }

    public static String a(@NonNull FunNativeAd funNativeAd, @NonNull Context context) {
        int i;
        ChannelNativeAds_5 channelNativeAds_5 = funNativeAd.getChannelNativeAds_5();
        if (channelNativeAds_5 == null) {
            return context.getString(R.string.ad_interaction_type_browser);
        }
        if (channelNativeAds_5.ksNative != null) {
            return channelNativeAds_5.ksNative.getActionDescription();
        }
        switch (funNativeAd.getInteractionType()) {
            case TYPE_DOWNLOAD:
                i = R.string.ad_interaction_type_download;
                break;
            case TYPE_DIAL:
                i = R.string.ad_interaction_type_dial;
                break;
            default:
                i = R.string.ad_interaction_type_browser;
                break;
        }
        if (channelNativeAds_5.gdtNative != null && channelNativeAds_5.gdtNative.isAppAd()) {
            i = R.string.ad_interaction_type_download;
        }
        if (i == 0) {
            i = R.string.ad_interaction_type_browser;
        }
        return context.getString(i);
    }
}
