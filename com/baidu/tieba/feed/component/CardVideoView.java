package com.baidu.tieba.feed.component;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.b57;
import com.baidu.tieba.bc7;
import com.baidu.tieba.e87;
import com.baidu.tieba.eb7;
import com.baidu.tieba.feed.component.CardVideoView;
import com.baidu.tieba.feed.widget.roundcorners.RoundFrameLayout;
import com.baidu.tieba.j37;
import com.baidu.tieba.l87;
import com.baidu.tieba.lb7;
import com.baidu.tieba.mb7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u001b\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0002H\u0014J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001cH\u0016J\u0006\u0010!\u001a\u00020\u001cJ\u000e\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0002R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \u0018*\u0004\u0018\u00010\u00170\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/baidu/tieba/feed/component/CardVideoView;", "Lcom/baidu/tieba/feed/component/CardFrameView;", "Lcom/baidu/tieba/feed/component/uistate/CardVideoUiState;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "Lcom/baidu/tieba/feed/list/IGetVideoHolder;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "horizontalVideoHeight", "", "getHorizontalVideoHeight", "()I", "horizontalVideoWidth", "getHorizontalVideoWidth", "verticalVideoHeight", "getVerticalVideoHeight", "verticalVideoWidth", "getVerticalVideoWidth", "videoHolder", "Lcom/baidu/tieba/feed/compat/Resolver$IVideoHolder;", "videoResolver", "Lcom/baidu/tieba/feed/compat/Resolver$IVideoContainer;", "kotlin.jvm.PlatformType", "videoRootView", "Lcom/baidu/tieba/feed/widget/roundcorners/RoundFrameLayout;", "doUpdateState", "", "state", "getVideoHolder", "", "onChangeSkin", "setTopRoundCorner", "updateStateDirectly", "lib-templates_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CardVideoView extends CardFrameView<b57> implements lb7, eb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final j37.q d;
    public j37.r e;
    public final RoundFrameLayout f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CardVideoView(Context context) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CardVideoView(Context context, AttributeSet attributeSet) {
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
        this.d = j37.a().c();
        RoundFrameLayout roundFrameLayout = new RoundFrameLayout(context);
        this.f = roundFrameLayout;
        roundFrameLayout.setRadiusPx(BdUtilHelper.getDimens(context, R.dimen.tbds21));
        addView(this.f, new FrameLayout.LayoutParams(-1, -1));
        j37.r b = this.d.b(getContext(), this.f);
        Intrinsics.checkNotNullExpressionValue(b, "videoResolver.create(getContext(), videoRootView)");
        this.e = b;
    }

    public /* synthetic */ CardVideoView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final void d(b57 state, CardVideoView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, state, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (e87 e87Var : state.o()) {
                bc7.a.f(e87Var, state.k() + 1);
                state.j().invoke(e87Var);
            }
            Rect rect = new Rect();
            this$0.getGlobalVisibleRect(rect);
            Function3<Context, Rect, b57, Unit> m = state.m();
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            m.invoke(context, rect, state);
        }
    }

    private final int getHorizontalVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            return (getMeasuredWidth() / 16) * 9;
        }
        return invokeV.intValue;
    }

    private final int getHorizontalVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            return getMeasuredWidth();
        }
        return invokeV.intValue;
    }

    private final int getVerticalVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            return (getVerticalVideoWidth() / 3) * 4;
        }
        return invokeV.intValue;
    }

    private final int getVerticalVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            return (getHorizontalVideoWidth() * 2) / 3;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.lb7
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || mb7.a(this)) {
            return;
        }
        this.e.onChangeSkinType();
    }

    @Override // com.baidu.tieba.eb7
    public Object getVideoHolder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return invokeV.objValue;
    }

    public final void setTopRoundCorner() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds21);
            this.f.setRadiusPx(dimens, dimens, 0, 0);
        }
    }

    public final void e(b57 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            a(state);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.feed.component.CardFrameView
    /* renamed from: c */
    public void a(final b57 state) {
        int horizontalVideoWidth;
        int horizontalVideoHeight;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            l87 p = state.p();
            ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
            if (layoutParams != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                if (p.d) {
                    horizontalVideoWidth = getVerticalVideoWidth();
                } else {
                    horizontalVideoWidth = getHorizontalVideoWidth();
                }
                layoutParams2.width = horizontalVideoWidth;
                if (p.d) {
                    horizontalVideoHeight = getVerticalVideoHeight();
                } else {
                    horizontalVideoHeight = getHorizontalVideoHeight();
                }
                layoutParams2.height = horizontalVideoHeight;
                this.f.setLayoutParams(layoutParams2);
                this.d.a(this.e, state);
                if (!state.n().f()) {
                    setClickable(false);
                } else {
                    this.f.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u37
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                CardVideoView.d(b57.this, this, view2);
                            }
                        }
                    });
                }
                f();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
    }
}
