package com.baidu.tieba.ad.browser.newstyle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.webview.BaseAdWebView;
import d.b.j0.a;
import d.b.j0.o.d.d;
/* loaded from: classes4.dex */
public class TBAdWebView extends BaseAdWebView {
    public TBAdWebView(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ad.webview.BaseAdWebView
    public void b(@NonNull DownloadCacheKey downloadCacheKey, boolean z) {
        if (!a.e().o() && !PermissionUtil.checkWriteExternalStorage(getContext())) {
            PermissionUtil.requestWriteExternalStorage((Activity) getContext(), 0);
        } else {
            d.c().l(downloadCacheKey, null);
        }
    }

    @Override // com.baidu.tieba.ad.webview.BaseAdWebView
    public String getUserAgent() {
        return getSettings().getUserAgentString() + " tieba/" + TbConfig.getVersion();
    }

    public TBAdWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TBAdWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
