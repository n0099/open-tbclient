package com.baidu.tieba;

import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.vdb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.download.exception.DownloadException;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
/* loaded from: classes5.dex */
public abstract class beb implements vdb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public final ydb b;
    public final geb c;
    public final vdb.a d;
    public volatile int e;
    public volatile int f;

    public abstract RandomAccessFile e(File file, String str, long j) throws IOException;

    public abstract Map<String, String> f(geb gebVar);

    public abstract int g();

    public abstract String h();

    public abstract void j(geb gebVar);

    public abstract void n(geb gebVar);

    public beb(ydb ydbVar, geb gebVar, vdb.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ydbVar, gebVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = 0;
        this.b = ydbVar;
        this.c = gebVar;
        this.d = aVar;
        String h = h();
        this.a = h;
        if (TextUtils.isEmpty(h)) {
            this.a = getClass().getSimpleName();
        }
    }

    public final void a() throws DownloadException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f != 107) {
                if (this.f != 106) {
                    return;
                }
                n(this.c);
                throw new DownloadException(106, "Download paused!");
            }
            throw new DownloadException(107, "Download canceled!");
        }
    }

    @Override // com.baidu.tieba.vdb
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f = 107;
        }
    }

    @Override // com.baidu.tieba.vdb
    public boolean isComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.e == 105) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.vdb
    public boolean isDownloading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.e == 104) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.vdb
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f = 106;
        }
    }

    public final void b(Closeable closeable) throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, closeable) == null) && closeable != null) {
            synchronized (beb.class) {
                closeable.close();
            }
        }
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b.a().getAbsolutePath() + File.separator + this.b.d();
        }
        return (String) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            Process.setThreadPriority(10);
            j(this.c);
            try {
                this.e = 104;
                d();
                synchronized (this.d) {
                    this.e = 105;
                    this.d.onDownloadCompleted(c());
                }
            } catch (DownloadException e) {
                i(e);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x005c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007a  */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, com.baidu.tieba.beb] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d() throws DownloadException {
        IOException e;
        ProtocolException e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                URL url = new URL(this.c.d());
                ?? r2 = 0;
                try {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        try {
                            httpURLConnection.setConnectTimeout(4000);
                            httpURLConnection.setReadTimeout(4000);
                            httpURLConnection.setRequestMethod("GET");
                            k(f(this.c), httpURLConnection);
                            int responseCode = httpURLConnection.getResponseCode();
                            if (responseCode == g()) {
                                m(httpURLConnection);
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                    return;
                                }
                                return;
                            }
                            throw new DownloadException(108, "UnSupported response code:" + responseCode);
                        } catch (ProtocolException e3) {
                            e2 = e3;
                            throw new DownloadException(108, "Protocol error", e2);
                        } catch (IOException e4) {
                            e = e4;
                            throw new DownloadException(108, "IO error", e);
                        }
                    } catch (Throwable th) {
                        th = th;
                        r2 = url;
                        if (r2 != 0) {
                            r2.disconnect();
                        }
                        throw th;
                    }
                } catch (ProtocolException e5) {
                    e2 = e5;
                } catch (IOException e6) {
                    e = e6;
                } catch (Throwable th2) {
                    th = th2;
                    if (r2 != 0) {
                    }
                    throw th;
                }
            } catch (MalformedURLException e7) {
                throw new DownloadException(108, "Bad url.", e7);
            }
        }
    }

    public final void i(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, downloadException) == null) {
            switch (downloadException.getErrorCode()) {
                case 106:
                    synchronized (this.d) {
                        this.e = 106;
                        this.d.onDownloadPaused();
                    }
                    return;
                case 107:
                    synchronized (this.d) {
                        this.e = 107;
                        this.d.onDownloadCanceled();
                    }
                    return;
                case 108:
                    synchronized (this.d) {
                        this.e = 108;
                        this.d.a(downloadException);
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Unknown state");
            }
        }
    }

    public final void k(Map<String, String> map, URLConnection uRLConnection) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, map, uRLConnection) == null) && map != null) {
            for (String str : map.keySet()) {
                uRLConnection.setRequestProperty(str, map.get(str));
            }
        }
    }

    public final void l(InputStream inputStream, RandomAccessFile randomAccessFile) throws DownloadException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, inputStream, randomAccessFile) == null) {
            byte[] bArr = new byte[8192];
            while (true) {
                a();
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        return;
                    }
                    randomAccessFile.write(bArr, 0, read);
                    long j = read;
                    this.c.e(this.c.b() + j);
                    synchronized (this.d) {
                        this.b.f(this.b.b() + j);
                        this.d.onDownloadProgress(this.b.b(), this.b.c());
                    }
                } catch (IOException e) {
                    n(this.c);
                    throw new DownloadException(108, e);
                }
            }
        }
    }

    public final void m(HttpURLConnection httpURLConnection) throws DownloadException {
        Closeable closeable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, httpURLConnection) == null) {
            Closeable closeable2 = null;
            try {
                try {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        long c = this.c.c() + this.c.b();
                        try {
                            File a = this.b.a();
                            if (!a.exists()) {
                                a.mkdirs();
                            }
                            RandomAccessFile e = e(a, this.b.d(), c);
                            l(inputStream, e);
                            try {
                                b(inputStream);
                                b(e);
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        } catch (IOException e3) {
                            throw new DownloadException(108, "File occur IOException ", e3);
                        } catch (Exception e4) {
                            throw new DownloadException(108, "Occur Exception ", e4);
                        }
                    } catch (Throwable th) {
                        th = th;
                        closeable2 = inputStream;
                        closeable = null;
                        try {
                            b(closeable2);
                            b(closeable);
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                        throw th;
                    }
                } catch (IOException e6) {
                    throw new DownloadException(108, "http get inputStream error", e6);
                }
            } catch (Throwable th2) {
                th = th2;
                closeable = null;
            }
        }
    }
}
