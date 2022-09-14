package com.baidu.tieba;

import android.content.Context;
import android.opengl.EGLContext;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mario.audio.AudioParams;
import com.baidu.mario.gldraw2d.params.MirrorType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.jvm.internal.ShortCompanionObject;
/* loaded from: classes3.dex */
public class ed0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String A = "ed0";
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public ad0 b;
    public int c;
    public boolean d;
    public long e;
    public long f;
    public long g;
    public boolean h;
    public gd0 i;
    public hd0 j;
    public nd0 k;
    public boolean l;
    public Context m;
    public int n;
    public fd0 o;
    public dd0 p;
    public lc0 q;
    public int r;
    public int s;
    public byte[] t;
    public ByteBuffer u;
    public Timer v;
    public TimerTask w;
    public boolean x;
    public boolean y;
    public long z;

    /* loaded from: classes3.dex */
    public class a implements hd0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ed0 a;

        public a(ed0 ed0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ed0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ed0Var;
        }

        @Override // com.baidu.tieba.hd0
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.a.g = j;
                if (j <= this.a.a || !this.a.l) {
                    return;
                }
                this.a.I();
            }
        }

        @Override // com.baidu.tieba.hd0
        public void onRecorderComplete(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                String str2 = ed0.A;
                Log.i(str2, "on RecorderComplete record time :" + this.a.g);
                if (this.a.o != null) {
                    this.a.o.w((int) this.a.g, str);
                }
            }
        }

        @Override // com.baidu.tieba.hd0
        public void onRecorderError(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                String str = ed0.A;
                Log.i(str, "onRecorderError:" + i);
                if (this.a.o != null) {
                    this.a.o.onError(i);
                }
            }
        }

        @Override // com.baidu.tieba.hd0
        public void onRecorderStart(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || this.a.o == null) {
                return;
            }
            this.a.o.onStart();
            this.a.x = true;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ed0 a;

        public b(ed0 ed0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ed0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ed0Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.x && !this.a.y) {
                    Log.i(ed0.A, "cancel audio time");
                    this.a.H();
                    this.a.y = false;
                    return;
                }
                ed0 ed0Var = this.a;
                ed0Var.K(ed0Var.u, 3840, System.nanoTime() - this.a.z);
                this.a.y = true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements lc0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<ed0> a;

        public c(ed0 ed0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ed0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(ed0Var);
            String str = ed0.A;
            Log.i(str, "gameRecorderRef is:" + this.a.get());
        }

        @Override // com.baidu.tieba.lc0
        public void a(boolean z, AudioParams audioParams) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZL(1048576, this, z, audioParams) == null) || this.a.get() == null) {
                return;
            }
            this.a.get().G(z, audioParams);
            Log.i(ed0.A, "onAudioStart");
        }

        @Override // com.baidu.tieba.lc0
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{byteBuffer, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.get() == null) {
                return;
            }
            this.a.get().y = false;
            this.a.get().K(byteBuffer, i, j);
        }

        @Override // com.baidu.tieba.lc0
        public void onAudioStop(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                Log.i(ed0.A, "onAudioStop");
                if (this.a.get() != null) {
                    this.a.get().H();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947730360, "Lcom/baidu/tieba/ed0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947730360, "Lcom/baidu/tieba/ed0;");
        }
    }

    public ed0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 120000;
        this.c = -1;
        this.d = false;
        this.h = false;
        this.r = 0;
        this.s = 0;
        this.t = ByteBuffer.allocate(3840).putShort(ShortCompanionObject.MIN_VALUE).array();
        this.u = ByteBuffer.allocate(3840).put(this.t);
        this.v = null;
        this.w = null;
        this.x = false;
        this.y = false;
        this.z = 0L;
        this.m = context;
        this.i = gd0.x();
        this.p = null;
        this.j = new a(this);
        D(new nd0(), this.j);
    }

    public void A(dd0 dd0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dd0Var) == null) {
            this.p = dd0Var;
        }
    }

    public void B(nd0 nd0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nd0Var) == null) {
            this.k = nd0Var;
        }
    }

    public void C(fd0 fd0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fd0Var) == null) {
            this.o = fd0Var;
        }
    }

    public void D(nd0 nd0Var, hd0 hd0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, nd0Var, hd0Var) == null) {
            B(nd0Var);
            this.j = hd0Var;
        }
    }

    public final void E(AudioParams audioParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, audioParams) == null) {
            if (this.q == null) {
                q();
            }
            if (audioParams == null) {
                Log.i(A, "audioParams is null,start to create AudioPams");
                new AudioParams();
            }
            if (this.p != null) {
                String str = A;
                Log.i(str, "set audio engie:" + this.p);
                this.p.a(this.q);
            }
        }
    }

    public void F(boolean z, int i, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str, Boolean.valueOf(z2)}) == null) || this.l) {
            return;
        }
        Log.i(A, "startRecored");
        this.z = System.nanoTime();
        this.k.u(str);
        this.k.s(z);
        int i2 = i * 1000;
        this.k.v(i2);
        this.k.x(this.r);
        this.k.w(this.s);
        this.e = 0L;
        this.g = 0L;
        if (i > 0 && i < 120) {
            this.a = i2;
        } else {
            this.a = 120000;
        }
        E(null);
    }

    public final void G(boolean z, AudioParams audioParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048582, this, z, audioParams) == null) {
            if (audioParams != null) {
                this.k.t(audioParams.getSampleRate());
                this.k.r(audioParams.getFrameSize());
                this.k.q(audioParams.getChannelConfig());
            }
            this.x = false;
            this.l = true;
            H();
            this.v = new Timer();
            b bVar = new b(this);
            this.w = bVar;
            this.v.schedule(bVar, 300L, 20L);
        }
    }

    public final synchronized void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                if (this.v != null) {
                    this.v.cancel();
                    this.v = null;
                    this.w = null;
                }
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Log.i(A, "stopRecored");
            r();
            this.l = false;
            this.x = false;
            this.y = false;
            int i = this.n;
            if (i != 0) {
                if (i != 1 && i != 2) {
                    throw new RuntimeException("unknown status " + this.n);
                }
                this.n = 0;
                gd0 gd0Var = this.i;
                if (gd0Var != null) {
                    gd0Var.U();
                }
            }
        }
    }

    public final void J(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            if (this.l && this.k != null) {
                int i2 = this.n;
                if (i2 == 0) {
                    p();
                    gd0 gd0Var = this.i;
                    if (gd0Var != null) {
                        gd0Var.S(this.m, this.k, this.j);
                    }
                    this.n = 1;
                } else if (i2 != 1) {
                    if (i2 == 2) {
                        this.b.j().f(i);
                        gd0 gd0Var2 = this.i;
                        if (gd0Var2 != null) {
                            gd0Var2.W(this.b);
                        }
                        this.n = 1;
                    } else {
                        throw new RuntimeException("unknown status " + this.n);
                    }
                }
            }
            gd0 gd0Var3 = this.i;
            if (gd0Var3 == null || this.d) {
                return;
            }
            gd0Var3.H(j - this.e);
        }
    }

    public final void K(ByteBuffer byteBuffer, int i, long j) {
        gd0 gd0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{byteBuffer, Integer.valueOf(i), Long.valueOf(j)}) == null) || (gd0Var = this.i) == null || !this.l || byteBuffer == null || i <= 0 || this.d) {
            return;
        }
        gd0Var.F(byteBuffer, i, j - this.e);
    }

    public final void p() {
        nd0 nd0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (nd0Var = this.k) == null || this.b == null) {
            return;
        }
        int l = nd0Var.l();
        int n = this.k.n();
        if (l >= 1920 || n >= 1920) {
            l = (int) ((l * 2) / 3.0f);
            n = (int) ((n * 2) / 3.0f);
        }
        if (l % 2 == 1) {
            l++;
        }
        if (n % 2 == 1) {
            n++;
        }
        String str = A;
        Log.i(str, "Record video width:" + n + " ;video height:" + l);
        this.k.x(n);
        this.k.w(l);
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.q == null) {
            this.q = new c(this);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.d) {
            this.e += System.nanoTime() - this.f;
            this.d = false;
        }
    }

    public long s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.g : invokeV.longValue;
    }

    public void t(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), eGLContext, Integer.valueOf(i), Integer.valueOf(i2), context}) == null) || eGLContext == null) {
            return;
        }
        this.m = context;
        String str = A;
        Log.i(str, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
        ad0 ad0Var = this.b;
        if (ad0Var == null) {
            this.b = new ad0(eGLContext, 0, true);
        } else {
            ad0Var.n(eGLContext);
        }
        this.b.i().e(i);
        this.b.i().d(i2);
        if (z) {
            this.b.c().j(MirrorType.VERTICALLY);
        }
        this.r = i;
        this.s = i2;
        this.k.x(i);
        this.k.w(i2);
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i) == null) || this.b == null) {
            return;
        }
        if (this.c != i) {
            xc0 xc0Var = new xc0();
            xc0Var.f(i);
            this.b.q(xc0Var);
            gd0 gd0Var = this.i;
            if (gd0Var != null) {
                gd0Var.s(this.b);
            }
            this.c = i;
        }
        J(this.c, System.nanoTime());
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.d) {
                Log.i(A, "pauseRecord cmd has executed, please run resumeRecord!");
            } else if (this.l) {
                this.d = true;
                Log.i(A, "pauseRecord");
                this.f = System.nanoTime();
                this.e = 0L;
                gd0 gd0Var = this.i;
                if (gd0Var != null) {
                    gd0Var.I();
                    long y = (this.f - (this.g * 1000000)) - this.i.y();
                    this.e = y;
                    if (y < 0) {
                        this.e = 0L;
                    }
                }
                fd0 fd0Var = this.o;
                if (fd0Var != null) {
                    fd0Var.onPause();
                }
                H();
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (!this.d) {
                this.h = true;
                v();
                return;
            }
            this.h = false;
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            gd0 gd0Var = this.i;
            if (gd0Var != null) {
                gd0Var.G();
                this.i = null;
            }
            if (this.j != null) {
                this.j = null;
            }
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && this.d) {
            this.e += System.nanoTime() - this.f;
            this.d = false;
            E(null);
            fd0 fd0Var = this.o;
            if (fd0Var != null) {
                fd0Var.onResume();
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.d && this.h) {
                y();
            }
            this.h = false;
        }
    }
}
