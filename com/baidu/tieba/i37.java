package com.baidu.tieba;

import android.content.Context;
import android.text.SpannableString;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class i37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public interface b {
        @NonNull
        j a();

        f b();

        k c();

        g d();

        i e();

        @NonNull
        h f();

        e g();
    }

    /* loaded from: classes6.dex */
    public interface e extends l {
        @NonNull
        ViewGroup create(Context context);

        void update(@NonNull ViewGroup viewGroup, @NonNull d47 d47Var);
    }

    /* loaded from: classes6.dex */
    public interface f extends l {
        @NonNull
        ViewGroup create(Context context);

        void update(@NonNull ViewGroup viewGroup, @NonNull h47 h47Var);
    }

    /* loaded from: classes6.dex */
    public interface g extends l {
        @NonNull
        ViewGroup create(Context context);

        void update(@NonNull ViewGroup viewGroup, @NonNull i47 i47Var);
    }

    /* loaded from: classes6.dex */
    public interface h extends l {
        @NonNull
        ViewGroup create(Context context);

        void update(@NonNull ViewGroup viewGroup, @NonNull Object obj);
    }

    /* loaded from: classes6.dex */
    public interface i extends l {
        @NonNull
        ViewGroup create(Context context);

        void update(@NonNull ViewGroup viewGroup, @NonNull l47 l47Var);
    }

    /* loaded from: classes6.dex */
    public interface j extends l {
        @NonNull
        ViewGroup create(Context context);

        void update(@NonNull ViewGroup viewGroup, @NonNull t47 t47Var);
    }

    /* loaded from: classes6.dex */
    public interface k {
        SpannableString a(@NonNull Context context, @NonNull y47 y47Var);
    }

    /* loaded from: classes6.dex */
    public interface l {
        void a(@NonNull ViewGroup viewGroup);
    }

    /* loaded from: classes6.dex */
    public static final class c implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public class a implements j {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.i37.l
            public void a(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.i37.j
            public void update(@NonNull ViewGroup viewGroup, @NonNull t47 t47Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, t47Var) == null) {
                }
            }

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.i37.j
            @NonNull
            public ViewGroup create(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                    return new LinearLayout(context);
                }
                return (ViewGroup) invokeL.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class b implements h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.i37.l
            public void a(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.i37.h
            public void update(@NonNull ViewGroup viewGroup, @NonNull Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, obj) == null) {
                }
            }

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.i37.h
            @NonNull
            public ViewGroup create(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                    return new LinearLayout(context);
                }
                return (ViewGroup) invokeL.objValue;
            }
        }

        /* renamed from: com.baidu.tieba.i37$c$c  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0343c implements e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.i37.l
            public void a(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.i37.e
            public void update(@NonNull ViewGroup viewGroup, @NonNull d47 d47Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, d47Var) == null) {
                }
            }

            public C0343c(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.i37.e
            @NonNull
            public ViewGroup create(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                    return new LinearLayout(context);
                }
                return (ViewGroup) invokeL.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class d implements f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.i37.l
            public void a(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.i37.f
            public void update(@NonNull ViewGroup viewGroup, @NonNull h47 h47Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, h47Var) == null) {
                }
            }

            public d(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.i37.f
            @NonNull
            public ViewGroup create(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                    return new LinearLayout(context);
                }
                return (ViewGroup) invokeL.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class e implements i {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.i37.l
            public void a(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.i37.i
            public void update(@NonNull ViewGroup viewGroup, @NonNull l47 l47Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, l47Var) == null) {
                }
            }

            public e(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.i37.i
            @NonNull
            public ViewGroup create(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                    return new LinearLayout(context);
                }
                return (ViewGroup) invokeL.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class f implements g {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.i37.l
            public void a(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.i37.g
            public void update(@NonNull ViewGroup viewGroup, @NonNull i47 i47Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i47Var) == null) {
                }
            }

            public f(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.i37.g
            @NonNull
            public ViewGroup create(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                    return new LinearLayout(context);
                }
                return (ViewGroup) invokeL.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class g implements k {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public g(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.i37.k
            public SpannableString a(Context context, y47 y47Var) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, y47Var)) == null) {
                    return new SpannableString("");
                }
                return (SpannableString) invokeLL.objValue;
            }
        }

        public c() {
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

        @Override // com.baidu.tieba.i37.b
        @NonNull
        public j a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new a(this);
            }
            return (j) invokeV.objValue;
        }

        @Override // com.baidu.tieba.i37.b
        public f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new d(this);
            }
            return (f) invokeV.objValue;
        }

        @Override // com.baidu.tieba.i37.b
        public k c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return new g(this);
            }
            return (k) invokeV.objValue;
        }

        @Override // com.baidu.tieba.i37.b
        public g d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return new f(this);
            }
            return (g) invokeV.objValue;
        }

        @Override // com.baidu.tieba.i37.b
        public i e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return new e(this);
            }
            return (i) invokeV.objValue;
        }

        @Override // com.baidu.tieba.i37.b
        @NonNull
        public h f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return new b(this);
            }
            return (h) invokeV.objValue;
        }

        @Override // com.baidu.tieba.i37.b
        public e g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new C0343c(this);
            }
            return (e) invokeV.objValue;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-767411428, "Lcom/baidu/tieba/i37$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-767411428, "Lcom/baidu/tieba/i37$d;");
                    return;
                }
            }
            b bVar = (b) ServiceManager.getService(new ServiceReference("feed", "component.resolver"));
            if (bVar != null) {
                a = bVar;
            } else {
                a = new c(null);
            }
        }
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return d.a;
        }
        return (b) invokeV.objValue;
    }
}
