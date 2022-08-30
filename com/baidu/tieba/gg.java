package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class gg<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public LinkedList<T> c;
    public hg<T> d;

    public gg(hg<T> hgVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hgVar, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 10;
        this.b = 0;
        this.c = null;
        this.d = null;
        if (hgVar != null && i > 0 && i2 <= i) {
            this.d = hgVar;
            this.a = i;
            this.b = i2;
            this.c = new LinkedList<>();
            a(this.b);
            return;
        }
        throw new InvalidParameterException("invalid params");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: java.util.LinkedList<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            synchronized (this) {
                for (int i2 = 0; i2 < i; i2++) {
                    Object obj = null;
                    try {
                        obj = this.d.a(this.d.d());
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    if (obj != null) {
                        this.c.offer(obj);
                    }
                }
            }
        }
    }

    public T b() {
        InterceptResult invokeV;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                t = null;
                try {
                    if (this.c.size() > 0) {
                        t = this.d.a(this.c.poll());
                    } else {
                        t = this.d.a(this.d.d());
                    }
                    a(this.b - this.c.size());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            return t;
        }
        return (T) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.c.clear();
            }
        }
    }

    public final void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            synchronized (this) {
                for (int i2 = 0; i2 < i; i2++) {
                    try {
                        this.d.b(this.c.poll());
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                }
            }
        }
    }

    public void e(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
            synchronized (this) {
                if (this.c.size() < this.a) {
                    T t2 = null;
                    try {
                        t2 = this.d.c(t);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    if (t2 != null) {
                        this.c.offer(t2);
                    }
                } else {
                    this.d.b(t);
                }
            }
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            synchronized (this) {
                if (i < this.b) {
                    i = this.b;
                }
                if (i <= 0) {
                    i = 1;
                }
                this.a = i;
                d(this.c.size() - this.a);
            }
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            synchronized (this) {
                if (i > this.a) {
                    i = this.a;
                }
                this.b = i;
                a(i - this.c.size());
            }
        }
    }
}
