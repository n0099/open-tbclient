package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.zxing.client.result.ResultParser;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
/* loaded from: classes6.dex */
public class hh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, closeable) == null) && closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String b(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, inputStream)) == null) {
            return c(inputStream, null);
        }
        return (String) invokeL.objValue;
    }

    public static String c(InputStream inputStream, String str) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, inputStream, str)) == null) {
            if (inputStream != null) {
                if (TextUtils.isEmpty(str)) {
                    str = System.getProperty("file.encoding", "utf-8");
                }
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, str);
                StringWriter stringWriter = new StringWriter();
                char[] cArr = new char[4096];
                for (int read = inputStreamReader.read(cArr); read > 0; read = inputStreamReader.read(cArr)) {
                    stringWriter.write(cArr, 0, read);
                }
                String stringWriter2 = stringWriter.toString();
                inputStreamReader.close();
                stringWriter.close();
                if ("utf-8".equalsIgnoreCase(str) && stringWriter2.startsWith(ResultParser.BYTE_ORDER_MARK)) {
                    return stringWriter2.substring(1);
                }
                return stringWriter2;
            }
            throw new IllegalArgumentException("stream may not be null.");
        }
        return (String) invokeLL.objValue;
    }
}
