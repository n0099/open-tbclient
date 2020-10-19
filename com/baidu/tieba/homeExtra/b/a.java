package com.baidu.tieba.homeExtra.b;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.mobstat.MtjConfig;
import com.baidu.mobstat.StatService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t.c;
/* loaded from: classes24.dex */
public class a implements c.a {
    public a() {
        String version = TbConfig.getVersion();
        if (!TextUtils.isEmpty(version)) {
            StatService.setAppVersionName(TbadkCoreApplication.getInst(), version);
        }
    }

    @Override // com.baidu.tieba.t.c.a
    public void autoTrace(Context context) {
        StatService.setFeedTrack(MtjConfig.FeedTrackStrategy.TRACK_NONE);
        StatService.autoTrace(context);
    }

    @Override // com.baidu.tieba.t.c.a
    public void setAppChannel(Context context, String str, boolean z) {
        StatService.setAppChannel(context, str, z);
    }

    @Override // com.baidu.tieba.t.c.a
    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        StatService.trackWebView(context, webView, webChromeClient);
    }
}
