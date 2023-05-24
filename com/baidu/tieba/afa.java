package com.baidu.tieba;

import android.os.RemoteException;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.TurbonetEngine;
import java.net.BindException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
/* loaded from: classes4.dex */
public class afa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public int c;
    public int d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;

    public afa(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = -14;
        this.d = -1;
        this.e = -1L;
        this.f = -1L;
        this.g = -1L;
        this.h = -1L;
        this.i = -1L;
        this.a = str;
        this.g = System.nanoTime() / 1000;
        this.f = System.currentTimeMillis();
    }

    public void a(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            if (exc instanceof SocketTimeoutException) {
                this.c = -1;
            } else if (exc instanceof UnknownHostException) {
                this.c = -2;
            } else if (exc instanceof ConnectException) {
                this.c = -5;
            } else if (exc instanceof ProtocolException) {
                this.c = -3;
            } else if (exc instanceof BindException) {
                this.c = -4;
            } else if (exc instanceof SSLHandshakeException) {
                this.c = -8;
            } else if (exc instanceof SSLProtocolException) {
                this.c = -9;
            } else if (exc instanceof RemoteException) {
                this.c = -13;
            } else if (exc instanceof NoRouteToHostException) {
                this.c = -6;
            } else if (exc instanceof PortUnreachableException) {
                this.c = -7;
            } else if (exc instanceof SSLKeyException) {
                this.c = -10;
            } else if (exc instanceof SSLPeerUnverifiedException) {
                this.c = -11;
            } else {
                this.c = -14;
            }
        }
    }

    public void d(TurbonetEngine turbonetEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, turbonetEngine) == null) {
            Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.a, this.b, Integer.valueOf(this.c), Integer.valueOf(this.d), Long.valueOf(this.e), Long.valueOf(this.f), Long.valueOf(this.h), Long.valueOf(this.i)));
            turbonetEngine.g(this.a, this.b, this.c, this.d, this.e, this.f, this.h, this.i);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.h = (System.nanoTime() / 1000) - this.g;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.i = (System.nanoTime() / 1000) - this.g;
        }
    }
}
