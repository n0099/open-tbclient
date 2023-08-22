package com.baidu.tieba.feed.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.b67;
import com.baidu.tieba.cb7;
import com.baidu.tieba.d67;
import com.baidu.tieba.db7;
import com.baidu.tieba.e67;
import com.baidu.tieba.feed.component.CardOriginCardView;
import com.baidu.tieba.l67;
import com.baidu.tieba.r87;
import com.baidu.tieba.x57;
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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/baidu/tieba/feed/component/CardOriginCardView;", "Landroid/widget/LinearLayout;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "abstractView", "Lcom/baidu/tieba/feed/component/CardAbstractView;", "cardVideoView", "Lcom/baidu/tieba/feed/component/CardVideoView;", "mountAppView", "Lcom/baidu/tieba/feed/component/CardAppView;", "mountView", "Lcom/baidu/tieba/feed/component/CardMountView;", "picView", "Lcom/baidu/tieba/feed/component/CardPicView;", "onChangeSkin", "", "updateState", "state", "Lcom/baidu/tieba/feed/component/uistate/CardOriginCardUiState;", "lib-templates_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CardOriginCardView extends LinearLayout implements cb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CardAbstractView a;
    public final CardPicView b;
    public final CardVideoView c;
    public final CardMountView d;
    public final CardAppView e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CardOriginCardView(Context context) {
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
    public CardOriginCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = new CardAbstractView(context, null, 2, null);
        this.b = new CardPicView(context);
        this.c = new CardVideoView(context, null, 2, null);
        this.d = new CardMountView(context, null, 2, null);
        this.e = new CardAppView(context, null, 2, null);
        setOrientation(1);
        addView(this.a, new LinearLayout.LayoutParams(-1, -2));
        addView(this.b, new LinearLayout.LayoutParams(-1, -2));
        addView(this.c, new LinearLayout.LayoutParams(-1, -2));
        addView(this.d, new LinearLayout.LayoutParams(-1, -2));
        addView(this.e, new LinearLayout.LayoutParams(-1, -2));
        int dimens = BdUtilHelper.getDimens(context, R.dimen.M_W_X005);
        setPadding(dimens, dimens, dimens, dimens);
    }

    public /* synthetic */ CardOriginCardView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final void b(d67 state, CardOriginCardView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, state, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Function2<Context, d67, Unit> m = state.m();
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            m.invoke(context, state);
            r87 o = state.o();
            if (o != null) {
                state.f().invoke(o);
            }
        }
    }

    public final void a(final d67 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.a.f(state.h());
            this.b.setVisibility(8);
            this.c.setVisibility(8);
            this.d.setVisibility(8);
            this.e.setVisibility(8);
            e67 k = state.k();
            if (k != null) {
                this.b.setVisibility(0);
                this.b.f(k);
            }
            l67 l = state.l();
            if (l != null) {
                this.c.setVisibility(0);
                this.c.f(l);
            }
            b67 j = state.j();
            if (j != null) {
                this.d.setVisibility(0);
                this.d.a(j);
            }
            x57 i = state.i();
            if (i != null) {
                this.e.setVisibility(0);
                this.e.a(i);
            }
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.i57
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        CardOriginCardView.b(d67.this, this, view2);
                    }
                }
            });
            c();
        }
    }

    @Override // com.baidu.tieba.cb7
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || db7.a(this)) {
            return;
        }
        SkinManager.setBackgroundColor(this, R.color.CAM_X0206);
        this.a.c();
        this.c.c();
        this.d.c();
        this.e.c();
    }
}
