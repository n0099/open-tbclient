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
public class d extends FrameLayout {
    private boolean avz;
    private boolean brB;
    private final LinearLayout brC;
    private boolean isError;
    private final BaseWebView.c mOnPageFinishedListener;
    private final BaseWebView.d mOnPageStartedListener;
    private final BaseWebView.e mOnReceivedErrorListener;
    private final BaseWebView mWebView;
    private final View zg;

    public d(Context context) {
        super(context);
        this.brB = false;
        this.avz = false;
        this.mOnPageStartedListener = new e(this);
        this.mOnPageFinishedListener = new f(this);
        this.mOnReceivedErrorListener = new g(this);
        this.isError = false;
        setLayoutParams(new ViewGroup.LayoutParams(-1, (com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m11getInst()) - TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds100)) - TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds90)));
        this.mWebView = new BaseWebView(TbadkCoreApplication.m11getInst());
        this.mWebView.setOnPageStartedListener(this.mOnPageStartedListener);
        this.mWebView.setOnPageFinishedListener(this.mOnPageFinishedListener);
        this.mWebView.setOnReceivedErrorListener(this.mOnReceivedErrorListener);
        addView(this.mWebView);
        this.zg = LayoutInflater.from(context).inflate(t.h.frs_no_list_item_view, (ViewGroup) this, false);
        this.zg.setVisibility(8);
        addView(this.zg);
        this.brC = (LinearLayout) inflate(getContext(), t.h.custom_loading_toast, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(context.getResources().getDimensionPixelSize(t.e.ds220), -2);
        layoutParams.gravity = 1;
        layoutParams.topMargin = context.getResources().getDimensionPixelSize(t.e.ds140);
        addView(this.brC, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.zg.setVisibility(8);
        this.brC.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Th() {
        this.mWebView.setVisibility(0);
        this.brC.setVisibility(8);
        this.zg.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ti() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = (com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m11getInst()) - TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds100)) - TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds90);
        setLayoutParams(layoutParams);
        this.mWebView.setVisibility(8);
        this.brC.setVisibility(8);
        this.zg.setVisibility(0);
    }

    public BaseWebView getWebView() {
        return this.mWebView;
    }

    public boolean Tj() {
        return this.avz;
    }

    public void setWebViewLoading(boolean z) {
        this.avz = z;
    }
}
