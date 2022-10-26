package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;
/* loaded from: classes4.dex */
public class il4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(File file) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, file)) == null) {
            String canonicalPath = file.getCanonicalPath();
            if (!canonicalPath.endsWith("/")) {
                return canonicalPath + "/";
            }
            return canonicalPath;
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String guessContentTypeFromName = URLConnection.guessContentTypeFromName(str);
            if (guessContentTypeFromName == null) {
                return "text/plain";
            }
            return guessContentTypeFromName;
        }
        return (String) invokeL.objValue;
    }

    public static InputStream e(File file) throws FileNotFoundException, IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file)) == null) {
            return d(file.getPath(), new FileInputStream(file));
        }
        return (InputStream) invokeL.objValue;
    }

    public static File b(File file, String str) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, file, str)) == null) {
            String a = a(file);
            String canonicalPath = new File(file, str).getCanonicalPath();
            if (canonicalPath.startsWith(a)) {
                return new File(canonicalPath);
            }
            return null;
        }
        return (File) invokeLL.objValue;
    }

    public static InputStream d(String str, InputStream inputStream) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, inputStream)) == null) {
            if (str.endsWith(".svgz")) {
                return new GZIPInputStream(inputStream);
            }
            return inputStream;
        }
        return (InputStream) invokeLL.objValue;
    }
}
