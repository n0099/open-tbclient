package com.baidu.tieba.edgefloat;

import android.app.Activity;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eJ\u0016\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eJ\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0011J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\bJ\u000e\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0005R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/baidu/tieba/edgefloat/EdgeFloatLifecycle;", "", "()V", "floatList", "Ljava/util/ArrayList;", "Lcom/baidu/tieba/edgefloat/EdgeFloat;", "Lkotlin/collections/ArrayList;", "dispatchTouchEvent", "", Config.EVENT_PART, "Landroid/view/MotionEvent;", "onBackPressed", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "", "onKeyboardVisibilityChanged", "isVisible", "", "keyboardHeight", "onScreenSizeChanged", "screenWidth", "screenHeight", "onWindowFocusChanged", "hasFocus", MiPushClient.COMMAND_REGISTER, "edgeFloat", "release", "switchActivity", "activity", "Landroid/app/Activity;", "unRegister", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EdgeFloatLifecycle {
    public static /* synthetic */ Interceptable $ic;
    public static final a b;
    public static final Lazy<EdgeFloatLifecycle> c;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<EdgeFloat> a;

    public static final EdgeFloatLifecycle c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a() : (EdgeFloatLifecycle) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
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

        public final EdgeFloatLifecycle a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return (EdgeFloatLifecycle) EdgeFloatLifecycle.c.getValue();
            }
            return (EdgeFloatLifecycle) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1712532590, "Lcom/baidu/tieba/edgefloat/EdgeFloatLifecycle;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1712532590, "Lcom/baidu/tieba/edgefloat/EdgeFloatLifecycle;");
                return;
            }
        }
        b = new a(null);
        c = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) EdgeFloatLifecycle$Companion$instance$2.INSTANCE);
    }

    public EdgeFloatLifecycle() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (EdgeFloat edgeFloat : this.a) {
                edgeFloat.v();
            }
        }
    }

    public final void b(MotionEvent ev) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ev) == null) {
            Intrinsics.checkNotNullParameter(ev, "ev");
            for (EdgeFloat edgeFloat : this.a) {
                edgeFloat.g(ev);
            }
        }
    }

    public final void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            for (EdgeFloat edgeFloat : this.a) {
                edgeFloat.onChangeSkinType(i);
            }
        }
    }

    public final void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            for (EdgeFloat edgeFloat : this.a) {
                edgeFloat.z(z);
            }
        }
    }

    public final void i(EdgeFloat edgeFloat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, edgeFloat) == null) {
            Intrinsics.checkNotNullParameter(edgeFloat, "edgeFloat");
            if (this.a.contains(edgeFloat)) {
                return;
            }
            this.a.add(edgeFloat);
        }
    }

    public final void k(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            for (EdgeFloat edgeFloat : this.a) {
                edgeFloat.D(activity);
            }
        }
    }

    public final boolean l(EdgeFloat edgeFloat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, edgeFloat)) == null) {
            Intrinsics.checkNotNullParameter(edgeFloat, "edgeFloat");
            if (!this.a.contains(edgeFloat)) {
                return false;
            }
            return this.a.remove(edgeFloat);
        }
        return invokeL.booleanValue;
    }

    public final void f(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            for (EdgeFloat edgeFloat : this.a) {
                edgeFloat.w(z, i);
            }
        }
    }

    public final void g(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            for (EdgeFloat edgeFloat : this.a) {
                edgeFloat.x(i, i2);
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Iterator<EdgeFloat> it = this.a.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "floatList.iterator()");
            while (it.hasNext()) {
                EdgeFloat next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                next.A();
                it.remove();
            }
        }
    }
}
