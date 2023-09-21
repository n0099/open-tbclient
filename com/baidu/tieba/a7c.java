package com.baidu.tieba;

import android.content.Context;
import android.media.AudioManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.core.TransVodProxy;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.player.mediacodec.MediaSample;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes5.dex */
public final class a7c {
    public static /* synthetic */ Interceptable $ic;
    public static long o;
    public static int p;
    public transient /* synthetic */ FieldHolder $fh;
    public TransVodProxy a;
    public AudioManager b;
    public boolean c;
    public ArrayList<MediaSample> d;
    public boolean e;
    public boolean f;
    public long g;
    public long h;
    public long i;
    public long j;
    public int k;
    public long l;
    public AtomicLong m;
    public AtomicLong n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947569532, "Lcom/baidu/tieba/a7c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947569532, "Lcom/baidu/tieba/a7c;");
        }
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public a7c(TransVodProxy transVodProxy, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {transVodProxy, context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = false;
        this.d = new ArrayList<>();
        this.e = false;
        this.f = false;
        this.g = 0L;
        this.h = 0L;
        this.i = 0L;
        this.j = 0L;
        this.k = 0;
        this.l = 50L;
        this.m = new AtomicLong(0L);
        this.n = new AtomicLong(0L);
        this.a = transVodProxy;
        long b = b();
        this.l = b;
        if (b == 0) {
            this.l = i6c.a();
            TLog.l(this, "jitter set avdelta " + this.l);
        }
        TLog.l(this, "jitter avdelta " + this.l);
        this.b = (AudioManager) context.getSystemService("audio");
    }

    public static void c(MediaSample mediaSample, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, mediaSample, i) == null) {
            d(mediaSample, i, b5c.a() - o);
        }
    }

    public static void d(MediaSample mediaSample, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{mediaSample, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            switch (i) {
                case 0:
                    mediaSample.r = (int) j;
                    return;
                case 1:
                    mediaSample.j = j;
                    return;
                case 2:
                    mediaSample.k = j;
                    return;
                case 3:
                    mediaSample.l = j;
                    return;
                case 4:
                    mediaSample.v = j;
                    return;
                case 5:
                    mediaSample.x = j;
                    return;
                case 6:
                    mediaSample.w = j;
                    return;
                case 7:
                default:
                    return;
                case 8:
                    mediaSample.y = j;
                    return;
                case 9:
                    mediaSample.A = j;
                    return;
                case 10:
                    mediaSample.z = j;
                    return;
                case 11:
                    mediaSample.B = j;
                    return;
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                for (int i = 0; i < this.d.size(); i++) {
                    h6c.f().e(this.d.get(i));
                }
                this.d.clear();
            }
        }
    }

    public void e(MediaSample mediaSample) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaSample) == null) {
            synchronized (this) {
                this.k++;
                if (mediaSample.c) {
                    this.n.set(mediaSample.z - mediaSample.l);
                    if (mediaSample.l <= this.g) {
                        TLog.h("[avsync]", "^^^^^^^^^^^^^^^^^^^^[avsync] audio pts error lastAduioPts=" + this.g + " sample.Pts=" + mediaSample.l);
                    } else if (this.k % 50 == 0) {
                        TLog.h("[avsync]", "audio pts: " + mediaSample.l + " audio delta: " + this.n.get());
                    }
                    this.f = true;
                    this.h = mediaSample.z;
                    this.g = mediaSample.l;
                } else {
                    this.m.set(mediaSample.z - mediaSample.l);
                    this.e = true;
                    if (mediaSample.l + 150 <= this.i) {
                        TLog.h("[avsync]", "^^^^^^^^^^^^^^^^^^^^[avsync] video pts error lastVideo=" + this.i + " sample.Pts=" + mediaSample.l);
                    } else if (this.k % 50 == 0) {
                        TLog.h("[avsync]", "video pts: " + mediaSample.l + " video delta: " + this.m.get());
                    }
                    this.i = mediaSample.l;
                    this.j = mediaSample.z;
                }
                int i2 = 30;
                if (w6c.w() < 12) {
                    i2 = 60;
                    i = -90;
                } else {
                    i = 0;
                }
                if (this.k > i2) {
                    if (this.e && this.f) {
                        long j = (this.n.get() + this.l) - this.m.get();
                        if (Math.abs(this.j - this.h) > 500 || Math.abs(this.g - this.i) > 1000) {
                            TLog.h("[avsync]", "[avsync] detla: " + j + " arender: " + this.h + "vrender: " + this.j + " apts: " + this.g + " vpts: " + this.i + " renderDiff:" + (this.h - this.j) + " ptsDiff:" + (this.g - this.i));
                        }
                        TLog.h("[avsync]", "updateAVDelta, audio delta: " + this.n.get() + " mDelta:" + this.l + " video delta: " + this.m.get() + " extraDelta " + ((this.n.get() + this.l) - this.m.get()) + " xDelta " + i);
                        this.a.w(this.n.get() + this.l + ((long) i), this.m.get());
                    }
                    this.k = 0;
                    this.e = false;
                    this.f = false;
                }
                g();
                MediaSample a = h6c.f().a(null);
                a.b(mediaSample);
                a.F = this.c;
                this.d.add(a);
                if (mediaSample.e || this.d.size() > 200 || mediaSample.N > 0 || mediaSample.O) {
                    this.a.m((MediaSample[]) this.d.toArray(new MediaSample[this.d.size()]));
                    a();
                }
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                a();
                this.e = false;
                this.f = false;
                this.g = 0L;
                this.i = 0L;
                this.h = 0L;
                this.j = 0L;
            }
        }
    }

    public final void g() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i2 = p + 1;
            p = i2;
            if (i2 > 1000) {
                try {
                    i = this.b.getStreamVolume(3);
                } catch (Exception unused) {
                    TLog.l(this, "getStreamVolume Exception");
                    i = 0;
                }
                String str = YYOption.IsLive.VALUE_TRUE;
                if (i == 0) {
                    this.c = true;
                    StringBuilder sb = new StringBuilder();
                    sb.append("audio playback is mute ");
                    if (!this.c) {
                        str = "false";
                    }
                    sb.append(str);
                    TLog.l(this, sb.toString());
                } else {
                    this.c = false;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("audio playback is mute ");
                    if (!this.c) {
                        str = "false";
                    }
                    sb2.append(str);
                    TLog.l(this, sb2.toString());
                }
                p = 0;
            }
        }
    }
}
