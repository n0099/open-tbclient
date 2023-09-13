package com.baidu.tieba;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes5.dex */
public class d7c {
    public static /* synthetic */ Interceptable $ic = null;
    public static int c = 1;
    public static final char[] d;
    public static d7c e;
    public transient /* synthetic */ FieldHolder $fh;
    public final HandlerThread a;
    public final Handler b;

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String[] a;
        public final /* synthetic */ d7c b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d7c d7cVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d7cVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = d7cVar;
            this.a = new String[]{"tinyvideoplayer", "lpfplayerfirstaccess", "lpfplayerdownload"};
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                Log.i("playStats", "handle msg " + message.what);
                int i = message.what;
                if (i < this.a.length && i >= 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (int i2 = 0; !this.b.h(this.a[message.what], (String) message.obj, currentTimeMillis, d7c.c) && i2 < 5; i2++) {
                    }
                    d7c.b();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947658905, "Lcom/baidu/tieba/d7c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947658905, "Lcom/baidu/tieba/d7c;");
                return;
            }
        }
        d = "0123456789abcdef".toCharArray();
        e = null;
    }

    public static /* synthetic */ int b() {
        int i = c;
        c = i + 1;
        return i;
    }

    public static d7c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            d7c d7cVar = e;
            if (d7cVar != null) {
                return d7cVar;
            }
            synchronized (d7c.class) {
                if (e == null) {
                    e = new d7c();
                }
            }
            return e;
        }
        return (d7c) invokeV.objValue;
    }

    public d7c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        HandlerThread handlerThread = new HandlerThread("yy-vod-stats-report");
        this.a = handlerThread;
        handlerThread.start();
        this.b = new a(this, this.a.getLooper());
    }

    public static String d(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) {
            char[] cArr = new char[bArr.length * 2];
            for (int i = 0; i < bArr.length; i++) {
                int i2 = bArr[i] & 255;
                int i3 = i * 2;
                char[] cArr2 = d;
                cArr[i3] = cArr2[i2 >>> 4];
                cArr[i3 + 1] = cArr2[i2 & 15];
            }
            return new String(cArr);
        }
        return (String) invokeL.objValue;
    }

    public static String g(String str) {
        MessageDigest messageDigest;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
                messageDigest = null;
            }
            if (messageDigest == null) {
                return "";
            }
            messageDigest.update(str.getBytes());
            return d(messageDigest.digest());
        }
        return (String) invokeL.objValue;
    }

    public static String e(String str, long j) {
        InterceptResult invokeLJ;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, str, j)) == null) {
            return ("&time=" + ("" + (j / 1000))) + "&key=" + g(str + str2 + "HiidoYYSystem");
        }
        return (String) invokeLJ.objValue;
    }

    public static void i(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65545, null, i, i2, str) == null) {
            Log.i("playStats", "tid:" + i + "type:" + i2 + ", stats:" + str);
            try {
                f().b.obtainMessage(i2, str).sendToTarget();
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final boolean h(String str, String str2, long j, int i) {
        InterceptResult invokeCommon;
        URL url;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Long.valueOf(j), Integer.valueOf(i)})) == null) {
            boolean z = false;
            if (str2 == null) {
                return false;
            }
            String str3 = "https://mlog.bigda.com/c.gif?act=" + str + e(str, j) + str2 + "&seq=" + i;
            HttpURLConnection httpURLConnection = null;
            try {
                url = new URL(str3);
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
                url = null;
            }
            if (url == null) {
                Log.e("playStats", "report url failed!");
                return false;
            }
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    if (Build.VERSION.SDK_INT < 21 && (httpURLConnection2 instanceof HttpsURLConnection)) {
                        ((HttpsURLConnection) httpURLConnection2).setSSLSocketFactory(new e7c());
                    }
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setReadTimeout(6000);
                    httpURLConnection2.connect();
                    int responseCode = httpURLConnection2.getResponseCode();
                    Log.i("playStats", "url : " + str3);
                    Log.i("playStats", "code : " + responseCode);
                    if (responseCode == 200) {
                        z = true;
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection = httpURLConnection2;
                    try {
                        th.printStackTrace();
                        Log.e("playStats", "open connection except!");
                        return z;
                    } finally {
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }
}
