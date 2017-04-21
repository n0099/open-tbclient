package com.baidu.tieba.frs.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class d extends FrameLayout {
    private boolean bZM;
    private final LinearLayout bZN;
    private boolean bZO;
    private boolean isLoading;
    private final View mNoDataView;
    private final BaseWebView.c mOnPageFinishedListener;
    private final BaseWebView.d mOnPageStartedListener;
    private final BaseWebView.e mOnReceivedErrorListener;
    private final BaseWebView mWebView;

    public d(Context context) {
        super(context);
        this.bZM = false;
        this.isLoading = false;
        this.mOnPageStartedListener = new e(this);
        this.mOnPageFinishedListener = new f(this);
        this.mOnReceivedErrorListener = new g(this);
        this.bZO = false;
        setLayoutParams(new ViewGroup.LayoutParams(-1, (k.ag(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds90)));
        this.mWebView = new BaseWebView(TbadkCoreApplication.m9getInst());
        this.mWebView.setOnPageStartedListener(this.mOnPageStartedListener);
        this.mWebView.setOnPageFinishedListener(this.mOnPageFinishedListener);
        this.mWebView.setOnReceivedErrorListener(this.mOnReceivedErrorListener);
        addView(this.mWebView);
        this.mNoDataView = LayoutInflater.from(context).inflate(w.j.frs_no_list_item_view, (ViewGroup) this, false);
        this.mNoDataView.setVisibility(8);
        addView(this.mNoDataView);
        this.bZN = (LinearLayout) inflate(getContext(), w.j.custom_loading_toast, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(context.getResources().getDimensionPixelSize(w.f.ds220), -2);
        layoutParams.gravity = 1;
        layoutParams.topMargin = context.getResources().getDimensionPixelSize(w.f.ds140);
        addView(this.bZN, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xg() {
        this.mNoDataView.setVisibility(8);
        this.bZN.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adD() {
        this.mWebView.setVisibility(0);
        this.bZN.setVisibility(8);
        this.mNoDataView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adE() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = (k.ag(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds90);
        setLayoutParams(layoutParams);
        this.mWebView.setVisibility(8);
        this.bZN.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public BaseWebView getWebView() {
        return this.mWebView;
    }

    public boolean adF() {
        return this.isLoading;
    }

    public void setWebViewLoading(boolean z) {
        this.isLoading = z;
    }
}
