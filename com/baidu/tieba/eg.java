package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.network.http.BdHttpCancelException;
import com.baidu.adp.lib.network.http.IHttpNet;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* loaded from: classes3.dex */
public class eg {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ig a;
    public HttpURLConnection b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public boolean h;
    public boolean i;
    public int j;
    public TimerTask k;
    public TimerTask l;
    public Timer m;

    /* loaded from: classes3.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eg a;

        public a(eg egVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {egVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = egVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.b();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eg a;

        public b(eg egVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {egVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = egVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    dh.f(this.a.b);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements HostnameVerifier {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HttpsURLConnection a;

        public c(eg egVar, HttpsURLConnection httpsURLConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {egVar, httpsURLConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = httpsURLConnection;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, sSLSession)) == null) {
                String requestProperty = this.a.getRequestProperty("Host");
                if (requestProperty == null) {
                    requestProperty = this.a.getURL().getHost();
                }
                return HttpsURLConnection.getDefaultHostnameVerifier().verify(requestProperty, sSLSession);
            }
            return invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448303435, "Lcom/baidu/tieba/eg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448303435, "Lcom/baidu/tieba/eg;");
                return;
            }
        }
        System.setProperty("http.keepAlive", "false");
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ig igVar = this.a;
            if (igVar != null && igVar.c() != null) {
                this.a.c().a = true;
            }
            dh.f(this.b);
        }
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return invokeV.longValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return invokeV.longValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.d;
        }
        return invokeV.longValue;
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.f;
        }
        return invokeV.longValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.a.c().b != 200 && this.a.c().b != 206) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public eg(ig igVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {igVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.h = false;
        this.i = true;
        this.j = 0;
        this.k = new a(this);
        this.l = new b(this);
        this.m = new Timer();
        if (igVar != null) {
            this.a = igVar;
            return;
        }
        throw new NullPointerException("init HttpImpl's args context is null");
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.j = i;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.i = z;
        }
    }

    public final byte[] c(String str, byte[] bArr) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr)) == null) {
            if (str != null && str.toLowerCase().contains("gzip")) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                bj.c(byteArrayInputStream, byteArrayOutputStream);
                this.g = System.currentTimeMillis();
                return byteArrayOutputStream.toByteArray();
            }
            if (this.g == 0) {
                this.g = System.currentTimeMillis();
            }
            return bArr;
        }
        return (byte[]) invokeLL.objValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r15v1 */
    public boolean d(String str, mg mgVar, int i, int i2, boolean z, hg hgVar, boolean z2) throws Exception {
        InterceptResult invokeCommon;
        hg hgVar2;
        FileOutputStream fileOutputStream;
        String k;
        URL m;
        File i3;
        InputStream inputStream;
        InputStream inputStream2;
        boolean z3;
        URL url;
        int i4;
        int i5;
        boolean z4;
        String headerField;
        int indexOf;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, mgVar, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), hgVar, Boolean.valueOf(z2)})) == null) {
            if (hgVar == null) {
                hgVar2 = new hg();
            } else {
                hgVar2 = hgVar;
            }
            InputStream inputStream3 = null;
            try {
                k = this.a.b().k(true);
                hgVar2.s = k;
                m = m(k, false, hgVar2, null);
                this.b = g(m, i2, i);
            } catch (Throwable th) {
                th = th;
            }
            if (this.a.c().a) {
                this.f = System.currentTimeMillis();
                dh.c(null);
                dh.f(this.b);
                dh.d(null);
                return false;
            }
            if (z2) {
                try {
                    aj.k(str);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (z) {
                i3 = new File(str);
            } else {
                i3 = aj.i(str);
            }
            if (i3 != null) {
                try {
                    long length = i3.length();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(i3, true);
                    try {
                        this.a.b().t(this.b);
                        this.b.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                        this.b.connect();
                        if (this.c <= 0) {
                            try {
                                this.c = System.currentTimeMillis();
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream3 = null;
                                fileOutputStream = fileOutputStream2;
                            }
                        }
                        this.d = System.currentTimeMillis();
                        int responseCode = this.b.getResponseCode();
                        this.e = System.currentTimeMillis();
                        if (responseCode == 302) {
                            url = this.b.getURL();
                            if (url != null) {
                                hgVar2.r = url.toString();
                            }
                            if (url != null) {
                                i6 = responseCode;
                                if (!TextUtils.equals(url.getProtocol(), m.getProtocol())) {
                                    dh.f(this.b);
                                    this.b = g(new URL(url.toString()), i2, i);
                                    this.a.b().t(this.b);
                                    this.b.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                                    this.b.connect();
                                    responseCode = this.b.getResponseCode();
                                    z3 = true;
                                }
                            } else {
                                i6 = responseCode;
                            }
                            responseCode = i6;
                            z3 = false;
                        } else {
                            z3 = false;
                            url = null;
                        }
                        this.a.c().b = responseCode;
                        String headerField2 = this.b.getHeaderField("Content-Range");
                        if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                            i4 = eh.e(headerField2.substring(indexOf + 1), 0);
                        } else {
                            i4 = 0;
                        }
                        if (i4 == 0 && this.a.c().b == 200 && (headerField = this.b.getHeaderField("Content-Length")) != null) {
                            i4 = eh.e(headerField, 0);
                        }
                        this.a.c().f = String.valueOf(i4);
                        if (!n()) {
                            String str2 = "";
                            if (responseCode == 302) {
                                if (z3) {
                                    str2 = "isReConn ";
                                }
                                str2 = str2 + "url=" + m + "-newUrl=" + url;
                            } else if (responseCode == 416) {
                                if (i4 > 0 && i4 == length) {
                                    this.f = System.currentTimeMillis();
                                    dh.c(null);
                                    dh.f(this.b);
                                    dh.d(fileOutputStream2);
                                    return false;
                                }
                                str2 = "fileLen=" + length + "-contentLen=" + i4;
                            }
                            throw new UnsupportedOperationException(str2);
                        } else if (this.b.getContentType() != null && this.b.getContentType().contains("text/vnd.wap.wml")) {
                            this.b.disconnect();
                            this.a.c().b = 0;
                            boolean d = d(str, mgVar, i, i2, z, hgVar2, z2);
                            this.f = System.currentTimeMillis();
                            dh.c(null);
                            dh.f(this.b);
                            dh.d(fileOutputStream2);
                            return d;
                        } else {
                            hgVar2.a = k.getBytes().length;
                            long length2 = this.b.getHeaderFields().toString().getBytes().length;
                            hgVar2.b = length2;
                            long j = i4;
                            hgVar2.b = length2 + j;
                            if (i4 != 0 && length >= j) {
                                this.f = System.currentTimeMillis();
                                this.f = System.currentTimeMillis();
                                dh.c(null);
                                dh.f(this.b);
                                dh.d(fileOutputStream2);
                                return true;
                            }
                            inputStream2 = null;
                            try {
                                inputStream2 = this.b.getInputStream();
                                byte[] bArr = new byte[1024];
                                if (i4 > 0) {
                                    i5 = i4 / 50;
                                } else {
                                    i5 = 0;
                                }
                                if (mgVar != null && length > 0) {
                                    mgVar.onProgress((int) length, i4);
                                }
                                int i7 = 0;
                                loop0: while (true) {
                                    int i8 = 0;
                                    while (!this.a.c().a) {
                                        int read = inputStream2.read(bArr);
                                        if (read == -1) {
                                            break loop0;
                                        }
                                        try {
                                            fileOutputStream2.write(bArr, 0, read);
                                            i7 += read;
                                            int i9 = i8 + read;
                                            if (mgVar != null && (i9 > i5 || i7 == i4)) {
                                                long j2 = j;
                                                mgVar.onProgress((int) (i7 + length), i4);
                                                j = j2;
                                            } else {
                                                i8 = i9;
                                                j = j;
                                            }
                                        } catch (Exception unused) {
                                            throw new FileNotFoundException();
                                        }
                                    }
                                    break loop0;
                                }
                                long j3 = j;
                                try {
                                    fileOutputStream2.flush();
                                    long j4 = i7;
                                    hgVar2.w = j4;
                                    hgVar2.x = length;
                                    hgVar2.y = j3;
                                    if (j4 + length >= j3) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    this.f = System.currentTimeMillis();
                                    dh.c(inputStream2);
                                    dh.f(this.b);
                                    dh.d(fileOutputStream2);
                                    return z4;
                                } catch (Exception unused2) {
                                    throw new FileNotFoundException();
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream3 = inputStream2;
                                fileOutputStream = fileOutputStream2;
                                this.f = System.currentTimeMillis();
                                dh.c(inputStream3);
                                dh.f(this.b);
                                dh.d(fileOutputStream);
                                throw th;
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream2 = null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    inputStream = null;
                }
            } else {
                inputStream = null;
                try {
                    throw new FileNotFoundException();
                } catch (Throwable th7) {
                    th = th7;
                }
            }
            inputStream3 = inputStream;
            fileOutputStream = inputStream3;
            this.f = System.currentTimeMillis();
            dh.c(inputStream3);
            dh.f(this.b);
            dh.d(fileOutputStream);
            throw th;
        }
        return invokeCommon.booleanValue;
    }

    public final HttpURLConnection f(URL url) {
        InterceptResult invokeL;
        String curMobileProxyHost;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, url)) == null) {
            HttpsURLConnection httpsURLConnection = null;
            try {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    return null;
                }
                if (BdNetTypeUtil.isMobileNet() && (curMobileProxyHost = BdNetTypeUtil.curMobileProxyHost()) != null && curMobileProxyHost.length() > 0) {
                    if (BdNetTypeUtil.isWap(curMobileProxyHost) && BdNetTypeUtil.isSupportWap()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(curMobileProxyHost);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.a.b().a("X-Online-Host", url.getHost());
                        } catch (Exception e) {
                            e = e;
                            httpsURLConnection = httpURLConnection;
                            e.printStackTrace();
                            return httpsURLConnection;
                        }
                    } else {
                        httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(curMobileProxyHost, BdNetTypeUtil.curMobileProxyPort())));
                    }
                    httpsURLConnection = httpURLConnection;
                }
                if (httpsURLConnection == null) {
                    httpsURLConnection = (HttpURLConnection) url.openConnection();
                }
                if (this.h && url.getProtocol().equals("https")) {
                    HttpsURLConnection httpsURLConnection2 = httpsURLConnection;
                    httpsURLConnection2.setSSLSocketFactory(new ng(httpsURLConnection2));
                    httpsURLConnection2.setHostnameVerifier(new c(this, httpsURLConnection2));
                    return httpsURLConnection2;
                }
                return httpsURLConnection;
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            return (HttpURLConnection) invokeL.objValue;
        }
    }

    public final HttpURLConnection g(URL url, int i, int i2) throws SocketException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, url, i, i2)) == null) {
            HttpURLConnection f = f(url);
            if (f != null) {
                f.setConnectTimeout(i);
                f.setReadTimeout(i2);
                return f;
            }
            throw new SocketException();
        }
        return (HttpURLConnection) invokeLII.objValue;
    }

    public void k(boolean z, boolean z2, int i, int i2, hg hgVar, pg pgVar) throws Exception {
        IHttpNet ogVar;
        URL d;
        Map map;
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), hgVar, pgVar}) == null) {
            hgVar.j = -1;
            IHttpNet iHttpNet = null;
            try {
                if (!this.a.c().a) {
                    String f = this.a.b().f(z, hgVar);
                    hgVar.s = f;
                    URL m = m(f, z2, hgVar, pgVar);
                    if (!this.a.c().a) {
                        hgVar.j = -2;
                        if (((dg) ServiceManager.getService(dg.a)).netABTest()) {
                            ogVar = new gg(this.a, IHttpNet.HttpNetType.GET);
                        } else {
                            ogVar = new og(this.a, IHttpNet.HttpNetType.GET);
                        }
                        IHttpNet iHttpNet2 = ogVar;
                        iHttpNet2.e(m);
                        iHttpNet2.g(m, this.h);
                        hgVar.j = -3;
                        long currentTimeMillis = System.currentTimeMillis();
                        iHttpNet2.a(m, i2, i);
                        iHttpNet2.f();
                        if (!this.a.c().a) {
                            hgVar.g = new Date().getTime() - currentTimeMillis;
                            hgVar.j = -4;
                            iHttpNet2.connect();
                            if (this.c <= 0) {
                                this.c = System.currentTimeMillis();
                            }
                            this.d = System.currentTimeMillis();
                            hgVar.j = -5;
                            hgVar.c = (new Date().getTime() - currentTimeMillis) - hgVar.g;
                            if (!this.a.c().a) {
                                byte[] execute = iHttpNet2.execute();
                                this.a.c().a(iHttpNet2);
                                if (this.a.b().m() && this.m != null && this.j >= 0 && this.j < 3) {
                                    this.m.schedule(this.l, (this.j + 1) * 3000);
                                }
                                this.e = System.currentTimeMillis();
                                iHttpNet2.h();
                                hgVar.j = -8;
                                if (f.contains("tiebac.baidu.com") && (map = this.a.c().h) != null && !map.isEmpty() && (list = (List) map.get("Tracecode")) != null && list.size() > 1) {
                                    hgVar.t = (String) list.get(0);
                                    hgVar.u = (String) list.get(1);
                                }
                                if (this.a.c().b == 302 && (d = iHttpNet2.d()) != null) {
                                    hgVar.r = d.toString();
                                }
                                hgVar.i = this.a.c().b;
                                hgVar.b = iHttpNet2.b().toString().getBytes().length;
                                if (this.m != null) {
                                    this.m.cancel();
                                }
                                if (execute != null) {
                                    hgVar.b += execute.length;
                                    this.a.c().i = c(this.a.c().d, execute);
                                }
                                hgVar.j = -9;
                                hgVar.d = new Date().getTime() - currentTimeMillis;
                                Timer timer = this.m;
                                if (timer != null) {
                                    timer.cancel();
                                }
                                iHttpNet2.disconnect();
                                return;
                            }
                            throw new BdHttpCancelException();
                        }
                        throw new BdHttpCancelException();
                    }
                    throw new BdHttpCancelException();
                }
                throw new BdHttpCancelException();
            } catch (Throwable th) {
                Timer timer2 = this.m;
                if (timer2 != null) {
                    timer2.cancel();
                }
                if (0 != 0) {
                    iHttpNet.disconnect();
                }
                throw th;
            }
        }
    }

    public void o(boolean z, boolean z2, int i, int i2, hg hgVar, pg pgVar) throws Exception {
        IHttpNet ogVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), hgVar, pgVar}) == null) {
            hgVar.j = -1;
            IHttpNet iHttpNet = null;
            try {
                String k = this.a.b().k(z);
                hgVar.s = k;
                URL m = m(k, z2, hgVar, pgVar);
                if (!this.a.c().a) {
                    hgVar.j = -2;
                    if (((dg) ServiceManager.getService(dg.a)).netABTest()) {
                        ogVar = new gg(this.a, IHttpNet.HttpNetType.POST_BYTE);
                    } else {
                        ogVar = new og(this.a, IHttpNet.HttpNetType.POST_BYTE);
                    }
                    IHttpNet iHttpNet2 = ogVar;
                    iHttpNet2.e(m);
                    iHttpNet2.g(m, this.h);
                    hgVar.j = -3;
                    System.currentTimeMillis();
                    iHttpNet2.a(m, i2, i);
                    if (!this.a.c().a) {
                        iHttpNet2.f();
                        if (!this.a.c().a) {
                            long time = new Date().getTime();
                            hgVar.g = new Date().getTime() - time;
                            hgVar.j = -4;
                            iHttpNet2.connect();
                            if (this.c <= 0) {
                                this.c = System.currentTimeMillis();
                            }
                            this.d = System.currentTimeMillis();
                            hgVar.j = -5;
                            hgVar.c = (new Date().getTime() - time) - hgVar.g;
                            if (!this.a.c().a) {
                                if (this.m != null) {
                                    this.m.schedule(this.k, 45000L);
                                }
                                hgVar.j = -6;
                                iHttpNet2.c();
                                hgVar.j = -7;
                                byte[] execute = iHttpNet2.execute();
                                this.a.c().a(iHttpNet2);
                                iHttpNet2.h();
                                this.e = System.currentTimeMillis();
                                if (!this.a.c().a) {
                                    hgVar.j = -8;
                                    hgVar.i = this.a.c().b;
                                    long length = iHttpNet2.b().toString().getBytes().length;
                                    hgVar.b = length;
                                    if (execute != null) {
                                        hgVar.b = length + execute.length;
                                        this.a.c().j = execute.length;
                                        this.a.c().i = c(this.a.c().d, execute);
                                    }
                                    hgVar.d = new Date().getTime() - time;
                                    hgVar.j = -9;
                                    Timer timer = this.m;
                                    if (timer != null) {
                                        timer.cancel();
                                    }
                                    iHttpNet2.disconnect();
                                    return;
                                }
                                throw new BdHttpCancelException();
                            }
                            throw new BdHttpCancelException();
                        }
                        throw new BdHttpCancelException();
                    }
                    throw new BdHttpCancelException();
                }
                throw new BdHttpCancelException();
            } catch (Throwable th) {
                Timer timer2 = this.m;
                if (timer2 != null) {
                    timer2.cancel();
                }
                if (0 != 0) {
                    iHttpNet.disconnect();
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final URL m(String str, boolean z, hg hgVar, pg pgVar) throws Exception {
        InterceptResult invokeCommon;
        boolean z2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, Boolean.valueOf(z), hgVar, pgVar})) == null) {
            String str3 = "hiphotos.baidu.com";
            boolean netABTest = ((dg) ServiceManager.getService(dg.a)).netABTest();
            URL url = new URL(str);
            if (netABTest && url.getProtocol().equals("https")) {
                return url;
            }
            if (!TextUtils.isEmpty(str) && this.i) {
                try {
                    String host = url.getHost();
                    if (!TextUtils.isEmpty(host)) {
                        if (!host.contains("hiphotos.baidu.com")) {
                            str3 = host;
                        }
                        BDHttpDnsResult r = BDHttpDns.h(BdBaseApplication.getInst().getApplicationContext()).r(str3, true);
                        if (r != null) {
                            hgVar.m = r.d();
                            hgVar.o = r.c();
                            ArrayList b2 = r.b();
                            if (((cg) ServiceManager.getService(cg.a)).isIpv6() && z && b2 != null && b2.size() != 0) {
                                z2 = true;
                                if (b2 != null && b2.size() > 0) {
                                    hgVar.p = b2.toString();
                                    int size = this.j % b2.size();
                                    str2 = (String) b2.get(size);
                                    if (!TextUtils.isEmpty(str2)) {
                                        if (z2) {
                                            str2 = PreferencesUtil.LEFT_MOUNT + str2 + PreferencesUtil.RIGHT_MOUNT;
                                            if (pgVar != null) {
                                                pgVar.e = true;
                                            }
                                        }
                                        if (!str2.startsWith("10.") || !url.getProtocol().equals("https")) {
                                            this.a.b().a("Host", str3);
                                            URL url2 = new URL(str.replaceFirst("://(.*)" + str3, "://" + str2));
                                            try {
                                                this.h = true;
                                                hgVar.q = size;
                                                hgVar.l = str2;
                                                hgVar.n = true;
                                                return url2;
                                            } catch (Exception e) {
                                                e = e;
                                                url = url2;
                                                BdLog.e(e);
                                                return url;
                                            }
                                        }
                                    }
                                }
                            }
                            z2 = false;
                            b2 = r.a();
                            if (b2 != null) {
                                hgVar.p = b2.toString();
                                int size2 = this.j % b2.size();
                                str2 = (String) b2.get(size2);
                                if (!TextUtils.isEmpty(str2)) {
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
            return url;
        }
        return (URL) invokeCommon.objValue;
    }

    public void p(boolean z, boolean z2, int i, int i2, hg hgVar, pg pgVar) throws Exception {
        IHttpNet ogVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), hgVar, pgVar}) == null) {
            hgVar.j = -1;
            IHttpNet iHttpNet = null;
            try {
                String k = this.a.b().k(z);
                hgVar.s = k;
                URL m = m(k, z2, hgVar, pgVar);
                if (!this.a.c().a) {
                    hgVar.j = -2;
                    if (((dg) ServiceManager.getService(dg.a)).netABTest()) {
                        ogVar = new gg(this.a, IHttpNet.HttpNetType.POST_FORM);
                    } else {
                        ogVar = new og(this.a, IHttpNet.HttpNetType.POST_FORM);
                    }
                    IHttpNet iHttpNet2 = ogVar;
                    iHttpNet2.e(m);
                    iHttpNet2.g(m, this.h);
                    iHttpNet2.a(m, i2, i);
                    hgVar.j = -3;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!this.a.c().a) {
                        iHttpNet2.f();
                        if (!this.a.c().a) {
                            hgVar.g = System.currentTimeMillis() - currentTimeMillis;
                            hgVar.j = -4;
                            iHttpNet2.connect();
                            if (this.c <= 0) {
                                this.c = System.currentTimeMillis();
                            }
                            this.d = System.currentTimeMillis();
                            hgVar.j = -5;
                            hgVar.c = (System.currentTimeMillis() - currentTimeMillis) - hgVar.g;
                            if (!this.a.c().a) {
                                hgVar.j = -6;
                                hgVar.a = iHttpNet2.c();
                                hgVar.j = -7;
                                if (!this.a.c().a) {
                                    iHttpNet2.h();
                                    this.e = System.currentTimeMillis();
                                    hgVar.j = -8;
                                    byte[] execute = iHttpNet2.execute();
                                    this.f = System.currentTimeMillis();
                                    this.a.c().a(iHttpNet2);
                                    hgVar.i = this.a.c().b;
                                    long length = this.a.c().h.toString().getBytes().length;
                                    hgVar.b = length;
                                    if (execute != null) {
                                        hgVar.b = length + execute.length;
                                        this.a.c().j = execute.length;
                                        this.a.c().i = c(this.a.c().d, execute);
                                    }
                                    hgVar.d = new Date().getTime() - currentTimeMillis;
                                    hgVar.j = -9;
                                    iHttpNet2.disconnect();
                                    return;
                                }
                                throw new BdHttpCancelException();
                            }
                            throw new BdHttpCancelException();
                        }
                        throw new BdHttpCancelException();
                    }
                    throw new BdHttpCancelException();
                }
                throw new BdHttpCancelException();
            } catch (Throwable th) {
                if (0 != 0) {
                    iHttpNet.disconnect();
                }
                throw th;
            }
        }
    }
}
