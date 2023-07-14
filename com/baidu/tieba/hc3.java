package com.baidu.tieba;

import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/* loaded from: classes6.dex */
public class hc3 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947818865, "Lcom/baidu/tieba/hc3;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947818865, "Lcom/baidu/tieba/hc3;");
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppConfigData a;
        public final /* synthetic */ File b;

        public a(SwanAppConfigData swanAppConfigData, File file, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppConfigData, file, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppConfigData;
            this.b = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            FileOutputStream fileOutputStream;
            Throwable th;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a == null) {
                return;
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(this.b);
                try {
                    fileOutputStream.write(SwanAppConfigData.w.call2((jc3<SwanAppConfigData>) this.a));
                    zr4.d(fileOutputStream);
                } catch (Exception unused) {
                    fileOutputStream2 = fileOutputStream;
                    zr4.d(fileOutputStream2);
                } catch (Throwable th2) {
                    th = th2;
                    zr4.d(fileOutputStream);
                    throw th;
                }
            } catch (Exception unused2) {
            } catch (Throwable th3) {
                fileOutputStream = null;
                th = th3;
            }
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == -1) {
                cv2.g0().getSwitch("swan_app_json_serialize", 0);
                a = 0;
            }
            if (a != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static SwanAppConfigData b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return c(str, false);
        }
        return (SwanAppConfigData) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SwanAppConfigData c(String str, boolean z) {
        InterceptResult invokeLZ;
        FileInputStream fileInputStream;
        SwanAppConfigData call;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, str, z)) == null) {
            System.currentTimeMillis();
            File file = new File(str, "app.json");
            FileInputStream fileInputStream2 = null;
            if (!file.exists()) {
                return null;
            }
            String E = zr4.E(file);
            File file2 = new File(str, "app_json_serialize6.kv");
            if (a() && !z && file2.exists()) {
                try {
                    fileInputStream = new FileInputStream(file2);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    int available = fileInputStream.available();
                    byte[] bArr = new byte[available];
                    if (available == fileInputStream.read(bArr) && (call = SwanAppConfigData.x.call(bArr)) != null) {
                        call.n = E;
                        zr4.d(fileInputStream);
                        return call;
                    }
                    zr4.d(fileInputStream);
                } catch (Exception unused2) {
                    fileInputStream2 = fileInputStream;
                    zr4.d(fileInputStream2);
                    SwanAppConfigData c = SwanAppConfigData.c(E, file.getParentFile());
                    if (a()) {
                    }
                    return c;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    zr4.d(fileInputStream2);
                    throw th;
                }
            }
            SwanAppConfigData c2 = SwanAppConfigData.c(E, file.getParentFile());
            if (a()) {
                po3.k(new a(c2, file2, str), "SwanAppConfigDataReader");
            }
            return c2;
        }
        return (SwanAppConfigData) invokeLZ.objValue;
    }
}
