package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.common.ConcurrentLinkedQueueX;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.player.mediacodec.MediaSample;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes5.dex */
public final class dib {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dib c;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicLong a;
    public ConcurrentLinkedQueueX<MediaSample> b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947706924, "Lcom/baidu/tieba/dib;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947706924, "Lcom/baidu/tieba/dib;");
        }
    }

    public dib() {
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
        this.a = new AtomicLong(0L);
        this.b = new ConcurrentLinkedQueueX<>();
        c(512L);
    }

    public static dib f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (dib.class) {
                    if (c == null) {
                        c = new dib();
                    }
                }
            }
            return c;
        }
        return (dib) invokeV.objValue;
    }

    public MediaSample a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            MediaSample poll = this.b.poll();
            if (poll == null) {
                if (this.a.get() < 1024) {
                    c(1024 - this.a.get());
                    poll = this.b.poll();
                } else {
                    poll = MediaSample.a(this.a.getAndIncrement());
                }
            }
            poll.d();
            poll.a = str;
            return poll;
        }
        return (MediaSample) invokeL.objValue;
    }

    public MediaSample b(String str, ByteBuffer byteBuffer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, byteBuffer)) == null) {
            MediaSample a = a(str);
            a.i.k = byteBuffer;
            return a;
        }
        return (MediaSample) invokeLL.objValue;
    }

    public final void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            for (int i = 0; i < j; i++) {
                this.b.add(MediaSample.a(this.a.getAndIncrement()));
            }
            d();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int elementCount = this.b.getElementCount();
            int i = (int) this.a.get();
            TLog.g(this, String.format("MediaAllocator check capacity:%d, realCapacity:%d, sizeInQueue:%d, lostSize:%d", 1024L, Integer.valueOf(i), Integer.valueOf(elementCount), Integer.valueOf(i - elementCount)));
        }
    }

    public void e(MediaSample mediaSample) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mediaSample) == null) {
            mediaSample.d();
            if (this.b.size() <= 1536.0d) {
                if (!this.b.contains(mediaSample)) {
                    this.b.add(mediaSample);
                    return;
                }
                return;
            }
            this.a.decrementAndGet();
        }
    }
}
