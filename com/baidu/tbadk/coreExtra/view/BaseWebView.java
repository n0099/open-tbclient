package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class BaseWebView extends WebView {
    private WebViewClient a;
    private f b;
    private Context c;
    private f d;
    private h e;
    private g f;

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
                this.d = new d(this);
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

    private void a() {
        getSettings().setJavaScriptEnabled(true);
        getSettings().setCacheMode(2);
        CompatibleUtile.getInstance().WebViewNoDataBase(getSettings());
        this.a = new e(this);
        setWebViewClient(this.a);
        setOnLongClickListener(new c(this));
    }

    public void setOnLoadUrlListener(f fVar) {
        this.b = fVar;
    }

    public void setOnPageStartedListener(h hVar) {
        this.e = hVar;
    }

    public void setOnPageFinishedListener(g gVar) {
        this.f = gVar;
    }
}
