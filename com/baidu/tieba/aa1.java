package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.eb1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class aa1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947608344, "Lcom/baidu/tieba/aa1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947608344, "Lcom/baidu/tieba/aa1;");
        }
    }

    /* loaded from: classes5.dex */
    public class a implements eb1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eb1.b a;

        /* renamed from: com.baidu.tieba.aa1$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0224a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0224a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                eb1.b bVar;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bVar = this.a.a) != null) {
                    bVar.a();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                eb1.b bVar;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bVar = this.a.a) != null) {
                    bVar.b();
                }
            }
        }

        public a(eb1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.tieba.eb1.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                jb1.a("WebViewInit", "内核在宿主内成功初始化");
                int unused = aa1.a = 3;
                ik0.c(new RunnableC0224a(this));
            }
        }

        @Override // com.baidu.tieba.eb1.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ik0.c(new b(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements eb1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eb1.b a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                eb1.b bVar;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bVar = this.a.a) != null) {
                    bVar.a();
                }
            }
        }

        /* renamed from: com.baidu.tieba.aa1$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0225b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public RunnableC0225b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                eb1.b bVar;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bVar = this.a.a) != null) {
                    bVar.b();
                }
            }
        }

        public b(eb1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.tieba.eb1.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                jb1.a("WebViewInit", "内核在SDK内成功初始化");
                int unused = aa1.a = 3;
                ik0.c(new a(this));
            }
        }

        @Override // com.baidu.tieba.eb1.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                jb1.a("WebViewInit", "内核在SDK内初始化失败");
                int unused = aa1.a = 4;
                ik0.c(new RunnableC0225b(this));
            }
        }
    }

    public static int b(Context context, eb1.b bVar) {
        InterceptResult invokeLL;
        String str;
        int c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, bVar)) == null) {
            if (3 != a && 4 != a) {
                int a2 = bb1.h().a(context, new a(bVar));
                if (3 != a2 && 1 != a2 && 2 != a2 && 5 != a2) {
                    if (a2 == 0 || 4 == a2) {
                        a = 2;
                        try {
                            boolean g = bb1.g();
                            StringBuilder sb = new StringBuilder();
                            sb.append("内核在sdk初始化，类型为 ");
                            String str2 = "t7";
                            if (g) {
                                str = "t7";
                            } else {
                                str = "native";
                            }
                            sb.append(str);
                            jb1.c(context, sb.toString());
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("内核在SDK内完成初始化，类型为 ");
                            if (!g) {
                                str2 = "native";
                            }
                            sb2.append(str2);
                            jb1.a("WebViewInit", sb2.toString());
                            if (g) {
                                c = w91.b();
                            } else {
                                c = w91.c();
                            }
                            w91.a().d(context, g, c, new b(bVar));
                        } catch (Throwable unused) {
                            jb1.a("WebViewInit", "SDK初始化内核时发生异常，初始化失败");
                            if (bVar != null) {
                                bVar.b();
                            }
                            a = 4;
                        }
                    }
                    return a;
                }
                a = a2;
                return a;
            }
            return a;
        }
        return invokeLL.intValue;
    }
}
