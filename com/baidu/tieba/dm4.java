package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Vector;
/* loaded from: classes5.dex */
public class dm4 implements tl4 {
    public static /* synthetic */ Interceptable $ic;
    public static final xo4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public Vector<tl4> a;
    public Object b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947709342, "Lcom/baidu/tieba/dm4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947709342, "Lcom/baidu/tieba/dm4;");
                return;
            }
        }
        c = xo4.e();
    }

    public dm4(tl4 tl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tl4Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new Object();
        this.a = new Vector<>();
        c(tl4Var);
    }

    @Override // com.baidu.tieba.tl4
    public <T> void a(xl4<T> xl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xl4Var) == null) {
            try {
                synchronized (this.b) {
                    Iterator<tl4> it = this.a.iterator();
                    while (it.hasNext()) {
                        it.next().a(xl4Var);
                    }
                }
            } catch (Throwable th) {
                c.g("RuntimeTaskObserver", "#notifyTaskRunning error", th);
            }
        }
    }

    @Override // com.baidu.tieba.tl4
    public <T> void b(xl4<T> xl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xl4Var) == null) {
            Vector vector = new Vector();
            try {
                synchronized (this.b) {
                    Iterator<tl4> it = this.a.iterator();
                    while (it.hasNext()) {
                        vector.add(it.next());
                    }
                }
                Iterator it2 = vector.iterator();
                while (it2.hasNext()) {
                    ((tl4) it2.next()).b(xl4Var);
                }
            } catch (Throwable th) {
                c.g("RuntimeTaskObserver", "#notifyTaskEnd error", th);
            }
        }
    }

    public void c(tl4 tl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tl4Var) == null) && tl4Var != null) {
            synchronized (this.b) {
                this.a.add(tl4Var);
            }
        }
    }

    public void d(tl4 tl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, tl4Var) == null) && tl4Var != null) {
            synchronized (this.b) {
                if (!this.a.remove(tl4Var)) {
                    this.a.remove(this.a.indexOf(tl4Var));
                }
            }
        }
    }
}
