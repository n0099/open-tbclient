package com.baidu.tieba.feed.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.cb7;
import com.baidu.tieba.d77;
import com.baidu.tieba.db7;
import com.baidu.tieba.feed.component.RecommendPersonAttentionCardView;
import com.baidu.tieba.feed.widget.HeadImageView;
import com.baidu.tieba.feed.widget.PersonAttentionView;
import com.baidu.tieba.h77;
import com.baidu.tieba.r87;
import com.baidu.tieba.s67;
import com.baidu.tieba.t87;
import com.baidu.tieba.vc7;
import com.baidu.tieba.z47;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u001cH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/baidu/tieba/feed/component/RecommendPersonAttentionCardView;", "Landroid/widget/LinearLayout;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "itemView", "Landroid/view/View;", "mContainer", "mLikeButton", "Lcom/baidu/tieba/feed/widget/PersonAttentionView;", "mUserDesc", "Landroid/widget/TextView;", "mUserImage", "Lcom/baidu/tieba/feed/widget/HeadImageView;", "mUserName", "onChangeSkin", "", StickerDataChangeType.UPDATE, "state", "Lcom/baidu/tieba/feed/component/uistate/RecommendPersonAttentionCardUiState;", "updateAvatar", "imageData", "Lcom/baidu/tieba/feed/data/CardHeadImageData;", "updateDesc", "desc", "Lcom/baidu/tieba/feed/data/TextData;", "updateName", "name", "lib-templates_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecommendPersonAttentionCardView extends LinearLayout implements cb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View a;
    public final HeadImageView b;
    public final LinearLayout c;
    public final TextView d;
    public final TextView e;
    public final PersonAttentionView f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RecommendPersonAttentionCardView(Context context) {
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
    public RecommendPersonAttentionCardView(Context context, AttributeSet attributeSet) {
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
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0229, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(getContext())\n     …m_person_attention, null)");
        this.a = inflate;
        View findViewById = inflate.findViewById(R.id.concern_user_image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.concern_user_image)");
        this.b = (HeadImageView) findViewById;
        View findViewById2 = this.a.findViewById(R.id.concern_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.concern_container)");
        this.c = (LinearLayout) findViewById2;
        View findViewById3 = this.a.findViewById(R.id.concern_user_name);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.concern_user_name)");
        this.d = (TextView) findViewById3;
        View findViewById4 = this.a.findViewById(R.id.concern_user_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.concern_user_desc)");
        this.e = (TextView) findViewById4;
        View findViewById5 = this.a.findViewById(R.id.user_recommend_like_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.….user_recommend_like_btn)");
        this.f = (PersonAttentionView) findViewById5;
        this.b.setImageViewSize(BdUtilHelper.getDimens(getContext(), R.dimen.tbds156));
        this.b.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
        this.b.setImageDefaultResource(17170445);
        this.b.setImagePlaceHolder(1);
        z47.d dVar = new z47.d();
        dVar.a = R.string.J_X05;
        dVar.b = 15;
        dVar.c = BdUtilHelper.getDimens(getContext(), R.dimen.tbds1);
        dVar.d = SkinManager.getColor(R.color.CAM_X0401);
        this.b.o(dVar);
        addView(this.a);
        c();
    }

    public /* synthetic */ RecommendPersonAttentionCardView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final void a(s67 state, View it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, state, it) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            String i = state.i();
            if (i != null) {
                Function2<View, String, Unit> f = state.f();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                f.invoke(it, i);
            }
            r87 j = state.j();
            if (j != null) {
                state.g().invoke(j);
            }
        }
    }

    public static final void b(s67 state, View it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, state, it) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            String i = state.i();
            if (i != null) {
                Function2<View, String, Unit> f = state.f();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                f.invoke(it, i);
            }
            r87 j = state.j();
            if (j != null) {
                state.g().invoke(j);
            }
        }
    }

    public static final void d(s67 state, View it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, state, it) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            String i = state.i();
            if (i != null) {
                Function2<View, String, Unit> f = state.f();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                f.invoke(it, i);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x004f, code lost:
        if (r0 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0083, code lost:
        if (r0 == null) goto L22;
     */
    @Override // com.baidu.tieba.cb7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c() {
        Object textColor;
        Object textColor2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || db7.a(this)) {
            return;
        }
        EMManager.from(this.c).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
        this.b.c();
        Object tag = this.d.getTag(R.id.obfuscated_res_0x7f09296c);
        if (tag != null) {
            if (tag instanceof h77) {
                this.d.setTextColor(vc7.a.a((h77) tag));
                textColor2 = Unit.INSTANCE;
            } else {
                textColor2 = EMManager.from(this.d).setTextColor(R.color.CAM_X0105);
            }
        }
        EMManager.from(this.d).setTextColor(R.color.CAM_X0105);
        Object tag2 = this.e.getTag(R.id.obfuscated_res_0x7f09296c);
        if (tag2 != null) {
            if (tag2 instanceof h77) {
                this.e.setTextColor(vc7.a.a((h77) tag2));
                textColor = Unit.INSTANCE;
            } else {
                textColor = EMManager.from(this.e).setTextColor(R.color.CAM_X0109);
            }
        }
        EMManager.from(this.e).setTextColor(R.color.CAM_X0109);
        this.f.r();
    }

    public final void e(d77 d77Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d77Var) == null) {
            this.b.j(d77Var.c());
            HeadImageView headImageView = this.b;
            if (d77Var.b() == 2) {
                z = true;
            } else {
                z = false;
            }
            headImageView.m(z);
            this.b.i(d77Var.a());
            this.b.n(d77Var.e());
            this.b.l(d77Var.g());
        }
    }

    public final void f(t87 t87Var) {
        Unit unit;
        h77 b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t87Var) == null) {
            this.e.setText((t87Var == null || (r1 = t87Var.c()) == null) ? "" : "");
            if (t87Var != null && (b = t87Var.b()) != null) {
                this.e.setTag(R.id.obfuscated_res_0x7f09296c, b);
                this.e.setTextColor(vc7.a.a(b));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                this.e.setTag(R.id.obfuscated_res_0x7f09296c, null);
            }
        }
    }

    public final void g(t87 t87Var) {
        Unit unit;
        h77 b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, t87Var) == null) {
            this.d.setText((t87Var == null || (r1 = t87Var.c()) == null) ? "" : "");
            if (t87Var != null && (b = t87Var.b()) != null) {
                this.d.setTag(R.id.obfuscated_res_0x7f09296c, b);
                this.d.setTextColor(vc7.a.a(b));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                this.d.setTag(R.id.obfuscated_res_0x7f09296c, null);
            }
        }
    }

    public final void update(final s67 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            e(state.e());
            this.b.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.p57
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        RecommendPersonAttentionCardView.a(s67.this, view2);
                    }
                }
            });
            g(state.l());
            this.d.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g57
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        RecommendPersonAttentionCardView.b(s67.this, view2);
                    }
                }
            });
            f(state.k());
            this.e.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.e57
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        RecommendPersonAttentionCardView.d(s67.this, view2);
                    }
                }
            });
            PersonAttentionView.s(this.f, state.h(), false, 2, null);
            c();
        }
    }
}
