package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;
/* loaded from: classes.dex */
public class BaseWebView extends WebView {
    private WebViewClient a;
    private g b;
    private Context c;
    private g d;
    private i e;
    private h f;

    public BaseWebView(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.c = context;
        a();
    }

    public void setDownloadEnabled(boolean z) {
        if (z) {
            if (this.d == null) {
                b();
            }
            setOnLoadUrlListener(this.d);
            return;
        }
        setOnLoadUrlListener(null);
    }

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.c = context;
        a();
    }

    public void a() {
        getSettings().setJavaScriptEnabled(true);
        getSettings().setCacheMode(2);
        com.baidu.tbadk.browser.a.a(getSettings());
        this.a = new f(this);
        setWebViewClient(this.a);
        setOnLongClickListener(new d(this));
    }

    public void setOnLoadUrlListener(g gVar) {
        this.b = gVar;
    }

    public void setOnPageStartedListener(i iVar) {
        this.e = iVar;
    }

    public void setOnPageFinishedListener(h hVar) {
        this.f = hVar;
    }

    private void b() {
        this.d = new e(this);
    }
}
