package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes3.dex */
public final class a4 implements Iterable<z3>, Comparable<a4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final z3[] a;
    public final int b;
    public long c;
    public a<z3> d;

    /* loaded from: classes3.dex */
    public static class a<T> implements Iterable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final T[] a;
        public b b;
        public b c;

        public a(T[] tArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tArr;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (m7.a) {
                    return new b(this.a);
                }
                if (this.b == null) {
                    this.b = new b(this.a);
                    this.c = new b(this.a);
                }
                b bVar = this.b;
                if (!bVar.c) {
                    bVar.b = 0;
                    bVar.c = true;
                    this.c.c = false;
                    return bVar;
                }
                b bVar2 = this.c;
                bVar2.b = 0;
                bVar2.c = true;
                bVar.c = false;
                return bVar2;
            }
            return (Iterator) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b<T> implements Iterator<T>, Iterable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final T[] a;
        public int b;
        public boolean c;

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (Iterator) invokeV.objValue;
        }

        public b(T[] tArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = true;
            this.a = tArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.c) {
                    if (this.b < this.a.length) {
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
                throw new GdxRuntimeException("Remove not allowed.");
            }
        }

        @Override // java.util.Iterator
        public T next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i = this.b;
                T[] tArr = this.a;
                if (i < tArr.length) {
                    if (this.c) {
                        this.b = i + 1;
                        return tArr[i];
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException(String.valueOf(this.b));
            }
            return (T) invokeV.objValue;
        }
    }

    public a4(z3... z3VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {z3VarArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = -1L;
        if (z3VarArr.length != 0) {
            z3[] z3VarArr2 = new z3[z3VarArr.length];
            for (int i3 = 0; i3 < z3VarArr.length; i3++) {
                z3VarArr2[i3] = z3VarArr[i3];
            }
            this.a = z3VarArr2;
            this.b = a();
            return;
        }
        throw new IllegalArgumentException("attributes must be >= 1");
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = 0;
            int i2 = 0;
            while (true) {
                z3[] z3VarArr = this.a;
                if (i < z3VarArr.length) {
                    z3 z3Var = z3VarArr[i];
                    z3Var.e = i2;
                    i2 += z3Var.k();
                    i++;
                } else {
                    return i2;
                }
            }
        } else {
            return invokeV.intValue;
        }
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.c == -1) {
                long j = 0;
                int i = 0;
                while (true) {
                    z3[] z3VarArr = this.a;
                    if (i >= z3VarArr.length) {
                        break;
                    }
                    j |= z3VarArr[i].a;
                    i++;
                }
                this.c = j;
            }
            return this.c;
        }
        return invokeV.longValue;
    }

    @Override // java.lang.Iterable
    public Iterator<z3> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.d == null) {
                this.d = new a<>(this.a);
            }
            return this.d.iterator();
        }
        return (Iterator) invokeV.objValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a.length;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(a4 a4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a4Var)) == null) {
            z3[] z3VarArr = this.a;
            int length = z3VarArr.length;
            z3[] z3VarArr2 = a4Var.a;
            if (length != z3VarArr2.length) {
                return z3VarArr.length - z3VarArr2.length;
            }
            int i = (d() > a4Var.d() ? 1 : (d() == a4Var.d() ? 0 : -1));
            if (i != 0) {
                if (i < 0) {
                    return -1;
                }
                return 1;
            }
            for (int length2 = this.a.length - 1; length2 >= 0; length2--) {
                z3 z3Var = this.a[length2];
                z3 z3Var2 = a4Var.a[length2];
                int i2 = z3Var.a;
                int i3 = z3Var2.a;
                if (i2 != i3) {
                    return i2 - i3;
                }
                int i4 = z3Var.g;
                int i5 = z3Var2.g;
                if (i4 != i5) {
                    return i4 - i5;
                }
                int i6 = z3Var.b;
                int i7 = z3Var2.b;
                if (i6 != i7) {
                    return i6 - i7;
                }
                boolean z = z3Var.c;
                if (z != z3Var2.c) {
                    if (!z) {
                        return -1;
                    }
                    return 1;
                }
                int i8 = z3Var.d;
                int i9 = z3Var2.d;
                if (i8 != i9) {
                    return i8 - i9;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public z3 c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return this.a[i];
        }
        return (z3) invokeI.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a4)) {
                return false;
            }
            a4 a4Var = (a4) obj;
            if (this.a.length != a4Var.a.length) {
                return false;
            }
            int i = 0;
            while (true) {
                z3[] z3VarArr = this.a;
                if (i >= z3VarArr.length) {
                    return true;
                }
                if (!z3VarArr[i].i(a4Var.a[i])) {
                    return false;
                }
                i++;
            }
        } else {
            return invokeL.booleanValue;
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        z3[] z3VarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            long length = this.a.length * 61;
            int i = 0;
            while (true) {
                if (i < this.a.length) {
                    length = (length * 61) + z3VarArr[i].hashCode();
                    i++;
                } else {
                    return (int) (length ^ (length >> 32));
                }
            }
        } else {
            return invokeV.intValue;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(PreferencesUtil.LEFT_MOUNT);
            for (int i = 0; i < this.a.length; i++) {
                sb.append("(");
                sb.append(this.a[i].f);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(this.a[i].a);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(this.a[i].b);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(this.a[i].e);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                sb.append("\n");
            }
            sb.append(PreferencesUtil.RIGHT_MOUNT);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
