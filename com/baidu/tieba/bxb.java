package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes5.dex */
public abstract class bxb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, closeable) == null) && closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                cxb.d("IOUtil", "closeSecure IOException");
            }
        }
    }

    public static void b(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, inputStream) == null) {
            a(inputStream);
        }
    }

    public static void c(OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, outputStream) == null) {
            a(outputStream);
        }
    }
}
