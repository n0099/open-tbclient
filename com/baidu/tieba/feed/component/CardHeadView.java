package com.baidu.tieba.feed.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.b97;
import com.baidu.tieba.c77;
import com.baidu.tieba.f87;
import com.baidu.tieba.fc7;
import com.baidu.tieba.feed.component.CardHeadView;
import com.baidu.tieba.feed.widget.AutoDegradeTagView;
import com.baidu.tieba.feed.widget.ForumAttentionView;
import com.baidu.tieba.feed.widget.HeadImageView;
import com.baidu.tieba.feed.widget.PersonAttentionView;
import com.baidu.tieba.g87;
import com.baidu.tieba.gc7;
import com.baidu.tieba.n87;
import com.baidu.tieba.sc7;
import com.baidu.tieba.u87;
import com.baidu.tieba.u97;
import com.baidu.tieba.yi;
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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/baidu/tieba/feed/component/CardHeadView;", "Landroid/widget/RelativeLayout;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "attentionView", "Lcom/baidu/tieba/feed/widget/PersonAttentionView;", "feedBackBtn", "Landroid/widget/ImageView;", "forumAttentionView", "Lcom/baidu/tieba/feed/widget/ForumAttentionView;", "headExtendInfo", "Lcom/baidu/tieba/feed/widget/AutoDegradeTagView;", "headImageView", "Lcom/baidu/tieba/feed/widget/HeadImageView;", "headMainView", "headRightLayout", "Landroid/widget/LinearLayout;", "initAttentionView", "", "initFeedBackBtn", "initHeadInfoLayout", "initImageView", "initRightLayout", "onChangeSkin", "updateState", "uiState", "Lcom/baidu/tieba/feed/component/uistate/CardHeadUiState;", "lib-templates_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CardHeadView extends RelativeLayout implements fc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView a;
    public AutoDegradeTagView b;
    public AutoDegradeTagView c;
    public LinearLayout d;
    public ImageView e;
    public PersonAttentionView f;
    public ForumAttentionView g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CardHeadView(Context context) {
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
    public static final class a implements AutoDegradeTagView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c77 a;

        public a(c77 c77Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c77Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c77Var;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
            if (((r0 == null || r0.length() == 0) ? true : true) == false) goto L30;
         */
        @Override // com.baidu.tieba.feed.widget.AutoDegradeTagView.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(n87 data, View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, data, view2) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(view2, "view");
                String J = data.J();
                boolean z2 = false;
                if (J != null && J.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                String str = null;
                if (z) {
                    J = null;
                }
                if (J == null) {
                    J = this.a.p();
                }
                str = J;
                if (str != null) {
                    this.a.n().invoke(view2, str);
                }
                if (data instanceof b97) {
                    for (u97 u97Var : ((b97) data).a()) {
                        sc7.a.b(u97Var, this.a.g() + 1);
                        this.a.f().invoke(u97Var);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements AutoDegradeTagView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c77 a;

        public b(c77 c77Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c77Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c77Var;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
            if (((r5 == null || r5.length() == 0) ? true : true) == false) goto L23;
         */
        @Override // com.baidu.tieba.feed.widget.AutoDegradeTagView.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(n87 data, View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, data, view2) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(view2, "view");
                String J = data.J();
                boolean z2 = false;
                if (J != null && J.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                String str = null;
                if (z) {
                    J = null;
                }
                if (J == null) {
                    J = this.a.p();
                }
                str = J;
                if (str != null) {
                    this.a.n().invoke(view2, str);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CardHeadView(Context context, AttributeSet attributeSet) {
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
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        e();
        f();
        a();
        c();
        d();
    }

    public /* synthetic */ CardHeadView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final void h(c77 uiState, String str, View it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, uiState, str, it) == null) {
            Intrinsics.checkNotNullParameter(uiState, "$uiState");
            Function2<View, String, Unit> m = uiState.m();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            m.invoke(it, str);
            for (u97 u97Var : uiState.q()) {
                sc7.a.b(u97Var, uiState.g() + 1);
                uiState.f().invoke(u97Var);
            }
        }
    }

    public static final void i(c77 uiState, View it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, uiState, it) == null) {
            Intrinsics.checkNotNullParameter(uiState, "$uiState");
            Function2<u87, View, Unit> l = uiState.l();
            u87 i = uiState.i();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            l.invoke(i, it);
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            PersonAttentionView personAttentionView = new PersonAttentionView(getContext(), null, 0, 6, null);
            this.f = personAttentionView;
            ForumAttentionView forumAttentionView = null;
            if (personAttentionView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("attentionView");
                personAttentionView = null;
            }
            personAttentionView.setVisibility(8);
            LinearLayout linearLayout = this.d;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headRightLayout");
                linearLayout = null;
            }
            PersonAttentionView personAttentionView2 = this.f;
            if (personAttentionView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("attentionView");
                personAttentionView2 = null;
            }
            linearLayout.addView(personAttentionView2);
            ForumAttentionView forumAttentionView2 = new ForumAttentionView(getContext(), null, 0, 6, null);
            this.g = forumAttentionView2;
            if (forumAttentionView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forumAttentionView");
                forumAttentionView2 = null;
            }
            forumAttentionView2.setVisibility(8);
            LinearLayout linearLayout2 = this.d;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headRightLayout");
                linearLayout2 = null;
            }
            ForumAttentionView forumAttentionView3 = this.g;
            if (forumAttentionView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forumAttentionView");
            } else {
                forumAttentionView = forumAttentionView3;
            }
            linearLayout2.addView(forumAttentionView);
        }
    }

    @Override // com.baidu.tieba.fc7
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || gc7.a(this)) {
            return;
        }
        HeadImageView headImageView = this.a;
        ImageView imageView = null;
        if (headImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headImageView");
            headImageView = null;
        }
        headImageView.b();
        AutoDegradeTagView autoDegradeTagView = this.b;
        if (autoDegradeTagView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headMainView");
            autoDegradeTagView = null;
        }
        autoDegradeTagView.b();
        AutoDegradeTagView autoDegradeTagView2 = this.c;
        if (autoDegradeTagView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headExtendInfo");
            autoDegradeTagView2 = null;
        }
        autoDegradeTagView2.b();
        PersonAttentionView personAttentionView = this.f;
        if (personAttentionView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attentionView");
            personAttentionView = null;
        }
        personAttentionView.r();
        ImageView imageView2 = this.e;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
        } else {
            imageView = imageView2;
        }
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_card_close22, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ImageView imageView = new ImageView(getContext());
            this.e = imageView;
            ImageView imageView2 = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
                imageView = null;
            }
            imageView.setVisibility(8);
            ImageView imageView3 = this.e;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
                imageView3 = null;
            }
            imageView3.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_card_close22, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
            ImageView imageView4 = this.e;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
                imageView4 = null;
            }
            imageView4.setId(R.id.obfuscated_res_0x7f0905d0);
            int g = yi.g(getContext(), R.dimen.tbds88);
            int g2 = yi.g(getContext(), R.dimen.tbds8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
            ImageView imageView5 = this.e;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
                imageView5 = null;
            }
            imageView5.setPadding(g2, g2, g2, g2);
            LinearLayout linearLayout = this.d;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headRightLayout");
                linearLayout = null;
            }
            ImageView imageView6 = this.e;
            if (imageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
            } else {
                imageView2 = imageView6;
            }
            linearLayout.addView(imageView2, layoutParams);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.d = linearLayout;
            View view2 = null;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headRightLayout");
                linearLayout = null;
            }
            linearLayout.setOrientation(0);
            LinearLayout linearLayout2 = this.d;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headRightLayout");
                linearLayout2 = null;
            }
            linearLayout2.setGravity(16);
            LinearLayout linearLayout3 = this.d;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headRightLayout");
                linearLayout3 = null;
            }
            linearLayout3.setId(R.id.obfuscated_res_0x7f0905d3);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(15);
            layoutParams.addRule(11);
            layoutParams.rightMargin = yi.g(getContext(), R.dimen.M_W_X005);
            View view3 = this.d;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headRightLayout");
            } else {
                view2 = view3;
            }
            addView(view2, layoutParams);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(1);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            AutoDegradeTagView autoDegradeTagView = null;
            AutoDegradeTagView autoDegradeTagView2 = new AutoDegradeTagView(context, null, 2, null);
            this.b = autoDegradeTagView2;
            if (autoDegradeTagView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headMainView");
                autoDegradeTagView2 = null;
            }
            autoDegradeTagView2.setTagConfig(yi.g(getContext(), R.dimen.T_X07), yi.g(getContext(), R.dimen.tbds39), yi.g(getContext(), R.dimen.M_W_X002), R.color.CAM_X0105);
            AutoDegradeTagView autoDegradeTagView3 = this.b;
            if (autoDegradeTagView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headMainView");
                autoDegradeTagView3 = null;
            }
            linearLayout.addView(autoDegradeTagView3);
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            AutoDegradeTagView autoDegradeTagView4 = new AutoDegradeTagView(context2, null, 2, null);
            this.c = autoDegradeTagView4;
            if (autoDegradeTagView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headExtendInfo");
                autoDegradeTagView4 = null;
            }
            autoDegradeTagView4.setTagConfig(yi.g(getContext(), R.dimen.T_X09), yi.g(getContext(), R.dimen.tbds31), yi.g(getContext(), R.dimen.M_W_X004), R.color.CAM_X0109);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = yi.g(getContext(), R.dimen.tbds5);
            AutoDegradeTagView autoDegradeTagView5 = this.c;
            if (autoDegradeTagView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headExtendInfo");
            } else {
                autoDegradeTagView = autoDegradeTagView5;
            }
            linearLayout.addView(autoDegradeTagView, layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(15);
            layoutParams2.addRule(1, R.id.obfuscated_res_0x7f0905d2);
            layoutParams2.addRule(0, R.id.obfuscated_res_0x7f0905d3);
            addView(linearLayout, layoutParams2);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            View view2 = null;
            HeadImageView headImageView = new HeadImageView(context, null, 2, null);
            this.a = headImageView;
            if (headImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headImageView");
                headImageView = null;
            }
            headImageView.setId(R.id.obfuscated_res_0x7f0905d2);
            int g = yi.g(getContext(), R.dimen.tbds148);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
            layoutParams.addRule(15);
            View view3 = this.a;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headImageView");
            } else {
                view2 = view3;
            }
            addView(view2, layoutParams);
        }
    }

    public final void g(final c77 uiState) {
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, uiState) == null) {
            Intrinsics.checkNotNullParameter(uiState, "uiState");
            f87 k = uiState.k();
            g87 b2 = k.b();
            HeadImageView headImageView = this.a;
            AutoDegradeTagView autoDegradeTagView = null;
            if (headImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headImageView");
                headImageView = null;
            }
            headImageView.j(b2.c());
            boolean z2 = true;
            int i2 = 0;
            if (b2.b() == 2) {
                z = true;
            } else {
                z = false;
            }
            headImageView.m(z);
            headImageView.n(b2.e());
            headImageView.i(b2.a());
            headImageView.l(b2.g());
            headImageView.k(b2.d());
            final String f = b2.f();
            if (f != null && f.length() != 0) {
                z2 = false;
            }
            if (z2) {
                HeadImageView headImageView2 = this.a;
                if (headImageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headImageView");
                    headImageView2 = null;
                }
                headImageView2.setOnClickListener(null);
            } else {
                HeadImageView headImageView3 = this.a;
                if (headImageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headImageView");
                    headImageView3 = null;
                }
                headImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.n67
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            CardHeadView.h(c77.this, f, view2);
                        }
                    }
                });
            }
            if (uiState.i() == null) {
                ImageView imageView = this.e;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
                    imageView = null;
                }
                imageView.setVisibility(8);
                ImageView imageView2 = this.e;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
                    imageView2 = null;
                }
                imageView2.setOnClickListener(null);
            } else {
                ImageView imageView3 = this.e;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
                    imageView3 = null;
                }
                imageView3.setVisibility(0);
                ImageView imageView4 = this.e;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
                    imageView4 = null;
                }
                imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.x67
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            CardHeadView.i(c77.this, view2);
                        }
                    }
                });
            }
            if (uiState.o() == null) {
                PersonAttentionView personAttentionView = this.f;
                if (personAttentionView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("attentionView");
                    personAttentionView = null;
                }
                personAttentionView.setVisibility(8);
                PersonAttentionView personAttentionView2 = this.f;
                if (personAttentionView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("attentionView");
                    personAttentionView2 = null;
                }
                personAttentionView2.setOnClickListener(null);
            } else {
                PersonAttentionView personAttentionView3 = this.f;
                if (personAttentionView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("attentionView");
                    personAttentionView3 = null;
                }
                personAttentionView3.setVisibility(0);
                PersonAttentionView personAttentionView4 = this.f;
                if (personAttentionView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("attentionView");
                    personAttentionView4 = null;
                }
                PersonAttentionView.s(personAttentionView4, uiState.o(), false, 2, null);
            }
            if (uiState.j() == null) {
                ForumAttentionView forumAttentionView = this.g;
                if (forumAttentionView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("forumAttentionView");
                    forumAttentionView = null;
                }
                forumAttentionView.setVisibility(8);
                ForumAttentionView forumAttentionView2 = this.g;
                if (forumAttentionView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("forumAttentionView");
                    forumAttentionView2 = null;
                }
                forumAttentionView2.setOnClickListener(null);
            } else {
                ForumAttentionView forumAttentionView3 = this.g;
                if (forumAttentionView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("forumAttentionView");
                    forumAttentionView3 = null;
                }
                forumAttentionView3.setVisibility(0);
                ForumAttentionView forumAttentionView4 = this.g;
                if (forumAttentionView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("forumAttentionView");
                    forumAttentionView4 = null;
                }
                ForumAttentionView.s(forumAttentionView4, uiState.j(), false, 2, null);
            }
            AutoDegradeTagView autoDegradeTagView2 = this.b;
            if (autoDegradeTagView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headMainView");
                autoDegradeTagView2 = null;
            }
            if (k.c().isEmpty()) {
                i = 8;
            } else {
                i = 0;
            }
            autoDegradeTagView2.setVisibility(i);
            AutoDegradeTagView autoDegradeTagView3 = this.b;
            if (autoDegradeTagView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headMainView");
                autoDegradeTagView3 = null;
            }
            autoDegradeTagView3.j(k.c());
            AutoDegradeTagView autoDegradeTagView4 = this.c;
            if (autoDegradeTagView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headExtendInfo");
                autoDegradeTagView4 = null;
            }
            if (k.a().isEmpty()) {
                i2 = 8;
            }
            autoDegradeTagView4.setVisibility(i2);
            AutoDegradeTagView autoDegradeTagView5 = this.c;
            if (autoDegradeTagView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headExtendInfo");
                autoDegradeTagView5 = null;
            }
            autoDegradeTagView5.j(k.a());
            AutoDegradeTagView autoDegradeTagView6 = this.b;
            if (autoDegradeTagView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headMainView");
                autoDegradeTagView6 = null;
            }
            autoDegradeTagView6.setOnTagClickListener(new a(uiState));
            AutoDegradeTagView autoDegradeTagView7 = this.c;
            if (autoDegradeTagView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headExtendInfo");
            } else {
                autoDegradeTagView = autoDegradeTagView7;
            }
            autoDegradeTagView.setOnTagClickListener(new b(uiState));
            b();
        }
    }
}
