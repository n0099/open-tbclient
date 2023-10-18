package com.baidu.tieba.feed.component;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.a77;
import com.baidu.tieba.b37;
import com.baidu.tieba.bu;
import com.baidu.tieba.c77;
import com.baidu.tieba.f37;
import com.baidu.tieba.feed.component.CardVirtualHeadView;
import com.baidu.tieba.feed.widget.AutoDegradeTagView;
import com.baidu.tieba.feed.widget.VirtualImageView;
import com.baidu.tieba.h27;
import com.baidu.tieba.m;
import com.baidu.tieba.m37;
import com.baidu.tieba.n47;
import com.baidu.tieba.vca;
import com.baidu.tieba.view.VirtualImageStatusTip;
import com.baidu.tieba.z87;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ,2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001,B\u001b\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\b\u0010\u001e\u001a\u00020\rH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0014J\b\u0010 \u001a\u00020\u001aH\u0016J\b\u0010!\u001a\u00020\u001aH\u0014J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010&\u001a\u00020\u001aH\u0016J\b\u0010'\u001a\u00020\u001aH\u0002J\b\u0010(\u001a\u00020\u001aH\u0002J\u000e\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/baidu/tieba/feed/component/CardVirtualHeadView;", "Landroid/widget/RelativeLayout;", "Lcom/baidu/tieba/feed/list/OnScrollIdleListener;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "feedBackBtn", "Landroid/widget/ImageView;", "hasAnimated", "", "headExtendInfo", "Lcom/baidu/tieba/feed/widget/AutoDegradeTagView;", "headMainView", "needAnimate", "needShowVirtualImageStatusTip", "viewRect", "Landroid/graphics/Rect;", "virtualImageStatusTip", "Lcom/baidu/tieba/view/VirtualImageStatusTip;", "virtualImageView", "Lcom/baidu/tieba/feed/widget/VirtualImageView;", "doStatusTipAnim", "", "initFeedBackBtn", "initHeadInfoLayout", "initVirtualImageView", "isInPlayArea", "onAttachedToWindow", "onChangeSkin", "onDetachedFromWindow", MissionEvent.MESSAGE_PAUSE, "owner", "Landroidx/lifecycle/LifecycleOwner;", "onResume", "onScrollIdle", "resetAnim", "resetHeadMainView", "updateState", "uiState", "Lcom/baidu/tieba/feed/component/uistate/CardVirtualHeadUiState;", "Companion", "lib-templates_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CardVirtualHeadView extends RelativeLayout implements c77, a77, DefaultLifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Rect a;
    public VirtualImageView b;
    public AutoDegradeTagView c;
    public AutoDegradeTagView d;
    public ImageView e;
    public VirtualImageStatusTip f;
    public boolean g;
    public boolean h;
    public boolean i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1283607408, "Lcom/baidu/tieba/feed/component/CardVirtualHeadView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1283607408, "Lcom/baidu/tieba/feed/component/CardVirtualHeadView;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CardVirtualHeadView(Context context) {
        this(context, null, 2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public /* synthetic */ void onCreate(@NonNull LifecycleOwner lifecycleOwner) {
        m.$default$onCreate(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public /* synthetic */ void onDestroy(@NonNull LifecycleOwner lifecycleOwner) {
        m.$default$onDestroy(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public /* synthetic */ void onStart(@NonNull LifecycleOwner lifecycleOwner) {
        m.$default$onStart(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public /* synthetic */ void onStop(@NonNull LifecycleOwner lifecycleOwner) {
        m.$default$onStop(this, lifecycleOwner);
    }

    /* loaded from: classes5.dex */
    public static final class a implements AutoDegradeTagView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h27 a;

        public a(h27 h27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h27Var;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
            if (((r5 == null || r5.length() == 0) ? true : true) == false) goto L23;
         */
        @Override // com.baidu.tieba.feed.widget.AutoDegradeTagView.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(f37 data, View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, data, view2) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(view2, "view");
                String F = data.F();
                boolean z2 = false;
                if (F != null && F.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                String str = null;
                if (z) {
                    F = null;
                }
                if (F == null) {
                    F = this.a.k();
                }
                str = F;
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
        public final /* synthetic */ h27 a;

        public b(h27 h27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h27Var;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
            if (((r5 == null || r5.length() == 0) ? true : true) == false) goto L23;
         */
        @Override // com.baidu.tieba.feed.widget.AutoDegradeTagView.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(f37 data, View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, data, view2) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(view2, "view");
                String F = data.F();
                boolean z2 = false;
                if (F != null && F.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                String str = null;
                if (z) {
                    F = null;
                }
                if (F == null) {
                    F = this.a.k();
                }
                str = F;
                if (str != null) {
                    this.a.i().invoke(view2, str);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CardVirtualHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = new Rect();
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setClipChildren(false);
        setClipToPadding(false);
        l();
        j();
        k();
    }

    public /* synthetic */ CardVirtualHeadView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final void B(h27 uiState, String it, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, uiState, it, view2) == null) {
            Intrinsics.checkNotNullParameter(uiState, "$uiState");
            Intrinsics.checkNotNullParameter(it, "$it");
            Function2<View, String, Unit> i = uiState.i();
            Intrinsics.checkNotNullExpressionValue(view2, "view");
            i.invoke(view2, it);
        }
    }

    public static final void C(h27 uiState, View it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, uiState, it) == null) {
            Intrinsics.checkNotNullParameter(uiState, "$uiState");
            Function2<m37, View, Unit> g = uiState.g();
            m37 e = uiState.e();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            g.invoke(e, it);
        }
    }

    public static final void D(CardVirtualHeadView this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.c();
        }
    }

    public static final void o(CardVirtualHeadView this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.c();
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onPause(LifecycleOwner owner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, owner) == null) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.i = true;
            m.$default$onPause(this, owner);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onResume(LifecycleOwner owner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, owner) == null) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            m.$default$onResume(this, owner);
            postDelayed(new Runnable() { // from class: com.baidu.tieba.d17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        CardVirtualHeadView.o(CardVirtualHeadView.this);
                    }
                }
            }, 500L);
        }
    }

    public static final void w(h27 uiState, View it) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, uiState, it) == null) {
            Intrinsics.checkNotNullParameter(uiState, "$uiState");
            String c = uiState.c();
            if (c != null && c.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                Function2<View, String, Boolean> h = uiState.h();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                h.invoke(it, uiState.c());
            }
            n47 a2 = uiState.f().a();
            if (a2 != null) {
                uiState.j().invoke(a2);
            }
        }
    }

    @Override // com.baidu.tieba.a77
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            AutoDegradeTagView autoDegradeTagView = this.c;
            VirtualImageStatusTip virtualImageStatusTip = null;
            if (autoDegradeTagView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headMainView");
                autoDegradeTagView = null;
            }
            autoDegradeTagView.b();
            AutoDegradeTagView autoDegradeTagView2 = this.d;
            if (autoDegradeTagView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headExtendInfo");
                autoDegradeTagView2 = null;
            }
            autoDegradeTagView2.b();
            ImageView imageView = this.e;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
                imageView = null;
            }
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_card_close22, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
            VirtualImageStatusTip virtualImageStatusTip2 = this.f;
            if (virtualImageStatusTip2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("virtualImageStatusTip");
            } else {
                virtualImageStatusTip = virtualImageStatusTip2;
            }
            virtualImageStatusTip.i();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.g) {
            VirtualImageStatusTip virtualImageStatusTip = this.f;
            VirtualImageStatusTip virtualImageStatusTip2 = null;
            if (virtualImageStatusTip == null) {
                Intrinsics.throwUninitializedPropertyAccessException("virtualImageStatusTip");
                virtualImageStatusTip = null;
            }
            if (virtualImageStatusTip.getVisibility() != 0) {
                AutoDegradeTagView autoDegradeTagView = this.d;
                if (autoDegradeTagView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headExtendInfo");
                    autoDegradeTagView = null;
                }
                autoDegradeTagView.setVisibility(8);
                AutoDegradeTagView autoDegradeTagView2 = this.c;
                if (autoDegradeTagView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headMainView");
                    autoDegradeTagView2 = null;
                }
                bu.c(autoDegradeTagView2);
                VirtualImageStatusTip virtualImageStatusTip3 = this.f;
                if (virtualImageStatusTip3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("virtualImageStatusTip");
                    virtualImageStatusTip3 = null;
                }
                virtualImageStatusTip3.setVisibility(0);
                VirtualImageStatusTip virtualImageStatusTip4 = this.f;
                if (virtualImageStatusTip4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("virtualImageStatusTip");
                } else {
                    virtualImageStatusTip2 = virtualImageStatusTip4;
                }
                virtualImageStatusTip2.f();
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            View view2 = null;
            VirtualImageView virtualImageView = new VirtualImageView(context, null, 2, null);
            this.b = virtualImageView;
            if (virtualImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("virtualImageView");
                virtualImageView = null;
            }
            virtualImageView.setId(R.id.obfuscated_res_0x7f0905f2);
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds148);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
            layoutParams.addRule(15);
            View view3 = this.b;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("virtualImageView");
            } else {
                view2 = view3;
            }
            addView(view2, layoutParams);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            AutoDegradeTagView autoDegradeTagView = this.c;
            VirtualImageView virtualImageView = null;
            if (autoDegradeTagView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headMainView");
                autoDegradeTagView = null;
            }
            autoDegradeTagView.animate().cancel();
            s();
            VirtualImageStatusTip virtualImageStatusTip = this.f;
            if (virtualImageStatusTip == null) {
                Intrinsics.throwUninitializedPropertyAccessException("virtualImageStatusTip");
                virtualImageStatusTip = null;
            }
            virtualImageStatusTip.setVisibility(8);
            AutoDegradeTagView autoDegradeTagView2 = this.d;
            if (autoDegradeTagView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headExtendInfo");
                autoDegradeTagView2 = null;
            }
            autoDegradeTagView2.setVisibility(0);
            VirtualImageView virtualImageView2 = this.b;
            if (virtualImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("virtualImageView");
            } else {
                virtualImageView = virtualImageView2;
            }
            virtualImageView.b();
            this.h = false;
        }
    }

    @Override // com.baidu.tieba.c77
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.i) {
                this.i = false;
                q();
            }
            if (n() && !this.h) {
                this.h = true;
                VirtualImageView virtualImageView = this.b;
                if (virtualImageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("virtualImageView");
                    virtualImageView = null;
                }
                virtualImageView.d();
                g();
            }
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            getGlobalVisibleRect(this.a);
            float equipmentHeight = BdUtilHelper.getEquipmentHeight(getContext());
            int i = (int) (0.05f * equipmentHeight);
            int i2 = (int) (equipmentHeight * 0.7f);
            Rect rect = this.a;
            if (rect.top >= i && rect.bottom <= i2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onAttachedToWindow();
            if (getContext() instanceof LifecycleOwner) {
                Context context = getContext();
                if (context != null) {
                    ((LifecycleOwner) context).getLifecycle().addObserver(this);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDetachedFromWindow();
            if (getContext() instanceof LifecycleOwner) {
                Context context = getContext();
                if (context != null) {
                    ((LifecycleOwner) context).getLifecycle().removeObserver(this);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            AutoDegradeTagView autoDegradeTagView = this.c;
            AutoDegradeTagView autoDegradeTagView2 = null;
            if (autoDegradeTagView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headMainView");
                autoDegradeTagView = null;
            }
            autoDegradeTagView.setScaleX(1.0f);
            AutoDegradeTagView autoDegradeTagView3 = this.c;
            if (autoDegradeTagView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headMainView");
                autoDegradeTagView3 = null;
            }
            autoDegradeTagView3.setScaleY(1.0f);
            AutoDegradeTagView autoDegradeTagView4 = this.c;
            if (autoDegradeTagView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headMainView");
            } else {
                autoDegradeTagView2 = autoDegradeTagView4;
            }
            autoDegradeTagView2.setTranslationY(0.0f);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ImageView imageView = new ImageView(getContext());
            this.e = imageView;
            View view2 = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
                imageView = null;
            }
            imageView.setVisibility(8);
            ImageView imageView2 = this.e;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
                imageView2 = null;
            }
            imageView2.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_card_close22, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
            ImageView imageView3 = this.e;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
                imageView3 = null;
            }
            imageView3.setId(R.id.obfuscated_res_0x7f0905f0);
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds88);
            int dimens2 = BdUtilHelper.getDimens(getContext(), R.dimen.tbds8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
            layoutParams.addRule(15);
            layoutParams.addRule(11);
            layoutParams.rightMargin = BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X005);
            ImageView imageView4 = this.e;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
                imageView4 = null;
            }
            imageView4.setPadding(dimens2, dimens2, dimens2, dimens2);
            View view3 = this.e;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
            } else {
                view2 = view3;
            }
            addView(view2, layoutParams);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setClipChildren(false);
            linearLayout.setClipToPadding(false);
            linearLayout.setOrientation(1);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            VirtualImageStatusTip virtualImageStatusTip = null;
            AutoDegradeTagView autoDegradeTagView = new AutoDegradeTagView(context, null, 2, null);
            this.c = autoDegradeTagView;
            if (autoDegradeTagView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headMainView");
                autoDegradeTagView = null;
            }
            autoDegradeTagView.setTagConfig(BdUtilHelper.getDimens(getContext(), R.dimen.T_X07), BdUtilHelper.getDimens(getContext(), R.dimen.tbds39), BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X002), R.color.CAM_X0105);
            AutoDegradeTagView autoDegradeTagView2 = this.c;
            if (autoDegradeTagView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headMainView");
                autoDegradeTagView2 = null;
            }
            linearLayout.addView(autoDegradeTagView2);
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            AutoDegradeTagView autoDegradeTagView3 = new AutoDegradeTagView(context2, null, 2, null);
            this.d = autoDegradeTagView3;
            if (autoDegradeTagView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headExtendInfo");
                autoDegradeTagView3 = null;
            }
            autoDegradeTagView3.setTagConfig(BdUtilHelper.getDimens(getContext(), R.dimen.T_X09), BdUtilHelper.getDimens(getContext(), R.dimen.tbds31), BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X004), R.color.CAM_X0109);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = BdUtilHelper.getDimens(getContext(), R.dimen.tbds5);
            AutoDegradeTagView autoDegradeTagView4 = this.d;
            if (autoDegradeTagView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headExtendInfo");
                autoDegradeTagView4 = null;
            }
            linearLayout.addView(autoDegradeTagView4, layoutParams);
            this.f = new VirtualImageStatusTip(getContext());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = BdUtilHelper.getDimens(getContext(), R.dimen.tbds_16);
            layoutParams2.leftMargin = BdUtilHelper.getDimens(getContext(), R.dimen.tbds_10);
            VirtualImageStatusTip virtualImageStatusTip2 = this.f;
            if (virtualImageStatusTip2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("virtualImageStatusTip");
            } else {
                virtualImageStatusTip = virtualImageStatusTip2;
            }
            linearLayout.addView(virtualImageStatusTip, layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams3.addRule(15);
            layoutParams3.addRule(1, R.id.obfuscated_res_0x7f0905f2);
            layoutParams3.addRule(0, R.id.obfuscated_res_0x7f0905f0);
            addView(linearLayout, layoutParams3);
        }
    }

    public final void v(final h27 uiState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, uiState) == null) {
            Intrinsics.checkNotNullParameter(uiState, "uiState");
            ImageView imageView = null;
            if (z87.b(this, uiState, false, 2, null)) {
                b();
                return;
            }
            boolean z = true;
            this.i = true;
            b37 c = uiState.f().c();
            if (c.a() == 1) {
                int f = vca.f(c.b());
                VirtualImageView virtualImageView = this.b;
                if (virtualImageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("virtualImageView");
                    virtualImageView = null;
                }
                virtualImageView.setImageBgColorInt(f);
            } else {
                VirtualImageView virtualImageView2 = this.b;
                if (virtualImageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("virtualImageView");
                    virtualImageView2 = null;
                }
                virtualImageView2.setImageBgUrl(c.b());
            }
            VirtualImageView virtualImageView3 = this.b;
            if (virtualImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("virtualImageView");
                virtualImageView3 = null;
            }
            virtualImageView3.setImageUrl(c.d());
            VirtualImageView virtualImageView4 = this.b;
            if (virtualImageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("virtualImageView");
                virtualImageView4 = null;
            }
            virtualImageView4.c(c.c());
            n47 e = uiState.f().e();
            if (e != null) {
                uiState.j().invoke(e);
            }
            VirtualImageView virtualImageView5 = this.b;
            if (virtualImageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("virtualImageView");
                virtualImageView5 = null;
            }
            virtualImageView5.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.x07
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        CardVirtualHeadView.w(h27.this, view2);
                    }
                }
            });
            AutoDegradeTagView autoDegradeTagView = this.c;
            if (autoDegradeTagView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headMainView");
                autoDegradeTagView = null;
            }
            autoDegradeTagView.setVisibility(0);
            AutoDegradeTagView autoDegradeTagView2 = this.c;
            if (autoDegradeTagView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headMainView");
                autoDegradeTagView2 = null;
            }
            autoDegradeTagView2.j(uiState.f().d());
            AutoDegradeTagView autoDegradeTagView3 = this.d;
            if (autoDegradeTagView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headExtendInfo");
                autoDegradeTagView3 = null;
            }
            autoDegradeTagView3.setVisibility(0);
            AutoDegradeTagView autoDegradeTagView4 = this.d;
            if (autoDegradeTagView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headExtendInfo");
                autoDegradeTagView4 = null;
            }
            autoDegradeTagView4.j(uiState.f().b());
            VirtualImageStatusTip virtualImageStatusTip = this.f;
            if (virtualImageStatusTip == null) {
                Intrinsics.throwUninitializedPropertyAccessException("virtualImageStatusTip");
                virtualImageStatusTip = null;
            }
            virtualImageStatusTip.setVisibility(8);
            if (uiState.f().f() != null) {
                this.g = true;
                VirtualImageStatusTip virtualImageStatusTip2 = this.f;
                if (virtualImageStatusTip2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("virtualImageStatusTip");
                    virtualImageStatusTip2 = null;
                }
                virtualImageStatusTip2.setVisibility(8);
                VirtualImageStatusTip virtualImageStatusTip3 = this.f;
                if (virtualImageStatusTip3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("virtualImageStatusTip");
                    virtualImageStatusTip3 = null;
                }
                virtualImageStatusTip3.setData(uiState.f().f(), true, "#7F66FE");
            } else {
                this.g = false;
            }
            final String k = uiState.k();
            if (k != null && k.length() != 0) {
                z = false;
            }
            if (!z) {
                VirtualImageStatusTip virtualImageStatusTip4 = this.f;
                if (virtualImageStatusTip4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("virtualImageStatusTip");
                    virtualImageStatusTip4 = null;
                }
                virtualImageStatusTip4.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u07
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            CardVirtualHeadView.B(h27.this, k, view2);
                        }
                    }
                });
            } else {
                k = null;
            }
            if (k == null) {
                VirtualImageStatusTip virtualImageStatusTip5 = this.f;
                if (virtualImageStatusTip5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("virtualImageStatusTip");
                    virtualImageStatusTip5 = null;
                }
                virtualImageStatusTip5.setOnClickListener(null);
                Unit unit = Unit.INSTANCE;
            }
            AutoDegradeTagView autoDegradeTagView5 = this.c;
            if (autoDegradeTagView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headMainView");
                autoDegradeTagView5 = null;
            }
            autoDegradeTagView5.setOnTagClickListener(new a(uiState));
            AutoDegradeTagView autoDegradeTagView6 = this.d;
            if (autoDegradeTagView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headExtendInfo");
                autoDegradeTagView6 = null;
            }
            autoDegradeTagView6.setOnTagClickListener(new b(uiState));
            if (uiState.e() == null) {
                ImageView imageView2 = this.e;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
                    imageView2 = null;
                }
                imageView2.setVisibility(8);
                ImageView imageView3 = this.e;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
                    imageView3 = null;
                }
                imageView3.setOnClickListener(null);
            } else {
                ImageView imageView4 = this.e;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
                    imageView4 = null;
                }
                imageView4.setVisibility(0);
                ImageView imageView5 = this.e;
                if (imageView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedBackBtn");
                } else {
                    imageView = imageView5;
                }
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.z07
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            CardVirtualHeadView.C(h27.this, view2);
                        }
                    }
                });
            }
            b();
            post(new Runnable() { // from class: com.baidu.tieba.k17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        CardVirtualHeadView.D(CardVirtualHeadView.this);
                    }
                }
            });
        }
    }
}
