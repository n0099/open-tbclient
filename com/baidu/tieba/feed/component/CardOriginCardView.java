package com.baidu.tieba.feed.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.b57;
import com.baidu.tieba.e87;
import com.baidu.tieba.feed.component.CardOriginCardView;
import com.baidu.tieba.kb7;
import com.baidu.tieba.lb7;
import com.baidu.tieba.m47;
import com.baidu.tieba.q47;
import com.baidu.tieba.s47;
import com.baidu.tieba.u47;
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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/baidu/tieba/feed/component/CardOriginCardView;", "Landroid/widget/LinearLayout;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "abstractView", "Lcom/baidu/tieba/feed/component/CardAbstractView;", "cardVideoView", "Lcom/baidu/tieba/feed/component/CardVideoView;", "contentLayout", "mountAppView", "Lcom/baidu/tieba/feed/component/CardAppView;", "mountView", "Lcom/baidu/tieba/feed/component/CardMountView;", "picView", "Lcom/baidu/tieba/feed/component/CardPicView;", "onChangeSkin", "", "updateState", "state", "Lcom/baidu/tieba/feed/component/uistate/CardOriginCardUiState;", "lib-templates_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CardOriginCardView extends LinearLayout implements kb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinearLayout a;
    public final CardAbstractView b;
    public final CardPicView c;
    public final CardVideoView d;
    public final CardMountView e;
    public final CardAppView f;

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
        this.a = new LinearLayout(context);
        this.b = new CardAbstractView(context, null, 2, null);
        this.c = new CardPicView(context);
        this.d = new CardVideoView(context, null, 2, null);
        this.e = new CardMountView(context, null, 2, null);
        this.f = new CardAppView(context, null, 2, null);
        this.a.setOrientation(1);
        setOrientation(1);
        addView(this.a, new LinearLayout.LayoutParams(-1, -2));
        this.a.addView(this.b, new LinearLayout.LayoutParams(-1, -2));
        this.a.addView(this.c, new LinearLayout.LayoutParams(-1, -2));
        this.a.addView(this.d, new LinearLayout.LayoutParams(-1, -2));
        this.a.addView(this.e, new LinearLayout.LayoutParams(-1, -2));
        this.a.addView(this.f, new LinearLayout.LayoutParams(-1, -2));
        int dimens = BdUtilHelper.getDimens(context, R.dimen.M_W_X005);
        setPadding(dimens, dimens, dimens, dimens);
    }

    public /* synthetic */ CardOriginCardView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final void b(s47 state, CardOriginCardView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, state, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Function2<Context, s47, Unit> q = state.q();
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            q.invoke(context, state);
            e87 s = state.s();
            if (s != null) {
                state.j().invoke(s);
            }
        }
    }

    public final void a(final s47 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.b.b(state.l());
            this.c.setVisibility(8);
            this.d.setVisibility(8);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
            u47 o = state.o();
            if (o != null) {
                this.c.setVisibility(0);
                this.c.b(o);
            }
            b57 p = state.p();
            if (p != null) {
                this.d.setVisibility(0);
                this.d.b(p);
            }
            q47 n = state.n();
            if (n != null) {
                this.e.setVisibility(0);
                this.e.a(n);
            }
            m47 m = state.m();
            if (m != null) {
                this.f.setVisibility(0);
                this.f.a(m);
            }
            this.a.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.v37
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        CardOriginCardView.b(s47.this, this, view2);
                    }
                }
            });
            f();
        }
    }

    @Override // com.baidu.tieba.kb7
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || lb7.a(this)) {
            return;
        }
        SkinManager.setBackgroundColor(this, R.color.CAM_X0206);
        this.b.f();
        this.d.f();
        this.e.f();
        this.f.f();
    }
}
