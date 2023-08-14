package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
/* loaded from: classes5.dex */
public class dqb {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "SecureX509SingleInstance";
    public static volatile eqb b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947714612, "Lcom/baidu/tieba/dqb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947714612, "Lcom/baidu/tieba/dqb;");
        }
    }

    public dqb() {
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

    @SuppressLint({"NewApi"})
    public static eqb a(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (context != null) {
                kqb.b(context);
                if (b == null) {
                    synchronized (dqb.class) {
                        if (b == null) {
                            InputStream n = iqb.n(context);
                            if (n == null) {
                                nqb.e(a, "get assets bks");
                                n = context.getAssets().open("hmsrootcas.bks");
                            } else {
                                nqb.e(a, "get files bks");
                            }
                            b = new eqb(n, "");
                            new lqb().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, context);
                        }
                    }
                }
                String str = a;
                nqb.b(str, "SecureX509TrustManager getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                return b;
            }
            throw new NullPointerException("context is null");
        }
        return (eqb) invokeL.objValue;
    }
}
