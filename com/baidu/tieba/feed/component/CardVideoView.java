package com.baidu.tieba.feed.component;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.feed.component.CardVideoView;
import com.baidu.tieba.g35;
import com.baidu.tieba.ii;
import com.baidu.tieba.l17;
import com.baidu.tieba.m17;
import com.baidu.tieba.nz6;
import com.baidu.tieba.oz6;
import com.baidu.tieba.sw6;
import com.baidu.tieba.xx6;
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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001b\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0002H\u0014J\b\u0010 \u001a\u00020\u001eH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000eR\u0014\u0010\u0019\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000eR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/baidu/tieba/feed/component/CardVideoView;", "Lcom/baidu/tieba/feed/component/CardFrameView;", "Lcom/baidu/tieba/feed/component/uistate/CardVideoUiState;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bottomInfo", "Landroid/widget/TextView;", "horizontalVideoHeight", "", "getHorizontalVideoHeight", "()I", "horizontalVideoWidth", "getHorizontalVideoWidth", "imgFirstFrame", "Landroid/widget/ImageView;", "playBtn", "resolver", "Lcom/baidu/tieba/feed/compat/WidgetResolver$NetImageViewCreator;", "kotlin.jvm.PlatformType", "verticalVideoHeight", "getVerticalVideoHeight", "verticalVideoWidth", "getVerticalVideoWidth", "videoContainer", "Landroid/widget/FrameLayout;", "doUpdateState", "", "state", "onChangeSkin", "lib-templates_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CardVideoView extends CardFrameView<xx6> implements l17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final sw6.d c;
    public final FrameLayout d;
    public final ImageView e;
    public final ImageView f;
    public final TextView g;

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
        this.c = sw6.a().a();
        this.d = new FrameLayout(context);
        View create = this.c.create(context);
        if (create != null) {
            this.e = (ImageView) create;
            this.f = new ImageView(context);
            this.g = new TextView(context);
            addView(this.d, new FrameLayout.LayoutParams(-1, -1));
            this.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.d.addView(this.e, new FrameLayout.LayoutParams(-1, -1));
            int g = ii.g(context, R.dimen.tbds114);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g, g);
            layoutParams.gravity = 17;
            this.d.addView(this.f, layoutParams);
            g35.d(this.g).B(R.dimen.tbds34);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 85;
            layoutParams2.rightMargin = ii.g(context, R.dimen.M_W_X007);
            layoutParams2.bottomMargin = ii.g(context, R.dimen.tbds30);
            this.d.addView(this.g, layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    }

    public /* synthetic */ CardVideoView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    private final int getHorizontalVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            return (getWidth() / 16) * 9;
        }
        return invokeV.intValue;
    }

    private final int getHorizontalVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            return getWidth();
        }
        return invokeV.intValue;
    }

    private final int getVerticalVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            return (getVerticalVideoWidth() / 3) * 4;
        }
        return invokeV.intValue;
    }

    private final int getVerticalVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            return (getHorizontalVideoWidth() * 2) / 3;
        }
        return invokeV.intValue;
    }

    public static final void h(xx6 state, CardVideoView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, state, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            state.c().invoke(state.f());
            Rect rect = new Rect();
            this$0.getGlobalVisibleRect(rect);
            Function3<Context, Rect, oz6, Unit> d = state.d();
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            d.invoke(context, rect, state.e());
        }
    }

    @Override // com.baidu.tieba.l17
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || m17.a(this)) {
            return;
        }
        this.f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        g35 d = g35.d(this.g);
        d.w(R.color.CAM_X0101);
        d.A(R.array.S_O_X001);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.feed.component.CardFrameView
    /* renamed from: g */
    public void e(final xx6 state) {
        int horizontalVideoWidth;
        int horizontalVideoHeight;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            nz6 g = state.g();
            ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
            if (layoutParams != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                if (g.b) {
                    horizontalVideoWidth = getVerticalVideoWidth();
                } else {
                    horizontalVideoWidth = getHorizontalVideoWidth();
                }
                layoutParams2.width = horizontalVideoWidth;
                if (g.b) {
                    horizontalVideoHeight = getVerticalVideoHeight();
                } else {
                    horizontalVideoHeight = getHorizontalVideoHeight();
                }
                layoutParams2.height = horizontalVideoHeight;
                this.d.setLayoutParams(layoutParams2);
                sw6.c cVar = new sw6.c();
                cVar.a = R.string.J_X05;
                cVar.b = 15;
                this.c.b(this.e, cVar);
                this.c.e(this.e, g.a);
                this.g.setText(g.c);
                if (!state.e().d()) {
                    setClickable(false);
                } else {
                    setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.bx6
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                CardVideoView.h(xx6.this, this, view2);
                            }
                        }
                    });
                }
                b();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
    }
}
