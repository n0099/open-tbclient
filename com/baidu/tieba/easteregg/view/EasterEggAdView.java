package com.baidu.tieba.easteregg.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionStatic;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.tieba.easteregg.data.EasterEggAdData;
import com.baidu.tieba.easteregg.view.CountDownView;
import com.baidu.tieba.easteregg.view.EasterEggAdView;
import com.baidu.tieba.easteregg.view.EasterEggAdView$skinChangeListener$2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.facebook.drawee.drawable.ScalingUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001+B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ\b\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002J\b\u0010#\u001a\u00020\u001eH\u0002J\u000e\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020\u001eR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/baidu/tieba/easteregg/view/EasterEggAdView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adIcon", "Landroid/widget/TextView;", "countDownView", "Lcom/baidu/tieba/easteregg/view/CountDownView;", "imgView", "Lcom/baidu/tbadk/widget/image/TbImage;", "onContentClickCallback", "Lcom/baidu/tieba/easteregg/view/EasterEggAdView$OnContentClickCallback;", "getOnContentClickCallback", "()Lcom/baidu/tieba/easteregg/view/EasterEggAdView$OnContentClickCallback;", "setOnContentClickCallback", "(Lcom/baidu/tieba/easteregg/view/EasterEggAdView$OnContentClickCallback;)V", "skinChangeListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "getSkinChangeListener", "()Lcom/baidu/adp/framework/listener/CustomMessageListener;", "skinChangeListener$delegate", "Lkotlin/Lazy;", "videoView", "Lcom/baidu/tbadk/afx/TbAlphaVideo;", "changeSkin", "", "hide", "initAdIconView", "initCountDownView", "initImageView", "initVideoView", "setCountDownCloseCallback", WebChromeClient.KEY_ARG_CALLBACK, "Lcom/baidu/tieba/easteregg/view/CountDownView$OnCloseCallback;", "show", "easterEggAdData", "Lcom/baidu/tieba/easteregg/data/EasterEggAdData;", "startCountDown", "OnContentClickCallback", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EasterEggAdView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImage a;
    public TbAlphaVideo b;
    public final CountDownView c;
    public final TextView d;
    public a e;
    public final Lazy f;

    /* loaded from: classes5.dex */
    public interface a {
        void a(String str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EasterEggAdView(Context context) {
        this(context, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EasterEggAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EasterEggAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.c = new CountDownView(context, null, 0, 6, null);
        this.d = new TextView(context);
        this.f = LazyKt__LazyJVMKt.lazy(new Function0<EasterEggAdView$skinChangeListener$2.a>(this) { // from class: com.baidu.tieba.easteregg.view.EasterEggAdView$skinChangeListener$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ EasterEggAdView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* loaded from: classes5.dex */
            public static final class a extends CustomMessageListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ EasterEggAdView a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(EasterEggAdView easterEggAdView) {
                    super(2001304);
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {easterEggAdView};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = easterEggAdView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                        this.a.a();
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new a(this.this$0);
                }
                return (a) invokeV.objValue;
            }
        });
        d();
        c();
        a();
    }

    public static final void h(EasterEggAdData easterEggAdData, EasterEggAdView this$0, View view2) {
        boolean z;
        boolean z2;
        boolean z3;
        TbPageContext<?> currentPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, easterEggAdData, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(easterEggAdData, "$easterEggAdData");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            String jumpLink = easterEggAdData.getJumpLink();
            String jumpScheme = easterEggAdData.getJumpScheme();
            if (jumpScheme != null && !StringsKt__StringsJVMKt.isBlank(jumpScheme)) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                if (jumpLink == null) {
                    jumpLink = "";
                }
                jumpLink = SchemeActionStatic.wrapThirdDeeplink(jumpScheme, jumpLink);
            } else {
                if (jumpLink != null && !StringsKt__StringsJVMKt.isBlank(jumpLink)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    jumpLink = null;
                }
            }
            if (jumpLink != null && !StringsKt__StringsJVMKt.isBlank(jumpLink)) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (!z3 && (currentPageContext = TbadkCoreApplication.getInst().getCurrentPageContext(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(BaseWebViewActivity.BUNDLE_NEED_EXTRA_PARAM, false);
                UrlManager.getInstance().dealOneLink(currentPageContext, new String[]{jumpLink}, true, bundle);
            }
            a aVar = this$0.e;
            if (aVar != null) {
                aVar.a(jumpLink);
            }
        }
    }

    public /* synthetic */ EasterEggAdView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final CustomMessageListener getSkinChangeListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            return (CustomMessageListener) this.f.getValue();
        }
        return (CustomMessageListener) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().unRegisterListener(getSkinChangeListener());
            TbAlphaVideo tbAlphaVideo = this.b;
            if (tbAlphaVideo != null) {
                tbAlphaVideo.stop();
            }
            TbAlphaVideo tbAlphaVideo2 = this.b;
            if (tbAlphaVideo2 != null) {
                tbAlphaVideo2.b();
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.b == null) {
            this.b = new TbAlphaVideo(getContext());
            addView(this.b, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public final a getOnContentClickCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e;
        }
        return (a) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.c.j();
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            EMManager.from(this).setGradientColor(new int[]{R.color.CAM_X0604, R.color.CAM_X0601});
            this.c.c();
            EMManager.from(this.d).setTextColor(R.color.CAM_X0101);
            this.d.setShadowLayer(UtilHelper.getDimenPixelSize(R.dimen.tbds6), 0.0f, UtilHelper.getDimenPixelSize(R.dimen.tbds2), SkinManager.getColor(R.color.CAM_X0606));
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(9);
            layoutParams.addRule(12);
            layoutParams.setMargins(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds8));
            this.d.setText(R.string.advert_label);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds6);
            this.d.setPadding(dimenPixelSize, 0, dimenPixelSize, UtilHelper.getDimenPixelSize(R.dimen.tbds2));
            EMManager.from(this.d).setTextSize(R.dimen.T_X10);
            addView(this.d, layoutParams);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, UtilHelper.getDimenPixelSize(R.dimen.tbds57));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.setMargins(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0);
            addView(this.c, layoutParams);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            this.a = new TbImage(context, null, 0, 6, null);
            addView(this.a, 0, new RelativeLayout.LayoutParams(-1, -1));
            TbImage tbImage = this.a;
            if (tbImage != null) {
                ScalingUtils.ScaleType CENTER_CROP = ScalingUtils.ScaleType.CENTER_CROP;
                Intrinsics.checkNotNullExpressionValue(CENTER_CROP, "CENTER_CROP");
                tbImage.setScaleType(CENTER_CROP);
            }
        }
    }

    public final void g(final EasterEggAdData easterEggAdData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, easterEggAdData) == null) {
            Intrinsics.checkNotNullParameter(easterEggAdData, "easterEggAdData");
            MessageManager.getInstance().registerListener(getSkinChangeListener());
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.yv6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        EasterEggAdView.h(EasterEggAdData.this, this, view2);
                    }
                }
            };
            boolean z = true;
            if (easterEggAdData.getResType() != 1) {
                String iconUrl = easterEggAdData.getIconUrl();
                if (iconUrl != null && !StringsKt__StringsJVMKt.isBlank(iconUrl)) {
                    z = false;
                }
                if (!z) {
                    e();
                    TbImage tbImage = this.a;
                    if (tbImage != null) {
                        setOnClickListener(onClickListener);
                        tbImage.l(iconUrl);
                        setVisibility(0);
                    }
                    TbAlphaVideo tbAlphaVideo = this.b;
                    if (tbAlphaVideo != null) {
                        tbAlphaVideo.setVisibility(8);
                    }
                }
            } else {
                String videoPath = easterEggAdData.getVideoPath();
                if (videoPath != null && !StringsKt__StringsJVMKt.isBlank(videoPath)) {
                    z = false;
                }
                if (!z) {
                    f();
                    TbAlphaVideo tbAlphaVideo2 = this.b;
                    if (tbAlphaVideo2 != null) {
                        setOnClickListener(onClickListener);
                        tbAlphaVideo2.setSourcePath(videoPath);
                        tbAlphaVideo2.i();
                        setVisibility(0);
                    }
                    TbImage tbImage2 = this.a;
                    if (tbImage2 != null) {
                        tbImage2.setVisibility(8);
                    }
                }
            }
            if (easterEggAdData.getCountdown() <= 0) {
                this.c.d();
            } else {
                CountDownView.setCountDownTime$default(this.c, easterEggAdData.getCountdown() * 1000, 0L, 2, null);
            }
        }
    }

    public final void setCountDownCloseCallback(CountDownView.a callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.c.setOnCloseCallback(callback);
        }
    }

    public final void setOnContentClickCallback(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.e = aVar;
        }
    }
}
