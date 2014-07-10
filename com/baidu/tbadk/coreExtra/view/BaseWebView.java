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
    private g mDownloadListener;
    private g mOnLoadUrlListener;
    private h mOnPageFinishedListener;
    private i mOnPageStartedListener;
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
        com.baidu.tbadk.browser.a.a(getSettings());
        this.mWebViewClient = new f(this);
        setWebViewClient(this.mWebViewClient);
        setOnLongClickListener(new d(this));
    }

    public void setOnLoadUrlListener(g gVar) {
        this.mOnLoadUrlListener = gVar;
    }

    public void setOnPageStartedListener(i iVar) {
        this.mOnPageStartedListener = iVar;
    }

    public void setOnPageFinishedListener(h hVar) {
        this.mOnPageFinishedListener = hVar;
    }

    public void resetProxy(int i) {
        CompatibleUtile.dealWebView();
    }

    private void initDownload() {
        this.mDownloadListener = new e(this);
    }
}
