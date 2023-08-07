package com.baidu.tieba.feed.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.R;
import com.baidu.tieba.aa7;
import com.baidu.tieba.c77;
import com.baidu.tieba.feed.component.CardReplyView;
import com.baidu.tieba.feed.widget.HeadImageView;
import com.baidu.tieba.j37;
import com.baidu.tieba.jb7;
import com.baidu.tieba.n97;
import com.baidu.tieba.r47;
import com.baidu.tieba.y67;
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
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u0017H\u0016J\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/baidu/tieba/feed/component/CardReplyView;", "Landroid/widget/RelativeLayout;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "agreeContainer", "Landroid/widget/FrameLayout;", "agreeResolver", "Lcom/baidu/tieba/feed/compat/Resolver$IAgreeView;", "kotlin.jvm.PlatformType", "agreeView", "Landroid/view/ViewGroup;", "imgHead", "Lcom/baidu/tieba/feed/widget/HeadImageView;", "imgSignet", "Landroid/widget/ImageView;", "replyContent", "Landroid/widget/TextView;", TbEnum.SystemMessage.KEY_USER_NAME, "doStat", "", "state", "Lcom/baidu/tieba/feed/component/uistate/CardReplyUiState;", "statDataList", "", "Lcom/baidu/tieba/feed/data/StatData;", "onChangeSkin", "updateState", "lib-templates_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CardReplyView extends RelativeLayout implements n97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HeadImageView a;
    public final TextView b;
    public final TextView c;
    public final FrameLayout d;
    public final ImageView e;
    public final j37.e f;
    public final ViewGroup g;

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
        this.f = e;
        ViewGroup create = e.create(context);
        Intrinsics.checkNotNullExpressionValue(create, "agreeResolver.create(context)");
        this.g = create;
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01dc, this);
        View findViewById = findViewById(R.id.user_avatar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.user_avatar)");
        this.a = (HeadImageView) findViewById;
        View findViewById2 = findViewById(R.id.user_name);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.user_name)");
        this.b = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.god_reply_content);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.god_reply_content)");
        this.c = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.obfuscated_res_0x7f090163);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.agree_container)");
        FrameLayout frameLayout = (FrameLayout) findViewById4;
        this.d = frameLayout;
        frameLayout.addView(this.g);
        View findViewById5 = findViewById(R.id.obfuscated_res_0x7f0910fe);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.img_signet)");
        this.e = (ImageView) findViewById5;
    }

    public /* synthetic */ CardReplyView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final void d(r47 state, CardReplyView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, state, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Function2<Context, String, Unit> e = state.e();
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            e.invoke(context, state.i());
            this$0.a(state, state.l());
        }
    }

    public static final void e(r47 state, CardReplyView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, state, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Function2<Context, String, Unit> e = state.e();
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            e.invoke(context, state.i());
            this$0.a(state, state.m());
        }
    }

    public static final void f(r47 state, CardReplyView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, state, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Function2<Context, String, Unit> e = state.e();
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            e.invoke(context, state.k());
            this$0.a(state, state.h());
        }
    }

    public final void a(r47 r47Var, List<c77> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, r47Var, list) == null) {
            for (c77 c77Var : list) {
                aa7.a.b(c77Var, r47Var.g() + 1);
                r47Var.f().invoke(c77Var);
            }
        }
    }

    public final void b(final r47 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            y67 j = state.j();
            this.a.j(j.d());
            this.a.i(j.c());
            this.a.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.x37
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        CardReplyView.d(r47.this, this, view2);
                    }
                }
            });
            this.b.setText(j.f());
            this.b.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e47
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        CardReplyView.e(r47.this, this, view2);
                    }
                }
            });
            this.c.setText(j.b());
            this.f.update(this.g, j.a());
            jb7.a(this.e, state.j().e());
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.m37
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        CardReplyView.f(r47.this, this, view2);
                    }
                }
            });
            c();
        }
    }

    @Override // com.baidu.tieba.n97
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.c();
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
            this.f.a(this.g);
            EMManager.from(this).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
        }
    }
}
