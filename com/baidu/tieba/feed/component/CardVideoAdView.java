package com.baidu.tieba.feed.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tieba.R;
import com.baidu.tieba.bc7;
import com.baidu.tieba.c67;
import com.baidu.tieba.eb7;
import com.baidu.tieba.ic7;
import com.baidu.tieba.jc7;
import com.baidu.tieba.p77;
import com.baidu.tieba.z97;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u001b\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0002H\u0014J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020!H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0014R\u0014\u0010\u001c\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0014R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/baidu/tieba/feed/component/CardVideoAdView;", "Lcom/baidu/tieba/feed/component/CardRelativeView;", "Lcom/baidu/tieba/feed/component/uistate/CardVideoAdUiState;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "Lcom/baidu/tieba/feed/list/IGetVideoHolder;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cardVideoView", "Lcom/baidu/tieba/feed/component/CardVideoView;", "guideResolver", "Lcom/baidu/tieba/feed/compat/Resolver$IDownloadGuide;", "kotlin.jvm.PlatformType", "guideView", "Landroid/view/ViewGroup;", "horizontalVideoHeight", "", "getHorizontalVideoHeight", "()I", "horizontalVideoWidth", "getHorizontalVideoWidth", "textBottom", "Landroid/widget/TextView;", "textTopRight", "verticalVideoHeight", "getVerticalVideoHeight", "verticalVideoWidth", "getVerticalVideoWidth", "videoCoverView", "Landroid/view/View;", "doUpdateState", "", "state", "getVideoHolder", "", "onChangeSkin", "lib-templates_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CardVideoAdView extends CardRelativeView<p77> implements ic7, bc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CardVideoView c;
    public final View d;
    public final TextView e;
    public final TextView f;
    public final c67.g g;
    public ViewGroup h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CardVideoAdView(Context context) {
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
    public CardVideoAdView(Context context, AttributeSet attributeSet) {
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
        c67.g m = c67.a().m();
        this.g = m;
        ViewGroup create = m.create(context);
        Intrinsics.checkNotNullExpressionValue(create, "guideResolver.create(context)");
        this.h = create;
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01eb, this);
        View findViewById = findViewById(R.id.video_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.video_view)");
        CardVideoView cardVideoView = (CardVideoView) findViewById;
        this.c = cardVideoView;
        cardVideoView.setTopRoundCorner();
        View findViewById2 = findViewById(R.id.obfuscated_res_0x7f09290a);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.video_cover)");
        this.d = findViewById2;
        View findViewById3 = findViewById(R.id.obfuscated_res_0x7f092503);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.text_top_right)");
        this.e = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.text_bottom);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.text_bottom)");
        TextView textView = (TextView) findViewById4;
        this.f = textView;
        textView.setMovementMethod(eb7.a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, R.id.video_view);
        layoutParams.addRule(7, R.id.obfuscated_res_0x7f09290a);
        addView(this.h, layoutParams);
    }

    public /* synthetic */ CardVideoAdView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
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

    @Override // com.baidu.tieba.bc7
    public Object getVideoHolder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c.getVideoHolder();
        }
        return invokeV.objValue;
    }

    @Override // com.baidu.tieba.ic7
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || jc7.a(this)) {
            return;
        }
        this.c.b();
        EMManager.from(this.e).setTextColor(R.color.CAM_X0619);
        EMManager.from(this.f).setTextColor(R.color.CAM_X0619);
        this.g.a(this.h);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.feed.component.CardRelativeView
    /* renamed from: g */
    public void e(p77 state) {
        int horizontalVideoWidth;
        int horizontalVideoHeight;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.c.f(state.i());
            this.e.setText(state.k());
            this.f.setText(state.h());
            ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
            if (layoutParams != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                z97 l = state.i().l();
                if (l.d) {
                    horizontalVideoWidth = getVerticalVideoWidth();
                } else {
                    horizontalVideoWidth = getHorizontalVideoWidth();
                }
                layoutParams2.width = horizontalVideoWidth;
                if (l.d) {
                    horizontalVideoHeight = getVerticalVideoHeight();
                } else {
                    horizontalVideoHeight = getHorizontalVideoHeight();
                }
                layoutParams2.height = horizontalVideoHeight;
                this.d.setLayoutParams(layoutParams2);
                this.g.update(this.h, state.j());
                b();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
    }
}
