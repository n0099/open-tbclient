package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes4.dex */
public class h1a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tv9 a;
    public final kw9 b;
    public final HashMap<String, mw9> c;

    /* loaded from: classes4.dex */
    public interface a<E> {
        void a(E e);

        void b(E e);
    }

    public h1a() {
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
        this.b = new kw9();
        this.c = new HashMap<>();
    }

    public final <E> void a(Set<E> set, Set<E> set2, a<E> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, set, set2, aVar) == null) {
            for (E e : set2) {
                if (set == null || !set.contains(e)) {
                    aVar.b(e);
                } else {
                    aVar.a(e);
                }
            }
        }
    }
}
