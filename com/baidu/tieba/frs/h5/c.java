package com.baidu.tieba.frs.h5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c extends FrameLayout {
    private final View IP;
    private boolean azx;
    private boolean bsN;
    private final LinearLayout bsO;
    private boolean isError;
    private final BaseWebView.c mOnPageFinishedListener;
    private final BaseWebView.d mOnPageStartedListener;
    private final BaseWebView.e mOnReceivedErrorListener;
    private final BaseWebView mWebView;

    public c(Context context) {
        super(context);
        this.bsN = false;
        this.azx = false;
        this.mOnPageStartedListener = new d(this);
        this.mOnPageFinishedListener = new e(this);
        this.mOnReceivedErrorListener = new f(this);
        this.isError = false;
        setLayoutParams(new ViewGroup.LayoutParams(-1, (com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds90)));
        this.mWebView = new BaseWebView(TbadkCoreApplication.m411getInst());
        this.mWebView.setOnPageStartedListener(this.mOnPageStartedListener);
        this.mWebView.setOnPageFinishedListener(this.mOnPageFinishedListener);
        this.mWebView.setOnReceivedErrorListener(this.mOnReceivedErrorListener);
        addView(this.mWebView);
        this.IP = LayoutInflater.from(context).inflate(t.h.frs_no_list_item_view, (ViewGroup) this, false);
        this.IP.setVisibility(8);
        addView(this.IP);
        this.bsO = (LinearLayout) inflate(getContext(), t.h.custom_loading_toast, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(context.getResources().getDimensionPixelSize(t.e.ds220), -2);
        layoutParams.gravity = 1;
        layoutParams.topMargin = context.getResources().getDimensionPixelSize(t.e.ds140);
        addView(this.bsO, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.IP.setVisibility(8);
        this.bsO.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SU() {
        this.mWebView.setVisibility(0);
        this.bsO.setVisibility(8);
        this.IP.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SV() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = (com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds90);
        setLayoutParams(layoutParams);
        this.mWebView.setVisibility(8);
        this.bsO.setVisibility(8);
        this.IP.setVisibility(0);
    }

    public BaseWebView getWebView() {
        return this.mWebView;
    }

    public boolean SW() {
        return this.azx;
    }

    public void setWebViewLoading(boolean z) {
        this.azx = z;
    }
}
