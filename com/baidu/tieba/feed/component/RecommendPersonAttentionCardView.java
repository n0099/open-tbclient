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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.ay6;
import com.baidu.tieba.feed.component.RecommendPersonAttentionCardView;
import com.baidu.tieba.feed.widget.HeadImageView;
import com.baidu.tieba.feed.widget.PersonAttentionView;
import com.baidu.tieba.g35;
import com.baidu.tieba.ii;
import com.baidu.tieba.ky6;
import com.baidu.tieba.l17;
import com.baidu.tieba.lz6;
import com.baidu.tieba.m17;
import com.baidu.tieba.mz6;
import com.baidu.tieba.oy6;
import com.baidu.tieba.sw6;
import com.baidu.tieba.y27;
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
/* loaded from: classes4.dex */
public final class RecommendPersonAttentionCardView extends LinearLayout implements l17 {
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
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d020a, (ViewGroup) null);
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
        this.b.setImageViewSize(ii.g(getContext(), R.dimen.tbds156));
        this.b.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
        this.b.setImageDefaultResource(17170445);
        this.b.setImagePlaceHolder(1);
        sw6.c cVar = new sw6.c();
        cVar.a = R.string.J_X05;
        cVar.b = 15;
        cVar.c = ii.g(getContext(), R.dimen.tbds1);
        cVar.d = SkinManager.getColor(R.color.CAM_X0401);
        this.b.m(cVar);
        addView(this.a);
        b();
    }

    public /* synthetic */ RecommendPersonAttentionCardView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final void a(ay6 state, View it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, state, it) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            String h = state.h();
            if (h != null) {
                Function2<View, String, Unit> e = state.e();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                e.invoke(it, h);
            }
            lz6 i = state.i();
            if (i != null) {
                state.f().invoke(i);
            }
        }
    }

    public static final void c(ay6 state, View it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, state, it) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            String h = state.h();
            if (h != null) {
                Function2<View, String, Unit> e = state.e();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                e.invoke(it, h);
            }
            lz6 i = state.i();
            if (i != null) {
                state.f().invoke(i);
            }
        }
    }

    public static final void d(ay6 state, View it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, state, it) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            String h = state.h();
            if (h != null) {
                Function2<View, String, Unit> e = state.e();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                e.invoke(it, h);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x004d, code lost:
        if (r0 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0080, code lost:
        if (r0 == null) goto L22;
     */
    @Override // com.baidu.tieba.l17
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() {
        Object obj;
        Object obj2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || m17.a(this)) {
            return;
        }
        g35 d = g35.d(this.c);
        d.o(R.string.J_X05);
        d.f(R.color.CAM_X0206);
        this.b.b();
        Object tag = this.d.getTag(R.id.obfuscated_res_0x7f0927ce);
        if (tag != null) {
            if (tag instanceof oy6) {
                this.d.setTextColor(y27.a.a((oy6) tag));
                obj2 = Unit.INSTANCE;
            } else {
                g35 d2 = g35.d(this.d);
                d2.w(R.color.CAM_X0105);
                obj2 = d2;
            }
        }
        g35.d(this.d).w(R.color.CAM_X0105);
        Object tag2 = this.e.getTag(R.id.obfuscated_res_0x7f0927ce);
        if (tag2 != null) {
            if (tag2 instanceof oy6) {
                this.e.setTextColor(y27.a.a((oy6) tag2));
                obj = Unit.INSTANCE;
            } else {
                g35 d3 = g35.d(this.e);
                d3.w(R.color.CAM_X0109);
                obj = d3;
            }
        }
        g35.d(this.e).w(R.color.CAM_X0109);
        this.f.q();
    }

    public final void e(ky6 ky6Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ky6Var) == null) {
            this.b.i(ky6Var.c());
            HeadImageView headImageView = this.b;
            if (ky6Var.b() == 2) {
                z = true;
            } else {
                z = false;
            }
            headImageView.k(z);
            this.b.h(ky6Var.a());
            this.b.l(ky6Var.d());
            this.b.j(ky6Var.f());
        }
    }

    public final void f(mz6 mz6Var) {
        Unit unit;
        oy6 b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mz6Var) == null) {
            this.e.setText((mz6Var == null || (r1 = mz6Var.c()) == null) ? "" : "");
            if (mz6Var != null && (b = mz6Var.b()) != null) {
                this.e.setTag(R.id.obfuscated_res_0x7f0927ce, b);
                this.e.setTextColor(y27.a.a(b));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                this.e.setTag(R.id.obfuscated_res_0x7f0927ce, null);
            }
        }
    }

    public final void g(mz6 mz6Var) {
        Unit unit;
        oy6 b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mz6Var) == null) {
            this.d.setText((mz6Var == null || (r1 = mz6Var.c()) == null) ? "" : "");
            if (mz6Var != null && (b = mz6Var.b()) != null) {
                this.d.setTag(R.id.obfuscated_res_0x7f0927ce, b);
                this.d.setTextColor(y27.a.a(b));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                this.d.setTag(R.id.obfuscated_res_0x7f0927ce, null);
            }
        }
    }

    public final void update(final ay6 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            e(state.d());
            this.b.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gx6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        RecommendPersonAttentionCardView.a(ay6.this, view2);
                    }
                }
            });
            g(state.k());
            this.d.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ax6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        RecommendPersonAttentionCardView.c(ay6.this, view2);
                    }
                }
            });
            f(state.j());
            this.e.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.xw6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        RecommendPersonAttentionCardView.d(ay6.this, view2);
                    }
                }
            });
            PersonAttentionView.r(this.f, state.g(), false, 2, null);
            b();
        }
    }
}
