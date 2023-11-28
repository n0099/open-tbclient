package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public interface da<T> {

    /* loaded from: classes5.dex */
    public interface a<T> {
        void a(String str, T t);
    }

    /* loaded from: classes5.dex */
    public interface c<T> extends da<T> {
        void b();

        ca<T> c();

        String j();
    }

    void a(String str, T t);

    void d(String str);

    void e(String str, T t, long j);

    void f(String str, a<T> aVar);

    void g(String str, T t);

    T get(String str);

    b<T> h(String str);

    void i(String str, T t, long j);

    void remove(String str);

    /* loaded from: classes5.dex */
    public static class b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public T b;
        public long c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }
}
