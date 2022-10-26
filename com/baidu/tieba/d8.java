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
public class d8 implements Iterable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object[] a;
    public int b;
    public int c;
    public int d;
    public transient a e;

    /* loaded from: classes3.dex */
    public class a implements Iterable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final d8 a;
        public final boolean b;
        public b c;
        public b d;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(d8 d8Var) {
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

        public a(d8 d8Var, boolean z) {
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
        public Iterator iterator() {
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
    public class b implements Iterator, Iterable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final d8 a;
        public final boolean b;
        public int c;
        public boolean d;

        @Override // java.lang.Iterable
        public Iterator iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (Iterator) invokeV.objValue;
        }

        public b(d8 d8Var, boolean z) {
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
        public Object next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i = this.c;
                d8 d8Var = this.a;
                if (i < d8Var.d) {
                    if (this.d) {
                        this.c = i + 1;
                        return d8Var.get(i);
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException(String.valueOf(this.c));
            }
            return invokeV.objValue;
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
            Object[] objArr = this.a;
            int length = objArr.length;
            int i2 = this.b;
            int i3 = i + 1;
            for (int i4 = 0; i4 < i; i4++) {
                Object obj = objArr[i2];
                i3 *= 31;
                if (obj != null) {
                    i3 += obj.hashCode();
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
    public Iterator iterator() {
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
        this.a = new Object[i];
    }

    public void addLast(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            Object[] objArr = this.a;
            if (this.d == objArr.length) {
                b(objArr.length << 1);
                objArr = this.a;
            }
            int i = this.c;
            int i2 = i + 1;
            this.c = i2;
            objArr[i] = obj;
            if (i2 == objArr.length) {
                this.c = 0;
            }
            this.d++;
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            Object[] objArr = this.a;
            int i2 = this.b;
            int i3 = this.c;
            Object[] objArr2 = (Object[]) t8.a(objArr.getClass().getComponentType(), i);
            if (i2 < i3) {
                System.arraycopy(objArr, i2, objArr2, 0, i3 - i2);
            } else if (this.d > 0) {
                int length = objArr.length - i2;
                System.arraycopy(objArr, i2, objArr2, 0, length);
                System.arraycopy(objArr, 0, objArr2, length, i3);
            }
            this.a = objArr2;
            this.b = 0;
            this.c = this.d;
        }
    }

    public Object a(int i) {
        InterceptResult invokeI;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i >= 0) {
                if (i < this.d) {
                    Object[] objArr = this.a;
                    int i2 = this.b;
                    int i3 = this.c;
                    int i4 = i + i2;
                    if (i2 < i3) {
                        obj = objArr[i4];
                        System.arraycopy(objArr, i4 + 1, objArr, i4, i3 - i4);
                        objArr[i3] = null;
                        this.c--;
                    } else if (i4 >= objArr.length) {
                        int length = i4 - objArr.length;
                        obj = objArr[length];
                        System.arraycopy(objArr, length + 1, objArr, length, i3 - length);
                        this.c--;
                    } else {
                        Object obj2 = objArr[i4];
                        System.arraycopy(objArr, i2, objArr, i2 + 1, i4 - i2);
                        objArr[i2] = null;
                        int i5 = this.b + 1;
                        this.b = i5;
                        if (i5 == objArr.length) {
                            this.b = 0;
                        }
                        obj = obj2;
                    }
                    this.d--;
                    return obj;
                }
                throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.d);
            }
            throw new IndexOutOfBoundsException("index can't be < 0: " + i);
        }
        return invokeI.objValue;
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
            Object[] objArr = this.a;
            int length = objArr.length;
            Object[] objArr2 = d8Var.a;
            int length2 = objArr2.length;
            int i2 = this.b;
            int i3 = d8Var.b;
            for (int i4 = 0; i4 < i; i4++) {
                Object obj2 = objArr[i2];
                Object obj3 = objArr2[i3];
                if (obj2 == null) {
                    if (obj3 != null) {
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
                    if (!obj2.equals(obj3)) {
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

    public Object get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (i >= 0) {
                if (i < this.d) {
                    Object[] objArr = this.a;
                    int i2 = this.b + i;
                    if (i2 >= objArr.length) {
                        i2 -= objArr.length;
                    }
                    return objArr[i2];
                }
                throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.d);
            }
            throw new IndexOutOfBoundsException("index can't be < 0: " + i);
        }
        return invokeI.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.d == 0) {
                return "[]";
            }
            Object[] objArr = this.a;
            int i = this.b;
            int i2 = this.c;
            k8 k8Var = new k8(64);
            k8Var.a('[');
            k8Var.m(objArr[i]);
            while (true) {
                i = (i + 1) % objArr.length;
                if (i != i2) {
                    k8Var.n(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    k8Var.m(objArr[i]);
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
