package com.baidu.tbadk.plugins;

import android.content.Context;
import android.location.Location;
import android.net.Uri;
/* loaded from: classes.dex */
public interface BdSocialShareSdkDelegate {

    /* loaded from: classes.dex */
    public interface ShareCallback {
        void onCancelOfBaiduListener();

        void onCompleteOfBaiduListener();

        void onErrorOfBaiduListener();

        void shareCallback(boolean z);
    }

    void shareToQQFriend(String str, String str2, String str3, Uri uri, Location location, Context context, boolean z, ShareCallback shareCallback);

    void shareToQQWeibo(String str, String str2, String str3, Uri uri, Location location, Context context, boolean z, ShareCallback shareCallback);

    void shareToQZone(String str, String str2, String str3, Uri uri, Location location, Context context, boolean z, ShareCallback shareCallback);

    void shareToRenren(String str, String str2, String str3, Uri uri, Location location, Context context, boolean z, ShareCallback shareCallback);

    void shareToSinaWeibo(String str, String str2, String str3, Uri uri, Location location, Context context, boolean z, ShareCallback shareCallback);

    void shareToWeixinFriend(String str, String str2, String str3, Uri uri, Location location, Context context, boolean z, ShareCallback shareCallback);

    void shareToWexinTimeline(String str, String str2, String str3, Uri uri, Location location, Context context, boolean z, ShareCallback shareCallback);
}
