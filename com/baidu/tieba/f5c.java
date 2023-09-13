package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.log.TLog;
/* loaded from: classes5.dex */
public class f5c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public int c;
    public long d;
    public long e;

    public f5c() {
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
        this.a = false;
        this.b = true;
        this.c = 0;
        this.d = 0L;
        this.e = 0L;
    }

    public synchronized boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                boolean z = false;
                if (this.c < 2) {
                    return false;
                }
                if (Math.abs(this.d - this.e) < 100) {
                    z = true;
                }
                return z;
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean c() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                z = this.a;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                TLog.g(this, "[surface] surfaceCreated");
                if (this.c > 0) {
                    this.e = this.d;
                }
                this.c++;
                this.d = System.currentTimeMillis();
                this.b = true;
                this.a = true;
            }
        }
    }

    public synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                TLog.g(this, "[surface] surfaceDestroy");
                this.b = true;
                this.a = false;
            }
        }
    }

    public synchronized boolean a(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            synchronized (this) {
                if (this.b == z) {
                    this.b = z2;
                    return true;
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public synchronized void d(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            synchronized (this) {
            }
        }
    }
}
