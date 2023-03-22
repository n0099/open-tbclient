package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.g7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.NoSuchElementException;
/* loaded from: classes4.dex */
public class i7<K, V> extends g7<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final k6<K> o;

    /* loaded from: classes4.dex */
    public static class a<K, V> extends g7.a<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public k6<K> g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i7<K, V> i7Var) {
            super(i7Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((g7) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = i7Var.o;
        }

        @Override // com.baidu.tieba.g7.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d = -1;
                boolean z = false;
                this.c = 0;
                if (this.b.a > 0) {
                    z = true;
                }
                this.a = z;
            }
        }

        @Override // com.baidu.tieba.g7.d, java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.d >= 0) {
                    this.b.k(this.f.a);
                    this.c--;
                    this.d = -1;
                    return;
                }
                throw new IllegalStateException("next must be called before remove.");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.g7.a, java.util.Iterator
        /* renamed from: d */
        public g7.b next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a) {
                    if (this.e) {
                        int i = this.c;
                        this.d = i;
                        this.f.a = this.g.get(i);
                        g7.b<K, V> bVar = this.f;
                        bVar.b = this.b.c(bVar.a);
                        boolean z = true;
                        int i2 = this.c + 1;
                        this.c = i2;
                        if (i2 >= this.b.a) {
                            z = false;
                        }
                        this.a = z;
                        return this.f;
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException();
            }
            return (g7.b) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b<K> extends g7.c<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public k6<K> f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(i7<K, ?> i7Var) {
            super(i7Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((g7) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = i7Var.o;
        }

        @Override // com.baidu.tieba.g7.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d = -1;
                boolean z = false;
                this.c = 0;
                if (this.b.a > 0) {
                    z = true;
                }
                this.a = z;
            }
        }

        @Override // com.baidu.tieba.g7.c
        public k6<K> d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                k6<K> k6Var = new k6<>(true, this.f.b - this.c);
                e(k6Var);
                return k6Var;
            }
            return (k6) invokeV.objValue;
        }

        @Override // com.baidu.tieba.g7.d, java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                int i = this.d;
                if (i >= 0) {
                    ((i7) this.b).o(i);
                    this.c = this.d;
                    this.d = -1;
                    return;
                }
                throw new IllegalStateException("next must be called before remove.");
            }
        }

        @Override // com.baidu.tieba.g7.c
        public k6<K> e(k6<K> k6Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k6Var)) == null) {
                k6<K> k6Var2 = this.f;
                int i = this.c;
                k6Var.c(k6Var2, i, k6Var2.b - i);
                this.c = this.f.b;
                this.a = false;
                return k6Var;
            }
            return (k6) invokeL.objValue;
        }

        @Override // com.baidu.tieba.g7.c, java.util.Iterator
        public K next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.a) {
                    if (this.e) {
                        K k = this.f.get(this.c);
                        int i = this.c;
                        this.d = i;
                        boolean z = true;
                        int i2 = i + 1;
                        this.c = i2;
                        if (i2 >= this.b.a) {
                            z = false;
                        }
                        this.a = z;
                        return k;
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException();
            }
            return (K) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class c<V> extends g7.e<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public k6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(i7<?, V> i7Var) {
            super(i7Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((g7) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = i7Var.o;
        }

        @Override // com.baidu.tieba.g7.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d = -1;
                boolean z = false;
                this.c = 0;
                if (this.b.a > 0) {
                    z = true;
                }
                this.a = z;
            }
        }

        @Override // com.baidu.tieba.g7.d, java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i = this.d;
                if (i >= 0) {
                    ((i7) this.b).o(i);
                    this.c = this.d;
                    this.d = -1;
                    return;
                }
                throw new IllegalStateException("next must be called before remove.");
            }
        }

        @Override // com.baidu.tieba.g7.e, java.util.Iterator
        public V next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a) {
                    if (this.e) {
                        V c = this.b.c(this.f.get(this.c));
                        int i = this.c;
                        this.d = i;
                        boolean z = true;
                        int i2 = i + 1;
                        this.c = i2;
                        if (i2 >= this.b.a) {
                            z = false;
                        }
                        this.a = z;
                        return c;
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException();
            }
            return (V) invokeV.objValue;
        }
    }

    public i7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new k6<>();
    }

    @Override // com.baidu.tieba.g7
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.o.clear();
            super.clear();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.g7, java.lang.Iterable
    /* renamed from: e */
    public g7.a<K, V> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return b();
        }
        return (g7.a) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i7(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.o = new k6<>(i);
    }

    @Override // com.baidu.tieba.g7
    public g7.a<K, V> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (p6.a) {
                return new a(this);
            }
            if (this.h == null) {
                this.h = new a(this);
                this.i = new a(this);
            }
            g7.a aVar = this.h;
            if (!aVar.e) {
                aVar.b();
                g7.a<K, V> aVar2 = this.h;
                aVar2.e = true;
                this.i.e = false;
                return aVar2;
            }
            this.i.b();
            g7.a<K, V> aVar3 = this.i;
            aVar3.e = true;
            this.h.e = false;
            return aVar3;
        }
        return (g7.a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g7
    public g7.c<K> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (p6.a) {
                return new b(this);
            }
            if (this.l == null) {
                this.l = new b(this);
                this.m = new b(this);
            }
            g7.c cVar = this.l;
            if (!cVar.e) {
                cVar.b();
                g7.c<K> cVar2 = this.l;
                cVar2.e = true;
                this.m.e = false;
                return cVar2;
            }
            this.m.b();
            g7.c<K> cVar3 = this.m;
            cVar3.e = true;
            this.l.e = false;
            return cVar3;
        }
        return (g7.c) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g7
    public g7.e<V> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (p6.a) {
                return new c(this);
            }
            if (this.j == null) {
                this.j = new c(this);
                this.k = new c(this);
            }
            g7.e eVar = this.j;
            if (!eVar.e) {
                eVar.b();
                g7.e<V> eVar2 = this.j;
                eVar2.e = true;
                this.k.e = false;
                return eVar2;
            }
            this.k.b();
            g7.e<V> eVar3 = this.k;
            eVar3.e = true;
            this.j.e = false;
            return eVar3;
        }
        return (g7.e) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g7
    public V i(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, k, v)) == null) {
            int g = g(k);
            if (g >= 0) {
                V[] vArr = this.c;
                V v2 = vArr[g];
                vArr[g] = v;
                return v2;
            }
            int i = -(g + 1);
            this.b[i] = k;
            this.c[i] = v;
            this.o.a(k);
            int i2 = this.a + 1;
            this.a = i2;
            if (i2 >= this.e) {
                l(this.b.length << 1);
                return null;
            }
            return null;
        }
        return (V) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.g7
    public V k(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, k)) == null) {
            this.o.i(k, false);
            return (V) super.k(k);
        }
        return (V) invokeL.objValue;
    }

    public V o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            return (V) super.k(this.o.h(i));
        }
        return (V) invokeI.objValue;
    }

    @Override // com.baidu.tieba.g7
    public String m(String str, boolean z) {
        InterceptResult invokeLZ;
        K k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048583, this, str, z)) == null) {
            if (this.a == 0) {
                if (z) {
                    return StringUtil.EMPTY_ARRAY;
                }
                return "";
            }
            StringBuilder sb = new StringBuilder(32);
            if (z) {
                sb.append('{');
            }
            k6<K> k6Var = this.o;
            int i = k6Var.b;
            for (int i2 = 0; i2 < i; i2++) {
                K k2 = k6Var.get(i2);
                if (i2 > 0) {
                    sb.append(str);
                }
                Object obj = "(this)";
                if (k2 == this) {
                    k = "(this)";
                } else {
                    k = k2;
                }
                sb.append(k);
                sb.append('=');
                V c2 = c(k2);
                if (c2 != this) {
                    obj = c2;
                }
                sb.append(obj);
            }
            if (z) {
                sb.append('}');
            }
            return sb.toString();
        }
        return (String) invokeLZ.objValue;
    }
}
