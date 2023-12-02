package com.baidu.tieba.forum.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewGroupKt;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tieba.R;
import com.baidu.tieba.c87;
import com.baidu.tieba.forum.view.TopCardView;
import com.baidu.tieba.i87;
import com.baidu.tieba.kb7;
import com.baidu.tieba.zm7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0014\u0018\u00002\u00020\u00012\u00020\u0002:\u0001<B'\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u0014H\u0002J\u001e\u0010'\u001a\u00020\u00142\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\r0)2\u0006\u0010*\u001a\u00020\u0014H\u0002J\b\u0010+\u001a\u00020%H\u0016J\b\u0010,\u001a\u00020%H\u0014J\u0010\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020\bH\u0002J\u0018\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020\bH\u0002J\u000e\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020\u001fJ\b\u00104\u001a\u00020%H\u0002J\b\u00105\u001a\u00020%H\u0002J\u001c\u00106\u001a\u00020%2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\r0\u001d2\u0006\u00107\u001a\u00020\u0017J,\u00108\u001a\u00020%2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\r0\u001d2\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\u0017R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/baidu/tieba/forum/view/TopCardView;", "Landroid/widget/RelativeLayout;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "collapsibleLayout", "Landroid/widget/LinearLayout;", "defaultData", "Lcom/baidu/tieba/feed/data/TopCardData;", "foldAnimator", "Landroid/animation/ValueAnimator;", "foldingView", "Landroid/widget/ImageView;", "foldingViewContent", "isShowCompleteCard", "", "mCollapsibleHeight", "mFid", "", "mFixedHeight", "mIsFolding", "mIsLiked", "mThemeColorInfo", "mTopCardDataList", "", "mUpdateFoldingListener", "Lcom/baidu/tieba/forum/view/TopCardView$IUpdateFoldingListener;", "unFoldAnimator", "getTopItemViewHeight", "topCardItemView", "Lcom/baidu/tieba/forum/view/TopCardItemView;", "initUI", "", "isAllRead", "isCanShowCompleteCard", "topCardDataList", "", "liked", "onChangeSkin", "onDetachedFromWindow", "refreshCollapsibleLayout", "collapsibleLayoutHeight", "setTopCardStyle", "itemView", "no", "setUpdateFoldingListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "startFoldAnimation", "startUnfoldAnimation", "updateLocalUI", "updateTid", "updateState", "foldStatus", "isLiked", "themeColorInfo", "IUpdateFoldingListener", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TopCardView extends RelativeLayout implements kb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public final LinearLayout b;
    public final ImageView c;
    public final LinearLayout d;
    public boolean e;
    public ValueAnimator f;
    public ValueAnimator g;
    public int h;
    public int i;
    public boolean j;
    public List<i87> k;
    public String l;
    public boolean m;
    public String n;
    public i87 o;

    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopCardView(Context context) {
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
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopCardView(Context context, AttributeSet attributeSet) {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopCardView(Context context, AttributeSet attributeSet, int i) {
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
        new LinkedHashMap();
        this.b = new LinearLayout(context);
        this.c = new ImageView(context);
        this.d = new LinearLayout(context);
        this.i = BdUtilHelper.getDimens(context, R.dimen.tbds100);
        this.k = new ArrayList();
        this.l = "";
        this.n = "";
        this.o = new i87();
        setPadding(0, BdUtilHelper.getDimens(context, R.dimen.M_H_X005), 0, 0);
        c();
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.no7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    TopCardView.a(TopCardView.this, view2);
                }
            }
        });
        f();
    }

    public /* synthetic */ TopCardView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final void a(TopCardView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int i = 1;
            boolean z = !this$0.e;
            this$0.e = z;
            a aVar = this$0.a;
            if (aVar != null) {
                aVar.a(z);
            }
            if (this$0.e) {
                this$0.i();
            } else {
                this$0.k();
                i = 2;
            }
            zm7.a(this$0.n, i);
        }
    }

    public final boolean e(List<i87> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, list, z)) == null) {
            if (!z) {
                return false;
            }
            for (i87 i87Var : list) {
                if (!i87Var.c() && !i87Var.b()) {
                    return true;
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public final void h(TopCardItemView topCardItemView, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048582, this, topCardItemView, i) != null) || this.k.size() <= 0) {
            return;
        }
        if (this.k.size() == 1) {
            z = true;
        } else {
            z = false;
        }
        if (i == 0) {
            topCardItemView.setViewStyle("top_card_view_style_first", z);
        } else if (i == this.k.size() - 1) {
            topCardItemView.setViewStyle("top_card_view_style_last", z);
        }
    }

    public static final void j(TopCardView this$0, ViewGroup.LayoutParams layoutParams, ValueAnimator valueAnimator) {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, this$0, layoutParams, valueAnimator) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ValueAnimator valueAnimator2 = this$0.f;
            if (valueAnimator2 != null) {
                obj = valueAnimator2.getAnimatedValue();
            } else {
                obj = null;
            }
            if (obj != null) {
                layoutParams.height = ((int) (((Float) obj).floatValue() * this$0.h)) + this$0.i;
                this$0.b.setLayoutParams(layoutParams);
                if (this$0.k.size() == 1) {
                    this$0.d.setVisibility(8);
                    return;
                }
                this$0.d.setVisibility(0);
                this$0.c.setImageResource(R.drawable.icon_mask_zhankai);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final void l(TopCardView this$0, ViewGroup.LayoutParams layoutParams, Ref.IntRef moreMargin, ValueAnimator valueAnimator) {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, null, this$0, layoutParams, moreMargin, valueAnimator) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(moreMargin, "$moreMargin");
            ValueAnimator valueAnimator2 = this$0.g;
            if (valueAnimator2 != null) {
                obj = valueAnimator2.getAnimatedValue();
            } else {
                obj = null;
            }
            if (obj != null) {
                layoutParams.height = ((int) (((Float) obj).floatValue() * this$0.h)) + this$0.i + moreMargin.element;
                this$0.b.setLayoutParams(layoutParams);
                this$0.c.setImageResource(R.drawable.icon_mask_shouqi);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public final int b(TopCardItemView topCardItemView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topCardItemView)) == null) {
            topCardItemView.setViewStyle("top_card_view_style_first", true);
            topCardItemView.measure(View.MeasureSpec.makeMeasureSpec(getContext().getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getContext().getResources().getDisplayMetrics().heightPixels, Integer.MIN_VALUE));
            return topCardItemView.getMeasuredHeight();
        }
        return invokeL.intValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            this.b.setOrientation(1);
            addView(this.b, layoutParams);
            this.c.setImageResource(R.drawable.icon_mask_zhankai);
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds42);
            this.d.addView(this.c, new LinearLayout.LayoutParams(dimens, dimens));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(BdUtilHelper.getDimens(getContext(), R.dimen.tbds84), BdUtilHelper.getDimens(getContext(), R.dimen.tbds70));
            layoutParams2.addRule(11);
            this.d.bringToFront();
            this.d.setPadding(0, BdUtilHelper.getDimens(getContext(), R.dimen.tbds10), 0, 0);
            this.d.setOrientation(1);
            this.d.setVisibility(8);
            addView(this.d, layoutParams2);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.removeAllViews();
            final ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
            TopCardItemView topCardItemView = new TopCardItemView(getContext(), null, 0, 6, null);
            topCardItemView.setData(this.o, false, this.l, this.j);
            topCardItemView.setViewStyle("top_card_view_style_first", true);
            this.b.addView(topCardItemView, new RelativeLayout.LayoutParams(-1, -2));
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.f = ofFloat;
            if (ofFloat != null) {
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.qo7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                            TopCardView.j(TopCardView.this, layoutParams, valueAnimator);
                        }
                    }
                });
            }
            ValueAnimator valueAnimator = this.f;
            if (valueAnimator != null) {
                valueAnimator.setDuration(300L);
            }
            ValueAnimator valueAnimator2 = this.f;
            if (valueAnimator2 != null) {
                valueAnimator2.start();
            }
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            for (i87 i87Var : this.k) {
                if (!i87Var.c()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDetachedFromWindow();
            ValueAnimator valueAnimator = this.g;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimator2 = this.g;
            if (valueAnimator2 != null) {
                valueAnimator2.removeAllUpdateListeners();
            }
            ValueAnimator valueAnimator3 = this.f;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
            }
            ValueAnimator valueAnimator4 = this.f;
            if (valueAnimator4 != null) {
                valueAnimator4.removeAllUpdateListeners();
            }
        }
    }

    @Override // com.baidu.tieba.kb7
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            EMManager.from(this).setCorner(R.string.J_X06).setBackGroundSelectorColor(R.color.CAM_X0205, R.color.CAM_X0206);
            int childCount = this.b.getChildCount();
            for (int i = 0; i < childCount; i++) {
                ((TopCardItemView) ViewGroupKt.get(this.b, i)).f();
            }
        }
    }

    public final void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
            layoutParams.height = i;
            this.b.setLayoutParams(layoutParams);
            this.h = layoutParams.height - this.i;
        }
    }

    public final void setUpdateFoldingListener(a listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, listener) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.a = listener;
        }
    }

    public final void k() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.b.removeAllViews();
            if (this.k.size() == 1) {
                z = true;
            } else {
                z = false;
            }
            final Ref.IntRef intRef = new Ref.IntRef();
            if (!d() && this.j) {
                int size = this.k.size();
                for (int i = 0; i < size; i++) {
                    TopCardItemView topCardItemView = new TopCardItemView(getContext(), null, 0, 6, null);
                    topCardItemView.setData(this.k.get(i), this.m, this.l, this.j);
                    if (i == 0) {
                        topCardItemView.setSplitViewVisible(false);
                        topCardItemView.setViewStyle("top_card_view_style_first", z);
                    } else if (i == this.k.size() - 1) {
                        topCardItemView.setViewStyle("top_card_view_style_last", z);
                    }
                    this.b.addView(topCardItemView, new RelativeLayout.LayoutParams(-1, -2));
                }
            } else {
                intRef.element = BdUtilHelper.getDimens(getContext(), R.dimen.tbds26);
                int size2 = this.k.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    TopCardItemView topCardItemView2 = new TopCardItemView(getContext(), null, 0, 6, null);
                    topCardItemView2.setData(this.k.get(i2), false, this.l, this.j);
                    topCardItemView2.setSplitViewVisible(false);
                    if (i2 == 0) {
                        topCardItemView2.setViewStyle("top_card_view_style_first", z);
                    } else if (i2 == this.k.size() - 1) {
                        topCardItemView2.setViewStyle("top_card_view_style_last", z);
                    }
                    this.b.addView(topCardItemView2, new RelativeLayout.LayoutParams(-1, -2));
                }
            }
            this.b.measure(View.MeasureSpec.makeMeasureSpec(getContext().getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getContext().getResources().getDisplayMetrics().heightPixels, Integer.MIN_VALUE));
            this.h = this.b.getMeasuredHeight() - this.i;
            final ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.g = ofFloat;
            if (ofFloat != null) {
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.mo7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                            TopCardView.l(TopCardView.this, layoutParams, intRef, valueAnimator);
                        }
                    }
                });
            }
            ValueAnimator valueAnimator = this.g;
            if (valueAnimator != null) {
                valueAnimator.setDuration(300L);
            }
            ValueAnimator valueAnimator2 = this.g;
            if (valueAnimator2 != null) {
                valueAnimator2.start();
            }
        }
    }

    public final void m(List<i87> topCardDataList, String updateTid) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, topCardDataList, updateTid) == null) {
            Intrinsics.checkNotNullParameter(topCardDataList, "topCardDataList");
            Intrinsics.checkNotNullParameter(updateTid, "updateTid");
            if (topCardDataList.size() <= 0) {
                return;
            }
            this.k = topCardDataList;
            int i = 0;
            if (this.m) {
                if (this.b.getChildCount() == 1 && this.k.size() == 1) {
                    this.d.setVisibility(8);
                    TopCardItemView topCardItemView = (TopCardItemView) ViewGroupKt.get(this.b, 0);
                    topCardItemView.h(false, this.j);
                    topCardItemView.setViewStyle("top_card_view_style_first", true);
                    g(b(topCardItemView));
                } else if (this.b.getChildCount() == 1) {
                    TopCardItemView topCardItemView2 = (TopCardItemView) ViewGroupKt.get(this.b, 0);
                    topCardItemView2.h(false, this.j);
                    this.c.setImageResource(R.drawable.icon_mask_zhankai);
                    this.e = true;
                    a aVar = this.a;
                    if (aVar != null) {
                        aVar.a(true);
                    }
                    g(b(topCardItemView2));
                } else if (d()) {
                    this.m = false;
                    int childCount = this.b.getChildCount();
                    int i2 = 0;
                    for (int i3 = 0; i3 < childCount; i3++) {
                        TopCardItemView topCardItemView3 = (TopCardItemView) ViewGroupKt.get(this.b, i3);
                        topCardItemView3.h(false, this.j);
                        h(topCardItemView3, i3);
                        i2 += b(topCardItemView3);
                    }
                    g(i2);
                } else {
                    int childCount2 = this.b.getChildCount();
                    while (true) {
                        if (i >= childCount2) {
                            break;
                        }
                        TopCardItemView topCardItemView4 = (TopCardItemView) ViewGroupKt.get(this.b, i);
                        if (Intrinsics.areEqual(updateTid, topCardItemView4.getTid())) {
                            topCardItemView4.h(true, this.j);
                            h(topCardItemView4, i);
                            break;
                        }
                        i++;
                    }
                }
            } else {
                int childCount3 = this.b.getChildCount();
                int i4 = 0;
                while (true) {
                    if (i4 >= childCount3) {
                        break;
                    }
                    TopCardItemView topCardItemView5 = (TopCardItemView) ViewGroupKt.get(this.b, i4);
                    if (Intrinsics.areEqual(updateTid, topCardItemView5.getTid())) {
                        topCardItemView5.h(false, this.j);
                        h(topCardItemView5, i4);
                        break;
                    }
                    i4++;
                }
            }
            requestLayout();
        }
    }

    public final void n(List<i87> topCardDataList, int i, boolean z, String themeColorInfo) {
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{topCardDataList, Integer.valueOf(i), Boolean.valueOf(z), themeColorInfo}) == null) {
            Intrinsics.checkNotNullParameter(topCardDataList, "topCardDataList");
            Intrinsics.checkNotNullParameter(themeColorInfo, "themeColorInfo");
            boolean z2 = true;
            if (i != 1 && i != 2) {
                this.b.removeAllViews();
                this.k = topCardDataList;
                this.j = z;
                this.l = themeColorInfo;
                c87 h = topCardDataList.get(0).h();
                if (h != null) {
                    l = Long.valueOf(h.d);
                } else {
                    l = null;
                }
                this.n = l.toString();
                if (!z || d()) {
                    if (topCardDataList.size() > 1) {
                        this.d.setVisibility(0);
                        this.c.setImageResource(R.drawable.icon_mask_zhankai);
                        this.e = true;
                    } else {
                        this.d.setVisibility(8);
                    }
                }
                this.m = e(topCardDataList, z);
                TopCardItemView topCardItemView = new TopCardItemView(getContext(), null, 0, 6, null);
                this.o = topCardDataList.get(0);
                Iterator<i87> it = topCardDataList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    i87 next = it.next();
                    if (!next.c()) {
                        this.o = next;
                        break;
                    }
                }
                Iterator<i87> it2 = topCardDataList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    i87 next2 = it2.next();
                    if (!next2.c() && !next2.b()) {
                        this.o = next2;
                        break;
                    }
                }
                if (this.m) {
                    this.d.setVisibility(0);
                    this.c.setImageResource(R.drawable.icon_mask_shouqi);
                    this.e = false;
                    a aVar = this.a;
                    if (aVar != null) {
                        aVar.a(false);
                    }
                } else if (topCardDataList.size() > 1) {
                    this.d.setVisibility(0);
                    this.c.setImageResource(R.drawable.icon_mask_zhankai);
                    this.e = true;
                    a aVar2 = this.a;
                    if (aVar2 != null) {
                        aVar2.a(true);
                    }
                }
                topCardItemView.setData(this.o, this.m, this.l, this.j);
                topCardItemView.setViewStyle("top_card_view_style_first", true);
                topCardItemView.setSplitViewVisible(false);
                this.b.addView(topCardItemView, new RelativeLayout.LayoutParams(-1, -2));
                topCardItemView.measure(View.MeasureSpec.makeMeasureSpec(getContext().getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getContext().getResources().getDisplayMetrics().heightPixels, Integer.MIN_VALUE));
                g(topCardItemView.getMeasuredHeight());
                this.h = topCardItemView.getMeasuredHeight() - this.i;
                requestLayout();
                f();
                return;
            }
            if (i != 2) {
                z2 = false;
            }
            this.e = z2;
        }
    }
}
