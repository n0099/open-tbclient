package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes4.dex */
public class c7<T> implements Iterable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public T[] a;
    public int b;
    public boolean c;
    public a d;

    /* loaded from: classes4.dex */
    public static class a<T> implements Iterable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c7<T> a;
        public final boolean b;
        public b c;
        public b d;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(c7<T> c7Var) {
            this(c7Var, true);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((c7) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public a(c7<T> c7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c7Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = c7Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Iterable
        /* renamed from: a */
        public b<T> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (h7.a) {
                    return new b<>(this.a, this.b);
                }
                if (this.c == null) {
                    this.c = new b(this.a, this.b);
                    this.d = new b(this.a, this.b);
                }
                b<T> bVar = this.c;
                if (!bVar.d) {
                    bVar.c = 0;
                    bVar.d = true;
                    this.d.d = false;
                    return bVar;
                }
                b<T> bVar2 = this.d;
                bVar2.c = 0;
                bVar2.d = true;
                bVar.d = false;
                return bVar2;
            }
            return (b) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b<T> implements Iterator<T>, Iterable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c7<T> a;
        public final boolean b;
        public int c;
        public boolean d;

        public b<T> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (b) invokeV.objValue;
        }

        public b(c7<T> c7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c7Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = true;
            this.a = c7Var;
            this.b = z;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.d) {
                    if (this.c < this.a.b) {
                        return true;
                    }
                    return false;
                }
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return invokeV.booleanValue;
        }

        @Override // java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            a();
            return this;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (this.b) {
                    int i = this.c - 1;
                    this.c = i;
                    this.a.h(i);
                    return;
                }
                throw new GdxRuntimeException("Remove not allowed.");
            }
        }

        @Override // java.util.Iterator
        public T next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int i = this.c;
                c7<T> c7Var = this.a;
                if (i < c7Var.b) {
                    if (this.d) {
                        T[] tArr = c7Var.a;
                        this.c = i + 1;
                        return tArr[i];
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException(String.valueOf(this.c));
            }
            return (T) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c7() {
        this(true, 16);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Boolean) objArr[0]).booleanValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c7(int i) {
        this(true, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public T[] e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (i >= 0) {
                int i2 = this.b + i;
                if (i2 > this.a.length) {
                    j(Math.max(Math.max(8, i2), (int) (this.b * 1.75f)));
                }
                return this.a;
            }
            throw new IllegalArgumentException("additionalCapacity must be >= 0: " + i);
        }
        return (T[]) ((Object[]) invokeI.objValue);
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (!this.c || !(obj instanceof c7)) {
                return false;
            }
            c7 c7Var = (c7) obj;
            if (!c7Var.c || (i = this.b) != c7Var.b) {
                return false;
            }
            T[] tArr = this.a;
            T[] tArr2 = c7Var.a;
            for (int i2 = 0; i2 < i; i2++) {
                T t = tArr[i2];
                T t2 = tArr2[i2];
                if (t == null) {
                    if (t2 != null) {
                        return false;
                    }
                } else if (!t.equals(t2)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public T h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            int i2 = this.b;
            if (i < i2) {
                T[] tArr = this.a;
                T t = tArr[i];
                int i3 = i2 - 1;
                this.b = i3;
                if (this.c) {
                    System.arraycopy(tArr, i + 1, tArr, i, i3 - i);
                } else {
                    tArr[i] = tArr[i3];
                }
                tArr[this.b] = null;
                return t;
            }
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.b);
        }
        return (T) invokeI.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c7(c7<? extends T> c7Var) {
        this(c7Var.c, c7Var.b, c7Var.a.getClass().getComponentType());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c7Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue(), (Class) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        int i3 = c7Var.b;
        this.b = i3;
        System.arraycopy(c7Var.a, 0, this.a, 0, i3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c7(Class cls) {
        this(true, 16, cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue(), (Class) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public c7(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.c = z;
        this.a = (T[]) new Object[i];
    }

    public boolean i(T t, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048589, this, t, z)) == null) {
            T[] tArr = this.a;
            if (!z && t != null) {
                int i = this.b;
                for (int i2 = 0; i2 < i; i2++) {
                    if (t.equals(tArr[i2])) {
                        h(i2);
                        return true;
                    }
                }
            } else {
                int i3 = this.b;
                for (int i4 = 0; i4 < i3; i4++) {
                    if (tArr[i4] == t) {
                        h(i4);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public void k(int i, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i, t) == null) {
            if (i < this.b) {
                this.a[i] = t;
                return;
            }
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.b);
        }
    }

    public c7(boolean z, int i, Class cls) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i), cls};
            interceptable.invokeUnInit(65541, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        this.c = z;
        this.a = (T[]) ((Object[]) u8.a(cls, i));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c7(boolean z, T[] tArr, int i, int i2) {
        this(z, i2, tArr.getClass().getComponentType());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), tArr, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65542, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue(), (Class) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
                return;
            }
        }
        this.b = i2;
        System.arraycopy(tArr, i, this.a, 0, i2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c7(T[] tArr) {
        this(true, tArr, 0, tArr.length);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tArr};
            interceptable.invokeUnInit(65543, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), (Object[]) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
    }

    public static <T> c7<T> n(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tArr)) == null) {
            return new c7<>(tArr);
        }
        return (c7) invokeL.objValue;
    }

    public void a(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
            T[] tArr = this.a;
            int i = this.b;
            if (i == tArr.length) {
                tArr = j(Math.max(8, (int) (i * 1.75f)));
            }
            int i2 = this.b;
            this.b = i2 + 1;
            tArr[i2] = t;
        }
    }

    public void b(c7<? extends T> c7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c7Var) == null) {
            d(c7Var.a, 0, c7Var.b);
        }
    }

    public T[] j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            T[] tArr = this.a;
            T[] tArr2 = (T[]) ((Object[]) u8.a(tArr.getClass().getComponentType(), i));
            System.arraycopy(tArr, 0, tArr2, 0, Math.min(this.b, tArr2.length));
            this.a = tArr2;
            return tArr2;
        }
        return (T[]) ((Object[]) invokeI.objValue);
    }

    public <V> V[] m(Class<V> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, cls)) == null) {
            V[] vArr = (V[]) ((Object[]) u8.a(cls, this.b));
            System.arraycopy(this.a, 0, vArr, 0, this.b);
            return vArr;
        }
        return (V[]) ((Object[]) invokeL.objValue);
    }

    public void sort(Comparator<? super T> comparator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, comparator) == null) {
            j8.a().c(this.a, comparator, 0, this.b);
        }
    }

    public void c(c7<? extends T> c7Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, c7Var, i, i2) == null) {
            if (i + i2 <= c7Var.b) {
                d(c7Var.a, i, i2);
                return;
            }
            throw new IllegalArgumentException("start + count must be <= size: " + i + " + " + i2 + " <= " + c7Var.b);
        }
    }

    public void d(T[] tArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, tArr, i, i2) == null) {
            T[] tArr2 = this.a;
            int i3 = this.b + i2;
            if (i3 > tArr2.length) {
                tArr2 = j(Math.max(Math.max(8, i3), (int) (this.b * 1.75f)));
            }
            System.arraycopy(tArr, i, tArr2, this.b, i2);
            this.b = i3;
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Arrays.fill(this.a, 0, this.b, (Object) null);
            this.b = 0;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: f */
    public b<T> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (h7.a) {
                return new b<>(this, true);
            }
            if (this.d == null) {
                this.d = new a(this);
            }
            return this.d.iterator();
        }
        return (b) invokeV.objValue;
    }

    public T first() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.b != 0) {
                return this.a[0];
            }
            throw new IllegalStateException("Array is empty.");
        }
        return (T) invokeV.objValue;
    }

    public T g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i = this.b;
            if (i == 0) {
                return null;
            }
            return this.a[com.badlogic.gdx.math.d.n(0, i - 1)];
        }
        return (T) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (!this.c) {
                return super.hashCode();
            }
            T[] tArr = this.a;
            int i = this.b;
            int i2 = 1;
            for (int i3 = 0; i3 < i; i3++) {
                i2 *= 31;
                T t = tArr[i3];
                if (t != null) {
                    i2 += t.hashCode();
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.b == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            j8.a().b(this.a, 0, this.b);
        }
    }

    public T peek() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            int i = this.b;
            if (i != 0) {
                return this.a[i - 1];
            }
            throw new IllegalStateException("Array is empty.");
        }
        return (T) invokeV.objValue;
    }

    public T pop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            int i = this.b;
            if (i != 0) {
                int i2 = i - 1;
                this.b = i2;
                T[] tArr = this.a;
                T t = tArr[i2];
                tArr[i2] = null;
                return t;
            }
            throw new IllegalStateException("Array is empty.");
        }
        return (T) invokeV.objValue;
    }

    public T get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (i < this.b) {
                return this.a[i];
            }
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.b);
        }
        return (T) invokeI.objValue;
    }

    public void insert(int i, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i, t) == null) {
            int i2 = this.b;
            if (i <= i2) {
                T[] tArr = this.a;
                if (i2 == tArr.length) {
                    tArr = j(Math.max(8, (int) (i2 * 1.75f)));
                }
                if (this.c) {
                    System.arraycopy(tArr, i, tArr, i + 1, this.b - i);
                } else {
                    tArr[this.b] = tArr[i];
                }
                this.b++;
                tArr[i] = t;
                return;
            }
            throw new IndexOutOfBoundsException("index can't be > size: " + i + " > " + this.b);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.b == 0) {
                return "[]";
            }
            T[] tArr = this.a;
            l8 l8Var = new l8(32);
            l8Var.a('[');
            l8Var.m(tArr[0]);
            for (int i = 1; i < this.b; i++) {
                l8Var.n(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                l8Var.m(tArr[i]);
            }
            l8Var.a(']');
            return l8Var.toString();
        }
        return (String) invokeV.objValue;
    }
}
