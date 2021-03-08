package com.baidu.tieba.funad.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.n;
import com.fun.ad.sdk.FunNativeAd;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class FunAbsAdView extends NativeAdContainer {
    protected String jVe;

    public abstract void Bi(int i);

    public abstract void a(@NonNull n nVar, @NonNull Activity activity);

    public abstract void cNF();

    public abstract void cNG();

    public abstract FrameLayout e(FunNativeAd funNativeAd);

    public abstract List<View> getClickViews();

    public abstract List<View> getCreativeViews();

    public abstract View getFeedBackView();

    protected abstract int getLayoutId();

    public abstract String getPageType();

    protected abstract void initView(Context context);

    public abstract void s(BdUniqueId bdUniqueId);

    public abstract void setDownloadDelayText(String str, long j);

    public abstract void setFunAdViewVisible(boolean z);

    public FunAbsAdView(Context context) {
        this(context, null, 0);
    }

    public FunAbsAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FunAbsAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
