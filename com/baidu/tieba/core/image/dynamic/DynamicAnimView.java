package com.baidu.tieba.core.image.dynamic;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.afx.callback.OnVideoEndedListener;
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.as6;
import com.baidu.tieba.core.image.dynamic.DynamicAnimView;
import com.baidu.tieba.tbadkcore.databinding.DynamicAnimAfxViewBinding;
import com.baidu.tieba.tbadkcore.databinding.DynamicAnimViewBinding;
import com.baidu.tieba.tbadkcore.databinding.DynamicAnimWebpViewBinding;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u000fH\u0002J\b\u0010\u001b\u001a\u00020\u000fH\u0002J\b\u0010\u001c\u001a\u00020\u000fH\u0002J\u0006\u0010\u001d\u001a\u00020\u000fJ\u0012\u0010\u001e\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!H\u0002J\u000e\u0010\"\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!J\u0010\u0010#\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!H\u0002J\u0006\u0010$\u001a\u00020\u000fR\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/baidu/tieba/core/image/dynamic/DynamicAnimView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "afxBinding", "Lcom/baidu/tieba/tbadkcore/databinding/DynamicAnimAfxViewBinding;", "binding", "Lcom/baidu/tieba/tbadkcore/databinding/DynamicAnimViewBinding;", "onClickListener", "Landroid/view/View$OnClickListener;", "onDynamicAnimEndListener", "Lkotlin/Function0;", "", "getOnDynamicAnimEndListener", "()Lkotlin/jvm/functions/Function0;", "setOnDynamicAnimEndListener", "(Lkotlin/jvm/functions/Function0;)V", "webpBinding", "Lcom/baidu/tieba/tbadkcore/databinding/DynamicAnimWebpViewBinding;", "isNotViewStubInflated", "", "viewStub", "Landroid/view/ViewStub;", "resetAfxView", "resetAllView", "resetWebpView", "setLastAnimationCurFrameToPLaceHolder", "setOnClickListener", "updateAfxView", "data", "Lcom/baidu/tieba/core/image/dynamic/DynamicAnimData;", "updateData", "updateWebpView", "webpStopAndDelay", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DynamicAnimView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final DynamicAnimViewBinding a;
    public DynamicAnimAfxViewBinding b;
    public DynamicAnimWebpViewBinding c;
    public View.OnClickListener d;
    public Function0<Unit> e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DynamicAnimView(Context context) {
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
    public static final class a extends BaseAnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Ref.BooleanRef a;
        public final /* synthetic */ DynamicAnimView b;

        public a(Ref.BooleanRef booleanRef, DynamicAnimView dynamicAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {booleanRef, dynamicAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = booleanRef;
            this.b = dynamicAnimView;
        }

        public static final void a(DynamicAnimView this$0) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                DynamicAnimWebpViewBinding dynamicAnimWebpViewBinding = this$0.c;
                if (dynamicAnimWebpViewBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webpBinding");
                    dynamicAnimWebpViewBinding = null;
                }
                dynamicAnimWebpViewBinding.b.o();
            }
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public void onAnimationStart(AnimatedDrawable2 animatedDrawable2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animatedDrawable2) == null) {
                Ref.BooleanRef booleanRef = this.a;
                if (booleanRef.element) {
                    return;
                }
                booleanRef.element = true;
                DynamicAnimWebpViewBinding dynamicAnimWebpViewBinding = this.b.c;
                if (dynamicAnimWebpViewBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webpBinding");
                    dynamicAnimWebpViewBinding = null;
                }
                dynamicAnimWebpViewBinding.b.p();
                SafeHandler inst = SafeHandler.getInst();
                final DynamicAnimView dynamicAnimView = this.b;
                inst.postDelayed(new Runnable() { // from class: com.baidu.tieba.zr6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            DynamicAnimView.a.a(DynamicAnimView.this);
                        }
                    }
                }, 5000L);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DynamicAnimView(Context context, AttributeSet attributeSet) {
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
        DynamicAnimViewBinding c = DynamicAnimViewBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(LayoutInflater.from(context), this, true)");
        this.a = c;
        c.b.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.baidu.tieba.xr6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub, View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, viewStub, view2) == null) {
                    DynamicAnimView.a(DynamicAnimView.this, viewStub, view2);
                }
            }
        });
        this.a.c.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.baidu.tieba.yr6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub, View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, viewStub, view2) == null) {
                    DynamicAnimView.b(DynamicAnimView.this, viewStub, view2);
                }
            }
        });
    }

    public /* synthetic */ DynamicAnimView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final void a(DynamicAnimView this$0, ViewStub viewStub, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, this$0, viewStub, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            DynamicAnimAfxViewBinding a2 = DynamicAnimAfxViewBinding.a(view2);
            Intrinsics.checkNotNullExpressionValue(a2, "bind(inflated)");
            this$0.b = a2;
        }
    }

    public static final void b(DynamicAnimView this$0, ViewStub viewStub, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, viewStub, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            DynamicAnimWebpViewBinding a2 = DynamicAnimWebpViewBinding.a(view2);
            Intrinsics.checkNotNullExpressionValue(a2, "bind(inflated)");
            this$0.c = a2;
        }
    }

    public static final void i(DynamicAnimView this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Function0<Unit> function0 = this$0.e;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public final boolean d(ViewStub viewStub) {
        InterceptResult invokeL;
        ViewParent viewParent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewStub)) == null) {
            if (viewStub != null) {
                viewParent = viewStub.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.d = onClickListener;
        }
    }

    public final void setOnDynamicAnimEndListener(Function0<Unit> function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, function0) == null) {
            this.e = function0;
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || d(this.a.b)) {
            return;
        }
        DynamicAnimAfxViewBinding dynamicAnimAfxViewBinding = this.b;
        if (dynamicAnimAfxViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("afxBinding");
            dynamicAnimAfxViewBinding = null;
        }
        TbAlphaVideo tbAlphaVideo = dynamicAnimAfxViewBinding.b;
        tbAlphaVideo.setVisibility(8);
        tbAlphaVideo.l();
        tbAlphaVideo.setKeepLastFrame(false);
        tbAlphaVideo.setOnVideoEndedListener(null);
        tbAlphaVideo.setOnClickListener(null);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || d(this.a.c)) {
            return;
        }
        DynamicAnimWebpViewBinding dynamicAnimWebpViewBinding = this.c;
        if (dynamicAnimWebpViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webpBinding");
            dynamicAnimWebpViewBinding = null;
        }
        TbImage tbImage = dynamicAnimWebpViewBinding.b;
        tbImage.setVisibility(8);
        tbImage.p();
        tbImage.setLooping(true);
        tbImage.setOnWebpEndedListener(null);
        tbImage.setOnClickListener(null);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || d(this.a.c)) {
            return;
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        DynamicAnimWebpViewBinding dynamicAnimWebpViewBinding = this.c;
        if (dynamicAnimWebpViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webpBinding");
            dynamicAnimWebpViewBinding = null;
        }
        dynamicAnimWebpViewBinding.b.setAnimationListener(new a(booleanRef, this));
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            e();
            g();
        }
    }

    public final Function0<Unit> getOnDynamicAnimEndListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (Function0) invokeV.objValue;
    }

    public final void setLastAnimationCurFrameToPLaceHolder() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            DynamicAnimWebpViewBinding dynamicAnimWebpViewBinding = this.c;
            if (dynamicAnimWebpViewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webpBinding");
                dynamicAnimWebpViewBinding = null;
            }
            dynamicAnimWebpViewBinding.b.setCurFrameToPLaceHolder();
        }
    }

    public final void h(as6 as6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, as6Var) == null) {
            if (d(this.a.b)) {
                this.a.b.inflate();
            }
            DynamicAnimAfxViewBinding dynamicAnimAfxViewBinding = this.b;
            if (dynamicAnimAfxViewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("afxBinding");
                dynamicAnimAfxViewBinding = null;
            }
            TbAlphaVideo tbAlphaVideo = dynamicAnimAfxViewBinding.b;
            tbAlphaVideo.setVisibility(0);
            tbAlphaVideo.setOnClickListener(this.d);
            tbAlphaVideo.setKeepLastFrame(as6Var.b());
            tbAlphaVideo.setSourcePath(as6Var.a());
            if (as6Var.b()) {
                tbAlphaVideo.setKeepLastFrame(false);
                tbAlphaVideo.setLooping(true);
                tbAlphaVideo.setOnVideoEndedListener(null);
            } else {
                tbAlphaVideo.setKeepLastFrame(true);
                tbAlphaVideo.setLooping(false);
                tbAlphaVideo.setOnVideoEndedListener(new OnVideoEndedListener() { // from class: com.baidu.tieba.wr6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
                    public final void onVideoEnded() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            DynamicAnimView.i(DynamicAnimView.this);
                        }
                    }
                });
            }
            tbAlphaVideo.i();
        }
    }

    public final void j(as6 data) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            String a2 = data.a();
            if (a2 != null && !StringsKt__StringsJVMKt.isBlank(a2)) {
                z = false;
            } else {
                z = true;
            }
            if (!z && new File(data.a()).exists()) {
                int type = data.getType();
                if (type != 1) {
                    if (type != 2) {
                        f();
                        return;
                    }
                    e();
                    k(data);
                    return;
                }
                g();
                h(data);
                return;
            }
            f();
        }
    }

    public final void k(as6 as6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, as6Var) == null) {
            if (d(this.a.c)) {
                this.a.c.inflate();
            }
            DynamicAnimWebpViewBinding dynamicAnimWebpViewBinding = this.c;
            if (dynamicAnimWebpViewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webpBinding");
                dynamicAnimWebpViewBinding = null;
            }
            TbImage tbImage = dynamicAnimWebpViewBinding.b;
            tbImage.setVisibility(0);
            tbImage.setOnClickListener(this.d);
            tbImage.setImageURI(Uri.fromFile(new File(as6Var.a())), (Object) null);
            if (as6Var.b()) {
                tbImage.setLooping(true);
                tbImage.setOnWebpEndedListener(null);
                return;
            }
            tbImage.setLooping(false);
            tbImage.setOnWebpEndedListener(new Function0<Unit>(this) { // from class: com.baidu.tieba.core.image.dynamic.DynamicAnimView$updateWebpView$1$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DynamicAnimView this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Function0<Unit> onDynamicAnimEndListener;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (onDynamicAnimEndListener = this.this$0.getOnDynamicAnimEndListener()) != null) {
                        onDynamicAnimEndListener.invoke();
                    }
                }
            });
        }
    }
}
