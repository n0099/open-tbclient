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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bJB\u0010\f\u001a\u00020\u00062:\b\u0002\u0010\n\u001a4\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rJ\u0018\u0010\u0014\u001a\u00020\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bJ\u0018\u0010\u0015\u001a\u00020\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b¨\u0006\u0016"}, d2 = {"Lcom/baidu/tieba/compact/SocialBarWrapper;", "Lcom/baidu/tbadk/core/view/ThreadCardBottomOpSegmentLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "delegateClick", "", "v", "Landroid/view/View;", "setAfterPraiseClick", WebChromeClient.KEY_ARG_CALLBACK, "Lkotlin/Function0;", "setOnAgreeNumUpdateListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "num", "", "isAgreed", "setOnCommentClick", "setOnShareClick", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SocialBarWrapper extends ThreadCardBottomOpSegmentLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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

    public static final void e0(View.OnClickListener onClickListener, Function0 function0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, onClickListener, function0, view2) == null) {
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
            function0.invoke();
        }
    }

    public static final void g0(SocialBarWrapper this$0, Function0 function0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, this$0, function0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            View mCommentContainer = this$0.i;
            Intrinsics.checkNotNullExpressionValue(mCommentContainer, "mCommentContainer");
            this$0.d0(mCommentContainer);
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public static final void h0(SocialBarWrapper this$0, Function0 function0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, function0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            View mShareContainer = this$0.l;
            Intrinsics.checkNotNullExpressionValue(mShareContainer, "mShareContainer");
            this$0.d0(mShareContainer);
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public static final void f0(Function2 function2, long j, boolean z) {
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

    public final void d0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            onClick(view2);
        }
    }

    public final void setAfterPraiseClick(final Function0<Unit> function0) {
        final View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, function0) == null) && function0 != null) {
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                onClickListener = agreeView.C;
            } else {
                onClickListener = null;
            }
            AgreeView agreeView2 = this.e;
            if (agreeView2 != null) {
                agreeView2.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ro6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            SocialBarWrapper.e0(onClickListener, function0, view2);
                        }
                    }
                });
            }
        }
    }

    public final void setOnAgreeNumUpdateListener(final Function2<? super Long, ? super Boolean, Unit> function2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, function2) == null) && function2 != null) {
            this.e.setOnAgreeNumUpdateListener(new AgreeView.j() { // from class: com.baidu.tieba.mo6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tbadk.core.view.AgreeView.j
                public final void a(long j, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
                        SocialBarWrapper.f0(Function2.this, j, z);
                    }
                }
            });
        }
    }

    public final void setOnCommentClick(final Function0<Unit> function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, function0) == null) {
            this.i.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.qo6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        SocialBarWrapper.g0(SocialBarWrapper.this, function0, view2);
                    }
                }
            });
        }
    }

    public final void setOnShareClick(final Function0<Unit> function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, function0) == null) {
            this.l.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.so6
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
}
