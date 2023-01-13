package com.baidu.tieba;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.zxing.client.result.ResultParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class hm9 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947828661, "Lcom/baidu/tieba/hm9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947828661, "Lcom/baidu/tieba/hm9;");
                return;
            }
        }
        a = cl9.m();
    }

    public static byte[] a(InputStream inputStream) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, inputStream)) == null) {
            if (inputStream == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    i = inputStream.read(bArr, 0, 1024);
                } catch (IOException e) {
                    if (a) {
                        Log.e("StringUtil", e.toString());
                    }
                    i = 0;
                }
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e2) {
                if (a) {
                    Log.e("StringUtil", e2.toString());
                }
            }
            return byteArray;
        }
        return (byte[]) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, IF, SGET, MOVE_EXCEPTION, INVOKE, INVOKE, INVOKE, IF, SGET, MOVE_EXCEPTION] complete} */
    public static String b(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, inputStream)) == null) {
            try {
                try {
                    byte[] a2 = a(inputStream);
                    if (a2 != null) {
                        String str = new String(a2);
                        if (str.startsWith(ResultParser.BYTE_ORDER_MARK)) {
                            str = str.substring(1);
                        }
                        return str;
                    } else if (inputStream != null) {
                        try {
                            inputStream.close();
                            return null;
                        } catch (Exception e) {
                            e = e;
                            if (!a) {
                                return null;
                            }
                            Log.e("StringUtil", e.toString());
                            return null;
                        }
                    } else {
                        return null;
                    }
                } finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e2) {
                            if (a) {
                                Log.e("StringUtil", e2.toString());
                            }
                        }
                    }
                }
            } catch (Exception e3) {
                if (a) {
                    Log.e("StringUtil", " getStringFromInput exception: ", e3);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return null;
                    } catch (Exception e4) {
                        e = e4;
                        if (!a) {
                            return null;
                        }
                        Log.e("StringUtil", e.toString());
                        return null;
                    }
                }
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
