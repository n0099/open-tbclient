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
import com.baidu.tieba.feed.component.CardHeadView;
import com.baidu.tieba.feed.widget.AutoDegradeTagView;
import com.baidu.tieba.feed.widget.HeadImageView;
import com.baidu.tieba.k57;
import com.baidu.tieba.l57;
import com.baidu.tieba.m67;
import com.baidu.tieba.m87;
import com.baidu.tieba.n87;
import com.baidu.tieba.p47;
import com.baidu.tieba.r57;
import com.baidu.tieba.x57;
import com.baidu.tieba.xi;
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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/baidu/tieba/feed/component/CardHeadView;", "Landroid/widget/RelativeLayout;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "feedBackBtn", "Landroid/widget/ImageView;", "headExtendInfo", "Lcom/baidu/tieba/feed/widget/AutoDegradeTagView;", "headImageView", "Lcom/baidu/tieba/feed/widget/HeadImageView;", "headMainView", "initFeedBackBtn", "", "initHeadInfoLayout", "initImageView", "onChangeSkin", "updateState", "uiState", "Lcom/baidu/tieba/feed/component/uistate/CardHeadUiState;", "lib-templates_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CardHeadView extends RelativeLayout implements m87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView a;
    public AutoDegradeTagView b;
    public AutoDegradeTagView c;
    public ImageView d;

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
        public final /* synthetic */ p47 a;

        public a(p47 p47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p47Var;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
            if (((r5 == null || r5.length() == 0) ? true : true) == false) goto L23;
         */
        @Override // com.baidu.tieba.feed.widget.AutoDegradeTagView.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(r57 data, View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, data, view2) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(view2, "view");
                String I = data.I();
                boolean z2 = false;
                if (I != null && I.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                String str = null;
                if (z) {
                    I = null;
                }
                if (I == null) {
                    I = this.a.j();
                }
                str = I;
                if (str != null) {
                    this.a.i().invoke(view2, str);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements AutoDegradeTagView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p47 a;

        public b(p47 p47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p47Var;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
            if (((r5 == null || r5.length() == 0) ? true : true) == false) goto L23;
         */
        @Override // com.baidu.tieba.feed.widget.AutoDegradeTagView.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(r57 data, View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, data, view2) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(view2, "view");
                String I = data.I();
                boolean z2 = false;
                if (I != null && I.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                String str = null;
                if (z) {
                    I = null;
                }
                if (I == null) {
                    I = this.a.j();
                }
                str = I;
                if (str != null) {
                    this.a.i().invoke(view2, str);
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
        d();
        a();
        c();
    }

    public /* synthetic */ CardHeadView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final void f(p47 uiState, String str, k57 headData, View it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, uiState, str, headData, it) == null) {
            Intrinsics.checkNotNullParameter(uiState, "$uiState");
            Intrinsics.checkNotNullParameter(headData, "$headData");
            Function2<View, String, Unit> h = uiState.h();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            h.invoke(it, str);
            m67 d = headData.d();
            if (d != null) {
                uiState.c().invoke(d);
            }
            m67 e = headData.e();
            if (e != null) {
                uiState.c().invoke(e);
            }
        }
    }

    public static final void g(p47 uiState, View it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, uiState, it) == null) {
            Intrinsics.checkNotNullParameter(uiState, "$uiState");
            Function2<x57, View, Unit> g = uiState.g();
            x57 e = uiState.e();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            g.invoke(e, it);
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ImageView imageView = new ImageView(getContext());
            this.d = imageView;
            View view2 = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
                imageView = null;
            }
            imageView.setVisibility(8);
            ImageView imageView2 = this.d;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
                imageView2 = null;
            }
            imageView2.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_card_close22, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
            ImageView imageView3 = this.d;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
                imageView3 = null;
            }
            imageView3.setId(R.id.obfuscated_res_0x7f0905cf);
            int g = xi.g(getContext(), R.dimen.tbds88);
            int g2 = xi.g(getContext(), R.dimen.tbds8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
            layoutParams.addRule(15);
            layoutParams.addRule(11);
            layoutParams.rightMargin = xi.g(getContext(), R.dimen.M_W_X005);
            ImageView imageView4 = this.d;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
                imageView4 = null;
            }
            imageView4.setPadding(g2, g2, g2, g2);
            View view3 = this.d;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
            } else {
                view2 = view3;
            }
            addView(view2, layoutParams);
        }
    }

    @Override // com.baidu.tieba.m87
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || n87.a(this)) {
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
        ImageView imageView2 = this.d;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
        } else {
            imageView = imageView2;
        }
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_card_close22, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            View view2 = null;
            HeadImageView headImageView = new HeadImageView(context, null, 2, null);
            this.a = headImageView;
            if (headImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headImageView");
                headImageView = null;
            }
            headImageView.setId(R.id.obfuscated_res_0x7f0905d1);
            int g = xi.g(getContext(), R.dimen.tbds148);
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

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
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
            autoDegradeTagView2.setTagConfig(xi.g(getContext(), R.dimen.T_X07), xi.g(getContext(), R.dimen.tbds39), xi.g(getContext(), R.dimen.M_W_X002), R.color.CAM_X0105);
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
            autoDegradeTagView4.setTagConfig(xi.g(getContext(), R.dimen.T_X09), xi.g(getContext(), R.dimen.tbds31), xi.g(getContext(), R.dimen.M_W_X004), R.color.CAM_X0109);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = xi.g(getContext(), R.dimen.tbds5);
            AutoDegradeTagView autoDegradeTagView5 = this.c;
            if (autoDegradeTagView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headExtendInfo");
            } else {
                autoDegradeTagView = autoDegradeTagView5;
            }
            linearLayout.addView(autoDegradeTagView, layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(15);
            layoutParams2.addRule(1, R.id.obfuscated_res_0x7f0905d1);
            layoutParams2.addRule(0, R.id.obfuscated_res_0x7f0905cf);
            addView(linearLayout, layoutParams2);
        }
    }

    public final void e(final p47 uiState) {
        boolean z;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, uiState) == null) {
            Intrinsics.checkNotNullParameter(uiState, "uiState");
            final k57 f = uiState.f();
            l57 b2 = f.b();
            HeadImageView headImageView = this.a;
            AutoDegradeTagView autoDegradeTagView = null;
            if (headImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headImageView");
                headImageView = null;
            }
            headImageView.i(b2.c());
            boolean z2 = true;
            if (b2.b() == 2) {
                z = true;
            } else {
                z = false;
            }
            headImageView.k(z);
            headImageView.l(b2.d());
            headImageView.h(b2.a());
            headImageView.j(b2.f());
            final String e = b2.e();
            if (e != null && e.length() != 0) {
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
                headImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.z37
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            CardHeadView.f(p47.this, e, f, view2);
                        }
                    }
                });
            }
            AutoDegradeTagView autoDegradeTagView2 = this.b;
            if (autoDegradeTagView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headMainView");
                autoDegradeTagView2 = null;
            }
            if (f.c().isEmpty()) {
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
            autoDegradeTagView3.j(f.c());
            AutoDegradeTagView autoDegradeTagView4 = this.c;
            if (autoDegradeTagView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headExtendInfo");
                autoDegradeTagView4 = null;
            }
            if (f.a().isEmpty()) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            autoDegradeTagView4.setVisibility(i2);
            AutoDegradeTagView autoDegradeTagView5 = this.c;
            if (autoDegradeTagView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headExtendInfo");
                autoDegradeTagView5 = null;
            }
            autoDegradeTagView5.j(f.a());
            if (uiState.e() == null) {
                ImageView imageView = this.d;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
                    imageView = null;
                }
                imageView.setVisibility(8);
                ImageView imageView2 = this.d;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
                    imageView2 = null;
                }
                imageView2.setOnClickListener(null);
            } else {
                ImageView imageView3 = this.d;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
                    imageView3 = null;
                }
                imageView3.setVisibility(0);
                ImageView imageView4 = this.d;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
                    imageView4 = null;
                }
                imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.v37
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            CardHeadView.g(p47.this, view2);
                        }
                    }
                });
            }
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
