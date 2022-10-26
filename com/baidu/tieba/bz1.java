package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.tieba.xx9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class bz1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public c02 a;
    public View b;
    public cz1 c;
    public cz1 d;
    public SwanAppComponentContainerView e;
    public dy9 f;
    public int g;

    public void A(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
        }
    }

    public abstract View v(Context context);

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a extends dy9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String e;
        public final /* synthetic */ bz1 f;

        public a(bz1 bz1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bz1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = bz1Var;
            this.e = str;
        }

        @Override // com.baidu.tieba.yx9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                bz1 bz1Var = this.f;
                bz1Var.b = bz1Var.v(bz1Var.a.getContext());
                bz1 bz1Var2 = this.f;
                bz1Var2.A(bz1Var2.b);
                this.f.e.setTargetView(this.f.b, 0);
                bz1 bz1Var3 = this.f;
                bz1Var3.C(bz1Var3.b, this.f.c, new e02(true));
                if (bz1.h) {
                    Log.d("Component-Base", this.e + " insert delayed（view）: success");
                }
            }
        }

        @Override // com.baidu.tieba.yx9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                m02.o("Component-Base", this.e + " insert delayed（view）: fail");
                if (bz1.h && th != null && TextUtils.equals(th.getMessage(), "save subscriber and return subscriber: nolinear !")) {
                    throw new RuntimeException("save subscriber and return subscriber: nolinear !");
                }
                this.f.B();
            }
        }

        @Override // com.baidu.tieba.yx9
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                m02.o("Component-Base", this.e + " success should call onCompleted");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements xx9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ bz1 b;

        public b(bz1 bz1Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bz1Var, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bz1Var;
            this.a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xx9.a, com.baidu.tieba.ly9
        public void call(dy9 dy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dy9Var) == null) {
                if (bz1.h) {
                    Log.d("Component-Base", "insert delayed => save thread: " + Thread.currentThread().getName());
                }
                if (this.a != Thread.currentThread().getId()) {
                    f02.a("Component-Base", "save subscriber and return subscriber: nolinear !");
                }
                this.b.f = dy9Var;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends si3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(bz1 bz1Var, String str, String str2, String str3, boolean z) {
            super(str, str2, str3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bz1Var, str, str2, str3, Boolean.valueOf(z)};
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

        @Override // com.baidu.tieba.si3, android.view.View.OnTouchListener
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947662160, "Lcom/baidu/tieba/bz1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947662160, "Lcom/baidu/tieba/bz1;");
                return;
            }
        }
        h = wj1.a;
    }

    public final void E() {
        dy9 dy9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (dy9Var = this.f) != null && !dy9Var.isUnsubscribed()) {
            this.f.unsubscribe();
        }
    }

    public final cz1 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return j(this.c);
        }
        return (cz1) invokeV.objValue;
    }

    public final SwanAppComponentContainerView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.e;
        }
        return (SwanAppComponentContainerView) invokeV.objValue;
    }

    public final cz1 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.c;
        }
        return (cz1) invokeV.objValue;
    }

    public final cz1 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.d;
        }
        return (cz1) invokeV.objValue;
    }

    public final View q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.d != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (h) {
                Log.d("Component-Base", o() + " onDestroy");
            }
            E();
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            E();
        }
    }

    public bz1(Context context, cz1 cz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cz1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        cz1 j = j(cz1Var);
        this.c = j;
        c02 c2 = zz1.c(j);
        this.a = c2;
        if (c2 == null) {
            m02.c("Component-Base", o() + " context is null !");
        } else if (context != null) {
            c2.c(context);
        }
    }

    public final bz1 g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            this.g = i | this.g;
            return this;
        }
        return (bz1) invokeI.objValue;
    }

    public final boolean h(c02 c02Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, c02Var)) == null) {
            boolean b2 = c02Var.a().b(this);
            x(b2);
            return b2;
        }
        return invokeL.booleanValue;
    }

    public final boolean s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            if ((this.g & i) == i) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public SwanAppComponentContainerView u(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, context)) == null) {
            return new SwanAppComponentContainerView(context);
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    public void r(SwanAppComponentContainerView swanAppComponentContainerView, cz1 cz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, swanAppComponentContainerView, cz1Var) == null) {
            swanAppComponentContainerView.setOnTouchListener(new c(this, cz1Var.c, cz1Var.b, cz1Var.a, cz1Var.g));
        }
    }

    public final dz1 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String o = o();
            if (h) {
                Log.i("Component-Base", "=====================" + o + " start remove=====================");
            }
            c02 c02Var = this.a;
            if (c02Var == null) {
                f02.a("Component-Base", o + " remove with a null component context!");
                return new dz1(202, "component context is null");
            } else if (this.e == null) {
                m02.c("Component-Base", o + " remove must after insert");
                return new dz1(202, "component remove must after insert");
            } else if (!c02Var.a().e(this)) {
                String str = o + " remove fail";
                m02.c("Component-Base", str);
                return new dz1(1001, str);
            } else {
                z();
                if (h) {
                    Log.d("Component-Base", o + " remove: success");
                }
                return new dz1(0, "success");
            }
        }
        return (dz1) invokeV.objValue;
    }

    public void C(View view2, cz1 cz1Var, e02 e02Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, view2, cz1Var, e02Var) == null) {
            D(cz1Var, e02Var);
        }
    }

    public final void D(cz1 cz1Var, e02 e02Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cz1Var, e02Var) == null) {
            if (this.e == null) {
                f02.a("Component-Base", "renderContainerView with a null container view");
                return;
            }
            if (e02Var.a(1)) {
                this.e.setHidden(cz1Var.f);
            }
            if (e02Var.a(2)) {
                r(this.e, cz1Var);
            }
        }
    }

    public e02 k(cz1 cz1Var, cz1 cz1Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, cz1Var, cz1Var2)) == null) {
            e02 e02Var = new e02();
            st2 st2Var = cz1Var2.h;
            if (st2Var != null && st2Var.b(cz1Var.h)) {
                e02Var.b(3);
            }
            if (cz1Var.f != cz1Var2.f) {
                e02Var.b(1);
            }
            if (cz1Var.g != cz1Var2.g) {
                e02Var.b(2);
            }
            return e02Var;
        }
        return (e02) invokeLL.objValue;
    }

    public final dz1 i(cz1 cz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cz1Var)) == null) {
            if (cz1Var == null) {
                return new dz1(202, "model is null");
            }
            if (TextUtils.isEmpty(cz1Var.c)) {
                return new dz1(202, "slave id is empty");
            }
            if (!cz1Var.isValid()) {
                return new dz1(202, "model is invalid");
            }
            return new dz1(0, "model is valid");
        }
        return (dz1) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final cz1 j(cz1 cz1Var) {
        InterceptResult invokeL;
        cz1 cz1Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, cz1Var)) == null) {
            try {
                cz1Var2 = (cz1) cz1Var.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                f02.b("Component-Base", "model must implement cloneable", e);
                cz1Var2 = null;
                if (cz1Var2 == null) {
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                f02.b("Component-Base", "clone model fail ！", e2);
                cz1Var2 = null;
                if (cz1Var2 == null) {
                }
            }
            if (cz1Var2 == null) {
                f02.a("Component-Base", "clone model fail ！");
                return cz1Var;
            }
            return cz1Var2;
        }
        return (cz1) invokeL.objValue;
    }

    public final dz1 insert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String o = o();
            dz1 i = i(this.c);
            if (!i.a()) {
                m02.c("Component-Base", o + " insert with a invalid model => " + i.b);
                return i;
            }
            if (h) {
                Log.i("Component-Base", "=====================" + o + " start insert=====================");
            }
            c02 c02Var = this.a;
            if (c02Var == null) {
                m02.c("Component-Base", o + " insert with a null component context!");
                return new dz1(202, "component context is null");
            }
            Context context = c02Var.getContext();
            if (this.e != null || this.b != null) {
                m02.o("Component-Base", o + " repeat insert");
            }
            View v = v(this.a.getContext());
            this.b = v;
            A(v);
            SwanAppComponentContainerView u = u(context);
            this.e = u;
            u.setTargetView(this.b);
            C(this.b, this.c, new e02(true));
            if (h(this.a)) {
                if (h) {
                    Log.d("Component-Base", o + " insert: success");
                }
                return new dz1(0, "success");
            }
            m02.c("Component-Base", o + " insert: attach fail");
            return new dz1(1001, "attach fail");
        }
        return (dz1) invokeV.objValue;
    }

    public final dy9 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            String o = o();
            dz1 i = i(this.c);
            if (!i.a()) {
                m02.c("Component-Base", o + " insert delayed with a invalid model => " + i.b);
                return null;
            }
            if (h) {
                Log.i("Component-Base", "=====================" + o + " start insertDelayed=====================");
            }
            if (this.a == null) {
                f02.a("Component-Base", o + " insert delayed with a null component context!");
                return null;
            }
            if (this.e != null) {
                m02.o("Component-Base", o + " repeat insert delayed: container view repeat");
            }
            dy9 dy9Var = this.f;
            if (dy9Var != null && !dy9Var.isUnsubscribed()) {
                this.f.unsubscribe();
                this.f = null;
                m02.o("Component-Base", o + " insert delayed repeat: subscriber repeat");
            }
            this.e = u(this.a.getContext());
            D(this.c, new e02(true));
            if (h(this.a)) {
                if (h) {
                    Log.d("Component-Base", o + " insert delayed（container view）: success");
                }
                xx9.a(new b(this, Thread.currentThread().getId())).u(new a(this, o));
                return this.f;
            }
            m02.c("Component-Base", o + " insert delayed: attach fail");
            return null;
        }
        return (dy9) invokeV.objValue;
    }

    public final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            dz1 i = i(this.c);
            if (i.a()) {
                return this.c.d();
            }
            return "【illegal component#" + i.b + "】";
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public final dz1 update(cz1 cz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, cz1Var)) == null) {
            String o = o();
            dz1 i = i(cz1Var);
            if (!i.a()) {
                m02.c("Component-Base", o + " update with a invalid model => " + i.b);
                return i;
            }
            if (h) {
                Log.i("Component-Base", "=====================" + o + " start update=====================");
            }
            cz1 cz1Var2 = this.c;
            if (cz1Var2 == cz1Var) {
                String str = o + " update with the same model";
                f02.a("Component-Base", str);
                return new dz1(202, str);
            } else if (!TextUtils.equals(cz1Var2.b, cz1Var.b)) {
                String str2 = o + " update with different id: " + this.c.b + StringUtil.ARRAY_ELEMENT_SEPARATOR + cz1Var.b;
                f02.a("Component-Base", str2);
                return new dz1(202, str2);
            } else if (!TextUtils.equals(this.c.c, cz1Var.c)) {
                String str3 = o + " update with different slave id: " + this.c.c + StringUtil.ARRAY_ELEMENT_SEPARATOR + cz1Var.c;
                f02.a("Component-Base", str3);
                return new dz1(202, str3);
            } else if (this.b != null && this.e != null) {
                if (this.a == null) {
                    f02.a("Component-Base", o + " update with a null component context!");
                    return new dz1(202, "component context is null");
                }
                cz1 cz1Var3 = this.c;
                this.d = cz1Var3;
                e02 k = k(cz1Var3, cz1Var);
                cz1 j = j(cz1Var);
                this.c = j;
                C(this.b, j, k);
                boolean f = this.a.a().f(this, k);
                this.d = null;
                if (!f) {
                    String str4 = o + " update component fail";
                    m02.c("Component-Base", str4);
                    return new dz1(1001, str4);
                }
                if (h) {
                    Log.d("Component-Base", o + " component update: success");
                }
                return new dz1(0, "success");
            } else {
                String str5 = o + " update must after insert succeeded";
                f02.a("Component-Base", str5);
                return new dz1(202, str5);
            }
        }
        return (dz1) invokeL.objValue;
    }
}
