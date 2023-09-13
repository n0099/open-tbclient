package com.baidu.tieba.feed.widget;

import android.content.Context;
import android.net.http.Headers;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.feed.widget.ForumAttentionView;
import com.baidu.tieba.he7;
import com.baidu.tieba.oa5;
import com.baidu.tieba.ye7;
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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\fJ\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000eJ\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/baidu/tieba/feed/widget/ForumAttentionView;", "Lcom/baidu/tbadk/core/view/commonBtn/TBSpecificationBtn;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", Headers.REFRESH, "Ljava/lang/Runnable;", "initButtonStyle", "", "isLike", "", "onChangeSkinType", StickerDataChangeType.UPDATE, "state", "Lcom/baidu/tieba/feed/widget/uistate/ForumAttentionUiState;", "updateUiOnly", "updateLikeStatus", "lib-components_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ForumAttentionView extends TBSpecificationBtn {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable o;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ForumAttentionView(Context context) {
        this(context, null, 0, 6, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ForumAttentionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ForumAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        q(false);
        setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02ea));
    }

    public /* synthetic */ ForumAttentionView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static /* synthetic */ void s(ForumAttentionView forumAttentionView, ye7 ye7Var, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        forumAttentionView.update(ye7Var, z);
    }

    public static final void t(final ForumAttentionView this$0, final ye7 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, this$0, state) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(state, "$state");
            if (he7.a(this$0, state, false)) {
                this$0.post(new Runnable() { // from class: com.baidu.tieba.pe7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ForumAttentionView.u(ForumAttentionView.this, state);
                        }
                    }
                });
            }
        }
    }

    public static final void u(ForumAttentionView this$0, ye7 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, this$0, state) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(state, "$state");
            this$0.update(state, true);
        }
    }

    public static final void v(ye7 state, TbPageContext pageContext, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, state, pageContext, view2) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            Function2<ye7, TbPageContext<?>, Unit> g = state.g();
            Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
            g.invoke(state, pageContext);
        }
    }

    public final void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            oa5 oa5Var = new oa5();
            if (z) {
                oa5Var.w(R.color.CAM_X0109);
            } else {
                oa5Var.u(R.color.CAM_X0302);
                oa5Var.j(R.drawable.icon_pure_follow26, 0, TBSpecificationButtonConfig.IconType.WEBP);
                oa5Var.i(R.color.CAM_X0304);
                oa5Var.h(BdUtilHelper.getDimens(getContext(), R.dimen.tbds26));
                oa5Var.g(BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X002));
            }
            setConfig(oa5Var);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            k();
        }
    }

    public final void update(final ye7 state, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, state, z) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            he7.b(this, state, false, 2, null);
            if (!z) {
                Runnable runnable = new Runnable() { // from class: com.baidu.tieba.le7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ForumAttentionView.t(ForumAttentionView.this, state);
                        }
                    }
                };
                this.o = runnable;
                if (runnable != null) {
                    state.c(runnable);
                }
            }
            if (!z && (getContext() instanceof TbPageContextSupport)) {
                Context context = getContext();
                if (context != null) {
                    final TbPageContext pageContext = ((TbPageContextSupport) context).getPageContext();
                    setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ke7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                ForumAttentionView.v(ye7.this, pageContext, view2);
                            }
                        }
                    });
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.TbPageContextSupport");
                }
            }
            w(state.f().c());
        }
    }

    public final void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            q(z);
            if (z) {
                setClickable(true);
                setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            } else {
                setClickable(true);
                setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02ea));
            }
            r();
        }
    }
}
