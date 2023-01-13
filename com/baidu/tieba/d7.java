package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.y7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes4.dex */
public class d7<K, V> implements Iterable<y7.b<K, V>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public K[] a;
    public V[] b;
    public int c;
    public boolean d;
    public transient a e;
    public transient a f;

    /* loaded from: classes4.dex */
    public static class a<K, V> implements Iterable<y7.b<K, V>>, Iterator<y7.b<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final d7<K, V> a;
        public y7.b<K, V> b;
        public int c;
        public boolean d;

        @Override // java.lang.Iterable
        public Iterator<y7.b<K, V>> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (Iterator) invokeV.objValue;
        }

        public a(d7<K, V> d7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = new y7.b<>();
            this.d = true;
            this.a = d7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: a */
        public y7.b<K, V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i = this.c;
                d7<K, V> d7Var = this.a;
                if (i < d7Var.c) {
                    if (this.d) {
                        y7.b<K, V> bVar = this.b;
                        bVar.a = d7Var.a[i];
                        V[] vArr = d7Var.b;
                        this.c = i + 1;
                        bVar.b = vArr[i];
                        return bVar;
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException(String.valueOf(this.c));
            }
            return (y7.b) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.d) {
                    if (this.c < this.a.c) {
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
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                int i = this.c - 1;
                this.c = i;
                this.a.f(i);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d7() {
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

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            K[] kArr = this.a;
            V[] vArr = this.b;
            int i = this.c;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                K k = kArr[i3];
                V v = vArr[i3];
                if (k != null) {
                    i2 += k.hashCode() * 31;
                }
                if (v != null) {
                    i2 += v.hashCode();
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d7(Class cls, Class cls2) {
        this(false, 16, cls, cls2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, cls2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue(), (Class) objArr2[2], (Class) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public d7(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.d = z;
        this.a = (K[]) new Object[i];
        this.b = (V[]) new Object[i];
    }

    public V c(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, k, v)) == null) {
            K[] kArr = this.a;
            int i = this.c - 1;
            if (k == null) {
                while (i >= 0) {
                    if (kArr[i] == k) {
                        return this.b[i];
                    }
                    i--;
                }
            } else {
                while (i >= 0) {
                    if (k.equals(kArr[i])) {
                        return this.b[i];
                    }
                    i--;
                }
            }
            return v;
        }
        return (V) invokeLL.objValue;
    }

    public int e(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, k, v)) == null) {
            int d = d(k);
            if (d == -1) {
                int i = this.c;
                if (i == this.a.length) {
                    g(Math.max(8, (int) (i * 1.75f)));
                }
                d = this.c;
                this.c = d + 1;
            }
            this.a[d] = k;
            this.b[d] = v;
            return d;
        }
        return invokeLL.intValue;
    }

    public d7(boolean z, int i, Class cls, Class cls2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i), cls, cls2};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.d = z;
        this.a = (K[]) ((Object[]) u8.a(cls, i));
        this.b = (V[]) ((Object[]) u8.a(cls2, i));
    }

    public a<K, V> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (h7.a) {
                return new a<>(this);
            }
            if (this.e == null) {
                this.e = new a(this);
                this.f = new a(this);
            }
            a<K, V> aVar = this.e;
            if (!aVar.d) {
                aVar.c = 0;
                aVar.d = true;
                this.f.d = false;
                return aVar;
            }
            a<K, V> aVar2 = this.f;
            aVar2.c = 0;
            aVar2.d = true;
            aVar.d = false;
            return aVar2;
        }
        return (a) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.c == 0) {
                return StringUtil.EMPTY_ARRAY;
            }
            K[] kArr = this.a;
            V[] vArr = this.b;
            l8 l8Var = new l8(32);
            l8Var.a('{');
            l8Var.m(kArr[0]);
            l8Var.a(com.alipay.sdk.encrypt.a.h);
            l8Var.m(vArr[0]);
            for (int i = 1; i < this.c; i++) {
                l8Var.n(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                l8Var.m(kArr[i]);
                l8Var.a(com.alipay.sdk.encrypt.a.h);
                l8Var.m(vArr[i]);
            }
            l8Var.a('}');
            return l8Var.toString();
        }
        return (String) invokeV.objValue;
    }

    public V b(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k)) == null) {
            return c(k, null);
        }
        return (V) invokeL.objValue;
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Arrays.fill(this.a, 0, this.c, (Object) null);
            Arrays.fill(this.b, 0, this.c, (Object) null);
            this.c = 0;
        }
    }

    @Override // java.lang.Iterable
    public Iterator<y7.b<K, V>> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return a();
        }
        return (Iterator) invokeV.objValue;
    }

    public int d(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, k)) == null) {
            K[] kArr = this.a;
            int i = 0;
            if (k == null) {
                int i2 = this.c;
                while (i < i2) {
                    if (kArr[i] == k) {
                        return i;
                    }
                    i++;
                }
                return -1;
            }
            int i3 = this.c;
            while (i < i3) {
                if (k.equals(kArr[i])) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v1, resolved type: com.baidu.tieba.d7 */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof d7)) {
                return false;
            }
            d7 d7Var = (d7) obj;
            int i = d7Var.c;
            int i2 = this.c;
            if (i != i2) {
                return false;
            }
            K[] kArr = this.a;
            V[] vArr = this.b;
            for (int i3 = 0; i3 < i2; i3++) {
                K k = kArr[i3];
                V v = vArr[i3];
                if (v == null) {
                    if (d7Var.c(k, y7.n) != null) {
                        return false;
                    }
                } else if (!v.equals(d7Var.b(k))) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            int i2 = this.c;
            if (i < i2) {
                K[] kArr = this.a;
                int i3 = i2 - 1;
                this.c = i3;
                if (this.d) {
                    int i4 = i + 1;
                    System.arraycopy(kArr, i4, kArr, i, i3 - i);
                    V[] vArr = this.b;
                    System.arraycopy(vArr, i4, vArr, i, this.c - i);
                } else {
                    kArr[i] = kArr[i3];
                    V[] vArr2 = this.b;
                    vArr2[i] = vArr2[i3];
                }
                int i5 = this.c;
                kArr[i5] = null;
                this.b[i5] = null;
                return;
            }
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            K[] kArr = (K[]) ((Object[]) u8.a(this.a.getClass().getComponentType(), i));
            System.arraycopy(this.a, 0, kArr, 0, Math.min(this.c, kArr.length));
            this.a = kArr;
            V[] vArr = (V[]) ((Object[]) u8.a(this.b.getClass().getComponentType(), i));
            System.arraycopy(this.b, 0, vArr, 0, Math.min(this.c, vArr.length));
            this.b = vArr;
        }
    }

    public void insert(int i, K k, V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048586, this, i, k, v) == null) {
            int i2 = this.c;
            if (i <= i2) {
                if (i2 == this.a.length) {
                    g(Math.max(8, (int) (i2 * 1.75f)));
                }
                if (this.d) {
                    K[] kArr = this.a;
                    int i3 = i + 1;
                    System.arraycopy(kArr, i, kArr, i3, this.c - i);
                    V[] vArr = this.b;
                    System.arraycopy(vArr, i, vArr, i3, this.c - i);
                } else {
                    K[] kArr2 = this.a;
                    int i4 = this.c;
                    kArr2[i4] = kArr2[i];
                    V[] vArr2 = this.b;
                    vArr2[i4] = vArr2[i];
                }
                this.c++;
                this.a[i] = k;
                this.b[i] = v;
                return;
            }
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }
    }
}
