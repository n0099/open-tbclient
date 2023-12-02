package com.baidu.tieba.feed.component;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.a87;
import com.baidu.tieba.ac7;
import com.baidu.tieba.e87;
import com.baidu.tieba.feed.component.CardReplyView;
import com.baidu.tieba.feed.widget.HeadImageView;
import com.baidu.tieba.j37;
import com.baidu.tieba.j55;
import com.baidu.tieba.kb7;
import com.baidu.tieba.ld7;
import com.baidu.tieba.tua;
import com.baidu.tieba.w47;
import com.baidu.tieba.yd7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0016J\b\u0010\u001f\u001a\u00020\u0018H\u0002J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"H\u0002J\u000e\u0010#\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010$\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/baidu/tieba/feed/component/CardReplyView;", "Landroid/widget/RelativeLayout;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "agreeContainer", "Landroid/widget/FrameLayout;", "agreeResolver", "Lcom/baidu/tieba/feed/compat/Resolver$IAgreeView;", "kotlin.jvm.PlatformType", "agreeView", "Landroid/view/ViewGroup;", "imgHead", "Lcom/baidu/tieba/feed/widget/HeadImageView;", "imgSignetProxy", "Lcom/baidu/tieba/feed/widget/FeedImageViewProxy;", "replyContent", "Landroid/widget/TextView;", "root", TbEnum.SystemMessage.KEY_USER_NAME, "doStat", "", "state", "Lcom/baidu/tieba/feed/component/uistate/CardReplyUiState;", "statDataList", "", "Lcom/baidu/tieba/feed/data/StatData;", "onChangeSkin", "resetContentProperties", "updateContentWithTag", "replyData", "Lcom/baidu/tieba/feed/data/ReplyData;", "updateState", "updateTagState", "updateViewVisibilityWithTagState", "visibility", "", "lib-templates_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CardReplyView extends RelativeLayout implements kb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RelativeLayout a;
    public final HeadImageView b;
    public final TextView c;
    public final TextView d;
    public final FrameLayout e;
    public final yd7 f;
    public final j37.e g;
    public final ViewGroup h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CardReplyView(Context context) {
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
    public CardReplyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ImageView imageView;
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
        j37.e e = j37.a().e();
        this.g = e;
        ViewGroup create = e.create(context);
        Intrinsics.checkNotNullExpressionValue(create, "agreeResolver.create(context)");
        this.h = create;
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01ee, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f09206b);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.root)");
        this.a = (RelativeLayout) findViewById;
        View findViewById2 = findViewById(R.id.user_avatar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.user_avatar)");
        this.b = (HeadImageView) findViewById2;
        View findViewById3 = findViewById(R.id.user_name);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.user_name)");
        this.c = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.god_reply_content);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.god_reply_content)");
        this.d = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.obfuscated_res_0x7f090177);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.agree_container)");
        FrameLayout frameLayout = (FrameLayout) findViewById5;
        this.e = frameLayout;
        frameLayout.addView(this.h);
        this.f = new yd7(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds172), -2);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.setMargins(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds156), 0);
        View h = this.f.h();
        if (h instanceof ImageView) {
            imageView = (ImageView) h;
        } else {
            imageView = null;
        }
        if (imageView != null) {
            imageView.setAdjustViewBounds(true);
        }
        addView(this.f.h(), layoutParams);
    }

    public /* synthetic */ CardReplyView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final void e(w47 state, CardReplyView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, state, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Function2<Context, String, Unit> i = state.i();
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            i.invoke(context, state.m());
            this$0.a(state, state.q());
        }
    }

    public static final void g(w47 state, CardReplyView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, state, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Function2<Context, String, Unit> i = state.i();
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            i.invoke(context, state.m());
            this$0.a(state, state.r());
        }
    }

    public static final void h(w47 state, CardReplyView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, state, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Function2<Context, w47, Unit> n = state.n();
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            n.invoke(context, state);
            this$0.a(state, state.l());
        }
    }

    public final void a(w47 w47Var, List<e87> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, w47Var, list) == null) {
            for (e87 e87Var : list) {
                ac7.a.f(e87Var, w47Var.k() + 1);
                w47Var.j().invoke(e87Var);
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d.setTextSize(0, BdUtilHelper.getDimens(getContext(), R.dimen.tbfontsize40));
            this.d.setMaxLines(15);
        }
    }

    public final void c(a87 a87Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, a87Var) == null) {
            String f = a87Var.f();
            if (f == null) {
                f = "";
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a87Var.b());
            spannableStringBuilder.insert(0, (CharSequence) f);
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.L_X01);
            int dimens2 = BdUtilHelper.getDimens(getContext(), R.dimen.T_X10);
            int dimens3 = BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X002);
            int dimens4 = BdUtilHelper.getDimens(getContext(), R.dimen.tbds1);
            int dimens5 = BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X002);
            int dimens6 = BdUtilHelper.getDimens(getContext(), R.dimen.tbds42);
            int d = tua.d(getContext(), a87Var.g());
            j55 j55Var = new j55(dimens, (int) R.string.J_X04, d, dimens2, d, dimens3, dimens6);
            j55Var.i(dimens5);
            j55Var.h(dimens4);
            spannableStringBuilder.setSpan(j55Var, 0, f.length(), 17);
            this.d.setTextSize(0, BdUtilHelper.getDimens(getContext(), R.dimen.T_X07));
            this.d.setMaxLines(2);
            this.d.setText(spannableStringBuilder);
        }
    }

    public final void d(final w47 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            a87 o = state.o();
            this.b.j(o.d());
            this.b.i(o.c());
            this.b.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.y37
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        CardReplyView.e(w47.this, this, view2);
                    }
                }
            });
            this.c.setText(o.h());
            this.c.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.i47
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        CardReplyView.g(w47.this, this, view2);
                    }
                }
            });
            this.d.setText(o.b());
            this.g.j(this.h, o.a());
            ld7.b(this.f.h(), state.o().e());
            this.a.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.l37
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        CardReplyView.h(w47.this, this, view2);
                    }
                }
            });
            i(o);
            f();
        }
    }

    @Override // com.baidu.tieba.kb7
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b.f();
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            this.g.b(this.h);
            EMManager.from(this).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
        }
    }

    public final void i(a87 a87Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, a87Var) == null) {
            if (a87Var.i()) {
                j(8);
                c(a87Var);
                return;
            }
            j(0);
            b();
        }
    }

    public final void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.b.setVisibility(i);
            this.c.setVisibility(i);
            this.f.h().setVisibility(i);
            this.e.setVisibility(i);
        }
    }
}
