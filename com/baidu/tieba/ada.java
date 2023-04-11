package com.baidu.tieba;

import android.os.Build;
import android.os.Environment;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes3.dex */
public final class ada {
    public static /* synthetic */ Interceptable $ic;
    public static String[] a;
    public static File b;
    public static RandomAccessFile c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947612715, "Lcom/baidu/tieba/ada;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947612715, "Lcom/baidu/tieba/ada;");
                return;
            }
        }
        a = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            File file = new File(str);
            b = file;
            if (file.exists()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            File file = new File(str);
            b = file;
            if (file.delete()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String externalStorageState = Environment.getExternalStorageState();
            if (Build.VERSION.SDK_INT >= 23) {
                if (uba.h().getContext().checkCallingOrSelfPermission(a[0]) != 0 || !externalStorageState.equals("mounted")) {
                    return false;
                }
                return true;
            }
            return externalStorageState.equals("mounted");
        }
        return invokeV.booleanValue;
    }

    public static synchronized boolean d(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3)) == null) {
            synchronized (ada.class) {
                if (!c() || !f(str2, str3)) {
                    return false;
                }
                try {
                    b = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(b, "rwd");
                    c = randomAccessFile;
                    randomAccessFile.seek(b.length());
                    c.write((str + "\r\n").getBytes("UTF-8"));
                    c.close();
                    return true;
                } catch (Exception e) {
                    dda.e(e);
                    return false;
                }
            }
        }
        return invokeLLL.booleanValue;
    }

    public static synchronized String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            synchronized (ada.class) {
                if (c()) {
                    if (a(str + str2)) {
                        try {
                            b = new File(str + str2);
                            c = new RandomAccessFile(b, "r");
                            StringBuffer stringBuffer = new StringBuffer();
                            while (true) {
                                String readLine = c.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), IMAudioTransRequest.CHARSET));
                                stringBuffer.append(",");
                            }
                            String stringBuffer2 = stringBuffer.toString();
                            try {
                                c.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            return stringBuffer2;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            try {
                                c.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                    return "";
                }
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean f(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) {
            try {
                b = new File(str);
                if (!a(str)) {
                    b.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                File file = new File(str + str2);
                b = file;
                if (file.exists()) {
                    return true;
                }
                return b.createNewFile();
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
