package com.baidu.tieba.feed.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.bz6;
import com.baidu.tieba.feed.component.CardLiveView;
import com.baidu.tieba.g35;
import com.baidu.tieba.ii;
import com.baidu.tieba.l17;
import com.baidu.tieba.lz6;
import com.baidu.tieba.m17;
import com.baidu.tieba.px6;
import com.baidu.tieba.sw6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001b\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0002H\u0014J\b\u0010\u001d\u001a\u00020\u001bH\u0016J\u0018\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/baidu/tieba/feed/component/CardLiveView;", "Lcom/baidu/tieba/feed/component/CardRelativeView;", "Lcom/baidu/tieba/feed/component/uistate/CardLiveUiState;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "coverView", "Landroid/view/View;", "labelBottomLeft", "Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "labelBottomRight", "labelTopLeft", "Landroid/widget/LinearLayout;", "labelTopLeftText", "lottieView", "Lcom/baidu/tbadk/widget/lottie/TBLottieAnimationView;", "lottieViewContainer", "Landroid/widget/FrameLayout;", "resolver", "Lcom/baidu/tieba/feed/compat/WidgetResolver$NetImageViewCreator;", "kotlin.jvm.PlatformType", "thumbnailImg", "Landroid/widget/ImageView;", "doUpdateState", "", "state", "onChangeSkin", "setCoverViewLp", "width", "", "height", "lib-templates_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CardLiveView extends CardRelativeView<px6> implements l17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final sw6.d c;
    public final LinearLayout d;
    public final FrameLayout e;
    public final TBLottieAnimationView f;
    public final EMTextView g;
    public final EMTextView h;
    public final EMTextView i;
    public final ImageView j;
    public final View k;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CardLiveView(Context context) {
        this(context, null, 2, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* loaded from: classes4.dex */
    public static final class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardLiveView a;

        public a(CardLiveView cardLiveView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardLiveView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardLiveView;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, v) == null) {
                Intrinsics.checkNotNullParameter(v, "v");
                this.a.f.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v) == null) {
                Intrinsics.checkNotNullParameter(v, "v");
                this.a.f.cancelAnimation();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CardLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.c = sw6.a().a();
        this.d = new LinearLayout(context);
        this.e = new FrameLayout(context);
        this.f = new TBLottieAnimationView(context);
        this.g = new EMTextView(context);
        this.h = new EMTextView(context);
        this.i = new EMTextView(context);
        View create = this.c.create(context);
        if (create != null) {
            this.j = (ImageView) create;
            this.k = new View(context);
            this.j.setId(R.id.obfuscated_res_0x7f0905d2);
            this.j.setScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(this.j, new RelativeLayout.LayoutParams(-1, -1));
            sw6.c cVar = new sw6.c();
            cVar.a = R.string.J_X05;
            cVar.b = 15;
            this.c.b(this.j, cVar);
            this.k.setBackgroundResource(R.drawable.bg_img_mask);
            addView(this.k, new RelativeLayout.LayoutParams(-1, -1));
            this.d.setOrientation(0);
            this.d.setGravity(16);
            this.f.loop(true);
            this.f.addOnAttachStateChangeListener(new a(this));
            int g = ii.g(context, R.dimen.tbds30);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g, g);
            layoutParams.gravity = 17;
            this.e.addView(this.f, layoutParams);
            int g2 = ii.g(context, R.dimen.tbds52);
            this.d.addView(this.e, new LinearLayout.LayoutParams(g2, g2));
            this.g.setPadding(ii.g(context, R.dimen.M_W_X002), 0, ii.g(context, R.dimen.M_W_X004), 0);
            this.d.addView(this.g, new LinearLayout.LayoutParams(-2, -2));
            this.g.setGravity(16);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = ii.g(context, R.dimen.M_H_X004);
            layoutParams2.leftMargin = ii.g(context, R.dimen.M_W_X006);
            addView(this.d, layoutParams2);
            int g3 = ii.g(context, R.dimen.tbds25);
            this.h.setPadding(g3, 0, g3, 0);
            this.h.setGravity(17);
            g35.d(this.h).B(R.dimen.T_X09);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, ii.g(context, R.dimen.tbds52));
            layoutParams3.addRule(8, R.id.obfuscated_res_0x7f0905d2);
            layoutParams3.leftMargin = ii.g(context, R.dimen.tbds33);
            layoutParams3.bottomMargin = ii.g(context, R.dimen.tbds25);
            addView(this.h, layoutParams3);
            g35.d(this.i).B(R.dimen.T_X09);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(8, R.id.obfuscated_res_0x7f0905d2);
            layoutParams4.addRule(11);
            layoutParams4.rightMargin = ii.g(context, R.dimen.M_W_X006);
            layoutParams4.bottomMargin = ii.g(context, R.dimen.M_H_X004);
            addView(this.i, layoutParams4);
            if (UbsABTestHelper.isFeedLiveCardStyleA()) {
                this.h.setVisibility(8);
                this.i.setVisibility(8);
                ViewGroup.LayoutParams layoutParams5 = this.j.getLayoutParams();
                if (layoutParams5 != null) {
                    RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) layoutParams5;
                    layoutParams6.width = ii.g(context, R.dimen.tbds650);
                    layoutParams6.height = ii.g(context, R.dimen.tbds813);
                    this.j.setLayoutParams(layoutParams6);
                    j(layoutParams6.width, layoutParams6.height);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    }

    public /* synthetic */ CardLiveView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final void i(px6 state, CardLiveView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, state, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            String str = state.d().f;
            if (str != null) {
                Function2<Context, String, Unit> e = state.e();
                Context context = this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                e.invoke(context, str);
            }
        }
    }

    @Override // com.baidu.tieba.l17
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || m17.a(this)) {
            return;
        }
        SkinManager.setLottieAnimation(this.f, R.raw.lottie_ala_live);
        g35 d = g35.d(this.d);
        d.o(R.string.J_X01);
        d.f(R.color.CAM_X0605);
        g35 d2 = g35.d(this.e);
        d2.o(R.string.J_X07);
        d2.f(R.color.CAM_X0310);
        SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0101);
        g35.d(this.g).B(R.dimen.T_X09);
        g35 d3 = g35.d(this.h);
        d3.o(R.string.J_X04);
        d3.w(R.color.CAM_X0101);
        d3.f(R.color.CAM_X0606);
        g35.d(this.i).w(R.color.CAM_X0101);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.feed.component.CardRelativeView
    /* renamed from: h */
    public void e(final px6 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            bz6 d = state.d();
            if (!UbsABTestHelper.isFeedLiveCardStyleA()) {
                ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
                if (layoutParams != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    int width = getWidth();
                    layoutParams2.width = width;
                    layoutParams2.height = (width * 9) / 16;
                    this.j.setLayoutParams(layoutParams2);
                    j(layoutParams2.width, layoutParams2.height);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                }
            }
            this.c.e(this.j, d.d);
            this.g.setText(d.a);
            this.h.setText(d.b);
            this.i.setText(d.c);
            lz6 lz6Var = d.e;
            if (lz6Var != null) {
                state.c().invoke(lz6Var);
            }
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ex6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        CardLiveView.i(px6.this, this, view2);
                    }
                }
            });
            b();
        }
    }

    public final void j(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.k.setLayoutParams(layoutParams);
        }
    }
}
