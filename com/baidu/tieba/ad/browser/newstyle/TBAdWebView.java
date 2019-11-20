package com.baidu.tieba.ad.browser.newstyle;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.webview.BaseAdWebView;
/* loaded from: classes3.dex */
public class TBAdWebView extends BaseAdWebView {
    public TBAdWebView(Context context) {
        super(context);
    }

    public TBAdWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TBAdWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.tieba.ad.webview.BaseAdWebView
    protected String getUserAgent() {
        return getSettings().getUserAgentString() + " tieba/" + TbConfig.getVersion();
    }

    @Override // com.baidu.tieba.ad.webview.BaseAdWebView
    protected void a(@NonNull DownloadCacheKey downloadCacheKey, boolean z) {
        if (!ab.checkWriteExternalStorage(getContext())) {
            ab.requestWriteExternalStorage((Activity) getContext(), 0);
        } else {
            com.baidu.tieba.ad.download.d.aDG().c(downloadCacheKey, null);
        }
    }
}
