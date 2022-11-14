package com.baidu.tieba;

import android.os.Process;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.downloader.exception.DownloadException;
import com.baidu.swan.game.ad.downloader.exception.DownloadPauseException;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class ds3 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ks3 a;
    public final DownloadInfo b;
    public final a c;
    public long d;

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b();
    }

    public ds3(ks3 ks3Var, DownloadInfo downloadInfo, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ks3Var, downloadInfo, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ks3Var;
        this.b = downloadInfo;
        this.d = downloadInfo.getProgress();
        this.c = aVar;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.b.isPause()) {
            return;
        }
        throw new DownloadPauseException(7);
    }

    public final void b() {
        InputStream inputStream;
        RandomAccessFile randomAccessFile;
        Exception e;
        IOException e2;
        ProtocolException e3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            RandomAccessFile randomAccessFile2 = null;
            try {
                try {
                    try {
                        URL url = new URL(this.b.getUri());
                        long j = this.d;
                        Response execute = new OkHttpClient().newCall(new Request.Builder().addHeader("RANGE", "bytes=" + j + "-").url(url).build()).execute();
                        if (execute != null && execute.body() != null) {
                            inputStream = execute.body().byteStream();
                            try {
                                RandomAccessFile randomAccessFile3 = new RandomAccessFile(this.b.getPath(), "rw");
                                try {
                                    randomAccessFile3.seek(j);
                                    byte[] bArr = new byte[1024];
                                    int i = 0;
                                    while (true) {
                                        int read = inputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        a();
                                        i += read;
                                        randomAccessFile3.write(bArr, 0, read);
                                        this.b.setProgress(this.d + i);
                                        this.c.b();
                                    }
                                    execute.body().close();
                                    this.c.a();
                                    randomAccessFile2 = randomAccessFile3;
                                } catch (DownloadPauseException unused) {
                                    randomAccessFile2 = randomAccessFile3;
                                    if (randomAccessFile2 != null) {
                                        randomAccessFile2.close();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                        return;
                                    }
                                    return;
                                } catch (ProtocolException e4) {
                                    e3 = e4;
                                    throw new DownloadException(4, "Protocol error", e3);
                                } catch (IOException e5) {
                                    e2 = e5;
                                    throw new DownloadException(5, "IO error", e2);
                                } catch (Exception e6) {
                                    e = e6;
                                    throw new DownloadException(9, "other error", e);
                                }
                            } catch (DownloadPauseException unused2) {
                            } catch (ProtocolException e7) {
                                e = e7;
                                e3 = e;
                                throw new DownloadException(4, "Protocol error", e3);
                            } catch (IOException e8) {
                                e = e8;
                                e2 = e;
                                throw new DownloadException(5, "IO error", e2);
                            } catch (Exception e9) {
                                e = e9;
                                e = e;
                                throw new DownloadException(9, "other error", e);
                            } catch (Throwable th) {
                                th = th;
                                randomAccessFile = null;
                                th = th;
                                if (randomAccessFile != null) {
                                    try {
                                        randomAccessFile.close();
                                    } catch (Exception e10) {
                                        e10.printStackTrace();
                                        throw th;
                                    }
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                throw th;
                            }
                        } else {
                            inputStream = null;
                        }
                        if (randomAccessFile2 != null) {
                            randomAccessFile2.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                } catch (DownloadPauseException unused3) {
                    inputStream = null;
                } catch (ProtocolException e12) {
                    e = e12;
                } catch (IOException e13) {
                    e = e13;
                } catch (Exception e14) {
                    e = e14;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                    randomAccessFile = null;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public final long c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                Response execute = new OkHttpClient().newCall(new Request.Builder().url(str).build()).execute();
                if (execute != null && execute.isSuccessful() && execute.body() != null) {
                    long contentLength = execute.body().contentLength();
                    execute.body().close();
                    return contentLength;
                }
                return 0L;
            } catch (MalformedURLException e) {
                throw new DownloadException(2, "Bad url.", e);
            } catch (ProtocolException e2) {
                throw new DownloadException(4, "Protocol error", e2);
            } catch (IOException e3) {
                throw new DownloadException(5, "IO error", e3);
            } catch (Exception e4) {
                throw new DownloadException(9, "Unknown error", e4);
            }
        }
        return invokeL.longValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Process.setThreadPriority(10);
            try {
                if (this.b.getSize() <= 0) {
                    long c = c(this.b.getUri());
                    if (c > 0) {
                        this.b.setSize(c);
                    } else {
                        throw new DownloadException(6, "length <= 0");
                    }
                }
                this.b.setStatus(DownloadState.DOWNLOADING.value());
                this.a.b(this.b);
                b();
            } catch (DownloadException e) {
                this.b.setStatus(DownloadState.DOWNLOAD_FAILED.value());
                this.b.setException(e);
                this.a.b(this.b);
                this.a.a(e);
            }
        }
    }
}
