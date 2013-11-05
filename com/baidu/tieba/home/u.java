package com.baidu.tieba.home;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumTopicActivity f1370a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(ForumTopicActivity forumTopicActivity) {
        this.f1370a = forumTopicActivity;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        if (i == 100) {
            this.f1370a.n();
        }
    }
}
