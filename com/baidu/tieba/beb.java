package com.baidu.tieba;

import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.vdb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.download.exception.DownloadException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
/* loaded from: classes5.dex */
public class beb implements vdb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final vdb.a b;
    public volatile int c;
    public volatile long d;

    public beb(String str, vdb.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = aVar;
    }

    public final void a() throws DownloadException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!isCanceled()) {
                if (!isPaused()) {
                    return;
                }
                throw new DownloadException(106, "Connection Paused!");
            }
            throw new DownloadException(107, "Connection Canceled!");
        }
    }

    @Override // com.baidu.tieba.vdb
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c = 107;
        }
    }

    @Override // com.baidu.tieba.vdb
    public boolean isCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.c == 107) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.vdb
    public boolean isPaused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.c == 106) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.vdb
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.c = 106;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Process.setThreadPriority(10);
            this.c = 102;
            this.b.onConnecting();
            try {
                b();
            } catch (DownloadException e) {
                c(e);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0064 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0082  */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b() throws DownloadException {
        IOException e;
        ProtocolException e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d = System.currentTimeMillis();
            try {
                URL url = new URL(this.a);
                ?? r2 = 0;
                try {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        try {
                            httpURLConnection.setConnectTimeout(4000);
                            httpURLConnection.setReadTimeout(4000);
                            httpURLConnection.setRequestMethod("GET");
                            httpURLConnection.setRequestProperty("Range", "bytes=0-");
                            int responseCode = httpURLConnection.getResponseCode();
                            if (responseCode == 200) {
                                d(httpURLConnection, false);
                            } else if (responseCode == 206) {
                                d(httpURLConnection, true);
                            } else {
                                throw new DownloadException(108, "UnSupported response code:" + responseCode);
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
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

    public final void c(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadException) == null) {
            switch (downloadException.getErrorCode()) {
                case 106:
                    synchronized (this.b) {
                        this.c = 106;
                        this.b.onConnectPaused();
                    }
                    return;
                case 107:
                    synchronized (this.b) {
                        this.c = 107;
                        this.b.onConnectCanceled();
                    }
                    return;
                case 108:
                    synchronized (this.b) {
                        this.c = 108;
                        this.b.b(downloadException);
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Unknown state");
            }
        }
    }

    public final void d(HttpURLConnection httpURLConnection, boolean z) throws DownloadException {
        long contentLength;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, httpURLConnection, z) == null) {
            String headerField = httpURLConnection.getHeaderField("Content-Length");
            if (!TextUtils.isEmpty(headerField) && !headerField.equals("0") && !headerField.equals("-1")) {
                contentLength = Long.parseLong(headerField);
            } else {
                contentLength = httpURLConnection.getContentLength();
            }
            if (contentLength <= 0) {
                String headerField2 = httpURLConnection.getHeaderField("Ohc-File-Size");
                if (!TextUtils.isEmpty(headerField2) && !headerField2.equals("0") && !headerField2.equals("-1")) {
                    contentLength = Long.parseLong(headerField2);
                } else {
                    contentLength = httpURLConnection.getContentLength();
                }
                if (contentLength <= 0) {
                    throw new DownloadException(108, "length <= 0");
                }
            }
            a();
            this.c = 103;
            this.b.onConnected(System.currentTimeMillis() - this.d, contentLength, z);
        }
    }
}
