package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.ConnectManager;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class bm4<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final xo4 f;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public wl4 b;
    public xl4<T> c;
    public AtomicBoolean d;
    public T e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947649760, "Lcom/baidu/tieba/bm4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947649760, "Lcom/baidu/tieba/bm4;");
                return;
            }
        }
        f = xo4.e();
    }

    public bm4(xl4<T> xl4Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xl4Var, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = xl4Var;
        this.b = xl4Var.a;
        this.a = i;
        this.e = xl4Var.b;
        this.d = xl4Var.d;
    }

    public final boolean a(InputStream inputStream, OutputStream outputStream, long j) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{inputStream, outputStream, Long.valueOf(j)})) == null) {
            int i = 32768;
            byte[] bArr = new byte[32768];
            long j2 = 0;
            int i2 = 0;
            while (!this.d.get() && i2 != -1) {
                if (j > 0) {
                    if (j2 >= j) {
                        break;
                    } else if (i + j2 > j) {
                        i = (int) (j - j2);
                    }
                }
                i2 = inputStream.read(bArr, 0, i);
                if (i2 > 0) {
                    outputStream.write(bArr, 0, i2);
                    j2 += i2;
                    this.b.b.b = j2;
                    this.c.l();
                }
            }
            gj4.b().y("PMSTaskProcessor", "#copyStream canceled=" + this.d.get() + " readed" + j2 + " totalBytes=" + j);
            if (j2 != j) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void b() {
        rl4 rl4Var;
        Exception e;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.d.get()) {
            return;
        }
        rl4 rl4Var2 = null;
        if (!ConnectManager.isNetworkConnected(AppRuntime.getAppContext())) {
            f.g("PMSTaskProcessor", "#downloadLogic 没有网络连接", null);
            this.b.a = new pk4(ErrorConstant.Code.DOWNLOAD_ERROR_MISS_PARAM, "download : no network");
            this.b.a.a("没有网络连接");
        } else if (!this.c.c()) {
            f.g("PMSTaskProcessor", "#downloadLogic 无法创建本地文件", null);
            this.b.a = new pk4(ErrorConstant.Code.DOWNLOAD_ERROR_PATH, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_CREATEFILE);
        } else {
            this.c.p();
            try {
                try {
                    rl4Var = gj4.b().A().c(this.b.b.n, this.a);
                    try {
                        int code = rl4Var.code();
                        int d = d(rl4Var, code);
                        if (this.b.a.a != d) {
                            this.b.a = new pk4(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                            this.b.a.a("状态不匹配错误，可能有未捕获的异常");
                            f.g("PMSTaskProcessor", "#downloadLogic 状态不匹配错误 errorCode=" + d + " errNo=" + this.b.a.a + " httpStatus=" + code, null);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        f.g("PMSTaskProcessor", "#downloadLogic 包下载异常", e);
                        this.b.a = new pk4(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                        this.b.a.a(Log.getStackTraceString(e));
                        zr4.d(rl4Var);
                    }
                } catch (Throwable th) {
                    th = th;
                    rl4Var2 = rl4Var;
                    zr4.d(rl4Var2);
                    throw th;
                }
            } catch (Exception e3) {
                rl4Var = null;
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                zr4.d(rl4Var2);
                throw th;
            }
            zr4.d(rl4Var);
        }
    }

    public final boolean c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!new File(str).exists()) {
                this.b.a = new pk4(ErrorConstant.Code.DOWNLOAD_ERROR_WRITE, String.format(ErrorConstant.ErrorMsg.DOWNLOAD_FILE_INEXIST, bp4.a("local file save failed:", str)));
                return false;
            }
            String str2 = this.b.b.l;
            String b = zo4.b(new File(str), true);
            if (str2 != null && b != null) {
                String upperCase = str2.toUpperCase();
                if (upperCase.equals(b)) {
                    return true;
                }
                this.b.a = new pk4(2202, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5 + bp4.a("server:", upperCase, ",local", b));
                return false;
            }
            this.b.a = new pk4(ErrorConstant.Code.DOWNLOAD_ERROR_WRITE, String.format(ErrorConstant.ErrorMsg.DOWNLOAD_FILE_INEXIST, bp4.a("server:", str2, ",local", b)));
            return false;
        }
        return invokeL.booleanValue;
    }

    public final int d(rl4 rl4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, rl4Var, i)) == null) {
            gj4.b().y("PMSTaskProcessor", "#parseResponse url=" + this.b.b.n + " code=" + rl4Var.code());
            this.b.a = null;
            if (i >= 200 && i <= 300) {
                ql4 body = rl4Var.body();
                if (body != null) {
                    long b = body.b();
                    f.g("PMSTaskProcessor", "#parseResponse currentSize=" + this.b.b.b + " pkgSize=" + this.b.b.k + " contentLength=" + b, null);
                    if (!this.c.j(this.b.b.k)) {
                        f.g("PMSTaskProcessor", "#parseResponse 磁盘空间不足", null);
                        this.b.a = new pk4(ErrorConstant.Code.DOWNLOAD_ERROR_CREATEFILE, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NOSPACE);
                        return this.b.a.a;
                    }
                    try {
                        if (e(body, b)) {
                            this.b.a = new pk4(2200, ErrorConstant.ErrorMsg.DOWNLOAD_SUCCESS);
                            return this.b.a.a;
                        }
                    } catch (IOException e) {
                        f.g("PMSTaskProcessor", "#parseResponse 写到文件过程中出错", e);
                        this.b.a = new pk4(ErrorConstant.Code.DOWNLOAD_ERROR_NOSPACE, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_WRITE);
                        return this.b.a.a;
                    }
                }
                wl4 wl4Var = this.b;
                if (wl4Var.a == null) {
                    wl4Var.a = new pk4(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                    this.b.a.a("错误码为空时设置的默认错误");
                }
                return this.b.a.a;
            }
            String str = "statusCode=" + i;
            f.g("PMSTaskProcessor", "#parseResponse error " + str, null);
            wl4 wl4Var2 = this.b;
            pk4 pk4Var = new pk4(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION);
            pk4Var.a(str);
            wl4Var2.a = pk4Var;
            return this.b.a.a;
        }
        return invokeLI.intValue;
    }

    public final boolean e(ql4 ql4Var, long j) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, ql4Var, j)) == null) {
            xl4<T> xl4Var = this.c;
            ul4<T> ul4Var = xl4Var.e;
            ReadableByteChannel readableByteChannel = null;
            try {
                T t = this.e;
                File file = xl4Var.c;
                ReadableByteChannel a = ql4Var.a();
                try {
                    pk4 h = ul4Var.h(t, file, j, a);
                    if (h.a == 2302) {
                        if (f(Channels.newInputStream(a), new FileOutputStream(this.c.c), j) && c(this.b.b.a)) {
                            if (a != null && a.isOpen()) {
                                zr4.d(a);
                            }
                            return true;
                        }
                        if (a != null && a.isOpen()) {
                            zr4.d(a);
                        }
                        return false;
                    } else if (h.a == 2300) {
                        this.b.b.b = j;
                        this.c.l();
                        if (a != null && a.isOpen()) {
                            zr4.d(a);
                        }
                        return true;
                    } else {
                        this.b.a = h;
                        if (a != null && a.isOpen()) {
                            zr4.d(a);
                        }
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    readableByteChannel = a;
                    if (readableByteChannel != null && readableByteChannel.isOpen()) {
                        zr4.d(readableByteChannel);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return invokeLJ.booleanValue;
        }
    }

    public final boolean f(InputStream inputStream, OutputStream outputStream, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{inputStream, outputStream, Long.valueOf(j)})) == null) {
            try {
                try {
                    return a(inputStream, outputStream, j);
                } catch (IOException e) {
                    gj4.b().G("PMSTaskProcessor", "#safeCopyStream 写入输出流出错", e);
                    zr4.d(inputStream);
                    zr4.d(outputStream);
                    return false;
                }
            } finally {
                zr4.d(inputStream);
                zr4.d(outputStream);
            }
        }
        return invokeCommon.booleanValue;
    }
}
