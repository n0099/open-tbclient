package com.baidu.tieba.home;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumTopicActivity f1504a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ForumTopicActivity forumTopicActivity) {
        this.f1504a = forumTopicActivity;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        if (i == 100) {
            this.f1504a.f();
        }
    }
}
