package com.baidu.tieba.frs.h5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class d extends FrameLayout {
    private final View BW;
    private boolean aAd;
    private boolean bKg;
    private final LinearLayout bKh;
    private boolean bKi;
    private final BaseWebView.c mOnPageFinishedListener;
    private final BaseWebView.d mOnPageStartedListener;
    private final BaseWebView.e mOnReceivedErrorListener;
    private final BaseWebView mWebView;

    public d(Context context) {
        super(context);
        this.bKg = false;
        this.aAd = false;
        this.mOnPageStartedListener = new e(this);
        this.mOnPageFinishedListener = new f(this);
        this.mOnReceivedErrorListener = new g(this);
        this.bKi = false;
        setLayoutParams(new ViewGroup.LayoutParams(-1, (com.baidu.adp.lib.util.k.J(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds90)));
        this.mWebView = new BaseWebView(TbadkCoreApplication.m9getInst());
        this.mWebView.setOnPageStartedListener(this.mOnPageStartedListener);
        this.mWebView.setOnPageFinishedListener(this.mOnPageFinishedListener);
        this.mWebView.setOnReceivedErrorListener(this.mOnReceivedErrorListener);
        addView(this.mWebView);
        this.BW = LayoutInflater.from(context).inflate(r.h.frs_no_list_item_view, (ViewGroup) this, false);
        this.BW.setVisibility(8);
        addView(this.BW);
        this.bKh = (LinearLayout) inflate(getContext(), r.h.custom_loading_toast, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(context.getResources().getDimensionPixelSize(r.e.ds220), -2);
        layoutParams.gravity = 1;
        layoutParams.topMargin = context.getResources().getDimensionPixelSize(r.e.ds140);
        addView(this.bKh, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ws() {
        this.BW.setVisibility(8);
        this.bKh.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aae() {
        this.mWebView.setVisibility(0);
        this.bKh.setVisibility(8);
        this.BW.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaf() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = (com.baidu.adp.lib.util.k.J(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds90);
        setLayoutParams(layoutParams);
        this.mWebView.setVisibility(8);
        this.bKh.setVisibility(8);
        this.BW.setVisibility(0);
    }

    public BaseWebView getWebView() {
        return this.mWebView;
    }

    public boolean aag() {
        return this.aAd;
    }

    public void setWebViewLoading(boolean z) {
        this.aAd = z;
    }
}
