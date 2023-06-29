package com.baidu.tieba.easteregg.view;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.edgefloat.EdgeFloat;
import com.baidu.tieba.edgefloat.EdgeFloatLifecycle;
import com.baidu.tieba.jz9;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001#BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005J\u0006\u0010\"\u001a\u00020\u001eR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u001b¨\u0006$"}, d2 = {"Lcom/baidu/tieba/easteregg/view/EasterEggAdEdgeFloat;", "", "activity", "Landroid/app/Activity;", NotificationCompat.WearableExtender.KEY_GRAVITY, "", "startX", "startY", "canDrag", "", "pageSupportList", "", "", "view", "Landroid/view/View;", "onScreenSizeChangedCallback", "Lcom/baidu/tieba/edgefloat/EdgeFloat$OnScreenSizeChangedCallback;", "(Landroid/app/Activity;IIIZLjava/util/List;Landroid/view/View;Lcom/baidu/tieba/edgefloat/EdgeFloat$OnScreenSizeChangedCallback;)V", "adViewContainer", "Landroid/widget/FrameLayout;", "getAdViewContainer", "()Landroid/widget/FrameLayout;", "adViewContainer$delegate", "Lkotlin/Lazy;", "edgeFloat", "Lcom/baidu/tieba/edgefloat/EdgeFloat;", "getEdgeFloat", "()Lcom/baidu/tieba/edgefloat/EdgeFloat;", "edgeFloat$delegate", "hide", "", "resetContentViewSize", "width", "height", "show", "Companion", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EasterEggAdEdgeFloat {
    public static /* synthetic */ Interceptable $ic;
    public static final a c;
    public static int d;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;
    public final Lazy b;

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return EasterEggAdEdgeFloat.d;
            }
            return invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(823828178, "Lcom/baidu/tieba/easteregg/view/EasterEggAdEdgeFloat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(823828178, "Lcom/baidu/tieba/easteregg/view/EasterEggAdEdgeFloat;");
                return;
            }
        }
        c = new a(null);
        d = UtilHelper.getDimenPixelSize(R.dimen.tbds340);
    }

    public final FrameLayout c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (FrameLayout) this.a.getValue();
        }
        return (FrameLayout) invokeV.objValue;
    }

    public final EdgeFloat d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (EdgeFloat) this.b.getValue();
        }
        return (EdgeFloat) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d().k();
            EdgeFloatLifecycle.b.a().l(d());
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d().D();
        }
    }

    public EasterEggAdEdgeFloat(final Activity activity, final int i, final int i2, final int i3, final boolean z, final List<String> pageSupportList, final View view2, final EdgeFloat.b onScreenSizeChangedCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), pageSupportList, view2, onScreenSizeChangedCallback};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(pageSupportList, "pageSupportList");
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(onScreenSizeChangedCallback, "onScreenSizeChangedCallback");
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>(activity) { // from class: com.baidu.tieba.easteregg.view.EasterEggAdEdgeFloat$adViewContainer$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ Activity $activity;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {activity};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i6 = newInitContext2.flag;
                    if ((i6 & 1) != 0) {
                        int i7 = i6 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.$activity = activity;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new FrameLayout(this.$activity);
                }
                return (FrameLayout) invokeV.objValue;
            }
        });
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<EdgeFloat>(this, view2, activity, i, i2, i3, z, pageSupportList, onScreenSizeChangedCallback) { // from class: com.baidu.tieba.easteregg.view.EasterEggAdEdgeFloat$edgeFloat$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ Activity $activity;
            public final /* synthetic */ boolean $canDrag;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int $gravity;
            public final /* synthetic */ EdgeFloat.b $onScreenSizeChangedCallback;
            public final /* synthetic */ List<String> $pageSupportList;
            public final /* synthetic */ int $startX;
            public final /* synthetic */ int $startY;
            public final /* synthetic */ View $view;
            public final /* synthetic */ EasterEggAdEdgeFloat this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, view2, activity, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), pageSupportList, onScreenSizeChangedCallback};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i6 = newInitContext2.flag;
                    if ((i6 & 1) != 0) {
                        int i7 = i6 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
                this.$view = view2;
                this.$activity = activity;
                this.$gravity = i;
                this.$startX = i2;
                this.$startY = i3;
                this.$canDrag = z;
                this.$pageSupportList = pageSupportList;
                this.$onScreenSizeChangedCallback = onScreenSizeChangedCallback;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EdgeFloat invoke() {
                InterceptResult invokeV;
                FrameLayout c2;
                FrameLayout c3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (EdgeFloat) invokeV.objValue;
                }
                c2 = this.this$0.c();
                c2.addView(this.$view);
                jz9 jz9Var = new jz9(this.$activity);
                c3 = this.this$0.c();
                jz9Var.M(c3);
                jz9Var.y(this.$gravity);
                jz9Var.I(this.$startX);
                jz9Var.J(this.$startY);
                jz9Var.d(this.$canDrag);
                jz9Var.N(xi.l(TbadkCoreApplication.getInst()));
                jz9Var.z(EasterEggAdEdgeFloat.c.a());
                jz9Var.D(this.$pageSupportList);
                jz9Var.H(false);
                jz9Var.G(this.$onScreenSizeChangedCallback);
                return jz9Var.c();
            }
        });
    }

    public final void f(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            d().C(i, i2);
        }
    }
}
