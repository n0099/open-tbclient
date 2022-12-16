package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ei4;
import com.baidu.tieba.ki4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.bumptech.glide.load.engine.GlideException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* loaded from: classes4.dex */
public class fi4 extends ei4 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final ri4<a> a;
    public final ri4<a> b;
    public final String c;
    public boolean d;
    public boolean e;
    public zh4 f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947765080, "Lcom/baidu/tieba/fi4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947765080, "Lcom/baidu/tieba/fi4;");
        }
    }

    /* loaded from: classes4.dex */
    public final class a implements ki4.b<Object>, ki4.a<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final Bundle b;
        public ei4.a<Object> c;
        public ki4<Object> d;
        public boolean e;
        public boolean f;
        public Object g;
        public boolean h;
        public boolean i;
        public boolean j;
        public boolean k;
        public boolean l;
        public boolean m;
        public a n;
        public final /* synthetic */ fi4 o;

        public void a(ki4<Object> ki4Var, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, ki4Var, obj) == null) && this.c != null) {
                String str = null;
                if (this.o.f != null) {
                    str = this.o.f.e.s;
                    this.o.f.e.s = "onLoadFinished";
                }
                try {
                    if (fi4.g) {
                        Log.v("LoaderManager", "  onLoadFinished in " + ki4Var + ": " + ki4Var.a(obj));
                    }
                    this.c.b(ki4Var, obj);
                    this.f = true;
                } finally {
                    if (this.o.f != null) {
                        this.o.f.e.s = str;
                    }
                }
            }
        }

        public void b() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (fi4.g) {
                    Log.v("LoaderManager", "  Destroying: " + this);
                }
                this.l = true;
                boolean z = this.f;
                this.f = false;
                if (this.c != null && this.d != null && this.e && z) {
                    if (fi4.g) {
                        Log.v("LoaderManager", "  Reseting: " + this);
                    }
                    if (this.o.f != null) {
                        str = this.o.f.e.s;
                        this.o.f.e.s = "onLoaderReset";
                    } else {
                        str = null;
                    }
                    try {
                        this.c.a(this.d);
                    } finally {
                        if (this.o.f != null) {
                            this.o.f.e.s = str;
                        }
                    }
                }
                this.c = null;
                this.g = null;
                this.e = false;
                ki4<Object> ki4Var = this.d;
                if (ki4Var != null) {
                    if (this.m) {
                        this.m = false;
                        ki4Var.k(this);
                        this.d.l(this);
                    }
                    this.d.h();
                }
                a aVar = this.n;
                if (aVar != null) {
                    aVar.b();
                }
            }
        }

        public void c(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, fileDescriptor, printWriter, strArr) == null) {
                printWriter.print(str);
                printWriter.print("mId=");
                printWriter.print(this.a);
                printWriter.print(" mArgs=");
                printWriter.println(this.b);
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.c);
                printWriter.print(str);
                printWriter.print("mLoader=");
                printWriter.println(this.d);
                ki4<Object> ki4Var = this.d;
                if (ki4Var != null) {
                    ki4Var.b(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
                }
                if (this.e || this.f) {
                    printWriter.print(str);
                    printWriter.print("mHaveData=");
                    printWriter.print(this.e);
                    printWriter.print("  mDeliveredData=");
                    printWriter.println(this.f);
                    printWriter.print(str);
                    printWriter.print("mData=");
                    printWriter.println(this.g);
                }
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.print(this.h);
                printWriter.print(" mReportNextStart=");
                printWriter.print(this.k);
                printWriter.print(" mDestroyed=");
                printWriter.println(this.l);
                printWriter.print(str);
                printWriter.print("mRetaining=");
                printWriter.print(this.i);
                printWriter.print(" mRetainingStarted=");
                printWriter.print(this.j);
                printWriter.print(" mListenerRegistered=");
                printWriter.println(this.m);
                if (this.n != null) {
                    printWriter.print(str);
                    printWriter.println("Pending Loader ");
                    printWriter.print(this.n);
                    printWriter.println(":");
                    a aVar = this.n;
                    aVar.c(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
                }
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.i) {
                    if (fi4.g) {
                        Log.v("LoaderManager", "  Finished Retaining: " + this);
                    }
                    this.i = false;
                    boolean z = this.h;
                    if (z != this.j && !z) {
                        h();
                    }
                }
                if (this.h && this.e && !this.k) {
                    a(this.d, this.g);
                }
            }
        }

        public void h() {
            ki4<Object> ki4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                if (fi4.g) {
                    Log.v("LoaderManager", "  Stopping: " + this);
                }
                this.h = false;
                if (!this.i && (ki4Var = this.d) != null && this.m) {
                    this.m = false;
                    ki4Var.k(this);
                    this.d.l(this);
                    this.d.j();
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                StringBuilder sb = new StringBuilder(64);
                sb.append("LoaderInfo{");
                sb.append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" #");
                sb.append(this.a);
                sb.append(ZeusCrashHandler.NAME_SEPERATOR);
                ni4.a(this.d, sb);
                sb.append("}}");
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        public void e() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.h && this.k) {
                this.k = false;
                if (this.e) {
                    a(this.d, this.g);
                }
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (fi4.g) {
                    Log.v("LoaderManager", "  Retaining: " + this);
                }
                this.i = true;
                this.j = this.h;
                this.h = false;
                this.c = null;
            }
        }

        public void g() {
            ei4.a<Object> aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                if (this.i && this.j) {
                    this.h = true;
                } else if (this.h) {
                } else {
                    this.h = true;
                    if (fi4.g) {
                        Log.v("LoaderManager", "  Starting: " + this);
                    }
                    if (this.d == null && (aVar = this.c) != null) {
                        this.d = aVar.onCreateLoader(this.a, this.b);
                    }
                    ki4<Object> ki4Var = this.d;
                    if (ki4Var != null) {
                        if (ki4Var.getClass().isMemberClass() && !Modifier.isStatic(this.d.getClass().getModifiers())) {
                            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.d);
                        }
                        if (!this.m) {
                            this.d.f(this.a, this);
                            this.d.g(this);
                            this.m = true;
                        }
                        this.d.i();
                    }
                }
            }
        }
    }

    public fi4(String str, zh4 zh4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, zh4Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ri4<>();
        this.b = new ri4<>();
        this.c = str;
        this.f = zh4Var;
        this.d = z;
    }

    public void k(zh4 zh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, zh4Var) == null) {
            this.f = zh4Var;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.e) {
                if (g) {
                    Log.v("LoaderManager", "Destroying Active in " + this);
                }
                for (int e = this.a.e() - 1; e >= 0; e--) {
                    this.a.f(e).b();
                }
                this.a.a();
            }
            if (g) {
                Log.v("LoaderManager", "Destroying Inactive in " + this);
            }
            for (int e2 = this.b.e() - 1; e2 >= 0; e2--) {
                this.b.f(e2).b();
            }
            this.b.a();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (g) {
                Log.v("LoaderManager", "Retaining in " + this);
            }
            if (!this.d) {
                RuntimeException runtimeException = new RuntimeException("here");
                runtimeException.fillInStackTrace();
                Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
                return;
            }
            this.e = true;
            this.d = false;
            for (int e = this.a.e() - 1; e >= 0; e--) {
                this.a.f(e).f();
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (g) {
                Log.v("LoaderManager", "Starting in " + this);
            }
            if (this.d) {
                RuntimeException runtimeException = new RuntimeException("here");
                runtimeException.fillInStackTrace();
                Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
                return;
            }
            this.d = true;
            for (int e = this.a.e() - 1; e >= 0; e--) {
                this.a.f(e).g();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (g) {
                Log.v("LoaderManager", "Stopping in " + this);
            }
            if (!this.d) {
                RuntimeException runtimeException = new RuntimeException("here");
                runtimeException.fillInStackTrace();
                Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
                return;
            }
            for (int e = this.a.e() - 1; e >= 0; e--) {
                this.a.f(e).h();
            }
            this.d = false;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int e = this.a.e() - 1; e >= 0; e--) {
                this.a.f(e).k = true;
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (int e = this.a.e() - 1; e >= 0; e--) {
                this.a.f(e).e();
            }
        }
    }

    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, fileDescriptor, printWriter, strArr) == null) {
            if (this.a.e() > 0) {
                printWriter.print(str);
                printWriter.println("Active Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.a.e(); i++) {
                    a f = this.a.f(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.a.d(i));
                    printWriter.print(": ");
                    printWriter.println(f.toString());
                    f.c(str2, fileDescriptor, printWriter, strArr);
                }
            }
            if (this.b.e() > 0) {
                printWriter.print(str);
                printWriter.println("Inactive Loaders:");
                String str3 = str + "    ";
                for (int i2 = 0; i2 < this.b.e(); i2++) {
                    a f2 = this.b.f(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.b.d(i2));
                    printWriter.print(": ");
                    printWriter.println(f2.toString());
                    f2.c(str3, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.e) {
            if (g) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.e = false;
            for (int e = this.a.e() - 1; e >= 0; e--) {
                this.a.f(e).d();
            }
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int e = this.a.e();
            boolean z2 = false;
            for (int i = 0; i < e; i++) {
                a f = this.a.f(i);
                if (f.h && !f.f) {
                    z = true;
                } else {
                    z = false;
                }
                z2 |= z;
            }
            return z2;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("LoaderManager{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" in ");
            ni4.a(this.f, sb);
            sb.append("}}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
