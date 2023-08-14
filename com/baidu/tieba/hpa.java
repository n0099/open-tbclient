package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.OneShotPreDrawListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.view.MaskContainer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class hpa {
    public static /* synthetic */ Interceptable $ic;
    public static final a i;
    public transient /* synthetic */ FieldHolder $fh;
    public final ViewGroup a;
    public final MaskContainer b;
    public final List<jpa> c;
    public boolean d;
    public int e;
    public Function2<? super hpa, ? super Integer, Unit> f;
    public Function0<Unit> g;
    public Function2<? super hpa, ? super Integer, Unit> h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947832784, "Lcom/baidu/tieba/hpa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947832784, "Lcom/baidu/tieba/hpa;");
                return;
            }
        }
        i = new a(null);
    }

    public /* synthetic */ hpa(Activity activity, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity);
    }

    /* loaded from: classes6.dex */
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

        @JvmStatic
        public final hpa a(Activity activity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, activity)) == null) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                return new hpa(activity, null);
            }
            return (hpa) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ hpa b;

        public b(View view2, hpa hpaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, hpaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = hpaVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b.d) {
                return;
            }
            this.b.d = true;
            this.b.i();
        }
    }

    public hpa(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new ArrayList();
        this.e = -1;
        this.a = (ViewGroup) activity.getWindow().getDecorView();
        MaskContainer maskContainer = new MaskContainer(activity, null, 2, null);
        this.b = maskContainer;
        maskContainer.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.dpa
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    hpa.a(hpa.this, view2);
                }
            }
        });
    }

    public static final void a(hpa this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Function2<? super hpa, ? super Integer, Unit> function2 = this$0.h;
            if (function2 != null) {
                function2.invoke(this$0, Integer.valueOf(this$0.e));
            }
            this$0.j();
        }
    }

    public final hpa d(Function0<jpa> block) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, block)) == null) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.c.add(block.invoke());
            return this;
        }
        return (hpa) invokeL.objValue;
    }

    public final hpa f(Function2<? super hpa, ? super Integer, Unit> clickCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, clickCallback)) == null) {
            Intrinsics.checkNotNullParameter(clickCallback, "clickCallback");
            this.h = clickCallback;
            return this;
        }
        return (hpa) invokeL.objValue;
    }

    public final hpa g(Function0<Unit> dismissCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, dismissCallback)) == null) {
            Intrinsics.checkNotNullParameter(dismissCallback, "dismissCallback");
            this.g = dismissCallback;
            return this;
        }
        return (hpa) invokeL.objValue;
    }

    public final hpa h(Function2<? super hpa, ? super Integer, Unit> function2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, function2)) == null) {
            this.f = function2;
            return this;
        }
        return (hpa) invokeL.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.removeView(this.b);
            this.b.removeAllViews();
            this.d = false;
            this.e = -1;
            Function0<Unit> function0 = this.g;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public final hpa i() {
        InterceptResult invokeV;
        boolean d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d = ipa.d(this.a);
            if (d) {
                if (this.b.getParent() == null) {
                    this.a.addView(this.b, new ViewGroup.LayoutParams(-1, -1));
                    j();
                }
            } else {
                ViewGroup viewGroup = this.a;
                Intrinsics.checkExpressionValueIsNotNull(OneShotPreDrawListener.add(viewGroup, new b(viewGroup, this)), "OneShotPreDrawListener.add(this) { action(this) }");
            }
            return this;
        }
        return (hpa) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.c.isEmpty()) {
                e();
                return;
            }
            this.b.a(this.a, this.c.remove(0));
            int i2 = this.e + 1;
            this.e = i2;
            Function2<? super hpa, ? super Integer, Unit> function2 = this.f;
            if (function2 != null) {
                function2.invoke(this, Integer.valueOf(i2));
            }
        }
    }
}
