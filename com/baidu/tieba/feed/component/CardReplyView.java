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
import com.baidu.tieba.b55;
import com.baidu.tieba.bqa;
import com.baidu.tieba.f47;
import com.baidu.tieba.feed.component.CardReplyView;
import com.baidu.tieba.feed.widget.HeadImageView;
import com.baidu.tieba.hd7;
import com.baidu.tieba.j77;
import com.baidu.tieba.jb7;
import com.baidu.tieba.n77;
import com.baidu.tieba.ta7;
import com.baidu.tieba.u27;
import com.baidu.tieba.uc7;
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
public final class CardReplyView extends RelativeLayout implements ta7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RelativeLayout a;
    public final HeadImageView b;
    public final TextView c;
    public final TextView d;
    public final FrameLayout e;
    public final hd7 f;
    public final u27.e g;
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
        u27.e e = u27.a().e();
        this.g = e;
        ViewGroup create = e.create(context);
        Intrinsics.checkNotNullExpressionValue(create, "agreeResolver.create(context)");
        this.h = create;
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01e8, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f091ff2);
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
        this.f = new hd7(context);
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

    public static final void e(f47 state, CardReplyView this$0, View view2) {
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

    public static final void f(f47 state, CardReplyView this$0, View view2) {
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

    public static final void g(f47 state, CardReplyView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, state, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Function2<Context, f47, Unit> n = state.n();
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            n.invoke(context, state);
            this$0.a(state, state.l());
        }
    }

    public final void a(f47 f47Var, List<n77> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, f47Var, list) == null) {
            for (n77 n77Var : list) {
                jb7.a.f(n77Var, f47Var.k() + 1);
                f47Var.j().invoke(n77Var);
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

    public final void c(j77 j77Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, j77Var) == null) {
            String f = j77Var.f();
            if (f == null) {
                f = "";
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(j77Var.b());
            spannableStringBuilder.insert(0, (CharSequence) f);
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.L_X01);
            int dimens2 = BdUtilHelper.getDimens(getContext(), R.dimen.T_X10);
            int dimens3 = BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X002);
            int dimens4 = BdUtilHelper.getDimens(getContext(), R.dimen.tbds1);
            int dimens5 = BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X002);
            int dimens6 = BdUtilHelper.getDimens(getContext(), R.dimen.tbds42);
            int d = bqa.d(getContext(), j77Var.g());
            b55 b55Var = new b55(dimens, (int) R.string.J_X04, d, dimens2, d, dimens3, dimens6);
            b55Var.i(dimens5);
            b55Var.h(dimens4);
            spannableStringBuilder.setSpan(b55Var, 0, f.length(), 17);
            this.d.setTextSize(0, BdUtilHelper.getDimens(getContext(), R.dimen.T_X07));
            this.d.setMaxLines(2);
            this.d.setText(spannableStringBuilder);
        }
    }

    public final void d(final f47 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            j77 o = state.o();
            this.b.i(o.d());
            this.b.h(o.c());
            this.b.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.i37
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        CardReplyView.e(f47.this, this, view2);
                    }
                }
            });
            this.c.setText(o.h());
            this.c.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.r37
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        CardReplyView.f(f47.this, this, view2);
                    }
                }
            });
            this.d.setText(o.b());
            this.g.j(this.h, o.a());
            uc7.b(this.f.h(), state.o().e());
            this.a.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w27
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        CardReplyView.g(f47.this, this, view2);
                    }
                }
            });
            h(o);
            r();
        }
    }

    public final void h(j77 j77Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, j77Var) == null) {
            if (j77Var.i()) {
                i(8);
                c(j77Var);
                return;
            }
            i(0);
            b();
        }
    }

    public final void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.b.setVisibility(i);
            this.c.setVisibility(i);
            this.f.h().setVisibility(i);
            this.e.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.ta7
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.b.r();
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            this.g.b(this.h);
            EMManager.from(this).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
        }
    }
}
