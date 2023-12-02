package com.baidu.tieba.forum.component;

import android.content.Context;
import android.graphics.Rect;
import android.net.http.Headers;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TextViewCutUtilsKt;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ac7;
import com.baidu.tieba.b57;
import com.baidu.tieba.bg7;
import com.baidu.tieba.ca7;
import com.baidu.tieba.cg7;
import com.baidu.tieba.db7;
import com.baidu.tieba.e87;
import com.baidu.tieba.feed.component.CardFrameView;
import com.baidu.tieba.feed.widget.roundcorners.RoundFrameLayout;
import com.baidu.tieba.forum.component.CardStaggeredVideoTagView;
import com.baidu.tieba.forum.component.CardStaggeredVideoView;
import com.baidu.tieba.kb7;
import com.baidu.tieba.l67;
import com.baidu.tieba.l87;
import com.baidu.tieba.lb7;
import com.baidu.tieba.m87;
import com.baidu.tieba.n67;
import com.baidu.tieba.o67;
import com.baidu.tieba.od7;
import com.baidu.tieba.wo7;
import com.baidu.tieba.x4;
import com.baidu.tieba.y47;
import com.baidu.tieba.ya7;
import com.baidu.tieba.z47;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u001b\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0002H\u0014J\u0018\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u001bH\u0002J\b\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020,2\u0006\u00102\u001a\u00020\u001bH\u0002J\b\u00103\u001a\u00020,H\u0016J\u0010\u00104\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0002H\u0002J\u0010\u00105\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0002H\u0002J\u0010\u00106\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0002H\u0002J\u001a\u00107\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00022\b\b\u0002\u0010.\u001a\u00020\u001bH\u0002J\u001a\u00108\u001a\u00020,2\u0006\u00109\u001a\u00020\u001b2\b\b\u0002\u0010:\u001a\u00020\u001bH\u0002J\u0010\u0010;\u001a\u00020,2\u0006\u0010-\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020,2\u0006\u0010-\u001a\u00020<H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0015R\u0014\u0010%\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0015R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/baidu/tieba/forum/component/CardStaggeredVideoView;", "Lcom/baidu/tieba/feed/component/CardFrameView;", "Lcom/baidu/tieba/forum/component/uistate/CardStaggeredVideoUiState;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "Lcom/baidu/tieba/feed/list/IGetVideoHolder;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "commentContainer", "Landroid/widget/LinearLayout;", "commentIcon", "Landroid/widget/ImageView;", "commentText", "Landroid/widget/TextView;", "headMainView", "Lcom/baidu/tieba/forum/component/CardStaggeredVideoTagView;", "horizontalVideoHeight", "", "getHorizontalVideoHeight", "()I", "horizontalVideoWidth", "getHorizontalVideoWidth", "imageView", "Lcom/baidu/tbadk/core/view/RoundTbImageView;", "inSelectedMode", "", "manageBtn", "manageSelectBtn", "manageSelectMask", "Landroid/widget/FrameLayout;", Headers.REFRESH, "Lcom/baidu/tieba/forum/component/uistate/RefreshRunnable;", "textView", "verticalVideoHeight", "getVerticalVideoHeight", "verticalVideoWidth", "getVerticalVideoWidth", "videoHolder", "Lcom/baidu/tieba/forum/view/FrsStaggeredVideoContainerHolder;", "videoRootView", "Lcom/baidu/tieba/feed/widget/roundcorners/RoundFrameLayout;", "doUpdateState", "", "state", "updateUiOnly", "getVideoHolder", "", "handGreyMode", "isGreyMode", "onChangeSkin", "updateEditMode", "updateManage", "updateOtherUI", "updateRefresh", "updateSelectedMode", "isInSelectedMode", "canSelect", "updateVideoUI", "Lcom/baidu/tieba/feed/component/uistate/CardVideoUiState;", "videoClick", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CardStaggeredVideoView extends CardFrameView<bg7> implements kb7, db7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wo7 d;
    public final RoundFrameLayout e;
    public final TextView f;
    public final RoundTbImageView g;
    public final CardStaggeredVideoTagView h;
    public final LinearLayout i;
    public final ImageView j;
    public final TextView k;
    public final ImageView l;
    public final FrameLayout m;
    public final ImageView n;
    public boolean o;
    public cg7 p;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CardStaggeredVideoView(Context context) {
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

    public static final void j(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, view2) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public static final class a implements CardStaggeredVideoTagView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bg7 a;
        public final /* synthetic */ CardStaggeredVideoView b;

        public a(bg7 bg7Var, CardStaggeredVideoView cardStaggeredVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bg7Var, cardStaggeredVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bg7Var;
            this.b = cardStaggeredVideoView;
        }

        @Override // com.baidu.tieba.forum.component.CardStaggeredVideoTagView.a
        public void a(o67 textData, TextView view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, textData, view2) == null) {
                Intrinsics.checkNotNullParameter(textData, "textData");
                Intrinsics.checkNotNullParameter(view2, "view");
                Function2<Context, l67, Unit> q = this.a.q();
                Context context = this.b.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                q.invoke(context, textData);
            }
        }

        @Override // com.baidu.tieba.forum.component.CardStaggeredVideoTagView.a
        public void b(n67 iconData, ImageView view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iconData, view2) == null) {
                Intrinsics.checkNotNullParameter(iconData, "iconData");
                Intrinsics.checkNotNullParameter(view2, "view");
                Function2<Context, l67, Unit> q = this.a.q();
                Context context = this.b.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                q.invoke(context, iconData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements cg7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardStaggeredVideoView a;

        public b(CardStaggeredVideoView cardStaggeredVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardStaggeredVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardStaggeredVideoView;
        }

        @Override // com.baidu.tieba.cg7
        public void a(z47 refreshUiState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, refreshUiState) == null) {
                Intrinsics.checkNotNullParameter(refreshUiState, "refreshUiState");
                if (!od7.a(this.a, refreshUiState, false)) {
                    return;
                }
                this.a.e((bg7) refreshUiState, true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CardStaggeredVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.e = new RoundFrameLayout(context);
        this.f = new TextView(context);
        this.g = new RoundTbImageView(context);
        this.h = new CardStaggeredVideoTagView(context, null, 2, null);
        this.i = new LinearLayout(context);
        this.j = new ImageView(context);
        this.k = new TextView(context);
        this.l = new ImageView(context);
        this.m = new FrameLayout(context);
        this.n = new ImageView(context);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        int dimens = BdUtilHelper.getDimens(context, R.dimen.tbds21);
        this.e.setRadiusPx(dimens, dimens, 0, 0);
        linearLayout.addView(this.e, new LinearLayout.LayoutParams(-1, -1));
        Context context2 = linearLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext()");
        this.d = new wo7(context2, this.e);
        this.f.setLineSpacing(BdUtilHelper.getDimens(context, R.dimen.tbds10), 1.0f);
        this.f.setMaxLines(2);
        this.f.setEllipsize(TextUtils.TruncateAt.END);
        this.f.setMovementMethod(ca7.a);
        this.f.setClickable(false);
        this.f.setLongClickable(false);
        View view2 = this.f;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(BdUtilHelper.getDimens(context, R.dimen.M_W_X004), BdUtilHelper.getDimens(context, R.dimen.M_H_X004) - BdUtilHelper.getDimens(context, R.dimen.tbds8), BdUtilHelper.getDimens(context, R.dimen.M_W_X004), 0);
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(view2, layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, 0, 0, BdUtilHelper.getDimens(context, R.dimen.M_H_X004) - BdUtilHelper.getDimens(context, R.dimen.M_H_X002));
        Unit unit2 = Unit.INSTANCE;
        linearLayout.addView(relativeLayout, layoutParams2);
        relativeLayout.setGravity(16);
        RoundTbImageView roundTbImageView = this.g;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(BdUtilHelper.getDimens(context, R.dimen.tbds42), BdUtilHelper.getDimens(context, R.dimen.tbds42));
        layoutParams3.addRule(15, -1);
        layoutParams3.setMargins(BdUtilHelper.getDimens(context, R.dimen.M_W_X004), 0, 0, 0);
        Unit unit3 = Unit.INSTANCE;
        relativeLayout.addView(roundTbImageView, layoutParams3);
        this.g.setId(R.id.obfuscated_res_0x7f09292a);
        LinearLayout linearLayout2 = this.i;
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(15, -1);
        layoutParams4.addRule(11, -1);
        Unit unit4 = Unit.INSTANCE;
        relativeLayout.addView(linearLayout2, layoutParams4);
        this.i.setPadding(BdUtilHelper.getDimens(context, R.dimen.M_W_X003), BdUtilHelper.getDimens(context, R.dimen.M_H_X002), BdUtilHelper.getDimens(context, R.dimen.M_W_X004), BdUtilHelper.getDimens(context, R.dimen.M_H_X002));
        this.i.setOrientation(0);
        this.i.setId(R.id.obfuscated_res_0x7f0907a0);
        LinearLayout linearLayout3 = this.i;
        ImageView imageView = this.j;
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(BdUtilHelper.getDimens(context, R.dimen.tbds36), BdUtilHelper.getDimens(context, R.dimen.tbds36));
        layoutParams5.gravity = 16;
        Unit unit5 = Unit.INSTANCE;
        linearLayout3.addView(imageView, layoutParams5);
        LinearLayout linearLayout4 = this.i;
        TextView textView = this.k;
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.gravity = 16;
        layoutParams6.setMargins(BdUtilHelper.getDimens(linearLayout.getContext(), R.dimen.M_W_X001), 0, 0, 0);
        Unit unit6 = Unit.INSTANCE;
        linearLayout4.addView(textView, layoutParams6);
        CardStaggeredVideoTagView cardStaggeredVideoTagView = this.h;
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(0, R.id.obfuscated_res_0x7f0907a0);
        layoutParams7.addRule(1, R.id.obfuscated_res_0x7f09292a);
        layoutParams7.addRule(15, -1);
        layoutParams7.setMargins(BdUtilHelper.getDimens(context, R.dimen.M_W_X002), 0, 0, 0);
        Unit unit7 = Unit.INSTANCE;
        relativeLayout.addView(cardStaggeredVideoTagView, layoutParams7);
        ImageView imageView2 = this.l;
        ViewGroup.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(BdUtilHelper.getDimens(context, R.dimen.tbds57) + (BdUtilHelper.getDimens(context, R.dimen.M_W_X002) * 2), BdUtilHelper.getDimens(context, R.dimen.tbds57) + (BdUtilHelper.getDimens(context, R.dimen.M_H_X001) * 2));
        imageView2.setPadding(BdUtilHelper.getDimens(context, R.dimen.M_W_X002), BdUtilHelper.getDimens(context, R.dimen.M_H_X001), BdUtilHelper.getDimens(context, R.dimen.M_W_X002), BdUtilHelper.getDimens(context, R.dimen.M_H_X001));
        Unit unit8 = Unit.INSTANCE;
        addView(imageView2, layoutParams8);
        imageView2.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f0809ca, WebPManager.ResourceStateType.NORMAL));
        imageView2.setVisibility(8);
        FrameLayout frameLayout = this.m;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setVisibility(8);
        ImageView imageView3 = this.n;
        FrameLayout frameLayout2 = this.m;
        FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(BdUtilHelper.getDimens(context, R.dimen.tbds57), BdUtilHelper.getDimens(context, R.dimen.tbds57));
        layoutParams9.setMargins(BdUtilHelper.getDimens(context, R.dimen.M_W_X002), BdUtilHelper.getDimens(context, R.dimen.M_H_X001), 0, 0);
        Unit unit9 = Unit.INSTANCE;
        frameLayout2.addView(imageView3, layoutParams9);
        imageView3.setImageResource(R.drawable.obfuscated_res_0x7f0809ea);
        f();
    }

    public /* synthetic */ CardStaggeredVideoView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final void l(bg7 state, CardStaggeredVideoView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, state, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Function2<Context, bg7, Unit> o = state.o();
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            o.invoke(context, state);
        }
    }

    public static final void n(CardStaggeredVideoView this$0, bg7 state, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, this$0, state, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(state, "$state");
            ya7.c(this$0.getContext(), state.l().b());
        }
    }

    public static final void o(CardStaggeredVideoView this$0, bg7 state, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, this$0, state, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(state, "$state");
            this$0.v(state.t());
        }
    }

    public static final void p(bg7 state, CardStaggeredVideoView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, state, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Function2<Context, bg7, Unit> n = state.n();
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            n.invoke(context, state);
        }
    }

    public static final void u(CardStaggeredVideoView this$0, b57 state, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, this$0, state, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(state, "$state");
            this$0.v(state);
        }
    }

    private final int getHorizontalVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            return (getMeasuredWidth() / 16) * 9;
        }
        return invokeV.intValue;
    }

    private final int getHorizontalVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            return getMeasuredWidth();
        }
        return invokeV.intValue;
    }

    private final int getVerticalVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            return (getVerticalVideoWidth() / 3) * 4;
        }
        return invokeV.intValue;
    }

    private final int getVerticalVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            return getHorizontalVideoWidth();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.db7
    public Object getVideoHolder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return invokeV.objValue;
    }

    public static final void i(bg7 state, CardStaggeredVideoView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, state, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Function2<Context, bg7, Unit> p = state.p();
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            p.invoke(context, state);
            s(this$0, state.w(), false, 2, null);
        }
    }

    public static /* synthetic */ void s(CardStaggeredVideoView cardStaggeredVideoView, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        cardStaggeredVideoView.r(z, z2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.feed.component.CardFrameView
    /* renamed from: d */
    public void a(bg7 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            e(state, false);
        }
    }

    public final void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                x4.b(this);
            } else {
                x4.a(this);
            }
        }
    }

    public final void e(bg7 bg7Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, bg7Var, z) == null) {
            q(bg7Var, z);
            g(bg7Var.u());
            t(bg7Var.t());
            m(bg7Var);
            f();
        }
    }

    public final void q(bg7 bg7Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, bg7Var, z) == null) {
            od7.b(this, bg7Var, false, 2, null);
            if (!z) {
                b bVar = new b(this);
                this.p = bVar;
                if (bVar != null) {
                    bg7Var.y(new WeakReference<>(bVar));
                }
            }
        }
    }

    @Override // com.baidu.tieba.kb7
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || lb7.a(this)) {
            return;
        }
        EMManager.from(this).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0201);
        EMManager.from(this.k).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0109).setTextSize(R.dimen.T_X09);
        EMManager.from(this.f).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X12).setTextColor(R.color.CAM_X0105);
        this.j.setImageResource(R.drawable.icon_pure_comment);
        this.d.onChangeSkinType();
        this.l.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f0809ca, WebPManager.ResourceStateType.NORMAL));
        if (this.o) {
            EMManager.from(this.m).setCorner(R.string.J_X05).setAlpha(R.string.A_X07).setBackGroundColor(R.color.CAM_X0201);
            this.n.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f0809eb, WebPManager.ResourceStateType.NORMAL));
            return;
        }
        this.m.setBackgroundResource(R.color.transparent);
        this.n.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f0809ea, WebPManager.ResourceStateType.NORMAL));
    }

    public final void h(final bg7 bg7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bg7Var) == null) {
            if (bg7Var.v()) {
                this.m.setVisibility(0);
                this.l.setVisibility(8);
                if (bg7Var.m()) {
                    this.m.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.rf7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                CardStaggeredVideoView.i(bg7.this, this, view2);
                            }
                        }
                    });
                    s(this, bg7Var.w(), false, 2, null);
                    return;
                }
                this.m.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.zf7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            CardStaggeredVideoView.j(view2);
                        }
                    }
                });
                r(true, false);
                return;
            }
            this.m.setVisibility(8);
            this.l.setVisibility(0);
        }
    }

    public final void t(final b57 b57Var) {
        int horizontalVideoWidth;
        int horizontalVideoHeight;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, b57Var) == null) {
            l87 p = b57Var.p();
            ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
            if (p.d) {
                horizontalVideoWidth = getVerticalVideoWidth();
            } else {
                horizontalVideoWidth = getHorizontalVideoWidth();
            }
            layoutParams.width = horizontalVideoWidth;
            if (p.d) {
                horizontalVideoHeight = getVerticalVideoHeight();
            } else {
                horizontalVideoHeight = getHorizontalVideoHeight();
            }
            layoutParams.height = horizontalVideoHeight;
            this.e.setLayoutParams(layoutParams);
            this.d.j(b57Var);
            if (!b57Var.n().f()) {
                setClickable(false);
            } else {
                this.e.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pf7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            CardStaggeredVideoView.u(CardStaggeredVideoView.this, b57Var, view2);
                        }
                    }
                });
            }
        }
    }

    public final void k(final bg7 bg7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bg7Var) == null) {
            if (bg7Var.z()) {
                h(bg7Var);
                this.l.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.vf7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            CardStaggeredVideoView.l(bg7.this, this, view2);
                        }
                    }
                });
                return;
            }
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            this.l.setOnClickListener(null);
            this.m.setOnClickListener(null);
        }
    }

    public final void m(final bg7 bg7Var) {
        SpannableStringBuilder spannableStringBuilder;
        boolean z;
        l67 l67Var;
        o67 o67Var;
        l67 l67Var2;
        n67 n67Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bg7Var) == null) {
            y47 s = bg7Var.s();
            n67 n67Var2 = null;
            if (s != null) {
                spannableStringBuilder = s.j();
            } else {
                spannableStringBuilder = null;
            }
            if (spannableStringBuilder != null && spannableStringBuilder.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                this.f.setVisibility(8);
            } else {
                this.f.setVisibility(0);
                TextViewCutUtilsKt.cutAndSetTextByMaxLine$default(this.f, spannableStringBuilder, 2, null, 1, 4, null);
            }
            this.g.startLoad(bg7Var.l().c());
            if (bg7Var.l().a() <= 0) {
                this.k.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0495));
            } else {
                this.k.setText(StringHelper.numFormatOverWan(bg7Var.l().a()));
            }
            List<l67> d = bg7Var.l().d();
            if (d != null) {
                l67Var = (l67) CollectionsKt___CollectionsKt.getOrNull(d, 0);
            } else {
                l67Var = null;
            }
            if (l67Var instanceof o67) {
                o67Var = (o67) l67Var;
            } else {
                o67Var = null;
            }
            if (o67Var == null) {
                o67Var = null;
            }
            List<l67> d2 = bg7Var.l().d();
            if (d2 != null) {
                l67Var2 = (l67) CollectionsKt___CollectionsKt.getOrNull(d2, 1);
            } else {
                l67Var2 = null;
            }
            if (l67Var2 instanceof n67) {
                n67Var = (n67) l67Var2;
            } else {
                n67Var = null;
            }
            if (n67Var != null) {
                n67Var2 = n67Var;
            }
            if (o67Var != null && n67Var2 != null) {
                this.h.c(o67Var, n67Var2);
            }
            this.g.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.of7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        CardStaggeredVideoView.n(CardStaggeredVideoView.this, bg7Var, view2);
                    }
                }
            });
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.qf7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        CardStaggeredVideoView.o(CardStaggeredVideoView.this, bg7Var, view2);
                    }
                }
            });
            this.i.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.wf7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        CardStaggeredVideoView.p(bg7.this, this, view2);
                    }
                }
            });
            this.h.setOnTagClickListener(new a(bg7Var, this));
            k(bg7Var);
        }
    }

    public final void r(boolean z, boolean z2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ImageView imageView = this.n;
            if (z2) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
            this.o = z;
            if (z) {
                EMManager.from(this.m).setCorner(R.string.J_X05).setAlpha(R.string.A_X07).setBackGroundColor(R.color.CAM_X0607);
                this.n.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f0809eb, WebPManager.ResourceStateType.NORMAL));
                return;
            }
            this.m.setBackgroundResource(R.color.transparent);
            this.n.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f0809ea, WebPManager.ResourceStateType.NORMAL));
        }
    }

    public final void v(b57 b57Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, b57Var) == null) {
            for (e87 e87Var : b57Var.o()) {
                ac7.a.f(e87Var, b57Var.k() + 1);
                b57Var.j().invoke(e87Var);
            }
            Rect rect = new Rect();
            getGlobalVisibleRect(rect);
            m87 n = b57Var.n();
            String a2 = ya7.a(b57Var.n().c(), "isShowBackAnim", "1");
            Intrinsics.checkNotNullExpressionValue(a2, "appendParam(state.schema…a, \"isShowBackAnim\", \"1\")");
            n.j(a2);
            Function3<Context, Rect, b57, Unit> m = b57Var.m();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            m.invoke(context, rect, b57Var);
        }
    }
}
