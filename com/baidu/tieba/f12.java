package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.tieba.g12;
import com.baidu.tieba.h6c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class f12<V extends View, M extends g12> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public f22 a;
    @Nullable
    public V b;
    @NonNull
    public M c;
    @Nullable
    public M d;
    @Nullable
    public SwanAppComponentContainerView e;
    @Nullable
    public n6c f;
    public int g;

    public void B(@NonNull V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v) == null) {
        }
    }

    @NonNull
    public abstract V v(@NonNull Context context);

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends n6c<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String e;
        public final /* synthetic */ f12 f;

        public a(f12 f12Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f12Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = f12Var;
            this.e = str;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidu.tieba.f12 */
        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: com.baidu.tieba.f12 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tieba.i6c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f12 f12Var = this.f;
                f12Var.b = f12Var.v(f12Var.a.b());
                f12 f12Var2 = this.f;
                f12Var2.B(f12Var2.b);
                this.f.e.setTargetView(this.f.b, 0);
                f12 f12Var3 = this.f;
                f12Var3.D(f12Var3.b, this.f.c, new h22(true));
                if (f12.h) {
                    Log.d("Component-Base", this.e + " insert delayed（view）: success");
                }
            }
        }

        @Override // com.baidu.tieba.i6c
        @SuppressLint({"BDThrowableCheck"})
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                p22.o("Component-Base", this.e + " insert delayed（view）: fail");
                if (f12.h && th != null && TextUtils.equals(th.getMessage(), "save subscriber and return subscriber: nolinear !")) {
                    throw new RuntimeException("save subscriber and return subscriber: nolinear !");
                }
                this.f.C();
            }
        }

        @Override // com.baidu.tieba.i6c
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                p22.o("Component-Base", this.e + " success should call onCompleted");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements h6c.a<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ f12 b;

        public b(f12 f12Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f12Var, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f12Var;
            this.a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v6c
        /* renamed from: a */
        public void call(n6c<? super Object> n6cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, n6cVar) == null) {
                if (f12.h) {
                    Log.d("Component-Base", "insert delayed => save thread: " + Thread.currentThread().getName());
                }
                if (this.a != Thread.currentThread().getId()) {
                    i22.a("Component-Base", "save subscriber and return subscriber: nolinear !");
                }
                this.b.f = n6cVar;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends vk3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(f12 f12Var, String str, String str2, String str3, boolean z) {
            super(str, str2, str3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f12Var, str, str2, str3, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = z;
        }

        @Override // com.baidu.tieba.vk3, android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.j && super.onTouch(view2, motionEvent)) {
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947711202, "Lcom/baidu/tieba/f12;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947711202, "Lcom/baidu/tieba/f12;");
                return;
            }
        }
        h = am1.a;
    }

    @CallSuper
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            F();
        }
    }

    public final void F() {
        n6c n6cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (n6cVar = this.f) != null && !n6cVar.isUnsubscribed()) {
            this.f.unsubscribe();
        }
    }

    @NonNull
    public final M l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return j(this.c);
        }
        return (M) invokeV.objValue;
    }

    @Nullable
    public final SwanAppComponentContainerView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.e;
        }
        return (SwanAppComponentContainerView) invokeV.objValue;
    }

    @NonNull
    public final M n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.c;
        }
        return (M) invokeV.objValue;
    }

    @Nullable
    public final M p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.d;
        }
        return (M) invokeV.objValue;
    }

    @Nullable
    public final V q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.b;
        }
        return (V) invokeV.objValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.d != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @CallSuper
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (h) {
                Log.d("Component-Base", o() + " onDestroy");
            }
            F();
        }
    }

    public f12(@Nullable Context context, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, m};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        M j = j(m);
        this.c = j;
        f22 c2 = c22.c(j);
        this.a = c2;
        if (c2 == null) {
            p22.c("Component-Base", o() + " context is null !");
        } else if (context != null) {
            c2.d(context);
        }
    }

    @NonNull
    public final f12 g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            this.g = i | this.g;
            return this;
        }
        return (f12) invokeI.objValue;
    }

    public final boolean h(@NonNull f22 f22Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, f22Var)) == null) {
            boolean b2 = f22Var.a().b(this);
            y(b2);
            return b2;
        }
        return invokeL.booleanValue;
    }

    public final boolean s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            if ((this.g & i) == i) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, context)) == null) {
            return new SwanAppComponentContainerView(context);
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void r(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, swanAppComponentContainerView, m) == null) {
            swanAppComponentContainerView.setOnTouchListener(new c(this, m.c, m.b, m.a, m.g));
        }
    }

    @NonNull
    @UiThread
    public final h12 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String o = o();
            if (h) {
                Log.i("Component-Base", "=====================" + o + " start remove=====================");
            }
            f22 f22Var = this.a;
            if (f22Var == null) {
                i22.a("Component-Base", o + " remove with a null component context!");
                return new h12(202, "component context is null");
            } else if (this.e == null) {
                p22.c("Component-Base", o + " remove must after insert");
                return new h12(202, "component remove must after insert");
            } else if (!f22Var.a().e(this)) {
                String str = o + " remove fail";
                p22.c("Component-Base", str);
                return new h12(1001, str);
            } else {
                A();
                if (h) {
                    Log.d("Component-Base", o + " remove: success");
                }
                return new h12(0, "success");
            }
        }
        return (h12) invokeV.objValue;
    }

    @CallSuper
    public void D(@NonNull V v, @NonNull M m, @NonNull h22 h22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, v, m, h22Var) == null) {
            E(m, h22Var);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void E(@NonNull M m, @NonNull h22 h22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, m, h22Var) == null) {
            if (this.e == null) {
                i22.a("Component-Base", "renderContainerView with a null container view");
                return;
            }
            if (h22Var.a(1)) {
                this.e.setHidden(m.f);
            }
            if (h22Var.a(2)) {
                r(this.e, m);
            }
        }
    }

    @NonNull
    @CallSuper
    public h22 k(@NonNull M m, @NonNull M m2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, m, m2)) == null) {
            h22 h22Var = new h22();
            vv2 vv2Var = m2.h;
            if (vv2Var != null && vv2Var.b(m.h)) {
                h22Var.b(3);
            }
            if (m.f != m2.f) {
                h22Var.b(1);
            }
            if (m.g != m2.g) {
                h22Var.b(2);
            }
            return h22Var;
        }
        return (h22) invokeLL.objValue;
    }

    @NonNull
    @UiThread
    public final h12 G(@NonNull M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, m)) == null) {
            String o = o();
            h12 i = i(m);
            if (!i.a()) {
                p22.c("Component-Base", o + " update with a invalid model => " + i.b);
                return i;
            }
            if (h) {
                Log.i("Component-Base", "=====================" + o + " start update=====================");
            }
            M m2 = this.c;
            if (m2 == m) {
                String str = o + " update with the same model";
                i22.a("Component-Base", str);
                return new h12(202, str);
            } else if (!TextUtils.equals(m2.b, m.b)) {
                String str2 = o + " update with different id: " + this.c.b + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.b;
                i22.a("Component-Base", str2);
                return new h12(202, str2);
            } else if (!TextUtils.equals(this.c.c, m.c)) {
                String str3 = o + " update with different slave id: " + this.c.c + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.c;
                i22.a("Component-Base", str3);
                return new h12(202, str3);
            } else if (this.b != null && this.e != null) {
                if (this.a == null) {
                    i22.a("Component-Base", o + " update with a null component context!");
                    return new h12(202, "component context is null");
                }
                M m3 = this.c;
                this.d = m3;
                h22 k = k(m3, m);
                M j = j(m);
                this.c = j;
                D(this.b, j, k);
                boolean f = this.a.a().f(this, k);
                this.d = null;
                if (!f) {
                    String str4 = o + " update component fail";
                    p22.c("Component-Base", str4);
                    return new h12(1001, str4);
                }
                if (h) {
                    Log.d("Component-Base", o + " component update: success");
                }
                return new h12(0, "success");
            } else {
                String str5 = o + " update must after insert succeeded";
                i22.a("Component-Base", str5);
                return new h12(202, str5);
            }
        }
        return (h12) invokeL.objValue;
    }

    @NonNull
    public final h12 i(M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, m)) == null) {
            if (m == null) {
                return new h12(202, "model is null");
            }
            if (TextUtils.isEmpty(m.c)) {
                return new h12(202, "slave id is empty");
            }
            if (!m.isValid()) {
                return new h12(202, "model is invalid");
            }
            return new h12(0, "model is valid");
        }
        return (h12) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final M j(@NonNull M m) {
        InterceptResult invokeL;
        g12 g12Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, m)) == null) {
            try {
                g12Var = (g12) m.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                i22.b("Component-Base", "model must implement cloneable", e);
                g12Var = null;
                if (g12Var == null) {
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                i22.b("Component-Base", "clone model fail ！", e2);
                g12Var = null;
                if (g12Var == null) {
                }
            }
            if (g12Var == null) {
                i22.a("Component-Base", "clone model fail ！");
                return m;
            }
            return (M) g12Var;
        }
        return (M) invokeL.objValue;
    }

    @NonNull
    public final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            h12 i = i(this.c);
            if (i.a()) {
                return this.c.d();
            }
            return "【illegal component#" + i.b + "】";
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    @UiThread
    public final h12 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            String o = o();
            h12 i = i(this.c);
            if (!i.a()) {
                p22.c("Component-Base", o + " insert with a invalid model => " + i.b);
                return i;
            }
            if (h) {
                Log.i("Component-Base", "=====================" + o + " start insert=====================");
            }
            f22 f22Var = this.a;
            if (f22Var == null) {
                p22.c("Component-Base", o + " insert with a null component context!");
                return new h12(202, "component context is null");
            }
            Context b2 = f22Var.b();
            if (this.e != null || this.b != null) {
                p22.o("Component-Base", o + " repeat insert");
            }
            V v = v(this.a.b());
            this.b = v;
            B(v);
            SwanAppComponentContainerView u = u(b2);
            this.e = u;
            u.setTargetView(this.b);
            D(this.b, this.c, new h22(true));
            if (h(this.a)) {
                if (h) {
                    Log.d("Component-Base", o + " insert: success");
                }
                return new h12(0, "success");
            }
            p22.c("Component-Base", o + " insert: attach fail");
            return new h12(1001, "attach fail");
        }
        return (h12) invokeV.objValue;
    }

    @Nullable
    @UiThread
    public final n6c x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            String o = o();
            h12 i = i(this.c);
            if (!i.a()) {
                p22.c("Component-Base", o + " insert delayed with a invalid model => " + i.b);
                return null;
            }
            if (h) {
                Log.i("Component-Base", "=====================" + o + " start insertDelayed=====================");
            }
            if (this.a == null) {
                i22.a("Component-Base", o + " insert delayed with a null component context!");
                return null;
            }
            if (this.e != null) {
                p22.o("Component-Base", o + " repeat insert delayed: container view repeat");
            }
            n6c n6cVar = this.f;
            if (n6cVar != null && !n6cVar.isUnsubscribed()) {
                this.f.unsubscribe();
                this.f = null;
                p22.o("Component-Base", o + " insert delayed repeat: subscriber repeat");
            }
            this.e = u(this.a.b());
            E(this.c, new h22(true));
            if (h(this.a)) {
                if (h) {
                    Log.d("Component-Base", o + " insert delayed（container view）: success");
                }
                h6c.d(new b(this, Thread.currentThread().getId())).F(new a(this, o));
                return this.f;
            }
            p22.c("Component-Base", o + " insert delayed: attach fail");
            return null;
        }
        return (n6c) invokeV.objValue;
    }
}
