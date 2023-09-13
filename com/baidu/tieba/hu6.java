package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tieba.ju6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hu6 {
    public static /* synthetic */ Interceptable $ic;
    public static ju6 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947836256, "Lcom/baidu/tieba/hu6;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947836256, "Lcom/baidu/tieba/hu6;");
        }
    }

    /* loaded from: classes6.dex */
    public class a implements ju6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.ju6
        public <T extends iu6> void b(@Nullable T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            }
        }

        @Override // com.baidu.tieba.ju6
        public void unregister(@NonNull Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            }
        }

        public a() {
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

        @Override // com.baidu.tieba.ju6
        public <T extends iu6> void a(@NonNull Object obj, @NonNull ku6<T> ku6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, obj, ku6Var) == null) {
                throw new IllegalStateException("Unable to find eventbus service!");
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final ju6.a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-735118046, "Lcom/baidu/tieba/hu6$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-735118046, "Lcom/baidu/tieba/hu6$b;");
                    return;
                }
            }
            a = (ju6.a) ServiceManager.getService(ju6.a.a);
        }
    }

    public hu6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a(@NonNull BdUniqueId bdUniqueId) {
        ju6.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, bdUniqueId) == null) && (aVar = b.a) != null) {
            aVar.a(bdUniqueId);
        }
    }

    public static ju6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (a == null) {
                synchronized (hu6.class) {
                    if (a == null) {
                        a = (ju6) ServiceManager.getService(ju6.a);
                    }
                    if (a == null) {
                        a = new a();
                    }
                }
            }
            return a;
        }
        return (ju6) invokeV.objValue;
    }
}
