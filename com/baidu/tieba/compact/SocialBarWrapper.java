package com.baidu.tieba.compact;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout;
import com.baidu.tieba.compact.SocialBarWrapper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0014J\u0018\u0010\r\u001a\u00020\b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fJB\u0010\u0010\u001a\u00020\b2:\b\u0002\u0010\u000e\u001a4\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\b\u0018\u00010\u0011J\u0018\u0010\u0018\u001a\u00020\b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fJ\u0014\u0010\u0019\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00160\u000fJ\u0018\u0010\u001a\u001a\u00020\b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/baidu/tieba/compact/SocialBarWrapper;", "Lcom/baidu/tbadk/core/view/ThreadCardBottomOpSegmentLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "oldOnPraiseClickListener", "Landroid/view/View$OnClickListener;", "delegateClick", "", "v", "Landroid/view/View;", "initView", "view", "setAfterPraiseClick", WebChromeClient.KEY_ARG_CALLBACK, "Lkotlin/Function0;", "setOnAgreeNumUpdateListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "num", "", "isAgreed", "setOnCommentClick", "setOnManageClick", "setOnShareClick", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SocialBarWrapper extends ThreadCardBottomOpSegmentLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener x0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocialBarWrapper(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void d0(SocialBarWrapper this$0, Function0 function0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, this$0, function0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            View.OnClickListener onClickListener = this$0.x0;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public static final void f0(SocialBarWrapper this$0, Function0 function0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, this$0, function0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            View mCommentContainer = this$0.i;
            Intrinsics.checkNotNullExpressionValue(mCommentContainer, "mCommentContainer");
            this$0.c0(mCommentContainer);
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public static final void g0(Function0 callback, SocialBarWrapper this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callback, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!((Boolean) callback.invoke()).booleanValue()) {
                View mManageViewContainer = this$0.q;
                Intrinsics.checkNotNullExpressionValue(mManageViewContainer, "mManageViewContainer");
                this$0.c0(mManageViewContainer);
            }
        }
    }

    public static final void h0(SocialBarWrapper this$0, Function0 function0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, this$0, function0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            View mShareContainer = this$0.l;
            Intrinsics.checkNotNullExpressionValue(mShareContainer, "mShareContainer");
            this$0.c0(mShareContainer);
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public static final void e0(Function2 function2, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{function2, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            function2.invoke(Long.valueOf(j), Boolean.valueOf(z));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.compact.SocialBarWrapper */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setAfterPraiseClick$default(SocialBarWrapper socialBarWrapper, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        socialBarWrapper.setAfterPraiseClick(function0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.compact.SocialBarWrapper */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setOnAgreeNumUpdateListener$default(SocialBarWrapper socialBarWrapper, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            function2 = null;
        }
        socialBarWrapper.setOnAgreeNumUpdateListener(function2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.compact.SocialBarWrapper */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setOnCommentClick$default(SocialBarWrapper socialBarWrapper, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        socialBarWrapper.setOnCommentClick(function0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.compact.SocialBarWrapper */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setOnShareClick$default(SocialBarWrapper socialBarWrapper, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        socialBarWrapper.setOnShareClick(function0);
    }

    public final void c0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            onClick(view2);
        }
    }

    public final void setAfterPraiseClick(final Function0<Unit> function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, function0) == null) {
            this.e.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.un6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        SocialBarWrapper.d0(SocialBarWrapper.this, function0, view2);
                    }
                }
            });
        }
    }

    public final void setOnAgreeNumUpdateListener(final Function2<? super Long, ? super Boolean, Unit> function2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, function2) == null) && function2 != null) {
            this.e.setOnAgreeNumUpdateListener(new AgreeView.i() { // from class: com.baidu.tieba.vn6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tbadk.core.view.AgreeView.i
                public final void a(long j, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
                        SocialBarWrapper.e0(Function2.this, j, z);
                    }
                }
            });
        }
    }

    public final void setOnCommentClick(final Function0<Unit> function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, function0) == null) {
            this.i.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ao6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        SocialBarWrapper.f0(SocialBarWrapper.this, function0, view2);
                    }
                }
            });
        }
    }

    public final void setOnManageClick(final Function0<Boolean> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.q.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.xn6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        SocialBarWrapper.g0(Function0.this, this, view2);
                    }
                }
            });
        }
    }

    public final void setOnShareClick(final Function0<Unit> function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, function0) == null) {
            this.l.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.bo6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        SocialBarWrapper.h0(SocialBarWrapper.this, function0, view2);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void y(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            super.y(view2);
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                onClickListener = agreeView.C;
            } else {
                onClickListener = null;
            }
            this.x0 = onClickListener;
        }
    }
}
