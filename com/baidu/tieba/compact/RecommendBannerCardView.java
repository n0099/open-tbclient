package com.baidu.tieba.compact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.ce8;
import com.baidu.tieba.compact.RecommendBannerCardView;
import com.baidu.tieba.fr6;
import com.baidu.tieba.lf8;
import com.baidu.tieba.pe8;
import com.baidu.tieba.qd;
import com.baidu.tieba.sa7;
import com.baidu.tieba.ta7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/baidu/tieba/compact/RecommendBannerCardView;", "Landroid/widget/LinearLayout;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "realView", "Lcom/baidu/tieba/homepage/personalize/adapter/QuizEntranceAdapter$QuizEntranceView;", "bindToParent", "", "parent", "Landroid/view/ViewGroup;", "onChangeSkin", StickerDataChangeType.UPDATE, "state", "Lcom/baidu/tieba/homepage/personalize/data/QuizEntranceData;", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecommendBannerCardView extends LinearLayout implements sa7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ce8.b a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RecommendBannerCardView(Context context) {
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
    public RecommendBannerCardView(Context context, AttributeSet attributeSet) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ RecommendBannerCardView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final void b(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, view2) == null) {
            TbSingleton.getInstance().isAddBanner = false;
            SharedPrefHelper.getInstance().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
        }
    }

    public final void c(final pe8 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            ce8.b bVar = this.a;
            if (bVar != null) {
                lf8.b(state.f);
                bVar.k(state);
                bVar.A(new View.OnClickListener() { // from class: com.baidu.tieba.ln6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            RecommendBannerCardView.d(pe8.this, this, view2);
                        }
                    }
                });
                r();
            }
        }
    }

    public static final void d(pe8 state, RecommendBannerCardView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, state, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!qd.isEmpty(state.e) && (this$0.getContext() instanceof fr6)) {
                lf8.a(state.g);
                UrlManager urlManager = UrlManager.getInstance();
                Context context = this$0.getContext();
                if (context != null) {
                    urlManager.dealOneLink(((fr6) context).getPageContext(), new String[]{state.e});
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.core.widget.PageContextWrapper");
            }
        }
    }

    public final void a(ViewGroup parent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, parent) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (!(getContext() instanceof fr6)) {
                return;
            }
            Context context = getContext();
            if (context != null) {
                ce8.b bVar = new ce8.b(((fr6) context).getPageContext(), parent);
                this.a = bVar;
                if (bVar != null) {
                    addView(bVar.i());
                    bVar.z(new View.OnClickListener() { // from class: com.baidu.tieba.nn6
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                RecommendBannerCardView.b(view2);
                            }
                        }
                    });
                    r();
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.core.widget.PageContextWrapper");
        }
    }

    @Override // com.baidu.tieba.sa7
    public void r() {
        ce8.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !ta7.a(this) && (getContext() instanceof fr6) && (bVar = this.a) != null) {
            Context context = getContext();
            if (context != null) {
                bVar.l(((fr6) context).getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.core.widget.PageContextWrapper");
        }
    }
}
