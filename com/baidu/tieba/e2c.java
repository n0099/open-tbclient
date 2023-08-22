package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.system.Os;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.log.TLog;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes5.dex */
public class e2c {
    public static /* synthetic */ Interceptable $ic;
    public static HandlerThread a;
    public static Handler b;
    public static Thread c;
    public static ConcurrentHashMap<String, String> d;
    public static WeakReference<Context> e;
    public static final String[] f;
    public static LinkedList<u1c> g;
    public static final char[] h;
    public static String i;
    public static String j;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u1c a;

        public a(u1c u1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u1cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u1cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Log.i("TransvodSoLoader", "on download success");
                u1c u1cVar = this.a;
                if (u1cVar != null) {
                    u1cVar.onLibDownloadSuccess();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u1c a;

        public b(u1c u1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u1cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u1cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Log.i("TransvodSoLoader", "on download in progress");
                u1c u1cVar = this.a;
                if (u1cVar != null) {
                    u1cVar.onLibDownloading();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u1c a;

        public c(u1c u1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u1cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u1cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Log.i("TransvodSoLoader", "on download success");
                u1c u1cVar = this.a;
                if (u1cVar != null) {
                    u1cVar.onLibDownloadSuccess();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final f b;
        public final /* synthetic */ File c;
        public final /* synthetic */ String d;
        public final /* synthetic */ u1c e;
        public final /* synthetic */ File f;

        public d(File file, String str, u1c u1cVar, File file2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, str, u1cVar, file2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = file;
            this.d = str;
            this.e = u1cVar;
            this.f = file2;
            this.a = true;
            this.b = new f(null);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x008f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a(String str) {
            URL url;
            HttpURLConnection httpURLConnection;
            int i;
            int contentLength;
            BufferedInputStream bufferedInputStream;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a = true;
                HttpURLConnection httpURLConnection2 = null;
                try {
                    url = new URL(str);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    url = null;
                }
                int i2 = 0;
                if (url == null) {
                    Log.e("TransvodSoLoader", "url error " + str);
                    this.a = false;
                    return;
                }
                Log.i("TransvodSoLoader", "open connection to " + url);
                try {
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    try {
                        if (Build.VERSION.SDK_INT < 21 && (httpURLConnection instanceof HttpsURLConnection)) {
                            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new z3c());
                        }
                        httpURLConnection.setConnectTimeout(10000);
                        httpURLConnection.setReadTimeout(6000);
                        httpURLConnection.connect();
                        i = httpURLConnection.getResponseCode();
                    } catch (Throwable th) {
                        th = th;
                        httpURLConnection2 = httpURLConnection;
                        th.printStackTrace();
                        Log.e("TransvodSoLoader", "open connection except!");
                        httpURLConnection = httpURLConnection2;
                        i = 0;
                        if (httpURLConnection != null) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                if (httpURLConnection != null) {
                    Log.e("TransvodSoLoader", "open connection failed!");
                    this.a = false;
                    return;
                }
                StringBuilder sb = new StringBuilder();
                f fVar = this.b;
                sb.append(fVar.f);
                sb.append("-");
                sb.append(i);
                fVar.f = sb.toString();
                try {
                    contentLength = httpURLConnection.getContentLength();
                    Log.i("TransvodSoLoader", "total length " + contentLength);
                } finally {
                    try {
                    } finally {
                    }
                }
                if (contentLength < 0) {
                    this.a = false;
                    return;
                }
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
                FileOutputStream fileOutputStream = new FileOutputStream(new File(this.c, e2c.u(str, this.d)));
                byte[] bArr = new byte[1024];
                Log.i("TransvodSoLoader", "download " + e2c.u(str, this.d) + " start");
                long nanoTime = System.nanoTime();
                long j = nanoTime;
                int i3 = 0;
                while (true) {
                    int read = bufferedInputStream2.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, i2, read);
                    i3 += read;
                    long nanoTime2 = System.nanoTime();
                    if (nanoTime2 - j > 1000000000) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("download progress ");
                        sb2.append(i3);
                        sb2.append("/");
                        sb2.append(contentLength);
                        sb2.append(" speed ");
                        bufferedInputStream = bufferedInputStream2;
                        sb2.append((i3 * 1000000000) / (nanoTime2 - nanoTime));
                        sb2.append(" bytes/sec");
                        Log.i("TransvodSoLoader", sb2.toString());
                        j = nanoTime2;
                    } else {
                        bufferedInputStream = bufferedInputStream2;
                    }
                    bufferedInputStream2 = bufferedInputStream;
                    i2 = 0;
                }
                fileOutputStream.close();
                Log.i("TransvodSoLoader", "download " + e2c.u(str, this.d) + " end");
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            synchronized (e2c.g) {
                e2c.g.clear();
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                for (int i = 0; !e2c.D(this.b) && i < 3; i++) {
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (e2c.e != null) {
                    e2c.z((Context) e2c.e.get());
                }
                synchronized (e2c.g) {
                    Iterator it = e2c.g.iterator();
                    while (it.hasNext()) {
                        u1c u1cVar = (u1c) it.next();
                        if (u1cVar != null) {
                            u1cVar.onLibDownloadSuccess();
                        }
                    }
                    e2c.g.clear();
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x00c5  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00ce  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                Thread.currentThread().setName("yrtcSoDownload");
                this.b.a = this.d;
                long currentTimeMillis = System.currentTimeMillis();
                String[] A = e2c.A(this.d);
                u1c u1cVar = this.e;
                if (u1cVar != null) {
                    u1cVar.onLibDownloading();
                }
                int length = A.length;
                boolean z2 = false;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str = A[i];
                    int i2 = 0;
                    while (true) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        a(str);
                        long currentTimeMillis3 = System.currentTimeMillis();
                        if (str.endsWith(".zip") && this.a) {
                            this.b.d = currentTimeMillis3 - currentTimeMillis2;
                        }
                        if (this.a) {
                            break;
                        }
                        int i3 = i2 + 1;
                        if (i2 >= 5) {
                            i2 = i3;
                            break;
                        }
                        i2 = i3;
                    }
                    if (!this.a && str.endsWith(".zip")) {
                        this.b.g = -1;
                        break;
                    }
                    this.b.b += i2;
                    i++;
                }
                long currentTimeMillis4 = System.currentTimeMillis();
                this.b.c = currentTimeMillis4 - currentTimeMillis;
                boolean C = e2c.C(this.c, this.d);
                if (!this.a || !C) {
                    z = false;
                } else {
                    z = e2c.y(this.c, this.d);
                    if (z) {
                        e2c.H(this.c, this.f, this.d);
                        z2 = e2c.l(this.f);
                        this.b.e = System.currentTimeMillis() - currentTimeMillis4;
                        if (z2) {
                            c();
                        } else {
                            e2c.q(this.f);
                            b();
                        }
                        if (this.a) {
                            f fVar = this.b;
                            if (fVar.g != -1) {
                                fVar.g = -2;
                            }
                        } else if (!C) {
                            this.b.g = -2;
                        } else if (!z) {
                            this.b.g = -3;
                        } else if (!z2) {
                            this.b.g = -4;
                        }
                        d();
                        Thread unused = e2c.c = null;
                    }
                }
                if (this.e != null) {
                    b();
                }
                if (this.a) {
                }
                d();
                Thread unused2 = e2c.c = null;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements FilenameFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
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

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, str)) == null) {
                return str.contains("transvod");
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;
        public long c;
        public long d;
        public long e;
        public String f;
        public int g;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = "";
        }

        public /* synthetic */ f(a aVar) {
            this();
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "&abi=" + this.a + "&retry=" + this.b + "&dotm=" + this.c + "&succm=" + this.d + "&unzip=" + this.e + "&err=" + this.f + "&res=" + this.g;
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947683891, "Lcom/baidu/tieba/e2c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947683891, "Lcom/baidu/tieba/e2c;");
                return;
            }
        }
        d = new ConcurrentHashMap<>();
        e = null;
        f = new String[]{"libc++_shared.so", "libssl.1.1.1j.so", "libcrypto.1.1.1j.so", "libcyber-ffmpeg.so", "libtransvod.so"};
        g = new LinkedList<>();
        h = "0123456789abcdef".toCharArray();
        i = null;
        j = null;
    }

    public static String[] A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("https://thunder-sofiles.myzhiniu.com/a_transvod/transvod-12.1.0.34-");
            if (str == null) {
                str = s();
            }
            sb.append(str);
            String sb2 = sb.toString();
            return new String[]{sb2 + ".zip", sb2 + ".sha1"};
        }
        return (String[]) invokeL.objValue;
    }

    public static String E(File file) {
        MessageDigest messageDigest;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, file)) == null) {
            try {
                messageDigest = MessageDigest.getInstance("SHA-1");
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
                messageDigest = null;
            }
            if (messageDigest == null) {
                return "";
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read > 0) {
                        messageDigest.update(bArr, 0, read);
                    } else {
                        fileInputStream.close();
                        return k(messageDigest.digest());
                    }
                }
            } catch (IOException e3) {
                e3.printStackTrace();
                return "";
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    public static void q(File file) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, file) == null) {
            File file2 = new File(file, "transvod");
            if (!file2.exists() || (listFiles = file2.listFiles(new e())) == null) {
                return;
            }
            for (File file3 : listFiles) {
                Log.i("TransvodSoLoader", "delete " + file3.getAbsolutePath() + " ret:" + file3.delete());
            }
        }
    }

    public static boolean x(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            File file = new File(context.getFilesDir(), "transvod");
            if (!file.exists()) {
                return false;
            }
            String u = u("*.sha1", s());
            if (!new File(file, "libtransvod.so").exists() || !new File(file, u).exists()) {
                return false;
            }
            c0c.c(context);
            return c0c.a();
        }
        return invokeL.booleanValue;
    }

    public static String B(String str) {
        MessageDigest messageDigest;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
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
            return k(messageDigest.digest());
        }
        return (String) invokeL.objValue;
    }

    public static String k(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, bArr)) == null) {
            char[] cArr = new char[bArr.length * 2];
            for (int i2 = 0; i2 < bArr.length; i2++) {
                int i3 = bArr[i2] & 255;
                int i4 = i2 * 2;
                char[] cArr2 = h;
                cArr[i4] = cArr2[i3 >>> 4];
                cArr[i4 + 1] = cArr2[i3 & 15];
            }
            return new String(cArr);
        }
        return (String) invokeL.objValue;
    }

    public static boolean l(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, file)) == null) {
            File file2 = new File(file, "transvod");
            if (!file2.exists()) {
                return false;
            }
            File file3 = new File(file2, "libtransvod.so");
            if (!file3.exists()) {
                return false;
            }
            return E(file3).equals(j);
        }
        return invokeL.booleanValue;
    }

    public static String v(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            File file = new File(context.getFilesDir(), "transvod");
            if (!file.exists()) {
                return null;
            }
            File file2 = new File(file, "libtransvod.so");
            if (!file2.exists()) {
                return null;
            }
            return file2.getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public static synchronized boolean C(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, file, str)) == null) {
            synchronized (e2c.class) {
                File file2 = new File(file, u("*.sha1", str));
                boolean z = false;
                if (!file2.exists()) {
                    return false;
                }
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                    i = bufferedReader.readLine();
                    j = bufferedReader.readLine();
                    Log.i("TransvodSoLoader", "soload sha1 zip " + i);
                    Log.i("TransvodSoLoader", "soload sha1 so " + j);
                    bufferedReader.close();
                    z = true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return z;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean F(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            if (str == null) {
                str = s();
            }
            File filesDir = context.getFilesDir();
            File file = new File(filesDir, "transvod");
            if (!file.exists()) {
                return false;
            }
            String[] strArr = {"libtransvod.so"};
            for (int i2 = 0; i2 < 1; i2++) {
                if (!new File(file, strArr[i2]).exists()) {
                    return false;
                }
            }
            if (!new File(file, u("*.sha1", str)).exists()) {
                return false;
            }
            if (!C(file, str)) {
                Log.i("TransvodSoLoader", "so sha1 read false " + filesDir.getAbsolutePath());
                return false;
            }
            boolean l = l(filesDir);
            Log.i("TransvodSoLoader", "so sha1 check ret " + l);
            return l;
        }
        return invokeLL.booleanValue;
    }

    public static boolean D(f fVar) {
        InterceptResult invokeL;
        URL url;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fVar)) == null) {
            boolean z = false;
            if (fVar == null) {
                return false;
            }
            String str = "http://mlog.bigda.com/c.gif?act=sodownload" + t() + fVar.toString() + "&mod=1";
            HttpURLConnection httpURLConnection = null;
            try {
                url = new URL(str);
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
                url = null;
            }
            if (url == null) {
                Log.e("TransvodSoLoader", "report url failed!");
                return false;
            }
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setReadTimeout(6000);
                    httpURLConnection2.connect();
                    int responseCode = httpURLConnection2.getResponseCode();
                    Log.i("TransvodSoLoader", "url : " + str);
                    Log.i("TransvodSoLoader", "code : " + responseCode);
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
                        Log.e("TransvodSoLoader", "open connection except!");
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
        return invokeL.booleanValue;
    }

    public static void G(String str, String str2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) {
            try {
                File file = new File(str2);
                if (!file.isDirectory()) {
                    file.mkdirs();
                }
                ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
                while (true) {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        String name = nextEntry.getName();
                        if (!name.contains("../")) {
                            String str3 = str2 + File.separator + name;
                            if (nextEntry.isDirectory()) {
                                File file2 = new File(str3);
                                if (!file2.isDirectory()) {
                                    file2.mkdirs();
                                }
                            } else {
                                FileOutputStream fileOutputStream = new FileOutputStream(str3, false);
                                byte[] bArr = new byte[4096];
                                while (true) {
                                    int read = zipInputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                zipInputStream.closeEntry();
                                fileOutputStream.close();
                            }
                        }
                    } else {
                        zipInputStream.close();
                        return;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                Log.e("TransvodSoLoader", "Unzip exception", e2);
            }
        }
    }

    public static boolean H(File file, File file2, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, file, file2, str)) == null) {
            File file3 = new File(file, u("*.zip", str));
            if (!file3.exists()) {
                return false;
            }
            String u = u("*.sha1", str);
            File file4 = new File(file, u);
            if (!file4.exists()) {
                return false;
            }
            File file5 = new File(file2, "transvod");
            if (file5.exists()) {
                File[] listFiles = file5.listFiles();
                if (listFiles != null) {
                    for (File file6 : listFiles) {
                        if (!file6.delete()) {
                            Log.e("TransvodSoLoader", "delete file failed " + file6.getAbsolutePath());
                        }
                    }
                }
            } else if (!file5.mkdir()) {
                Log.e("TransvodSoLoader", "mkdir failed " + file5.getAbsolutePath());
            }
            try {
                if (!file5.exists()) {
                    Log.e("TransvodSoLoader", "mkdir so so files failed");
                    return false;
                }
                try {
                    G(file3.getAbsolutePath(), file5.getAbsolutePath());
                    o(file4, new File(file5, u));
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return false;
            } finally {
                m(file);
            }
        }
        return invokeLLL.booleanValue;
    }

    public static boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                return Process.is64Bit();
            }
            if (i2 < 21) {
                return false;
            }
            String[] strArr = Build.SUPPORTED_64_BIT_ABIS;
            if (strArr.length <= 0) {
                return false;
            }
            return Build.CPU_ABI.equals(strArr[0]);
        }
        return invokeV.booleanValue;
    }

    public static void m(File file) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65557, null, file) == null) && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.getName().startsWith("transvod-") && (file2.getName().endsWith(".zip") || file2.getName().endsWith(".sha1"))) {
                    if (!file2.delete()) {
                        Log.e("TransvodSoLoader", "delete file failed " + file2.getAbsolutePath());
                    } else {
                        Log.i("TransvodSoLoader", "delete file ok " + file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public static boolean n(File file, File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, file, file2)) == null) {
            boolean z = false;
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    Os.symlink(file.getAbsolutePath(), file2.getAbsolutePath());
                    TLog.b("TransvodSoLoader", " sys link success");
                    z = true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    TLog.m("TransvodSoLoader", " sym link error ---------- ");
                }
            }
            if (z) {
                return true;
            }
            TLog.b("TransvodSoLoader", " begin to copy file " + file.getPath());
            return o(file, file2);
        }
        return invokeLL.booleanValue;
    }

    public static String u(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, str, str2)) == null) {
            if (str.endsWith(".zip")) {
                return "transvod-12.1.0.34-" + str2 + ".zip";
            } else if (str.endsWith(".sha1")) {
                return "transvod-12.1.0.34-" + str2 + ".sha1";
            } else {
                throw new RuntimeException("impossible code reached!");
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean y(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65569, null, file, str)) == null) {
            File file2 = new File(file, u("*.zip", str));
            if (!file2.exists()) {
                return false;
            }
            if (E(file2).equals(i)) {
                return true;
            }
            Log.i("TransvodSoLoader", "sha1 calc failed for " + file2.getAbsolutePath());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean o(File file, File file2) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, file, file2)) == null) {
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    fileOutputStream2 = new FileOutputStream(file2);
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read < 0) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        }
                        fileOutputStream2.flush();
                        try {
                            fileInputStream2.close();
                            fileOutputStream2.close();
                        } catch (IOException e2) {
                            TLog.m("TransvodSoLoader", " " + e2.getMessage());
                        }
                        return true;
                    } catch (FileNotFoundException unused) {
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                TLog.m("TransvodSoLoader", " " + e3.getMessage());
                                return false;
                            }
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        return false;
                    } catch (IOException unused2) {
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                                TLog.m("TransvodSoLoader", " " + e4.getMessage());
                                return false;
                            }
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        return false;
                    } catch (Throwable th) {
                        fileInputStream = fileInputStream2;
                        fileOutputStream = fileOutputStream2;
                        th = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e5) {
                                TLog.m("TransvodSoLoader", " " + e5.getMessage());
                                throw th;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (FileNotFoundException unused3) {
                    fileOutputStream2 = null;
                } catch (IOException unused4) {
                    fileOutputStream2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    fileInputStream = fileInputStream2;
                }
            } catch (FileNotFoundException unused5) {
                fileOutputStream2 = null;
            } catch (IOException unused6) {
                fileOutputStream2 = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } else {
            return invokeLL.booleanValue;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void p(File file, String str, Context context, String str2) {
        File file2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65560, null, file, str, context, str2) == null) {
            File file3 = new File(str2);
            boolean z = true;
            if (file.exists() && file.length() > 0) {
                boolean z2 = false;
                try {
                    if (file.getCanonicalFile().equals(file.getAbsoluteFile())) {
                        if (file.length() != file3.length()) {
                            try {
                                TLog.h("TransvodSoLoader", " destSoFile " + str + " length = " + file.length());
                                TLog.h("TransvodSoLoader", " srcSoFile " + str + " length = " + file3.length());
                                z2 = true;
                            } catch (IOException e2) {
                                e = e2;
                                e.printStackTrace();
                                if (z) {
                                }
                            }
                        }
                    }
                    try {
                        if (!file.getCanonicalFile().equals(file3.getAbsoluteFile())) {
                            TLog.h("TransvodSoLoader", " destSoFile getCanonicalFile " + file.getCanonicalFile());
                            TLog.h("TransvodSoLoader", " srcSoFile getAbsoluteFile " + file3.getAbsoluteFile());
                        } else {
                            z = z2;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        z = z2;
                        e.printStackTrace();
                        if (z) {
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    z = false;
                }
            }
            if (z) {
                TLog.h("TransvodSoLoader", " copy host " + str + " start");
                try {
                    file.delete();
                } catch (Exception e5) {
                    e5.printStackTrace();
                    TLog.m("TransvodSoLoader", " delete old " + str + " soft link fail");
                }
                if (!TextUtils.isEmpty(str2)) {
                    file2 = new File(str2);
                } else {
                    file2 = new File(context.getApplicationInfo().nativeLibraryDir, str);
                }
                n(file2, file);
                TLog.h("TransvodSoLoader", " copy " + str + " end, length = " + file.length() + " src path= " + file2.getAbsolutePath());
            }
        }
    }

    public static synchronized boolean r(Context context, String str, u1c u1cVar, List<String> list) {
        InterceptResult invokeLLLL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65562, null, context, str, u1cVar, list)) == null) {
            synchronized (e2c.class) {
                if (a == null) {
                    HandlerThread handlerThread = new HandlerThread("yvodSoLoadState");
                    a = handlerThread;
                    handlerThread.start();
                    b = new Handler(a.getLooper());
                }
                if ("armeabi".equals(str)) {
                    str = PassBiometricUtil.CPU_TYPE_ARMEABI_V7A;
                }
                e = new WeakReference<>(context);
                for (int i2 = 0; i2 < f.length - 1; i2++) {
                    File file = new File(context.getApplicationInfo().nativeLibraryDir, f[i2]);
                    if (file.exists() && file.isFile()) {
                        d.put(f[i2], file.getAbsolutePath());
                    }
                }
                if (list != null && list.size() > 0) {
                    for (String str2 : list) {
                        for (String str3 : f) {
                            if (!TextUtils.isEmpty(str2) && str2.contains(str3)) {
                                File file2 = new File(str2);
                                if (file2.exists() && file2.isFile()) {
                                    d.put(str3, str2);
                                }
                            }
                        }
                    }
                }
                if (F(context, str)) {
                    z(context);
                    if (u1cVar != null) {
                        b.post(new a(u1cVar));
                    }
                    return true;
                }
                synchronized (g) {
                    g.add(u1cVar);
                }
                if (c != null) {
                    if (u1cVar != null) {
                        b.post(new b(u1cVar));
                    }
                    return false;
                } else if (F(context, str)) {
                    if (u1cVar != null) {
                        z(context);
                        b.post(new c(u1cVar));
                    }
                    return true;
                } else {
                    File cacheDir = context.getCacheDir();
                    File filesDir = context.getFilesDir();
                    filesDir.getAbsolutePath();
                    if (str == null) {
                        str = s();
                    }
                    Thread thread = new Thread(new d(cacheDir, str, u1cVar, filesDir));
                    c = thread;
                    thread.start();
                    return false;
                }
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static String s() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                str = Build.SUPPORTED_ABIS[0];
            } else {
                str = Build.CPU_ABI;
            }
            if (str.contains("arm")) {
                if (w()) {
                    return "arm64-v8a";
                }
                return PassBiometricUtil.CPU_TYPE_ARMEABI_V7A;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            String str = "" + (System.currentTimeMillis() / 1000);
            return (((((("&time=" + str) + "&key=" + B("sodownload" + str + "HiidoYYSystem")) + "&ts=" + str) + "&ph=" + URLEncoder.encode(Build.BRAND + "-" + Build.DEVICE + "-" + Build.PRODUCT)) + "&os=" + Build.VERSION.SDK_INT) + "&ver=12.1.0.34") + "&mod=1";
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public static boolean z(Context context) {
        InterceptResult invokeL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) {
            File file = new File(context.getFilesDir(), "transvod");
            if (!file.exists() || !new File(file, "libtransvod.so").exists()) {
                return false;
            }
            for (String str : d.keySet()) {
                p(new File(file, str), str, context, d.get(str));
            }
            boolean z = false;
            for (String str2 : f) {
                File file2 = new File(file, str2);
                if (!file2.exists()) {
                    Log.w("TransvodSoLoader", " loadLibrary: " + file2.getAbsolutePath() + " not found!");
                } else {
                    Log.i("TransvodSoLoader", " loadLibrary: start load " + file2.getAbsolutePath());
                    try {
                        TLog.h("TransvodSoLoader", " loadLibrary: " + str2);
                        System.load(file2.getAbsolutePath());
                        z = true;
                    } catch (Throwable th) {
                        TLog.d("TransvodSoLoader", " load transvod failed, UnsatisfiedLinkError " + th.getMessage());
                        z = false;
                    }
                    TLog.d("TransvodSoLoader", " loadLibrary: load finish " + file2.getAbsolutePath() + " res " + z);
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
