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
/* loaded from: classes5.dex */
public class bv2 extends DataOutputStream {
    public static /* synthetic */ Interceptable $ic;
    public static final zu2<byte[], String> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements zu2<byte[], String> {
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
        @Override // com.baidu.tieba.zu2
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

    /* loaded from: classes5.dex */
    public class b implements zu2<byte[], Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bv2 a;

        public b(bv2 bv2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bv2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zu2
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947658347, "Lcom/baidu/tieba/bv2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947658347, "Lcom/baidu/tieba/bv2;");
                return;
            }
        }
        a = new a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bv2(OutputStream outputStream) throws IOException {
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

    public <T> void c(@Nullable T t, @NonNull zu2<byte[], T> zu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, t, zu2Var) == null) {
            try {
                b(zu2Var.call(t));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public <T> void e(Map<String, T> map, zu2<byte[], T> zu2Var) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, map, zu2Var) == null) {
            if (map == null) {
                writeInt(-1);
                return;
            }
            writeInt(map.size());
            g(map.keySet());
            d(map.values(), zu2Var);
        }
    }

    public <T> void d(@Nullable Collection<T> collection, zu2<byte[], T> zu2Var) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, collection, zu2Var) == null) {
            if (collection == null) {
                writeInt(-1);
                return;
            }
            writeInt(collection.size());
            for (T t : collection) {
                try {
                    b(zu2Var.call(t));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
