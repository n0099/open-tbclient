package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes3.dex */
public abstract class ai4<E> extends yh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public final Context b;
    public final Handler c;
    public final int d;
    public final ci4 e;
    public ri4<String, fi4> f;
    public gi4 g;
    public boolean h;
    public boolean i;

    @Override // com.baidu.tieba.yh4
    @Nullable
    public View a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return null;
        }
        return (View) invokeI.objValue;
    }

    @Override // com.baidu.tieba.yh4
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void k(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, fragment) == null) {
        }
    }

    public void l(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048589, this, str, fileDescriptor, printWriter, strArr) == null) {
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void p(@NonNull Fragment fragment, @NonNull String[] strArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048593, this, fragment, strArr, i) == null) {
        }
    }

    public boolean q(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, fragment)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    public ai4(Activity activity, Context context, Handler handler, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, context, handler, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new ci4();
        this.a = activity;
        this.b = context;
        this.c = handler;
        this.d = i;
    }

    public void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, str, fileDescriptor, printWriter, strArr) == null) {
            printWriter.print(str);
            printWriter.print("mLoadersStarted=");
            printWriter.println(this.i);
            if (this.g != null) {
                printWriter.print(str);
                printWriter.print("Loader Manager ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this.g)));
                printWriter.println(":");
                gi4 gi4Var = this.g;
                gi4Var.h(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ai4(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.a, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Activity) objArr2[0], (Context) objArr2[1], (Handler) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void c() {
        gi4 gi4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (gi4Var = this.g) == null) {
            return;
        }
        gi4Var.b();
    }

    public ci4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (ci4) invokeV.objValue;
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a;
        }
        return (Activity) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b;
        }
        return (Context) invokeV.objValue;
    }

    public Handler h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.c;
        }
        return (Handler) invokeV.objValue;
    }

    public LayoutInflater m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return (LayoutInflater) this.b.getSystemService("layout_inflater");
        }
        return (LayoutInflater) invokeV.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.i) {
            return;
        }
        this.i = true;
        gi4 gi4Var = this.g;
        if (gi4Var != null) {
            gi4Var.f();
        } else if (!this.h) {
            gi4 i = i("(root)", true, false);
            this.g = i;
            if (i != null && !i.d) {
                i.f();
            }
        }
        this.h = true;
    }

    public void t() {
        ri4<String, fi4> ri4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (ri4Var = this.f) != null) {
            int size = ri4Var.size();
            gi4[] gi4VarArr = new gi4[size];
            for (int i = size - 1; i >= 0; i--) {
                gi4VarArr[i] = (gi4) this.f.k(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                gi4 gi4Var = gi4VarArr[i2];
                gi4Var.i();
                gi4Var.d();
            }
        }
    }

    public void e(boolean z) {
        gi4 gi4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048580, this, z) != null) || (gi4Var = this.g) == null || !this.i) {
            return;
        }
        this.i = false;
        if (z) {
            gi4Var.e();
        } else {
            gi4Var.g();
        }
    }

    public void j(String str) {
        ri4<String, fi4> ri4Var;
        gi4 gi4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && (ri4Var = this.f) != null && (gi4Var = (gi4) ri4Var.get(str)) != null && !gi4Var.e) {
            gi4Var.b();
            this.f.remove(str);
        }
    }

    public void u(ri4<String, fi4> ri4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, ri4Var) == null) {
            this.f = ri4Var;
        }
    }

    public gi4 i(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (this.f == null) {
                this.f = new ri4<>();
            }
            gi4 gi4Var = (gi4) this.f.get(str);
            if (gi4Var == null) {
                if (z2) {
                    gi4 gi4Var2 = new gi4(str, this, z);
                    this.f.put(str, gi4Var2);
                    return gi4Var2;
                }
                return gi4Var;
            }
            gi4Var.k(this);
            return gi4Var;
        }
        return (gi4) invokeCommon.objValue;
    }

    public void r(Fragment fragment, Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048595, this, fragment, intent, i) == null) {
            if (i == -1) {
                this.b.startActivity(intent);
                return;
            }
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
    }

    public ri4<String, fi4> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            ri4<String, fi4> ri4Var = this.f;
            int i = 0;
            if (ri4Var != null) {
                int size = ri4Var.size();
                gi4[] gi4VarArr = new gi4[size];
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    gi4VarArr[i2] = (gi4) this.f.k(i2);
                }
                int i3 = 0;
                while (i < size) {
                    gi4 gi4Var = gi4VarArr[i];
                    if (gi4Var.e) {
                        i3 = 1;
                    } else {
                        gi4Var.b();
                        this.f.remove(gi4Var.c);
                    }
                    i++;
                }
                i = i3;
            }
            if (i != 0) {
                return this.f;
            }
            return null;
        }
        return (ri4) invokeV.objValue;
    }
}
