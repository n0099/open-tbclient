package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.x7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes3.dex */
public class c7 implements Iterable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object[] a;
    public Object[] b;
    public int c;
    public boolean d;
    public transient a e;
    public transient a f;

    /* loaded from: classes3.dex */
    public class a implements Iterable, Iterator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c7 a;
        public x7.b b;
        public int c;
        public boolean d;

        @Override // java.lang.Iterable
        public Iterator iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (Iterator) invokeV.objValue;
        }

        public a(c7 c7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = new x7.b();
            this.d = true;
            this.a = c7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: a */
        public x7.b next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i = this.c;
                c7 c7Var = this.a;
                if (i < c7Var.c) {
                    if (this.d) {
                        x7.b bVar = this.b;
                        bVar.a = c7Var.a[i];
                        Object[] objArr = c7Var.b;
                        this.c = i + 1;
                        bVar.b = objArr[i];
                        return bVar;
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException(String.valueOf(this.c));
            }
            return (x7.b) invokeV.objValue;
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

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Object[] objArr = this.a;
            Object[] objArr2 = this.b;
            int i = this.c;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                Object obj = objArr[i3];
                Object obj2 = objArr2[i3];
                if (obj != null) {
                    i2 += obj.hashCode() * 31;
                }
                if (obj2 != null) {
                    i2 += obj2.hashCode();
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c7(Class cls, Class cls2) {
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

    public c7(boolean z, int i) {
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
        this.a = new Object[i];
        this.b = new Object[i];
    }

    public Object c(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, obj, obj2)) == null) {
            Object[] objArr = this.a;
            int i = this.c - 1;
            if (obj == null) {
                while (i >= 0) {
                    if (objArr[i] == obj) {
                        return this.b[i];
                    }
                    i--;
                }
            } else {
                while (i >= 0) {
                    if (obj.equals(objArr[i])) {
                        return this.b[i];
                    }
                    i--;
                }
            }
            return obj2;
        }
        return invokeLL.objValue;
    }

    public int e(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, obj, obj2)) == null) {
            int d = d(obj);
            if (d == -1) {
                int i = this.c;
                if (i == this.a.length) {
                    g(Math.max(8, (int) (i * 1.75f)));
                }
                d = this.c;
                this.c = d + 1;
            }
            this.a[d] = obj;
            this.b[d] = obj2;
            return d;
        }
        return invokeLL.intValue;
    }

    public c7(boolean z, int i, Class cls, Class cls2) {
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
        this.a = (Object[]) t8.a(cls, i);
        this.b = (Object[]) t8.a(cls2, i);
    }

    public a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (g7.a) {
                return new a(this);
            }
            if (this.e == null) {
                this.e = new a(this);
                this.f = new a(this);
            }
            a aVar = this.e;
            if (!aVar.d) {
                aVar.c = 0;
                aVar.d = true;
                this.f.d = false;
                return aVar;
            }
            a aVar2 = this.f;
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
            Object[] objArr = this.a;
            Object[] objArr2 = this.b;
            k8 k8Var = new k8(32);
            k8Var.a('{');
            k8Var.m(objArr[0]);
            k8Var.a('=');
            k8Var.m(objArr2[0]);
            for (int i = 1; i < this.c; i++) {
                k8Var.n(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                k8Var.m(objArr[i]);
                k8Var.a('=');
                k8Var.m(objArr2[i]);
            }
            k8Var.a('}');
            return k8Var.toString();
        }
        return (String) invokeV.objValue;
    }

    public Object b(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            return c(obj, null);
        }
        return invokeL.objValue;
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
    public Iterator iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return a();
        }
        return (Iterator) invokeV.objValue;
    }

    public int d(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            Object[] objArr = this.a;
            int i = 0;
            if (obj == null) {
                int i2 = this.c;
                while (i < i2) {
                    if (objArr[i] == obj) {
                        return i;
                    }
                    i++;
                }
                return -1;
            }
            int i3 = this.c;
            while (i < i3) {
                if (obj.equals(objArr[i])) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c7)) {
                return false;
            }
            c7 c7Var = (c7) obj;
            int i = c7Var.c;
            int i2 = this.c;
            if (i != i2) {
                return false;
            }
            Object[] objArr = this.a;
            Object[] objArr2 = this.b;
            for (int i3 = 0; i3 < i2; i3++) {
                Object obj2 = objArr[i3];
                Object obj3 = objArr2[i3];
                if (obj3 == null) {
                    if (c7Var.c(obj2, x7.n) != null) {
                        return false;
                    }
                } else if (!obj3.equals(c7Var.b(obj2))) {
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
                Object[] objArr = this.a;
                int i3 = i2 - 1;
                this.c = i3;
                if (this.d) {
                    int i4 = i + 1;
                    System.arraycopy(objArr, i4, objArr, i, i3 - i);
                    Object[] objArr2 = this.b;
                    System.arraycopy(objArr2, i4, objArr2, i, this.c - i);
                } else {
                    objArr[i] = objArr[i3];
                    Object[] objArr3 = this.b;
                    objArr3[i] = objArr3[i3];
                }
                int i5 = this.c;
                objArr[i5] = null;
                this.b[i5] = null;
                return;
            }
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            Object[] objArr = (Object[]) t8.a(this.a.getClass().getComponentType(), i);
            System.arraycopy(this.a, 0, objArr, 0, Math.min(this.c, objArr.length));
            this.a = objArr;
            Object[] objArr2 = (Object[]) t8.a(this.b.getClass().getComponentType(), i);
            System.arraycopy(this.b, 0, objArr2, 0, Math.min(this.c, objArr2.length));
            this.b = objArr2;
        }
    }

    public void insert(int i, Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048586, this, i, obj, obj2) == null) {
            int i2 = this.c;
            if (i <= i2) {
                if (i2 == this.a.length) {
                    g(Math.max(8, (int) (i2 * 1.75f)));
                }
                if (this.d) {
                    Object[] objArr = this.a;
                    int i3 = i + 1;
                    System.arraycopy(objArr, i, objArr, i3, this.c - i);
                    Object[] objArr2 = this.b;
                    System.arraycopy(objArr2, i, objArr2, i3, this.c - i);
                } else {
                    Object[] objArr3 = this.a;
                    int i4 = this.c;
                    objArr3[i4] = objArr3[i];
                    Object[] objArr4 = this.b;
                    objArr4[i4] = objArr4[i];
                }
                this.c++;
                this.a[i] = obj;
                this.b[i] = obj2;
                return;
            }
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }
    }
}
