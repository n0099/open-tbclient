package com.baidu.tieba.feed.component;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.SpaceItemDecoration;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.a87;
import com.baidu.tieba.c67;
import com.baidu.tieba.c87;
import com.baidu.tieba.d87;
import com.baidu.tieba.feed.component.RecommendCardView;
import com.baidu.tieba.feed.list.FeedTemplateAdapter;
import com.baidu.tieba.l97;
import com.baidu.tieba.n57;
import com.baidu.tieba.o75;
import com.baidu.tieba.q47;
import com.baidu.tieba.vi;
import com.baidu.tieba.z77;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/baidu/tieba/feed/component/RecommendCardView;", "Landroid/widget/LinearLayout;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "adapter", "Lcom/baidu/tieba/feed/list/ITemplateAdapter;", "feedbackView", "Landroid/widget/ImageView;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mTitleColorId", "", "mTitleView", "Landroid/widget/TextView;", "onChangeSkin", "", StickerDataChangeType.UPDATE, "state", "Lcom/baidu/tieba/feed/component/uistate/RecommendCardUiState;", "lib-templates_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecommendCardView extends LinearLayout implements c87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public int b;
    public RecyclerView c;
    public z77 d;
    public final ImageView e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RecommendCardView(Context context) {
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
    public RecommendCardView(Context context, AttributeSet attributeSet) {
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
        this.b = R.color.CAM_X0108;
        LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0222, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f0924a3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
        this.a = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.thread_card_list);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.thread_card_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.c = recyclerView;
        recyclerView.setFadingEdgeLength(0);
        this.c.setOverScrollMode(2);
        this.c.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.c.setItemAnimator(new DefaultItemAnimator());
        int g = vi.g(getContext(), R.dimen.tbds21);
        int g2 = vi.g(getContext(), R.dimen.tbds44);
        this.c.addItemDecoration(new SpaceItemDecoration(g2, g, g2));
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = vi.g(getContext(), R.dimen.tbds39);
            this.c.setLayoutParams(marginLayoutParams);
            setOrientation(1);
            FeedTemplateAdapter feedTemplateAdapter = new FeedTemplateAdapter();
            this.d = feedTemplateAdapter;
            feedTemplateAdapter.j(new a87() { // from class: com.baidu.tieba.m37
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.a87
                public final List a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? RecommendCardView.a() : (List) invokeV.objValue;
                }
            });
            this.d.f(this.c);
            View findViewById3 = findViewById(R.id.obfuscated_res_0x7f090ae8);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.feedback_view)");
            this.e = (ImageView) findViewById3;
            b();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public /* synthetic */ RecommendCardView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final List a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return CollectionsKt__CollectionsJVMKt.listOf(new l97("recommend_card_person_attention"));
        }
        return (List) invokeV.objValue;
    }

    public static final void c(q47 state, View it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, state, it) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            Function2<n57, View, Unit> g = state.g();
            n57 d = state.d();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            g.invoke(d, it);
        }
    }

    @Override // com.baidu.tieba.c87
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setViewTextColor(this.a, this.b);
            if (d87.a(this)) {
                return;
            }
            o75 d = o75.d(this);
            d.o(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            this.e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_card_close22, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.d.b();
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void update(final q47 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            String f = state.f();
            int h = state.h();
            if (!TextUtils.isEmpty(f) && h != 0) {
                this.a.setTextSize(0, vi.g(getContext(), R.dimen.tbds37));
                this.a.setText(f);
                this.a.setTypeface(Typeface.DEFAULT_BOLD);
                this.b = h;
            } else {
                this.a.setTextSize(0, vi.g(getContext(), R.dimen.tbds37));
                this.a.setText(R.string.obfuscated_res_0x7f0f04b7);
                this.a.setTypeface(Typeface.DEFAULT_BOLD);
                this.b = R.color.CAM_X0105;
            }
            this.d.setList(state.e().a);
            c67 c67Var = state.e().b;
            if (c67Var != null) {
                state.c().invoke(c67Var);
            }
            if (state.d() == null) {
                this.e.setVisibility(8);
                this.e.setOnClickListener(null);
            } else {
                this.e.setVisibility(0);
                this.e.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w37
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            RecommendCardView.c(q47.this, view2);
                        }
                    }
                });
            }
            b();
        }
    }
}
