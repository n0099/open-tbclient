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
    private boolean axe;
    private boolean bPQ;
    private final LinearLayout bPR;
    private boolean bPS;
    private final BaseWebView.c mOnPageFinishedListener;
    private final BaseWebView.d mOnPageStartedListener;
    private final BaseWebView.e mOnReceivedErrorListener;
    private final BaseWebView mWebView;
    private final View zG;

    public d(Context context) {
        super(context);
        this.bPQ = false;
        this.axe = false;
        this.mOnPageStartedListener = new e(this);
        this.mOnPageFinishedListener = new f(this);
        this.mOnReceivedErrorListener = new g(this);
        this.bPS = false;
        setLayoutParams(new ViewGroup.LayoutParams(-1, (com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m10getInst()) - TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds100)) - TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds90)));
        this.mWebView = new BaseWebView(TbadkCoreApplication.m10getInst());
        this.mWebView.setOnPageStartedListener(this.mOnPageStartedListener);
        this.mWebView.setOnPageFinishedListener(this.mOnPageFinishedListener);
        this.mWebView.setOnReceivedErrorListener(this.mOnReceivedErrorListener);
        addView(this.mWebView);
        this.zG = LayoutInflater.from(context).inflate(u.h.frs_no_list_item_view, (ViewGroup) this, false);
        this.zG.setVisibility(8);
        addView(this.zG);
        this.bPR = (LinearLayout) inflate(getContext(), u.h.custom_loading_toast, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(context.getResources().getDimensionPixelSize(u.e.ds220), -2);
        layoutParams.gravity = 1;
        layoutParams.topMargin = context.getResources().getDimensionPixelSize(u.e.ds140);
        addView(this.bPR, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vj() {
        this.zG.setVisibility(8);
        this.bPR.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qj() {
        this.mWebView.setVisibility(0);
        this.bPR.setVisibility(8);
        this.zG.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zo() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = (com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m10getInst()) - TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds100)) - TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds90);
        setLayoutParams(layoutParams);
        this.mWebView.setVisibility(8);
        this.bPR.setVisibility(8);
        this.zG.setVisibility(0);
    }

    public BaseWebView getWebView() {
        return this.mWebView;
    }

    public boolean Zp() {
        return this.axe;
    }

    public void setWebViewLoading(boolean z) {
        this.axe = z;
    }
}
