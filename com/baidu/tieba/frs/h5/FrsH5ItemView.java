package com.baidu.tieba.frs.h5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class FrsH5ItemView extends FrameLayout {
    private final LinearLayout dSt;
    private boolean dSu;
    private boolean hasLoaded;
    private boolean isLoading;
    private final View mNoDataView;
    private final BaseWebView.c mOnPageFinishedListener;
    private final BaseWebView.d mOnPageStartedListener;
    private final BaseWebView.f mOnReceivedErrorListener;
    private final BaseWebView mWebView;

    public FrsH5ItemView(Context context) {
        super(context);
        this.hasLoaded = false;
        this.isLoading = false;
        this.mOnPageStartedListener = new BaseWebView.d() { // from class: com.baidu.tieba.frs.h5.FrsH5ItemView.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
            public void b(WebView webView, String str) {
                if (!FrsH5ItemView.this.hasLoaded) {
                    FrsH5ItemView.this.showLoading();
                    ViewGroup.LayoutParams layoutParams = FrsH5ItemView.this.getLayoutParams();
                    layoutParams.height = (l.aQ(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds90);
                    FrsH5ItemView.this.setLayoutParams(layoutParams);
                }
                FrsH5ItemView.this.dSu = false;
            }
        };
        this.mOnPageFinishedListener = new BaseWebView.c() { // from class: com.baidu.tieba.frs.h5.FrsH5ItemView.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                FrsH5ItemView.this.isLoading = false;
                if (!FrsH5ItemView.this.dSu) {
                    FrsH5ItemView.this.aEd();
                    ViewGroup.LayoutParams layoutParams = FrsH5ItemView.this.getLayoutParams();
                    layoutParams.height = -2;
                    FrsH5ItemView.this.setLayoutParams(layoutParams);
                }
                FrsH5ItemView.this.hasLoaded = true;
            }
        };
        this.mOnReceivedErrorListener = new BaseWebView.f() { // from class: com.baidu.tieba.frs.h5.FrsH5ItemView.3
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                FrsH5ItemView.this.aEe();
                FrsH5ItemView.this.dSu = true;
            }
        };
        this.dSu = false;
        setLayoutParams(new ViewGroup.LayoutParams(-1, (l.aQ(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds90)));
        this.mWebView = new BaseWebView(TbadkCoreApplication.getInst());
        this.mWebView.setOnPageStartedListener(this.mOnPageStartedListener);
        this.mWebView.setOnPageFinishedListener(this.mOnPageFinishedListener);
        this.mWebView.setOnReceivedErrorListener(this.mOnReceivedErrorListener);
        addView(this.mWebView);
        this.mNoDataView = LayoutInflater.from(context).inflate(e.h.frs_no_list_item_view, (ViewGroup) this, false);
        this.mNoDataView.setVisibility(8);
        addView(this.mNoDataView);
        this.dSt = (LinearLayout) inflate(getContext(), e.h.custom_loading_toast, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(context.getResources().getDimensionPixelSize(e.C0200e.ds220), -2);
        layoutParams.gravity = 1;
        layoutParams.topMargin = context.getResources().getDimensionPixelSize(e.C0200e.ds140);
        addView(this.dSt, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.mNoDataView.setVisibility(8);
        this.dSt.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEd() {
        this.mWebView.setVisibility(0);
        this.dSt.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEe() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = (l.aQ(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds90);
        setLayoutParams(layoutParams);
        this.mWebView.setVisibility(8);
        this.dSt.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public BaseWebView getWebView() {
        return this.mWebView;
    }

    public void setWebViewLoading(boolean z) {
        this.isLoading = z;
    }
}
