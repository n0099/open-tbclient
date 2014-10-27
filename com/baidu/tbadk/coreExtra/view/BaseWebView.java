package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class BaseWebView extends WebView {
    private static final String TAG = "BaseWebView";
    private Context mContext;
    private f mDownloadListener;
    private f mOnLoadUrlListener;
    private g mOnPageFinishedListener;
    private h mOnPageStartedListener;
    private WebViewClient mWebViewClient;

    public BaseWebView(Context context) {
        super(context);
        this.mOnLoadUrlListener = null;
        this.mContext = null;
        this.mDownloadListener = null;
        this.mOnPageStartedListener = null;
        this.mOnPageFinishedListener = null;
        this.mContext = context;
        init();
    }

    public void setDownloadEnabled(boolean z) {
        if (z) {
            if (this.mDownloadListener == null) {
                initDownload();
            }
            setOnLoadUrlListener(this.mDownloadListener);
            return;
        }
        setOnLoadUrlListener(null);
    }

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnLoadUrlListener = null;
        this.mContext = null;
        this.mDownloadListener = null;
        this.mOnPageStartedListener = null;
        this.mOnPageFinishedListener = null;
        this.mContext = context;
        init();
    }

    public void init() {
        getSettings().setJavaScriptEnabled(true);
        getSettings().setCacheMode(2);
        com.baidu.tbadk.browser.a.WebViewNoDataBase(getSettings());
        this.mWebViewClient = new e(this);
        setWebViewClient(this.mWebViewClient);
        setOnLongClickListener(new c(this));
    }

    public void setOnLoadUrlListener(f fVar) {
        this.mOnLoadUrlListener = fVar;
    }

    public void setOnPageStartedListener(h hVar) {
        this.mOnPageStartedListener = hVar;
    }

    public void setOnPageFinishedListener(g gVar) {
        this.mOnPageFinishedListener = gVar;
    }

    public void resetProxy(int i) {
        CompatibleUtile.dealWebView(null);
    }

    private void initDownload() {
        this.mDownloadListener = new d(this);
    }
}
