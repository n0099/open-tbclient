package com.baidu.tieba.frs.h5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class c extends FrameLayout {
    private final View HL;
    private final com.baidu.tbadk.c.f Na;
    private boolean aZT;
    private boolean isError;
    private final BaseWebView.c mOnPageFinishedListener;
    private final BaseWebView.d mOnPageStartedListener;
    private final BaseWebView.e mOnReceivedErrorListener;
    private final BaseWebView mWebView;

    public c(Context context) {
        super(context);
        this.aZT = false;
        this.mOnPageStartedListener = new d(this);
        this.mOnPageFinishedListener = new e(this);
        this.mOnReceivedErrorListener = new f(this);
        this.isError = false;
        setLayoutParams(new ViewGroup.LayoutParams(-1, (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds90)));
        this.mWebView = new BaseWebView(TbadkCoreApplication.m411getInst());
        this.mWebView.setOnPageStartedListener(this.mOnPageStartedListener);
        this.mWebView.setOnPageFinishedListener(this.mOnPageFinishedListener);
        this.mWebView.setOnReceivedErrorListener(this.mOnReceivedErrorListener);
        this.mWebView.setVisibility(4);
        addView(this.mWebView);
        this.HL = LayoutInflater.from(context).inflate(i.g.frs_no_list_item_view, (ViewGroup) this, false);
        this.HL.setVisibility(8);
        addView(this.HL);
        this.Na = new com.baidu.tbadk.c.f(context, context.getResources().getDimensionPixelSize(i.d.ds140));
        this.Na.v(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.mWebView.setVisibility(8);
        this.HL.setVisibility(8);
        if (!this.Na.Cq()) {
            this.Na.v(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MX() {
        this.mWebView.setVisibility(0);
        this.Na.u(this);
        this.HL.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoData() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds90);
        setLayoutParams(layoutParams);
        this.mWebView.setVisibility(8);
        this.Na.u(this);
        this.HL.setVisibility(0);
    }

    public BaseWebView getWebView() {
        return this.mWebView;
    }
}
