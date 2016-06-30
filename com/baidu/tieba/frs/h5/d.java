package com.baidu.tieba.frs.h5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class d extends FrameLayout {
    private boolean awp;
    private boolean bOf;
    private final LinearLayout bOg;
    private boolean bOh;
    private final BaseWebView.c mOnPageFinishedListener;
    private final BaseWebView.d mOnPageStartedListener;
    private final BaseWebView.e mOnReceivedErrorListener;
    private final BaseWebView mWebView;
    private final View zf;

    public d(Context context) {
        super(context);
        this.bOf = false;
        this.awp = false;
        this.mOnPageStartedListener = new e(this);
        this.mOnPageFinishedListener = new f(this);
        this.mOnReceivedErrorListener = new g(this);
        this.bOh = false;
        setLayoutParams(new ViewGroup.LayoutParams(-1, (com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds90)));
        this.mWebView = new BaseWebView(TbadkCoreApplication.m9getInst());
        this.mWebView.setOnPageStartedListener(this.mOnPageStartedListener);
        this.mWebView.setOnPageFinishedListener(this.mOnPageFinishedListener);
        this.mWebView.setOnReceivedErrorListener(this.mOnReceivedErrorListener);
        addView(this.mWebView);
        this.zf = LayoutInflater.from(context).inflate(u.h.frs_no_list_item_view, (ViewGroup) this, false);
        this.zf.setVisibility(8);
        addView(this.zf);
        this.bOg = (LinearLayout) inflate(getContext(), u.h.custom_loading_toast, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(context.getResources().getDimensionPixelSize(u.e.ds220), -2);
        layoutParams.gravity = 1;
        layoutParams.topMargin = context.getResources().getDimensionPixelSize(u.e.ds140);
        addView(this.bOg, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vj() {
        this.zf.setVisibility(8);
        this.bOg.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PF() {
        this.mWebView.setVisibility(0);
        this.bOg.setVisibility(8);
        this.zf.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YT() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = (com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds90);
        setLayoutParams(layoutParams);
        this.mWebView.setVisibility(8);
        this.bOg.setVisibility(8);
        this.zf.setVisibility(0);
    }

    public BaseWebView getWebView() {
        return this.mWebView;
    }

    public boolean YU() {
        return this.awp;
    }

    public void setWebViewLoading(boolean z) {
        this.awp = z;
    }
}
