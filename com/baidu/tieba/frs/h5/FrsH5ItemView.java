package com.baidu.tieba.frs.h5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class FrsH5ItemView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public boolean f15762e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f15763f;

    /* renamed from: g  reason: collision with root package name */
    public final BaseWebView.f f15764g;

    /* renamed from: h  reason: collision with root package name */
    public final BaseWebView.e f15765h;

    /* renamed from: i  reason: collision with root package name */
    public final BaseWebView.h f15766i;
    public final BaseWebView j;
    public final LinearLayout k;
    public final View l;
    public boolean m;

    /* loaded from: classes4.dex */
    public class a implements BaseWebView.f {
        public a() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
        public void a(WebView webView, String str) {
            if (!FrsH5ItemView.this.f15762e) {
                FrsH5ItemView.this.j();
                ViewGroup.LayoutParams layoutParams = FrsH5ItemView.this.getLayoutParams();
                layoutParams.height = (l.i(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds90);
                FrsH5ItemView.this.setLayoutParams(layoutParams);
            }
            FrsH5ItemView.this.m = false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements BaseWebView.e {
        public b() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            FrsH5ItemView.this.f15763f = false;
            if (!FrsH5ItemView.this.m) {
                FrsH5ItemView.this.i();
                ViewGroup.LayoutParams layoutParams = FrsH5ItemView.this.getLayoutParams();
                layoutParams.height = -2;
                FrsH5ItemView.this.setLayoutParams(layoutParams);
            }
            FrsH5ItemView.this.f15762e = true;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements BaseWebView.h {
        public c() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void a(WebView webView, int i2, String str, String str2) {
            FrsH5ItemView.this.k();
            FrsH5ItemView.this.m = true;
        }
    }

    public FrsH5ItemView(Context context) {
        super(context);
        this.f15762e = false;
        this.f15764g = new a();
        this.f15765h = new b();
        this.f15766i = new c();
        this.m = false;
        setLayoutParams(new ViewGroup.LayoutParams(-1, (l.i(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds90)));
        BaseWebView baseWebView = new BaseWebView(TbadkCoreApplication.getInst());
        this.j = baseWebView;
        baseWebView.setOnPageStartedListener(this.f15764g);
        this.j.setOnPageFinishedListener(this.f15765h);
        this.j.setOnReceivedErrorListener(this.f15766i);
        addView(this.j);
        View inflate = LayoutInflater.from(context).inflate(R.layout.frs_no_list_item_view, (ViewGroup) this, false);
        this.l = inflate;
        inflate.setVisibility(8);
        addView(this.l);
        this.k = (LinearLayout) FrameLayout.inflate(getContext(), R.layout.custom_loading_toast, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(context.getResources().getDimensionPixelSize(R.dimen.ds220), -2);
        layoutParams.gravity = 1;
        layoutParams.topMargin = context.getResources().getDimensionPixelSize(R.dimen.ds140);
        addView(this.k, layoutParams);
    }

    public BaseWebView getWebView() {
        return this.j;
    }

    public final void i() {
        this.j.setVisibility(0);
        this.k.setVisibility(8);
        this.l.setVisibility(8);
    }

    public final void j() {
        this.l.setVisibility(8);
        this.k.setVisibility(0);
    }

    public final void k() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = (l.i(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds90);
        setLayoutParams(layoutParams);
        this.j.setVisibility(8);
        this.k.setVisibility(8);
        this.l.setVisibility(0);
    }

    public void setWebViewLoading(boolean z) {
    }
}
