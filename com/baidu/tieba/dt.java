package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes4.dex */
public class dt<K, V> implements Iterable<Map.Entry<K, V>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c<K, V> a;
    public c<K, V> b;
    public WeakHashMap<Object<K, V>, Boolean> c;
    public int d;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b<K, V> extends e<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, cVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((c) objArr2[0], (c) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.dt.e
        public c<K, V> a(c<K, V> cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                return cVar.c;
            }
            return (c) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class c<K, V> implements Map.Entry<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final K a;
        public final V b;
        public c<K, V> c;

        public c(K k, V v) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k, v};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k;
            this.b = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                if (this.a.equals(cVar.a) && this.b.equals(cVar.b)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a;
            }
            return (K) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b;
            }
            return (V) invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a + "=" + this.b;
            }
            return (String) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, v)) == null) {
                throw new UnsupportedOperationException("An entry modification is not supported");
            }
            return (V) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Object<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c<K, V> a;
        public boolean b;
        public final /* synthetic */ dt c;

        public d(dt dtVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dtVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = dtVar;
            this.b = true;
        }

        public /* synthetic */ d(dt dtVar, a aVar) {
            this(dtVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: a */
        public Map.Entry<K, V> next() {
            InterceptResult invokeV;
            c<K, V> cVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.b) {
                    this.b = false;
                    this.a = this.c.a;
                } else {
                    c<K, V> cVar2 = this.a;
                    if (cVar2 != null) {
                        cVar = cVar2.c;
                    } else {
                        cVar = null;
                    }
                    this.a = cVar;
                }
                return this.a;
            }
            return (Map.Entry) invokeV.objValue;
        }

        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.b) {
                    if (this.c.a != null) {
                        return true;
                    }
                    return false;
                }
                c<K, V> cVar = this.a;
                if (cVar != null && cVar.c != null) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class e<K, V> implements Object<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c<K, V> a;
        public c<K, V> b;

        public abstract c<K, V> a(c<K, V> cVar);

        public e(c<K, V> cVar, c<K, V> cVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, cVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar2;
            this.b = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: b */
        public Map.Entry<K, V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                c<K, V> cVar = this.b;
                this.b = c();
                return cVar;
            }
            return (Map.Entry) invokeV.objValue;
        }

        public final c<K, V> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                c<K, V> cVar = this.b;
                c<K, V> cVar2 = this.a;
                if (cVar != cVar2 && cVar2 != null) {
                    return a(cVar);
                }
                return null;
            }
            return (c) invokeV.objValue;
        }

        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.b != null) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    public dt() {
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
        this.c = new WeakHashMap<>();
        this.d = 0;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public dt<K, V>.d f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            dt<K, V>.d dVar = new d(this, null);
            this.c.put(dVar, Boolean.FALSE);
            return dVar;
        }
        return (d) invokeV.objValue;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b bVar = new b(this.a, this.b);
            this.c.put(bVar, Boolean.FALSE);
            return bVar;
        }
        return (Iterator) invokeV.objValue;
    }

    public c<K, V> c(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k)) == null) {
            c<K, V> cVar = this.a;
            while (cVar != null && !cVar.a.equals(k)) {
                cVar = cVar.c;
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public V d(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, k, v)) == null) {
            c<K, V> c2 = c(k);
            if (c2 != null) {
                return c2.b;
            }
            e(k, v);
            return null;
        }
        return (V) invokeLL.objValue;
    }

    public c<K, V> e(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, k, v)) == null) {
            c<K, V> cVar = new c<>(k, v);
            this.d++;
            c<K, V> cVar2 = this.b;
            if (cVar2 == null) {
                this.a = cVar;
                this.b = cVar;
                return cVar;
            }
            cVar2.c = cVar;
            this.b = cVar;
            return cVar;
        }
        return (c) invokeLL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof dt)) {
                return false;
            }
            dt dtVar = (dt) obj;
            if (a() != dtVar.a()) {
                return false;
            }
            Iterator<Map.Entry<K, V>> it = iterator();
            Iterator<Map.Entry<K, V>> it2 = dtVar.iterator();
            while (it.hasNext() && it2.hasNext()) {
                Map.Entry<K, V> next = it.next();
                Map.Entry<K, V> next2 = it2.next();
                if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                    return false;
                }
            }
            if (!it.hasNext() && !it2.hasNext()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(PreferencesUtil.LEFT_MOUNT);
            Iterator<Map.Entry<K, V>> it = iterator();
            while (it.hasNext()) {
                sb.append(it.next().toString());
                if (it.hasNext()) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
            }
            sb.append(PreferencesUtil.RIGHT_MOUNT);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
