package com.baidu.tieba.funad.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import c.a.q0.i3.i0.o;
import c.a.q0.w0.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunNativeAd;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class FunAbsAdView extends NativeAdContainer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String funAdTitle;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FunAbsAdView(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public abstract void destroyDownloadButton();

    public abstract List<View> getClickViews();

    public abstract List<View> getCreativeViews();

    public abstract View getFeedBackView();

    public abstract FrameLayout getGdtAdContainer(FunNativeAd funNativeAd);

    public abstract int getLayoutId();

    public abstract a.g getLogItem();

    public abstract String getPageType();

    public abstract void hideOrShowView(int i2);

    public abstract void hideShowByType(BdUniqueId bdUniqueId);

    public abstract void inflateFunAd(@NonNull o oVar, @NonNull Activity activity);

    public abstract void initView(Context context);

    public abstract void onChangedSkinType();

    public abstract void resetAdLaybleState(@NonNull FunNativeAd funNativeAd);

    public abstract void setFeedBackListener(View.OnClickListener onClickListener);

    @Deprecated
    public abstract void setFunAdViewVisible(boolean z);

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FunAbsAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunAbsAdView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        initView(context);
    }
}
