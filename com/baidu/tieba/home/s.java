package com.baidu.tieba.home;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends WebChromeClient {
    final /* synthetic */ ForumTopicActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ForumTopicActivity forumTopicActivity) {
        this.a = forumTopicActivity;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        if (i == 100) {
            this.a.f();
        }
    }
}
