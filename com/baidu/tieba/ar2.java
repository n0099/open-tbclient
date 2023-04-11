package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes3.dex */
public class ar2 extends DataOutputStream {
    public static /* synthetic */ Interceptable $ic;
    public static final yq2<byte[], String> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements yq2<byte[], String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yq2
        @Nullable
        public byte[] call(@Nullable String str) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (str == null) {
                    return null;
                }
                return str.getBytes();
            }
            return (byte[]) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements yq2<byte[], Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ar2 a;

        public b(ar2 ar2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ar2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ar2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yq2
        @Nullable
        public byte[] call(@Nullable Boolean bool) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool)) == null) {
                if (bool != null && bool.booleanValue()) {
                    return new byte[0];
                }
                return null;
            }
            return (byte[]) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947624712, "Lcom/baidu/tieba/ar2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947624712, "Lcom/baidu/tieba/ar2;");
                return;
            }
        }
        a = new a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar2(OutputStream outputStream) throws IOException {
        super(outputStream);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {outputStream};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((OutputStream) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void a(Map<String, Boolean> map) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            e(map, new b(this));
        }
    }

    public void b(byte[] bArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr) == null) {
            if (bArr == null) {
                writeInt(-1);
                return;
            }
            writeInt(bArr.length);
            if (bArr.length > 0) {
                write(bArr);
            }
        }
    }

    public void f(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            try {
                b(a.call(str));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void g(Collection<String> collection) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, collection) == null) {
            d(collection, a);
        }
    }

    public void h(Map<String, String> map) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, map) == null) {
            e(map, a);
        }
    }

    public <T> void c(@Nullable T t, @NonNull yq2<byte[], T> yq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, t, yq2Var) == null) {
            try {
                b(yq2Var.call(t));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public <T> void e(Map<String, T> map, yq2<byte[], T> yq2Var) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, map, yq2Var) == null) {
            if (map == null) {
                writeInt(-1);
                return;
            }
            writeInt(map.size());
            g(map.keySet());
            d(map.values(), yq2Var);
        }
    }

    public <T> void d(@Nullable Collection<T> collection, yq2<byte[], T> yq2Var) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, collection, yq2Var) == null) {
            if (collection == null) {
                writeInt(-1);
                return;
            }
            writeInt(collection.size());
            for (T t : collection) {
                try {
                    b(yq2Var.call(t));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
