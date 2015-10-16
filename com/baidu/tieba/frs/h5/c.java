package com.baidu.tieba.frs.h5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class c extends FrameLayout {
    private final View HM;
    private boolean avC;
    private boolean baq;
    private final LinearLayout bas;
    private boolean isError;
    private final BaseWebView.c mOnPageFinishedListener;
    private final BaseWebView.d mOnPageStartedListener;
    private final BaseWebView.e mOnReceivedErrorListener;
    private final BaseWebView mWebView;

    public c(Context context) {
        super(context);
        this.baq = false;
        this.avC = false;
        this.mOnPageStartedListener = new d(this);
        this.mOnPageFinishedListener = new e(this);
        this.mOnReceivedErrorListener = new f(this);
        this.isError = false;
        setLayoutParams(new ViewGroup.LayoutParams(-1, (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds90)));
        this.mWebView = new BaseWebView(TbadkCoreApplication.m411getInst());
        this.mWebView.setOnPageStartedListener(this.mOnPageStartedListener);
        this.mWebView.setOnPageFinishedListener(this.mOnPageFinishedListener);
        this.mWebView.setOnReceivedErrorListener(this.mOnReceivedErrorListener);
        addView(this.mWebView);
        this.HM = LayoutInflater.from(context).inflate(i.g.frs_no_list_item_view, (ViewGroup) this, false);
        this.HM.setVisibility(8);
        addView(this.HM);
        this.bas = (LinearLayout) inflate(getContext(), i.g.custom_loading_toast, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(context.getResources().getDimensionPixelSize(i.d.ds220), -2);
        layoutParams.gravity = 1;
        layoutParams.topMargin = context.getResources().getDimensionPixelSize(i.d.ds140);
        addView(this.bas, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.HM.setVisibility(8);
        this.bas.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MW() {
        this.mWebView.setVisibility(0);
        this.bas.setVisibility(8);
        this.HM.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoData() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds90);
        setLayoutParams(layoutParams);
        this.mWebView.setVisibility(8);
        this.bas.setVisibility(8);
        this.HM.setVisibility(0);
    }

    public BaseWebView getWebView() {
        return this.mWebView;
    }

    public boolean MX() {
        return this.avC;
    }

    public void setWebViewLoading(boolean z) {
        this.avC = z;
    }
}
