package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes4.dex */
public abstract class i8b<E> extends j8b<E> {
    public static /* synthetic */ Interceptable $ic;
    public static final int c;
    public static final long d;
    public static final int e;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;
    public final E[] b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947808790, "Lcom/baidu/tieba/i8b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947808790, "Lcom/baidu/tieba/i8b;");
                return;
            }
        }
        c = Integer.getInteger("sparse.shift", 0).intValue();
        int b = i9b.a.b(Object[].class);
        if (4 == b) {
            e = c + 2;
        } else if (8 == b) {
            e = c + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        d = i9b.a.a(Object[].class) + (32 << (e - c));
    }

    public i8b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        int b = l8b.b(i);
        this.a = b - 1;
        this.b = (E[]) new Object[(b << c) + 64];
    }

    public final long a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            return b(j, this.a);
        }
        return invokeJ.longValue;
    }

    public final E d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            return e(this.b, j);
        }
        return (E) invokeJ.objValue;
    }

    public final long b(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            return d + ((j & j2) << e);
        }
        return invokeCommon.longValue;
    }

    public final E c(E[] eArr, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, eArr, j)) == null) {
            return (E) i9b.a.e(eArr, j);
        }
        return (E) invokeLJ.objValue;
    }

    public final E e(E[] eArr, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048581, this, eArr, j)) == null) {
            return (E) i9b.a.f(eArr, j);
        }
        return (E) invokeLJ.objValue;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048579, this) != null) {
            return;
        }
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (Iterator) invokeV.objValue;
    }

    public final void f(E[] eArr, long j, E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{eArr, Long.valueOf(j), e2}) == null) {
            i9b.a.j(eArr, j, e2);
        }
    }

    public final void g(E[] eArr, long j, E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{eArr, Long.valueOf(j), e2}) == null) {
            i9b.a.h(eArr, j, e2);
        }
    }
}
