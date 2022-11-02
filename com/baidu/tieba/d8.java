package com.baidu.tieba;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes3.dex */
public class d8<T> implements Iterable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public T[] a;
    public int b;
    public int c;
    public int d;
    public transient a e;

    /* loaded from: classes3.dex */
    public static class a<T> implements Iterable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final d8<T> a;
        public final boolean b;
        public b c;
        public b d;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(d8<T> d8Var) {
            this(d8Var, true);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((d8) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public a(d8<T> d8Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d8Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = d8Var;
            this.b = z;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (g7.a) {
                    return new b(this.a, this.b);
                }
                if (this.c == null) {
                    this.c = new b(this.a, this.b);
                    this.d = new b(this.a, this.b);
                }
                b bVar = this.c;
                if (!bVar.d) {
                    bVar.c = 0;
                    bVar.d = true;
                    this.d.d = false;
                    return bVar;
                }
                b bVar2 = this.d;
                bVar2.c = 0;
                bVar2.d = true;
                bVar.d = false;
                return bVar2;
            }
            return (Iterator) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b<T> implements Iterator<T>, Iterable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final d8<T> a;
        public final boolean b;
        public int c;
        public boolean d;

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (Iterator) invokeV.objValue;
        }

        public b(d8<T> d8Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d8Var, Boolean.valueOf(z)};
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
            this.a = d8Var;
            this.b = z;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.d) {
                    if (this.c < this.a.d) {
                        return true;
                    }
                    return false;
                }
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.b) {
                    int i = this.c - 1;
                    this.c = i;
                    this.a.a(i);
                    return;
                }
                throw new GdxRuntimeException("Remove not allowed.");
            }
        }

        @Override // java.util.Iterator
        public T next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i = this.c;
                d8<T> d8Var = this.a;
                if (i < d8Var.d) {
                    if (this.d) {
                        this.c = i + 1;
                        return d8Var.get(i);
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException(String.valueOf(this.c));
            }
            return (T) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d8() {
        this(16);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i = this.d;
            T[] tArr = this.a;
            int length = tArr.length;
            int i2 = this.b;
            int i3 = i + 1;
            for (int i4 = 0; i4 < i; i4++) {
                T t = tArr[i2];
                i3 *= 31;
                if (t != null) {
                    i3 += t.hashCode();
                }
                i2++;
                if (i2 == length) {
                    i2 = 0;
                }
            }
            return i3;
        }
        return invokeV.intValue;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (g7.a) {
                return new b(this, true);
            }
            if (this.e == null) {
                this.e = new a(this);
            }
            return this.e.iterator();
        }
        return (Iterator) invokeV.objValue;
    }

    public d8(int i) {
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
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.a = (T[]) new Object[i];
    }

    public void addLast(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            T[] tArr = this.a;
            if (this.d == tArr.length) {
                b(tArr.length << 1);
                tArr = this.a;
            }
            int i = this.c;
            int i2 = i + 1;
            this.c = i2;
            tArr[i] = t;
            if (i2 == tArr.length) {
                this.c = 0;
            }
            this.d++;
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            T[] tArr = this.a;
            int i2 = this.b;
            int i3 = this.c;
            T[] tArr2 = (T[]) ((Object[]) t8.a(tArr.getClass().getComponentType(), i));
            if (i2 < i3) {
                System.arraycopy(tArr, i2, tArr2, 0, i3 - i2);
            } else if (this.d > 0) {
                int length = tArr.length - i2;
                System.arraycopy(tArr, i2, tArr2, 0, length);
                System.arraycopy(tArr, 0, tArr2, length, i3);
            }
            this.a = tArr2;
            this.b = 0;
            this.c = this.d;
        }
    }

    public T a(int i) {
        InterceptResult invokeI;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i >= 0) {
                if (i < this.d) {
                    T[] tArr = this.a;
                    int i2 = this.b;
                    int i3 = this.c;
                    int i4 = i + i2;
                    if (i2 < i3) {
                        t = tArr[i4];
                        System.arraycopy(tArr, i4 + 1, tArr, i4, i3 - i4);
                        tArr[i3] = null;
                        this.c--;
                    } else if (i4 >= tArr.length) {
                        int length = i4 - tArr.length;
                        t = tArr[length];
                        System.arraycopy(tArr, length + 1, tArr, length, i3 - length);
                        this.c--;
                    } else {
                        T t2 = tArr[i4];
                        System.arraycopy(tArr, i2, tArr, i2 + 1, i4 - i2);
                        tArr[i2] = null;
                        int i5 = this.b + 1;
                        this.b = i5;
                        if (i5 == tArr.length) {
                            this.b = 0;
                        }
                        t = t2;
                    }
                    this.d--;
                    return t;
                }
                throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.d);
            }
            throw new IndexOutOfBoundsException("index can't be < 0: " + i);
        }
        return (T) invokeI.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0040 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof d8)) {
                return false;
            }
            d8 d8Var = (d8) obj;
            int i = this.d;
            if (d8Var.d != i) {
                return false;
            }
            T[] tArr = this.a;
            int length = tArr.length;
            T[] tArr2 = d8Var.a;
            int length2 = tArr2.length;
            int i2 = this.b;
            int i3 = d8Var.b;
            for (int i4 = 0; i4 < i; i4++) {
                T t = tArr[i2];
                T t2 = tArr2[i3];
                if (t == null) {
                    if (t2 != null) {
                        return false;
                    }
                    i2++;
                    i3++;
                    if (i2 == length) {
                        i2 = 0;
                    }
                    if (i3 != length2) {
                        i3 = 0;
                    }
                } else {
                    if (!t.equals(t2)) {
                        return false;
                    }
                    i2++;
                    i3++;
                    if (i2 == length) {
                    }
                    if (i3 != length2) {
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public T get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (i >= 0) {
                if (i < this.d) {
                    T[] tArr = this.a;
                    int i2 = this.b + i;
                    if (i2 >= tArr.length) {
                        i2 -= tArr.length;
                    }
                    return tArr[i2];
                }
                throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.d);
            }
            throw new IndexOutOfBoundsException("index can't be < 0: " + i);
        }
        return (T) invokeI.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.d == 0) {
                return "[]";
            }
            T[] tArr = this.a;
            int i = this.b;
            int i2 = this.c;
            k8 k8Var = new k8(64);
            k8Var.a('[');
            k8Var.m(tArr[i]);
            while (true) {
                i = (i + 1) % tArr.length;
                if (i != i2) {
                    k8Var.n(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    k8Var.m(tArr[i]);
                } else {
                    k8Var.a(']');
                    return k8Var.toString();
                }
            }
        } else {
            return (String) invokeV.objValue;
        }
    }
}
