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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.bc7;
import com.baidu.tieba.e87;
import com.baidu.tieba.feed.component.CardLiveView;
import com.baidu.tieba.k37;
import com.baidu.tieba.l77;
import com.baidu.tieba.lb7;
import com.baidu.tieba.mb7;
import com.baidu.tieba.p47;
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
/* loaded from: classes5.dex */
public final class CardLiveView extends CardRelativeView<p47> implements lb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final k37.e d;
    public final LinearLayout e;
    public final FrameLayout f;
    public final TBLottieAnimationView g;
    public final EMTextView h;
    public final EMTextView i;
    public final EMTextView j;
    public final ImageView k;
    public final View l;

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

    /* loaded from: classes5.dex */
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
                this.a.g.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v) == null) {
                Intrinsics.checkNotNullParameter(v, "v");
                this.a.g.cancelAnimation();
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
        this.d = k37.a().a();
        this.e = new LinearLayout(context);
        this.f = new FrameLayout(context);
        this.g = new TBLottieAnimationView(context);
        this.h = new EMTextView(context);
        this.i = new EMTextView(context);
        this.j = new EMTextView(context);
        View create = this.d.create(context);
        if (create != null) {
            this.k = (ImageView) create;
            this.l = new View(context);
            this.k.setId(R.id.obfuscated_res_0x7f090655);
            this.k.setScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(this.k, new RelativeLayout.LayoutParams(-1, -1));
            k37.d dVar = new k37.d();
            dVar.a = R.string.J_X05;
            dVar.b = 15;
            this.d.c(this.k, dVar);
            this.l.setBackgroundResource(R.drawable.bg_img_mask);
            addView(this.l, new RelativeLayout.LayoutParams(-1, -1));
            this.e.setOrientation(0);
            this.e.setGravity(16);
            this.g.loop(true);
            this.g.setLifecycleEnable(true);
            this.g.addOnAttachStateChangeListener(new a(this));
            int dimens = BdUtilHelper.getDimens(context, R.dimen.tbds30);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.gravity = 17;
            this.f.addView(this.g, layoutParams);
            int dimens2 = BdUtilHelper.getDimens(context, R.dimen.tbds52);
            this.e.addView(this.f, new LinearLayout.LayoutParams(dimens2, dimens2));
            this.h.setPadding(BdUtilHelper.getDimens(context, R.dimen.M_W_X002), 0, BdUtilHelper.getDimens(context, R.dimen.M_W_X004), 0);
            this.e.addView(this.h, new LinearLayout.LayoutParams(-2, -2));
            this.h.setGravity(16);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = BdUtilHelper.getDimens(context, R.dimen.M_H_X004);
            layoutParams2.leftMargin = BdUtilHelper.getDimens(context, R.dimen.M_W_X006);
            addView(this.e, layoutParams2);
            int dimens3 = BdUtilHelper.getDimens(context, R.dimen.tbds25);
            this.i.setPadding(dimens3, 0, dimens3, 0);
            this.i.setGravity(17);
            EMManager.from(this.i).setTextSize(R.dimen.T_X09);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(context, R.dimen.tbds52));
            layoutParams3.addRule(8, R.id.obfuscated_res_0x7f090655);
            layoutParams3.leftMargin = BdUtilHelper.getDimens(context, R.dimen.tbds33);
            layoutParams3.bottomMargin = BdUtilHelper.getDimens(context, R.dimen.tbds25);
            addView(this.i, layoutParams3);
            EMManager.from(this.j).setTextSize(R.dimen.T_X09);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(8, R.id.obfuscated_res_0x7f090655);
            layoutParams4.addRule(11);
            layoutParams4.rightMargin = BdUtilHelper.getDimens(context, R.dimen.M_W_X006);
            layoutParams4.bottomMargin = BdUtilHelper.getDimens(context, R.dimen.M_H_X004);
            addView(this.j, layoutParams4);
            if (UbsABTestHelper.isFeedLiveCardStyleA()) {
                this.i.setVisibility(8);
                this.j.setVisibility(8);
                ViewGroup.LayoutParams layoutParams5 = this.k.getLayoutParams();
                if (layoutParams5 != null) {
                    RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) layoutParams5;
                    layoutParams6.width = BdUtilHelper.getDimens(context, R.dimen.tbds650);
                    layoutParams6.height = BdUtilHelper.getDimens(context, R.dimen.tbds813);
                    this.k.setLayoutParams(layoutParams6);
                    g(layoutParams6.width, layoutParams6.height);
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

    public static final void e(p47 state, CardLiveView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, state, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (state.m().f != null) {
                Function2<Context, p47, Unit> n = state.n();
                Context context = this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                n.invoke(context, state);
            }
            for (e87 e87Var : state.l()) {
                bc7.a.f(e87Var, state.k() + 1);
                state.j().invoke(e87Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.feed.component.CardRelativeView
    /* renamed from: d */
    public void a(final p47 state) {
        int width;
        int i;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            l77 m = state.m();
            boolean isFeedLiveCardStyleA = UbsABTestHelper.isFeedLiveCardStyleA();
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
            if (isFeedLiveCardStyleA) {
                width = (int) (equipmentWidth * 0.6f);
            } else {
                width = getWidth();
            }
            ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
            if (layoutParams != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.width = width;
                if (isFeedLiveCardStyleA) {
                    i = (width * 5) / 4;
                } else {
                    i = (width * 9) / 16;
                }
                layoutParams2.height = i;
                this.k.setLayoutParams(layoutParams2);
                g(layoutParams2.width, layoutParams2.height);
                this.d.f(this.k, m.d);
                this.h.setText(m.a);
                String str = m.b;
                Intrinsics.checkNotNullExpressionValue(str, "liveData.labelBottomLeft");
                if (str.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.i.setVisibility(0);
                    this.i.setText(m.b);
                } else {
                    this.i.setVisibility(8);
                }
                this.j.setText(m.c);
                e87 e87Var = m.e;
                if (e87Var != null) {
                    state.j().invoke(e87Var);
                }
                this.k.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.x37
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            CardLiveView.e(p47.this, this, view2);
                        }
                    }
                });
                f();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
    }

    @Override // com.baidu.tieba.lb7
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || mb7.a(this)) {
            return;
        }
        SkinManager.setLottieAnimation(this.g, R.raw.lottie_ala_live);
        EMManager.from(this.e).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0605);
        EMManager.from(this.f).setCorner(R.string.J_X07).setBackGroundColor(R.color.CAM_X0310);
        SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0101);
        EMManager.from(this.h).setTextSize(R.dimen.T_X09);
        EMManager.from(this.i).setCorner(R.string.J_X04).setTextColor(R.color.CAM_X0101).setBackGroundColor(R.color.CAM_X0606);
        EMManager.from(this.j).setTextColor(R.color.CAM_X0101);
    }

    public final void g(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            ViewGroup.LayoutParams layoutParams = this.l.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.l.setLayoutParams(layoutParams);
        }
    }
}
