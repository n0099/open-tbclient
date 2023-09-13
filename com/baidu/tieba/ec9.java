package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.BdCloseHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class ec9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65536, null, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        FileHelper.deleteFileOrDir(new File(gc9.e + gc9.a + str));
    }

    public static void c(String str, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, str, jSONArray) == null) && !StringUtils.isNull(str) && jSONArray != null) {
            try {
                JSONArray jSONArray2 = new JSONArray(str);
                for (int i = 0; i < jSONArray2.length(); i++) {
                    jSONArray.put(jSONArray2.optJSONObject(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static JSONArray d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (StringUtils.isNull(str)) {
                return jSONArray;
            }
            File file = new File(str);
            if (!file.exists()) {
                return jSONArray;
            }
            String e = e(file);
            String[] split = e.split("\n");
            if (split.length > 0) {
                for (String str2 : split) {
                    c(str2, jSONArray);
                }
            } else {
                c(e, jSONArray);
            }
            FileHelper.deleteFile(file);
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public static String e(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file)) == null) {
            StringBuilder sb = new StringBuilder();
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read));
                }
                BdCloseHelper.close((InputStream) fileInputStream);
            } catch (Exception e2) {
                e = e2;
                fileInputStream2 = fileInputStream;
                e.printStackTrace();
                BdCloseHelper.close((InputStream) fileInputStream2);
                return sb.toString();
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                BdCloseHelper.close((InputStream) fileInputStream2);
                throw th;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, file, str)) == null) {
            return g(file, str, true);
        }
        return invokeLL.booleanValue;
    }

    public static boolean g(File file, String str, boolean z) {
        InterceptResult invokeLLZ;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65542, null, file, str, z)) == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    fileOutputStream = new FileOutputStream(file, z);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(str.getBytes());
                fileOutputStream.flush();
                BdCloseHelper.close((OutputStream) fileOutputStream);
                return true;
            } catch (Exception e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                BdCloseHelper.close((OutputStream) fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                BdCloseHelper.close((OutputStream) fileOutputStream2);
                throw th;
            }
        }
        return invokeLLZ.booleanValue;
    }
}
