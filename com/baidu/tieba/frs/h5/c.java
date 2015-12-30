package com.baidu.tieba.frs.h5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class c extends FrameLayout {
    private final View Iu;
    private boolean axY;
    private boolean bkT;
    private final LinearLayout bkU;
    private boolean isError;
    private final BaseWebView.c mOnPageFinishedListener;
    private final BaseWebView.d mOnPageStartedListener;
    private final BaseWebView.e mOnReceivedErrorListener;
    private final BaseWebView mWebView;

    public c(Context context) {
        super(context);
        this.bkT = false;
        this.axY = false;
        this.mOnPageStartedListener = new d(this);
        this.mOnPageFinishedListener = new e(this);
        this.mOnReceivedErrorListener = new f(this);
        this.isError = false;
        setLayoutParams(new ViewGroup.LayoutParams(-1, (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds90)));
        this.mWebView = new BaseWebView(TbadkCoreApplication.m411getInst());
        this.mWebView.setOnPageStartedListener(this.mOnPageStartedListener);
        this.mWebView.setOnPageFinishedListener(this.mOnPageFinishedListener);
        this.mWebView.setOnReceivedErrorListener(this.mOnReceivedErrorListener);
        addView(this.mWebView);
        this.Iu = LayoutInflater.from(context).inflate(n.h.frs_no_list_item_view, (ViewGroup) this, false);
        this.Iu.setVisibility(8);
        addView(this.Iu);
        this.bkU = (LinearLayout) inflate(getContext(), n.h.custom_loading_toast, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(context.getResources().getDimensionPixelSize(n.e.ds220), -2);
        layoutParams.gravity = 1;
        layoutParams.topMargin = context.getResources().getDimensionPixelSize(n.e.ds140);
        addView(this.bkU, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.Iu.setVisibility(8);
        this.bkU.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pe() {
        this.mWebView.setVisibility(0);
        this.bkU.setVisibility(8);
        this.Iu.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoData() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds90);
        setLayoutParams(layoutParams);
        this.mWebView.setVisibility(8);
        this.bkU.setVisibility(8);
        this.Iu.setVisibility(0);
    }

    public BaseWebView getWebView() {
        return this.mWebView;
    }

    public boolean Pf() {
        return this.axY;
    }

    public void setWebViewLoading(boolean z) {
        this.axY = z;
    }
}
