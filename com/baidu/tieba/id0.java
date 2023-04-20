package com.baidu.tieba;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class id0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String d = "id0";
    public transient /* synthetic */ FieldHolder $fh;
    public MediaMuxer a;
    public volatile boolean b;
    public jd0 c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947849524, "Lcom/baidu/tieba/id0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947849524, "Lcom/baidu/tieba/id0;");
        }
    }

    public id0() {
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
        this.b = false;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !this.b) {
            this.a.release();
            this.a = null;
        }
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                boolean z = true;
                try {
                    this.a.start();
                    this.b = true;
                } catch (Exception unused) {
                    Log.e(d, "startMuxer error!!!");
                    z = false;
                }
                if (this.c != null) {
                    this.c.a(z);
                }
            }
        }
    }

    public synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                boolean z = false;
                try {
                    this.a.stop();
                    this.b = false;
                    z = true;
                } catch (Exception unused) {
                    Log.e(d, "stopMuxer error!!!");
                }
                if (this.c != null) {
                    this.c.b(z);
                }
            }
        }
    }

    public synchronized int a(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mediaFormat)) == null) {
            synchronized (this) {
                try {
                    int addTrack = this.a.addTrack(mediaFormat);
                    if (addTrack >= 0) {
                        return addTrack;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Log.e(d, "addMuxerTrack error!!!");
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public boolean b(String str, int i, jd0 jd0Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i, jd0Var)) == null) {
            if (!ld0.a(str)) {
                ld0.b(str);
            }
            try {
                this.a = new MediaMuxer(str, i);
                this.c = jd0Var;
                this.b = false;
                return true;
            } catch (Exception e) {
                Log.e(d, "initMovieMuxer init error!!!");
                e.printStackTrace();
                return false;
            }
        }
        return invokeLIL.booleanValue;
    }

    public boolean g(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, byteBuffer, bufferInfo)) == null) {
            if (i != -1) {
                try {
                    this.a.writeSampleData(i, byteBuffer, bufferInfo);
                    return true;
                } catch (Exception unused) {
                    Log.e(d, "startMuxer error!!!");
                    return false;
                }
            }
            return false;
        }
        return invokeILL.booleanValue;
    }
}
