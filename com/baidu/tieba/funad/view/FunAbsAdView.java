package com.baidu.tieba.funad.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.fun.ad.sdk.FunNativeAd;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import d.a.j0.d3.h0.n;
import d.a.j0.r0.a;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class FunAbsAdView extends NativeAdContainer {

    /* renamed from: e  reason: collision with root package name */
    public String f16724e;

    public FunAbsAdView(Context context) {
        this(context, null, 0);
    }

    public abstract void b();

    public abstract FrameLayout c(FunNativeAd funNativeAd);

    public abstract void d(int i2);

    public abstract void e(BdUniqueId bdUniqueId);

    public abstract void f(@NonNull n nVar, @NonNull Activity activity);

    public abstract void g(Context context);

    public abstract List<View> getClickViews();

    public abstract List<View> getCreativeViews();

    public abstract View getFeedBackView();

    public abstract int getLayoutId();

    public abstract a.d getLogItem();

    public abstract String getPageType();

    public abstract void h();

    public abstract void setDownloadDelayText(String str, long j);

    public abstract void setFeedBackListener(View.OnClickListener onClickListener);

    @Deprecated
    public abstract void setFunAdViewVisible(boolean z);

    public FunAbsAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FunAbsAdView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        g(context);
    }
}
